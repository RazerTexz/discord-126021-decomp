package p007b.p225i.p361c.p406w;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.c.w.w */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4885w {

    /* JADX INFO: renamed from: a */
    @GuardedBy("TopicsStore.class")
    public static WeakReference<C4885w> f13050a;

    /* JADX INFO: renamed from: b */
    public final SharedPreferences f13051b;

    /* JADX INFO: renamed from: c */
    public C4883u f13052c;

    /* JADX INFO: renamed from: d */
    public final Executor f13053d;

    public C4885w(SharedPreferences sharedPreferences, Executor executor) {
        this.f13053d = executor;
        this.f13051b = sharedPreferences;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public final synchronized C4884v m6829a() {
        String strPeek;
        C4884v c4884v;
        C4883u c4883u = this.f13052c;
        synchronized (c4883u.f13044d) {
            strPeek = c4883u.f13044d.peek();
        }
        Pattern pattern = C4884v.f13046a;
        c4884v = null;
        if (!TextUtils.isEmpty(strPeek)) {
            String[] strArrSplit = strPeek.split("!", -1);
            if (strArrSplit.length == 2) {
                c4884v = new C4884v(strArrSplit[0], strArrSplit[1]);
            }
        }
        return c4884v;
    }
}
