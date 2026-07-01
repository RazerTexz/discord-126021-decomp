package f0.e0.k;

import d0.t.o;
import d0.z.d.m;
import f0.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a {
    public h$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final List<String> a(List<? extends y> list) {
        m.checkParameterIsNotNull(list, "protocols");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((y) obj) != y.HTTP_1_0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((y) it.next()).toString());
        }
        return arrayList2;
    }

    public final byte[] b(List<? extends y> list) {
        m.checkParameterIsNotNull(list, "protocols");
        g0.e eVar = new g0.e();
        for (String str : (ArrayList) a(list)) {
            eVar.T(str.length());
            eVar.b0(str);
        }
        return eVar.Z(eVar.k);
    }

    public final boolean c() {
        return m.areEqual("Dalvik", System.getProperty("java.vm.name"));
    }
}
