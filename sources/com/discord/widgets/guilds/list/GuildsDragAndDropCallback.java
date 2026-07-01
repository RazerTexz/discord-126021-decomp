package com.discord.widgets.guilds.list;

import androidx.recyclerview.widget.ItemTouchHelper$Callback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GuildsDragAndDropCallback.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildsDragAndDropCallback extends ItemTouchHelper$Callback {
    public static final GuildsDragAndDropCallback$Companion Companion = new GuildsDragAndDropCallback$Companion(null);
    private static final int DEFAULT_DRAG_SCROLL_SPEED = 20;
    private static final float MOVE_THRESHOLD = 0.2f;
    private final GuildsDragAndDropCallback$Controller controller;

    public GuildsDragAndDropCallback(GuildsDragAndDropCallback$Controller guildsDragAndDropCallback$Controller) {
        m.checkNotNullParameter(guildsDragAndDropCallback$Controller, "controller");
        this.controller = guildsDragAndDropCallback$Controller;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper$Callback
    public RecyclerView$ViewHolder chooseDropTarget(RecyclerView$ViewHolder selected, List<RecyclerView$ViewHolder> dropTargets, int curX, int curY) {
        m.checkNotNullParameter(selected, "selected");
        m.checkNotNullParameter(dropTargets, "dropTargets");
        return this.controller.chooseDropTarget(selected, dropTargets, curX, curY);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper$Callback
    public float getMoveThreshold(RecyclerView$ViewHolder viewHolder) {
        m.checkNotNullParameter(viewHolder, "viewHolder");
        return 0.2f;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper$Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView$ViewHolder viewHolder) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(viewHolder, "viewHolder");
        boolean z2 = viewHolder instanceof GuildsDragAndDropCallback$DraggableViewHolder;
        Object obj = viewHolder;
        if (!z2) {
            obj = null;
        }
        GuildsDragAndDropCallback$DraggableViewHolder guildsDragAndDropCallback$DraggableViewHolder = (GuildsDragAndDropCallback$DraggableViewHolder) obj;
        return ItemTouchHelper$Callback.makeMovementFlags(guildsDragAndDropCallback$DraggableViewHolder != null && guildsDragAndDropCallback$DraggableViewHolder.canDrag() ? 3 : 0, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper$Callback
    public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int viewSize, int viewSizeOutOfBounds, int totalSize, long msSinceStartScroll) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        return ((int) Math.signum(viewSizeOutOfBounds)) * 20;
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
        return this.controller.onMove(recyclerView, source, target);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper$Callback
    public void onSelectedChanged(RecyclerView$ViewHolder viewHolder, int actionState) {
        if (actionState == 2) {
            if (viewHolder != null) {
                this.controller.onDragStarted(viewHolder);
            }
        } else if (actionState == 0) {
            this.controller.onDrop();
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper$Callback
    public void onSwiped(RecyclerView$ViewHolder viewHolder, int i) {
        m.checkNotNullParameter(viewHolder, "viewHolder");
    }
}
