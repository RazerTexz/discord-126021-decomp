package p007b.p452o.p453a.p455n.p456o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: renamed from: b.o.a.n.o.h */
/* JADX INFO: compiled from: SequenceAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5148h extends AbstractC5145e {

    /* JADX INFO: renamed from: e */
    public final List<AbstractC5145e> f13943e;

    /* JADX INFO: renamed from: f */
    public int f13944f = -1;

    /* JADX INFO: renamed from: b.o.a.n.o.h$a */
    /* JADX INFO: compiled from: SequenceAction.java */
    public class a implements InterfaceC5142b {
        public a() {
        }

        @Override // p007b.p452o.p453a.p455n.p456o.InterfaceC5142b
        /* JADX INFO: renamed from: a */
        public void mo7334a(@NonNull InterfaceC5141a interfaceC5141a, int i) {
            if (i == Integer.MAX_VALUE) {
                ((AbstractC5145e) interfaceC5141a).f13937a.remove(this);
                C5148h.this.m7342m();
            }
        }
    }

    public C5148h(@NonNull List<AbstractC5145e> list) {
        this.f13943e = list;
        m7342m();
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: b */
    public void mo7248b(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        int i = this.f13944f;
        if (i >= 0) {
            this.f13943e.get(i).mo7248b(interfaceC5143c, captureRequest, totalCaptureResult);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: c */
    public void mo7331c(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest) {
        if (this.f13940d) {
            mo7249j(interfaceC5143c);
            this.f13940d = false;
        }
        int i = this.f13944f;
        if (i >= 0) {
            this.f13943e.get(i).mo7331c(interfaceC5143c, captureRequest);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: d */
    public void mo7332d(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        int i = this.f13944f;
        if (i >= 0) {
            this.f13943e.get(i).mo7332d(interfaceC5143c, captureRequest, captureResult);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e
    /* JADX INFO: renamed from: h */
    public void mo7335h(@NonNull InterfaceC5143c interfaceC5143c) {
        int i = this.f13944f;
        if (i >= 0) {
            this.f13943e.get(i).mo7335h(interfaceC5143c);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e
    /* JADX INFO: renamed from: j */
    public void mo7249j(@NonNull InterfaceC5143c interfaceC5143c) {
        this.f13939c = interfaceC5143c;
        int i = this.f13944f;
        if (i >= 0) {
            this.f13943e.get(i).mo7249j(interfaceC5143c);
        }
    }

    /* JADX INFO: renamed from: m */
    public final void m7342m() {
        int i = this.f13944f;
        boolean z2 = i == -1;
        if (i == this.f13943e.size() - 1) {
            m7341l(Integer.MAX_VALUE);
            return;
        }
        int i2 = this.f13944f + 1;
        this.f13944f = i2;
        this.f13943e.get(i2).m7337f(new a());
        if (z2) {
            return;
        }
        this.f13943e.get(this.f13944f).mo7249j(this.f13939c);
    }
}
