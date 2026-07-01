package b.o.a.r;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import b.o.a.CameraView6;
import b.o.a.n.t.Angles;
import com.otaliastudios.cameraview.CameraView;

/* JADX INFO: renamed from: b.o.a.r.f, reason: use source file name */
/* JADX INFO: compiled from: OrientationHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class OrientationHelper2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1951b;
    public final c c;

    @VisibleForTesting
    public final OrientationEventListener d;
    public boolean h;
    public final Handler a = new Handler(Looper.getMainLooper());
    public int e = -1;
    public int g = -1;

    @VisibleForTesting
    public final DisplayManager.DisplayListener f = new b();

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
                i2 = OrientationHelper2.this.e;
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
            OrientationHelper2 orientationHelper2 = OrientationHelper2.this;
            if (i2 != orientationHelper2.e) {
                orientationHelper2.e = i2;
                CameraView.b bVar = (CameraView.b) orientationHelper2.c;
                bVar.f3177b.a(1, "onDeviceOrientationChanged", Integer.valueOf(i2));
                CameraView cameraView = CameraView.this;
                int i3 = cameraView.f3175y.g;
                if (cameraView.m) {
                    Angles anglesE = cameraView.f3176z.e();
                    anglesE.e(i2);
                    anglesE.e = i2;
                    anglesE.d();
                } else {
                    int i4 = (360 - i3) % 360;
                    Angles anglesE2 = cameraView.f3176z.e();
                    anglesE2.e(i4);
                    anglesE2.e = i4;
                    anglesE2.d();
                }
                CameraView.this.u.post(new CameraView6(bVar, (i2 + i3) % 360));
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
            OrientationHelper2 orientationHelper2 = OrientationHelper2.this;
            int i2 = orientationHelper2.g;
            int iA = orientationHelper2.a();
            if (iA != i2) {
                OrientationHelper2 orientationHelper3 = OrientationHelper2.this;
                orientationHelper3.g = iA;
                CameraView.b bVar = (CameraView.b) orientationHelper3.c;
                if (CameraView.this.d()) {
                    bVar.f3177b.a(2, "onDisplayOffsetChanged", "restarting the camera.");
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

    public OrientationHelper2(@NonNull Context context, @NonNull c cVar) {
        this.f1951b = context;
        this.c = cVar;
        this.d = new a(context.getApplicationContext(), 3);
    }

    public final int a() {
        int rotation = ((WindowManager) this.f1951b.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }
}
