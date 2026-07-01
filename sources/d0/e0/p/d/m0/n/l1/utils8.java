package d0.e0.p.d.m0.n.l1;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.j.DescriptorRenderer2;
import d0.e0.p.d.m0.k.u.a.CapturedTypeConstructor4;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.TypeSubstitution3;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.p1.CapturedTypeApproximation2;
import d0.z.d.Intrinsics3;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.z, reason: use source file name */
/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class utils8 {
    public static final String a(TypeConstructor typeConstructor) {
        StringBuilder sb = new StringBuilder();
        b(Intrinsics3.stringPlus("type: ", typeConstructor), sb);
        b(Intrinsics3.stringPlus("hashCode: ", Integer.valueOf(typeConstructor.hashCode())), sb);
        b(Intrinsics3.stringPlus("javaClass: ", typeConstructor.getClass().getCanonicalName()), sb);
        for (DeclarationDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor(); declarationDescriptor != null; declarationDescriptor = declarationDescriptor.getContainingDeclaration()) {
            b(Intrinsics3.stringPlus("fqName: ", DescriptorRenderer2.f3439b.render(declarationDescriptor)), sb);
            b(Intrinsics3.stringPlus("javaClass: ", declarationDescriptor.getClass().getCanonicalName()), sb);
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final StringBuilder b(String str, StringBuilder sb) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
        Intrinsics3.checkNotNullParameter(sb, "$this_anonymous");
        sb.append(str);
        Intrinsics3.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics3.checkNotNullExpressionValue(sb, "append('\\n')");
        return sb;
    }

    public static final KotlinType findCorrespondingSupertype(KotlinType kotlinType, KotlinType kotlinType2, TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        boolean z2;
        Variance variance = Variance.INVARIANT;
        Intrinsics3.checkNotNullParameter(kotlinType, "subtype");
        Intrinsics3.checkNotNullParameter(kotlinType2, "supertype");
        Intrinsics3.checkNotNullParameter(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new utils7(kotlinType, null));
        TypeConstructor constructor = kotlinType2.getConstructor();
        while (!arrayDeque.isEmpty()) {
            utils7 utils7Var = (utils7) arrayDeque.poll();
            KotlinType type = utils7Var.getType();
            TypeConstructor constructor2 = type.getConstructor();
            TypeCheckerProcedureCallbacksImpl typeCheckerProcedureCallbacksImpl = (TypeCheckerProcedureCallbacksImpl) typeCheckingProcedureCallbacks;
            if (typeCheckerProcedureCallbacksImpl.assertEqualTypeConstructors(constructor2, constructor)) {
                boolean zIsMarkedNullable = type.isMarkedNullable();
                for (utils7 previous = utils7Var.getPrevious(); previous != null; previous = previous.getPrevious()) {
                    KotlinType type2 = previous.getType();
                    List<TypeProjection> arguments = type2.getArguments();
                    if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                        Iterator<T> it = arguments.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            if (((TypeProjection) it.next()).getProjectionKind() != variance) {
                                z2 = true;
                                break;
                            }
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                    if (z2) {
                        KotlinType kotlinTypeSafeSubstitute = CapturedTypeConstructor4.wrapWithCapturingSubstitution$default(TypeSubstitution3.f3542b.create(type2), false, 1, null).buildSubstitutor().safeSubstitute(type, variance);
                        Intrinsics3.checkNotNullExpressionValue(kotlinTypeSafeSubstitute, "TypeConstructorSubstitution.create(currentType)\n                            .wrapWithCapturingSubstitution().buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)");
                        type = CapturedTypeApproximation2.approximateCapturedTypes(kotlinTypeSafeSubstitute).getUpper();
                    } else {
                        type = TypeSubstitution3.f3542b.create(type2).buildSubstitutor().safeSubstitute(type, variance);
                        Intrinsics3.checkNotNullExpressionValue(type, "{\n                    TypeConstructorSubstitution.create(currentType)\n                            .buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)\n                }");
                    }
                    zIsMarkedNullable = zIsMarkedNullable || type2.isMarkedNullable();
                }
                TypeConstructor constructor3 = type.getConstructor();
                if (typeCheckerProcedureCallbacksImpl.assertEqualTypeConstructors(constructor3, constructor)) {
                    return TypeUtils.makeNullableAsSpecified(type, zIsMarkedNullable);
                }
                StringBuilder sbU = outline.U("Type constructors should be equals!\nsubstitutedSuperType: ");
                sbU.append(a(constructor3));
                sbU.append(", \n\nsupertype: ");
                sbU.append(a(constructor));
                sbU.append(" \n");
                sbU.append(typeCheckerProcedureCallbacksImpl.assertEqualTypeConstructors(constructor3, constructor));
                throw new AssertionError(sbU.toString());
            }
            for (KotlinType kotlinType3 : constructor2.getSupertypes()) {
                Intrinsics3.checkNotNullExpressionValue(kotlinType3, "immediateSupertype");
                arrayDeque.add(new utils7(kotlinType3, utils7Var));
            }
        }
        return null;
    }
}
