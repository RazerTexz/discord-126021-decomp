package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3389x;
import p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3355g;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zau extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zau> CREATOR = new C3389x();

    /* JADX INFO: renamed from: j */
    public final int f20550j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public IBinder f20551k;

    /* JADX INFO: renamed from: l */
    public ConnectionResult f20552l;

    /* JADX INFO: renamed from: m */
    public boolean f20553m;

    /* JADX INFO: renamed from: n */
    public boolean f20554n;

    public zau(int i, @Nullable IBinder iBinder, ConnectionResult connectionResult, boolean z2, boolean z3) {
        this.f20550j = i;
        this.f20551k = iBinder;
        this.f20552l = connectionResult;
        this.f20553m = z2;
        this.f20554n = z3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zau)) {
            return false;
        }
        zau zauVar = (zau) obj;
        return this.f20552l.equals(zauVar.f20552l) && C1460d.m524h0(m9041w0(), zauVar.m9041w0());
    }

    @Nullable
    /* JADX INFO: renamed from: w0 */
    public final InterfaceC3355g m9041w0() {
        IBinder iBinder = this.f20551k;
        if (iBinder == null) {
            return null;
        }
        return InterfaceC3355g.a.m4157g(iBinder);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20550j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        C1460d.m566r2(parcel, 2, this.f20551k, false);
        C1460d.m570s2(parcel, 3, this.f20552l, i, false);
        boolean z2 = this.f20553m;
        parcel.writeInt(262148);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.f20554n;
        parcel.writeInt(262149);
        parcel.writeInt(z3 ? 1 : 0);
        C1460d.m418A2(parcel, iM594y2);
    }
}
