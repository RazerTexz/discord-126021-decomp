package b.i.c.s;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class y {
    public static final long a = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f1777b = new Object();
    public static b.i.a.f.m.a c;

    public static ComponentName a(@NonNull Context context, @NonNull Intent intent) {
        synchronized (f1777b) {
            if (c == null) {
                b.i.a.f.m.a aVar = new b.i.a.f.m.a(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
                c = aVar;
                aVar.c.setReferenceCounted(true);
                aVar.h = true;
            }
            boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
            intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
            ComponentName componentNameStartService = context.startService(intent);
            if (componentNameStartService == null) {
                return null;
            }
            if (!booleanExtra) {
                c.a(a);
            }
            return componentNameStartService;
        }
    }
}
