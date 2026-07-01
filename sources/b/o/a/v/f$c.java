package b.o.a.v;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest$Builder;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: Snapshot2PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$c extends b.o.a.n.o.e {
    public final /* synthetic */ f e;

    public f$c(f fVar, f$a f_a) {
        this.e = fVar;
    }

    @Override // b.o.a.n.o.e
    public void j(@NonNull b.o.a.n.o.c cVar) {
        this.c = cVar;
        try {
            i.m.a(1, "ResetFlashAction:", "Reverting the flash changes.");
            CaptureRequest$Builder captureRequest$Builder = ((b.o.a.n.d) cVar).f1921i0;
            captureRequest$Builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
            captureRequest$Builder.set(CaptureRequest.FLASH_MODE, 0);
            ((b.o.a.n.d) cVar).e1(this, captureRequest$Builder);
            captureRequest$Builder.set(CaptureRequest.CONTROL_AE_MODE, this.e.w);
            captureRequest$Builder.set(CaptureRequest.FLASH_MODE, this.e.f1955x);
            ((b.o.a.n.d) cVar).k1();
        } catch (CameraAccessException unused) {
        }
    }
}
