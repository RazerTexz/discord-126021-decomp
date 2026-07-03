package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p330i.p332b.C4075ia;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzz> CREATOR = new C4075ia();

    /* JADX INFO: renamed from: j */
    public String f20700j;

    /* JADX INFO: renamed from: k */
    public String f20701k;

    /* JADX INFO: renamed from: l */
    public zzku f20702l;

    /* JADX INFO: renamed from: m */
    public long f20703m;

    /* JADX INFO: renamed from: n */
    public boolean f20704n;

    /* JADX INFO: renamed from: o */
    public String f20705o;

    /* JADX INFO: renamed from: p */
    public zzaq f20706p;

    /* JADX INFO: renamed from: q */
    public long f20707q;

    /* JADX INFO: renamed from: r */
    public zzaq f20708r;

    /* JADX INFO: renamed from: s */
    public long f20709s;

    /* JADX INFO: renamed from: t */
    public zzaq f20710t;

    public zzz(zzz zzzVar) {
        this.f20700j = zzzVar.f20700j;
        this.f20701k = zzzVar.f20701k;
        this.f20702l = zzzVar.f20702l;
        this.f20703m = zzzVar.f20703m;
        this.f20704n = zzzVar.f20704n;
        this.f20705o = zzzVar.f20705o;
        this.f20706p = zzzVar.f20706p;
        this.f20707q = zzzVar.f20707q;
        this.f20708r = zzzVar.f20708r;
        this.f20709s = zzzVar.f20709s;
        this.f20710t = zzzVar.f20710t;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m574t2(parcel, 2, this.f20700j, false);
        C1460d.m574t2(parcel, 3, this.f20701k, false);
        C1460d.m570s2(parcel, 4, this.f20702l, i, false);
        long j = this.f20703m;
        parcel.writeInt(524293);
        parcel.writeLong(j);
        boolean z2 = this.f20704n;
        parcel.writeInt(262150);
        parcel.writeInt(z2 ? 1 : 0);
        C1460d.m574t2(parcel, 7, this.f20705o, false);
        C1460d.m570s2(parcel, 8, this.f20706p, i, false);
        long j2 = this.f20707q;
        parcel.writeInt(524297);
        parcel.writeLong(j2);
        C1460d.m570s2(parcel, 10, this.f20708r, i, false);
        long j3 = this.f20709s;
        parcel.writeInt(524299);
        parcel.writeLong(j3);
        C1460d.m570s2(parcel, 12, this.f20710t, i, false);
        C1460d.m418A2(parcel, iM594y2);
    }

    public zzz(String str, String str2, zzku zzkuVar, long j, boolean z2, String str3, zzaq zzaqVar, long j2, zzaq zzaqVar2, long j3, zzaq zzaqVar3) {
        this.f20700j = str;
        this.f20701k = str2;
        this.f20702l = zzkuVar;
        this.f20703m = j;
        this.f20704n = z2;
        this.f20705o = str3;
        this.f20706p = zzaqVar;
        this.f20707q = j2;
        this.f20708r = zzaqVar2;
        this.f20709s = j3;
        this.f20710t = zzaqVar3;
    }
}
