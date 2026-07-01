package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.h.m.d;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgp> CREATOR = new d();
    public final int j;

    @Nullable
    public final ParcelUuid k;

    @Nullable
    public final ParcelUuid l;

    @Nullable
    public final ParcelUuid m;

    @Nullable
    public final byte[] n;

    @Nullable
    public final byte[] o;
    public final int p;

    @Nullable
    public final byte[] q;

    @Nullable
    public final byte[] r;

    public zzgp(int i, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4) {
        this.j = i;
        this.k = parcelUuid;
        this.l = parcelUuid2;
        this.m = parcelUuid3;
        this.n = bArr;
        this.o = bArr2;
        this.p = i2;
        this.q = bArr3;
        this.r = bArr4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzgp.class == obj.getClass()) {
            zzgp zzgpVar = (zzgp) obj;
            if (this.p == zzgpVar.p && Arrays.equals(this.q, zzgpVar.q) && Arrays.equals(this.r, zzgpVar.r) && AnimatableValueParser.h0(this.m, zzgpVar.m) && Arrays.equals(this.n, zzgpVar.n) && Arrays.equals(this.o, zzgpVar.o) && AnimatableValueParser.h0(this.k, zzgpVar.k) && AnimatableValueParser.h0(this.l, zzgpVar.l)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.p), Integer.valueOf(Arrays.hashCode(this.q)), Integer.valueOf(Arrays.hashCode(this.r)), this.m, Integer.valueOf(Arrays.hashCode(this.n)), Integer.valueOf(Arrays.hashCode(this.o)), this.k, this.l});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        AnimatableValueParser.s2(parcel, 4, this.k, i, false);
        AnimatableValueParser.s2(parcel, 5, this.l, i, false);
        AnimatableValueParser.s2(parcel, 6, this.m, i, false);
        AnimatableValueParser.q2(parcel, 7, this.n, false);
        AnimatableValueParser.q2(parcel, 8, this.o, false);
        int i3 = this.p;
        parcel.writeInt(262153);
        parcel.writeInt(i3);
        AnimatableValueParser.q2(parcel, 10, this.q, false);
        AnimatableValueParser.q2(parcel, 11, this.r, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
