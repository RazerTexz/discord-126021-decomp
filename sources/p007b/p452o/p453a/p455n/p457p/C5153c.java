package p007b.p452o.p453a.p455n.p457p;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p455n.C5130d;
import p007b.p452o.p453a.p455n.p456o.InterfaceC5143c;

/* JADX INFO: renamed from: b.o.a.n.p.c */
/* JADX INFO: compiled from: FocusLock.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5153c extends AbstractC5151a {

    /* JADX INFO: renamed from: e */
    public static final C5103b f13953e = new C5103b(C5153c.class.getSimpleName());

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: b */
    public void mo7248b(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
        f13953e.m7159a(1, "onCapture:", "afState:", num, "afMode:", num2);
        if (num == null || num2 == null || num2.intValue() != 1) {
            return;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0 || iIntValue == 2 || iIntValue == 4 || iIntValue == 5 || iIntValue == 6) {
            m7341l(Integer.MAX_VALUE);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p457p.AbstractC5151a
    /* JADX INFO: renamed from: m */
    public boolean mo7343m(@NonNull InterfaceC5143c interfaceC5143c) {
        for (int i : (int[]) m7340k(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0])) {
            if (i == 1) {
                return true;
            }
        }
        return false;
    }

    @Override // p007b.p452o.p453a.p455n.p457p.AbstractC5151a
    /* JADX INFO: renamed from: n */
    public boolean mo7344n(@NonNull InterfaceC5143c interfaceC5143c) {
        TotalCaptureResult totalCaptureResult = ((C5130d) interfaceC5143c).f13808j0;
        if (totalCaptureResult == null) {
            f13953e.m7159a(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        boolean z2 = num != null && (num.intValue() == 4 || num.intValue() == 5 || num.intValue() == 0 || num.intValue() == 2 || num.intValue() == 6);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
        boolean z3 = z2 && (num2 != null && num2.intValue() == 1);
        f13953e.m7159a(1, "checkShouldSkip:", Boolean.valueOf(z3));
        return z3;
    }

    @Override // p007b.p452o.p453a.p455n.p457p.AbstractC5151a
    /* JADX INFO: renamed from: o */
    public void mo7345o(@NonNull InterfaceC5143c interfaceC5143c) {
        ((C5130d) interfaceC5143c).f13807i0.set(CaptureRequest.CONTROL_AF_MODE, 1);
        C5130d c5130d = (C5130d) interfaceC5143c;
        c5130d.f13807i0.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        c5130d.m7236k1();
    }
}
