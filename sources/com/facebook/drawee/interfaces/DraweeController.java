package com.facebook.drawee.interfaces;

import android.graphics.drawable.Animatable;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public interface DraweeController {
    /* JADX INFO: renamed from: a */
    void mo8652a();

    /* JADX INFO: renamed from: b */
    DraweeHierarchy mo8653b();

    /* JADX INFO: renamed from: c */
    Animatable mo8654c();

    /* JADX INFO: renamed from: d */
    void mo8655d();

    /* JADX INFO: renamed from: e */
    void mo1045e(DraweeHierarchy draweeHierarchy);

    boolean onTouchEvent(MotionEvent motionEvent);
}
