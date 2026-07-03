package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    private static final int STATE_COLLAPSED = 2;
    private static final int STATE_EXPANDED = 1;
    private static final int STATE_UNINITIALIZED = 0;
    private int currentState;

    /* JADX INFO: renamed from: com.google.android.material.transformation.ExpandableBehavior$a */
    public class ViewTreeObserverOnPreDrawListenerC11033a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ View f21238j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ int f21239k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ ExpandableWidget f21240l;

        public ViewTreeObserverOnPreDrawListenerC11033a(View view, int i, ExpandableWidget expandableWidget) {
            this.f21238j = view;
            this.f21239k = i;
            this.f21240l = expandableWidget;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f21238j.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.currentState == this.f21239k) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                ExpandableWidget expandableWidget = this.f21240l;
                expandableBehavior.onExpandedStateChange((View) expandableWidget, this.f21238j, expandableWidget.isExpanded(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.currentState = 0;
    }

    private boolean didStateChange(boolean z2) {
        if (!z2) {
            return this.currentState == 1;
        }
        int i = this.currentState;
        return i == 0 || i == 2;
    }

    @Nullable
    public static <T extends ExpandableBehavior> T from(@NonNull View view, @NonNull Class<T> cls) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (behavior instanceof ExpandableBehavior) {
            return cls.cast(behavior);
        }
        throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public ExpandableWidget findExpandableWidget(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        List<View> dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        for (int i = 0; i < size; i++) {
            View view2 = dependencies.get(i);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (ExpandableWidget) view2;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        ExpandableWidget expandableWidget = (ExpandableWidget) view2;
        if (!didStateChange(expandableWidget.isExpanded())) {
            return false;
        }
        this.currentState = expandableWidget.isExpanded() ? 1 : 2;
        return onExpandedStateChange((View) expandableWidget, view, expandableWidget.isExpanded(), true);
    }

    public abstract boolean onExpandedStateChange(View view, View view2, boolean z2, boolean z3);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
        ExpandableWidget expandableWidgetFindExpandableWidget;
        if (ViewCompat.isLaidOut(view) || (expandableWidgetFindExpandableWidget = findExpandableWidget(coordinatorLayout, view)) == null || !didStateChange(expandableWidgetFindExpandableWidget.isExpanded())) {
            return false;
        }
        int i2 = expandableWidgetFindExpandableWidget.isExpanded() ? 1 : 2;
        this.currentState = i2;
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC11033a(view, i2, expandableWidgetFindExpandableWidget));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentState = 0;
    }
}
