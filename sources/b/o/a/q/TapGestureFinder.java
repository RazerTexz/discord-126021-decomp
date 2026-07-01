package b.o.a.q;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import b.o.a.q.GestureFinder;
import com.otaliastudios.cameraview.CameraView;

/* JADX INFO: renamed from: b.o.a.q.g, reason: use source file name */
/* JADX INFO: compiled from: TapGestureFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public class TapGestureFinder extends GestureFinder {
    public GestureDetector d;
    public boolean e;

    /* JADX INFO: renamed from: b.o.a.q.g$a */
    /* JADX INFO: compiled from: TapGestureFinder.java */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            TapGestureFinder tapGestureFinder = TapGestureFinder.this;
            tapGestureFinder.e = true;
            tapGestureFinder.f1947b = Gesture.l;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            TapGestureFinder tapGestureFinder = TapGestureFinder.this;
            tapGestureFinder.e = true;
            tapGestureFinder.f1947b = Gesture.k;
            return true;
        }
    }

    public TapGestureFinder(@NonNull GestureFinder.a aVar) {
        super(aVar, 1);
        GestureDetector gestureDetector = new GestureDetector(((CameraView.b) aVar).g(), new a());
        this.d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
    }

    @Override // b.o.a.q.GestureFinder
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
