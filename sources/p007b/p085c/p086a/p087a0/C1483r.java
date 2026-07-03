package p007b.p085c.p086a.p087a0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.C1505d;
import p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c;
import p007b.p085c.p086a.p090c0.C1501a;
import p007b.p085c.p086a.p091w.p093c.C1551h;

/* JADX INFO: renamed from: b.c.a.a0.r */
/* JADX INFO: compiled from: KeyframesParser.java */
/* JADX INFO: loaded from: classes.dex */
public class C1483r {

    /* JADX INFO: renamed from: a */
    public static AbstractC1473c.a f2279a = AbstractC1473c.a.m616a("k");

    /* JADX INFO: renamed from: a */
    public static <T> List<C1501a<T>> m632a(AbstractC1473c abstractC1473c, C1505d c1505d, float f, InterfaceC1469h0<T> interfaceC1469h0) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (abstractC1473c.mo613u() == AbstractC1473c.b.STRING) {
            c1505d.m669a("Lottie doesn't support expressions.");
            return arrayList;
        }
        abstractC1473c.mo604b();
        while (abstractC1473c.mo607e()) {
            if (abstractC1473c.mo615y(f2279a) != 0) {
                abstractC1473c.mo601C();
            } else if (abstractC1473c.mo613u() == AbstractC1473c.b.BEGIN_ARRAY) {
                abstractC1473c.mo603a();
                if (abstractC1473c.mo613u() == AbstractC1473c.b.NUMBER) {
                    arrayList.add(C1482q.m631a(abstractC1473c, c1505d, f, interfaceC1469h0, false));
                } else {
                    while (abstractC1473c.mo607e()) {
                        arrayList.add(C1482q.m631a(abstractC1473c, c1505d, f, interfaceC1469h0, true));
                    }
                }
                abstractC1473c.mo605c();
            } else {
                arrayList.add(C1482q.m631a(abstractC1473c, c1505d, f, interfaceC1469h0, false));
            }
        }
        abstractC1473c.mo606d();
        m633b(arrayList);
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    public static <T> void m633b(List<? extends C1501a<T>> list) {
        int i;
        T t;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            C1501a<T> c1501a = list.get(i2);
            i2++;
            C1501a<T> c1501a2 = list.get(i2);
            c1501a.f2321f = Float.valueOf(c1501a2.f2320e);
            if (c1501a.f2318c == null && (t = c1501a2.f2317b) != null) {
                c1501a.f2318c = t;
                if (c1501a instanceof C1551h) {
                    ((C1551h) c1501a).m742e();
                }
            }
        }
        C1501a<T> c1501a3 = list.get(i);
        if ((c1501a3.f2317b == null || c1501a3.f2318c == null) && list.size() > 1) {
            list.remove(c1501a3);
        }
    }
}
