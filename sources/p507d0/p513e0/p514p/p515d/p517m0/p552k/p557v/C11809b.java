package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.b */
/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11809b extends AbstractC11815g<List<? extends AbstractC11815g<?>>> {

    /* JADX INFO: renamed from: b */
    public final Function1<InterfaceC11325c0, AbstractC11913c0> f24435b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C11809b(List<? extends AbstractC11815g<?>> list, Function1<? super InterfaceC11325c0, ? extends AbstractC11913c0> function1) {
        super(list);
        C12238m.checkNotNullParameter(list, "value");
        C12238m.checkNotNullParameter(function1, "computeType");
        this.f24435b = function1;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public AbstractC11913c0 getType(InterfaceC11325c0 interfaceC11325c0) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        AbstractC11913c0 abstractC11913c0Invoke = this.f24435b.invoke(interfaceC11325c0);
        if (!AbstractC11288h.isArray(abstractC11913c0Invoke) && !AbstractC11288h.isPrimitiveArray(abstractC11913c0Invoke)) {
            AbstractC11288h.isUnsignedArrayType(abstractC11913c0Invoke);
        }
        return abstractC11913c0Invoke;
    }
}
