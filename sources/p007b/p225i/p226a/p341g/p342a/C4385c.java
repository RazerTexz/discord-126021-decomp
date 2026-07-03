package p007b.p225i.p226a.p341g.p342a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: renamed from: b.i.a.g.a.c */
/* JADX INFO: compiled from: ViewOffsetBehavior.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4385c<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int tempLeftRightOffset;
    private int tempTopBottomOffset;
    private C4386d viewOffsetHelper;

    public C4385c() {
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public int getLeftAndRightOffset() {
        C4386d c4386d = this.viewOffsetHelper;
        if (c4386d != null) {
            return c4386d.f11534e;
        }
        return 0;
    }

    public int getTopAndBottomOffset() {
        C4386d c4386d = this.viewOffsetHelper;
        if (c4386d != null) {
            return c4386d.f11533d;
        }
        return 0;
    }

    public boolean isHorizontalOffsetEnabled() {
        C4386d c4386d = this.viewOffsetHelper;
        return c4386d != null && c4386d.f11536g;
    }

    public boolean isVerticalOffsetEnabled() {
        C4386d c4386d = this.viewOffsetHelper;
        return c4386d != null && c4386d.f11535f;
    }

    public void layoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i) {
        coordinatorLayout.onLayoutChild(v, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i) {
        layoutChild(coordinatorLayout, v, i);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new C4386d(v);
        }
        C4386d c4386d = this.viewOffsetHelper;
        c4386d.f11531b = c4386d.f11530a.getTop();
        c4386d.f11532c = c4386d.f11530a.getLeft();
        this.viewOffsetHelper.m6033a();
        int i2 = this.tempTopBottomOffset;
        if (i2 != 0) {
            this.viewOffsetHelper.m6034b(i2);
            this.tempTopBottomOffset = 0;
        }
        int i3 = this.tempLeftRightOffset;
        if (i3 == 0) {
            return true;
        }
        C4386d c4386d2 = this.viewOffsetHelper;
        if (c4386d2.f11536g && c4386d2.f11534e != i3) {
            c4386d2.f11534e = i3;
            c4386d2.m6033a();
        }
        this.tempLeftRightOffset = 0;
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean z2) {
        C4386d c4386d = this.viewOffsetHelper;
        if (c4386d != null) {
            c4386d.f11536g = z2;
        }
    }

    public boolean setLeftAndRightOffset(int i) {
        C4386d c4386d = this.viewOffsetHelper;
        if (c4386d == null) {
            this.tempLeftRightOffset = i;
            return false;
        }
        if (!c4386d.f11536g || c4386d.f11534e == i) {
            return false;
        }
        c4386d.f11534e = i;
        c4386d.m6033a();
        return true;
    }

    public boolean setTopAndBottomOffset(int i) {
        C4386d c4386d = this.viewOffsetHelper;
        if (c4386d != null) {
            return c4386d.m6034b(i);
        }
        this.tempTopBottomOffset = i;
        return false;
    }

    public void setVerticalOffsetEnabled(boolean z2) {
        C4386d c4386d = this.viewOffsetHelper;
        if (c4386d != null) {
            c4386d.f11535f = z2;
        }
    }

    public C4385c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }
}
