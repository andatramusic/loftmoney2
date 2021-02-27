package com.andatra.loftmoney;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<FragmentItem> fragments = new ArrayList<>();
        fragments.add(new FragmentItem(new ExpenceFragment(), getString(R.string.expences)));
        fragments.add(new FragmentItem(new IncomeFragment(), getString(R.string.income)));
        fragments.add(new FragmentItem(new BalanceFragment(), getString(R.string.balance)));

        ViewPager containerView = view.findViewById(R.id.containerView);
        TabLayout tablayout = view.findViewById(R.id.tabContainerView);

        FragmentAdapter fragmentAdapter = new FragmentAdapter(fragments, getChildFragmentManager(), 0);
        containerView.setAdapter(fragmentAdapter);
        containerView.setOffscreenPageLimit(3);
        tablayout.setupWithViewPager(containerView);
    }
}
