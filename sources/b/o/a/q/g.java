package b.o.a.q;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraView$b;

/* JADX INFO: compiled from: TapGestureFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends c {
    public GestureDetector d;
    public boolean e;

    public g(@NonNull c$a c_a) {
        super(c_a, 1);
        GestureDetector gestureDetector = new GestureDetector(((CameraView$b) c_a).g(), new g$a(this));
        this.d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
    }

    @Override // b.o.a.q.c
    public float b(float f, float f2, float f3) {
        return 0.0f;
    }

    public boolean c(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.e = false;
        }
        this.d.onTouchEvent(motionEvent);
        if (!this.e) {
            return false;
        }
        this.c[0].x = motionEvent.getX();
        this.c[0].y = motionEvent.getY();
        return true;
    }
}
