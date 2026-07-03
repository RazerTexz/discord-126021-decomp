package p007b.p109f.p115d.p124i;

import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p007b.p109f.p115d.p119d.C1690m;

/* JADX INFO: renamed from: b.f.d.i.a */
/* JADX INFO: compiled from: StatFsHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1710a {

    /* JADX INFO: renamed from: a */
    public static C1710a f3119a;

    /* JADX INFO: renamed from: b */
    public static final long f3120b = TimeUnit.MINUTES.toMillis(2);

    /* JADX INFO: renamed from: d */
    public volatile File f3122d;

    /* JADX INFO: renamed from: f */
    public volatile File f3124f;

    /* JADX INFO: renamed from: g */
    public long f3125g;

    /* JADX INFO: renamed from: c */
    public volatile StatFs f3121c = null;

    /* JADX INFO: renamed from: e */
    public volatile StatFs f3123e = null;

    /* JADX INFO: renamed from: i */
    public volatile boolean f3127i = false;

    /* JADX INFO: renamed from: h */
    public final Lock f3126h = new ReentrantLock();

    /* JADX INFO: renamed from: a */
    public final void m1000a() {
        if (this.f3127i) {
            return;
        }
        this.f3126h.lock();
        try {
            if (!this.f3127i) {
                this.f3122d = Environment.getDataDirectory();
                this.f3124f = Environment.getExternalStorageDirectory();
                m1001b();
                this.f3127i = true;
            }
        } finally {
            this.f3126h.unlock();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m1001b() {
        this.f3121c = m1002c(this.f3121c, this.f3122d);
        this.f3123e = m1002c(this.f3123e, this.f3124f);
        this.f3125g = SystemClock.uptimeMillis();
    }

    /* JADX INFO: renamed from: c */
    public final StatFs m1002c(StatFs statFs, File file) throws Throwable {
        StatFs statFs2 = null;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = new StatFs(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            statFs2 = statFs;
            return statFs2;
        } catch (IllegalArgumentException unused) {
            return statFs2;
        } catch (Throwable th) {
            C1690m.m972a(th);
            throw new RuntimeException(th);
        }
    }
}
