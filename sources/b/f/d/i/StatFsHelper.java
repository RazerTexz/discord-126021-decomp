package b.f.d.i;

import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import b.f.d.d.Throwables;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: b.f.d.i.a, reason: use source file name */
/* JADX INFO: compiled from: StatFsHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class StatFsHelper {
    public static StatFsHelper a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f473b = TimeUnit.MINUTES.toMillis(2);
    public volatile File d;
    public volatile File f;
    public long g;
    public volatile StatFs c = null;
    public volatile StatFs e = null;
    public volatile boolean i = false;
    public final Lock h = new ReentrantLock();

    public final void a() {
        if (this.i) {
            return;
        }
        this.h.lock();
        try {
            if (!this.i) {
                this.d = Environment.getDataDirectory();
                this.f = Environment.getExternalStorageDirectory();
                b();
                this.i = true;
            }
        } finally {
            this.h.unlock();
        }
    }

    public final void b() {
        this.c = c(this.c, this.d);
        this.e = c(this.e, this.f);
        this.g = SystemClock.uptimeMillis();
    }

    public final StatFs c(StatFs statFs, File file) throws Throwable {
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
            Throwables.a(th);
            throw new RuntimeException(th);
        }
    }
}
