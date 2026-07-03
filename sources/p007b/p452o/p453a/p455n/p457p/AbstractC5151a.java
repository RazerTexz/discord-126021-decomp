package p007b.p452o.p453a.p455n.p457p;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import p007b.p452o.p453a.p455n.p456o.AbstractC5145e;
import p007b.p452o.p453a.p455n.p456o.InterfaceC5143c;

/* JADX INFO: renamed from: b.o.a.n.p.a */
/* JADX INFO: compiled from: BaseLock.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class AbstractC5151a extends AbstractC5145e {
    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e
    /* JADX INFO: renamed from: j */
    public final void mo7249j(@NonNull InterfaceC5143c interfaceC5143c) {
        this.f13939c = interfaceC5143c;
        boolean zMo7344n = mo7344n(interfaceC5143c);
        if (!mo7343m(interfaceC5143c) || zMo7344n) {
            m7341l(Integer.MAX_VALUE);
        } else {
            mo7345o(interfaceC5143c);
        }
    }

    /* JADX INFO: renamed from: m */
    public abstract boolean mo7343m(@NonNull InterfaceC5143c interfaceC5143c);

    /* JADX INFO: renamed from: n */
    public abstract boolean mo7344n(@NonNull InterfaceC5143c interfaceC5143c);

    /* JADX INFO: renamed from: o */
    public abstract void mo7345o(@NonNull InterfaceC5143c interfaceC5143c);
}
