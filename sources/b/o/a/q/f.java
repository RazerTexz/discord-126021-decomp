package b.o.a.q;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraView$b;

/* JADX INFO: compiled from: ScrollGestureFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends c {
    public static final b.o.a.b d = new b.o.a.b(f.class.getSimpleName());
    public GestureDetector e;
    public boolean f;
    public float g;

    public f(@NonNull c$a c_a) {
        super(c_a, 2);
        CameraView$b cameraView$b = (CameraView$b) c_a;
        GestureDetector gestureDetector = new GestureDetector(cameraView$b.g(), new f$a(this, cameraView$b));
        this.e = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
    }

    @Override // b.o.a.q.c
    public float b(float f, float f2, float f3) {
        return ((f3 - f2) * this.g * 2.0f) + f;
    }

    public boolean c(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f = false;
        }
        this.e.onTouchEvent(motionEvent);
        if (this.f) {
            d.a(1, "Notifying a gesture of type", this.f1947b.name());
        }
        return this.f;
    }
}
