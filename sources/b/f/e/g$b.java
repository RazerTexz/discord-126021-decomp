package b.f.e;

import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import java.util.List;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: FirstAvailableDataSourceSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class g$b<T> extends c<T> {
    public int h = 0;
    public DataSource<T> i = null;
    public DataSource<T> j = null;
    public final /* synthetic */ g k;

    public g$b(g gVar) {
        this.k = gVar;
        if (q()) {
            return;
        }
        k(new RuntimeException("No data source supplier or supplier returned null."), null);
    }

    public static void o(g$b g_b, DataSource dataSource) {
        boolean z2;
        synchronized (g_b) {
            if (g_b.i() || dataSource != g_b.i) {
                z2 = false;
            } else {
                g_b.i = null;
                z2 = true;
            }
        }
        if (z2) {
            if (dataSource != g_b.p() && dataSource != null) {
                dataSource.close();
            }
            if (g_b.q()) {
                return;
            }
            g_b.k(dataSource.d(), dataSource.a());
        }
    }

    @Override // b.f.e.c, com.facebook.datasource.DataSource
    public synchronized boolean b() {
        DataSource<T> dataSourceP;
        dataSourceP = p();
        return dataSourceP != null && dataSourceP.b();
    }

    @Override // b.f.e.c, com.facebook.datasource.DataSource
    public boolean close() {
        synchronized (this) {
            if (!super.close()) {
                return false;
            }
            DataSource<T> dataSource = this.i;
            this.i = null;
            DataSource<T> dataSource2 = this.j;
            this.j = null;
            if (dataSource2 != null) {
                dataSource2.close();
            }
            if (dataSource == null) {
                return true;
            }
            dataSource.close();
            return true;
        }
    }

    @Override // b.f.e.c, com.facebook.datasource.DataSource
    public synchronized T getResult() {
        DataSource<T> dataSourceP;
        dataSourceP = p();
        return dataSourceP != null ? dataSourceP.getResult() : null;
    }

    public final synchronized DataSource<T> p() {
        return this.j;
    }

    public final boolean q() {
        Supplier<DataSource<T>> supplier;
        boolean z2;
        synchronized (this) {
            if (i() || this.h >= this.k.a.size()) {
                supplier = null;
            } else {
                List<Supplier<DataSource<T>>> list = this.k.a;
                int i = this.h;
                this.h = i + 1;
                supplier = list.get(i);
            }
        }
        DataSource<T> dataSource = supplier != null ? supplier.get() : null;
        synchronized (this) {
            if (i()) {
                z2 = false;
            } else {
                this.i = dataSource;
                z2 = true;
            }
        }
        if (z2 && dataSource != null) {
            dataSource.f(new g$b$a(this, null), b.f.d.b.a.j);
            return true;
        }
        if (dataSource != null) {
            dataSource.close();
        }
        return false;
    }
}
