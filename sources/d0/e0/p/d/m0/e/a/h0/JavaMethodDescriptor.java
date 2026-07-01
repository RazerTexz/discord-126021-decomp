package d0.e0.p.d.m0.e.a.h0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
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
import d0.e0.p.d.m0.k.DescriptorFactory;
import d0.e0.p.d.m0.n.KotlinType;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h0.f, reason: use source file name */
/* JADX INFO: compiled from: JavaMethodDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class JavaMethodDescriptor extends SimpleFunctionDescriptorImpl implements JavaCallableMemberDescriptor {
    public static final CallableDescriptor.a<ValueParameterDescriptor> M = new a();
    public b N;
    public final boolean O;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h0.f$a */
    /* JADX INFO: compiled from: JavaMethodDescriptor.java */
    public static class a implements CallableDescriptor.a<ValueParameterDescriptor> {
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h0.f$b */
    /* JADX INFO: compiled from: JavaMethodDescriptor.java */
    public enum b {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);

        public final boolean isStable;
        public final boolean isSynthesized;

        b(boolean z2, boolean z3) {
            this.isStable = z2;
            this.isSynthesized = z3;
        }

        public static b get(boolean z2, boolean z3) {
            if (z2) {
                return z3 ? STABLE_SYNTHESIZED : STABLE_DECLARED;
            }
            return z3 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaMethodDescriptor(DeclarationDescriptor declarationDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, Annotations4 annotations4, Name name, CallableMemberDescriptor.a aVar, SourceElement sourceElement, boolean z2) {
        super(declarationDescriptor, simpleFunctionDescriptor, annotations4, name, aVar, sourceElement);
        if (declarationDescriptor == null) {
            a(0);
            throw null;
        }
        if (annotations4 == null) {
            a(1);
            throw null;
        }
        if (name == null) {
            a(2);
            throw null;
        }
        if (aVar == null) {
            a(3);
            throw null;
        }
        if (sourceElement == null) {
            a(4);
            throw null;
        }
        this.N = null;
        this.O = z2;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 12 || i == 17 || i == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 12 || i == 17 || i == 20) ? 2 : 3];
        switch (i) {
            case 1:
            case 6:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
            case 14:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 16:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "typeParameters";
                break;
            case 10:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
                objArr[0] = "visibility";
                break;
            case 12:
            case 17:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 18:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 19:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 12) {
            objArr[1] = "initialize";
        } else if (i == 17) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
                objArr[2] = "initialize";
                break;
            case 12:
            case 17:
            case 20:
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 18:
            case 19:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 12 && i != 17 && i != 20) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static JavaMethodDescriptor createJavaMethod(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, Name name, SourceElement sourceElement, boolean z2) {
        if (declarationDescriptor == null) {
            a(5);
            throw null;
        }
        if (annotations4 == null) {
            a(6);
            throw null;
        }
        if (name == null) {
            a(7);
            throw null;
        }
        if (sourceElement != null) {
            return new JavaMethodDescriptor(declarationDescriptor, null, annotations4, name, CallableMemberDescriptor.a.DECLARATION, sourceElement, z2);
        }
        a(8);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.SimpleFunctionDescriptorImpl, d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl
    public FunctionDescriptorImpl b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(13);
            throw null;
        }
        if (aVar == null) {
            a(14);
            throw null;
        }
        if (annotations4 == null) {
            a(15);
            throw null;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
        if (name == null) {
            name = getName();
        }
        JavaMethodDescriptor javaMethodDescriptor = new JavaMethodDescriptor(declarationDescriptor, simpleFunctionDescriptor, annotations4, name, aVar, sourceElement, this.O);
        javaMethodDescriptor.setParameterNamesStatus(hasStableParameterNames(), hasSynthesizedParameterNames());
        return javaMethodDescriptor;
    }

    @Override // d0.e0.p.d.m0.e.a.h0.JavaCallableMemberDescriptor
    public /* bridge */ /* synthetic */ JavaCallableMemberDescriptor enhance(KotlinType kotlinType, List list, KotlinType kotlinType2, Tuples2 tuples2) {
        return enhance(kotlinType, (List<util4>) list, kotlinType2, (Tuples2<CallableDescriptor.a<?>, ?>) tuples2);
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl
    public boolean hasStableParameterNames() {
        return this.N.isStable;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.N.isSynthesized;
    }

    @Override // d0.e0.p.d.m0.c.i1.SimpleFunctionDescriptorImpl
    public SimpleFunctionDescriptorImpl initialize(ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List<? extends TypeParameterDescriptor> list, List<ValueParameterDescriptor> list2, KotlinType kotlinType, Modality modality, DescriptorVisibility2 descriptorVisibility2, Map<? extends CallableDescriptor.a<?>, ?> map) {
        if (list == null) {
            a(9);
            throw null;
        }
        if (list2 == null) {
            a(10);
            throw null;
        }
        if (descriptorVisibility2 == null) {
            a(11);
            throw null;
        }
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImplInitialize = super.initialize(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, kotlinType, modality, descriptorVisibility2, map);
        setOperator(d0.e0.p.d.m0.o.i.a.check(simpleFunctionDescriptorImplInitialize).isSuccess());
        if (simpleFunctionDescriptorImplInitialize != null) {
            return simpleFunctionDescriptorImplInitialize;
        }
        a(12);
        throw null;
    }

    public void setParameterNamesStatus(boolean z2, boolean z3) {
        this.N = b.get(z2, z3);
    }

    @Override // d0.e0.p.d.m0.e.a.h0.JavaCallableMemberDescriptor
    public JavaMethodDescriptor enhance(KotlinType kotlinType, List<util4> list, KotlinType kotlinType2, Tuples2<CallableDescriptor.a<?>, ?> tuples2) {
        if (list == null) {
            a(18);
            throw null;
        }
        if (kotlinType2 == null) {
            a(19);
            throw null;
        }
        JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) newCopyBuilder().setValueParameters(util3.copyValueParameters(list, getValueParameters(), this)).setReturnType(kotlinType2).setExtensionReceiverParameter(kotlinType == null ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(this, kotlinType, Annotations4.f.getEMPTY())).setDropOriginalInContainingParts().setPreserveSourceElement().build();
        if (tuples2 != null) {
            javaMethodDescriptor.putInUserDataMap(tuples2.getFirst(), tuples2.getSecond());
        }
        if (javaMethodDescriptor != null) {
            return javaMethodDescriptor;
        }
        a(20);
        throw null;
    }
}
