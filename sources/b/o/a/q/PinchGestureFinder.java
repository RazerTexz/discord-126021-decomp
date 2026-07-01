package b.o.a.q;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.o.a.q.GestureFinder;
import com.otaliastudios.cameraview.CameraView;

/* JADX INFO: renamed from: b.o.a.q.e, reason: use source file name */
/* JADX INFO: compiled from: PinchGestureFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public class PinchGestureFinder extends GestureFinder {
    public ScaleGestureDetector d;
    public boolean e;
    public float f;

    /* JADX INFO: renamed from: b.o.a.q.e$a */
    /* JADX INFO: compiled from: PinchGestureFinder.java */
    public class a extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public a() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            PinchGestureFinder pinchGestureFinder = PinchGestureFinder.this;
            pinchGestureFinder.e = true;
            pinchGestureFinder.f = (scaleGestureDetector.getScaleFactor() - 1.0f) * 2.0f;
            return true;
        }
    }

    public PinchGestureFinder(@NonNull GestureFinder.a aVar) {
        super(aVar, 2);
        this.f = 0.0f;
        this.f1947b = Gesture.j;
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(((CameraView.b) aVar).g(), new a());
        this.d = scaleGestureDetector;
        scaleGestureDetector.setQuickScaleEnabled(false);
    }

    @Override // b.o.a.q.GestureFinder
    public float b(float f, float f2, float f3) {
        return outline.a(f3, f2, this.f, f);
    }

    public boolean c(@NonNull MotionEvent motionEvent) {
        boolean z2 = false;
        if (motionEvent.getAction() == 0) {
            this.e = false;
        }
        this.d.onTouchEvent(motionEvent);
        if (this.e) {
            this.c[0].x = motionEvent.getX(0);
            this.c[0].y = motionEvent.getY(0);
            z2 = true;
            if (motionEvent.getPointerCount() > 1) {
                this.c[1].x = motionEvent.getX(1);
                this.c[1].y = motionEvent.getY(1);
            }
        }
        return z2;
    }
}
