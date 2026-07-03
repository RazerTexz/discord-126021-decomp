package p007b.p109f.p129e;

import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p117b.C1670a;
import p007b.p109f.p115d.p119d.C1686i;

/* JADX INFO: renamed from: b.f.e.g */
/* JADX INFO: compiled from: FirstAvailableDataSourceSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class C1727g<T> implements Supplier<DataSource<T>> {

    /* JADX INFO: renamed from: a */
    public final List<Supplier<DataSource<T>>> f3160a;

    /* JADX INFO: renamed from: b.f.e.g$b */
    /* JADX INFO: compiled from: FirstAvailableDataSourceSupplier.java */
    public class b extends AbstractC1723c<T> {

        /* JADX INFO: renamed from: h */
        public int f3161h = 0;

        /* JADX INFO: renamed from: i */
        public DataSource<T> f3162i = null;

        /* JADX INFO: renamed from: j */
        public DataSource<T> f3163j = null;

        /* JADX INFO: renamed from: b.f.e.g$b$a */
        /* JADX INFO: compiled from: FirstAvailableDataSourceSupplier.java */
        public class a implements InterfaceC1726f<T> {
            public a(a aVar) {
            }

            @Override // p007b.p109f.p129e.InterfaceC1726f
            public void onCancellation(DataSource<T> dataSource) {
            }

            @Override // p007b.p109f.p129e.InterfaceC1726f
            public void onFailure(DataSource<T> dataSource) {
                b.m1031o(b.this, dataSource);
            }

            @Override // p007b.p109f.p129e.InterfaceC1726f
            public void onNewResult(DataSource<T> dataSource) throws Throwable {
                DataSource<T> dataSource2;
                if (!dataSource.mo1018b()) {
                    if (((AbstractC1723c) dataSource).mo1019c()) {
                        b.m1031o(b.this, dataSource);
                        return;
                    }
                    return;
                }
                b bVar = b.this;
                Objects.requireNonNull(bVar);
                AbstractC1723c abstractC1723c = (AbstractC1723c) dataSource;
                boolean zMo1019c = abstractC1723c.mo1019c();
                synchronized (bVar) {
                    if (dataSource == bVar.f3162i && dataSource != (dataSource2 = bVar.f3163j)) {
                        if (dataSource2 == null || zMo1019c) {
                            bVar.f3163j = dataSource;
                        } else {
                            dataSource2 = null;
                        }
                        if (dataSource2 != null) {
                            dataSource2.close();
                        }
                    }
                }
                if (dataSource == bVar.m1032p()) {
                    bVar.m1029m(null, abstractC1723c.mo1019c(), abstractC1723c.f3152a);
                }
            }

            @Override // p007b.p109f.p129e.InterfaceC1726f
            public void onProgressUpdate(DataSource<T> dataSource) {
                b.this.m1028l(Math.max(b.this.getProgress(), ((AbstractC1723c) dataSource).getProgress()));
            }
        }

        public b() {
            if (m1033q()) {
                return;
            }
            m1027k(new RuntimeException("No data source supplier or supplier returned null."), null);
        }

        /* JADX INFO: renamed from: o */
        public static void m1031o(b bVar, DataSource dataSource) {
            boolean z2;
            synchronized (bVar) {
                if (bVar.m1025i() || dataSource != bVar.f3162i) {
                    z2 = false;
                } else {
                    bVar.f3162i = null;
                    z2 = true;
                }
            }
            if (z2) {
                if (dataSource != bVar.m1032p() && dataSource != null) {
                    dataSource.close();
                }
                if (bVar.m1033q()) {
                    return;
                }
                bVar.m1027k(dataSource.mo1020d(), dataSource.mo1017a());
            }
        }

        @Override // p007b.p109f.p129e.AbstractC1723c, com.facebook.datasource.DataSource
        /* JADX INFO: renamed from: b */
        public synchronized boolean mo1018b() {
            DataSource<T> dataSourceM1032p;
            dataSourceM1032p = m1032p();
            return dataSourceM1032p != null && dataSourceM1032p.mo1018b();
        }

        @Override // p007b.p109f.p129e.AbstractC1723c, com.facebook.datasource.DataSource
        public boolean close() {
            synchronized (this) {
                if (!super.close()) {
                    return false;
                }
                DataSource<T> dataSource = this.f3162i;
                this.f3162i = null;
                DataSource<T> dataSource2 = this.f3163j;
                this.f3163j = null;
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

        @Override // p007b.p109f.p129e.AbstractC1723c, com.facebook.datasource.DataSource
        public synchronized T getResult() {
            DataSource<T> dataSourceM1032p;
            dataSourceM1032p = m1032p();
            return dataSourceM1032p != null ? dataSourceM1032p.getResult() : null;
        }

        /* JADX INFO: renamed from: p */
        public final synchronized DataSource<T> m1032p() {
            return this.f3163j;
        }

        /* JADX INFO: renamed from: q */
        public final boolean m1033q() {
            Supplier<DataSource<T>> supplier;
            boolean z2;
            synchronized (this) {
                if (m1025i() || this.f3161h >= C1727g.this.f3160a.size()) {
                    supplier = null;
                } else {
                    List<Supplier<DataSource<T>>> list = C1727g.this.f3160a;
                    int i = this.f3161h;
                    this.f3161h = i + 1;
                    supplier = list.get(i);
                }
            }
            DataSource<T> dataSource = supplier != null ? supplier.get() : null;
            synchronized (this) {
                if (m1025i()) {
                    z2 = false;
                } else {
                    this.f3162i = dataSource;
                    z2 = true;
                }
            }
            if (z2 && dataSource != null) {
                dataSource.mo1022f(new a(null), C1670a.f3078j);
                return true;
            }
            if (dataSource != null) {
                dataSource.close();
            }
            return false;
        }
    }

    public C1727g(List<Supplier<DataSource<T>>> list) {
        C1460d.m535k(!list.isEmpty(), "List of suppliers is empty!");
        this.f3160a = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1727g) {
            return C1460d.m520g0(this.f3160a, ((C1727g) obj).f3160a);
        }
        return false;
    }

    @Override // com.facebook.common.internal.Supplier
    public Object get() {
        return new b();
    }

    public int hashCode() {
        return this.f3160a.hashCode();
    }

    public String toString() {
        C1686i c1686iM526h2 = C1460d.m526h2(this);
        c1686iM526h2.m971c("list", this.f3160a);
        return c1686iM526h2.toString();
    }
}
