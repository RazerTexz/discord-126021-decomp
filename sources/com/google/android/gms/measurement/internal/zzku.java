package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.c.a.a0.d;
import b.i.a.f.i.b.s9;
import b.i.a.f.i.b.u9;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzku extends AbstractSafeParcelable {
    public static final Parcelable$Creator<zzku> CREATOR = new s9();
    public final int j;
    public final String k;
    public final long l;
    public final Long m;
    public final String n;
    public final String o;
    public final Double p;

    public zzku(u9 u9Var) {
        this(u9Var.c, u9Var.d, u9Var.e, u9Var.f1576b);
    }

    public final Object w0() {
        Long l = this.m;
        if (l != null) {
            return l;
        }
        Double d = this.p;
        if (d != null) {
            return d;
        }
        String str = this.n;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        d.t2(parcel, 2, this.k, false);
        long j = this.l;
        parcel.writeInt(524291);
        parcel.writeLong(j);
        Long l = this.m;
        if (l != null) {
            parcel.writeInt(524292);
            parcel.writeLong(l.longValue());
        }
        d.t2(parcel, 6, this.n, false);
        d.t2(parcel, 7, this.o, false);
        Double d = this.p;
        if (d != null) {
            parcel.writeInt(524296);
            parcel.writeDouble(d.doubleValue());
        }
        d.A2(parcel, iY2);
    }

    public zzku(String str, long j, Object obj, String str2) {
        d.w(str);
        this.j = 2;
        this.k = str;
        this.l = j;
        this.o = str2;
        if (obj == null) {
            this.m = null;
            this.p = null;
            this.n = null;
            return;
        }
        if (obj instanceof Long) {
            this.m = (Long) obj;
            this.p = null;
            this.n = null;
        } else if (obj instanceof String) {
            this.m = null;
            this.p = null;
            this.n = (String) obj;
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("User attribute given of un-supported type");
            }
            this.m = null;
            this.p = (Double) obj;
            this.n = null;
        }
    }

    public zzku(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        this.j = i;
        this.k = str;
        this.l = j;
        this.m = l;
        if (i == 1) {
            this.p = f != null ? Double.valueOf(f.doubleValue()) : null;
        } else {
            this.p = d;
        }
        this.n = str2;
        this.o = str3;
    }
}
