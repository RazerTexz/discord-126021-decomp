package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.nearby.messages.Strategy;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4281f0;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4309t0;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4319y0;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4305r0;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4315w0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbz> CREATOR = new C4281f0();

    /* JADX INFO: renamed from: j */
    public final int f20779j;

    /* JADX INFO: renamed from: k */
    public final zzaf f20780k;

    /* JADX INFO: renamed from: l */
    public final Strategy f20781l;

    /* JADX INFO: renamed from: m */
    public final InterfaceC4305r0 f20782m;

    /* JADX INFO: renamed from: n */
    @Nullable
    @Deprecated
    public final String f20783n;

    /* JADX INFO: renamed from: o */
    @Nullable
    @Deprecated
    public final String f20784o;

    /* JADX INFO: renamed from: p */
    @Deprecated
    public final boolean f20785p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public final InterfaceC4315w0 f20786q;

    /* JADX INFO: renamed from: r */
    @Deprecated
    public final boolean f20787r;

    /* JADX INFO: renamed from: s */
    @Deprecated
    public final ClientAppContext f20788s;

    /* JADX INFO: renamed from: t */
    public final int f20789t;

    public zzbz(int i, zzaf zzafVar, Strategy strategy, IBinder iBinder, @Nullable String str, @Nullable String str2, boolean z2, @Nullable IBinder iBinder2, boolean z3, @Nullable ClientAppContext clientAppContext, int i2) {
        InterfaceC4305r0 c4309t0;
        this.f20779j = i;
        this.f20780k = zzafVar;
        this.f20781l = strategy;
        InterfaceC4315w0 c4319y0 = null;
        if (iBinder == null) {
            c4309t0 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            c4309t0 = iInterfaceQueryLocalInterface instanceof InterfaceC4305r0 ? (InterfaceC4305r0) iInterfaceQueryLocalInterface : new C4309t0(iBinder);
        }
        this.f20782m = c4309t0;
        this.f20783n = str;
        this.f20784o = str2;
        this.f20785p = z2;
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IPublishCallback");
            c4319y0 = iInterfaceQueryLocalInterface2 instanceof InterfaceC4315w0 ? (InterfaceC4315w0) iInterfaceQueryLocalInterface2 : new C4319y0(iBinder2);
        }
        this.f20786q = c4319y0;
        this.f20787r = z3;
        this.f20788s = ClientAppContext.m9121w0(clientAppContext, str2, str, z3);
        this.f20789t = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20779j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        C1460d.m570s2(parcel, 2, this.f20780k, i, false);
        C1460d.m570s2(parcel, 3, this.f20781l, i, false);
        C1460d.m566r2(parcel, 4, this.f20782m.asBinder(), false);
        C1460d.m574t2(parcel, 5, this.f20783n, false);
        C1460d.m574t2(parcel, 6, this.f20784o, false);
        boolean z2 = this.f20785p;
        parcel.writeInt(262151);
        parcel.writeInt(z2 ? 1 : 0);
        InterfaceC4315w0 interfaceC4315w0 = this.f20786q;
        C1460d.m566r2(parcel, 8, interfaceC4315w0 == null ? null : interfaceC4315w0.asBinder(), false);
        boolean z3 = this.f20787r;
        parcel.writeInt(262153);
        parcel.writeInt(z3 ? 1 : 0);
        C1460d.m570s2(parcel, 10, this.f20788s, i, false);
        int i3 = this.f20789t;
        parcel.writeInt(262155);
        parcel.writeInt(i3);
        C1460d.m418A2(parcel, iM594y2);
    }
}
