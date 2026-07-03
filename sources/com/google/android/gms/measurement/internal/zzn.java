package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p330i.p332b.C4262z9;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new C4262z9();

    /* JADX INFO: renamed from: A */
    public final String f20677A;

    /* JADX INFO: renamed from: B */
    public final Boolean f20678B;

    /* JADX INFO: renamed from: C */
    public final long f20679C;

    /* JADX INFO: renamed from: D */
    public final List<String> f20680D;

    /* JADX INFO: renamed from: E */
    public final String f20681E;

    /* JADX INFO: renamed from: F */
    public final String f20682F;

    /* JADX INFO: renamed from: j */
    public final String f20683j;

    /* JADX INFO: renamed from: k */
    public final String f20684k;

    /* JADX INFO: renamed from: l */
    public final String f20685l;

    /* JADX INFO: renamed from: m */
    public final String f20686m;

    /* JADX INFO: renamed from: n */
    public final long f20687n;

    /* JADX INFO: renamed from: o */
    public final long f20688o;

    /* JADX INFO: renamed from: p */
    public final String f20689p;

    /* JADX INFO: renamed from: q */
    public final boolean f20690q;

    /* JADX INFO: renamed from: r */
    public final boolean f20691r;

    /* JADX INFO: renamed from: s */
    public final long f20692s;

    /* JADX INFO: renamed from: t */
    public final String f20693t;

    /* JADX INFO: renamed from: u */
    public final long f20694u;

    /* JADX INFO: renamed from: v */
    public final long f20695v;

    /* JADX INFO: renamed from: w */
    public final int f20696w;

    /* JADX INFO: renamed from: x */
    public final boolean f20697x;

    /* JADX INFO: renamed from: y */
    public final boolean f20698y;

    /* JADX INFO: renamed from: z */
    public final boolean f20699z;

    public zzn(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z2, boolean z3, String str6, long j4, long j5, int i, boolean z4, boolean z5, boolean z6, String str7, Boolean bool, long j6, List<String> list, String str8, String str9) {
        C1460d.m583w(str);
        this.f20683j = str;
        this.f20684k = TextUtils.isEmpty(str2) ? null : str2;
        this.f20685l = str3;
        this.f20692s = j;
        this.f20686m = str4;
        this.f20687n = j2;
        this.f20688o = j3;
        this.f20689p = str5;
        this.f20690q = z2;
        this.f20691r = z3;
        this.f20693t = str6;
        this.f20694u = j4;
        this.f20695v = j5;
        this.f20696w = i;
        this.f20697x = z4;
        this.f20698y = z5;
        this.f20699z = z6;
        this.f20677A = str7;
        this.f20678B = bool;
        this.f20679C = j6;
        this.f20680D = list;
        this.f20681E = str8;
        this.f20682F = str9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m574t2(parcel, 2, this.f20683j, false);
        C1460d.m574t2(parcel, 3, this.f20684k, false);
        C1460d.m574t2(parcel, 4, this.f20685l, false);
        C1460d.m574t2(parcel, 5, this.f20686m, false);
        long j = this.f20687n;
        parcel.writeInt(524294);
        parcel.writeLong(j);
        long j2 = this.f20688o;
        parcel.writeInt(524295);
        parcel.writeLong(j2);
        C1460d.m574t2(parcel, 8, this.f20689p, false);
        boolean z2 = this.f20690q;
        parcel.writeInt(262153);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.f20691r;
        parcel.writeInt(262154);
        parcel.writeInt(z3 ? 1 : 0);
        long j3 = this.f20692s;
        parcel.writeInt(524299);
        parcel.writeLong(j3);
        C1460d.m574t2(parcel, 12, this.f20693t, false);
        long j4 = this.f20694u;
        parcel.writeInt(524301);
        parcel.writeLong(j4);
        long j5 = this.f20695v;
        parcel.writeInt(524302);
        parcel.writeLong(j5);
        int i2 = this.f20696w;
        parcel.writeInt(262159);
        parcel.writeInt(i2);
        boolean z4 = this.f20697x;
        parcel.writeInt(262160);
        parcel.writeInt(z4 ? 1 : 0);
        boolean z5 = this.f20698y;
        parcel.writeInt(262161);
        parcel.writeInt(z5 ? 1 : 0);
        boolean z6 = this.f20699z;
        parcel.writeInt(262162);
        parcel.writeInt(z6 ? 1 : 0);
        C1460d.m574t2(parcel, 19, this.f20677A, false);
        Boolean bool = this.f20678B;
        if (bool != null) {
            parcel.writeInt(262165);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        long j6 = this.f20679C;
        parcel.writeInt(524310);
        parcel.writeLong(j6);
        List<String> list = this.f20680D;
        if (list != null) {
            int iM594y3 = C1460d.m594y2(parcel, 23);
            parcel.writeStringList(list);
            C1460d.m418A2(parcel, iM594y3);
        }
        C1460d.m574t2(parcel, 24, this.f20681E, false);
        C1460d.m574t2(parcel, 25, this.f20682F, false);
        C1460d.m418A2(parcel, iM594y2);
    }

    public zzn(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z2, boolean z3, long j3, String str6, long j4, long j5, int i, boolean z4, boolean z5, boolean z6, String str7, Boolean bool, long j6, List<String> list, String str8, String str9) {
        this.f20683j = str;
        this.f20684k = str2;
        this.f20685l = str3;
        this.f20692s = j3;
        this.f20686m = str4;
        this.f20687n = j;
        this.f20688o = j2;
        this.f20689p = str5;
        this.f20690q = z2;
        this.f20691r = z3;
        this.f20693t = str6;
        this.f20694u = j4;
        this.f20695v = j5;
        this.f20696w = i;
        this.f20697x = z4;
        this.f20698y = z5;
        this.f20699z = z6;
        this.f20677A = str7;
        this.f20678B = bool;
        this.f20679C = j6;
        this.f20680D = list;
        this.f20681E = str8;
        this.f20682F = str9;
    }
}
