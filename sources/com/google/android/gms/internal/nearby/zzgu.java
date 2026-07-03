package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p313h.p326m.C3930g;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgu> CREATOR = new C3930g();

    /* JADX INFO: renamed from: j */
    public final int f20648j;

    /* JADX INFO: renamed from: k */
    public final int f20649k;

    /* JADX INFO: renamed from: l */
    public final byte[] f20650l;

    /* JADX INFO: renamed from: m */
    public final boolean f20651m;

    public zzgu(int i, int i2, byte[] bArr, boolean z2) {
        this.f20648j = i;
        this.f20649k = i2;
        this.f20650l = bArr;
        this.f20651m = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20649k;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        C1460d.m562q2(parcel, 2, this.f20650l, false);
        boolean z2 = this.f20651m;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        int i3 = this.f20648j;
        parcel.writeInt(263144);
        parcel.writeInt(i3);
        C1460d.m418A2(parcel, iM594y2);
    }
}
