package p007b.p225i.p226a.p242c.p260g3.p261z;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.Matrix;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.BinderThread;

/* JADX INFO: renamed from: b.i.a.c.g3.z.l */
/* JADX INFO: compiled from: TouchTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ViewOnTouchListenerC2800l extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, C2795g.a {

    /* JADX INFO: renamed from: l */
    public final a f7046l;

    /* JADX INFO: renamed from: m */
    public final float f7047m;

    /* JADX INFO: renamed from: n */
    public final GestureDetector f7048n;

    /* JADX INFO: renamed from: j */
    public final PointF f7044j = new PointF();

    /* JADX INFO: renamed from: k */
    public final PointF f7045k = new PointF();

    /* JADX INFO: renamed from: o */
    public volatile float f7049o = 3.1415927f;

    /* JADX INFO: renamed from: b.i.a.c.g3.z.l$a */
    /* JADX INFO: compiled from: TouchTracker.java */
    public interface a {
    }

    public ViewOnTouchListenerC2800l(Context context, a aVar, float f) {
        this.f7046l = aVar;
        this.f7047m = f;
        this.f7048n = new GestureDetector(context, this);
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.p261z.C2795g.a
    @BinderThread
    /* JADX INFO: renamed from: a */
    public void mo3199a(float[] fArr, float f) {
        this.f7049o = -f;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f7044j.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float x2 = (motionEvent2.getX() - this.f7044j.x) / this.f7047m;
        float y2 = motionEvent2.getY();
        PointF pointF = this.f7044j;
        float f3 = (y2 - pointF.y) / this.f7047m;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d = this.f7049o;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        PointF pointF2 = this.f7045k;
        pointF2.x -= (fCos * x2) - (fSin * f3);
        float f4 = (fCos * f3) + (fSin * x2) + pointF2.y;
        pointF2.y = f4;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f4));
        a aVar = this.f7046l;
        PointF pointF3 = this.f7045k;
        C2799k.a aVar2 = (C2799k.a) aVar;
        synchronized (aVar2) {
            aVar2.f7039p = pointF3.y;
            aVar2.m3203b();
            Matrix.setRotateM(aVar2.f7038o, 0, -pointF3.x, 0.0f, 1.0f, 0.0f);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return C2799k.this.performClick();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f7048n.onTouchEvent(motionEvent);
    }
}
