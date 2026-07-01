package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.c.a.a0.d;
import b.i.a.f.i.b.ia;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzz extends AbstractSafeParcelable {
    public static final Parcelable$Creator<zzz> CREATOR = new ia();
    public String j;
    public String k;
    public zzku l;
    public long m;
    public boolean n;
    public String o;
    public zzaq p;
    public long q;
    public zzaq r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f3016s;
    public zzaq t;

    public zzz(zzz zzzVar) {
        this.j = zzzVar.j;
        this.k = zzzVar.k;
        this.l = zzzVar.l;
        this.m = zzzVar.m;
        this.n = zzzVar.n;
        this.o = zzzVar.o;
        this.p = zzzVar.p;
        this.q = zzzVar.q;
        this.r = zzzVar.r;
        this.f3016s = zzzVar.f3016s;
        this.t = zzzVar.t;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        d.t2(parcel, 2, this.j, false);
        d.t2(parcel, 3, this.k, false);
        d.s2(parcel, 4, this.l, i, false);
        long j = this.m;
        parcel.writeInt(524293);
        parcel.writeLong(j);
        boolean z2 = this.n;
        parcel.writeInt(262150);
        parcel.writeInt(z2 ? 1 : 0);
        d.t2(parcel, 7, this.o, false);
        d.s2(parcel, 8, this.p, i, false);
        long j2 = this.q;
        parcel.writeInt(524297);
        parcel.writeLong(j2);
        d.s2(parcel, 10, this.r, i, false);
        long j3 = this.f3016s;
        parcel.writeInt(524299);
        parcel.writeLong(j3);
        d.s2(parcel, 12, this.t, i, false);
        d.A2(parcel, iY2);
    }

    public zzz(String str, String str2, zzku zzkuVar, long j, boolean z2, String str3, zzaq zzaqVar, long j2, zzaq zzaqVar2, long j3, zzaq zzaqVar3) {
        this.j = str;
        this.k = str2;
        this.l = zzkuVar;
        this.m = j;
        this.n = z2;
        this.o = str3;
        this.p = zzaqVar;
        this.q = j2;
        this.r = zzaqVar2;
        this.f3016s = j3;
        this.t = zzaqVar3;
    }
}
