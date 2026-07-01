package b.o.a.n.r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.o.a.CameraLogger;
import b.o.a.n.Camera2Engine;
import b.o.a.n.o.ActionHolder;

/* JADX INFO: renamed from: b.o.a.n.r.d, reason: use source file name */
/* JADX INFO: compiled from: ExposureReset.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class ExposureReset extends BaseReset {
    public static final CameraLogger f = new CameraLogger(ExposureReset.class.getSimpleName());

    public ExposureReset() {
        super(true);
    }

    @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
    public void b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        if (this.f1935b == 0) {
            ((Camera2Engine) actionHolder).f1921i0.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
            ((Camera2Engine) actionHolder).k1();
            l(Integer.MAX_VALUE);
        }
    }

    @Override // b.o.a.n.r.BaseReset
    public void m(@NonNull ActionHolder actionHolder, @Nullable MeteringRectangle meteringRectangle) {
        int iIntValue = ((Integer) k(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue();
        if (meteringRectangle != null && iIntValue > 0) {
            ((Camera2Engine) actionHolder).f1921i0.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{meteringRectangle});
        }
        TotalCaptureResult totalCaptureResult = ((Camera2Engine) actionHolder).f1922j0;
        Integer num = totalCaptureResult == null ? null : (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        CameraLogger cameraLogger = f;
        cameraLogger.a(1, "onStarted:", "last precapture trigger is", num);
        if (num != null && num.intValue() == 1) {
            cameraLogger.a(1, "onStarted:", "canceling precapture.");
            ((Camera2Engine) actionHolder).f1921i0.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(Build.VERSION.SDK_INT < 23 ? 0 : 2));
        }
        Camera2Engine camera2Engine = (Camera2Engine) actionHolder;
        camera2Engine.f1921i0.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
        camera2Engine.k1();
        l(0);
    }
}
