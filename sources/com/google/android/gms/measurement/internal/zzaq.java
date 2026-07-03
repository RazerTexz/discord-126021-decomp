package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p330i.p332b.C4153q;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new C4153q();

    /* JADX INFO: renamed from: j */
    public final String f20666j;

    /* JADX INFO: renamed from: k */
    public final zzap f20667k;

    /* JADX INFO: renamed from: l */
    public final String f20668l;

    /* JADX INFO: renamed from: m */
    public final long f20669m;

    public zzaq(String str, zzap zzapVar, String str2, long j) {
        this.f20666j = str;
        this.f20667k = zzapVar;
        this.f20668l = str2;
        this.f20669m = j;
    }

    public final String toString() {
        String str = this.f20668l;
        String str2 = this.f20666j;
        String strValueOf = String.valueOf(this.f20667k);
        return C1643a.m822J(C1643a.m831S(strValueOf.length() + C1643a.m841b(str2, C1643a.m841b(str, 21)), "origin=", str, ",name=", str2), ",params=", strValueOf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m574t2(parcel, 2, this.f20666j, false);
        C1460d.m570s2(parcel, 3, this.f20667k, i, false);
        C1460d.m574t2(parcel, 4, this.f20668l, false);
        long j = this.f20669m;
        parcel.writeInt(524293);
        parcel.writeLong(j);
        C1460d.m418A2(parcel, iM594y2);
    }

    public zzaq(zzaq zzaqVar, long j) {
        Objects.requireNonNull(zzaqVar, "null reference");
        this.f20666j = zzaqVar.f20666j;
        this.f20667k = zzaqVar.f20667k;
        this.f20668l = zzaqVar.f20668l;
        this.f20669m = j;
    }
}
