package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.i.a.f.c.a.d.e;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable$Creator<Credential> CREATOR = new e();
    public final String j;

    @Nullable
    public final String k;

    @Nullable
    public final Uri l;
    public final List<IdToken> m;

    @Nullable
    public final String n;

    @Nullable
    public final String o;

    @Nullable
    public final String p;

    @Nullable
    public final String q;

    public Credential(String str, @Nullable String str2, @Nullable Uri uri, List<IdToken> list, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        d.z(str, "credential identifier cannot be null");
        String strTrim = str.trim();
        d.v(strTrim, "credential identifier cannot be empty");
        if (str3 != null && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Password must not be empty if set");
        }
        if (str4 != null) {
            boolean z2 = false;
            if (!TextUtils.isEmpty(str4)) {
                Uri uri2 = Uri.parse(str4);
                if (uri2.isAbsolute() && uri2.isHierarchical() && !TextUtils.isEmpty(uri2.getScheme()) && !TextUtils.isEmpty(uri2.getAuthority()) && ("http".equalsIgnoreCase(uri2.getScheme()) || Constants.SCHEME.equalsIgnoreCase(uri2.getScheme()))) {
                    z2 = true;
                }
            }
            if (!Boolean.valueOf(z2).booleanValue()) {
                throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
            }
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
        }
        if (str2 != null && TextUtils.isEmpty(str2.trim())) {
            str2 = null;
        }
        this.k = str2;
        this.l = uri;
        this.m = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.j = strTrim;
        this.n = str3;
        this.o = str4;
        this.p = str5;
        this.q = str6;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.j, credential.j) && TextUtils.equals(this.k, credential.k) && d.h0(this.l, credential.l) && TextUtils.equals(this.n, credential.n) && TextUtils.equals(this.o, credential.o);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.j, this.k, this.l, this.n, this.o});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        d.t2(parcel, 1, this.j, false);
        d.t2(parcel, 2, this.k, false);
        d.s2(parcel, 3, this.l, i, false);
        d.w2(parcel, 4, this.m, false);
        d.t2(parcel, 5, this.n, false);
        d.t2(parcel, 6, this.o, false);
        d.t2(parcel, 9, this.p, false);
        d.t2(parcel, 10, this.q, false);
        d.A2(parcel, iY2);
    }
}
