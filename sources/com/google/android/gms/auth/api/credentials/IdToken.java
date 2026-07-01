package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.i.a.f.c.a.d.i;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class IdToken extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable$Creator<IdToken> CREATOR = new i();

    @NonNull
    public final String j;

    @NonNull
    public final String k;

    public IdToken(@NonNull String str, @NonNull String str2) {
        d.o(!TextUtils.isEmpty(str), "account type string cannot be null or empty");
        d.o(!TextUtils.isEmpty(str2), "id token string cannot be null or empty");
        this.j = str;
        this.k = str2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdToken)) {
            return false;
        }
        IdToken idToken = (IdToken) obj;
        return d.h0(this.j, idToken.j) && d.h0(this.k, idToken.k);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        d.t2(parcel, 1, this.j, false);
        d.t2(parcel, 2, this.k, false);
        d.A2(parcel, iY2);
    }
}
