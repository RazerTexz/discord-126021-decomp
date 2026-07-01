package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.h.h;
import b.i.a.f.e.h.m;
import b.i.a.f.e.k.j;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class Status extends AbstractSafeParcelable implements h, ReflectedParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<Status> CREATOR;

    @RecentlyNonNull
    public static final Status j = new Status(0, null);

    @RecentlyNonNull
    public static final Status k = new Status(14, null);

    @RecentlyNonNull
    public static final Status l = new Status(8, null);

    @RecentlyNonNull
    public static final Status m = new Status(15, null);

    @RecentlyNonNull
    public static final Status n = new Status(16, null);
    public final int o;
    public final int p;

    @Nullable
    public final String q;

    @Nullable
    public final PendingIntent r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public final ConnectionResult f3003s;

    static {
        new Status(17, null);
        new Status(18, null);
        CREATOR = new m();
    }

    public Status(int i, int i2, @Nullable String str, @Nullable PendingIntent pendingIntent, @Nullable ConnectionResult connectionResult) {
        this.o = i;
        this.p = i2;
        this.q = str;
        this.r = pendingIntent;
        this.f3003s = connectionResult;
    }

    public Status(int i, @Nullable String str) {
        this.o = 1;
        this.p = i;
        this.q = str;
        this.r = null;
        this.f3003s = null;
    }

    @Override // b.i.a.f.e.h.h
    @RecentlyNonNull
    public Status b0() {
        return this;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.o == status.o && this.p == status.p && AnimatableValueParser.h0(this.q, status.q) && AnimatableValueParser.h0(this.r, status.r) && AnimatableValueParser.h0(this.f3003s, status.f3003s);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.o), Integer.valueOf(this.p), this.q, this.r, this.f3003s});
    }

    @RecentlyNonNull
    public String toString() {
        j jVar = new j(this);
        jVar.a("statusCode", x0());
        jVar.a("resolution", this.r);
        return jVar.toString();
    }

    public boolean w0() {
        return this.p <= 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.p;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        AnimatableValueParser.t2(parcel, 2, this.q, false);
        AnimatableValueParser.s2(parcel, 3, this.r, i, false);
        AnimatableValueParser.s2(parcel, 4, this.f3003s, i, false);
        int i3 = this.o;
        parcel.writeInt(263144);
        parcel.writeInt(i3);
        AnimatableValueParser.A2(parcel, iY2);
    }

    @RecentlyNonNull
    public final String x0() {
        String str = this.q;
        return str != null ? str : AnimatableValueParser.B0(this.p);
    }

    public Status(int i, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this.o = 1;
        this.p = i;
        this.q = str;
        this.r = pendingIntent;
        this.f3003s = null;
    }
}
