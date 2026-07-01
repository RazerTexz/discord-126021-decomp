package com.yalantis.ucrop.view;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector$SimpleOnScaleGestureListener;

/* JADX INFO: loaded from: classes3.dex */
public class GestureCropImageView$d extends ScaleGestureDetector$SimpleOnScaleGestureListener {
    public final /* synthetic */ GestureCropImageView a;

    public GestureCropImageView$d(GestureCropImageView gestureCropImageView, GestureCropImageView$a gestureCropImageView$a) {
        this.a = gestureCropImageView;
    }

    @Override // android.view.ScaleGestureDetector$SimpleOnScaleGestureListener, android.view.ScaleGestureDetector$OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        GestureCropImageView gestureCropImageView = this.a;
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        GestureCropImageView gestureCropImageView2 = this.a;
        gestureCropImageView.f(scaleFactor, gestureCropImageView2.N, gestureCropImageView2.O);
        return true;
    }
}
