package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.c.a.f.b.s;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new s();
    public final String j;
    public GoogleSignInOptions k;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        AnimatableValueParser.w(str);
        this.j = str;
        this.k = googleSignInOptions;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.j.equals(signInConfiguration.j)) {
            GoogleSignInOptions googleSignInOptions = this.k;
            if (googleSignInOptions == null) {
                if (signInConfiguration.k == null) {
                    return true;
                }
            } else if (googleSignInOptions.equals(signInConfiguration.k)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.j;
        int iHashCode = str == null ? 0 : str.hashCode();
        GoogleSignInOptions googleSignInOptions = this.k;
        return ((iHashCode + 31) * 31) + (googleSignInOptions != null ? googleSignInOptions.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.t2(parcel, 2, this.j, false);
        AnimatableValueParser.s2(parcel, 5, this.k, i, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
