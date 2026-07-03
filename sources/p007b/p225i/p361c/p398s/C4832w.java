package p007b.p225i.p361c.p398s;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.C4542c;

/* JADX INFO: renamed from: b.i.c.s.w */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4832w {

    /* JADX INFO: renamed from: a */
    public final SharedPreferences f12901a;

    /* JADX INFO: renamed from: b */
    public final Context f12902b;

    /* JADX INFO: renamed from: c */
    @GuardedBy("this")
    public final Map<String, Long> f12903c = new ArrayMap();

    /* JADX INFO: renamed from: b.i.c.s.w$a */
    /* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
    public static class a {

        /* JADX INFO: renamed from: a */
        public static final long f12904a = TimeUnit.DAYS.toMillis(7);

        /* JADX INFO: renamed from: b */
        public static final /* synthetic */ int f12905b = 0;

        /* JADX INFO: renamed from: c */
        public final String f12906c;

        /* JADX INFO: renamed from: d */
        public final String f12907d;

        /* JADX INFO: renamed from: e */
        public final long f12908e;

        public a(String str, String str2, long j) {
            this.f12906c = str;
            this.f12907d = str2;
            this.f12908e = j;
        }

        /* JADX INFO: renamed from: a */
        public static String m6742a(String str, String str2, long j) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put("appVersion", str2);
                jSONObject.put("timestamp", j);
                return jSONObject.toString();
            } catch (JSONException e) {
                String strValueOf = String.valueOf(e);
                C1643a.m854h0(strValueOf.length() + 24, "Failed to encode token: ", strValueOf, "FirebaseInstanceId");
                return null;
            }
        }

        /* JADX INFO: renamed from: b */
        public static a m6743b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new a(str, null, 0L);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new a(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
            } catch (JSONException e) {
                String strValueOf = String.valueOf(e);
                C1643a.m854h0(strValueOf.length() + 23, "Failed to parse token: ", strValueOf, "FirebaseInstanceId");
                return null;
            }
        }
    }

    public C4832w(Context context) {
        boolean zIsEmpty;
        this.f12902b = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.f12901a = sharedPreferences;
        File file = new File(ContextCompat.getNoBackupFilesDir(context), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile()) {
                synchronized (this) {
                    zIsEmpty = sharedPreferences.getAll().isEmpty();
                }
                if (zIsEmpty) {
                    return;
                }
                Log.i("FirebaseInstanceId", "App restored, clearing state");
                m6740c();
                C4832w c4832w = FirebaseInstanceId.f21433b;
                synchronized (FirebaseInstanceId.getInstance(C4542c.m6327b())) {
                    FirebaseInstanceId.f21433b.m6740c();
                }
            }
        } catch (IOException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(e.getMessage());
                Log.d("FirebaseInstanceId", strValueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(strValueOf) : new String("Error creating file in no backup dir: "));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m6738a(String str, String str2) {
        return C1643a.m859k(str2.length() + C1643a.m841b(str, 3), str, "|S|", str2);
    }

    /* JADX INFO: renamed from: b */
    public final String m6739b(String str, String str2, String str3) {
        StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(str3, C1643a.m841b(str2, C1643a.m841b(str, 4))), str, "|T|", str2, "|");
        sbM831S.append(str3);
        return sbM831S.toString();
    }

    /* JADX INFO: renamed from: c */
    public synchronized void m6740c() {
        this.f12903c.clear();
        this.f12901a.edit().clear().commit();
    }

    /* JADX INFO: renamed from: d */
    public final long m6741d(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f12901a.contains(m6738a(str, "cre"))) {
            String string = this.f12901a.getString(m6738a(str, "cre"), null);
            if (string != null) {
                try {
                    return Long.parseLong(string);
                } catch (NumberFormatException unused) {
                }
            }
            return 0L;
        }
        SharedPreferences.Editor editorEdit = this.f12901a.edit();
        editorEdit.putString(m6738a(str, "cre"), String.valueOf(jCurrentTimeMillis));
        editorEdit.commit();
        return jCurrentTimeMillis;
    }
}
