package b.i.a.f.i.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import b.i.a.f.h.l.a1$a;
import b.i.a.f.h.l.e1$a;
import b.i.a.f.h.l.l0$a;
import b.i.a.f.h.l.o0$a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends i9 {
    public static final String[] d = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    public static final String[] e = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    public static final String[] f = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    public static final String[] g = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    public static final String[] h = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    public static final String[] i = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] j = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] k = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    public final h l;
    public final e9 m;

    public g(k9 k9Var) {
        super(k9Var);
        this.m = new e9(this.a.o);
        this.l = new h(this, this.a.f1570b, "google_app_measurement.db");
    }

    @WorkerThread
    public static void G(ContentValues contentValues, String str, Object obj) {
        b.c.a.a0.d.w(str);
        Objects.requireNonNull(obj, "null reference");
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put(str, (Double) obj);
        }
    }

    @WorkerThread
    public final Object A(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        if (type == 0) {
            g().f.a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i2));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i2));
        }
        if (type == 3) {
            return cursor.getString(i2);
        }
        if (type != 4) {
            g().f.b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        g().f.a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0053  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r5v0, types: [long] */
    public final String B(long j2) throws Throwable {
        Cursor cursorRawQuery;
        b();
        n();
        ?? r0 = 0;
        try {
            try {
                cursorRawQuery = t().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf((long) j2)});
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        String string = cursorRawQuery.getString(0);
                        cursorRawQuery.close();
                        return string;
                    }
                    g().n.a("No expired configs for apps with pending events");
                    cursorRawQuery.close();
                    return null;
                } catch (SQLiteException e2) {
                    e = e2;
                    g().f.b("Error selecting expired configs", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r0 = j2;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r0 != 0) {
                r0.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00b5  */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00b2: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:37:0x00b2 */
    @WorkerThread
    public final List<u9> C(String str) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        b.c.a.a0.d.w(str);
        b();
        n();
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = t().query("user_attributes", new String[]{ModelAuditLogEntry.CHANGE_KEY_NAME, "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return arrayList;
                    }
                    do {
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str2 = string2;
                        long j2 = cursorQuery.getLong(2);
                        Object objA = A(cursorQuery, 3);
                        if (objA == null) {
                            g().f.b("Read invalid user property value, ignoring it. appId", q3.s(str));
                        } else {
                            arrayList.add(new u9(str, str2, string, j2, objA));
                        }
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    return arrayList;
                } catch (SQLiteException e2) {
                    e = e2;
                    g().f.c("Error querying user properties. appId", q3.s(str), e);
                    if (!b.i.a.f.h.l.l9.b() || !this.a.h.u(str, p.F0)) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    List<u9> listEmptyList = Collections.emptyList();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return listEmptyList;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final List<Pair<b.i.a.f.h.l.e1, Long>> D(String str, int i2, int i3) {
        b();
        n();
        b.c.a.a0.d.l(i2 > 0);
        b.c.a.a0.d.l(i3 > 0);
        b.c.a.a0.d.w(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = t().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i2));
                if (!cursorQuery.moveToFirst()) {
                    List<Pair<b.i.a.f.h.l.e1, Long>> listEmptyList = Collections.emptyList();
                    cursorQuery.close();
                    return listEmptyList;
                }
                ArrayList arrayList = new ArrayList();
                int length = 0;
                do {
                    long j2 = cursorQuery.getLong(0);
                    try {
                        byte[] bArrS = m().S(cursorQuery.getBlob(1));
                        if (!arrayList.isEmpty() && bArrS.length + length > i3) {
                            break;
                        }
                        try {
                            e1$a e1_a = (e1$a) q9.x(b.i.a.f.h.l.e1.u0(), bArrS);
                            if (!cursorQuery.isNull(2)) {
                                int i4 = cursorQuery.getInt(2);
                                if (e1_a.l) {
                                    e1_a.n();
                                    e1_a.l = false;
                                }
                                b.i.a.f.h.l.e1.V0((b.i.a.f.h.l.e1) e1_a.k, i4);
                            }
                            length += bArrS.length;
                            arrayList.add(Pair.create((b.i.a.f.h.l.e1) ((b.i.a.f.h.l.u4) e1_a.p()), Long.valueOf(j2)));
                        } catch (IOException e2) {
                            g().f.c("Failed to merge queued bundle. appId", q3.s(str), e2);
                        }
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                    } catch (IOException e3) {
                        g().f.c("Failed to unzip queued bundle. appId", q3.s(str), e3);
                    }
                } while (length <= i3);
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e4) {
                g().f.c("Error querying bundles. appId", q3.s(str), e4);
                List<Pair<b.i.a.f.h.l.e1, Long>> listEmptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return listEmptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0123  */
    @WorkerThread
    public final List<u9> E(String str, String str2, String str3) throws Throwable {
        String str4;
        Cursor cursorQuery;
        b.c.a.a0.d.w(str);
        b();
        n();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                ArrayList arrayList2 = new ArrayList(3);
                arrayList2.add(str);
                StringBuilder sb = new StringBuilder("app_id=?");
                if (TextUtils.isEmpty(str2)) {
                    str4 = str2;
                } else {
                    str4 = str2;
                    try {
                        arrayList2.add(str4);
                        sb.append(" and origin=?");
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursorQuery = null;
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    arrayList2.add(String.valueOf(str3).concat("*"));
                    sb.append(" and name glob ?");
                }
                cursorQuery = t().query("user_attributes", new String[]{ModelAuditLogEntry.CHANGE_KEY_NAME, "set_timestamp", "value", "origin"}, sb.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), null, null, "rowid", "1001");
                try {
                    try {
                        if (!cursorQuery.moveToFirst()) {
                            cursorQuery.close();
                            return arrayList;
                        }
                        while (arrayList.size() < 1000) {
                            String string = cursorQuery.getString(0);
                            long j2 = cursorQuery.getLong(1);
                            Object objA = A(cursorQuery, 2);
                            String string2 = cursorQuery.getString(3);
                            if (objA == null) {
                                try {
                                    g().f.d("(2)Read invalid user property value, ignoring it", q3.s(str), string2, str3);
                                } catch (SQLiteException e3) {
                                    e = e3;
                                    str4 = string2;
                                }
                            } else {
                                arrayList.add(new u9(str, string2, string, j2, objA));
                            }
                            if (!cursorQuery.moveToNext()) {
                                cursorQuery.close();
                                return arrayList;
                            }
                            str4 = string2;
                        }
                        g().f.b("Read more than the max allowed user properties, ignoring excess", 1000);
                        cursorQuery.close();
                        return arrayList;
                    } catch (SQLiteException e4) {
                        e = e4;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e5) {
                e = e5;
                str4 = str2;
            }
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        g().f.d("(2)Error querying user properties", q3.s(str), str4, e);
        if (!b.i.a.f.h.l.l9.b() || !this.a.h.u(str, p.F0)) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        }
        List<u9> listEmptyList = Collections.emptyList();
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return listEmptyList;
    }

    public final List<zzz> F(String str, String[] strArr) {
        b();
        n();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = t().query("conditional_properties", new String[]{"app_id", "origin", ModelAuditLogEntry.CHANGE_KEY_NAME, "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                while (arrayList.size() < 1000) {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    String string3 = cursorQuery.getString(2);
                    Object objA = A(cursorQuery, 3);
                    boolean z2 = cursorQuery.getInt(4) != 0;
                    String string4 = cursorQuery.getString(5);
                    long j2 = cursorQuery.getLong(6);
                    q9 q9VarM = m();
                    byte[] blob = cursorQuery.getBlob(7);
                    Parcelable$Creator<zzaq> parcelable$Creator = zzaq.CREATOR;
                    zzaq zzaqVar = (zzaq) q9VarM.u(blob, parcelable$Creator);
                    arrayList.add(new zzz(string, string2, new zzku(string3, cursorQuery.getLong(10), objA, string2), cursorQuery.getLong(8), z2, string4, zzaqVar, j2, (zzaq) m().u(cursorQuery.getBlob(9), parcelable$Creator), cursorQuery.getLong(11), (zzaq) m().u(cursorQuery.getBlob(12), parcelable$Creator)));
                    if (!cursorQuery.moveToNext()) {
                        cursorQuery.close();
                        return arrayList;
                    }
                }
                g().f.b("Read more than the max allowed conditional properties, ignoring extra", 1000);
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e2) {
                g().f.b("Error querying conditional user property value", e2);
                List<zzz> listEmptyList = Collections.emptyList();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return listEmptyList;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final void H(l lVar) {
        Objects.requireNonNull(lVar, "null reference");
        b();
        n();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", lVar.a);
        contentValues.put(ModelAuditLogEntry.CHANGE_KEY_NAME, lVar.f1548b);
        contentValues.put("lifetime_count", Long.valueOf(lVar.c));
        contentValues.put("current_bundle_count", Long.valueOf(lVar.d));
        contentValues.put("last_fire_timestamp", Long.valueOf(lVar.f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(lVar.g));
        contentValues.put("last_bundled_day", lVar.h);
        contentValues.put("last_sampled_complex_event_id", lVar.i);
        contentValues.put("last_sampling_rate", lVar.j);
        contentValues.put("current_session_count", Long.valueOf(lVar.e));
        Boolean bool = lVar.k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (t().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                g().f.b("Failed to insert/update event aggregates (got -1). appId", q3.s(lVar.a));
            }
        } catch (SQLiteException e2) {
            g().f.c("Error storing event aggregates. appId", q3.s(lVar.a), e2);
        }
    }

    @WorkerThread
    public final void I(a4 a4Var) {
        b();
        n();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", a4Var.o());
        contentValues.put("app_instance_id", a4Var.s());
        contentValues.put("gmp_app_id", a4Var.v());
        contentValues.put("resettable_device_id_hash", a4Var.E());
        contentValues.put("last_bundle_index", Long.valueOf(a4Var.U()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(a4Var.K()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(a4Var.L()));
        contentValues.put("app_version", a4Var.M());
        contentValues.put("app_store", a4Var.O());
        contentValues.put("gmp_version", Long.valueOf(a4Var.P()));
        contentValues.put("dev_cert_hash", Long.valueOf(a4Var.Q()));
        contentValues.put("measurement_enabled", Boolean.valueOf(a4Var.T()));
        a4Var.a.f().b();
        contentValues.put("day", Long.valueOf(a4Var.f1515x));
        a4Var.a.f().b();
        contentValues.put("daily_public_events_count", Long.valueOf(a4Var.f1516y));
        a4Var.a.f().b();
        contentValues.put("daily_events_count", Long.valueOf(a4Var.f1517z));
        a4Var.a.f().b();
        contentValues.put("daily_conversions_count", Long.valueOf(a4Var.A));
        a4Var.a.f().b();
        contentValues.put("config_fetched_time", Long.valueOf(a4Var.F));
        a4Var.a.f().b();
        contentValues.put("failed_config_fetch_time", Long.valueOf(a4Var.G));
        contentValues.put("app_version_int", Long.valueOf(a4Var.N()));
        contentValues.put("firebase_instance_id", a4Var.H());
        a4Var.a.f().b();
        contentValues.put("daily_error_events_count", Long.valueOf(a4Var.B));
        a4Var.a.f().b();
        contentValues.put("daily_realtime_events_count", Long.valueOf(a4Var.C));
        a4Var.a.f().b();
        contentValues.put("health_monitor_sample", a4Var.D);
        contentValues.put("android_id", Long.valueOf(a4Var.g()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(a4Var.h()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(a4Var.i()));
        contentValues.put("admob_app_id", a4Var.y());
        contentValues.put("dynamite_version", Long.valueOf(a4Var.S()));
        if (a4Var.k() != null) {
            if (a4Var.k().size() == 0) {
                g().i.b("Safelisted events should not be an empty list. appId", a4Var.o());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", a4Var.k()));
            }
        }
        if (b.i.a.f.h.l.da.b() && this.a.h.u(a4Var.o(), p.f1561j0)) {
            contentValues.put("ga_app_id", a4Var.B());
        }
        try {
            SQLiteDatabase sQLiteDatabaseT = t();
            if (sQLiteDatabaseT.update("apps", contentValues, "app_id = ?", new String[]{a4Var.o()}) == 0 && sQLiteDatabaseT.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                g().f.b("Failed to insert/update app (got -1). appId", q3.s(a4Var.o()));
            }
        } catch (SQLiteException e2) {
            g().f.c("Error storing app. appId", q3.s(a4Var.o()), e2);
        }
    }

    @WorkerThread
    public final void J(List<Long> list) {
        b();
        n();
        Objects.requireNonNull(list, "null reference");
        if (list.size() == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        }
        if (R()) {
            String strJoin = TextUtils.join(",", list);
            String strK = b.d.b.a.a.k(b.d.b.a.a.b(strJoin, 2), "(", strJoin, ")");
            if (S(b.d.b.a.a.k(b.d.b.a.a.b(strK, 80), "SELECT COUNT(1) FROM queue WHERE rowid IN ", strK, " AND retry_count =  2147483647 LIMIT 1"), null) > 0) {
                g().i.a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseT = t();
                StringBuilder sb = new StringBuilder(String.valueOf(strK).length() + Opcodes.LAND);
                sb.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb.append(strK);
                sb.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                sQLiteDatabaseT.execSQL(sb.toString());
            } catch (SQLiteException e2) {
                g().f.b("Error incrementing retry count. error", e2);
            }
        }
    }

    @WorkerThread
    public final boolean K(b.i.a.f.h.l.e1 e1Var, boolean z2) {
        b();
        n();
        b.c.a.a0.d.w(e1Var.G1());
        b.c.a.a0.d.F(e1Var.n1());
        i0();
        Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (e1Var.o1() < jCurrentTimeMillis - c.B() || e1Var.o1() > c.B() + jCurrentTimeMillis) {
            g().i.d("Storing bundle outside of the max uploading time span. appId, now, timestamp", q3.s(e1Var.G1()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(e1Var.o1()));
        }
        try {
            byte[] bArrT = m().T(e1Var.d());
            g().n.b("Saving bundle, size", Integer.valueOf(bArrT.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", e1Var.G1());
            contentValues.put("bundle_end_timestamp", Long.valueOf(e1Var.o1()));
            contentValues.put("data", bArrT);
            contentValues.put("has_realtime", Integer.valueOf(z2 ? 1 : 0));
            if (e1Var.f0()) {
                contentValues.put("retry_count", Integer.valueOf(e1Var.n0()));
            }
            try {
                if (t().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                g().f.b("Failed to insert bundle (got -1). appId", q3.s(e1Var.G1()));
                return false;
            } catch (SQLiteException e2) {
                g().f.c("Error storing bundle. appId", q3.s(e1Var.G1()), e2);
                return false;
            }
        } catch (IOException e3) {
            g().f.c("Data loss. Failed to serialize bundle. appId", q3.s(e1Var.G1()), e3);
            return false;
        }
    }

    public final boolean L(m mVar, long j2, boolean z2) {
        b();
        n();
        b.c.a.a0.d.w(mVar.a);
        byte[] bArrD = m().v(mVar).d();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", mVar.a);
        contentValues.put(ModelAuditLogEntry.CHANGE_KEY_NAME, mVar.f1549b);
        contentValues.put("timestamp", Long.valueOf(mVar.d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j2));
        contentValues.put("data", bArrD);
        contentValues.put("realtime", Integer.valueOf(z2 ? 1 : 0));
        try {
            if (t().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            g().f.b("Failed to insert raw event (got -1). appId", q3.s(mVar.a));
            return false;
        } catch (SQLiteException e2) {
            g().f.c("Error storing raw event. appId", q3.s(mVar.a), e2);
            return false;
        }
    }

    @WorkerThread
    public final boolean M(u9 u9Var) {
        b();
        n();
        if (Y(u9Var.a, u9Var.c) == null) {
            if (t9.X(u9Var.c)) {
                long jS = S("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{u9Var.a});
                c cVar = this.a.h;
                String str = u9Var.a;
                Objects.requireNonNull(cVar);
                int iMax = 25;
                if (b.i.a.f.h.l.o8.b() && cVar.u(null, p.w0)) {
                    iMax = Math.max(Math.min(cVar.q(str, p.G), 100), 25);
                }
                if (jS >= iMax) {
                    return false;
                }
            } else if (!"_npa".equals(u9Var.c) && S("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{u9Var.a, u9Var.f1576b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", u9Var.a);
        contentValues.put("origin", u9Var.f1576b);
        contentValues.put(ModelAuditLogEntry.CHANGE_KEY_NAME, u9Var.c);
        contentValues.put("set_timestamp", Long.valueOf(u9Var.d));
        G(contentValues, "value", u9Var.e);
        try {
            if (t().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                g().f.b("Failed to insert/update user property (got -1). appId", q3.s(u9Var.a));
            }
        } catch (SQLiteException e2) {
            g().f.c("Error storing user property. appId", q3.s(u9Var.a), e2);
        }
        return true;
    }

    @WorkerThread
    public final boolean N(zzz zzzVar) {
        b();
        n();
        if (Y(zzzVar.j, zzzVar.l.k) == null && S("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzzVar.j}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzzVar.j);
        contentValues.put("origin", zzzVar.k);
        contentValues.put(ModelAuditLogEntry.CHANGE_KEY_NAME, zzzVar.l.k);
        G(contentValues, "value", zzzVar.l.w0());
        contentValues.put("active", Boolean.valueOf(zzzVar.n));
        contentValues.put("trigger_event_name", zzzVar.o);
        contentValues.put("trigger_timeout", Long.valueOf(zzzVar.q));
        e();
        contentValues.put("timed_out_event", t9.g0(zzzVar.p));
        contentValues.put("creation_timestamp", Long.valueOf(zzzVar.m));
        e();
        contentValues.put("triggered_event", t9.g0(zzzVar.r));
        contentValues.put("triggered_timestamp", Long.valueOf(zzzVar.l.l));
        contentValues.put("time_to_live", Long.valueOf(zzzVar.f3016s));
        e();
        contentValues.put("expired_event", t9.g0(zzzVar.t));
        try {
            if (t().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                g().f.b("Failed to insert/update conditional user property (got -1)", q3.s(zzzVar.j));
            }
        } catch (SQLiteException e2) {
            g().f.c("Error storing conditional user property", q3.s(zzzVar.j), e2);
        }
        return true;
    }

    @WorkerThread
    public final boolean O(String str, int i2, b.i.a.f.h.l.l0 l0Var) {
        n();
        b();
        b.c.a.a0.d.w(str);
        Objects.requireNonNull(l0Var, "null reference");
        if (TextUtils.isEmpty(l0Var.z())) {
            g().i.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", q3.s(str), Integer.valueOf(i2), String.valueOf(l0Var.x() ? Integer.valueOf(l0Var.y()) : null));
            return false;
        }
        byte[] bArrD = l0Var.d();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", l0Var.x() ? Integer.valueOf(l0Var.y()) : null);
        contentValues.put("event_name", l0Var.z());
        contentValues.put("session_scoped", l0Var.G() ? Boolean.valueOf(l0Var.H()) : null);
        contentValues.put("data", bArrD);
        try {
            if (t().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            g().f.b("Failed to insert event filter (got -1). appId", q3.s(str));
            return true;
        } catch (SQLiteException e2) {
            g().f.c("Error storing event filter. appId", q3.s(str), e2);
            return false;
        }
    }

    @WorkerThread
    public final boolean P(String str, int i2, b.i.a.f.h.l.o0 o0Var) {
        n();
        b();
        b.c.a.a0.d.w(str);
        Objects.requireNonNull(o0Var, "null reference");
        if (TextUtils.isEmpty(o0Var.x())) {
            g().i.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", q3.s(str), Integer.valueOf(i2), String.valueOf(o0Var.v() ? Integer.valueOf(o0Var.w()) : null));
            return false;
        }
        byte[] bArrD = o0Var.d();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", o0Var.v() ? Integer.valueOf(o0Var.w()) : null);
        contentValues.put("property_name", o0Var.x());
        contentValues.put("session_scoped", o0Var.B() ? Boolean.valueOf(o0Var.C()) : null);
        contentValues.put("data", bArrD);
        try {
            if (t().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            g().f.b("Failed to insert property filter (got -1). appId", q3.s(str));
            return false;
        } catch (SQLiteException e2) {
            g().f.c("Error storing property filter. appId", q3.s(str), e2);
            return false;
        }
    }

    public final boolean Q(String str, Long l, long j2, b.i.a.f.h.l.a1 a1Var) {
        b();
        n();
        Objects.requireNonNull(a1Var, "null reference");
        b.c.a.a0.d.w(str);
        Objects.requireNonNull(l, "null reference");
        byte[] bArrD = a1Var.d();
        g().n.c("Saving complex main event, appId, data size", d().u(str), Integer.valueOf(bArrD.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j2));
        contentValues.put("main_event", bArrD);
        try {
            if (t().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            g().f.b("Failed to insert complex main event (got -1). appId", q3.s(str));
            return false;
        } catch (SQLiteException e2) {
            g().f.c("Error storing complex main event. appId", q3.s(str), e2);
            return false;
        }
    }

    public final boolean R() {
        return this.a.f1570b.getDatabasePath("google_app_measurement.db").exists();
    }

    @WorkerThread
    public final long S(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = t().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j2 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j2;
            } catch (SQLiteException e2) {
                g().f.c("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final a4 T(String str) throws Throwable {
        Cursor cursorQuery;
        b.c.a.a0.d.w(str);
        b();
        n();
        Cursor cursor = null;
        try {
            boolean z2 = true;
            cursorQuery = t().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "ssaid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    a4 a4Var = new a4(this.f1538b.k, str);
                    a4Var.c(cursorQuery.getString(0));
                    a4Var.m(cursorQuery.getString(1));
                    a4Var.x(cursorQuery.getString(2));
                    a4Var.C(cursorQuery.getLong(3));
                    a4Var.a(cursorQuery.getLong(4));
                    a4Var.l(cursorQuery.getLong(5));
                    a4Var.D(cursorQuery.getString(6));
                    a4Var.G(cursorQuery.getString(7));
                    a4Var.t(cursorQuery.getLong(8));
                    a4Var.w(cursorQuery.getLong(9));
                    a4Var.e(cursorQuery.isNull(10) || cursorQuery.getInt(10) != 0);
                    long j2 = cursorQuery.getLong(11);
                    a4Var.a.f().b();
                    a4Var.E |= a4Var.f1515x != j2;
                    a4Var.f1515x = j2;
                    long j3 = cursorQuery.getLong(12);
                    a4Var.a.f().b();
                    a4Var.E |= a4Var.f1516y != j3;
                    a4Var.f1516y = j3;
                    long j4 = cursorQuery.getLong(13);
                    a4Var.a.f().b();
                    a4Var.E |= a4Var.f1517z != j4;
                    a4Var.f1517z = j4;
                    long j5 = cursorQuery.getLong(14);
                    a4Var.a.f().b();
                    a4Var.E |= a4Var.A != j5;
                    a4Var.A = j5;
                    a4Var.F(cursorQuery.getLong(15));
                    a4Var.I(cursorQuery.getLong(16));
                    a4Var.p(cursorQuery.isNull(17) ? -2147483648L : cursorQuery.getInt(17));
                    a4Var.A(cursorQuery.getString(18));
                    long j6 = cursorQuery.getLong(19);
                    a4Var.a.f().b();
                    a4Var.E |= a4Var.B != j6;
                    a4Var.B = j6;
                    long j7 = cursorQuery.getLong(20);
                    a4Var.a.f().b();
                    a4Var.E |= a4Var.C != j7;
                    a4Var.C = j7;
                    a4Var.J(cursorQuery.getString(21));
                    long j8 = 0;
                    if (!this.a.h.o(p.y0)) {
                        a4Var.R(cursorQuery.isNull(22) ? 0L : cursorQuery.getLong(22));
                    }
                    a4Var.n(cursorQuery.isNull(23) || cursorQuery.getInt(23) != 0);
                    if (!cursorQuery.isNull(24) && cursorQuery.getInt(24) == 0) {
                        z2 = false;
                    }
                    a4Var.r(z2);
                    a4Var.q(cursorQuery.getString(25));
                    if (!cursorQuery.isNull(26)) {
                        j8 = cursorQuery.getLong(26);
                    }
                    a4Var.z(j8);
                    if (!cursorQuery.isNull(27)) {
                        a4Var.d(Arrays.asList(cursorQuery.getString(27).split(",", -1)));
                    }
                    if (b.i.a.f.h.l.da.b() && this.a.h.u(str, p.f1561j0)) {
                        a4Var.u(cursorQuery.getString(28));
                    }
                    a4Var.a.f().b();
                    a4Var.E = false;
                    if (cursorQuery.moveToNext()) {
                        g().f.b("Got multiple records for app, expected one. appId", q3.s(str));
                    }
                    cursorQuery.close();
                    return a4Var;
                } catch (SQLiteException e2) {
                    e = e2;
                    g().f.c("Error querying app. appId", q3.s(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        th = th;
        cursor = cursorQuery;
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    @WorkerThread
    public final List<zzz> U(String str, String str2, String str3) {
        b.c.a.a0.d.w(str);
        b();
        n();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return F(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @WorkerThread
    public final void V(String str, String str2) {
        b.c.a.a0.d.w(str);
        b.c.a.a0.d.w(str2);
        b();
        n();
        try {
            t().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            g().f.d("Error deleting user property. appId", q3.s(str), d().y(str2), e2);
        }
    }

    public final boolean W(String str, List<Integer> list) {
        b.c.a.a0.d.w(str);
        n();
        b();
        SQLiteDatabase sQLiteDatabaseT = t();
        try {
            long jS = S("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, this.a.h.q(str, p.F)));
            if (jS <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Integer num = list.get(i2);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String strJoin = TextUtils.join(",", arrayList);
            String strK = b.d.b.a.a.k(b.d.b.a.a.b(strJoin, 2), "(", strJoin, ")");
            return sQLiteDatabaseT.delete("audience_filter_values", b.d.b.a.a.k(b.d.b.a.a.b(strK, Opcodes.F2L), "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ", strK, " order by rowid desc limit -1 offset ?)"), new String[]{str, Integer.toString(iMax)}) > 0;
        } catch (SQLiteException e2) {
            g().f.c("Database error querying filters. appId", q3.s(str), e2);
            return false;
        }
    }

    public final long X(String str) {
        b.c.a.a0.d.w(str);
        b();
        n();
        try {
            return t().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, this.a.h.q(str, p.p))))});
        } catch (SQLiteException e2) {
            g().f.c("Error deleting over the limit events. appId", q3.s(str), e2);
            return 0L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a1  */
    @WorkerThread
    public final u9 Y(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        b.c.a.a0.d.w(str);
        b.c.a.a0.d.w(str2);
        b();
        n();
        Cursor cursor = null;
        try {
            try {
                cursorQuery = t().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    try {
                        u9 u9Var = new u9(str, cursorQuery.getString(2), str2, cursorQuery.getLong(0), A(cursorQuery, 1));
                        if (cursorQuery.moveToNext()) {
                            g().f.b("Got multiple records for user property, expected one. appId", q3.s(str));
                        }
                        cursorQuery.close();
                        return u9Var;
                    } catch (SQLiteException e2) {
                        e = e2;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        g().f.d("Error querying user property. appId", q3.s(str), d().y(str2), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0119  */
    @WorkerThread
    public final zzz Z(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        b.c.a.a0.d.w(str);
        b.c.a.a0.d.w(str2);
        b();
        n();
        Cursor cursor = null;
        try {
            try {
                cursorQuery = t().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    String string = cursorQuery.getString(0);
                    try {
                        Object objA = A(cursorQuery, 1);
                        boolean z2 = cursorQuery.getInt(2) != 0;
                        String string2 = cursorQuery.getString(3);
                        long j2 = cursorQuery.getLong(4);
                        q9 q9VarM = m();
                        byte[] blob = cursorQuery.getBlob(5);
                        Parcelable$Creator<zzaq> parcelable$Creator = zzaq.CREATOR;
                        zzz zzzVar = new zzz(str, string, new zzku(str2, cursorQuery.getLong(8), objA, string), cursorQuery.getLong(6), z2, string2, (zzaq) q9VarM.u(blob, parcelable$Creator), j2, (zzaq) m().u(cursorQuery.getBlob(7), parcelable$Creator), cursorQuery.getLong(9), (zzaq) m().u(cursorQuery.getBlob(10), parcelable$Creator));
                        if (cursorQuery.moveToNext()) {
                            g().f.c("Got multiple records for conditional property, expected one", q3.s(str), d().y(str2));
                        }
                        cursorQuery.close();
                        return zzzVar;
                    } catch (SQLiteException e2) {
                        e = e2;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        g().f.d("Error querying conditional property", q3.s(str), d().y(str2), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    @WorkerThread
    public final int a0(String str, String str2) {
        b.c.a.a0.d.w(str);
        b.c.a.a0.d.w(str2);
        b();
        n();
        try {
            return t().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            g().f.d("Error deleting conditional property", q3.s(str), d().y(str2), e2);
            return 0;
        }
    }

    @WorkerThread
    public final void b0() {
        n();
        t().beginTransaction();
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00cb  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    public final Map<Integer, List<b.i.a.f.h.l.l0>> c0(String str, String str2) {
        Cursor cursorQuery;
        n();
        b();
        b.c.a.a0.d.w(str);
        b.c.a.a0.d.w(str2);
        ArrayMap arrayMap = new ArrayMap();
        ?? r9 = 0;
        try {
            try {
                cursorQuery = t().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        Map<Integer, List<b.i.a.f.h.l.l0>> mapEmptyMap = Collections.emptyMap();
                        cursorQuery.close();
                        return mapEmptyMap;
                    }
                    do {
                        try {
                            b.i.a.f.h.l.l0 l0Var = (b.i.a.f.h.l.l0) ((b.i.a.f.h.l.u4) ((l0$a) q9.x(b.i.a.f.h.l.l0.I(), cursorQuery.getBlob(1))).p());
                            int i2 = cursorQuery.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i2));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i2), arrayList);
                            }
                            arrayList.add(l0Var);
                        } catch (IOException e2) {
                            g().f.c("Failed to merge filter. appId", q3.s(str), e2);
                        }
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    return arrayMap;
                } catch (SQLiteException e3) {
                    e = e3;
                    g().f.c("Database error querying filters. appId", q3.s(str), e);
                    if (!b.i.a.f.h.l.l9.b() || !this.a.h.u(str, p.F0)) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    Map<Integer, List<b.i.a.f.h.l.l0>> mapEmptyMap2 = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return mapEmptyMap2;
                }
            } catch (Throwable th) {
                th = th;
                r9 = str2;
                if (r9 != 0) {
                    r9.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r9 != 0) {
                r9.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00cb  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    public final Map<Integer, List<b.i.a.f.h.l.o0>> d0(String str, String str2) {
        Cursor cursorQuery;
        n();
        b();
        b.c.a.a0.d.w(str);
        b.c.a.a0.d.w(str2);
        ArrayMap arrayMap = new ArrayMap();
        ?? r9 = 0;
        try {
            try {
                cursorQuery = t().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        Map<Integer, List<b.i.a.f.h.l.o0>> mapEmptyMap = Collections.emptyMap();
                        cursorQuery.close();
                        return mapEmptyMap;
                    }
                    do {
                        try {
                            b.i.a.f.h.l.o0 o0Var = (b.i.a.f.h.l.o0) ((b.i.a.f.h.l.u4) ((o0$a) q9.x(b.i.a.f.h.l.o0.D(), cursorQuery.getBlob(1))).p());
                            int i2 = cursorQuery.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i2));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i2), arrayList);
                            }
                            arrayList.add(o0Var);
                        } catch (IOException e2) {
                            g().f.c("Failed to merge filter", q3.s(str), e2);
                        }
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    return arrayMap;
                } catch (SQLiteException e3) {
                    e = e3;
                    g().f.c("Database error querying filters. appId", q3.s(str), e);
                    if (!b.i.a.f.h.l.l9.b() || !this.a.h.u(str, p.F0)) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    Map<Integer, List<b.i.a.f.h.l.o0>> mapEmptyMap2 = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return mapEmptyMap2;
                }
            } catch (Throwable th) {
                th = th;
                r9 = str2;
                if (r9 != 0) {
                    r9.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r9 != 0) {
                r9.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final void e0() {
        n();
        t().endTransaction();
    }

    public final long f0(String str) {
        b.c.a.a0.d.w(str);
        return w("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    @WorkerThread
    public final long g0(String str, String str2) throws Throwable {
        b.c.a.a0.d.w(str);
        b.c.a.a0.d.w(str2);
        b();
        n();
        SQLiteDatabase sQLiteDatabaseT = t();
        sQLiteDatabaseT.beginTransaction();
        long j2 = 0;
        try {
            StringBuilder sb = new StringBuilder(str2.length() + 32);
            sb.append("select ");
            sb.append(str2);
            sb.append(" from app2 where app_id=?");
            try {
                try {
                    long jW = w(sb.toString(), new String[]{str}, -1L);
                    if (jW == -1) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("app_id", str);
                        contentValues.put("first_open_count", (Integer) 0);
                        contentValues.put("previous_install_count", (Integer) 0);
                        if (sQLiteDatabaseT.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                            g().f.c("Failed to insert column (got -1). appId", q3.s(str), str2);
                            sQLiteDatabaseT.endTransaction();
                            return -1L;
                        }
                        jW = 0;
                        g().f.d("Error inserting column. appId", q3.s(str), str2, e);
                        sQLiteDatabaseT.endTransaction();
                        return j2;
                    }
                    try {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("app_id", str);
                        contentValues2.put(str2, Long.valueOf(1 + jW));
                        if (sQLiteDatabaseT.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                            g().f.c("Failed to update column (got 0). appId", q3.s(str), str2);
                            sQLiteDatabaseT.endTransaction();
                            return -1L;
                        }
                        sQLiteDatabaseT.setTransactionSuccessful();
                        sQLiteDatabaseT.endTransaction();
                        return jW;
                    } catch (SQLiteException e2) {
                        e = e2;
                        j2 = jW;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
                sQLiteDatabaseT.endTransaction();
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00cd  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00ca: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:44:0x00ca */
    public final Bundle h0(String str) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor;
        b();
        n();
        Cursor cursor2 = null;
        try {
            try {
                cursorRawQuery = t().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        g().n.a("Default event parameters not found");
                        cursorRawQuery.close();
                        return null;
                    }
                    try {
                        b.i.a.f.h.l.a1 a1Var = (b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) ((a1$a) q9.x(b.i.a.f.h.l.a1.M(), cursorRawQuery.getBlob(0))).p());
                        m();
                        List<b.i.a.f.h.l.c1> listV = a1Var.v();
                        Bundle bundle = new Bundle();
                        for (b.i.a.f.h.l.c1 c1Var : listV) {
                            String strB = c1Var.B();
                            if (c1Var.M()) {
                                bundle.putDouble(strB, c1Var.N());
                            } else if (c1Var.K()) {
                                bundle.putFloat(strB, c1Var.L());
                            } else if (c1Var.F()) {
                                bundle.putString(strB, c1Var.G());
                            } else if (c1Var.I()) {
                                bundle.putLong(strB, c1Var.J());
                            }
                        }
                        cursorRawQuery.close();
                        return bundle;
                    } catch (IOException e2) {
                        g().f.c("Failed to retrieve default event parameters. appId", q3.s(str), e2);
                        cursorRawQuery.close();
                        return null;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    g().f.b("Error selecting default event parameters", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final void i0() {
        b();
        n();
        if (R()) {
            long jA = l().i.a();
            Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jA) > p.f1564y.a(null).longValue()) {
                l().i.b(jElapsedRealtime);
                b();
                n();
                if (R()) {
                    SQLiteDatabase sQLiteDatabaseT = t();
                    Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
                    int iDelete = sQLiteDatabaseT.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(System.currentTimeMillis()), String.valueOf(c.B())});
                    if (iDelete > 0) {
                        g().n.b("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
                    }
                }
            }
        }
    }

    public final long j0() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = t().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return -1L;
                }
                long j2 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j2;
            } catch (SQLiteException e2) {
                g().f.b("Error querying raw events", e2);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    @Override // b.i.a.f.i.b.i9
    public final boolean p() {
        return false;
    }

    @WorkerThread
    public final void s() {
        n();
        t().setTransactionSuccessful();
    }

    @WorkerThread
    public final SQLiteDatabase t() {
        b();
        try {
            return this.l.getWritableDatabase();
        } catch (SQLiteException e2) {
            g().i.b("Error opening database", e2);
            throw e2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    @WorkerThread
    public final String u() throws Throwable {
        Throwable th;
        Cursor cursorRawQuery;
        ?? T = t();
        try {
            try {
                cursorRawQuery = T.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        cursorRawQuery.close();
                        return null;
                    }
                    String string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                    return string;
                } catch (SQLiteException e2) {
                    e = e2;
                    g().f.b("Database error getting next bundle app id", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (T != 0) {
                    T.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorRawQuery = null;
        } catch (Throwable th3) {
            th = th3;
            T = 0;
            if (T != 0) {
                T.close();
            }
            throw th;
        }
    }

    public final long v(b.i.a.f.h.l.e1 e1Var) throws IOException {
        b();
        n();
        b.c.a.a0.d.w(e1Var.G1());
        byte[] bArrD = e1Var.d();
        long jT = m().t(bArrD);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", e1Var.G1());
        contentValues.put("metadata_fingerprint", Long.valueOf(jT));
        contentValues.put("metadata", bArrD);
        try {
            t().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return jT;
        } catch (SQLiteException e2) {
            g().f.c("Error storing raw event metadata. appId", q3.s(e1Var.G1()), e2);
            throw e2;
        }
    }

    @WorkerThread
    public final long w(String str, String[] strArr, long j2) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = t().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return j2;
                }
                long j3 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j3;
            } catch (SQLiteException e2) {
                g().f.c("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final f x(long j2, String str, long j3, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        b.c.a.a0.d.w(str);
        b();
        n();
        String[] strArr = {str};
        f fVar = new f();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseT = t();
                Cursor cursorQuery = sQLiteDatabaseT.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    g().i.b("Not updating daily counts, app is not known. appId", q3.s(str));
                    cursorQuery.close();
                    return fVar;
                }
                if (cursorQuery.getLong(0) == j2) {
                    fVar.f1532b = cursorQuery.getLong(1);
                    fVar.a = cursorQuery.getLong(2);
                    fVar.c = cursorQuery.getLong(3);
                    fVar.d = cursorQuery.getLong(4);
                    fVar.e = cursorQuery.getLong(5);
                }
                if (z2) {
                    fVar.f1532b += j3;
                }
                if (z3) {
                    fVar.a += j3;
                }
                if (z4) {
                    fVar.c += j3;
                }
                if (z5) {
                    fVar.d += j3;
                }
                if (z6) {
                    fVar.e += j3;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j2));
                contentValues.put("daily_public_events_count", Long.valueOf(fVar.a));
                contentValues.put("daily_events_count", Long.valueOf(fVar.f1532b));
                contentValues.put("daily_conversions_count", Long.valueOf(fVar.c));
                contentValues.put("daily_error_events_count", Long.valueOf(fVar.d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(fVar.e));
                sQLiteDatabaseT.update("apps", contentValues, "app_id=?", strArr);
                cursorQuery.close();
                return fVar;
            } catch (SQLiteException e2) {
                g().f.c("Error updating daily counts. appId", q3.s(str), e2);
                if (0 != 0) {
                    cursor.close();
                }
                return fVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final f y(long j2, String str, boolean z2, boolean z3) {
        return x(j2, str, 1L, false, false, z2, false, z3);
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0143: MOVE (r18 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:64:0x0143 */
    @WorkerThread
    public final l z(String str, String str2) {
        Cursor cursorQuery;
        Cursor cursor;
        Cursor cursor2;
        Boolean boolValueOf;
        b.c.a.a0.d.w(str);
        b.c.a.a0.d.w(str2);
        b();
        n();
        Cursor cursor3 = null;
        try {
            try {
                cursorQuery = t().query("events", (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    long j2 = cursorQuery.getLong(0);
                    long j3 = cursorQuery.getLong(1);
                    long j4 = cursorQuery.getLong(2);
                    long j5 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
                    Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
                    Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
                    Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
                    if (cursorQuery.isNull(7)) {
                        boolValueOf = null;
                    } else {
                        try {
                            boolValueOf = Boolean.valueOf(cursorQuery.getLong(7) == 1);
                        } catch (SQLiteException e2) {
                            e = e2;
                        }
                    }
                    cursor2 = cursorQuery;
                    try {
                        l lVar = new l(str, str2, j2, j3, cursorQuery.isNull(8) ? 0L : cursorQuery.getLong(8), j4, j5, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                        if (cursor2.moveToNext()) {
                            g().f.b("Got multiple records for event aggregates, expected one. appId", q3.s(str));
                        }
                        cursor2.close();
                        return lVar;
                    } catch (SQLiteException e3) {
                        e = e3;
                        cursorQuery = cursor2;
                    } catch (Throwable th) {
                        th = th;
                        cursor3 = cursor2;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e4) {
                    e = e4;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursorQuery;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor3 = cursor;
            }
        } catch (SQLiteException e5) {
            e = e5;
            cursorQuery = null;
        } catch (Throwable th4) {
            th = th4;
        }
        g().f.d("Error querying events. appId", q3.s(str), d().u(str2), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }
}
