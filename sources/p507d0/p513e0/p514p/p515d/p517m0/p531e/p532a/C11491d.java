package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import kotlin.jvm.functions.Function2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11818j;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.d */
/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11491d extends AbstractC12240o implements Function2<C11818j, EnumC11485a, Boolean> {

    /* JADX INFO: renamed from: j */
    public static final C11491d f23191j = new C11491d();

    public C11491d() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(C11818j c11818j, EnumC11485a enumC11485a) {
        return Boolean.valueOf(invoke2(c11818j, enumC11485a));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(C11818j c11818j, EnumC11485a enumC11485a) {
        C12238m.checkNotNullParameter(c11818j, "<this>");
        C12238m.checkNotNullParameter(enumC11485a, "it");
        return C12238m.areEqual(c11818j.getEnumEntryName().getIdentifier(), enumC11485a.getJavaTarget());
    }
}
