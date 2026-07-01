package b.i.c.m.d.k;

import android.app.ActivityManager;
import android.app.ActivityManager$MemoryInfo;
import android.app.ActivityManager$RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build$VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import b.i.c.m.d.m.f$b;
import b.i.c.m.d.m.i$b;
import b.i.c.m.d.m.v$a;
import b.i.c.m.d.m.v$c$a;
import b.i.c.m.d.m.v$d;
import b.i.c.m.d.m.v$d$d;
import b.i.c.m.d.q.b$a;
import b.i.c.m.d.q.b$b;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class x {
    public static final FilenameFilter a = new x$a("BeginSession");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FilenameFilter f1699b = new x$b();
    public static final Comparator<File> c = new x$c();
    public static final Comparator<File> d = new x$d();
    public static final Pattern e = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    public static final Map<String, String> f = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    public static final String[] g = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    public final d1 A;
    public p0 B;
    public final Context i;
    public final q0 j;
    public final m0 k;
    public final f1 l;
    public final i m;
    public final b.i.c.m.d.n.b n;
    public final v0 o;
    public final b.i.c.m.d.o.h p;
    public final b q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final x$j f1700s;
    public final b.i.c.m.d.l.b t;
    public final b.i.c.m.d.q.a u;
    public final b$a v;
    public final b.i.c.m.d.a w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b.i.c.m.d.t.d f1701x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f1702y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final b.i.c.m.d.i.a f1703z;
    public final AtomicInteger h = new AtomicInteger(0);
    public TaskCompletionSource<Boolean> C = new TaskCompletionSource<>();
    public TaskCompletionSource<Boolean> D = new TaskCompletionSource<>();
    public TaskCompletionSource<Void> E = new TaskCompletionSource<>();
    public AtomicBoolean F = new AtomicBoolean(false);
    public final b$b r = new h0(this);

    public x(Context context, i iVar, b.i.c.m.d.n.b bVar, v0 v0Var, q0 q0Var, b.i.c.m.d.o.h hVar, m0 m0Var, b bVar2, b.i.c.m.d.q.a aVar, b$b b_b, b.i.c.m.d.a aVar2, b.i.c.m.d.i.a aVar3, b.i.c.m.d.s.d dVar) {
        this.i = context;
        this.m = iVar;
        this.n = bVar;
        this.o = v0Var;
        this.j = q0Var;
        this.p = hVar;
        this.k = m0Var;
        this.q = bVar2;
        this.w = aVar2;
        this.f1702y = bVar2.g.a();
        this.f1703z = aVar3;
        f1 f1Var = new f1();
        this.l = f1Var;
        x$j x_j = new x$j(hVar);
        this.f1700s = x_j;
        b.i.c.m.d.l.b bVar3 = new b.i.c.m.d.l.b(context, x_j);
        this.t = bVar3;
        this.u = new b.i.c.m.d.q.a(new x$k(this, null));
        this.v = new x$l(this, null);
        b.i.c.m.d.t.a aVar4 = new b.i.c.m.d.t.a(1024, new b.i.c.m.d.t.c(10));
        this.f1701x = aVar4;
        File file = new File(new File(hVar.a.getFilesDir(), ".com.google.firebase.crashlytics").getPath());
        n0 n0Var = new n0(context, v0Var, bVar2, aVar4);
        b.i.c.m.d.o.g gVar = new b.i.c.m.d.o.g(file, dVar);
        b.i.c.m.d.m.x.h hVar2 = b.i.c.m.d.r.c.a;
        b.i.a.b.j.n.b(context);
        b.i.a.b.g gVarC = b.i.a.b.j.n.a().c(new b.i.a.b.i.a(b.i.c.m.d.r.c.f1746b, b.i.c.m.d.r.c.c));
        b.i.a.b.b bVar4 = new b.i.a.b.b("json");
        b.i.a.b.e<b.i.c.m.d.m.v, byte[]> eVar = b.i.c.m.d.r.c.d;
        this.A = new d1(n0Var, gVar, new b.i.c.m.d.r.c(((b.i.a.b.j.j) gVarC).a("FIREBASE_CRASHLYTICS_REPORT", b.i.c.m.d.m.v.class, bVar4, eVar), eVar), bVar3, f1Var);
    }

    public static void A(b.i.c.m.d.p.c cVar, File file) throws Throwable {
        if (!file.exists()) {
            b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
            StringBuilder sbU = b.d.b.a.a.U("Tried to include a file that doesn't exist: ");
            sbU.append(file.getName());
            bVar.d(sbU.toString());
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                e(fileInputStream2, cVar, (int) file.length());
                h.c(fileInputStream2, "Failed to close file input stream.");
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                h.c(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(x xVar) throws Exception {
        String str;
        String str2;
        Integer num;
        Objects.requireNonNull(xVar);
        long j = j();
        new g(xVar.o);
        String str3 = g.f1684b;
        b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
        b.d.b.a.a.o0("Opening a new session with ID ", str3, bVar);
        xVar.w.h(str3);
        Locale locale = Locale.US;
        String str4 = String.format(locale, "Crashlytics Android SDK/%s", "17.3.0");
        xVar.z(str3, "BeginSession", new u(xVar, str3, str4, j));
        xVar.w.d(str3, str4, j);
        v0 v0Var = xVar.o;
        String str5 = v0Var.e;
        b bVar2 = xVar.q;
        String str6 = bVar2.e;
        String str7 = bVar2.f;
        String strB = v0Var.b();
        int iG = r0.f(xVar.q.c).g();
        xVar.z(str3, "SessionApp", new v(xVar, str5, str6, str7, strB, iG));
        xVar.w.f(str3, str5, str6, str7, strB, iG, xVar.f1702y);
        String str8 = Build$VERSION.RELEASE;
        String str9 = Build$VERSION.CODENAME;
        boolean zU = h.u(xVar.i);
        xVar.z(str3, "SessionOS", new w(xVar, str8, str9, zU));
        xVar.w.g(str3, str8, str9, zU);
        Context context = xVar.i;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        h$b h_b = h$b.UNKNOWN;
        String str10 = Build.CPU_ABI;
        if (TextUtils.isEmpty(str10)) {
            bVar.b("Architecture#getValue()::Build.CPU_ABI returned null or empty");
        } else {
            h$b h_b2 = h$b.t.get(str10.toLowerCase(locale));
            if (h_b2 != null) {
                h_b = h_b2;
            }
        }
        int iOrdinal = h_b.ordinal();
        String str11 = Build.MODEL;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        long jP = h.p();
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean zS = h.s(context);
        int iK = h.k(context);
        String str12 = Build.MANUFACTURER;
        String str13 = Build.PRODUCT;
        xVar.z(str3, "SessionDevice", new y(xVar, iOrdinal, str11, iAvailableProcessors, jP, blockCount, zS, iK, str12, str13));
        xVar.w.c(str3, iOrdinal, str11, iAvailableProcessors, jP, blockCount, zS, iK, str12, str13);
        xVar.t.a(str3);
        d1 d1Var = xVar.A;
        String strT = t(str3);
        n0 n0Var = d1Var.a;
        Objects.requireNonNull(n0Var);
        Charset charset = b.i.c.m.d.m.v.a;
        b.i.c.m.d.m.b$b b_b = new b.i.c.m.d.m.b$b();
        b_b.a = "17.3.0";
        String str14 = n0Var.e.a;
        Objects.requireNonNull(str14, "Null gmpAppId");
        b_b.f1714b = str14;
        String strB2 = n0Var.d.b();
        Objects.requireNonNull(strB2, "Null installationUuid");
        b_b.d = strB2;
        String str15 = n0Var.e.e;
        Objects.requireNonNull(str15, "Null buildVersion");
        b_b.e = str15;
        String str16 = n0Var.e.f;
        Objects.requireNonNull(str16, "Null displayVersion");
        b_b.f = str16;
        b_b.c = 4;
        f$b f_b = new f$b();
        f_b.b(false);
        f_b.c = Long.valueOf(j);
        Objects.requireNonNull(strT, "Null identifier");
        f_b.f1719b = strT;
        String str17 = n0.a;
        Objects.requireNonNull(str17, "Null generator");
        f_b.a = str17;
        String str18 = n0Var.d.e;
        Objects.requireNonNull(str18, "Null identifier");
        String str19 = n0Var.e.e;
        Objects.requireNonNull(str19, "Null version");
        String str20 = n0Var.e.f;
        String strB3 = n0Var.d.b();
        String strA = n0Var.e.g.a();
        if (strA != null) {
            str2 = strA;
            str = "Unity";
        } else {
            str = null;
            str2 = null;
        }
        f_b.f = new b.i.c.m.d.m.g(str18, str19, str20, null, strB3, str, str2, null);
        Integer num2 = 3;
        Objects.requireNonNull(str8, "Null version");
        Objects.requireNonNull(str9, "Null buildVersion");
        Boolean boolValueOf = Boolean.valueOf(h.u(n0Var.c));
        String strW = num2 == null ? " platform" : "";
        if (boolValueOf == null) {
            strW = b.d.b.a.a.w(strW, " jailbroken");
        }
        if (!strW.isEmpty()) {
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
        }
        f_b.h = new b.i.c.m.d.m.t(num2.intValue(), str8, str9, boolValueOf.booleanValue(), null);
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        int iIntValue = 7;
        if (!TextUtils.isEmpty(str10) && (num = n0.f1691b.get(str10.toLowerCase(locale))) != null) {
            iIntValue = num.intValue();
        }
        int iAvailableProcessors2 = Runtime.getRuntime().availableProcessors();
        long jP2 = h.p();
        long blockCount2 = ((long) statFs2.getBlockCount()) * ((long) statFs2.getBlockSize());
        boolean zS2 = h.s(n0Var.c);
        int iK2 = h.k(n0Var.c);
        i$b i_b = new i$b();
        i_b.a = Integer.valueOf(iIntValue);
        Objects.requireNonNull(str11, "Null model");
        i_b.f1722b = str11;
        i_b.c = Integer.valueOf(iAvailableProcessors2);
        i_b.d = Long.valueOf(jP2);
        i_b.e = Long.valueOf(blockCount2);
        i_b.f = Boolean.valueOf(zS2);
        i_b.g = Integer.valueOf(iK2);
        Objects.requireNonNull(str12, "Null manufacturer");
        i_b.h = str12;
        Objects.requireNonNull(str13, "Null modelClass");
        i_b.i = str13;
        f_b.i = i_b.a();
        f_b.k = 3;
        b_b.g = f_b.a();
        b.i.c.m.d.m.v vVarA = b_b.a();
        b.i.c.m.d.o.g gVar = d1Var.f1680b;
        Objects.requireNonNull(gVar);
        v$d v_dH = vVarA.h();
        if (v_dH == null) {
            bVar.b("Could not get session for report");
            return;
        }
        String strG = v_dH.g();
        try {
            File fileH = gVar.h(strG);
            b.i.c.m.d.o.g.i(fileH);
            b.i.c.m.d.o.g.l(new File(fileH, "report"), b.i.c.m.d.o.g.c.g(vVarA));
        } catch (IOException e2) {
            b.i.c.m.d.b.a.c("Could not persist report for session " + strG, e2);
        }
    }

    public static Task b(x xVar) {
        boolean z2;
        Task taskO;
        Objects.requireNonNull(xVar);
        ArrayList arrayList = new ArrayList();
        for (File file : r(xVar.l(), m.a)) {
            try {
                long j = Long.parseLong(file.getName().substring(3));
                try {
                    Class.forName("com.google.firebase.crash.FirebaseCrash");
                    z2 = true;
                } catch (ClassNotFoundException unused) {
                    z2 = false;
                }
                if (z2) {
                    b.i.c.m.d.b.a.b("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
                    taskO = b.i.a.f.e.o.f.Z(null);
                } else {
                    taskO = b.i.a.f.e.o.f.o(new ScheduledThreadPoolExecutor(1), new a0(xVar, j));
                }
                arrayList.add(taskO);
            } catch (NumberFormatException unused2) {
                b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
                StringBuilder sbU = b.d.b.a.a.U("Could not parse timestamp from file ");
                sbU.append(file.getName());
                bVar.b(sbU.toString());
            }
            file.delete();
        }
        return b.i.a.f.e.o.f.B1(arrayList);
    }

    public static void c(@Nullable String str, @NonNull File file) throws Exception {
        FileOutputStream fileOutputStream;
        if (str == null) {
            return;
        }
        b.i.c.m.d.p.c cVarI = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            try {
                cVarI = b.i.c.m.d.p.c.i(fileOutputStream);
                b.i.c.m.d.p.a aVar = b.i.c.m.d.p.d.a;
                b.i.c.m.d.p.a aVarA = b.i.c.m.d.p.a.a(str);
                cVarI.r(7, 2);
                int iB = b.i.c.m.d.p.c.b(2, aVarA);
                cVarI.o(b.i.c.m.d.p.c.d(iB) + b.i.c.m.d.p.c.e(5) + iB);
                cVarI.r(5, 2);
                cVarI.o(iB);
                cVarI.l(2, aVarA);
                StringBuilder sbU = b.d.b.a.a.U("Failed to flush to append to ");
                sbU.append(file.getPath());
                h.h(cVarI, sbU.toString());
                h.c(fileOutputStream, "Failed to close " + file.getPath());
            } catch (Throwable th) {
                th = th;
                StringBuilder sbU2 = b.d.b.a.a.U("Failed to flush to append to ");
                sbU2.append(file.getPath());
                h.h(cVarI, sbU2.toString());
                h.c(fileOutputStream, "Failed to close " + file.getPath());
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static void e(InputStream inputStream, b.i.c.m.d.p.c cVar, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 < 0) {
                break;
            } else {
                i2 += i3;
            }
        }
        Objects.requireNonNull(cVar);
        int i4 = cVar.k;
        int i5 = cVar.l;
        int i6 = i4 - i5;
        if (i6 >= i) {
            System.arraycopy(bArr, 0, cVar.j, i5, i);
            cVar.l += i;
            return;
        }
        System.arraycopy(bArr, 0, cVar.j, i5, i6);
        int i7 = i6 + 0;
        int i8 = i - i6;
        cVar.l = cVar.k;
        cVar.j();
        if (i8 > cVar.k) {
            cVar.m.write(bArr, i7, i8);
        } else {
            System.arraycopy(bArr, i7, cVar.j, 0, i8);
            cVar.l = i8;
        }
    }

    public static long j() {
        return new Date().getTime() / 1000;
    }

    public static String o(File file) {
        return file.getName().substring(0, 35);
    }

    public static File[] r(File file, FilenameFilter filenameFilter) {
        File[] fileArrListFiles = file.listFiles(filenameFilter);
        return fileArrListFiles == null ? new File[0] : fileArrListFiles;
    }

    @NonNull
    public static String t(@NonNull String str) {
        return str.replaceAll("-", "");
    }

    public static void x(b.i.c.m.d.p.c cVar, File[] fileArr, String str) throws Throwable {
        Arrays.sort(fileArr, h.c);
        for (File file : fileArr) {
            try {
                b.i.c.m.d.b.a.b(String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                A(cVar, file);
            } catch (Exception e2) {
                if (b.i.c.m.d.b.a.a(6)) {
                    Log.e("FirebaseCrashlytics", "Error writting non-fatal to session.", e2);
                }
            }
        }
    }

    public final void d(b.i.c.m.d.p.b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            bVar.a();
        } catch (IOException e2) {
            if (b.i.c.m.d.b.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Error closing session file stream in the presence of an exception", e2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(int i, boolean z2) throws Exception {
        FileInputStream fileInputStream;
        f1 f1Var;
        String strJ;
        String str;
        b.i.c.m.d.p.c cVarI;
        b.i.c.m.d.p.b bVar;
        String str2;
        InputStream inputStreamH;
        int i2 = (z2 ? 1 : 0) + 8;
        HashSet hashSet = new HashSet();
        File[] fileArrS = s();
        int iMin = Math.min(i2, fileArrS.length);
        for (int i3 = 0; i3 < iMin; i3++) {
            hashSet.add(o(fileArrS[i3]));
        }
        File[] fileArrListFiles = ((x$j) this.t.c).a().listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                String name = file.getName();
                int iLastIndexOf = name.lastIndexOf(".temp");
                if (iLastIndexOf != -1) {
                    name = name.substring(20, iLastIndexOf);
                }
                if (!hashSet.contains(name)) {
                    file.delete();
                }
            }
        }
        FileInputStream fileInputStream2 = null;
        for (File file2 : r(l(), new x$f(null))) {
            String name2 = file2.getName();
            Matcher matcher = e.matcher(name2);
            if (!matcher.matches()) {
                b.i.c.m.d.b.a.b("Deleting unknown file: " + name2);
                file2.delete();
            } else if (!hashSet.contains(matcher.group(1))) {
                b.i.c.m.d.b.a.b("Trimming session file: " + name2);
                file2.delete();
            }
        }
        File[] fileArrS2 = s();
        if (fileArrS2.length <= z2) {
            b.i.c.m.d.b.a.b("No open sessions to be closed.");
            return;
        }
        String strO = o(fileArrS2[z2 ? 1 : 0]);
        if (p()) {
            f1Var = this.l;
        } else {
            File fileB = new z0(l()).b(strO);
            if (fileB.exists()) {
                try {
                    try {
                        fileInputStream = new FileInputStream(fileB);
                        try {
                            f1Var = z0.c(h.x(fileInputStream));
                            h.c(fileInputStream, "Failed to close user metadata file.");
                        } catch (Exception e2) {
                            e = e2;
                            fileInputStream2 = fileInputStream;
                            if (b.i.c.m.d.b.a.a(6)) {
                                Log.e("FirebaseCrashlytics", "Error deserializing user metadata.", e);
                            }
                            h.c(fileInputStream2, "Failed to close user metadata file.");
                            f1Var = new f1();
                        } catch (Throwable th) {
                            th = th;
                            h.c(fileInputStream, "Failed to close user metadata file.");
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                }
            } else {
                f1Var = new f1();
            }
        }
        z(strO, "SessionUser", new z(this, f1Var));
        String str3 = "report";
        String str4 = "user";
        if (this.w.e(strO)) {
            b.i.c.m.d.b bVar2 = b.i.c.m.d.b.a;
            b.d.b.a.a.o0("Finalizing native report for session ", strO, bVar2);
            b.i.c.m.d.d dVarB = this.w.b(strO);
            File fileD = dVarB.d();
            if (fileD == null || !fileD.exists()) {
                bVar2.g("No minidump data found for session " + strO);
            } else {
                long jLastModified = fileD.lastModified();
                b.i.c.m.d.l.b bVar3 = new b.i.c.m.d.l.b(this.i, this.f1700s, strO);
                File file3 = new File(m(), strO);
                if (file3.mkdirs()) {
                    g(jLastModified);
                    File fileL = l();
                    byte[] bArrC = bVar3.d.c();
                    z0 z0Var = new z0(fileL);
                    File fileB2 = z0Var.b(strO);
                    File fileA = z0Var.a(strO);
                    ArrayList<a1> arrayList = new ArrayList();
                    arrayList.add(new f("logs_file", "logs", bArrC));
                    arrayList.add(new u0("crash_meta_file", "metadata", dVarB.f()));
                    arrayList.add(new u0("session_meta_file", "session", dVarB.e()));
                    arrayList.add(new u0("app_meta_file", "app", dVarB.a()));
                    arrayList.add(new u0("device_meta_file", "device", dVarB.c()));
                    arrayList.add(new u0("os_meta_file", "os", dVarB.b()));
                    arrayList.add(new u0("minidump_file", "minidump", dVarB.d()));
                    arrayList.add(new u0("user_meta_file", "user", fileB2));
                    arrayList.add(new u0("keys_file", "keys", fileA));
                    for (a1 a1Var : arrayList) {
                        try {
                            inputStreamH = a1Var.h();
                            if (inputStreamH != null) {
                                try {
                                    b.i.a.f.e.o.f.t0(inputStreamH, new File(file3, a1Var.a()));
                                } catch (IOException unused) {
                                } catch (Throwable th3) {
                                    th = th3;
                                    h.d(inputStreamH);
                                    throw th;
                                }
                            }
                        } catch (IOException unused2) {
                            inputStreamH = null;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStreamH = null;
                        }
                        h.d(inputStreamH);
                    }
                    d1 d1Var = this.A;
                    String strReplaceAll = strO.replaceAll("-", "");
                    Objects.requireNonNull(d1Var);
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        v$c$a v_c_aB = ((a1) it.next()).b();
                        if (v_c_aB != null) {
                            arrayList2.add(v_c_aB);
                        }
                    }
                    b.i.c.m.d.o.g gVar = d1Var.f1680b;
                    b.i.c.m.d.m.d dVar = new b.i.c.m.d.m.d(new b.i.c.m.d.m.w(arrayList2), null, null);
                    Objects.requireNonNull(gVar);
                    File file4 = new File(gVar.h(strReplaceAll), "report");
                    File file5 = gVar.j;
                    try {
                        b.i.c.m.d.m.x.h hVar = b.i.c.m.d.o.g.c;
                        b.i.c.m.d.m.b$b b_b = (b.i.c.m.d.m.b$b) hVar.f(b.i.c.m.d.o.g.j(file4)).i();
                        b_b.g = null;
                        b_b.h = dVar;
                        b.i.c.m.d.m.v vVarA = b_b.a();
                        b.i.c.m.d.o.g.i(file5);
                        b.i.c.m.d.o.g.l(new File(file5, strReplaceAll), hVar.g(vVarA));
                    } catch (IOException e4) {
                        b.i.c.m.d.b.a.c("Could not synthesize final native report file for " + file4, e4);
                    }
                    bVar3.d.d();
                } else {
                    bVar2.b("Couldn't create native sessions directory");
                }
            }
            if (!this.w.a(strO)) {
                b.d.b.a.a.o0("Could not finalize native session: ", strO, b.i.c.m.d.b.a);
            }
        }
        b.i.c.m.d.b.a.b("Closing open sessions.");
        int i4 = z2 ? 1 : 0;
        while (i4 < fileArrS2.length) {
            File file6 = fileArrS2[i4];
            String strO2 = o(file6);
            b.i.c.m.d.b bVar4 = b.i.c.m.d.b.a;
            bVar4.b("Closing session: " + strO2);
            bVar4.b("Collecting session parts for ID " + strO2);
            File[] fileArrR = r(l(), new x$h(b.d.b.a.a.w(strO2, "SessionCrash")));
            boolean z3 = fileArrR.length > 0;
            Locale locale = Locale.US;
            bVar4.b(String.format(locale, "Session %s has fatal exception: %s", strO2, Boolean.valueOf(z3)));
            File[] fileArrR2 = r(l(), new x$h(b.d.b.a.a.w(strO2, "SessionEvent")));
            boolean z4 = fileArrR2.length > 0;
            String str5 = str3;
            bVar4.b(String.format(locale, "Session %s has non-fatal exceptions: %s", strO2, Boolean.valueOf(z4)));
            if (z3 || z4) {
                if (fileArrR2.length > i) {
                    bVar4.b(String.format(locale, "Trimming down to %d logged exceptions.", Integer.valueOf(i)));
                    v(strO2, i);
                    fileArrR2 = r(l(), new x$h(b.d.b.a.a.w(strO2, "SessionEvent")));
                }
                File file7 = z3 ? fileArrR[0] : null;
                boolean z5 = file7 != null;
                File fileK = z5 ? k() : n();
                if (!fileK.exists()) {
                    fileK.mkdirs();
                }
                try {
                    bVar = new b.i.c.m.d.p.b(fileK, strO2);
                    try {
                        cVarI = b.i.c.m.d.p.c.i(bVar);
                        try {
                            try {
                                bVar4.b("Collecting SessionStart data for session ID " + strO2);
                                A(cVarI, file6);
                                str2 = str4;
                                try {
                                    cVarI.t(4, j());
                                    cVarI.k(5, z5);
                                    cVarI.s(11, 1);
                                    cVarI.m(12, 3);
                                    w(cVarI, strO2);
                                    x(cVarI, fileArrR2, strO2);
                                    if (z5) {
                                        A(cVarI, file7);
                                    }
                                    h.h(cVarI, "Error flushing session file stream");
                                    h.c(bVar, "Failed to close CLS file");
                                } catch (Exception e5) {
                                    e = e5;
                                    b.i.c.m.d.b.a.e("Failed to write session file for session ID: " + strO2, e);
                                    h.h(cVarI, "Error flushing session file stream");
                                    d(bVar);
                                }
                            } catch (Exception e6) {
                                e = e6;
                                str2 = str4;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            h.h(cVarI, "Error flushing session file stream");
                            h.c(bVar, "Failed to close CLS file");
                            throw th;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        str2 = str4;
                        cVarI = null;
                    } catch (Throwable th6) {
                        th = th6;
                        cVarI = null;
                    }
                } catch (Exception e8) {
                    e = e8;
                    str2 = str4;
                    cVarI = null;
                    bVar = null;
                } catch (Throwable th7) {
                    th = th7;
                    cVarI = null;
                    bVar = null;
                }
            } else {
                b.d.b.a.a.o0("No events present for session ID ", strO2, bVar4);
                str2 = str4;
            }
            b.i.c.m.d.b.a.b("Removing session part files for ID " + strO2);
            File[] fileArrR3 = r(l(), new x$n(strO2));
            for (File file8 : fileArrR3) {
                file8.delete();
            }
            i4++;
            str4 = str2;
            str3 = str5;
        }
        String str6 = str3;
        String str7 = str4;
        String strT = z2 != 0 ? t(o(fileArrS2[0])) : null;
        d1 d1Var2 = this.A;
        long j = j();
        b.i.c.m.d.o.g gVar2 = d1Var2.f1680b;
        List<File> listF = b.i.c.m.d.o.g.f(gVar2.g, new b.i.c.m.d.o.b(strT));
        Collections.sort(listF, b.i.c.m.d.o.g.d);
        if (listF.size() > 8) {
            Iterator<File> it2 = listF.subList(8, listF.size()).iterator();
            while (it2.hasNext()) {
                b.i.c.m.d.o.g.k(it2.next());
            }
            listF = listF.subList(0, 8);
        }
        for (File file9 : listF) {
            b.i.c.m.d.b bVar5 = b.i.c.m.d.b.a;
            StringBuilder sbU = b.d.b.a.a.U("Finalizing report for session ");
            sbU.append(file9.getName());
            bVar5.b(sbU.toString());
            List<File> listG = b.i.c.m.d.o.g.g(file9, b.i.c.m.d.o.g.e);
            if (listG.isEmpty()) {
                StringBuilder sbU2 = b.d.b.a.a.U("Session ");
                sbU2.append(file9.getName());
                sbU2.append(" has no events.");
                bVar5.b(sbU2.toString());
            } else {
                Collections.sort(listG);
                ArrayList arrayList3 = new ArrayList();
                Iterator<File> it3 = listG.iterator();
                while (true) {
                    boolean z6 = false;
                    while (true) {
                        if (!it3.hasNext()) {
                            if (!arrayList3.isEmpty()) {
                                File file10 = new File(file9, str7);
                                if (file10.isFile()) {
                                    try {
                                        strJ = b.i.c.m.d.o.g.j(file10);
                                    } catch (IOException e9) {
                                        b.i.c.m.d.b bVar6 = b.i.c.m.d.b.a;
                                        StringBuilder sbU3 = b.d.b.a.a.U("Could not read user ID file in ");
                                        sbU3.append(file9.getName());
                                        bVar6.c(sbU3.toString(), e9);
                                        strJ = null;
                                    }
                                } else {
                                    strJ = null;
                                }
                                str = str6;
                                File file11 = new File(file9, str);
                                File file12 = z6 ? gVar2.h : gVar2.i;
                                try {
                                    b.i.c.m.d.m.x.h hVar2 = b.i.c.m.d.o.g.c;
                                    b.i.c.m.d.m.v vVarJ = hVar2.f(b.i.c.m.d.o.g.j(file11)).j(j, z6, strJ);
                                    b.i.c.m.d.m.w<v$d$d> wVar = new b.i.c.m.d.m.w<>(arrayList3);
                                    if (vVarJ.h() == null) {
                                        throw new IllegalStateException("Reports without sessions cannot have events added to them.");
                                    }
                                    v$a v_aI = vVarJ.i();
                                    f$b f_b = (f$b) vVarJ.h().l();
                                    f_b.j = wVar;
                                    b.i.c.m.d.m.b$b b_b2 = (b.i.c.m.d.m.b$b) v_aI;
                                    b_b2.g = f_b.a();
                                    b.i.c.m.d.m.v vVarA2 = b_b2.a();
                                    v$d v_dH = vVarA2.h();
                                    if (v_dH != null) {
                                        b.i.c.m.d.o.g.i(file12);
                                        b.i.c.m.d.o.g.l(new File(file12, v_dH.g()), hVar2.g(vVarA2));
                                        break;
                                    }
                                    break;
                                } catch (IOException e10) {
                                    b.i.c.m.d.b.a.c("Could not synthesize final report file for " + file11, e10);
                                    break;
                                }
                            }
                            b.i.c.m.d.b bVar7 = b.i.c.m.d.b.a;
                            StringBuilder sbU4 = b.d.b.a.a.U("Could not parse event files for session ");
                            sbU4.append(file9.getName());
                            bVar7.b(sbU4.toString());
                        } else {
                            File next = it3.next();
                            try {
                                b.i.c.m.d.m.x.h hVar3 = b.i.c.m.d.o.g.c;
                                String strJ2 = b.i.c.m.d.o.g.j(next);
                                Objects.requireNonNull(hVar3);
                                try {
                                    JsonReader jsonReader = new JsonReader(new StringReader(strJ2));
                                    try {
                                        v$d$d v_d_dB = b.i.c.m.d.m.x.h.b(jsonReader);
                                        jsonReader.close();
                                        arrayList3.add(v_d_dB);
                                        if (!z6) {
                                            String name3 = next.getName();
                                            if (!(name3.startsWith("event") && name3.endsWith("_"))) {
                                            }
                                        }
                                        z6 = true;
                                    } catch (Throwable th8) {
                                        try {
                                            jsonReader.close();
                                        } catch (Throwable unused3) {
                                        }
                                        throw th8;
                                    }
                                } catch (IllegalStateException e11) {
                                    throw new IOException(e11);
                                }
                            } catch (IOException e12) {
                                b.i.c.m.d.b.a.c("Could not add event to report for " + next, e12);
                            }
                        }
                    }
                }
                b.i.c.m.d.o.g.k(file9);
                str6 = str;
            }
            str = str6;
            b.i.c.m.d.o.g.k(file9);
            str6 = str;
        }
        Objects.requireNonNull(((b.i.c.m.d.s.c) gVar2.k).c().b());
        ArrayList arrayList4 = (ArrayList) gVar2.e();
        int size = arrayList4.size();
        if (size <= 4) {
            return;
        }
        Iterator it4 = arrayList4.subList(4, size).iterator();
        while (it4.hasNext()) {
            ((File) it4.next()).delete();
        }
    }

    public final void g(long j) {
        try {
            new File(l(), ".ae" + j).createNewFile();
        } catch (IOException unused) {
            b.i.c.m.d.b.a.b("Could not write app exception marker.");
        }
    }

    public boolean h(int i) {
        this.m.a();
        if (p()) {
            b.i.c.m.d.b.a.b("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
        bVar.b("Finalizing previously open sessions.");
        try {
            f(i, true);
            bVar.b("Closed all previously open sessions");
            return true;
        } catch (Exception e2) {
            if (b.i.c.m.d.b.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Unable to finalize previously open sessions.", e2);
            }
            return false;
        }
    }

    @Nullable
    public final String i() {
        File[] fileArrS = s();
        if (fileArrS.length > 0) {
            return o(fileArrS[0]);
        }
        return null;
    }

    public File k() {
        return new File(l(), "fatal-sessions");
    }

    public File l() {
        return this.p.a();
    }

    public File m() {
        return new File(l(), "native-sessions");
    }

    public File n() {
        return new File(l(), "nonfatal-sessions");
    }

    public boolean p() {
        p0 p0Var = this.B;
        return p0Var != null && p0Var.d.get();
    }

    public File[] q() {
        LinkedList linkedList = new LinkedList();
        File fileK = k();
        FilenameFilter filenameFilter = f1699b;
        File[] fileArrListFiles = fileK.listFiles(filenameFilter);
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        Collections.addAll(linkedList, fileArrListFiles);
        File[] fileArrListFiles2 = n().listFiles(filenameFilter);
        if (fileArrListFiles2 == null) {
            fileArrListFiles2 = new File[0];
        }
        Collections.addAll(linkedList, fileArrListFiles2);
        Collections.addAll(linkedList, r(l(), filenameFilter));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    public final File[] s() {
        File[] fileArrR = r(l(), a);
        Arrays.sort(fileArrR, c);
        return fileArrR;
    }

    public Task<Void> u(float f2, Task<b.i.c.m.d.s.h.b> task) {
        b.i.a.f.n.c0<Void> c0Var;
        Task taskZ;
        b.i.c.m.d.q.a aVar = this.u;
        File[] fileArrQ = ((x$k) aVar.a).a.q();
        File[] fileArrListFiles = ((x$k) aVar.a).a.m().listFiles();
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        if (!((fileArrQ != null && fileArrQ.length > 0) || fileArrListFiles.length > 0)) {
            b.i.c.m.d.b.a.b("No reports are available.");
            this.C.b(Boolean.FALSE);
            return b.i.a.f.e.o.f.Z(null);
        }
        b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
        bVar.b("Unsent reports are available.");
        if (this.j.b()) {
            bVar.b("Automatic data collection is enabled. Allowing upload.");
            this.C.b(Boolean.FALSE);
            taskZ = b.i.a.f.e.o.f.Z(Boolean.TRUE);
        } else {
            bVar.b("Automatic data collection is disabled.");
            bVar.b("Notifying that unsent reports are available.");
            this.C.b(Boolean.TRUE);
            q0 q0Var = this.j;
            synchronized (q0Var.c) {
                c0Var = q0Var.d.a;
            }
            Task<TContinuationResult> taskQ = c0Var.q(new e0(this));
            bVar.b("Waiting for send/deleteUnsentReports to be called.");
            b.i.a.f.n.c0<Boolean> c0Var2 = this.D.a;
            FilenameFilter filenameFilter = h1.a;
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            i1 i1Var = new i1(taskCompletionSource);
            taskQ.h(i1Var);
            c0Var2.h(i1Var);
            taskZ = taskCompletionSource.a;
        }
        return taskZ.q(new x$e(this, task, f2));
    }

    public final void v(String str, int i) {
        h1.b(l(), new x$h(b.d.b.a.a.w(str, "SessionEvent")), i, d);
    }

    public final void w(b.i.c.m.d.p.c cVar, String str) throws Throwable {
        for (String str2 : g) {
            File[] fileArrR = r(l(), new x$h(b.d.b.a.a.y(str, str2, ".cls")));
            if (fileArrR.length == 0) {
                b.i.c.m.d.b.a.b("Can't find " + str2 + " data for session ID " + str);
            } else {
                b.i.c.m.d.b.a.b("Collecting " + str2 + " data for session ID " + str);
                A(cVar, fileArrR[0]);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:22:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:24:0x0100  */
    /* JADX WARN: Code duplicated, block: B:25:0x0112  */
    /* JADX WARN: Code duplicated, block: B:28:0x0198  */
    /* JADX WARN: Code duplicated, block: B:31:0x01f0 A[LOOP:1: B:30:0x01ee->B:31:0x01f0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x023a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0253  */
    /* JADX WARN: Code duplicated, block: B:43:0x0286  */
    /* JADX WARN: Code duplicated, block: B:47:0x0295  */
    /* JADX WARN: Code duplicated, block: B:49:0x029b  */
    /* JADX WARN: Code duplicated, block: B:53:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:56:0x0306  */
    /* JADX WARN: Code duplicated, block: B:63:0x0288 A[SYNTHETIC] */
    public final void y(b.i.c.m.d.p.c cVar, Thread thread, Throwable th, long j, String str, boolean z2) throws Exception {
        Thread[] threadArr;
        Map<String, String> mapA;
        Map<String, String> treeMap;
        byte[] bArrC;
        b.i.c.m.d.p.a aVarA;
        b.i.c.m.d.p.a aVar;
        b.i.c.m.d.p.a aVar2;
        Thread[] threadArr2;
        int iD;
        int length;
        int i;
        b.i.c.m.d.p.a aVar3;
        String value;
        b.i.c.m.d.t.e eVar = new b.i.c.m.d.t.e(th, this.f1701x);
        Context context = this.i;
        e eVarA = e.a(context);
        Float f2 = eVarA.a;
        int iB = eVarA.b();
        boolean zM = h.m(context);
        int i2 = context.getResources().getConfiguration().orientation;
        long jP = h.p();
        ActivityManager$MemoryInfo activityManager$MemoryInfo = new ActivityManager$MemoryInfo();
        ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(activityManager$MemoryInfo);
        long j2 = jP - activityManager$MemoryInfo.availMem;
        long jA = h.a(Environment.getDataDirectory().getPath());
        ActivityManager$RunningAppProcessInfo activityManager$RunningAppProcessInfoI = h.i(context.getPackageName(), context);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = eVar.c;
        String str2 = this.q.f1677b;
        String str3 = this.o.e;
        if (z2) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr3 = new Thread[allStackTraces.size()];
            int i3 = 0;
            for (Map$Entry<Thread, StackTraceElement[]> map$Entry : allStackTraces.entrySet()) {
                threadArr3[i3] = map$Entry.getKey();
                linkedList.add(this.f1701x.a(map$Entry.getValue()));
                i3++;
                threadArr3 = threadArr3;
            }
            threadArr = threadArr3;
        } else {
            threadArr = new Thread[0];
        }
        if (h.j(context, "com.crashlytics.CollectCustomKeys", true)) {
            mapA = this.l.a();
            if (mapA != null && mapA.size() > 1) {
                treeMap = new TreeMap(mapA);
            }
            bArrC = this.t.d.c();
            b.i.c.m.d.p.a aVar4 = b.i.c.m.d.p.d.a;
            b.i.c.m.d.p.a aVarA2 = b.i.c.m.d.p.a.a(str3);
            if (str2 == null) {
                aVarA = null;
            } else {
                aVarA = b.i.c.m.d.p.a.a(str2.replace("-", ""));
            }
            if (bArrC != null) {
                int length2 = bArrC.length;
                byte[] bArr = new byte[length2];
                System.arraycopy(bArrC, 0, bArr, 0, length2);
                aVar = new b.i.c.m.d.p.a(bArr);
            } else {
                b.i.c.m.d.b.a.b("No log data to include with this event.");
                aVar = null;
            }
            cVar.r(10, 2);
            int iB2 = b.i.c.m.d.p.c.b(2, b.i.c.m.d.p.a.a(str)) + b.i.c.m.d.p.c.h(1, j) + 0;
            aVar2 = aVar;
            threadArr2 = threadArr;
            int iF = b.i.c.m.d.p.d.f(eVar, thread, stackTraceElementArr, threadArr, linkedList, 8, aVarA2, aVarA, treeMap, activityManager$RunningAppProcessInfoI, i2);
            int iD2 = b.i.c.m.d.p.c.d(iF) + b.i.c.m.d.p.c.e(3) + iF + iB2;
            int iG = b.i.c.m.d.p.d.g(f2, iB, zM, i2, j2, jA);
            iD = b.i.c.m.d.p.c.d(iG) + b.i.c.m.d.p.c.e(5) + iG + iD2;
            if (aVar2 != null) {
                int iB3 = b.i.c.m.d.p.c.b(1, aVar2);
                iD += b.i.c.m.d.p.c.d(iB3) + b.i.c.m.d.p.c.e(6) + iB3;
            }
            cVar.o(iD);
            cVar.t(1, j);
            cVar.l(2, b.i.c.m.d.p.a.a(str));
            cVar.r(3, 2);
            b.i.c.m.d.p.a aVar5 = aVarA;
            cVar.o(b.i.c.m.d.p.d.f(eVar, thread, stackTraceElementArr, threadArr2, linkedList, 8, aVarA2, aVar5, treeMap, activityManager$RunningAppProcessInfoI, i2));
            cVar.r(1, 2);
            cVar.o(b.i.c.m.d.p.d.e(eVar, thread, stackTraceElementArr, threadArr2, linkedList, 8, aVarA2, aVar5));
            b.i.c.m.d.p.d.m(cVar, thread, stackTraceElementArr, 4, true);
            length = threadArr2.length;
            for (i = 0; i < length; i++) {
                b.i.c.m.d.p.d.m(cVar, threadArr2[i], (StackTraceElement[]) linkedList.get(i), 0, false);
            }
            b.i.c.m.d.p.d.l(cVar, eVar, 1, 8, 2);
            cVar.r(3, 2);
            cVar.o(b.i.c.m.d.p.d.d());
            b.i.c.m.d.p.a aVar6 = b.i.c.m.d.p.d.a;
            cVar.l(1, aVar6);
            cVar.l(2, aVar6);
            cVar.t(3, 0L);
            cVar.r(4, 2);
            aVar3 = aVarA;
            cVar.o(b.i.c.m.d.p.d.a(aVarA2, aVar3));
            cVar.t(1, 0L);
            cVar.t(2, 0L);
            cVar.l(3, aVarA2);
            if (aVar3 != null) {
                cVar.l(4, aVar3);
            }
            if (treeMap != null && !treeMap.isEmpty()) {
                for (Map$Entry<String, String> map$Entry2 : treeMap.entrySet()) {
                    cVar.r(2, 2);
                    cVar.o(b.i.c.m.d.p.d.b(map$Entry2.getKey(), map$Entry2.getValue()));
                    cVar.l(1, b.i.c.m.d.p.a.a(map$Entry2.getKey()));
                    value = map$Entry2.getValue();
                    if (value == null) {
                        value = "";
                    }
                    cVar.l(2, b.i.c.m.d.p.a.a(value));
                }
            }
            if (activityManager$RunningAppProcessInfoI != null) {
                cVar.k(3, activityManager$RunningAppProcessInfoI.importance != 100);
            }
            cVar.s(4, i2);
            cVar.r(5, 2);
            cVar.o(b.i.c.m.d.p.d.g(f2, iB, zM, i2, j2, jA));
            if (f2 != null) {
                float fFloatValue = f2.floatValue();
                cVar.o(13);
                int iFloatToRawIntBits = Float.floatToRawIntBits(fFloatValue);
                cVar.n(iFloatToRawIntBits & 255);
                cVar.n((iFloatToRawIntBits >> 8) & 255);
                cVar.n((iFloatToRawIntBits >> 16) & 255);
                cVar.n((iFloatToRawIntBits >> 24) & 255);
            }
            cVar.o(16);
            cVar.o((iB << 1) ^ (iB >> 31));
            cVar.k(3, zM);
            cVar.s(4, i2);
            cVar.t(5, j2);
            cVar.t(6, jA);
            if (aVar2 != null) {
                cVar.r(6, 2);
                cVar.o(b.i.c.m.d.p.c.b(1, aVar2));
                cVar.l(1, aVar2);
            }
            this.t.d.d();
        }
        mapA = new TreeMap<>();
        treeMap = mapA;
        bArrC = this.t.d.c();
        b.i.c.m.d.p.a aVar7 = b.i.c.m.d.p.d.a;
        b.i.c.m.d.p.a aVarA3 = b.i.c.m.d.p.a.a(str3);
        if (str2 == null) {
            aVarA = null;
        } else {
            aVarA = b.i.c.m.d.p.a.a(str2.replace("-", ""));
        }
        if (bArrC != null) {
            int length3 = bArrC.length;
            byte[] bArr2 = new byte[length3];
            System.arraycopy(bArrC, 0, bArr2, 0, length3);
            aVar = new b.i.c.m.d.p.a(bArr2);
        } else {
            b.i.c.m.d.b.a.b("No log data to include with this event.");
            aVar = null;
        }
        cVar.r(10, 2);
        int iB4 = b.i.c.m.d.p.c.b(2, b.i.c.m.d.p.a.a(str)) + b.i.c.m.d.p.c.h(1, j) + 0;
        aVar2 = aVar;
        threadArr2 = threadArr;
        int iF2 = b.i.c.m.d.p.d.f(eVar, thread, stackTraceElementArr, threadArr, linkedList, 8, aVarA3, aVarA, treeMap, activityManager$RunningAppProcessInfoI, i2);
        int iD3 = b.i.c.m.d.p.c.d(iF2) + b.i.c.m.d.p.c.e(3) + iF2 + iB4;
        int iG2 = b.i.c.m.d.p.d.g(f2, iB, zM, i2, j2, jA);
        iD = b.i.c.m.d.p.c.d(iG2) + b.i.c.m.d.p.c.e(5) + iG2 + iD3;
        if (aVar2 != null) {
            int iB5 = b.i.c.m.d.p.c.b(1, aVar2);
            iD += b.i.c.m.d.p.c.d(iB5) + b.i.c.m.d.p.c.e(6) + iB5;
        }
        cVar.o(iD);
        cVar.t(1, j);
        cVar.l(2, b.i.c.m.d.p.a.a(str));
        cVar.r(3, 2);
        b.i.c.m.d.p.a aVar8 = aVarA;
        cVar.o(b.i.c.m.d.p.d.f(eVar, thread, stackTraceElementArr, threadArr2, linkedList, 8, aVarA3, aVar8, treeMap, activityManager$RunningAppProcessInfoI, i2));
        cVar.r(1, 2);
        cVar.o(b.i.c.m.d.p.d.e(eVar, thread, stackTraceElementArr, threadArr2, linkedList, 8, aVarA3, aVar8));
        b.i.c.m.d.p.d.m(cVar, thread, stackTraceElementArr, 4, true);
        length = threadArr2.length;
        while (i < length) {
            b.i.c.m.d.p.d.m(cVar, threadArr2[i], (StackTraceElement[]) linkedList.get(i), 0, false);
        }
        b.i.c.m.d.p.d.l(cVar, eVar, 1, 8, 2);
        cVar.r(3, 2);
        cVar.o(b.i.c.m.d.p.d.d());
        b.i.c.m.d.p.a aVar9 = b.i.c.m.d.p.d.a;
        cVar.l(1, aVar9);
        cVar.l(2, aVar9);
        cVar.t(3, 0L);
        cVar.r(4, 2);
        aVar3 = aVarA;
        cVar.o(b.i.c.m.d.p.d.a(aVarA3, aVar3));
        cVar.t(1, 0L);
        cVar.t(2, 0L);
        cVar.l(3, aVarA3);
        if (aVar3 != null) {
            cVar.l(4, aVar3);
        }
        if (treeMap != null) {
            while (r3.hasNext()) {
                cVar.r(2, 2);
                cVar.o(b.i.c.m.d.p.d.b(map$Entry2.getKey(), map$Entry2.getValue()));
                cVar.l(1, b.i.c.m.d.p.a.a(map$Entry2.getKey()));
                value = map$Entry2.getValue();
                if (value == null) {
                    value = "";
                }
                cVar.l(2, b.i.c.m.d.p.a.a(value));
            }
        }
        if (activityManager$RunningAppProcessInfoI != null) {
            cVar.k(3, activityManager$RunningAppProcessInfoI.importance != 100);
        }
        cVar.s(4, i2);
        cVar.r(5, 2);
        cVar.o(b.i.c.m.d.p.d.g(f2, iB, zM, i2, j2, jA));
        if (f2 != null) {
            float fFloatValue2 = f2.floatValue();
            cVar.o(13);
            int iFloatToRawIntBits2 = Float.floatToRawIntBits(fFloatValue2);
            cVar.n(iFloatToRawIntBits2 & 255);
            cVar.n((iFloatToRawIntBits2 >> 8) & 255);
            cVar.n((iFloatToRawIntBits2 >> 16) & 255);
            cVar.n((iFloatToRawIntBits2 >> 24) & 255);
        }
        cVar.o(16);
        cVar.o((iB << 1) ^ (iB >> 31));
        cVar.k(3, zM);
        cVar.s(4, i2);
        cVar.t(5, j2);
        cVar.t(6, jA);
        if (aVar2 != null) {
            cVar.r(6, 2);
            cVar.o(b.i.c.m.d.p.c.b(1, aVar2));
            cVar.l(1, aVar2);
        }
        this.t.d.d();
    }

    public final void z(String str, String str2, x$g x_g) throws Exception {
        Throwable th;
        b.i.c.m.d.p.b bVar;
        b.i.c.m.d.p.c cVar = null;
        try {
            bVar = new b.i.c.m.d.p.b(l(), str + str2);
            try {
                b.i.c.m.d.p.c cVarI = b.i.c.m.d.p.c.i(bVar);
                try {
                    x_g.a(cVarI);
                    h.h(cVarI, "Failed to flush to session " + str2 + " file.");
                    h.c(bVar, "Failed to close session " + str2 + " file.");
                } catch (Throwable th2) {
                    th = th2;
                    cVar = cVarI;
                    h.h(cVar, "Failed to flush to session " + str2 + " file.");
                    h.c(bVar, "Failed to close session " + str2 + " file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            bVar = null;
        }
    }
}
