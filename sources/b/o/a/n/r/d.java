package b.o.a.n.r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build$VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: ExposureReset.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class d extends b {
    public static final b.o.a.b f = new b.o.a.b(d.class.getSimpleName());

    public d() {
        super(true);
    }

    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void b(@NonNull b.o.a.n.o.c cVar, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        if (this.f1935b == 0) {
            ((b.o.a.n.d) cVar).f1921i0.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
            ((b.o.a.n.d) cVar).k1();
            l(Integer.MAX_VALUE);
        }
    }

    @Override // b.o.a.n.r.b
    public void m(@NonNull b.o.a.n.o.c cVar, @Nullable MeteringRectangle meteringRectangle) {
        int iIntValue = ((Integer) k(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue();
        if (meteringRectangle != null && iIntValue > 0) {
            ((b.o.a.n.d) cVar).f1921i0.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{meteringRectangle});
        }
        TotalCaptureResult totalCaptureResult = ((b.o.a.n.d) cVar).f1922j0;
        Integer num = totalCaptureResult == null ? null : (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        b.o.a.b bVar = f;
        bVar.a(1, "onStarted:", "last precapture trigger is", num);
        if (num != null && num.intValue() == 1) {
            bVar.a(1, "onStarted:", "canceling precapture.");
            ((b.o.a.n.d) cVar).f1921i0.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(Build$VERSION.SDK_INT < 23 ? 0 : 2));
        }
        b.o.a.n.d dVar = (b.o.a.n.d) cVar;
        dVar.f1921i0.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
        dVar.k1();
        l(0);
    }
}
