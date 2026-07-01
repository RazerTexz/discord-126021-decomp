package b.i.a.f.h.l;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class k5 extends o3<String> implements j5, RandomAccess {
    public static final k5 k;
    public final List<Object> l;

    static {
        k5 k5Var = new k5(10);
        k = k5Var;
        k5Var.j = false;
    }

    public k5(int i) {
        this.l = new ArrayList(i);
    }

    public static String d(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof t3)) {
            Charset charset = w4.a;
            return new String((byte[]) obj, w4.a);
        }
        t3 t3Var = (t3) obj;
        Objects.requireNonNull(t3Var);
        return t3Var.d() == 0 ? "" : t3Var.i(w4.a);
    }

    @Override // b.i.a.f.h.l.j5
    public final Object A(int i) {
        return this.l.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        c();
        this.l.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // b.i.a.f.h.l.j5
    public final List<?> b() {
        return Collections.unmodifiableList(this.l);
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        c();
        this.l.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // b.i.a.f.h.l.b5
    public final /* synthetic */ b5 f(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.l);
        return new k5((ArrayList<Object>) arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        Object obj = this.l.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof t3) {
            t3 t3Var = (t3) obj;
            Objects.requireNonNull(t3Var);
            String strI = t3Var.d() == 0 ? "" : t3Var.i(w4.a);
            if (t3Var.m()) {
                this.l.set(i, strI);
            }
            return strI;
        }
        byte[] bArr = (byte[]) obj;
        Charset charset = w4.a;
        String str = new String(bArr, w4.a);
        if (k7.a.a(0, bArr, 0, bArr.length) == 0) {
            this.l.set(i, str);
        }
        return str;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        Object objRemove = this.l.remove(i);
        ((AbstractList) this).modCount++;
        return d(objRemove);
    }

    @Override // b.i.a.f.h.l.j5
    public final j5 s() {
        return this.j ? new e7(this) : this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        c();
        return d(this.l.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.l.size();
    }

    @Override // b.i.a.f.h.l.j5
    public final void t(t3 t3Var) {
        c();
        this.l.add(t3Var);
        ((AbstractList) this).modCount++;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        c();
        if (collection instanceof j5) {
            collection = ((j5) collection).b();
        }
        boolean zAddAll = this.l.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    public k5(ArrayList<Object> arrayList) {
        this.l = arrayList;
    }
}
