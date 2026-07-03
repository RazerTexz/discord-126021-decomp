package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a.C11806d;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12010v0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p572p1.C11996b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.z */
/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11966z {
    /* JADX INFO: renamed from: a */
    public static final String m10017a(InterfaceC12008u0 interfaceC12008u0) {
        StringBuilder sb = new StringBuilder();
        m10018b(C12238m.stringPlus("type: ", interfaceC12008u0), sb);
        m10018b(C12238m.stringPlus("hashCode: ", Integer.valueOf(interfaceC12008u0.hashCode())), sb);
        m10018b(C12238m.stringPlus("javaClass: ", interfaceC12008u0.getClass().getCanonicalName()), sb);
        for (InterfaceC11450m declarationDescriptor = interfaceC12008u0.getDeclarationDescriptor(); declarationDescriptor != null; declarationDescriptor = declarationDescriptor.getContainingDeclaration()) {
            m10018b(C12238m.stringPlus("fqName: ", AbstractC11746c.f24226b.render(declarationDescriptor)), sb);
            m10018b(C12238m.stringPlus("javaClass: ", declarationDescriptor.getClass().getCanonicalName()), sb);
        }
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX INFO: renamed from: b */
    public static final StringBuilder m10018b(String str, StringBuilder sb) {
        C12238m.checkNotNullParameter(str, "<this>");
        C12238m.checkNotNullParameter(sb, "$this_anonymous");
        sb.append(str);
        C12238m.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        C12238m.checkNotNullExpressionValue(sb, "append('\\n')");
        return sb;
    }

    public static final AbstractC11913c0 findCorrespondingSupertype(AbstractC11913c0 abstractC11913c0, AbstractC11913c0 abstractC11913c1, InterfaceC11961u interfaceC11961u) {
        boolean z2;
        EnumC11935j1 enumC11935j1 = EnumC11935j1.INVARIANT;
        C12238m.checkNotNullParameter(abstractC11913c0, "subtype");
        C12238m.checkNotNullParameter(abstractC11913c1, "supertype");
        C12238m.checkNotNullParameter(interfaceC11961u, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new C11958r(abstractC11913c0, null));
        InterfaceC12008u0 constructor = abstractC11913c1.getConstructor();
        while (!arrayDeque.isEmpty()) {
            C11958r c11958r = (C11958r) arrayDeque.poll();
            AbstractC11913c0 type = c11958r.getType();
            InterfaceC12008u0 constructor2 = type.getConstructor();
            C11959s c11959s = (C11959s) interfaceC11961u;
            if (c11959s.assertEqualTypeConstructors(constructor2, constructor)) {
                boolean zIsMarkedNullable = type.isMarkedNullable();
                for (C11958r previous = c11958r.getPrevious(); previous != null; previous = previous.getPrevious()) {
                    AbstractC11913c0 type2 = previous.getType();
                    List<InterfaceC12012w0> arguments = type2.getArguments();
                    if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                        Iterator<T> it = arguments.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            if (((InterfaceC12012w0) it.next()).getProjectionKind() != enumC11935j1) {
                                z2 = true;
                                break;
                            }
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                    if (z2) {
                        AbstractC11913c0 abstractC11913c0SafeSubstitute = C11806d.wrapWithCapturingSubstitution$default(AbstractC12010v0.f24889b.create(type2), false, 1, null).buildSubstitutor().safeSubstitute(type, enumC11935j1);
                        C12238m.checkNotNullExpressionValue(abstractC11913c0SafeSubstitute, "TypeConstructorSubstitution.create(currentType)\n                            .wrapWithCapturingSubstitution().buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)");
                        type = C11996b.approximateCapturedTypes(abstractC11913c0SafeSubstitute).getUpper();
                    } else {
                        type = AbstractC12010v0.f24889b.create(type2).buildSubstitutor().safeSubstitute(type, enumC11935j1);
                        C12238m.checkNotNullExpressionValue(type, "{\n                    TypeConstructorSubstitution.create(currentType)\n                            .buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)\n                }");
                    }
                    zIsMarkedNullable = zIsMarkedNullable || type2.isMarkedNullable();
                }
                InterfaceC12008u0 constructor3 = type.getConstructor();
                if (c11959s.assertEqualTypeConstructors(constructor3, constructor)) {
                    return C11920e1.makeNullableAsSpecified(type, zIsMarkedNullable);
                }
                StringBuilder sbM833U = C1643a.m833U("Type constructors should be equals!\nsubstitutedSuperType: ");
                sbM833U.append(m10017a(constructor3));
                sbM833U.append(", \n\nsupertype: ");
                sbM833U.append(m10017a(constructor));
                sbM833U.append(" \n");
                sbM833U.append(c11959s.assertEqualTypeConstructors(constructor3, constructor));
                throw new AssertionError(sbM833U.toString());
            }
            for (AbstractC11913c0 abstractC11913c2 : constructor2.getSupertypes()) {
                C12238m.checkNotNullExpressionValue(abstractC11913c2, "immediateSupertype");
                arrayDeque.add(new C11958r(abstractC11913c2, c11958r));
            }
        }
        return null;
    }
}
