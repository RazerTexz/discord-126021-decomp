package b.i.a.f.i.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.discord.stores.StoreGuildScheduledEvents;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class d4 extends r5 {
    public static final Pair<String, Long> c = new Pair<>("", 0L);
    public final j4 A;
    public final j4 B;
    public final h4 C;
    public final i4 D;
    public SharedPreferences d;
    public k4 e;
    public final h4 f;
    public final h4 g;
    public final h4 h;
    public final h4 i;
    public final h4 j;
    public final h4 k;
    public final h4 l;
    public final j4 m;
    public String n;
    public boolean o;
    public long p;
    public final h4 q;
    public final h4 r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final f4 f1524s;
    public final j4 t;
    public final f4 u;
    public final h4 v;
    public boolean w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public f4 f1525x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public f4 f1526y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public h4 f1527z;

    public d4(u4 u4Var) {
        super(u4Var);
        this.f = new h4(this, "last_upload", 0L);
        this.g = new h4(this, "last_upload_attempt", 0L);
        this.h = new h4(this, "backoff", 0L);
        this.i = new h4(this, "last_delete_stale", 0L);
        this.q = new h4(this, "time_before_start", 10000L);
        this.r = new h4(this, "session_timeout", StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD);
        this.f1524s = new f4(this, "start_new_session", true);
        this.v = new h4(this, "last_pause_time", 0L);
        this.t = new j4(this, "non_personalized_ads");
        this.u = new f4(this, "allow_remote_dynamite", false);
        this.j = new h4(this, "midnight_offset", 0L);
        this.k = new h4(this, "first_open_time", 0L);
        this.l = new h4(this, "app_install_time", 0L);
        this.m = new j4(this, "app_instance_id");
        this.f1525x = new f4(this, "app_backgrounded", false);
        this.f1526y = new f4(this, "deep_link_retrieval_complete", false);
        this.f1527z = new h4(this, "deep_link_retrieval_attempts", 0L);
        this.A = new j4(this, "firebase_feature_rollouts");
        this.B = new j4(this, "deferred_attribution_cache");
        this.C = new h4(this, "deferred_attribution_cache_timestamp", 0L);
        this.D = new i4(this, "default_event_parameters");
    }

    @Override // b.i.a.f.i.b.r5
    @WorkerThread
    public final void m() {
        SharedPreferences sharedPreferences = this.a.f1570b.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.d = sharedPreferences;
        boolean z2 = sharedPreferences.getBoolean("has_been_opened", false);
        this.w = z2;
        if (!z2) {
            SharedPreferences$Editor sharedPreferences$EditorEdit = this.d.edit();
            sharedPreferences$EditorEdit.putBoolean("has_been_opened", true);
            sharedPreferences$EditorEdit.apply();
        }
        this.e = new k4(this, "health_monitor", Math.max(0L, p.c.a(null).longValue()), null);
    }

    @Override // b.i.a.f.i.b.r5
    public final boolean r() {
        return true;
    }

    @WorkerThread
    public final void s(Boolean bool) {
        b();
        SharedPreferences$Editor sharedPreferences$EditorEdit = w().edit();
        if (bool != null) {
            sharedPreferences$EditorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            sharedPreferences$EditorEdit.remove("measurement_enabled");
        }
        sharedPreferences$EditorEdit.apply();
    }

    @WorkerThread
    public final boolean t(int i) {
        return d.e(i, w().getInt("consent_source", 100));
    }

    public final boolean u(long j) {
        return j - this.r.a() > this.v.a();
    }

    @WorkerThread
    public final void v(boolean z2) {
        b();
        g().n.b("App measurement setting deferred collection", Boolean.valueOf(z2));
        SharedPreferences$Editor sharedPreferences$EditorEdit = w().edit();
        sharedPreferences$EditorEdit.putBoolean("deferred_analytics_collection", z2);
        sharedPreferences$EditorEdit.apply();
    }

    @WorkerThread
    public final SharedPreferences w() {
        b();
        o();
        return this.d;
    }

    @WorkerThread
    public final Boolean x() {
        b();
        if (w().contains("measurement_enabled")) {
            return Boolean.valueOf(w().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    @WorkerThread
    public final d y() {
        b();
        return d.b(w().getString("consent_settings", "G1"));
    }
}
