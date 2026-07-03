package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p292c.p293a.p294d.C3190e;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new C3190e();

    /* JADX INFO: renamed from: j */
    public final String f20389j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public final String f20390k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public final Uri f20391l;

    /* JADX INFO: renamed from: m */
    public final List<IdToken> f20392m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public final String f20393n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public final String f20394o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public final String f20395p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public final String f20396q;

    /* JADX INFO: renamed from: com.google.android.gms.auth.api.credentials.Credential$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    public static class C10792a {

        /* JADX INFO: renamed from: a */
        public final String f20397a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public String f20398b;

        /* JADX INFO: renamed from: c */
        @Nullable
        public Uri f20399c;

        /* JADX INFO: renamed from: d */
        @Nullable
        public String f20400d;

        public C10792a(String str) {
            this.f20397a = str;
        }

        /* JADX INFO: renamed from: a */
        public Credential m9009a() {
            return new Credential(this.f20397a, this.f20398b, this.f20399c, null, this.f20400d, null, null, null);
        }
    }

    public Credential(String str, @Nullable String str2, @Nullable Uri uri, List<IdToken> list, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        C1460d.m595z(str, "credential identifier cannot be null");
        String strTrim = str.trim();
        C1460d.m579v(strTrim, "credential identifier cannot be empty");
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
        this.f20390k = str2;
        this.f20391l = uri;
        this.f20392m = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f20389j = strTrim;
        this.f20393n = str3;
        this.f20394o = str4;
        this.f20395p = str5;
        this.f20396q = str6;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.f20389j, credential.f20389j) && TextUtils.equals(this.f20390k, credential.f20390k) && C1460d.m524h0(this.f20391l, credential.f20391l) && TextUtils.equals(this.f20393n, credential.f20393n) && TextUtils.equals(this.f20394o, credential.f20394o);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f20389j, this.f20390k, this.f20391l, this.f20393n, this.f20394o});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m574t2(parcel, 1, this.f20389j, false);
        C1460d.m574t2(parcel, 2, this.f20390k, false);
        C1460d.m570s2(parcel, 3, this.f20391l, i, false);
        C1460d.m586w2(parcel, 4, this.f20392m, false);
        C1460d.m574t2(parcel, 5, this.f20393n, false);
        C1460d.m574t2(parcel, 6, this.f20394o, false);
        C1460d.m574t2(parcel, 9, this.f20395p, false);
        C1460d.m574t2(parcel, 10, this.f20396q, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
