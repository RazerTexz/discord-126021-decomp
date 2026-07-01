package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.ClassConstructorDescriptorImpl;
import d0.e0.p.d.m0.c.i1.PropertyGetterDescriptorImpl;
import d0.e0.p.d.m0.c.i1.PropertySetterDescriptorImpl;
import d0.e0.p.d.m0.c.i1.ReceiverParameterDescriptorImpl;
import d0.e0.p.d.m0.c.i1.SimpleFunctionDescriptorImpl;
import d0.e0.p.d.m0.c.i1.ValueParameterDescriptorImpl;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.p.ExtensionReceiver;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.Variance;
import java.util.Collections;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.d, reason: use source file name */
/* JADX INFO: compiled from: DescriptorFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class DescriptorFactory {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.d$a */
    /* JADX INFO: compiled from: DescriptorFactory.java */
    public static class a extends ClassConstructorDescriptorImpl {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ClassDescriptor classDescriptor, SourceElement sourceElement, boolean z2) {
            super(classDescriptor, null, Annotations4.f.getEMPTY(), true, CallableMemberDescriptor.a.DECLARATION, sourceElement);
            if (classDescriptor == null) {
                a(0);
                throw null;
            }
            if (sourceElement == null) {
                a(1);
                throw null;
            }
            initialize(Collections.emptyList(), DescriptorUtils.getDefaultConstructorVisibility(classDescriptor, z2));
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "containingClass";
            } else {
                objArr[0] = "source";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 12 || i == 23 || i == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 12 || i == 23 || i == 25) ? 2 : 3];
        switch (i) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case 18:
            case 30:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case 15:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case 23:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case 21:
                objArr[0] = "source";
                break;
            case 22:
            case 24:
                objArr[0] = "enumClass";
                break;
            case 26:
            case 27:
            case 28:
                objArr[0] = "descriptor";
                break;
            case 29:
                objArr[0] = "owner";
                break;
        }
        if (i == 12) {
            objArr[1] = "createSetter";
        } else if (i == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case 23:
            case 25:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case 21:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case 22:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 27:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 28:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 29:
            case 30:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 12 && i != 23 && i != 25) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static boolean b(FunctionDescriptor functionDescriptor) {
        return functionDescriptor.getKind() == CallableMemberDescriptor.a.SYNTHESIZED && DescriptorUtils.isEnumClass(functionDescriptor.getContainingDeclaration());
    }

    public static PropertyGetterDescriptorImpl createDefaultGetter(PropertyDescriptor propertyDescriptor, Annotations4 annotations4) {
        if (propertyDescriptor == null) {
            a(13);
            throw null;
        }
        if (annotations4 != null) {
            return createGetter(propertyDescriptor, annotations4, true, false, false);
        }
        a(14);
        throw null;
    }

    public static PropertySetterDescriptorImpl createDefaultSetter(PropertyDescriptor propertyDescriptor, Annotations4 annotations4, Annotations4 annotations5) {
        if (propertyDescriptor == null) {
            a(0);
            throw null;
        }
        if (annotations4 == null) {
            a(1);
            throw null;
        }
        if (annotations5 != null) {
            return createSetter(propertyDescriptor, annotations4, annotations5, true, false, false, propertyDescriptor.getSource());
        }
        a(2);
        throw null;
    }

    public static SimpleFunctionDescriptor createEnumValueOfMethod(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            a(24);
            throw null;
        }
        Annotations4.a aVar = Annotations4.f;
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImplCreate = SimpleFunctionDescriptorImpl.create(classDescriptor, aVar.getEMPTY(), StandardNames.c, CallableMemberDescriptor.a.SYNTHESIZED, classDescriptor.getSource());
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImplInitialize = simpleFunctionDescriptorImplCreate.initialize((ReceiverParameterDescriptor) null, (ReceiverParameterDescriptor) null, Collections.emptyList(), Collections.singletonList(new ValueParameterDescriptorImpl(simpleFunctionDescriptorImplCreate, null, 0, aVar.getEMPTY(), Name.identifier("value"), DescriptorUtils2.getBuiltIns(classDescriptor).getStringType(), false, false, false, null, classDescriptor.getSource())), (KotlinType) classDescriptor.getDefaultType(), Modality.FINAL, DescriptorVisibilities.e);
        if (simpleFunctionDescriptorImplInitialize != null) {
            return simpleFunctionDescriptorImplInitialize;
        }
        a(25);
        throw null;
    }

    public static SimpleFunctionDescriptor createEnumValuesMethod(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            a(22);
            throw null;
        }
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImplInitialize = SimpleFunctionDescriptorImpl.create(classDescriptor, Annotations4.f.getEMPTY(), StandardNames.f3215b, CallableMemberDescriptor.a.SYNTHESIZED, classDescriptor.getSource()).initialize((ReceiverParameterDescriptor) null, (ReceiverParameterDescriptor) null, Collections.emptyList(), Collections.emptyList(), (KotlinType) DescriptorUtils2.getBuiltIns(classDescriptor).getArrayType(Variance.INVARIANT, classDescriptor.getDefaultType()), Modality.FINAL, DescriptorVisibilities.e);
        if (simpleFunctionDescriptorImplInitialize != null) {
            return simpleFunctionDescriptorImplInitialize;
        }
        a(23);
        throw null;
    }

    public static ReceiverParameterDescriptor createExtensionReceiverParameterForCallable(CallableDescriptor callableDescriptor, KotlinType kotlinType, Annotations4 annotations4) {
        if (callableDescriptor == null) {
            a(29);
            throw null;
        }
        if (annotations4 == null) {
            a(30);
            throw null;
        }
        if (kotlinType == null) {
            return null;
        }
        return new ReceiverParameterDescriptorImpl(callableDescriptor, new ExtensionReceiver(callableDescriptor, kotlinType, null), annotations4);
    }

    public static PropertyGetterDescriptorImpl createGetter(PropertyDescriptor propertyDescriptor, Annotations4 annotations4, boolean z2, boolean z3, boolean z4) {
        if (propertyDescriptor == null) {
            a(15);
            throw null;
        }
        if (annotations4 != null) {
            return createGetter(propertyDescriptor, annotations4, z2, z3, z4, propertyDescriptor.getSource());
        }
        a(16);
        throw null;
    }

    public static ClassConstructorDescriptorImpl createPrimaryConstructorForObject(ClassDescriptor classDescriptor, SourceElement sourceElement) {
        if (classDescriptor == null) {
            a(20);
            throw null;
        }
        if (sourceElement != null) {
            return new a(classDescriptor, sourceElement, false);
        }
        a(21);
        throw null;
    }

    public static PropertySetterDescriptorImpl createSetter(PropertyDescriptor propertyDescriptor, Annotations4 annotations4, Annotations4 annotations5, boolean z2, boolean z3, boolean z4, SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            a(3);
            throw null;
        }
        if (annotations4 == null) {
            a(4);
            throw null;
        }
        if (annotations5 == null) {
            a(5);
            throw null;
        }
        if (sourceElement != null) {
            return createSetter(propertyDescriptor, annotations4, annotations5, z2, z3, z4, propertyDescriptor.getVisibility(), sourceElement);
        }
        a(6);
        throw null;
    }

    public static boolean isEnumValueOfMethod(FunctionDescriptor functionDescriptor) {
        if (functionDescriptor != null) {
            return functionDescriptor.getName().equals(StandardNames.c) && b(functionDescriptor);
        }
        a(27);
        throw null;
    }

    public static boolean isEnumValuesMethod(FunctionDescriptor functionDescriptor) {
        if (functionDescriptor != null) {
            return functionDescriptor.getName().equals(StandardNames.f3215b) && b(functionDescriptor);
        }
        a(26);
        throw null;
    }

    public static PropertyGetterDescriptorImpl createGetter(PropertyDescriptor propertyDescriptor, Annotations4 annotations4, boolean z2, boolean z3, boolean z4, SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            a(17);
            throw null;
        }
        if (annotations4 == null) {
            a(18);
            throw null;
        }
        if (sourceElement != null) {
            return new PropertyGetterDescriptorImpl(propertyDescriptor, annotations4, propertyDescriptor.getModality(), propertyDescriptor.getVisibility(), z2, z3, z4, CallableMemberDescriptor.a.DECLARATION, null, sourceElement);
        }
        a(19);
        throw null;
    }

    public static PropertySetterDescriptorImpl createSetter(PropertyDescriptor propertyDescriptor, Annotations4 annotations4, Annotations4 annotations5, boolean z2, boolean z3, boolean z4, DescriptorVisibility2 descriptorVisibility2, SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            a(7);
            throw null;
        }
        if (annotations4 == null) {
            a(8);
            throw null;
        }
        if (annotations5 == null) {
            a(9);
            throw null;
        }
        if (descriptorVisibility2 == null) {
            a(10);
            throw null;
        }
        if (sourceElement != null) {
            PropertySetterDescriptorImpl propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(propertyDescriptor, annotations4, propertyDescriptor.getModality(), descriptorVisibility2, z2, z3, z4, CallableMemberDescriptor.a.DECLARATION, null, sourceElement);
            propertySetterDescriptorImpl.initialize(PropertySetterDescriptorImpl.createSetterParameter(propertySetterDescriptorImpl, propertyDescriptor.getType(), annotations5));
            return propertySetterDescriptorImpl;
        }
        a(11);
        throw null;
    }
}
