package p007b.p445m.p446a;

import java.util.List;
import java.util.concurrent.TimeUnit;
import p507d0.p580t.C12147n;

/* JADX INFO: renamed from: b.m.a.c */
/* JADX INFO: compiled from: DefaultParam.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5084c {

    /* JADX INFO: renamed from: b */
    public static final long f13640b;

    /* JADX INFO: renamed from: c */
    public static final long f13641c;

    /* JADX INFO: renamed from: d */
    public static final long f13642d;

    /* JADX INFO: renamed from: e */
    public static final C5084c f13643e = new C5084c();

    /* JADX INFO: renamed from: a */
    public static final List<String> f13639a = C12147n.listOf((Object[]) new String[]{"2.us.pool.ntp.org", "1.us.pool.ntp.org", "0.us.pool.ntp.org"});

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        f13640b = timeUnit.toMillis(1L);
        f13641c = timeUnit.toMillis(1L);
        f13642d = TimeUnit.SECONDS.toMillis(6L);
    }
}
