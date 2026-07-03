package p007b.p452o.p453a.p471v;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Arrays;
import p007b.p452o.p453a.C5113l;
import p007b.p452o.p453a.p455n.C5130d;
import p007b.p452o.p453a.p455n.p456o.AbstractC5145e;
import p007b.p452o.p453a.p455n.p456o.AbstractC5146f;
import p007b.p452o.p453a.p455n.p456o.C5148h;
import p007b.p452o.p453a.p455n.p456o.C5149i;
import p007b.p452o.p453a.p455n.p456o.InterfaceC5141a;
import p007b.p452o.p453a.p455n.p456o.InterfaceC5143c;
import p007b.p452o.p453a.p455n.p457p.C5154d;
import p007b.p452o.p453a.p472w.InterfaceC5229e;
import p007b.p452o.p453a.p473x.C5235a;

/* JADX INFO: renamed from: b.o.a.v.f */
/* JADX INFO: compiled from: Snapshot2PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5221f extends C5222g {

    /* JADX INFO: renamed from: t */
    public final InterfaceC5141a f14185t;

    /* JADX INFO: renamed from: u */
    public final InterfaceC5143c f14186u;

    /* JADX INFO: renamed from: v */
    public final boolean f14187v;

    /* JADX INFO: renamed from: w */
    public Integer f14188w;

    /* JADX INFO: renamed from: x */
    public Integer f14189x;

    /* JADX INFO: renamed from: b.o.a.v.f$a */
    /* JADX INFO: compiled from: Snapshot2PictureRecorder.java */
    public class a extends AbstractC5146f {
        public a() {
        }

        @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5146f
        /* JADX INFO: renamed from: b */
        public void mo7247b(@NonNull InterfaceC5141a interfaceC5141a) {
            AbstractC5224i.f14205m.m7159a(1, "Taking picture with super.take().");
            C5221f.super.mo7417c();
        }
    }

    /* JADX INFO: renamed from: b.o.a.v.f$b */
    /* JADX INFO: compiled from: Snapshot2PictureRecorder.java */
    public class b extends AbstractC5145e {
        public b(C5221f c5221f, a aVar) {
        }

        @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
        /* JADX INFO: renamed from: b */
        public void mo7248b(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.FLASH_STATE);
            if (num == null) {
                AbstractC5224i.f14205m.m7159a(2, "FlashAction:", "Waiting flash, but flashState is null!", "Taking snapshot.");
                m7341l(Integer.MAX_VALUE);
            } else if (num.intValue() != 3) {
                AbstractC5224i.f14205m.m7159a(1, "FlashAction:", "Waiting flash but flashState is", num, ". Waiting...");
            } else {
                AbstractC5224i.f14205m.m7159a(1, "FlashAction:", "Waiting flash and we have FIRED state!", "Taking snapshot.");
                m7341l(Integer.MAX_VALUE);
            }
        }

        @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e
        /* JADX INFO: renamed from: j */
        public void mo7249j(@NonNull InterfaceC5143c interfaceC5143c) {
            this.f13939c = interfaceC5143c;
            AbstractC5224i.f14205m.m7159a(1, "FlashAction:", "Parameters locked, opening torch.");
            ((C5130d) interfaceC5143c).f13807i0.set(CaptureRequest.FLASH_MODE, 2);
            C5130d c5130d = (C5130d) interfaceC5143c;
            c5130d.f13807i0.set(CaptureRequest.CONTROL_AE_MODE, 1);
            c5130d.m7236k1();
        }
    }

    /* JADX INFO: renamed from: b.o.a.v.f$c */
    /* JADX INFO: compiled from: Snapshot2PictureRecorder.java */
    public class c extends AbstractC5145e {
        public c(a aVar) {
        }

        @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e
        /* JADX INFO: renamed from: j */
        public void mo7249j(@NonNull InterfaceC5143c interfaceC5143c) {
            this.f13939c = interfaceC5143c;
            try {
                AbstractC5224i.f14205m.m7159a(1, "ResetFlashAction:", "Reverting the flash changes.");
                CaptureRequest.Builder builder = ((C5130d) interfaceC5143c).f13807i0;
                builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                builder.set(CaptureRequest.FLASH_MODE, 0);
                ((C5130d) interfaceC5143c).m7230e1(this, builder);
                builder.set(CaptureRequest.CONTROL_AE_MODE, C5221f.this.f14188w);
                builder.set(CaptureRequest.FLASH_MODE, C5221f.this.f14189x);
                ((C5130d) interfaceC5143c).m7236k1();
            } catch (CameraAccessException unused) {
            }
        }
    }

    public C5221f(@NonNull C5113l.a aVar, @NonNull C5130d c5130d, @NonNull InterfaceC5229e interfaceC5229e, @NonNull C5235a c5235a) {
        super(aVar, c5130d, interfaceC5229e, c5235a, c5130d.f13894c0);
        this.f14186u = c5130d;
        boolean z2 = false;
        C5148h c5148h = new C5148h(Arrays.asList(new C5149i(2500L, new C5154d()), new b(this, null)));
        this.f14185t = c5148h;
        c5148h.m7337f(new a());
        TotalCaptureResult totalCaptureResult = c5130d.f13808j0;
        if (totalCaptureResult == null) {
            AbstractC5224i.f14205m.m7159a(2, "Picture snapshot requested very early, before the first preview frame.", "Metering might not work as intended.");
        }
        Integer num = totalCaptureResult != null ? (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE) : null;
        if (c5130d.f13873H && num != null && num.intValue() == 4) {
            z2 = true;
        }
        this.f14187v = z2;
        this.f14188w = (Integer) c5130d.f13807i0.get(CaptureRequest.CONTROL_AE_MODE);
        this.f14189x = (Integer) c5130d.f13807i0.get(CaptureRequest.FLASH_MODE);
    }

    @Override // p007b.p452o.p453a.p471v.C5222g, p007b.p452o.p453a.p471v.AbstractC5219d
    /* JADX INFO: renamed from: b */
    public void mo7416b() {
        new c(null).mo7333e(this.f14186u);
        super.mo7416b();
    }

    @Override // p007b.p452o.p453a.p471v.C5222g, p007b.p452o.p453a.p471v.AbstractC5219d
    /* JADX INFO: renamed from: c */
    public void mo7417c() {
        if (this.f14187v) {
            AbstractC5224i.f14205m.m7159a(1, "take:", "Engine needs flash. Starting action");
            this.f14185t.mo7333e(this.f14186u);
        } else {
            AbstractC5224i.f14205m.m7159a(1, "take:", "Engine does no metering or needs no flash.", "Taking fast snapshot.");
            super.mo7417c();
        }
    }
}
