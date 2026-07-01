package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.v0;
import d0.e0.p.d.m0.n.w0;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z {
    public static final String a(u0 u0Var) {
        StringBuilder sb = new StringBuilder();
        b(d0.z.d.m.stringPlus("type: ", u0Var), sb);
        b(d0.z.d.m.stringPlus("hashCode: ", Integer.valueOf(u0Var.hashCode())), sb);
        b(d0.z.d.m.stringPlus("javaClass: ", u0Var.getClass().getCanonicalName()), sb);
        for (d0.e0.p.d.m0.c.m declarationDescriptor = u0Var.getDeclarationDescriptor(); declarationDescriptor != null; declarationDescriptor = declarationDescriptor.getContainingDeclaration()) {
            b(d0.z.d.m.stringPlus("fqName: ", d0.e0.p.d.m0.j.c.f3439b.render(declarationDescriptor)), sb);
            b(d0.z.d.m.stringPlus("javaClass: ", declarationDescriptor.getClass().getCanonicalName()), sb);
        }
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final StringBuilder b(String str, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(str, "<this>");
        d0.z.d.m.checkNotNullParameter(sb, "$this_anonymous");
        sb.append(str);
        d0.z.d.m.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        d0.z.d.m.checkNotNullExpressionValue(sb, "append('\\n')");
        return sb;
    }

    public static final c0 findCorrespondingSupertype(c0 c0Var, c0 c0Var2, u uVar) {
        boolean z2;
        j1 j1Var = j1.INVARIANT;
        d0.z.d.m.checkNotNullParameter(c0Var, "subtype");
        d0.z.d.m.checkNotNullParameter(c0Var2, "supertype");
        d0.z.d.m.checkNotNullParameter(uVar, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new r(c0Var, null));
        u0 constructor = c0Var2.getConstructor();
        while (!arrayDeque.isEmpty()) {
            r rVar = (r) arrayDeque.poll();
            c0 type = rVar.getType();
            u0 constructor2 = type.getConstructor();
            s sVar = (s) uVar;
            if (sVar.assertEqualTypeConstructors(constructor2, constructor)) {
                boolean zIsMarkedNullable = type.isMarkedNullable();
                for (r previous = rVar.getPrevious(); previous != null; previous = previous.getPrevious()) {
                    c0 type2 = previous.getType();
                    List<w0> arguments = type2.getArguments();
                    if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                        Iterator<T> it = arguments.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            if (((w0) it.next()).getProjectionKind() != j1Var) {
                                z2 = true;
                                break;
                            }
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                    if (z2) {
                        c0 c0VarSafeSubstitute = d0.e0.p.d.m0.k.u.a.d.wrapWithCapturingSubstitution$default(v0.f3542b.create(type2), false, 1, null).buildSubstitutor().safeSubstitute(type, j1Var);
                        d0.z.d.m.checkNotNullExpressionValue(c0VarSafeSubstitute, "TypeConstructorSubstitution.create(currentType)\n                            .wrapWithCapturingSubstitution().buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)");
                        type = d0.e0.p.d.m0.n.p1.b.approximateCapturedTypes(c0VarSafeSubstitute).getUpper();
                    } else {
                        type = v0.f3542b.create(type2).buildSubstitutor().safeSubstitute(type, j1Var);
                        d0.z.d.m.checkNotNullExpressionValue(type, "{\n                    TypeConstructorSubstitution.create(currentType)\n                            .buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)\n                }");
                    }
                    zIsMarkedNullable = zIsMarkedNullable || type2.isMarkedNullable();
                }
                u0 constructor3 = type.getConstructor();
                if (sVar.assertEqualTypeConstructors(constructor3, constructor)) {
                    return e1.makeNullableAsSpecified(type, zIsMarkedNullable);
                }
                StringBuilder sbU = b.d.b.a.a.U("Type constructors should be equals!\nsubstitutedSuperType: ");
                sbU.append(a(constructor3));
                sbU.append(", \n\nsupertype: ");
                sbU.append(a(constructor));
                sbU.append(" \n");
                sbU.append(sVar.assertEqualTypeConstructors(constructor3, constructor));
                throw new AssertionError(sbU.toString());
            }
            for (c0 c0Var3 : constructor2.getSupertypes()) {
                d0.z.d.m.checkNotNullExpressionValue(c0Var3, "immediateSupertype");
                arrayDeque.add(new r(c0Var3, rVar));
            }
        }
        return null;
    }
}
