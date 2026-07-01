package b.i.a.f.h.l;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.core.content.PermissionChecker;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c2 implements b2 {

    @GuardedBy("GservicesLoader.class")
    public static c2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1437b;
    public final ContentObserver c;

    public c2(Context context) {
        this.f1437b = context;
        f2 f2Var = new f2();
        this.c = f2Var;
        context.getContentResolver().registerContentObserver(u1.a, true, f2Var);
    }

    public static c2 a(Context context) {
        c2 c2Var;
        synchronized (c2.class) {
            if (a == null) {
                a = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new c2(context) : new c2();
            }
            c2Var = a;
        }
        return c2Var;
    }

    @Override // b.i.a.f.h.l.b2
    public final Object g(String str) {
        if (this.f1437b == null) {
            return null;
        }
        try {
            return (String) b.i.a.f.e.o.f.T1(new g2(this, str));
        } catch (IllegalStateException | SecurityException e) {
            String strValueOf = String.valueOf(str);
            Log.e("GservicesLoader", strValueOf.length() != 0 ? "Unable to read GServices for: ".concat(strValueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    public c2() {
        this.f1437b = null;
        this.c = null;
    }
}
