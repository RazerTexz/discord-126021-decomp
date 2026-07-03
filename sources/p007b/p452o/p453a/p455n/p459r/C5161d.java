package p007b.p452o.p453a.p455n.p459r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p455n.C5130d;
import p007b.p452o.p453a.p455n.p456o.InterfaceC5143c;

/* JADX INFO: renamed from: b.o.a.n.r.d */
/* JADX INFO: compiled from: ExposureReset.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5161d extends AbstractC5159b {

    /* JADX INFO: renamed from: f */
    public static final C5103b f13973f = new C5103b(C5161d.class.getSimpleName());

    public C5161d() {
        super(true);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: b */
    public void mo7248b(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        if (this.f13938b == 0) {
            ((C5130d) interfaceC5143c).f13807i0.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
            ((C5130d) interfaceC5143c).m7236k1();
            m7341l(Integer.MAX_VALUE);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p459r.AbstractC5159b
    /* JADX INFO: renamed from: m */
    public void mo7352m(@NonNull InterfaceC5143c interfaceC5143c, @Nullable MeteringRectangle meteringRectangle) {
        int iIntValue = ((Integer) m7340k(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue();
        if (meteringRectangle != null && iIntValue > 0) {
            ((C5130d) interfaceC5143c).f13807i0.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{meteringRectangle});
        }
        TotalCaptureResult totalCaptureResult = ((C5130d) interfaceC5143c).f13808j0;
        Integer num = totalCaptureResult == null ? null : (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        C5103b c5103b = f13973f;
        c5103b.m7159a(1, "onStarted:", "last precapture trigger is", num);
        if (num != null && num.intValue() == 1) {
            c5103b.m7159a(1, "onStarted:", "canceling precapture.");
            ((C5130d) interfaceC5143c).f13807i0.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(Build.VERSION.SDK_INT < 23 ? 0 : 2));
        }
        C5130d c5130d = (C5130d) interfaceC5143c;
        c5130d.f13807i0.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
        c5130d.m7236k1();
        m7341l(0);
    }
}
