package p007b.p225i.p226a.p288f.p313h.p316c;

import android.content.Context;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p292c.p293a.C3183a;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3284d;

/* JADX INFO: renamed from: b.i.a.f.h.c.m */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3464m<R extends InterfaceC3273h> extends AbstractC3284d<R, C3466o> {
    public AbstractC3464m(AbstractC3268c abstractC3268c) {
        super(C3183a.f9207e, abstractC3268c);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3287e
    /* JADX INFO: renamed from: b */
    public /* bridge */ /* synthetic */ void mo3989b(Object obj) {
        mo3989b((InterfaceC3273h) obj);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3284d
    /* JADX INFO: renamed from: k */
    public void mo3988k(C3266a.b bVar) throws RemoteException {
        C3466o c3466o = (C3466o) bVar;
        mo4400m(c3466o.f9479d, (InterfaceC3471t) c3466o.m4142w());
    }

    /* JADX INFO: renamed from: m */
    public abstract void mo4400m(Context context, InterfaceC3471t interfaceC3471t) throws RemoteException;
}
