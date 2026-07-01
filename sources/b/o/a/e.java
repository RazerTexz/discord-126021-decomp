package b.o.a;

import android.hardware.Camera;
import android.hardware.Camera$CameraInfo;
import androidx.annotation.NonNull;
import java.util.Objects;

/* JADX INFO: compiled from: CameraUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static final b a = new b(e.class.getSimpleName());

    public static boolean a(@NonNull b.o.a.m.e eVar) {
        Objects.requireNonNull(b.o.a.n.q.a.a());
        int iIntValue = b.o.a.n.q.a.d.get(eVar).intValue();
        Camera$CameraInfo camera$CameraInfo = new Camera$CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, camera$CameraInfo);
            if (camera$CameraInfo.facing == iIntValue) {
                return true;
            }
        }
        return false;
    }
}
