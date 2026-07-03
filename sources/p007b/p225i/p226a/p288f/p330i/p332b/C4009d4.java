package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.discord.stores.StoreGuildScheduledEvents;

/* JADX INFO: renamed from: b.i.a.f.i.b.d4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4009d4 extends AbstractC4170r5 {

    /* JADX INFO: renamed from: c */
    public static final Pair<String, Long> f10629c = new Pair<>("", 0L);

    /* JADX INFO: renamed from: A */
    public final C4081j4 f10630A;

    /* JADX INFO: renamed from: B */
    public final C4081j4 f10631B;

    /* JADX INFO: renamed from: C */
    public final C4057h4 f10632C;

    /* JADX INFO: renamed from: D */
    public final C4069i4 f10633D;

    /* JADX INFO: renamed from: d */
    public SharedPreferences f10634d;

    /* JADX INFO: renamed from: e */
    public C4092k4 f10635e;

    /* JADX INFO: renamed from: f */
    public final C4057h4 f10636f;

    /* JADX INFO: renamed from: g */
    public final C4057h4 f10637g;

    /* JADX INFO: renamed from: h */
    public final C4057h4 f10638h;

    /* JADX INFO: renamed from: i */
    public final C4057h4 f10639i;

    /* JADX INFO: renamed from: j */
    public final C4057h4 f10640j;

    /* JADX INFO: renamed from: k */
    public final C4057h4 f10641k;

    /* JADX INFO: renamed from: l */
    public final C4057h4 f10642l;

    /* JADX INFO: renamed from: m */
    public final C4081j4 f10643m;

    /* JADX INFO: renamed from: n */
    public String f10644n;

    /* JADX INFO: renamed from: o */
    public boolean f10645o;

    /* JADX INFO: renamed from: p */
    public long f10646p;

    /* JADX INFO: renamed from: q */
    public final C4057h4 f10647q;

    /* JADX INFO: renamed from: r */
    public final C4057h4 f10648r;

    /* JADX INFO: renamed from: s */
    public final C4033f4 f10649s;

    /* JADX INFO: renamed from: t */
    public final C4081j4 f10650t;

    /* JADX INFO: renamed from: u */
    public final C4033f4 f10651u;

    /* JADX INFO: renamed from: v */
    public final C4057h4 f10652v;

    /* JADX INFO: renamed from: w */
    public boolean f10653w;

    /* JADX INFO: renamed from: x */
    public C4033f4 f10654x;

    /* JADX INFO: renamed from: y */
    public C4033f4 f10655y;

    /* JADX INFO: renamed from: z */
    public C4057h4 f10656z;

    public C4009d4(C4202u4 c4202u4) {
        super(c4202u4);
        this.f10636f = new C4057h4(this, "last_upload", 0L);
        this.f10637g = new C4057h4(this, "last_upload_attempt", 0L);
        this.f10638h = new C4057h4(this, "backoff", 0L);
        this.f10639i = new C4057h4(this, "last_delete_stale", 0L);
        this.f10647q = new C4057h4(this, "time_before_start", 10000L);
        this.f10648r = new C4057h4(this, "session_timeout", StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD);
        this.f10649s = new C4033f4(this, "start_new_session", true);
        this.f10652v = new C4057h4(this, "last_pause_time", 0L);
        this.f10650t = new C4081j4(this, "non_personalized_ads");
        this.f10651u = new C4033f4(this, "allow_remote_dynamite", false);
        this.f10640j = new C4057h4(this, "midnight_offset", 0L);
        this.f10641k = new C4057h4(this, "first_open_time", 0L);
        this.f10642l = new C4057h4(this, "app_install_time", 0L);
        this.f10643m = new C4081j4(this, "app_instance_id");
        this.f10654x = new C4033f4(this, "app_backgrounded", false);
        this.f10655y = new C4033f4(this, "deep_link_retrieval_complete", false);
        this.f10656z = new C4057h4(this, "deep_link_retrieval_attempts", 0L);
        this.f10630A = new C4081j4(this, "firebase_feature_rollouts");
        this.f10631B = new C4081j4(this, "deferred_attribution_cache");
        this.f10632C = new C4057h4(this, "deferred_attribution_cache_timestamp", 0L);
        this.f10633D = new C4069i4(this, "default_event_parameters");
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4170r5
    @WorkerThread
    /* JADX INFO: renamed from: m */
    public final void mo5573m() {
        SharedPreferences sharedPreferences = this.f11202a.f11254b.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f10634d = sharedPreferences;
        boolean z2 = sharedPreferences.getBoolean("has_been_opened", false);
        this.f10653w = z2;
        if (!z2) {
            SharedPreferences.Editor editorEdit = this.f10634d.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        this.f10635e = new C4092k4(this, "health_monitor", Math.max(0L, C4142p.f11065c.m5693a(null).longValue()), null);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4170r5
    /* JADX INFO: renamed from: r */
    public final boolean mo5574r() {
        return true;
    }

    @WorkerThread
    /* JADX INFO: renamed from: s */
    public final void m5575s(Boolean bool) {
        mo5848b();
        SharedPreferences.Editor editorEdit = m5579w().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
    }

    @WorkerThread
    /* JADX INFO: renamed from: t */
    public final boolean m5576t(int i) {
        return C4004d.m5565e(i, m5579w().getInt("consent_source", 100));
    }

    /* JADX INFO: renamed from: u */
    public final boolean m5577u(long j) {
        return j - this.f10648r.m5648a() > this.f10652v.m5648a();
    }

    @WorkerThread
    /* JADX INFO: renamed from: v */
    public final void m5578v(boolean z2) {
        mo5848b();
        mo5726g().f11149n.m5861b("App measurement setting deferred collection", Boolean.valueOf(z2));
        SharedPreferences.Editor editorEdit = m5579w().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z2);
        editorEdit.apply();
    }

    @WorkerThread
    /* JADX INFO: renamed from: w */
    public final SharedPreferences m5579w() {
        mo5848b();
        m5857o();
        return this.f10634d;
    }

    @WorkerThread
    /* JADX INFO: renamed from: x */
    public final Boolean m5580x() {
        mo5848b();
        if (m5579w().contains("measurement_enabled")) {
            return Boolean.valueOf(m5579w().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    @WorkerThread
    /* JADX INFO: renamed from: y */
    public final C4004d m5581y() {
        mo5848b();
        return C4004d.m5563b(m5579w().getString("consent_settings", "G1"));
    }
}
