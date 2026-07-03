package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.C12116o;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.EnumC11350m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.EnumC11351n;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11566b;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11580m;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11809b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11818j;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12160r;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.d */
/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11501d {

    /* JADX INFO: renamed from: a */
    public static final C11501d f23236a = new C11501d();

    /* JADX INFO: renamed from: b */
    public static final Map<String, EnumSet<EnumC11351n>> f23237b = C12136h0.mapOf(C12116o.m10073to("PACKAGE", EnumSet.noneOf(EnumC11351n.class)), C12116o.m10073to("TYPE", EnumSet.of(EnumC11351n.CLASS, EnumC11351n.FILE)), C12116o.m10073to("ANNOTATION_TYPE", EnumSet.of(EnumC11351n.ANNOTATION_CLASS)), C12116o.m10073to("TYPE_PARAMETER", EnumSet.of(EnumC11351n.TYPE_PARAMETER)), C12116o.m10073to("FIELD", EnumSet.of(EnumC11351n.FIELD)), C12116o.m10073to("LOCAL_VARIABLE", EnumSet.of(EnumC11351n.LOCAL_VARIABLE)), C12116o.m10073to("PARAMETER", EnumSet.of(EnumC11351n.VALUE_PARAMETER)), C12116o.m10073to("CONSTRUCTOR", EnumSet.of(EnumC11351n.CONSTRUCTOR)), C12116o.m10073to("METHOD", EnumSet.of(EnumC11351n.FUNCTION, EnumC11351n.PROPERTY_GETTER, EnumC11351n.PROPERTY_SETTER)), C12116o.m10073to("TYPE_USE", EnumSet.of(EnumC11351n.TYPE)));

    /* JADX INFO: renamed from: c */
    public static final Map<String, EnumC11350m> f23238c = C12136h0.mapOf(C12116o.m10073to("RUNTIME", EnumC11350m.RUNTIME), C12116o.m10073to("CLASS", EnumC11350m.BINARY), C12116o.m10073to("SOURCE", EnumC11350m.SOURCE));

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.d$a */
    /* JADX INFO: compiled from: JavaAnnotationMapper.kt */
    public static final class a extends AbstractC12240o implements Function1<InterfaceC11325c0, AbstractC11913c0> {

        /* JADX INFO: renamed from: j */
        public static final a f23239j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final AbstractC11913c0 invoke(InterfaceC11325c0 interfaceC11325c0) {
            C12238m.checkNotNullParameter(interfaceC11325c0, "module");
            InterfaceC11326c1 annotationParameterByName = C11498a.getAnnotationParameterByName(C11500c.f23230a.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), interfaceC11325c0.getBuiltIns().getBuiltInClassByFqName(C11291k.a.f22504A));
            AbstractC11913c0 type = annotationParameterByName == null ? null : annotationParameterByName.getType();
            if (type != null) {
                return type;
            }
            AbstractC11934j0 abstractC11934j0CreateErrorType = C12005t.createErrorType("Error: AnnotationTarget[]");
            C12238m.checkNotNullExpressionValue(abstractC11934j0CreateErrorType, "createErrorType(\"Error: AnnotationTarget[]\")");
            return abstractC11934j0CreateErrorType;
        }
    }

    public final AbstractC11815g<?> mapJavaRetentionArgument$descriptors_jvm(InterfaceC11566b interfaceC11566b) {
        InterfaceC11580m interfaceC11580m = interfaceC11566b instanceof InterfaceC11580m ? (InterfaceC11580m) interfaceC11566b : null;
        if (interfaceC11580m == null) {
            return null;
        }
        Map<String, EnumC11350m> map = f23238c;
        C11716e entryName = interfaceC11580m.getEntryName();
        EnumC11350m enumC11350m = map.get(entryName == null ? null : entryName.asString());
        if (enumC11350m == null) {
            return null;
        }
        C11712a c11712a = C11712a.topLevel(C11291k.a.f22506C);
        C12238m.checkNotNullExpressionValue(c11712a, "topLevel(StandardNames.FqNames.annotationRetention)");
        C11716e c11716eIdentifier = C11716e.identifier(enumC11350m.name());
        C12238m.checkNotNullExpressionValue(c11716eIdentifier, "identifier(retention.name)");
        return new C11818j(c11712a, c11716eIdentifier);
    }

    public final Set<EnumC11351n> mapJavaTargetArgumentByName(String str) {
        EnumSet<EnumC11351n> enumSet = f23237b.get(str);
        return enumSet == null ? C12148n0.emptySet() : enumSet;
    }

    public final AbstractC11815g<?> mapJavaTargetArguments$descriptors_jvm(List<? extends InterfaceC11566b> list) {
        C12238m.checkNotNullParameter(list, "arguments");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof InterfaceC11580m) {
                arrayList.add(obj);
            }
        }
        ArrayList<EnumC11351n> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C11716e entryName = ((InterfaceC11580m) it.next()).getEntryName();
            C12160r.addAll(arrayList2, mapJavaTargetArgumentByName(entryName == null ? null : entryName.asString()));
        }
        ArrayList arrayList3 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList2, 10));
        for (EnumC11351n enumC11351n : arrayList2) {
            C11712a c11712a = C11712a.topLevel(C11291k.a.f22505B);
            C12238m.checkNotNullExpressionValue(c11712a, "topLevel(StandardNames.FqNames.annotationTarget)");
            C11716e c11716eIdentifier = C11716e.identifier(enumC11351n.name());
            C12238m.checkNotNullExpressionValue(c11716eIdentifier, "identifier(kotlinTarget.name)");
            arrayList3.add(new C11818j(c11712a, c11716eIdentifier));
        }
        return new C11809b(arrayList3, a.f23239j);
    }
}
