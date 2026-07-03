package p007b.p452o.p453a.p467r;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.CameraView;
import p007b.p452o.p453a.RunnableC5111j;
import p007b.p452o.p453a.p455n.p461t.C5170a;

/* JADX INFO: renamed from: b.o.a.r.f */
/* JADX INFO: compiled from: OrientationHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5205f {

    /* JADX INFO: renamed from: b */
    public final Context f14118b;

    /* JADX INFO: renamed from: c */
    public final c f14119c;

    /* JADX INFO: renamed from: d */
    @VisibleForTesting
    public final OrientationEventListener f14120d;

    /* JADX INFO: renamed from: h */
    public boolean f14124h;

    /* JADX INFO: renamed from: a */
    public final Handler f14117a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e */
    public int f14121e = -1;

    /* JADX INFO: renamed from: g */
    public int f14123g = -1;

    /* JADX INFO: renamed from: f */
    @VisibleForTesting
    public final DisplayManager.DisplayListener f14122f = new b();

    /* JADX INFO: renamed from: b.o.a.r.f$a */
    /* JADX INFO: compiled from: OrientationHelper.java */
    public class a extends OrientationEventListener {
        public a(Context context, int i) {
            super(context, i);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x002d  */
        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            int i2;
            if (i == -1) {
                i2 = C5205f.this.f14121e;
                if (i2 == -1) {
                    i2 = 0;
                }
            } else if (i >= 315 || i < 45) {
                i2 = 0;
            } else if (i >= 45 && i < 135) {
                i2 = 90;
            } else if (i >= 135 && i < 225) {
                i2 = 180;
            } else if (i < 225 || i >= 315) {
                i2 = 0;
            } else {
                i2 = 270;
            }
            C5205f c5205f = C5205f.this;
            if (i2 != c5205f.f14121e) {
                c5205f.f14121e = i2;
                CameraView.C11195b c11195b = (CameraView.C11195b) c5205f.f14119c;
                c11195b.f22141b.m7159a(1, "onDeviceOrientationChanged", Integer.valueOf(i2));
                CameraView cameraView = CameraView.this;
                int i3 = cameraView.f22137y.f14123g;
                if (cameraView.f22125m) {
                    C5170a c5170aMo7281e = cameraView.f22138z.mo7281e();
                    c5170aMo7281e.m7360e(i2);
                    c5170aMo7281e.f13999e = i2;
                    c5170aMo7281e.m7359d();
                } else {
                    int i4 = (360 - i3) % 360;
                    C5170a c5170aMo7281e2 = cameraView.f22138z.mo7281e();
                    c5170aMo7281e2.m7360e(i4);
                    c5170aMo7281e2.f13999e = i4;
                    c5170aMo7281e2.m7359d();
                }
                CameraView.this.f22133u.post(new RunnableC5111j(c11195b, (i2 + i3) % 360));
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.r.f$b */
    /* JADX INFO: compiled from: OrientationHelper.java */
    public class b implements DisplayManager.DisplayListener {
        public b() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            C5205f c5205f = C5205f.this;
            int i2 = c5205f.f14123g;
            int iM7401a = c5205f.m7401a();
            if (iM7401a != i2) {
                C5205f c5205f2 = C5205f.this;
                c5205f2.f14123g = iM7401a;
                CameraView.C11195b c11195b = (CameraView.C11195b) c5205f2.f14119c;
                if (CameraView.this.m9307d()) {
                    c11195b.f22141b.m7159a(2, "onDisplayOffsetChanged", "restarting the camera.");
                    CameraView.this.close();
                    CameraView.this.open();
                }
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }

    /* JADX INFO: renamed from: b.o.a.r.f$c */
    /* JADX INFO: compiled from: OrientationHelper.java */
    public interface c {
    }

    public C5205f(@NonNull Context context, @NonNull c cVar) {
        this.f14118b = context;
        this.f14119c = cVar;
        this.f14120d = new a(context.getApplicationContext(), 3);
    }

    /* JADX INFO: renamed from: a */
    public final int m7401a() {
        int rotation = ((WindowManager) this.f14118b.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }
}
