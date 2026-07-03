package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p313h.p324k.C3574s;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzt> CREATOR = new C3574s();

    /* JADX INFO: renamed from: j */
    public final String f20602j;

    /* JADX INFO: renamed from: k */
    public final String f20603k;

    /* JADX INFO: renamed from: l */
    public final boolean f20604l;

    /* JADX INFO: renamed from: m */
    public final int f20605m;

    /* JADX INFO: renamed from: n */
    public final boolean f20606n;

    /* JADX INFO: renamed from: o */
    public final String f20607o;

    /* JADX INFO: renamed from: p */
    public final zzm[] f20608p;

    /* JADX INFO: renamed from: q */
    public final String f20609q;

    /* JADX INFO: renamed from: r */
    public final zzu f20610r;

    public zzt(String str, String str2, boolean z2, int i, boolean z3, String str3, zzm[] zzmVarArr, String str4, zzu zzuVar) {
        this.f20602j = str;
        this.f20603k = str2;
        this.f20604l = z2;
        this.f20605m = i;
        this.f20606n = z3;
        this.f20607o = str3;
        this.f20608p = zzmVarArr;
        this.f20609q = str4;
        this.f20610r = zzuVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzt)) {
            return false;
        }
        zzt zztVar = (zzt) obj;
        return this.f20604l == zztVar.f20604l && this.f20605m == zztVar.f20605m && this.f20606n == zztVar.f20606n && C1460d.m524h0(this.f20602j, zztVar.f20602j) && C1460d.m524h0(this.f20603k, zztVar.f20603k) && C1460d.m524h0(this.f20607o, zztVar.f20607o) && C1460d.m524h0(this.f20609q, zztVar.f20609q) && C1460d.m524h0(this.f20610r, zztVar.f20610r) && Arrays.equals(this.f20608p, zztVar.f20608p);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f20602j, this.f20603k, Boolean.valueOf(this.f20604l), Integer.valueOf(this.f20605m), Boolean.valueOf(this.f20606n), this.f20607o, Integer.valueOf(Arrays.hashCode(this.f20608p)), this.f20609q, this.f20610r});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m574t2(parcel, 1, this.f20602j, false);
        C1460d.m574t2(parcel, 2, this.f20603k, false);
        boolean z2 = this.f20604l;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        int i2 = this.f20605m;
        parcel.writeInt(262148);
        parcel.writeInt(i2);
        boolean z3 = this.f20606n;
        parcel.writeInt(262149);
        parcel.writeInt(z3 ? 1 : 0);
        C1460d.m574t2(parcel, 6, this.f20607o, false);
        C1460d.m582v2(parcel, 7, this.f20608p, i, false);
        C1460d.m574t2(parcel, 11, this.f20609q, false);
        C1460d.m570s2(parcel, 12, this.f20610r, i, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
