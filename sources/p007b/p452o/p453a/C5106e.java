package p007b.p452o.p453a;

import android.hardware.Camera;
import androidx.annotation.NonNull;
import java.util.Objects;
import p007b.p452o.p453a.p454m.EnumC5118e;
import p007b.p452o.p453a.p455n.p458q.C5156a;

/* JADX INFO: renamed from: b.o.a.e */
/* JADX INFO: compiled from: CameraUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5106e {

    /* JADX INFO: renamed from: a */
    public static final C5103b f13705a = new C5103b(C5106e.class.getSimpleName());

    /* JADX INFO: renamed from: a */
    public static boolean m7164a(@NonNull EnumC5118e enumC5118e) {
        Objects.requireNonNull(C5156a.m7346a());
        int iIntValue = C5156a.f13959d.get(enumC5118e).intValue();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == iIntValue) {
                return true;
            }
        }
        return false;
    }
}
