package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.i.b.z9;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new z9();
    public final String A;
    public final Boolean B;
    public final long C;
    public final List<String> D;
    public final String E;
    public final String F;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final long n;
    public final long o;
    public final String p;
    public final boolean q;
    public final boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f3012s;
    public final String t;
    public final long u;
    public final long v;
    public final int w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f3013x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f3014y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f3015z;

    public zzn(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z2, boolean z3, String str6, long j4, long j5, int i, boolean z4, boolean z5, boolean z6, String str7, Boolean bool, long j6, List<String> list, String str8, String str9) {
        AnimatableValueParser.w(str);
        this.j = str;
        this.k = TextUtils.isEmpty(str2) ? null : str2;
        this.l = str3;
        this.f3012s = j;
        this.m = str4;
        this.n = j2;
        this.o = j3;
        this.p = str5;
        this.q = z2;
        this.r = z3;
        this.t = str6;
        this.u = j4;
        this.v = j5;
        this.w = i;
        this.f3013x = z4;
        this.f3014y = z5;
        this.f3015z = z6;
        this.A = str7;
        this.B = bool;
        this.C = j6;
        this.D = list;
        this.E = str8;
        this.F = str9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.t2(parcel, 2, this.j, false);
        AnimatableValueParser.t2(parcel, 3, this.k, false);
        AnimatableValueParser.t2(parcel, 4, this.l, false);
        AnimatableValueParser.t2(parcel, 5, this.m, false);
        long j = this.n;
        parcel.writeInt(524294);
        parcel.writeLong(j);
        long j2 = this.o;
        parcel.writeInt(524295);
        parcel.writeLong(j2);
        AnimatableValueParser.t2(parcel, 8, this.p, false);
        boolean z2 = this.q;
        parcel.writeInt(262153);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.r;
        parcel.writeInt(262154);
        parcel.writeInt(z3 ? 1 : 0);
        long j3 = this.f3012s;
        parcel.writeInt(524299);
        parcel.writeLong(j3);
        AnimatableValueParser.t2(parcel, 12, this.t, false);
        long j4 = this.u;
        parcel.writeInt(524301);
        parcel.writeLong(j4);
        long j5 = this.v;
        parcel.writeInt(524302);
        parcel.writeLong(j5);
        int i2 = this.w;
        parcel.writeInt(262159);
        parcel.writeInt(i2);
        boolean z4 = this.f3013x;
        parcel.writeInt(262160);
        parcel.writeInt(z4 ? 1 : 0);
        boolean z5 = this.f3014y;
        parcel.writeInt(262161);
        parcel.writeInt(z5 ? 1 : 0);
        boolean z6 = this.f3015z;
        parcel.writeInt(262162);
        parcel.writeInt(z6 ? 1 : 0);
        AnimatableValueParser.t2(parcel, 19, this.A, false);
        Boolean bool = this.B;
        if (bool != null) {
            parcel.writeInt(262165);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        long j6 = this.C;
        parcel.writeInt(524310);
        parcel.writeLong(j6);
        List<String> list = this.D;
        if (list != null) {
            int iY3 = AnimatableValueParser.y2(parcel, 23);
            parcel.writeStringList(list);
            AnimatableValueParser.A2(parcel, iY3);
        }
        AnimatableValueParser.t2(parcel, 24, this.E, false);
        AnimatableValueParser.t2(parcel, 25, this.F, false);
        AnimatableValueParser.A2(parcel, iY2);
    }

    public zzn(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z2, boolean z3, long j3, String str6, long j4, long j5, int i, boolean z4, boolean z5, boolean z6, String str7, Boolean bool, long j6, List<String> list, String str8, String str9) {
        this.j = str;
        this.k = str2;
        this.l = str3;
        this.f3012s = j3;
        this.m = str4;
        this.n = j;
        this.o = j2;
        this.p = str5;
        this.q = z2;
        this.r = z3;
        this.t = str6;
        this.u = j4;
        this.v = j5;
        this.w = i;
        this.f3013x = z4;
        this.f3014y = z5;
        this.f3015z = z6;
        this.A = str7;
        this.B = bool;
        this.C = j6;
        this.D = list;
        this.E = str8;
        this.F = str9;
    }
}
