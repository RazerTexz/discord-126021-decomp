package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassConstructorDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ConstructorDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptorVisitor;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.n.TypeSubstitutor2;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.g, reason: use source file name */
/* JADX INFO: compiled from: ClassConstructorDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class ClassConstructorDescriptorImpl extends FunctionDescriptorImpl implements ClassConstructorDescriptor {
    public static final Name M = Name.special("<init>");
    public final boolean N;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassConstructorDescriptorImpl(ClassDescriptor classDescriptor, ConstructorDescriptor constructorDescriptor, Annotations4 annotations4, boolean z2, CallableMemberDescriptor.a aVar, SourceElement sourceElement) {
        super(classDescriptor, constructorDescriptor, annotations4, M, aVar, sourceElement);
        if (classDescriptor == null) {
            a(0);
            throw null;
        }
        if (annotations4 == null) {
            a(1);
            throw null;
        }
        if (aVar == null) {
            a(2);
            throw null;
        }
        if (sourceElement == null) {
            a(3);
            throw null;
        }
        this.N = z2;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001a  */
    /* JADX WARN: Code duplicated, block: B:7:0x000e  */
    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (i != 19 && i != 25) {
            switch (i) {
                case 15:
                case 16:
                case 17:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 19 && i != 25) {
            switch (i) {
                case 15:
                case 16:
                case 17:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 5:
            case 8:
            case 23:
                objArr[0] = "annotations";
                break;
            case 2:
            case 22:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 9:
            case 24:
                objArr[0] = "source";
                break;
            case 4:
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 13:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
            case 14:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "typeParameterDescriptors";
                break;
            case 15:
            case 16:
            case 17:
            case 19:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                break;
            case 18:
                objArr[0] = "originalSubstitutor";
                break;
            case 20:
                objArr[0] = "overriddenDescriptors";
                break;
            case 21:
                objArr[0] = "newOwner";
                break;
        }
        if (i == 19) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i != 25) {
            switch (i) {
                case 15:
                    objArr[1] = "getContainingDeclaration";
                    break;
                case 16:
                    objArr[1] = "getConstructedClass";
                    break;
                case 17:
                    objArr[1] = "getOriginal";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                    break;
            }
        } else {
            objArr[1] = "copy";
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "create";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSynthesized";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                objArr[2] = "initialize";
                break;
            case 15:
            case 16:
            case 17:
            case 19:
            case 25:
                break;
            case 18:
                objArr[2] = "substitute";
                break;
            case 20:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 21:
            case 22:
            case 23:
            case 24:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 19 && i != 25) {
            switch (i) {
                case 15:
                case 16:
                case 17:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    public static ClassConstructorDescriptorImpl create(ClassDescriptor classDescriptor, Annotations4 annotations4, boolean z2, SourceElement sourceElement) {
        if (classDescriptor == null) {
            a(4);
            throw null;
        }
        if (annotations4 == null) {
            a(5);
            throw null;
        }
        if (sourceElement != null) {
            return new ClassConstructorDescriptorImpl(classDescriptor, null, annotations4, z2, CallableMemberDescriptor.a.DECLARATION, sourceElement);
        }
        a(6);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitConstructorDescriptor(this, d);
    }

    public ReceiverParameterDescriptor calculateDispatchReceiverParameter() {
        ClassDescriptor containingDeclaration = getContainingDeclaration();
        if (!containingDeclaration.isInner()) {
            return null;
        }
        DeclarationDescriptor containingDeclaration2 = containingDeclaration.getContainingDeclaration();
        if (containingDeclaration2 instanceof ClassDescriptor) {
            return ((ClassDescriptor) containingDeclaration2).getThisAsReceiverParameter();
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ClassConstructorDescriptorImpl b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(21);
            throw null;
        }
        if (aVar == null) {
            a(22);
            throw null;
        }
        if (annotations4 == null) {
            a(23);
            throw null;
        }
        if (sourceElement == null) {
            a(24);
            throw null;
        }
        CallableMemberDescriptor.a aVar2 = CallableMemberDescriptor.a.DECLARATION;
        if (aVar == aVar2 || aVar == CallableMemberDescriptor.a.SYNTHESIZED) {
            return new ClassConstructorDescriptorImpl((ClassDescriptor) declarationDescriptor, this, annotations4, this.N, aVar2, sourceElement);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + declarationDescriptor + "\nkind: " + aVar);
    }

    @Override // d0.e0.p.d.m0.c.ConstructorDescriptor
    public ClassDescriptor getConstructedClass() {
        ClassDescriptor containingDeclaration = getContainingDeclaration();
        if (containingDeclaration != null) {
            return containingDeclaration;
        }
        a(16);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.FunctionDescriptor, d0.e0.p.d.m0.c.CallableMemberDescriptor, d0.e0.p.d.m0.c.CallableDescriptor
    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet != null) {
            return setEmptySet;
        }
        a(19);
        throw null;
    }

    public ClassConstructorDescriptorImpl initialize(List<ValueParameterDescriptor> list, DescriptorVisibility2 descriptorVisibility2, List<TypeParameterDescriptor> list2) {
        if (list == null) {
            a(10);
            throw null;
        }
        if (descriptorVisibility2 == null) {
            a(11);
            throw null;
        }
        if (list2 != null) {
            initialize(null, calculateDispatchReceiverParameter(), list2, list, null, Modality.FINAL, descriptorVisibility2);
            return this;
        }
        a(12);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ConstructorDescriptor
    public boolean isPrimary() {
        return this.N;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.CallableMemberDescriptor
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection != null) {
            return;
        }
        a(20);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.CallableMemberDescriptor
    public ClassConstructorDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, CallableMemberDescriptor.a aVar, boolean z2) {
        ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) super.copy(declarationDescriptor, modality, descriptorVisibility2, aVar, z2);
        if (classConstructorDescriptor != null) {
            return classConstructorDescriptor;
        }
        a(25);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.DeclarationDescriptorNonRootImpl, d0.e0.p.d.m0.c.DeclarationDescriptor
    public ClassDescriptor getContainingDeclaration() {
        ClassDescriptor classDescriptor = (ClassDescriptor) super.getContainingDeclaration();
        if (classDescriptor != null) {
            return classDescriptor;
        }
        a(15);
        throw null;
    }

    public ClassConstructorDescriptorImpl initialize(List<ValueParameterDescriptor> list, DescriptorVisibility2 descriptorVisibility2) {
        if (list == null) {
            a(13);
            throw null;
        }
        if (descriptorVisibility2 != null) {
            initialize(list, descriptorVisibility2, getContainingDeclaration().getDeclaredTypeParameters());
            return this;
        }
        a(14);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.FunctionDescriptor, d0.e0.p.d.m0.c.Substitutable
    public ClassConstructorDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        if (typeSubstitutor2 != null) {
            return (ClassConstructorDescriptor) super.substitute(typeSubstitutor2);
        }
        a(18);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.i1.DeclarationDescriptorNonRootImpl, d0.e0.p.d.m0.c.i1.DeclarationDescriptorImpl, d0.e0.p.d.m0.c.DeclarationDescriptor
    public ClassConstructorDescriptor getOriginal() {
        ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) super.getOriginal();
        if (classConstructorDescriptor != null) {
            return classConstructorDescriptor;
        }
        a(17);
        throw null;
    }
}
