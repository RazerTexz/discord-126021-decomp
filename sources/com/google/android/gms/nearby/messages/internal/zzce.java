package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.j.b.e.i0;
import b.i.a.f.j.b.e.r0;
import b.i.a.f.j.b.e.t0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzce extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzce> CREATOR = new i0();
    public final int j;
    public final zzaf k;
    public final r0 l;

    @Nullable
    @Deprecated
    public final String m;

    @Nullable
    @Deprecated
    public final String n;

    @Deprecated
    public final boolean o;

    @Nullable
    @Deprecated
    public final ClientAppContext p;

    public zzce(int i, zzaf zzafVar, IBinder iBinder, @Nullable String str, @Nullable String str2, boolean z2, @Nullable ClientAppContext clientAppContext) {
        r0 t0Var;
        this.j = i;
        this.k = zzafVar;
        if (iBinder == null) {
            t0Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            t0Var = iInterfaceQueryLocalInterface instanceof r0 ? (r0) iInterfaceQueryLocalInterface : new t0(iBinder);
        }
        this.l = t0Var;
        this.m = str;
        this.n = str2;
        this.o = z2;
        this.p = ClientAppContext.w0(clientAppContext, str2, str, z2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        AnimatableValueParser.s2(parcel, 2, this.k, i, false);
        AnimatableValueParser.r2(parcel, 3, this.l.asBinder(), false);
        AnimatableValueParser.t2(parcel, 4, this.m, false);
        AnimatableValueParser.t2(parcel, 5, this.n, false);
        boolean z2 = this.o;
        parcel.writeInt(262150);
        parcel.writeInt(z2 ? 1 : 0);
        AnimatableValueParser.s2(parcel, 7, this.p, i, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
