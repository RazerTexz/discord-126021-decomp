package b.f.e;

import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: DataSources.java */
/* JADX INFO: loaded from: classes.dex */
public final class e<T> implements Supplier<DataSource<T>> {
    public final /* synthetic */ Throwable a;

    public e(Throwable th) {
        this.a = th;
    }

    @Override // com.facebook.common.internal.Supplier
    public Object get() {
        return b.c.a.a0.d.N0(this.a);
    }
}
