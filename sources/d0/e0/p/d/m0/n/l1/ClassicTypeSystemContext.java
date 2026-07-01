package d0.e0.p.d.m0.n.l1;

import b.d.b.a.outline;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.b.PrimitiveType;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.ModalityUtils;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.k.inlineClassesUtils;
import d0.e0.p.d.m0.k.v.IntegerLiteralTypeConstructor;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.AbstractTypeChecker3;
import d0.e0.p.d.m0.n.IntersectionTypeConstructor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType2;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinType6;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.SpecialTypes3;
import d0.e0.p.d.m0.n.SpecialTypes5;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.TypeSystemCommonBackendContext;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.dynamicTypes;
import d0.e0.p.d.m0.n.n1.p;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.c, reason: use source file name */
/* JADX INFO: compiled from: ClassicTypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ClassicTypeSystemContext extends TypeSystemCommonBackendContext, d0.e0.p.d.m0.n.n1.p {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.c$a */
    /* JADX INFO: compiled from: ClassicTypeSystemContext.kt */
    public static final class a {
        public static boolean areEqualTypeConstructors(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.l lVar, d0.e0.p.d.m0.n.n1.l lVar2) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(lVar, "c1");
            Intrinsics3.checkNotNullParameter(lVar2, "c2");
            if (!(lVar instanceof TypeConstructor)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + Reflection2.getOrCreateKotlinClass(lVar.getClass())).toString());
            }
            if (lVar2 instanceof TypeConstructor) {
                return Intrinsics3.areEqual(lVar, lVar2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar2 + ", " + Reflection2.getOrCreateKotlinClass(lVar2.getClass())).toString());
        }

        public static int argumentsCount(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.h hVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            if (hVar instanceof KotlinType) {
                return ((KotlinType) hVar).getArguments().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + Reflection2.getOrCreateKotlinClass(hVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.j asArgumentList(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.i iVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(iVar, "receiver");
            if (iVar instanceof KotlinType4) {
                return (d0.e0.p.d.m0.n.n1.j) iVar;
            }
            StringBuilder sbZ = outline.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
            sbZ.append(Reflection2.getOrCreateKotlinClass(iVar.getClass()));
            throw new IllegalArgumentException(sbZ.toString().toString());
        }

        public static d0.e0.p.d.m0.n.n1.c asCapturedType(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.i iVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(iVar, "receiver");
            if (iVar instanceof KotlinType4) {
                if (iVar instanceof NewCapturedType) {
                    return (NewCapturedType) iVar;
                }
                return null;
            }
            StringBuilder sbZ = outline.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
            sbZ.append(Reflection2.getOrCreateKotlinClass(iVar.getClass()));
            throw new IllegalArgumentException(sbZ.toString().toString());
        }

        public static d0.e0.p.d.m0.n.n1.d asDefinitelyNotNullType(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.i iVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(iVar, "receiver");
            if (iVar instanceof KotlinType4) {
                if (iVar instanceof SpecialTypes3) {
                    return (SpecialTypes3) iVar;
                }
                return null;
            }
            StringBuilder sbZ = outline.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
            sbZ.append(Reflection2.getOrCreateKotlinClass(iVar.getClass()));
            throw new IllegalArgumentException(sbZ.toString().toString());
        }

        public static d0.e0.p.d.m0.n.n1.e asDynamicType(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.f fVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(fVar, "receiver");
            if (fVar instanceof KotlinType6) {
                if (fVar instanceof dynamicTypes) {
                    return (dynamicTypes) fVar;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + fVar + ", " + Reflection2.getOrCreateKotlinClass(fVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.f asFlexibleType(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.h hVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            if (hVar instanceof KotlinType) {
                KotlinType3 kotlinType3Unwrap = ((KotlinType) hVar).unwrap();
                if (kotlinType3Unwrap instanceof KotlinType6) {
                    return (KotlinType6) kotlinType3Unwrap;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + Reflection2.getOrCreateKotlinClass(hVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.i asSimpleType(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.h hVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            if (hVar instanceof KotlinType) {
                KotlinType3 kotlinType3Unwrap = ((KotlinType) hVar).unwrap();
                if (kotlinType3Unwrap instanceof KotlinType4) {
                    return (KotlinType4) kotlinType3Unwrap;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + Reflection2.getOrCreateKotlinClass(hVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.k asTypeArgument(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.h hVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            if (hVar instanceof KotlinType) {
                return TypeUtils2.asTypeProjection((KotlinType) hVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + Reflection2.getOrCreateKotlinClass(hVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.i captureFromArguments(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.b bVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(iVar, "type");
            Intrinsics3.checkNotNullParameter(bVar, "status");
            if (iVar instanceof KotlinType4) {
                return NewCapturedType3.captureFromArguments((KotlinType4) iVar, bVar);
            }
            StringBuilder sbZ = outline.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
            sbZ.append(Reflection2.getOrCreateKotlinClass(iVar.getClass()));
            throw new IllegalArgumentException(sbZ.toString().toString());
        }

        public static d0.e0.p.d.m0.n.n1.h createFlexibleType(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.i iVar2) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(iVar, "lowerBound");
            Intrinsics3.checkNotNullParameter(iVar2, "upperBound");
            if (!(iVar instanceof KotlinType4)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + classicTypeSystemContext + ", " + Reflection2.getOrCreateKotlinClass(classicTypeSystemContext.getClass())).toString());
            }
            if (iVar2 instanceof KotlinType4) {
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
                return KotlinTypeFactory.flexibleType((KotlinType4) iVar, (KotlinType4) iVar2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + classicTypeSystemContext + ", " + Reflection2.getOrCreateKotlinClass(classicTypeSystemContext.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.k getArgument(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.h hVar, int i) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            if (hVar instanceof KotlinType) {
                return ((KotlinType) hVar).getArguments().get(i);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + Reflection2.getOrCreateKotlinClass(hVar.getClass())).toString());
        }

        public static FqNameUnsafe getClassFqNameUnsafe(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.l lVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(lVar, "receiver");
            if (lVar instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) lVar).getDeclarationDescriptor();
                Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return DescriptorUtils2.getFqNameUnsafe((ClassDescriptor) declarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + Reflection2.getOrCreateKotlinClass(lVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.m getParameter(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.l lVar, int i) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(lVar, "receiver");
            if (lVar instanceof TypeConstructor) {
                TypeParameterDescriptor typeParameterDescriptor = ((TypeConstructor) lVar).getParameters().get(i);
                Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor, "this.parameters[index]");
                return typeParameterDescriptor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + Reflection2.getOrCreateKotlinClass(lVar.getClass())).toString());
        }

        public static PrimitiveType getPrimitiveArrayType(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.l lVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(lVar, "receiver");
            if (lVar instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) lVar).getDeclarationDescriptor();
                Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return KotlinBuiltIns.getPrimitiveArrayType((ClassDescriptor) declarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + Reflection2.getOrCreateKotlinClass(lVar.getClass())).toString());
        }

        public static PrimitiveType getPrimitiveType(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.l lVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(lVar, "receiver");
            if (lVar instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) lVar).getDeclarationDescriptor();
                Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return KotlinBuiltIns.getPrimitiveType((ClassDescriptor) declarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + Reflection2.getOrCreateKotlinClass(lVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.h getRepresentativeUpperBound(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.m mVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(mVar, "receiver");
            if (mVar instanceof TypeParameterDescriptor) {
                return TypeUtils2.getRepresentativeUpperBound((TypeParameterDescriptor) mVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + Reflection2.getOrCreateKotlinClass(mVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.h getSubstitutedUnderlyingType(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.h hVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            if (hVar instanceof KotlinType) {
                return inlineClassesUtils.substitutedUnderlyingType((KotlinType) hVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + Reflection2.getOrCreateKotlinClass(hVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.h getType(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.k kVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(kVar, "receiver");
            if (kVar instanceof TypeProjection) {
                return ((TypeProjection) kVar).getType().unwrap();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + Reflection2.getOrCreateKotlinClass(kVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.m getTypeParameterClassifier(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.l lVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(lVar, "receiver");
            if (lVar instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) lVar).getDeclarationDescriptor();
                if (declarationDescriptor instanceof TypeParameterDescriptor) {
                    return (TypeParameterDescriptor) declarationDescriptor;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + Reflection2.getOrCreateKotlinClass(lVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.r getVariance(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.k kVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(kVar, "receiver");
            if (kVar instanceof TypeProjection) {
                Variance projectionKind = ((TypeProjection) kVar).getProjectionKind();
                Intrinsics3.checkNotNullExpressionValue(projectionKind, "this.projectionKind");
                return d0.e0.p.d.m0.n.n1.o.convertVariance(projectionKind);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + Reflection2.getOrCreateKotlinClass(kVar.getClass())).toString());
        }

        public static boolean hasAnnotation(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.h hVar, FqName fqName) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            if (hVar instanceof KotlinType) {
                return ((KotlinType) hVar).getAnnotations().hasAnnotation(fqName);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + Reflection2.getOrCreateKotlinClass(hVar.getClass())).toString());
        }

        public static boolean identicalArguments(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.i iVar2) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(iVar, "a");
            Intrinsics3.checkNotNullParameter(iVar2, "b");
            if (!(iVar instanceof KotlinType4)) {
                StringBuilder sbZ = outline.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
                sbZ.append(Reflection2.getOrCreateKotlinClass(iVar.getClass()));
                throw new IllegalArgumentException(sbZ.toString().toString());
            }
            if (iVar2 instanceof KotlinType4) {
                return ((KotlinType4) iVar).getArguments() == ((KotlinType4) iVar2).getArguments();
            }
            StringBuilder sbZ2 = outline.Z("ClassicTypeSystemContext couldn't handle: ", iVar2, ", ");
            sbZ2.append(Reflection2.getOrCreateKotlinClass(iVar2.getClass()));
            throw new IllegalArgumentException(sbZ2.toString().toString());
        }

        public static d0.e0.p.d.m0.n.n1.h intersectTypes(ClassicTypeSystemContext classicTypeSystemContext, List<? extends d0.e0.p.d.m0.n.n1.h> list) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(list, "types");
            return IntersectionType.intersectTypes(list);
        }

        public static boolean isAnyConstructor(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.l lVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(lVar, "receiver");
            if (lVar instanceof TypeConstructor) {
                return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) lVar, StandardNames.a.f3217b);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + Reflection2.getOrCreateKotlinClass(lVar.getClass())).toString());
        }

        public static boolean isClassTypeConstructor(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.l lVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(lVar, "receiver");
            if (lVar instanceof TypeConstructor) {
                return ((TypeConstructor) lVar).getDeclarationDescriptor() instanceof ClassDescriptor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + Reflection2.getOrCreateKotlinClass(lVar.getClass())).toString());
        }

        public static boolean isCommonFinalClassConstructor(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.l lVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(lVar, "receiver");
            if (lVar instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) lVar).getDeclarationDescriptor();
                ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
                return (classDescriptor == null || !ModalityUtils.isFinalClass(classDescriptor) || classDescriptor.getKind() == ClassKind.ENUM_ENTRY || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS) ? false : true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + Reflection2.getOrCreateKotlinClass(lVar.getClass())).toString());
        }

        public static boolean isDenotable(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.l lVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(lVar, "receiver");
            if (lVar instanceof TypeConstructor) {
                return ((TypeConstructor) lVar).isDenotable();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + Reflection2.getOrCreateKotlinClass(lVar.getClass())).toString());
        }

        public static boolean isError(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.h hVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            if (hVar instanceof KotlinType) {
                return KotlinType2.isError((KotlinType) hVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + Reflection2.getOrCreateKotlinClass(hVar.getClass())).toString());
        }

        public static boolean isInlineClass(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.l lVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(lVar, "receiver");
            if (lVar instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) lVar).getDeclarationDescriptor();
                ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
                return Intrinsics3.areEqual(classDescriptor != null ? Boolean.valueOf(inlineClassesUtils.isInlineClass(classDescriptor)) : null, Boolean.TRUE);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + Reflection2.getOrCreateKotlinClass(lVar.getClass())).toString());
        }

        public static boolean isIntegerLiteralTypeConstructor(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.l lVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(lVar, "receiver");
            if (lVar instanceof TypeConstructor) {
                return lVar instanceof IntegerLiteralTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + Reflection2.getOrCreateKotlinClass(lVar.getClass())).toString());
        }

        public static boolean isIntersection(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.l lVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(lVar, "receiver");
            if (lVar instanceof TypeConstructor) {
                return lVar instanceof IntersectionTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + Reflection2.getOrCreateKotlinClass(lVar.getClass())).toString());
        }

        public static boolean isMarkedNullable(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.h hVar) {
            return p.a.isMarkedNullable(classicTypeSystemContext, hVar);
        }

        public static boolean isNothingConstructor(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.l lVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(lVar, "receiver");
            if (lVar instanceof TypeConstructor) {
                return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) lVar, StandardNames.a.c);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + Reflection2.getOrCreateKotlinClass(lVar.getClass())).toString());
        }

        public static boolean isNullableType(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.h hVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            if (hVar instanceof KotlinType) {
                return TypeUtils.isNullableType((KotlinType) hVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + Reflection2.getOrCreateKotlinClass(hVar.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isPrimitiveType(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.i iVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(iVar, "receiver");
            if (iVar instanceof KotlinType) {
                return KotlinBuiltIns.isPrimitiveType((KotlinType) iVar);
            }
            StringBuilder sbZ = outline.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
            sbZ.append(Reflection2.getOrCreateKotlinClass(iVar.getClass()));
            throw new IllegalArgumentException(sbZ.toString().toString());
        }

        public static boolean isProjectionNotNull(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.c cVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(cVar, "receiver");
            if (cVar instanceof NewCapturedType) {
                return ((NewCapturedType) cVar).isProjectionNotNull();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + cVar + ", " + Reflection2.getOrCreateKotlinClass(cVar.getClass())).toString());
        }

        public static boolean isStarProjection(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.k kVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(kVar, "receiver");
            if (kVar instanceof TypeProjection) {
                return ((TypeProjection) kVar).isStarProjection();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + Reflection2.getOrCreateKotlinClass(kVar.getClass())).toString());
        }

        public static boolean isStubType(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.i iVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(iVar, "receiver");
            if (iVar instanceof KotlinType4) {
                return false;
            }
            StringBuilder sbZ = outline.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
            sbZ.append(Reflection2.getOrCreateKotlinClass(iVar.getClass()));
            throw new IllegalArgumentException(sbZ.toString().toString());
        }

        public static boolean isUnderKotlinPackage(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.l lVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(lVar, "receiver");
            if (lVar instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) lVar).getDeclarationDescriptor();
                return Intrinsics3.areEqual(declarationDescriptor == null ? null : Boolean.valueOf(KotlinBuiltIns.isUnderKotlinPackage(declarationDescriptor)), Boolean.TRUE);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + Reflection2.getOrCreateKotlinClass(lVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.i lowerBound(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.f fVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(fVar, "receiver");
            if (fVar instanceof KotlinType6) {
                return ((KotlinType6) fVar).getLowerBound();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + fVar + ", " + Reflection2.getOrCreateKotlinClass(fVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.i lowerBoundIfFlexible(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.h hVar) {
            return p.a.lowerBoundIfFlexible(classicTypeSystemContext, hVar);
        }

        public static d0.e0.p.d.m0.n.n1.h lowerType(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.c cVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(cVar, "receiver");
            if (cVar instanceof NewCapturedType) {
                return ((NewCapturedType) cVar).getLowerType();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + cVar + ", " + Reflection2.getOrCreateKotlinClass(cVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.h makeDefinitelyNotNullOrNotNull(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.h hVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            if (hVar instanceof KotlinType3) {
                return SpecialTypes5.makeDefinitelyNotNullOrNotNull$default((KotlinType3) hVar, false, 1, null);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + Reflection2.getOrCreateKotlinClass(hVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.h makeNullable(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.h hVar) {
            return TypeSystemCommonBackendContext.a.makeNullable(classicTypeSystemContext, hVar);
        }

        public static AbstractTypeChecker3 newBaseTypeCheckerContext(ClassicTypeSystemContext classicTypeSystemContext, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            return new ClassicTypeCheckerContext(z2, z3, false, null, 12, null);
        }

        public static d0.e0.p.d.m0.n.n1.i original(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.d dVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(dVar, "receiver");
            if (dVar instanceof SpecialTypes3) {
                return ((SpecialTypes3) dVar).getOriginal();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + dVar + ", " + Reflection2.getOrCreateKotlinClass(dVar.getClass())).toString());
        }

        public static int parametersCount(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.l lVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(lVar, "receiver");
            if (lVar instanceof TypeConstructor) {
                return ((TypeConstructor) lVar).getParameters().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + Reflection2.getOrCreateKotlinClass(lVar.getClass())).toString());
        }

        public static Collection<d0.e0.p.d.m0.n.n1.h> possibleIntegerTypes(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.i iVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(iVar, "receiver");
            d0.e0.p.d.m0.n.n1.l lVarTypeConstructor = classicTypeSystemContext.typeConstructor(iVar);
            if (lVarTypeConstructor instanceof IntegerLiteralTypeConstructor) {
                return ((IntegerLiteralTypeConstructor) lVarTypeConstructor).getPossibleTypes();
            }
            StringBuilder sbZ = outline.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
            sbZ.append(Reflection2.getOrCreateKotlinClass(iVar.getClass()));
            throw new IllegalArgumentException(sbZ.toString().toString());
        }

        public static Collection<d0.e0.p.d.m0.n.n1.h> supertypes(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.l lVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(lVar, "receiver");
            if (lVar instanceof TypeConstructor) {
                Collection<KotlinType> supertypes = ((TypeConstructor) lVar).getSupertypes();
                Intrinsics3.checkNotNullExpressionValue(supertypes, "this.supertypes");
                return supertypes;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + Reflection2.getOrCreateKotlinClass(lVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.l typeConstructor(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.h hVar) {
            return p.a.typeConstructor(classicTypeSystemContext, hVar);
        }

        public static d0.e0.p.d.m0.n.n1.i upperBound(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.f fVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(fVar, "receiver");
            if (fVar instanceof KotlinType6) {
                return ((KotlinType6) fVar).getUpperBound();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + fVar + ", " + Reflection2.getOrCreateKotlinClass(fVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.i upperBoundIfFlexible(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.h hVar) {
            return p.a.upperBoundIfFlexible(classicTypeSystemContext, hVar);
        }

        public static d0.e0.p.d.m0.n.n1.i withNullability(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.i iVar, boolean z2) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(iVar, "receiver");
            if (iVar instanceof KotlinType4) {
                return ((KotlinType4) iVar).makeNullableAsSpecified(z2);
            }
            StringBuilder sbZ = outline.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
            sbZ.append(Reflection2.getOrCreateKotlinClass(iVar.getClass()));
            throw new IllegalArgumentException(sbZ.toString().toString());
        }

        public static boolean isMarkedNullable(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.i iVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(iVar, "receiver");
            if (iVar instanceof KotlinType4) {
                return ((KotlinType4) iVar).isMarkedNullable();
            }
            StringBuilder sbZ = outline.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
            sbZ.append(Reflection2.getOrCreateKotlinClass(iVar.getClass()));
            throw new IllegalArgumentException(sbZ.toString().toString());
        }

        public static d0.e0.p.d.m0.n.n1.l typeConstructor(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.i iVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(iVar, "receiver");
            if (iVar instanceof KotlinType4) {
                return ((KotlinType4) iVar).getConstructor();
            }
            StringBuilder sbZ = outline.Z("ClassicTypeSystemContext couldn't handle: ", iVar, ", ");
            sbZ.append(Reflection2.getOrCreateKotlinClass(iVar.getClass()));
            throw new IllegalArgumentException(sbZ.toString().toString());
        }

        public static d0.e0.p.d.m0.n.n1.r getVariance(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.m mVar) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(mVar, "receiver");
            if (mVar instanceof TypeParameterDescriptor) {
                Variance variance = ((TypeParameterDescriptor) mVar).getVariance();
                Intrinsics3.checkNotNullExpressionValue(variance, "this.variance");
                return d0.e0.p.d.m0.n.n1.o.convertVariance(variance);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + Reflection2.getOrCreateKotlinClass(mVar.getClass())).toString());
        }

        public static d0.e0.p.d.m0.n.n1.h withNullability(ClassicTypeSystemContext classicTypeSystemContext, d0.e0.p.d.m0.n.n1.h hVar, boolean z2) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "this");
            Intrinsics3.checkNotNullParameter(hVar, "receiver");
            if (hVar instanceof d0.e0.p.d.m0.n.n1.i) {
                return classicTypeSystemContext.withNullability((d0.e0.p.d.m0.n.n1.i) hVar, z2);
            }
            if (!(hVar instanceof d0.e0.p.d.m0.n.n1.f)) {
                throw new IllegalStateException("sealed".toString());
            }
            d0.e0.p.d.m0.n.n1.f fVar = (d0.e0.p.d.m0.n.n1.f) hVar;
            return classicTypeSystemContext.createFlexibleType(classicTypeSystemContext.withNullability(classicTypeSystemContext.lowerBound(fVar), z2), classicTypeSystemContext.withNullability(classicTypeSystemContext.upperBound(fVar), z2));
        }
    }

    d0.e0.p.d.m0.n.n1.i asSimpleType(d0.e0.p.d.m0.n.n1.h hVar);

    d0.e0.p.d.m0.n.n1.h createFlexibleType(d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.i iVar2);

    d0.e0.p.d.m0.n.n1.i lowerBound(d0.e0.p.d.m0.n.n1.f fVar);

    d0.e0.p.d.m0.n.n1.l typeConstructor(d0.e0.p.d.m0.n.n1.i iVar);

    d0.e0.p.d.m0.n.n1.i upperBound(d0.e0.p.d.m0.n.n1.f fVar);

    d0.e0.p.d.m0.n.n1.i withNullability(d0.e0.p.d.m0.n.n1.i iVar, boolean z2);
}
