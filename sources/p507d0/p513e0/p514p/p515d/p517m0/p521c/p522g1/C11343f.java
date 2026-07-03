package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import kotlin.jvm.functions.Function1;
import p507d0.C12116o;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11807a;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11809b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11818j;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11831w;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.f */
/* JADX INFO: compiled from: annotationUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11343f {

    /* JADX INFO: renamed from: a */
    public static final C11716e f22730a;

    /* JADX INFO: renamed from: b */
    public static final C11716e f22731b;

    /* JADX INFO: renamed from: c */
    public static final C11716e f22732c;

    /* JADX INFO: renamed from: d */
    public static final C11716e f22733d;

    /* JADX INFO: renamed from: e */
    public static final C11716e f22734e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.f$a */
    /* JADX INFO: compiled from: annotationUtil.kt */
    public static final class a extends AbstractC12240o implements Function1<InterfaceC11325c0, AbstractC11913c0> {
        public final /* synthetic */ AbstractC11288h $this_createDeprecatedAnnotation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractC11288h abstractC11288h) {
            super(1);
            this.$this_createDeprecatedAnnotation = abstractC11288h;
        }

        @Override // kotlin.jvm.functions.Function1
        public final AbstractC11913c0 invoke(InterfaceC11325c0 interfaceC11325c0) {
            C12238m.checkNotNullParameter(interfaceC11325c0, "module");
            AbstractC11934j0 arrayType = interfaceC11325c0.getBuiltIns().getArrayType(EnumC11935j1.INVARIANT, this.$this_createDeprecatedAnnotation.getStringType());
            C12238m.checkNotNullExpressionValue(arrayType, "module.builtIns.getArrayType(Variance.INVARIANT, stringType)");
            return arrayType;
        }
    }

    static {
        C11716e c11716eIdentifier = C11716e.identifier("message");
        C12238m.checkNotNullExpressionValue(c11716eIdentifier, "identifier(\"message\")");
        f22730a = c11716eIdentifier;
        C11716e c11716eIdentifier2 = C11716e.identifier("replaceWith");
        C12238m.checkNotNullExpressionValue(c11716eIdentifier2, "identifier(\"replaceWith\")");
        f22731b = c11716eIdentifier2;
        C11716e c11716eIdentifier3 = C11716e.identifier("level");
        C12238m.checkNotNullExpressionValue(c11716eIdentifier3, "identifier(\"level\")");
        f22732c = c11716eIdentifier3;
        C11716e c11716eIdentifier4 = C11716e.identifier("expression");
        C12238m.checkNotNullExpressionValue(c11716eIdentifier4, "identifier(\"expression\")");
        f22733d = c11716eIdentifier4;
        C11716e c11716eIdentifier5 = C11716e.identifier("imports");
        C12238m.checkNotNullExpressionValue(c11716eIdentifier5, "identifier(\"imports\")");
        f22734e = c11716eIdentifier5;
    }

    public static final InterfaceC11340c createDeprecatedAnnotation(AbstractC11288h abstractC11288h, String str, String str2, String str3) {
        C12238m.checkNotNullParameter(abstractC11288h, "<this>");
        C12238m.checkNotNullParameter(str, "message");
        C12238m.checkNotNullParameter(str2, "replaceWith");
        C12238m.checkNotNullParameter(str3, "level");
        C11347j c11347j = new C11347j(abstractC11288h, C11291k.a.f22568w, C12136h0.mapOf(C12116o.m10073to(f22733d, new C11831w(str2)), C12116o.m10073to(f22734e, new C11809b(C12147n.emptyList(), new a(abstractC11288h)))));
        C11713b c11713b = C11291k.a.f22566u;
        C11716e c11716e = f22732c;
        C11712a c11712a = C11712a.topLevel(C11291k.a.f22567v);
        C12238m.checkNotNullExpressionValue(c11712a, "topLevel(StandardNames.FqNames.deprecationLevel)");
        C11716e c11716eIdentifier = C11716e.identifier(str3);
        C12238m.checkNotNullExpressionValue(c11716eIdentifier, "identifier(level)");
        return new C11347j(abstractC11288h, c11713b, C12136h0.mapOf(C12116o.m10073to(f22730a, new C11831w(str)), C12116o.m10073to(f22731b, new C11807a(c11347j)), C12116o.m10073to(c11716e, new C11818j(c11712a, c11716eIdentifier))));
    }

    public static /* synthetic */ InterfaceC11340c createDeprecatedAnnotation$default(AbstractC11288h abstractC11288h, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "WARNING";
        }
        return createDeprecatedAnnotation(abstractC11288h, str, str2, str3);
    }
}
