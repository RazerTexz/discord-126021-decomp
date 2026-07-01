package b.i.d.q;

import java.util.ArrayDeque;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public class l<T> implements ObjectConstructor<T> {
    public l(g gVar) {
    }

    @Override // b.i.d.q.ObjectConstructor
    public T a() {
        return (T) new ArrayDeque();
    }
}
