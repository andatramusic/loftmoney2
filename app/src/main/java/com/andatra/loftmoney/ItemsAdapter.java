package com.andatra.loftmoney;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {

    private List<Item> itemList = new ArrayList<Item>();

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        View itemView = View.inflate(parent.getContext(), R.layout.item, null);

        return new ItemsViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {
        holder.bind(itemList.get(position));

    }
    public void addItem(Item item) {
        itemList.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ItemsViewHolder extends RecyclerView.ViewHolder{

        private TextView titleTextView;
        private TextView costTextView;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.TitleView);
            costTextView = itemView.findViewById(R.id.CostView);

        }
        public void bind(Item item){
            titleTextView.setText(item.getTitle());
            costTextView.setText(costTextView.getContext().getResources().getString(R.string.price_with_currency, String.valueOf(item.getCost())));

        }
    }

}
