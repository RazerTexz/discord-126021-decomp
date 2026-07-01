package b.i.a.f.c.a.f.b;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
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

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final Lock a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public static a f1335b;
    public final Lock c = new ReentrantLock();
    public final SharedPreferences d;

    public a(Context context) {
        this.d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context context) {
        Objects.requireNonNull(context, "null reference");
        a.lock();
        try {
            if (f1335b == null) {
                f1335b = new a(context.getApplicationContext());
            }
            return f1335b;
        } finally {
            a.unlock();
        }
    }

    public static String f(String str, String str2) {
        return outline.k(outline.b(str2, str.length() + 1), str, ":", str2);
    }

    @Nullable
    public GoogleSignInAccount b() {
        String strG;
        String strG2 = g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strG2) || (strG = g(f("googleSignInAccount", strG2))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.x0(strG);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    public GoogleSignInOptions c() {
        String strG;
        String strG2 = g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strG2) || (strG = g(f("googleSignInOptions", strG2))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.x0(strG);
        } catch (JSONException unused) {
            return null;
        }
    }

    public void d(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        Objects.requireNonNull(googleSignInAccount, "null reference");
        Objects.requireNonNull(googleSignInOptions, "null reference");
        e("defaultGoogleSignInAccount", googleSignInAccount.r);
        String str = googleSignInAccount.r;
        String strF = f("googleSignInAccount", str);
        JSONObject jSONObject = new JSONObject();
        try {
            String str2 = googleSignInAccount.k;
            if (str2 != null) {
                jSONObject.put(ModelAuditLogEntry.CHANGE_KEY_ID, str2);
            }
            String str3 = googleSignInAccount.l;
            if (str3 != null) {
                jSONObject.put("tokenId", str3);
            }
            String str4 = googleSignInAccount.m;
            if (str4 != null) {
                jSONObject.put(NotificationCompat.CATEGORY_EMAIL, str4);
            }
            String str5 = googleSignInAccount.n;
            if (str5 != null) {
                jSONObject.put("displayName", str5);
            }
            String str6 = googleSignInAccount.t;
            if (str6 != null) {
                jSONObject.put("givenName", str6);
            }
            String str7 = googleSignInAccount.u;
            if (str7 != null) {
                jSONObject.put("familyName", str7);
            }
            Uri uri = googleSignInAccount.o;
            if (uri != null) {
                jSONObject.put("photoUrl", uri.toString());
            }
            String str8 = googleSignInAccount.p;
            if (str8 != null) {
                jSONObject.put("serverAuthCode", str8);
            }
            jSONObject.put("expirationTime", googleSignInAccount.q);
            jSONObject.put("obfuscatedIdentifier", googleSignInAccount.r);
            JSONArray jSONArray = new JSONArray();
            List<Scope> list = googleSignInAccount.f2996s;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, b.i.a.f.c.a.f.c.j);
            int i = 0;
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.k);
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            e(strF, jSONObject.toString());
            String strF2 = f("googleSignInOptions", str);
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONArray jSONArray2 = new JSONArray();
                Collections.sort(googleSignInOptions.q, GoogleSignInOptions.o);
                ArrayList<Scope> arrayList = googleSignInOptions.q;
                int size = arrayList.size();
                while (i < size) {
                    Scope scope2 = arrayList.get(i);
                    i++;
                    jSONArray2.put(scope2.k);
                }
                jSONObject2.put("scopes", jSONArray2);
                Account account = googleSignInOptions.r;
                if (account != null) {
                    jSONObject2.put("accountName", account.name);
                }
                jSONObject2.put("idTokenRequested", googleSignInOptions.f2997s);
                jSONObject2.put("forceCodeForRefreshToken", googleSignInOptions.u);
                jSONObject2.put("serverAuthRequested", googleSignInOptions.t);
                if (!TextUtils.isEmpty(googleSignInOptions.v)) {
                    jSONObject2.put("serverClientId", googleSignInOptions.v);
                }
                if (!TextUtils.isEmpty(googleSignInOptions.w)) {
                    jSONObject2.put("hostedDomain", googleSignInOptions.w);
                }
                e(strF2, jSONObject2.toString());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final void e(String str, String str2) {
        this.c.lock();
        try {
            this.d.edit().putString(str, str2).apply();
        } finally {
            this.c.unlock();
        }
    }

    @Nullable
    public final String g(String str) {
        this.c.lock();
        try {
            return this.d.getString(str, null);
        } finally {
            this.c.unlock();
        }
    }
}
