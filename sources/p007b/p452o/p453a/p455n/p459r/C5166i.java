package p007b.p452o.p453a.p455n.p459r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p455n.C5130d;
import p007b.p452o.p453a.p455n.p456o.InterfaceC5143c;

/* JADX INFO: renamed from: b.o.a.n.r.i */
/* JADX INFO: compiled from: WhiteBalanceMeter.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5166i extends AbstractC5158a {

    /* JADX INFO: renamed from: i */
    public static final C5103b f13983i = new C5103b(C5166i.class.getSimpleName());

    public C5166i(@NonNull List<MeteringRectangle> list, boolean z2) {
        super(list, z2);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: b */
    public void mo7248b(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        f13983i.m7159a(1, "onCaptureCompleted:", "awbState:", num);
        if (num == null) {
            return;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 2) {
            this.f13967g = true;
            m7341l(Integer.MAX_VALUE);
        } else {
            if (iIntValue != 3) {
                return;
            }
            this.f13967g = false;
            m7341l(Integer.MAX_VALUE);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p459r.AbstractC5158a
    /* JADX INFO: renamed from: m */
    public boolean mo7349m(@NonNull InterfaceC5143c interfaceC5143c) {
        boolean z2 = ((Integer) m7340k(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        Integer num = (Integer) ((C5130d) interfaceC5143c).f13807i0.get(CaptureRequest.CONTROL_AWB_MODE);
        boolean z3 = z2 && num != null && num.intValue() == 1;
        f13983i.m7159a(1, "checkIsSupported:", Boolean.valueOf(z3));
        return z3;
    }

    @Override // p007b.p452o.p453a.p455n.p459r.AbstractC5158a
    /* JADX INFO: renamed from: n */
    public boolean mo7350n(@NonNull InterfaceC5143c interfaceC5143c) {
        TotalCaptureResult totalCaptureResult = ((C5130d) interfaceC5143c).f13808j0;
        if (totalCaptureResult == null) {
            f13983i.m7159a(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        boolean z2 = num != null && num.intValue() == 2;
        f13983i.m7159a(1, "checkShouldSkip:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // p007b.p452o.p453a.p455n.p459r.AbstractC5158a
    /* JADX INFO: renamed from: o */
    public void mo7351o(@NonNull InterfaceC5143c interfaceC5143c, @NonNull List<MeteringRectangle> list) {
        f13983i.m7159a(1, "onStarted:", "with areas:", list);
        int iIntValue = ((Integer) m7340k(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB, 0)).intValue();
        if (list.isEmpty() || iIntValue <= 0) {
            return;
        }
        ((C5130d) interfaceC5143c).f13807i0.set(CaptureRequest.CONTROL_AWB_REGIONS, (MeteringRectangle[]) list.subList(0, Math.min(iIntValue, list.size())).toArray(new MeteringRectangle[0]));
        ((C5130d) interfaceC5143c).m7236k1();
    }
}
