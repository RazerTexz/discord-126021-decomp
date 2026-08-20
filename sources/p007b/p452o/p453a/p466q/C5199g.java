package p007b.p452o.p453a.p466q;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraView;

/* JADX INFO: renamed from: b.o.a.q.g */
/* JADX INFO: compiled from: TapGestureFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5199g extends AbstractC5195c {

    /* JADX INFO: renamed from: d */
    public GestureDetector f14097d;

    /* JADX INFO: renamed from: e */
    public boolean f14098e;

    /* JADX INFO: renamed from: b.o.a.q.g$a */
    /* JADX INFO: compiled from: TapGestureFinder.java */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            C5199g c5199g = C5199g.this;
            c5199g.f14098e = true;
            c5199g.f14082b = EnumC5193a.f14068l;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            C5199g c5199g = C5199g.this;
            c5199g.f14098e = true;
            c5199g.f14082b = EnumC5193a.f14067k;
            return true;
        }
    }

    public C5199g(@NonNull AbstractC5195c.a aVar) {
        super(aVar, 1);
        GestureDetector gestureDetector = new GestureDetector(((CameraView.C11195b) aVar).m9317g(), new a());
        this.f14097d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
    }

    @Override // p007b.p452o.p453a.p466q.AbstractC5195c
    /* JADX INFO: renamed from: b */
    public float mo7393b(float f, float f2, float f3) {
        return 0.0f;
    }

    /* JADX INFO: renamed from: c */
    public boolean m7396c(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f14098e = false;
        }
        this.f14097d.onTouchEvent(motionEvent);
        if (!this.f14098e) {
            return false;
        }
        this.f14083c[0].x = motionEvent.getX();
        this.f14083c[0].y = motionEvent.getY();
        return true;
    }
}
