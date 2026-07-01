package d0.e0.p.d.m0.c.i1;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptorVisitor;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.PropertySetterDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.e0, reason: use source file name */
/* JADX INFO: compiled from: PropertySetterDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class PropertySetterDescriptorImpl extends PropertyAccessorDescriptorImpl implements PropertySetterDescriptor {
    public ValueParameterDescriptor v;
    public final PropertySetterDescriptor w;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public PropertySetterDescriptorImpl(PropertyDescriptor propertyDescriptor, Annotations4 annotations4, Modality modality, DescriptorVisibility2 descriptorVisibility2, boolean z2, boolean z3, boolean z4, CallableMemberDescriptor.a aVar, PropertySetterDescriptor propertySetterDescriptor, SourceElement sourceElement) {
        PropertySetterDescriptor propertySetterDescriptor2;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        if (propertyDescriptor == null) {
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
        if (aVar == null) {
            a(4);
            throw null;
        }
        if (sourceElement == null) {
            a(5);
            throw null;
        }
        StringBuilder sbU = outline.U("<set-");
        sbU.append(propertyDescriptor.getName());
        sbU.append(">");
        super(modality, descriptorVisibility2, propertyDescriptor, annotations4, Name.special(sbU.toString()), z2, z3, z4, aVar, sourceElement);
        if (propertySetterDescriptor != null) {
            propertySetterDescriptorImpl = this;
            propertySetterDescriptor2 = propertySetterDescriptor;
        } else {
            propertySetterDescriptor2 = this;
            propertySetterDescriptorImpl = propertySetterDescriptor2;
        }
        propertySetterDescriptorImpl.w = propertySetterDescriptor2;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 9:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static ValueParameterDescriptorImpl createSetterParameter(PropertySetterDescriptor propertySetterDescriptor, KotlinType kotlinType, Annotations4 annotations4) {
        if (propertySetterDescriptor == null) {
            a(7);
            throw null;
        }
        if (kotlinType == null) {
            a(8);
            throw null;
        }
        if (annotations4 != null) {
            return new ValueParameterDescriptorImpl(propertySetterDescriptor, null, 0, annotations4, Name.special("<set-?>"), kotlinType, false, false, false, null, SourceElement.a);
        }
        a(9);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitPropertySetterDescriptor(this, d);
    }

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor, d0.e0.p.d.m0.c.CallableMemberDescriptor, d0.e0.p.d.m0.c.CallableDescriptor
    public Collection<? extends PropertySetterDescriptor> getOverriddenDescriptors() {
        return b(false);
    }

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    public KotlinType getReturnType() {
        KotlinType4 unitType = DescriptorUtils2.getBuiltIns(this).getUnitType();
        if (unitType != null) {
            return unitType;
        }
        a(12);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    public List<ValueParameterDescriptor> getValueParameters() {
        ValueParameterDescriptor valueParameterDescriptor = this.v;
        if (valueParameterDescriptor == null) {
            throw new IllegalStateException();
        }
        List<ValueParameterDescriptor> listSingletonList = Collections.singletonList(valueParameterDescriptor);
        if (listSingletonList != null) {
            return listSingletonList;
        }
        a(11);
        throw null;
    }

    public void initialize(ValueParameterDescriptor valueParameterDescriptor) {
        if (valueParameterDescriptor != null) {
            this.v = valueParameterDescriptor;
        } else {
            a(6);
            throw null;
        }
    }

    @Override // d0.e0.p.d.m0.c.i1.PropertyAccessorDescriptorImpl, d0.e0.p.d.m0.c.i1.DeclarationDescriptorNonRootImpl, d0.e0.p.d.m0.c.i1.DeclarationDescriptorImpl, d0.e0.p.d.m0.c.DeclarationDescriptor
    public PropertySetterDescriptor getOriginal() {
        PropertySetterDescriptor propertySetterDescriptor = this.w;
        if (propertySetterDescriptor != null) {
            return propertySetterDescriptor;
        }
        a(13);
        throw null;
    }
}
