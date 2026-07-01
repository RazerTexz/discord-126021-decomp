package b.i.c.m.d.k;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.p.CodedOutputStream2;
import com.adjust.sdk.Constants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.c.m.d.k.h, reason: use source file name */
/* JADX INFO: compiled from: CommonUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class CommonUtils {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f1685b = -1;
    public static final Comparator<File> c = new a();

    /* JADX INFO: renamed from: b.i.c.m.d.k.h$a */
    /* JADX INFO: compiled from: CommonUtils.java */
    public class a implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.k.h$b */
    /* JADX INFO: compiled from: CommonUtils.java */
    public enum b {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;

        public static final Map<String, b> t;

        static {
            b bVar = X86_32;
            b bVar2 = ARMV6;
            b bVar3 = ARMV7;
            b bVar4 = ARM64;
            HashMap map = new HashMap(4);
            t = map;
            map.put("armeabi-v7a", bVar3);
            map.put("armeabi", bVar2);
            map.put("arm64-v8a", bVar4);
            map.put("x86", bVar);
        }
    }

    public static long a(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (blockSize * ((long) statFs.getAvailableBlocks()));
    }

    @SuppressLint({"MissingPermission"})
    public static boolean b(Context context) {
        if (!(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static void c(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                if (Logger3.a.a(6)) {
                    Log.e("FirebaseCrashlytics", str, e);
                }
            }
        }
    }

    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static long e(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i);
    }

    public static String f(String... strArr) {
        if (strArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (str != null) {
                    arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
                }
            }
            Collections.sort(arrayList);
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
            }
            String string = sb.toString();
            if (string.length() > 0) {
                return w(string);
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public static String g(File file, String str) throws Throwable {
        ?? Exists = file.exists();
        String str2 = null;
        str2 = null;
        str2 = null;
        ?? r2 = 0;
        try {
            if (Exists != 0) {
                try {
                    Exists = new BufferedReader(new FileReader(file), 1024);
                    while (true) {
                        try {
                            String line = Exists.readLine();
                            if (line == null) {
                                break;
                            }
                            String[] strArrSplit = Pattern.compile("\\s*:\\s*").split(line, 2);
                            if (strArrSplit.length > 1 && strArrSplit[0].equals(str)) {
                                str2 = strArrSplit[1];
                                break;
                            }
                        } catch (Exception e) {
                            e = e;
                            Logger3.a.e("Error parsing " + file, e);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    Exists = 0;
                } catch (Throwable th) {
                    th = th;
                    c(r2, "Failed to close system file reader.");
                    throw th;
                }
                c(Exists, "Failed to close system file reader.");
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
            r2 = Exists;
        }
    }

    public static void h(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                ((CodedOutputStream2) flushable).flush();
            } catch (IOException e) {
                if (Logger3.a.a(6)) {
                    Log.e("FirebaseCrashlytics", str, e);
                }
            }
        }
    }

    public static ActivityManager.RunningAppProcessInfo i(String str, Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static boolean j(Context context, String str, boolean z2) {
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            int iN = n(context, str, "bool");
            if (iN > 0) {
                return resources.getBoolean(iN);
            }
            int iN2 = n(context, str, "string");
            if (iN2 > 0) {
                return Boolean.parseBoolean(context.getString(iN2));
            }
        }
        return z2;
    }

    public static int k(Context context) {
        boolean z2 = true;
        int i = s(context) ? 1 : 0;
        if (u(context)) {
            i |= 2;
        }
        if (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger()) {
            z2 = false;
        }
        return z2 ? i | 4 : i;
    }

    public static String l(Context context) {
        int iN = n(context, "com.google.firebase.crashlytics.mapping_file_id", "string");
        if (iN == 0) {
            iN = n(context, "com.crashlytics.android.build_id", "string");
        }
        if (iN != 0) {
            return context.getResources().getString(iN);
        }
        return null;
    }

    public static boolean m(Context context) {
        return (s(context) || ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) == null) ? false : true;
    }

    public static int n(Context context, String str, String str2) {
        String packageName;
        Resources resources = context.getResources();
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            try {
                packageName = context.getResources().getResourcePackageName(i);
                if ("android".equals(packageName)) {
                    packageName = context.getPackageName();
                }
            } catch (Resources.NotFoundException unused) {
                packageName = context.getPackageName();
            }
        } else {
            packageName = context.getPackageName();
        }
        return resources.getIdentifier(str, str2, packageName);
    }

    public static SharedPreferences o(Context context) {
        return context.getSharedPreferences("com.google.firebase.crashlytics", 0);
    }

    public static synchronized long p() {
        if (f1685b == -1) {
            long jE = 0;
            String strG = g(new File("/proc/meminfo"), "MemTotal");
            if (!TextUtils.isEmpty(strG)) {
                String upperCase = strG.toUpperCase(Locale.US);
                try {
                    if (upperCase.endsWith("KB")) {
                        jE = e(upperCase, "KB", 1024);
                    } else if (upperCase.endsWith("MB")) {
                        jE = e(upperCase, "MB", 1048576);
                    } else if (upperCase.endsWith("GB")) {
                        jE = e(upperCase, "GB", BasicMeasure.EXACTLY);
                    } else {
                        Logger3.a.b("Unexpected meminfo format while computing RAM: " + upperCase);
                    }
                } catch (NumberFormatException e) {
                    Logger3.a.e("Unexpected meminfo format while computing RAM: " + upperCase, e);
                }
            }
            f1685b = jE;
        }
        return f1685b;
    }

    public static String q(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static void r(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean s(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        String str = Build.PRODUCT;
        return "sdk".equals(str) || "google_sdk".equals(str) || string == null;
    }

    public static boolean t(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean u(Context context) {
        boolean zS = s(context);
        String str = Build.TAGS;
        if ((zS || str == null || !str.contains("test-keys")) && !new File("/system/app/Superuser.apk").exists()) {
            return !zS && new File("/system/xbin/su").exists();
        }
        return true;
    }

    public static String v(int i) {
        if (i >= 0) {
            return String.format(Locale.US, "%1$10s", Integer.valueOf(i)).replace(' ', '0');
        }
        throw new IllegalArgumentException("value must be zero or greater");
    }

    public static String w(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
            messageDigest.update(bytes);
            return q(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            Logger3.a.e("Could not create hashing algorithm: " + Constants.SHA1 + ", returning empty string.", e);
            return "";
        }
    }

    public static String x(InputStream inputStream) throws IOException {
        Scanner scannerUseDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : "";
    }
}
