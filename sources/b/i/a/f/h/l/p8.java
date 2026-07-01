package b.i.a.f.h.l;

import com.adjust.sdk.Constants;
import com.discord.api.permission.Permission;
import com.discord.stores.StoreGuildScheduledEvents;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p8 implements m8 {
    public static final l2<Long> A;
    public static final l2<Long> B;
    public static final l2<Long> C;
    public static final l2<Long> D;
    public static final l2<Long> E;
    public static final l2<String> F;
    public static final l2<Long> G;
    public static final l2<Long> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l2<Long> f1483b;
    public static final l2<String> c;
    public static final l2<String> d;
    public static final l2<Long> e;
    public static final l2<Long> f;
    public static final l2<Long> g;
    public static final l2<Long> h;
    public static final l2<Long> i;
    public static final l2<Long> j;
    public static final l2<Long> k;
    public static final l2<Long> l;
    public static final l2<Long> m;
    public static final l2<Long> n;
    public static final l2<Long> o;
    public static final l2<Long> p;
    public static final l2<Long> q;
    public static final l2<Long> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final l2<Long> f1484s;
    public static final l2<Long> t;
    public static final l2<Long> u;
    public static final l2<Long> v;
    public static final l2<Long> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final l2<Long> f1485x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final l2<Long> f1486y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final l2<Long> f1487z;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        a = q2Var.a("measurement.ad_id_cache_time", 10000L);
        f1483b = q2Var.a("measurement.config.cache_time", 86400000L);
        q2Var.b("measurement.log_tag", "FA");
        c = q2Var.b("measurement.config.url_authority", "app-measurement.com");
        d = q2Var.b("measurement.config.url_scheme", Constants.SCHEME);
        e = q2Var.a("measurement.upload.debug_upload_interval", 1000L);
        f = q2Var.a("measurement.lifetimevalue.max_currency_tracked", 4L);
        g = q2Var.a("measurement.store.max_stored_events_per_app", 100000L);
        h = q2Var.a("measurement.experiment.max_ids", 50L);
        i = q2Var.a("measurement.audience.filter_result_max_count", 200L);
        j = q2Var.a("measurement.alarm_manager.minimum_interval", 60000L);
        k = q2Var.a("measurement.upload.minimum_delay", 500L);
        l = q2Var.a("measurement.monitoring.sample_period_millis", 86400000L);
        m = q2Var.a("measurement.upload.realtime_upload_interval", 10000L);
        n = q2Var.a("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        q2Var.a("measurement.config.cache_time.service", 3600000L);
        o = q2Var.a("measurement.service_client.idle_disconnect_millis", 5000L);
        q2Var.b("measurement.log_tag.service", "FA-SVC");
        p = q2Var.a("measurement.upload.stale_data_deletion_interval", 86400000L);
        q = q2Var.a("measurement.upload.backoff_period", 43200000L);
        r = q2Var.a("measurement.upload.initial_upload_delay_time", 15000L);
        f1484s = q2Var.a("measurement.upload.interval", 3600000L);
        t = q2Var.a("measurement.upload.max_bundle_size", Permission.READ_MESSAGE_HISTORY);
        u = q2Var.a("measurement.upload.max_bundles", 100L);
        v = q2Var.a("measurement.upload.max_conversions_per_day", 500L);
        w = q2Var.a("measurement.upload.max_error_events_per_day", 1000L);
        f1485x = q2Var.a("measurement.upload.max_events_per_bundle", 1000L);
        f1486y = q2Var.a("measurement.upload.max_events_per_day", 100000L);
        f1487z = q2Var.a("measurement.upload.max_public_events_per_day", 50000L);
        A = q2Var.a("measurement.upload.max_queue_time", 2419200000L);
        B = q2Var.a("measurement.upload.max_realtime_events_per_day", 10L);
        C = q2Var.a("measurement.upload.max_batch_size", Permission.READ_MESSAGE_HISTORY);
        D = q2Var.a("measurement.upload.retry_count", 6L);
        E = q2Var.a("measurement.upload.retry_time", StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD);
        F = q2Var.b("measurement.upload.url", "https://app-measurement.com/a");
        G = q2Var.a("measurement.upload.window_interval", 3600000L);
    }

    @Override // b.i.a.f.h.l.m8
    public final long A() {
        return v.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long B() {
        return D.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long C() {
        return j.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long D() {
        return A.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long E() {
        return f1484s.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long F() {
        return k.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long G() {
        return B.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long a() {
        return a.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long b() {
        return f1483b.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final String c() {
        return c.d();
    }

    @Override // b.i.a.f.h.l.m8
    public final String d() {
        return d.d();
    }

    @Override // b.i.a.f.h.l.m8
    public final long e() {
        return e.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long f() {
        return p.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long g() {
        return q.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long h() {
        return g.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long i() {
        return l.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long j() {
        return m.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long k() {
        return t.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long l() {
        return f1486y.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long m() {
        return h.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long n() {
        return G.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long o() {
        return f1487z.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long p() {
        return i.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long q() {
        return r.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long r() {
        return n.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long s() {
        return w.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long t() {
        return f.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long u() {
        return E.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long v() {
        return o.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long w() {
        return f1485x.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final String x() {
        return F.d();
    }

    @Override // b.i.a.f.h.l.m8
    public final long y() {
        return C.d().longValue();
    }

    @Override // b.i.a.f.h.l.m8
    public final long z() {
        return u.d().longValue();
    }
}
