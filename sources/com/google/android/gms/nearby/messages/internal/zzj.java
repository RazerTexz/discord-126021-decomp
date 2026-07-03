package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4297n0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new C4297n0();

    /* JADX INFO: renamed from: j */
    public final int f20815j;

    /* JADX INFO: renamed from: k */
    @Nullable
    @Deprecated
    public final ClientAppContext f20816k;

    /* JADX INFO: renamed from: l */
    public final int f20817l;

    public zzj(int i) {
        this.f20815j = 1;
        this.f20816k = null;
        this.f20817l = i;
    }

    public zzj(int i, ClientAppContext clientAppContext, int i2) {
        this.f20815j = i;
        this.f20816k = clientAppContext;
        this.f20817l = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20815j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        C1460d.m570s2(parcel, 2, this.f20816k, i, false);
        int i3 = this.f20817l;
        parcel.writeInt(262147);
        parcel.writeInt(i3);
        C1460d.m418A2(parcel, iM594y2);
    }
}
