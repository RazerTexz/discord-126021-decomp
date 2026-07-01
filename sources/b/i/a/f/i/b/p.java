package b.i.a.f.i.b;

import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import com.discord.stores.StoreGuildScheduledEvents;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p {
    public static j3<Long> A;
    public static j3<Boolean> A0;
    public static j3<Long> B;
    public static j3<Boolean> B0;
    public static j3<Integer> C;
    public static j3<Boolean> C0;
    public static j3<Long> D;
    public static j3<Boolean> D0;
    public static j3<Integer> E;
    public static j3<Long> E0;
    public static j3<Integer> F;
    public static j3<Boolean> F0;
    public static j3<Integer> G;
    public static j3<Boolean> G0;
    public static j3<Integer> H;
    public static j3<Boolean> H0;
    public static j3<Integer> I;
    public static j3<Boolean> I0;
    public static j3<Long> J;
    public static j3<Boolean> J0;
    public static j3<Boolean> K;
    public static j3<Integer> K0;
    public static j3<String> L;
    public static j3<Boolean> L0;
    public static j3<Long> M;
    public static j3<Boolean> M0;
    public static j3<Integer> N;
    public static j3<Boolean> N0;
    public static j3<Double> O;
    public static j3<Boolean> O0;
    public static j3<Integer> P;
    public static j3<Integer> Q;
    public static j3<Boolean> R;
    public static j3<Boolean> S;
    public static j3<Boolean> T;
    public static j3<Boolean> U;
    public static j3<Boolean> V;
    public static j3<Boolean> W;
    public static j3<Boolean> X;
    public static j3<Boolean> Y;
    public static j3<Boolean> Z;
    public static List<j3<?>> a = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static j3<Boolean> f1551a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static j3<Long> f1552b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static j3<Boolean> f1553b0;
    public static j3<Long> c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static j3<Boolean> f1554c0;
    public static j3<Long> d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static j3<Boolean> f1555d0;
    public static j3<String> e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static j3<Boolean> f1556e0;
    public static j3<String> f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static j3<Boolean> f1557f0;
    public static j3<Integer> g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static j3<Boolean> f1558g0;
    public static j3<Integer> h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static j3<Boolean> f1559h0;
    public static j3<Integer> i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static j3<Boolean> f1560i0;
    public static j3<Integer> j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static j3<Boolean> f1561j0;
    public static j3<Integer> k;
    public static j3<Boolean> k0;
    public static j3<Integer> l;
    public static j3<Boolean> l0;
    public static j3<Integer> m;
    public static j3<Boolean> m0;
    public static j3<Integer> n;
    public static j3<Boolean> n0;
    public static j3<Integer> o;
    public static j3<Boolean> o0;
    public static j3<Integer> p;
    public static j3<Boolean> p0;
    public static j3<String> q;
    public static j3<Boolean> q0;
    public static j3<Long> r;
    public static j3<Boolean> r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static j3<Long> f1562s;
    public static j3<Boolean> s0;
    public static j3<Long> t;
    public static j3<Boolean> t0;
    public static j3<Long> u;
    public static j3<Boolean> u0;
    public static j3<Long> v;
    public static j3<Boolean> v0;
    public static j3<Long> w;
    public static j3<Boolean> w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static j3<Long> f1563x;
    public static j3<Boolean> x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static j3<Long> f1564y;
    public static j3<Boolean> y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static j3<Long> f1565z;
    public static j3<Boolean> z0;

    static {
        Collections.synchronizedSet(new HashSet());
        f1552b = a("measurement.ad_id_cache_time", 10000L, 10000L, s.a);
        c = a("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, r.a);
        d = a("measurement.config.cache_time", 86400000L, 3600000L, f0.a);
        e = a("measurement.config.url_scheme", Constants.SCHEME, Constants.SCHEME, o0.a);
        f = a("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", c1.a);
        g = a("measurement.upload.max_bundles", 100, 100, l1.a);
        h = a("measurement.upload.max_batch_size", 65536, 65536, y1.a);
        i = a("measurement.upload.max_bundle_size", 65536, 65536, i2.a);
        j = a("measurement.upload.max_events_per_bundle", 1000, 1000, v2.a);
        k = a("measurement.upload.max_events_per_day", 100000, 100000, g3.a);
        l = a("measurement.upload.max_error_events_per_day", 1000, 1000, u.a);
        m = a("measurement.upload.max_public_events_per_day", 50000, 50000, t.a);
        n = a("measurement.upload.max_conversions_per_day", 10000, 10000, w.a);
        o = a("measurement.upload.max_realtime_events_per_day", 10, 10, v.a);
        p = a("measurement.store.max_stored_events_per_app", 100000, 100000, z.a);
        q = a("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", y.a);
        r = a("measurement.upload.backoff_period", 43200000L, 43200000L, b0.a);
        f1562s = a("measurement.upload.window_interval", 3600000L, 3600000L, a0.a);
        t = a("measurement.upload.interval", 3600000L, 3600000L, d0.a);
        u = a("measurement.upload.realtime_upload_interval", 10000L, 10000L, c0.a);
        v = a("measurement.upload.debug_upload_interval", 1000L, 1000L, e0.a);
        w = a("measurement.upload.minimum_delay", 500L, 500L, h0.a);
        f1563x = a("measurement.alarm_manager.minimum_interval", 60000L, 60000L, g0.a);
        f1564y = a("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, j0.a);
        f1565z = a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, i0.a);
        A = a("measurement.upload.initial_upload_delay_time", 15000L, 15000L, l0.a);
        Long lValueOf = Long.valueOf(StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD);
        B = a("measurement.upload.retry_time", lValueOf, lValueOf, k0.a);
        C = a("measurement.upload.retry_count", 6, 6, n0.a);
        D = a("measurement.upload.max_queue_time", 2419200000L, 2419200000L, m0.a);
        E = a("measurement.lifetimevalue.max_currency_tracked", 4, 4, p0.a);
        F = a("measurement.audience.filter_result_max_count", 200, 200, r0.a);
        G = a("measurement.upload.max_public_user_properties", 25, 25, null);
        H = a("measurement.upload.max_event_name_cardinality", 500, 500, null);
        I = a("measurement.upload.max_public_event_params", 25, 25, null);
        J = a("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, q0.a);
        Boolean bool = Boolean.FALSE;
        K = a("measurement.test.boolean_flag", bool, bool, t0.a);
        L = a("measurement.test.string_flag", "---", "---", s0.a);
        M = a("measurement.test.long_flag", -1L, -1L, v0.a);
        N = a("measurement.test.int_flag", -2, -2, u0.a);
        Double dValueOf = Double.valueOf(-3.0d);
        O = a("measurement.test.double_flag", dValueOf, dValueOf, x0.a);
        P = a("measurement.experiment.max_ids", 50, 50, w0.a);
        Q = a("measurement.max_bundles_per_iteration", 100, 100, a1.a);
        R = a("measurement.validation.internal_limits_internal_event_params", bool, bool, z0.a);
        Boolean bool2 = Boolean.TRUE;
        S = a("measurement.collection.firebase_global_collection_flag_enabled", bool2, bool2, b1.a);
        T = a("measurement.collection.efficient_engagement_reporting_enabled_2", bool2, bool2, e1.a);
        U = a("measurement.collection.redundant_engagement_removal_enabled", bool, bool, d1.a);
        V = a("measurement.client.freeride_engagement_fix", bool2, bool2, g1.a);
        W = a("measurement.collection.log_event_and_bundle_v2", bool2, bool2, f1.a);
        X = a("measurement.quality.checksum", bool, bool, null);
        Y = a("measurement.sdk.dynamite.allow_remote_dynamite3", bool2, bool2, i1.a);
        Z = a("measurement.sdk.collection.validate_param_names_alphabetical", bool2, bool2, h1.a);
        f1551a0 = a("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, bool, k1.a);
        f1553b0 = a("measurement.audience.refresh_event_count_filters_timestamp", bool, bool, j1.a);
        f1554c0 = a("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, bool, m1.a);
        f1555d0 = a("measurement.sdk.collection.retrieve_deeplink_from_bow_2", bool2, bool2, o1.a);
        f1556e0 = a("measurement.sdk.collection.last_deep_link_referrer2", bool2, bool2, n1.a);
        f1557f0 = a("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, bool, q1.a);
        f1558g0 = a("measurement.sdk.collection.last_gclid_from_referrer2", bool, bool, p1.a);
        f1559h0 = a("measurement.sdk.collection.enable_extend_user_property_size", bool2, bool2, s1.a);
        f1560i0 = a("measurement.upload.file_lock_state_check", bool, bool, r1.a);
        f1561j0 = a("measurement.ga.ga_app_id", bool, bool, u1.a);
        k0 = a("measurement.lifecycle.app_in_background_parameter", bool, bool, t1.a);
        l0 = a("measurement.integration.disable_firebase_instance_id", bool, bool, w1.a);
        m0 = a("measurement.lifecycle.app_backgrounded_engagement", bool, bool, v1.a);
        n0 = a("measurement.collection.service.update_with_analytics_fix", bool, bool, x1.a);
        o0 = a("measurement.service.use_appinfo_modified", bool, bool, b2.a);
        p0 = a("measurement.client.firebase_feature_rollout.v1.enable", bool2, bool2, a2.a);
        q0 = a("measurement.client.sessions.check_on_reset_and_enable2", bool2, bool2, d2.a);
        r0 = a("measurement.scheduler.task_thread.cleanup_on_exit", bool, bool, c2.a);
        s0 = a("measurement.upload.file_truncate_fix", bool, bool, f2.a);
        t0 = a("measurement.sdk.referrer.delayed_install_referrer_api", bool, bool, e2.a);
        u0 = a("measurement.sdk.screen.disabling_automatic_reporting", bool2, bool2, h2.a);
        v0 = a("measurement.sdk.screen.manual_screen_view_logging", bool2, bool2, g2.a);
        a("measurement.collection.synthetic_data_mitigation", bool, bool, j2.a);
        w0 = a("measurement.service.configurable_service_limits", bool2, bool2, l2.a);
        x0 = a("measurement.client.configurable_service_limits", bool2, bool2, k2.a);
        y0 = a("measurement.androidId.delete_feature", bool2, bool2, n2.a);
        z0 = a("measurement.client.global_params", bool2, bool2, m2.a);
        A0 = a("measurement.service.global_params", bool2, bool2, p2.a);
        B0 = a("measurement.service.global_params_in_payload", bool2, bool2, o2.a);
        C0 = a("measurement.client.string_reader", bool2, bool2, r2.a);
        D0 = a("measurement.sdk.attribution.cache", bool2, bool2, q2.a);
        E0 = a("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, t2.a);
        F0 = a("measurement.service.database_return_empty_collection", bool2, bool2, s2.a);
        G0 = a("measurement.service.ssaid_removal", bool2, bool2, u2.a);
        H0 = a("measurement.client.consent_state_v1", bool2, bool2, x2.a);
        I0 = a("measurement.client.3p_consent_state_v1", bool2, bool2, w2.a);
        Boolean bool3 = Boolean.FALSE;
        J0 = a("measurement.service.consent_state_v1_W36", bool3, bool3, z2.a);
        K0 = a("measurement.service.storage_consent_support_version", 203590, 203590, y2.a);
        L0 = a("measurement.client.ad_impression", bool2, bool2, c3.a);
        M0 = a("measurement.service.ad_impression", bool2, bool2, b3.a);
        N0 = a("measurement.service.separate_public_internal_event_blacklisting", bool2, bool2, e3.a);
        O0 = a("measurement.service.directly_maybe_log_error_events", bool3, bool3, d3.a);
    }

    public static <V> j3<V> a(@Nullable String str, @Nullable V v2, @Nullable V v3, @Nullable h3<V> h3Var) {
        j3<V> j3Var = new j3<>(str, v2, v3, h3Var, null);
        a.add(j3Var);
        return j3Var;
    }
}
