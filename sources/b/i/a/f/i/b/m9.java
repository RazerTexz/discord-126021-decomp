package b.i.a.f.i.b;

import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m9 implements z3 {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k9 f1550b;

    public m9(k9 k9Var, String str) {
        this.f1550b = k9Var;
        this.a = str;
    }

    @Override // b.i.a.f.i.b.z3
    public final void a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        k9 k9Var = this.f1550b;
        k9Var.U();
        k9Var.P();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                k9Var.f1543s = false;
                k9Var.x();
                throw th2;
            }
        }
        List<Long> list = k9Var.w;
        k9Var.w = null;
        boolean z2 = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                h4 h4Var = k9Var.k.o().f;
                Objects.requireNonNull((b.i.a.f.e.o.c) k9Var.k.o);
                h4Var.b(System.currentTimeMillis());
                k9Var.k.o().g.b(0L);
                k9Var.w();
                k9Var.k.g().n.c("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                k9Var.K().b0();
                try {
                    for (Long l : list) {
                        try {
                            g gVarK = k9Var.K();
                            long jLongValue = l.longValue();
                            gVarK.b();
                            gVarK.n();
                            try {
                                if (gVarK.t().delete("queue", "rowid=?", new String[]{String.valueOf(jLongValue)}) != 1) {
                                    throw new SQLiteException("Deleted fewer rows from queue than expected");
                                }
                            } catch (SQLiteException e) {
                                gVarK.g().f.b("Failed to delete a bundle in a queue table", e);
                                throw e;
                            }
                        } catch (SQLiteException e2) {
                            List<Long> list2 = k9Var.f1544x;
                            if (list2 == null || !list2.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    k9Var.K().s();
                    k9Var.K().e0();
                    k9Var.f1544x = null;
                    if (k9Var.J().u() && k9Var.v()) {
                        k9Var.Q();
                    } else {
                        k9Var.f1545y = -1L;
                        k9Var.w();
                    }
                    k9Var.n = 0L;
                } catch (Throwable th3) {
                    k9Var.K().e0();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                k9Var.k.g().f.b("Database error while trying to delete uploaded bundles", e3);
                Objects.requireNonNull((b.i.a.f.e.o.c) k9Var.k.o);
                k9Var.n = SystemClock.elapsedRealtime();
                k9Var.k.g().n.b("Disable upload, time", Long.valueOf(k9Var.n));
            }
        } else {
            k9Var.k.g().n.c("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            h4 h4Var2 = k9Var.k.o().g;
            Objects.requireNonNull((b.i.a.f.e.o.c) k9Var.k.o);
            h4Var2.b(System.currentTimeMillis());
            if (i != 503 && i != 429) {
                z2 = false;
            }
            if (z2) {
                h4 h4Var3 = k9Var.k.o().h;
                Objects.requireNonNull((b.i.a.f.e.o.c) k9Var.k.o);
                h4Var3.b(System.currentTimeMillis());
            }
            k9Var.K().J(list);
            k9Var.w();
        }
        k9Var.f1543s = false;
        k9Var.x();
    }
}
