package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.c.a.a0.d;
import b.i.a.f.c.a.f.g;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable$Creator<SignInAccount> CREATOR = new g();

    @Deprecated
    public String j;
    public GoogleSignInAccount k;

    @Deprecated
    public String l;

    public SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.k = googleSignInAccount;
        d.v(str, "8.3 and 8.4 SDKs require non-null email");
        this.j = str;
        d.v(str2, "8.3 and 8.4 SDKs require non-null userId");
        this.l = str2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        d.t2(parcel, 4, this.j, false);
        d.s2(parcel, 7, this.k, i, false);
        d.t2(parcel, 8, this.l, false);
        d.A2(parcel, iY2);
    }
}
