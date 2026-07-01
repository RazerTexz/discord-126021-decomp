package b.o.a.q;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import b.o.a.CameraLogger;
import b.o.a.q.GestureFinder;
import com.otaliastudios.cameraview.CameraView;

/* JADX INFO: renamed from: b.o.a.q.f, reason: use source file name */
/* JADX INFO: compiled from: ScrollGestureFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public class ScrollGestureFinder extends GestureFinder {
    public static final CameraLogger d = new CameraLogger(ScrollGestureFinder.class.getSimpleName());
    public GestureDetector e;
    public boolean f;
    public float g;

    /* JADX INFO: renamed from: b.o.a.q.f$a */
    /* JADX INFO: compiled from: ScrollGestureFinder.java */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ GestureFinder.a j;

        public a(GestureFinder.a aVar) {
            this.j = aVar;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0064  */
        /* JADX WARN: Code duplicated, block: B:16:0x0070  */
        /* JADX WARN: Code duplicated, block: B:17:0x0072  */
        /* JADX WARN: Code duplicated, block: B:21:0x0078  */
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            boolean z2;
            Gesture gesture = Gesture.m;
            boolean z3 = false;
            ScrollGestureFinder.d.a(1, "onScroll:", "distanceX=" + f, "distanceY=" + f2);
            if (motionEvent == null || motionEvent2 == null) {
                return false;
            }
            if (motionEvent.getX() == ScrollGestureFinder.this.c[0].x) {
                float y2 = motionEvent.getY();
                ScrollGestureFinder scrollGestureFinder = ScrollGestureFinder.this;
                if (y2 != scrollGestureFinder.c[0].y) {
                    if (Math.abs(f) >= Math.abs(f2)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    ScrollGestureFinder scrollGestureFinder2 = ScrollGestureFinder.this;
                    if (!z2) {
                        gesture = Gesture.n;
                    }
                    scrollGestureFinder2.f1947b = gesture;
                    scrollGestureFinder2.c[0].set(motionEvent.getX(), motionEvent.getY());
                    z3 = z2;
                } else if (scrollGestureFinder.f1947b == gesture) {
                    z3 = true;
                }
            } else {
                if (Math.abs(f) >= Math.abs(f2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ScrollGestureFinder scrollGestureFinder3 = ScrollGestureFinder.this;
                if (!z2) {
                    gesture = Gesture.n;
                }
                scrollGestureFinder3.f1947b = gesture;
                scrollGestureFinder3.c[0].set(motionEvent.getX(), motionEvent.getY());
                z3 = z2;
            }
            ScrollGestureFinder.this.c[1].set(motionEvent2.getX(), motionEvent2.getY());
            ScrollGestureFinder.this.g = z3 ? f / CameraView.this.getWidth() : f2 / CameraView.this.getHeight();
            ScrollGestureFinder scrollGestureFinder4 = ScrollGestureFinder.this;
            scrollGestureFinder4.g = z3 ? -scrollGestureFinder4.g : scrollGestureFinder4.g;
            scrollGestureFinder4.f = true;
            return true;
        }
    }

    public ScrollGestureFinder(@NonNull GestureFinder.a aVar) {
        super(aVar, 2);
        CameraView.b bVar = (CameraView.b) aVar;
        GestureDetector gestureDetector = new GestureDetector(bVar.g(), new a(bVar));
        this.e = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
    }

    @Override // b.o.a.q.GestureFinder
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
