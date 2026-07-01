package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.ClassConstructorDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptorVisitor;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.a0.SubstitutingScope;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.m.LockBasedStorageManager;
import d0.e0.p.d.m0.n.ClassTypeConstructorImpl;
import d0.e0.p.d.m0.n.DescriptorSubstitutor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeSubstitution5;
import d0.e0.p.d.m0.n.TypeSubstitutor2;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.t._Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.t, reason: use source file name */
/* JADX INFO: compiled from: LazySubstitutingClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class LazySubstitutingClassDescriptor extends ModuleAwareClassDescriptor {
    public final ModuleAwareClassDescriptor k;
    public final TypeSubstitutor2 l;
    public TypeSubstitutor2 m;
    public List<TypeParameterDescriptor> n;
    public List<TypeParameterDescriptor> o;
    public TypeConstructor p;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.t$a */
    /* JADX INFO: compiled from: LazySubstitutingClassDescriptor.java */
    public class a implements Function1<TypeParameterDescriptor, Boolean> {
        public a(LazySubstitutingClassDescriptor lazySubstitutingClassDescriptor) {
        }

        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(TypeParameterDescriptor typeParameterDescriptor) {
            return Boolean.valueOf(!typeParameterDescriptor.isCapturedFromOuterDeclaration());
        }
    }

    public LazySubstitutingClassDescriptor(ModuleAwareClassDescriptor moduleAwareClassDescriptor, TypeSubstitutor2 typeSubstitutor2) {
        this.k = moduleAwareClassDescriptor;
        this.l = typeSubstitutor2;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0051  */
    /* JADX WARN: Code duplicated, block: B:35:0x0056  */
    /* JADX WARN: Code duplicated, block: B:36:0x005b  */
    public static /* synthetic */ void a(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10 || i == 13 || i == 22) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10 || i == 13 || i == 22) ? 3 : 2];
        if (i == 2) {
            objArr[0] = "typeArguments";
        } else if (i == 3) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i == 5) {
            objArr[0] = "typeSubstitution";
        } else if (i == 6) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i == 8) {
            objArr[0] = "typeArguments";
        } else if (i == 10) {
            objArr[0] = "typeSubstitution";
        } else if (i == 13) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i != 22) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
        } else {
            objArr[0] = "substitutor";
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 10:
            case 13:
            case 22:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 11:
                objArr[1] = "getMemberScope";
                break;
            case 12:
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getDefaultType";
                break;
            case 17:
                objArr[1] = "getConstructors";
                break;
            case 18:
                objArr[1] = "getAnnotations";
                break;
            case 19:
                objArr[1] = "getName";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case 21:
                objArr[1] = "getContainingDeclaration";
                break;
            case 23:
                objArr[1] = "substitute";
                break;
            case 24:
                objArr[1] = "getKind";
                break;
            case 25:
                objArr[1] = "getModality";
                break;
            case 26:
                objArr[1] = "getVisibility";
                break;
            case 27:
                objArr[1] = "getUnsubstitutedInnerClassesScope";
                break;
            case 28:
                objArr[1] = "getSource";
                break;
            case 29:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 30:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "getTypeConstructor";
                break;
        }
        if (i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10) {
            objArr[2] = "getMemberScope";
        } else if (i == 13) {
            objArr[2] = "getUnsubstitutedMemberScope";
        } else if (i == 22) {
            objArr[2] = "substitute";
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6 && i != 8 && i != 10 && i != 13 && i != 22) {
            throw new IllegalStateException(str2);
        }
        throw new IllegalArgumentException(str2);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitClassDescriptor(this, d);
    }

    public final TypeSubstitutor2 b() {
        if (this.m == null) {
            if (this.l.isEmpty()) {
                this.m = this.l;
            } else {
                List<TypeParameterDescriptor> parameters = this.k.getTypeConstructor().getParameters();
                this.n = new ArrayList(parameters.size());
                this.m = DescriptorSubstitutor.substituteTypeParameters(parameters, this.l.getSubstitution(), this, this.n);
                this.o = _Collections.filter(this.n, new a(this));
            }
        }
        return this.m;
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations3
    public Annotations4 getAnnotations() {
        Annotations4 annotations = this.k.getAnnotations();
        if (annotations != null) {
            return annotations;
        }
        a(18);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public ClassDescriptor getCompanionObjectDescriptor() {
        return this.k.getCompanionObjectDescriptor();
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public Collection<ClassConstructorDescriptor> getConstructors() {
        Collection<ClassConstructorDescriptor> constructors = this.k.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.size());
        for (ClassConstructorDescriptor classConstructorDescriptor : constructors) {
            arrayList.add(((ClassConstructorDescriptor) classConstructorDescriptor.newCopyBuilder().setOriginal(classConstructorDescriptor.getOriginal()).setModality(classConstructorDescriptor.getModality()).setVisibility(classConstructorDescriptor.getVisibility()).setKind(classConstructorDescriptor.getKind()).setCopyOverrides(false).build()).substitute(b()));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.DeclarationDescriptorNonRoot, d0.e0.p.d.m0.c.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor containingDeclaration = this.k.getContainingDeclaration();
        if (containingDeclaration != null) {
            return containingDeclaration;
        }
        a(21);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        b();
        List<TypeParameterDescriptor> list = this.o;
        if (list != null) {
            return list;
        }
        a(29);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.ClassifierDescriptor
    public KotlinType4 getDefaultType() {
        KotlinType4 kotlinType4SimpleTypeWithNonTrivialMemberScope = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(getAnnotations(), getTypeConstructor(), TypeUtils.getDefaultTypeProjections(getTypeConstructor().getParameters()), false, getUnsubstitutedMemberScope());
        if (kotlinType4SimpleTypeWithNonTrivialMemberScope != null) {
            return kotlinType4SimpleTypeWithNonTrivialMemberScope;
        }
        a(16);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public ClassKind getKind() {
        ClassKind kind = this.k.getKind();
        if (kind != null) {
            return kind;
        }
        a(24);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.ModuleAwareClassDescriptor
    public MemberScope3 getMemberScope(TypeSubstitution5 typeSubstitution5, KotlinTypeRefiner kotlinTypeRefiner) {
        if (typeSubstitution5 == null) {
            a(5);
            throw null;
        }
        if (kotlinTypeRefiner == null) {
            a(6);
            throw null;
        }
        MemberScope3 memberScope = this.k.getMemberScope(typeSubstitution5, kotlinTypeRefiner);
        if (!this.l.isEmpty()) {
            return new SubstitutingScope(memberScope, b());
        }
        if (memberScope != null) {
            return memberScope;
        }
        a(7);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.MemberDescriptor
    public Modality getModality() {
        Modality modality = this.k.getModality();
        if (modality != null) {
            return modality;
        }
        a(25);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public Name getName() {
        Name name = this.k.getName();
        if (name != null) {
            return name;
        }
        a(19);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        Collection<ClassDescriptor> sealedSubclasses = this.k.getSealedSubclasses();
        if (sealedSubclasses != null) {
            return sealedSubclasses;
        }
        a(30);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return SourceElement.a;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public MemberScope3 getStaticScope() {
        MemberScope3 staticScope = this.k.getStaticScope();
        if (staticScope != null) {
            return staticScope;
        }
        a(15);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        throw new UnsupportedOperationException();
    }

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor = this.k.getTypeConstructor();
        if (this.l.isEmpty()) {
            if (typeConstructor != null) {
                return typeConstructor;
            }
            a(0);
            throw null;
        }
        if (this.p == null) {
            TypeSubstitutor2 typeSubstitutor2B = b();
            Collection<KotlinType> supertypes = typeConstructor.getSupertypes();
            ArrayList arrayList = new ArrayList(supertypes.size());
            Iterator<KotlinType> it = supertypes.iterator();
            while (it.hasNext()) {
                arrayList.add(typeSubstitutor2B.substitute(it.next(), Variance.INVARIANT));
            }
            this.p = new ClassTypeConstructorImpl(this, this.n, arrayList, LockBasedStorageManager.f3514b);
        }
        TypeConstructor typeConstructor2 = this.p;
        if (typeConstructor2 != null) {
            return typeConstructor2;
        }
        a(1);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public MemberScope3 getUnsubstitutedInnerClassesScope() {
        MemberScope3 unsubstitutedInnerClassesScope = this.k.getUnsubstitutedInnerClassesScope();
        if (unsubstitutedInnerClassesScope != null) {
            return unsubstitutedInnerClassesScope;
        }
        a(27);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public MemberScope3 getUnsubstitutedMemberScope() {
        MemberScope3 unsubstitutedMemberScope = getUnsubstitutedMemberScope(DescriptorUtils2.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this.k)));
        if (unsubstitutedMemberScope != null) {
            return unsubstitutedMemberScope;
        }
        a(12);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return this.k.getUnsubstitutedPrimaryConstructor();
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.DeclarationDescriptorWithVisibility, d0.e0.p.d.m0.c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        DescriptorVisibility2 visibility = this.k.getVisibility();
        if (visibility != null) {
            return visibility;
        }
        a(26);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isActual() {
        return this.k.isActual();
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isCompanionObject() {
        return this.k.isCompanionObject();
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isData() {
        return this.k.isData();
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isExpect() {
        return this.k.isExpect();
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isExternal() {
        return this.k.isExternal();
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isFun() {
        return this.k.isFun();
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isInline() {
        return this.k.isInline();
    }

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return this.k.isInner();
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isValue() {
        return this.k.isValue();
    }

    @Override // d0.e0.p.d.m0.c.i1.ModuleAwareClassDescriptor
    public MemberScope3 getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            a(13);
            throw null;
        }
        MemberScope3 unsubstitutedMemberScope = this.k.getUnsubstitutedMemberScope(kotlinTypeRefiner);
        if (!this.l.isEmpty()) {
            return new SubstitutingScope(unsubstitutedMemberScope, b());
        }
        if (unsubstitutedMemberScope != null) {
            return unsubstitutedMemberScope;
        }
        a(14);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.Substitutable
    public ClassDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        if (typeSubstitutor2 != null) {
            return typeSubstitutor2.isEmpty() ? this : new LazySubstitutingClassDescriptor(this, TypeSubstitutor2.createChainedSubstitutor(typeSubstitutor2.getSubstitution(), b().getSubstitution()));
        }
        a(22);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public ClassDescriptor getOriginal() {
        ClassDescriptor original = this.k.getOriginal();
        if (original != null) {
            return original;
        }
        a(20);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public MemberScope3 getMemberScope(TypeSubstitution5 typeSubstitution5) {
        if (typeSubstitution5 != null) {
            MemberScope3 memberScope = getMemberScope(typeSubstitution5, DescriptorUtils2.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
            if (memberScope != null) {
                return memberScope;
            }
            a(11);
            throw null;
        }
        a(10);
        throw null;
    }
}
