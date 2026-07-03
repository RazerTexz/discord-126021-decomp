package p007b.p225i.p226a.p288f.p339m;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p306m.C3396a;
import p007b.p225i.p226a.p288f.p299e.p306m.C3397b;
import p007b.p225i.p226a.p288f.p299e.p308o.C3406h;
import p007b.p225i.p226a.p288f.p299e.p308o.C3407i;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;

/* JADX INFO: renamed from: b.i.a.f.m.a */
/* JADX INFO: loaded from: classes3.dex */
public class C4351a {

    /* JADX INFO: renamed from: a */
    public static ScheduledExecutorService f11458a;

    /* JADX INFO: renamed from: b */
    public final Object f11459b;

    /* JADX INFO: renamed from: c */
    public final PowerManager.WakeLock f11460c;

    /* JADX INFO: renamed from: d */
    public WorkSource f11461d;

    /* JADX INFO: renamed from: e */
    public final int f11462e;

    /* JADX INFO: renamed from: f */
    public final String f11463f;

    /* JADX INFO: renamed from: g */
    public final Context f11464g;

    /* JADX INFO: renamed from: h */
    public boolean f11465h;

    /* JADX INFO: renamed from: i */
    public final Map<String, Integer[]> f11466i;

    /* JADX INFO: renamed from: j */
    public int f11467j;

    /* JADX INFO: renamed from: k */
    public AtomicInteger f11468k;

    public C4351a(@NonNull Context context, int i, @NonNull String str) {
        C3396a.a aVar;
        WorkSource workSource = null;
        String packageName = context == null ? null : context.getPackageName();
        this.f11459b = this;
        this.f11465h = true;
        this.f11466i = new HashMap();
        Collections.synchronizedSet(new HashSet());
        this.f11468k = new AtomicInteger(0);
        C1460d.m595z(context, "WakeLock: context must not be null");
        C1460d.m579v(str, "WakeLock: wakeLockName must not be empty");
        this.f11462e = i;
        this.f11464g = context.getApplicationContext();
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f11463f = str;
        } else {
            this.f11463f = str.length() != 0 ? "*gcore*:".concat(str) : new String("*gcore*:");
        }
        this.f11460c = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (C3407i.m4372a(context)) {
            packageName = C3406h.m4371a(packageName) ? context.getPackageName() : packageName;
            if (context.getPackageManager() != null && packageName != null) {
                try {
                    ApplicationInfo applicationInfo = C3411b.m4376a(context).f9605a.getPackageManager().getApplicationInfo(packageName, 0);
                    if (applicationInfo == null) {
                        Log.e("WorkSourceUtil", packageName.length() != 0 ? "Could not get applicationInfo from package: ".concat(packageName) : new String("Could not get applicationInfo from package: "));
                    } else {
                        int i2 = applicationInfo.uid;
                        workSource = new WorkSource();
                        Method method = C3407i.f9599b;
                        if (method != null) {
                            try {
                                method.invoke(workSource, Integer.valueOf(i2), packageName);
                            } catch (Exception e) {
                                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
                            }
                        } else {
                            Method method2 = C3407i.f9598a;
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
            this.f11461d = workSource;
            if (workSource != null && C3407i.m4372a(this.f11464g)) {
                WorkSource workSource2 = this.f11461d;
                if (workSource2 != null) {
                    workSource2.add(workSource);
                } else {
                    this.f11461d = workSource;
                }
                try {
                    this.f11460c.setWorkSource(this.f11461d);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e3) {
                    Log.wtf("WakeLock", e3.toString());
                }
            }
        }
        if (f11458a == null) {
            synchronized (C3396a.class) {
                if (C3396a.f9580a == null) {
                    C3396a.f9580a = new C3397b();
                }
                aVar = C3396a.f9580a;
            }
            Objects.requireNonNull((C3397b) aVar);
            f11458a = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0059 A[Catch: all -> 0x0087, TryCatch #0 {, blocks: (B:7:0x0010, B:9:0x0019, B:14:0x002c, B:16:0x0031, B:18:0x003b, B:25:0x0061, B:26:0x006e, B:19:0x004a, B:21:0x0059, B:23:0x005d, B:11:0x001d, B:13:0x0025), top: B:34:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0061 A[Catch: all -> 0x0087, TryCatch #0 {, blocks: (B:7:0x0010, B:9:0x0019, B:14:0x002c, B:16:0x0031, B:18:0x003b, B:25:0x0061, B:26:0x006e, B:19:0x004a, B:21:0x0059, B:23:0x005d, B:11:0x001d, B:13:0x0025), top: B:34:0x0010 }] */
    /* JADX INFO: renamed from: a */
    public void m6001a(long j) {
        this.f11468k.incrementAndGet();
        if (this.f11465h) {
            TextUtils.isEmpty(null);
        }
        synchronized (this.f11459b) {
            boolean z2 = false;
            if ((!this.f11466i.isEmpty() || this.f11467j > 0) && !this.f11460c.isHeld()) {
                this.f11466i.clear();
                this.f11467j = 0;
            }
            if (this.f11465h) {
                Integer[] numArr = this.f11466i.get(null);
                if (numArr == null) {
                    this.f11466i.put(null, new Integer[]{1});
                    z2 = true;
                } else {
                    numArr[0] = Integer.valueOf(numArr[0].intValue() + 1);
                }
                if (z2) {
                    C1460d.m580v0(this.f11460c, null);
                    m6003c();
                    this.f11467j++;
                } else if (!this.f11465h) {
                    C1460d.m580v0(this.f11460c, null);
                    m6003c();
                    this.f11467j++;
                }
            } else if (!this.f11465h && this.f11467j == 0) {
                C1460d.m580v0(this.f11460c, null);
                m6003c();
                this.f11467j++;
            }
        }
        this.f11460c.acquire();
        if (j > 0) {
            f11458a.schedule(new RunnableC4352b(this), j, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0053 A[Catch: all -> 0x006d, TryCatch #0 {, blocks: (B:10:0x0024, B:12:0x0029, B:24:0x005b, B:25:0x0068, B:15:0x0035, B:17:0x003d, B:18:0x0044, B:20:0x0053, B:22:0x0057), top: B:31:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x005b A[Catch: all -> 0x006d, TryCatch #0 {, blocks: (B:10:0x0024, B:12:0x0029, B:24:0x005b, B:25:0x0068, B:15:0x0035, B:17:0x003d, B:18:0x0044, B:20:0x0053, B:22:0x0057), top: B:31:0x0024 }] */
    /* JADX INFO: renamed from: b */
    public void m6002b() {
        if (this.f11468k.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f11463f).concat(" release without a matched acquire!"));
        }
        if (this.f11465h) {
            TextUtils.isEmpty(null);
        }
        synchronized (this.f11459b) {
            if (this.f11465h) {
                Integer[] numArr = this.f11466i.get(null);
                boolean z2 = false;
                if (numArr != null) {
                    if (numArr[0].intValue() == 1) {
                        this.f11466i.remove(null);
                        z2 = true;
                    } else {
                        numArr[0] = Integer.valueOf(numArr[0].intValue() - 1);
                    }
                }
                if (z2) {
                    C1460d.m580v0(this.f11460c, null);
                    m6003c();
                    this.f11467j--;
                } else if (!this.f11465h && this.f11467j == 1) {
                    C1460d.m580v0(this.f11460c, null);
                    m6003c();
                    this.f11467j--;
                }
            } else if (!this.f11465h) {
                C1460d.m580v0(this.f11460c, null);
                m6003c();
                this.f11467j--;
            }
        }
        m6004d();
    }

    /* JADX INFO: renamed from: c */
    public final List<String> m6003c() {
        int iIntValue;
        Method method;
        WorkSource workSource = this.f11461d;
        Method method2 = C3407i.f9598a;
        ArrayList arrayList = new ArrayList();
        if (workSource == null || (method = C3407i.f9600c) == null) {
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
                Method method3 = C3407i.f9601d;
                String str = null;
                if (method3 != null) {
                    try {
                        str = (String) method3.invoke(workSource, Integer.valueOf(i));
                    } catch (Exception e2) {
                        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                    }
                }
                if (!C3406h.m4371a(str)) {
                    Objects.requireNonNull(str, "null reference");
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: d */
    public final void m6004d() {
        if (this.f11460c.isHeld()) {
            try {
                this.f11460c.release();
            } catch (RuntimeException e) {
                if (!e.getClass().equals(RuntimeException.class)) {
                    throw e;
                }
                Log.e("WakeLock", String.valueOf(this.f11463f).concat(" was already released!"), e);
            }
            this.f11460c.isHeld();
        }
    }
}
