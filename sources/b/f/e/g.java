package b.f.e;

import b.f.d.d.i;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import java.util.List;

/* JADX INFO: compiled from: FirstAvailableDataSourceSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class g<T> implements Supplier<DataSource<T>> {
    public final List<Supplier<DataSource<T>>> a;

    public g(List<Supplier<DataSource<T>>> list) {
        b.c.a.a0.d.k(!list.isEmpty(), "List of suppliers is empty!");
        this.a = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            return b.c.a.a0.d.g0(this.a, ((g) obj).a);
        }
        return false;
    }

    @Override // com.facebook.common.internal.Supplier
    public Object get() {
        return new g$b(this);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        i iVarH2 = b.c.a.a0.d.h2(this);
        iVarH2.c("list", this.a);
        return iVarH2.toString();
    }
}
