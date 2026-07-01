package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.h.l;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<Scope> CREATOR = new l();
    public final int j;
    public final String k;

    public Scope(@RecentlyNonNull String str) {
        AnimatableValueParser.v(str, "scopeUri must not be null or empty");
        this.j = 1;
        this.k = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.k.equals(((Scope) obj).k);
        }
        return false;
    }

    public int hashCode() {
        return this.k.hashCode();
    }

    @RecentlyNonNull
    public String toString() {
        return this.k;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        AnimatableValueParser.t2(parcel, 2, this.k, false);
        AnimatableValueParser.A2(parcel, iY2);
    }

    public Scope(int i, String str) {
        AnimatableValueParser.v(str, "scopeUri must not be null or empty");
        this.j = i;
        this.k = str;
    }
}
