package p007b.p452o.p453a.p455n.p459r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p455n.C5130d;
import p007b.p452o.p453a.p455n.p456o.InterfaceC5143c;

/* JADX INFO: renamed from: b.o.a.n.r.f */
/* JADX INFO: compiled from: FocusReset.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5163f extends AbstractC5159b {

    /* JADX INFO: renamed from: f */
    public static final C5103b f13975f = new C5103b(C5163f.class.getSimpleName());

    public C5163f() {
        super(true);
    }

    @Override // p007b.p452o.p453a.p455n.p459r.AbstractC5159b
    /* JADX INFO: renamed from: m */
    public void mo7352m(@NonNull InterfaceC5143c interfaceC5143c, @Nullable MeteringRectangle meteringRectangle) {
        boolean z2;
        int iIntValue = ((Integer) m7340k(CameraCharacteristics.CONTROL_MAX_REGIONS_AF, 0)).intValue();
        boolean z3 = true;
        if (meteringRectangle == null || iIntValue <= 0) {
            z2 = false;
        } else {
            ((C5130d) interfaceC5143c).f13807i0.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{meteringRectangle});
            z2 = true;
        }
        TotalCaptureResult totalCaptureResult = ((C5130d) interfaceC5143c).f13808j0;
        Integer num = totalCaptureResult == null ? null : (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_TRIGGER);
        f13975f.m7159a(2, "onStarted:", "last focus trigger is", num);
        if (num == null || num.intValue() != 1) {
            z3 = z2;
        } else {
            ((C5130d) interfaceC5143c).f13807i0.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        }
        if (z3) {
            ((C5130d) interfaceC5143c).m7236k1();
        }
        m7341l(Integer.MAX_VALUE);
    }
}
