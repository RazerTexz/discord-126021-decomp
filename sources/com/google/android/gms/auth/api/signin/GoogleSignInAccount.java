package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p292c.p293a.p296f.C3219d;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new C3219d();

    /* JADX INFO: renamed from: j */
    public final int f20416j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public String f20417k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public String f20418l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public String f20419m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public String f20420n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public Uri f20421o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public String f20422p;

    /* JADX INFO: renamed from: q */
    public long f20423q;

    /* JADX INFO: renamed from: r */
    public String f20424r;

    /* JADX INFO: renamed from: s */
    public List<Scope> f20425s;

    /* JADX INFO: renamed from: t */
    @Nullable
    public String f20426t;

    /* JADX INFO: renamed from: u */
    @Nullable
    public String f20427u;

    /* JADX INFO: renamed from: v */
    public Set<Scope> f20428v = new HashSet();

    public GoogleSignInAccount(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Uri uri, @Nullable String str5, long j, String str6, List<Scope> list, @Nullable String str7, @Nullable String str8) {
        this.f20416j = i;
        this.f20417k = str;
        this.f20418l = str2;
        this.f20419m = str3;
        this.f20420n = str4;
        this.f20421o = uri;
        this.f20422p = str5;
        this.f20423q = j;
        this.f20424r = str6;
        this.f20425s = list;
        this.f20426t = str7;
        this.f20427u = str8;
    }

    @Nullable
    /* JADX INFO: renamed from: x0 */
    public static GoogleSignInAccount m9010x0(@Nullable String str) throws JSONException {
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
        C1460d.m583w(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, strOptString2, strOptString3, strOptString4, strOptString5, uri, null, jLongValue, string, new ArrayList(hashSet), strOptString6, strOptString7);
        googleSignInAccount.f20422p = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
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
        return googleSignInAccount.f20424r.equals(this.f20424r) && googleSignInAccount.m9011w0().equals(m9011w0());
    }

    public int hashCode() {
        return m9011w0().hashCode() + C1643a.m863m(this.f20424r, 527, 31);
    }

    @NonNull
    /* JADX INFO: renamed from: w0 */
    public Set<Scope> m9011w0() {
        HashSet hashSet = new HashSet(this.f20425s);
        hashSet.addAll(this.f20428v);
        return hashSet;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20416j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        C1460d.m574t2(parcel, 2, this.f20417k, false);
        C1460d.m574t2(parcel, 3, this.f20418l, false);
        C1460d.m574t2(parcel, 4, this.f20419m, false);
        C1460d.m574t2(parcel, 5, this.f20420n, false);
        C1460d.m570s2(parcel, 6, this.f20421o, i, false);
        C1460d.m574t2(parcel, 7, this.f20422p, false);
        long j = this.f20423q;
        parcel.writeInt(524296);
        parcel.writeLong(j);
        C1460d.m574t2(parcel, 9, this.f20424r, false);
        C1460d.m586w2(parcel, 10, this.f20425s, false);
        C1460d.m574t2(parcel, 11, this.f20426t, false);
        C1460d.m574t2(parcel, 12, this.f20427u, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
