package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4289j0;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4303q0;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4309t0;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4299o0;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4305r0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcg> CREATOR = new C4289j0();

    /* JADX INFO: renamed from: j */
    public final int f20803j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public final InterfaceC4299o0 f20804k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC4305r0 f20805l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public final PendingIntent f20806m;

    /* JADX INFO: renamed from: n */
    @Deprecated
    public final int f20807n;

    /* JADX INFO: renamed from: o */
    @Nullable
    @Deprecated
    public final String f20808o;

    /* JADX INFO: renamed from: p */
    @Nullable
    @Deprecated
    public final String f20809p;

    /* JADX INFO: renamed from: q */
    @Deprecated
    public final boolean f20810q;

    /* JADX INFO: renamed from: r */
    @Nullable
    @Deprecated
    public final ClientAppContext f20811r;

    @VisibleForTesting
    public zzcg(int i, @Nullable IBinder iBinder, IBinder iBinder2, @Nullable PendingIntent pendingIntent, int i2, @Nullable String str, @Nullable String str2, boolean z2, @Nullable ClientAppContext clientAppContext) {
        InterfaceC4299o0 c4303q0;
        this.f20803j = i;
        InterfaceC4305r0 c4309t0 = null;
        if (iBinder == null) {
            c4303q0 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            c4303q0 = iInterfaceQueryLocalInterface instanceof InterfaceC4299o0 ? (InterfaceC4299o0) iInterfaceQueryLocalInterface : new C4303q0(iBinder);
        }
        this.f20804k = c4303q0;
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            c4309t0 = iInterfaceQueryLocalInterface2 instanceof InterfaceC4305r0 ? (InterfaceC4305r0) iInterfaceQueryLocalInterface2 : new C4309t0(iBinder2);
        }
        this.f20805l = c4309t0;
        this.f20806m = pendingIntent;
        this.f20807n = i2;
        this.f20808o = str;
        this.f20809p = str2;
        this.f20810q = z2;
        this.f20811r = ClientAppContext.m9121w0(clientAppContext, str2, str, z2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20803j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        InterfaceC4299o0 interfaceC4299o0 = this.f20804k;
        C1460d.m566r2(parcel, 2, interfaceC4299o0 == null ? null : interfaceC4299o0.asBinder(), false);
        C1460d.m566r2(parcel, 3, this.f20805l.asBinder(), false);
        C1460d.m570s2(parcel, 4, this.f20806m, i, false);
        int i3 = this.f20807n;
        parcel.writeInt(262149);
        parcel.writeInt(i3);
        C1460d.m574t2(parcel, 6, this.f20808o, false);
        C1460d.m574t2(parcel, 7, this.f20809p, false);
        boolean z2 = this.f20810q;
        parcel.writeInt(262152);
        parcel.writeInt(z2 ? 1 : 0);
        C1460d.m570s2(parcel, 9, this.f20811r, i, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
