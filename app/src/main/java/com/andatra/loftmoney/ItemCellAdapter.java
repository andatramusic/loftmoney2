package com.andatra.loftmoney;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemCellAdapter extends RecyclerView.Adapter<ItemCellAdapter.ItemViewHolder> {

    private List<Item> itemList = new ArrayList<>();

    public ItemCellAdapterClick itemCellAdapterClick;

    public void setData(List<Item> items) {
        itemList.clear();
        itemList.addAll(items);

        notifyDataSetChanged();
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void updateItem(Item item) {
        int itemPosition = itemList.indexOf(item);
        itemList.set(itemPosition, item);
        notifyItemChanged(itemPosition);
    }

    public void deleteSelectedItems() {
        List<Item> selectedItems = new ArrayList<>();
        for (Item item : itemList) {
            if (item.isSelected()) {
                selectedItems.add(item);
            }
        }

        itemList.removeAll(selectedItems);
        notifyDataSetChanged();
    }

    public void setItemCellAdapterClick(ItemCellAdapterClick itemCellAdapterClick) {
        this.itemCellAdapterClick = itemCellAdapterClick;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new ItemViewHolder(layoutInflater.inflate(R.layout.item, parent, false),
                itemCellAdapterClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView costTextView;
        private ItemCellAdapterClick itemCellAdapterClick;

        public ItemViewHolder(@NonNull View itemView, final ItemCellAdapterClick itemCellAdapterClick) {
            super(itemView);

            this.itemCellAdapterClick = itemCellAdapterClick;

            titleTextView = itemView.findViewById(R.id.TitleView);
            costTextView = itemView.findViewById(R.id.CostView);
        }

        public void bind(final Item item) {
            titleTextView.setText(item.getTitle());
            costTextView.setText((int) item.getCost());

            itemView.setBackgroundColor(ContextCompat.getColor(itemView.getContext(),
                    item.isSelected() ? R.color.white : android.R.color.white));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemCellAdapterClick != null) {
                        itemCellAdapterClick.onCellClick(item);
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (itemCellAdapterClick != null) {
                        itemCellAdapterClick.onLongCellClick(item);
                    }

                    return true;
                }
            });
        }
    }
}