package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p292c.p293a.p296f.C3220e;
import p007b.p225i.p226a.p288f.p292c.p293a.p296f.C3221f;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements C3266a.d, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* JADX INFO: renamed from: j */
    public static final Scope f20429j;

    /* JADX INFO: renamed from: k */
    public static final Scope f20430k;

    /* JADX INFO: renamed from: l */
    public static final Scope f20431l;

    /* JADX INFO: renamed from: m */
    public static final Scope f20432m;

    /* JADX INFO: renamed from: n */
    public static final GoogleSignInOptions f20433n;

    /* JADX INFO: renamed from: o */
    public static Comparator<Scope> f20434o;

    /* JADX INFO: renamed from: p */
    public final int f20435p;

    /* JADX INFO: renamed from: q */
    public final ArrayList<Scope> f20436q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public Account f20437r;

    /* JADX INFO: renamed from: s */
    public boolean f20438s;

    /* JADX INFO: renamed from: t */
    public final boolean f20439t;

    /* JADX INFO: renamed from: u */
    public final boolean f20440u;

    /* JADX INFO: renamed from: v */
    @Nullable
    public String f20441v;

    /* JADX INFO: renamed from: w */
    @Nullable
    public String f20442w;

    /* JADX INFO: renamed from: x */
    public ArrayList<GoogleSignInOptionsExtensionParcelable> f20443x;

    /* JADX INFO: renamed from: y */
    @Nullable
    public String f20444y;

    /* JADX INFO: renamed from: z */
    public Map<Integer, GoogleSignInOptionsExtensionParcelable> f20445z;

    static {
        Scope scope = new Scope("profile");
        f20429j = scope;
        new Scope(NotificationCompat.CATEGORY_EMAIL);
        Scope scope2 = new Scope("openid");
        f20430k = scope2;
        Scope scope3 = new Scope("https://www.googleapis.com/auth/games_lite");
        f20431l = scope3;
        Scope scope4 = new Scope("https://www.googleapis.com/auth/games");
        f20432m = scope4;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        hashSet.add(scope2);
        hashSet.add(scope);
        if (hashSet.contains(scope4) && hashSet.contains(scope3)) {
            hashSet.remove(scope3);
        }
        f20433n = new GoogleSignInOptions(3, new ArrayList(hashSet), null, false, false, false, null, null, map, null);
        HashSet hashSet2 = new HashSet();
        HashMap map2 = new HashMap();
        hashSet2.add(scope3);
        hashSet2.addAll(Arrays.asList(new Scope[0]));
        if (hashSet2.contains(scope4) && hashSet2.contains(scope3)) {
            hashSet2.remove(scope3);
        }
        new GoogleSignInOptions(3, new ArrayList(hashSet2), null, false, false, false, null, null, map2, null);
        CREATOR = new C3221f();
        f20434o = new C3220e();
    }

    public GoogleSignInOptions(int i, ArrayList<Scope> arrayList, @Nullable Account account, boolean z2, boolean z3, boolean z4, @Nullable String str, @Nullable String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map, @Nullable String str3) {
        this.f20435p = i;
        this.f20436q = arrayList;
        this.f20437r = account;
        this.f20438s = z2;
        this.f20439t = z3;
        this.f20440u = z4;
        this.f20441v = str;
        this.f20442w = str2;
        this.f20443x = new ArrayList<>(map.values());
        this.f20445z = map;
        this.f20444y = str3;
    }

    @Nullable
    /* JADX INFO: renamed from: x0 */
    public static GoogleSignInOptions m9012x0(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String strOptString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(strOptString) ? new Account(strOptString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null, jSONObject.has("hostedDomain") ? jSONObject.optString("hostedDomain") : null, new HashMap(), null);
    }

    /* JADX INFO: renamed from: y0 */
    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> m9013y0(@Nullable List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap map = new HashMap();
        if (list == null) {
            return map;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.f20459k), googleSignInOptionsExtensionParcelable);
        }
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x004d A[Catch: ClassCastException -> 0x007e, TryCatch #0 {ClassCastException -> 0x007e, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0017, B:12:0x0027, B:15:0x0034, B:17:0x0038, B:22:0x0045, B:24:0x004d, B:29:0x0060, B:31:0x0066, B:33:0x006c, B:35:0x0072, B:27:0x0056, B:20:0x003d), top: B:41:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    /* JADX WARN: Code duplicated, block: B:27:0x0056 A[Catch: ClassCastException -> 0x007e, TryCatch #0 {ClassCastException -> 0x007e, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0017, B:12:0x0027, B:15:0x0034, B:17:0x0038, B:22:0x0045, B:24:0x004d, B:29:0x0060, B:31:0x0066, B:33:0x006c, B:35:0x0072, B:27:0x0056, B:20:0x003d), top: B:41:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0060 A[Catch: ClassCastException -> 0x007e, TryCatch #0 {ClassCastException -> 0x007e, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0017, B:12:0x0027, B:15:0x0034, B:17:0x0038, B:22:0x0045, B:24:0x004d, B:29:0x0060, B:31:0x0066, B:33:0x006c, B:35:0x0072, B:27:0x0056, B:20:0x003d), top: B:41:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0066 A[Catch: ClassCastException -> 0x007e, TryCatch #0 {ClassCastException -> 0x007e, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0017, B:12:0x0027, B:15:0x0034, B:17:0x0038, B:22:0x0045, B:24:0x004d, B:29:0x0060, B:31:0x0066, B:33:0x006c, B:35:0x0072, B:27:0x0056, B:20:0x003d), top: B:41:0x0004 }] */
    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f20443x.size() <= 0 && googleSignInOptions.f20443x.size() <= 0 && this.f20436q.size() == googleSignInOptions.m9014w0().size() && this.f20436q.containsAll(googleSignInOptions.m9014w0())) {
                Account account = this.f20437r;
                if (account == null) {
                    if (googleSignInOptions.f20437r == null) {
                        if (TextUtils.isEmpty(this.f20441v)) {
                            if (TextUtils.isEmpty(googleSignInOptions.f20441v)) {
                                if (this.f20440u != googleSignInOptions.f20440u && this.f20438s == googleSignInOptions.f20438s && this.f20439t == googleSignInOptions.f20439t && TextUtils.equals(this.f20444y, googleSignInOptions.f20444y)) {
                                    return true;
                                }
                            }
                        } else if (this.f20441v.equals(googleSignInOptions.f20441v)) {
                            if (this.f20440u != googleSignInOptions.f20440u) {
                            }
                        }
                    }
                } else if (account.equals(googleSignInOptions.f20437r)) {
                    if (TextUtils.isEmpty(this.f20441v)) {
                        if (TextUtils.isEmpty(googleSignInOptions.f20441v)) {
                            if (this.f20440u != googleSignInOptions.f20440u) {
                            }
                        }
                    } else if (this.f20441v.equals(googleSignInOptions.f20441v)) {
                        if (this.f20440u != googleSignInOptions.f20440u) {
                        }
                    }
                }
            }
        } catch (ClassCastException unused) {
        }
        return false;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.f20436q;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Scope scope = arrayList2.get(i);
            i++;
            arrayList.add(scope.f20488k);
        }
        Collections.sort(arrayList);
        int iHashCode = arrayList.hashCode() + 31;
        Account account = this.f20437r;
        int iHashCode2 = (iHashCode * 31) + (account == null ? 0 : account.hashCode());
        String str = this.f20441v;
        int iHashCode3 = (((((((iHashCode2 * 31) + (str == null ? 0 : str.hashCode())) * 31) + (this.f20440u ? 1 : 0)) * 31) + (this.f20438s ? 1 : 0)) * 31) + (this.f20439t ? 1 : 0);
        String str2 = this.f20444y;
        return (iHashCode3 * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    /* JADX INFO: renamed from: w0 */
    public ArrayList<Scope> m9014w0() {
        return new ArrayList<>(this.f20436q);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20435p;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        C1460d.m586w2(parcel, 2, m9014w0(), false);
        C1460d.m570s2(parcel, 3, this.f20437r, i, false);
        boolean z2 = this.f20438s;
        parcel.writeInt(262148);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.f20439t;
        parcel.writeInt(262149);
        parcel.writeInt(z3 ? 1 : 0);
        boolean z4 = this.f20440u;
        parcel.writeInt(262150);
        parcel.writeInt(z4 ? 1 : 0);
        C1460d.m574t2(parcel, 7, this.f20441v, false);
        C1460d.m574t2(parcel, 8, this.f20442w, false);
        C1460d.m586w2(parcel, 9, this.f20443x, false);
        C1460d.m574t2(parcel, 10, this.f20444y, false);
        C1460d.m418A2(parcel, iM594y2);
    }

    /* JADX INFO: renamed from: com.google.android.gms.auth.api.signin.GoogleSignInOptions$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static final class C10794a {

        /* JADX INFO: renamed from: a */
        public Set<Scope> f20446a;

        /* JADX INFO: renamed from: b */
        public boolean f20447b;

        /* JADX INFO: renamed from: c */
        public boolean f20448c;

        /* JADX INFO: renamed from: d */
        public boolean f20449d;

        /* JADX INFO: renamed from: e */
        @Nullable
        public String f20450e;

        /* JADX INFO: renamed from: f */
        @Nullable
        public Account f20451f;

        /* JADX INFO: renamed from: g */
        @Nullable
        public String f20452g;

        /* JADX INFO: renamed from: h */
        public Map<Integer, GoogleSignInOptionsExtensionParcelable> f20453h;

        /* JADX INFO: renamed from: i */
        @Nullable
        public String f20454i;

        public C10794a() {
            this.f20446a = new HashSet();
            this.f20453h = new HashMap();
        }

        /* JADX INFO: renamed from: a */
        public final GoogleSignInOptions m9015a() {
            if (this.f20446a.contains(GoogleSignInOptions.f20432m)) {
                Set<Scope> set = this.f20446a;
                Scope scope = GoogleSignInOptions.f20431l;
                if (set.contains(scope)) {
                    this.f20446a.remove(scope);
                }
            }
            if (this.f20449d && (this.f20451f == null || !this.f20446a.isEmpty())) {
                this.f20446a.add(GoogleSignInOptions.f20430k);
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f20446a), this.f20451f, this.f20449d, this.f20447b, this.f20448c, this.f20450e, this.f20452g, this.f20453h, this.f20454i);
        }

        public C10794a(@NonNull GoogleSignInOptions googleSignInOptions) {
            this.f20446a = new HashSet();
            this.f20453h = new HashMap();
            this.f20446a = new HashSet(googleSignInOptions.f20436q);
            this.f20447b = googleSignInOptions.f20439t;
            this.f20448c = googleSignInOptions.f20440u;
            this.f20449d = googleSignInOptions.f20438s;
            this.f20450e = googleSignInOptions.f20441v;
            this.f20451f = googleSignInOptions.f20437r;
            this.f20452g = googleSignInOptions.f20442w;
            this.f20453h = GoogleSignInOptions.m9013y0(googleSignInOptions.f20443x);
            this.f20454i = googleSignInOptions.f20444y;
        }
    }
}
