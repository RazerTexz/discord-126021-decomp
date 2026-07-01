package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.c.a.a0.d;
import b.i.a.f.h.l.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable$Creator<zzae> CREATOR = new h();
    public final long j;
    public final long k;
    public final boolean l;
    public final String m;
    public final String n;
    public final String o;
    public final Bundle p;

    public zzae(long j, long j2, boolean z2, String str, String str2, String str3, Bundle bundle) {
        this.j = j;
        this.k = j2;
        this.l = z2;
        this.m = str;
        this.n = str2;
        this.o = str3;
        this.p = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        long j = this.j;
        parcel.writeInt(524289);
        parcel.writeLong(j);
        long j2 = this.k;
        parcel.writeInt(524290);
        parcel.writeLong(j2);
        boolean z2 = this.l;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        d.t2(parcel, 4, this.m, false);
        d.t2(parcel, 5, this.n, false);
        d.t2(parcel, 6, this.o, false);
        d.p2(parcel, 7, this.p, false);
        d.A2(parcel, iY2);
    }
}
