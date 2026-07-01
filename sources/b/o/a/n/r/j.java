package b.o.a.n.r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: WhiteBalanceReset.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class j extends b {
    public static final b.o.a.b f = new b.o.a.b(j.class.getSimpleName());

    public j() {
        super(true);
    }

    @Override // b.o.a.n.r.b
    public void m(@NonNull b.o.a.n.o.c cVar, @Nullable MeteringRectangle meteringRectangle) {
        f.a(2, "onStarted:", "with area:", meteringRectangle);
        int iIntValue = ((Integer) k(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB, 0)).intValue();
        if (meteringRectangle != null && iIntValue > 0) {
            ((b.o.a.n.d) cVar).f1921i0.set(CaptureRequest.CONTROL_AWB_REGIONS, new MeteringRectangle[]{meteringRectangle});
            ((b.o.a.n.d) cVar).k1();
        }
        l(Integer.MAX_VALUE);
    }
}
