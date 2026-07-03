package p007b.p225i.p361c.p406w;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.WorkerThread;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.c.w.u */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4883u {

    /* JADX INFO: renamed from: a */
    public final SharedPreferences f13041a;

    /* JADX INFO: renamed from: b */
    public final String f13042b;

    /* JADX INFO: renamed from: c */
    public final String f13043c;

    /* JADX INFO: renamed from: d */
    @GuardedBy("internalQueue")
    public final ArrayDeque<String> f13044d = new ArrayDeque<>();

    /* JADX INFO: renamed from: e */
    public final Executor f13045e;

    public C4883u(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f13041a = sharedPreferences;
        this.f13042b = str;
        this.f13043c = str2;
        this.f13045e = executor;
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public static C4883u m6828a(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        C4883u c4883u = new C4883u(sharedPreferences, str, str2, executor);
        synchronized (c4883u.f13044d) {
            c4883u.f13044d.clear();
            String string = c4883u.f13041a.getString(c4883u.f13042b, "");
            if (!TextUtils.isEmpty(string) && string.contains(c4883u.f13043c)) {
                String[] strArrSplit = string.split(c4883u.f13043c, -1);
                if (strArrSplit.length == 0) {
                    Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                }
                for (String str3 : strArrSplit) {
                    if (!TextUtils.isEmpty(str3)) {
                        c4883u.f13044d.add(str3);
                    }
                }
            }
        }
        return c4883u;
    }
}
