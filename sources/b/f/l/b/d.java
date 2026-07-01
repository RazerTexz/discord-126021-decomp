package b.f.l.b;

import android.view.GestureDetector$SimpleOnGestureListener;
import android.view.MotionEvent;

/* JADX INFO: compiled from: GestureListenerWrapper.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends GestureDetector$SimpleOnGestureListener {
    public GestureDetector$SimpleOnGestureListener j = new GestureDetector$SimpleOnGestureListener();

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return this.j.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return this.j.onDoubleTapEvent(motionEvent);
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return this.j.onDown(motionEvent);
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.j.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.j.onLongPress(motionEvent);
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.j.onScroll(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        this.j.onShowPress(motionEvent);
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return this.j.onSingleTapConfirmed(motionEvent);
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.j.onSingleTapUp(motionEvent);
    }
}
