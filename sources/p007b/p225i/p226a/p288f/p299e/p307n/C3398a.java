package p007b.p225i.p226a.p288f.p299e.p307n;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import p007b.p225i.p226a.p288f.p299e.p304k.ServiceConnectionC3378r0;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;

/* JADX INFO: renamed from: b.i.a.f.e.n.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3398a {

    /* JADX INFO: renamed from: a */
    public static final Object f9581a = new Object();

    /* JADX INFO: renamed from: b */
    public static volatile C3398a f9582b;

    /* JADX INFO: renamed from: c */
    @RecentlyNonNull
    public ConcurrentHashMap<ServiceConnection, ServiceConnection> f9583c = new ConcurrentHashMap<>();

    @RecentlyNonNull
    /* JADX INFO: renamed from: b */
    public static C3398a m4181b() {
        if (f9582b == null) {
            synchronized (f9581a) {
                if (f9582b == null) {
                    f9582b = new C3398a();
                }
            }
        }
        C3398a c3398a = f9582b;
        Objects.requireNonNull(c3398a, "null reference");
        return c3398a;
    }

    /* JADX INFO: renamed from: a */
    public boolean m4182a(@RecentlyNonNull Context context, @RecentlyNonNull Intent intent, @RecentlyNonNull ServiceConnection serviceConnection, int i) {
        return m4184d(context, context.getClass().getName(), intent, serviceConnection, i, true);
    }

    @SuppressLint({"UntrackedBindService"})
    /* JADX INFO: renamed from: c */
    public void m4183c(@RecentlyNonNull Context context, @RecentlyNonNull ServiceConnection serviceConnection) {
        if (!(!(serviceConnection instanceof ServiceConnectionC3378r0)) || !this.f9583c.containsKey(serviceConnection)) {
            try {
                context.unbindService(serviceConnection);
            } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
            }
        } else {
            try {
                try {
                    context.unbindService(this.f9583c.get(serviceConnection));
                } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused2) {
                }
            } finally {
                this.f9583c.remove(serviceConnection);
            }
        }
    }

    @SuppressLint({"UntrackedBindService"})
    /* JADX INFO: renamed from: d */
    public final boolean m4184d(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, boolean z2) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((C3411b.m4376a(context).m4373a(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!(!(serviceConnection instanceof ServiceConnectionC3378r0))) {
            return context.bindService(intent, serviceConnection, i);
        }
        ServiceConnection serviceConnectionPutIfAbsent = this.f9583c.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnectionPutIfAbsent != null && serviceConnection != serviceConnectionPutIfAbsent) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
        }
        try {
            boolean zBindService = context.bindService(intent, serviceConnection, i);
            if (zBindService) {
                return zBindService;
            }
            this.f9583c.remove(serviceConnection, serviceConnection);
            return false;
        } catch (Throwable th) {
            this.f9583c.remove(serviceConnection, serviceConnection);
            throw th;
        }
    }
}
