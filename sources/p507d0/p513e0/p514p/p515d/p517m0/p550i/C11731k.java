package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.k */
/* JADX INFO: compiled from: LazyStringArrayList.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11731k extends AbstractList<String> implements RandomAccess, InterfaceC11732l {

    /* JADX INFO: renamed from: j */
    public static final InterfaceC11732l f24147j = new C11731k().getUnmodifiableView();

    /* JADX INFO: renamed from: k */
    public final List<Object> f24148k;

    public C11731k() {
        this.f24148k = new ArrayList();
    }

    /* JADX INFO: renamed from: c */
    public static String m9856c(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof AbstractC11723c ? ((AbstractC11723c) obj).toStringUtf8() : C11728h.toStringUtf8((byte[]) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f24148k.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11732l
    public AbstractC11723c getByteString(int i) {
        AbstractC11723c abstractC11723cCopyFromUtf8;
        Object obj = this.f24148k.get(i);
        if (obj instanceof AbstractC11723c) {
            abstractC11723cCopyFromUtf8 = (AbstractC11723c) obj;
        } else {
            abstractC11723cCopyFromUtf8 = obj instanceof String ? AbstractC11723c.copyFromUtf8((String) obj) : AbstractC11723c.copyFrom((byte[]) obj);
        }
        if (abstractC11723cCopyFromUtf8 != obj) {
            this.f24148k.set(i, abstractC11723cCopyFromUtf8);
        }
        return abstractC11723cCopyFromUtf8;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11732l
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.f24148k);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11732l
    public InterfaceC11732l getUnmodifiableView() {
        return new C11741u(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f24148k.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, String str) {
        this.f24148k.add(i, str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends String> collection) {
        if (collection instanceof InterfaceC11732l) {
            collection = ((InterfaceC11732l) collection).getUnderlyingElements();
        }
        boolean zAddAll = this.f24148k.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        Object obj = this.f24148k.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC11723c) {
            AbstractC11723c abstractC11723c = (AbstractC11723c) obj;
            String stringUtf8 = abstractC11723c.toStringUtf8();
            if (abstractC11723c.isValidUtf8()) {
                this.f24148k.set(i, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String stringUtf9 = C11728h.toStringUtf8(bArr);
        if (C11728h.isValidUtf8(bArr)) {
            this.f24148k.set(i, stringUtf9);
        }
        return stringUtf9;
    }

    @Override // java.util.AbstractList, java.util.List
    public String remove(int i) {
        Object objRemove = this.f24148k.remove(i);
        ((AbstractList) this).modCount++;
        return m9856c(objRemove);
    }

    @Override // java.util.AbstractList, java.util.List
    public String set(int i, String str) {
        return m9856c(this.f24148k.set(i, str));
    }

    public C11731k(InterfaceC11732l interfaceC11732l) {
        this.f24148k = new ArrayList(interfaceC11732l.size());
        addAll(interfaceC11732l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11732l
    public void add(AbstractC11723c abstractC11723c) {
        this.f24148k.add(abstractC11723c);
        ((AbstractList) this).modCount++;
    }
}
