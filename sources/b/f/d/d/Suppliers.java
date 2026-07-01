package b.f.d.d;

import com.facebook.common.internal.Supplier;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.f.d.d.k, reason: use source file name */
/* JADX INFO: compiled from: Suppliers.java */
/* JADX INFO: loaded from: classes.dex */
public final class Suppliers<T> implements Supplier<T> {
    public final /* synthetic */ Object a;

    public Suppliers(Object obj) {
        this.a = obj;
    }

    @Override // com.facebook.common.internal.Supplier
    public T get() {
        return (T) this.a;
    }
}
