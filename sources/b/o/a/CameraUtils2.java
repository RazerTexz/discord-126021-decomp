package b.o.a;

import android.hardware.Camera;
import androidx.annotation.NonNull;
import b.o.a.m.Facing;
import b.o.a.n.q.Camera1Mapper;
import java.util.Objects;

/* JADX INFO: renamed from: b.o.a.e, reason: use source file name */
/* JADX INFO: compiled from: CameraUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraUtils2 {
    public static final CameraLogger a = new CameraLogger(CameraUtils2.class.getSimpleName());

    public static boolean a(@NonNull Facing facing) {
        Objects.requireNonNull(Camera1Mapper.a());
        int iIntValue = Camera1Mapper.d.get(facing).intValue();
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
