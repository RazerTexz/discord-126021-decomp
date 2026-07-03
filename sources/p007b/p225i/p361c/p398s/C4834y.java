package p007b.p225i.p361c.p398s;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import java.util.concurrent.TimeUnit;
import p007b.p225i.p226a.p288f.p339m.C4351a;

/* JADX INFO: renamed from: b.i.c.s.y */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4834y {

    /* JADX INFO: renamed from: a */
    public static final long f12914a = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: renamed from: b */
    public static final Object f12915b = new Object();

    /* JADX INFO: renamed from: c */
    public static C4351a f12916c;

    /* JADX INFO: renamed from: a */
    public static ComponentName m6749a(@NonNull Context context, @NonNull Intent intent) {
        synchronized (f12915b) {
            if (f12916c == null) {
                C4351a c4351a = new C4351a(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
                f12916c = c4351a;
                c4351a.f11460c.setReferenceCounted(true);
                c4351a.f11465h = true;
            }
            boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
            intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
            ComponentName componentNameStartService = context.startService(intent);
            if (componentNameStartService == null) {
                return null;
            }
            if (!booleanExtra) {
                f12916c.m6001a(f12914a);
            }
            return componentNameStartService;
        }
    }
}
