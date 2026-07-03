package p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p292c.p293a.p296f.C3218c;

/* JADX INFO: renamed from: b.i.a.f.c.a.f.b.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3198a {

    /* JADX INFO: renamed from: a */
    public static final Lock f9225a = new ReentrantLock();

    /* JADX INFO: renamed from: b */
    @Nullable
    public static C3198a f9226b;

    /* JADX INFO: renamed from: c */
    public final Lock f9227c = new ReentrantLock();

    /* JADX INFO: renamed from: d */
    public final SharedPreferences f9228d;

    public C3198a(Context context) {
        this.f9228d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    /* JADX INFO: renamed from: a */
    public static C3198a m3973a(Context context) {
        Objects.requireNonNull(context, "null reference");
        f9225a.lock();
        try {
            if (f9226b == null) {
                f9226b = new C3198a(context.getApplicationContext());
            }
            return f9226b;
        } finally {
            f9225a.unlock();
        }
    }

    /* JADX INFO: renamed from: f */
    public static String m3974f(String str, String str2) {
        return C1643a.m859k(C1643a.m841b(str2, str.length() + 1), str, ":", str2);
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public GoogleSignInAccount m3975b() {
        String strM3979g;
        String strM3979g2 = m3979g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strM3979g2) || (strM3979g = m3979g(m3974f("googleSignInAccount", strM3979g2))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.m9010x0(strM3979g);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public GoogleSignInOptions m3976c() {
        String strM3979g;
        String strM3979g2 = m3979g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strM3979g2) || (strM3979g = m3979g(m3974f("googleSignInOptions", strM3979g2))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.m9012x0(strM3979g);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public void m3977d(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        Objects.requireNonNull(googleSignInAccount, "null reference");
        Objects.requireNonNull(googleSignInOptions, "null reference");
        m3978e("defaultGoogleSignInAccount", googleSignInAccount.f20424r);
        String str = googleSignInAccount.f20424r;
        String strM3974f = m3974f("googleSignInAccount", str);
        JSONObject jSONObject = new JSONObject();
        try {
            String str2 = googleSignInAccount.f20417k;
            if (str2 != null) {
                jSONObject.put(ModelAuditLogEntry.CHANGE_KEY_ID, str2);
            }
            String str3 = googleSignInAccount.f20418l;
            if (str3 != null) {
                jSONObject.put("tokenId", str3);
            }
            String str4 = googleSignInAccount.f20419m;
            if (str4 != null) {
                jSONObject.put(NotificationCompat.CATEGORY_EMAIL, str4);
            }
            String str5 = googleSignInAccount.f20420n;
            if (str5 != null) {
                jSONObject.put("displayName", str5);
            }
            String str6 = googleSignInAccount.f20426t;
            if (str6 != null) {
                jSONObject.put("givenName", str6);
            }
            String str7 = googleSignInAccount.f20427u;
            if (str7 != null) {
                jSONObject.put("familyName", str7);
            }
            Uri uri = googleSignInAccount.f20421o;
            if (uri != null) {
                jSONObject.put("photoUrl", uri.toString());
            }
            String str8 = googleSignInAccount.f20422p;
            if (str8 != null) {
                jSONObject.put("serverAuthCode", str8);
            }
            jSONObject.put("expirationTime", googleSignInAccount.f20423q);
            jSONObject.put("obfuscatedIdentifier", googleSignInAccount.f20424r);
            JSONArray jSONArray = new JSONArray();
            List<Scope> list = googleSignInAccount.f20425s;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, C3218c.f9241j);
            int i = 0;
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.f20488k);
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            m3978e(strM3974f, jSONObject.toString());
            String strM3974f2 = m3974f("googleSignInOptions", str);
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONArray jSONArray2 = new JSONArray();
                Collections.sort(googleSignInOptions.f20436q, GoogleSignInOptions.f20434o);
                ArrayList<Scope> arrayList = googleSignInOptions.f20436q;
                int size = arrayList.size();
                while (i < size) {
                    Scope scope2 = arrayList.get(i);
                    i++;
                    jSONArray2.put(scope2.f20488k);
                }
                jSONObject2.put("scopes", jSONArray2);
                Account account = googleSignInOptions.f20437r;
                if (account != null) {
                    jSONObject2.put("accountName", account.name);
                }
                jSONObject2.put("idTokenRequested", googleSignInOptions.f20438s);
                jSONObject2.put("forceCodeForRefreshToken", googleSignInOptions.f20440u);
                jSONObject2.put("serverAuthRequested", googleSignInOptions.f20439t);
                if (!TextUtils.isEmpty(googleSignInOptions.f20441v)) {
                    jSONObject2.put("serverClientId", googleSignInOptions.f20441v);
                }
                if (!TextUtils.isEmpty(googleSignInOptions.f20442w)) {
                    jSONObject2.put("hostedDomain", googleSignInOptions.f20442w);
                }
                m3978e(strM3974f2, jSONObject2.toString());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m3978e(String str, String str2) {
        this.f9227c.lock();
        try {
            this.f9228d.edit().putString(str, str2).apply();
        } finally {
            this.f9227c.unlock();
        }
    }

    @Nullable
    /* JADX INFO: renamed from: g */
    public final String m3979g(String str) {
        this.f9227c.lock();
        try {
            return this.f9228d.getString(str, null);
        } finally {
            this.f9227c.unlock();
        }
    }
}
