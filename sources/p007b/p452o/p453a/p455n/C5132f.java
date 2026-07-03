package p007b.p452o.p453a.p455n;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import p007b.p452o.p453a.p455n.p456o.AbstractC5145e;
import p007b.p452o.p453a.p455n.p456o.InterfaceC5143c;

/* JADX INFO: renamed from: b.o.a.n.f */
/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5132f extends AbstractC5145e {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C5130d f13865e;

    public C5132f(C5130d c5130d) {
        this.f13865e = c5130d;
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e
    /* JADX INFO: renamed from: j */
    public void mo7249j(@NonNull InterfaceC5143c interfaceC5143c) {
        this.f13939c = interfaceC5143c;
        this.f13865e.m7231f1(((C5130d) interfaceC5143c).f13807i0);
        C5130d c5130d = (C5130d) interfaceC5143c;
        CaptureRequest.Builder builder = c5130d.f13807i0;
        CaptureRequest.Key key = CaptureRequest.CONTROL_AE_LOCK;
        Boolean bool = Boolean.FALSE;
        builder.set(key, bool);
        c5130d.f13807i0.set(CaptureRequest.CONTROL_AWB_LOCK, bool);
        c5130d.m7236k1();
        m7341l(Integer.MAX_VALUE);
    }
}
