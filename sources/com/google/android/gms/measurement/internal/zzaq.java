package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.i.b.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new q();
    public final String j;
    public final zzap k;
    public final String l;
    public final long m;

    public zzaq(String str, zzap zzapVar, String str2, long j) {
        this.j = str;
        this.k = zzapVar;
        this.l = str2;
        this.m = j;
    }

    public final String toString() {
        String str = this.l;
        String str2 = this.j;
        String strValueOf = String.valueOf(this.k);
        return outline.J(outline.S(strValueOf.length() + outline.b(str2, outline.b(str, 21)), "origin=", str, ",name=", str2), ",params=", strValueOf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.t2(parcel, 2, this.j, false);
        AnimatableValueParser.s2(parcel, 3, this.k, i, false);
        AnimatableValueParser.t2(parcel, 4, this.l, false);
        long j = this.m;
        parcel.writeInt(524293);
        parcel.writeLong(j);
        AnimatableValueParser.A2(parcel, iY2);
    }

    public zzaq(zzaq zzaqVar, long j) {
        Objects.requireNonNull(zzaqVar, "null reference");
        this.j = zzaqVar.j;
        this.k = zzaqVar.k;
        this.l = zzaqVar.l;
        this.m = j;
    }
}
