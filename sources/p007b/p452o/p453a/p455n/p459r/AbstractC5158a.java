package p007b.p452o.p453a.p455n.p459r;

import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p455n.p456o.AbstractC5145e;
import p007b.p452o.p453a.p455n.p456o.InterfaceC5143c;

/* JADX INFO: renamed from: b.o.a.n.r.a */
/* JADX INFO: compiled from: BaseMeter.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class AbstractC5158a extends AbstractC5145e {

    /* JADX INFO: renamed from: e */
    public static final C5103b f13965e = new C5103b(AbstractC5158a.class.getSimpleName());

    /* JADX INFO: renamed from: f */
    public final List<MeteringRectangle> f13966f;

    /* JADX INFO: renamed from: g */
    public boolean f13967g;

    /* JADX INFO: renamed from: h */
    public boolean f13968h;

    public AbstractC5158a(@NonNull List<MeteringRectangle> list, boolean z2) {
        this.f13966f = list;
        this.f13968h = z2;
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e
    /* JADX INFO: renamed from: j */
    public final void mo7249j(@NonNull InterfaceC5143c interfaceC5143c) {
        this.f13939c = interfaceC5143c;
        boolean z2 = this.f13968h && mo7350n(interfaceC5143c);
        if (mo7349m(interfaceC5143c) && !z2) {
            f13965e.m7159a(1, "onStart:", "supported and not skipped. Dispatching onStarted.");
            mo7351o(interfaceC5143c, this.f13966f);
        } else {
            f13965e.m7159a(1, "onStart:", "not supported or skipped. Dispatching COMPLETED state.");
            this.f13967g = true;
            m7341l(Integer.MAX_VALUE);
        }
    }

    /* JADX INFO: renamed from: m */
    public abstract boolean mo7349m(@NonNull InterfaceC5143c interfaceC5143c);

    /* JADX INFO: renamed from: n */
    public abstract boolean mo7350n(@NonNull InterfaceC5143c interfaceC5143c);

    /* JADX INFO: renamed from: o */
    public abstract void mo7351o(@NonNull InterfaceC5143c interfaceC5143c, @NonNull List<MeteringRectangle> list);
}
