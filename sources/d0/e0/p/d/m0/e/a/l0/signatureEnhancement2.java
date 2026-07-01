package d0.e0.p.d.m0.e.a.l0;

import d0.t._Arrays;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.m, reason: use source file name */
/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class signatureEnhancement2 extends Lambda implements Function1<Integer, typeQualifiers> {
    public final /* synthetic */ typeQualifiers[] $computedResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public signatureEnhancement2(typeQualifiers[] typequalifiersArr) {
        super(1);
        this.$computedResult = typequalifiersArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ typeQualifiers invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final typeQualifiers invoke(int i) {
        typeQualifiers[] typequalifiersArr = this.$computedResult;
        return (i < 0 || i > _Arrays.getLastIndex(typequalifiersArr)) ? typeQualifiers.a.getNONE() : typequalifiersArr[i];
    }
}
