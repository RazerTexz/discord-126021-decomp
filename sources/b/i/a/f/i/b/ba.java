package b.i.a.f.i.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import b.i.a.f.h.l.g1$a;
import b.i.a.f.h.l.l0$a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class ba extends i9 {
    public String d;
    public Set<Integer> e;
    public Map<Integer, da> f;
    public Long g;
    public Long h;

    public ba(k9 k9Var) {
        super(k9Var);
    }

    @Override // b.i.a.f.i.b.i9
    public final boolean p() {
        return false;
    }

    public final da s(int i) {
        if (this.f.containsKey(Integer.valueOf(i))) {
            return this.f.get(Integer.valueOf(i));
        }
        da daVar = new da(this, this.d, null);
        this.f.put(Integer.valueOf(i), daVar);
        return daVar;
    }

    /* JADX WARN: Code duplicated, block: B:251:0x0574  */
    /* JADX WARN: Code duplicated, block: B:282:0x0639  */
    /* JADX WARN: Code duplicated, block: B:285:0x064e  */
    /* JADX WARN: Code duplicated, block: B:289:0x0670  */
    /* JADX WARN: Code duplicated, block: B:290:0x06a9  */
    /* JADX WARN: Code duplicated, block: B:293:0x06f3  */
    /* JADX WARN: Code duplicated, block: B:295:0x0703  */
    /* JADX WARN: Code duplicated, block: B:298:0x0714  */
    /* JADX WARN: Code duplicated, block: B:300:0x0718  */
    /* JADX WARN: Code duplicated, block: B:302:0x0722  */
    /* JADX WARN: Code duplicated, block: B:306:0x0732  */
    /* JADX WARN: Code duplicated, block: B:312:0x076b  */
    /* JADX WARN: Code duplicated, block: B:314:0x079c A[LOOP:12: B:310:0x0765->B:314:0x079c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:318:0x07bc  */
    /* JADX WARN: Code duplicated, block: B:323:0x07d8  */
    /* JADX WARN: Code duplicated, block: B:326:0x07e7  */
    /* JADX WARN: Code duplicated, block: B:328:0x07f9  */
    /* JADX WARN: Code duplicated, block: B:338:0x082f  */
    /* JADX WARN: Code duplicated, block: B:341:0x0853  */
    /* JADX WARN: Code duplicated, block: B:344:0x0868  */
    /* JADX WARN: Code duplicated, block: B:346:0x0879  */
    /* JADX WARN: Code duplicated, block: B:348:0x0889  */
    /* JADX WARN: Code duplicated, block: B:349:0x0896  */
    /* JADX WARN: Code duplicated, block: B:351:0x08c0  */
    /* JADX WARN: Code duplicated, block: B:363:0x0915  */
    /* JADX WARN: Code duplicated, block: B:364:0x091e  */
    /* JADX WARN: Code duplicated, block: B:368:0x0930  */
    /* JADX WARN: Code duplicated, block: B:373:0x0959  */
    /* JADX WARN: Code duplicated, block: B:389:0x09e0  */
    /* JADX WARN: Code duplicated, block: B:454:0x065c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:456:0x0648 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:459:0x0756 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:460:0x0748 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:464:0x07b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:465:0x07aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:467:0x0845 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:472:0x0939 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:476:0x092a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:478:0x09b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:480:0x0953 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x0184  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v65 */
    /* JADX WARN: Type inference failed for: r7v66, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v67 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @WorkerThread
    public final List<b.i.a.f.h.l.y0> t(String str, List<b.i.a.f.h.l.a1> list, List<b.i.a.f.h.l.i1> list2, Long l, Long l2) throws Throwable {
        int i;
        int i2;
        boolean z2;
        String str2;
        Object obj;
        Map map;
        Object obj2;
        ?? r7;
        Cursor cursorQuery;
        Map mapEmptyMap;
        Map map2;
        String str3;
        String str4;
        ArrayList arrayList;
        Iterator<Integer> it;
        g gVarQ;
        String str5;
        ContentValues contentValues;
        ArrayMap arrayMap;
        String strD;
        Map<Integer, List<b.i.a.f.h.l.o0>> mapD0;
        Iterator<Integer> it2;
        int iIntValue;
        Iterator<b.i.a.f.h.l.o0> it3;
        boolean zI;
        b.i.a.f.h.l.o0 next;
        Integer numValueOf;
        ha haVar;
        Integer numValueOf2;
        ca caVar;
        ArrayMap arrayMap2;
        Iterator<b.i.a.f.h.l.a1> it4;
        b.i.a.f.h.l.a1 next2;
        b.i.a.f.h.l.a1 a1VarA;
        g gVarQ2;
        String str6;
        String strF;
        l lVarZ;
        l lVar;
        long j;
        String strF2;
        Map<Integer, List<b.i.a.f.h.l.l0>> mapC0;
        ca caVar2;
        Iterator<Integer> it5;
        int iIntValue2;
        Iterator<b.i.a.f.h.l.l0> it6;
        boolean zI2;
        Iterator<Integer> it7;
        ArrayMap arrayMap3;
        Iterator<b.i.a.f.h.l.a1> it8;
        fa faVar;
        Map map3;
        List<b.i.a.f.h.l.l0> list3;
        boolean z3;
        ?? r8;
        Cursor cursorRawQuery;
        ?? r9;
        Cursor cursorQuery2;
        b.c.a.a0.d.w(str);
        Objects.requireNonNull(list, "null reference");
        Objects.requireNonNull(list2, "null reference");
        this.d = str;
        this.e = new HashSet();
        this.f = new ArrayMap();
        this.g = l;
        this.h = l2;
        Iterator<b.i.a.f.h.l.a1> it9 = list.iterator();
        while (true) {
            i = 1;
            i2 = 0;
            if (!it9.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(it9.next().F())) {
                z2 = true;
                break;
            }
        }
        boolean z4 = b.i.a.f.h.l.f9.b() && this.a.h.u(this.d, p.f1554c0);
        boolean z5 = b.i.a.f.h.l.f9.b() && this.a.h.u(this.d, p.f1553b0);
        if (z2) {
            g gVarQ3 = q();
            String str7 = this.d;
            gVarQ3.n();
            gVarQ3.b();
            b.c.a.a0.d.w(str7);
            ContentValues contentValues2 = new ContentValues();
            str2 = "current_session_count";
            contentValues2.put("current_session_count", (Integer) 0);
            try {
                SQLiteDatabase sQLiteDatabaseT = gVarQ3.t();
                str2 = "events";
                sQLiteDatabaseT.update("events", contentValues2, "app_id = ?", new String[]{str7});
                obj = sQLiteDatabaseT;
            } catch (SQLiteException e) {
                gVarQ3.g().f.c("Error resetting session-scoped event counts. appId", q3.s(str7), e);
                obj = "Error resetting session-scoped event counts. appId";
            }
        }
        Map mapEmptyMap2 = Collections.emptyMap();
        String str8 = "audience_id";
        Object obj3 = obj;
        obj3 = obj;
        if (z5 && z4) {
            g gVarQ4 = q();
            String str9 = this.d;
            Objects.requireNonNull(gVarQ4);
            b.c.a.a0.d.w(str9);
            ArrayMap arrayMap4 = new ArrayMap();
            try {
                try {
                    cursorQuery2 = gVarQ4.t().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str9}, null, null, null);
                    try {
                        if (cursorQuery2.moveToFirst()) {
                            while (true) {
                                try {
                                    b.i.a.f.h.l.l0 l0Var = (b.i.a.f.h.l.l0) ((b.i.a.f.h.l.u4) ((l0$a) q9.x(b.i.a.f.h.l.l0.I(), cursorQuery2.getBlob(1))).p());
                                    if (l0Var.C()) {
                                        int i3 = cursorQuery2.getInt(i2);
                                        List arrayList2 = (List) arrayMap4.get(Integer.valueOf(i3));
                                        if (arrayList2 == null) {
                                            arrayList2 = new ArrayList();
                                            arrayMap4.put(Integer.valueOf(i3), arrayList2);
                                        }
                                        arrayList2.add(l0Var);
                                    }
                                } catch (IOException e2) {
                                    gVarQ4.g().f.c("Failed to merge filter. appId", q3.s(str9), e2);
                                }
                                if (!cursorQuery2.moveToNext()) {
                                    break;
                                }
                                i2 = 0;
                            }
                            cursorQuery2.close();
                            map = arrayMap4;
                            obj2 = arrayMap4;
                        } else {
                            mapEmptyMap2 = Collections.emptyMap();
                            cursorQuery2.close();
                            obj3 = arrayMap4;
                            map = mapEmptyMap2;
                            obj2 = obj3;
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                        gVarQ4.g().f.c("Database error querying filters. appId", q3.s(str9), e);
                        mapEmptyMap2 = Collections.emptyMap();
                        obj3 = "Database error querying filters. appId";
                        if (cursorQuery2 != null) {
                            cursorQuery2.close();
                            obj3 = "Database error querying filters. appId";
                        }
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
                cursorQuery2 = null;
            } catch (Throwable th2) {
                th = th2;
                r9 = 0;
                if (r9 != 0) {
                    r9.close();
                }
                throw th;
            }
        } else {
            map = mapEmptyMap2;
            obj2 = obj3;
        }
        g gVarQ5 = q();
        String str10 = this.d;
        gVarQ5.n();
        gVarQ5.b();
        b.c.a.a0.d.w(str10);
        try {
            try {
                cursorQuery = gVarQ5.t().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str10}, null, null, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        ArrayMap arrayMap5 = new ArrayMap();
                        int i4 = 0;
                        while (true) {
                            int i5 = cursorQuery.getInt(i4);
                            try {
                                arrayMap5.put(Integer.valueOf(i5), (b.i.a.f.h.l.g1) ((b.i.a.f.h.l.u4) ((g1$a) q9.x(b.i.a.f.h.l.g1.M(), cursorQuery.getBlob(i))).p()));
                            } catch (IOException e5) {
                                gVarQ5.g().f.d("Failed to merge filter results. appId, audienceId, error", q3.s(str10), Integer.valueOf(i5), e5);
                            }
                            if (!cursorQuery.moveToNext()) {
                                break;
                            }
                            arrayMap5 = arrayMap5;
                            i4 = 0;
                            i = 1;
                        }
                        cursorQuery.close();
                        map2 = arrayMap5;
                    } else if (b.i.a.f.h.l.l9.b() && gVarQ5.a.h.u(str10, p.F0)) {
                        mapEmptyMap = Collections.emptyMap();
                        cursorQuery.close();
                        map2 = mapEmptyMap;
                    } else {
                        cursorQuery.close();
                        map2 = null;
                    }
                } catch (SQLiteException e6) {
                    e = e6;
                    gVarQ5.g().f.c("Database error querying filter results. appId", q3.s(str10), e);
                    if (!b.i.a.f.h.l.l9.b() || !gVarQ5.a.h.u(str10, p.F0)) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        map2 = null;
                        if (b.i.a.f.h.l.l9.b()) {
                        }
                        str3 = "audience_id";
                        str4 = "Skipping failed audience ID";
                        if (!list.isEmpty()) {
                            caVar = new ca(this, null);
                            arrayMap2 = new ArrayMap();
                            it4 = list.iterator();
                            while (it4.hasNext()) {
                                next2 = it4.next();
                                a1VarA = caVar.a(this.d, next2);
                                if (a1VarA != null) {
                                    gVarQ2 = q();
                                    str6 = this.d;
                                    strF = a1VarA.F();
                                    lVarZ = gVarQ2.z(str6, next2.F());
                                    if (lVarZ == null) {
                                        gVarQ2.g().i.c("Event aggregate wasn't created during raw event logging. appId, event", q3.s(str6), gVarQ2.d().u(strF));
                                        lVar = new l(str6, next2.F(), 1L, 1L, 1L, next2.H(), 0L, null, null, null, null);
                                    } else {
                                        lVar = new l(lVarZ.a, lVarZ.f1548b, lVarZ.c + 1, lVarZ.d + 1, lVarZ.e + 1, lVarZ.f, lVarZ.g, lVarZ.h, lVarZ.i, lVarZ.j, lVarZ.k);
                                    }
                                    q().H(lVar);
                                    j = lVar.c;
                                    strF2 = a1VarA.F();
                                    mapC0 = (Map) arrayMap2.get(strF2);
                                    if (mapC0 == null) {
                                        mapC0 = q().c0(this.d, strF2);
                                        if (b.i.a.f.h.l.l9.b()) {
                                            caVar2 = caVar;
                                            if (!this.a.h.u(this.d, p.F0)) {
                                            }
                                            arrayMap2.put(strF2, mapC0);
                                        } else {
                                            caVar2 = caVar;
                                        }
                                        if (mapC0 == null) {
                                            mapC0 = new ArrayMap();
                                        }
                                        arrayMap2.put(strF2, mapC0);
                                    } else {
                                        caVar2 = caVar;
                                    }
                                    it5 = mapC0.keySet().iterator();
                                    while (it5.hasNext()) {
                                        iIntValue2 = it5.next().intValue();
                                        if (this.e.contains(Integer.valueOf(iIntValue2))) {
                                            g().n.b("Skipping failed audience ID", Integer.valueOf(iIntValue2));
                                        } else {
                                            it6 = mapC0.get(Integer.valueOf(iIntValue2)).iterator();
                                            zI2 = true;
                                            while (true) {
                                                if (it6.hasNext()) {
                                                    it7 = it5;
                                                    arrayMap3 = arrayMap2;
                                                    it8 = it4;
                                                    break;
                                                }
                                                b.i.a.f.h.l.l0 next3 = it6.next();
                                                it7 = it5;
                                                arrayMap3 = arrayMap2;
                                                faVar = new fa(this, this.d, iIntValue2, next3);
                                                it8 = it4;
                                                zI2 = faVar.i(this.g, this.h, a1VarA, j, lVar, u(iIntValue2, next3.y()));
                                                if (zI2) {
                                                    this.e.add(Integer.valueOf(iIntValue2));
                                                    break;
                                                }
                                                s(iIntValue2).b(faVar);
                                                it5 = it7;
                                                arrayMap2 = arrayMap3;
                                                it4 = it8;
                                            }
                                            if (!zI2) {
                                                this.e.add(Integer.valueOf(iIntValue2));
                                            }
                                            it5 = it7;
                                            arrayMap2 = arrayMap3;
                                            it4 = it8;
                                        }
                                    }
                                    caVar = caVar2;
                                }
                            }
                        }
                        if (!list2.isEmpty()) {
                            arrayMap = new ArrayMap();
                            while (r2.hasNext()) {
                                strD = i1Var.D();
                                mapD0 = (Map) arrayMap.get(strD);
                                if (mapD0 == null) {
                                    mapD0 = q().d0(this.d, strD);
                                    mapD0 = b.i.a.f.h.l.l9.b() ? new ArrayMap<>() : new ArrayMap<>();
                                    arrayMap.put(strD, mapD0);
                                }
                                it2 = mapD0.keySet().iterator();
                                while (it2.hasNext()) {
                                    iIntValue = it2.next().intValue();
                                    if (this.e.contains(Integer.valueOf(iIntValue))) {
                                        g().n.b(str4, Integer.valueOf(iIntValue));
                                        break;
                                    }
                                    it3 = mapD0.get(Integer.valueOf(iIntValue)).iterator();
                                    zI = true;
                                    while (true) {
                                        if (it3.hasNext()) {
                                            arrayMap = arrayMap;
                                            str4 = str4;
                                            break;
                                        }
                                        next = it3.next();
                                        if (g().x(2)) {
                                            s3 s3Var = g().n;
                                            Integer numValueOf3 = Integer.valueOf(iIntValue);
                                            if (next.v()) {
                                                numValueOf2 = Integer.valueOf(next.w());
                                            } else {
                                                numValueOf2 = null;
                                            }
                                            s3Var.d("Evaluating filter. audience, filter, property", numValueOf3, numValueOf2, d().y(next.x()));
                                            g().n.b("Filter definition", m().y(next));
                                        } else {
                                            arrayMap = arrayMap;
                                        }
                                        if (next.v()) {
                                        }
                                        s3 s3Var2 = g().i;
                                        Object objS = q3.s(this.d);
                                        if (next.v()) {
                                            numValueOf = Integer.valueOf(next.w());
                                        } else {
                                            numValueOf = null;
                                        }
                                        s3Var2.c("Invalid property filter ID. appId, id", objS, String.valueOf(numValueOf));
                                        zI = false;
                                        break;
                                        if (!zI) {
                                            this.e.add(Integer.valueOf(iIntValue));
                                        }
                                        arrayMap = arrayMap;
                                        str4 = str4;
                                        s(iIntValue).b(haVar);
                                        arrayMap = arrayMap;
                                        str4 = str4;
                                    }
                                }
                            }
                        }
                        arrayList = new ArrayList();
                        Set<Integer> setKeySet = this.f.keySet();
                        setKeySet.removeAll(this.e);
                        it = setKeySet.iterator();
                        while (it.hasNext()) {
                            int iIntValue3 = it.next().intValue();
                            b.i.a.f.h.l.y0 y0VarA = this.f.get(Integer.valueOf(iIntValue3)).a(iIntValue3);
                            arrayList.add(y0VarA);
                            gVarQ = q();
                            str5 = this.d;
                            b.i.a.f.h.l.g1 g1VarA = y0VarA.A();
                            gVarQ.n();
                            gVarQ.b();
                            b.c.a.a0.d.w(str5);
                            Objects.requireNonNull(g1VarA, "null reference");
                            byte[] bArrD = g1VarA.d();
                            contentValues = new ContentValues();
                            contentValues.put("app_id", str5);
                            contentValues.put(str3, Integer.valueOf(iIntValue3));
                            contentValues.put("current_results", bArrD);
                            try {
                                try {
                                    if (gVarQ.t().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                        gVarQ.g().f.b("Failed to insert filter results (got -1). appId", q3.s(str5));
                                    }
                                } catch (SQLiteException e7) {
                                    e = e7;
                                    gVarQ.g().f.c("Error storing filter results. appId", q3.s(str5), e);
                                }
                            } catch (SQLiteException e8) {
                                e = e8;
                            }
                        }
                        return arrayList;
                    }
                    mapEmptyMap = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                r7 = obj2;
                if (r7 != 0) {
                    r7.close();
                }
                throw th;
            }
        } catch (SQLiteException e9) {
            e = e9;
            cursorQuery = null;
        } catch (Throwable th4) {
            th = th4;
            r7 = 0;
            if (r7 != 0) {
                r7.close();
            }
            throw th;
        }
        if (((b.i.a.f.h.l.l9.b() || !this.a.h.u(this.d, p.F0)) && map2 == null) || map2.isEmpty()) {
            str3 = "audience_id";
        } else {
            HashSet hashSet = new HashSet(map2.keySet());
            if (z2) {
                String str11 = this.d;
                b.c.a.a0.d.w(str11);
                ArrayMap arrayMap6 = new ArrayMap();
                if (!map2.isEmpty()) {
                    g gVarQ6 = q();
                    gVarQ6.n();
                    gVarQ6.b();
                    b.c.a.a0.d.w(str11);
                    Map arrayMap7 = new ArrayMap();
                    SQLiteDatabase sQLiteDatabaseT2 = gVarQ6.t();
                    try {
                        try {
                            cursorRawQuery = sQLiteDatabaseT2.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str11, str11});
                            try {
                                if (cursorRawQuery.moveToFirst()) {
                                    do {
                                        int i6 = cursorRawQuery.getInt(0);
                                        List arrayList3 = (List) arrayMap7.get(Integer.valueOf(i6));
                                        if (arrayList3 == null) {
                                            arrayList3 = new ArrayList();
                                            arrayMap7.put(Integer.valueOf(i6), arrayList3);
                                        }
                                        try {
                                            arrayList3.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                        } catch (SQLiteException e10) {
                                            e = e10;
                                            gVarQ6.g().f.c("Database error querying scoped filters. appId", q3.s(str11), e);
                                            if (b.i.a.f.h.l.l9.b() && gVarQ6.a.h.u(str11, p.F0)) {
                                                arrayMap7 = Collections.emptyMap();
                                                if (cursorRawQuery != null) {
                                                    cursorRawQuery.close();
                                                }
                                            } else {
                                                if (cursorRawQuery != null) {
                                                    cursorRawQuery.close();
                                                }
                                                arrayMap7 = null;
                                            }
                                        }
                                    } while (cursorRawQuery.moveToNext());
                                    cursorRawQuery.close();
                                } else {
                                    arrayMap7 = Collections.emptyMap();
                                    cursorRawQuery.close();
                                }
                            } catch (SQLiteException e11) {
                                e = e11;
                            }
                        } catch (SQLiteException e12) {
                            e = e12;
                            cursorRawQuery = null;
                        } catch (Throwable th5) {
                            th = th5;
                            r8 = 0;
                            if (r8 != 0) {
                                r8.close();
                            }
                            throw th;
                        }
                        Iterator it10 = map2.keySet().iterator();
                        while (it10.hasNext()) {
                            int iIntValue4 = ((Integer) it10.next()).intValue();
                            b.i.a.f.h.l.g1 g1Var = (b.i.a.f.h.l.g1) map2.get(Integer.valueOf(iIntValue4));
                            List<Integer> list4 = (List) arrayMap7.get(Integer.valueOf(iIntValue4));
                            if (list4 == null || list4.isEmpty()) {
                                it10 = it10;
                                arrayMap6.put(Integer.valueOf(iIntValue4), g1Var);
                                it10 = it10;
                                arrayMap7 = arrayMap7;
                            } else {
                                List<Long> listC = m().C(g1Var.E(), list4);
                                if (!listC.isEmpty()) {
                                    g1$a g1_aT = g1Var.t();
                                    if (g1_aT.l) {
                                        g1_aT.n();
                                        g1_aT.l = false;
                                    }
                                    b.i.a.f.h.l.g1.B((b.i.a.f.h.l.g1) g1_aT.k);
                                    if (g1_aT.l) {
                                        g1_aT.n();
                                        g1_aT.l = false;
                                    }
                                    b.i.a.f.h.l.g1.D((b.i.a.f.h.l.g1) g1_aT.k, listC);
                                    List<Long> listC2 = m().C(g1Var.v(), list4);
                                    if (g1_aT.l) {
                                        g1_aT.n();
                                        g1_aT.l = false;
                                    }
                                    b.i.a.f.h.l.g1.w((b.i.a.f.h.l.g1) g1_aT.k);
                                    if (g1_aT.l) {
                                        g1_aT.n();
                                        g1_aT.l = false;
                                    }
                                    b.i.a.f.h.l.g1.y((b.i.a.f.h.l.g1) g1_aT.k, listC2);
                                    for (int i7 = 0; i7 < g1Var.J(); i7++) {
                                        if (list4.contains(Integer.valueOf(g1Var.u(i7).x()))) {
                                            if (g1_aT.l) {
                                                g1_aT.n();
                                                g1_aT.l = false;
                                            }
                                            b.i.a.f.h.l.g1.x((b.i.a.f.h.l.g1) g1_aT.k, i7);
                                        }
                                    }
                                    for (int i8 = 0; i8 < g1Var.L(); i8++) {
                                        if (list4.contains(Integer.valueOf(g1Var.A(i8).y()))) {
                                            if (g1_aT.l) {
                                                g1_aT.n();
                                                g1_aT.l = false;
                                            }
                                            b.i.a.f.h.l.g1.C((b.i.a.f.h.l.g1) g1_aT.k, i8);
                                        }
                                    }
                                    arrayMap6.put(Integer.valueOf(iIntValue4), (b.i.a.f.h.l.g1) ((b.i.a.f.h.l.u4) g1_aT.p()));
                                    it10 = it10;
                                    arrayMap7 = arrayMap7;
                                }
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        r8 = sQLiteDatabaseT2;
                    }
                }
                map3 = arrayMap6;
            } else {
                str8 = "audience_id";
                map3 = map2;
            }
            Iterator it11 = hashSet.iterator();
            Map map4 = map;
            while (it11.hasNext()) {
                int iIntValue5 = ((Integer) it11.next()).intValue();
                b.i.a.f.h.l.g1 g1Var2 = (b.i.a.f.h.l.g1) map3.get(Integer.valueOf(iIntValue5));
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                ArrayMap arrayMap8 = new ArrayMap();
                if (g1Var2 != null && g1Var2.J() != 0) {
                    for (b.i.a.f.h.l.z0 z0Var : g1Var2.I()) {
                        if (z0Var.w()) {
                            arrayMap8.put(Integer.valueOf(z0Var.x()), z0Var.y() ? Long.valueOf(z0Var.z()) : null);
                        }
                    }
                }
                ArrayMap arrayMap9 = new ArrayMap();
                if (g1Var2 != null && g1Var2.L() != 0) {
                    for (b.i.a.f.h.l.h1 h1Var : g1Var2.K()) {
                        if (h1Var.x() && h1Var.A() > 0) {
                            arrayMap9.put(Integer.valueOf(h1Var.y()), Long.valueOf(h1Var.u(h1Var.A() - 1)));
                        }
                        map3 = map3;
                    }
                }
                Map map5 = map3;
                if (g1Var2 != null) {
                    for (int i9 = 0; i9 < (g1Var2.z() << 6); i9++) {
                        if (q9.Q(g1Var2.v(), i9)) {
                            g().n.c("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue5), Integer.valueOf(i9));
                            bitSet2.set(i9);
                            if (q9.Q(g1Var2.E(), i9)) {
                                bitSet.set(i9);
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            arrayMap8.remove(Integer.valueOf(i9));
                        }
                    }
                }
                b.i.a.f.h.l.g1 g1Var3 = (b.i.a.f.h.l.g1) map2.get(Integer.valueOf(iIntValue5));
                if (z5 && z4 && (list3 = (List) map4.get(Integer.valueOf(iIntValue5))) != null && this.h != null && this.g != null) {
                    for (b.i.a.f.h.l.l0 l0Var2 : list3) {
                        int iY = l0Var2.y();
                        long jLongValue = this.h.longValue() / 1000;
                        if (l0Var2.F()) {
                            jLongValue = this.g.longValue() / 1000;
                        }
                        if (arrayMap8.containsKey(Integer.valueOf(iY))) {
                            arrayMap8.put(Integer.valueOf(iY), Long.valueOf(jLongValue));
                        }
                        if (arrayMap9.containsKey(Integer.valueOf(iY))) {
                            arrayMap9.put(Integer.valueOf(iY), Long.valueOf(jLongValue));
                        }
                    }
                }
                this.f.put(Integer.valueOf(iIntValue5), new da(this, this.d, g1Var3, bitSet, bitSet2, arrayMap8, arrayMap9, null));
                str8 = str8;
                map4 = map4;
                map3 = map5;
            }
            str3 = str8;
        }
        str4 = "Skipping failed audience ID";
        if (!list.isEmpty()) {
            caVar = new ca(this, null);
            arrayMap2 = new ArrayMap();
            it4 = list.iterator();
            while (it4.hasNext()) {
                next2 = it4.next();
                a1VarA = caVar.a(this.d, next2);
                if (a1VarA != null) {
                    gVarQ2 = q();
                    str6 = this.d;
                    strF = a1VarA.F();
                    lVarZ = gVarQ2.z(str6, next2.F());
                    if (lVarZ == null) {
                        gVarQ2.g().i.c("Event aggregate wasn't created during raw event logging. appId, event", q3.s(str6), gVarQ2.d().u(strF));
                        lVar = new l(str6, next2.F(), 1L, 1L, 1L, next2.H(), 0L, null, null, null, null);
                    } else {
                        lVar = new l(lVarZ.a, lVarZ.f1548b, lVarZ.c + 1, lVarZ.d + 1, lVarZ.e + 1, lVarZ.f, lVarZ.g, lVarZ.h, lVarZ.i, lVarZ.j, lVarZ.k);
                    }
                    q().H(lVar);
                    j = lVar.c;
                    strF2 = a1VarA.F();
                    mapC0 = (Map) arrayMap2.get(strF2);
                    if (mapC0 == null) {
                        mapC0 = q().c0(this.d, strF2);
                        if (b.i.a.f.h.l.l9.b()) {
                            caVar2 = caVar;
                            if (!this.a.h.u(this.d, p.F0)) {
                            }
                            arrayMap2.put(strF2, mapC0);
                        } else {
                            caVar2 = caVar;
                        }
                        if (mapC0 == null) {
                            mapC0 = new ArrayMap();
                        }
                        arrayMap2.put(strF2, mapC0);
                    } else {
                        caVar2 = caVar;
                    }
                    it5 = mapC0.keySet().iterator();
                    while (it5.hasNext()) {
                        iIntValue2 = it5.next().intValue();
                        if (this.e.contains(Integer.valueOf(iIntValue2))) {
                            g().n.b("Skipping failed audience ID", Integer.valueOf(iIntValue2));
                        } else {
                            it6 = mapC0.get(Integer.valueOf(iIntValue2)).iterator();
                            zI2 = true;
                            while (true) {
                                if (it6.hasNext()) {
                                    it7 = it5;
                                    arrayMap3 = arrayMap2;
                                    it8 = it4;
                                    break;
                                }
                                b.i.a.f.h.l.l0 next4 = it6.next();
                                it7 = it5;
                                arrayMap3 = arrayMap2;
                                faVar = new fa(this, this.d, iIntValue2, next4);
                                it8 = it4;
                                zI2 = faVar.i(this.g, this.h, a1VarA, j, lVar, u(iIntValue2, next4.y()));
                                if (zI2) {
                                    this.e.add(Integer.valueOf(iIntValue2));
                                    break;
                                }
                                s(iIntValue2).b(faVar);
                                it5 = it7;
                                arrayMap2 = arrayMap3;
                                it4 = it8;
                            }
                            if (!zI2) {
                                this.e.add(Integer.valueOf(iIntValue2));
                            }
                            it5 = it7;
                            arrayMap2 = arrayMap3;
                            it4 = it8;
                        }
                    }
                    caVar = caVar2;
                }
            }
        }
        if (!list2.isEmpty()) {
            arrayMap = new ArrayMap();
            for (b.i.a.f.h.l.i1 i1Var : list2) {
                strD = i1Var.D();
                mapD0 = (Map) arrayMap.get(strD);
                if (mapD0 == null) {
                    mapD0 = q().d0(this.d, strD);
                    if ((b.i.a.f.h.l.l9.b() || !this.a.h.u(this.d, p.F0)) && mapD0 == null) {
                    }
                    arrayMap.put(strD, mapD0);
                }
                it2 = mapD0.keySet().iterator();
                while (it2.hasNext()) {
                    iIntValue = it2.next().intValue();
                    if (this.e.contains(Integer.valueOf(iIntValue))) {
                        g().n.b(str4, Integer.valueOf(iIntValue));
                        break;
                        break;
                    }
                    it3 = mapD0.get(Integer.valueOf(iIntValue)).iterator();
                    zI = true;
                    while (true) {
                        if (it3.hasNext()) {
                            arrayMap = arrayMap;
                            str4 = str4;
                            break;
                        }
                        next = it3.next();
                        if (g().x(2)) {
                            s3 s3Var3 = g().n;
                            Integer numValueOf4 = Integer.valueOf(iIntValue);
                            if (next.v()) {
                                numValueOf2 = Integer.valueOf(next.w());
                            } else {
                                numValueOf2 = null;
                            }
                            s3Var3.d("Evaluating filter. audience, filter, property", numValueOf4, numValueOf2, d().y(next.x()));
                            g().n.b("Filter definition", m().y(next));
                        } else {
                            arrayMap = arrayMap;
                        }
                        if (next.v() || next.w() > 256) {
                            s3 s3Var4 = g().i;
                            Object objS2 = q3.s(this.d);
                            if (next.v()) {
                                numValueOf = Integer.valueOf(next.w());
                            } else {
                                numValueOf = null;
                            }
                            s3Var4.c("Invalid property filter ID. appId, id", objS2, String.valueOf(numValueOf));
                            zI = false;
                            break;
                        }
                        haVar = new ha(this, this.d, iIntValue, next);
                        zI = haVar.i(this.g, this.h, i1Var, u(iIntValue, next.w()));
                        if (!zI) {
                            this.e.add(Integer.valueOf(iIntValue));
                            break;
                        }
                        s(iIntValue).b(haVar);
                        arrayMap = arrayMap;
                        str4 = str4;
                    }
                    if (!zI) {
                        this.e.add(Integer.valueOf(iIntValue));
                    }
                    arrayMap = arrayMap;
                    str4 = str4;
                }
            }
        }
        arrayList = new ArrayList();
        Set<Integer> setKeySet2 = this.f.keySet();
        setKeySet2.removeAll(this.e);
        it = setKeySet2.iterator();
        while (it.hasNext()) {
            int iIntValue6 = it.next().intValue();
            b.i.a.f.h.l.y0 y0VarA2 = this.f.get(Integer.valueOf(iIntValue6)).a(iIntValue6);
            arrayList.add(y0VarA2);
            gVarQ = q();
            str5 = this.d;
            b.i.a.f.h.l.g1 g1VarA2 = y0VarA2.A();
            gVarQ.n();
            gVarQ.b();
            b.c.a.a0.d.w(str5);
            Objects.requireNonNull(g1VarA2, "null reference");
            byte[] bArrD2 = g1VarA2.d();
            contentValues = new ContentValues();
            contentValues.put("app_id", str5);
            contentValues.put(str3, Integer.valueOf(iIntValue6));
            contentValues.put("current_results", bArrD2);
            if (gVarQ.t().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                gVarQ.g().f.b("Failed to insert filter results (got -1). appId", q3.s(str5));
            }
        }
        return arrayList;
    }

    public final boolean u(int i, int i2) {
        if (this.f.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.f.get(Integer.valueOf(i)).d.get(i2);
    }
}
