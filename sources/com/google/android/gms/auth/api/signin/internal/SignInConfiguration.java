package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b.C3216s;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new C3216s();

    /* JADX INFO: renamed from: j */
    public final String f20461j;

    /* JADX INFO: renamed from: k */
    public GoogleSignInOptions f20462k;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        C1460d.m583w(str);
        this.f20461j = str;
        this.f20462k = googleSignInOptions;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f20461j.equals(signInConfiguration.f20461j)) {
            GoogleSignInOptions googleSignInOptions = this.f20462k;
            if (googleSignInOptions == null) {
                if (signInConfiguration.f20462k == null) {
                    return true;
                }
            } else if (googleSignInOptions.equals(signInConfiguration.f20462k)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f20461j;
        int iHashCode = str == null ? 0 : str.hashCode();
        GoogleSignInOptions googleSignInOptions = this.f20462k;
        return ((iHashCode + 31) * 31) + (googleSignInOptions != null ? googleSignInOptions.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m574t2(parcel, 2, this.f20461j, false);
        C1460d.m570s2(parcel, 5, this.f20462k, i, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
