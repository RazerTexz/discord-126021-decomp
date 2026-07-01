package d0.e0.p.d.m0.b.p;

import androidx.exifinterface.media.ExifInterface;
import d0.e0.p.d.m0.b.functionTypes;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl;
import d0.e0.p.d.m0.c.i1.SimpleFunctionDescriptorImpl;
import d0.e0.p.d.m0.c.i1.ValueParameterDescriptorImpl;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.TypeSubstitutor2;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.o.OperatorNameConventions;
import d0.t.Collections2;
import d0.t.IndexedValue;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.e, reason: use source file name */
/* JADX INFO: compiled from: FunctionInvokeDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FunctionInvokeDescriptor extends SimpleFunctionDescriptorImpl {
    public static final a M = new a(null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.e$a */
    /* JADX INFO: compiled from: FunctionInvokeDescriptor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final FunctionInvokeDescriptor create(FunctionClassDescriptor functionClassDescriptor, boolean z2) {
            String lowerCase;
            Intrinsics3.checkNotNullParameter(functionClassDescriptor, "functionClass");
            List<TypeParameterDescriptor> declaredTypeParameters = functionClassDescriptor.getDeclaredTypeParameters();
            FunctionInvokeDescriptor functionInvokeDescriptor = new FunctionInvokeDescriptor(functionClassDescriptor, null, CallableMemberDescriptor.a.DECLARATION, z2, null);
            ReceiverParameterDescriptor thisAsReceiverParameter = functionClassDescriptor.getThisAsReceiverParameter();
            List<? extends TypeParameterDescriptor> listEmptyList = Collections2.emptyList();
            ArrayList arrayList = new ArrayList();
            for (Object obj : declaredTypeParameters) {
                if (!(((TypeParameterDescriptor) obj).getVariance() == Variance.IN_VARIANCE)) {
                    break;
                }
                arrayList.add(obj);
            }
            Iterable<IndexedValue> iterableWithIndex = _Collections.withIndex(arrayList);
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(iterableWithIndex, 10));
            for (IndexedValue indexedValue : iterableWithIndex) {
                int index = indexedValue.getIndex();
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) indexedValue.getValue();
                String strAsString = typeParameterDescriptor.getName().asString();
                Intrinsics3.checkNotNullExpressionValue(strAsString, "typeParameter.name.asString()");
                if (Intrinsics3.areEqual(strAsString, ExifInterface.GPS_DIRECTION_TRUE)) {
                    lowerCase = "instance";
                } else if (Intrinsics3.areEqual(strAsString, ExifInterface.LONGITUDE_EAST)) {
                    lowerCase = "receiver";
                } else {
                    lowerCase = strAsString.toLowerCase();
                    Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                }
                Annotations4 empty = Annotations4.f.getEMPTY();
                Name nameIdentifier = Name.identifier(lowerCase);
                Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(name)");
                KotlinType4 defaultType = typeParameterDescriptor.getDefaultType();
                Intrinsics3.checkNotNullExpressionValue(defaultType, "typeParameter.defaultType");
                SourceElement sourceElement = SourceElement.a;
                Intrinsics3.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
                ArrayList arrayList3 = arrayList2;
                arrayList3.add(new ValueParameterDescriptorImpl(functionInvokeDescriptor, null, index, empty, nameIdentifier, defaultType, false, false, false, null, sourceElement));
                arrayList2 = arrayList3;
            }
            functionInvokeDescriptor.initialize((ReceiverParameterDescriptor) null, thisAsReceiverParameter, listEmptyList, (List<ValueParameterDescriptor>) arrayList2, (KotlinType) ((TypeParameterDescriptor) _Collections.last((List) declaredTypeParameters)).getDefaultType(), Modality.ABSTRACT, DescriptorVisibilities.e);
            functionInvokeDescriptor.setHasSynthesizedParameterNames(true);
            return functionInvokeDescriptor;
        }
    }

    public FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, CallableMemberDescriptor.a aVar, boolean z2) {
        super(declarationDescriptor, functionInvokeDescriptor, Annotations4.f.getEMPTY(), OperatorNameConventions.g, aVar, SourceElement.a);
        setOperator(true);
        setSuspend(z2);
        setHasStableParameterNames(false);
    }

    public /* synthetic */ FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, CallableMemberDescriptor.a aVar, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(declarationDescriptor, functionInvokeDescriptor, aVar, z2);
    }

    @Override // d0.e0.p.d.m0.c.i1.SimpleFunctionDescriptorImpl, d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl
    public FunctionDescriptorImpl b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(sourceElement, "source");
        return new FunctionInvokeDescriptor(declarationDescriptor, (FunctionInvokeDescriptor) functionDescriptor, aVar, isSuspend());
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl
    public FunctionDescriptor c(FunctionDescriptorImpl.c cVar) {
        boolean z2;
        Name name;
        Intrinsics3.checkNotNullParameter(cVar, "configuration");
        FunctionInvokeDescriptor functionInvokeDescriptor = (FunctionInvokeDescriptor) super.c(cVar);
        if (functionInvokeDescriptor == null) {
            return null;
        }
        List<ValueParameterDescriptor> valueParameters = functionInvokeDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "substituted.valueParameters");
        boolean z3 = true;
        if (!(valueParameters instanceof Collection) || !valueParameters.isEmpty()) {
            Iterator<T> it = valueParameters.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                }
                KotlinType type = ((ValueParameterDescriptor) it.next()).getType();
                Intrinsics3.checkNotNullExpressionValue(type, "it.type");
                if (functionTypes.extractParameterNameFromFunctionTypeArgument(type) != null) {
                    z2 = false;
                    break;
                }
            }
        } else {
            z2 = true;
            break;
        }
        if (z2) {
            return functionInvokeDescriptor;
        }
        List<ValueParameterDescriptor> valueParameters2 = functionInvokeDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters2, "substituted.valueParameters");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(valueParameters2, 10));
        Iterator<T> it2 = valueParameters2.iterator();
        while (it2.hasNext()) {
            KotlinType type2 = ((ValueParameterDescriptor) it2.next()).getType();
            Intrinsics3.checkNotNullExpressionValue(type2, "it.type");
            arrayList.add(functionTypes.extractParameterNameFromFunctionTypeArgument(type2));
        }
        int size = functionInvokeDescriptor.getValueParameters().size() - arrayList.size();
        List<ValueParameterDescriptor> valueParameters3 = functionInvokeDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters3, "valueParameters");
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(valueParameters3, 10));
        for (ValueParameterDescriptor valueParameterDescriptor : valueParameters3) {
            Name name2 = valueParameterDescriptor.getName();
            Intrinsics3.checkNotNullExpressionValue(name2, "it.name");
            int index = valueParameterDescriptor.getIndex();
            int i = index - size;
            if (i >= 0 && (name = (Name) arrayList.get(i)) != null) {
                name2 = name;
            }
            arrayList2.add(valueParameterDescriptor.copy(functionInvokeDescriptor, name2, index));
        }
        FunctionDescriptorImpl.c cVarD = functionInvokeDescriptor.d(TypeSubstitutor2.a);
        if (arrayList.isEmpty()) {
            z3 = false;
        } else {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                if (((Name) it3.next()) == null) {
                }
            }
            z3 = false;
        }
        FunctionDescriptorImpl.c original = cVarD.setHasSynthesizedParameterNames(z3).setValueParameters((List<ValueParameterDescriptor>) arrayList2).setOriginal((CallableMemberDescriptor) functionInvokeDescriptor.getOriginal());
        Intrinsics3.checkNotNullExpressionValue(original, "newCopyBuilder(TypeSubstitutor.EMPTY)\n                .setHasSynthesizedParameterNames(parameterNames.any { it == null })\n                .setValueParameters(newValueParameters)\n                .setOriginal(original)");
        FunctionDescriptor functionDescriptorC = super.c(original);
        Intrinsics3.checkNotNull(functionDescriptorC);
        return functionDescriptorC;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }
}
