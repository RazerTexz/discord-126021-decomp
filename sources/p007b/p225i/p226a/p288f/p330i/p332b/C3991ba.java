package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3579a1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3657f9;
import p007b.p225i.p226a.p288f.p313h.p325l.C3663g1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3677h1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3691i1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3730l0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3739l9;
import p007b.p225i.p226a.p288f.p313h.p325l.C3769o0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3899y0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3912z0;

/* JADX INFO: renamed from: b.i.a.f.i.b.ba */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3991ba extends AbstractC4074i9 {

    /* JADX INFO: renamed from: d */
    public String f10574d;

    /* JADX INFO: renamed from: e */
    public Set<Integer> f10575e;

    /* JADX INFO: renamed from: f */
    public Map<Integer, C4015da> f10576f;

    /* JADX INFO: renamed from: g */
    public Long f10577g;

    /* JADX INFO: renamed from: h */
    public Long f10578h;

    public C3991ba(C4097k9 c4097k9) {
        super(c4097k9);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4074i9
    /* JADX INFO: renamed from: p */
    public final boolean mo5515p() {
        return false;
    }

    /* JADX INFO: renamed from: s */
    public final C4015da m5516s(int i) {
        if (this.f10576f.containsKey(Integer.valueOf(i))) {
            return this.f10576f.get(Integer.valueOf(i));
        }
        C4015da c4015da = new C4015da(this, this.f10574d, null);
        this.f10576f.put(Integer.valueOf(i), c4015da);
        return c4015da;
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
    /* JADX INFO: renamed from: t */
    public final List<C3899y0> m5517t(String str, List<C3579a1> list, List<C3691i1> list2, Long l, Long l2) throws Throwable {
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
        C4040g c4040gM5686q;
        String str5;
        ContentValues contentValues;
        ArrayMap arrayMap;
        String strM4949D;
        Map<Integer, List<C3769o0>> mapM5632d0;
        Iterator<Integer> it2;
        int iIntValue;
        Iterator<C3769o0> it3;
        boolean zM5662i;
        C3769o0 next;
        Integer numValueOf;
        C4063ha c4063ha;
        Integer numValueOf2;
        C4003ca c4003ca;
        ArrayMap arrayMap2;
        Iterator<C3579a1> it4;
        C3579a1 next2;
        C3579a1 c3579a1M5561a;
        C4040g c4040gM5686q2;
        String str6;
        String strM4533F;
        C4098l c4098lM5646z;
        C4098l c4098l;
        long j;
        String strM4533F2;
        Map<Integer, List<C3730l0>> mapM5631c0;
        C4003ca c4003ca2;
        Iterator<Integer> it5;
        int iIntValue2;
        Iterator<C3730l0> it6;
        boolean zM5602i;
        Iterator<Integer> it7;
        ArrayMap arrayMap3;
        Iterator<C3579a1> it8;
        C4039fa c4039fa;
        Map map3;
        List<C3730l0> list3;
        boolean z3;
        ?? r8;
        Cursor cursorRawQuery;
        ?? r9;
        Cursor cursorQuery2;
        C1460d.m583w(str);
        Objects.requireNonNull(list, "null reference");
        Objects.requireNonNull(list2, "null reference");
        this.f10574d = str;
        this.f10575e = new HashSet();
        this.f10576f = new ArrayMap();
        this.f10577g = l;
        this.f10578h = l2;
        Iterator<C3579a1> it9 = list.iterator();
        while (true) {
            i = 1;
            i2 = 0;
            if (!it9.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(it9.next().m4533F())) {
                z2 = true;
                break;
            }
        }
        boolean z4 = C3657f9.m4881b() && this.f11202a.f11260h.m5532u(this.f10574d, C4142p.f11066c0);
        boolean z5 = C3657f9.m4881b() && this.f11202a.f11260h.m5532u(this.f10574d, C4142p.f11064b0);
        if (z2) {
            C4040g c4040gM5686q3 = m5686q();
            String str7 = this.f10574d;
            c4040gM5686q3.m5684n();
            c4040gM5686q3.mo5848b();
            C1460d.m583w(str7);
            ContentValues contentValues2 = new ContentValues();
            str2 = "current_session_count";
            contentValues2.put("current_session_count", (Integer) 0);
            try {
                SQLiteDatabase sQLiteDatabaseM5640t = c4040gM5686q3.m5640t();
                str2 = "events";
                sQLiteDatabaseM5640t.update("events", contentValues2, "app_id = ?", new String[]{str7});
                obj = sQLiteDatabaseM5640t;
            } catch (SQLiteException e) {
                c4040gM5686q3.mo5726g().f11141f.m5862c("Error resetting session-scoped event counts. appId", C4157q3.m5788s(str7), e);
                obj = "Error resetting session-scoped event counts. appId";
            }
        }
        Map mapEmptyMap2 = Collections.emptyMap();
        String str8 = "audience_id";
        Object obj3 = obj;
        obj3 = obj;
        if (z5 && z4) {
            C4040g c4040gM5686q4 = m5686q();
            String str9 = this.f10574d;
            Objects.requireNonNull(c4040gM5686q4);
            C1460d.m583w(str9);
            ArrayMap arrayMap4 = new ArrayMap();
            try {
                try {
                    cursorQuery2 = c4040gM5686q4.m5640t().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str9}, null, null, null);
                    try {
                        if (cursorQuery2.moveToFirst()) {
                            while (true) {
                                try {
                                    C3730l0 c3730l0 = (C3730l0) ((AbstractC3851u4) ((C3730l0.a) C4163q9.m5832x(C3730l0.m5031I(), cursorQuery2.getBlob(1))).m5320p());
                                    if (c3730l0.m5037C()) {
                                        int i3 = cursorQuery2.getInt(i2);
                                        List arrayList2 = (List) arrayMap4.get(Integer.valueOf(i3));
                                        if (arrayList2 == null) {
                                            arrayList2 = new ArrayList();
                                            arrayMap4.put(Integer.valueOf(i3), arrayList2);
                                        }
                                        arrayList2.add(c3730l0);
                                    }
                                } catch (IOException e2) {
                                    c4040gM5686q4.mo5726g().f11141f.m5862c("Failed to merge filter. appId", C4157q3.m5788s(str9), e2);
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
                        c4040gM5686q4.mo5726g().f11141f.m5862c("Database error querying filters. appId", C4157q3.m5788s(str9), e);
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
        C4040g c4040gM5686q5 = m5686q();
        String str10 = this.f10574d;
        c4040gM5686q5.m5684n();
        c4040gM5686q5.mo5848b();
        C1460d.m583w(str10);
        try {
            try {
                cursorQuery = c4040gM5686q5.m5640t().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str10}, null, null, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        ArrayMap arrayMap5 = new ArrayMap();
                        int i4 = 0;
                        while (true) {
                            int i5 = cursorQuery.getInt(i4);
                            try {
                                arrayMap5.put(Integer.valueOf(i5), (C3663g1) ((AbstractC3851u4) ((C3663g1.a) C4163q9.m5832x(C3663g1.m4893M(), cursorQuery.getBlob(i))).m5320p()));
                            } catch (IOException e5) {
                                c4040gM5686q5.mo5726g().f11141f.m5863d("Failed to merge filter results. appId, audienceId, error", C4157q3.m5788s(str10), Integer.valueOf(i5), e5);
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
                    } else if (C3739l9.m5058b() && c4040gM5686q5.f11202a.f11260h.m5532u(str10, C4142p.f11031F0)) {
                        mapEmptyMap = Collections.emptyMap();
                        cursorQuery.close();
                        map2 = mapEmptyMap;
                    } else {
                        cursorQuery.close();
                        map2 = null;
                    }
                } catch (SQLiteException e6) {
                    e = e6;
                    c4040gM5686q5.mo5726g().f11141f.m5862c("Database error querying filter results. appId", C4157q3.m5788s(str10), e);
                    if (!C3739l9.m5058b() || !c4040gM5686q5.f11202a.f11260h.m5532u(str10, C4142p.f11031F0)) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        map2 = null;
                        if (C3739l9.m5058b()) {
                        }
                        str3 = "audience_id";
                        str4 = "Skipping failed audience ID";
                        if (!list.isEmpty()) {
                            c4003ca = new C4003ca(this, null);
                            arrayMap2 = new ArrayMap();
                            it4 = list.iterator();
                            while (it4.hasNext()) {
                                next2 = it4.next();
                                c3579a1M5561a = c4003ca.m5561a(this.f10574d, next2);
                                if (c3579a1M5561a != null) {
                                    c4040gM5686q2 = m5686q();
                                    str6 = this.f10574d;
                                    strM4533F = c3579a1M5561a.m4533F();
                                    c4098lM5646z = c4040gM5686q2.m5646z(str6, next2.m4533F());
                                    if (c4098lM5646z == null) {
                                        c4040gM5686q2.mo5726g().f11144i.m5862c("Event aggregate wasn't created during raw event logging. appId, event", C4157q3.m5788s(str6), c4040gM5686q2.m5865d().m5766u(strM4533F));
                                        c4098l = new C4098l(str6, next2.m4533F(), 1L, 1L, 1L, next2.m4535H(), 0L, null, null, null, null);
                                    } else {
                                        c4098l = new C4098l(c4098lM5646z.f10926a, c4098lM5646z.f10927b, c4098lM5646z.f10928c + 1, c4098lM5646z.f10929d + 1, c4098lM5646z.f10930e + 1, c4098lM5646z.f10931f, c4098lM5646z.f10932g, c4098lM5646z.f10933h, c4098lM5646z.f10934i, c4098lM5646z.f10935j, c4098lM5646z.f10936k);
                                    }
                                    m5686q().m5610H(c4098l);
                                    j = c4098l.f10928c;
                                    strM4533F2 = c3579a1M5561a.m4533F();
                                    mapM5631c0 = (Map) arrayMap2.get(strM4533F2);
                                    if (mapM5631c0 == null) {
                                        mapM5631c0 = m5686q().m5631c0(this.f10574d, strM4533F2);
                                        if (C3739l9.m5058b()) {
                                            c4003ca2 = c4003ca;
                                            if (!this.f11202a.f11260h.m5532u(this.f10574d, C4142p.f11031F0)) {
                                            }
                                            arrayMap2.put(strM4533F2, mapM5631c0);
                                        } else {
                                            c4003ca2 = c4003ca;
                                        }
                                        if (mapM5631c0 == null) {
                                            mapM5631c0 = new ArrayMap();
                                        }
                                        arrayMap2.put(strM4533F2, mapM5631c0);
                                    } else {
                                        c4003ca2 = c4003ca;
                                    }
                                    it5 = mapM5631c0.keySet().iterator();
                                    while (it5.hasNext()) {
                                        iIntValue2 = it5.next().intValue();
                                        if (this.f10575e.contains(Integer.valueOf(iIntValue2))) {
                                            mo5726g().f11149n.m5861b("Skipping failed audience ID", Integer.valueOf(iIntValue2));
                                        } else {
                                            it6 = mapM5631c0.get(Integer.valueOf(iIntValue2)).iterator();
                                            zM5602i = true;
                                            while (true) {
                                                if (it6.hasNext()) {
                                                    it7 = it5;
                                                    arrayMap3 = arrayMap2;
                                                    it8 = it4;
                                                    break;
                                                }
                                                C3730l0 next3 = it6.next();
                                                it7 = it5;
                                                arrayMap3 = arrayMap2;
                                                c4039fa = new C4039fa(this, this.f10574d, iIntValue2, next3);
                                                it8 = it4;
                                                zM5602i = c4039fa.m5602i(this.f10577g, this.f10578h, c3579a1M5561a, j, c4098l, m5518u(iIntValue2, next3.m5045y()));
                                                if (zM5602i) {
                                                    this.f10575e.add(Integer.valueOf(iIntValue2));
                                                    break;
                                                }
                                                m5516s(iIntValue2).m5587b(c4039fa);
                                                it5 = it7;
                                                arrayMap2 = arrayMap3;
                                                it4 = it8;
                                            }
                                            if (!zM5602i) {
                                                this.f10575e.add(Integer.valueOf(iIntValue2));
                                            }
                                            it5 = it7;
                                            arrayMap2 = arrayMap3;
                                            it4 = it8;
                                        }
                                    }
                                    c4003ca = c4003ca2;
                                }
                            }
                        }
                        if (!list2.isEmpty()) {
                            arrayMap = new ArrayMap();
                            while (r2.hasNext()) {
                                strM4949D = c3691i1.m4949D();
                                mapM5632d0 = (Map) arrayMap.get(strM4949D);
                                if (mapM5632d0 == null) {
                                    mapM5632d0 = m5686q().m5632d0(this.f10574d, strM4949D);
                                    mapM5632d0 = C3739l9.m5058b() ? new ArrayMap<>() : new ArrayMap<>();
                                    arrayMap.put(strM4949D, mapM5632d0);
                                }
                                it2 = mapM5632d0.keySet().iterator();
                                while (it2.hasNext()) {
                                    iIntValue = it2.next().intValue();
                                    if (this.f10575e.contains(Integer.valueOf(iIntValue))) {
                                        mo5726g().f11149n.m5861b(str4, Integer.valueOf(iIntValue));
                                        break;
                                    }
                                    it3 = mapM5632d0.get(Integer.valueOf(iIntValue)).iterator();
                                    zM5662i = true;
                                    while (true) {
                                        if (it3.hasNext()) {
                                            arrayMap = arrayMap;
                                            str4 = str4;
                                            break;
                                        }
                                        next = it3.next();
                                        if (mo5726g().m5800x(2)) {
                                            C4179s3 c4179s3 = mo5726g().f11149n;
                                            Integer numValueOf3 = Integer.valueOf(iIntValue);
                                            if (next.m5147v()) {
                                                numValueOf2 = Integer.valueOf(next.m5148w());
                                            } else {
                                                numValueOf2 = null;
                                            }
                                            c4179s3.m5863d("Evaluating filter. audience, filter, property", numValueOf3, numValueOf2, m5865d().m5769y(next.m5149x()));
                                            mo5726g().f11149n.m5861b("Filter definition", m5683m().m5845y(next));
                                        } else {
                                            arrayMap = arrayMap;
                                        }
                                        if (next.m5147v()) {
                                        }
                                        C4179s3 c4179s4 = mo5726g().f11144i;
                                        Object objM5788s = C4157q3.m5788s(this.f10574d);
                                        if (next.m5147v()) {
                                            numValueOf = Integer.valueOf(next.m5148w());
                                        } else {
                                            numValueOf = null;
                                        }
                                        c4179s4.m5862c("Invalid property filter ID. appId, id", objM5788s, String.valueOf(numValueOf));
                                        zM5662i = false;
                                        break;
                                        if (!zM5662i) {
                                            this.f10575e.add(Integer.valueOf(iIntValue));
                                        }
                                        arrayMap = arrayMap;
                                        str4 = str4;
                                        m5516s(iIntValue).m5587b(c4063ha);
                                        arrayMap = arrayMap;
                                        str4 = str4;
                                    }
                                }
                            }
                        }
                        arrayList = new ArrayList();
                        Set<Integer> setKeySet = this.f10576f.keySet();
                        setKeySet.removeAll(this.f10575e);
                        it = setKeySet.iterator();
                        while (it.hasNext()) {
                            int iIntValue3 = it.next().intValue();
                            C3899y0 c3899y0M5586a = this.f10576f.get(Integer.valueOf(iIntValue3)).m5586a(iIntValue3);
                            arrayList.add(c3899y0M5586a);
                            c4040gM5686q = m5686q();
                            str5 = this.f10574d;
                            C3663g1 c3663g1M5369A = c3899y0M5586a.m5369A();
                            c4040gM5686q.m5684n();
                            c4040gM5686q.mo5848b();
                            C1460d.m583w(str5);
                            Objects.requireNonNull(c3663g1M5369A, "null reference");
                            byte[] bArrM5052d = c3663g1M5369A.m5052d();
                            contentValues = new ContentValues();
                            contentValues.put("app_id", str5);
                            contentValues.put(str3, Integer.valueOf(iIntValue3));
                            contentValues.put("current_results", bArrM5052d);
                            try {
                                try {
                                    if (c4040gM5686q.m5640t().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                        c4040gM5686q.mo5726g().f11141f.m5861b("Failed to insert filter results (got -1). appId", C4157q3.m5788s(str5));
                                    }
                                } catch (SQLiteException e7) {
                                    e = e7;
                                    c4040gM5686q.mo5726g().f11141f.m5862c("Error storing filter results. appId", C4157q3.m5788s(str5), e);
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
        if (((C3739l9.m5058b() || !this.f11202a.f11260h.m5532u(this.f10574d, C4142p.f11031F0)) && map2 == null) || map2.isEmpty()) {
            str3 = "audience_id";
        } else {
            HashSet hashSet = new HashSet(map2.keySet());
            if (z2) {
                String str11 = this.f10574d;
                C1460d.m583w(str11);
                ArrayMap arrayMap6 = new ArrayMap();
                if (!map2.isEmpty()) {
                    C4040g c4040gM5686q6 = m5686q();
                    c4040gM5686q6.m5684n();
                    c4040gM5686q6.mo5848b();
                    C1460d.m583w(str11);
                    Map arrayMap7 = new ArrayMap();
                    SQLiteDatabase sQLiteDatabaseM5640t2 = c4040gM5686q6.m5640t();
                    try {
                        try {
                            cursorRawQuery = sQLiteDatabaseM5640t2.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str11, str11});
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
                                            c4040gM5686q6.mo5726g().f11141f.m5862c("Database error querying scoped filters. appId", C4157q3.m5788s(str11), e);
                                            if (C3739l9.m5058b() && c4040gM5686q6.f11202a.f11260h.m5532u(str11, C4142p.f11031F0)) {
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
                            C3663g1 c3663g1 = (C3663g1) map2.get(Integer.valueOf(iIntValue4));
                            List<Integer> list4 = (List) arrayMap7.get(Integer.valueOf(iIntValue4));
                            if (list4 == null || list4.isEmpty()) {
                                it10 = it10;
                                arrayMap6.put(Integer.valueOf(iIntValue4), c3663g1);
                                it10 = it10;
                                arrayMap7 = arrayMap7;
                            } else {
                                List<Long> listM5833C = m5683m().m5833C(c3663g1.m4900E(), list4);
                                if (!listM5833C.isEmpty()) {
                                    C3663g1.a aVarM5315t = c3663g1.m5315t();
                                    if (aVarM5315t.f10348l) {
                                        aVarM5315t.m5318n();
                                        aVarM5315t.f10348l = false;
                                    }
                                    C3663g1.m4888B((C3663g1) aVarM5315t.f10347k);
                                    if (aVarM5315t.f10348l) {
                                        aVarM5315t.m5318n();
                                        aVarM5315t.f10348l = false;
                                    }
                                    C3663g1.m4890D((C3663g1) aVarM5315t.f10347k, listM5833C);
                                    List<Long> listM5833C2 = m5683m().m5833C(c3663g1.m4907v(), list4);
                                    if (aVarM5315t.f10348l) {
                                        aVarM5315t.m5318n();
                                        aVarM5315t.f10348l = false;
                                    }
                                    C3663g1.m4896w((C3663g1) aVarM5315t.f10347k);
                                    if (aVarM5315t.f10348l) {
                                        aVarM5315t.m5318n();
                                        aVarM5315t.f10348l = false;
                                    }
                                    C3663g1.m4898y((C3663g1) aVarM5315t.f10347k, listM5833C2);
                                    for (int i7 = 0; i7 < c3663g1.m4903J(); i7++) {
                                        if (list4.contains(Integer.valueOf(c3663g1.m4906u(i7).m5394x()))) {
                                            if (aVarM5315t.f10348l) {
                                                aVarM5315t.m5318n();
                                                aVarM5315t.f10348l = false;
                                            }
                                            C3663g1.m4897x((C3663g1) aVarM5315t.f10347k, i7);
                                        }
                                    }
                                    for (int i8 = 0; i8 < c3663g1.m4905L(); i8++) {
                                        if (list4.contains(Integer.valueOf(c3663g1.m4899A(i8).m4931y()))) {
                                            if (aVarM5315t.f10348l) {
                                                aVarM5315t.m5318n();
                                                aVarM5315t.f10348l = false;
                                            }
                                            C3663g1.m4889C((C3663g1) aVarM5315t.f10347k, i8);
                                        }
                                    }
                                    arrayMap6.put(Integer.valueOf(iIntValue4), (C3663g1) ((AbstractC3851u4) aVarM5315t.m5320p()));
                                    it10 = it10;
                                    arrayMap7 = arrayMap7;
                                }
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        r8 = sQLiteDatabaseM5640t2;
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
                C3663g1 c3663g2 = (C3663g1) map3.get(Integer.valueOf(iIntValue5));
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                ArrayMap arrayMap8 = new ArrayMap();
                if (c3663g2 != null && c3663g2.m4903J() != 0) {
                    for (C3912z0 c3912z0 : c3663g2.m4902I()) {
                        if (c3912z0.m5393w()) {
                            arrayMap8.put(Integer.valueOf(c3912z0.m5394x()), c3912z0.m5395y() ? Long.valueOf(c3912z0.m5396z()) : null);
                        }
                    }
                }
                ArrayMap arrayMap9 = new ArrayMap();
                if (c3663g2 != null && c3663g2.m4905L() != 0) {
                    for (C3677h1 c3677h1 : c3663g2.m4904K()) {
                        if (c3677h1.m4930x() && c3677h1.m4928A() > 0) {
                            arrayMap9.put(Integer.valueOf(c3677h1.m4931y()), Long.valueOf(c3677h1.m4929u(c3677h1.m4928A() - 1)));
                        }
                        map3 = map3;
                    }
                }
                Map map5 = map3;
                if (c3663g2 != null) {
                    for (int i9 = 0; i9 < (c3663g2.m4908z() << 6); i9++) {
                        if (C4163q9.m5828Q(c3663g2.m4907v(), i9)) {
                            mo5726g().f11149n.m5862c("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue5), Integer.valueOf(i9));
                            bitSet2.set(i9);
                            if (C4163q9.m5828Q(c3663g2.m4900E(), i9)) {
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
                C3663g1 c3663g3 = (C3663g1) map2.get(Integer.valueOf(iIntValue5));
                if (z5 && z4 && (list3 = (List) map4.get(Integer.valueOf(iIntValue5))) != null && this.f10578h != null && this.f10577g != null) {
                    for (C3730l0 c3730l1 : list3) {
                        int iM5045y = c3730l1.m5045y();
                        long jLongValue = this.f10578h.longValue() / 1000;
                        if (c3730l1.m5040F()) {
                            jLongValue = this.f10577g.longValue() / 1000;
                        }
                        if (arrayMap8.containsKey(Integer.valueOf(iM5045y))) {
                            arrayMap8.put(Integer.valueOf(iM5045y), Long.valueOf(jLongValue));
                        }
                        if (arrayMap9.containsKey(Integer.valueOf(iM5045y))) {
                            arrayMap9.put(Integer.valueOf(iM5045y), Long.valueOf(jLongValue));
                        }
                    }
                }
                this.f10576f.put(Integer.valueOf(iIntValue5), new C4015da(this, this.f10574d, c3663g3, bitSet, bitSet2, arrayMap8, arrayMap9, null));
                str8 = str8;
                map4 = map4;
                map3 = map5;
            }
            str3 = str8;
        }
        str4 = "Skipping failed audience ID";
        if (!list.isEmpty()) {
            c4003ca = new C4003ca(this, null);
            arrayMap2 = new ArrayMap();
            it4 = list.iterator();
            while (it4.hasNext()) {
                next2 = it4.next();
                c3579a1M5561a = c4003ca.m5561a(this.f10574d, next2);
                if (c3579a1M5561a != null) {
                    c4040gM5686q2 = m5686q();
                    str6 = this.f10574d;
                    strM4533F = c3579a1M5561a.m4533F();
                    c4098lM5646z = c4040gM5686q2.m5646z(str6, next2.m4533F());
                    if (c4098lM5646z == null) {
                        c4040gM5686q2.mo5726g().f11144i.m5862c("Event aggregate wasn't created during raw event logging. appId, event", C4157q3.m5788s(str6), c4040gM5686q2.m5865d().m5766u(strM4533F));
                        c4098l = new C4098l(str6, next2.m4533F(), 1L, 1L, 1L, next2.m4535H(), 0L, null, null, null, null);
                    } else {
                        c4098l = new C4098l(c4098lM5646z.f10926a, c4098lM5646z.f10927b, c4098lM5646z.f10928c + 1, c4098lM5646z.f10929d + 1, c4098lM5646z.f10930e + 1, c4098lM5646z.f10931f, c4098lM5646z.f10932g, c4098lM5646z.f10933h, c4098lM5646z.f10934i, c4098lM5646z.f10935j, c4098lM5646z.f10936k);
                    }
                    m5686q().m5610H(c4098l);
                    j = c4098l.f10928c;
                    strM4533F2 = c3579a1M5561a.m4533F();
                    mapM5631c0 = (Map) arrayMap2.get(strM4533F2);
                    if (mapM5631c0 == null) {
                        mapM5631c0 = m5686q().m5631c0(this.f10574d, strM4533F2);
                        if (C3739l9.m5058b()) {
                            c4003ca2 = c4003ca;
                            if (!this.f11202a.f11260h.m5532u(this.f10574d, C4142p.f11031F0)) {
                            }
                            arrayMap2.put(strM4533F2, mapM5631c0);
                        } else {
                            c4003ca2 = c4003ca;
                        }
                        if (mapM5631c0 == null) {
                            mapM5631c0 = new ArrayMap();
                        }
                        arrayMap2.put(strM4533F2, mapM5631c0);
                    } else {
                        c4003ca2 = c4003ca;
                    }
                    it5 = mapM5631c0.keySet().iterator();
                    while (it5.hasNext()) {
                        iIntValue2 = it5.next().intValue();
                        if (this.f10575e.contains(Integer.valueOf(iIntValue2))) {
                            mo5726g().f11149n.m5861b("Skipping failed audience ID", Integer.valueOf(iIntValue2));
                        } else {
                            it6 = mapM5631c0.get(Integer.valueOf(iIntValue2)).iterator();
                            zM5602i = true;
                            while (true) {
                                if (it6.hasNext()) {
                                    it7 = it5;
                                    arrayMap3 = arrayMap2;
                                    it8 = it4;
                                    break;
                                }
                                C3730l0 next4 = it6.next();
                                it7 = it5;
                                arrayMap3 = arrayMap2;
                                c4039fa = new C4039fa(this, this.f10574d, iIntValue2, next4);
                                it8 = it4;
                                zM5602i = c4039fa.m5602i(this.f10577g, this.f10578h, c3579a1M5561a, j, c4098l, m5518u(iIntValue2, next4.m5045y()));
                                if (zM5602i) {
                                    this.f10575e.add(Integer.valueOf(iIntValue2));
                                    break;
                                }
                                m5516s(iIntValue2).m5587b(c4039fa);
                                it5 = it7;
                                arrayMap2 = arrayMap3;
                                it4 = it8;
                            }
                            if (!zM5602i) {
                                this.f10575e.add(Integer.valueOf(iIntValue2));
                            }
                            it5 = it7;
                            arrayMap2 = arrayMap3;
                            it4 = it8;
                        }
                    }
                    c4003ca = c4003ca2;
                }
            }
        }
        if (!list2.isEmpty()) {
            arrayMap = new ArrayMap();
            for (C3691i1 c3691i1 : list2) {
                strM4949D = c3691i1.m4949D();
                mapM5632d0 = (Map) arrayMap.get(strM4949D);
                if (mapM5632d0 == null) {
                    mapM5632d0 = m5686q().m5632d0(this.f10574d, strM4949D);
                    if ((C3739l9.m5058b() || !this.f11202a.f11260h.m5532u(this.f10574d, C4142p.f11031F0)) && mapM5632d0 == null) {
                    }
                    arrayMap.put(strM4949D, mapM5632d0);
                }
                it2 = mapM5632d0.keySet().iterator();
                while (it2.hasNext()) {
                    iIntValue = it2.next().intValue();
                    if (this.f10575e.contains(Integer.valueOf(iIntValue))) {
                        mo5726g().f11149n.m5861b(str4, Integer.valueOf(iIntValue));
                        break;
                        break;
                    }
                    it3 = mapM5632d0.get(Integer.valueOf(iIntValue)).iterator();
                    zM5662i = true;
                    while (true) {
                        if (it3.hasNext()) {
                            arrayMap = arrayMap;
                            str4 = str4;
                            break;
                        }
                        next = it3.next();
                        if (mo5726g().m5800x(2)) {
                            C4179s3 c4179s5 = mo5726g().f11149n;
                            Integer numValueOf4 = Integer.valueOf(iIntValue);
                            if (next.m5147v()) {
                                numValueOf2 = Integer.valueOf(next.m5148w());
                            } else {
                                numValueOf2 = null;
                            }
                            c4179s5.m5863d("Evaluating filter. audience, filter, property", numValueOf4, numValueOf2, m5865d().m5769y(next.m5149x()));
                            mo5726g().f11149n.m5861b("Filter definition", m5683m().m5845y(next));
                        } else {
                            arrayMap = arrayMap;
                        }
                        if (next.m5147v() || next.m5148w() > 256) {
                            C4179s3 c4179s6 = mo5726g().f11144i;
                            Object objM5788s2 = C4157q3.m5788s(this.f10574d);
                            if (next.m5147v()) {
                                numValueOf = Integer.valueOf(next.m5148w());
                            } else {
                                numValueOf = null;
                            }
                            c4179s6.m5862c("Invalid property filter ID. appId, id", objM5788s2, String.valueOf(numValueOf));
                            zM5662i = false;
                            break;
                        }
                        c4063ha = new C4063ha(this, this.f10574d, iIntValue, next);
                        zM5662i = c4063ha.m5662i(this.f10577g, this.f10578h, c3691i1, m5518u(iIntValue, next.m5148w()));
                        if (!zM5662i) {
                            this.f10575e.add(Integer.valueOf(iIntValue));
                            break;
                        }
                        m5516s(iIntValue).m5587b(c4063ha);
                        arrayMap = arrayMap;
                        str4 = str4;
                    }
                    if (!zM5662i) {
                        this.f10575e.add(Integer.valueOf(iIntValue));
                    }
                    arrayMap = arrayMap;
                    str4 = str4;
                }
            }
        }
        arrayList = new ArrayList();
        Set<Integer> setKeySet2 = this.f10576f.keySet();
        setKeySet2.removeAll(this.f10575e);
        it = setKeySet2.iterator();
        while (it.hasNext()) {
            int iIntValue6 = it.next().intValue();
            C3899y0 c3899y0M5586a2 = this.f10576f.get(Integer.valueOf(iIntValue6)).m5586a(iIntValue6);
            arrayList.add(c3899y0M5586a2);
            c4040gM5686q = m5686q();
            str5 = this.f10574d;
            C3663g1 c3663g1M5369A2 = c3899y0M5586a2.m5369A();
            c4040gM5686q.m5684n();
            c4040gM5686q.mo5848b();
            C1460d.m583w(str5);
            Objects.requireNonNull(c3663g1M5369A2, "null reference");
            byte[] bArrM5052d2 = c3663g1M5369A2.m5052d();
            contentValues = new ContentValues();
            contentValues.put("app_id", str5);
            contentValues.put(str3, Integer.valueOf(iIntValue6));
            contentValues.put("current_results", bArrM5052d2);
            if (c4040gM5686q.m5640t().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                c4040gM5686q.mo5726g().f11141f.m5861b("Failed to insert filter results (got -1). appId", C4157q3.m5788s(str5));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: u */
    public final boolean m5518u(int i, int i2) {
        if (this.f10576f.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.f10576f.get(Integer.valueOf(i)).f10675d.get(i2);
    }
}
