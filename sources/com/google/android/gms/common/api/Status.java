package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p300h.C3335m;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h;
import p007b.p225i.p226a.p288f.p299e.p304k.C3361j;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class Status extends AbstractSafeParcelable implements InterfaceC3273h, ReflectedParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<Status> CREATOR;

    /* JADX INFO: renamed from: j */
    @RecentlyNonNull
    public static final Status f20489j = new Status(0, null);

    /* JADX INFO: renamed from: k */
    @RecentlyNonNull
    public static final Status f20490k = new Status(14, null);

    /* JADX INFO: renamed from: l */
    @RecentlyNonNull
    public static final Status f20491l = new Status(8, null);

    /* JADX INFO: renamed from: m */
    @RecentlyNonNull
    public static final Status f20492m = new Status(15, null);

    /* JADX INFO: renamed from: n */
    @RecentlyNonNull
    public static final Status f20493n = new Status(16, null);

    /* JADX INFO: renamed from: o */
    public final int f20494o;

    /* JADX INFO: renamed from: p */
    public final int f20495p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public final String f20496q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public final PendingIntent f20497r;

    /* JADX INFO: renamed from: s */
    @Nullable
    public final ConnectionResult f20498s;

    static {
        new Status(17, null);
        new Status(18, null);
        CREATOR = new C3335m();
    }

    public Status(int i, int i2, @Nullable String str, @Nullable PendingIntent pendingIntent, @Nullable ConnectionResult connectionResult) {
        this.f20494o = i;
        this.f20495p = i2;
        this.f20496q = str;
        this.f20497r = pendingIntent;
        this.f20498s = connectionResult;
    }

    public Status(int i, @Nullable String str) {
        this.f20494o = 1;
        this.f20495p = i;
        this.f20496q = str;
        this.f20497r = null;
        this.f20498s = null;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h
    @RecentlyNonNull
    /* JADX INFO: renamed from: b0 */
    public Status mo4053b0() {
        return this;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f20494o == status.f20494o && this.f20495p == status.f20495p && C1460d.m524h0(this.f20496q, status.f20496q) && C1460d.m524h0(this.f20497r, status.f20497r) && C1460d.m524h0(this.f20498s, status.f20498s);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f20494o), Integer.valueOf(this.f20495p), this.f20496q, this.f20497r, this.f20498s});
    }

    @RecentlyNonNull
    public String toString() {
        C3361j c3361j = new C3361j(this);
        c3361j.m4162a("statusCode", m9031x0());
        c3361j.m4162a("resolution", this.f20497r);
        return c3361j.toString();
    }

    /* JADX INFO: renamed from: w0 */
    public boolean m9030w0() {
        return this.f20495p <= 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20495p;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        C1460d.m574t2(parcel, 2, this.f20496q, false);
        C1460d.m570s2(parcel, 3, this.f20497r, i, false);
        C1460d.m570s2(parcel, 4, this.f20498s, i, false);
        int i3 = this.f20494o;
        parcel.writeInt(263144);
        parcel.writeInt(i3);
        C1460d.m418A2(parcel, iM594y2);
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: x0 */
    public final String m9031x0() {
        String str = this.f20496q;
        return str != null ? str : C1460d.m420B0(this.f20495p);
    }

    public Status(int i, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this.f20494o = 1;
        this.f20495p = i;
        this.f20496q = str;
        this.f20497r = pendingIntent;
        this.f20498s = null;
    }
}
