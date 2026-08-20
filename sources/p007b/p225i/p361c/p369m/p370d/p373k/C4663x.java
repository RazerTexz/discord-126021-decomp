package p007b.p225i.p361c.p369m.p370d.p373k;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.FileFilter;
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
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p228b.C2407b;
import p007b.p225i.p226a.p228b.InterfaceC2410e;
import p007b.p225i.p226a.p228b.InterfaceC2412g;
import p007b.p225i.p226a.p228b.p229i.C2414a;
import p007b.p225i.p226a.p228b.p231j.C2443j;
import p007b.p225i.p226a.p228b.p231j.C2447n;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.C4358c0;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4362f;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.InterfaceC4591a;
import p007b.p225i.p361c.p369m.p370d.InterfaceC4594d;
import p007b.p225i.p361c.p369m.p370d.p371i.InterfaceC4599a;
import p007b.p225i.p361c.p369m.p370d.p374l.C4670b;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;
import p007b.p225i.p361c.p369m.p370d.p375m.C4675b;
import p007b.p225i.p361c.p369m.p370d.p375m.C4677d;
import p007b.p225i.p361c.p369m.p370d.p375m.C4679f;
import p007b.p225i.p361c.p369m.p370d.p375m.C4680g;
import p007b.p225i.p361c.p369m.p370d.p375m.C4682i;
import p007b.p225i.p361c.p369m.p370d.p375m.C4693t;
import p007b.p225i.p361c.p369m.p370d.p375m.C4696w;
import p007b.p225i.p361c.p369m.p370d.p375m.p376x.C4704h;
import p007b.p225i.p361c.p369m.p370d.p377n.C4706b;
import p007b.p225i.p361c.p369m.p370d.p378o.C4714g;
import p007b.p225i.p361c.p369m.p370d.p378o.C4715h;
import p007b.p225i.p361c.p369m.p370d.p379p.C4716a;
import p007b.p225i.p361c.p369m.p370d.p379p.C4717b;
import p007b.p225i.p361c.p369m.p370d.p379p.C4718c;
import p007b.p225i.p361c.p369m.p370d.p379p.C4719d;
import p007b.p225i.p361c.p369m.p370d.p380q.C4720a;
import p007b.p225i.p361c.p369m.p370d.p380q.C4721b;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c;
import p007b.p225i.p361c.p369m.p370d.p383r.C4732c;
import p007b.p225i.p361c.p369m.p370d.p384s.C4735c;
import p007b.p225i.p361c.p369m.p370d.p384s.InterfaceC4736d;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4741b;
import p007b.p225i.p361c.p369m.p370d.p387t.C4752a;
import p007b.p225i.p361c.p369m.p370d.p387t.C4754c;
import p007b.p225i.p361c.p369m.p370d.p387t.C4756e;
import p007b.p225i.p361c.p369m.p370d.p387t.InterfaceC4755d;

/* JADX INFO: renamed from: b.i.c.m.d.k.x */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4663x {

    /* JADX INFO: renamed from: a */
    public static final FilenameFilter f12415a = new a("BeginSession");

    /* JADX INFO: renamed from: b */
    public static final FilenameFilter f12416b = new b();

    /* JADX INFO: renamed from: c */
    public static final Comparator<File> f12417c = new c();

    /* JADX INFO: renamed from: d */
    public static final Comparator<File> f12418d = new d();

    /* JADX INFO: renamed from: e */
    public static final Pattern f12419e = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");

    /* JADX INFO: renamed from: f */
    public static final Map<String, String> f12420f = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");

    /* JADX INFO: renamed from: g */
    public static final String[] f12421g = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};

    /* JADX INFO: renamed from: A */
    public final C4618d1 f12422A;

    /* JADX INFO: renamed from: B */
    public C4648p0 f12423B;

    /* JADX INFO: renamed from: i */
    public final Context f12429i;

    /* JADX INFO: renamed from: j */
    public final C4650q0 f12430j;

    /* JADX INFO: renamed from: k */
    public final C4642m0 f12431k;

    /* JADX INFO: renamed from: l */
    public final C4624f1 f12432l;

    /* JADX INFO: renamed from: m */
    public final C4631i f12433m;

    /* JADX INFO: renamed from: n */
    public final C4706b f12434n;

    /* JADX INFO: renamed from: o */
    public final C4660v0 f12435o;

    /* JADX INFO: renamed from: p */
    public final C4715h f12436p;

    /* JADX INFO: renamed from: q */
    public final C4610b f12437q;

    /* JADX INFO: renamed from: s */
    public final j f12439s;

    /* JADX INFO: renamed from: t */
    public final C4670b f12440t;

    /* JADX INFO: renamed from: u */
    public final C4720a f12441u;

    /* JADX INFO: renamed from: v */
    public final C4721b.a f12442v;

    /* JADX INFO: renamed from: w */
    public final InterfaceC4591a f12443w;

    /* JADX INFO: renamed from: x */
    public final InterfaceC4755d f12444x;

    /* JADX INFO: renamed from: y */
    public final String f12445y;

    /* JADX INFO: renamed from: z */
    public final InterfaceC4599a f12446z;

    /* JADX INFO: renamed from: h */
    public final AtomicInteger f12428h = new AtomicInteger(0);

    /* JADX INFO: renamed from: C */
    public TaskCompletionSource<Boolean> f12424C = new TaskCompletionSource<>();

    /* JADX INFO: renamed from: D */
    public TaskCompletionSource<Boolean> f12425D = new TaskCompletionSource<>();

    /* JADX INFO: renamed from: E */
    public TaskCompletionSource<Void> f12426E = new TaskCompletionSource<>();

    /* JADX INFO: renamed from: F */
    public AtomicBoolean f12427F = new AtomicBoolean(false);

    /* JADX INFO: renamed from: r */
    public final C4721b.b f12438r = new C4629h0(this);

    /* JADX INFO: renamed from: b.i.c.m.d.k.x$a */
    /* JADX INFO: compiled from: CrashlyticsController.java */
    public class a extends h {
        public a(String str) {
            super(str);
        }

        @Override // p007b.p225i.p361c.p369m.p370d.p373k.C4663x.h, java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return super.accept(file, str) && str.endsWith(".cls");
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.k.x$b */
    /* JADX INFO: compiled from: CrashlyticsController.java */
    public class b implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.length() == 39 && str.endsWith(".cls");
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.k.x$c */
    /* JADX INFO: compiled from: CrashlyticsController.java */
    public class c implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.k.x$d */
    /* JADX INFO: compiled from: CrashlyticsController.java */
    public class d implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.k.x$e */
    /* JADX INFO: compiled from: CrashlyticsController.java */
    public class e implements InterfaceC4362f<Boolean, Void> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Task f12447a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ float f12448b;

        public e(Task task, float f) {
            this.f12447a = task;
            this.f12448b = f;
        }

        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4362f
        @NonNull
        /* JADX INFO: renamed from: a */
        public Task<Void> mo4013a(@Nullable Boolean bool) throws Exception {
            return C4663x.this.f12433m.m6438c(new CallableC4626g0(this, bool));
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.k.x$f */
    /* JADX INFO: compiled from: CrashlyticsController.java */
    public static class f implements FilenameFilter {
        public f(a aVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !((b) C4663x.f12416b).accept(file, str) && C4663x.f12419e.matcher(str).matches();
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.k.x$g */
    /* JADX INFO: compiled from: CrashlyticsController.java */
    public interface g {
        /* JADX INFO: renamed from: a */
        void mo6454a(C4718c c4718c) throws Exception;
    }

    /* JADX INFO: renamed from: b.i.c.m.d.k.x$h */
    /* JADX INFO: compiled from: CrashlyticsController.java */
    public static class h implements FilenameFilter {

        /* JADX INFO: renamed from: a */
        public final String f12450a;

        public h(String str) {
            this.f12450a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.f12450a) && !str.endsWith(".cls_temp");
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.k.x$i */
    /* JADX INFO: compiled from: CrashlyticsController.java */
    public static class i implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return ((C4717b.a) C4717b.f12686j).accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.k.x$j */
    /* JADX INFO: compiled from: CrashlyticsController.java */
    public static final class j implements C4670b.b {

        /* JADX INFO: renamed from: a */
        public final C4715h f12451a;

        public j(C4715h c4715h) {
            this.f12451a = c4715h;
        }

        /* JADX INFO: renamed from: a */
        public File m6487a() {
            File file = new File(this.f12451a.m6636a(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.k.x$k */
    /* JADX INFO: compiled from: CrashlyticsController.java */
    public final class k implements C4721b.c {
        public k(a aVar) {
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.k.x$l */
    /* JADX INFO: compiled from: CrashlyticsController.java */
    public final class l implements C4721b.a {
        public l(a aVar) {
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.k.x$m */
    /* JADX INFO: compiled from: CrashlyticsController.java */
    public static final class m implements Runnable {

        /* JADX INFO: renamed from: j */
        public final Context f12454j;

        /* JADX INFO: renamed from: k */
        public final InterfaceC4724c f12455k;

        /* JADX INFO: renamed from: l */
        public final C4721b f12456l;

        /* JADX INFO: renamed from: m */
        public final boolean f12457m;

        public m(Context context, InterfaceC4724c interfaceC4724c, C4721b c4721b, boolean z2) {
            this.f12454j = context;
            this.f12455k = interfaceC4724c;
            this.f12456l = c4721b;
            this.f12457m = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C4628h.m6408b(this.f12454j)) {
                C4592b.f12227a.m6371b("Attempting to send crash report at time of crash...");
                this.f12456l.m6670a(this.f12455k, this.f12457m);
            }
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.k.x$n */
    /* JADX INFO: compiled from: CrashlyticsController.java */
    public static class n implements FilenameFilter {

        /* JADX INFO: renamed from: a */
        public final String f12458a;

        public n(String str) {
            this.f12458a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f12458a);
            sb.append(".cls");
            return (str.equals(sb.toString()) || !str.contains(this.f12458a) || str.endsWith(".cls_temp")) ? false : true;
        }
    }

    public C4663x(Context context, C4631i c4631i, C4706b c4706b, C4660v0 c4660v0, C4650q0 c4650q0, C4715h c4715h, C4642m0 c4642m0, C4610b c4610b, C4720a c4720a, C4721b.b bVar, InterfaceC4591a interfaceC4591a, InterfaceC4599a interfaceC4599a, InterfaceC4736d interfaceC4736d) {
        this.f12429i = context;
        this.f12433m = c4631i;
        this.f12434n = c4706b;
        this.f12435o = c4660v0;
        this.f12430j = c4650q0;
        this.f12436p = c4715h;
        this.f12431k = c4642m0;
        this.f12437q = c4610b;
        this.f12443w = interfaceC4591a;
        this.f12445y = c4610b.f12265g.m6697a();
        this.f12446z = interfaceC4599a;
        C4624f1 c4624f1 = new C4624f1();
        this.f12432l = c4624f1;
        j jVar = new j(c4715h);
        this.f12439s = jVar;
        C4670b c4670b = new C4670b(context, jVar);
        this.f12440t = c4670b;
        this.f12441u = new C4720a(new k(null));
        this.f12442v = new l(null);
        C4752a c4752a = new C4752a(1024, new C4754c(10));
        this.f12444x = c4752a;
        File file = new File(new File(c4715h.f12683a.getFilesDir(), ".com.google.firebase.crashlytics").getPath());
        C4644n0 c4644n0 = new C4644n0(context, c4660v0, c4610b, c4752a);
        C4714g c4714g = new C4714g(file, interfaceC4736d);
        C4704h c4704h = C4732c.f12723a;
        C2447n.m2360b(context);
        InterfaceC2412g interfaceC2412gM2361c = C2447n.m2359a().m2361c(new C2414a(C4732c.f12724b, C4732c.f12725c));
        C2407b c2407b = new C2407b("json");
        InterfaceC2410e<AbstractC4695v, byte[]> interfaceC2410e = C4732c.f12726d;
        this.f12422A = new C4618d1(c4644n0, c4714g, new C4732c(((C2443j) interfaceC2412gM2361c).mo2291a("FIREBASE_CRASHLYTICS_REPORT", AbstractC4695v.class, c2407b, interfaceC2410e), interfaceC2410e), c4670b, c4624f1);
    }

    /* JADX INFO: renamed from: A */
    public static void m6460A(C4718c c4718c, File file) throws Throwable {
        if (!file.exists()) {
            C4592b c4592b = C4592b.f12227a;
            StringBuilder sbM833U = C1643a.m833U("Tried to include a file that doesn't exist: ");
            sbM833U.append(file.getName());
            c4592b.m6373d(sbM833U.toString());
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                m6464e(fileInputStream2, c4718c, (int) file.length());
                C4628h.m6409c(fileInputStream2, "Failed to close file input stream.");
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                C4628h.m6409c(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m6461a(C4663x c4663x) throws Exception {
        String str;
        String str2;
        Integer num;
        Objects.requireNonNull(c4663x);
        long jM6465j = m6465j();
        new C4625g(c4663x.f12435o);
        String str3 = C4625g.f12293b;
        C4592b c4592b = C4592b.f12227a;
        C1643a.m868o0("Opening a new session with ID ", str3, c4592b);
        c4663x.f12443w.mo6369h(str3);
        Locale locale = Locale.US;
        String str4 = String.format(locale, "Crashlytics Android SDK/%s", "17.3.0");
        c4663x.m6486z(str3, "BeginSession", new C4657u(c4663x, str3, str4, jM6465j));
        c4663x.f12443w.mo6365d(str3, str4, jM6465j);
        C4660v0 c4660v0 = c4663x.f12435o;
        String str5 = c4660v0.f12411e;
        C4610b c4610b = c4663x.f12437q;
        String str6 = c4610b.f12263e;
        String str7 = c4610b.f12264f;
        String strM6456b = c4660v0.m6456b();
        int iM6453g = EnumC4652r0.m6452f(c4663x.f12437q.f12261c).m6453g();
        c4663x.m6486z(str3, "SessionApp", new C4659v(c4663x, str5, str6, str7, strM6456b, iM6453g));
        c4663x.f12443w.mo6367f(str3, str5, str6, str7, strM6456b, iM6453g, c4663x.f12445y);
        String str8 = Build.VERSION.RELEASE;
        String str9 = Build.VERSION.CODENAME;
        boolean zM6427u = C4628h.m6427u(c4663x.f12429i);
        c4663x.m6486z(str3, "SessionOS", new C4661w(c4663x, str8, str9, zM6427u));
        c4663x.f12443w.mo6368g(str3, str8, str9, zM6427u);
        Context context = c4663x.f12429i;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        C4628h.b bVar = C4628h.b.UNKNOWN;
        String str10 = Build.CPU_ABI;
        if (TextUtils.isEmpty(str10)) {
            c4592b.m6371b("Architecture#getValue()::Build.CPU_ABI returned null or empty");
        } else {
            C4628h.b bVar2 = C4628h.b.f12310t.get(str10.toLowerCase(locale));
            if (bVar2 != null) {
                bVar = bVar2;
            }
        }
        int iOrdinal = bVar.ordinal();
        String str11 = Build.MODEL;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        long jM6422p = C4628h.m6422p();
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean zM6425s = C4628h.m6425s(context);
        int iM6417k = C4628h.m6417k(context);
        String str12 = Build.MANUFACTURER;
        String str13 = Build.PRODUCT;
        c4663x.m6486z(str3, "SessionDevice", new C4665y(c4663x, iOrdinal, str11, iAvailableProcessors, jM6422p, blockCount, zM6425s, iM6417k, str12, str13));
        c4663x.f12443w.mo6364c(str3, iOrdinal, str11, iAvailableProcessors, jM6422p, blockCount, zM6425s, iM6417k, str12, str13);
        c4663x.f12440t.m6496a(str3);
        C4618d1 c4618d1 = c4663x.f12422A;
        String strM6468t = m6468t(str3);
        C4644n0 c4644n0 = c4618d1.f12278a;
        Objects.requireNonNull(c4644n0);
        Charset charset = AbstractC4695v.f12647a;
        C4675b.b bVar3 = new C4675b.b();
        bVar3.f12526a = "17.3.0";
        String str14 = c4644n0.f12357e.f12259a;
        Objects.requireNonNull(str14, "Null gmpAppId");
        bVar3.f12527b = str14;
        String strM6456b2 = c4644n0.f12356d.m6456b();
        Objects.requireNonNull(strM6456b2, "Null installationUuid");
        bVar3.f12529d = strM6456b2;
        String str15 = c4644n0.f12357e.f12263e;
        Objects.requireNonNull(str15, "Null buildVersion");
        bVar3.f12530e = str15;
        String str16 = c4644n0.f12357e.f12264f;
        Objects.requireNonNull(str16, "Null displayVersion");
        bVar3.f12531f = str16;
        bVar3.f12528c = 4;
        C4679f.b bVar4 = new C4679f.b();
        bVar4.m6544b(false);
        bVar4.f12553c = Long.valueOf(jM6465j);
        Objects.requireNonNull(strM6468t, "Null identifier");
        bVar4.f12552b = strM6468t;
        String str17 = C4644n0.f12353a;
        Objects.requireNonNull(str17, "Null generator");
        bVar4.f12551a = str17;
        String str18 = c4644n0.f12356d.f12411e;
        Objects.requireNonNull(str18, "Null identifier");
        String str19 = c4644n0.f12357e.f12263e;
        Objects.requireNonNull(str19, "Null version");
        String str20 = c4644n0.f12357e.f12264f;
        String strM6456b3 = c4644n0.f12356d.m6456b();
        String strM6697a = c4644n0.f12357e.f12265g.m6697a();
        if (strM6697a != null) {
            str2 = strM6697a;
            str = "Unity";
        } else {
            str = null;
            str2 = null;
        }
        bVar4.f12556f = new C4680g(str18, str19, str20, null, strM6456b3, str, str2, null);
        Integer num2 = 3;
        Objects.requireNonNull(str8, "Null version");
        Objects.requireNonNull(str9, "Null buildVersion");
        Boolean boolValueOf = Boolean.valueOf(C4628h.m6427u(c4644n0.f12355c));
        String strM883w = num2 == null ? " platform" : "";
        if (boolValueOf == null) {
            strM883w = C1643a.m883w(strM883w, " jailbroken");
        }
        if (!strM883w.isEmpty()) {
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
        }
        bVar4.f12558h = new C4693t(num2.intValue(), str8, str9, boolValueOf.booleanValue(), null);
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        int iIntValue = 7;
        if (!TextUtils.isEmpty(str10) && (num = C4644n0.f12354b.get(str10.toLowerCase(locale))) != null) {
            iIntValue = num.intValue();
        }
        int iAvailableProcessors2 = Runtime.getRuntime().availableProcessors();
        long jM6422p2 = C4628h.m6422p();
        long blockCount2 = ((long) statFs2.getBlockCount()) * ((long) statFs2.getBlockSize());
        boolean zM6425s2 = C4628h.m6425s(c4644n0.f12355c);
        int iM6417k2 = C4628h.m6417k(c4644n0.f12355c);
        C4682i.b bVar5 = new C4682i.b();
        bVar5.f12578a = Integer.valueOf(iIntValue);
        Objects.requireNonNull(str11, "Null model");
        bVar5.f12579b = str11;
        bVar5.f12580c = Integer.valueOf(iAvailableProcessors2);
        bVar5.f12581d = Long.valueOf(jM6422p2);
        bVar5.f12582e = Long.valueOf(blockCount2);
        bVar5.f12583f = Boolean.valueOf(zM6425s2);
        bVar5.f12584g = Integer.valueOf(iM6417k2);
        Objects.requireNonNull(str12, "Null manufacturer");
        bVar5.f12585h = str12;
        Objects.requireNonNull(str13, "Null modelClass");
        bVar5.f12586i = str13;
        bVar4.f12559i = bVar5.m6562a();
        bVar4.f12561k = 3;
        bVar3.f12532g = bVar4.mo6543a();
        AbstractC4695v abstractC4695vMo6524a = bVar3.mo6524a();
        C4714g c4714g = c4618d1.f12279b;
        Objects.requireNonNull(c4714g);
        AbstractC4695v.d dVarMo6522h = abstractC4695vMo6524a.mo6522h();
        if (dVarMo6522h == null) {
            c4592b.m6371b("Could not get session for report");
            return;
        }
        String strMo6537g = dVarMo6522h.mo6537g();
        try {
            File fileM6635h = c4714g.m6635h(strMo6537g);
            C4714g.m6628i(fileM6635h);
            C4714g.m6631l(new File(fileM6635h, "report"), C4714g.f12674c.m6620g(abstractC4695vMo6524a));
        } catch (IOException e2) {
            C4592b.f12227a.m6372c("Could not persist report for session " + strMo6537g, e2);
        }
    }

    /* JADX INFO: renamed from: b */
    public static Task m6462b(C4663x c4663x) {
        boolean z2;
        Task taskM4323o;
        Objects.requireNonNull(c4663x);
        ArrayList arrayList = new ArrayList();
        for (File file : m6467r(c4663x.m6476l(), C4641m.f12347a)) {
            try {
                long j2 = Long.parseLong(file.getName().substring(3));
                try {
                    Class.forName("com.google.firebase.crash.FirebaseCrash");
                    z2 = true;
                } catch (ClassNotFoundException unused) {
                    z2 = false;
                }
                if (z2) {
                    C4592b.f12227a.m6371b("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
                    taskM4323o = C3404f.m4264Z(null);
                } else {
                    taskM4323o = C3404f.m4323o(new ScheduledThreadPoolExecutor(1), new CallableC4608a0(c4663x, j2));
                }
                arrayList.add(taskM4323o);
            } catch (NumberFormatException unused2) {
                C4592b c4592b = C4592b.f12227a;
                StringBuilder sbM833U = C1643a.m833U("Could not parse timestamp from file ");
                sbM833U.append(file.getName());
                c4592b.m6371b(sbM833U.toString());
            }
            file.delete();
        }
        return C3404f.m4194B1(arrayList);
    }

    /* JADX INFO: renamed from: c */
    public static void m6463c(@Nullable String str, @NonNull File file) throws Exception {
        FileOutputStream fileOutputStream;
        if (str == null) {
            return;
        }
        C4718c c4718cM6646i = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            try {
                c4718cM6646i = C4718c.m6646i(fileOutputStream);
                C4716a c4716a = C4719d.f12694a;
                C4716a c4716aM6637a = C4716a.m6637a(str);
                c4718cM6646i.m6654r(7, 2);
                int iM6640b = C4718c.m6640b(2, c4716aM6637a);
                c4718cM6646i.m6652o(C4718c.m6642d(iM6640b) + C4718c.m6643e(5) + iM6640b);
                c4718cM6646i.m6654r(5, 2);
                c4718cM6646i.m6652o(iM6640b);
                c4718cM6646i.m6649l(2, c4716aM6637a);
                StringBuilder sbM833U = C1643a.m833U("Failed to flush to append to ");
                sbM833U.append(file.getPath());
                C4628h.m6414h(c4718cM6646i, sbM833U.toString());
                C4628h.m6409c(fileOutputStream, "Failed to close " + file.getPath());
            } catch (Throwable th) {
                th = th;
                StringBuilder sbM833U2 = C1643a.m833U("Failed to flush to append to ");
                sbM833U2.append(file.getPath());
                C4628h.m6414h(c4718cM6646i, sbM833U2.toString());
                C4628h.m6409c(fileOutputStream, "Failed to close " + file.getPath());
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m6464e(InputStream inputStream, C4718c c4718c, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i3, i2 - i3);
            if (i4 < 0) {
                break;
            } else {
                i3 += i4;
            }
        }
        Objects.requireNonNull(c4718c);
        int i5 = c4718c.f12691k;
        int i6 = c4718c.f12692l;
        int i7 = i5 - i6;
        if (i7 >= i2) {
            System.arraycopy(bArr, 0, c4718c.f12690j, i6, i2);
            c4718c.f12692l += i2;
            return;
        }
        System.arraycopy(bArr, 0, c4718c.f12690j, i6, i7);
        int i8 = i7 + 0;
        int i9 = i2 - i7;
        c4718c.f12692l = c4718c.f12691k;
        c4718c.m6647j();
        if (i9 > c4718c.f12691k) {
            c4718c.f12693m.write(bArr, i8, i9);
        } else {
            System.arraycopy(bArr, i8, c4718c.f12690j, 0, i9);
            c4718c.f12692l = i9;
        }
    }

    /* JADX INFO: renamed from: j */
    public static long m6465j() {
        return new Date().getTime() / 1000;
    }

    /* JADX INFO: renamed from: o */
    public static String m6466o(File file) {
        return file.getName().substring(0, 35);
    }

    /* JADX INFO: renamed from: r */
    public static File[] m6467r(File file, FilenameFilter filenameFilter) {
        File[] fileArrListFiles = file.listFiles(filenameFilter);
        return fileArrListFiles == null ? new File[0] : fileArrListFiles;
    }

    @NonNull
    /* JADX INFO: renamed from: t */
    public static String m6468t(@NonNull String str) {
        return str.replaceAll("-", "");
    }

    /* JADX INFO: renamed from: x */
    public static void m6469x(C4718c c4718c, File[] fileArr, String str) throws Throwable {
        Arrays.sort(fileArr, C4628h.f12299c);
        for (File file : fileArr) {
            try {
                C4592b.f12227a.m6371b(String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                m6460A(c4718c, file);
            } catch (Exception e2) {
                if (C4592b.f12227a.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", "Error writting non-fatal to session.", e2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m6470d(C4717b c4717b) {
        if (c4717b == null) {
            return;
        }
        try {
            c4717b.m6638a();
        } catch (IOException e2) {
            if (C4592b.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "Error closing session file stream in the presence of an exception", e2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: f */
    public final void m6471f(int i2, boolean z2) throws Exception {
        FileInputStream fileInputStream;
        C4624f1 c4624f1;
        String strM6629j;
        String str;
        C4718c c4718cM6646i;
        C4717b c4717b;
        String str2;
        InputStream inputStreamMo6394h;
        int i3 = (z2 ? 1 : 0) + 8;
        HashSet hashSet = new HashSet();
        File[] fileArrM6481s = m6481s();
        int iMin = Math.min(i3, fileArrM6481s.length);
        for (int i4 = 0; i4 < iMin; i4++) {
            hashSet.add(m6466o(fileArrM6481s[i4]));
        }
        File[] fileArrListFiles = ((j) this.f12440t.f12472c).m6487a().listFiles();
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
        for (File file2 : m6467r(m6476l(), new f(null))) {
            String name2 = file2.getName();
            Matcher matcher = f12419e.matcher(name2);
            if (!matcher.matches()) {
                C4592b.f12227a.m6371b("Deleting unknown file: " + name2);
                file2.delete();
            } else if (!hashSet.contains(matcher.group(1))) {
                C4592b.f12227a.m6371b("Trimming session file: " + name2);
                file2.delete();
            }
        }
        File[] fileArrM6481s2 = m6481s();
        if (fileArrM6481s2.length <= z2) {
            C4592b.f12227a.m6371b("No open sessions to be closed.");
            return;
        }
        String strM6466o = m6466o(fileArrM6481s2[z2 ? 1 : 0]);
        if (m6479p()) {
            c4624f1 = this.f12432l;
        } else {
            File fileM6490b = new C4668z0(m6476l()).m6490b(strM6466o);
            if (fileM6490b.exists()) {
                try {
                    try {
                        fileInputStream = new FileInputStream(fileM6490b);
                        try {
                            c4624f1 = C4668z0.m6488c(C4628h.m6430x(fileInputStream));
                            C4628h.m6409c(fileInputStream, "Failed to close user metadata file.");
                        } catch (Exception e2) {
                            e = e2;
                            fileInputStream2 = fileInputStream;
                            if (C4592b.f12227a.m6370a(6)) {
                                Log.e("FirebaseCrashlytics", "Error deserializing user metadata.", e);
                            }
                            C4628h.m6409c(fileInputStream2, "Failed to close user metadata file.");
                            c4624f1 = new C4624f1();
                        } catch (Throwable th) {
                            th = th;
                            C4628h.m6409c(fileInputStream, "Failed to close user metadata file.");
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
                c4624f1 = new C4624f1();
            }
        }
        m6486z(strM6466o, "SessionUser", new C4667z(this, c4624f1));
        String str3 = "report";
        String str4 = "user";
        if (this.f12443w.mo6366e(strM6466o)) {
            C4592b c4592b = C4592b.f12227a;
            C1643a.m868o0("Finalizing native report for session ", strM6466o, c4592b);
            InterfaceC4594d interfaceC4594dMo6363b = this.f12443w.mo6363b(strM6466o);
            File fileMo6380d = interfaceC4594dMo6363b.mo6380d();
            if (fileMo6380d == null || !fileMo6380d.exists()) {
                c4592b.m6376g("No minidump data found for session " + strM6466o);
            } else {
                long jLastModified = fileMo6380d.lastModified();
                C4670b c4670b = new C4670b(this.f12429i, this.f12439s, strM6466o);
                File file3 = new File(m6477m(), strM6466o);
                if (file3.mkdirs()) {
                    m6472g(jLastModified);
                    File fileM6476l = m6476l();
                    byte[] bArrMo6493c = c4670b.f12473d.mo6493c();
                    C4668z0 c4668z0 = new C4668z0(fileM6476l);
                    File fileM6490b2 = c4668z0.m6490b(strM6466o);
                    File fileM6489a = c4668z0.m6489a(strM6466o);
                    ArrayList<InterfaceC4609a1> arrayList = new ArrayList();
                    arrayList.add(new C4622f("logs_file", "logs", bArrMo6493c));
                    arrayList.add(new C4658u0("crash_meta_file", "metadata", interfaceC4594dMo6363b.mo6382f()));
                    arrayList.add(new C4658u0("session_meta_file", "session", interfaceC4594dMo6363b.mo6381e()));
                    arrayList.add(new C4658u0("app_meta_file", "app", interfaceC4594dMo6363b.mo6377a()));
                    arrayList.add(new C4658u0("device_meta_file", "device", interfaceC4594dMo6363b.mo6379c()));
                    arrayList.add(new C4658u0("os_meta_file", "os", interfaceC4594dMo6363b.mo6378b()));
                    arrayList.add(new C4658u0("minidump_file", "minidump", interfaceC4594dMo6363b.mo6380d()));
                    arrayList.add(new C4658u0("user_meta_file", "user", fileM6490b2));
                    arrayList.add(new C4658u0("keys_file", "keys", fileM6489a));
                    for (InterfaceC4609a1 interfaceC4609a1 : arrayList) {
                        try {
                            inputStreamMo6394h = interfaceC4609a1.mo6394h();
                            if (inputStreamMo6394h != null) {
                                try {
                                    C3404f.m4344t0(inputStreamMo6394h, new File(file3, interfaceC4609a1.mo6392a()));
                                } catch (IOException unused) {
                                } catch (Throwable th3) {
                                    th = th3;
                                    C4628h.m6410d(inputStreamMo6394h);
                                    throw th;
                                }
                            }
                        } catch (IOException unused2) {
                            inputStreamMo6394h = null;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStreamMo6394h = null;
                        }
                        C4628h.m6410d(inputStreamMo6394h);
                    }
                    C4618d1 c4618d1 = this.f12422A;
                    String strReplaceAll = strM6466o.replaceAll("-", "");
                    Objects.requireNonNull(c4618d1);
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        AbstractC4695v.c.a aVarMo6393b = ((InterfaceC4609a1) it.next()).mo6393b();
                        if (aVarMo6393b != null) {
                            arrayList2.add(aVarMo6393b);
                        }
                    }
                    C4714g c4714g = c4618d1.f12279b;
                    C4677d c4677d = new C4677d(new C4696w(arrayList2), null, null);
                    Objects.requireNonNull(c4714g);
                    File file4 = new File(c4714g.m6635h(strReplaceAll), "report");
                    File file5 = c4714g.f12681j;
                    try {
                        C4704h c4704h = C4714g.f12674c;
                        C4675b.b bVar = (C4675b.b) c4704h.m6619f(C4714g.m6629j(file4)).mo6523i();
                        bVar.f12532g = null;
                        bVar.f12533h = c4677d;
                        AbstractC4695v abstractC4695vMo6524a = bVar.mo6524a();
                        C4714g.m6628i(file5);
                        C4714g.m6631l(new File(file5, strReplaceAll), c4704h.m6620g(abstractC4695vMo6524a));
                    } catch (IOException e4) {
                        C4592b.f12227a.m6372c("Could not synthesize final native report file for " + file4, e4);
                    }
                    c4670b.f12473d.mo6494d();
                } else {
                    c4592b.m6371b("Couldn't create native sessions directory");
                }
            }
            if (!this.f12443w.mo6362a(strM6466o)) {
                C1643a.m868o0("Could not finalize native session: ", strM6466o, C4592b.f12227a);
            }
        }
        C4592b.f12227a.m6371b("Closing open sessions.");
        int i5 = z2 ? 1 : 0;
        while (i5 < fileArrM6481s2.length) {
            File file6 = fileArrM6481s2[i5];
            String strM6466o2 = m6466o(file6);
            C4592b c4592b2 = C4592b.f12227a;
            c4592b2.m6371b("Closing session: " + strM6466o2);
            c4592b2.m6371b("Collecting session parts for ID " + strM6466o2);
            File[] fileArrM6467r = m6467r(m6476l(), new h(C1643a.m883w(strM6466o2, "SessionCrash")));
            boolean z3 = fileArrM6467r.length > 0;
            Locale locale = Locale.US;
            c4592b2.m6371b(String.format(locale, "Session %s has fatal exception: %s", strM6466o2, Boolean.valueOf(z3)));
            File[] fileArrM6467r2 = m6467r(m6476l(), new h(C1643a.m883w(strM6466o2, "SessionEvent")));
            boolean z4 = fileArrM6467r2.length > 0;
            String str5 = str3;
            c4592b2.m6371b(String.format(locale, "Session %s has non-fatal exceptions: %s", strM6466o2, Boolean.valueOf(z4)));
            if (z3 || z4) {
                if (fileArrM6467r2.length > i2) {
                    c4592b2.m6371b(String.format(locale, "Trimming down to %d logged exceptions.", Integer.valueOf(i2)));
                    m6483v(strM6466o2, i2);
                    fileArrM6467r2 = m6467r(m6476l(), new h(C1643a.m883w(strM6466o2, "SessionEvent")));
                }
                File file7 = z3 ? fileArrM6467r[0] : null;
                boolean z5 = file7 != null;
                File fileM6475k = z5 ? m6475k() : m6478n();
                if (!fileM6475k.exists()) {
                    fileM6475k.mkdirs();
                }
                try {
                    c4717b = new C4717b(fileM6475k, strM6466o2);
                    try {
                        c4718cM6646i = C4718c.m6646i(c4717b);
                        try {
                            try {
                                c4592b2.m6371b("Collecting SessionStart data for session ID " + strM6466o2);
                                m6460A(c4718cM6646i, file6);
                                str2 = str4;
                                try {
                                    c4718cM6646i.m6656t(4, m6465j());
                                    c4718cM6646i.m6648k(5, z5);
                                    c4718cM6646i.m6655s(11, 1);
                                    c4718cM6646i.m6650m(12, 3);
                                    m6484w(c4718cM6646i, strM6466o2);
                                    m6469x(c4718cM6646i, fileArrM6467r2, strM6466o2);
                                    if (z5) {
                                        m6460A(c4718cM6646i, file7);
                                    }
                                    C4628h.m6414h(c4718cM6646i, "Error flushing session file stream");
                                    C4628h.m6409c(c4717b, "Failed to close CLS file");
                                } catch (Exception e5) {
                                    e = e5;
                                    C4592b.f12227a.m6374e("Failed to write session file for session ID: " + strM6466o2, e);
                                    C4628h.m6414h(c4718cM6646i, "Error flushing session file stream");
                                    m6470d(c4717b);
                                }
                            } catch (Exception e6) {
                                e = e6;
                                str2 = str4;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            C4628h.m6414h(c4718cM6646i, "Error flushing session file stream");
                            C4628h.m6409c(c4717b, "Failed to close CLS file");
                            throw th;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        str2 = str4;
                        c4718cM6646i = null;
                    } catch (Throwable th6) {
                        th = th6;
                        c4718cM6646i = null;
                    }
                } catch (Exception e8) {
                    e = e8;
                    str2 = str4;
                    c4718cM6646i = null;
                    c4717b = null;
                } catch (Throwable th7) {
                    th = th7;
                    c4718cM6646i = null;
                    c4717b = null;
                }
            } else {
                C1643a.m868o0("No events present for session ID ", strM6466o2, c4592b2);
                str2 = str4;
            }
            C4592b.f12227a.m6371b("Removing session part files for ID " + strM6466o2);
            File[] fileArrM6467r3 = m6467r(m6476l(), new n(strM6466o2));
            for (File file8 : fileArrM6467r3) {
                file8.delete();
            }
            i5++;
            str4 = str2;
            str3 = str5;
        }
        String str6 = str3;
        String str7 = str4;
        final String strM6468t = z2 != 0 ? m6468t(m6466o(fileArrM6481s2[0])) : null;
        C4618d1 c4618d2 = this.f12422A;
        long jM6465j = m6465j();
        C4714g c4714g2 = c4618d2.f12279b;
        List<File> listM6626f = C4714g.m6626f(c4714g2.f12678g, new FileFilter(strM6468t) { // from class: b.i.c.m.d.o.b

            /* JADX INFO: renamed from: a */
            public final String f12667a;

            {
                this.f12667a = strM6468t;
            }

            @Override // java.io.FileFilter
            public boolean accept(File file9) {
                String str8 = this.f12667a;
                Charset charset = C4714g.f12672a;
                return file9.isDirectory() && !file9.getName().equals(str8);
            }
        });
        Collections.sort(listM6626f, C4714g.f12675d);
        if (listM6626f.size() > 8) {
            Iterator<File> it2 = listM6626f.subList(8, listM6626f.size()).iterator();
            while (it2.hasNext()) {
                C4714g.m6630k(it2.next());
            }
            listM6626f = listM6626f.subList(0, 8);
        }
        for (File file9 : listM6626f) {
            C4592b c4592b3 = C4592b.f12227a;
            StringBuilder sbM833U = C1643a.m833U("Finalizing report for session ");
            sbM833U.append(file9.getName());
            c4592b3.m6371b(sbM833U.toString());
            List<File> listM6627g = C4714g.m6627g(file9, C4714g.f12676e);
            if (listM6627g.isEmpty()) {
                StringBuilder sbM833U2 = C1643a.m833U("Session ");
                sbM833U2.append(file9.getName());
                sbM833U2.append(" has no events.");
                c4592b3.m6371b(sbM833U2.toString());
            } else {
                Collections.sort(listM6627g);
                ArrayList arrayList3 = new ArrayList();
                Iterator<File> it3 = listM6627g.iterator();
                while (true) {
                    boolean z6 = false;
                    while (true) {
                        if (!it3.hasNext()) {
                            if (!arrayList3.isEmpty()) {
                                File file10 = new File(file9, str7);
                                if (file10.isFile()) {
                                    try {
                                        strM6629j = C4714g.m6629j(file10);
                                    } catch (IOException e9) {
                                        C4592b c4592b4 = C4592b.f12227a;
                                        StringBuilder sbM833U3 = C1643a.m833U("Could not read user ID file in ");
                                        sbM833U3.append(file9.getName());
                                        c4592b4.m6372c(sbM833U3.toString(), e9);
                                        strM6629j = null;
                                    }
                                } else {
                                    strM6629j = null;
                                }
                                str = str6;
                                File file11 = new File(file9, str);
                                File file12 = z6 ? c4714g2.f12679h : c4714g2.f12680i;
                                try {
                                    C4704h c4704h2 = C4714g.f12674c;
                                    AbstractC4695v abstractC4695vM6612j = c4704h2.m6619f(C4714g.m6629j(file11)).m6612j(jM6465j, z6, strM6629j);
                                    C4696w<AbstractC4695v.d.AbstractC13233d> c4696w = new C4696w<>(arrayList3);
                                    if (abstractC4695vM6612j.mo6522h() == null) {
                                        throw new IllegalStateException("Reports without sessions cannot have events added to them.");
                                    }
                                    AbstractC4695v.a aVarMo6523i = abstractC4695vM6612j.mo6523i();
                                    C4679f.b bVar2 = (C4679f.b) abstractC4695vM6612j.mo6522h().mo6542l();
                                    bVar2.f12560j = c4696w;
                                    C4675b.b bVar3 = (C4675b.b) aVarMo6523i;
                                    bVar3.f12532g = bVar2.mo6543a();
                                    AbstractC4695v abstractC4695vMo6524a2 = bVar3.mo6524a();
                                    AbstractC4695v.d dVarMo6522h = abstractC4695vMo6524a2.mo6522h();
                                    if (dVarMo6522h != null) {
                                        C4714g.m6628i(file12);
                                        C4714g.m6631l(new File(file12, dVarMo6522h.mo6537g()), c4704h2.m6620g(abstractC4695vMo6524a2));
                                        break;
                                    }
                                    break;
                                } catch (IOException e10) {
                                    C4592b.f12227a.m6372c("Could not synthesize final report file for " + file11, e10);
                                    break;
                                }
                            }
                            C4592b c4592b5 = C4592b.f12227a;
                            StringBuilder sbM833U4 = C1643a.m833U("Could not parse event files for session ");
                            sbM833U4.append(file9.getName());
                            c4592b5.m6371b(sbM833U4.toString());
                        } else {
                            File next = it3.next();
                            try {
                                C4704h c4704h3 = C4714g.f12674c;
                                String strM6629j2 = C4714g.m6629j(next);
                                Objects.requireNonNull(c4704h3);
                                try {
                                    JsonReader jsonReader = new JsonReader(new StringReader(strM6629j2));
                                    try {
                                        AbstractC4695v.d.AbstractC13233d abstractC13233dM6615b = C4704h.m6615b(jsonReader);
                                        jsonReader.close();
                                        arrayList3.add(abstractC13233dM6615b);
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
                                C4592b.f12227a.m6372c("Could not add event to report for " + next, e12);
                            }
                        }
                    }
                }
                C4714g.m6630k(file9);
                str6 = str;
            }
            str = str6;
            C4714g.m6630k(file9);
            str6 = str;
        }
        Objects.requireNonNull(((C4735c) c4714g2.f12682k).m6685c().mo6690b());
        ArrayList arrayList4 = (ArrayList) c4714g2.m6634e();
        int size = arrayList4.size();
        if (size <= 4) {
            return;
        }
        Iterator it4 = arrayList4.subList(4, size).iterator();
        while (it4.hasNext()) {
            ((File) it4.next()).delete();
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m6472g(long j2) {
        try {
            new File(m6476l(), ".ae" + j2).createNewFile();
        } catch (IOException unused) {
            C4592b.f12227a.m6371b("Could not write app exception marker.");
        }
    }

    /* JADX INFO: renamed from: h */
    public boolean m6473h(int i2) {
        this.f12433m.m6436a();
        if (m6479p()) {
            C4592b.f12227a.m6371b("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        C4592b c4592b = C4592b.f12227a;
        c4592b.m6371b("Finalizing previously open sessions.");
        try {
            m6471f(i2, true);
            c4592b.m6371b("Closed all previously open sessions");
            return true;
        } catch (Exception e2) {
            if (C4592b.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "Unable to finalize previously open sessions.", e2);
            }
            return false;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: i */
    public final String m6474i() {
        File[] fileArrM6481s = m6481s();
        if (fileArrM6481s.length > 0) {
            return m6466o(fileArrM6481s[0]);
        }
        return null;
    }

    /* JADX INFO: renamed from: k */
    public File m6475k() {
        return new File(m6476l(), "fatal-sessions");
    }

    /* JADX INFO: renamed from: l */
    public File m6476l() {
        return this.f12436p.m6636a();
    }

    /* JADX INFO: renamed from: m */
    public File m6477m() {
        return new File(m6476l(), "native-sessions");
    }

    /* JADX INFO: renamed from: n */
    public File m6478n() {
        return new File(m6476l(), "nonfatal-sessions");
    }

    /* JADX INFO: renamed from: p */
    public boolean m6479p() {
        C4648p0 c4648p0 = this.f12423B;
        return c4648p0 != null && c4648p0.f12368d.get();
    }

    /* JADX INFO: renamed from: q */
    public File[] m6480q() {
        LinkedList linkedList = new LinkedList();
        File fileM6475k = m6475k();
        FilenameFilter filenameFilter = f12416b;
        File[] fileArrListFiles = fileM6475k.listFiles(filenameFilter);
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        Collections.addAll(linkedList, fileArrListFiles);
        File[] fileArrListFiles2 = m6478n().listFiles(filenameFilter);
        if (fileArrListFiles2 == null) {
            fileArrListFiles2 = new File[0];
        }
        Collections.addAll(linkedList, fileArrListFiles2);
        Collections.addAll(linkedList, m6467r(m6476l(), filenameFilter));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    /* JADX INFO: renamed from: s */
    public final File[] m6481s() {
        File[] fileArrM6467r = m6467r(m6476l(), f12415a);
        Arrays.sort(fileArrM6467r, f12417c);
        return fileArrM6467r;
    }

    /* JADX INFO: renamed from: u */
    public Task<Void> m6482u(float f2, Task<C4741b> task) {
        C4358c0<Void> c4358c0;
        Task taskM4264Z;
        C4720a c4720a = this.f12441u;
        File[] fileArrM6480q = C4663x.this.m6480q();
        File[] fileArrListFiles = C4663x.this.m6477m().listFiles();
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        if (!((fileArrM6480q != null && fileArrM6480q.length > 0) || fileArrListFiles.length > 0)) {
            C4592b.f12227a.m6371b("No reports are available.");
            this.f12424C.m9126b(Boolean.FALSE);
            return C3404f.m4264Z(null);
        }
        C4592b c4592b = C4592b.f12227a;
        c4592b.m6371b("Unsent reports are available.");
        if (this.f12430j.m6450b()) {
            c4592b.m6371b("Automatic data collection is enabled. Allowing upload.");
            this.f12424C.m9126b(Boolean.FALSE);
            taskM4264Z = C3404f.m4264Z(Boolean.TRUE);
        } else {
            c4592b.m6371b("Automatic data collection is disabled.");
            c4592b.m6371b("Notifying that unsent reports are available.");
            this.f12424C.m9126b(Boolean.TRUE);
            C4650q0 c4650q0 = this.f12430j;
            synchronized (c4650q0.f12373c) {
                c4358c0 = c4650q0.f12374d.f20845a;
            }
            Task<TContinuationResult> taskMo6022q = c4358c0.mo6022q(new C4620e0(this));
            c4592b.m6371b("Waiting for send/deleteUnsentReports to be called.");
            C4358c0<Boolean> c4358c1 = this.f12425D.f20845a;
            FilenameFilter filenameFilter = C4630h1.f12313a;
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            C4633i1 c4633i1 = new C4633i1(taskCompletionSource);
            taskMo6022q.mo6013h(c4633i1);
            c4358c1.mo6013h(c4633i1);
            taskM4264Z = taskCompletionSource.f20845a;
        }
        return taskM4264Z.mo6022q(new e(task, f2));
    }

    /* JADX INFO: renamed from: v */
    public final void m6483v(String str, int i2) {
        C4630h1.m6433b(m6476l(), new h(C1643a.m883w(str, "SessionEvent")), i2, f12418d);
    }

    /* JADX INFO: renamed from: w */
    public final void m6484w(C4718c c4718c, String str) throws Throwable {
        for (String str2 : f12421g) {
            File[] fileArrM6467r = m6467r(m6476l(), new h(C1643a.m886y(str, str2, ".cls")));
            if (fileArrM6467r.length == 0) {
                C4592b.f12227a.m6371b("Can't find " + str2 + " data for session ID " + str);
            } else {
                C4592b.f12227a.m6371b("Collecting " + str2 + " data for session ID " + str);
                m6460A(c4718c, fileArrM6467r[0]);
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
    /* JADX INFO: renamed from: y */
    public final void m6485y(C4718c c4718c, Thread thread, Throwable th, long j2, String str, boolean z2) throws Exception {
        Thread[] threadArr;
        Map<String, String> mapM6404a;
        Map<String, String> treeMap;
        byte[] bArrMo6493c;
        C4716a c4716aM6637a;
        C4716a c4716a;
        C4716a c4716a2;
        Thread[] threadArr2;
        int iM6642d;
        int length;
        int i2;
        C4716a c4716a3;
        String value;
        C4756e c4756e = new C4756e(th, this.f12444x);
        Context context = this.f12429i;
        C4619e c4619eM6401a = C4619e.m6401a(context);
        Float f2 = c4619eM6401a.f12283a;
        int iM6402b = c4619eM6401a.m6402b();
        boolean zM6419m = C4628h.m6419m(context);
        int i3 = context.getResources().getConfiguration().orientation;
        long jM6422p = C4628h.m6422p();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
        long j3 = jM6422p - memoryInfo.availMem;
        long jM6407a = C4628h.m6407a(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo runningAppProcessInfoM6415i = C4628h.m6415i(context.getPackageName(), context);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = c4756e.f12779c;
        String str2 = this.f12437q.f12260b;
        String str3 = this.f12435o.f12411e;
        if (z2) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr3 = new Thread[allStackTraces.size()];
            int i4 = 0;
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                threadArr3[i4] = entry.getKey();
                linkedList.add(this.f12444x.mo6696a(entry.getValue()));
                i4++;
                threadArr3 = threadArr3;
            }
            threadArr = threadArr3;
        } else {
            threadArr = new Thread[0];
        }
        if (C4628h.m6416j(context, "com.crashlytics.CollectCustomKeys", true)) {
            mapM6404a = this.f12432l.m6404a();
            if (mapM6404a != null && mapM6404a.size() > 1) {
                treeMap = new TreeMap(mapM6404a);
            }
            bArrMo6493c = this.f12440t.f12473d.mo6493c();
            C4716a c4716a4 = C4719d.f12694a;
            C4716a c4716aM6637a2 = C4716a.m6637a(str3);
            if (str2 == null) {
                c4716aM6637a = null;
            } else {
                c4716aM6637a = C4716a.m6637a(str2.replace("-", ""));
            }
            if (bArrMo6493c != null) {
                int length2 = bArrMo6493c.length;
                byte[] bArr = new byte[length2];
                System.arraycopy(bArrMo6493c, 0, bArr, 0, length2);
                c4716a = new C4716a(bArr);
            } else {
                C4592b.f12227a.m6371b("No log data to include with this event.");
                c4716a = null;
            }
            c4718c.m6654r(10, 2);
            int iM6640b = C4718c.m6640b(2, C4716a.m6637a(str)) + C4718c.m6645h(1, j2) + 0;
            c4716a2 = c4716a;
            threadArr2 = threadArr;
            int iM6662f = C4719d.m6662f(c4756e, thread, stackTraceElementArr, threadArr, linkedList, 8, c4716aM6637a2, c4716aM6637a, treeMap, runningAppProcessInfoM6415i, i3);
            int iM6642d2 = C4718c.m6642d(iM6662f) + C4718c.m6643e(3) + iM6662f + iM6640b;
            int iM6663g = C4719d.m6663g(f2, iM6402b, zM6419m, i3, j3, jM6407a);
            iM6642d = C4718c.m6642d(iM6663g) + C4718c.m6643e(5) + iM6663g + iM6642d2;
            if (c4716a2 != null) {
                int iM6640b2 = C4718c.m6640b(1, c4716a2);
                iM6642d += C4718c.m6642d(iM6640b2) + C4718c.m6643e(6) + iM6640b2;
            }
            c4718c.m6652o(iM6642d);
            c4718c.m6656t(1, j2);
            c4718c.m6649l(2, C4716a.m6637a(str));
            c4718c.m6654r(3, 2);
            C4716a c4716a5 = c4716aM6637a;
            c4718c.m6652o(C4719d.m6662f(c4756e, thread, stackTraceElementArr, threadArr2, linkedList, 8, c4716aM6637a2, c4716a5, treeMap, runningAppProcessInfoM6415i, i3));
            c4718c.m6654r(1, 2);
            c4718c.m6652o(C4719d.m6661e(c4756e, thread, stackTraceElementArr, threadArr2, linkedList, 8, c4716aM6637a2, c4716a5));
            C4719d.m6669m(c4718c, thread, stackTraceElementArr, 4, true);
            length = threadArr2.length;
            for (i2 = 0; i2 < length; i2++) {
                C4719d.m6669m(c4718c, threadArr2[i2], (StackTraceElement[]) linkedList.get(i2), 0, false);
            }
            C4719d.m6668l(c4718c, c4756e, 1, 8, 2);
            c4718c.m6654r(3, 2);
            c4718c.m6652o(C4719d.m6660d());
            C4716a c4716a6 = C4719d.f12694a;
            c4718c.m6649l(1, c4716a6);
            c4718c.m6649l(2, c4716a6);
            c4718c.m6656t(3, 0L);
            c4718c.m6654r(4, 2);
            c4716a3 = c4716aM6637a;
            c4718c.m6652o(C4719d.m6657a(c4716aM6637a2, c4716a3));
            c4718c.m6656t(1, 0L);
            c4718c.m6656t(2, 0L);
            c4718c.m6649l(3, c4716aM6637a2);
            if (c4716a3 != null) {
                c4718c.m6649l(4, c4716a3);
            }
            if (treeMap != null && !treeMap.isEmpty()) {
                for (Map.Entry<String, String> entry2 : treeMap.entrySet()) {
                    c4718c.m6654r(2, 2);
                    c4718c.m6652o(C4719d.m6658b(entry2.getKey(), entry2.getValue()));
                    c4718c.m6649l(1, C4716a.m6637a(entry2.getKey()));
                    value = entry2.getValue();
                    if (value == null) {
                        value = "";
                    }
                    c4718c.m6649l(2, C4716a.m6637a(value));
                }
            }
            if (runningAppProcessInfoM6415i != null) {
                c4718c.m6648k(3, runningAppProcessInfoM6415i.importance != 100);
            }
            c4718c.m6655s(4, i3);
            c4718c.m6654r(5, 2);
            c4718c.m6652o(C4719d.m6663g(f2, iM6402b, zM6419m, i3, j3, jM6407a));
            if (f2 != null) {
                float fFloatValue = f2.floatValue();
                c4718c.m6652o(13);
                int iFloatToRawIntBits = Float.floatToRawIntBits(fFloatValue);
                c4718c.m6651n(iFloatToRawIntBits & 255);
                c4718c.m6651n((iFloatToRawIntBits >> 8) & 255);
                c4718c.m6651n((iFloatToRawIntBits >> 16) & 255);
                c4718c.m6651n((iFloatToRawIntBits >> 24) & 255);
            }
            c4718c.m6652o(16);
            c4718c.m6652o((iM6402b << 1) ^ (iM6402b >> 31));
            c4718c.m6648k(3, zM6419m);
            c4718c.m6655s(4, i3);
            c4718c.m6656t(5, j3);
            c4718c.m6656t(6, jM6407a);
            if (c4716a2 != null) {
                c4718c.m6654r(6, 2);
                c4718c.m6652o(C4718c.m6640b(1, c4716a2));
                c4718c.m6649l(1, c4716a2);
            }
            this.f12440t.f12473d.mo6494d();
        }
        mapM6404a = new TreeMap<>();
        treeMap = mapM6404a;
        bArrMo6493c = this.f12440t.f12473d.mo6493c();
        C4716a c4716a7 = C4719d.f12694a;
        C4716a c4716aM6637a3 = C4716a.m6637a(str3);
        if (str2 == null) {
            c4716aM6637a = null;
        } else {
            c4716aM6637a = C4716a.m6637a(str2.replace("-", ""));
        }
        if (bArrMo6493c != null) {
            int length3 = bArrMo6493c.length;
            byte[] bArr2 = new byte[length3];
            System.arraycopy(bArrMo6493c, 0, bArr2, 0, length3);
            c4716a = new C4716a(bArr2);
        } else {
            C4592b.f12227a.m6371b("No log data to include with this event.");
            c4716a = null;
        }
        c4718c.m6654r(10, 2);
        int iM6640b3 = C4718c.m6640b(2, C4716a.m6637a(str)) + C4718c.m6645h(1, j2) + 0;
        c4716a2 = c4716a;
        threadArr2 = threadArr;
        int iM6662f2 = C4719d.m6662f(c4756e, thread, stackTraceElementArr, threadArr, linkedList, 8, c4716aM6637a3, c4716aM6637a, treeMap, runningAppProcessInfoM6415i, i3);
        int iM6642d3 = C4718c.m6642d(iM6662f2) + C4718c.m6643e(3) + iM6662f2 + iM6640b3;
        int iM6663g2 = C4719d.m6663g(f2, iM6402b, zM6419m, i3, j3, jM6407a);
        iM6642d = C4718c.m6642d(iM6663g2) + C4718c.m6643e(5) + iM6663g2 + iM6642d3;
        if (c4716a2 != null) {
            int iM6640b4 = C4718c.m6640b(1, c4716a2);
            iM6642d += C4718c.m6642d(iM6640b4) + C4718c.m6643e(6) + iM6640b4;
        }
        c4718c.m6652o(iM6642d);
        c4718c.m6656t(1, j2);
        c4718c.m6649l(2, C4716a.m6637a(str));
        c4718c.m6654r(3, 2);
        C4716a c4716a8 = c4716aM6637a;
        c4718c.m6652o(C4719d.m6662f(c4756e, thread, stackTraceElementArr, threadArr2, linkedList, 8, c4716aM6637a3, c4716a8, treeMap, runningAppProcessInfoM6415i, i3));
        c4718c.m6654r(1, 2);
        c4718c.m6652o(C4719d.m6661e(c4756e, thread, stackTraceElementArr, threadArr2, linkedList, 8, c4716aM6637a3, c4716a8));
        C4719d.m6669m(c4718c, thread, stackTraceElementArr, 4, true);
        length = threadArr2.length;
        while (i2 < length) {
            C4719d.m6669m(c4718c, threadArr2[i2], (StackTraceElement[]) linkedList.get(i2), 0, false);
        }
        C4719d.m6668l(c4718c, c4756e, 1, 8, 2);
        c4718c.m6654r(3, 2);
        c4718c.m6652o(C4719d.m6660d());
        C4716a c4716a9 = C4719d.f12694a;
        c4718c.m6649l(1, c4716a9);
        c4718c.m6649l(2, c4716a9);
        c4718c.m6656t(3, 0L);
        c4718c.m6654r(4, 2);
        c4716a3 = c4716aM6637a;
        c4718c.m6652o(C4719d.m6657a(c4716aM6637a3, c4716a3));
        c4718c.m6656t(1, 0L);
        c4718c.m6656t(2, 0L);
        c4718c.m6649l(3, c4716aM6637a3);
        if (c4716a3 != null) {
            c4718c.m6649l(4, c4716a3);
        }
        if (treeMap != null) {
            while (r3.hasNext()) {
                c4718c.m6654r(2, 2);
                c4718c.m6652o(C4719d.m6658b(entry2.getKey(), entry2.getValue()));
                c4718c.m6649l(1, C4716a.m6637a(entry2.getKey()));
                value = entry2.getValue();
                if (value == null) {
                    value = "";
                }
                c4718c.m6649l(2, C4716a.m6637a(value));
            }
        }
        if (runningAppProcessInfoM6415i != null) {
            c4718c.m6648k(3, runningAppProcessInfoM6415i.importance != 100);
        }
        c4718c.m6655s(4, i3);
        c4718c.m6654r(5, 2);
        c4718c.m6652o(C4719d.m6663g(f2, iM6402b, zM6419m, i3, j3, jM6407a));
        if (f2 != null) {
            float fFloatValue2 = f2.floatValue();
            c4718c.m6652o(13);
            int iFloatToRawIntBits2 = Float.floatToRawIntBits(fFloatValue2);
            c4718c.m6651n(iFloatToRawIntBits2 & 255);
            c4718c.m6651n((iFloatToRawIntBits2 >> 8) & 255);
            c4718c.m6651n((iFloatToRawIntBits2 >> 16) & 255);
            c4718c.m6651n((iFloatToRawIntBits2 >> 24) & 255);
        }
        c4718c.m6652o(16);
        c4718c.m6652o((iM6402b << 1) ^ (iM6402b >> 31));
        c4718c.m6648k(3, zM6419m);
        c4718c.m6655s(4, i3);
        c4718c.m6656t(5, j3);
        c4718c.m6656t(6, jM6407a);
        if (c4716a2 != null) {
            c4718c.m6654r(6, 2);
            c4718c.m6652o(C4718c.m6640b(1, c4716a2));
            c4718c.m6649l(1, c4716a2);
        }
        this.f12440t.f12473d.mo6494d();
    }

    /* JADX INFO: renamed from: z */
    public final void m6486z(String str, String str2, g gVar) throws Exception {
        Throwable th;
        C4717b c4717b;
        C4718c c4718c = null;
        try {
            c4717b = new C4717b(m6476l(), str + str2);
            try {
                C4718c c4718cM6646i = C4718c.m6646i(c4717b);
                try {
                    gVar.mo6454a(c4718cM6646i);
                    C4628h.m6414h(c4718cM6646i, "Failed to flush to session " + str2 + " file.");
                    C4628h.m6409c(c4717b, "Failed to close session " + str2 + " file.");
                } catch (Throwable th2) {
                    th = th2;
                    c4718c = c4718cM6646i;
                    C4628h.m6414h(c4718c, "Failed to flush to session " + str2 + " file.");
                    C4628h.m6409c(c4717b, "Failed to close session " + str2 + " file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            c4717b = null;
        }
    }
}
