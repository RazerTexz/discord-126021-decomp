package p007b.p452o.p453a.p455n.p459r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p455n.C5130d;
import p007b.p452o.p453a.p455n.p456o.InterfaceC5143c;

/* JADX INFO: renamed from: b.o.a.n.r.j */
/* JADX INFO: compiled from: WhiteBalanceReset.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5167j extends AbstractC5159b {

    /* JADX INFO: renamed from: f */
    public static final C5103b f13984f = new C5103b(C5167j.class.getSimpleName());

    public C5167j() {
        super(true);
    }

    @Override // p007b.p452o.p453a.p455n.p459r.AbstractC5159b
    /* JADX INFO: renamed from: m */
    public void mo7352m(@NonNull InterfaceC5143c interfaceC5143c, @Nullable MeteringRectangle meteringRectangle) {
        f13984f.m7159a(2, "onStarted:", "with area:", meteringRectangle);
        int iIntValue = ((Integer) m7340k(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB, 0)).intValue();
        if (meteringRectangle != null && iIntValue > 0) {
            ((C5130d) interfaceC5143c).f13807i0.set(CaptureRequest.CONTROL_AWB_REGIONS, new MeteringRectangle[]{meteringRectangle});
            ((C5130d) interfaceC5143c).m7236k1();
        }
        m7341l(Integer.MAX_VALUE);
    }
}
