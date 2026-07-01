package b.f.e;

import b.c.a.a0.AnimatableValueParser;
import b.f.d.b.CallerThreadExecutor;
import b.f.d.d.Objects2;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.e.g, reason: use source file name */
/* JADX INFO: compiled from: FirstAvailableDataSourceSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class FirstAvailableDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    public final List<Supplier<DataSource<T>>> a;

    /* JADX INFO: renamed from: b.f.e.g$b */
    /* JADX INFO: compiled from: FirstAvailableDataSourceSupplier.java */
    public class b extends AbstractDataSource3<T> {
        public int h = 0;
        public DataSource<T> i = null;
        public DataSource<T> j = null;

        /* JADX INFO: renamed from: b.f.e.g$b$a */
        /* JADX INFO: compiled from: FirstAvailableDataSourceSupplier.java */
        public class a implements DataSubscriber<T> {
            public a(a aVar) {
            }

            @Override // b.f.e.DataSubscriber
            public void onCancellation(DataSource<T> dataSource) {
            }

            @Override // b.f.e.DataSubscriber
            public void onFailure(DataSource<T> dataSource) {
                b.o(b.this, dataSource);
            }

            @Override // b.f.e.DataSubscriber
            public void onNewResult(DataSource<T> dataSource) throws Throwable {
                DataSource<T> dataSource2;
                if (!dataSource.b()) {
                    if (((AbstractDataSource3) dataSource).c()) {
                        b.o(b.this, dataSource);
                        return;
                    }
                    return;
                }
                b bVar = b.this;
                Objects.requireNonNull(bVar);
                AbstractDataSource3 abstractDataSource3 = (AbstractDataSource3) dataSource;
                boolean zC = abstractDataSource3.c();
                synchronized (bVar) {
                    if (dataSource == bVar.i && dataSource != (dataSource2 = bVar.j)) {
                        if (dataSource2 == null || zC) {
                            bVar.j = dataSource;
                        } else {
                            dataSource2 = null;
                        }
                        if (dataSource2 != null) {
                            dataSource2.close();
                        }
                    }
                }
                if (dataSource == bVar.p()) {
                    bVar.m(null, abstractDataSource3.c(), abstractDataSource3.a);
                }
            }

            @Override // b.f.e.DataSubscriber
            public void onProgressUpdate(DataSource<T> dataSource) {
                b.this.l(Math.max(b.this.getProgress(), ((AbstractDataSource3) dataSource).getProgress()));
            }
        }

        public b() {
            if (q()) {
                return;
            }
            k(new RuntimeException("No data source supplier or supplier returned null."), null);
        }

        public static void o(b bVar, DataSource dataSource) {
            boolean z2;
            synchronized (bVar) {
                if (bVar.i() || dataSource != bVar.i) {
                    z2 = false;
                } else {
                    bVar.i = null;
                    z2 = true;
                }
            }
            if (z2) {
                if (dataSource != bVar.p() && dataSource != null) {
                    dataSource.close();
                }
                if (bVar.q()) {
                    return;
                }
                bVar.k(dataSource.d(), dataSource.a());
            }
        }

        @Override // b.f.e.AbstractDataSource3, com.facebook.datasource.DataSource
        public synchronized boolean b() {
            DataSource<T> dataSourceP;
            dataSourceP = p();
            return dataSourceP != null && dataSourceP.b();
        }

        @Override // b.f.e.AbstractDataSource3, com.facebook.datasource.DataSource
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

        @Override // b.f.e.AbstractDataSource3, com.facebook.datasource.DataSource
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
                if (i() || this.h >= FirstAvailableDataSourceSupplier.this.a.size()) {
                    supplier = null;
                } else {
                    List<Supplier<DataSource<T>>> list = FirstAvailableDataSourceSupplier.this.a;
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
                dataSource.f(new a(null), CallerThreadExecutor.j);
                return true;
            }
            if (dataSource != null) {
                dataSource.close();
            }
            return false;
        }
    }

    public FirstAvailableDataSourceSupplier(List<Supplier<DataSource<T>>> list) {
        AnimatableValueParser.k(!list.isEmpty(), "List of suppliers is empty!");
        this.a = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FirstAvailableDataSourceSupplier) {
            return AnimatableValueParser.g0(this.a, ((FirstAvailableDataSourceSupplier) obj).a);
        }
        return false;
    }

    @Override // com.facebook.common.internal.Supplier
    public Object get() {
        return new b();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        Objects2 objects2H2 = AnimatableValueParser.h2(this);
        objects2H2.c("list", this.a);
        return objects2H2.toString();
    }
}
