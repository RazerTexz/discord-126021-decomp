package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.f.h.l.o5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3774o5 extends AbstractC3748m5 {

    /* JADX INFO: renamed from: c */
    public static final Class<?> f10177c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public C3774o5(C3735l5 c3735l5) {
        super(null);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3748m5
    /* JADX INFO: renamed from: a */
    public final <E> void mo5070a(Object obj, Object obj2, long j) {
        List list;
        List list2;
        List listMo4569f;
        List list3 = (List) C3711j7.m4993r(obj2, j);
        int size = list3.size();
        List list4 = (List) C3711j7.m4993r(obj, j);
        if (list4.isEmpty()) {
            if (list4 instanceof InterfaceC3709j5) {
                listMo4569f = new C3722k5(size);
            } else {
                listMo4569f = ((list4 instanceof InterfaceC3736l6) && (list4 instanceof InterfaceC3597b5)) ? ((InterfaceC3597b5) list4).mo4569f(size) : new ArrayList(size);
            }
            C3711j7.m4981f(obj, j, listMo4569f);
            list2 = listMo4569f;
        } else {
            if (f10177c.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                C3711j7.m4981f(obj, j, arrayList);
                list = arrayList;
            } else if (list4 instanceof C3641e7) {
                C3722k5 c3722k5 = new C3722k5(list4.size() + size);
                c3722k5.addAll(c3722k5.size(), (C3641e7) list4);
                C3711j7.m4981f(obj, j, c3722k5);
                list = c3722k5;
            } else if ((list4 instanceof InterfaceC3736l6) && (list4 instanceof InterfaceC3597b5)) {
                InterfaceC3597b5 interfaceC3597b5 = (InterfaceC3597b5) list4;
                if (!interfaceC3597b5.mo4568a()) {
                    list2 = list4;
                    list2 = list4;
                    list2 = list4;
                    InterfaceC3597b5<E> interfaceC3597b5Mo4569f = interfaceC3597b5.mo4569f(list4.size() + size);
                    C3711j7.m4981f(obj, j, interfaceC3597b5Mo4569f);
                    list2 = interfaceC3597b5Mo4569f;
                }
            }
            list2 = list;
        }
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        int size2 = list2.size();
        int size3 = list3.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list3);
        }
        if (size2 > 0) {
            list3 = list2;
        }
        C3711j7.m4981f(obj, j, list3);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3748m5
    /* JADX INFO: renamed from: b */
    public final void mo5071b(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) C3711j7.m4993r(obj, j);
        if (list instanceof InterfaceC3709j5) {
            objUnmodifiableList = ((InterfaceC3709j5) list).mo4865s();
        } else {
            if (f10177c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof InterfaceC3736l6) && (list instanceof InterfaceC3597b5)) {
                InterfaceC3597b5 interfaceC3597b5 = (InterfaceC3597b5) list;
                if (interfaceC3597b5.mo4568a()) {
                    interfaceC3597b5.mo4570g0();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        C3711j7.m4981f(obj, j, objUnmodifiableList);
    }
}
