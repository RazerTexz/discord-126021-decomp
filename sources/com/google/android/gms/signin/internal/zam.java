package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zau;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p337l.p338b.C4345j;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new C4345j();

    /* JADX INFO: renamed from: j */
    public final int f20841j;

    /* JADX INFO: renamed from: k */
    public final ConnectionResult f20842k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public final zau f20843l;

    public zam(int i, ConnectionResult connectionResult, @Nullable zau zauVar) {
        this.f20841j = i;
        this.f20842k = connectionResult;
        this.f20843l = zauVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20841j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        C1460d.m570s2(parcel, 2, this.f20842k, i, false);
        C1460d.m570s2(parcel, 3, this.f20843l, i, false);
        C1460d.m418A2(parcel, iM594y2);
    }

    public zam() {
        ConnectionResult connectionResult = new ConnectionResult(8, null);
        this.f20841j = 1;
        this.f20842k = connectionResult;
        this.f20843l = null;
    }
}
