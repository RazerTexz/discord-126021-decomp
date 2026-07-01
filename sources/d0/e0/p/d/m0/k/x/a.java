package d0.e0.p.d.m0.k.x;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.g1.c;
import d0.e0.p.d.m0.c.h;
import d0.e0.p.d.m0.c.i;
import d0.e0.p.d.m0.c.m0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.g.e;
import d0.e0.p.d.m0.k.v.g;
import d0.e0.p.d.m0.n.l1.g$a;
import d0.e0.p.d.m0.n.l1.o;
import d0.e0.p.d.m0.p.b;
import d0.f0.n;
import d0.f0.q;
import d0.t.u;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: DescriptorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    static {
        m.checkNotNullExpressionValue(e.identifier("value"), "identifier(\"value\")");
    }

    public static final boolean declaresOrInheritsDefaultValue(c1 c1Var) {
        m.checkNotNullParameter(c1Var, "<this>");
        Boolean boolIfAny = b.ifAny(d0.t.m.listOf(c1Var), a$a.a, a$b.j);
        m.checkNotNullExpressionValue(boolIfAny, "ifAny(\n        listOf(this),\n        { current -> current.overriddenDescriptors.map(ValueParameterDescriptor::getOriginal) },\n        ValueParameterDescriptor::declaresDefaultValue\n    )");
        return boolIfAny.booleanValue();
    }

    public static final g<?> firstArgument(c cVar) {
        m.checkNotNullParameter(cVar, "<this>");
        return (g) u.firstOrNull(cVar.getAllValueArguments().values());
    }

    public static final d0.e0.p.d.m0.c.b firstOverridden(d0.e0.p.d.m0.c.b bVar, boolean z2, Function1<? super d0.e0.p.d.m0.c.b, Boolean> function1) {
        m.checkNotNullParameter(bVar, "<this>");
        m.checkNotNullParameter(function1, "predicate");
        return (d0.e0.p.d.m0.c.b) b.dfs(d0.t.m.listOf(bVar), new a$c(z2), new a$d(new Ref$ObjectRef(), function1));
    }

    public static /* synthetic */ d0.e0.p.d.m0.c.b firstOverridden$default(d0.e0.p.d.m0.c.b bVar, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return firstOverridden(bVar, z2, function1);
    }

    public static final d0.e0.p.d.m0.g.b fqNameOrNull(d0.e0.p.d.m0.c.m mVar) {
        m.checkNotNullParameter(mVar, "<this>");
        d0.e0.p.d.m0.g.c fqNameUnsafe = getFqNameUnsafe(mVar);
        if (!fqNameUnsafe.isSafe()) {
            fqNameUnsafe = null;
        }
        if (fqNameUnsafe == null) {
            return null;
        }
        return fqNameUnsafe.toSafe();
    }

    public static final d0.e0.p.d.m0.c.e getAnnotationClass(c cVar) {
        m.checkNotNullParameter(cVar, "<this>");
        h declarationDescriptor = cVar.getType().getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof d0.e0.p.d.m0.c.e) {
            return (d0.e0.p.d.m0.c.e) declarationDescriptor;
        }
        return null;
    }

    public static final d0.e0.p.d.m0.b.h getBuiltIns(d0.e0.p.d.m0.c.m mVar) {
        m.checkNotNullParameter(mVar, "<this>");
        return getModule(mVar).getBuiltIns();
    }

    public static final d0.e0.p.d.m0.g.a getClassId(h hVar) {
        d0.e0.p.d.m0.c.m containingDeclaration;
        d0.e0.p.d.m0.g.a classId;
        if (hVar == null || (containingDeclaration = hVar.getContainingDeclaration()) == null) {
            return null;
        }
        if (containingDeclaration instanceof e0) {
            return new d0.e0.p.d.m0.g.a(((e0) containingDeclaration).getFqName(), hVar.getName());
        }
        if (!(containingDeclaration instanceof i) || (classId = getClassId((h) containingDeclaration)) == null) {
            return null;
        }
        return classId.createNestedClassId(hVar.getName());
    }

    public static final d0.e0.p.d.m0.g.b getFqNameSafe(d0.e0.p.d.m0.c.m mVar) {
        m.checkNotNullParameter(mVar, "<this>");
        d0.e0.p.d.m0.g.b fqNameSafe = d0.e0.p.d.m0.k.e.getFqNameSafe(mVar);
        m.checkNotNullExpressionValue(fqNameSafe, "getFqNameSafe(this)");
        return fqNameSafe;
    }

    public static final d0.e0.p.d.m0.g.c getFqNameUnsafe(d0.e0.p.d.m0.c.m mVar) {
        m.checkNotNullParameter(mVar, "<this>");
        d0.e0.p.d.m0.g.c fqName = d0.e0.p.d.m0.k.e.getFqName(mVar);
        m.checkNotNullExpressionValue(fqName, "getFqName(this)");
        return fqName;
    }

    public static final d0.e0.p.d.m0.n.l1.g getKotlinTypeRefiner(c0 c0Var) {
        m.checkNotNullParameter(c0Var, "<this>");
        o oVar = (o) c0Var.getCapability(d0.e0.p.d.m0.n.l1.h.getREFINER_CAPABILITY());
        d0.e0.p.d.m0.n.l1.g gVar = oVar == null ? null : (d0.e0.p.d.m0.n.l1.g) oVar.getValue();
        return gVar == null ? g$a.a : gVar;
    }

    public static final c0 getModule(d0.e0.p.d.m0.c.m mVar) {
        m.checkNotNullParameter(mVar, "<this>");
        c0 containingModule = d0.e0.p.d.m0.k.e.getContainingModule(mVar);
        m.checkNotNullExpressionValue(containingModule, "getContainingModule(this)");
        return containingModule;
    }

    public static final Sequence<d0.e0.p.d.m0.c.m> getParents(d0.e0.p.d.m0.c.m mVar) {
        m.checkNotNullParameter(mVar, "<this>");
        return q.drop(getParentsWithSelf(mVar), 1);
    }

    public static final Sequence<d0.e0.p.d.m0.c.m> getParentsWithSelf(d0.e0.p.d.m0.c.m mVar) {
        m.checkNotNullParameter(mVar, "<this>");
        return n.generateSequence(mVar, a$e.j);
    }

    public static final d0.e0.p.d.m0.c.b getPropertyIfAccessor(d0.e0.p.d.m0.c.b bVar) {
        m.checkNotNullParameter(bVar, "<this>");
        if (!(bVar instanceof m0)) {
            return bVar;
        }
        n0 correspondingProperty = ((m0) bVar).getCorrespondingProperty();
        m.checkNotNullExpressionValue(correspondingProperty, "correspondingProperty");
        return correspondingProperty;
    }

    public static final d0.e0.p.d.m0.c.e getSuperClassNotAny(d0.e0.p.d.m0.c.e eVar) {
        m.checkNotNullParameter(eVar, "<this>");
        for (d0.e0.p.d.m0.n.c0 c0Var : eVar.getDefaultType().getConstructor().getSupertypes()) {
            if (!d0.e0.p.d.m0.b.h.isAnyOrNullableAny(c0Var)) {
                h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
                if (d0.e0.p.d.m0.k.e.isClassOrEnumClass(declarationDescriptor)) {
                    Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (d0.e0.p.d.m0.c.e) declarationDescriptor;
                }
            }
        }
        return null;
    }

    public static final boolean isTypeRefinementEnabled(c0 c0Var) {
        m.checkNotNullParameter(c0Var, "<this>");
        o oVar = (o) c0Var.getCapability(d0.e0.p.d.m0.n.l1.h.getREFINER_CAPABILITY());
        return (oVar == null ? null : (d0.e0.p.d.m0.n.l1.g) oVar.getValue()) != null;
    }

    public static final d0.e0.p.d.m0.c.e resolveTopLevelClass(c0 c0Var, d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.d.b.b bVar2) {
        m.checkNotNullParameter(c0Var, "<this>");
        m.checkNotNullParameter(bVar, "topLevelClassFqName");
        m.checkNotNullParameter(bVar2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        bVar.isRoot();
        d0.e0.p.d.m0.g.b bVarParent = bVar.parent();
        m.checkNotNullExpressionValue(bVarParent, "topLevelClassFqName.parent()");
        d0.e0.p.d.m0.k.a0.i memberScope = c0Var.getPackage(bVarParent).getMemberScope();
        e eVarShortName = bVar.shortName();
        m.checkNotNullExpressionValue(eVarShortName, "topLevelClassFqName.shortName()");
        h contributedClassifier = memberScope.getContributedClassifier(eVarShortName, bVar2);
        if (contributedClassifier instanceof d0.e0.p.d.m0.c.e) {
            return (d0.e0.p.d.m0.c.e) contributedClassifier;
        }
        return null;
    }
}
