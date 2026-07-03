package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p336k.C4330d;

/* JADX INFO: loaded from: classes3.dex */
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new C4330d();

    /* JADX INFO: renamed from: j */
    public final long f20827j;

    /* JADX INFO: renamed from: k */
    public final HarmfulAppsData[] f20828k;

    /* JADX INFO: renamed from: l */
    public final int f20829l;

    /* JADX INFO: renamed from: m */
    public final boolean f20830m;

    public zzd(long j, HarmfulAppsData[] harmfulAppsDataArr, int i, boolean z2) {
        this.f20827j = j;
        this.f20828k = harmfulAppsDataArr;
        this.f20830m = z2;
        if (z2) {
            this.f20829l = i;
        } else {
            this.f20829l = -1;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        long j = this.f20827j;
        parcel.writeInt(524290);
        parcel.writeLong(j);
        C1460d.m582v2(parcel, 3, this.f20828k, i, false);
        int i2 = this.f20829l;
        parcel.writeInt(262148);
        parcel.writeInt(i2);
        boolean z2 = this.f20830m;
        parcel.writeInt(262149);
        parcel.writeInt(z2 ? 1 : 0);
        C1460d.m418A2(parcel, iM594y2);
    }
}
