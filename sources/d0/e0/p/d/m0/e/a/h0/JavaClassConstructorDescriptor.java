package d0.e0.p.d.m0.e.a.h0;

import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.ClassConstructorDescriptorImpl;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorFactory;
import d0.e0.p.d.m0.n.KotlinType;
import java.util.List;
import kotlin.Tuples2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h0.c, reason: use source file name */
/* JADX INFO: compiled from: JavaClassConstructorDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class JavaClassConstructorDescriptor extends ClassConstructorDescriptorImpl implements JavaCallableMemberDescriptor {
    public Boolean O;
    public Boolean P;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaClassConstructorDescriptor(ClassDescriptor classDescriptor, JavaClassConstructorDescriptor javaClassConstructorDescriptor, Annotations4 annotations4, boolean z2, CallableMemberDescriptor.a aVar, SourceElement sourceElement) {
        super(classDescriptor, javaClassConstructorDescriptor, annotations4, z2, aVar, sourceElement);
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
        this.O = null;
        this.P = null;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 11 || i == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 11 || i == 18) ? 2 : 3];
        switch (i) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 11 && i != 18) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static JavaClassConstructorDescriptor createJavaConstructor(ClassDescriptor classDescriptor, Annotations4 annotations4, boolean z2, SourceElement sourceElement) {
        if (classDescriptor == null) {
            a(4);
            throw null;
        }
        if (annotations4 == null) {
            a(5);
            throw null;
        }
        if (sourceElement != null) {
            return new JavaClassConstructorDescriptor(classDescriptor, null, annotations4, z2, CallableMemberDescriptor.a.DECLARATION, sourceElement);
        }
        a(6);
        throw null;
    }

    @Override // d0.e0.p.d.m0.e.a.h0.JavaCallableMemberDescriptor
    public /* bridge */ /* synthetic */ JavaCallableMemberDescriptor enhance(KotlinType kotlinType, List list, KotlinType kotlinType2, Tuples2 tuples2) {
        return enhance(kotlinType, (List<util4>) list, kotlinType2, (Tuples2<CallableDescriptor.a<?>, ?>) tuples2);
    }

    @Override // d0.e0.p.d.m0.c.i1.ClassConstructorDescriptorImpl
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public JavaClassConstructorDescriptor b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(7);
            throw null;
        }
        if (aVar == null) {
            a(8);
            throw null;
        }
        if (annotations4 == null) {
            a(9);
            throw null;
        }
        if (sourceElement == null) {
            a(10);
            throw null;
        }
        if (aVar != CallableMemberDescriptor.a.DECLARATION && aVar != CallableMemberDescriptor.a.SYNTHESIZED) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + declarationDescriptor + "\nkind: " + aVar);
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        JavaClassConstructorDescriptor javaClassConstructorDescriptor = (JavaClassConstructorDescriptor) functionDescriptor;
        if (classDescriptor == null) {
            a(12);
            throw null;
        }
        if (aVar == null) {
            a(13);
            throw null;
        }
        if (sourceElement == null) {
            a(14);
            throw null;
        }
        if (annotations4 == null) {
            a(15);
            throw null;
        }
        JavaClassConstructorDescriptor javaClassConstructorDescriptor2 = new JavaClassConstructorDescriptor(classDescriptor, javaClassConstructorDescriptor, annotations4, this.N, aVar, sourceElement);
        javaClassConstructorDescriptor2.setHasStableParameterNames(hasStableParameterNames());
        javaClassConstructorDescriptor2.setHasSynthesizedParameterNames(hasSynthesizedParameterNames());
        return javaClassConstructorDescriptor2;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl
    public boolean hasStableParameterNames() {
        return this.O.booleanValue();
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.P.booleanValue();
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl
    public void setHasStableParameterNames(boolean z2) {
        this.O = Boolean.valueOf(z2);
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl
    public void setHasSynthesizedParameterNames(boolean z2) {
        this.P = Boolean.valueOf(z2);
    }

    @Override // d0.e0.p.d.m0.e.a.h0.JavaCallableMemberDescriptor
    public JavaClassConstructorDescriptor enhance(KotlinType kotlinType, List<util4> list, KotlinType kotlinType2, Tuples2<CallableDescriptor.a<?>, ?> tuples2) {
        if (list == null) {
            a(16);
            throw null;
        }
        if (kotlinType2 == null) {
            a(17);
            throw null;
        }
        JavaClassConstructorDescriptor javaClassConstructorDescriptorB = b(getContainingDeclaration(), null, getKind(), null, getAnnotations(), getSource());
        javaClassConstructorDescriptorB.initialize(kotlinType != null ? DescriptorFactory.createExtensionReceiverParameterForCallable(javaClassConstructorDescriptorB, kotlinType, Annotations4.f.getEMPTY()) : null, getDispatchReceiverParameter(), getTypeParameters(), util3.copyValueParameters(list, getValueParameters(), javaClassConstructorDescriptorB), kotlinType2, getModality(), getVisibility());
        if (tuples2 != null) {
            javaClassConstructorDescriptorB.putInUserDataMap(tuples2.getFirst(), tuples2.getSecond());
        }
        return javaClassConstructorDescriptorB;
    }
}
