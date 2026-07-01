package com.discord.utilities.views;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$SimpleOnItemTouchListener;
import d0.z.d.m;

/* JADX INFO: compiled from: StickyHeaderItemDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickyHeaderItemDecoration$blockClicks$1 extends RecyclerView$SimpleOnItemTouchListener {
    public final /* synthetic */ StickyHeaderItemDecoration this$0;

    public StickyHeaderItemDecoration$blockClicks$1(StickyHeaderItemDecoration stickyHeaderItemDecoration) {
        this.this$0 = stickyHeaderItemDecoration;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x005f  */
    @Override // androidx.recyclerview.widget.RecyclerView$SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView$OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent event) {
        boolean z2;
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            StickyHeaderItemDecoration.access$setActionDownRawX$p(this.this$0, Float.valueOf(event.getRawX()));
            StickyHeaderItemDecoration.access$setActionDownRawY$p(this.this$0, Float.valueOf(event.getRawY()));
        } else if (action == 1) {
            Float fAccess$getActionDownRawX$p = StickyHeaderItemDecoration.access$getActionDownRawX$p(this.this$0);
            Float fAccess$getActionDownRawY$p = StickyHeaderItemDecoration.access$getActionDownRawY$p(this.this$0);
            if (fAccess$getActionDownRawX$p == null || fAccess$getActionDownRawY$p == null) {
                z2 = false;
            } else {
                float fAbs = Math.abs(event.getRawX() - fAccess$getActionDownRawX$p.floatValue());
                float fAbs2 = Math.abs(event.getRawY() - fAccess$getActionDownRawY$p.floatValue());
                float dimensionPixelSize = recyclerView.getResources().getDimensionPixelSize(2131165344);
                if (fAbs >= dimensionPixelSize || fAbs2 >= dimensionPixelSize) {
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            StickyHeaderItemDecoration.access$resetActionDownCoordinates(this.this$0);
            if (z2 && event.getY() <= StickyHeaderItemDecoration.access$getStickyHeaderBottom$p(this.this$0)) {
                return true;
            }
        } else if (action == 3) {
            StickyHeaderItemDecoration.access$resetActionDownCoordinates(this.this$0);
        }
        return false;
    }
}
