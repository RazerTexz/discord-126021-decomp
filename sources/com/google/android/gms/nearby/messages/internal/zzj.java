package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.j.b.e.n0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new n0();
    public final int j;

    @Nullable
    @Deprecated
    public final ClientAppContext k;
    public final int l;

    public zzj(int i) {
        this.j = 1;
        this.k = null;
        this.l = i;
    }

    public zzj(int i, ClientAppContext clientAppContext, int i2) {
        this.j = i;
        this.k = clientAppContext;
        this.l = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        AnimatableValueParser.s2(parcel, 2, this.k, i, false);
        int i3 = this.l;
        parcel.writeInt(262147);
        parcel.writeInt(i3);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
