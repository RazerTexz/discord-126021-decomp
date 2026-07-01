package b.o.a.n.p;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: FocusLock.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class c extends a {
    public static final b.o.a.b e = new b.o.a.b(c.class.getSimpleName());

    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void b(@NonNull b.o.a.n.o.c cVar, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
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

    @Override // b.o.a.n.p.a
    public boolean m(@NonNull b.o.a.n.o.c cVar) {
        for (int i : (int[]) k(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0])) {
            if (i == 1) {
                return true;
            }
        }
        return false;
    }

    @Override // b.o.a.n.p.a
    public boolean n(@NonNull b.o.a.n.o.c cVar) {
        TotalCaptureResult totalCaptureResult = ((b.o.a.n.d) cVar).f1922j0;
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

    @Override // b.o.a.n.p.a
    public void o(@NonNull b.o.a.n.o.c cVar) {
        ((b.o.a.n.d) cVar).f1921i0.set(CaptureRequest.CONTROL_AF_MODE, 1);
        b.o.a.n.d dVar = (b.o.a.n.d) cVar;
        dVar.f1921i0.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        dVar.k1();
    }
}
