package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.e.a.h0.JavaMethodDescriptor;
import d0.e0.p.d.m0.e.a.i0.m.RawType;
import d0.e0.p.d.m0.e.a.i0.m.RawType2;
import d0.e0.p.d.m0.k.ExternalOverridabilityCondition;
import d0.e0.p.d.m0.k.OverridingUtil;
import d0.e0.p.d.m0.n.KotlinType;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.p, reason: use source file name */
/* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ErasedOverridabilityCondition implements ExternalOverridabilityCondition {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.p$a */
    /* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            OverridingUtil.d.a.values();
            a = new int[]{1, 0, 0};
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.p$b */
    /* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
    public static final class b extends Lambda implements Function1<ValueParameterDescriptor, KotlinType> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final KotlinType invoke(ValueParameterDescriptor valueParameterDescriptor) {
            return valueParameterDescriptor.getType();
        }
    }

    @Override // d0.e0.p.d.m0.k.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.a getContract() {
        return ExternalOverridabilityCondition.a.SUCCESS_ONLY;
    }

    @Override // d0.e0.p.d.m0.k.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.b isOverridable(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        boolean z2;
        CallableDescriptor callableDescriptorSubstitute;
        ExternalOverridabilityCondition.b bVar = ExternalOverridabilityCondition.b.UNKNOWN;
        Intrinsics3.checkNotNullParameter(callableDescriptor, "superDescriptor");
        Intrinsics3.checkNotNullParameter(callableDescriptor2, "subDescriptor");
        if (!(callableDescriptor2 instanceof JavaMethodDescriptor)) {
            return bVar;
        }
        JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) callableDescriptor2;
        List<TypeParameterDescriptor> typeParameters = javaMethodDescriptor.getTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(typeParameters, "subDescriptor.typeParameters");
        if (!typeParameters.isEmpty()) {
            return bVar;
        }
        OverridingUtil.d basicOverridabilityProblem = OverridingUtil.getBasicOverridabilityProblem(callableDescriptor, callableDescriptor2);
        if ((basicOverridabilityProblem == null ? null : basicOverridabilityProblem.getResult()) != null) {
            return bVar;
        }
        List<ValueParameterDescriptor> valueParameters = javaMethodDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "subDescriptor.valueParameters");
        Sequence map = _Sequences2.map(_Collections.asSequence(valueParameters), b.j);
        KotlinType returnType = javaMethodDescriptor.getReturnType();
        Intrinsics3.checkNotNull(returnType);
        Sequence sequencePlus = _Sequences2.plus((Sequence<? extends KotlinType>) map, returnType);
        ReceiverParameterDescriptor extensionReceiverParameter = javaMethodDescriptor.getExtensionReceiverParameter();
        Iterator it = _Sequences2.plus(sequencePlus, (Iterable) Collections2.listOfNotNull(extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null)).iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            KotlinType kotlinType = (KotlinType) it.next();
            if ((kotlinType.getArguments().isEmpty() ^ true) && !(kotlinType.unwrap() instanceof RawType2)) {
                z2 = true;
                break;
            }
        }
        if (z2 || (callableDescriptorSubstitute = callableDescriptor.substitute(RawType.f3341b.buildSubstitutor())) == null) {
            return bVar;
        }
        if (callableDescriptorSubstitute instanceof SimpleFunctionDescriptor) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) callableDescriptorSubstitute;
            List<TypeParameterDescriptor> typeParameters2 = simpleFunctionDescriptor.getTypeParameters();
            Intrinsics3.checkNotNullExpressionValue(typeParameters2, "erasedSuper.typeParameters");
            if (!typeParameters2.isEmpty()) {
                callableDescriptorSubstitute = (SimpleFunctionDescriptor) simpleFunctionDescriptor.newCopyBuilder().setTypeParameters(Collections2.emptyList()).build();
                Intrinsics3.checkNotNull(callableDescriptorSubstitute);
            }
        }
        OverridingUtil.d.a result = OverridingUtil.f3468b.isOverridableByWithoutExternalConditions(callableDescriptorSubstitute, callableDescriptor2, false).getResult();
        Intrinsics3.checkNotNullExpressionValue(result, "DEFAULT.isOverridableByWithoutExternalConditions(erasedSuper, subDescriptor, false).result");
        return a.a[result.ordinal()] == 1 ? ExternalOverridabilityCondition.b.OVERRIDABLE : bVar;
    }
}
