package com.discord.utilities.mg_recycler;

import androidx.recyclerview.widget.ItemTouchHelper$Callback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DragAndDropHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DragAndDropHelper extends ItemTouchHelper$Callback {
    public static final DragAndDropHelper$Companion Companion = new DragAndDropHelper$Companion(null);
    private static final int DEFAULT_DRAG_SCROLL_SPEED = 15;
    private final DragAndDropHelper$Adapter adapter;
    private final int dragScrollSpeed;

    public DragAndDropHelper(DragAndDropHelper$Adapter dragAndDropHelper$Adapter) {
        this(dragAndDropHelper$Adapter, 0, 2, null);
    }

    public /* synthetic */ DragAndDropHelper(DragAndDropHelper$Adapter dragAndDropHelper$Adapter, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(dragAndDropHelper$Adapter, (i2 & 2) != 0 ? 15 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.ItemTouchHelper$Callback
    public void clearView(RecyclerView recyclerView, RecyclerView$ViewHolder viewHolder) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(viewHolder, "viewHolder");
        super.clearView(recyclerView, viewHolder);
        ((DragAndDropHelper$DraggableViewHolder) viewHolder).onDragStateChanged(false);
        this.adapter.onDrop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.ItemTouchHelper$Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView$ViewHolder viewHolder) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(viewHolder, "viewHolder");
        return ItemTouchHelper$Callback.makeMovementFlags((viewHolder instanceof DragAndDropHelper$DraggableViewHolder) && ((DragAndDropHelper$DraggableViewHolder) viewHolder).getCanDrag() ? 3 : 0, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper$Callback
    public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int viewSize, int viewSizeOutOfBounds, int totalSize, long msSinceStartScroll) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        return this.dragScrollSpeed * ((int) Math.signum(viewSizeOutOfBounds));
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper$Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper$Callback
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper$Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView$ViewHolder source, RecyclerView$ViewHolder target) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(source, "source");
        m.checkNotNullParameter(target, "target");
        if (!this.adapter.isValidMove(source.getAdapterPosition(), target.getAdapterPosition())) {
            return false;
        }
        this.adapter.onItemMove(source.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.ItemTouchHelper$Callback
    public void onSelectedChanged(RecyclerView$ViewHolder viewHolder, int actionState) {
        if (actionState == 2) {
            DragAndDropHelper$DraggableViewHolder dragAndDropHelper$DraggableViewHolder = (DragAndDropHelper$DraggableViewHolder) viewHolder;
            m.checkNotNull(dragAndDropHelper$DraggableViewHolder);
            dragAndDropHelper$DraggableViewHolder.onDragStateChanged(true);
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper$Callback
    public void onSwiped(RecyclerView$ViewHolder viewHolder, int i) {
        m.checkNotNullParameter(viewHolder, "viewHolder");
    }

    public DragAndDropHelper(DragAndDropHelper$Adapter dragAndDropHelper$Adapter, int i) {
        m.checkNotNullParameter(dragAndDropHelper$Adapter, "adapter");
        this.adapter = dragAndDropHelper$Adapter;
        this.dragScrollSpeed = i;
    }
}
