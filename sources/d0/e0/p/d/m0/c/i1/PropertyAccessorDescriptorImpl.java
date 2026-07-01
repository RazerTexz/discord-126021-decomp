package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.PropertyAccessorDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.Substitutable;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.n.TypeSubstitutor2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.b0, reason: use source file name */
/* JADX INFO: compiled from: PropertyAccessorDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PropertyAccessorDescriptorImpl extends DeclarationDescriptorNonRootImpl implements PropertyAccessorDescriptor {
    public boolean n;
    public final boolean o;
    public final Modality p;
    public final PropertyDescriptor q;
    public final boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CallableMemberDescriptor.a f3258s;
    public DescriptorVisibility2 t;
    public FunctionDescriptor u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PropertyAccessorDescriptorImpl(Modality modality, DescriptorVisibility2 descriptorVisibility2, PropertyDescriptor propertyDescriptor, Annotations4 annotations4, Name name, boolean z2, boolean z3, boolean z4, CallableMemberDescriptor.a aVar, SourceElement sourceElement) {
        super(propertyDescriptor.getContainingDeclaration(), annotations4, name, sourceElement);
        if (modality == null) {
            a(0);
            throw null;
        }
        if (descriptorVisibility2 == null) {
            a(1);
            throw null;
        }
        if (propertyDescriptor == null) {
            a(2);
            throw null;
        }
        if (annotations4 == null) {
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
        this.u = null;
        this.p = modality;
        this.t = descriptorVisibility2;
        this.q = propertyDescriptor;
        this.n = z2;
        this.o = z3;
        this.r = z4;
        this.f3258s = aVar;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                i2 = 2;
                break;
            case 7:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 14:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getModality";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 12:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 13:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 14:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            case 7:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public Collection<PropertyAccessorDescriptor> b(boolean z2) {
        ArrayList arrayList = new ArrayList(0);
        for (PropertyDescriptor propertyDescriptor : getCorrespondingProperty().getOverriddenDescriptors()) {
            Substitutable getter = z2 ? propertyDescriptor.getGetter() : propertyDescriptor.getSetter();
            if (getter != null) {
                arrayList.add(getter);
            }
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.PropertyAccessorDescriptor
    public PropertyDescriptor getCorrespondingProperty() {
        PropertyDescriptor propertyDescriptor = this.q;
        if (propertyDescriptor != null) {
            return propertyDescriptor;
        }
        a(12);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return getCorrespondingProperty().getDispatchReceiverParameter();
    }

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return getCorrespondingProperty().getExtensionReceiverParameter();
    }

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.u;
    }

    @Override // d0.e0.p.d.m0.c.CallableMemberDescriptor
    public CallableMemberDescriptor.a getKind() {
        CallableMemberDescriptor.a aVar = this.f3258s;
        if (aVar != null) {
            return aVar;
        }
        a(6);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public Modality getModality() {
        Modality modality = this.p;
        if (modality != null) {
            return modality;
        }
        a(9);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.DeclarationDescriptorNonRootImpl, d0.e0.p.d.m0.c.i1.DeclarationDescriptorImpl, d0.e0.p.d.m0.c.DeclarationDescriptor
    public abstract PropertyAccessorDescriptor getOriginal();

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(8);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.a<V> aVar) {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorWithVisibility, d0.e0.p.d.m0.c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        DescriptorVisibility2 descriptorVisibility2 = this.t;
        if (descriptorVisibility2 != null) {
            return descriptorVisibility2;
        }
        a(10);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.PropertyAccessorDescriptor
    public boolean isDefault() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isExternal() {
        return this.o;
    }

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isHiddenToOvercomeSignatureClash() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isInfix() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isInline() {
        return this.r;
    }

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isOperator() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isSuspend() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }

    public void setDefault(boolean z2) {
        this.n = z2;
    }

    public void setInitialSignatureDescriptor(FunctionDescriptor functionDescriptor) {
        this.u = functionDescriptor;
    }

    @Override // d0.e0.p.d.m0.c.CallableMemberDescriptor
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection != null) {
            return;
        }
        a(14);
        throw null;
    }

    public void setVisibility(DescriptorVisibility2 descriptorVisibility2) {
        this.t = descriptorVisibility2;
    }

    @Override // d0.e0.p.d.m0.c.CallableMemberDescriptor
    public PropertyAccessorDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, CallableMemberDescriptor.a aVar, boolean z2) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // d0.e0.p.d.m0.c.Substitutable
    public FunctionDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        if (typeSubstitutor2 != null) {
            throw new UnsupportedOperationException();
        }
        a(7);
        throw null;
    }
}
