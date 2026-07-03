package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p300h.C3334l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<Scope> CREATOR = new C3334l();

    /* JADX INFO: renamed from: j */
    public final int f20487j;

    /* JADX INFO: renamed from: k */
    public final String f20488k;

    public Scope(@RecentlyNonNull String str) {
        C1460d.m579v(str, "scopeUri must not be null or empty");
        this.f20487j = 1;
        this.f20488k = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f20488k.equals(((Scope) obj).f20488k);
        }
        return false;
    }

    public int hashCode() {
        return this.f20488k.hashCode();
    }

    @RecentlyNonNull
    public String toString() {
        return this.f20488k;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20487j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        C1460d.m574t2(parcel, 2, this.f20488k, false);
        C1460d.m418A2(parcel, iM594y2);
    }

    public Scope(int i, String str) {
        C1460d.m579v(str, "scopeUri must not be null or empty");
        this.f20487j = i;
        this.f20488k = str;
    }
}
