package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.h.k.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzt> CREATOR = new s();
    public final String j;
    public final String k;
    public final boolean l;
    public final int m;
    public final boolean n;
    public final String o;
    public final zzm[] p;
    public final String q;
    public final zzu r;

    public zzt(String str, String str2, boolean z2, int i, boolean z3, String str3, zzm[] zzmVarArr, String str4, zzu zzuVar) {
        this.j = str;
        this.k = str2;
        this.l = z2;
        this.m = i;
        this.n = z3;
        this.o = str3;
        this.p = zzmVarArr;
        this.q = str4;
        this.r = zzuVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzt)) {
            return false;
        }
        zzt zztVar = (zzt) obj;
        return this.l == zztVar.l && this.m == zztVar.m && this.n == zztVar.n && AnimatableValueParser.h0(this.j, zztVar.j) && AnimatableValueParser.h0(this.k, zztVar.k) && AnimatableValueParser.h0(this.o, zztVar.o) && AnimatableValueParser.h0(this.q, zztVar.q) && AnimatableValueParser.h0(this.r, zztVar.r) && Arrays.equals(this.p, zztVar.p);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.j, this.k, Boolean.valueOf(this.l), Integer.valueOf(this.m), Boolean.valueOf(this.n), this.o, Integer.valueOf(Arrays.hashCode(this.p)), this.q, this.r});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.t2(parcel, 1, this.j, false);
        AnimatableValueParser.t2(parcel, 2, this.k, false);
        boolean z2 = this.l;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        int i2 = this.m;
        parcel.writeInt(262148);
        parcel.writeInt(i2);
        boolean z3 = this.n;
        parcel.writeInt(262149);
        parcel.writeInt(z3 ? 1 : 0);
        AnimatableValueParser.t2(parcel, 6, this.o, false);
        AnimatableValueParser.v2(parcel, 7, this.p, i, false);
        AnimatableValueParser.t2(parcel, 11, this.q, false);
        AnimatableValueParser.s2(parcel, 12, this.r, i, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
