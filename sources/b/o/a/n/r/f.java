package b.o.a.n.r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: FocusReset.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class f extends b {
    public static final b.o.a.b f = new b.o.a.b(f.class.getSimpleName());

    public f() {
        super(true);
    }

    @Override // b.o.a.n.r.b
    public void m(@NonNull b.o.a.n.o.c cVar, @Nullable MeteringRectangle meteringRectangle) {
        boolean z2;
        int iIntValue = ((Integer) k(CameraCharacteristics.CONTROL_MAX_REGIONS_AF, 0)).intValue();
        boolean z3 = true;
        if (meteringRectangle == null || iIntValue <= 0) {
            z2 = false;
        } else {
            ((b.o.a.n.d) cVar).f1921i0.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{meteringRectangle});
            z2 = true;
        }
        TotalCaptureResult totalCaptureResult = ((b.o.a.n.d) cVar).f1922j0;
        Integer num = totalCaptureResult == null ? null : (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_TRIGGER);
        f.a(2, "onStarted:", "last focus trigger is", num);
        if (num == null || num.intValue() != 1) {
            z3 = z2;
        } else {
            ((b.o.a.n.d) cVar).f1921i0.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        }
        if (z3) {
            ((b.o.a.n.d) cVar).k1();
        }
        l(Integer.MAX_VALUE);
    }
}
