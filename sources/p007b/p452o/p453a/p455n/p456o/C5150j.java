package p007b.p452o.p453a.p455n.p456o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: b.o.a.n.o.j */
/* JADX INFO: compiled from: TogetherAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5150j extends AbstractC5145e {

    /* JADX INFO: renamed from: e */
    public final List<AbstractC5145e> f13949e;

    /* JADX INFO: renamed from: f */
    public final List<AbstractC5145e> f13950f;

    /* JADX INFO: renamed from: b.o.a.n.o.j$a */
    /* JADX INFO: compiled from: TogetherAction.java */
    public class a implements InterfaceC5142b {
        public a() {
        }

        @Override // p007b.p452o.p453a.p455n.p456o.InterfaceC5142b
        /* JADX INFO: renamed from: a */
        public void mo7334a(@NonNull InterfaceC5141a interfaceC5141a, int i) {
            if (i == Integer.MAX_VALUE) {
                C5150j.this.f13950f.remove(interfaceC5141a);
            }
            if (C5150j.this.f13950f.isEmpty()) {
                C5150j.this.m7341l(Integer.MAX_VALUE);
            }
        }
    }

    public C5150j(@NonNull List<AbstractC5145e> list) {
        this.f13949e = new ArrayList(list);
        this.f13950f = new ArrayList(list);
        Iterator<AbstractC5145e> it = list.iterator();
        while (it.hasNext()) {
            it.next().m7337f(new a());
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: b */
    public void mo7248b(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        for (AbstractC5145e abstractC5145e : this.f13949e) {
            if (!abstractC5145e.m7338g()) {
                abstractC5145e.mo7248b(interfaceC5143c, captureRequest, totalCaptureResult);
            }
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: c */
    public void mo7331c(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest) {
        if (this.f13940d) {
            mo7249j(interfaceC5143c);
            this.f13940d = false;
        }
        for (AbstractC5145e abstractC5145e : this.f13949e) {
            if (!abstractC5145e.m7338g()) {
                abstractC5145e.mo7331c(interfaceC5143c, captureRequest);
            }
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: d */
    public void mo7332d(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        for (AbstractC5145e abstractC5145e : this.f13949e) {
            if (!abstractC5145e.m7338g()) {
                abstractC5145e.mo7332d(interfaceC5143c, captureRequest, captureResult);
            }
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e
    /* JADX INFO: renamed from: h */
    public void mo7335h(@NonNull InterfaceC5143c interfaceC5143c) {
        for (AbstractC5145e abstractC5145e : this.f13949e) {
            if (!abstractC5145e.m7338g()) {
                abstractC5145e.mo7335h(interfaceC5143c);
            }
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e
    /* JADX INFO: renamed from: j */
    public void mo7249j(@NonNull InterfaceC5143c interfaceC5143c) {
        this.f13939c = interfaceC5143c;
        for (AbstractC5145e abstractC5145e : this.f13949e) {
            if (!abstractC5145e.m7338g()) {
                abstractC5145e.mo7249j(interfaceC5143c);
            }
        }
    }
}
