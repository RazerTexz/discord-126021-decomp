package b.o.a.n.r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: compiled from: ExposureMeter.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class c extends a {
    public static final b.o.a.b i = new b.o.a.b(c.class.getSimpleName());
    public boolean j;
    public boolean k;

    public c(@NonNull List<MeteringRectangle> list, boolean z2) {
        super(list, z2);
        this.j = false;
        this.k = false;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004e  */
    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void b(@NonNull b.o.a.n.o.c cVar, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        i.a(1, "onCaptureCompleted:", "aeState:", num, "aeTriggerState:", num2);
        if (num == null) {
            return;
        }
        if (this.f1935b == 0) {
            int iIntValue = num.intValue();
            if (iIntValue == 2) {
                if (num2 != null && num2.intValue() == 1) {
                    this.g = true;
                    l(Integer.MAX_VALUE);
                }
            } else if (iIntValue == 3) {
                this.g = false;
                l(Integer.MAX_VALUE);
            } else if (iIntValue != 4) {
                if (iIntValue == 5) {
                    l(1);
                }
            } else if (num2 != null) {
                this.g = true;
                l(Integer.MAX_VALUE);
            }
        }
        if (this.f1935b == 1) {
            int iIntValue2 = num.intValue();
            if (iIntValue2 != 2) {
                if (iIntValue2 == 3) {
                    this.g = false;
                    l(Integer.MAX_VALUE);
                    return;
                } else if (iIntValue2 != 4) {
                    return;
                }
            }
            this.g = true;
            l(Integer.MAX_VALUE);
        }
    }

    @Override // b.o.a.n.o.e
    public void i(@NonNull b.o.a.n.o.c cVar) {
        ((b.o.a.n.d) cVar).f1921i0.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, null);
    }

    @Override // b.o.a.n.r.a
    public boolean m(@NonNull b.o.a.n.o.c cVar) {
        boolean z2 = ((Integer) k(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() == 2;
        Integer num = (Integer) ((b.o.a.n.d) cVar).f1921i0.get(CaptureRequest.CONTROL_AE_MODE);
        boolean z3 = num != null && (num.intValue() == 1 || num.intValue() == 3 || num.intValue() == 2 || num.intValue() == 4 || num.intValue() == 5);
        this.k = !z2;
        boolean z4 = ((Integer) k(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue() > 0;
        this.j = z4;
        boolean z5 = z3 && (this.k || z4);
        i.a(1, "checkIsSupported:", Boolean.valueOf(z5), "trigger:", Boolean.valueOf(this.k), "areas:", Boolean.valueOf(this.j));
        return z5;
    }

    @Override // b.o.a.n.r.a
    public boolean n(@NonNull b.o.a.n.o.c cVar) {
        TotalCaptureResult totalCaptureResult = ((b.o.a.n.d) cVar).f1922j0;
        if (totalCaptureResult == null) {
            i.a(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        boolean z2 = num != null && num.intValue() == 2;
        i.a(1, "checkShouldSkip:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // b.o.a.n.r.a
    public void o(@NonNull b.o.a.n.o.c cVar, @NonNull List<MeteringRectangle> list) {
        i.a(1, "onStarted:", "with areas:", list);
        if (this.j && !list.isEmpty()) {
            ((b.o.a.n.d) cVar).f1921i0.set(CaptureRequest.CONTROL_AE_REGIONS, (MeteringRectangle[]) list.subList(0, Math.min(((Integer) k(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue(), list.size())).toArray(new MeteringRectangle[0]));
        }
        if (this.k) {
            ((b.o.a.n.d) cVar).f1921i0.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        }
        ((b.o.a.n.d) cVar).k1();
        if (this.k) {
            l(0);
        } else {
            l(1);
        }
    }
}
