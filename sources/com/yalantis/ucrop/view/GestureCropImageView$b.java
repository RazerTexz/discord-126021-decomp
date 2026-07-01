package com.yalantis.ucrop.view;

import android.view.GestureDetector$SimpleOnGestureListener;
import android.view.MotionEvent;
import b.q.a.l.a$b;

/* JADX INFO: loaded from: classes3.dex */
public class GestureCropImageView$b extends GestureDetector$SimpleOnGestureListener {
    public final /* synthetic */ GestureCropImageView j;

    public GestureCropImageView$b(GestureCropImageView gestureCropImageView, GestureCropImageView$a gestureCropImageView$a) {
        this.j = gestureCropImageView;
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        GestureCropImageView gestureCropImageView = this.j;
        float doubleTapTargetScale = gestureCropImageView.getDoubleTapTargetScale();
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        if (doubleTapTargetScale > gestureCropImageView.getMaxScale()) {
            doubleTapTargetScale = gestureCropImageView.getMaxScale();
        }
        float currentScale = gestureCropImageView.getCurrentScale();
        a$b a_b = new a$b(gestureCropImageView, 200L, currentScale, doubleTapTargetScale - currentScale, x2, y2);
        gestureCropImageView.E = a_b;
        gestureCropImageView.post(a_b);
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.j.g(-f, -f2);
        return true;
    }
}
