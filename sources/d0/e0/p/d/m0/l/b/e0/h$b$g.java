package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.c.t0;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DeserializedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$b$g extends o implements Function0<Map<d0.e0.p.d.m0.g.e, ? extends List<? extends t0>>> {
    public final /* synthetic */ h$b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$b$g(h$b h_b) {
        super(0);
        this.this$0 = h_b;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<d0.e0.p.d.m0.g.e, ? extends List<? extends t0>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<d0.e0.p.d.m0.g.e, ? extends List<? extends t0>> invoke2() {
        List listAccess$getAllFunctions = h$b.access$getAllFunctions(this.this$0);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : listAccess$getAllFunctions) {
            d0.e0.p.d.m0.g.e name = ((t0) obj).getName();
            d0.z.d.m.checkNotNullExpressionValue(name, "it.name");
            Object arrayList = linkedHashMap.get(name);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(name, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        return linkedHashMap;
    }
}
