package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.c.a.a0.d;
import b.i.a.f.c.a.f.b.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable$Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new b();
    public final int j;
    public int k;
    public Bundle l;

    public GoogleSignInOptionsExtensionParcelable(int i, int i2, Bundle bundle) {
        this.j = i;
        this.k = i2;
        this.l = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.k;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        d.p2(parcel, 3, this.l, false);
        d.A2(parcel, iY2);
    }
}
