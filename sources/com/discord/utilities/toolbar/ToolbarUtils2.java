package com.discord.utilities.toolbar;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.discord.utilities.dimen.DimenUtils;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.discord.utilities.toolbar.ToolbarUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: ToolbarUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ToolbarUtils2 {
    public static final View getNavigationIconView(Toolbar toolbar) {
        Intrinsics3.checkNotNullParameter(toolbar, "$this$getNavigationIconView");
        CharSequence navigationContentDescription = toolbar.getNavigationContentDescription();
        boolean z2 = false;
        if (navigationContentDescription != null) {
            if (navigationContentDescription.length() > 0) {
                z2 = true;
            }
        }
        CharSequence navigationContentDescription2 = z2 ? toolbar.getNavigationContentDescription() : "navigationIcon";
        toolbar.setNavigationContentDescription(navigationContentDescription2);
        ArrayList<View> arrayList = new ArrayList<>();
        toolbar.findViewsWithText(arrayList, navigationContentDescription2, 2);
        if (!z2) {
            toolbar.setNavigationContentDescription((CharSequence) null);
        }
        return (View) _Collections.firstOrNull((List) arrayList);
    }

    public static final void positionUnreadCountView(Toolbar toolbar, final View view) {
        Intrinsics3.checkNotNullParameter(toolbar, "$this$positionUnreadCountView");
        Intrinsics3.checkNotNullParameter(view, "view");
        View navigationIconView = getNavigationIconView(toolbar);
        if (navigationIconView != null) {
            if (!ViewCompat.isLaidOut(navigationIconView) || navigationIconView.isLayoutRequested()) {
                navigationIconView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.utilities.toolbar.ToolbarUtilsKt$positionUnreadCountView$$inlined$doOnLayout$1
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        Intrinsics3.checkNotNullParameter(view2, "view");
                        view2.removeOnLayoutChangeListener(this);
                        int iDpToPixels = DimenUtils.dpToPixels(2);
                        int right2 = view2.getRight();
                        int bottom2 = view2.getBottom();
                        View view3 = view;
                        float f = 2;
                        float f2 = iDpToPixels;
                        view3.setX((right2 / f) + f2);
                        view3.setY((bottom2 / f) + f2);
                    }
                });
                return;
            }
            int iDpToPixels = DimenUtils.dpToPixels(2);
            int right = navigationIconView.getRight();
            int bottom = navigationIconView.getBottom();
            float f = 2;
            float f2 = iDpToPixels;
            view.setX((right / f) + f2);
            view.setY((bottom / f) + f2);
        }
    }
}
