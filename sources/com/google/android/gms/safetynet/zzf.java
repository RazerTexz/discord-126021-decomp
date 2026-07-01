package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.c.a.a0.d;
import b.i.a.f.k.e;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable$Creator<zzf> CREATOR = new e();
    public final String j;

    public zzf(String str) {
        this.j = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        d.t2(parcel, 2, this.j, false);
        d.A2(parcel, iY2);
    }
}
