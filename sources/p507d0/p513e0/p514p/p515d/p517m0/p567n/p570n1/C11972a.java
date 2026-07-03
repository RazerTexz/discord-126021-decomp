package p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1;

import java.util.ArrayList;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.n1.a */
/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11972a extends ArrayList<InterfaceC11982k> implements InterfaceC11981j {
    public C11972a(int i) {
        super(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof InterfaceC11982k) {
            return contains((InterfaceC11982k) obj);
        }
        return false;
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof InterfaceC11982k) {
            return indexOf((InterfaceC11982k) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof InterfaceC11982k) {
            return lastIndexOf((InterfaceC11982k) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof InterfaceC11982k) {
            return remove((InterfaceC11982k) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public /* bridge */ boolean contains(InterfaceC11982k interfaceC11982k) {
        return super.contains((Object) interfaceC11982k);
    }

    public /* bridge */ int indexOf(InterfaceC11982k interfaceC11982k) {
        return super.indexOf((Object) interfaceC11982k);
    }

    public /* bridge */ int lastIndexOf(InterfaceC11982k interfaceC11982k) {
        return super.lastIndexOf((Object) interfaceC11982k);
    }

    public /* bridge */ boolean remove(InterfaceC11982k interfaceC11982k) {
        return super.remove((Object) interfaceC11982k);
    }
}
