package b.o.a.n.r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.o.a.CameraLogger;
import b.o.a.n.Camera2Engine;
import b.o.a.n.o.ActionHolder;

/* JADX INFO: renamed from: b.o.a.n.r.j, reason: use source file name */
/* JADX INFO: compiled from: WhiteBalanceReset.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class WhiteBalanceReset extends BaseReset {
    public static final CameraLogger f = new CameraLogger(WhiteBalanceReset.class.getSimpleName());

    public WhiteBalanceReset() {
        super(true);
    }

    @Override // b.o.a.n.r.BaseReset
    public void m(@NonNull ActionHolder actionHolder, @Nullable MeteringRectangle meteringRectangle) {
        f.a(2, "onStarted:", "with area:", meteringRectangle);
        int iIntValue = ((Integer) k(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB, 0)).intValue();
        if (meteringRectangle != null && iIntValue > 0) {
            ((Camera2Engine) actionHolder).f1921i0.set(CaptureRequest.CONTROL_AWB_REGIONS, new MeteringRectangle[]{meteringRectangle});
            ((Camera2Engine) actionHolder).k1();
        }
        l(Integer.MAX_VALUE);
    }
}
