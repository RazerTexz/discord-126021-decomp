package b.o.a.n.r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: compiled from: FocusMeter.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class e extends a {
    public static final b.o.a.b i = new b.o.a.b(e.class.getSimpleName());

    public e(@NonNull List<MeteringRectangle> list, boolean z2) {
        super(list, z2);
    }

    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void b(@NonNull b.o.a.n.o.c cVar, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        i.a(1, "onCaptureCompleted:", "afState:", num);
        if (num == null) {
            return;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 4) {
            this.g = true;
            l(Integer.MAX_VALUE);
        } else {
            if (iIntValue != 5) {
                return;
            }
            this.g = false;
            l(Integer.MAX_VALUE);
        }
    }

    @Override // b.o.a.n.o.e
    public void i(@NonNull b.o.a.n.o.c cVar) {
        ((b.o.a.n.d) cVar).f1921i0.set(CaptureRequest.CONTROL_AF_TRIGGER, null);
    }

    @Override // b.o.a.n.r.a
    public boolean m(@NonNull b.o.a.n.o.c cVar) {
        Integer num = (Integer) ((b.o.a.n.d) cVar).f1921i0.get(CaptureRequest.CONTROL_AF_MODE);
        boolean z2 = num != null && (num.intValue() == 1 || num.intValue() == 4 || num.intValue() == 3 || num.intValue() == 2);
        i.a(1, "checkIsSupported:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // b.o.a.n.r.a
    public boolean n(@NonNull b.o.a.n.o.c cVar) {
        TotalCaptureResult totalCaptureResult = ((b.o.a.n.d) cVar).f1922j0;
        if (totalCaptureResult == null) {
            i.a(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        boolean z2 = num != null && (num.intValue() == 4 || num.intValue() == 2);
        i.a(1, "checkShouldSkip:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // b.o.a.n.r.a
    public void o(@NonNull b.o.a.n.o.c cVar, @NonNull List<MeteringRectangle> list) {
        i.a(1, "onStarted:", "with areas:", list);
        ((b.o.a.n.d) cVar).f1921i0.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        int iIntValue = ((Integer) k(CameraCharacteristics.CONTROL_MAX_REGIONS_AF, 0)).intValue();
        if (!list.isEmpty() && iIntValue > 0) {
            ((b.o.a.n.d) cVar).f1921i0.set(CaptureRequest.CONTROL_AF_REGIONS, (MeteringRectangle[]) list.subList(0, Math.min(iIntValue, list.size())).toArray(new MeteringRectangle[0]));
        }
        ((b.o.a.n.d) cVar).k1();
    }
}
