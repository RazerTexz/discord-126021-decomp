package p007b.p225i.p361c.p398s;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: renamed from: b.i.c.s.v */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4831v {

    /* JADX INFO: renamed from: a */
    public static C4831v f12896a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public String f12897b = null;

    /* JADX INFO: renamed from: c */
    public Boolean f12898c = null;

    /* JADX INFO: renamed from: d */
    public Boolean f12899d = null;

    /* JADX INFO: renamed from: e */
    public final Queue<Intent> f12900e = new ArrayDeque();

    /* JADX INFO: renamed from: a */
    public static synchronized C4831v m6735a() {
        if (f12896a == null) {
            f12896a = new C4831v();
        }
        return f12896a;
    }

    /* JADX INFO: renamed from: b */
    public boolean m6736b(Context context) {
        if (this.f12899d == null) {
            this.f12899d = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.f12898c.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f12899d.booleanValue();
    }

    /* JADX INFO: renamed from: c */
    public boolean m6737c(Context context) {
        if (this.f12898c == null) {
            this.f12898c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f12898c.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f12898c.booleanValue();
    }
}
