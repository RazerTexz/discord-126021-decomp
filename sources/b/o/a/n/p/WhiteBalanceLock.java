package b.o.a.n.p;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.o.a.CameraLogger;
import b.o.a.n.Camera2Engine;
import b.o.a.n.o.ActionHolder;

/* JADX INFO: renamed from: b.o.a.n.p.e, reason: use source file name */
/* JADX INFO: compiled from: WhiteBalanceLock.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class WhiteBalanceLock extends BaseLock {
    public static final CameraLogger e = new CameraLogger(WhiteBalanceLock.class.getSimpleName());

    @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
    public void b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        e.a(1, "processCapture:", "awbState:", num);
        if (num != null && num.intValue() == 3) {
            l(Integer.MAX_VALUE);
        }
    }

    @Override // b.o.a.n.p.BaseLock
    public boolean m(@NonNull ActionHolder actionHolder) {
        boolean z2 = ((Integer) k(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        Integer num = (Integer) ((Camera2Engine) actionHolder).f1921i0.get(CaptureRequest.CONTROL_AWB_MODE);
        boolean z3 = z2 && num != null && num.intValue() == 1;
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
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        boolean z2 = num != null && num.intValue() == 3;
        e.a(1, "checkShouldSkip:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // b.o.a.n.p.BaseLock
    public void o(@NonNull ActionHolder actionHolder) {
        ((Camera2Engine) actionHolder).f1921i0.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.TRUE);
        ((Camera2Engine) actionHolder).k1();
    }
}
