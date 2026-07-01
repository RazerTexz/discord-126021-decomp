package b.i.a.c.g3.z;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.Matrix;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.BinderThread;
import b.i.a.c.g3.z.OrientationListener;
import b.i.a.c.g3.z.SphericalGLSurfaceView;

/* JADX INFO: renamed from: b.i.a.c.g3.z.l, reason: use source file name */
/* JADX INFO: compiled from: TouchTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TouchTracker extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, OrientationListener.a {
    public final a l;
    public final float m;
    public final GestureDetector n;
    public final PointF j = new PointF();
    public final PointF k = new PointF();
    public volatile float o = 3.1415927f;

    /* JADX INFO: renamed from: b.i.a.c.g3.z.l$a */
    /* JADX INFO: compiled from: TouchTracker.java */
    public interface a {
    }

    public TouchTracker(Context context, a aVar, float f) {
        this.l = aVar;
        this.m = f;
        this.n = new GestureDetector(context, this);
    }

    @Override // b.i.a.c.g3.z.OrientationListener.a
    @BinderThread
    public void a(float[] fArr, float f) {
        this.o = -f;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.j.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float x2 = (motionEvent2.getX() - this.j.x) / this.m;
        float y2 = motionEvent2.getY();
        PointF pointF = this.j;
        float f3 = (y2 - pointF.y) / this.m;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d = this.o;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        PointF pointF2 = this.k;
        pointF2.x -= (fCos * x2) - (fSin * f3);
        float f4 = (fCos * f3) + (fSin * x2) + pointF2.y;
        pointF2.y = f4;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f4));
        a aVar = this.l;
        PointF pointF3 = this.k;
        SphericalGLSurfaceView.a aVar2 = (SphericalGLSurfaceView.a) aVar;
        synchronized (aVar2) {
            aVar2.p = pointF3.y;
            aVar2.b();
            Matrix.setRotateM(aVar2.o, 0, -pointF3.x, 0.0f, 1.0f, 0.0f);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return SphericalGLSurfaceView.this.performClick();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.n.onTouchEvent(motionEvent);
    }
}
