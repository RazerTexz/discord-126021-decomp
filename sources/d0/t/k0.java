package d0.t;

import java.util.List;

/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes3.dex */
public class k0<T> extends c<T> {
    public final List<T> k;

    /* JADX WARN: Multi-variable type inference failed */
    public k0(List<? extends T> list) {
        d0.z.d.m.checkNotNullParameter(list, "delegate");
        this.k = list;
    }

    @Override // d0.t.c, java.util.List
    public T get(int i) {
        return this.k.get(s.access$reverseElementIndex(this, i));
    }

    @Override // d0.t.a
    public int getSize() {
        return this.k.size();
    }
}
