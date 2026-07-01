package d0.e0.p.d.m0.c.i1;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptorVisitor;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.PropertyGetterDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.n.KotlinType;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.d0, reason: use source file name */
/* JADX INFO: compiled from: PropertyGetterDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class PropertyGetterDescriptorImpl extends PropertyAccessorDescriptorImpl implements PropertyGetterDescriptor {
    public KotlinType v;
    public final PropertyGetterDescriptor w;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public PropertyGetterDescriptorImpl(PropertyDescriptor propertyDescriptor, Annotations4 annotations4, Modality modality, DescriptorVisibility2 descriptorVisibility2, boolean z2, boolean z3, boolean z4, CallableMemberDescriptor.a aVar, PropertyGetterDescriptor propertyGetterDescriptor, SourceElement sourceElement) {
        PropertyGetterDescriptor propertyGetterDescriptor2;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
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
        StringBuilder sbU = outline.U("<get-");
        sbU.append(propertyDescriptor.getName());
        sbU.append(">");
        super(modality, descriptorVisibility2, propertyDescriptor, annotations4, Name.special(sbU.toString()), z2, z3, z4, aVar, sourceElement);
        if (propertyGetterDescriptor != null) {
            propertyGetterDescriptorImpl = this;
            propertyGetterDescriptor2 = propertyGetterDescriptor;
        } else {
            propertyGetterDescriptor2 = this;
            propertyGetterDescriptorImpl = propertyGetterDescriptor2;
        }
        propertyGetterDescriptorImpl.w = propertyGetterDescriptor2;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 6 || i == 7 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
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
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i == 7) {
            objArr[1] = "getValueParameters";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i != 6 && i != 7 && i != 8) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 6 && i != 7 && i != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitPropertyGetterDescriptor(this, d);
    }

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor, d0.e0.p.d.m0.c.CallableMemberDescriptor, d0.e0.p.d.m0.c.CallableDescriptor
    public Collection<? extends PropertyGetterDescriptor> getOverriddenDescriptors() {
        return b(true);
    }

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    public KotlinType getReturnType() {
        return this.v;
    }

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(7);
        throw null;
    }

    public void initialize(KotlinType kotlinType) {
        if (kotlinType == null) {
            kotlinType = getCorrespondingProperty().getType();
        }
        this.v = kotlinType;
    }

    @Override // d0.e0.p.d.m0.c.i1.PropertyAccessorDescriptorImpl, d0.e0.p.d.m0.c.i1.DeclarationDescriptorNonRootImpl, d0.e0.p.d.m0.c.i1.DeclarationDescriptorImpl, d0.e0.p.d.m0.c.DeclarationDescriptor
    public PropertyGetterDescriptor getOriginal() {
        PropertyGetterDescriptor propertyGetterDescriptor = this.w;
        if (propertyGetterDescriptor != null) {
            return propertyGetterDescriptor;
        }
        a(8);
        throw null;
    }
}
