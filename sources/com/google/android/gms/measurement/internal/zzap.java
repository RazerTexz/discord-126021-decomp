package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.i.b.n;
import b.i.a.f.i.b.o;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzap extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzap> CREATOR = new o();
    public final Bundle j;

    public zzap(Bundle bundle) {
        this.j = bundle;
    }

    public final String A0(String str) {
        return this.j.getString(str);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new n(this);
    }

    public final String toString() {
        return this.j.toString();
    }

    public final Object w0(String str) {
        return this.j.get(str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.p2(parcel, 2, x0(), false);
        AnimatableValueParser.A2(parcel, iY2);
    }

    public final Bundle x0() {
        return new Bundle(this.j);
    }

    public final Long y0(String str) {
        return Long.valueOf(this.j.getLong(str));
    }

    public final Double z0(String str) {
        return Double.valueOf(this.j.getDouble(str));
    }
}
