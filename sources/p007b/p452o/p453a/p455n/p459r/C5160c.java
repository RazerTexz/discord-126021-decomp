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

/* JADX INFO: renamed from: b.o.a.n.r.c */
/* JADX INFO: compiled from: ExposureMeter.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5160c extends AbstractC5158a {

    /* JADX INFO: renamed from: i */
    public static final C5103b f13970i = new C5103b(C5160c.class.getSimpleName());

    /* JADX INFO: renamed from: j */
    public boolean f13971j;

    /* JADX INFO: renamed from: k */
    public boolean f13972k;

    public C5160c(@NonNull List<MeteringRectangle> list, boolean z2) {
        super(list, z2);
        this.f13971j = false;
        this.f13972k = false;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004e  */
    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: b */
    public void mo7248b(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        f13970i.m7159a(1, "onCaptureCompleted:", "aeState:", num, "aeTriggerState:", num2);
        if (num == null) {
            return;
        }
        if (this.f13938b == 0) {
            int iIntValue = num.intValue();
            if (iIntValue == 2) {
                if (num2 != null && num2.intValue() == 1) {
                    this.f13967g = true;
                    m7341l(Integer.MAX_VALUE);
                }
            } else if (iIntValue == 3) {
                this.f13967g = false;
                m7341l(Integer.MAX_VALUE);
            } else if (iIntValue != 4) {
                if (iIntValue == 5) {
                    m7341l(1);
                }
            } else if (num2 != null) {
                this.f13967g = true;
                m7341l(Integer.MAX_VALUE);
            }
        }
        if (this.f13938b == 1) {
            int iIntValue2 = num.intValue();
            if (iIntValue2 != 2) {
                if (iIntValue2 == 3) {
                    this.f13967g = false;
                    m7341l(Integer.MAX_VALUE);
                    return;
                } else if (iIntValue2 != 4) {
                    return;
                }
            }
            this.f13967g = true;
            m7341l(Integer.MAX_VALUE);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e
    /* JADX INFO: renamed from: i */
    public void mo7339i(@NonNull InterfaceC5143c interfaceC5143c) {
        ((C5130d) interfaceC5143c).f13807i0.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, null);
    }

    @Override // p007b.p452o.p453a.p455n.p459r.AbstractC5158a
    /* JADX INFO: renamed from: m */
    public boolean mo7349m(@NonNull InterfaceC5143c interfaceC5143c) {
        boolean z2 = ((Integer) m7340k(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() == 2;
        Integer num = (Integer) ((C5130d) interfaceC5143c).f13807i0.get(CaptureRequest.CONTROL_AE_MODE);
        boolean z3 = num != null && (num.intValue() == 1 || num.intValue() == 3 || num.intValue() == 2 || num.intValue() == 4 || num.intValue() == 5);
        this.f13972k = !z2;
        boolean z4 = ((Integer) m7340k(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue() > 0;
        this.f13971j = z4;
        boolean z5 = z3 && (this.f13972k || z4);
        f13970i.m7159a(1, "checkIsSupported:", Boolean.valueOf(z5), "trigger:", Boolean.valueOf(this.f13972k), "areas:", Boolean.valueOf(this.f13971j));
        return z5;
    }

    @Override // p007b.p452o.p453a.p455n.p459r.AbstractC5158a
    /* JADX INFO: renamed from: n */
    public boolean mo7350n(@NonNull InterfaceC5143c interfaceC5143c) {
        TotalCaptureResult totalCaptureResult = ((C5130d) interfaceC5143c).f13808j0;
        if (totalCaptureResult == null) {
            f13970i.m7159a(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        boolean z2 = num != null && num.intValue() == 2;
        f13970i.m7159a(1, "checkShouldSkip:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // p007b.p452o.p453a.p455n.p459r.AbstractC5158a
    /* JADX INFO: renamed from: o */
    public void mo7351o(@NonNull InterfaceC5143c interfaceC5143c, @NonNull List<MeteringRectangle> list) {
        f13970i.m7159a(1, "onStarted:", "with areas:", list);
        if (this.f13971j && !list.isEmpty()) {
            ((C5130d) interfaceC5143c).f13807i0.set(CaptureRequest.CONTROL_AE_REGIONS, (MeteringRectangle[]) list.subList(0, Math.min(((Integer) m7340k(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue(), list.size())).toArray(new MeteringRectangle[0]));
        }
        if (this.f13972k) {
            ((C5130d) interfaceC5143c).f13807i0.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        }
        ((C5130d) interfaceC5143c).m7236k1();
        if (this.f13972k) {
            m7341l(0);
        } else {
            m7341l(1);
        }
    }
}
