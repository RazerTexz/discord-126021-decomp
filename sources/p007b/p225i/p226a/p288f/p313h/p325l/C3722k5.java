package p007b.p225i.p226a.p288f.p313h.p325l;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: renamed from: b.i.a.f.h.l.k5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3722k5 extends AbstractC3772o3<String> implements InterfaceC3709j5, RandomAccess {

    /* JADX INFO: renamed from: k */
    public static final C3722k5 f10054k;

    /* JADX INFO: renamed from: l */
    public final List<Object> f10055l;

    static {
        C3722k5 c3722k5 = new C3722k5(10);
        f10054k = c3722k5;
        c3722k5.f10123j = false;
    }

    public C3722k5(int i) {
        this.f10055l = new ArrayList(i);
    }

    /* JADX INFO: renamed from: d */
    public static String m5020d(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof AbstractC3837t3)) {
            Charset charset = C3877w4.f10379a;
            return new String((byte[]) obj, C3877w4.f10379a);
        }
        AbstractC3837t3 abstractC3837t3 = (AbstractC3837t3) obj;
        Objects.requireNonNull(abstractC3837t3);
        return abstractC3837t3.mo5282d() == 0 ? "" : abstractC3837t3.mo5285i(C3877w4.f10379a);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3709j5
    /* JADX INFO: renamed from: A */
    public final Object mo4863A(int i) {
        return this.f10055l.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        m5153c();
        this.f10055l.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3709j5
    /* JADX INFO: renamed from: b */
    public final List<?> mo4864b() {
        return Collections.unmodifiableList(this.f10055l);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        m5153c();
        this.f10055l.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3597b5
    /* JADX INFO: renamed from: f */
    public final /* synthetic */ InterfaceC3597b5 mo4569f(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.f10055l);
        return new C3722k5((ArrayList<Object>) arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        Object obj = this.f10055l.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC3837t3) {
            AbstractC3837t3 abstractC3837t3 = (AbstractC3837t3) obj;
            Objects.requireNonNull(abstractC3837t3);
            String strMo5285i = abstractC3837t3.mo5282d() == 0 ? "" : abstractC3837t3.mo5285i(C3877w4.f10379a);
            if (abstractC3837t3.mo5288m()) {
                this.f10055l.set(i, strMo5285i);
            }
            return strMo5285i;
        }
        byte[] bArr = (byte[]) obj;
        Charset charset = C3877w4.f10379a;
        String str = new String(bArr, C3877w4.f10379a);
        if (C3724k7.f10058a.mo5055a(0, bArr, 0, bArr.length) == 0) {
            this.f10055l.set(i, str);
        }
        return str;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        m5153c();
        Object objRemove = this.f10055l.remove(i);
        ((AbstractList) this).modCount++;
        return m5020d(objRemove);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3709j5
    /* JADX INFO: renamed from: s */
    public final InterfaceC3709j5 mo4865s() {
        return this.f10123j ? new C3641e7(this) : this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        m5153c();
        return m5020d(this.f10055l.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f10055l.size();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3709j5
    /* JADX INFO: renamed from: t */
    public final void mo4866t(AbstractC3837t3 abstractC3837t3) {
        m5153c();
        this.f10055l.add(abstractC3837t3);
        ((AbstractList) this).modCount++;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        m5153c();
        if (collection instanceof InterfaceC3709j5) {
            collection = ((InterfaceC3709j5) collection).mo4864b();
        }
        boolean zAddAll = this.f10055l.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    public C3722k5(ArrayList<Object> arrayList) {
        this.f10055l = arrayList;
    }
}
