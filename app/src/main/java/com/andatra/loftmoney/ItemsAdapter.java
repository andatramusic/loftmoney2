package com.andatra.loftmoney;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private List<Item> mItemsList = new ArrayList<Item>();
    private final int colorId;

    public ItemsAdapter(final int colorId) {
        this.colorId = colorId;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        View itemView = View.inflate(parent.getContext(), R.layout.item, null);

        return new ItemViewHolder(itemView, colorId);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, final int position) {
        holder.bindItem(mItemsList.get(position));
    }

    public void addItem(Item item) {
        mItemsList.add(item);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mItemsList.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mItemsList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitleView;
        private TextView mCostView;

        public ItemViewHolder(@NonNull final View itemView, final int colorId) {
            super(itemView);

            mTitleView = itemView.findViewById(R.id.TitleView);
            mCostView = itemView.findViewById(R.id.CostView);

            final Context context = mCostView.getContext();
            mCostView.setTextColor(ContextCompat.getColor(context, colorId));
        }

        public void bindItem(final Item item) {
            mTitleView.setText(item.getTitle());
            mCostView.setText(
                    mCostView.getContext().getResources().getString(R.string.price_with_currency, String.valueOf(item.getCost()))
            );
        }
    }
}