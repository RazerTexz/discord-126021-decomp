package d0.e0.p.d.m0.n;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TypeSubstitutor.java */
/* JADX INFO: loaded from: classes3.dex */
public class c1 {
    public static final c1 a = create(z0.a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z0 f3520b;

    public c1(z0 z0Var) {
        if (z0Var != null) {
            this.f3520b = z0Var;
        } else {
            a(6);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001d A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:23:0x0036 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:54:0x00b1  */
    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (i != 1 && i != 7 && i != 32 && i != 35) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 38:
                                        case 39:
                                        case 40:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            str = "@NotNull method %s.%s must not return null";
                            break;
                    }
                case 10:
                case 11:
                case 12:
                    str = "@NotNull method %s.%s must not return null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 1 && i != 7 && i != 32 && i != 35) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 38:
                                        case 39:
                                        case 40:
                                            break;
                                        default:
                                            i2 = 3;
                                            break;
                                    }
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                    i2 = 2;
                                    break;
                            }
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            i2 = 2;
                            break;
                    }
                case 10:
                case 11:
                case 12:
                    i2 = 2;
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 7:
            case 10:
            case 11:
            case 12:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 27:
            case 28:
            case 29:
            case 30:
            case 32:
            case 35:
            case 38:
            case 39:
            case 40:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "substitutionContext";
                break;
            case 5:
                objArr[0] = "context";
                break;
            case 6:
            default:
                objArr[0] = "substitution";
                break;
            case 8:
            case 13:
                objArr[0] = "type";
                break;
            case 9:
            case 14:
                objArr[0] = "howThisTypeIsUsed";
                break;
            case 15:
            case 16:
            case 34:
                objArr[0] = "typeProjection";
                break;
            case 17:
            case 26:
                objArr[0] = "originalProjection";
                break;
            case 24:
                objArr[0] = "originalType";
                break;
            case 25:
                objArr[0] = "substituted";
                break;
            case 31:
                objArr[0] = "annotations";
                break;
            case 33:
            case 36:
                objArr[0] = "typeParameterVariance";
                break;
            case 37:
                objArr[0] = "projectionKind";
                break;
        }
        if (i == 1) {
            objArr[1] = "replaceWithNonApproximatingSubstitution";
        } else if (i == 7) {
            objArr[1] = "getSubstitution";
        } else if (i == 32) {
            objArr[1] = "filterOutUnsafeVariance";
        } else if (i != 35) {
            switch (i) {
                case 10:
                case 11:
                case 12:
                    objArr[1] = "safeSubstitute";
                    break;
                default:
                    switch (i) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            objArr[1] = "unsafeSubstitute";
                            break;
                        default:
                            switch (i) {
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                    objArr[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                                    break;
                                default:
                                    switch (i) {
                                        case 38:
                                        case 39:
                                        case 40:
                                            objArr[1] = "combine";
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            objArr[1] = "combine";
        }
        switch (i) {
            case 1:
            case 7:
            case 10:
            case 11:
            case 12:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 27:
            case 28:
            case 29:
            case 30:
            case 32:
            case 35:
            case 38:
            case 39:
            case 40:
                break;
            case 2:
            case 3:
                objArr[2] = "createChainedSubstitutor";
                break;
            case 4:
            case 5:
            default:
                objArr[2] = "create";
                break;
            case 6:
                objArr[2] = "<init>";
                break;
            case 8:
            case 9:
                objArr[2] = "safeSubstitute";
                break;
            case 13:
            case 14:
            case 15:
                objArr[2] = "substitute";
                break;
            case 16:
                objArr[2] = "substituteWithoutApproximation";
                break;
            case 17:
                objArr[2] = "unsafeSubstitute";
                break;
            case 24:
            case 25:
            case 26:
                objArr[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                break;
            case 31:
                objArr[2] = "filterOutUnsafeVariance";
                break;
            case 33:
            case 34:
            case 36:
            case 37:
                objArr[2] = "combine";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 7 && i != 32 && i != 35) {
            switch (i) {
                case 10:
                case 11:
                case 12:
                    break;
                default:
                    switch (i) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            break;
                        default:
                            switch (i) {
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                    break;
                                default:
                                    switch (i) {
                                        case 38:
                                        case 39:
                                        case 40:
                                            break;
                                        default:
                                            throw new IllegalArgumentException(str2);
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        throw new IllegalStateException(str2);
    }

    public static int b(j1 j1Var, j1 j1Var2) {
        j1 j1Var3 = j1.OUT_VARIANCE;
        j1 j1Var4 = j1.IN_VARIANCE;
        if (j1Var == j1Var4 && j1Var2 == j1Var3) {
            return 3;
        }
        return (j1Var == j1Var3 && j1Var2 == j1Var4) ? 2 : 1;
    }

    public static String c(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (d0.e0.p.d.m0.p.c.isProcessCanceledException(th)) {
                throw th;
            }
            return "[Exception while computing toString(): " + th + "]";
        }
    }

    public static j1 combine(j1 j1Var, w0 w0Var) {
        if (j1Var == null) {
            a(33);
            throw null;
        }
        if (w0Var != null) {
            return w0Var.isStarProjection() ? j1.OUT_VARIANCE : combine(j1Var, w0Var.getProjectionKind());
        }
        a(34);
        throw null;
    }

    public static c1 create(z0 z0Var) {
        if (z0Var != null) {
            return new c1(z0Var);
        }
        a(0);
        throw null;
    }

    public static c1 createChainedSubstitutor(z0 z0Var, z0 z0Var2) {
        if (z0Var == null) {
            a(2);
            throw null;
        }
        if (z0Var2 != null) {
            return create(p.create(z0Var, z0Var2));
        }
        a(3);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final w0 d(w0 w0Var, d0.e0.p.d.m0.c.z0 z0Var, int i) throws c1$a {
        if (w0Var == null) {
            a(17);
            throw null;
        }
        z0 z0Var2 = this.f3520b;
        if (i > 100) {
            StringBuilder sbU = b.d.b.a.a.U("Recursion too deep. Most likely infinite loop while substituting ");
            sbU.append(c(w0Var));
            sbU.append("; substitution: ");
            sbU.append(c(z0Var2));
            throw new IllegalStateException(sbU.toString());
        }
        if (w0Var.isStarProjection()) {
            return w0Var;
        }
        c0 type = w0Var.getType();
        if (type instanceof f1) {
            f1 f1Var = (f1) type;
            i1 origin = f1Var.getOrigin();
            c0 enhancement = f1Var.getEnhancement();
            w0 w0VarD = d(new y0(w0Var.getProjectionKind(), origin), z0Var, i + 1);
            return new y0(w0VarD.getProjectionKind(), g1.wrapEnhancement(w0VarD.getType().unwrap(), substitute(enhancement, w0Var.getProjectionKind())));
        }
        if (r.isDynamic(type) || (type.unwrap() instanceof i0)) {
            return w0Var;
        }
        w0 y0Var = this.f3520b.get(type);
        if (y0Var == null) {
            y0Var = null;
        } else if (type.getAnnotations().hasAnnotation(d0.e0.p.d.m0.b.k$a.G)) {
            u0 constructor = y0Var.getType().getConstructor();
            if (constructor instanceof d0.e0.p.d.m0.n.l1.j) {
                w0 projection = ((d0.e0.p.d.m0.n.l1.j) constructor).getProjection();
                j1 projectionKind = projection.getProjectionKind();
                if (b(w0Var.getProjectionKind(), projectionKind) == 3) {
                    y0Var = new y0(projection.getType());
                } else if (z0Var != null && b(z0Var.getVariance(), projectionKind) == 3) {
                    y0Var = new y0(projection.getType());
                }
            }
        }
        j1 projectionKind2 = w0Var.getProjectionKind();
        if (y0Var == null && y.isFlexible(type) && !t0.isCustomTypeVariable(type)) {
            v vVarAsFlexibleType = y.asFlexibleType(type);
            int i2 = i + 1;
            w0 w0VarD2 = d(new y0(projectionKind2, vVarAsFlexibleType.getLowerBound()), z0Var, i2);
            w0 w0VarD3 = d(new y0(projectionKind2, vVarAsFlexibleType.getUpperBound()), z0Var, i2);
            return (w0VarD2.getType() == vVarAsFlexibleType.getLowerBound() && w0VarD3.getType() == vVarAsFlexibleType.getUpperBound()) ? w0Var : new y0(w0VarD2.getProjectionKind(), d0.flexibleType(a1.asSimpleType(w0VarD2.getType()), a1.asSimpleType(w0VarD3.getType())));
        }
        if (d0.e0.p.d.m0.b.h.isNothing(type) || e0.isError(type)) {
            return w0Var;
        }
        if (y0Var != null) {
            int iB = b(projectionKind2, y0Var.getProjectionKind());
            if (!d0.e0.p.d.m0.k.u.a.d.isCaptured(type)) {
                int iH = b.c.a.y.b.h(iB);
                if (iH == 1) {
                    return new y0(j1.OUT_VARIANCE, type.getConstructor().getBuiltIns().getNullableAnyType());
                }
                if (iH == 2) {
                    throw new c1$a("Out-projection in in-position");
                }
            }
            j customTypeVariable = t0.getCustomTypeVariable(type);
            if (y0Var.isStarProjection()) {
                return y0Var;
            }
            c0 c0VarSubstitutionResult = customTypeVariable != null ? customTypeVariable.substitutionResult(y0Var.getType()) : e1.makeNullableIfNeeded(y0Var.getType(), type.isMarkedNullable());
            if (!type.getAnnotations().isEmpty()) {
                d0.e0.p.d.m0.c.g1.g gVarFilterAnnotations = this.f3520b.filterAnnotations(type.getAnnotations());
                if (gVarFilterAnnotations == null) {
                    a(31);
                    throw null;
                }
                if (gVarFilterAnnotations.hasAnnotation(d0.e0.p.d.m0.b.k$a.G)) {
                    gVarFilterAnnotations = new d0.e0.p.d.m0.c.g1.l(gVarFilterAnnotations, new b1());
                }
                c0VarSubstitutionResult = d0.e0.p.d.m0.n.o1.a.replaceAnnotations(c0VarSubstitutionResult, new d0.e0.p.d.m0.c.g1.k(c0VarSubstitutionResult.getAnnotations(), gVarFilterAnnotations));
            }
            if (iB == 1) {
                projectionKind2 = combine(projectionKind2, y0Var.getProjectionKind());
            }
            return new y0(projectionKind2, c0VarSubstitutionResult);
        }
        j1 j1Var = j1.INVARIANT;
        c0 type2 = w0Var.getType();
        j1 projectionKind3 = w0Var.getProjectionKind();
        if (type2.getConstructor().getDeclarationDescriptor() instanceof d0.e0.p.d.m0.c.z0) {
            return w0Var;
        }
        j0 abbreviation = m0.getAbbreviation(type2);
        c0 c0VarSubstitute = abbreviation != null ? replaceWithNonApproximatingSubstitution().substitute(abbreviation, j1Var) : null;
        List<d0.e0.p.d.m0.c.z0> parameters = type2.getConstructor().getParameters();
        List<w0> arguments = type2.getArguments();
        ArrayList arrayList = new ArrayList(parameters.size());
        boolean z2 = false;
        for (int i3 = 0; i3 < parameters.size(); i3++) {
            d0.e0.p.d.m0.c.z0 z0Var3 = parameters.get(i3);
            w0 w0Var2 = arguments.get(i3);
            w0 w0VarD4 = d(w0Var2, z0Var3, i + 1);
            int iH2 = b.c.a.y.b.h(b(z0Var3.getVariance(), w0VarD4.getProjectionKind()));
            if (iH2 != 0) {
                if (iH2 == 1 || iH2 == 2) {
                    w0VarD4 = e1.makeStarProjection(z0Var3);
                }
            } else if (z0Var3.getVariance() != j1Var && !w0VarD4.isStarProjection()) {
                w0VarD4 = new y0(j1Var, w0VarD4.getType());
            }
            if (w0VarD4 != w0Var2) {
                z2 = true;
            }
            arrayList.add(w0VarD4);
        }
        if (z2) {
            arguments = arrayList;
        }
        c0 c0VarReplace = a1.replace(type2, arguments, this.f3520b.filterAnnotations(type2.getAnnotations()));
        if ((c0VarReplace instanceof j0) && (c0VarSubstitute instanceof j0)) {
            c0VarReplace = m0.withAbbreviation((j0) c0VarReplace, (j0) c0VarSubstitute);
        }
        return new y0(projectionKind3, c0VarReplace);
    }

    public z0 getSubstitution() {
        z0 z0Var = this.f3520b;
        if (z0Var != null) {
            return z0Var;
        }
        a(7);
        throw null;
    }

    public boolean isEmpty() {
        return this.f3520b.isEmpty();
    }

    public c1 replaceWithNonApproximatingSubstitution() {
        z0 z0Var = this.f3520b;
        return ((z0Var instanceof z) && z0Var.approximateContravariantCapturedTypes()) ? new c1(new z(((z) this.f3520b).getParameters(), ((z) this.f3520b).getArguments(), false)) : this;
    }

    public c0 safeSubstitute(c0 c0Var, j1 j1Var) {
        if (c0Var == null) {
            a(8);
            throw null;
        }
        if (j1Var == null) {
            a(9);
            throw null;
        }
        if (isEmpty()) {
            if (c0Var != null) {
                return c0Var;
            }
            a(10);
            throw null;
        }
        try {
            c0 type = d(new y0(j1Var, c0Var), null, 0).getType();
            if (type != null) {
                return type;
            }
            a(11);
            throw null;
        } catch (c1$a e) {
            j0 j0VarCreateErrorType = t.createErrorType(e.getMessage());
            if (j0VarCreateErrorType != null) {
                return j0VarCreateErrorType;
            }
            a(12);
            throw null;
        }
    }

    public c0 substitute(c0 c0Var, j1 j1Var) {
        if (c0Var == null) {
            a(13);
            throw null;
        }
        if (j1Var == null) {
            a(14);
            throw null;
        }
        w0 w0VarSubstitute = substitute(new y0(j1Var, getSubstitution().prepareTopLevelType(c0Var, j1Var)));
        if (w0VarSubstitute == null) {
            return null;
        }
        return w0VarSubstitute.getType();
    }

    public w0 substituteWithoutApproximation(w0 w0Var) {
        if (w0Var == null) {
            a(16);
            throw null;
        }
        if (isEmpty()) {
            return w0Var;
        }
        try {
            return d(w0Var, null, 0);
        } catch (c1$a unused) {
            return null;
        }
    }

    public static c1 create(c0 c0Var) {
        if (c0Var != null) {
            return create(v0.create(c0Var.getConstructor(), c0Var.getArguments()));
        }
        a(5);
        throw null;
    }

    public static j1 combine(j1 j1Var, j1 j1Var2) {
        if (j1Var == null) {
            a(36);
            throw null;
        }
        if (j1Var2 != null) {
            j1 j1Var3 = j1.INVARIANT;
            if (j1Var == j1Var3) {
                if (j1Var2 != null) {
                    return j1Var2;
                }
                a(38);
                throw null;
            }
            if (j1Var2 == j1Var3) {
                if (j1Var != null) {
                    return j1Var;
                }
                a(39);
                throw null;
            }
            if (j1Var == j1Var2) {
                if (j1Var2 != null) {
                    return j1Var2;
                }
                a(40);
                throw null;
            }
            throw new AssertionError("Variance conflict: type parameter variance '" + j1Var + "' and projection kind '" + j1Var2 + "' cannot be combined");
        }
        a(37);
        throw null;
    }

    public w0 substitute(w0 w0Var) {
        if (w0Var != null) {
            w0 w0VarSubstituteWithoutApproximation = substituteWithoutApproximation(w0Var);
            return (this.f3520b.approximateCapturedTypes() || this.f3520b.approximateContravariantCapturedTypes()) ? d0.e0.p.d.m0.n.p1.b.approximateCapturedTypesIfNecessary(w0VarSubstituteWithoutApproximation, this.f3520b.approximateContravariantCapturedTypes()) : w0VarSubstituteWithoutApproximation;
        }
        a(15);
        throw null;
    }
}
