package b.o.a.n.p;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: WhiteBalanceLock.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class e extends a {
    public static final b.o.a.b e = new b.o.a.b(e.class.getSimpleName());

    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void b(@NonNull b.o.a.n.o.c cVar, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        e.a(1, "processCapture:", "awbState:", num);
        if (num != null && num.intValue() == 3) {
            l(Integer.MAX_VALUE);
        }
    }

    @Override // b.o.a.n.p.a
    public boolean m(@NonNull b.o.a.n.o.c cVar) {
        boolean z2 = ((Integer) k(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        Integer num = (Integer) ((b.o.a.n.d) cVar).f1921i0.get(CaptureRequest.CONTROL_AWB_MODE);
        boolean z3 = z2 && num != null && num.intValue() == 1;
        e.a(1, "checkIsSupported:", Boolean.valueOf(z3));
        return z3;
    }

    @Override // b.o.a.n.p.a
    public boolean n(@NonNull b.o.a.n.o.c cVar) {
        TotalCaptureResult totalCaptureResult = ((b.o.a.n.d) cVar).f1922j0;
        if (totalCaptureResult == null) {
            e.a(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        boolean z2 = num != null && num.intValue() == 3;
        e.a(1, "checkShouldSkip:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // b.o.a.n.p.a
    public void o(@NonNull b.o.a.n.o.c cVar) {
        ((b.o.a.n.d) cVar).f1921i0.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.TRUE);
        ((b.o.a.n.d) cVar).k1();
    }
}
