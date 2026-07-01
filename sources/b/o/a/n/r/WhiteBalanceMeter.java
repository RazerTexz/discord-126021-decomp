package b.o.a.n.r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.o.a.CameraLogger;
import b.o.a.n.Camera2Engine;
import b.o.a.n.o.ActionHolder;
import java.util.List;

/* JADX INFO: renamed from: b.o.a.n.r.i, reason: use source file name */
/* JADX INFO: compiled from: WhiteBalanceMeter.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class WhiteBalanceMeter extends BaseMeter {
    public static final CameraLogger i = new CameraLogger(WhiteBalanceMeter.class.getSimpleName());

    public WhiteBalanceMeter(@NonNull List<MeteringRectangle> list, boolean z2) {
        super(list, z2);
    }

    @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
    public void b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
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

    @Override // b.o.a.n.r.BaseMeter
    public boolean m(@NonNull ActionHolder actionHolder) {
        boolean z2 = ((Integer) k(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        Integer num = (Integer) ((Camera2Engine) actionHolder).f1921i0.get(CaptureRequest.CONTROL_AWB_MODE);
        boolean z3 = z2 && num != null && num.intValue() == 1;
        i.a(1, "checkIsSupported:", Boolean.valueOf(z3));
        return z3;
    }

    @Override // b.o.a.n.r.BaseMeter
    public boolean n(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult totalCaptureResult = ((Camera2Engine) actionHolder).f1922j0;
        if (totalCaptureResult == null) {
            i.a(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        boolean z2 = num != null && num.intValue() == 2;
        i.a(1, "checkShouldSkip:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // b.o.a.n.r.BaseMeter
    public void o(@NonNull ActionHolder actionHolder, @NonNull List<MeteringRectangle> list) {
        i.a(1, "onStarted:", "with areas:", list);
        int iIntValue = ((Integer) k(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB, 0)).intValue();
        if (list.isEmpty() || iIntValue <= 0) {
            return;
        }
        ((Camera2Engine) actionHolder).f1921i0.set(CaptureRequest.CONTROL_AWB_REGIONS, (MeteringRectangle[]) list.subList(0, Math.min(iIntValue, list.size())).toArray(new MeteringRectangle[0]));
        ((Camera2Engine) actionHolder).k1();
    }
}
