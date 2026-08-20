package p007b.p452o.p453a.p466q;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraView;
import p007b.p452o.p453a.C5103b;

/* JADX INFO: renamed from: b.o.a.q.f */
/* JADX INFO: compiled from: ScrollGestureFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5198f extends AbstractC5195c {

    /* JADX INFO: renamed from: d */
    public static final C5103b f14091d = new C5103b(C5198f.class.getSimpleName());

    /* JADX INFO: renamed from: e */
    public GestureDetector f14092e;

    /* JADX INFO: renamed from: f */
    public boolean f14093f;

    /* JADX INFO: renamed from: g */
    public float f14094g;

    /* JADX INFO: renamed from: b.o.a.q.f$a */
    /* JADX INFO: compiled from: ScrollGestureFinder.java */
    public class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ AbstractC5195c.a f14095j;

        public a(AbstractC5195c.a aVar) {
            this.f14095j = aVar;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0064  */
        /* JADX WARN: Code duplicated, block: B:16:0x0070  */
        /* JADX WARN: Code duplicated, block: B:17:0x0072  */
        /* JADX WARN: Code duplicated, block: B:21:0x0078  */
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            boolean z2;
            EnumC5193a enumC5193a = EnumC5193a.f14069m;
            boolean z3 = false;
            C5198f.f14091d.m7159a(1, "onScroll:", "distanceX=" + f, "distanceY=" + f2);
            if (motionEvent == null || motionEvent2 == null) {
                return false;
            }
            if (motionEvent.getX() == C5198f.this.f14083c[0].x) {
                float y2 = motionEvent.getY();
                C5198f c5198f = C5198f.this;
                if (y2 != c5198f.f14083c[0].y) {
                    if (Math.abs(f) >= Math.abs(f2)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    C5198f c5198f2 = C5198f.this;
                    if (!z2) {
                        enumC5193a = EnumC5193a.f14070n;
                    }
                    c5198f2.f14082b = enumC5193a;
                    c5198f2.f14083c[0].set(motionEvent.getX(), motionEvent.getY());
                    z3 = z2;
                } else if (c5198f.f14082b == enumC5193a) {
                    z3 = true;
                }
            } else {
                if (Math.abs(f) >= Math.abs(f2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                C5198f c5198f3 = C5198f.this;
                if (!z2) {
                    enumC5193a = EnumC5193a.f14070n;
                }
                c5198f3.f14082b = enumC5193a;
                c5198f3.f14083c[0].set(motionEvent.getX(), motionEvent.getY());
                z3 = z2;
            }
            C5198f.this.f14083c[1].set(motionEvent2.getX(), motionEvent2.getY());
            C5198f.this.f14094g = z3 ? f / CameraView.this.getWidth() : f2 / CameraView.this.getHeight();
            C5198f c5198f4 = C5198f.this;
            c5198f4.f14094g = z3 ? -c5198f4.f14094g : c5198f4.f14094g;
            c5198f4.f14093f = true;
            return true;
        }
    }

    public C5198f(@NonNull AbstractC5195c.a aVar) {
        super(aVar, 2);
        CameraView.C11195b c11195b = (CameraView.C11195b) aVar;
        GestureDetector gestureDetector = new GestureDetector(c11195b.m9317g(), new a(c11195b));
        this.f14092e = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
    }

    @Override // p007b.p452o.p453a.p466q.AbstractC5195c
    /* JADX INFO: renamed from: b */
    public float mo7393b(float f, float f2, float f3) {
        return ((f3 - f2) * this.f14094g * 2.0f) + f;
    }

    /* JADX INFO: renamed from: c */
    public boolean m7395c(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f14093f = false;
        }
        this.f14092e.onTouchEvent(motionEvent);
        if (this.f14093f) {
            f14091d.m7159a(1, "Notifying a gesture of type", this.f14082b.name());
        }
        return this.f14093f;
    }
}
