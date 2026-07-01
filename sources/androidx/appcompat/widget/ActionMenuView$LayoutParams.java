package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewDebug$ExportedProperty;
import android.view.ViewGroup$LayoutParams;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView$LayoutParams extends LinearLayoutCompat$LayoutParams {

    @ViewDebug$ExportedProperty
    public int cellsUsed;

    @ViewDebug$ExportedProperty
    public boolean expandable;
    public boolean expanded;

    @ViewDebug$ExportedProperty
    public int extraPixels;

    @ViewDebug$ExportedProperty
    public boolean isOverflowButton;

    @ViewDebug$ExportedProperty
    public boolean preventEdgeOffset;

    public ActionMenuView$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ActionMenuView$LayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
    }

    public ActionMenuView$LayoutParams(ActionMenuView$LayoutParams actionMenuView$LayoutParams) {
        super((ViewGroup$LayoutParams) actionMenuView$LayoutParams);
        this.isOverflowButton = actionMenuView$LayoutParams.isOverflowButton;
    }

    public ActionMenuView$LayoutParams(int i, int i2) {
        super(i, i2);
        this.isOverflowButton = false;
    }

    public ActionMenuView$LayoutParams(int i, int i2, boolean z2) {
        super(i, i2);
        this.isOverflowButton = z2;
    }
}
