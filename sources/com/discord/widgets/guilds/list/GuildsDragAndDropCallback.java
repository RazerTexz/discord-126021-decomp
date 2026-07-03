package com.discord.widgets.guilds.list;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildsDragAndDropCallback.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildsDragAndDropCallback extends ItemTouchHelper.Callback {
    private static final int DEFAULT_DRAG_SCROLL_SPEED = 20;
    private static final float MOVE_THRESHOLD = 0.2f;
    private final Controller controller;

    /* JADX INFO: compiled from: GuildsDragAndDropCallback.kt */
    public interface Controller {
        RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder selected, List<RecyclerView.ViewHolder> dropTargets, int curX, int curY);

        void onDragStarted(RecyclerView.ViewHolder viewHolder);

        void onDrop();

        boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target);
    }

    /* JADX INFO: compiled from: GuildsDragAndDropCallback.kt */
    public interface DraggableViewHolder {
        boolean canDrag();
    }

    public GuildsDragAndDropCallback(Controller controller) {
        C12238m.checkNotNullParameter(controller, "controller");
        this.controller = controller;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder selected, List<RecyclerView.ViewHolder> dropTargets, int curX, int curY) {
        C12238m.checkNotNullParameter(selected, "selected");
        C12238m.checkNotNullParameter(dropTargets, "dropTargets");
        return this.controller.chooseDropTarget(selected, dropTargets, curX, curY);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
        C12238m.checkNotNullParameter(viewHolder, "viewHolder");
        return 0.2f;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        C12238m.checkNotNullParameter(recyclerView, "recyclerView");
        C12238m.checkNotNullParameter(viewHolder, "viewHolder");
        boolean z2 = viewHolder instanceof DraggableViewHolder;
        Object obj = viewHolder;
        if (!z2) {
            obj = null;
        }
        DraggableViewHolder draggableViewHolder = (DraggableViewHolder) obj;
        return ItemTouchHelper.Callback.makeMovementFlags(draggableViewHolder != null && draggableViewHolder.canDrag() ? 3 : 0, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int viewSize, int viewSizeOutOfBounds, int totalSize, long msSinceStartScroll) {
        C12238m.checkNotNullParameter(recyclerView, "recyclerView");
        return ((int) Math.signum(viewSizeOutOfBounds)) * 20;
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
        C12238m.checkNotNullParameter(recyclerView, "recyclerView");
        C12238m.checkNotNullParameter(source, "source");
        C12238m.checkNotNullParameter(target, "target");
        return this.controller.onMove(recyclerView, source, target);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState == 2) {
            if (viewHolder != null) {
                this.controller.onDragStarted(viewHolder);
            }
        } else if (actionState == 0) {
            this.controller.onDrop();
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        C12238m.checkNotNullParameter(viewHolder, "viewHolder");
    }
}
