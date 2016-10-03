package com.bignerdranch.expandablerecyclerview;

import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * ViewHolder for a child list item.
 * <p>
 * The user should extend this class and implement as they wish for their
 * child list item.
 */
public class ChildViewHolder extends RecyclerView.ViewHolder {
    Object mChildListItem;
    ExpandableRecyclerAdapter mExpandableAdapter;

    /**
     * Default constructor.
     *
     * @param itemView The {@link View} being hosted in this ViewHolder
     */
    public ChildViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    /**
     * @return the childListItem associated with this view holder
     */
    @UiThread
    public Object getChildListItem() {
        return mChildListItem;
    }

    /**
     * Returns the adapter position of the Parent associated with this ChildViewHolder
     *
     * @return The adapter position of the Parent if it still exists in the adapter.
     * RecyclerView.NO_POSITION if item has been removed from the adapter,
     * RecyclerView.Adapter.notifyDataSetChanged() has been called after the last
     * layout pass or the ViewHolder has already been recycled.
     */
    @UiThread
    public int getParentAdapterPosition() {
        int adapterPosition = getAdapterPosition();
        if (mExpandableAdapter == null || adapterPosition == RecyclerView.NO_POSITION) {
            return adapterPosition;
        }

        return mExpandableAdapter.getNearestParentPosition(adapterPosition);
    }

    /**
     * Returns the adapter position of the Child associated with this ChildViewHolder
     *
     * @return The adapter position of the Child if it still exists in the adapter.
     * RecyclerView.NO_POSITION if item has been removed from the adapter,
     * RecyclerView.Adapter.notifyDataSetChanged() has been called after the last
     * layout pass or the ViewHolder has already been recycled.
     */
    @UiThread
    public int getChildAdapterPosition() {
        int adapterPosition = getAdapterPosition();
        if (mExpandableAdapter == null || adapterPosition == RecyclerView.NO_POSITION) {
            return adapterPosition;
        }

        return mExpandableAdapter.getChildPosition(adapterPosition);
    }
}