package b.f.e;

import com.facebook.datasource.DataSource;
import java.util.Objects;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: FirstAvailableDataSourceSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class g$b$a<T> implements f<T> {
    public final /* synthetic */ g$b a;

    public g$b$a(g$b g_b, g$a g_a) {
        this.a = g_b;
    }

    @Override // b.f.e.f
    public void onCancellation(DataSource<T> dataSource) {
    }

    @Override // b.f.e.f
    public void onFailure(DataSource<T> dataSource) {
        g$b.o(this.a, dataSource);
    }

    @Override // b.f.e.f
    public void onNewResult(DataSource<T> dataSource) throws Throwable {
        DataSource<T> dataSource2;
        if (!dataSource.b()) {
            if (((c) dataSource).c()) {
                g$b.o(this.a, dataSource);
                return;
            }
            return;
        }
        g$b g_b = this.a;
        Objects.requireNonNull(g_b);
        c cVar = (c) dataSource;
        boolean zC = cVar.c();
        synchronized (g_b) {
            if (dataSource == g_b.i && dataSource != (dataSource2 = g_b.j)) {
                if (dataSource2 == null || zC) {
                    g_b.j = dataSource;
                } else {
                    dataSource2 = null;
                }
                if (dataSource2 != null) {
                    dataSource2.close();
                }
            }
        }
        if (dataSource == g_b.p()) {
            g_b.m(null, cVar.c(), cVar.a);
        }
    }

    @Override // b.f.e.f
    public void onProgressUpdate(DataSource<T> dataSource) {
        this.a.l(Math.max(this.a.getProgress(), ((c) dataSource).getProgress()));
    }
}
