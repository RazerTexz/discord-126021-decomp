package com.discord.utilities.views;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$State;
import d0.z.d.m;

/* JADX INFO: compiled from: StickyHeaderItemDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickyHeaderItemDecoration extends RecyclerView$ItemDecoration {
    private Float actionDownRawX;
    private Float actionDownRawY;
    private final StickyHeaderItemDecoration$StickyHeaderAdapter adapter;
    private float stickyHeaderBottom;

    public StickyHeaderItemDecoration(StickyHeaderItemDecoration$StickyHeaderAdapter stickyHeaderItemDecoration$StickyHeaderAdapter) {
        m.checkNotNullParameter(stickyHeaderItemDecoration$StickyHeaderAdapter, "adapter");
        this.adapter = stickyHeaderItemDecoration$StickyHeaderAdapter;
    }

    public static final /* synthetic */ Float access$getActionDownRawX$p(StickyHeaderItemDecoration stickyHeaderItemDecoration) {
        return stickyHeaderItemDecoration.actionDownRawX;
    }

    public static final /* synthetic */ Float access$getActionDownRawY$p(StickyHeaderItemDecoration stickyHeaderItemDecoration) {
        return stickyHeaderItemDecoration.actionDownRawY;
    }

    public static final /* synthetic */ float access$getStickyHeaderBottom$p(StickyHeaderItemDecoration stickyHeaderItemDecoration) {
        return stickyHeaderItemDecoration.stickyHeaderBottom;
    }

    public static final /* synthetic */ void access$resetActionDownCoordinates(StickyHeaderItemDecoration stickyHeaderItemDecoration) {
        stickyHeaderItemDecoration.resetActionDownCoordinates();
    }

    public static final /* synthetic */ void access$setActionDownRawX$p(StickyHeaderItemDecoration stickyHeaderItemDecoration, Float f) {
        stickyHeaderItemDecoration.actionDownRawX = f;
    }

    public static final /* synthetic */ void access$setActionDownRawY$p(StickyHeaderItemDecoration stickyHeaderItemDecoration, Float f) {
        stickyHeaderItemDecoration.actionDownRawY = f;
    }

    public static final /* synthetic */ void access$setStickyHeaderBottom$p(StickyHeaderItemDecoration stickyHeaderItemDecoration, float f) {
        stickyHeaderItemDecoration.stickyHeaderBottom = f;
    }

    private final void drawHeader(Canvas c, View header, float offsetY) {
        c.save();
        if (offsetY != 0.0f) {
            c.translate(0.0f, offsetY);
        }
        this.stickyHeaderBottom = header.getBottom() - offsetY;
        header.draw(c);
        c.restore();
    }

    public static /* synthetic */ void drawHeader$default(StickyHeaderItemDecoration stickyHeaderItemDecoration, Canvas canvas, View view, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = 0.0f;
        }
        stickyHeaderItemDecoration.drawHeader(canvas, view, f);
    }

    private final View getAndBindHeaderViewForItem(int itemPosition) {
        Integer headerPositionForItem = this.adapter.getHeaderPositionForItem(itemPosition);
        if (headerPositionForItem == null) {
            return null;
        }
        return this.adapter.getAndBindHeaderView(headerPositionForItem.intValue());
    }

    private final View getOverlappingView(RecyclerView parent, int contactPoint) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            m.checkNotNullExpressionValue(childAt, "child");
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            if (top <= contactPoint && bottom > contactPoint) {
                return childAt;
            }
        }
        return null;
    }

    private final void resetActionDownCoordinates() {
        this.actionDownRawX = null;
        this.actionDownRawY = null;
    }

    public final void blockClicks(RecyclerView parent) {
        m.checkNotNullParameter(parent, "parent");
        parent.addOnItemTouchListener(new StickyHeaderItemDecoration$blockClicks$1(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView$State state) {
        int childAdapterPosition;
        int childAdapterPosition2;
        m.checkNotNullParameter(canvas, "canvas");
        m.checkNotNullParameter(parent, "parent");
        m.checkNotNullParameter(state, "state");
        super.onDrawOver(canvas, parent, state);
        View childAt = parent.getChildAt(0);
        if (childAt == null || (childAdapterPosition = parent.getChildAdapterPosition(childAt)) == -1) {
            return;
        }
        View andBindHeaderViewForItem = getAndBindHeaderViewForItem(childAdapterPosition);
        float top = 0.0f;
        if (andBindHeaderViewForItem == null) {
            this.stickyHeaderBottom = 0.0f;
            return;
        }
        int top2 = parent.getTop() + andBindHeaderViewForItem.getBottom();
        int top3 = parent.getTop();
        int bottom = parent.getBottom();
        if (top3 > top2 || bottom <= top2) {
            return;
        }
        View overlappingView = getOverlappingView(parent, andBindHeaderViewForItem.getBottom());
        if (overlappingView != null && (childAdapterPosition2 = parent.getChildAdapterPosition(overlappingView)) != -1 && this.adapter.isHeader(childAdapterPosition2)) {
            top = overlappingView.getTop() - andBindHeaderViewForItem.getHeight();
        }
        drawHeader(canvas, andBindHeaderViewForItem, top);
    }
}
