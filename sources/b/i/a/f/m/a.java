package b.i.a.f.m;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.m.a;
import b.i.a.f.e.o.h;
import b.i.a.f.e.o.i;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static ScheduledExecutorService a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1591b;
    public final PowerManager.WakeLock c;
    public WorkSource d;
    public final int e;
    public final String f;
    public final Context g;
    public boolean h;
    public final Map<String, Integer[]> i;
    public int j;
    public AtomicInteger k;

    public a(@NonNull Context context, int i, @NonNull String str) {
        a.InterfaceC0038a interfaceC0038a;
        WorkSource workSource = null;
        String packageName = context == null ? null : context.getPackageName();
        this.f1591b = this;
        this.h = true;
        this.i = new HashMap();
        Collections.synchronizedSet(new HashSet());
        this.k = new AtomicInteger(0);
        AnimatableValueParser.z(context, "WakeLock: context must not be null");
        AnimatableValueParser.v(str, "WakeLock: wakeLockName must not be empty");
        this.e = i;
        this.g = context.getApplicationContext();
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f = str;
        } else {
            this.f = str.length() != 0 ? "*gcore*:".concat(str) : new String("*gcore*:");
        }
        this.c = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (i.a(context)) {
            packageName = h.a(packageName) ? context.getPackageName() : packageName;
            if (context.getPackageManager() != null && packageName != null) {
                try {
                    ApplicationInfo applicationInfo = b.i.a.f.e.p.b.a(context).a.getPackageManager().getApplicationInfo(packageName, 0);
                    if (applicationInfo == null) {
                        Log.e("WorkSourceUtil", packageName.length() != 0 ? "Could not get applicationInfo from package: ".concat(packageName) : new String("Could not get applicationInfo from package: "));
                    } else {
                        int i2 = applicationInfo.uid;
                        workSource = new WorkSource();
                        Method method = i.f1399b;
                        if (method != null) {
                            try {
                                method.invoke(workSource, Integer.valueOf(i2), packageName);
                            } catch (Exception e) {
                                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
                            }
                        } else {
                            Method method2 = i.a;
                            if (method2 != null) {
                                try {
                                    method2.invoke(workSource, Integer.valueOf(i2));
                                } catch (Exception e2) {
                                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                                }
                            }
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    Log.e("WorkSourceUtil", packageName.length() != 0 ? "Could not find package: ".concat(packageName) : new String("Could not find package: "));
                }
            }
            this.d = workSource;
            if (workSource != null && i.a(this.g)) {
                WorkSource workSource2 = this.d;
                if (workSource2 != null) {
                    workSource2.add(workSource);
                } else {
                    this.d = workSource;
                }
                try {
                    this.c.setWorkSource(this.d);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e3) {
                    Log.wtf("WakeLock", e3.toString());
                }
            }
        }
        if (a == null) {
            synchronized (b.i.a.f.e.m.a.class) {
                if (b.i.a.f.e.m.a.a == null) {
                    b.i.a.f.e.m.a.a = new b.i.a.f.e.m.b();
                }
                interfaceC0038a = b.i.a.f.e.m.a.a;
            }
            Objects.requireNonNull((b.i.a.f.e.m.b) interfaceC0038a);
            a = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0059 A[Catch: all -> 0x0087, TryCatch #0 {, blocks: (B:7:0x0010, B:9:0x0019, B:14:0x002c, B:16:0x0031, B:18:0x003b, B:25:0x0061, B:26:0x006e, B:19:0x004a, B:21:0x0059, B:23:0x005d, B:11:0x001d, B:13:0x0025), top: B:34:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0061 A[Catch: all -> 0x0087, TryCatch #0 {, blocks: (B:7:0x0010, B:9:0x0019, B:14:0x002c, B:16:0x0031, B:18:0x003b, B:25:0x0061, B:26:0x006e, B:19:0x004a, B:21:0x0059, B:23:0x005d, B:11:0x001d, B:13:0x0025), top: B:34:0x0010 }] */
    public void a(long j) {
        this.k.incrementAndGet();
        if (this.h) {
            TextUtils.isEmpty(null);
        }
        synchronized (this.f1591b) {
            boolean z2 = false;
            if ((!this.i.isEmpty() || this.j > 0) && !this.c.isHeld()) {
                this.i.clear();
                this.j = 0;
            }
            if (this.h) {
                Integer[] numArr = this.i.get(null);
                if (numArr == null) {
                    this.i.put(null, new Integer[]{1});
                    z2 = true;
                } else {
                    numArr[0] = Integer.valueOf(numArr[0].intValue() + 1);
                }
                if (z2) {
                    AnimatableValueParser.v0(this.c, null);
                    c();
                    this.j++;
                } else if (!this.h) {
                    AnimatableValueParser.v0(this.c, null);
                    c();
                    this.j++;
                }
            } else if (!this.h && this.j == 0) {
                AnimatableValueParser.v0(this.c, null);
                c();
                this.j++;
            }
        }
        this.c.acquire();
        if (j > 0) {
            a.schedule(new b(this), j, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0053 A[Catch: all -> 0x006d, TryCatch #0 {, blocks: (B:10:0x0024, B:12:0x0029, B:24:0x005b, B:25:0x0068, B:15:0x0035, B:17:0x003d, B:18:0x0044, B:20:0x0053, B:22:0x0057), top: B:31:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x005b A[Catch: all -> 0x006d, TryCatch #0 {, blocks: (B:10:0x0024, B:12:0x0029, B:24:0x005b, B:25:0x0068, B:15:0x0035, B:17:0x003d, B:18:0x0044, B:20:0x0053, B:22:0x0057), top: B:31:0x0024 }] */
    public void b() {
        if (this.k.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f).concat(" release without a matched acquire!"));
        }
        if (this.h) {
            TextUtils.isEmpty(null);
        }
        synchronized (this.f1591b) {
            if (this.h) {
                Integer[] numArr = this.i.get(null);
                boolean z2 = false;
                if (numArr != null) {
                    if (numArr[0].intValue() == 1) {
                        this.i.remove(null);
                        z2 = true;
                    } else {
                        numArr[0] = Integer.valueOf(numArr[0].intValue() - 1);
                    }
                }
                if (z2) {
                    AnimatableValueParser.v0(this.c, null);
                    c();
                    this.j--;
                } else if (!this.h && this.j == 1) {
                    AnimatableValueParser.v0(this.c, null);
                    c();
                    this.j--;
                }
            } else if (!this.h) {
                AnimatableValueParser.v0(this.c, null);
                c();
                this.j--;
            }
        }
        d();
    }

    public final List<String> c() {
        int iIntValue;
        Method method;
        WorkSource workSource = this.d;
        Method method2 = i.a;
        ArrayList arrayList = new ArrayList();
        if (workSource == null || (method = i.c) == null) {
            iIntValue = 0;
        } else {
            try {
                Object objInvoke = method.invoke(workSource, new Object[0]);
                Objects.requireNonNull(objInvoke, "null reference");
                iIntValue = ((Integer) objInvoke).intValue();
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
                iIntValue = 0;
            }
        }
        if (iIntValue != 0) {
            for (int i = 0; i < iIntValue; i++) {
                Method method3 = i.d;
                String str = null;
                if (method3 != null) {
                    try {
                        str = (String) method3.invoke(workSource, Integer.valueOf(i));
                    } catch (Exception e2) {
                        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                    }
                }
                if (!h.a(str)) {
                    Objects.requireNonNull(str, "null reference");
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    public final void d() {
        if (this.c.isHeld()) {
            try {
                this.c.release();
            } catch (RuntimeException e) {
                if (!e.getClass().equals(RuntimeException.class)) {
                    throw e;
                }
                Log.e("WakeLock", String.valueOf(this.f).concat(" was already released!"), e);
            }
            this.c.isHeld();
        }
    }
}
