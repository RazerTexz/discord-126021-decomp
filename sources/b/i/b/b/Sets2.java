package b.i.b.b;

import b.i.b.b.Collections2;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: renamed from: b.i.b.b.n0, reason: use source file name */
/* JADX INFO: compiled from: Sets.java */
/* JADX INFO: loaded from: classes3.dex */
public class Sets2<E> extends AbstractIterator2<E> {
    public final Iterator<E> l;
    public final /* synthetic */ Collections2.a m;

    public Sets2(Collections2.a aVar) {
        this.m = aVar;
        this.l = aVar.j.iterator();
    }
}
