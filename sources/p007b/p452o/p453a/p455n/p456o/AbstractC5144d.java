package p007b.p452o.p453a.p455n.p456o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: b.o.a.n.o.d */
/* JADX INFO: compiled from: ActionWrapper.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class AbstractC5144d extends AbstractC5145e {

    /* JADX INFO: renamed from: b.o.a.n.o.d$a */
    /* JADX INFO: compiled from: ActionWrapper.java */
    public class a implements InterfaceC5142b {
        public a() {
        }

        @Override // p007b.p452o.p453a.p455n.p456o.InterfaceC5142b
        /* JADX INFO: renamed from: a */
        public void mo7334a(@NonNull InterfaceC5141a interfaceC5141a, int i) {
            AbstractC5144d.this.m7341l(i);
            if (i == Integer.MAX_VALUE) {
                ((AbstractC5145e) interfaceC5141a).f13937a.remove(this);
            }
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: b */
    public void mo7248b(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        mo7336m().mo7248b(interfaceC5143c, captureRequest, totalCaptureResult);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: c */
    public void mo7331c(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest) {
        if (this.f13940d) {
            mo7249j(interfaceC5143c);
            this.f13940d = false;
        }
        mo7336m().mo7331c(interfaceC5143c, captureRequest);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: d */
    public void mo7332d(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        mo7336m().mo7332d(interfaceC5143c, captureRequest, captureResult);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e
    /* JADX INFO: renamed from: h */
    public void mo7335h(@NonNull InterfaceC5143c interfaceC5143c) {
        mo7336m().mo7335h(interfaceC5143c);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e
    /* JADX INFO: renamed from: j */
    public void mo7249j(@NonNull InterfaceC5143c interfaceC5143c) {
        this.f13939c = interfaceC5143c;
        mo7336m().m7337f(new a());
        mo7336m().mo7249j(interfaceC5143c);
    }

    @NonNull
    /* JADX INFO: renamed from: m */
    public abstract AbstractC5145e mo7336m();
}
