package p007b.p225i.p226a.p288f.p330i.p332b;

import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.i.b.m9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4119m9 implements InterfaceC4256z3 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String f10972a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C4097k9 f10973b;

    public C4119m9(C4097k9 c4097k9, String str) {
        this.f10973b = c4097k9;
        this.f10972a = str;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4256z3
    /* JADX INFO: renamed from: a */
    public final void mo5751a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        C4097k9 c4097k9 = this.f10973b;
        c4097k9.m5720U();
        c4097k9.m5715P();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                c4097k9.f10914s = false;
                c4097k9.m5743x();
                throw th2;
            }
        }
        List<Long> list = c4097k9.f10918w;
        c4097k9.f10918w = null;
        boolean z2 = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                C4057h4 c4057h4 = c4097k9.f10906k.m5946o().f10636f;
                Objects.requireNonNull((C3401c) c4097k9.f10906k.f11267o);
                c4057h4.m5649b(System.currentTimeMillis());
                c4097k9.f10906k.m5946o().f10637g.m5649b(0L);
                c4097k9.m5742w();
                c4097k9.f10906k.mo5726g().f11149n.m5862c("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                c4097k9.m5710K().m5630b0();
                try {
                    for (Long l : list) {
                        try {
                            C4040g c4040gM5710K = c4097k9.m5710K();
                            long jLongValue = l.longValue();
                            c4040gM5710K.mo5848b();
                            c4040gM5710K.m5684n();
                            try {
                                if (c4040gM5710K.m5640t().delete("queue", "rowid=?", new String[]{String.valueOf(jLongValue)}) != 1) {
                                    throw new SQLiteException("Deleted fewer rows from queue than expected");
                                }
                            } catch (SQLiteException e) {
                                c4040gM5710K.mo5726g().f11141f.m5861b("Failed to delete a bundle in a queue table", e);
                                throw e;
                            }
                        } catch (SQLiteException e2) {
                            List<Long> list2 = c4097k9.f10919x;
                            if (list2 == null || !list2.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    c4097k9.m5710K().m5639s();
                    c4097k9.m5710K().m5633e0();
                    c4097k9.f10919x = null;
                    if (c4097k9.m5709J().m5963u() && c4097k9.m5741v()) {
                        c4097k9.m5716Q();
                    } else {
                        c4097k9.f10920y = -1L;
                        c4097k9.m5742w();
                    }
                    c4097k9.f10909n = 0L;
                } catch (Throwable th3) {
                    c4097k9.m5710K().m5633e0();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                c4097k9.f10906k.mo5726g().f11141f.m5861b("Database error while trying to delete uploaded bundles", e3);
                Objects.requireNonNull((C3401c) c4097k9.f10906k.f11267o);
                c4097k9.f10909n = SystemClock.elapsedRealtime();
                c4097k9.f10906k.mo5726g().f11149n.m5861b("Disable upload, time", Long.valueOf(c4097k9.f10909n));
            }
        } else {
            c4097k9.f10906k.mo5726g().f11149n.m5862c("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            C4057h4 c4057h5 = c4097k9.f10906k.m5946o().f10637g;
            Objects.requireNonNull((C3401c) c4097k9.f10906k.f11267o);
            c4057h5.m5649b(System.currentTimeMillis());
            if (i != 503 && i != 429) {
                z2 = false;
            }
            if (z2) {
                C4057h4 c4057h6 = c4097k9.f10906k.m5946o().f10638h;
                Objects.requireNonNull((C3401c) c4097k9.f10906k.f11267o);
                c4057h6.m5649b(System.currentTimeMillis());
            }
            c4097k9.m5710K().m5612J(list);
            c4097k9.m5742w();
        }
        c4097k9.f10914s = false;
        c4097k9.m5743x();
    }
}
