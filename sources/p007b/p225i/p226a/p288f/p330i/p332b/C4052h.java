package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.f.i.b.h */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4052h extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C4040g f10762j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4052h(C4040g c4040g, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f10762j = c4040g;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0022  */
    @Override // android.database.sqlite.SQLiteOpenHelper
    @WorkerThread
    public final SQLiteDatabase getWritableDatabase() {
        boolean z2;
        C4026e9 c4026e9 = this.f10762j.f10744m;
        if (c4026e9.f10697b == 0) {
            z2 = true;
        } else {
            Objects.requireNonNull((C3401c) c4026e9.f10696a);
            if (SystemClock.elapsedRealtime() - c4026e9.f10697b >= 3600000) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (!z2) {
            throw new SQLiteException("Database open failed");
        }
        try {
            return super.getWritableDatabase();
        } catch (SQLiteException unused) {
            C4026e9 c4026e10 = this.f10762j.f10744m;
            Objects.requireNonNull((C3401c) c4026e10.f10696a);
            c4026e10.f10697b = SystemClock.elapsedRealtime();
            this.f10762j.mo5726g().f11141f.m5860a("Opening the database failed, dropping and recreating it");
            if (!this.f10762j.f11202a.f11254b.getDatabasePath("google_app_measurement.db").delete()) {
                this.f10762j.mo5726g().f11141f.m5861b("Failed to delete corrupted db file", "google_app_measurement.db");
            }
            try {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                this.f10762j.f10744m.f10697b = 0L;
                return writableDatabase;
            } catch (SQLiteException e) {
                this.f10762j.mo5726g().f11141f.m5861b("Failed to open freshly created database", e);
                throw e;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @WorkerThread
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        C3404f.m4290f2(this.f10762j.mo5726g(), sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @WorkerThread
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @WorkerThread
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        C3404f.m4294g2(this.f10762j.mo5726g(), sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", C4040g.f10735d);
        C3404f.m4294g2(this.f10762j.mo5726g(), sQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
        C3404f.m4294g2(this.f10762j.mo5726g(), sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", C4040g.f10736e);
        C3404f.m4294g2(this.f10762j.mo5726g(), sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", C4040g.f10737f);
        C3404f.m4294g2(this.f10762j.mo5726g(), sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", C4040g.f10739h);
        C3404f.m4294g2(this.f10762j.mo5726g(), sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
        C3404f.m4294g2(this.f10762j.mo5726g(), sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", C4040g.f10738g);
        C3404f.m4294g2(this.f10762j.mo5726g(), sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", C4040g.f10740i);
        C3404f.m4294g2(this.f10762j.mo5726g(), sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", C4040g.f10741j);
        C3404f.m4294g2(this.f10762j.mo5726g(), sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        C3404f.m4294g2(this.f10762j.mo5726g(), sQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", C4040g.f10742k);
        C3404f.m4294g2(this.f10762j.mo5726g(), sQLiteDatabase, "main_event_params", "CREATE TABLE IF NOT EXISTS main_event_params ( app_id TEXT NOT NULL, event_id TEXT NOT NULL, children_to_process INTEGER NOT NULL, main_event BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,event_id,children_to_process,main_event", null);
        C3404f.m4294g2(this.f10762j.mo5726g(), sQLiteDatabase, "default_event_params", "CREATE TABLE IF NOT EXISTS default_event_params ( app_id TEXT NOT NULL, parameters BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,parameters", null);
        C3404f.m4294g2(this.f10762j.mo5726g(), sQLiteDatabase, "consent_settings", "CREATE TABLE IF NOT EXISTS consent_settings ( app_id TEXT NOT NULL, consent_state TEXT NOT NULL, PRIMARY KEY (app_id));", "app_id,consent_state", null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @WorkerThread
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
