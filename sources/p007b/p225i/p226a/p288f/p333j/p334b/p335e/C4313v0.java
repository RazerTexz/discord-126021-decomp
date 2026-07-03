package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.messages.internal.SubscribeRequest;
import com.google.android.gms.nearby.messages.internal.zzbz;
import com.google.android.gms.nearby.messages.internal.zzcb;
import com.google.android.gms.nearby.messages.internal.zzce;
import com.google.android.gms.nearby.messages.internal.zzcg;
import com.google.android.gms.nearby.messages.internal.zzj;
import p007b.p225i.p226a.p288f.p313h.p326m.C3924a;
import p007b.p225i.p226a.p288f.p313h.p326m.C3926c;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.v0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4313v0 extends C3924a implements InterfaceC4311u0 {
    public C4313v0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
    }

    @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4311u0
    /* JADX INFO: renamed from: C */
    public final void mo5991C(SubscribeRequest subscribeRequest) throws RemoteException {
        Parcel parcelM5398c = m5398c();
        C3926c.m5402b(parcelM5398c, subscribeRequest);
        m5399g(3, parcelM5398c);
    }

    @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4311u0
    /* JADX INFO: renamed from: P */
    public final void mo5992P(zzce zzceVar) throws RemoteException {
        Parcel parcelM5398c = m5398c();
        C3926c.m5402b(parcelM5398c, zzceVar);
        m5399g(2, parcelM5398c);
    }

    @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4311u0
    /* JADX INFO: renamed from: i0 */
    public final void mo5993i0(zzj zzjVar) throws RemoteException {
        Parcel parcelM5398c = m5398c();
        C3926c.m5402b(parcelM5398c, zzjVar);
        m5399g(9, parcelM5398c);
    }

    @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4311u0
    /* JADX INFO: renamed from: j0 */
    public final void mo5994j0(zzcg zzcgVar) throws RemoteException {
        Parcel parcelM5398c = m5398c();
        C3926c.m5402b(parcelM5398c, zzcgVar);
        m5399g(4, parcelM5398c);
    }

    @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4311u0
    /* JADX INFO: renamed from: n */
    public final void mo5995n(zzbz zzbzVar) throws RemoteException {
        Parcel parcelM5398c = m5398c();
        C3926c.m5402b(parcelM5398c, zzbzVar);
        m5399g(1, parcelM5398c);
    }

    @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4311u0
    /* JADX INFO: renamed from: s */
    public final void mo5996s(zzcb zzcbVar) throws RemoteException {
        Parcel parcelM5398c = m5398c();
        C3926c.m5402b(parcelM5398c, zzcbVar);
        m5399g(8, parcelM5398c);
    }
}
