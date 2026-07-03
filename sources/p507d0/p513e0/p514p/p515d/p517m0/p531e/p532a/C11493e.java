package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import kotlin.jvm.functions.Function2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11818j;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.e */
/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11493e extends AbstractC12240o implements Function2<C11818j, EnumC11485a, Boolean> {
    public final /* synthetic */ C11489c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11493e(C11489c c11489c) {
        super(2);
        this.this$0 = c11489c;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(C11818j c11818j, EnumC11485a enumC11485a) {
        return Boolean.valueOf(invoke2(c11818j, enumC11485a));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(C11818j c11818j, EnumC11485a enumC11485a) {
        C12238m.checkNotNullParameter(c11818j, "<this>");
        C12238m.checkNotNullParameter(enumC11485a, "it");
        return C11489c.access$toKotlinTargetNames(this.this$0, enumC11485a.getJavaTarget()).contains(c11818j.getEnumEntryName().getIdentifier());
    }
}
