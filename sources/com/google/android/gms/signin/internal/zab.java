package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.h.h;
import b.i.a.f.l.b.b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zab extends AbstractSafeParcelable implements h {
    public static final Parcelable.Creator<zab> CREATOR = new b();
    public final int j;
    public int k;

    @Nullable
    public Intent l;

    public zab() {
        this.j = 2;
        this.k = 0;
        this.l = null;
    }

    @Override // b.i.a.f.e.h.h
    public final Status b0() {
        return this.k == 0 ? Status.j : Status.n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.k;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        AnimatableValueParser.s2(parcel, 3, this.l, i, false);
        AnimatableValueParser.A2(parcel, iY2);
    }

    public zab(int i, int i2, @Nullable Intent intent) {
        this.j = i;
        this.k = i2;
        this.l = intent;
    }
}
