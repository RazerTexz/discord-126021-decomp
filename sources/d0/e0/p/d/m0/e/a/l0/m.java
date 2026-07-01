package d0.e0.p.d.m0.e.a.l0;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends d0.z.d.o implements Function1<Integer, e> {
    public final /* synthetic */ e[] $computedResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(e[] eVarArr) {
        super(1);
        this.$computedResult = eVarArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ e invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final e invoke(int i) {
        e[] eVarArr = this.$computedResult;
        return (i < 0 || i > d0.t.k.getLastIndex(eVarArr)) ? e.a.getNONE() : eVarArr[i];
    }
}
