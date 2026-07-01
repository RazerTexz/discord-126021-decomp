package b.i.c.w;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class w {

    @GuardedBy("TopicsStore.class")
    public static WeakReference<w> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f1799b;
    public u c;
    public final Executor d;

    public w(SharedPreferences sharedPreferences, Executor executor) {
        this.d = executor;
        this.f1799b = sharedPreferences;
    }

    @Nullable
    public final synchronized v a() {
        String strPeek;
        v vVar;
        u uVar = this.c;
        synchronized (uVar.d) {
            strPeek = uVar.d.peek();
        }
        Pattern pattern = v.a;
        vVar = null;
        if (!TextUtils.isEmpty(strPeek)) {
            String[] strArrSplit = strPeek.split("!", -1);
            if (strArrSplit.length == 2) {
                vVar = new v(strArrSplit[0], strArrSplit[1]);
            }
        }
        return vVar;
    }
}
