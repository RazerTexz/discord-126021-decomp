package b.i.c.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class w {
    public final SharedPreferences a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1775b;

    @GuardedBy("this")
    public final Map<String, Long> c = new ArrayMap();

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
                synchronized (FirebaseInstanceId.getInstance(b.i.c.c.b())) {
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
        return b.d.b.a.a.k(str2.length() + b.d.b.a.a.b(str, 3), str, "|S|", str2);
    }

    public final String b(String str, String str2, String str3) {
        StringBuilder sbS = b.d.b.a.a.S(b.d.b.a.a.b(str3, b.d.b.a.a.b(str2, b.d.b.a.a.b(str, 4))), str, "|T|", str2, "|");
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
        SharedPreferences$Editor sharedPreferences$EditorEdit = this.a.edit();
        sharedPreferences$EditorEdit.putString(a(str, "cre"), String.valueOf(jCurrentTimeMillis));
        sharedPreferences$EditorEdit.commit();
        return jCurrentTimeMillis;
    }
}
