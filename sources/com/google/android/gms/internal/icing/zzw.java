package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.h.k.u;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new u();
    public final zzi j;
    public final long k;
    public int l;
    public final String m;
    public final zzh n;
    public final boolean o;
    public int p;
    public int q;
    public final String r;

    public zzw(zzi zziVar, long j, int i, String str, zzh zzhVar, boolean z2, int i2, int i3, String str2) {
        this.j = zziVar;
        this.k = j;
        this.l = i;
        this.m = str;
        this.n = zzhVar;
        this.o = z2;
        this.p = i2;
        this.q = i3;
        this.r = str2;
    }

    public final String toString() {
        return String.format(Locale.US, "UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", this.j, Long.valueOf(this.k), Integer.valueOf(this.l), Integer.valueOf(this.q));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.s2(parcel, 1, this.j, i, false);
        long j = this.k;
        parcel.writeInt(524290);
        parcel.writeLong(j);
        int i2 = this.l;
        parcel.writeInt(262147);
        parcel.writeInt(i2);
        AnimatableValueParser.t2(parcel, 4, this.m, false);
        AnimatableValueParser.s2(parcel, 5, this.n, i, false);
        boolean z2 = this.o;
        parcel.writeInt(262150);
        parcel.writeInt(z2 ? 1 : 0);
        int i3 = this.p;
        parcel.writeInt(262151);
        parcel.writeInt(i3);
        int i4 = this.q;
        parcel.writeInt(262152);
        parcel.writeInt(i4);
        AnimatableValueParser.t2(parcel, 9, this.r, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
