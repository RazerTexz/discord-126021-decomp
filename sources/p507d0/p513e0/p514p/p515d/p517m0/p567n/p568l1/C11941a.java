package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.EnumC11289i;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11714c;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11822n;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11921f;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12010v0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11914c1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.EnumC11973b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.EnumC11989r;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11974c;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11975d;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11976e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11977f;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11981j;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11982k;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11983l;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11984m;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.a */
/* JADX INFO: compiled from: ClassicTypeCheckerContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C11941a extends AbstractC11921f implements InterfaceC11943c {

    /* JADX INFO: renamed from: e */
    public static final a f24799e = new a(null);

    /* JADX INFO: renamed from: f */
    public final boolean f24800f;

    /* JADX INFO: renamed from: g */
    public final boolean f24801g;

    /* JADX INFO: renamed from: h */
    public final boolean f24802h;

    /* JADX INFO: renamed from: i */
    public final AbstractC11947g f24803i;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.a$a */
    /* JADX INFO: compiled from: ClassicTypeCheckerContext.kt */
    public static final class a {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ClassicTypeCheckerContext.kt */
        public static final class C13337a extends AbstractC11921f.b.a {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ InterfaceC11943c f24804a;

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ C11914c1 f24805b;

            public C13337a(InterfaceC11943c interfaceC11943c, C11914c1 c11914c1) {
                this.f24804a = interfaceC11943c;
                this.f24805b = c11914c1;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11921f.b
            public InterfaceC11980i transformType(AbstractC11921f abstractC11921f, InterfaceC11979h interfaceC11979h) {
                C12238m.checkNotNullParameter(abstractC11921f, "context");
                C12238m.checkNotNullParameter(interfaceC11979h, "type");
                InterfaceC11943c interfaceC11943c = this.f24804a;
                AbstractC11913c0 abstractC11913c0SafeSubstitute = this.f24805b.safeSubstitute((AbstractC11913c0) interfaceC11943c.lowerBoundIfFlexible(interfaceC11979h), EnumC11935j1.INVARIANT);
                C12238m.checkNotNullExpressionValue(abstractC11913c0SafeSubstitute, "substitutor.safeSubstitute(\n                        type.lowerBoundIfFlexible() as KotlinType,\n                        Variance.INVARIANT\n                    )");
                InterfaceC11980i interfaceC11980iAsSimpleType = interfaceC11943c.asSimpleType(abstractC11913c0SafeSubstitute);
                C12238m.checkNotNull(interfaceC11980iAsSimpleType);
                return interfaceC11980iAsSimpleType;
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final AbstractC11921f.b.a classicSubstitutionSupertypePolicy(InterfaceC11943c interfaceC11943c, InterfaceC11980i interfaceC11980i) {
            C12238m.checkNotNullParameter(interfaceC11943c, "<this>");
            C12238m.checkNotNullParameter(interfaceC11980i, "type");
            if (interfaceC11980i instanceof AbstractC11934j0) {
                return new C13337a(interfaceC11943c, AbstractC12010v0.f24889b.create((AbstractC11913c0) interfaceC11980i).buildSubstitutor());
            }
            throw new IllegalArgumentException(C11942b.access$errorMessage(interfaceC11980i).toString());
        }
    }

    public /* synthetic */ C11941a(boolean z2, boolean z3, boolean z4, AbstractC11947g abstractC11947g, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, (i & 2) != 0 ? true : z3, (i & 4) != 0 ? true : z4, (i & 8) != 0 ? AbstractC11947g.a.f24807a : abstractC11947g);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean areEqualTypeConstructors(InterfaceC11983l interfaceC11983l, InterfaceC11983l interfaceC11983l2) {
        C12238m.checkNotNullParameter(interfaceC11983l, "c1");
        C12238m.checkNotNullParameter(interfaceC11983l2, "c2");
        if (!(interfaceC11983l instanceof InterfaceC12008u0)) {
            throw new IllegalArgumentException(C11942b.access$errorMessage(interfaceC11983l).toString());
        }
        if (interfaceC11983l2 instanceof InterfaceC12008u0) {
            return areEqualTypeConstructors((InterfaceC12008u0) interfaceC11983l, (InterfaceC12008u0) interfaceC11983l2);
        }
        throw new IllegalArgumentException(C11942b.access$errorMessage(interfaceC11983l2).toString());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public int argumentsCount(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11943c.a.argumentsCount(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11981j asArgumentList(InterfaceC11980i interfaceC11980i) {
        return InterfaceC11943c.a.asArgumentList(this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11974c asCapturedType(InterfaceC11980i interfaceC11980i) {
        return InterfaceC11943c.a.asCapturedType(this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11975d asDefinitelyNotNullType(InterfaceC11980i interfaceC11980i) {
        return InterfaceC11943c.a.asDefinitelyNotNullType(this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11976e asDynamicType(InterfaceC11977f interfaceC11977f) {
        return InterfaceC11943c.a.asDynamicType(this, interfaceC11977f);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11977f asFlexibleType(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11943c.a.asFlexibleType(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n, p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11943c
    public InterfaceC11980i asSimpleType(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11943c.a.asSimpleType(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11982k asTypeArgument(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11943c.a.asTypeArgument(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11980i captureFromArguments(InterfaceC11980i interfaceC11980i, EnumC11973b enumC11973b) {
        return InterfaceC11943c.a.captureFromArguments(this, interfaceC11980i, enumC11973b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11943c
    public InterfaceC11979h createFlexibleType(InterfaceC11980i interfaceC11980i, InterfaceC11980i interfaceC11980i2) {
        return InterfaceC11943c.a.createFlexibleType(this, interfaceC11980i, interfaceC11980i2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11982k getArgument(InterfaceC11979h interfaceC11979h, int i) {
        return InterfaceC11943c.a.getArgument(this, interfaceC11979h, i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11917d1
    public C11714c getClassFqNameUnsafe(InterfaceC11983l interfaceC11983l) {
        return InterfaceC11943c.a.getClassFqNameUnsafe(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11984m getParameter(InterfaceC11983l interfaceC11983l, int i) {
        return InterfaceC11943c.a.getParameter(this, interfaceC11983l, i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11917d1
    public EnumC11289i getPrimitiveArrayType(InterfaceC11983l interfaceC11983l) {
        return InterfaceC11943c.a.getPrimitiveArrayType(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11917d1
    public EnumC11289i getPrimitiveType(InterfaceC11983l interfaceC11983l) {
        return InterfaceC11943c.a.getPrimitiveType(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11917d1
    public InterfaceC11979h getRepresentativeUpperBound(InterfaceC11984m interfaceC11984m) {
        return InterfaceC11943c.a.getRepresentativeUpperBound(this, interfaceC11984m);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11917d1
    public InterfaceC11979h getSubstitutedUnderlyingType(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11943c.a.getSubstitutedUnderlyingType(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11979h getType(InterfaceC11982k interfaceC11982k) {
        return InterfaceC11943c.a.getType(this, interfaceC11982k);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11917d1
    public InterfaceC11984m getTypeParameterClassifier(InterfaceC11983l interfaceC11983l) {
        return InterfaceC11943c.a.getTypeParameterClassifier(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public EnumC11989r getVariance(InterfaceC11982k interfaceC11982k) {
        return InterfaceC11943c.a.getVariance(this, interfaceC11982k);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11917d1
    public boolean hasAnnotation(InterfaceC11979h interfaceC11979h, C11713b c11713b) {
        return InterfaceC11943c.a.hasAnnotation(this, interfaceC11979h, c11713b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11988q
    public boolean identicalArguments(InterfaceC11980i interfaceC11980i, InterfaceC11980i interfaceC11980i2) {
        return InterfaceC11943c.a.identicalArguments(this, interfaceC11980i, interfaceC11980i2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11979h intersectTypes(List<? extends InterfaceC11979h> list) {
        return InterfaceC11943c.a.intersectTypes(this, list);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isAnyConstructor(InterfaceC11983l interfaceC11983l) {
        return InterfaceC11943c.a.isAnyConstructor(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isClassTypeConstructor(InterfaceC11983l interfaceC11983l) {
        return InterfaceC11943c.a.isClassTypeConstructor(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isCommonFinalClassConstructor(InterfaceC11983l interfaceC11983l) {
        return InterfaceC11943c.a.isCommonFinalClassConstructor(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isDenotable(InterfaceC11983l interfaceC11983l) {
        return InterfaceC11943c.a.isDenotable(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isError(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11943c.a.isError(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11921f
    public boolean isErrorTypeEqualsToAnything() {
        return this.f24800f;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11917d1
    public boolean isInlineClass(InterfaceC11983l interfaceC11983l) {
        return InterfaceC11943c.a.isInlineClass(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isIntegerLiteralTypeConstructor(InterfaceC11983l interfaceC11983l) {
        return InterfaceC11943c.a.isIntegerLiteralTypeConstructor(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isIntersection(InterfaceC11983l interfaceC11983l) {
        return InterfaceC11943c.a.isIntersection(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isMarkedNullable(InterfaceC11980i interfaceC11980i) {
        return InterfaceC11943c.a.isMarkedNullable((InterfaceC11943c) this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isNothingConstructor(InterfaceC11983l interfaceC11983l) {
        return InterfaceC11943c.a.isNothingConstructor(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isNullableType(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11943c.a.isNullableType(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isPrimitiveType(InterfaceC11980i interfaceC11980i) {
        return InterfaceC11943c.a.isPrimitiveType(this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isProjectionNotNull(InterfaceC11974c interfaceC11974c) {
        return InterfaceC11943c.a.isProjectionNotNull(this, interfaceC11974c);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isStarProjection(InterfaceC11982k interfaceC11982k) {
        return InterfaceC11943c.a.isStarProjection(this, interfaceC11982k);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isStubType(InterfaceC11980i interfaceC11980i) {
        return InterfaceC11943c.a.isStubType(this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11921f
    public boolean isStubTypeEqualsToAnything() {
        return this.f24801g;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11917d1
    public boolean isUnderKotlinPackage(InterfaceC11983l interfaceC11983l) {
        return InterfaceC11943c.a.isUnderKotlinPackage(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n, p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11943c
    public InterfaceC11980i lowerBound(InterfaceC11977f interfaceC11977f) {
        return InterfaceC11943c.a.lowerBound(this, interfaceC11977f);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11979h lowerType(InterfaceC11974c interfaceC11974c) {
        return InterfaceC11943c.a.lowerType(this, interfaceC11974c);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11979h makeDefinitelyNotNullOrNotNull(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11943c.a.makeDefinitelyNotNullOrNotNull(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11917d1
    public InterfaceC11979h makeNullable(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11943c.a.makeNullable(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11980i original(InterfaceC11975d interfaceC11975d) {
        return InterfaceC11943c.a.original(this, interfaceC11975d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public int parametersCount(InterfaceC11983l interfaceC11983l) {
        return InterfaceC11943c.a.parametersCount(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public Collection<InterfaceC11979h> possibleIntegerTypes(InterfaceC11980i interfaceC11980i) {
        return InterfaceC11943c.a.possibleIntegerTypes(this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11921f
    public InterfaceC11979h prepareType(InterfaceC11979h interfaceC11979h) {
        C12238m.checkNotNullParameter(interfaceC11979h, "type");
        if (interfaceC11979h instanceof AbstractC11913c0) {
            return InterfaceC11952l.f24820b.getDefault().transformToNewType(((AbstractC11913c0) interfaceC11979h).unwrap());
        }
        throw new IllegalArgumentException(C11942b.access$errorMessage(interfaceC11979h).toString());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11921f
    public InterfaceC11979h refineType(InterfaceC11979h interfaceC11979h) {
        C12238m.checkNotNullParameter(interfaceC11979h, "type");
        if (interfaceC11979h instanceof AbstractC11913c0) {
            return this.f24803i.refineType((AbstractC11913c0) interfaceC11979h);
        }
        throw new IllegalArgumentException(C11942b.access$errorMessage(interfaceC11979h).toString());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public Collection<InterfaceC11979h> supertypes(InterfaceC11983l interfaceC11983l) {
        return InterfaceC11943c.a.supertypes(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n, p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11943c
    public InterfaceC11983l typeConstructor(InterfaceC11980i interfaceC11980i) {
        return InterfaceC11943c.a.typeConstructor((InterfaceC11943c) this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n, p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11943c
    public InterfaceC11980i upperBound(InterfaceC11977f interfaceC11977f) {
        return InterfaceC11943c.a.upperBound(this, interfaceC11977f);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11979h withNullability(InterfaceC11979h interfaceC11979h, boolean z2) {
        return InterfaceC11943c.a.withNullability(this, interfaceC11979h, z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public EnumC11989r getVariance(InterfaceC11984m interfaceC11984m) {
        return InterfaceC11943c.a.getVariance(this, interfaceC11984m);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11921f
    public AbstractC11921f.b.a substitutionSupertypePolicy(InterfaceC11980i interfaceC11980i) {
        C12238m.checkNotNullParameter(interfaceC11980i, "type");
        return f24799e.classicSubstitutionSupertypePolicy(this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n, p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11943c
    public InterfaceC11980i withNullability(InterfaceC11980i interfaceC11980i, boolean z2) {
        return InterfaceC11943c.a.withNullability((InterfaceC11943c) this, interfaceC11980i, z2);
    }

    public C11941a(boolean z2, boolean z3, boolean z4, AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        this.f24800f = z2;
        this.f24801g = z3;
        this.f24802h = z4;
        this.f24803i = abstractC11947g;
    }

    public boolean areEqualTypeConstructors(InterfaceC12008u0 interfaceC12008u0, InterfaceC12008u0 interfaceC12008u1) {
        C12238m.checkNotNullParameter(interfaceC12008u0, "a");
        C12238m.checkNotNullParameter(interfaceC12008u1, "b");
        if (interfaceC12008u0 instanceof C11822n) {
            return ((C11822n) interfaceC12008u0).checkConstructor(interfaceC12008u1);
        }
        return interfaceC12008u1 instanceof C11822n ? ((C11822n) interfaceC12008u1).checkConstructor(interfaceC12008u0) : C12238m.areEqual(interfaceC12008u0, interfaceC12008u1);
    }
}
