package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.C3257c0;
import p007b.p225i.p226a.p288f.p311f.BinderC3423b;
import p007b.p225i.p226a.p288f.p311f.InterfaceC3422a;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new C3257c0();

    /* JADX INFO: renamed from: j */
    public final String f20559j;

    /* JADX INFO: renamed from: k */
    public final boolean f20560k;

    /* JADX INFO: renamed from: l */
    public final boolean f20561l;

    /* JADX INFO: renamed from: m */
    public final Context f20562m;

    /* JADX INFO: renamed from: n */
    public final boolean f20563n;

    public zzn(String str, boolean z2, boolean z3, IBinder iBinder, boolean z4) {
        this.f20559j = str;
        this.f20560k = z2;
        this.f20561l = z3;
        this.f20562m = (Context) BinderC3423b.m4381i(InterfaceC3422a.a.m4380g(iBinder));
        this.f20563n = z4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m574t2(parcel, 1, this.f20559j, false);
        boolean z2 = this.f20560k;
        parcel.writeInt(262146);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.f20561l;
        parcel.writeInt(262147);
        parcel.writeInt(z3 ? 1 : 0);
        C1460d.m566r2(parcel, 4, new BinderC3423b(this.f20562m), false);
        boolean z4 = this.f20563n;
        parcel.writeInt(262149);
        parcel.writeInt(z4 ? 1 : 0);
        C1460d.m418A2(parcel, iM594y2);
    }
}
