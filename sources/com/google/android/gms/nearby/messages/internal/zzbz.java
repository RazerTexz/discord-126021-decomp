package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.i.a.f.j.b.e.f0;
import b.i.a.f.j.b.e.r0;
import b.i.a.f.j.b.e.t0;
import b.i.a.f.j.b.e.w0;
import b.i.a.f.j.b.e.y0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.nearby.messages.Strategy;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbz extends AbstractSafeParcelable {
    public static final Parcelable$Creator<zzbz> CREATOR = new f0();
    public final int j;
    public final zzaf k;
    public final Strategy l;
    public final r0 m;

    @Nullable
    @Deprecated
    public final String n;

    @Nullable
    @Deprecated
    public final String o;

    @Deprecated
    public final boolean p;

    @Nullable
    public final w0 q;

    @Deprecated
    public final boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Deprecated
    public final ClientAppContext f3024s;
    public final int t;

    public zzbz(int i, zzaf zzafVar, Strategy strategy, IBinder iBinder, @Nullable String str, @Nullable String str2, boolean z2, @Nullable IBinder iBinder2, boolean z3, @Nullable ClientAppContext clientAppContext, int i2) {
        r0 t0Var;
        this.j = i;
        this.k = zzafVar;
        this.l = strategy;
        w0 y0Var = null;
        if (iBinder == null) {
            t0Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            t0Var = iInterfaceQueryLocalInterface instanceof r0 ? (r0) iInterfaceQueryLocalInterface : new t0(iBinder);
        }
        this.m = t0Var;
        this.n = str;
        this.o = str2;
        this.p = z2;
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IPublishCallback");
            y0Var = iInterfaceQueryLocalInterface2 instanceof w0 ? (w0) iInterfaceQueryLocalInterface2 : new y0(iBinder2);
        }
        this.q = y0Var;
        this.r = z3;
        this.f3024s = ClientAppContext.w0(clientAppContext, str2, str, z3);
        this.t = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        d.s2(parcel, 2, this.k, i, false);
        d.s2(parcel, 3, this.l, i, false);
        d.r2(parcel, 4, this.m.asBinder(), false);
        d.t2(parcel, 5, this.n, false);
        d.t2(parcel, 6, this.o, false);
        boolean z2 = this.p;
        parcel.writeInt(262151);
        parcel.writeInt(z2 ? 1 : 0);
        w0 w0Var = this.q;
        d.r2(parcel, 8, w0Var == null ? null : w0Var.asBinder(), false);
        boolean z3 = this.r;
        parcel.writeInt(262153);
        parcel.writeInt(z3 ? 1 : 0);
        d.s2(parcel, 10, this.f3024s, i, false);
        int i3 = this.t;
        parcel.writeInt(262155);
        parcel.writeInt(i3);
        d.A2(parcel, iY2);
    }
}
