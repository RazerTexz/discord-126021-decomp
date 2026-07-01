package d0.e0.p.d.m0.n.m1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl;
import d0.e0.p.d.m0.c.i1.SimpleFunctionDescriptorImpl;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeSubstitution5;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.m1.a, reason: use source file name */
/* JADX INFO: compiled from: ErrorSimpleFunctionDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class ErrorSimpleFunctionDescriptorImpl extends SimpleFunctionDescriptorImpl {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.m1.a$a */
    /* JADX INFO: compiled from: ErrorSimpleFunctionDescriptorImpl.java */
    public class a implements FunctionDescriptor.a<SimpleFunctionDescriptor> {
        public a() {
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0030  */
        /* JADX WARN: Code duplicated, block: B:31:0x004e  */
        public static /* synthetic */ void a(int i) {
            String str;
            int i2;
            if (i != 1 && i != 3 && i != 5 && i != 10 && i != 12 && i != 14 && i != 16 && i != 18 && i != 30 && i != 7 && i != 8) {
                switch (i) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        str = "@NotNull method %s.%s must not return null";
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i != 1 && i != 3 && i != 5 && i != 10 && i != 12 && i != 14 && i != 16 && i != 18 && i != 30 && i != 7 && i != 8) {
                switch (i) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
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
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                case 14:
                case 16:
                case 18:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 30:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1";
                    break;
                case 2:
                    objArr[0] = "modality";
                    break;
                case 4:
                    objArr[0] = "visibility";
                    break;
                case 6:
                    objArr[0] = "kind";
                    break;
                case 9:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
                case 11:
                case 17:
                    objArr[0] = "parameters";
                    break;
                case 13:
                    objArr[0] = "substitution";
                    break;
                case 15:
                    objArr[0] = "userDataKey";
                    break;
                case 19:
                    objArr[0] = "type";
                    break;
                case 29:
                    objArr[0] = "additionalAnnotations";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i == 1) {
                objArr[1] = "setOwner";
            } else if (i == 3) {
                objArr[1] = "setModality";
            } else if (i == 5) {
                objArr[1] = "setVisibility";
            } else if (i == 10) {
                objArr[1] = "setName";
            } else if (i == 12) {
                objArr[1] = "setValueParameters";
            } else if (i == 14) {
                objArr[1] = "setSubstitution";
            } else if (i == 16) {
                objArr[1] = "putUserData";
            } else if (i == 18) {
                objArr[1] = "setTypeParameters";
            } else if (i == 30) {
                objArr[1] = "setAdditionalAnnotations";
            } else if (i == 7) {
                objArr[1] = "setKind";
            } else if (i != 8) {
                switch (i) {
                    case 20:
                        objArr[1] = "setReturnType";
                        break;
                    case 21:
                        objArr[1] = "setExtensionReceiverParameter";
                        break;
                    case 22:
                        objArr[1] = "setDispatchReceiverParameter";
                        break;
                    case 23:
                        objArr[1] = "setOriginal";
                        break;
                    case 24:
                        objArr[1] = "setSignatureChange";
                        break;
                    case 25:
                        objArr[1] = "setPreserveSourceElement";
                        break;
                    case 26:
                        objArr[1] = "setDropOriginalInContainingParts";
                        break;
                    case 27:
                        objArr[1] = "setHiddenToOvercomeSignatureClash";
                        break;
                    case 28:
                        objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1";
                        break;
                }
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                case 14:
                case 16:
                case 18:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 30:
                    break;
                case 2:
                    objArr[2] = "setModality";
                    break;
                case 4:
                    objArr[2] = "setVisibility";
                    break;
                case 6:
                    objArr[2] = "setKind";
                    break;
                case 9:
                    objArr[2] = "setName";
                    break;
                case 11:
                    objArr[2] = "setValueParameters";
                    break;
                case 13:
                    objArr[2] = "setSubstitution";
                    break;
                case 15:
                    objArr[2] = "putUserData";
                    break;
                case 17:
                    objArr[2] = "setTypeParameters";
                    break;
                case 19:
                    objArr[2] = "setReturnType";
                    break;
                case 29:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 3 && i != 5 && i != 10 && i != 12 && i != 14 && i != 16 && i != 18 && i != 30 && i != 7 && i != 8) {
                switch (i) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setAdditionalAnnotations(Annotations4 annotations4) {
            if (annotations4 != null) {
                return this;
            }
            a(29);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setCopyOverrides(boolean z2) {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setDispatchReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor) {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setDropOriginalInContainingParts() {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setExtensionReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor) {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setHiddenForResolutionEverywhereBesideSupercalls() {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setHiddenToOvercomeSignatureClash() {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setKind(CallableMemberDescriptor.a aVar) {
            if (aVar != null) {
                return this;
            }
            a(6);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setModality(Modality modality) {
            if (modality != null) {
                return this;
            }
            a(2);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setName(Name name) {
            if (name != null) {
                return this;
            }
            a(9);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setOriginal(CallableMemberDescriptor callableMemberDescriptor) {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setOwner(DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor != null) {
                return this;
            }
            a(0);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setPreserveSourceElement() {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setReturnType(KotlinType kotlinType) {
            if (kotlinType != null) {
                return this;
            }
            a(19);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setSignatureChange() {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setSubstitution(TypeSubstitution5 typeSubstitution5) {
            if (typeSubstitution5 != null) {
                return this;
            }
            a(13);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setTypeParameters(List<TypeParameterDescriptor> list) {
            if (list != null) {
                return this;
            }
            a(17);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setValueParameters(List<ValueParameterDescriptor> list) {
            if (list != null) {
                return this;
            }
            a(11);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor.a<SimpleFunctionDescriptor> setVisibility(DescriptorVisibility2 descriptorVisibility2) {
            if (descriptorVisibility2 != null) {
                return this;
            }
            a(4);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public SimpleFunctionDescriptor build() {
            return ErrorSimpleFunctionDescriptorImpl.this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorSimpleFunctionDescriptorImpl(ClassDescriptor classDescriptor, ErrorUtils.d dVar) {
        super(classDescriptor, null, Annotations4.f.getEMPTY(), Name.special("<ERROR FUNCTION>"), CallableMemberDescriptor.a.DECLARATION, SourceElement.a);
        if (classDescriptor == null) {
            a(0);
            throw null;
        }
        if (dVar != null) {
        } else {
            a(1);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "ownerScope";
                break;
            case 2:
                objArr[0] = "newOwner";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "annotations";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
                break;
            case 8:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 6) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "copy";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 6:
            case 7:
                break;
            case 8:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.i1.SimpleFunctionDescriptorImpl, d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl
    public FunctionDescriptorImpl b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(2);
            throw null;
        }
        if (aVar == null) {
            a(3);
            throw null;
        }
        if (annotations4 != null) {
            return this;
        }
        a(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.SimpleFunctionDescriptorImpl, d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.CallableMemberDescriptor
    public SimpleFunctionDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, CallableMemberDescriptor.a aVar, boolean z2) {
        return this;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.a<V> aVar) {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isSuspend() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.SimpleFunctionDescriptorImpl, d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.FunctionDescriptor, d0.e0.p.d.m0.c.SimpleFunctionDescriptor
    public FunctionDescriptor.a<? extends SimpleFunctionDescriptor> newCopyBuilder() {
        return new a();
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.CallableMemberDescriptor
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection != null) {
            return;
        }
        a(8);
        throw null;
    }
}
