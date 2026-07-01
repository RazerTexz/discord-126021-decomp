package com.facebook.drawee.interfaces;

import android.graphics.drawable.Animatable;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public interface DraweeController {
    void a();

    DraweeHierarchy b();

    Animatable c();

    void d();

    void e(DraweeHierarchy draweeHierarchy);

    boolean onTouchEvent(MotionEvent motionEvent);
}
