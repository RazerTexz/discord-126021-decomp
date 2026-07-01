package d0.e0.p.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: KClassImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a$o<T> extends d0.z.d.o implements Function0<List<? extends h<? extends T>>> {
    public final /* synthetic */ h$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$a$o(h$a h_a) {
        super(0);
        this.this$0 = h_a;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        return invoke();
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<h<? extends T>> invoke() {
        Collection<d0.e0.p.d.m0.c.e> sealedSubclasses = this.this$0.getDescriptor().getSealedSubclasses();
        d0.z.d.m.checkNotNullExpressionValue(sealedSubclasses, "descriptor.sealedSubclasses");
        ArrayList arrayList = new ArrayList();
        for (d0.e0.p.d.m0.c.e eVar : sealedSubclasses) {
            Objects.requireNonNull(eVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> javaClass = j0.toJavaClass(eVar);
            h hVar = javaClass != null ? new h(javaClass) : null;
            if (hVar != null) {
                arrayList.add(hVar);
            }
        }
        return arrayList;
    }
}
