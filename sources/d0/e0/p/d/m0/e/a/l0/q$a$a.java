package d0.e0.p.d.m0.e.a.l0;

import androidx.exifinterface.media.ExifInterface;
import d0.t.g0;
import d0.t.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q$a$a {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Pair<String, w>> f3352b;
    public Pair<String, w> c;
    public final /* synthetic */ q$a d;

    public q$a$a(q$a q_a, String str) {
        d0.z.d.m.checkNotNullParameter(q_a, "this$0");
        d0.z.d.m.checkNotNullParameter(str, "functionName");
        this.d = q_a;
        this.a = str;
        this.f3352b = new ArrayList();
        this.c = d0.o.to(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, null);
    }

    public final Pair<String, k> build() {
        d0.e0.p.d.m0.e.b.w wVar = d0.e0.p.d.m0.e.b.w.a;
        String className = this.d.getClassName();
        String functionName = getFunctionName();
        List<Pair<String, w>> list = this.f3352b;
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Pair) it.next()).getFirst());
        }
        String strSignature = wVar.signature(className, wVar.jvmDescriptor(functionName, arrayList, this.c.getFirst()));
        w second = this.c.getSecond();
        List<Pair<String, w>> list2 = this.f3352b;
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add((w) ((Pair) it2.next()).getSecond());
        }
        return d0.o.to(strSignature, new k(second, arrayList2));
    }

    public final String getFunctionName() {
        return this.a;
    }

    public final void parameter(String str, e... eVarArr) {
        w wVar;
        d0.z.d.m.checkNotNullParameter(str, "type");
        d0.z.d.m.checkNotNullParameter(eVarArr, "qualifiers");
        List<Pair<String, w>> list = this.f3352b;
        if (eVarArr.length == 0) {
            wVar = null;
        } else {
            Iterable<z> iterableWithIndex = d0.t.k.withIndex(eVarArr);
            LinkedHashMap linkedHashMap = new LinkedHashMap(d0.d0.f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(iterableWithIndex, 10)), 16));
            for (z zVar : iterableWithIndex) {
                linkedHashMap.put(Integer.valueOf(zVar.getIndex()), (e) zVar.getValue());
            }
            wVar = new w(linkedHashMap);
        }
        list.add(d0.o.to(str, wVar));
    }

    public final void returns(String str, e... eVarArr) {
        d0.z.d.m.checkNotNullParameter(str, "type");
        d0.z.d.m.checkNotNullParameter(eVarArr, "qualifiers");
        Iterable<z> iterableWithIndex = d0.t.k.withIndex(eVarArr);
        LinkedHashMap linkedHashMap = new LinkedHashMap(d0.d0.f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(iterableWithIndex, 10)), 16));
        for (z zVar : iterableWithIndex) {
            linkedHashMap.put(Integer.valueOf(zVar.getIndex()), (e) zVar.getValue());
        }
        this.c = d0.o.to(str, new w(linkedHashMap));
    }

    public final void returns(d0.e0.p.d.m0.k.y.d dVar) {
        d0.z.d.m.checkNotNullParameter(dVar, "type");
        String desc = dVar.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc, "type.desc");
        this.c = d0.o.to(desc, null);
    }
}
