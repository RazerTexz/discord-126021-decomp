package p007b.p452o.p453a.p455n.p457p;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p455n.C5130d;
import p007b.p452o.p453a.p455n.p456o.InterfaceC5143c;

/* JADX INFO: renamed from: b.o.a.n.p.b */
/* JADX INFO: compiled from: ExposureLock.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5152b extends AbstractC5151a {

    /* JADX INFO: renamed from: e */
    public static final C5103b f13952e = new C5103b(C5152b.class.getSimpleName());

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: b */
    public void mo7248b(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        f13952e.m7159a(1, "processCapture:", "aeState:", num);
        if (num != null && num.intValue() == 3) {
            m7341l(Integer.MAX_VALUE);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p457p.AbstractC5151a
    /* JADX INFO: renamed from: m */
    public boolean mo7343m(@NonNull InterfaceC5143c interfaceC5143c) {
        boolean z2 = ((Integer) m7340k(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        Integer num = (Integer) ((C5130d) interfaceC5143c).f13807i0.get(CaptureRequest.CONTROL_AE_MODE);
        boolean z3 = z2 && (num != null && (num.intValue() == 1 || num.intValue() == 3 || num.intValue() == 2 || num.intValue() == 4 || num.intValue() == 5));
        f13952e.m7159a(1, "checkIsSupported:", Boolean.valueOf(z3));
        return z3;
    }

    @Override // p007b.p452o.p453a.p455n.p457p.AbstractC5151a
    /* JADX INFO: renamed from: n */
    public boolean mo7344n(@NonNull InterfaceC5143c interfaceC5143c) {
        TotalCaptureResult totalCaptureResult = ((C5130d) interfaceC5143c).f13808j0;
        if (totalCaptureResult == null) {
            f13952e.m7159a(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        boolean z2 = num != null && num.intValue() == 3;
        f13952e.m7159a(1, "checkShouldSkip:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // p007b.p452o.p453a.p455n.p457p.AbstractC5151a
    /* JADX INFO: renamed from: o */
    public void mo7345o(@NonNull InterfaceC5143c interfaceC5143c) {
        ((C5130d) interfaceC5143c).f13807i0.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(Build.VERSION.SDK_INT >= 23 ? 2 : 0));
        C5130d c5130d = (C5130d) interfaceC5143c;
        c5130d.f13807i0.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
        c5130d.m7236k1();
    }
}
