package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p564d0;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11677b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11679d;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11682g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11687l;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11696u;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p546y.C11701b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11725e;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.C11843a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d0.a */
/* JADX INFO: compiled from: BuiltInSerializerProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11851a extends C11843a {

    /* JADX INFO: renamed from: m */
    public static final C11851a f24515m = new C11851a();

    /* JADX WARN: Illegal instructions before constructor call */
    public C11851a() {
        C11725e c11725eNewInstance = C11725e.newInstance();
        C11701b.registerAllExtensions(c11725eNewInstance);
        C12238m.checkNotNullExpressionValue(c11725eNewInstance, "newInstance().apply(BuiltInsProtoBuf::registerAllExtensions)");
        AbstractC11727g.f<C11687l, Integer> fVar = C11701b.f24000a;
        C12238m.checkNotNullExpressionValue(fVar, "packageFqName");
        AbstractC11727g.f<C11679d, List<C11677b>> fVar2 = C11701b.f24002c;
        C12238m.checkNotNullExpressionValue(fVar2, "constructorAnnotation");
        AbstractC11727g.f<C11678c, List<C11677b>> fVar3 = C11701b.f24001b;
        C12238m.checkNotNullExpressionValue(fVar3, "classAnnotation");
        AbstractC11727g.f<C11684i, List<C11677b>> fVar4 = C11701b.f24003d;
        C12238m.checkNotNullExpressionValue(fVar4, "functionAnnotation");
        AbstractC11727g.f<C11689n, List<C11677b>> fVar5 = C11701b.f24004e;
        C12238m.checkNotNullExpressionValue(fVar5, "propertyAnnotation");
        AbstractC11727g.f<C11689n, List<C11677b>> fVar6 = C11701b.f24005f;
        C12238m.checkNotNullExpressionValue(fVar6, "propertyGetterAnnotation");
        AbstractC11727g.f<C11689n, List<C11677b>> fVar7 = C11701b.f24006g;
        C12238m.checkNotNullExpressionValue(fVar7, "propertySetterAnnotation");
        AbstractC11727g.f<C11682g, List<C11677b>> fVar8 = C11701b.f24008i;
        C12238m.checkNotNullExpressionValue(fVar8, "enumEntryAnnotation");
        AbstractC11727g.f<C11689n, C11677b.b.c> fVar9 = C11701b.f24007h;
        C12238m.checkNotNullExpressionValue(fVar9, "compileTimeValue");
        AbstractC11727g.f<C11696u, List<C11677b>> fVar10 = C11701b.f24009j;
        C12238m.checkNotNullExpressionValue(fVar10, "parameterAnnotation");
        AbstractC11727g.f<C11692q, List<C11677b>> fVar11 = C11701b.f24010k;
        C12238m.checkNotNullExpressionValue(fVar11, "typeAnnotation");
        AbstractC11727g.f<C11694s, List<C11677b>> fVar12 = C11701b.f24011l;
        C12238m.checkNotNullExpressionValue(fVar12, "typeParameterAnnotation");
        super(c11725eNewInstance, fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11, fVar12);
    }

    public final String getBuiltInsFileName(C11713b c11713b) {
        String strAsString;
        C12238m.checkNotNullParameter(c11713b, "fqName");
        if (c11713b.isRoot()) {
            strAsString = "default-package";
        } else {
            strAsString = c11713b.shortName().asString();
            C12238m.checkNotNullExpressionValue(strAsString, "fqName.shortName().asString()");
        }
        return C12238m.stringPlus(strAsString, ".kotlin_builtins");
    }

    public final String getBuiltInsFilePath(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        StringBuilder sb = new StringBuilder();
        String strAsString = c11713b.asString();
        C12238m.checkNotNullExpressionValue(strAsString, "fqName.asString()");
        sb.append(C12103t.replace$default(strAsString, '.', MentionUtilsKt.SLASH_CHAR, false, 4, (Object) null));
        sb.append(MentionUtilsKt.SLASH_CHAR);
        sb.append(getBuiltInsFileName(c11713b));
        return sb.toString();
    }
}
