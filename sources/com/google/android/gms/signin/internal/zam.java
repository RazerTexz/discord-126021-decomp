package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.l.b.j;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zau;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new j();
    public final int j;
    public final ConnectionResult k;

    @Nullable
    public final zau l;

    public zam(int i, ConnectionResult connectionResult, @Nullable zau zauVar) {
        this.j = i;
        this.k = connectionResult;
        this.l = zauVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        AnimatableValueParser.s2(parcel, 2, this.k, i, false);
        AnimatableValueParser.s2(parcel, 3, this.l, i, false);
        AnimatableValueParser.A2(parcel, iY2);
    }

    public zam() {
        ConnectionResult connectionResult = new ConnectionResult(8, null);
        this.j = 1;
        this.k = connectionResult;
        this.l = null;
    }
}
