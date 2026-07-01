package com.google.android.material.bottomappbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View$OnLayoutChangeListener;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.view.ViewCompat;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar$Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

    @NonNull
    private final Rect fabContentRect;
    private final View$OnLayoutChangeListener fabLayoutListener;
    private int originalBottomMargin;
    private WeakReference<BottomAppBar> viewRef;

    public BottomAppBar$Behavior() {
        this.fabLayoutListener = new BottomAppBar$Behavior$a(this);
        this.fabContentRect = new Rect();
    }

    public static /* synthetic */ WeakReference access$2400(BottomAppBar$Behavior bottomAppBar$Behavior) {
        return bottomAppBar$Behavior.viewRef;
    }

    public static /* synthetic */ Rect access$2500(BottomAppBar$Behavior bottomAppBar$Behavior) {
        return bottomAppBar$Behavior.fabContentRect;
    }

    public static /* synthetic */ int access$2600(BottomAppBar$Behavior bottomAppBar$Behavior) {
        return bottomAppBar$Behavior.originalBottomMargin;
    }

    @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
        return onLayoutChild(coordinatorLayout, (BottomAppBar) view, i);
    }

    @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, @NonNull View view3, int i, int i2) {
        return onStartNestedScroll(coordinatorLayout, (BottomAppBar) view, view2, view3, i, i2);
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i) {
        this.viewRef = new WeakReference<>(bottomAppBar);
        View viewAccess$3100 = BottomAppBar.access$3100(bottomAppBar);
        if (viewAccess$3100 != null && !ViewCompat.isLaidOut(viewAccess$3100)) {
            CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams) viewAccess$3100.getLayoutParams();
            coordinatorLayout$LayoutParams.anchorGravity = 49;
            this.originalBottomMargin = ((ViewGroup$MarginLayoutParams) coordinatorLayout$LayoutParams).bottomMargin;
            if (viewAccess$3100 instanceof FloatingActionButton) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) viewAccess$3100;
                floatingActionButton.addOnLayoutChangeListener(this.fabLayoutListener);
                BottomAppBar.access$3200(bottomAppBar, floatingActionButton);
            }
            BottomAppBar.access$1300(bottomAppBar);
        }
        coordinatorLayout.onLayoutChild(bottomAppBar, i);
        return super.onLayoutChild(coordinatorLayout, bottomAppBar, i);
    }

    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i, int i2) {
        return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view, view2, i, i2);
    }

    public BottomAppBar$Behavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fabLayoutListener = new BottomAppBar$Behavior$a(this);
        this.fabContentRect = new Rect();
    }
}
