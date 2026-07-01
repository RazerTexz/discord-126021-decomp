package b.i.a.f.i.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import b.i.a.f.h.l.k0$a;
import b.i.a.f.h.l.l0$a;
import b.i.a.f.h.l.m0$a;
import b.i.a.f.h.l.o0$a;
import b.i.a.f.h.l.t0$a;
import b.i.a.f.h.l.u0$a;
import b.i.a.f.h.l.u4$b;
import com.google.android.gms.internal.measurement.zzij;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p4 extends i9 implements e {
    public final Map<String, Map<String, String>> d;
    public final Map<String, Map<String, Boolean>> e;
    public final Map<String, Map<String, Boolean>> f;
    public final Map<String, b.i.a.f.h.l.u0> g;
    public final Map<String, Map<String, Integer>> h;
    public final Map<String, String> i;

    public p4(k9 k9Var) {
        super(k9Var);
        this.d = new ArrayMap();
        this.e = new ArrayMap();
        this.f = new ArrayMap();
        this.g = new ArrayMap();
        this.i = new ArrayMap();
        this.h = new ArrayMap();
    }

    public static Map<String, String> u(b.i.a.f.h.l.u0 u0Var) {
        ArrayMap arrayMap = new ArrayMap();
        for (b.i.a.f.h.l.v0 v0Var : u0Var.B()) {
            arrayMap.put(v0Var.u(), v0Var.v());
        }
        return arrayMap;
    }

    @WorkerThread
    public final boolean A(String str) throws Throwable {
        b();
        b.i.a.f.h.l.u0 u0VarS = s(str);
        if (u0VarS == null) {
            return false;
        }
        return u0VarS.E();
    }

    @WorkerThread
    public final long B(String str) throws Throwable {
        String strH = h(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(strH)) {
            return 0L;
        }
        try {
            return Long.parseLong(strH);
        } catch (NumberFormatException e) {
            g().i.c("Unable to parse timezone offset. appId", q3.s(str), e);
            return 0L;
        }
    }

    public final boolean C(String str) {
        return "1".equals(h(str, "measurement.upload.blacklist_internal"));
    }

    public final boolean D(String str) {
        return "1".equals(h(str, "measurement.upload.blacklist_public"));
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00d6  */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00d3: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:28:0x00d3 */
    @WorkerThread
    public final void E(String str) throws Throwable {
        SQLiteException e;
        Cursor cursorQuery;
        Cursor cursor;
        byte[] blob;
        n();
        b();
        b.c.a.a0.d.w(str);
        if (this.g.get(str) == null) {
            g gVarQ = q();
            Objects.requireNonNull(gVarQ);
            b.c.a.a0.d.w(str);
            gVarQ.b();
            gVarQ.n();
            Cursor cursor2 = null;
            try {
                try {
                    cursorQuery = gVarQ.t().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
                    try {
                        if (cursorQuery.moveToFirst()) {
                            blob = cursorQuery.getBlob(0);
                            if (cursorQuery.moveToNext()) {
                                gVarQ.g().f.b("Got multiple records for app config, expected one. appId", q3.s(str));
                            }
                            cursorQuery.close();
                        } else {
                            cursorQuery.close();
                            blob = null;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        gVarQ.g().f.c("Error querying remote config. appId", q3.s(str), e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
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
            if (blob != null) {
                u0$a u0_aT = t(str, blob).t();
                v(str, u0_aT);
                this.d.put(str, u((b.i.a.f.h.l.u0) ((b.i.a.f.h.l.u4) u0_aT.p())));
                this.g.put(str, (b.i.a.f.h.l.u0) ((b.i.a.f.h.l.u4) u0_aT.p()));
                this.i.put(str, null);
                return;
            }
            this.d.put(str, null);
            this.e.put(str, null);
            this.f.put(str, null);
            this.g.put(str, null);
            this.i.put(str, null);
            this.h.put(str, null);
        }
    }

    @Override // b.i.a.f.i.b.e
    @WorkerThread
    public final String h(String str, String str2) throws Throwable {
        b();
        E(str);
        Map<String, String> map = this.d.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @Override // b.i.a.f.i.b.i9
    public final boolean p() {
        return false;
    }

    @WorkerThread
    public final b.i.a.f.h.l.u0 s(String str) throws Throwable {
        n();
        b();
        b.c.a.a0.d.w(str);
        E(str);
        return this.g.get(str);
    }

    @WorkerThread
    public final b.i.a.f.h.l.u0 t(String str, byte[] bArr) {
        if (bArr == null) {
            return b.i.a.f.h.l.u0.G();
        }
        try {
            b.i.a.f.h.l.u0 u0Var = (b.i.a.f.h.l.u0) ((b.i.a.f.h.l.u4) ((u0$a) q9.x(b.i.a.f.h.l.u0.F(), bArr)).p());
            g().n.c("Parsed config. version, gmp_app_id", u0Var.x() ? Long.valueOf(u0Var.y()) : null, u0Var.z() ? u0Var.A() : null);
            return u0Var;
        } catch (zzij e) {
            g().i.c("Unable to merge remote config. appId", q3.s(str), e);
            return b.i.a.f.h.l.u0.G();
        } catch (RuntimeException e2) {
            g().i.c("Unable to merge remote config. appId", q3.s(str), e2);
            return b.i.a.f.h.l.u0.G();
        }
    }

    public final void v(String str, u0$a u0_a) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        for (int i = 0; i < ((b.i.a.f.h.l.u0) u0_a.k).C(); i++) {
            t0$a t0_aT = ((b.i.a.f.h.l.u0) u0_a.k).u(i).t();
            if (TextUtils.isEmpty(t0_aT.q())) {
                g().i.a("EventConfig contained null event name");
            } else {
                String strQ = t0_aT.q();
                String strY1 = b.i.a.f.e.o.f.Y1(t0_aT.q(), v5.a, v5.c);
                if (!TextUtils.isEmpty(strY1)) {
                    if (t0_aT.l) {
                        t0_aT.n();
                        t0_aT.l = false;
                    }
                    b.i.a.f.h.l.t0.v((b.i.a.f.h.l.t0) t0_aT.k, strY1);
                    if (u0_a.l) {
                        u0_a.n();
                        u0_a.l = false;
                    }
                    b.i.a.f.h.l.u0.w((b.i.a.f.h.l.u0) u0_a.k, i, (b.i.a.f.h.l.t0) ((b.i.a.f.h.l.u4) t0_aT.p()));
                }
                if (b.i.a.f.h.l.x7.b() && this.a.h.o(p.N0)) {
                    arrayMap.put(strQ, Boolean.valueOf(((b.i.a.f.h.l.t0) t0_aT.k).w()));
                } else {
                    arrayMap.put(t0_aT.q(), Boolean.valueOf(((b.i.a.f.h.l.t0) t0_aT.k).w()));
                }
                arrayMap2.put(t0_aT.q(), Boolean.valueOf(((b.i.a.f.h.l.t0) t0_aT.k).x()));
                if (((b.i.a.f.h.l.t0) t0_aT.k).y()) {
                    if (t0_aT.r() < 2 || t0_aT.r() > 65535) {
                        g().i.c("Invalid sampling rate. Event name, sample rate", t0_aT.q(), Integer.valueOf(t0_aT.r()));
                    } else {
                        arrayMap3.put(t0_aT.q(), Integer.valueOf(t0_aT.r()));
                    }
                }
            }
        }
        this.e.put(str, arrayMap);
        this.f.put(str, arrayMap2);
        this.h.put(str, arrayMap3);
    }

    @WorkerThread
    public final boolean w(String str, byte[] bArr, String str2) {
        byte[] bArrD;
        boolean z2;
        String str3;
        boolean z3;
        boolean z4;
        n();
        b();
        b.c.a.a0.d.w(str);
        u0$a u0_aT = t(str, bArr).t();
        v(str, u0_aT);
        this.g.put(str, (b.i.a.f.h.l.u0) ((b.i.a.f.h.l.u4) u0_aT.p()));
        this.i.put(str, str2);
        this.d.put(str, u((b.i.a.f.h.l.u0) ((b.i.a.f.h.l.u4) u0_aT.p())));
        g gVarQ = q();
        ArrayList<b.i.a.f.h.l.k0> arrayList = new ArrayList(Collections.unmodifiableList(((b.i.a.f.h.l.u0) u0_aT.k).D()));
        Objects.requireNonNull(gVarQ);
        String str4 = "app_id=? and audience_id=?";
        String str5 = "null reference";
        int i = 0;
        while (i < arrayList.size()) {
            k0$a k0_aT = ((b.i.a.f.h.l.k0) arrayList.get(i)).t();
            if (((b.i.a.f.h.l.k0) k0_aT.k).D() != 0) {
                int i2 = 0;
                while (i2 < ((b.i.a.f.h.l.k0) k0_aT.k).D()) {
                    l0$a l0_aT = ((b.i.a.f.h.l.k0) k0_aT.k).z(i2).t();
                    l0$a l0_a = (l0$a) ((u4$b) l0_aT.clone());
                    u0$a u0_a = u0_aT;
                    String strY1 = b.i.a.f.e.o.f.Y1(((b.i.a.f.h.l.l0) l0_aT.k).z(), v5.a, v5.c);
                    if (strY1 != null) {
                        if (l0_a.l) {
                            l0_a.n();
                            l0_a.l = false;
                        }
                        b.i.a.f.h.l.l0.w((b.i.a.f.h.l.l0) l0_a.k, strY1);
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    int i3 = 0;
                    while (i3 < ((b.i.a.f.h.l.l0) l0_aT.k).B()) {
                        b.i.a.f.h.l.m0 m0VarU = ((b.i.a.f.h.l.l0) l0_aT.k).u(i3);
                        l0$a l0_a2 = l0_aT;
                        String str6 = str4;
                        String str7 = str5;
                        String strY2 = b.i.a.f.e.o.f.Y1(m0VarU.C(), u5.a, u5.f1575b);
                        if (strY2 != null) {
                            m0$a m0_aT = m0VarU.t();
                            if (m0_aT.l) {
                                m0_aT.n();
                                m0_aT.l = false;
                            }
                            b.i.a.f.h.l.m0.u((b.i.a.f.h.l.m0) m0_aT.k, strY2);
                            b.i.a.f.h.l.m0 m0Var = (b.i.a.f.h.l.m0) ((b.i.a.f.h.l.u4) m0_aT.p());
                            if (l0_a.l) {
                                l0_a.n();
                                l0_a.l = false;
                            }
                            b.i.a.f.h.l.l0.v((b.i.a.f.h.l.l0) l0_a.k, i3, m0Var);
                            z4 = true;
                        }
                        i3++;
                        l0_aT = l0_a2;
                        str4 = str6;
                        str5 = str7;
                    }
                    String str8 = str4;
                    String str9 = str5;
                    if (z4) {
                        if (k0_aT.l) {
                            k0_aT.n();
                            k0_aT.l = false;
                        }
                        b.i.a.f.h.l.k0.v((b.i.a.f.h.l.k0) k0_aT.k, i2, (b.i.a.f.h.l.l0) ((b.i.a.f.h.l.u4) l0_a.p()));
                        arrayList.set(i, (b.i.a.f.h.l.k0) ((b.i.a.f.h.l.u4) k0_aT.p()));
                    }
                    i2++;
                    u0_aT = u0_a;
                    str4 = str8;
                    str5 = str9;
                }
            }
            u0$a u0_a2 = u0_aT;
            String str10 = str4;
            String str11 = str5;
            if (((b.i.a.f.h.l.k0) k0_aT.k).B() != 0) {
                for (int i4 = 0; i4 < ((b.i.a.f.h.l.k0) k0_aT.k).B(); i4++) {
                    b.i.a.f.h.l.o0 o0VarU = ((b.i.a.f.h.l.k0) k0_aT.k).u(i4);
                    String strY3 = b.i.a.f.e.o.f.Y1(o0VarU.x(), x5.a, x5.f1578b);
                    if (strY3 != null) {
                        o0$a o0_aT = o0VarU.t();
                        if (o0_aT.l) {
                            o0_aT.n();
                            z3 = false;
                            o0_aT.l = false;
                        } else {
                            z3 = false;
                        }
                        b.i.a.f.h.l.o0.u((b.i.a.f.h.l.o0) o0_aT.k, strY3);
                        if (k0_aT.l) {
                            k0_aT.n();
                            k0_aT.l = z3;
                        }
                        b.i.a.f.h.l.k0.w((b.i.a.f.h.l.k0) k0_aT.k, i4, (b.i.a.f.h.l.o0) ((b.i.a.f.h.l.u4) o0_aT.p()));
                        arrayList.set(i, (b.i.a.f.h.l.k0) ((b.i.a.f.h.l.u4) k0_aT.p()));
                    }
                }
            }
            i++;
            u0_aT = u0_a2;
            str4 = str10;
            str5 = str11;
        }
        u0$a u0_a3 = u0_aT;
        String str12 = str4;
        String str13 = str5;
        gVarQ.n();
        gVarQ.b();
        b.c.a.a0.d.w(str);
        SQLiteDatabase sQLiteDatabaseT = gVarQ.t();
        sQLiteDatabaseT.beginTransaction();
        try {
            gVarQ.n();
            gVarQ.b();
            b.c.a.a0.d.w(str);
            SQLiteDatabase sQLiteDatabaseT2 = gVarQ.t();
            sQLiteDatabaseT2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseT2.delete("event_filters", "app_id=?", new String[]{str});
            for (b.i.a.f.h.l.k0 k0Var : arrayList) {
                gVarQ.n();
                gVarQ.b();
                b.c.a.a0.d.w(str);
                str13 = str13;
                Objects.requireNonNull(k0Var, str13);
                if (k0Var.x()) {
                    int iY = k0Var.y();
                    Iterator<b.i.a.f.h.l.l0> it = k0Var.C().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            Iterator<b.i.a.f.h.l.o0> it2 = k0Var.A().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    Iterator<b.i.a.f.h.l.l0> it3 = k0Var.C().iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            z2 = true;
                                            break;
                                        }
                                        if (!gVarQ.O(str, iY, it3.next())) {
                                            z2 = false;
                                            break;
                                        }
                                    }
                                    if (z2) {
                                        Iterator<b.i.a.f.h.l.o0> it4 = k0Var.A().iterator();
                                        while (it4.hasNext()) {
                                            if (!gVarQ.P(str, iY, it4.next())) {
                                                z2 = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (z2) {
                                        str3 = str12;
                                    } else {
                                        gVarQ.n();
                                        gVarQ.b();
                                        b.c.a.a0.d.w(str);
                                        SQLiteDatabase sQLiteDatabaseT3 = gVarQ.t();
                                        str3 = str12;
                                        sQLiteDatabaseT3.delete("property_filters", str3, new String[]{str, String.valueOf(iY)});
                                        sQLiteDatabaseT3.delete("event_filters", str3, new String[]{str, String.valueOf(iY)});
                                    }
                                    str12 = str3;
                                    break;
                                }
                                if (!it2.next().v()) {
                                    gVarQ.g().i.c("Property filter with no ID. Audience definition ignored. appId, audienceId", q3.s(str), Integer.valueOf(iY));
                                }
                            }
                        } else if (!it.next().x()) {
                            gVarQ.g().i.c("Event filter with no ID. Audience definition ignored. appId, audienceId", q3.s(str), Integer.valueOf(iY));
                        }
                    }
                } else {
                    gVarQ.g().i.b("Audience with no ID. appId", q3.s(str));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (b.i.a.f.h.l.k0 k0Var2 : arrayList) {
                arrayList2.add(k0Var2.x() ? Integer.valueOf(k0Var2.y()) : null);
            }
            gVarQ.W(str, arrayList2);
            sQLiteDatabaseT.setTransactionSuccessful();
            sQLiteDatabaseT.endTransaction();
            try {
                if (u0_a3.l) {
                    u0_a3.n();
                    u0_a3.l = false;
                }
                b.i.a.f.h.l.u0.v((b.i.a.f.h.l.u0) u0_a3.k);
                bArrD = ((b.i.a.f.h.l.u0) ((b.i.a.f.h.l.u4) u0_a3.p())).d();
            } catch (RuntimeException e) {
                g().i.c("Unable to serialize reduced-size config. Storing full config instead. appId", q3.s(str), e);
                bArrD = bArr;
            }
            g gVarQ2 = q();
            b.c.a.a0.d.w(str);
            gVarQ2.b();
            gVarQ2.n();
            ContentValues contentValues = new ContentValues();
            contentValues.put("remote_config", bArrD);
            try {
                if (gVarQ2.t().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                    gVarQ2.g().f.b("Failed to update remote config (got 0). appId", q3.s(str));
                }
            } catch (SQLiteException e2) {
                gVarQ2.g().f.c("Error storing remote config. appId", q3.s(str), e2);
            }
            this.g.put(str, (b.i.a.f.h.l.u0) ((b.i.a.f.h.l.u4) u0_a3.p()));
            return true;
        } catch (Throwable th) {
            sQLiteDatabaseT.endTransaction();
            throw th;
        }
    }

    @WorkerThread
    public final boolean x(String str, String str2) throws Throwable {
        Boolean bool;
        b();
        E(str);
        if ("1".equals(h(str, "measurement.upload.blacklist_internal")) && t9.r0(str2)) {
            return true;
        }
        if ("1".equals(h(str, "measurement.upload.blacklist_public")) && t9.X(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.e.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WorkerThread
    public final boolean y(String str, String str2) throws Throwable {
        Boolean bool;
        b();
        E(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WorkerThread
    public final int z(String str, String str2) throws Throwable {
        Integer num;
        b();
        E(str);
        Map<String, Integer> map = this.h.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }
}
