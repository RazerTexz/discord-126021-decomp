package p007b.p225i.p226a.p288f.p313h.p323j;

import com.discord.stores.StoreGuildScheduledEvents;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p302i.C3340e;

/* JADX INFO: renamed from: b.i.a.f.h.j.e0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3510e0 {

    /* JADX INFO: renamed from: A */
    public static C3513f0<Long> f9686A;

    /* JADX INFO: renamed from: B */
    public static C3513f0<Long> f9687B;

    /* JADX INFO: renamed from: C */
    public static C3513f0<Boolean> f9688C;

    /* JADX INFO: renamed from: a */
    public static C3513f0<Boolean> f9689a;

    /* JADX INFO: renamed from: b */
    public static C3513f0<String> f9690b;

    /* JADX INFO: renamed from: c */
    public static C3513f0<Long> f9691c;

    /* JADX INFO: renamed from: d */
    public static C3513f0<Long> f9692d;

    /* JADX INFO: renamed from: e */
    public static C3513f0<Long> f9693e;

    /* JADX INFO: renamed from: f */
    public static C3513f0<Long> f9694f;

    /* JADX INFO: renamed from: g */
    public static C3513f0<Integer> f9695g;

    /* JADX INFO: renamed from: h */
    public static C3513f0<Integer> f9696h;

    /* JADX INFO: renamed from: i */
    public static C3513f0<String> f9697i;

    /* JADX INFO: renamed from: j */
    public static C3513f0<String> f9698j;

    /* JADX INFO: renamed from: k */
    public static C3513f0<String> f9699k;

    /* JADX INFO: renamed from: l */
    public static C3513f0<String> f9700l;

    /* JADX INFO: renamed from: m */
    public static C3513f0<Integer> f9701m;

    /* JADX INFO: renamed from: n */
    public static C3513f0<String> f9702n;

    /* JADX INFO: renamed from: o */
    public static C3513f0<String> f9703o;

    /* JADX INFO: renamed from: p */
    public static C3513f0<Integer> f9704p;

    /* JADX INFO: renamed from: q */
    public static C3513f0<Integer> f9705q;

    /* JADX INFO: renamed from: r */
    public static C3513f0<Integer> f9706r;

    /* JADX INFO: renamed from: s */
    public static C3513f0<String> f9707s;

    /* JADX INFO: renamed from: t */
    public static C3513f0<Integer> f9708t;

    /* JADX INFO: renamed from: u */
    public static C3513f0<Integer> f9709u;

    /* JADX INFO: renamed from: v */
    public static C3513f0<Integer> f9710v;

    /* JADX INFO: renamed from: w */
    public static C3513f0<Boolean> f9711w;

    /* JADX INFO: renamed from: x */
    public static C3513f0<Long> f9712x;

    /* JADX INFO: renamed from: y */
    public static C3513f0<Long> f9713y;

    /* JADX INFO: renamed from: z */
    public static C3513f0<Long> f9714z;

    static {
        C3513f0.m4448d("analytics.service_enabled", false, false);
        f9689a = C3513f0.m4448d("analytics.service_client_enabled", true, true);
        f9690b = C3513f0.m4447c("analytics.log_tag", "GAv4", "GAv4-SVC");
        C3513f0.m4446b("analytics.max_tokens", 60L, 60L);
        Objects.requireNonNull(new C3340e("analytics.tokens_per_sec", Float.valueOf(0.5f)), "null reference");
        C3513f0.m4445a("analytics.max_stored_hits", 2000, 20000);
        C3513f0.m4445a("analytics.max_stored_hits_per_app", 2000, 2000);
        C3513f0.m4445a("analytics.max_stored_properties_per_app", 100, 100);
        f9691c = C3513f0.m4446b("analytics.local_dispatch_millis", StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD, 120000L);
        f9692d = C3513f0.m4446b("analytics.initial_local_dispatch_millis", 5000L, 5000L);
        C3513f0.m4446b("analytics.min_local_dispatch_millis", 120000L, 120000L);
        C3513f0.m4446b("analytics.max_local_dispatch_millis", 7200000L, 7200000L);
        f9693e = C3513f0.m4446b("analytics.dispatch_alarm_millis", 7200000L, 7200000L);
        f9694f = C3513f0.m4446b("analytics.max_dispatch_alarm_millis", 32400000L, 32400000L);
        f9695g = C3513f0.m4445a("analytics.max_hits_per_dispatch", 20, 20);
        f9696h = C3513f0.m4445a("analytics.max_hits_per_batch", 20, 20);
        f9697i = C3513f0.m4447c("analytics.insecure_host", "http://www.google-analytics.com", "http://www.google-analytics.com");
        f9698j = C3513f0.m4447c("analytics.secure_host", "https://ssl.google-analytics.com", "https://ssl.google-analytics.com");
        f9699k = C3513f0.m4447c("analytics.simple_endpoint", "/collect", "/collect");
        f9700l = C3513f0.m4447c("analytics.batching_endpoint", "/batch", "/batch");
        f9701m = C3513f0.m4445a("analytics.max_get_length", 2036, 2036);
        f9702n = C3513f0.m4447c("analytics.batching_strategy.k", "BATCH_BY_COUNT", "BATCH_BY_COUNT");
        f9703o = C3513f0.m4447c("analytics.compression_strategy.k", "GZIP", "GZIP");
        C3513f0.m4445a("analytics.max_hits_per_request.k", 20, 20);
        f9704p = C3513f0.m4445a("analytics.max_hit_length.k", 8192, 8192);
        f9705q = C3513f0.m4445a("analytics.max_post_length.k", 8192, 8192);
        f9706r = C3513f0.m4445a("analytics.max_batch_post_length", 8192, 8192);
        f9707s = C3513f0.m4447c("analytics.fallback_responses.k", "404,502", "404,502");
        f9708t = C3513f0.m4445a("analytics.batch_retry_interval.seconds.k", 3600, 3600);
        C3513f0.m4446b("analytics.service_monitor_interval", 86400000L, 86400000L);
        f9709u = C3513f0.m4445a("analytics.http_connection.connect_timeout_millis", 60000, 60000);
        f9710v = C3513f0.m4445a("analytics.http_connection.read_timeout_millis", 61000, 61000);
        C3513f0.m4446b("analytics.campaigns.time_limit", 86400000L, 86400000L);
        C3513f0.m4447c("analytics.first_party_experiment_id", "", "");
        C3513f0.m4445a("analytics.first_party_experiment_variant", 0, 0);
        f9711w = C3513f0.m4448d("analytics.test.disable_receiver", false, false);
        f9712x = C3513f0.m4446b("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
        f9713y = C3513f0.m4446b("analytics.service_client.connect_timeout_millis", 5000L, 5000L);
        C3513f0.m4446b("analytics.service_client.second_connect_delay_millis", 5000L, 5000L);
        C3513f0.m4446b("analytics.service_client.unexpected_reconnect_millis", 60000L, 60000L);
        f9714z = C3513f0.m4446b("analytics.service_client.reconnect_throttle_millis", StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD, StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD);
        f9686A = C3513f0.m4446b("analytics.monitoring.sample_period_millis", 86400000L, 86400000L);
        f9687B = C3513f0.m4446b("analytics.initialization_warning_threshold", 5000L, 5000L);
        f9688C = C3513f0.m4448d("analytics.gcm_task_service", false, false);
    }
}
