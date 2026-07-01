package com.discord.utilities.views;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: StickyHeaderItemDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickyHeaderItemDecoration extends RecyclerView.ItemDecoration {
    private Float actionDownRawX;
    private Float actionDownRawY;
    private final StickyHeaderAdapter adapter;
    private float stickyHeaderBottom;

    /* JADX INFO: compiled from: StickyHeaderItemDecoration.kt */
    public static final class LayoutManager {
        public static final LayoutManager INSTANCE = new LayoutManager();

        private LayoutManager() {
        }

        public static final void layoutHeaderView(ViewGroup parent, View view) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            Intrinsics3.checkNotNullParameter(view, "view");
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(parent.getWidth(), BasicMeasure.EXACTLY);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(parent.getHeight(), 0);
            view.measure(ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, parent.getPaddingRight() + parent.getPaddingLeft(), view.getLayoutParams().width), ViewGroup.getChildMeasureSpec(iMakeMeasureSpec2, parent.getPaddingBottom() + parent.getPaddingTop(), view.getLayoutParams().height));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: compiled from: StickyHeaderItemDecoration.kt */
    public interface StickyHeaderAdapter {
        View getAndBindHeaderView(int position);

        Integer getHeaderPositionForItem(int itemPosition);

        boolean isHeader(int position);
    }

    public StickyHeaderItemDecoration(StickyHeaderAdapter stickyHeaderAdapter) {
        Intrinsics3.checkNotNullParameter(stickyHeaderAdapter, "adapter");
        this.adapter = stickyHeaderAdapter;
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
            Intrinsics3.checkNotNullExpressionValue(childAt, "child");
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
        Intrinsics3.checkNotNullParameter(parent, "parent");
        parent.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() { // from class: com.discord.utilities.views.StickyHeaderItemDecoration.blockClicks.1
            /* JADX WARN: Code duplicated, block: B:17:0x005f  */
            @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent event) {
                boolean z2;
                Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
                Intrinsics3.checkNotNullParameter(event, "event");
                int action = event.getAction();
                if (action == 0) {
                    StickyHeaderItemDecoration.this.actionDownRawX = Float.valueOf(event.getRawX());
                    StickyHeaderItemDecoration.this.actionDownRawY = Float.valueOf(event.getRawY());
                } else if (action == 1) {
                    Float f = StickyHeaderItemDecoration.this.actionDownRawX;
                    Float f2 = StickyHeaderItemDecoration.this.actionDownRawY;
                    if (f == null || f2 == null) {
                        z2 = false;
                    } else {
                        float fAbs = Math.abs(event.getRawX() - f.floatValue());
                        float fAbs2 = Math.abs(event.getRawY() - f2.floatValue());
                        float dimensionPixelSize = recyclerView.getResources().getDimensionPixelSize(R.dimen.default_scroll_slop);
                        if (fAbs >= dimensionPixelSize || fAbs2 >= dimensionPixelSize) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                    }
                    StickyHeaderItemDecoration.this.resetActionDownCoordinates();
                    if (z2 && event.getY() <= StickyHeaderItemDecoration.this.stickyHeaderBottom) {
                        return true;
                    }
                } else if (action == 3) {
                    StickyHeaderItemDecoration.this.resetActionDownCoordinates();
                }
                return false;
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        int childAdapterPosition;
        int childAdapterPosition2;
        Intrinsics3.checkNotNullParameter(canvas, "canvas");
        Intrinsics3.checkNotNullParameter(parent, "parent");
        Intrinsics3.checkNotNullParameter(state, "state");
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
