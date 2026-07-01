package androidx.coordinatorlayout.widget;

import android.view.View;
import android.view.ViewGroup$OnHierarchyChangeListener;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout$HierarchyChangeListener implements ViewGroup$OnHierarchyChangeListener {
    public final /* synthetic */ CoordinatorLayout this$0;

    public CoordinatorLayout$HierarchyChangeListener(CoordinatorLayout coordinatorLayout) {
        this.this$0 = coordinatorLayout;
    }

    @Override // android.view.ViewGroup$OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        ViewGroup$OnHierarchyChangeListener viewGroup$OnHierarchyChangeListener = this.this$0.mOnHierarchyChangeListener;
        if (viewGroup$OnHierarchyChangeListener != null) {
            viewGroup$OnHierarchyChangeListener.onChildViewAdded(view, view2);
        }
    }

    @Override // android.view.ViewGroup$OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        this.this$0.onChildViewsChanged(2);
        ViewGroup$OnHierarchyChangeListener viewGroup$OnHierarchyChangeListener = this.this$0.mOnHierarchyChangeListener;
        if (viewGroup$OnHierarchyChangeListener != null) {
            viewGroup$OnHierarchyChangeListener.onChildViewRemoved(view, view2);
        }
    }
}
