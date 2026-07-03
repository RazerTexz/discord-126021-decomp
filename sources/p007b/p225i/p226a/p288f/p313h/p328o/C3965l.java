package p007b.p225i.p226a.p288f.p313h.p328o;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3349d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3347c;

/* JADX INFO: renamed from: b.i.a.f.h.o.l */
/* JADX INFO: loaded from: classes3.dex */
public final class C3965l extends AbstractC3349d<InterfaceC3960g> {
    public C3965l(Context context, Looper looper, C3347c c3347c, AbstractC3268c.a aVar, AbstractC3268c.b bVar) {
        super(context, looper, 45, c3347c, aVar, bVar);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b, p007b.p225i.p226a.p288f.p299e.p300h.C3266a.f
    /* JADX INFO: renamed from: l */
    public final int mo3982l() {
        return 12200000;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: r */
    public final /* synthetic */ IInterface mo3983r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC3960g ? (InterfaceC3960g) iInterfaceQueryLocalInterface : new C3961h(iBinder);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: x */
    public final String mo3984x() {
        return "com.google.android.gms.safetynet.internal.ISafetyNetService";
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: y */
    public final String mo3985y() {
        return "com.google.android.gms.safetynet.service.START";
    }
}
