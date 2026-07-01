package b.i.c.w;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.WorkerThread;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public final SharedPreferences a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1797b;
    public final String c;

    @GuardedBy("internalQueue")
    public final ArrayDeque<String> d = new ArrayDeque<>();
    public final Executor e;

    public u(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.a = sharedPreferences;
        this.f1797b = str;
        this.c = str2;
        this.e = executor;
    }

    @WorkerThread
    public static u a(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        u uVar = new u(sharedPreferences, str, str2, executor);
        synchronized (uVar.d) {
            uVar.d.clear();
            String string = uVar.a.getString(uVar.f1797b, "");
            if (!TextUtils.isEmpty(string) && string.contains(uVar.c)) {
                String[] strArrSplit = string.split(uVar.c, -1);
                if (strArrSplit.length == 0) {
                    Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                }
                for (String str3 : strArrSplit) {
                    if (!TextUtils.isEmpty(str3)) {
                        uVar.d.add(str3);
                    }
                }
            }
        }
        return uVar;
    }
}
