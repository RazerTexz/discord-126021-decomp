package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzij;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3717k0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3730l0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3743m0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3769o0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3834t0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3847u0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3860v0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3893x7;

/* JADX INFO: renamed from: b.i.a.f.i.b.p4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4147p4 extends AbstractC4074i9 implements InterfaceC4016e {

    /* JADX INFO: renamed from: d */
    public final Map<String, Map<String, String>> f11117d;

    /* JADX INFO: renamed from: e */
    public final Map<String, Map<String, Boolean>> f11118e;

    /* JADX INFO: renamed from: f */
    public final Map<String, Map<String, Boolean>> f11119f;

    /* JADX INFO: renamed from: g */
    public final Map<String, C3847u0> f11120g;

    /* JADX INFO: renamed from: h */
    public final Map<String, Map<String, Integer>> f11121h;

    /* JADX INFO: renamed from: i */
    public final Map<String, String> f11122i;

    public C4147p4(C4097k9 c4097k9) {
        super(c4097k9);
        this.f11117d = new ArrayMap();
        this.f11118e = new ArrayMap();
        this.f11119f = new ArrayMap();
        this.f11120g = new ArrayMap();
        this.f11122i = new ArrayMap();
        this.f11121h = new ArrayMap();
    }

    /* JADX INFO: renamed from: u */
    public static Map<String, String> m5772u(C3847u0 c3847u0) {
        ArrayMap arrayMap = new ArrayMap();
        for (C3860v0 c3860v0 : c3847u0.m5300B()) {
            arrayMap.put(c3860v0.m5330u(), c3860v0.m5331v());
        }
        return arrayMap;
    }

    @WorkerThread
    /* JADX INFO: renamed from: A */
    public final boolean m5773A(String str) throws Throwable {
        mo5848b();
        C3847u0 c3847u0M5778s = m5778s(str);
        if (c3847u0M5778s == null) {
            return false;
        }
        return c3847u0M5778s.m5303E();
    }

    @WorkerThread
    /* JADX INFO: renamed from: B */
    public final long m5774B(String str) throws Throwable {
        String strMo5500h = mo5500h(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(strMo5500h)) {
            return 0L;
        }
        try {
            return Long.parseLong(strMo5500h);
        } catch (NumberFormatException e) {
            mo5726g().f11144i.m5862c("Unable to parse timezone offset. appId", C4157q3.m5788s(str), e);
            return 0L;
        }
    }

    /* JADX INFO: renamed from: C */
    public final boolean m5775C(String str) {
        return "1".equals(mo5500h(str, "measurement.upload.blacklist_internal"));
    }

    /* JADX INFO: renamed from: D */
    public final boolean m5776D(String str) {
        return "1".equals(mo5500h(str, "measurement.upload.blacklist_public"));
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00d6  */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00d3: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:28:0x00d3 */
    @WorkerThread
    /* JADX INFO: renamed from: E */
    public final void m5777E(String str) throws Throwable {
        SQLiteException e;
        Cursor cursorQuery;
        Cursor cursor;
        byte[] blob;
        m5684n();
        mo5848b();
        C1460d.m583w(str);
        if (this.f11120g.get(str) == null) {
            C4040g c4040gM5686q = m5686q();
            Objects.requireNonNull(c4040gM5686q);
            C1460d.m583w(str);
            c4040gM5686q.mo5848b();
            c4040gM5686q.m5684n();
            Cursor cursor2 = null;
            try {
                try {
                    cursorQuery = c4040gM5686q.m5640t().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
                    try {
                        if (cursorQuery.moveToFirst()) {
                            blob = cursorQuery.getBlob(0);
                            if (cursorQuery.moveToNext()) {
                                c4040gM5686q.mo5726g().f11141f.m5861b("Got multiple records for app config, expected one. appId", C4157q3.m5788s(str));
                            }
                            cursorQuery.close();
                        } else {
                            cursorQuery.close();
                            blob = null;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        c4040gM5686q.mo5726g().f11141f.m5862c("Error querying remote config. appId", C4157q3.m5788s(str), e);
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
                C3847u0.a aVarM5315t = m5779t(str, blob).m5315t();
                m5780v(str, aVarM5315t);
                this.f11117d.put(str, m5772u((C3847u0) ((AbstractC3851u4) aVarM5315t.m5320p())));
                this.f11120g.put(str, (C3847u0) ((AbstractC3851u4) aVarM5315t.m5320p()));
                this.f11122i.put(str, null);
                return;
            }
            this.f11117d.put(str, null);
            this.f11118e.put(str, null);
            this.f11119f.put(str, null);
            this.f11120g.put(str, null);
            this.f11122i.put(str, null);
            this.f11121h.put(str, null);
        }
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4016e
    @WorkerThread
    /* JADX INFO: renamed from: h */
    public final String mo5500h(String str, String str2) throws Throwable {
        mo5848b();
        m5777E(str);
        Map<String, String> map = this.f11117d.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4074i9
    /* JADX INFO: renamed from: p */
    public final boolean mo5515p() {
        return false;
    }

    @WorkerThread
    /* JADX INFO: renamed from: s */
    public final C3847u0 m5778s(String str) throws Throwable {
        m5684n();
        mo5848b();
        C1460d.m583w(str);
        m5777E(str);
        return this.f11120g.get(str);
    }

    @WorkerThread
    /* JADX INFO: renamed from: t */
    public final C3847u0 m5779t(String str, byte[] bArr) {
        if (bArr == null) {
            return C3847u0.m5295G();
        }
        try {
            C3847u0 c3847u0 = (C3847u0) ((AbstractC3851u4) ((C3847u0.a) C4163q9.m5832x(C3847u0.m5294F(), bArr)).m5320p());
            mo5726g().f11149n.m5862c("Parsed config. version, gmp_app_id", c3847u0.m5305x() ? Long.valueOf(c3847u0.m5306y()) : null, c3847u0.m5307z() ? c3847u0.m5299A() : null);
            return c3847u0;
        } catch (zzij e) {
            mo5726g().f11144i.m5862c("Unable to merge remote config. appId", C4157q3.m5788s(str), e);
            return C3847u0.m5295G();
        } catch (RuntimeException e2) {
            mo5726g().f11144i.m5862c("Unable to merge remote config. appId", C4157q3.m5788s(str), e2);
            return C3847u0.m5295G();
        }
    }

    /* JADX INFO: renamed from: v */
    public final void m5780v(String str, C3847u0.a aVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        for (int i = 0; i < ((C3847u0) aVar.f10347k).m5301C(); i++) {
            C3834t0.a aVarM5315t = ((C3847u0) aVar.f10347k).m5304u(i).m5315t();
            if (TextUtils.isEmpty(aVarM5315t.m5275q())) {
                mo5726g().f11144i.m5860a("EventConfig contained null event name");
            } else {
                String strM5275q = aVarM5315t.m5275q();
                String strM4263Y1 = C3404f.m4263Y1(aVarM5315t.m5275q(), C4214v5.f11304a, C4214v5.f11306c);
                if (!TextUtils.isEmpty(strM4263Y1)) {
                    if (aVarM5315t.f10348l) {
                        aVarM5315t.m5318n();
                        aVarM5315t.f10348l = false;
                    }
                    C3834t0.m5269v((C3834t0) aVarM5315t.f10347k, strM4263Y1);
                    if (aVar.f10348l) {
                        aVar.m5318n();
                        aVar.f10348l = false;
                    }
                    C3847u0.m5298w((C3847u0) aVar.f10347k, i, (C3834t0) ((AbstractC3851u4) aVarM5315t.m5320p()));
                }
                if (C3893x7.m5362b() && this.f11202a.f11260h.m5526o(C4142p.f11047N0)) {
                    arrayMap.put(strM5275q, Boolean.valueOf(((C3834t0) aVarM5315t.f10347k).m5271w()));
                } else {
                    arrayMap.put(aVarM5315t.m5275q(), Boolean.valueOf(((C3834t0) aVarM5315t.f10347k).m5271w()));
                }
                arrayMap2.put(aVarM5315t.m5275q(), Boolean.valueOf(((C3834t0) aVarM5315t.f10347k).m5272x()));
                if (((C3834t0) aVarM5315t.f10347k).m5273y()) {
                    if (aVarM5315t.m5276r() < 2 || aVarM5315t.m5276r() > 65535) {
                        mo5726g().f11144i.m5862c("Invalid sampling rate. Event name, sample rate", aVarM5315t.m5275q(), Integer.valueOf(aVarM5315t.m5276r()));
                    } else {
                        arrayMap3.put(aVarM5315t.m5275q(), Integer.valueOf(aVarM5315t.m5276r()));
                    }
                }
            }
        }
        this.f11118e.put(str, arrayMap);
        this.f11119f.put(str, arrayMap2);
        this.f11121h.put(str, arrayMap3);
    }

    @WorkerThread
    /* JADX INFO: renamed from: w */
    public final boolean m5781w(String str, byte[] bArr, String str2) {
        byte[] bArrM5052d;
        boolean z2;
        String str3;
        boolean z3;
        boolean z4;
        m5684n();
        mo5848b();
        C1460d.m583w(str);
        C3847u0.a aVarM5315t = m5779t(str, bArr).m5315t();
        m5780v(str, aVarM5315t);
        this.f11120g.put(str, (C3847u0) ((AbstractC3851u4) aVarM5315t.m5320p()));
        this.f11122i.put(str, str2);
        this.f11117d.put(str, m5772u((C3847u0) ((AbstractC3851u4) aVarM5315t.m5320p())));
        C4040g c4040gM5686q = m5686q();
        ArrayList<C3717k0> arrayList = new ArrayList(Collections.unmodifiableList(((C3847u0) aVarM5315t.f10347k).m5302D()));
        Objects.requireNonNull(c4040gM5686q);
        String str4 = "app_id=? and audience_id=?";
        String str5 = "null reference";
        int i = 0;
        while (i < arrayList.size()) {
            C3717k0.a aVarM5315t2 = ((C3717k0) arrayList.get(i)).m5315t();
            if (((C3717k0) aVarM5315t2.f10347k).m5015D() != 0) {
                int i2 = 0;
                while (i2 < ((C3717k0) aVarM5315t2.f10347k).m5015D()) {
                    C3730l0.a aVarM5315t3 = ((C3717k0) aVarM5315t2.f10347k).m5019z(i2).m5315t();
                    C3730l0.a aVar = (C3730l0.a) ((AbstractC3851u4.b) aVarM5315t3.clone());
                    C3847u0.a aVar2 = aVarM5315t;
                    String strM4263Y1 = C3404f.m4263Y1(((C3730l0) aVarM5315t3.f10347k).m5046z(), C4214v5.f11304a, C4214v5.f11306c);
                    if (strM4263Y1 != null) {
                        if (aVar.f10348l) {
                            aVar.m5318n();
                            aVar.f10348l = false;
                        }
                        C3730l0.m5034w((C3730l0) aVar.f10347k, strM4263Y1);
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    int i3 = 0;
                    while (i3 < ((C3730l0) aVarM5315t3.f10347k).m5036B()) {
                        C3743m0 c3743m0M5043u = ((C3730l0) aVarM5315t3.f10347k).m5043u(i3);
                        C3730l0.a aVar3 = aVarM5315t3;
                        String str6 = str4;
                        String str7 = str5;
                        String strM4263Y2 = C3404f.m4263Y1(c3743m0M5043u.m5064C(), C4203u5.f11279a, C4203u5.f11280b);
                        if (strM4263Y2 != null) {
                            C3743m0.a aVarM5315t4 = c3743m0M5043u.m5315t();
                            if (aVarM5315t4.f10348l) {
                                aVarM5315t4.m5318n();
                                aVarM5315t4.f10348l = false;
                            }
                            C3743m0.m5061u((C3743m0) aVarM5315t4.f10347k, strM4263Y2);
                            C3743m0 c3743m0 = (C3743m0) ((AbstractC3851u4) aVarM5315t4.m5320p());
                            if (aVar.f10348l) {
                                aVar.m5318n();
                                aVar.f10348l = false;
                            }
                            C3730l0.m5033v((C3730l0) aVar.f10347k, i3, c3743m0);
                            z4 = true;
                        }
                        i3++;
                        aVarM5315t3 = aVar3;
                        str4 = str6;
                        str5 = str7;
                    }
                    String str8 = str4;
                    String str9 = str5;
                    if (z4) {
                        if (aVarM5315t2.f10348l) {
                            aVarM5315t2.m5318n();
                            aVarM5315t2.f10348l = false;
                        }
                        C3717k0.m5010v((C3717k0) aVarM5315t2.f10347k, i2, (C3730l0) ((AbstractC3851u4) aVar.m5320p()));
                        arrayList.set(i, (C3717k0) ((AbstractC3851u4) aVarM5315t2.m5320p()));
                    }
                    i2++;
                    aVarM5315t = aVar2;
                    str4 = str8;
                    str5 = str9;
                }
            }
            C3847u0.a aVar4 = aVarM5315t;
            String str10 = str4;
            String str11 = str5;
            if (((C3717k0) aVarM5315t2.f10347k).m5013B() != 0) {
                for (int i4 = 0; i4 < ((C3717k0) aVarM5315t2.f10347k).m5013B(); i4++) {
                    C3769o0 c3769o0M5016u = ((C3717k0) aVarM5315t2.f10347k).m5016u(i4);
                    String strM4263Y3 = C3404f.m4263Y1(c3769o0M5016u.m5149x(), C4236x5.f11341a, C4236x5.f11342b);
                    if (strM4263Y3 != null) {
                        C3769o0.a aVarM5315t5 = c3769o0M5016u.m5315t();
                        if (aVarM5315t5.f10348l) {
                            aVarM5315t5.m5318n();
                            z3 = false;
                            aVarM5315t5.f10348l = false;
                        } else {
                            z3 = false;
                        }
                        C3769o0.m5143u((C3769o0) aVarM5315t5.f10347k, strM4263Y3);
                        if (aVarM5315t2.f10348l) {
                            aVarM5315t2.m5318n();
                            aVarM5315t2.f10348l = z3;
                        }
                        C3717k0.m5011w((C3717k0) aVarM5315t2.f10347k, i4, (C3769o0) ((AbstractC3851u4) aVarM5315t5.m5320p()));
                        arrayList.set(i, (C3717k0) ((AbstractC3851u4) aVarM5315t2.m5320p()));
                    }
                }
            }
            i++;
            aVarM5315t = aVar4;
            str4 = str10;
            str5 = str11;
        }
        C3847u0.a aVar5 = aVarM5315t;
        String str12 = str4;
        String str13 = str5;
        c4040gM5686q.m5684n();
        c4040gM5686q.mo5848b();
        C1460d.m583w(str);
        SQLiteDatabase sQLiteDatabaseM5640t = c4040gM5686q.m5640t();
        sQLiteDatabaseM5640t.beginTransaction();
        try {
            c4040gM5686q.m5684n();
            c4040gM5686q.mo5848b();
            C1460d.m583w(str);
            SQLiteDatabase sQLiteDatabaseM5640t2 = c4040gM5686q.m5640t();
            sQLiteDatabaseM5640t2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseM5640t2.delete("event_filters", "app_id=?", new String[]{str});
            for (C3717k0 c3717k0 : arrayList) {
                c4040gM5686q.m5684n();
                c4040gM5686q.mo5848b();
                C1460d.m583w(str);
                str13 = str13;
                Objects.requireNonNull(c3717k0, str13);
                if (c3717k0.m5017x()) {
                    int iM5018y = c3717k0.m5018y();
                    Iterator<C3730l0> it = c3717k0.m5014C().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            Iterator<C3769o0> it2 = c3717k0.m5012A().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    Iterator<C3730l0> it3 = c3717k0.m5014C().iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            z2 = true;
                                            break;
                                        }
                                        if (!c4040gM5686q.m5617O(str, iM5018y, it3.next())) {
                                            z2 = false;
                                            break;
                                        }
                                    }
                                    if (z2) {
                                        Iterator<C3769o0> it4 = c3717k0.m5012A().iterator();
                                        while (it4.hasNext()) {
                                            if (!c4040gM5686q.m5618P(str, iM5018y, it4.next())) {
                                                z2 = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (z2) {
                                        str3 = str12;
                                    } else {
                                        c4040gM5686q.m5684n();
                                        c4040gM5686q.mo5848b();
                                        C1460d.m583w(str);
                                        SQLiteDatabase sQLiteDatabaseM5640t3 = c4040gM5686q.m5640t();
                                        str3 = str12;
                                        sQLiteDatabaseM5640t3.delete("property_filters", str3, new String[]{str, String.valueOf(iM5018y)});
                                        sQLiteDatabaseM5640t3.delete("event_filters", str3, new String[]{str, String.valueOf(iM5018y)});
                                    }
                                    str12 = str3;
                                    break;
                                }
                                if (!it2.next().m5147v()) {
                                    c4040gM5686q.mo5726g().f11144i.m5862c("Property filter with no ID. Audience definition ignored. appId, audienceId", C4157q3.m5788s(str), Integer.valueOf(iM5018y));
                                }
                            }
                        } else if (!it.next().m5044x()) {
                            c4040gM5686q.mo5726g().f11144i.m5862c("Event filter with no ID. Audience definition ignored. appId, audienceId", C4157q3.m5788s(str), Integer.valueOf(iM5018y));
                        }
                    }
                } else {
                    c4040gM5686q.mo5726g().f11144i.m5861b("Audience with no ID. appId", C4157q3.m5788s(str));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (C3717k0 c3717k1 : arrayList) {
                arrayList2.add(c3717k1.m5017x() ? Integer.valueOf(c3717k1.m5018y()) : null);
            }
            c4040gM5686q.m5625W(str, arrayList2);
            sQLiteDatabaseM5640t.setTransactionSuccessful();
            sQLiteDatabaseM5640t.endTransaction();
            try {
                if (aVar5.f10348l) {
                    aVar5.m5318n();
                    aVar5.f10348l = false;
                }
                C3847u0.m5297v((C3847u0) aVar5.f10347k);
                bArrM5052d = ((C3847u0) ((AbstractC3851u4) aVar5.m5320p())).m5052d();
            } catch (RuntimeException e) {
                mo5726g().f11144i.m5862c("Unable to serialize reduced-size config. Storing full config instead. appId", C4157q3.m5788s(str), e);
                bArrM5052d = bArr;
            }
            C4040g c4040gM5686q2 = m5686q();
            C1460d.m583w(str);
            c4040gM5686q2.mo5848b();
            c4040gM5686q2.m5684n();
            ContentValues contentValues = new ContentValues();
            contentValues.put("remote_config", bArrM5052d);
            try {
                if (c4040gM5686q2.m5640t().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                    c4040gM5686q2.mo5726g().f11141f.m5861b("Failed to update remote config (got 0). appId", C4157q3.m5788s(str));
                }
            } catch (SQLiteException e2) {
                c4040gM5686q2.mo5726g().f11141f.m5862c("Error storing remote config. appId", C4157q3.m5788s(str), e2);
            }
            this.f11120g.put(str, (C3847u0) ((AbstractC3851u4) aVar5.m5320p()));
            return true;
        } catch (Throwable th) {
            sQLiteDatabaseM5640t.endTransaction();
            throw th;
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: x */
    public final boolean m5782x(String str, String str2) throws Throwable {
        Boolean bool;
        mo5848b();
        m5777E(str);
        if ("1".equals(mo5500h(str, "measurement.upload.blacklist_internal")) && C4196t9.m5885r0(str2)) {
            return true;
        }
        if ("1".equals(mo5500h(str, "measurement.upload.blacklist_public")) && C4196t9.m5877X(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f11118e.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WorkerThread
    /* JADX INFO: renamed from: y */
    public final boolean m5783y(String str, String str2) throws Throwable {
        Boolean bool;
        mo5848b();
        m5777E(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f11119f.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WorkerThread
    /* JADX INFO: renamed from: z */
    public final int m5784z(String str, String str2) throws Throwable {
        Integer num;
        mo5848b();
        m5777E(str);
        Map<String, Integer> map = this.f11121h.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }
}
