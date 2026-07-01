package d0.e0.p.d.m0.n.n1;

import java.util.ArrayList;

/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends ArrayList<k> implements j {
    public a(int i) {
        super(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof k) {
            return contains((k) obj);
        }
        return false;
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof k) {
            return indexOf((k) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof k) {
            return lastIndexOf((k) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof k) {
            return remove((k) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public /* bridge */ boolean contains(k kVar) {
        return super.contains((Object) kVar);
    }

    public /* bridge */ int indexOf(k kVar) {
        return super.indexOf((Object) kVar);
    }

    public /* bridge */ int lastIndexOf(k kVar) {
        return super.lastIndexOf((Object) kVar);
    }

    public /* bridge */ boolean remove(k kVar) {
        return super.remove((Object) kVar);
    }
}
