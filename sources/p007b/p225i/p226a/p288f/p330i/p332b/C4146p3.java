package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.WorkerThread;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.f.i.b.p3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4146p3 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C4113m3 f11116j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4146p3(C4113m3 c4113m3, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f11116j = c4113m3;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @WorkerThread
    public final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e) {
            throw e;
        } catch (SQLiteException unused) {
            this.f11116j.mo5726g().f11141f.m5860a("Opening the local database failed, dropping and recreating it");
            if (!this.f11116j.f11202a.f11254b.getDatabasePath("google_app_measurement_local.db").delete()) {
                this.f11116j.mo5726g().f11141f.m5861b("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e2) {
                this.f11116j.mo5726g().f11141f.m5861b("Failed to open local database. Events will bypass local storage", e2);
                return null;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @WorkerThread
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        C3404f.m4290f2(this.f11116j.mo5726g(), sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @WorkerThread
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @WorkerThread
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        C3404f.m4294g2(this.f11116j.mo5726g(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @WorkerThread
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
