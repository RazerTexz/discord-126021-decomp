package d0.e0.p.d.m0.e.a.l0;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l$b$b extends d0.z.d.o implements Function1<Integer, e> {
    public final /* synthetic */ w $predefined;
    public final /* synthetic */ Function1<Integer, e> $qualifiers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public l$b$b(w wVar, Function1<? super Integer, e> function1) {
        super(1);
        this.$predefined = wVar;
        this.$qualifiers = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ e invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final e invoke(int i) {
        e eVar = this.$predefined.getMap().get(Integer.valueOf(i));
        return eVar == null ? this.$qualifiers.invoke(Integer.valueOf(i)) : eVar;
    }
}
