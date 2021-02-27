package com.andatra.loftmoney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BudgetFragment extends Fragment {

    public static final int REQUEST_CODE = 100;
    private static final String COLOR_ID = "colorId";
    private static final String TYPE = "fragmentType";

    private ItemsAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    private Api mApi;

    public static BudgetFragment newInstance(final int colorId, final String type) {
        BudgetFragment budgetFragment = new BudgetFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(COLOR_ID, colorId);
        bundle.putString(TYPE, type);
        budgetFragment.setArguments(bundle);
        return budgetFragment;
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApi = ((LoftApp)getActivity().getApplication()).getApi();
        loadItems();
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_budget, null);

        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                loadItems();
            }
        });

        mAdapter = new ItemsAdapter(getArguments().getInt(COLOR_ID));
        recyclerView.setAdapter(mAdapter);



        return view;
    }

    @Override
    public void onActivityResult(
            final int requestCode, final int resultCode, @Nullable final Intent data
    ) {
        super.onActivityResult(requestCode, resultCode, data);

        int cost;
        try {
            cost = Integer.parseInt(data.getStringExtra("cost"));
        } catch (NumberFormatException e) {
            cost = 0;
        }
        final int realCost = cost;
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            final String title = data.getStringExtra("title");

            final String token = PreferenceManager.getDefaultSharedPreferences(getContext()).getString(MainActivity.TOKEN, "");

            Call<Status> call = mApi.addItem(new AddItemRequest(title, getArguments().getString(TYPE),cost),token);
            call.enqueue(new Callback<Status>() {

                @Override
                public void onResponse(
                        final Call<Status> call, final Response<Status> response
                ) {
                    if (response.body().getClass().equals("success")) {
                        mAdapter.addItem(new Item(title, realCost));
                    }
                }

                @Override
                public void onFailure(final Call<Status> call, final Throwable t) {
                    t.printStackTrace();
                }
            });

        }
    }

    public void loadItems() {
        final String token = PreferenceManager.getDefaultSharedPreferences(getContext()).getString(MainActivity.TOKEN, "");

        Call<List<Item>> items = mApi.getItems(getArguments().getString(TYPE), token);
        items.enqueue(new Callback<List<Item>>() {

            @Override
            public void onResponse(
                    final Call<List<Item>> call, final Response<List<Item>> response
            ) {
                mAdapter.clearItems();
                mSwipeRefreshLayout.setRefreshing(false);
                List<Item> items = response.body();
                for (Item item : items) {
                    mAdapter.addItem(item);
                }
            }

            @Override
            public void onFailure(final Call<List<Item>> call, final Throwable t) {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

    }
}