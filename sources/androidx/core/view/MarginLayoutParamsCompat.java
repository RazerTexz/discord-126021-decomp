package androidx.core.view;

import android.view.ViewGroup$MarginLayoutParams;

/* JADX INFO: loaded from: classes.dex */
public final class MarginLayoutParamsCompat {
    private MarginLayoutParamsCompat() {
    }

    public static int getLayoutDirection(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        int layoutDirection = viewGroup$MarginLayoutParams.getLayoutDirection();
        if (layoutDirection == 0 || layoutDirection == 1) {
            return layoutDirection;
        }
        return 0;
    }

    public static int getMarginEnd(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        return viewGroup$MarginLayoutParams.getMarginEnd();
    }

    public static int getMarginStart(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        return viewGroup$MarginLayoutParams.getMarginStart();
    }

    public static boolean isMarginRelative(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        return viewGroup$MarginLayoutParams.isMarginRelative();
    }

    public static void resolveLayoutDirection(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, int i) {
        viewGroup$MarginLayoutParams.resolveLayoutDirection(i);
    }

    public static void setLayoutDirection(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, int i) {
        viewGroup$MarginLayoutParams.setLayoutDirection(i);
    }

    public static void setMarginEnd(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, int i) {
        viewGroup$MarginLayoutParams.setMarginEnd(i);
    }

    public static void setMarginStart(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, int i) {
        viewGroup$MarginLayoutParams.setMarginStart(i);
    }
}
