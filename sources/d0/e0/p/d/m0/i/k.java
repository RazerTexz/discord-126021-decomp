package d0.e0.p.d.m0.i;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: LazyStringArrayList.java */
/* JADX INFO: loaded from: classes3.dex */
public class k extends AbstractList<String> implements RandomAccess, l {
    public static final l j = new k().getUnmodifiableView();
    public final List<Object> k;

    public k() {
        this.k = new ArrayList();
    }

    public static String c(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof c ? ((c) obj).toStringUtf8() : h.toStringUtf8((byte[]) obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        add(i, (String) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.k.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int i) {
        return get(i);
    }

    @Override // d0.e0.p.d.m0.i.l
    public c getByteString(int i) {
        c cVarCopyFromUtf8;
        Object obj = this.k.get(i);
        if (obj instanceof c) {
            cVarCopyFromUtf8 = (c) obj;
        } else {
            cVarCopyFromUtf8 = obj instanceof String ? c.copyFromUtf8((String) obj) : c.copyFrom((byte[]) obj);
        }
        if (cVarCopyFromUtf8 != obj) {
            this.k.set(i, cVarCopyFromUtf8);
        }
        return cVarCopyFromUtf8;
    }

    @Override // d0.e0.p.d.m0.i.l
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.k);
    }

    @Override // d0.e0.p.d.m0.i.l
    public l getUnmodifiableView() {
        return new u(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int i) {
        return remove(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        return set(i, (String) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.k.size();
    }

    public void add(int i, String str) {
        this.k.add(i, str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends String> collection) {
        if (collection instanceof l) {
            collection = ((l) collection).getUnderlyingElements();
        }
        boolean zAddAll = this.k.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        Object obj = this.k.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            String stringUtf8 = cVar.toStringUtf8();
            if (cVar.isValidUtf8()) {
                this.k.set(i, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String stringUtf9 = h.toStringUtf8(bArr);
        if (h.isValidUtf8(bArr)) {
            this.k.set(i, stringUtf9);
        }
        return stringUtf9;
    }

    @Override // java.util.AbstractList, java.util.List
    public String remove(int i) {
        Object objRemove = this.k.remove(i);
        ((AbstractList) this).modCount++;
        return c(objRemove);
    }

    public String set(int i, String str) {
        return c(this.k.set(i, str));
    }

    public k(l lVar) {
        this.k = new ArrayList(lVar.size());
        addAll(lVar);
    }

    @Override // d0.e0.p.d.m0.i.l
    public void add(c cVar) {
        this.k.add(cVar);
        ((AbstractList) this).modCount++;
    }
}
