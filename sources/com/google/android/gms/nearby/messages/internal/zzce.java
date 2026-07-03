package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4287i0;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4309t0;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4305r0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzce extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzce> CREATOR = new C4287i0();

    /* JADX INFO: renamed from: j */
    public final int f20796j;

    /* JADX INFO: renamed from: k */
    public final zzaf f20797k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC4305r0 f20798l;

    /* JADX INFO: renamed from: m */
    @Nullable
    @Deprecated
    public final String f20799m;

    /* JADX INFO: renamed from: n */
    @Nullable
    @Deprecated
    public final String f20800n;

    /* JADX INFO: renamed from: o */
    @Deprecated
    public final boolean f20801o;

    /* JADX INFO: renamed from: p */
    @Nullable
    @Deprecated
    public final ClientAppContext f20802p;

    public zzce(int i, zzaf zzafVar, IBinder iBinder, @Nullable String str, @Nullable String str2, boolean z2, @Nullable ClientAppContext clientAppContext) {
        InterfaceC4305r0 c4309t0;
        this.f20796j = i;
        this.f20797k = zzafVar;
        if (iBinder == null) {
            c4309t0 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            c4309t0 = iInterfaceQueryLocalInterface instanceof InterfaceC4305r0 ? (InterfaceC4305r0) iInterfaceQueryLocalInterface : new C4309t0(iBinder);
        }
        this.f20798l = c4309t0;
        this.f20799m = str;
        this.f20800n = str2;
        this.f20801o = z2;
        this.f20802p = ClientAppContext.m9121w0(clientAppContext, str2, str, z2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20796j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        C1460d.m570s2(parcel, 2, this.f20797k, i, false);
        C1460d.m566r2(parcel, 3, this.f20798l.asBinder(), false);
        C1460d.m574t2(parcel, 4, this.f20799m, false);
        C1460d.m574t2(parcel, 5, this.f20800n, false);
        boolean z2 = this.f20801o;
        parcel.writeInt(262150);
        parcel.writeInt(z2 ? 1 : 0);
        C1460d.m570s2(parcel, 7, this.f20802p, i, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
