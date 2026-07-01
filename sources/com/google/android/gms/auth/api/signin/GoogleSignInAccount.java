package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import b.i.a.f.c.a.f.d;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable$Creator<GoogleSignInAccount> CREATOR = new d();
    public final int j;

    @Nullable
    public String k;

    @Nullable
    public String l;

    @Nullable
    public String m;

    @Nullable
    public String n;

    @Nullable
    public Uri o;

    @Nullable
    public String p;
    public long q;
    public String r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<Scope> f2996s;

    @Nullable
    public String t;

    @Nullable
    public String u;
    public Set<Scope> v = new HashSet();

    public GoogleSignInAccount(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Uri uri, @Nullable String str5, long j, String str6, List<Scope> list, @Nullable String str7, @Nullable String str8) {
        this.j = i;
        this.k = str;
        this.l = str2;
        this.m = str3;
        this.n = str4;
        this.o = uri;
        this.p = str5;
        this.q = j;
        this.r = str6;
        this.f2996s = list;
        this.t = str7;
        this.u = str8;
    }

    @Nullable
    public static GoogleSignInAccount x0(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String strOptString2 = jSONObject.optString(ModelAuditLogEntry.CHANGE_KEY_ID);
        String strOptString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String strOptString4 = jSONObject.has(NotificationCompat.CATEGORY_EMAIL) ? jSONObject.optString(NotificationCompat.CATEGORY_EMAIL) : null;
        String strOptString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String strOptString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String strOptString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        Long lValueOf = Long.valueOf(j);
        String string = jSONObject.getString("obfuscatedIdentifier");
        if (lValueOf == null) {
            lValueOf = Long.valueOf(System.currentTimeMillis() / 1000);
        }
        long jLongValue = lValueOf.longValue();
        b.c.a.a0.d.w(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, strOptString2, strOptString3, strOptString4, strOptString5, uri, null, jLongValue, string, new ArrayList(hashSet), strOptString6, strOptString7);
        googleSignInAccount.p = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.r.equals(this.r) && googleSignInAccount.w0().equals(w0());
    }

    public int hashCode() {
        return w0().hashCode() + a.m(this.r, 527, 31);
    }

    @NonNull
    public Set<Scope> w0() {
        HashSet hashSet = new HashSet(this.f2996s);
        hashSet.addAll(this.v);
        return hashSet;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iY2 = b.c.a.a0.d.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        b.c.a.a0.d.t2(parcel, 2, this.k, false);
        b.c.a.a0.d.t2(parcel, 3, this.l, false);
        b.c.a.a0.d.t2(parcel, 4, this.m, false);
        b.c.a.a0.d.t2(parcel, 5, this.n, false);
        b.c.a.a0.d.s2(parcel, 6, this.o, i, false);
        b.c.a.a0.d.t2(parcel, 7, this.p, false);
        long j = this.q;
        parcel.writeInt(524296);
        parcel.writeLong(j);
        b.c.a.a0.d.t2(parcel, 9, this.r, false);
        b.c.a.a0.d.w2(parcel, 10, this.f2996s, false);
        b.c.a.a0.d.t2(parcel, 11, this.t, false);
        b.c.a.a0.d.t2(parcel, 12, this.u, false);
        b.c.a.a0.d.A2(parcel, iY2);
    }
}
