package b.i.a.f.h.l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o5 extends m5 {
    public static final Class<?> c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public o5(l5 l5Var) {
        super(null);
    }

    @Override // b.i.a.f.h.l.m5
    public final <E> void a(Object obj, Object obj2, long j) {
        List list;
        List list2;
        List listF;
        List list3 = (List) j7.r(obj2, j);
        int size = list3.size();
        List list4 = (List) j7.r(obj, j);
        if (list4.isEmpty()) {
            if (list4 instanceof j5) {
                listF = new k5(size);
            } else {
                listF = ((list4 instanceof l6) && (list4 instanceof b5)) ? ((b5) list4).f(size) : new ArrayList(size);
            }
            j7.f(obj, j, listF);
            list2 = listF;
        } else {
            if (c.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                j7.f(obj, j, arrayList);
                list = arrayList;
            } else if (list4 instanceof e7) {
                k5 k5Var = new k5(list4.size() + size);
                k5Var.addAll(k5Var.size(), (e7) list4);
                j7.f(obj, j, k5Var);
                list = k5Var;
            } else if ((list4 instanceof l6) && (list4 instanceof b5)) {
                b5 b5Var = (b5) list4;
                if (!b5Var.a()) {
                    list2 = list4;
                    list2 = list4;
                    list2 = list4;
                    b5<E> b5VarF = b5Var.f(list4.size() + size);
                    j7.f(obj, j, b5VarF);
                    list2 = b5VarF;
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
        j7.f(obj, j, list3);
    }

    @Override // b.i.a.f.h.l.m5
    public final void b(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) j7.r(obj, j);
        if (list instanceof j5) {
            objUnmodifiableList = ((j5) list).s();
        } else {
            if (c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof l6) && (list instanceof b5)) {
                b5 b5Var = (b5) list;
                if (b5Var.a()) {
                    b5Var.g0();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        j7.f(obj, j, objUnmodifiableList);
    }
}
