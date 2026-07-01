package d0.e0.p.d.m0.c.i1;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptorVisitor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.FieldDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.PropertyAccessorDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.PropertySetterDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.p.ExtensionReceiver;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.m.storage6;
import d0.e0.p.d.m0.n.DescriptorSubstitutor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeSubstitution5;
import d0.e0.p.d.m0.n.TypeSubstitutor2;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.p.SmartSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.c0, reason: use source file name */
/* JADX INFO: compiled from: PropertyDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class PropertyDescriptorImpl extends VariableDescriptorWithInitializerImpl implements PropertyDescriptor {
    public final boolean A;
    public ReceiverParameterDescriptor B;
    public ReceiverParameterDescriptor C;
    public List<TypeParameterDescriptor> D;
    public PropertyGetterDescriptorImpl E;
    public PropertySetterDescriptor F;
    public boolean G;
    public FieldDescriptor H;
    public FieldDescriptor I;
    public final Modality q;
    public DescriptorVisibility2 r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Collection<? extends PropertyDescriptor> f3259s;
    public final PropertyDescriptor t;
    public final CallableMemberDescriptor.a u;
    public final boolean v;
    public final boolean w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f3260x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f3261y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f3262z;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.c0$a */
    /* JADX INFO: compiled from: PropertyDescriptorImpl.java */
    public class a {
        public DeclarationDescriptor a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Modality f3263b;
        public DescriptorVisibility2 c;
        public CallableMemberDescriptor.a e;
        public ReceiverParameterDescriptor h;
        public Name i;
        public KotlinType j;
        public PropertyDescriptor d = null;
        public TypeSubstitution5 f = TypeSubstitution5.a;
        public boolean g = true;

        public a() {
            this.a = PropertyDescriptorImpl.this.getContainingDeclaration();
            this.f3263b = PropertyDescriptorImpl.this.getModality();
            this.c = PropertyDescriptorImpl.this.getVisibility();
            this.e = PropertyDescriptorImpl.this.getKind();
            this.h = PropertyDescriptorImpl.this.B;
            this.i = PropertyDescriptorImpl.this.getName();
            this.j = PropertyDescriptorImpl.this.getType();
        }

        public static /* synthetic */ void a(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? 2 : 3];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i == 1) {
                objArr[1] = "setOwner";
            } else if (i == 2) {
                objArr[1] = "setOriginal";
            } else if (i == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i == 5) {
                objArr[1] = "setReturnType";
            } else if (i == 7) {
                objArr[1] = "setModality";
            } else if (i == 9) {
                objArr[1] = "setVisibility";
            } else if (i == 11) {
                objArr[1] = "setKind";
            } else if (i == 19) {
                objArr[1] = "setName";
            } else if (i == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i == 16) {
                objArr[1] = "setSubstitution";
            } else if (i != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 5 && i != 7 && i != 9 && i != 11 && i != 19 && i != 13 && i != 14 && i != 16 && i != 17) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public PropertyDescriptor build() {
            ReceiverParameterDescriptor receiverParameterDescriptorSubstitute;
            ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl;
            PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
            PropertySetterDescriptorImpl propertySetterDescriptorImpl;
            storage6<d0.e0.p.d.m0.k.v.g<?>> storage6Var;
            PropertyDescriptorImpl propertyDescriptorImpl = PropertyDescriptorImpl.this;
            Objects.requireNonNull(propertyDescriptorImpl);
            CallableMemberDescriptor.a aVar = CallableMemberDescriptor.a.FAKE_OVERRIDE;
            DeclarationDescriptor declarationDescriptor = this.a;
            Modality modality = this.f3263b;
            DescriptorVisibility2 descriptorVisibility2 = this.c;
            PropertyDescriptor propertyDescriptor = this.d;
            CallableMemberDescriptor.a aVar2 = this.e;
            Name name = this.i;
            SourceElement sourceElement = SourceElement.a;
            PropertyDescriptorImpl propertyDescriptorImplB = propertyDescriptorImpl.b(declarationDescriptor, modality, descriptorVisibility2, propertyDescriptor, aVar2, name, sourceElement);
            List<TypeParameterDescriptor> typeParameters = propertyDescriptorImpl.getTypeParameters();
            ArrayList arrayList = new ArrayList(typeParameters.size());
            TypeSubstitutor2 typeSubstitutor2SubstituteTypeParameters = DescriptorSubstitutor.substituteTypeParameters(typeParameters, this.f, propertyDescriptorImplB, arrayList);
            KotlinType kotlinType = this.j;
            Variance variance = Variance.OUT_VARIANCE;
            KotlinType kotlinTypeSubstitute = typeSubstitutor2SubstituteTypeParameters.substitute(kotlinType, variance);
            if (kotlinTypeSubstitute == null) {
                return null;
            }
            ReceiverParameterDescriptor receiverParameterDescriptor = this.h;
            if (receiverParameterDescriptor != null) {
                receiverParameterDescriptorSubstitute = receiverParameterDescriptor.substitute(typeSubstitutor2SubstituteTypeParameters);
                if (receiverParameterDescriptorSubstitute == null) {
                    return null;
                }
            } else {
                receiverParameterDescriptorSubstitute = null;
            }
            ReceiverParameterDescriptor receiverParameterDescriptor2 = propertyDescriptorImpl.C;
            if (receiverParameterDescriptor2 != null) {
                KotlinType kotlinTypeSubstitute2 = typeSubstitutor2SubstituteTypeParameters.substitute(receiverParameterDescriptor2.getType(), Variance.IN_VARIANCE);
                if (kotlinTypeSubstitute2 == null) {
                    return null;
                }
                receiverParameterDescriptorImpl = new ReceiverParameterDescriptorImpl(propertyDescriptorImplB, new ExtensionReceiver(propertyDescriptorImplB, kotlinTypeSubstitute2, propertyDescriptorImpl.C.getValue()), propertyDescriptorImpl.C.getAnnotations());
            } else {
                receiverParameterDescriptorImpl = null;
            }
            propertyDescriptorImplB.setType(kotlinTypeSubstitute, arrayList, receiverParameterDescriptorSubstitute, receiverParameterDescriptorImpl);
            PropertyGetterDescriptorImpl propertyGetterDescriptorImpl2 = propertyDescriptorImpl.E;
            if (propertyGetterDescriptorImpl2 == null) {
                propertyGetterDescriptorImpl = null;
            } else {
                Annotations4 annotations = propertyGetterDescriptorImpl2.getAnnotations();
                Modality modality2 = this.f3263b;
                DescriptorVisibility2 visibility = propertyDescriptorImpl.E.getVisibility();
                if (this.e == aVar && DescriptorVisibilities.isPrivate(visibility.normalize())) {
                    visibility = DescriptorVisibilities.h;
                }
                DescriptorVisibility2 descriptorVisibility3 = visibility;
                boolean zIsDefault = propertyDescriptorImpl.E.isDefault();
                boolean zIsExternal = propertyDescriptorImpl.E.isExternal();
                boolean zIsInline = propertyDescriptorImpl.E.isInline();
                CallableMemberDescriptor.a aVar3 = this.e;
                PropertyDescriptor propertyDescriptor2 = this.d;
                propertyGetterDescriptorImpl = new PropertyGetterDescriptorImpl(propertyDescriptorImplB, annotations, modality2, descriptorVisibility3, zIsDefault, zIsExternal, zIsInline, aVar3, propertyDescriptor2 == null ? null : propertyDescriptor2.getGetter(), sourceElement);
            }
            if (propertyGetterDescriptorImpl != null) {
                KotlinType returnType = propertyDescriptorImpl.E.getReturnType();
                propertyGetterDescriptorImpl.setInitialSignatureDescriptor(PropertyDescriptorImpl.c(typeSubstitutor2SubstituteTypeParameters, propertyDescriptorImpl.E));
                propertyGetterDescriptorImpl.initialize(returnType != null ? typeSubstitutor2SubstituteTypeParameters.substitute(returnType, variance) : null);
            }
            PropertySetterDescriptor propertySetterDescriptor = propertyDescriptorImpl.F;
            if (propertySetterDescriptor == null) {
                propertySetterDescriptorImpl = null;
            } else {
                Annotations4 annotations2 = propertySetterDescriptor.getAnnotations();
                Modality modality3 = this.f3263b;
                DescriptorVisibility2 visibility2 = propertyDescriptorImpl.F.getVisibility();
                if (this.e == aVar && DescriptorVisibilities.isPrivate(visibility2.normalize())) {
                    visibility2 = DescriptorVisibilities.h;
                }
                DescriptorVisibility2 descriptorVisibility4 = visibility2;
                boolean zIsDefault2 = propertyDescriptorImpl.F.isDefault();
                boolean zIsExternal2 = propertyDescriptorImpl.F.isExternal();
                boolean zIsInline2 = propertyDescriptorImpl.F.isInline();
                CallableMemberDescriptor.a aVar4 = this.e;
                PropertyDescriptor propertyDescriptor3 = this.d;
                propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(propertyDescriptorImplB, annotations2, modality3, descriptorVisibility4, zIsDefault2, zIsExternal2, zIsInline2, aVar4, propertyDescriptor3 == null ? null : propertyDescriptor3.getSetter(), sourceElement);
            }
            if (propertySetterDescriptorImpl != null) {
                List<ValueParameterDescriptor> substitutedValueParameters = FunctionDescriptorImpl.getSubstitutedValueParameters(propertySetterDescriptorImpl, propertyDescriptorImpl.F.getValueParameters(), typeSubstitutor2SubstituteTypeParameters, false, false, null);
                if (substitutedValueParameters == null) {
                    propertyDescriptorImplB.setSetterProjectedOut(true);
                    substitutedValueParameters = Collections.singletonList(PropertySetterDescriptorImpl.createSetterParameter(propertySetterDescriptorImpl, DescriptorUtils2.getBuiltIns(this.a).getNothingType(), propertyDescriptorImpl.F.getValueParameters().get(0).getAnnotations()));
                }
                if (substitutedValueParameters.size() != 1) {
                    throw new IllegalStateException();
                }
                propertySetterDescriptorImpl.setInitialSignatureDescriptor(PropertyDescriptorImpl.c(typeSubstitutor2SubstituteTypeParameters, propertyDescriptorImpl.F));
                propertySetterDescriptorImpl.initialize(substitutedValueParameters.get(0));
            }
            FieldDescriptor fieldDescriptor = propertyDescriptorImpl.H;
            FieldDescriptorImpl fieldDescriptorImpl = fieldDescriptor == null ? null : new FieldDescriptorImpl(fieldDescriptor.getAnnotations(), propertyDescriptorImplB);
            FieldDescriptor fieldDescriptor2 = propertyDescriptorImpl.I;
            propertyDescriptorImplB.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, fieldDescriptorImpl, fieldDescriptor2 != null ? new FieldDescriptorImpl(fieldDescriptor2.getAnnotations(), propertyDescriptorImplB) : null);
            if (this.g) {
                SmartSet smartSetCreate = SmartSet.create();
                Iterator<? extends PropertyDescriptor> it = propertyDescriptorImpl.getOverriddenDescriptors().iterator();
                while (it.hasNext()) {
                    smartSetCreate.add(it.next().substitute(typeSubstitutor2SubstituteTypeParameters));
                }
                propertyDescriptorImplB.setOverriddenDescriptors(smartSetCreate);
            }
            if (propertyDescriptorImpl.isConst() && (storage6Var = propertyDescriptorImpl.p) != null) {
                propertyDescriptorImplB.setCompileTimeInitializer(storage6Var);
            }
            return propertyDescriptorImplB;
        }

        public a setCopyOverrides(boolean z2) {
            this.g = z2;
            return this;
        }

        public a setKind(CallableMemberDescriptor.a aVar) {
            if (aVar != null) {
                this.e = aVar;
                return this;
            }
            a(10);
            throw null;
        }

        public a setModality(Modality modality) {
            if (modality != null) {
                this.f3263b = modality;
                return this;
            }
            a(6);
            throw null;
        }

        public a setOriginal(CallableMemberDescriptor callableMemberDescriptor) {
            this.d = (PropertyDescriptor) callableMemberDescriptor;
            return this;
        }

        public a setOwner(DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor != null) {
                this.a = declarationDescriptor;
                return this;
            }
            a(0);
            throw null;
        }

        public a setSubstitution(TypeSubstitution5 typeSubstitution5) {
            if (typeSubstitution5 != null) {
                this.f = typeSubstitution5;
                return this;
            }
            a(15);
            throw null;
        }

        public a setVisibility(DescriptorVisibility2 descriptorVisibility2) {
            if (descriptorVisibility2 != null) {
                this.c = descriptorVisibility2;
                return this;
            }
            a(8);
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PropertyDescriptorImpl(DeclarationDescriptor declarationDescriptor, PropertyDescriptor propertyDescriptor, Annotations4 annotations4, Modality modality, DescriptorVisibility2 descriptorVisibility2, boolean z2, Name name, CallableMemberDescriptor.a aVar, SourceElement sourceElement, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        super(declarationDescriptor, annotations4, name, null, z2, sourceElement);
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
        if (aVar == null) {
            a(5);
            throw null;
        }
        if (sourceElement == null) {
            a(6);
            throw null;
        }
        this.f3259s = null;
        this.q = modality;
        this.r = descriptorVisibility2;
        this.t = propertyDescriptor == null ? this : propertyDescriptor;
        this.u = aVar;
        this.v = z3;
        this.w = z4;
        this.f3260x = z5;
        this.f3261y = z6;
        this.f3262z = z7;
        this.A = z8;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001a  */
    /* JADX WARN: Code duplicated, block: B:19:0x002c  */
    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (i != 23 && i != 33 && i != 34 && i != 36 && i != 37) {
            switch (i) {
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 23 && i != 33 && i != 34 && i != 36 && i != 37) {
            switch (i) {
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
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
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
            case 16:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 5:
            case 12:
            case 30:
                objArr[0] = "kind";
                break;
            case 6:
            case 13:
            case 32:
                objArr[0] = "source";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 14:
                objArr[0] = "outType";
                break;
            case 15:
                objArr[0] = "typeParameters";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 33:
            case 34:
            case 36:
            case 37:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                break;
            case 22:
                objArr[0] = "originalSubstitutor";
                break;
            case 24:
                objArr[0] = "copyConfiguration";
                break;
            case 25:
                objArr[0] = "substitutor";
                break;
            case 26:
                objArr[0] = "accessorDescriptor";
                break;
            case 27:
                objArr[0] = "newOwner";
                break;
            case 28:
                objArr[0] = "newModality";
                break;
            case 29:
                objArr[0] = "newVisibility";
                break;
            case 31:
                objArr[0] = "newName";
                break;
            case 35:
                objArr[0] = "overriddenDescriptors";
                break;
        }
        if (i == 23) {
            objArr[1] = "getSourceToUseForCopy";
        } else if (i == 33) {
            objArr[1] = "getOriginal";
        } else if (i == 34) {
            objArr[1] = "getKind";
        } else if (i == 36) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i != 37) {
            switch (i) {
                case 17:
                    objArr[1] = "getTypeParameters";
                    break;
                case 18:
                    objArr[1] = "getReturnType";
                    break;
                case 19:
                    objArr[1] = "getModality";
                    break;
                case 20:
                    objArr[1] = "getVisibility";
                    break;
                case 21:
                    objArr[1] = "getAccessors";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                    break;
            }
        } else {
            objArr[1] = "copy";
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[2] = "create";
                break;
            case 14:
            case 15:
                objArr[2] = "setType";
                break;
            case 16:
                objArr[2] = "setVisibility";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 33:
            case 34:
            case 36:
            case 37:
                break;
            case 22:
                objArr[2] = "substitute";
                break;
            case 24:
                objArr[2] = "doSubstitute";
                break;
            case 25:
            case 26:
                objArr[2] = "getSubstitutedInitialSignatureDescriptor";
                break;
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 35:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 23 && i != 33 && i != 34 && i != 36 && i != 37) {
            switch (i) {
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    public static FunctionDescriptor c(TypeSubstitutor2 typeSubstitutor2, PropertyAccessorDescriptor propertyAccessorDescriptor) {
        if (propertyAccessorDescriptor == null) {
            a(26);
            throw null;
        }
        if (propertyAccessorDescriptor.getInitialSignatureDescriptor() != null) {
            return propertyAccessorDescriptor.getInitialSignatureDescriptor().substitute(typeSubstitutor2);
        }
        return null;
    }

    public static PropertyDescriptorImpl create(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, Modality modality, DescriptorVisibility2 descriptorVisibility2, boolean z2, Name name, CallableMemberDescriptor.a aVar, SourceElement sourceElement, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
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
        if (aVar == null) {
            a(12);
            throw null;
        }
        if (sourceElement != null) {
            return new PropertyDescriptorImpl(declarationDescriptor, null, annotations4, modality, descriptorVisibility2, z2, name, aVar, sourceElement, z3, z4, z5, z6, z7, z8);
        }
        a(13);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitPropertyDescriptor(this, d);
    }

    public PropertyDescriptorImpl b(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, PropertyDescriptor propertyDescriptor, CallableMemberDescriptor.a aVar, Name name, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(27);
            throw null;
        }
        if (modality == null) {
            a(28);
            throw null;
        }
        if (descriptorVisibility2 == null) {
            a(29);
            throw null;
        }
        if (aVar == null) {
            a(30);
            throw null;
        }
        if (name != null) {
            return new PropertyDescriptorImpl(declarationDescriptor, propertyDescriptor, getAnnotations(), modality, descriptorVisibility2, isVar(), name, aVar, sourceElement, isLateInit(), isConst(), isExpect(), isActual(), isExternal(), isDelegated());
        }
        a(31);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.PropertyDescriptor
    public List<PropertyAccessorDescriptor> getAccessors() {
        ArrayList arrayList = new ArrayList(2);
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = this.E;
        if (propertyGetterDescriptorImpl != null) {
            arrayList.add(propertyGetterDescriptorImpl);
        }
        PropertySetterDescriptor propertySetterDescriptor = this.F;
        if (propertySetterDescriptor != null) {
            arrayList.add(propertySetterDescriptor);
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.PropertyDescriptor
    public FieldDescriptor getBackingField() {
        return this.H;
    }

    @Override // d0.e0.p.d.m0.c.PropertyDescriptor
    public FieldDescriptor getDelegateField() {
        return this.I;
    }

    @Override // d0.e0.p.d.m0.c.i1.VariableDescriptorImpl, d0.e0.p.d.m0.c.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.B;
    }

    @Override // d0.e0.p.d.m0.c.i1.VariableDescriptorImpl, d0.e0.p.d.m0.c.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.C;
    }

    @Override // d0.e0.p.d.m0.c.CallableMemberDescriptor
    public CallableMemberDescriptor.a getKind() {
        CallableMemberDescriptor.a aVar = this.u;
        if (aVar != null) {
            return aVar;
        }
        a(34);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public Modality getModality() {
        Modality modality = this.q;
        if (modality != null) {
            return modality;
        }
        a(19);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors() {
        Collection<? extends PropertyDescriptor> collectionEmptyList = this.f3259s;
        if (collectionEmptyList == null) {
            collectionEmptyList = Collections.emptyList();
        }
        if (collectionEmptyList != null) {
            return collectionEmptyList;
        }
        a(36);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.VariableDescriptorImpl, d0.e0.p.d.m0.c.CallableDescriptor
    public KotlinType getReturnType() {
        KotlinType type = getType();
        if (type != null) {
            return type;
        }
        a(18);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.PropertyDescriptor
    public PropertySetterDescriptor getSetter() {
        return this.F;
    }

    @Override // d0.e0.p.d.m0.c.i1.VariableDescriptorImpl, d0.e0.p.d.m0.c.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.D;
        if (list != null) {
            return list;
        }
        StringBuilder sbU = outline.U("typeParameters == null for ");
        sbU.append(toString());
        throw new IllegalStateException(sbU.toString());
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorWithVisibility, d0.e0.p.d.m0.c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        DescriptorVisibility2 descriptorVisibility2 = this.r;
        if (descriptorVisibility2 != null) {
            return descriptorVisibility2;
        }
        a(20);
        throw null;
    }

    public void initialize(PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, PropertySetterDescriptor propertySetterDescriptor) {
        initialize(propertyGetterDescriptorImpl, propertySetterDescriptor, null, null);
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isActual() {
        return this.f3261y;
    }

    @Override // d0.e0.p.d.m0.c.VariableDescriptor
    public boolean isConst() {
        return this.w;
    }

    @Override // d0.e0.p.d.m0.c.PropertyDescriptor
    public boolean isDelegated() {
        return this.A;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isExpect() {
        return this.f3260x;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isExternal() {
        return this.f3262z;
    }

    @Override // d0.e0.p.d.m0.c.VariableDescriptor
    public boolean isLateInit() {
        return this.v;
    }

    public boolean isSetterProjectedOut() {
        return this.G;
    }

    public a newCopyBuilder() {
        return new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.e0.p.d.m0.c.CallableMemberDescriptor
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection != 0) {
            this.f3259s = collection;
        } else {
            a(35);
            throw null;
        }
    }

    public void setSetterProjectedOut(boolean z2) {
        this.G = z2;
    }

    public void setType(KotlinType kotlinType, List<? extends TypeParameterDescriptor> list, ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2) {
        if (kotlinType == null) {
            a(14);
            throw null;
        }
        if (list == null) {
            a(15);
            throw null;
        }
        setOutType(kotlinType);
        this.D = new ArrayList(list);
        this.C = receiverParameterDescriptor2;
        this.B = receiverParameterDescriptor;
    }

    public void setVisibility(DescriptorVisibility2 descriptorVisibility2) {
        if (descriptorVisibility2 != null) {
            this.r = descriptorVisibility2;
        } else {
            a(16);
            throw null;
        }
    }

    @Override // d0.e0.p.d.m0.c.CallableMemberDescriptor
    public PropertyDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, CallableMemberDescriptor.a aVar, boolean z2) {
        PropertyDescriptor propertyDescriptorBuild = newCopyBuilder().setOwner(declarationDescriptor).setOriginal(null).setModality(modality).setVisibility(descriptorVisibility2).setKind(aVar).setCopyOverrides(z2).build();
        if (propertyDescriptorBuild != null) {
            return propertyDescriptorBuild;
        }
        a(37);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.PropertyDescriptor
    public PropertyGetterDescriptorImpl getGetter() {
        return this.E;
    }

    public void initialize(PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, PropertySetterDescriptor propertySetterDescriptor, FieldDescriptor fieldDescriptor, FieldDescriptor fieldDescriptor2) {
        this.E = propertyGetterDescriptorImpl;
        this.F = propertySetterDescriptor;
        this.H = fieldDescriptor;
        this.I = fieldDescriptor2;
    }

    @Override // d0.e0.p.d.m0.c.Substitutable
    public PropertyDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        if (typeSubstitutor2 != null) {
            return typeSubstitutor2.isEmpty() ? this : newCopyBuilder().setSubstitution(typeSubstitutor2.getSubstitution()).setOriginal(getOriginal()).build();
        }
        a(22);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.DeclarationDescriptorNonRootImpl, d0.e0.p.d.m0.c.i1.DeclarationDescriptorImpl, d0.e0.p.d.m0.c.DeclarationDescriptor
    public PropertyDescriptor getOriginal() {
        PropertyDescriptor propertyDescriptor = this.t;
        PropertyDescriptor original = propertyDescriptor == this ? this : propertyDescriptor.getOriginal();
        if (original != null) {
            return original;
        }
        a(33);
        throw null;
    }
}
