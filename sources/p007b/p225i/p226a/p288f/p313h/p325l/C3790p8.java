package p007b.p225i.p226a.p288f.p313h.p325l;

import com.adjust.sdk.Constants;
import com.discord.api.permission.Permission;
import com.discord.stores.StoreGuildScheduledEvents;

/* JADX INFO: renamed from: b.i.a.f.h.l.p8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3790p8 implements InterfaceC3751m8 {

    /* JADX INFO: renamed from: A */
    public static final AbstractC3732l2<Long> f10218A;

    /* JADX INFO: renamed from: B */
    public static final AbstractC3732l2<Long> f10219B;

    /* JADX INFO: renamed from: C */
    public static final AbstractC3732l2<Long> f10220C;

    /* JADX INFO: renamed from: D */
    public static final AbstractC3732l2<Long> f10221D;

    /* JADX INFO: renamed from: E */
    public static final AbstractC3732l2<Long> f10222E;

    /* JADX INFO: renamed from: F */
    public static final AbstractC3732l2<String> f10223F;

    /* JADX INFO: renamed from: G */
    public static final AbstractC3732l2<Long> f10224G;

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Long> f10225a;

    /* JADX INFO: renamed from: b */
    public static final AbstractC3732l2<Long> f10226b;

    /* JADX INFO: renamed from: c */
    public static final AbstractC3732l2<String> f10227c;

    /* JADX INFO: renamed from: d */
    public static final AbstractC3732l2<String> f10228d;

    /* JADX INFO: renamed from: e */
    public static final AbstractC3732l2<Long> f10229e;

    /* JADX INFO: renamed from: f */
    public static final AbstractC3732l2<Long> f10230f;

    /* JADX INFO: renamed from: g */
    public static final AbstractC3732l2<Long> f10231g;

    /* JADX INFO: renamed from: h */
    public static final AbstractC3732l2<Long> f10232h;

    /* JADX INFO: renamed from: i */
    public static final AbstractC3732l2<Long> f10233i;

    /* JADX INFO: renamed from: j */
    public static final AbstractC3732l2<Long> f10234j;

    /* JADX INFO: renamed from: k */
    public static final AbstractC3732l2<Long> f10235k;

    /* JADX INFO: renamed from: l */
    public static final AbstractC3732l2<Long> f10236l;

    /* JADX INFO: renamed from: m */
    public static final AbstractC3732l2<Long> f10237m;

    /* JADX INFO: renamed from: n */
    public static final AbstractC3732l2<Long> f10238n;

    /* JADX INFO: renamed from: o */
    public static final AbstractC3732l2<Long> f10239o;

    /* JADX INFO: renamed from: p */
    public static final AbstractC3732l2<Long> f10240p;

    /* JADX INFO: renamed from: q */
    public static final AbstractC3732l2<Long> f10241q;

    /* JADX INFO: renamed from: r */
    public static final AbstractC3732l2<Long> f10242r;

    /* JADX INFO: renamed from: s */
    public static final AbstractC3732l2<Long> f10243s;

    /* JADX INFO: renamed from: t */
    public static final AbstractC3732l2<Long> f10244t;

    /* JADX INFO: renamed from: u */
    public static final AbstractC3732l2<Long> f10245u;

    /* JADX INFO: renamed from: v */
    public static final AbstractC3732l2<Long> f10246v;

    /* JADX INFO: renamed from: w */
    public static final AbstractC3732l2<Long> f10247w;

    /* JADX INFO: renamed from: x */
    public static final AbstractC3732l2<Long> f10248x;

    /* JADX INFO: renamed from: y */
    public static final AbstractC3732l2<Long> f10249y;

    /* JADX INFO: renamed from: z */
    public static final AbstractC3732l2<Long> f10250z;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        f10225a = c3797q2.m5182a("measurement.ad_id_cache_time", 10000L);
        f10226b = c3797q2.m5182a("measurement.config.cache_time", 86400000L);
        c3797q2.m5183b("measurement.log_tag", "FA");
        f10227c = c3797q2.m5183b("measurement.config.url_authority", "app-measurement.com");
        f10228d = c3797q2.m5183b("measurement.config.url_scheme", Constants.SCHEME);
        f10229e = c3797q2.m5182a("measurement.upload.debug_upload_interval", 1000L);
        f10230f = c3797q2.m5182a("measurement.lifetimevalue.max_currency_tracked", 4L);
        f10231g = c3797q2.m5182a("measurement.store.max_stored_events_per_app", 100000L);
        f10232h = c3797q2.m5182a("measurement.experiment.max_ids", 50L);
        f10233i = c3797q2.m5182a("measurement.audience.filter_result_max_count", 200L);
        f10234j = c3797q2.m5182a("measurement.alarm_manager.minimum_interval", 60000L);
        f10235k = c3797q2.m5182a("measurement.upload.minimum_delay", 500L);
        f10236l = c3797q2.m5182a("measurement.monitoring.sample_period_millis", 86400000L);
        f10237m = c3797q2.m5182a("measurement.upload.realtime_upload_interval", 10000L);
        f10238n = c3797q2.m5182a("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        c3797q2.m5182a("measurement.config.cache_time.service", 3600000L);
        f10239o = c3797q2.m5182a("measurement.service_client.idle_disconnect_millis", 5000L);
        c3797q2.m5183b("measurement.log_tag.service", "FA-SVC");
        f10240p = c3797q2.m5182a("measurement.upload.stale_data_deletion_interval", 86400000L);
        f10241q = c3797q2.m5182a("measurement.upload.backoff_period", 43200000L);
        f10242r = c3797q2.m5182a("measurement.upload.initial_upload_delay_time", 15000L);
        f10243s = c3797q2.m5182a("measurement.upload.interval", 3600000L);
        f10244t = c3797q2.m5182a("measurement.upload.max_bundle_size", Permission.READ_MESSAGE_HISTORY);
        f10245u = c3797q2.m5182a("measurement.upload.max_bundles", 100L);
        f10246v = c3797q2.m5182a("measurement.upload.max_conversions_per_day", 500L);
        f10247w = c3797q2.m5182a("measurement.upload.max_error_events_per_day", 1000L);
        f10248x = c3797q2.m5182a("measurement.upload.max_events_per_bundle", 1000L);
        f10249y = c3797q2.m5182a("measurement.upload.max_events_per_day", 100000L);
        f10250z = c3797q2.m5182a("measurement.upload.max_public_events_per_day", 50000L);
        f10218A = c3797q2.m5182a("measurement.upload.max_queue_time", 2419200000L);
        f10219B = c3797q2.m5182a("measurement.upload.max_realtime_events_per_day", 10L);
        f10220C = c3797q2.m5182a("measurement.upload.max_batch_size", Permission.READ_MESSAGE_HISTORY);
        f10221D = c3797q2.m5182a("measurement.upload.retry_count", 6L);
        f10222E = c3797q2.m5182a("measurement.upload.retry_time", StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD);
        f10223F = c3797q2.m5183b("measurement.upload.url", "https://app-measurement.com/a");
        f10224G = c3797q2.m5182a("measurement.upload.window_interval", 3600000L);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: A */
    public final long mo5074A() {
        return f10246v.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: B */
    public final long mo5075B() {
        return f10221D.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: C */
    public final long mo5076C() {
        return f10234j.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: D */
    public final long mo5077D() {
        return f10218A.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: E */
    public final long mo5078E() {
        return f10243s.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: F */
    public final long mo5079F() {
        return f10235k.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: G */
    public final long mo5080G() {
        return f10219B.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: a */
    public final long mo5081a() {
        return f10225a.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: b */
    public final long mo5082b() {
        return f10226b.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: c */
    public final String mo5083c() {
        return f10227c.m5050d();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: d */
    public final String mo5084d() {
        return f10228d.m5050d();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: e */
    public final long mo5085e() {
        return f10229e.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: f */
    public final long mo5086f() {
        return f10240p.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: g */
    public final long mo5087g() {
        return f10241q.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: h */
    public final long mo5088h() {
        return f10231g.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: i */
    public final long mo5089i() {
        return f10236l.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: j */
    public final long mo5090j() {
        return f10237m.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: k */
    public final long mo5091k() {
        return f10244t.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: l */
    public final long mo5092l() {
        return f10249y.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: m */
    public final long mo5093m() {
        return f10232h.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: n */
    public final long mo5094n() {
        return f10224G.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: o */
    public final long mo5095o() {
        return f10250z.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: p */
    public final long mo5096p() {
        return f10233i.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: q */
    public final long mo5097q() {
        return f10242r.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: r */
    public final long mo5098r() {
        return f10238n.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: s */
    public final long mo5099s() {
        return f10247w.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: t */
    public final long mo5100t() {
        return f10230f.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: u */
    public final long mo5101u() {
        return f10222E.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: v */
    public final long mo5102v() {
        return f10239o.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: w */
    public final long mo5103w() {
        return f10248x.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: x */
    public final String mo5104x() {
        return f10223F.m5050d();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: y */
    public final long mo5105y() {
        return f10220C.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3751m8
    /* JADX INFO: renamed from: z */
    public final long mo5106z() {
        return f10245u.m5050d().longValue();
    }
}
