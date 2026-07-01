package b.i.a.f.h.j;

import com.discord.stores.StoreGuildScheduledEvents;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {
    public static f0<Long> A;
    public static f0<Long> B;
    public static f0<Boolean> C;
    public static f0<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f0<String> f1411b;
    public static f0<Long> c;
    public static f0<Long> d;
    public static f0<Long> e;
    public static f0<Long> f;
    public static f0<Integer> g;
    public static f0<Integer> h;
    public static f0<String> i;
    public static f0<String> j;
    public static f0<String> k;
    public static f0<String> l;
    public static f0<Integer> m;
    public static f0<String> n;
    public static f0<String> o;
    public static f0<Integer> p;
    public static f0<Integer> q;
    public static f0<Integer> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static f0<String> f1412s;
    public static f0<Integer> t;
    public static f0<Integer> u;
    public static f0<Integer> v;
    public static f0<Boolean> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static f0<Long> f1413x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static f0<Long> f1414y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static f0<Long> f1415z;

    static {
        f0.d("analytics.service_enabled", false, false);
        a = f0.d("analytics.service_client_enabled", true, true);
        f1411b = f0.c("analytics.log_tag", "GAv4", "GAv4-SVC");
        f0.b("analytics.max_tokens", 60L, 60L);
        Objects.requireNonNull(new b.i.a.f.e.i.e("analytics.tokens_per_sec", Float.valueOf(0.5f)), "null reference");
        f0.a("analytics.max_stored_hits", 2000, 20000);
        f0.a("analytics.max_stored_hits_per_app", 2000, 2000);
        f0.a("analytics.max_stored_properties_per_app", 100, 100);
        c = f0.b("analytics.local_dispatch_millis", StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD, 120000L);
        d = f0.b("analytics.initial_local_dispatch_millis", 5000L, 5000L);
        f0.b("analytics.min_local_dispatch_millis", 120000L, 120000L);
        f0.b("analytics.max_local_dispatch_millis", 7200000L, 7200000L);
        e = f0.b("analytics.dispatch_alarm_millis", 7200000L, 7200000L);
        f = f0.b("analytics.max_dispatch_alarm_millis", 32400000L, 32400000L);
        g = f0.a("analytics.max_hits_per_dispatch", 20, 20);
        h = f0.a("analytics.max_hits_per_batch", 20, 20);
        i = f0.c("analytics.insecure_host", "http://www.google-analytics.com", "http://www.google-analytics.com");
        j = f0.c("analytics.secure_host", "https://ssl.google-analytics.com", "https://ssl.google-analytics.com");
        k = f0.c("analytics.simple_endpoint", "/collect", "/collect");
        l = f0.c("analytics.batching_endpoint", "/batch", "/batch");
        m = f0.a("analytics.max_get_length", 2036, 2036);
        n = f0.c("analytics.batching_strategy.k", "BATCH_BY_COUNT", "BATCH_BY_COUNT");
        o = f0.c("analytics.compression_strategy.k", "GZIP", "GZIP");
        f0.a("analytics.max_hits_per_request.k", 20, 20);
        p = f0.a("analytics.max_hit_length.k", 8192, 8192);
        q = f0.a("analytics.max_post_length.k", 8192, 8192);
        r = f0.a("analytics.max_batch_post_length", 8192, 8192);
        f1412s = f0.c("analytics.fallback_responses.k", "404,502", "404,502");
        t = f0.a("analytics.batch_retry_interval.seconds.k", 3600, 3600);
        f0.b("analytics.service_monitor_interval", 86400000L, 86400000L);
        u = f0.a("analytics.http_connection.connect_timeout_millis", 60000, 60000);
        v = f0.a("analytics.http_connection.read_timeout_millis", 61000, 61000);
        f0.b("analytics.campaigns.time_limit", 86400000L, 86400000L);
        f0.c("analytics.first_party_experiment_id", "", "");
        f0.a("analytics.first_party_experiment_variant", 0, 0);
        w = f0.d("analytics.test.disable_receiver", false, false);
        f1413x = f0.b("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
        f1414y = f0.b("analytics.service_client.connect_timeout_millis", 5000L, 5000L);
        f0.b("analytics.service_client.second_connect_delay_millis", 5000L, 5000L);
        f0.b("analytics.service_client.unexpected_reconnect_millis", 60000L, 60000L);
        f1415z = f0.b("analytics.service_client.reconnect_throttle_millis", StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD, StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD);
        A = f0.b("analytics.monitoring.sample_period_millis", 86400000L, 86400000L);
        B = f0.b("analytics.initialization_warning_threshold", 5000L, 5000L);
        C = f0.d("analytics.gcm_task_service", false, false);
    }
}
