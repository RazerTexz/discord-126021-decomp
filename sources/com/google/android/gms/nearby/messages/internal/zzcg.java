package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.j.b.e.j0;
import b.i.a.f.j.b.e.o0;
import b.i.a.f.j.b.e.q0;
import b.i.a.f.j.b.e.r0;
import b.i.a.f.j.b.e.t0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcg> CREATOR = new j0();
    public final int j;

    @Nullable
    public final o0 k;
    public final r0 l;

    @Nullable
    public final PendingIntent m;

    @Deprecated
    public final int n;

    @Nullable
    @Deprecated
    public final String o;

    @Nullable
    @Deprecated
    public final String p;

    @Deprecated
    public final boolean q;

    @Nullable
    @Deprecated
    public final ClientAppContext r;

    @VisibleForTesting
    public zzcg(int i, @Nullable IBinder iBinder, IBinder iBinder2, @Nullable PendingIntent pendingIntent, int i2, @Nullable String str, @Nullable String str2, boolean z2, @Nullable ClientAppContext clientAppContext) {
        o0 q0Var;
        this.j = i;
        r0 t0Var = null;
        if (iBinder == null) {
            q0Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            q0Var = iInterfaceQueryLocalInterface instanceof o0 ? (o0) iInterfaceQueryLocalInterface : new q0(iBinder);
        }
        this.k = q0Var;
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            t0Var = iInterfaceQueryLocalInterface2 instanceof r0 ? (r0) iInterfaceQueryLocalInterface2 : new t0(iBinder2);
        }
        this.l = t0Var;
        this.m = pendingIntent;
        this.n = i2;
        this.o = str;
        this.p = str2;
        this.q = z2;
        this.r = ClientAppContext.w0(clientAppContext, str2, str, z2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        o0 o0Var = this.k;
        AnimatableValueParser.r2(parcel, 2, o0Var == null ? null : o0Var.asBinder(), false);
        AnimatableValueParser.r2(parcel, 3, this.l.asBinder(), false);
        AnimatableValueParser.s2(parcel, 4, this.m, i, false);
        int i3 = this.n;
        parcel.writeInt(262149);
        parcel.writeInt(i3);
        AnimatableValueParser.t2(parcel, 6, this.o, false);
        AnimatableValueParser.t2(parcel, 7, this.p, false);
        boolean z2 = this.q;
        parcel.writeInt(262152);
        parcel.writeInt(z2 ? 1 : 0);
        AnimatableValueParser.s2(parcel, 9, this.r, i, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
