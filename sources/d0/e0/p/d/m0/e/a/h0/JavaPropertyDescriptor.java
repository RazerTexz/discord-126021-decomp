package d0.e0.p.d.m0.e.a.h0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ConstUtil;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.PropertySetterDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.PropertyDescriptorImpl;
import d0.e0.p.d.m0.c.i1.PropertyGetterDescriptorImpl;
import d0.e0.p.d.m0.c.i1.PropertySetterDescriptorImpl;
import d0.e0.p.d.m0.e.a.l0.typeEnhancement6;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorFactory;
import d0.e0.p.d.m0.m.storage6;
import d0.e0.p.d.m0.n.KotlinType;
import java.util.List;
import kotlin.Tuples2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h0.g, reason: use source file name */
/* JADX INFO: compiled from: JavaPropertyDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class JavaPropertyDescriptor extends PropertyDescriptorImpl implements JavaCallableMemberDescriptor {
    public final boolean J;
    public final Tuples2<CallableDescriptor.a<?>, ?> K;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaPropertyDescriptor(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, Modality modality, DescriptorVisibility2 descriptorVisibility2, boolean z2, Name name, SourceElement sourceElement, PropertyDescriptor propertyDescriptor, CallableMemberDescriptor.a aVar, boolean z3, Tuples2<CallableDescriptor.a<?>, ?> tuples2) {
        super(declarationDescriptor, propertyDescriptor, annotations4, modality, descriptorVisibility2, z2, name, aVar, sourceElement, false, false, false, false, false, false);
        if (declarationDescriptor == null) {
            a(0);
            throw null;
        }
        if (annotations4 == null) {
            a(1);
            throw null;
        }
        if (modality == null) {
            a(2);
            throw null;
        }
        if (descriptorVisibility2 == null) {
            a(3);
            throw null;
        }
        if (name == null) {
            a(4);
            throw null;
        }
        if (sourceElement == null) {
            a(5);
            throw null;
        }
        if (aVar == null) {
            a(6);
            throw null;
        }
        this.J = z3;
        this.K = tuples2;
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 21 ? 3 : 2];
        switch (i) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
        }
        if (i != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i == 21) {
            throw new IllegalStateException(str2);
        }
    }

    public static JavaPropertyDescriptor create(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, Modality modality, DescriptorVisibility2 descriptorVisibility2, boolean z2, Name name, SourceElement sourceElement, boolean z3) {
        if (declarationDescriptor == null) {
            a(7);
            throw null;
        }
        if (annotations4 == null) {
            a(8);
            throw null;
        }
        if (modality == null) {
            a(9);
            throw null;
        }
        if (descriptorVisibility2 == null) {
            a(10);
            throw null;
        }
        if (name == null) {
            a(11);
            throw null;
        }
        if (sourceElement != null) {
            return new JavaPropertyDescriptor(declarationDescriptor, annotations4, modality, descriptorVisibility2, z2, name, sourceElement, null, CallableMemberDescriptor.a.DECLARATION, z3, null);
        }
        a(12);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.PropertyDescriptorImpl
    public PropertyDescriptorImpl b(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, PropertyDescriptor propertyDescriptor, CallableMemberDescriptor.a aVar, Name name, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(13);
            throw null;
        }
        if (modality == null) {
            a(14);
            throw null;
        }
        if (descriptorVisibility2 == null) {
            a(15);
            throw null;
        }
        if (aVar == null) {
            a(16);
            throw null;
        }
        if (name != null) {
            return new JavaPropertyDescriptor(declarationDescriptor, getAnnotations(), modality, descriptorVisibility2, isVar(), name, sourceElement, propertyDescriptor, aVar, this.J, this.K);
        }
        a(17);
        throw null;
    }

    @Override // d0.e0.p.d.m0.e.a.h0.JavaCallableMemberDescriptor
    public JavaCallableMemberDescriptor enhance(KotlinType kotlinType, List<util4> list, KotlinType kotlinType2, Tuples2<CallableDescriptor.a<?>, ?> tuples2) {
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        if (list == null) {
            a(19);
            throw null;
        }
        if (kotlinType2 == null) {
            a(20);
            throw null;
        }
        PropertyDescriptor original = getOriginal() == this ? null : getOriginal();
        JavaPropertyDescriptor javaPropertyDescriptor = new JavaPropertyDescriptor(getContainingDeclaration(), getAnnotations(), getModality(), getVisibility(), isVar(), getName(), getSource(), original, getKind(), this.J, tuples2);
        PropertyGetterDescriptorImpl getter = getGetter();
        if (getter != null) {
            propertyGetterDescriptorImpl = propertyGetterDescriptorImpl;
            PropertyGetterDescriptorImpl propertyGetterDescriptorImpl2 = new PropertyGetterDescriptorImpl(javaPropertyDescriptor, getter.getAnnotations(), getter.getModality(), getter.getVisibility(), getter.isDefault(), getter.isExternal(), getter.isInline(), getKind(), original == null ? null : original.getGetter(), getter.getSource());
            propertyGetterDescriptorImpl.setInitialSignatureDescriptor(getter.getInitialSignatureDescriptor());
            propertyGetterDescriptorImpl.initialize(kotlinType2);
        } else {
            propertyGetterDescriptorImpl = null;
        }
        PropertySetterDescriptor setter = getSetter();
        if (setter != null) {
            PropertySetterDescriptorImpl propertySetterDescriptorImpl2 = new PropertySetterDescriptorImpl(javaPropertyDescriptor, setter.getAnnotations(), setter.getModality(), setter.getVisibility(), setter.isDefault(), setter.isExternal(), setter.isInline(), getKind(), original == null ? null : original.getSetter(), setter.getSource());
            propertySetterDescriptorImpl2.setInitialSignatureDescriptor(propertySetterDescriptorImpl2.getInitialSignatureDescriptor());
            propertySetterDescriptorImpl2.initialize(setter.getValueParameters().get(0));
            propertySetterDescriptorImpl = propertySetterDescriptorImpl2;
        } else {
            propertySetterDescriptorImpl = null;
        }
        javaPropertyDescriptor.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, getBackingField(), getDelegateField());
        javaPropertyDescriptor.setSetterProjectedOut(isSetterProjectedOut());
        storage6<d0.e0.p.d.m0.k.v.g<?>> storage6Var = this.p;
        if (storage6Var != null) {
            javaPropertyDescriptor.setCompileTimeInitializer(storage6Var);
        }
        javaPropertyDescriptor.setOverriddenDescriptors(getOverriddenDescriptors());
        javaPropertyDescriptor.setType(kotlinType2, getTypeParameters(), getDispatchReceiverParameter(), kotlinType == null ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(this, kotlinType, Annotations4.f.getEMPTY()));
        return javaPropertyDescriptor;
    }

    @Override // d0.e0.p.d.m0.c.i1.VariableDescriptorImpl, d0.e0.p.d.m0.c.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.PropertyDescriptorImpl, d0.e0.p.d.m0.c.VariableDescriptor
    public boolean isConst() {
        KotlinType type = getType();
        return this.J && ConstUtil.canBeUsedForConstVal(type) && (!typeEnhancement6.hasEnhancedNullability(type) || KotlinBuiltIns.isString(type));
    }
}
