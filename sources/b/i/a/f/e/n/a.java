package b.i.a.f.e.n;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import b.i.a.f.e.k.r0;
import b.i.a.f.e.p.b;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f1395b;

    @RecentlyNonNull
    public ConcurrentHashMap<ServiceConnection, ServiceConnection> c = new ConcurrentHashMap<>();

    @RecentlyNonNull
    public static a b() {
        if (f1395b == null) {
            synchronized (a) {
                if (f1395b == null) {
                    f1395b = new a();
                }
            }
        }
        a aVar = f1395b;
        Objects.requireNonNull(aVar, "null reference");
        return aVar;
    }

    public boolean a(@RecentlyNonNull Context context, @RecentlyNonNull Intent intent, @RecentlyNonNull ServiceConnection serviceConnection, int i) {
        return d(context, context.getClass().getName(), intent, serviceConnection, i, true);
    }

    @SuppressLint({"UntrackedBindService"})
    public void c(@RecentlyNonNull Context context, @RecentlyNonNull ServiceConnection serviceConnection) {
        if (!(!(serviceConnection instanceof r0)) || !this.c.containsKey(serviceConnection)) {
            try {
                context.unbindService(serviceConnection);
            } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
            }
        } else {
            try {
                try {
                    context.unbindService(this.c.get(serviceConnection));
                } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused2) {
                }
            } finally {
                this.c.remove(serviceConnection);
            }
        }
    }

    @SuppressLint({"UntrackedBindService"})
    public final boolean d(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, boolean z2) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((b.a(context).a(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!(!(serviceConnection instanceof r0))) {
            return context.bindService(intent, serviceConnection, i);
        }
        ServiceConnection serviceConnectionPutIfAbsent = this.c.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnectionPutIfAbsent != null && serviceConnection != serviceConnectionPutIfAbsent) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
        }
        try {
            boolean zBindService = context.bindService(intent, serviceConnection, i);
            if (zBindService) {
                return zBindService;
            }
            this.c.remove(serviceConnection, serviceConnection);
            return false;
        } catch (Throwable th) {
            this.c.remove(serviceConnection, serviceConnection);
            throw th;
        }
    }
}
