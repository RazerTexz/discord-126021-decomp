package b.i.a.f.i.b;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import b.i.a.f.h.l.a1$a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class ca {
    public b.i.a.f.h.l.a1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f1522b;
    public long c;
    public final /* synthetic */ ba d;

    public ca(ba baVar, aa aaVar) {
        this.d = baVar;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0093 A[Catch: SQLiteException -> 0x00dd, all -> 0x01bc, TRY_LEAVE, TryCatch #3 {all -> 0x01bc, blocks: (B:25:0x008d, B:27:0x0093, B:29:0x00a3, B:30:0x00af, B:31:0x00c1, B:34:0x00ca, B:42:0x00e5), top: B:98:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00a3 A[Catch: SQLiteException -> 0x00dd, all -> 0x01bc, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x01bc, blocks: (B:25:0x008d, B:27:0x0093, B:29:0x00a3, B:30:0x00af, B:31:0x00c1, B:34:0x00ca, B:42:0x00e5), top: B:98:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:75:0x01c0  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v6, types: [long] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v5 */
    public final b.i.a.f.h.l.a1 a(String str, b.i.a.f.h.l.a1 a1Var) {
        g gVarQ;
        ?? r6;
        Cursor cursorRawQuery;
        Pair pairCreate;
        Object obj;
        ?? LongValue;
        String strF = a1Var.F();
        List<b.i.a.f.h.l.c1> listV = a1Var.v();
        this.d.m();
        Long l = (Long) q9.R(a1Var, "_eid");
        boolean z2 = l != null;
        if (z2 && strF.equals("_ep")) {
            this.d.m();
            String str2 = (String) q9.R(a1Var, "_en");
            if (TextUtils.isEmpty(str2)) {
                this.d.g().g.b("Extra parameter without an event name. eventId", l);
                return null;
            }
            if (this.a == null || this.f1522b == null) {
                gVarQ = this.d.q();
                gVarQ.b();
                gVarQ.n();
                try {
                    try {
                        cursorRawQuery = gVarQ.t().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                try {
                                    pairCreate = Pair.create((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) ((a1$a) q9.x(b.i.a.f.h.l.a1.M(), cursorRawQuery.getBlob(0))).p()), Long.valueOf(cursorRawQuery.getLong(1)));
                                    cursorRawQuery.close();
                                } catch (IOException e) {
                                    gVarQ.g().f.d("Failed to merge main event. appId, eventId", q3.s(str), l, e);
                                    cursorRawQuery.close();
                                    pairCreate = null;
                                }
                            } else {
                                gVarQ.g().n.a("Main event not found");
                                cursorRawQuery.close();
                                pairCreate = null;
                            }
                        } catch (SQLiteException e2) {
                            e = e2;
                            gVarQ.g().f.b("Error selecting main event", e);
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            pairCreate = null;
                            if (pairCreate != null) {
                            }
                            this.d.g().g.c("Extra parameter without existing main event. eventName, eventId", str2, l);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        r6 = LongValue;
                        if (r6 != 0) {
                            r6.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    cursorRawQuery = null;
                } catch (Throwable th2) {
                    th = th2;
                    r6 = 0;
                    if (r6 != 0) {
                        r6.close();
                    }
                    throw th;
                }
                if (pairCreate != null || (obj = pairCreate.first) == null) {
                    this.d.g().g.c("Extra parameter without existing main event. eventName, eventId", str2, l);
                    return null;
                }
                this.a = (b.i.a.f.h.l.a1) obj;
                this.c = ((Long) pairCreate.second).longValue();
                this.d.m();
                this.f1522b = (Long) q9.R(this.a, "_eid");
            } else {
                LongValue = l.longValue();
                if (LongValue != this.f1522b.longValue()) {
                    gVarQ = this.d.q();
                    gVarQ.b();
                    gVarQ.n();
                    cursorRawQuery = gVarQ.t().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
                    if (cursorRawQuery.moveToFirst()) {
                        gVarQ.g().n.a("Main event not found");
                        cursorRawQuery.close();
                        pairCreate = null;
                    } else {
                        pairCreate = Pair.create((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) ((a1$a) q9.x(b.i.a.f.h.l.a1.M(), cursorRawQuery.getBlob(0))).p()), Long.valueOf(cursorRawQuery.getLong(1)));
                        cursorRawQuery.close();
                    }
                    if (pairCreate != null) {
                    }
                    this.d.g().g.c("Extra parameter without existing main event. eventName, eventId", str2, l);
                    return null;
                }
            }
            long j = this.c - 1;
            this.c = j;
            if (j <= 0) {
                g gVarQ2 = this.d.q();
                gVarQ2.b();
                gVarQ2.g().n.b("Clearing complex main event info. appId", str);
                try {
                    gVarQ2.t().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e4) {
                    gVarQ2.g().f.b("Error clearing complex main event", e4);
                }
            } else {
                this.d.q().Q(str, l, this.c, this.a);
            }
            ArrayList arrayList = new ArrayList();
            for (b.i.a.f.h.l.c1 c1Var : this.a.v()) {
                this.d.m();
                if (q9.w(a1Var, c1Var.B()) == null) {
                    arrayList.add(c1Var);
                }
            }
            if (arrayList.isEmpty()) {
                this.d.g().g.b("No unique parameters in main event. eventName", str2);
            } else {
                arrayList.addAll(listV);
                listV = arrayList;
            }
            strF = str2;
        } else if (z2) {
            this.f1522b = l;
            this.a = a1Var;
            this.d.m();
            Object objR = q9.R(a1Var, "_epc");
            long jLongValue = ((Long) (objR != null ? objR : 0L)).longValue();
            this.c = jLongValue;
            if (jLongValue <= 0) {
                this.d.g().g.b("Complex event with zero extra param count. eventName", strF);
            } else {
                this.d.q().Q(str, l, this.c, a1Var);
            }
        }
        a1$a a1_aT = a1Var.t();
        a1_aT.t(strF);
        if (a1_aT.l) {
            a1_aT.n();
            a1_aT.l = false;
        }
        b.i.a.f.h.l.a1.w((b.i.a.f.h.l.a1) a1_aT.k);
        if (a1_aT.l) {
            a1_aT.n();
            a1_aT.l = false;
        }
        b.i.a.f.h.l.a1.B((b.i.a.f.h.l.a1) a1_aT.k, listV);
        return (b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) a1_aT.p());
    }
}
