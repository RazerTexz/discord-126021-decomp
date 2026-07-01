package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.j.b.e.b1;
import b.i.a.f.j.b.e.g0;
import b.i.a.f.j.b.e.r0;
import b.i.a.f.j.b.e.t0;
import b.i.a.f.j.b.e.z0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcb> CREATOR = new g0();
    public final int j;
    public final r0 k;
    public final z0 l;
    public boolean m;

    @Nullable
    @Deprecated
    public String n;

    @Nullable
    @Deprecated
    public final ClientAppContext o;

    public zzcb(int i, IBinder iBinder, IBinder iBinder2, boolean z2, @Nullable String str, @Nullable ClientAppContext clientAppContext) {
        r0 t0Var;
        z0 b1Var;
        this.j = i;
        if (iBinder == null) {
            t0Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            t0Var = iInterfaceQueryLocalInterface instanceof r0 ? (r0) iInterfaceQueryLocalInterface : new t0(iBinder);
        }
        this.k = t0Var;
        if (iBinder2 == null) {
            b1Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IStatusCallback");
            b1Var = iInterfaceQueryLocalInterface2 instanceof z0 ? (z0) iInterfaceQueryLocalInterface2 : new b1(iBinder2);
        }
        this.l = b1Var;
        this.m = z2;
        this.n = str;
        this.o = ClientAppContext.w0(clientAppContext, null, str, false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        AnimatableValueParser.r2(parcel, 2, this.k.asBinder(), false);
        AnimatableValueParser.r2(parcel, 3, this.l.asBinder(), false);
        boolean z2 = this.m;
        parcel.writeInt(262148);
        parcel.writeInt(z2 ? 1 : 0);
        AnimatableValueParser.t2(parcel, 5, this.n, false);
        AnimatableValueParser.s2(parcel, 6, this.o, i, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
