package p007b.p225i.p226a.p288f.p330i.p332b;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3579a1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3607c1;

/* JADX INFO: renamed from: b.i.a.f.i.b.ca */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4003ca {

    /* JADX INFO: renamed from: a */
    public C3579a1 f10618a;

    /* JADX INFO: renamed from: b */
    public Long f10619b;

    /* JADX INFO: renamed from: c */
    public long f10620c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C3991ba f10621d;

    public C4003ca(C3991ba c3991ba, C3979aa c3979aa) {
        this.f10621d = c3991ba;
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
    /* JADX INFO: renamed from: a */
    public final C3579a1 m5561a(String str, C3579a1 c3579a1) {
        C4040g c4040gM5686q;
        ?? r6;
        Cursor cursorRawQuery;
        Pair pairCreate;
        Object obj;
        ?? LongValue;
        String strM4533F = c3579a1.m4533F();
        List<C3607c1> listM4543v = c3579a1.m4543v();
        this.f10621d.m5683m();
        Long l = (Long) C4163q9.m5829R(c3579a1, "_eid");
        boolean z2 = l != null;
        if (z2 && strM4533F.equals("_ep")) {
            this.f10621d.m5683m();
            String str2 = (String) C4163q9.m5829R(c3579a1, "_en");
            if (TextUtils.isEmpty(str2)) {
                this.f10621d.mo5726g().f11142g.m5861b("Extra parameter without an event name. eventId", l);
                return null;
            }
            if (this.f10618a == null || this.f10619b == null) {
                c4040gM5686q = this.f10621d.m5686q();
                c4040gM5686q.mo5848b();
                c4040gM5686q.m5684n();
                try {
                    try {
                        cursorRawQuery = c4040gM5686q.m5640t().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                try {
                                    pairCreate = Pair.create((C3579a1) ((AbstractC3851u4) ((C3579a1.a) C4163q9.m5832x(C3579a1.m4526M(), cursorRawQuery.getBlob(0))).m5320p()), Long.valueOf(cursorRawQuery.getLong(1)));
                                    cursorRawQuery.close();
                                } catch (IOException e) {
                                    c4040gM5686q.mo5726g().f11141f.m5863d("Failed to merge main event. appId, eventId", C4157q3.m5788s(str), l, e);
                                    cursorRawQuery.close();
                                    pairCreate = null;
                                }
                            } else {
                                c4040gM5686q.mo5726g().f11149n.m5860a("Main event not found");
                                cursorRawQuery.close();
                                pairCreate = null;
                            }
                        } catch (SQLiteException e2) {
                            e = e2;
                            c4040gM5686q.mo5726g().f11141f.m5861b("Error selecting main event", e);
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            pairCreate = null;
                            if (pairCreate != null) {
                            }
                            this.f10621d.mo5726g().f11142g.m5862c("Extra parameter without existing main event. eventName, eventId", str2, l);
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
                    this.f10621d.mo5726g().f11142g.m5862c("Extra parameter without existing main event. eventName, eventId", str2, l);
                    return null;
                }
                this.f10618a = (C3579a1) obj;
                this.f10620c = ((Long) pairCreate.second).longValue();
                this.f10621d.m5683m();
                this.f10619b = (Long) C4163q9.m5829R(this.f10618a, "_eid");
            } else {
                LongValue = l.longValue();
                if (LongValue != this.f10619b.longValue()) {
                    c4040gM5686q = this.f10621d.m5686q();
                    c4040gM5686q.mo5848b();
                    c4040gM5686q.m5684n();
                    cursorRawQuery = c4040gM5686q.m5640t().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
                    if (cursorRawQuery.moveToFirst()) {
                        c4040gM5686q.mo5726g().f11149n.m5860a("Main event not found");
                        cursorRawQuery.close();
                        pairCreate = null;
                    } else {
                        pairCreate = Pair.create((C3579a1) ((AbstractC3851u4) ((C3579a1.a) C4163q9.m5832x(C3579a1.m4526M(), cursorRawQuery.getBlob(0))).m5320p()), Long.valueOf(cursorRawQuery.getLong(1)));
                        cursorRawQuery.close();
                    }
                    if (pairCreate != null) {
                    }
                    this.f10621d.mo5726g().f11142g.m5862c("Extra parameter without existing main event. eventName, eventId", str2, l);
                    return null;
                }
            }
            long j = this.f10620c - 1;
            this.f10620c = j;
            if (j <= 0) {
                C4040g c4040gM5686q2 = this.f10621d.m5686q();
                c4040gM5686q2.mo5848b();
                c4040gM5686q2.mo5726g().f11149n.m5861b("Clearing complex main event info. appId", str);
                try {
                    c4040gM5686q2.m5640t().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e4) {
                    c4040gM5686q2.mo5726g().f11141f.m5861b("Error clearing complex main event", e4);
                }
            } else {
                this.f10621d.m5686q().m5619Q(str, l, this.f10620c, this.f10618a);
            }
            ArrayList arrayList = new ArrayList();
            for (C3607c1 c3607c1 : this.f10618a.m4543v()) {
                this.f10621d.m5683m();
                if (C4163q9.m5831w(c3579a1, c3607c1.m4587B()) == null) {
                    arrayList.add(c3607c1);
                }
            }
            if (arrayList.isEmpty()) {
                this.f10621d.mo5726g().f11142g.m5861b("No unique parameters in main event. eventName", str2);
            } else {
                arrayList.addAll(listM4543v);
                listM4543v = arrayList;
            }
            strM4533F = str2;
        } else if (z2) {
            this.f10619b = l;
            this.f10618a = c3579a1;
            this.f10621d.m5683m();
            Object objM5829R = C4163q9.m5829R(c3579a1, "_epc");
            long jLongValue = ((Long) (objM5829R != null ? objM5829R : 0L)).longValue();
            this.f10620c = jLongValue;
            if (jLongValue <= 0) {
                this.f10621d.mo5726g().f11142g.m5861b("Complex event with zero extra param count. eventName", strM4533F);
            } else {
                this.f10621d.m5686q().m5619Q(str, l, this.f10620c, c3579a1);
            }
        }
        C3579a1.a aVarM5315t = c3579a1.m5315t();
        aVarM5315t.m4548t(strM4533F);
        if (aVarM5315t.f10348l) {
            aVarM5315t.m5318n();
            aVarM5315t.f10348l = false;
        }
        C3579a1.m4528w((C3579a1) aVarM5315t.f10347k);
        if (aVarM5315t.f10348l) {
            aVarM5315t.m5318n();
            aVarM5315t.f10348l = false;
        }
        C3579a1.m4523B((C3579a1) aVarM5315t.f10347k, listM4543v);
        return (C3579a1) ((AbstractC3851u4) aVarM5315t.m5320p());
    }
}
