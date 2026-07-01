package b.i.c.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import b.d.b.a.outline;
import b.i.c.FirebaseApp2;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class w {
    public final SharedPreferences a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1775b;

    @GuardedBy("this")
    public final Map<String, Long> c = new ArrayMap();

    /* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
    public static class a {
        public static final long a = TimeUnit.DAYS.toMillis(7);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f1776b = 0;
        public final String c;
        public final String d;
        public final long e;

        public a(String str, String str2, long j) {
            this.c = str;
            this.d = str2;
            this.e = j;
        }

        public static String a(String str, String str2, long j) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put("appVersion", str2);
                jSONObject.put("timestamp", j);
                return jSONObject.toString();
            } catch (JSONException e) {
                String strValueOf = String.valueOf(e);
                outline.h0(strValueOf.length() + 24, "Failed to encode token: ", strValueOf, "FirebaseInstanceId");
                return null;
            }
        }

        public static a b(String str) {
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
                outline.h0(strValueOf.length() + 23, "Failed to parse token: ", strValueOf, "FirebaseInstanceId");
                return null;
            }
        }
    }

    public w(Context context) {
        boolean zIsEmpty;
        this.f1775b = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.a = sharedPreferences;
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
                c();
                w wVar = FirebaseInstanceId.f3111b;
                synchronized (FirebaseInstanceId.getInstance(FirebaseApp2.b())) {
                    FirebaseInstanceId.f3111b.c();
                }
            }
        } catch (IOException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(e.getMessage());
                Log.d("FirebaseInstanceId", strValueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(strValueOf) : new String("Error creating file in no backup dir: "));
            }
        }
    }

    public static String a(String str, String str2) {
        return outline.k(str2.length() + outline.b(str, 3), str, "|S|", str2);
    }

    public final String b(String str, String str2, String str3) {
        StringBuilder sbS = outline.S(outline.b(str3, outline.b(str2, outline.b(str, 4))), str, "|T|", str2, "|");
        sbS.append(str3);
        return sbS.toString();
    }

    public synchronized void c() {
        this.c.clear();
        this.a.edit().clear().commit();
    }

    public final long d(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.a.contains(a(str, "cre"))) {
            String string = this.a.getString(a(str, "cre"), null);
            if (string != null) {
                try {
                    return Long.parseLong(string);
                } catch (NumberFormatException unused) {
                }
            }
            return 0L;
        }
        SharedPreferences.Editor editorEdit = this.a.edit();
        editorEdit.putString(a(str, "cre"), String.valueOf(jCurrentTimeMillis));
        editorEdit.commit();
        return jCurrentTimeMillis;
    }
}
