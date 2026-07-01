package com.google.android.gms.internal.icing;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.h.k.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new m();
    public final zzk[] j;
    public final String k;
    public final boolean l;
    public final Account m;

    public zzh(zzk[] zzkVarArr, String str, boolean z2, Account account) {
        this.j = zzkVarArr;
        this.k = str;
        this.l = z2;
        this.m = account;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzh) {
            zzh zzhVar = (zzh) obj;
            if (AnimatableValueParser.h0(this.k, zzhVar.k) && AnimatableValueParser.h0(Boolean.valueOf(this.l), Boolean.valueOf(zzhVar.l)) && AnimatableValueParser.h0(this.m, zzhVar.m) && Arrays.equals(this.j, zzhVar.j)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.k, Boolean.valueOf(this.l), this.m, Integer.valueOf(Arrays.hashCode(this.j))});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.v2(parcel, 1, this.j, i, false);
        AnimatableValueParser.t2(parcel, 2, this.k, false);
        boolean z2 = this.l;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        AnimatableValueParser.s2(parcel, 4, this.m, i, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
