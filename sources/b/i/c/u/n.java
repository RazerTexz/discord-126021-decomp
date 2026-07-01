package b.i.c.u;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static final long a = TimeUnit.HOURS.toSeconds(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f1783b = Pattern.compile("\\AA[\\w-]{38}\\z");
    public static n c;
    public final b.i.c.u.q.a d;

    public n(b.i.c.u.q.a aVar) {
        this.d = aVar;
    }

    public static n c() {
        if (b.i.c.u.q.a.a == null) {
            b.i.c.u.q.a.a = new b.i.c.u.q.a();
        }
        b.i.c.u.q.a aVar = b.i.c.u.q.a.a;
        if (c == null) {
            c = new n(aVar);
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

    public boolean d(@NonNull b.i.c.u.o.d dVar) {
        if (TextUtils.isEmpty(dVar.a())) {
            return true;
        }
        return dVar.b() + dVar.g() < b() + a;
    }
}
