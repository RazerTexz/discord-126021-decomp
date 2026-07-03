package p007b.p452o.p453a.p455n.p456o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: b.o.a.n.o.i */
/* JADX INFO: compiled from: TimeoutAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5149i extends AbstractC5144d {

    /* JADX INFO: renamed from: e */
    public long f13946e;

    /* JADX INFO: renamed from: f */
    public long f13947f;

    /* JADX INFO: renamed from: g */
    public AbstractC5145e f13948g;

    public C5149i(long j, @NonNull AbstractC5145e abstractC5145e) {
        this.f13947f = j;
        this.f13948g = abstractC5145e;
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5144d, p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: b */
    public void mo7248b(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.mo7248b(interfaceC5143c, captureRequest, totalCaptureResult);
        if (m7338g() || System.currentTimeMillis() <= this.f13946e + this.f13947f) {
            return;
        }
        this.f13948g.mo7330a(interfaceC5143c);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5144d, p007b.p452o.p453a.p455n.p456o.AbstractC5145e
    /* JADX INFO: renamed from: j */
    public void mo7249j(@NonNull InterfaceC5143c interfaceC5143c) {
        this.f13946e = System.currentTimeMillis();
        super.mo7249j(interfaceC5143c);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5144d
    @NonNull
    /* JADX INFO: renamed from: m */
    public AbstractC5145e mo7336m() {
        return this.f13948g;
    }
}
