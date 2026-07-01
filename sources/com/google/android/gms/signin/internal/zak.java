package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.l.b.i;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zas;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new i();
    public final int j;
    public final zas k;

    public zak(int i, zas zasVar) {
        this.j = i;
        this.k = zasVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        AnimatableValueParser.s2(parcel, 2, this.k, i, false);
        AnimatableValueParser.A2(parcel, iY2);
    }

    public zak(zas zasVar) {
        this.j = 1;
        this.k = zasVar;
    }
}
