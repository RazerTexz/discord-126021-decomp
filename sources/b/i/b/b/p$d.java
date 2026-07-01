package b.i.b.b;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: compiled from: ImmutableList.java */
/* JADX INFO: loaded from: classes3.dex */
public class p$d<E> extends p<E> {
    public final transient int l;
    public final transient int m;
    public final /* synthetic */ p this$0;

    public p$d(p pVar, int i, int i2) {
        this.this$0 = pVar;
        this.l = i;
        this.m = i2;
    }

    @Override // b.i.b.b.n
    public Object[] e() {
        return this.this$0.e();
    }

    @Override // b.i.b.b.n
    public int g() {
        return this.this$0.h() + this.l + this.m;
    }

    @Override // java.util.List
    public E get(int i) {
        b.i.a.f.e.o.f.x(i, this.m);
        return this.this$0.get(i + this.l);
    }

    @Override // b.i.b.b.n
    public int h() {
        return this.this$0.h() + this.l;
    }

    @Override // b.i.b.b.n
    public boolean i() {
        return true;
    }

    @Override // b.i.b.b.p, b.i.b.b.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return p();
    }

    @Override // b.i.b.b.p, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return p();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.m;
    }

    @Override // b.i.b.b.p, java.util.List
    public /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return w(i, i2);
    }

    @Override // b.i.b.b.p
    public p<E> w(int i, int i2) {
        b.i.a.f.e.o.f.D(i, i2, this.m);
        p pVar = this.this$0;
        int i3 = this.l;
        return pVar.w(i + i3, i2 + i3);
    }

    @Override // b.i.b.b.p, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return r(i);
    }
}
