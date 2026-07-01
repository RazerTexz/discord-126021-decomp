package b.c.a.a0;

import b.c.a.a0.i0.c$a;
import b.c.a.a0.i0.c$b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: KeyframesParser.java */
/* JADX INFO: loaded from: classes.dex */
public class r {
    public static c$a a = c$a.a("k");

    public static <T> List<b.c.a.c0.a<T>> a(b.c.a.a0.i0.c cVar, b.c.a.d dVar, float f, h0<T> h0Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (cVar.u() == c$b.STRING) {
            dVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        cVar.b();
        while (cVar.e()) {
            if (cVar.y(a) != 0) {
                cVar.C();
            } else if (cVar.u() == c$b.BEGIN_ARRAY) {
                cVar.a();
                if (cVar.u() == c$b.NUMBER) {
                    arrayList.add(q.a(cVar, dVar, f, h0Var, false));
                } else {
                    while (cVar.e()) {
                        arrayList.add(q.a(cVar, dVar, f, h0Var, true));
                    }
                }
                cVar.c();
            } else {
                arrayList.add(q.a(cVar, dVar, f, h0Var, false));
            }
        }
        cVar.d();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends b.c.a.c0.a<T>> list) {
        int i;
        T t;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            b.c.a.c0.a<T> aVar = list.get(i2);
            i2++;
            b.c.a.c0.a<T> aVar2 = list.get(i2);
            aVar.f = Float.valueOf(aVar2.e);
            if (aVar.c == null && (t = aVar2.f347b) != null) {
                aVar.c = t;
                if (aVar instanceof b.c.a.w.c.h) {
                    ((b.c.a.w.c.h) aVar).e();
                }
            }
        }
        b.c.a.c0.a<T> aVar3 = list.get(i);
        if ((aVar3.f347b == null || aVar3.c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
