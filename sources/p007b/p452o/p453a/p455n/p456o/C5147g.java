package p007b.p452o.p453a.p455n.p456o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p455n.AbstractC5135i;

/* JADX INFO: renamed from: b.o.a.n.o.g */
/* JADX INFO: compiled from: LogAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5147g extends AbstractC5145e {

    /* JADX INFO: renamed from: e */
    public static final C5103b f13941e = new C5103b(AbstractC5135i.class.getSimpleName());

    /* JADX INFO: renamed from: f */
    public String f13942f;

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: b */
    public void mo7248b(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_MODE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        Integer num3 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        String str = "aeMode: " + num + " aeLock: " + ((Boolean) totalCaptureResult.get(CaptureResult.CONTROL_AE_LOCK)) + " aeState: " + num2 + " aeTriggerState: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER)) + " afState: " + num3 + " afTriggerState: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_TRIGGER));
        if (str.equals(this.f13942f)) {
            return;
        }
        this.f13942f = str;
        f13941e.m7159a(1, str);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e
    /* JADX INFO: renamed from: i */
    public void mo7339i(@NonNull InterfaceC5143c interfaceC5143c) {
        m7341l(0);
        mo7333e(interfaceC5143c);
    }
}
