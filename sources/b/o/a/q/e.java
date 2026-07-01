package b.o.a.q;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraView$b;

/* JADX INFO: compiled from: PinchGestureFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends c {
    public ScaleGestureDetector d;
    public boolean e;
    public float f;

    public e(@NonNull c$a c_a) {
        super(c_a, 2);
        this.f = 0.0f;
        this.f1947b = a.j;
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(((CameraView$b) c_a).g(), new e$a(this));
        this.d = scaleGestureDetector;
        scaleGestureDetector.setQuickScaleEnabled(false);
    }

    @Override // b.o.a.q.c
    public float b(float f, float f2, float f3) {
        return b.d.b.a.a.a(f3, f2, this.f, f);
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
