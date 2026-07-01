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

/* JADX INFO: renamed from: b.o.a.n.p.c, reason: use source file name */
/* JADX INFO: compiled from: FocusLock.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class FocusLock extends BaseLock {
    public static final CameraLogger e = new CameraLogger(FocusLock.class.getSimpleName());

    @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
    public void b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
        e.a(1, "onCapture:", "afState:", num, "afMode:", num2);
        if (num == null || num2 == null || num2.intValue() != 1) {
            return;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0 || iIntValue == 2 || iIntValue == 4 || iIntValue == 5 || iIntValue == 6) {
            l(Integer.MAX_VALUE);
        }
    }

    @Override // b.o.a.n.p.BaseLock
    public boolean m(@NonNull ActionHolder actionHolder) {
        for (int i : (int[]) k(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0])) {
            if (i == 1) {
                return true;
            }
        }
        return false;
    }

    @Override // b.o.a.n.p.BaseLock
    public boolean n(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult totalCaptureResult = ((Camera2Engine) actionHolder).f1922j0;
        if (totalCaptureResult == null) {
            e.a(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        boolean z2 = num != null && (num.intValue() == 4 || num.intValue() == 5 || num.intValue() == 0 || num.intValue() == 2 || num.intValue() == 6);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
        boolean z3 = z2 && (num2 != null && num2.intValue() == 1);
        e.a(1, "checkShouldSkip:", Boolean.valueOf(z3));
        return z3;
    }

    @Override // b.o.a.n.p.BaseLock
    public void o(@NonNull ActionHolder actionHolder) {
        ((Camera2Engine) actionHolder).f1921i0.set(CaptureRequest.CONTROL_AF_MODE, 1);
        Camera2Engine camera2Engine = (Camera2Engine) actionHolder;
        camera2Engine.f1921i0.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        camera2Engine.k1();
    }
}
