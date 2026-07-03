package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3579a1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3607c1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3630da;
import p007b.p225i.p226a.p288f.p313h.p325l.C3635e1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3730l0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3739l9;
import p007b.p225i.p226a.p288f.p313h.p325l.C3769o0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3777o8;

/* JADX INFO: renamed from: b.i.a.f.i.b.g */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4040g extends AbstractC4074i9 {

    /* JADX INFO: renamed from: d */
    public static final String[] f10735d = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* JADX INFO: renamed from: e */
    public static final String[] f10736e = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* JADX INFO: renamed from: f */
    public static final String[] f10737f = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};

    /* JADX INFO: renamed from: g */
    public static final String[] f10738g = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* JADX INFO: renamed from: h */
    public static final String[] f10739h = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* JADX INFO: renamed from: i */
    public static final String[] f10740i = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* JADX INFO: renamed from: j */
    public static final String[] f10741j = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* JADX INFO: renamed from: k */
    public static final String[] f10742k = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* JADX INFO: renamed from: l */
    public final C4052h f10743l;

    /* JADX INFO: renamed from: m */
    public final C4026e9 f10744m;

    public C4040g(C4097k9 c4097k9) {
        super(c4097k9);
        this.f10744m = new C4026e9(this.f11202a.f11267o);
        this.f10743l = new C4052h(this, this.f11202a.f11254b, "google_app_measurement.db");
    }

    @WorkerThread
    /* JADX INFO: renamed from: G */
    public static void m5603G(ContentValues contentValues, String str, Object obj) {
        C1460d.m583w(str);
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
    /* JADX INFO: renamed from: A */
    public final Object m5604A(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            mo5726g().f11141f.m5860a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type != 4) {
            mo5726g().f11141f.m5861b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        mo5726g().f11141f.m5860a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0053  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r5v0, types: [long] */
    /* JADX INFO: renamed from: B */
    public final String m5605B(long j) throws Throwable {
        Cursor cursorRawQuery;
        mo5848b();
        m5684n();
        ?? r0 = 0;
        try {
            try {
                cursorRawQuery = m5640t().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf((long) j)});
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        String string = cursorRawQuery.getString(0);
                        cursorRawQuery.close();
                        return string;
                    }
                    mo5726g().f11149n.m5860a("No expired configs for apps with pending events");
                    cursorRawQuery.close();
                    return null;
                } catch (SQLiteException e) {
                    e = e;
                    mo5726g().f11141f.m5861b("Error selecting expired configs", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r0 = j;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
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
    /* JADX INFO: renamed from: C */
    public final List<C4207u9> m5606C(String str) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        C1460d.m583w(str);
        mo5848b();
        m5684n();
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = m5640t().query("user_attributes", new String[]{ModelAuditLogEntry.CHANGE_KEY_NAME, "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
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
                        long j = cursorQuery.getLong(2);
                        Object objM5604A = m5604A(cursorQuery, 3);
                        if (objM5604A == null) {
                            mo5726g().f11141f.m5861b("Read invalid user property value, ignoring it. appId", C4157q3.m5788s(str));
                        } else {
                            arrayList.add(new C4207u9(str, str2, string, j, objM5604A));
                        }
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    return arrayList;
                } catch (SQLiteException e) {
                    e = e;
                    mo5726g().f11141f.m5862c("Error querying user properties. appId", C4157q3.m5788s(str), e);
                    if (!C3739l9.m5058b() || !this.f11202a.f11260h.m5532u(str, C4142p.f11031F0)) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    List<C4207u9> listEmptyList = Collections.emptyList();
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
        } catch (SQLiteException e2) {
            e = e2;
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
    /* JADX INFO: renamed from: D */
    public final List<Pair<C3635e1, Long>> m5607D(String str, int i, int i2) {
        mo5848b();
        m5684n();
        C1460d.m539l(i > 0);
        C1460d.m539l(i2 > 0);
        C1460d.m583w(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = m5640t().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
                if (!cursorQuery.moveToFirst()) {
                    List<Pair<C3635e1, Long>> listEmptyList = Collections.emptyList();
                    cursorQuery.close();
                    return listEmptyList;
                }
                ArrayList arrayList = new ArrayList();
                int length = 0;
                do {
                    long j = cursorQuery.getLong(0);
                    try {
                        byte[] bArrM5839S = m5683m().m5839S(cursorQuery.getBlob(1));
                        if (!arrayList.isEmpty() && bArrM5839S.length + length > i2) {
                            break;
                        }
                        try {
                            C3635e1.a aVar = (C3635e1.a) C4163q9.m5832x(C3635e1.m4690u0(), bArrM5839S);
                            if (!cursorQuery.isNull(2)) {
                                int i3 = cursorQuery.getInt(2);
                                if (aVar.f10348l) {
                                    aVar.m5318n();
                                    aVar.f10348l = false;
                                }
                                C3635e1.m4668V0((C3635e1) aVar.f10347k, i3);
                            }
                            length += bArrM5839S.length;
                            arrayList.add(Pair.create((C3635e1) ((AbstractC3851u4) aVar.m5320p()), Long.valueOf(j)));
                        } catch (IOException e) {
                            mo5726g().f11141f.m5862c("Failed to merge queued bundle. appId", C4157q3.m5788s(str), e);
                        }
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                    } catch (IOException e2) {
                        mo5726g().f11141f.m5862c("Failed to unzip queued bundle. appId", C4157q3.m5788s(str), e2);
                    }
                } while (length <= i2);
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e3) {
                mo5726g().f11141f.m5862c("Error querying bundles. appId", C4157q3.m5788s(str), e3);
                List<Pair<C3635e1, Long>> listEmptyList2 = Collections.emptyList();
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
    /* JADX INFO: renamed from: E */
    public final List<C4207u9> m5608E(String str, String str2, String str3) throws Throwable {
        String str4;
        Cursor cursorQuery;
        C1460d.m583w(str);
        mo5848b();
        m5684n();
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
                    } catch (SQLiteException e) {
                        e = e;
                        cursorQuery = null;
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    arrayList2.add(String.valueOf(str3).concat("*"));
                    sb.append(" and name glob ?");
                }
                cursorQuery = m5640t().query("user_attributes", new String[]{ModelAuditLogEntry.CHANGE_KEY_NAME, "set_timestamp", "value", "origin"}, sb.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), null, null, "rowid", "1001");
                try {
                    try {
                        if (!cursorQuery.moveToFirst()) {
                            cursorQuery.close();
                            return arrayList;
                        }
                        while (arrayList.size() < 1000) {
                            String string = cursorQuery.getString(0);
                            long j = cursorQuery.getLong(1);
                            Object objM5604A = m5604A(cursorQuery, 2);
                            String string2 = cursorQuery.getString(3);
                            if (objM5604A == null) {
                                try {
                                    mo5726g().f11141f.m5863d("(2)Read invalid user property value, ignoring it", C4157q3.m5788s(str), string2, str3);
                                } catch (SQLiteException e2) {
                                    e = e2;
                                    str4 = string2;
                                }
                            } else {
                                arrayList.add(new C4207u9(str, string2, string, j, objM5604A));
                            }
                            if (!cursorQuery.moveToNext()) {
                                cursorQuery.close();
                                return arrayList;
                            }
                            str4 = string2;
                        }
                        mo5726g().f11141f.m5861b("Read more than the max allowed user properties, ignoring excess", 1000);
                        cursorQuery.close();
                        return arrayList;
                    } catch (SQLiteException e3) {
                        e = e3;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                str4 = str2;
            }
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        mo5726g().f11141f.m5863d("(2)Error querying user properties", C4157q3.m5788s(str), str4, e);
        if (!C3739l9.m5058b() || !this.f11202a.f11260h.m5532u(str, C4142p.f11031F0)) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        }
        List<C4207u9> listEmptyList = Collections.emptyList();
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return listEmptyList;
    }

    /* JADX INFO: renamed from: F */
    public final List<zzz> m5609F(String str, String[] strArr) {
        mo5848b();
        m5684n();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = m5640t().query("conditional_properties", new String[]{"app_id", "origin", ModelAuditLogEntry.CHANGE_KEY_NAME, "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                while (arrayList.size() < 1000) {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    String string3 = cursorQuery.getString(2);
                    Object objM5604A = m5604A(cursorQuery, 3);
                    boolean z2 = cursorQuery.getInt(4) != 0;
                    String string4 = cursorQuery.getString(5);
                    long j = cursorQuery.getLong(6);
                    C4163q9 c4163q9M5683m = m5683m();
                    byte[] blob = cursorQuery.getBlob(7);
                    Parcelable.Creator<zzaq> creator = zzaq.CREATOR;
                    zzaq zzaqVar = (zzaq) c4163q9M5683m.m5843u(blob, creator);
                    arrayList.add(new zzz(string, string2, new zzku(string3, cursorQuery.getLong(10), objM5604A, string2), cursorQuery.getLong(8), z2, string4, zzaqVar, j, (zzaq) m5683m().m5843u(cursorQuery.getBlob(9), creator), cursorQuery.getLong(11), (zzaq) m5683m().m5843u(cursorQuery.getBlob(12), creator)));
                    if (!cursorQuery.moveToNext()) {
                        cursorQuery.close();
                        return arrayList;
                    }
                }
                mo5726g().f11141f.m5861b("Read more than the max allowed conditional properties, ignoring extra", 1000);
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e) {
                mo5726g().f11141f.m5861b("Error querying conditional user property value", e);
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
    /* JADX INFO: renamed from: H */
    public final void m5610H(C4098l c4098l) {
        Objects.requireNonNull(c4098l, "null reference");
        mo5848b();
        m5684n();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c4098l.f10926a);
        contentValues.put(ModelAuditLogEntry.CHANGE_KEY_NAME, c4098l.f10927b);
        contentValues.put("lifetime_count", Long.valueOf(c4098l.f10928c));
        contentValues.put("current_bundle_count", Long.valueOf(c4098l.f10929d));
        contentValues.put("last_fire_timestamp", Long.valueOf(c4098l.f10931f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(c4098l.f10932g));
        contentValues.put("last_bundled_day", c4098l.f10933h);
        contentValues.put("last_sampled_complex_event_id", c4098l.f10934i);
        contentValues.put("last_sampling_rate", c4098l.f10935j);
        contentValues.put("current_session_count", Long.valueOf(c4098l.f10930e));
        Boolean bool = c4098l.f10936k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (m5640t().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                mo5726g().f11141f.m5861b("Failed to insert/update event aggregates (got -1). appId", C4157q3.m5788s(c4098l.f10926a));
            }
        } catch (SQLiteException e) {
            mo5726g().f11141f.m5862c("Error storing event aggregates. appId", C4157q3.m5788s(c4098l.f10926a), e);
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: I */
    public final void m5611I(C3973a4 c3973a4) {
        mo5848b();
        m5684n();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c3973a4.m5485o());
        contentValues.put("app_instance_id", c3973a4.m5489s());
        contentValues.put("gmp_app_id", c3973a4.m5492v());
        contentValues.put("resettable_device_id_hash", c3973a4.m5451E());
        contentValues.put("last_bundle_index", Long.valueOf(c3973a4.m5467U()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(c3973a4.m5457K()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(c3973a4.m5458L()));
        contentValues.put("app_version", c3973a4.m5459M());
        contentValues.put("app_store", c3973a4.m5461O());
        contentValues.put("gmp_version", Long.valueOf(c3973a4.m5462P()));
        contentValues.put("dev_cert_hash", Long.valueOf(c3973a4.m5463Q()));
        contentValues.put("measurement_enabled", Boolean.valueOf(c3973a4.m5466T()));
        c3973a4.f10516a.mo5725f().mo5848b();
        contentValues.put("day", Long.valueOf(c3973a4.f10539x));
        c3973a4.f10516a.mo5725f().mo5848b();
        contentValues.put("daily_public_events_count", Long.valueOf(c3973a4.f10540y));
        c3973a4.f10516a.mo5725f().mo5848b();
        contentValues.put("daily_events_count", Long.valueOf(c3973a4.f10541z));
        c3973a4.f10516a.mo5725f().mo5848b();
        contentValues.put("daily_conversions_count", Long.valueOf(c3973a4.f10509A));
        c3973a4.f10516a.mo5725f().mo5848b();
        contentValues.put("config_fetched_time", Long.valueOf(c3973a4.f10514F));
        c3973a4.f10516a.mo5725f().mo5848b();
        contentValues.put("failed_config_fetch_time", Long.valueOf(c3973a4.f10515G));
        contentValues.put("app_version_int", Long.valueOf(c3973a4.m5460N()));
        contentValues.put("firebase_instance_id", c3973a4.m5454H());
        c3973a4.f10516a.mo5725f().mo5848b();
        contentValues.put("daily_error_events_count", Long.valueOf(c3973a4.f10510B));
        c3973a4.f10516a.mo5725f().mo5848b();
        contentValues.put("daily_realtime_events_count", Long.valueOf(c3973a4.f10511C));
        c3973a4.f10516a.mo5725f().mo5848b();
        contentValues.put("health_monitor_sample", c3973a4.f10512D);
        contentValues.put("android_id", Long.valueOf(c3973a4.m5477g()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(c3973a4.m5478h()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(c3973a4.m5479i()));
        contentValues.put("admob_app_id", c3973a4.m5495y());
        contentValues.put("dynamite_version", Long.valueOf(c3973a4.m5465S()));
        if (c3973a4.m5481k() != null) {
            if (c3973a4.m5481k().size() == 0) {
                mo5726g().f11144i.m5861b("Safelisted events should not be an empty list. appId", c3973a4.m5485o());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", c3973a4.m5481k()));
            }
        }
        if (C3630da.m4644b() && this.f11202a.f11260h.m5532u(c3973a4.m5485o(), C4142p.f11080j0)) {
            contentValues.put("ga_app_id", c3973a4.m5448B());
        }
        try {
            SQLiteDatabase sQLiteDatabaseM5640t = m5640t();
            if (sQLiteDatabaseM5640t.update("apps", contentValues, "app_id = ?", new String[]{c3973a4.m5485o()}) == 0 && sQLiteDatabaseM5640t.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                mo5726g().f11141f.m5861b("Failed to insert/update app (got -1). appId", C4157q3.m5788s(c3973a4.m5485o()));
            }
        } catch (SQLiteException e) {
            mo5726g().f11141f.m5862c("Error storing app. appId", C4157q3.m5788s(c3973a4.m5485o()), e);
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: J */
    public final void m5612J(List<Long> list) {
        mo5848b();
        m5684n();
        Objects.requireNonNull(list, "null reference");
        if (list.size() == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        }
        if (m5620R()) {
            String strJoin = TextUtils.join(",", list);
            String strM859k = C1643a.m859k(C1643a.m841b(strJoin, 2), "(", strJoin, ")");
            if (m5621S(C1643a.m859k(C1643a.m841b(strM859k, 80), "SELECT COUNT(1) FROM queue WHERE rowid IN ", strM859k, " AND retry_count =  2147483647 LIMIT 1"), null) > 0) {
                mo5726g().f11144i.m5860a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseM5640t = m5640t();
                StringBuilder sb = new StringBuilder(String.valueOf(strM859k).length() + Opcodes.LAND);
                sb.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb.append(strM859k);
                sb.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                sQLiteDatabaseM5640t.execSQL(sb.toString());
            } catch (SQLiteException e) {
                mo5726g().f11141f.m5861b("Error incrementing retry count. error", e);
            }
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: K */
    public final boolean m5613K(C3635e1 c3635e1, boolean z2) {
        mo5848b();
        m5684n();
        C1460d.m583w(c3635e1.m4710G1());
        C1460d.m432F(c3635e1.m4747n1());
        m5637i0();
        Objects.requireNonNull((C3401c) this.f11202a.f11267o);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (c3635e1.m4749o1() < jCurrentTimeMillis - C3992c.m5519B() || c3635e1.m4749o1() > C3992c.m5519B() + jCurrentTimeMillis) {
            mo5726g().f11144i.m5863d("Storing bundle outside of the max uploading time span. appId, now, timestamp", C4157q3.m5788s(c3635e1.m4710G1()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(c3635e1.m4749o1()));
        }
        try {
            byte[] bArrM5840T = m5683m().m5840T(c3635e1.m5052d());
            mo5726g().f11149n.m5861b("Saving bundle, size", Integer.valueOf(bArrM5840T.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", c3635e1.m4710G1());
            contentValues.put("bundle_end_timestamp", Long.valueOf(c3635e1.m4749o1()));
            contentValues.put("data", bArrM5840T);
            contentValues.put("has_realtime", Integer.valueOf(z2 ? 1 : 0));
            if (c3635e1.m4741f0()) {
                contentValues.put("retry_count", Integer.valueOf(c3635e1.m4746n0()));
            }
            try {
                if (m5640t().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                mo5726g().f11141f.m5861b("Failed to insert bundle (got -1). appId", C4157q3.m5788s(c3635e1.m4710G1()));
                return false;
            } catch (SQLiteException e) {
                mo5726g().f11141f.m5862c("Error storing bundle. appId", C4157q3.m5788s(c3635e1.m4710G1()), e);
                return false;
            }
        } catch (IOException e2) {
            mo5726g().f11141f.m5862c("Data loss. Failed to serialize bundle. appId", C4157q3.m5788s(c3635e1.m4710G1()), e2);
            return false;
        }
    }

    /* JADX INFO: renamed from: L */
    public final boolean m5614L(C4109m c4109m, long j, boolean z2) {
        mo5848b();
        m5684n();
        C1460d.m583w(c4109m.f10952a);
        byte[] bArrM5052d = m5683m().m5844v(c4109m).m5052d();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c4109m.f10952a);
        contentValues.put(ModelAuditLogEntry.CHANGE_KEY_NAME, c4109m.f10953b);
        contentValues.put("timestamp", Long.valueOf(c4109m.f10955d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", bArrM5052d);
        contentValues.put("realtime", Integer.valueOf(z2 ? 1 : 0));
        try {
            if (m5640t().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            mo5726g().f11141f.m5861b("Failed to insert raw event (got -1). appId", C4157q3.m5788s(c4109m.f10952a));
            return false;
        } catch (SQLiteException e) {
            mo5726g().f11141f.m5862c("Error storing raw event. appId", C4157q3.m5788s(c4109m.f10952a), e);
            return false;
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: M */
    public final boolean m5615M(C4207u9 c4207u9) {
        mo5848b();
        m5684n();
        if (m5627Y(c4207u9.f11290a, c4207u9.f11292c) == null) {
            if (C4196t9.m5877X(c4207u9.f11292c)) {
                long jM5621S = m5621S("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{c4207u9.f11290a});
                C3992c c3992c = this.f11202a.f11260h;
                String str = c4207u9.f11290a;
                Objects.requireNonNull(c3992c);
                int iMax = 25;
                if (C3777o8.m5155b() && c3992c.m5532u(null, C4142p.f11106w0)) {
                    iMax = Math.max(Math.min(c3992c.m5528q(str, C4142p.f11032G), 100), 25);
                }
                if (jM5621S >= iMax) {
                    return false;
                }
            } else if (!"_npa".equals(c4207u9.f11292c) && m5621S("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{c4207u9.f11290a, c4207u9.f11291b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c4207u9.f11290a);
        contentValues.put("origin", c4207u9.f11291b);
        contentValues.put(ModelAuditLogEntry.CHANGE_KEY_NAME, c4207u9.f11292c);
        contentValues.put("set_timestamp", Long.valueOf(c4207u9.f11293d));
        m5603G(contentValues, "value", c4207u9.f11294e);
        try {
            if (m5640t().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                mo5726g().f11141f.m5861b("Failed to insert/update user property (got -1). appId", C4157q3.m5788s(c4207u9.f11290a));
            }
        } catch (SQLiteException e) {
            mo5726g().f11141f.m5862c("Error storing user property. appId", C4157q3.m5788s(c4207u9.f11290a), e);
        }
        return true;
    }

    @WorkerThread
    /* JADX INFO: renamed from: N */
    public final boolean m5616N(zzz zzzVar) {
        mo5848b();
        m5684n();
        if (m5627Y(zzzVar.f20700j, zzzVar.f20702l.f20671k) == null && m5621S("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzzVar.f20700j}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzzVar.f20700j);
        contentValues.put("origin", zzzVar.f20701k);
        contentValues.put(ModelAuditLogEntry.CHANGE_KEY_NAME, zzzVar.f20702l.f20671k);
        m5603G(contentValues, "value", zzzVar.f20702l.m9117w0());
        contentValues.put("active", Boolean.valueOf(zzzVar.f20704n));
        contentValues.put("trigger_event_name", zzzVar.f20705o);
        contentValues.put("trigger_timeout", Long.valueOf(zzzVar.f20707q));
        m5866e();
        contentValues.put("timed_out_event", C4196t9.m5880g0(zzzVar.f20706p));
        contentValues.put("creation_timestamp", Long.valueOf(zzzVar.f20703m));
        m5866e();
        contentValues.put("triggered_event", C4196t9.m5880g0(zzzVar.f20708r));
        contentValues.put("triggered_timestamp", Long.valueOf(zzzVar.f20702l.f20672l));
        contentValues.put("time_to_live", Long.valueOf(zzzVar.f20709s));
        m5866e();
        contentValues.put("expired_event", C4196t9.m5880g0(zzzVar.f20710t));
        try {
            if (m5640t().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                mo5726g().f11141f.m5861b("Failed to insert/update conditional user property (got -1)", C4157q3.m5788s(zzzVar.f20700j));
            }
        } catch (SQLiteException e) {
            mo5726g().f11141f.m5862c("Error storing conditional user property", C4157q3.m5788s(zzzVar.f20700j), e);
        }
        return true;
    }

    @WorkerThread
    /* JADX INFO: renamed from: O */
    public final boolean m5617O(String str, int i, C3730l0 c3730l0) {
        m5684n();
        mo5848b();
        C1460d.m583w(str);
        Objects.requireNonNull(c3730l0, "null reference");
        if (TextUtils.isEmpty(c3730l0.m5046z())) {
            mo5726g().f11144i.m5863d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", C4157q3.m5788s(str), Integer.valueOf(i), String.valueOf(c3730l0.m5044x() ? Integer.valueOf(c3730l0.m5045y()) : null));
            return false;
        }
        byte[] bArrM5052d = c3730l0.m5052d();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", c3730l0.m5044x() ? Integer.valueOf(c3730l0.m5045y()) : null);
        contentValues.put("event_name", c3730l0.m5046z());
        contentValues.put("session_scoped", c3730l0.m5041G() ? Boolean.valueOf(c3730l0.m5042H()) : null);
        contentValues.put("data", bArrM5052d);
        try {
            if (m5640t().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            mo5726g().f11141f.m5861b("Failed to insert event filter (got -1). appId", C4157q3.m5788s(str));
            return true;
        } catch (SQLiteException e) {
            mo5726g().f11141f.m5862c("Error storing event filter. appId", C4157q3.m5788s(str), e);
            return false;
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: P */
    public final boolean m5618P(String str, int i, C3769o0 c3769o0) {
        m5684n();
        mo5848b();
        C1460d.m583w(str);
        Objects.requireNonNull(c3769o0, "null reference");
        if (TextUtils.isEmpty(c3769o0.m5149x())) {
            mo5726g().f11144i.m5863d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", C4157q3.m5788s(str), Integer.valueOf(i), String.valueOf(c3769o0.m5147v() ? Integer.valueOf(c3769o0.m5148w()) : null));
            return false;
        }
        byte[] bArrM5052d = c3769o0.m5052d();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", c3769o0.m5147v() ? Integer.valueOf(c3769o0.m5148w()) : null);
        contentValues.put("property_name", c3769o0.m5149x());
        contentValues.put("session_scoped", c3769o0.m5145B() ? Boolean.valueOf(c3769o0.m5146C()) : null);
        contentValues.put("data", bArrM5052d);
        try {
            if (m5640t().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            mo5726g().f11141f.m5861b("Failed to insert property filter (got -1). appId", C4157q3.m5788s(str));
            return false;
        } catch (SQLiteException e) {
            mo5726g().f11141f.m5862c("Error storing property filter. appId", C4157q3.m5788s(str), e);
            return false;
        }
    }

    /* JADX INFO: renamed from: Q */
    public final boolean m5619Q(String str, Long l, long j, C3579a1 c3579a1) {
        mo5848b();
        m5684n();
        Objects.requireNonNull(c3579a1, "null reference");
        C1460d.m583w(str);
        Objects.requireNonNull(l, "null reference");
        byte[] bArrM5052d = c3579a1.m5052d();
        mo5726g().f11149n.m5862c("Saving complex main event, appId, data size", m5865d().m5766u(str), Integer.valueOf(bArrM5052d.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", bArrM5052d);
        try {
            if (m5640t().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            mo5726g().f11141f.m5861b("Failed to insert complex main event (got -1). appId", C4157q3.m5788s(str));
            return false;
        } catch (SQLiteException e) {
            mo5726g().f11141f.m5862c("Error storing complex main event. appId", C4157q3.m5788s(str), e);
            return false;
        }
    }

    /* JADX INFO: renamed from: R */
    public final boolean m5620R() {
        return this.f11202a.f11254b.getDatabasePath("google_app_measurement.db").exists();
    }

    @WorkerThread
    /* JADX INFO: renamed from: S */
    public final long m5621S(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = m5640t().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j;
            } catch (SQLiteException e) {
                mo5726g().f11141f.m5862c("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: T */
    public final C3973a4 m5622T(String str) throws Throwable {
        Cursor cursorQuery;
        C1460d.m583w(str);
        mo5848b();
        m5684n();
        Cursor cursor = null;
        try {
            boolean z2 = true;
            cursorQuery = m5640t().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "ssaid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    C3973a4 c3973a4 = new C3973a4(this.f10827b.f10906k, str);
                    c3973a4.m5473c(cursorQuery.getString(0));
                    c3973a4.m5483m(cursorQuery.getString(1));
                    c3973a4.m5494x(cursorQuery.getString(2));
                    c3973a4.m5449C(cursorQuery.getLong(3));
                    c3973a4.m5471a(cursorQuery.getLong(4));
                    c3973a4.m5482l(cursorQuery.getLong(5));
                    c3973a4.m5450D(cursorQuery.getString(6));
                    c3973a4.m5453G(cursorQuery.getString(7));
                    c3973a4.m5490t(cursorQuery.getLong(8));
                    c3973a4.m5493w(cursorQuery.getLong(9));
                    c3973a4.m5475e(cursorQuery.isNull(10) || cursorQuery.getInt(10) != 0);
                    long j = cursorQuery.getLong(11);
                    c3973a4.f10516a.mo5725f().mo5848b();
                    c3973a4.f10513E |= c3973a4.f10539x != j;
                    c3973a4.f10539x = j;
                    long j2 = cursorQuery.getLong(12);
                    c3973a4.f10516a.mo5725f().mo5848b();
                    c3973a4.f10513E |= c3973a4.f10540y != j2;
                    c3973a4.f10540y = j2;
                    long j3 = cursorQuery.getLong(13);
                    c3973a4.f10516a.mo5725f().mo5848b();
                    c3973a4.f10513E |= c3973a4.f10541z != j3;
                    c3973a4.f10541z = j3;
                    long j4 = cursorQuery.getLong(14);
                    c3973a4.f10516a.mo5725f().mo5848b();
                    c3973a4.f10513E |= c3973a4.f10509A != j4;
                    c3973a4.f10509A = j4;
                    c3973a4.m5452F(cursorQuery.getLong(15));
                    c3973a4.m5455I(cursorQuery.getLong(16));
                    c3973a4.m5486p(cursorQuery.isNull(17) ? -2147483648L : cursorQuery.getInt(17));
                    c3973a4.m5447A(cursorQuery.getString(18));
                    long j5 = cursorQuery.getLong(19);
                    c3973a4.f10516a.mo5725f().mo5848b();
                    c3973a4.f10513E |= c3973a4.f10510B != j5;
                    c3973a4.f10510B = j5;
                    long j6 = cursorQuery.getLong(20);
                    c3973a4.f10516a.mo5725f().mo5848b();
                    c3973a4.f10513E |= c3973a4.f10511C != j6;
                    c3973a4.f10511C = j6;
                    c3973a4.m5456J(cursorQuery.getString(21));
                    long j7 = 0;
                    if (!this.f11202a.f11260h.m5526o(C4142p.f11110y0)) {
                        c3973a4.m5464R(cursorQuery.isNull(22) ? 0L : cursorQuery.getLong(22));
                    }
                    c3973a4.m5484n(cursorQuery.isNull(23) || cursorQuery.getInt(23) != 0);
                    if (!cursorQuery.isNull(24) && cursorQuery.getInt(24) == 0) {
                        z2 = false;
                    }
                    c3973a4.m5488r(z2);
                    c3973a4.m5487q(cursorQuery.getString(25));
                    if (!cursorQuery.isNull(26)) {
                        j7 = cursorQuery.getLong(26);
                    }
                    c3973a4.m5496z(j7);
                    if (!cursorQuery.isNull(27)) {
                        c3973a4.m5474d(Arrays.asList(cursorQuery.getString(27).split(",", -1)));
                    }
                    if (C3630da.m4644b() && this.f11202a.f11260h.m5532u(str, C4142p.f11080j0)) {
                        c3973a4.m5491u(cursorQuery.getString(28));
                    }
                    c3973a4.f10516a.mo5725f().mo5848b();
                    c3973a4.f10513E = false;
                    if (cursorQuery.moveToNext()) {
                        mo5726g().f11141f.m5861b("Got multiple records for app, expected one. appId", C4157q3.m5788s(str));
                    }
                    cursorQuery.close();
                    return c3973a4;
                } catch (SQLiteException e) {
                    e = e;
                    mo5726g().f11141f.m5862c("Error querying app. appId", C4157q3.m5788s(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
            }
        } catch (SQLiteException e2) {
            e = e2;
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
    /* JADX INFO: renamed from: U */
    public final List<zzz> m5623U(String str, String str2, String str3) {
        C1460d.m583w(str);
        mo5848b();
        m5684n();
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
        return m5609F(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @WorkerThread
    /* JADX INFO: renamed from: V */
    public final void m5624V(String str, String str2) {
        C1460d.m583w(str);
        C1460d.m583w(str2);
        mo5848b();
        m5684n();
        try {
            m5640t().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            mo5726g().f11141f.m5863d("Error deleting user property. appId", C4157q3.m5788s(str), m5865d().m5769y(str2), e);
        }
    }

    /* JADX INFO: renamed from: W */
    public final boolean m5625W(String str, List<Integer> list) {
        C1460d.m583w(str);
        m5684n();
        mo5848b();
        SQLiteDatabase sQLiteDatabaseM5640t = m5640t();
        try {
            long jM5621S = m5621S("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, this.f11202a.f11260h.m5528q(str, C4142p.f11030F)));
            if (jM5621S <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String strJoin = TextUtils.join(",", arrayList);
            String strM859k = C1643a.m859k(C1643a.m841b(strJoin, 2), "(", strJoin, ")");
            return sQLiteDatabaseM5640t.delete("audience_filter_values", C1643a.m859k(C1643a.m841b(strM859k, Opcodes.F2L), "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ", strM859k, " order by rowid desc limit -1 offset ?)"), new String[]{str, Integer.toString(iMax)}) > 0;
        } catch (SQLiteException e) {
            mo5726g().f11141f.m5862c("Database error querying filters. appId", C4157q3.m5788s(str), e);
            return false;
        }
    }

    /* JADX INFO: renamed from: X */
    public final long m5626X(String str) {
        C1460d.m583w(str);
        mo5848b();
        m5684n();
        try {
            return m5640t().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, this.f11202a.f11260h.m5528q(str, C4142p.f11091p))))});
        } catch (SQLiteException e) {
            mo5726g().f11141f.m5862c("Error deleting over the limit events. appId", C4157q3.m5788s(str), e);
            return 0L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a1  */
    @WorkerThread
    /* JADX INFO: renamed from: Y */
    public final C4207u9 m5627Y(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        C1460d.m583w(str);
        C1460d.m583w(str2);
        mo5848b();
        m5684n();
        Cursor cursor = null;
        try {
            try {
                cursorQuery = m5640t().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    try {
                        C4207u9 c4207u9 = new C4207u9(str, cursorQuery.getString(2), str2, cursorQuery.getLong(0), m5604A(cursorQuery, 1));
                        if (cursorQuery.moveToNext()) {
                            mo5726g().f11141f.m5861b("Got multiple records for user property, expected one. appId", C4157q3.m5788s(str));
                        }
                        cursorQuery.close();
                        return c4207u9;
                    } catch (SQLiteException e) {
                        e = e;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
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
        } catch (SQLiteException e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        mo5726g().f11141f.m5863d("Error querying user property. appId", C4157q3.m5788s(str), m5865d().m5769y(str2), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0119  */
    @WorkerThread
    /* JADX INFO: renamed from: Z */
    public final zzz m5628Z(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        C1460d.m583w(str);
        C1460d.m583w(str2);
        mo5848b();
        m5684n();
        Cursor cursor = null;
        try {
            try {
                cursorQuery = m5640t().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    String string = cursorQuery.getString(0);
                    try {
                        Object objM5604A = m5604A(cursorQuery, 1);
                        boolean z2 = cursorQuery.getInt(2) != 0;
                        String string2 = cursorQuery.getString(3);
                        long j = cursorQuery.getLong(4);
                        C4163q9 c4163q9M5683m = m5683m();
                        byte[] blob = cursorQuery.getBlob(5);
                        Parcelable.Creator<zzaq> creator = zzaq.CREATOR;
                        zzz zzzVar = new zzz(str, string, new zzku(str2, cursorQuery.getLong(8), objM5604A, string), cursorQuery.getLong(6), z2, string2, (zzaq) c4163q9M5683m.m5843u(blob, creator), j, (zzaq) m5683m().m5843u(cursorQuery.getBlob(7), creator), cursorQuery.getLong(9), (zzaq) m5683m().m5843u(cursorQuery.getBlob(10), creator));
                        if (cursorQuery.moveToNext()) {
                            mo5726g().f11141f.m5862c("Got multiple records for conditional property, expected one", C4157q3.m5788s(str), m5865d().m5769y(str2));
                        }
                        cursorQuery.close();
                        return zzzVar;
                    } catch (SQLiteException e) {
                        e = e;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
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
        } catch (SQLiteException e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        mo5726g().f11141f.m5863d("Error querying conditional property", C4157q3.m5788s(str), m5865d().m5769y(str2), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    @WorkerThread
    /* JADX INFO: renamed from: a0 */
    public final int m5629a0(String str, String str2) {
        C1460d.m583w(str);
        C1460d.m583w(str2);
        mo5848b();
        m5684n();
        try {
            return m5640t().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            mo5726g().f11141f.m5863d("Error deleting conditional property", C4157q3.m5788s(str), m5865d().m5769y(str2), e);
            return 0;
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: b0 */
    public final void m5630b0() {
        m5684n();
        m5640t().beginTransaction();
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00cb  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX INFO: renamed from: c0 */
    public final Map<Integer, List<C3730l0>> m5631c0(String str, String str2) {
        Cursor cursorQuery;
        m5684n();
        mo5848b();
        C1460d.m583w(str);
        C1460d.m583w(str2);
        ArrayMap arrayMap = new ArrayMap();
        ?? r9 = 0;
        try {
            try {
                cursorQuery = m5640t().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        Map<Integer, List<C3730l0>> mapEmptyMap = Collections.emptyMap();
                        cursorQuery.close();
                        return mapEmptyMap;
                    }
                    do {
                        try {
                            C3730l0 c3730l0 = (C3730l0) ((AbstractC3851u4) ((C3730l0.a) C4163q9.m5832x(C3730l0.m5031I(), cursorQuery.getBlob(1))).m5320p());
                            int i = cursorQuery.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), arrayList);
                            }
                            arrayList.add(c3730l0);
                        } catch (IOException e) {
                            mo5726g().f11141f.m5862c("Failed to merge filter. appId", C4157q3.m5788s(str), e);
                        }
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    return arrayMap;
                } catch (SQLiteException e2) {
                    e = e2;
                    mo5726g().f11141f.m5862c("Database error querying filters. appId", C4157q3.m5788s(str), e);
                    if (!C3739l9.m5058b() || !this.f11202a.f11260h.m5532u(str, C4142p.f11031F0)) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    Map<Integer, List<C3730l0>> mapEmptyMap2 = Collections.emptyMap();
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
        } catch (SQLiteException e3) {
            e = e3;
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
    /* JADX INFO: renamed from: d0 */
    public final Map<Integer, List<C3769o0>> m5632d0(String str, String str2) {
        Cursor cursorQuery;
        m5684n();
        mo5848b();
        C1460d.m583w(str);
        C1460d.m583w(str2);
        ArrayMap arrayMap = new ArrayMap();
        ?? r9 = 0;
        try {
            try {
                cursorQuery = m5640t().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        Map<Integer, List<C3769o0>> mapEmptyMap = Collections.emptyMap();
                        cursorQuery.close();
                        return mapEmptyMap;
                    }
                    do {
                        try {
                            C3769o0 c3769o0 = (C3769o0) ((AbstractC3851u4) ((C3769o0.a) C4163q9.m5832x(C3769o0.m5141D(), cursorQuery.getBlob(1))).m5320p());
                            int i = cursorQuery.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), arrayList);
                            }
                            arrayList.add(c3769o0);
                        } catch (IOException e) {
                            mo5726g().f11141f.m5862c("Failed to merge filter", C4157q3.m5788s(str), e);
                        }
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    return arrayMap;
                } catch (SQLiteException e2) {
                    e = e2;
                    mo5726g().f11141f.m5862c("Database error querying filters. appId", C4157q3.m5788s(str), e);
                    if (!C3739l9.m5058b() || !this.f11202a.f11260h.m5532u(str, C4142p.f11031F0)) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    Map<Integer, List<C3769o0>> mapEmptyMap2 = Collections.emptyMap();
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
        } catch (SQLiteException e3) {
            e = e3;
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
    /* JADX INFO: renamed from: e0 */
    public final void m5633e0() {
        m5684n();
        m5640t().endTransaction();
    }

    /* JADX INFO: renamed from: f0 */
    public final long m5634f0(String str) {
        C1460d.m583w(str);
        return m5643w("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    @WorkerThread
    /* JADX INFO: renamed from: g0 */
    public final long m5635g0(String str, String str2) throws Throwable {
        C1460d.m583w(str);
        C1460d.m583w(str2);
        mo5848b();
        m5684n();
        SQLiteDatabase sQLiteDatabaseM5640t = m5640t();
        sQLiteDatabaseM5640t.beginTransaction();
        long j = 0;
        try {
            StringBuilder sb = new StringBuilder(str2.length() + 32);
            sb.append("select ");
            sb.append(str2);
            sb.append(" from app2 where app_id=?");
            try {
                try {
                    long jM5643w = m5643w(sb.toString(), new String[]{str}, -1L);
                    if (jM5643w == -1) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("app_id", str);
                        contentValues.put("first_open_count", (Integer) 0);
                        contentValues.put("previous_install_count", (Integer) 0);
                        if (sQLiteDatabaseM5640t.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                            mo5726g().f11141f.m5862c("Failed to insert column (got -1). appId", C4157q3.m5788s(str), str2);
                            sQLiteDatabaseM5640t.endTransaction();
                            return -1L;
                        }
                        jM5643w = 0;
                        mo5726g().f11141f.m5863d("Error inserting column. appId", C4157q3.m5788s(str), str2, e);
                        sQLiteDatabaseM5640t.endTransaction();
                        return j;
                    }
                    try {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("app_id", str);
                        contentValues2.put(str2, Long.valueOf(1 + jM5643w));
                        if (sQLiteDatabaseM5640t.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                            mo5726g().f11141f.m5862c("Failed to update column (got 0). appId", C4157q3.m5788s(str), str2);
                            sQLiteDatabaseM5640t.endTransaction();
                            return -1L;
                        }
                        sQLiteDatabaseM5640t.setTransactionSuccessful();
                        sQLiteDatabaseM5640t.endTransaction();
                        return jM5643w;
                    } catch (SQLiteException e) {
                        e = e;
                        j = jM5643w;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
                sQLiteDatabaseM5640t.endTransaction();
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00cd  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00ca: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:44:0x00ca */
    /* JADX INFO: renamed from: h0 */
    public final Bundle m5636h0(String str) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor;
        mo5848b();
        m5684n();
        Cursor cursor2 = null;
        try {
            try {
                cursorRawQuery = m5640t().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        mo5726g().f11149n.m5860a("Default event parameters not found");
                        cursorRawQuery.close();
                        return null;
                    }
                    try {
                        C3579a1 c3579a1 = (C3579a1) ((AbstractC3851u4) ((C3579a1.a) C4163q9.m5832x(C3579a1.m4526M(), cursorRawQuery.getBlob(0))).m5320p());
                        m5683m();
                        List<C3607c1> listM4543v = c3579a1.m4543v();
                        Bundle bundle = new Bundle();
                        for (C3607c1 c3607c1 : listM4543v) {
                            String strM4587B = c3607c1.m4587B();
                            if (c3607c1.m4594M()) {
                                bundle.putDouble(strM4587B, c3607c1.m4595N());
                            } else if (c3607c1.m4592K()) {
                                bundle.putFloat(strM4587B, c3607c1.m4593L());
                            } else if (c3607c1.m4588F()) {
                                bundle.putString(strM4587B, c3607c1.m4589G());
                            } else if (c3607c1.m4590I()) {
                                bundle.putLong(strM4587B, c3607c1.m4591J());
                            }
                        }
                        cursorRawQuery.close();
                        return bundle;
                    } catch (IOException e) {
                        mo5726g().f11141f.m5862c("Failed to retrieve default event parameters. appId", C4157q3.m5788s(str), e);
                        cursorRawQuery.close();
                        return null;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    mo5726g().f11141f.m5861b("Error selecting default event parameters", e);
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
        } catch (SQLiteException e3) {
            e = e3;
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
    /* JADX INFO: renamed from: i0 */
    public final void m5637i0() {
        mo5848b();
        m5684n();
        if (m5620R()) {
            long jM5648a = m5867l().f10639i.m5648a();
            Objects.requireNonNull((C3401c) this.f11202a.f11267o);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jM5648a) > C4142p.f11109y.m5693a(null).longValue()) {
                m5867l().f10639i.m5649b(jElapsedRealtime);
                mo5848b();
                m5684n();
                if (m5620R()) {
                    SQLiteDatabase sQLiteDatabaseM5640t = m5640t();
                    Objects.requireNonNull((C3401c) this.f11202a.f11267o);
                    int iDelete = sQLiteDatabaseM5640t.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(System.currentTimeMillis()), String.valueOf(C3992c.m5519B())});
                    if (iDelete > 0) {
                        mo5726g().f11149n.m5861b("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: j0 */
    public final long m5638j0() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = m5640t().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return -1L;
                }
                long j = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j;
            } catch (SQLiteException e) {
                mo5726g().f11141f.m5861b("Error querying raw events", e);
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

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4074i9
    /* JADX INFO: renamed from: p */
    public final boolean mo5515p() {
        return false;
    }

    @WorkerThread
    /* JADX INFO: renamed from: s */
    public final void m5639s() {
        m5684n();
        m5640t().setTransactionSuccessful();
    }

    @WorkerThread
    /* JADX INFO: renamed from: t */
    public final SQLiteDatabase m5640t() {
        mo5848b();
        try {
            return this.f10743l.getWritableDatabase();
        } catch (SQLiteException e) {
            mo5726g().f11144i.m5861b("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    @WorkerThread
    /* JADX INFO: renamed from: u */
    public final String m5641u() throws Throwable {
        Throwable th;
        Cursor cursorRawQuery;
        ?? M5640t = m5640t();
        try {
            try {
                cursorRawQuery = M5640t.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        cursorRawQuery.close();
                        return null;
                    }
                    String string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                    return string;
                } catch (SQLiteException e) {
                    e = e;
                    mo5726g().f11141f.m5861b("Database error getting next bundle app id", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (M5640t != 0) {
                    M5640t.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorRawQuery = null;
        } catch (Throwable th3) {
            th = th3;
            M5640t = 0;
            if (M5640t != 0) {
                M5640t.close();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: v */
    public final long m5642v(C3635e1 c3635e1) throws IOException {
        mo5848b();
        m5684n();
        C1460d.m583w(c3635e1.m4710G1());
        byte[] bArrM5052d = c3635e1.m5052d();
        long jM5842t = m5683m().m5842t(bArrM5052d);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c3635e1.m4710G1());
        contentValues.put("metadata_fingerprint", Long.valueOf(jM5842t));
        contentValues.put("metadata", bArrM5052d);
        try {
            m5640t().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return jM5842t;
        } catch (SQLiteException e) {
            mo5726g().f11141f.m5862c("Error storing raw event metadata. appId", C4157q3.m5788s(c3635e1.m4710G1()), e);
            throw e;
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: w */
    public final long m5643w(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = m5640t().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return j;
                }
                long j2 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j2;
            } catch (SQLiteException e) {
                mo5726g().f11141f.m5862c("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: x */
    public final C4028f m5644x(long j, String str, long j2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        C1460d.m583w(str);
        mo5848b();
        m5684n();
        String[] strArr = {str};
        C4028f c4028f = new C4028f();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseM5640t = m5640t();
                Cursor cursorQuery = sQLiteDatabaseM5640t.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    mo5726g().f11144i.m5861b("Not updating daily counts, app is not known. appId", C4157q3.m5788s(str));
                    cursorQuery.close();
                    return c4028f;
                }
                if (cursorQuery.getLong(0) == j) {
                    c4028f.f10705b = cursorQuery.getLong(1);
                    c4028f.f10704a = cursorQuery.getLong(2);
                    c4028f.f10706c = cursorQuery.getLong(3);
                    c4028f.f10707d = cursorQuery.getLong(4);
                    c4028f.f10708e = cursorQuery.getLong(5);
                }
                if (z2) {
                    c4028f.f10705b += j2;
                }
                if (z3) {
                    c4028f.f10704a += j2;
                }
                if (z4) {
                    c4028f.f10706c += j2;
                }
                if (z5) {
                    c4028f.f10707d += j2;
                }
                if (z6) {
                    c4028f.f10708e += j2;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j));
                contentValues.put("daily_public_events_count", Long.valueOf(c4028f.f10704a));
                contentValues.put("daily_events_count", Long.valueOf(c4028f.f10705b));
                contentValues.put("daily_conversions_count", Long.valueOf(c4028f.f10706c));
                contentValues.put("daily_error_events_count", Long.valueOf(c4028f.f10707d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(c4028f.f10708e));
                sQLiteDatabaseM5640t.update("apps", contentValues, "app_id=?", strArr);
                cursorQuery.close();
                return c4028f;
            } catch (SQLiteException e) {
                mo5726g().f11141f.m5862c("Error updating daily counts. appId", C4157q3.m5788s(str), e);
                if (0 != 0) {
                    cursor.close();
                }
                return c4028f;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: y */
    public final C4028f m5645y(long j, String str, boolean z2, boolean z3) {
        return m5644x(j, str, 1L, false, false, z2, false, z3);
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0143: MOVE (r18 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:64:0x0143 */
    @WorkerThread
    /* JADX INFO: renamed from: z */
    public final C4098l m5646z(String str, String str2) {
        Cursor cursorQuery;
        Cursor cursor;
        Cursor cursor2;
        Boolean boolValueOf;
        C1460d.m583w(str);
        C1460d.m583w(str2);
        mo5848b();
        m5684n();
        Cursor cursor3 = null;
        try {
            try {
                cursorQuery = m5640t().query("events", (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    long j = cursorQuery.getLong(0);
                    long j2 = cursorQuery.getLong(1);
                    long j3 = cursorQuery.getLong(2);
                    long j4 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
                    Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
                    Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
                    Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
                    if (cursorQuery.isNull(7)) {
                        boolValueOf = null;
                    } else {
                        try {
                            boolValueOf = Boolean.valueOf(cursorQuery.getLong(7) == 1);
                        } catch (SQLiteException e) {
                            e = e;
                        }
                    }
                    cursor2 = cursorQuery;
                    try {
                        C4098l c4098l = new C4098l(str, str2, j, j2, cursorQuery.isNull(8) ? 0L : cursorQuery.getLong(8), j3, j4, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                        if (cursor2.moveToNext()) {
                            mo5726g().f11141f.m5861b("Got multiple records for event aggregates, expected one. appId", C4157q3.m5788s(str));
                        }
                        cursor2.close();
                        return c4098l;
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursorQuery = cursor2;
                    } catch (Throwable th) {
                        th = th;
                        cursor3 = cursor2;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursorQuery;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor3 = cursor;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursorQuery = null;
        } catch (Throwable th4) {
            th = th4;
        }
        mo5726g().f11141f.m5863d("Error querying events. appId", C4157q3.m5788s(str), m5865d().m5766u(str2), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }
}
