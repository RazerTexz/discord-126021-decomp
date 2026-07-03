package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12141k;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.m */
/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11607m extends AbstractC12240o implements Function1<Integer, C11599e> {
    public final /* synthetic */ C11599e[] $computedResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11607m(C11599e[] c11599eArr) {
        super(1);
        this.$computedResult = c11599eArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ C11599e invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final C11599e invoke(int i) {
        C11599e[] c11599eArr = this.$computedResult;
        return (i < 0 || i > C12141k.getLastIndex(c11599eArr)) ? C11599e.f23450a.getNONE() : c11599eArr[i];
    }
}
