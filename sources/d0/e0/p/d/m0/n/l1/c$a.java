package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.b.k$a;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.d1$a;
import d0.e0.p.d.m0.n.e0;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.i1;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.n1.p$a;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.w0;
import d0.z.d.a0;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: ClassicTypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a {
    public static boolean areEqualTypeConstructors(c cVar, d0.e0.p.d.m0.n.n1.l lVar, d0.e0.p.d.m0.n.n1.l lVar2) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(lVar, "c1");
        d0.z.d.m.checkNotNullParameter(lVar2, "c2");
        if (!(lVar instanceof u0)) {
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + a0.getOrCreateKotlinClass(lVar.getClass())).toString());
        }
        if (lVar2 instanceof u0) {
            return d0.z.d.m.areEqual(lVar, lVar2);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar2 + ", " + a0.getOrCreateKotlinClass(lVar2.getClass())).toString());
    }

    public static int argumentsCount(c cVar, d0.e0.p.d.m0.n.n1.h hVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        if (hVar instanceof c0) {
            return ((c0) hVar).getArguments().size();
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + a0.getOrCreateKotlinClass(hVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.j asArgumentList(c cVar, d0.e0.p.d.m0.n.n1.i iVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(iVar, "receiver");
        if (iVar instanceof j0) {
            return (d0.e0.p.d.m0.n.n1.j) iVar;
        }
        StringBuilder sbZ = b.d.b.a.a.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
        sbZ.append(a0.getOrCreateKotlinClass(iVar.getClass()));
        throw new IllegalArgumentException(sbZ.toString().toString());
    }

    public static d0.e0.p.d.m0.n.n1.c asCapturedType(c cVar, d0.e0.p.d.m0.n.n1.i iVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(iVar, "receiver");
        if (iVar instanceof j0) {
            if (iVar instanceof i) {
                return (i) iVar;
            }
            return null;
        }
        StringBuilder sbZ = b.d.b.a.a.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
        sbZ.append(a0.getOrCreateKotlinClass(iVar.getClass()));
        throw new IllegalArgumentException(sbZ.toString().toString());
    }

    public static d0.e0.p.d.m0.n.n1.d asDefinitelyNotNullType(c cVar, d0.e0.p.d.m0.n.n1.i iVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(iVar, "receiver");
        if (iVar instanceof j0) {
            if (iVar instanceof d0.e0.p.d.m0.n.k) {
                return (d0.e0.p.d.m0.n.k) iVar;
            }
            return null;
        }
        StringBuilder sbZ = b.d.b.a.a.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
        sbZ.append(a0.getOrCreateKotlinClass(iVar.getClass()));
        throw new IllegalArgumentException(sbZ.toString().toString());
    }

    public static d0.e0.p.d.m0.n.n1.e asDynamicType(c cVar, d0.e0.p.d.m0.n.n1.f fVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(fVar, "receiver");
        if (fVar instanceof d0.e0.p.d.m0.n.v) {
            if (fVar instanceof d0.e0.p.d.m0.n.q) {
                return (d0.e0.p.d.m0.n.q) fVar;
            }
            return null;
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + fVar + ", " + a0.getOrCreateKotlinClass(fVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.f asFlexibleType(c cVar, d0.e0.p.d.m0.n.n1.h hVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        if (hVar instanceof c0) {
            i1 i1VarUnwrap = ((c0) hVar).unwrap();
            if (i1VarUnwrap instanceof d0.e0.p.d.m0.n.v) {
                return (d0.e0.p.d.m0.n.v) i1VarUnwrap;
            }
            return null;
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + a0.getOrCreateKotlinClass(hVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.i asSimpleType(c cVar, d0.e0.p.d.m0.n.n1.h hVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        if (hVar instanceof c0) {
            i1 i1VarUnwrap = ((c0) hVar).unwrap();
            if (i1VarUnwrap instanceof j0) {
                return (j0) i1VarUnwrap;
            }
            return null;
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + a0.getOrCreateKotlinClass(hVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.k asTypeArgument(c cVar, d0.e0.p.d.m0.n.n1.h hVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        if (hVar instanceof c0) {
            return d0.e0.p.d.m0.n.o1.a.asTypeProjection((c0) hVar);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + a0.getOrCreateKotlinClass(hVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.i captureFromArguments(c cVar, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.b bVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(iVar, "type");
        d0.z.d.m.checkNotNullParameter(bVar, "status");
        if (iVar instanceof j0) {
            return k.captureFromArguments((j0) iVar, bVar);
        }
        StringBuilder sbZ = b.d.b.a.a.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
        sbZ.append(a0.getOrCreateKotlinClass(iVar.getClass()));
        throw new IllegalArgumentException(sbZ.toString().toString());
    }

    public static d0.e0.p.d.m0.n.n1.h createFlexibleType(c cVar, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.i iVar2) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(iVar, "lowerBound");
        d0.z.d.m.checkNotNullParameter(iVar2, "upperBound");
        if (!(iVar instanceof j0)) {
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + cVar + ", " + a0.getOrCreateKotlinClass(cVar.getClass())).toString());
        }
        if (iVar2 instanceof j0) {
            d0 d0Var = d0.a;
            return d0.flexibleType((j0) iVar, (j0) iVar2);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + cVar + ", " + a0.getOrCreateKotlinClass(cVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.k getArgument(c cVar, d0.e0.p.d.m0.n.n1.h hVar, int i) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        if (hVar instanceof c0) {
            return ((c0) hVar).getArguments().get(i);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + a0.getOrCreateKotlinClass(hVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.g.c getClassFqNameUnsafe(c cVar, d0.e0.p.d.m0.n.n1.l lVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(lVar, "receiver");
        if (lVar instanceof u0) {
            d0.e0.p.d.m0.c.h declarationDescriptor = ((u0) lVar).getDeclarationDescriptor();
            Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return d0.e0.p.d.m0.k.x.a.getFqNameUnsafe((d0.e0.p.d.m0.c.e) declarationDescriptor);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + a0.getOrCreateKotlinClass(lVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.m getParameter(c cVar, d0.e0.p.d.m0.n.n1.l lVar, int i) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(lVar, "receiver");
        if (lVar instanceof u0) {
            z0 z0Var = ((u0) lVar).getParameters().get(i);
            d0.z.d.m.checkNotNullExpressionValue(z0Var, "this.parameters[index]");
            return z0Var;
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + a0.getOrCreateKotlinClass(lVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.b.i getPrimitiveArrayType(c cVar, d0.e0.p.d.m0.n.n1.l lVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(lVar, "receiver");
        if (lVar instanceof u0) {
            d0.e0.p.d.m0.c.h declarationDescriptor = ((u0) lVar).getDeclarationDescriptor();
            Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return d0.e0.p.d.m0.b.h.getPrimitiveArrayType((d0.e0.p.d.m0.c.e) declarationDescriptor);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + a0.getOrCreateKotlinClass(lVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.b.i getPrimitiveType(c cVar, d0.e0.p.d.m0.n.n1.l lVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(lVar, "receiver");
        if (lVar instanceof u0) {
            d0.e0.p.d.m0.c.h declarationDescriptor = ((u0) lVar).getDeclarationDescriptor();
            Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return d0.e0.p.d.m0.b.h.getPrimitiveType((d0.e0.p.d.m0.c.e) declarationDescriptor);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + a0.getOrCreateKotlinClass(lVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.h getRepresentativeUpperBound(c cVar, d0.e0.p.d.m0.n.n1.m mVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(mVar, "receiver");
        if (mVar instanceof z0) {
            return d0.e0.p.d.m0.n.o1.a.getRepresentativeUpperBound((z0) mVar);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + a0.getOrCreateKotlinClass(mVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.h getSubstitutedUnderlyingType(c cVar, d0.e0.p.d.m0.n.n1.h hVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        if (hVar instanceof c0) {
            return d0.e0.p.d.m0.k.g.substitutedUnderlyingType((c0) hVar);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + a0.getOrCreateKotlinClass(hVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.h getType(c cVar, d0.e0.p.d.m0.n.n1.k kVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(kVar, "receiver");
        if (kVar instanceof w0) {
            return ((w0) kVar).getType().unwrap();
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + a0.getOrCreateKotlinClass(kVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.m getTypeParameterClassifier(c cVar, d0.e0.p.d.m0.n.n1.l lVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(lVar, "receiver");
        if (lVar instanceof u0) {
            d0.e0.p.d.m0.c.h declarationDescriptor = ((u0) lVar).getDeclarationDescriptor();
            if (declarationDescriptor instanceof z0) {
                return (z0) declarationDescriptor;
            }
            return null;
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + a0.getOrCreateKotlinClass(lVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.r getVariance(c cVar, d0.e0.p.d.m0.n.n1.k kVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(kVar, "receiver");
        if (kVar instanceof w0) {
            j1 projectionKind = ((w0) kVar).getProjectionKind();
            d0.z.d.m.checkNotNullExpressionValue(projectionKind, "this.projectionKind");
            return d0.e0.p.d.m0.n.n1.o.convertVariance(projectionKind);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + a0.getOrCreateKotlinClass(kVar.getClass())).toString());
    }

    public static boolean hasAnnotation(c cVar, d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        if (hVar instanceof c0) {
            return ((c0) hVar).getAnnotations().hasAnnotation(bVar);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + a0.getOrCreateKotlinClass(hVar.getClass())).toString());
    }

    public static boolean identicalArguments(c cVar, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.i iVar2) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(iVar, "a");
        d0.z.d.m.checkNotNullParameter(iVar2, "b");
        if (!(iVar instanceof j0)) {
            StringBuilder sbZ = b.d.b.a.a.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
            sbZ.append(a0.getOrCreateKotlinClass(iVar.getClass()));
            throw new IllegalArgumentException(sbZ.toString().toString());
        }
        if (iVar2 instanceof j0) {
            return ((j0) iVar).getArguments() == ((j0) iVar2).getArguments();
        }
        StringBuilder sbZ2 = b.d.b.a.a.Z("ClassicTypeSystemContext couldn't handle: ", iVar2, ", ");
        sbZ2.append(a0.getOrCreateKotlinClass(iVar2.getClass()));
        throw new IllegalArgumentException(sbZ2.toString().toString());
    }

    public static d0.e0.p.d.m0.n.n1.h intersectTypes(c cVar, List<? extends d0.e0.p.d.m0.n.n1.h> list) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(list, "types");
        return e.intersectTypes(list);
    }

    public static boolean isAnyConstructor(c cVar, d0.e0.p.d.m0.n.n1.l lVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(lVar, "receiver");
        if (lVar instanceof u0) {
            return d0.e0.p.d.m0.b.h.isTypeConstructorForGivenClass((u0) lVar, k$a.f3217b);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + a0.getOrCreateKotlinClass(lVar.getClass())).toString());
    }

    public static boolean isClassTypeConstructor(c cVar, d0.e0.p.d.m0.n.n1.l lVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(lVar, "receiver");
        if (lVar instanceof u0) {
            return ((u0) lVar).getDeclarationDescriptor() instanceof d0.e0.p.d.m0.c.e;
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + a0.getOrCreateKotlinClass(lVar.getClass())).toString());
    }

    public static boolean isCommonFinalClassConstructor(c cVar, d0.e0.p.d.m0.n.n1.l lVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(lVar, "receiver");
        if (lVar instanceof u0) {
            d0.e0.p.d.m0.c.h declarationDescriptor = ((u0) lVar).getDeclarationDescriptor();
            d0.e0.p.d.m0.c.e eVar = declarationDescriptor instanceof d0.e0.p.d.m0.c.e ? (d0.e0.p.d.m0.c.e) declarationDescriptor : null;
            return (eVar == null || !d0.e0.p.d.m0.c.a0.isFinalClass(eVar) || eVar.getKind() == d0.e0.p.d.m0.c.f.ENUM_ENTRY || eVar.getKind() == d0.e0.p.d.m0.c.f.ANNOTATION_CLASS) ? false : true;
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + a0.getOrCreateKotlinClass(lVar.getClass())).toString());
    }

    public static boolean isDenotable(c cVar, d0.e0.p.d.m0.n.n1.l lVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(lVar, "receiver");
        if (lVar instanceof u0) {
            return ((u0) lVar).isDenotable();
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + a0.getOrCreateKotlinClass(lVar.getClass())).toString());
    }

    public static boolean isError(c cVar, d0.e0.p.d.m0.n.n1.h hVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        if (hVar instanceof c0) {
            return e0.isError((c0) hVar);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + a0.getOrCreateKotlinClass(hVar.getClass())).toString());
    }

    public static boolean isInlineClass(c cVar, d0.e0.p.d.m0.n.n1.l lVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(lVar, "receiver");
        if (lVar instanceof u0) {
            d0.e0.p.d.m0.c.h declarationDescriptor = ((u0) lVar).getDeclarationDescriptor();
            d0.e0.p.d.m0.c.e eVar = declarationDescriptor instanceof d0.e0.p.d.m0.c.e ? (d0.e0.p.d.m0.c.e) declarationDescriptor : null;
            return d0.z.d.m.areEqual(eVar != null ? Boolean.valueOf(d0.e0.p.d.m0.k.g.isInlineClass(eVar)) : null, Boolean.TRUE);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + a0.getOrCreateKotlinClass(lVar.getClass())).toString());
    }

    public static boolean isIntegerLiteralTypeConstructor(c cVar, d0.e0.p.d.m0.n.n1.l lVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(lVar, "receiver");
        if (lVar instanceof u0) {
            return lVar instanceof d0.e0.p.d.m0.k.v.n;
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + a0.getOrCreateKotlinClass(lVar.getClass())).toString());
    }

    public static boolean isIntersection(c cVar, d0.e0.p.d.m0.n.n1.l lVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(lVar, "receiver");
        if (lVar instanceof u0) {
            return lVar instanceof d0.e0.p.d.m0.n.a0;
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + a0.getOrCreateKotlinClass(lVar.getClass())).toString());
    }

    public static boolean isMarkedNullable(c cVar, d0.e0.p.d.m0.n.n1.h hVar) {
        return p$a.isMarkedNullable(cVar, hVar);
    }

    public static boolean isNothingConstructor(c cVar, d0.e0.p.d.m0.n.n1.l lVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(lVar, "receiver");
        if (lVar instanceof u0) {
            return d0.e0.p.d.m0.b.h.isTypeConstructorForGivenClass((u0) lVar, k$a.c);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + a0.getOrCreateKotlinClass(lVar.getClass())).toString());
    }

    public static boolean isNullableType(c cVar, d0.e0.p.d.m0.n.n1.h hVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        if (hVar instanceof c0) {
            return e1.isNullableType((c0) hVar);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + a0.getOrCreateKotlinClass(hVar.getClass())).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isPrimitiveType(c cVar, d0.e0.p.d.m0.n.n1.i iVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(iVar, "receiver");
        if (iVar instanceof c0) {
            return d0.e0.p.d.m0.b.h.isPrimitiveType((c0) iVar);
        }
        StringBuilder sbZ = b.d.b.a.a.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
        sbZ.append(a0.getOrCreateKotlinClass(iVar.getClass()));
        throw new IllegalArgumentException(sbZ.toString().toString());
    }

    public static boolean isProjectionNotNull(c cVar, d0.e0.p.d.m0.n.n1.c cVar2) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(cVar2, "receiver");
        if (cVar2 instanceof i) {
            return ((i) cVar2).isProjectionNotNull();
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + cVar2 + ", " + a0.getOrCreateKotlinClass(cVar2.getClass())).toString());
    }

    public static boolean isStarProjection(c cVar, d0.e0.p.d.m0.n.n1.k kVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(kVar, "receiver");
        if (kVar instanceof w0) {
            return ((w0) kVar).isStarProjection();
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + a0.getOrCreateKotlinClass(kVar.getClass())).toString());
    }

    public static boolean isStubType(c cVar, d0.e0.p.d.m0.n.n1.i iVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(iVar, "receiver");
        if (iVar instanceof j0) {
            return false;
        }
        StringBuilder sbZ = b.d.b.a.a.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
        sbZ.append(a0.getOrCreateKotlinClass(iVar.getClass()));
        throw new IllegalArgumentException(sbZ.toString().toString());
    }

    public static boolean isUnderKotlinPackage(c cVar, d0.e0.p.d.m0.n.n1.l lVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(lVar, "receiver");
        if (lVar instanceof u0) {
            d0.e0.p.d.m0.c.h declarationDescriptor = ((u0) lVar).getDeclarationDescriptor();
            return d0.z.d.m.areEqual(declarationDescriptor == null ? null : Boolean.valueOf(d0.e0.p.d.m0.b.h.isUnderKotlinPackage(declarationDescriptor)), Boolean.TRUE);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + a0.getOrCreateKotlinClass(lVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.i lowerBound(c cVar, d0.e0.p.d.m0.n.n1.f fVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(fVar, "receiver");
        if (fVar instanceof d0.e0.p.d.m0.n.v) {
            return ((d0.e0.p.d.m0.n.v) fVar).getLowerBound();
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + fVar + ", " + a0.getOrCreateKotlinClass(fVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.i lowerBoundIfFlexible(c cVar, d0.e0.p.d.m0.n.n1.h hVar) {
        return p$a.lowerBoundIfFlexible(cVar, hVar);
    }

    public static d0.e0.p.d.m0.n.n1.h lowerType(c cVar, d0.e0.p.d.m0.n.n1.c cVar2) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(cVar2, "receiver");
        if (cVar2 instanceof i) {
            return ((i) cVar2).getLowerType();
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + cVar2 + ", " + a0.getOrCreateKotlinClass(cVar2.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.h makeDefinitelyNotNullOrNotNull(c cVar, d0.e0.p.d.m0.n.n1.h hVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        if (hVar instanceof i1) {
            return d.access$makeDefinitelyNotNullOrNotNullInternal((i1) hVar);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + a0.getOrCreateKotlinClass(hVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.h makeNullable(c cVar, d0.e0.p.d.m0.n.n1.h hVar) {
        return d1$a.makeNullable(cVar, hVar);
    }

    public static d0.e0.p.d.m0.n.f newBaseTypeCheckerContext(c cVar, boolean z2, boolean z3) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        return new a(z2, z3, false, null, 12, null);
    }

    public static d0.e0.p.d.m0.n.n1.i original(c cVar, d0.e0.p.d.m0.n.n1.d dVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(dVar, "receiver");
        if (dVar instanceof d0.e0.p.d.m0.n.k) {
            return ((d0.e0.p.d.m0.n.k) dVar).getOriginal();
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + dVar + ", " + a0.getOrCreateKotlinClass(dVar.getClass())).toString());
    }

    public static int parametersCount(c cVar, d0.e0.p.d.m0.n.n1.l lVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(lVar, "receiver");
        if (lVar instanceof u0) {
            return ((u0) lVar).getParameters().size();
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + a0.getOrCreateKotlinClass(lVar.getClass())).toString());
    }

    public static Collection<d0.e0.p.d.m0.n.n1.h> possibleIntegerTypes(c cVar, d0.e0.p.d.m0.n.n1.i iVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(iVar, "receiver");
        d0.e0.p.d.m0.n.n1.l lVarTypeConstructor = cVar.typeConstructor(iVar);
        if (lVarTypeConstructor instanceof d0.e0.p.d.m0.k.v.n) {
            return ((d0.e0.p.d.m0.k.v.n) lVarTypeConstructor).getPossibleTypes();
        }
        StringBuilder sbZ = b.d.b.a.a.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
        sbZ.append(a0.getOrCreateKotlinClass(iVar.getClass()));
        throw new IllegalArgumentException(sbZ.toString().toString());
    }

    public static Collection<d0.e0.p.d.m0.n.n1.h> supertypes(c cVar, d0.e0.p.d.m0.n.n1.l lVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(lVar, "receiver");
        if (lVar instanceof u0) {
            Collection<c0> supertypes = ((u0) lVar).getSupertypes();
            d0.z.d.m.checkNotNullExpressionValue(supertypes, "this.supertypes");
            return supertypes;
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + a0.getOrCreateKotlinClass(lVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.l typeConstructor(c cVar, d0.e0.p.d.m0.n.n1.h hVar) {
        return p$a.typeConstructor(cVar, hVar);
    }

    public static d0.e0.p.d.m0.n.n1.i upperBound(c cVar, d0.e0.p.d.m0.n.n1.f fVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(fVar, "receiver");
        if (fVar instanceof d0.e0.p.d.m0.n.v) {
            return ((d0.e0.p.d.m0.n.v) fVar).getUpperBound();
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + fVar + ", " + a0.getOrCreateKotlinClass(fVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.i upperBoundIfFlexible(c cVar, d0.e0.p.d.m0.n.n1.h hVar) {
        return p$a.upperBoundIfFlexible(cVar, hVar);
    }

    public static d0.e0.p.d.m0.n.n1.i withNullability(c cVar, d0.e0.p.d.m0.n.n1.i iVar, boolean z2) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(iVar, "receiver");
        if (iVar instanceof j0) {
            return ((j0) iVar).makeNullableAsSpecified(z2);
        }
        StringBuilder sbZ = b.d.b.a.a.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
        sbZ.append(a0.getOrCreateKotlinClass(iVar.getClass()));
        throw new IllegalArgumentException(sbZ.toString().toString());
    }

    public static boolean isMarkedNullable(c cVar, d0.e0.p.d.m0.n.n1.i iVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(iVar, "receiver");
        if (iVar instanceof j0) {
            return ((j0) iVar).isMarkedNullable();
        }
        StringBuilder sbZ = b.d.b.a.a.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
        sbZ.append(a0.getOrCreateKotlinClass(iVar.getClass()));
        throw new IllegalArgumentException(sbZ.toString().toString());
    }

    public static d0.e0.p.d.m0.n.n1.l typeConstructor(c cVar, d0.e0.p.d.m0.n.n1.i iVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(iVar, "receiver");
        if (iVar instanceof j0) {
            return ((j0) iVar).getConstructor();
        }
        StringBuilder sbZ = b.d.b.a.a.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
        sbZ.append(a0.getOrCreateKotlinClass(iVar.getClass()));
        throw new IllegalArgumentException(sbZ.toString().toString());
    }

    public static d0.e0.p.d.m0.n.n1.r getVariance(c cVar, d0.e0.p.d.m0.n.n1.m mVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(mVar, "receiver");
        if (mVar instanceof z0) {
            j1 variance = ((z0) mVar).getVariance();
            d0.z.d.m.checkNotNullExpressionValue(variance, "this.variance");
            return d0.e0.p.d.m0.n.n1.o.convertVariance(variance);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + a0.getOrCreateKotlinClass(mVar.getClass())).toString());
    }

    public static d0.e0.p.d.m0.n.n1.h withNullability(c cVar, d0.e0.p.d.m0.n.n1.h hVar, boolean z2) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.z.d.m.checkNotNullParameter(hVar, "receiver");
        if (hVar instanceof d0.e0.p.d.m0.n.n1.i) {
            return cVar.withNullability((d0.e0.p.d.m0.n.n1.i) hVar, z2);
        }
        if (!(hVar instanceof d0.e0.p.d.m0.n.n1.f)) {
            throw new IllegalStateException("sealed".toString());
        }
        d0.e0.p.d.m0.n.n1.f fVar = (d0.e0.p.d.m0.n.n1.f) hVar;
        return cVar.createFlexibleType(cVar.withNullability(cVar.lowerBound(fVar), z2), cVar.withNullability(cVar.upperBound(fVar), z2));
    }
}
