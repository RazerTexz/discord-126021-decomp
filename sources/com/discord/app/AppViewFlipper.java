package com.discord.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ViewFlipper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroup;
import com.discord.R;
import com.discord.app.AppScrollingViewBehavior;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.Intrinsics3;
import java.util.Iterator;

/* JADX INFO: compiled from: AppViewFlipper.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppViewFlipper extends ViewFlipper {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public int previewedChildIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        ViewExtensions.setForwardingWindowInsetsListener(this);
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.a.AppViewFlipper, 0, 0);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ble.AppViewFlipper, 0, 0)");
        try {
            this.previewedChildIndex = typedArrayObtainStyledAttributes.getInt(0, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.ViewFlipper, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof CoordinatorLayout) {
            Iterator<View> it = ViewGroup.getChildren(this).iterator();
            while (it.hasNext()) {
                ViewCompat.setOnApplyWindowInsetsListener(it.next(), new AppScrollingViewBehavior.a());
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) {
            setDisplayedChild(this.previewedChildIndex);
        }
    }

    @Override // android.widget.ViewAnimator
    public void setDisplayedChild(int whichChild) {
        if (getDisplayedChild() != whichChild) {
            super.setDisplayedChild(whichChild);
        }
    }
}
