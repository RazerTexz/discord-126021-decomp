package b.i.a.g.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;

/* JADX INFO: compiled from: ViewOffsetBehavior.java */
/* JADX INFO: loaded from: classes3.dex */
public class c<V extends View> extends CoordinatorLayout$Behavior<V> {
    private int tempLeftRightOffset;
    private int tempTopBottomOffset;
    private d viewOffsetHelper;

    public c() {
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public int getLeftAndRightOffset() {
        d dVar = this.viewOffsetHelper;
        if (dVar != null) {
            return dVar.e;
        }
        return 0;
    }

    public int getTopAndBottomOffset() {
        d dVar = this.viewOffsetHelper;
        if (dVar != null) {
            return dVar.d;
        }
        return 0;
    }

    public boolean isHorizontalOffsetEnabled() {
        d dVar = this.viewOffsetHelper;
        return dVar != null && dVar.g;
    }

    public boolean isVerticalOffsetEnabled() {
        d dVar = this.viewOffsetHelper;
        return dVar != null && dVar.f;
    }

    public void layoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i) {
        coordinatorLayout.onLayoutChild(v, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i) {
        layoutChild(coordinatorLayout, v, i);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new d(v);
        }
        d dVar = this.viewOffsetHelper;
        dVar.f1603b = dVar.a.getTop();
        dVar.c = dVar.a.getLeft();
        this.viewOffsetHelper.a();
        int i2 = this.tempTopBottomOffset;
        if (i2 != 0) {
            this.viewOffsetHelper.b(i2);
            this.tempTopBottomOffset = 0;
        }
        int i3 = this.tempLeftRightOffset;
        if (i3 == 0) {
            return true;
        }
        d dVar2 = this.viewOffsetHelper;
        if (dVar2.g && dVar2.e != i3) {
            dVar2.e = i3;
            dVar2.a();
        }
        this.tempLeftRightOffset = 0;
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean z2) {
        d dVar = this.viewOffsetHelper;
        if (dVar != null) {
            dVar.g = z2;
        }
    }

    public boolean setLeftAndRightOffset(int i) {
        d dVar = this.viewOffsetHelper;
        if (dVar == null) {
            this.tempLeftRightOffset = i;
            return false;
        }
        if (!dVar.g || dVar.e == i) {
            return false;
        }
        dVar.e = i;
        dVar.a();
        return true;
    }

    public boolean setTopAndBottomOffset(int i) {
        d dVar = this.viewOffsetHelper;
        if (dVar != null) {
            return dVar.b(i);
        }
        this.tempTopBottomOffset = i;
        return false;
    }

    public void setVerticalOffsetEnabled(boolean z2) {
        d dVar = this.viewOffsetHelper;
        if (dVar != null) {
            dVar.f = z2;
        }
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }
}
