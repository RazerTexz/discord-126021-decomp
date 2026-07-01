package b.i.c.m.d.q;

import android.util.Log;
import b.i.c.m.d.k.d;
import b.i.c.m.d.k.x$l;
import b.i.c.m.d.q.c.c;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ReportUploader.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$d extends d {
    public final List<c> j;
    public final boolean k;
    public final float l;
    public final /* synthetic */ b m;

    public b$d(b bVar, List<c> list, boolean z2, float f) {
        this.m = bVar;
        this.j = list;
        this.k = z2;
        this.l = f;
    }

    @Override // b.i.c.m.d.k.d
    public void a() {
        try {
            b(this.j, this.k);
        } catch (Exception e) {
            if (b.i.c.m.d.b.a.a(6)) {
                Log.e("FirebaseCrashlytics", "An unexpected error occurred while attempting to upload crash reports.", e);
            }
        }
        this.m.h = null;
    }

    public final void b(List<c> list, boolean z2) {
        b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
        StringBuilder sbU = b.d.b.a.a.U("Starting report processing in ");
        sbU.append(this.l);
        sbU.append(" second(s)...");
        bVar.b(sbU.toString());
        float f = this.l;
        if (f > 0.0f) {
            try {
                Thread.sleep((long) (f * 1000.0f));
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        if (((x$l) this.m.g).a.p()) {
            return;
        }
        int i = 0;
        while (list.size() > 0 && !((x$l) this.m.g).a.p()) {
            b.i.c.m.d.b bVar2 = b.i.c.m.d.b.a;
            StringBuilder sbU2 = b.d.b.a.a.U("Attempting to send ");
            sbU2.append(list.size());
            sbU2.append(" report(s)");
            bVar2.b(sbU2.toString());
            ArrayList arrayList = new ArrayList();
            for (c cVar : list) {
                if (!this.m.a(cVar, z2)) {
                    arrayList.add(cVar);
                }
            }
            if (arrayList.size() > 0) {
                short[] sArr = b.a;
                int i2 = i + 1;
                long j = sArr[Math.min(i, sArr.length - 1)];
                b.i.c.m.d.b.a.b("Report submission: scheduling delayed retry in " + j + " seconds");
                try {
                    Thread.sleep(j * 1000);
                    i = i2;
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            list = arrayList;
        }
    }
}
