package b.o.a.n.r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: compiled from: WhiteBalanceMeter.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class i extends a {
    public static final b.o.a.b i = new b.o.a.b(i.class.getSimpleName());

    public i(@NonNull List<MeteringRectangle> list, boolean z2) {
        super(list, z2);
    }

    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void b(@NonNull b.o.a.n.o.c cVar, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        i.a(1, "onCaptureCompleted:", "awbState:", num);
        if (num == null) {
            return;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 2) {
            this.g = true;
            l(Integer.MAX_VALUE);
        } else {
            if (iIntValue != 3) {
                return;
            }
            this.g = false;
            l(Integer.MAX_VALUE);
        }
    }

    @Override // b.o.a.n.r.a
    public boolean m(@NonNull b.o.a.n.o.c cVar) {
        boolean z2 = ((Integer) k(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        Integer num = (Integer) ((b.o.a.n.d) cVar).f1921i0.get(CaptureRequest.CONTROL_AWB_MODE);
        boolean z3 = z2 && num != null && num.intValue() == 1;
        i.a(1, "checkIsSupported:", Boolean.valueOf(z3));
        return z3;
    }

    @Override // b.o.a.n.r.a
    public boolean n(@NonNull b.o.a.n.o.c cVar) {
        TotalCaptureResult totalCaptureResult = ((b.o.a.n.d) cVar).f1922j0;
        if (totalCaptureResult == null) {
            i.a(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        boolean z2 = num != null && num.intValue() == 2;
        i.a(1, "checkShouldSkip:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // b.o.a.n.r.a
    public void o(@NonNull b.o.a.n.o.c cVar, @NonNull List<MeteringRectangle> list) {
        i.a(1, "onStarted:", "with areas:", list);
        int iIntValue = ((Integer) k(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB, 0)).intValue();
        if (list.isEmpty() || iIntValue <= 0) {
            return;
        }
        ((b.o.a.n.d) cVar).f1921i0.set(CaptureRequest.CONTROL_AWB_REGIONS, (MeteringRectangle[]) list.subList(0, Math.min(iIntValue, list.size())).toArray(new MeteringRectangle[0]));
        ((b.o.a.n.d) cVar).k1();
    }
}
