package b.o.a.n.p;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.o.a.CameraLogger;
import b.o.a.n.Camera2Engine;
import b.o.a.n.o.ActionHolder;

/* JADX INFO: renamed from: b.o.a.n.p.b, reason: use source file name */
/* JADX INFO: compiled from: ExposureLock.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class ExposureLock extends BaseLock {
    public static final CameraLogger e = new CameraLogger(ExposureLock.class.getSimpleName());

    @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
    public void b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        e.a(1, "processCapture:", "aeState:", num);
        if (num != null && num.intValue() == 3) {
            l(Integer.MAX_VALUE);
        }
    }

    @Override // b.o.a.n.p.BaseLock
    public boolean m(@NonNull ActionHolder actionHolder) {
        boolean z2 = ((Integer) k(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        Integer num = (Integer) ((Camera2Engine) actionHolder).f1921i0.get(CaptureRequest.CONTROL_AE_MODE);
        boolean z3 = z2 && (num != null && (num.intValue() == 1 || num.intValue() == 3 || num.intValue() == 2 || num.intValue() == 4 || num.intValue() == 5));
        e.a(1, "checkIsSupported:", Boolean.valueOf(z3));
        return z3;
    }

    @Override // b.o.a.n.p.BaseLock
    public boolean n(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult totalCaptureResult = ((Camera2Engine) actionHolder).f1922j0;
        if (totalCaptureResult == null) {
            e.a(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        boolean z2 = num != null && num.intValue() == 3;
        e.a(1, "checkShouldSkip:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // b.o.a.n.p.BaseLock
    public void o(@NonNull ActionHolder actionHolder) {
        ((Camera2Engine) actionHolder).f1921i0.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(Build.VERSION.SDK_INT >= 23 ? 2 : 0));
        Camera2Engine camera2Engine = (Camera2Engine) actionHolder;
        camera2Engine.f1921i0.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
        camera2Engine.k1();
    }
}
