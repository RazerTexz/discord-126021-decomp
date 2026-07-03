package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4273b1;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4283g0;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4309t0;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4305r0;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4321z0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcb> CREATOR = new C4283g0();

    /* JADX INFO: renamed from: j */
    public final int f20790j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC4305r0 f20791k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC4321z0 f20792l;

    /* JADX INFO: renamed from: m */
    public boolean f20793m;

    /* JADX INFO: renamed from: n */
    @Nullable
    @Deprecated
    public String f20794n;

    /* JADX INFO: renamed from: o */
    @Nullable
    @Deprecated
    public final ClientAppContext f20795o;

    public zzcb(int i, IBinder iBinder, IBinder iBinder2, boolean z2, @Nullable String str, @Nullable ClientAppContext clientAppContext) {
        InterfaceC4305r0 c4309t0;
        InterfaceC4321z0 c4273b1;
        this.f20790j = i;
        if (iBinder == null) {
            c4309t0 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            c4309t0 = iInterfaceQueryLocalInterface instanceof InterfaceC4305r0 ? (InterfaceC4305r0) iInterfaceQueryLocalInterface : new C4309t0(iBinder);
        }
        this.f20791k = c4309t0;
        if (iBinder2 == null) {
            c4273b1 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IStatusCallback");
            c4273b1 = iInterfaceQueryLocalInterface2 instanceof InterfaceC4321z0 ? (InterfaceC4321z0) iInterfaceQueryLocalInterface2 : new C4273b1(iBinder2);
        }
        this.f20792l = c4273b1;
        this.f20793m = z2;
        this.f20794n = str;
        this.f20795o = ClientAppContext.m9121w0(clientAppContext, null, str, false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20790j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        C1460d.m566r2(parcel, 2, this.f20791k.asBinder(), false);
        C1460d.m566r2(parcel, 3, this.f20792l.asBinder(), false);
        boolean z2 = this.f20793m;
        parcel.writeInt(262148);
        parcel.writeInt(z2 ? 1 : 0);
        C1460d.m574t2(parcel, 5, this.f20794n, false);
        C1460d.m570s2(parcel, 6, this.f20795o, i, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
