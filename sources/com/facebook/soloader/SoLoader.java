package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import com.adjust.sdk.Constants;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p109f.p190m.AbstractC2059l;
import p007b.p109f.p190m.AbstractC2060m;
import p007b.p109f.p190m.C2048a;
import p007b.p109f.p190m.C2049b;
import p007b.p109f.p190m.C2050c;
import p007b.p109f.p190m.C2052e;
import p007b.p109f.p190m.C2057j;
import p007b.p109f.p190m.InterfaceC2051d;
import p007b.p109f.p190m.InterfaceC2058k;
import p007b.p109f.p190m.p191n.C2061a;

/* JADX INFO: loaded from: classes3.dex */
public class SoLoader {

    /* JADX INFO: renamed from: b */
    public static InterfaceC2058k f19642b;

    /* JADX INFO: renamed from: f */
    public static AbstractC2060m[] f19646f;

    /* JADX INFO: renamed from: g */
    public static C2049b f19647g;

    /* JADX INFO: renamed from: k */
    public static int f19651k;

    /* JADX INFO: renamed from: l */
    public static boolean f19652l;

    /* JADX INFO: renamed from: c */
    public static final ReentrantReadWriteLock f19643c = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: d */
    public static AbstractC2059l[] f19644d = null;

    /* JADX INFO: renamed from: e */
    public static volatile int f19645e = 0;

    /* JADX INFO: renamed from: h */
    public static final HashSet<String> f19648h = new HashSet<>();

    /* JADX INFO: renamed from: i */
    public static final Map<String, Object> f19649i = new HashMap();

    /* JADX INFO: renamed from: j */
    public static final Set<String> f19650j = Collections.newSetFromMap(new ConcurrentHashMap());

    /* JADX INFO: renamed from: a */
    public static final boolean f19641a = true;

    @InterfaceC2051d
    @TargetApi(14)
    public static class Api14Utils {
        private Api14Utils() {
        }

        /* JADX INFO: renamed from: a */
        public static String m8732a() {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader == null || (classLoader instanceof BaseDexClassLoader)) {
                try {
                    return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
                } catch (Exception e) {
                    throw new RuntimeException("Cannot call getLdLibraryPath", e);
                }
            }
            StringBuilder sbM833U = C1643a.m833U("ClassLoader ");
            sbM833U.append(classLoader.getClass().getName());
            sbM833U.append(" should be of type BaseDexClassLoader");
            throw new IllegalStateException(sbM833U.toString());
        }
    }

    /* JADX INFO: renamed from: com.facebook.soloader.SoLoader$a */
    public static class C10674a implements InterfaceC2058k {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ boolean f19653a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ String f19654b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ String f19655c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ Runtime f19656d;

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ Method f19657e;

        public C10674a(boolean z2, String str, String str2, Runtime runtime, Method method) {
            this.f19653a = z2;
            this.f19654b = str;
            this.f19655c = str2;
            this.f19656d = runtime;
            this.f19657e = method;
        }

        /* JADX INFO: renamed from: a */
        public final String m8733a(String str) {
            try {
                File file = new File(str);
                MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i <= 0) {
                            String str2 = String.format("%32x", new BigInteger(1, messageDigest.digest()));
                            fileInputStream.close();
                            return str2;
                        }
                        messageDigest.update(bArr, 0, i);
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (IOException e) {
                return e.toString();
            } catch (SecurityException e2) {
                return e2.toString();
            } catch (NoSuchAlgorithmException e3) {
                return e3.toString();
            }
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x006f */
        /* JADX WARN: Code duplicated, block: B:47:0x0094  */
        /* JADX INFO: renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void m8734b(String str, int i) throws Throwable {
            String str2;
            if (!this.f19653a) {
                System.load(str);
                return;
            }
            C10674a c10674a = null;
            String str3 = (i & 4) == 4 ? this.f19654b : this.f19655c;
            try {
                try {
                    synchronized (this.f19656d) {
                        try {
                            str2 = (String) this.f19657e.invoke(this.f19656d, str, SoLoader.class.getClassLoader(), str3);
                            try {
                                if (str2 != null) {
                                    throw new UnsatisfiedLinkError(str2);
                                }
                            } catch (Throwable th) {
                                th = th;
                                while (true) {
                                    try {
                                        break;
                                    } catch (IllegalAccessException e) {
                                        e = e;
                                        throw new RuntimeException("Error: Cannot load " + str, e);
                                    } catch (IllegalArgumentException e2) {
                                        e = e2;
                                        throw new RuntimeException("Error: Cannot load " + str, e);
                                    } catch (InvocationTargetException e3) {
                                        e = e3;
                                        throw new RuntimeException("Error: Cannot load " + str, e);
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    if (str2 != null) {
                        StringBuilder sbM837Y = C1643a.m837Y("Error when loading lib: ", str2, " lib hash: ");
                        sbM837Y.append(m8733a(str));
                        sbM837Y.append(" search path is ");
                        sbM837Y.append(str3);
                        Log.e("SoLoader", sbM837Y.toString());
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (0 != 0) {
                        StringBuilder sbM837Y2 = C1643a.m837Y("Error when loading lib: ", null, " lib hash: ");
                        sbM837Y2.append(c10674a.m8733a(str));
                        sbM837Y2.append(" search path is ");
                        sbM837Y2.append(str3);
                        Log.e("SoLoader", sbM837Y2.toString());
                    }
                    throw th;
                }
            } catch (IllegalAccessException e4) {
                e = e4;
                throw new RuntimeException("Error: Cannot load " + str, e);
            } catch (IllegalArgumentException e5) {
                e = e5;
                throw new RuntimeException("Error: Cannot load " + str, e);
            } catch (InvocationTargetException e6) {
                e = e6;
                throw new RuntimeException("Error: Cannot load " + str, e);
            } catch (Throwable th4) {
                th = th4;
                c10674a = this;
                if (0 != 0) {
                    StringBuilder sbM837Y3 = C1643a.m837Y("Error when loading lib: ", null, " lib hash: ");
                    sbM837Y3.append(c10674a.m8733a(str));
                    sbM837Y3.append(" search path is ");
                    sbM837Y3.append(str3);
                    Log.e("SoLoader", sbM837Y3.toString());
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.facebook.soloader.SoLoader$b */
    public static final class C10675b extends UnsatisfiedLinkError {
        /* JADX WARN: Illegal instructions before constructor call */
        public C10675b(Throwable th, String str) {
            StringBuilder sbM833U = C1643a.m833U("APK was built for a different platform. Supported ABIs: ");
            sbM833U.append(Arrays.toString(C1460d.m424C0()));
            sbM833U.append(" error: ");
            sbM833U.append(str);
            super(sbM833U.toString());
            initCause(th);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m8728a(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws UnsatisfiedLinkError {
        boolean z2;
        int iMo1568a;
        ReentrantReadWriteLock reentrantReadWriteLock = f19643c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (f19644d == null) {
                Log.e("SoLoader", "Could not load: " + str + " because no SO source exists");
                throw new UnsatisfiedLinkError("couldn't find DSO to load: " + str);
            }
            reentrantReadWriteLock.readLock().unlock();
            int i2 = 0;
            if (threadPolicy == null) {
                threadPolicy = StrictMode.allowThreadDiskReads();
                z2 = true;
            } else {
                z2 = false;
            }
            if (f19641a) {
                Api18TraceUtils.m8727a("SoLoader.loadLibrary[", str, "]");
            }
            try {
                reentrantReadWriteLock.readLock().lock();
                iMo1568a = 0;
                int i3 = 0;
                while (iMo1568a == 0) {
                    try {
                        AbstractC2059l[] abstractC2059lArr = f19644d;
                        if (i3 >= abstractC2059lArr.length) {
                            break;
                        }
                        iMo1568a = abstractC2059lArr[i3].mo1568a(str, i, threadPolicy);
                        if (iMo1568a != 3 || f19646f == null) {
                            i3++;
                        } else {
                            Log.d("SoLoader", "Trying backup SoSource for " + str);
                            for (AbstractC2060m abstractC2060m : f19646f) {
                                synchronized (abstractC2060m) {
                                    try {
                                        synchronized (abstractC2060m.m1583h(str)) {
                                            try {
                                                abstractC2060m.f4345d = str;
                                                abstractC2060m.mo1569b(2);
                                            } catch (Throwable th) {
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                                int iMo1568a2 = abstractC2060m.mo1568a(str, i, threadPolicy);
                                if (iMo1568a2 == 1) {
                                    iMo1568a = iMo1568a2;
                                    break;
                                }
                            }
                        }
                        th = th;
                        iMo1568a = i2;
                        if (f19641a) {
                            Trace.endSection();
                        }
                        if (z2) {
                            StrictMode.setThreadPolicy(threadPolicy);
                        }
                        if (iMo1568a == 0 || iMo1568a == 3) {
                            StringBuilder sbM836X = C1643a.m836X("couldn't find DSO to load: ", str);
                            String message = th.getMessage();
                            if (message == null) {
                                message = th.toString();
                            }
                            sbM836X.append(" caused by: ");
                            sbM836X.append(message);
                            th.printStackTrace();
                            sbM836X.append(" result: ");
                            sbM836X.append(iMo1568a);
                            String string = sbM836X.toString();
                            Log.e("SoLoader", string);
                            UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError(string);
                            unsatisfiedLinkError.initCause(th);
                            throw unsatisfiedLinkError;
                        }
                        return;
                    } catch (Throwable th3) {
                        i2 = iMo1568a;
                        f19643c.readLock().unlock();
                        throw th3;
                    }
                }
                try {
                    ReentrantReadWriteLock reentrantReadWriteLock2 = f19643c;
                    reentrantReadWriteLock2.readLock().unlock();
                    if (f19641a) {
                        Trace.endSection();
                    }
                    if (z2) {
                        StrictMode.setThreadPolicy(threadPolicy);
                    }
                    if (iMo1568a == 0 || iMo1568a == 3) {
                        StringBuilder sbM836X2 = C1643a.m836X("couldn't find DSO to load: ", str);
                        reentrantReadWriteLock2.readLock().lock();
                        while (i2 < f19644d.length) {
                            sbM836X2.append("\n\tSoSource ");
                            sbM836X2.append(i2);
                            sbM836X2.append(": ");
                            sbM836X2.append(f19644d[i2].toString());
                            i2++;
                        }
                        C2049b c2049b = f19647g;
                        if (c2049b != null) {
                            File fileM1567d = C2049b.m1567d(c2049b.m1571e());
                            sbM836X2.append("\n\tNative lib dir: ");
                            sbM836X2.append(fileM1567d.getAbsolutePath());
                            sbM836X2.append("\n");
                        }
                        f19643c.readLock().unlock();
                        sbM836X2.append(" result: ");
                        sbM836X2.append(iMo1568a);
                        String string2 = sbM836X2.toString();
                        Log.e("SoLoader", string2);
                        throw new UnsatisfiedLinkError(string2);
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
                iMo1568a = i2;
            }
        } catch (Throwable th6) {
            f19643c.readLock().unlock();
            throw th6;
        }
    }

    /* JADX INFO: renamed from: b */
    public static synchronized void m8729b(InterfaceC2058k interfaceC2058k) {
        Method declaredMethod;
        String strJoin;
        try {
            if (interfaceC2058k != null) {
                f19642b = interfaceC2058k;
                return;
            }
            Runtime runtime = Runtime.getRuntime();
            int i = Build.VERSION.SDK_INT;
            if (i < 23 || i > 27) {
                declaredMethod = null;
            } else {
                try {
                    declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class, String.class);
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException | SecurityException e) {
                    Log.w("SoLoader", "Cannot get nativeLoad method", e);
                    declaredMethod = null;
                }
            }
            boolean z2 = declaredMethod != null;
            String strM8732a = z2 ? Api14Utils.m8732a() : null;
            if (strM8732a == null) {
                strJoin = null;
            } else {
                String[] strArrSplit = strM8732a.split(":");
                ArrayList arrayList = new ArrayList(strArrSplit.length);
                for (String str : strArrSplit) {
                    if (!str.contains("!")) {
                        arrayList.add(str);
                    }
                }
                strJoin = TextUtils.join(":", arrayList);
            }
            f19642b = new C10674a(z2, strM8732a, strJoin, runtime, declaredMethod);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m8730c(Context context, int i) throws IOException {
        int i2;
        boolean zIs64Bit;
        f19643c.writeLock().lock();
        try {
            if (f19644d == null) {
                Log.d("SoLoader", "init start");
                f19651k = i;
                ArrayList arrayList = new ArrayList();
                String str = System.getenv("LD_LIBRARY_PATH");
                if (str == null) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        zIs64Bit = SysUtil$MarshmallowSysdeps.is64Bit();
                    } else {
                        try {
                            zIs64Bit = SysUtil$LollipopSysdeps.is64Bit();
                        } catch (Exception e) {
                            Log.e("SysUtil", String.format("Could not read /proc/self/exe. Err msg: %s", e.getMessage()));
                            zIs64Bit = false;
                        }
                    }
                    str = zIs64Bit ? "/vendor/lib64:/system/lib64" : "/vendor/lib:/system/lib";
                }
                for (String str2 : str.split(":")) {
                    Log.d("SoLoader", "adding system library source: " + str2);
                    arrayList.add(new C2050c(new File(str2), 2));
                }
                if (context != null) {
                    if ((i & 1) != 0) {
                        f19646f = null;
                        Log.d("SoLoader", "adding exo package source: lib-main");
                        arrayList.add(0, new C2052e(context, "lib-main"));
                    } else {
                        if (f19652l) {
                            i2 = 0;
                        } else {
                            f19647g = new C2049b(context, 0);
                            Log.d("SoLoader", "adding application source: " + f19647g.toString());
                            arrayList.add(0, f19647g);
                            i2 = 1;
                        }
                        if ((f19651k & 8) != 0) {
                            f19646f = null;
                        } else {
                            File file = new File(context.getApplicationInfo().sourceDir);
                            ArrayList arrayList2 = new ArrayList();
                            C2048a c2048a = new C2048a(context, file, "lib-main", i2);
                            arrayList2.add(c2048a);
                            Log.d("SoLoader", "adding backup source from : " + c2048a.toString());
                            if (context.getApplicationInfo().splitSourceDirs != null) {
                                Log.d("SoLoader", "adding backup sources from split apks");
                                String[] strArr = context.getApplicationInfo().splitSourceDirs;
                                int length = strArr.length;
                                int i3 = 0;
                                int i4 = 0;
                                while (i3 < length) {
                                    File file2 = new File(strArr[i3]);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("lib-");
                                    sb.append(i4);
                                    C2048a c2048a2 = new C2048a(context, file2, sb.toString(), i2);
                                    Log.d("SoLoader", "adding backup source: " + c2048a2.toString());
                                    arrayList2.add(c2048a2);
                                    i3++;
                                    i4++;
                                }
                            }
                            f19646f = (AbstractC2060m[]) arrayList2.toArray(new AbstractC2060m[arrayList2.size()]);
                            arrayList.addAll(0, arrayList2);
                        }
                    }
                }
                AbstractC2059l[] abstractC2059lArr = (AbstractC2059l[]) arrayList.toArray(new AbstractC2059l[arrayList.size()]);
                ReentrantReadWriteLock reentrantReadWriteLock = f19643c;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    int i5 = (f19651k & 2) != 0 ? 1 : 0;
                    reentrantReadWriteLock.writeLock().unlock();
                    int length2 = abstractC2059lArr.length;
                    while (true) {
                        int i6 = length2 - 1;
                        if (length2 <= 0) {
                            break;
                        }
                        Log.d("SoLoader", "Preparing SO source: " + abstractC2059lArr[i6]);
                        abstractC2059lArr[i6].mo1569b(i5);
                        length2 = i6;
                    }
                    f19644d = abstractC2059lArr;
                    f19645e++;
                    Log.d("SoLoader", "init finish: " + f19644d.length + " SO sources prepared");
                } finally {
                    f19643c.writeLock().unlock();
                }
            }
            Log.d("SoLoader", "init exiting");
        } catch (Throwable th) {
            Log.d("SoLoader", "init exiting");
            f19643c.writeLock().unlock();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00b8 A[Catch: all -> 0x0137, PHI: r3
      0x00b8: PHI (r3v5 boolean) = (r3v2 boolean), (r3v3 boolean), (r3v3 boolean) binds: [B:22:0x0044, B:33:0x005b, B:38:0x0091] A[DONT_GENERATE, DONT_INLINE], TryCatch #5 {, blocks: (B:23:0x0046, B:28:0x0050, B:34:0x005d, B:35:0x0076, B:41:0x0094, B:43:0x0096, B:45:0x009c, B:47:0x00a4, B:48:0x00b3, B:49:0x00b4, B:52:0x00b7, B:53:0x00b8, B:55:0x00bc, B:57:0x00c2, B:62:0x00cf, B:64:0x00d3, B:72:0x0124, B:74:0x0128, B:75:0x012b, B:76:0x012c, B:36:0x0077, B:37:0x0090, B:24:0x0047, B:27:0x004f, B:32:0x005a, B:65:0x00da, B:66:0x00fc, B:70:0x0100, B:71:0x0123), top: B:96:0x0046, outer: #6, inners: #0, #2, #3, #7 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00bc A[Catch: all -> 0x0137, TryCatch #5 {, blocks: (B:23:0x0046, B:28:0x0050, B:34:0x005d, B:35:0x0076, B:41:0x0094, B:43:0x0096, B:45:0x009c, B:47:0x00a4, B:48:0x00b3, B:49:0x00b4, B:52:0x00b7, B:53:0x00b8, B:55:0x00bc, B:57:0x00c2, B:62:0x00cf, B:64:0x00d3, B:72:0x0124, B:74:0x0128, B:75:0x012b, B:76:0x012c, B:36:0x0077, B:37:0x0090, B:24:0x0047, B:27:0x004f, B:32:0x005a, B:65:0x00da, B:66:0x00fc, B:70:0x0100, B:71:0x0123), top: B:96:0x0046, outer: #6, inners: #0, #2, #3, #7 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00c2 A[Catch: all -> 0x0137, TryCatch #5 {, blocks: (B:23:0x0046, B:28:0x0050, B:34:0x005d, B:35:0x0076, B:41:0x0094, B:43:0x0096, B:45:0x009c, B:47:0x00a4, B:48:0x00b3, B:49:0x00b4, B:52:0x00b7, B:53:0x00b8, B:55:0x00bc, B:57:0x00c2, B:62:0x00cf, B:64:0x00d3, B:72:0x0124, B:74:0x0128, B:75:0x012b, B:76:0x012c, B:36:0x0077, B:37:0x0090, B:24:0x0047, B:27:0x004f, B:32:0x005a, B:65:0x00da, B:66:0x00fc, B:70:0x0100, B:71:0x0123), top: B:96:0x0046, outer: #6, inners: #0, #2, #3, #7 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00cd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:64:0x00d3 A[Catch: all -> 0x0137, TRY_LEAVE, TryCatch #5 {, blocks: (B:23:0x0046, B:28:0x0050, B:34:0x005d, B:35:0x0076, B:41:0x0094, B:43:0x0096, B:45:0x009c, B:47:0x00a4, B:48:0x00b3, B:49:0x00b4, B:52:0x00b7, B:53:0x00b8, B:55:0x00bc, B:57:0x00c2, B:62:0x00cf, B:64:0x00d3, B:72:0x0124, B:74:0x0128, B:75:0x012b, B:76:0x012c, B:36:0x0077, B:37:0x0090, B:24:0x0047, B:27:0x004f, B:32:0x005a, B:65:0x00da, B:66:0x00fc, B:70:0x0100, B:71:0x0123), top: B:96:0x0046, outer: #6, inners: #0, #2, #3, #7 }] */
    /* JADX INFO: renamed from: d */
    public static boolean m8731d(String str, String str2, String str3, int i, StrictMode.ThreadPolicy threadPolicy) {
        boolean z2;
        Object obj;
        boolean z3 = false;
        if (!TextUtils.isEmpty(str2) && f19650j.contains(str2)) {
            return false;
        }
        synchronized (SoLoader.class) {
            HashSet<String> hashSet = f19648h;
            if (!hashSet.contains(str)) {
                z2 = false;
            } else {
                if (str3 == null) {
                    return false;
                }
                z2 = true;
            }
            Map<String, Object> map = f19649i;
            if (map.containsKey(str)) {
                obj = map.get(str);
            } else {
                Object obj2 = new Object();
                map.put(str, obj2);
                obj = obj2;
            }
            ReentrantReadWriteLock reentrantReadWriteLock = f19643c;
            reentrantReadWriteLock.readLock().lock();
            try {
                synchronized (obj) {
                    if (z2) {
                        if ((i & 16) == 0) {
                            if (!TextUtils.isEmpty(str2)) {
                                z3 = true;
                            }
                            if (str3 != null) {
                                if (f19641a) {
                                    Api18TraceUtils.m8727a("MergedSoMapping.invokeJniOnload[", str2, "]");
                                }
                                Log.d("SoLoader", "About to merge: " + str2 + " / " + str);
                                C1460d.m466Q0(str2);
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
                            if ((i & 16) == 0) {
                                if (!TextUtils.isEmpty(str2)) {
                                    z3 = true;
                                }
                                if (str3 != null) {
                                    if (f19641a) {
                                        Api18TraceUtils.m8727a("MergedSoMapping.invokeJniOnload[", str2, "]");
                                    }
                                    Log.d("SoLoader", "About to merge: " + str2 + " / " + str);
                                    C1460d.m466Q0(str2);
                                    throw null;
                                }
                            }
                            reentrantReadWriteLock.readLock().unlock();
                            return !z2;
                        }
                        try {
                            Log.d("SoLoader", "About to load: " + str);
                            m8728a(str, i, threadPolicy);
                            synchronized (SoLoader.class) {
                                Log.d("SoLoader", "Loaded: " + str);
                                hashSet.add(str);
                            }
                            if ((i & 16) == 0) {
                                if (!TextUtils.isEmpty(str2) && f19650j.contains(str2)) {
                                    z3 = true;
                                }
                                if (str3 != null && !z3) {
                                    if (f19641a) {
                                        Api18TraceUtils.m8727a("MergedSoMapping.invokeJniOnload[", str2, "]");
                                    }
                                    try {
                                        try {
                                            Log.d("SoLoader", "About to merge: " + str2 + " / " + str);
                                            C1460d.m466Q0(str2);
                                            throw null;
                                        } catch (UnsatisfiedLinkError e) {
                                            throw new RuntimeException("Failed to call JNI_OnLoad from '" + str2 + "', which has been merged into '" + str + "'.  See comment for details.", e);
                                        }
                                    } catch (Throwable th) {
                                        if (f19641a) {
                                            Trace.endSection();
                                        }
                                        throw th;
                                    }
                                }
                            }
                            reentrantReadWriteLock.readLock().unlock();
                            return !z2;
                        } catch (UnsatisfiedLinkError e2) {
                            String message = e2.getMessage();
                            if (message == null || !message.contains("unexpected e_machine:")) {
                                throw e2;
                            }
                            throw new C10675b(e2, message.substring(message.lastIndexOf("unexpected e_machine:")));
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                f19643c.readLock().unlock();
                throw th2;
            }
        }
    }

    public static void init(Context context, int i) throws IOException {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        boolean z2 = false;
        if ((i & 32) == 0 && context != null) {
            try {
                if ((context.getApplicationInfo().flags & Opcodes.LOR) != 0) {
                    z2 = true;
                }
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            }
        }
        f19652l = z2;
        m8729b(null);
        m8730c(context, i);
        C2061a.m1587a(new C2057j());
    }
}
