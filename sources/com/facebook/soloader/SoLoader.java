package com.facebook.soloader;

import android.content.Context;
import android.os.Build$VERSION;
import android.os.StrictMode;
import android.os.StrictMode$ThreadPolicy;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import b.c.a.a0.d;
import b.d.b.a.a;
import b.f.m.b;
import b.f.m.c;
import b.f.m.e;
import b.f.m.j;
import b.f.m.k;
import b.f.m.l;
import b.f.m.m;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public class SoLoader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static k f2906b;
    public static m[] f;
    public static b g;
    public static int k;
    public static boolean l;
    public static final ReentrantReadWriteLock c = new ReentrantReadWriteLock();
    public static l[] d = null;
    public static volatile int e = 0;
    public static final HashSet<String> h = new HashSet<>();
    public static final Map<String, Object> i = new HashMap();
    public static final Set<String> j = Collections.newSetFromMap(new ConcurrentHashMap());
    public static final boolean a = true;

    /* JADX WARN: Bottom block not found for handler: all -> 0x0118 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(String str, int i2, StrictMode$ThreadPolicy strictMode$ThreadPolicy) throws UnsatisfiedLinkError {
        boolean z2;
        ReentrantReadWriteLock reentrantReadWriteLock = c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (d == null) {
                Log.e("SoLoader", "Could not load: " + str + " because no SO source exists");
                throw new UnsatisfiedLinkError("couldn't find DSO to load: " + str);
            }
            reentrantReadWriteLock.readLock().unlock();
            int i3 = 0;
            if (strictMode$ThreadPolicy == null) {
                strictMode$ThreadPolicy = StrictMode.allowThreadDiskReads();
                z2 = true;
            } else {
                z2 = false;
            }
            if (a) {
                Api18TraceUtils.a("SoLoader.loadLibrary[", str, "]");
            }
            reentrantReadWriteLock.readLock().lock();
            int iA = 0;
            int i4 = 0;
            while (iA == 0) {
                try {
                    l[] lVarArr = d;
                    if (i4 >= lVarArr.length) {
                        break;
                    }
                    iA = lVarArr[i4].a(str, i2, strictMode$ThreadPolicy);
                    if (iA != 3 || f == null) {
                        i4++;
                    } else {
                        Log.d("SoLoader", "Trying backup SoSource for " + str);
                        for (m mVar : f) {
                            synchronized (mVar) {
                                try {
                                    synchronized (mVar.h(str)) {
                                        try {
                                            mVar.d = str;
                                            mVar.b(2);
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                            int iA2 = mVar.a(str, i2, strictMode$ThreadPolicy);
                            if (iA2 == 1) {
                                iA = iA2;
                                break;
                            }
                        }
                    }
                    th = th;
                    iA = i3;
                    if (a) {
                        Trace.endSection();
                    }
                    if (z2) {
                        StrictMode.setThreadPolicy(strictMode$ThreadPolicy);
                    }
                    if (iA == 0 || iA == 3) {
                        StringBuilder sbX = a.X("couldn't find DSO to load: ", str);
                        String message = th.getMessage();
                        if (message == null) {
                            message = th.toString();
                        }
                        sbX.append(" caused by: ");
                        sbX.append(message);
                        th.printStackTrace();
                        sbX.append(" result: ");
                        sbX.append(iA);
                        String string = sbX.toString();
                        Log.e("SoLoader", string);
                        UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError(string);
                        unsatisfiedLinkError.initCause(th);
                        throw unsatisfiedLinkError;
                    }
                    return;
                } catch (Throwable th3) {
                    i3 = iA;
                    c.readLock().unlock();
                    throw th3;
                }
            }
            try {
                ReentrantReadWriteLock reentrantReadWriteLock2 = c;
                reentrantReadWriteLock2.readLock().unlock();
                if (a) {
                    Trace.endSection();
                }
                if (z2) {
                    StrictMode.setThreadPolicy(strictMode$ThreadPolicy);
                }
                if (iA == 0 || iA == 3) {
                    StringBuilder sbX2 = a.X("couldn't find DSO to load: ", str);
                    reentrantReadWriteLock2.readLock().lock();
                    while (i3 < d.length) {
                        sbX2.append("\n\tSoSource ");
                        sbX2.append(i3);
                        sbX2.append(": ");
                        sbX2.append(d[i3].toString());
                        i3++;
                    }
                    b bVar = g;
                    if (bVar != null) {
                        File fileD = b.d(bVar.e());
                        sbX2.append("\n\tNative lib dir: ");
                        sbX2.append(fileD.getAbsolutePath());
                        sbX2.append("\n");
                    }
                    c.readLock().unlock();
                    sbX2.append(" result: ");
                    sbX2.append(iA);
                    String string2 = sbX2.toString();
                    Log.e("SoLoader", string2);
                    throw new UnsatisfiedLinkError(string2);
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            c.readLock().unlock();
            throw th5;
        }
    }

    public static synchronized void b(k kVar) {
        Method declaredMethod;
        String strJoin;
        try {
            if (kVar != null) {
                f2906b = kVar;
                return;
            }
            Runtime runtime = Runtime.getRuntime();
            int i2 = Build$VERSION.SDK_INT;
            if (i2 < 23 || i2 > 27) {
                declaredMethod = null;
            } else {
                try {
                    declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class, String.class);
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException | SecurityException e2) {
                    Log.w("SoLoader", "Cannot get nativeLoad method", e2);
                    declaredMethod = null;
                }
            }
            boolean z2 = declaredMethod != null;
            String strA = z2 ? SoLoader$Api14Utils.a() : null;
            if (strA == null) {
                strJoin = null;
            } else {
                String[] strArrSplit = strA.split(":");
                ArrayList arrayList = new ArrayList(strArrSplit.length);
                for (String str : strArrSplit) {
                    if (!str.contains("!")) {
                        arrayList.add(str);
                    }
                }
                strJoin = TextUtils.join(":", arrayList);
            }
            f2906b = new SoLoader$a(z2, strA, strJoin, runtime, declaredMethod);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void c(Context context, int i2) throws IOException {
        int i3;
        boolean zIs64Bit;
        c.writeLock().lock();
        try {
            if (d == null) {
                Log.d("SoLoader", "init start");
                k = i2;
                ArrayList arrayList = new ArrayList();
                String str = System.getenv("LD_LIBRARY_PATH");
                if (str == null) {
                    if (Build$VERSION.SDK_INT >= 23) {
                        zIs64Bit = SysUtil$MarshmallowSysdeps.is64Bit();
                    } else {
                        try {
                            zIs64Bit = SysUtil$LollipopSysdeps.is64Bit();
                        } catch (Exception e2) {
                            Log.e("SysUtil", String.format("Could not read /proc/self/exe. Err msg: %s", e2.getMessage()));
                            zIs64Bit = false;
                        }
                    }
                    str = zIs64Bit ? "/vendor/lib64:/system/lib64" : "/vendor/lib:/system/lib";
                }
                for (String str2 : str.split(":")) {
                    Log.d("SoLoader", "adding system library source: " + str2);
                    arrayList.add(new c(new File(str2), 2));
                }
                if (context != null) {
                    if ((i2 & 1) != 0) {
                        f = null;
                        Log.d("SoLoader", "adding exo package source: lib-main");
                        arrayList.add(0, new e(context, "lib-main"));
                    } else {
                        if (l) {
                            i3 = 0;
                        } else {
                            g = new b(context, 0);
                            Log.d("SoLoader", "adding application source: " + g.toString());
                            arrayList.add(0, g);
                            i3 = 1;
                        }
                        if ((k & 8) != 0) {
                            f = null;
                        } else {
                            File file = new File(context.getApplicationInfo().sourceDir);
                            ArrayList arrayList2 = new ArrayList();
                            b.f.m.a aVar = new b.f.m.a(context, file, "lib-main", i3);
                            arrayList2.add(aVar);
                            Log.d("SoLoader", "adding backup source from : " + aVar.toString());
                            if (context.getApplicationInfo().splitSourceDirs != null) {
                                Log.d("SoLoader", "adding backup sources from split apks");
                                String[] strArr = context.getApplicationInfo().splitSourceDirs;
                                int length = strArr.length;
                                int i4 = 0;
                                int i5 = 0;
                                while (i4 < length) {
                                    File file2 = new File(strArr[i4]);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("lib-");
                                    sb.append(i5);
                                    b.f.m.a aVar2 = new b.f.m.a(context, file2, sb.toString(), i3);
                                    Log.d("SoLoader", "adding backup source: " + aVar2.toString());
                                    arrayList2.add(aVar2);
                                    i4++;
                                    i5++;
                                }
                            }
                            f = (m[]) arrayList2.toArray(new m[arrayList2.size()]);
                            arrayList.addAll(0, arrayList2);
                        }
                    }
                }
                l[] lVarArr = (l[]) arrayList.toArray(new l[arrayList.size()]);
                ReentrantReadWriteLock reentrantReadWriteLock = c;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    int i6 = (k & 2) != 0 ? 1 : 0;
                    reentrantReadWriteLock.writeLock().unlock();
                    int length2 = lVarArr.length;
                    while (true) {
                        int i7 = length2 - 1;
                        if (length2 <= 0) {
                            break;
                        }
                        Log.d("SoLoader", "Preparing SO source: " + lVarArr[i7]);
                        lVarArr[i7].b(i6);
                        length2 = i7;
                    }
                    d = lVarArr;
                    e++;
                    Log.d("SoLoader", "init finish: " + d.length + " SO sources prepared");
                } finally {
                    c.writeLock().unlock();
                }
            }
            Log.d("SoLoader", "init exiting");
        } catch (Throwable th) {
            Log.d("SoLoader", "init exiting");
            c.writeLock().unlock();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00b8 A[Catch: all -> 0x0137, PHI: r3
      0x00b8: PHI (r3v5 boolean) = (r3v2 boolean), (r3v3 boolean), (r3v3 boolean) binds: [B:22:0x0044, B:33:0x005b, B:38:0x0091] A[DONT_GENERATE, DONT_INLINE], TryCatch #5 {, blocks: (B:23:0x0046, B:28:0x0050, B:34:0x005d, B:35:0x0076, B:41:0x0094, B:43:0x0096, B:45:0x009c, B:47:0x00a4, B:48:0x00b3, B:49:0x00b4, B:52:0x00b7, B:53:0x00b8, B:55:0x00bc, B:57:0x00c2, B:62:0x00cf, B:64:0x00d3, B:72:0x0124, B:74:0x0128, B:75:0x012b, B:76:0x012c, B:36:0x0077, B:37:0x0090, B:24:0x0047, B:27:0x004f, B:32:0x005a, B:65:0x00da, B:66:0x00fc, B:70:0x0100, B:71:0x0123), top: B:96:0x0046, outer: #6, inners: #0, #2, #3, #7 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00bc A[Catch: all -> 0x0137, TryCatch #5 {, blocks: (B:23:0x0046, B:28:0x0050, B:34:0x005d, B:35:0x0076, B:41:0x0094, B:43:0x0096, B:45:0x009c, B:47:0x00a4, B:48:0x00b3, B:49:0x00b4, B:52:0x00b7, B:53:0x00b8, B:55:0x00bc, B:57:0x00c2, B:62:0x00cf, B:64:0x00d3, B:72:0x0124, B:74:0x0128, B:75:0x012b, B:76:0x012c, B:36:0x0077, B:37:0x0090, B:24:0x0047, B:27:0x004f, B:32:0x005a, B:65:0x00da, B:66:0x00fc, B:70:0x0100, B:71:0x0123), top: B:96:0x0046, outer: #6, inners: #0, #2, #3, #7 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00c2 A[Catch: all -> 0x0137, TryCatch #5 {, blocks: (B:23:0x0046, B:28:0x0050, B:34:0x005d, B:35:0x0076, B:41:0x0094, B:43:0x0096, B:45:0x009c, B:47:0x00a4, B:48:0x00b3, B:49:0x00b4, B:52:0x00b7, B:53:0x00b8, B:55:0x00bc, B:57:0x00c2, B:62:0x00cf, B:64:0x00d3, B:72:0x0124, B:74:0x0128, B:75:0x012b, B:76:0x012c, B:36:0x0077, B:37:0x0090, B:24:0x0047, B:27:0x004f, B:32:0x005a, B:65:0x00da, B:66:0x00fc, B:70:0x0100, B:71:0x0123), top: B:96:0x0046, outer: #6, inners: #0, #2, #3, #7 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00cd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:64:0x00d3 A[Catch: all -> 0x0137, TRY_LEAVE, TryCatch #5 {, blocks: (B:23:0x0046, B:28:0x0050, B:34:0x005d, B:35:0x0076, B:41:0x0094, B:43:0x0096, B:45:0x009c, B:47:0x00a4, B:48:0x00b3, B:49:0x00b4, B:52:0x00b7, B:53:0x00b8, B:55:0x00bc, B:57:0x00c2, B:62:0x00cf, B:64:0x00d3, B:72:0x0124, B:74:0x0128, B:75:0x012b, B:76:0x012c, B:36:0x0077, B:37:0x0090, B:24:0x0047, B:27:0x004f, B:32:0x005a, B:65:0x00da, B:66:0x00fc, B:70:0x0100, B:71:0x0123), top: B:96:0x0046, outer: #6, inners: #0, #2, #3, #7 }] */
    public static boolean d(String str, String str2, String str3, int i2, StrictMode$ThreadPolicy strictMode$ThreadPolicy) {
        boolean z2;
        Object obj;
        boolean z3 = false;
        if (!TextUtils.isEmpty(str2) && j.contains(str2)) {
            return false;
        }
        synchronized (SoLoader.class) {
            HashSet<String> hashSet = h;
            if (!hashSet.contains(str)) {
                z2 = false;
            } else {
                if (str3 == null) {
                    return false;
                }
                z2 = true;
            }
            Map<String, Object> map = i;
            if (map.containsKey(str)) {
                obj = map.get(str);
            } else {
                Object obj2 = new Object();
                map.put(str, obj2);
                obj = obj2;
            }
            ReentrantReadWriteLock reentrantReadWriteLock = c;
            reentrantReadWriteLock.readLock().lock();
            try {
                synchronized (obj) {
                    if (z2) {
                        if ((i2 & 16) == 0) {
                            if (!TextUtils.isEmpty(str2)) {
                                z3 = true;
                            }
                            if (str3 != null) {
                                if (a) {
                                    Api18TraceUtils.a("MergedSoMapping.invokeJniOnload[", str2, "]");
                                }
                                Log.d("SoLoader", "About to merge: " + str2 + " / " + str);
                                d.Q0(str2);
                                throw null;
                            }
                        }
                        reentrantReadWriteLock.readLock().unlock();
                        return !z2;
                    }
                    synchronized (SoLoader.class) {
                        if (hashSet.contains(str)) {
                            if (str3 == null) {
                                reentrantReadWriteLock.readLock().unlock();
                                return false;
                            }
                            z2 = true;
                        }
                        if (z2) {
                            if ((i2 & 16) == 0) {
                                if (!TextUtils.isEmpty(str2)) {
                                    z3 = true;
                                }
                                if (str3 != null) {
                                    if (a) {
                                        Api18TraceUtils.a("MergedSoMapping.invokeJniOnload[", str2, "]");
                                    }
                                    Log.d("SoLoader", "About to merge: " + str2 + " / " + str);
                                    d.Q0(str2);
                                    throw null;
                                }
                            }
                            reentrantReadWriteLock.readLock().unlock();
                            return !z2;
                        }
                        try {
                            Log.d("SoLoader", "About to load: " + str);
                            a(str, i2, strictMode$ThreadPolicy);
                            synchronized (SoLoader.class) {
                                Log.d("SoLoader", "Loaded: " + str);
                                hashSet.add(str);
                            }
                            if ((i2 & 16) == 0) {
                                if (!TextUtils.isEmpty(str2) && j.contains(str2)) {
                                    z3 = true;
                                }
                                if (str3 != null && !z3) {
                                    if (a) {
                                        Api18TraceUtils.a("MergedSoMapping.invokeJniOnload[", str2, "]");
                                    }
                                    try {
                                        try {
                                            Log.d("SoLoader", "About to merge: " + str2 + " / " + str);
                                            d.Q0(str2);
                                            throw null;
                                        } catch (UnsatisfiedLinkError e2) {
                                            throw new RuntimeException("Failed to call JNI_OnLoad from '" + str2 + "', which has been merged into '" + str + "'.  See comment for details.", e2);
                                        }
                                    } catch (Throwable th) {
                                        if (a) {
                                            Trace.endSection();
                                        }
                                        throw th;
                                    }
                                }
                            }
                            reentrantReadWriteLock.readLock().unlock();
                            return !z2;
                        } catch (UnsatisfiedLinkError e3) {
                            String message = e3.getMessage();
                            if (message == null || !message.contains("unexpected e_machine:")) {
                                throw e3;
                            }
                            throw new SoLoader$b(e3, message.substring(message.lastIndexOf("unexpected e_machine:")));
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                c.readLock().unlock();
                throw th2;
            }
        }
    }

    public static void init(Context context, int i2) throws IOException {
        StrictMode$ThreadPolicy strictMode$ThreadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        boolean z2 = false;
        if ((i2 & 32) == 0 && context != null) {
            try {
                if ((context.getApplicationInfo().flags & Opcodes.LOR) != 0) {
                    z2 = true;
                }
            } finally {
                StrictMode.setThreadPolicy(strictMode$ThreadPolicyAllowThreadDiskWrites);
            }
        }
        l = z2;
        b(null);
        c(context, i2);
        b.f.m.n.a.a(new j());
    }
}
