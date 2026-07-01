package com.discord.utilities.view.extensions;

import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;
import d0.z.d.m;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewExtensions$interceptScrollWhenInsideScrollable$1 implements View$OnTouchListener {
    public static final ViewExtensions$interceptScrollWhenInsideScrollable$1 INSTANCE = new ViewExtensions$interceptScrollWhenInsideScrollable$1();

    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        m.checkNotNullExpressionValue(view, "view");
        if (!view.isFocused()) {
            return false;
        }
        view.getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    }
}
