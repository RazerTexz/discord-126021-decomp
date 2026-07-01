package d0.e0.p.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KFunction;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: KClassImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a$e<T> extends d0.z.d.o implements Function0<List<? extends KFunction<? extends T>>> {
    public final /* synthetic */ h$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$a$e(h$a h_a) {
        super(0);
        this.this$0 = h_a;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        return invoke();
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<KFunction<T>> invoke() {
        Collection<d0.e0.p.d.m0.c.l> constructorDescriptors = this.this$0.p.getConstructorDescriptors();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(constructorDescriptors, 10));
        Iterator<T> it = constructorDescriptors.iterator();
        while (it.hasNext()) {
            arrayList.add(new j(this.this$0.p, (d0.e0.p.d.m0.c.l) it.next()));
        }
        return arrayList;
    }
}
