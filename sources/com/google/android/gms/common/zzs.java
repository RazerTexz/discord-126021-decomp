package com.google.android.gms.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.AbstractBinderC3419x;
import p007b.p225i.p226a.p288f.p299e.BinderC3420y;
import p007b.p225i.p226a.p288f.p299e.C3261e0;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractBinderC3392y0;
import p007b.p225i.p226a.p288f.p299e.p304k.C3390x0;
import p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3394z0;
import p007b.p225i.p226a.p288f.p311f.BinderC3423b;
import p007b.p225i.p226a.p288f.p311f.InterfaceC3422a;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new C3261e0();

    /* JADX INFO: renamed from: j */
    public final String f20567j;

    /* JADX INFO: renamed from: k */
    public final AbstractBinderC3419x f20568k;

    /* JADX INFO: renamed from: l */
    public final boolean f20569l;

    /* JADX INFO: renamed from: m */
    public final boolean f20570m;

    public zzs(String str, IBinder iBinder, boolean z2, boolean z3) {
        this.f20567j = str;
        BinderC3420y binderC3420y = null;
        if (iBinder != null) {
            try {
                int i = AbstractBinderC3392y0.f9573a;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
                InterfaceC3422a interfaceC3422aMo4177d = (iInterfaceQueryLocalInterface instanceof InterfaceC3394z0 ? (InterfaceC3394z0) iInterfaceQueryLocalInterface : new C3390x0(iBinder)).mo4177d();
                byte[] bArr = interfaceC3422aMo4177d == null ? null : (byte[]) BinderC3423b.m4381i(interfaceC3422aMo4177d);
                if (bArr != null) {
                    binderC3420y = new BinderC3420y(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            }
        }
        this.f20568k = binderC3420y;
        this.f20569l = z2;
        this.f20570m = z3;
    }

    public zzs(String str, AbstractBinderC3419x abstractBinderC3419x, boolean z2, boolean z3) {
        this.f20567j = str;
        this.f20568k = abstractBinderC3419x;
        this.f20569l = z2;
        this.f20570m = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m574t2(parcel, 1, this.f20567j, false);
        AbstractBinderC3419x abstractBinderC3419x = this.f20568k;
        if (abstractBinderC3419x == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            abstractBinderC3419x = null;
        }
        C1460d.m566r2(parcel, 2, abstractBinderC3419x, false);
        boolean z2 = this.f20569l;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.f20570m;
        parcel.writeInt(262148);
        parcel.writeInt(z3 ? 1 : 0);
        C1460d.m418A2(parcel, iM594y2);
    }
}
