package com.google.android.material.transformation;

import android.view.View;
import android.view.ViewTreeObserver$OnPreDrawListener;
import com.google.android.material.expandable.ExpandableWidget;

/* JADX INFO: loaded from: classes3.dex */
public class ExpandableBehavior$a implements ViewTreeObserver$OnPreDrawListener {
    public final /* synthetic */ View j;
    public final /* synthetic */ int k;
    public final /* synthetic */ ExpandableWidget l;
    public final /* synthetic */ ExpandableBehavior m;

    public ExpandableBehavior$a(ExpandableBehavior expandableBehavior, View view, int i, ExpandableWidget expandableWidget) {
        this.m = expandableBehavior;
        this.j = view;
        this.k = i;
        this.l = expandableWidget;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public boolean onPreDraw() {
        this.j.getViewTreeObserver().removeOnPreDrawListener(this);
        if (ExpandableBehavior.access$000(this.m) == this.k) {
            ExpandableBehavior expandableBehavior = this.m;
            ExpandableWidget expandableWidget = this.l;
            expandableBehavior.onExpandedStateChange((View) expandableWidget, this.j, expandableWidget.isExpanded(), false);
        }
        return false;
    }
}
