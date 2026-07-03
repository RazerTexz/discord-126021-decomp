package p007b.p452o.p453a.p466q;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraView;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p452o.p453a.p466q.AbstractC5195c;

/* JADX INFO: renamed from: b.o.a.q.e */
/* JADX INFO: compiled from: PinchGestureFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5197e extends AbstractC5195c {

    /* JADX INFO: renamed from: d */
    public ScaleGestureDetector f14087d;

    /* JADX INFO: renamed from: e */
    public boolean f14088e;

    /* JADX INFO: renamed from: f */
    public float f14089f;

    /* JADX INFO: renamed from: b.o.a.q.e$a */
    /* JADX INFO: compiled from: PinchGestureFinder.java */
    public class a extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public a() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            C5197e c5197e = C5197e.this;
            c5197e.f14088e = true;
            c5197e.f14089f = (scaleGestureDetector.getScaleFactor() - 1.0f) * 2.0f;
            return true;
        }
    }

    public C5197e(@NonNull AbstractC5195c.a aVar) {
        super(aVar, 2);
        this.f14089f = 0.0f;
        this.f14082b = EnumC5193a.f14066j;
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(((CameraView.C11195b) aVar).m9317g(), new a());
        this.f14087d = scaleGestureDetector;
        scaleGestureDetector.setQuickScaleEnabled(false);
    }

    @Override // p007b.p452o.p453a.p466q.AbstractC5195c
    /* JADX INFO: renamed from: b */
    public float mo7393b(float f, float f2, float f3) {
        return C1643a.m839a(f3, f2, this.f14089f, f);
    }

    /* JADX INFO: renamed from: c */
    public boolean m7394c(@NonNull MotionEvent motionEvent) {
        boolean z2 = false;
        if (motionEvent.getAction() == 0) {
            this.f14088e = false;
        }
        this.f14087d.onTouchEvent(motionEvent);
        if (this.f14088e) {
            this.f14083c[0].x = motionEvent.getX(0);
            this.f14083c[0].y = motionEvent.getY(0);
            z2 = true;
            if (motionEvent.getPointerCount() > 1) {
                this.f14083c[1].x = motionEvent.getX(1);
                this.f14083c[1].y = motionEvent.getY(1);
            }
        }
        return z2;
    }
}
