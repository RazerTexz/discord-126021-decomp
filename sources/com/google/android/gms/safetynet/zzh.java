package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p336k.C4332f;

/* JADX INFO: loaded from: classes3.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new C4332f();

    /* JADX INFO: renamed from: j */
    public final int f20832j;

    /* JADX INFO: renamed from: k */
    public final boolean f20833k;

    public zzh(int i, boolean z2) {
        this.f20832j = i;
        this.f20833k = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20832j;
        parcel.writeInt(262146);
        parcel.writeInt(i2);
        boolean z2 = this.f20833k;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        C1460d.m418A2(parcel, iM594y2);
    }
}
