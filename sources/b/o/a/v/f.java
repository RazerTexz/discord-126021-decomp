package b.o.a.v;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.o.a.l$a;
import java.util.Arrays;

/* JADX INFO: compiled from: Snapshot2PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class f extends g {
    public final b.o.a.n.o.a t;
    public final b.o.a.n.o.c u;
    public final boolean v;
    public Integer w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Integer f1955x;

    public f(@NonNull l$a l_a, @NonNull b.o.a.n.d dVar, @NonNull b.o.a.w.e eVar, @NonNull b.o.a.x.a aVar) {
        super(l_a, dVar, eVar, aVar, dVar.f1930c0);
        this.u = dVar;
        boolean z2 = false;
        b.o.a.n.o.h hVar = new b.o.a.n.o.h(Arrays.asList(new b.o.a.n.o.i(2500L, new b.o.a.n.p.d()), new f$b(this, null)));
        this.t = hVar;
        hVar.f(new f$a(this));
        TotalCaptureResult totalCaptureResult = dVar.f1922j0;
        if (totalCaptureResult == null) {
            i.m.a(2, "Picture snapshot requested very early, before the first preview frame.", "Metering might not work as intended.");
        }
        Integer num = totalCaptureResult != null ? (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE) : null;
        if (dVar.H && num != null && num.intValue() == 4) {
            z2 = true;
        }
        this.v = z2;
        this.w = (Integer) dVar.f1921i0.get(CaptureRequest.CONTROL_AE_MODE);
        this.f1955x = (Integer) dVar.f1921i0.get(CaptureRequest.FLASH_MODE);
    }

    public static /* synthetic */ void d(f fVar) {
        super.c();
    }

    @Override // b.o.a.v.g, b.o.a.v.d
    public void b() {
        new f$c(this, null).e(this.u);
        super.b();
    }

    @Override // b.o.a.v.g, b.o.a.v.d
    public void c() {
        if (this.v) {
            i.m.a(1, "take:", "Engine needs flash. Starting action");
            this.t.e(this.u);
        } else {
            i.m.a(1, "take:", "Engine does no metering or needs no flash.", "Taking fast snapshot.");
            super.c();
        }
    }
}
