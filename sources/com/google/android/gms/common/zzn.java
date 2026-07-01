package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.c0;
import b.i.a.f.f.a;
import b.i.a.f.f.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new c0();
    public final String j;
    public final boolean k;
    public final boolean l;
    public final Context m;
    public final boolean n;

    public zzn(String str, boolean z2, boolean z3, IBinder iBinder, boolean z4) {
        this.j = str;
        this.k = z2;
        this.l = z3;
        this.m = (Context) b.i(a.AbstractBinderC0040a.g(iBinder));
        this.n = z4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.t2(parcel, 1, this.j, false);
        boolean z2 = this.k;
        parcel.writeInt(262146);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.l;
        parcel.writeInt(262147);
        parcel.writeInt(z3 ? 1 : 0);
        AnimatableValueParser.r2(parcel, 4, new b(this.m), false);
        boolean z4 = this.n;
        parcel.writeInt(262149);
        parcel.writeInt(z4 ? 1 : 0);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
