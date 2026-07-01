package b.o.a.v;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: Snapshot2PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$b extends b.o.a.n.o.e {
    public f$b(f fVar, f$a f_a) {
    }

    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void b(@NonNull b.o.a.n.o.c cVar, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.FLASH_STATE);
        if (num == null) {
            i.m.a(2, "FlashAction:", "Waiting flash, but flashState is null!", "Taking snapshot.");
            l(Integer.MAX_VALUE);
        } else if (num.intValue() != 3) {
            i.m.a(1, "FlashAction:", "Waiting flash but flashState is", num, ". Waiting...");
        } else {
            i.m.a(1, "FlashAction:", "Waiting flash and we have FIRED state!", "Taking snapshot.");
            l(Integer.MAX_VALUE);
        }
    }

    @Override // b.o.a.n.o.e
    public void j(@NonNull b.o.a.n.o.c cVar) {
        this.c = cVar;
        i.m.a(1, "FlashAction:", "Parameters locked, opening torch.");
        ((b.o.a.n.d) cVar).f1921i0.set(CaptureRequest.FLASH_MODE, 2);
        b.o.a.n.d dVar = (b.o.a.n.d) cVar;
        dVar.f1921i0.set(CaptureRequest.CONTROL_AE_MODE, 1);
        dVar.k1();
    }
}
