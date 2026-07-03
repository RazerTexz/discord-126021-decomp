package com.google.android.gms.internal.icing;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p313h.p324k.C3568m;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new C3568m();

    /* JADX INFO: renamed from: j */
    public final zzk[] f20585j;

    /* JADX INFO: renamed from: k */
    public final String f20586k;

    /* JADX INFO: renamed from: l */
    public final boolean f20587l;

    /* JADX INFO: renamed from: m */
    public final Account f20588m;

    public zzh(zzk[] zzkVarArr, String str, boolean z2, Account account) {
        this.f20585j = zzkVarArr;
        this.f20586k = str;
        this.f20587l = z2;
        this.f20588m = account;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzh) {
            zzh zzhVar = (zzh) obj;
            if (C1460d.m524h0(this.f20586k, zzhVar.f20586k) && C1460d.m524h0(Boolean.valueOf(this.f20587l), Boolean.valueOf(zzhVar.f20587l)) && C1460d.m524h0(this.f20588m, zzhVar.f20588m) && Arrays.equals(this.f20585j, zzhVar.f20585j)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f20586k, Boolean.valueOf(this.f20587l), this.f20588m, Integer.valueOf(Arrays.hashCode(this.f20585j))});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m582v2(parcel, 1, this.f20585j, i, false);
        C1460d.m574t2(parcel, 2, this.f20586k, false);
        boolean z2 = this.f20587l;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        C1460d.m570s2(parcel, 4, this.f20588m, i, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
