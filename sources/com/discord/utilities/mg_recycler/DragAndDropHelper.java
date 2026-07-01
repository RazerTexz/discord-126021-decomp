package com.discord.utilities.mg_recycler;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DragAndDropHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DragAndDropHelper extends ItemTouchHelper.Callback {
    private static final int DEFAULT_DRAG_SCROLL_SPEED = 15;
    private final Adapter adapter;
    private final int dragScrollSpeed;

    /* JADX INFO: compiled from: DragAndDropHelper.kt */
    public interface Adapter {
        boolean isValidMove(int fromPosition, int toPosition);

        void onDrop();

        void onItemMove(int fromPosition, int toPosition);
    }

    /* JADX INFO: compiled from: DragAndDropHelper.kt */
    public interface DraggableViewHolder {
        boolean canDrag();

        void onDragStateChanged(boolean dragging);
    }

    public DragAndDropHelper(Adapter adapter) {
        this(adapter, 0, 2, null);
    }

    public /* synthetic */ DragAndDropHelper(Adapter adapter, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(adapter, (i2 & 2) != 0 ? 15 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(viewHolder, "viewHolder");
        super.clearView(recyclerView, viewHolder);
        ((DraggableViewHolder) viewHolder).onDragStateChanged(false);
        this.adapter.onDrop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(viewHolder, "viewHolder");
        return ItemTouchHelper.Callback.makeMovementFlags((viewHolder instanceof DraggableViewHolder) && ((DraggableViewHolder) viewHolder).canDrag() ? 3 : 0, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int viewSize, int viewSizeOutOfBounds, int totalSize, long msSinceStartScroll) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        return this.dragScrollSpeed * ((int) Math.signum(viewSizeOutOfBounds));
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(source, "source");
        Intrinsics3.checkNotNullParameter(target, "target");
        if (!this.adapter.isValidMove(source.getAdapterPosition(), target.getAdapterPosition())) {
            return false;
        }
        this.adapter.onItemMove(source.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState == 2) {
            DraggableViewHolder draggableViewHolder = (DraggableViewHolder) viewHolder;
            Intrinsics3.checkNotNull(draggableViewHolder);
            draggableViewHolder.onDragStateChanged(true);
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics3.checkNotNullParameter(viewHolder, "viewHolder");
    }

    public DragAndDropHelper(Adapter adapter, int i) {
        Intrinsics3.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
        this.dragScrollSpeed = i;
    }
}
