package b.i.c.u;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.i.c.u.o.PersistedInstallationEntry;
import b.i.c.u.q.SystemClock3;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.c.u.n, reason: use source file name */
/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Utils6 {
    public static final long a = TimeUnit.HOURS.toSeconds(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f1783b = Pattern.compile("\\AA[\\w-]{38}\\z");
    public static Utils6 c;
    public final SystemClock3 d;

    public Utils6(SystemClock3 systemClock3) {
        this.d = systemClock3;
    }

    public static Utils6 c() {
        if (SystemClock3.a == null) {
            SystemClock3.a = new SystemClock3();
        }
        SystemClock3 systemClock3 = SystemClock3.a;
        if (c == null) {
            c = new Utils6(systemClock3);
        }
        return c;
    }

    public long a() {
        Objects.requireNonNull(this.d);
        return System.currentTimeMillis();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    public boolean d(@NonNull PersistedInstallationEntry persistedInstallationEntry) {
        if (TextUtils.isEmpty(persistedInstallationEntry.a())) {
            return true;
        }
        return persistedInstallationEntry.b() + persistedInstallationEntry.g() < b() + a;
    }
}
