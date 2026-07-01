package b.i.a.f.i.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.h.l.k0;
import b.i.a.f.h.l.l0;
import b.i.a.f.h.l.m0;
import b.i.a.f.h.l.o0;
import b.i.a.f.h.l.t0;
import b.i.a.f.h.l.u0;
import b.i.a.f.h.l.u4;
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
        AnimatableValueParser.w(str);
        if (this.g.get(str) == null) {
            g gVarQ = q();
            Objects.requireNonNull(gVarQ);
            AnimatableValueParser.w(str);
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
                u0.a aVarT = t(str, blob).t();
                v(str, aVarT);
                this.d.put(str, u((b.i.a.f.h.l.u0) ((b.i.a.f.h.l.u4) aVarT.p())));
                this.g.put(str, (b.i.a.f.h.l.u0) ((b.i.a.f.h.l.u4) aVarT.p()));
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
        AnimatableValueParser.w(str);
        E(str);
        return this.g.get(str);
    }

    @WorkerThread
    public final b.i.a.f.h.l.u0 t(String str, byte[] bArr) {
        if (bArr == null) {
            return b.i.a.f.h.l.u0.G();
        }
        try {
            b.i.a.f.h.l.u0 u0Var = (b.i.a.f.h.l.u0) ((b.i.a.f.h.l.u4) ((u0.a) q9.x(b.i.a.f.h.l.u0.F(), bArr)).p());
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

    public final void v(String str, u0.a aVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        for (int i = 0; i < ((b.i.a.f.h.l.u0) aVar.k).C(); i++) {
            t0.a aVarT = ((b.i.a.f.h.l.u0) aVar.k).u(i).t();
            if (TextUtils.isEmpty(aVarT.q())) {
                g().i.a("EventConfig contained null event name");
            } else {
                String strQ = aVarT.q();
                String strY1 = b.i.a.f.e.o.f.Y1(aVarT.q(), v5.a, v5.c);
                if (!TextUtils.isEmpty(strY1)) {
                    if (aVarT.l) {
                        aVarT.n();
                        aVarT.l = false;
                    }
                    b.i.a.f.h.l.t0.v((b.i.a.f.h.l.t0) aVarT.k, strY1);
                    if (aVar.l) {
                        aVar.n();
                        aVar.l = false;
                    }
                    b.i.a.f.h.l.u0.w((b.i.a.f.h.l.u0) aVar.k, i, (b.i.a.f.h.l.t0) ((b.i.a.f.h.l.u4) aVarT.p()));
                }
                if (b.i.a.f.h.l.x7.b() && this.a.h.o(p.N0)) {
                    arrayMap.put(strQ, Boolean.valueOf(((b.i.a.f.h.l.t0) aVarT.k).w()));
                } else {
                    arrayMap.put(aVarT.q(), Boolean.valueOf(((b.i.a.f.h.l.t0) aVarT.k).w()));
                }
                arrayMap2.put(aVarT.q(), Boolean.valueOf(((b.i.a.f.h.l.t0) aVarT.k).x()));
                if (((b.i.a.f.h.l.t0) aVarT.k).y()) {
                    if (aVarT.r() < 2 || aVarT.r() > 65535) {
                        g().i.c("Invalid sampling rate. Event name, sample rate", aVarT.q(), Integer.valueOf(aVarT.r()));
                    } else {
                        arrayMap3.put(aVarT.q(), Integer.valueOf(aVarT.r()));
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
        AnimatableValueParser.w(str);
        u0.a aVarT = t(str, bArr).t();
        v(str, aVarT);
        this.g.put(str, (b.i.a.f.h.l.u0) ((b.i.a.f.h.l.u4) aVarT.p()));
        this.i.put(str, str2);
        this.d.put(str, u((b.i.a.f.h.l.u0) ((b.i.a.f.h.l.u4) aVarT.p())));
        g gVarQ = q();
        ArrayList<b.i.a.f.h.l.k0> arrayList = new ArrayList(Collections.unmodifiableList(((b.i.a.f.h.l.u0) aVarT.k).D()));
        Objects.requireNonNull(gVarQ);
        String str4 = "app_id=? and audience_id=?";
        String str5 = "null reference";
        int i = 0;
        while (i < arrayList.size()) {
            k0.a aVarT2 = ((b.i.a.f.h.l.k0) arrayList.get(i)).t();
            if (((b.i.a.f.h.l.k0) aVarT2.k).D() != 0) {
                int i2 = 0;
                while (i2 < ((b.i.a.f.h.l.k0) aVarT2.k).D()) {
                    l0.a aVarT3 = ((b.i.a.f.h.l.k0) aVarT2.k).z(i2).t();
                    l0.a aVar = (l0.a) ((u4.b) aVarT3.clone());
                    u0.a aVar2 = aVarT;
                    String strY1 = b.i.a.f.e.o.f.Y1(((b.i.a.f.h.l.l0) aVarT3.k).z(), v5.a, v5.c);
                    if (strY1 != null) {
                        if (aVar.l) {
                            aVar.n();
                            aVar.l = false;
                        }
                        b.i.a.f.h.l.l0.w((b.i.a.f.h.l.l0) aVar.k, strY1);
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    int i3 = 0;
                    while (i3 < ((b.i.a.f.h.l.l0) aVarT3.k).B()) {
                        b.i.a.f.h.l.m0 m0VarU = ((b.i.a.f.h.l.l0) aVarT3.k).u(i3);
                        l0.a aVar3 = aVarT3;
                        String str6 = str4;
                        String str7 = str5;
                        String strY2 = b.i.a.f.e.o.f.Y1(m0VarU.C(), u5.a, u5.f1575b);
                        if (strY2 != null) {
                            m0.a aVarT4 = m0VarU.t();
                            if (aVarT4.l) {
                                aVarT4.n();
                                aVarT4.l = false;
                            }
                            b.i.a.f.h.l.m0.u((b.i.a.f.h.l.m0) aVarT4.k, strY2);
                            b.i.a.f.h.l.m0 m0Var = (b.i.a.f.h.l.m0) ((b.i.a.f.h.l.u4) aVarT4.p());
                            if (aVar.l) {
                                aVar.n();
                                aVar.l = false;
                            }
                            b.i.a.f.h.l.l0.v((b.i.a.f.h.l.l0) aVar.k, i3, m0Var);
                            z4 = true;
                        }
                        i3++;
                        aVarT3 = aVar3;
                        str4 = str6;
                        str5 = str7;
                    }
                    String str8 = str4;
                    String str9 = str5;
                    if (z4) {
                        if (aVarT2.l) {
                            aVarT2.n();
                            aVarT2.l = false;
                        }
                        b.i.a.f.h.l.k0.v((b.i.a.f.h.l.k0) aVarT2.k, i2, (b.i.a.f.h.l.l0) ((b.i.a.f.h.l.u4) aVar.p()));
                        arrayList.set(i, (b.i.a.f.h.l.k0) ((b.i.a.f.h.l.u4) aVarT2.p()));
                    }
                    i2++;
                    aVarT = aVar2;
                    str4 = str8;
                    str5 = str9;
                }
            }
            u0.a aVar4 = aVarT;
            String str10 = str4;
            String str11 = str5;
            if (((b.i.a.f.h.l.k0) aVarT2.k).B() != 0) {
                for (int i4 = 0; i4 < ((b.i.a.f.h.l.k0) aVarT2.k).B(); i4++) {
                    b.i.a.f.h.l.o0 o0VarU = ((b.i.a.f.h.l.k0) aVarT2.k).u(i4);
                    String strY3 = b.i.a.f.e.o.f.Y1(o0VarU.x(), x5.a, x5.f1578b);
                    if (strY3 != null) {
                        o0.a aVarT5 = o0VarU.t();
                        if (aVarT5.l) {
                            aVarT5.n();
                            z3 = false;
                            aVarT5.l = false;
                        } else {
                            z3 = false;
                        }
                        b.i.a.f.h.l.o0.u((b.i.a.f.h.l.o0) aVarT5.k, strY3);
                        if (aVarT2.l) {
                            aVarT2.n();
                            aVarT2.l = z3;
                        }
                        b.i.a.f.h.l.k0.w((b.i.a.f.h.l.k0) aVarT2.k, i4, (b.i.a.f.h.l.o0) ((b.i.a.f.h.l.u4) aVarT5.p()));
                        arrayList.set(i, (b.i.a.f.h.l.k0) ((b.i.a.f.h.l.u4) aVarT2.p()));
                    }
                }
            }
            i++;
            aVarT = aVar4;
            str4 = str10;
            str5 = str11;
        }
        u0.a aVar5 = aVarT;
        String str12 = str4;
        String str13 = str5;
        gVarQ.n();
        gVarQ.b();
        AnimatableValueParser.w(str);
        SQLiteDatabase sQLiteDatabaseT = gVarQ.t();
        sQLiteDatabaseT.beginTransaction();
        try {
            gVarQ.n();
            gVarQ.b();
            AnimatableValueParser.w(str);
            SQLiteDatabase sQLiteDatabaseT2 = gVarQ.t();
            sQLiteDatabaseT2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseT2.delete("event_filters", "app_id=?", new String[]{str});
            for (b.i.a.f.h.l.k0 k0Var : arrayList) {
                gVarQ.n();
                gVarQ.b();
                AnimatableValueParser.w(str);
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
                                        AnimatableValueParser.w(str);
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
                if (aVar5.l) {
                    aVar5.n();
                    aVar5.l = false;
                }
                b.i.a.f.h.l.u0.v((b.i.a.f.h.l.u0) aVar5.k);
                bArrD = ((b.i.a.f.h.l.u0) ((b.i.a.f.h.l.u4) aVar5.p())).d();
            } catch (RuntimeException e) {
                g().i.c("Unable to serialize reduced-size config. Storing full config instead. appId", q3.s(str), e);
                bArrD = bArr;
            }
            g gVarQ2 = q();
            AnimatableValueParser.w(str);
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
            this.g.put(str, (b.i.a.f.h.l.u0) ((b.i.a.f.h.l.u4) aVar5.p()));
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
