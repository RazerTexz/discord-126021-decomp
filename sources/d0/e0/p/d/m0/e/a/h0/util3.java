package d0.e0.p.d.m0.e.a.h0;

import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.ValueParameterDescriptorImpl;
import d0.e0.p.d.m0.e.a.JvmAnnotationNames;
import d0.e0.p.d.m0.e.a.i0.l.LazyJavaStaticClassScope2;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.v.w;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Tuples2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h0.k, reason: use source file name */
/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class util3 {
    public static final List<ValueParameterDescriptor> copyValueParameters(Collection<util4> collection, Collection<? extends ValueParameterDescriptor> collection2, CallableDescriptor callableDescriptor) {
        Intrinsics3.checkNotNullParameter(collection, "newValueParametersTypes");
        Intrinsics3.checkNotNullParameter(collection2, "oldValueParameters");
        Intrinsics3.checkNotNullParameter(callableDescriptor, "newOwner");
        collection.size();
        collection2.size();
        List<Tuples2> listZip = _Collections.zip(collection, collection2);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listZip, 10));
        for (Tuples2 tuples2 : listZip) {
            util4 util4Var = (util4) tuples2.component1();
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) tuples2.component2();
            int index = valueParameterDescriptor.getIndex();
            Annotations4 annotations = valueParameterDescriptor.getAnnotations();
            Name name = valueParameterDescriptor.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "oldParameter.name");
            KotlinType type = util4Var.getType();
            boolean hasDefaultValue = util4Var.getHasDefaultValue();
            boolean zIsCrossinline = valueParameterDescriptor.isCrossinline();
            boolean zIsNoinline = valueParameterDescriptor.isNoinline();
            KotlinType arrayElementType = valueParameterDescriptor.getVarargElementType() != null ? DescriptorUtils2.getModule(callableDescriptor).getBuiltIns().getArrayElementType(util4Var.getType()) : null;
            SourceElement source = valueParameterDescriptor.getSource();
            Intrinsics3.checkNotNullExpressionValue(source, "oldParameter.source");
            arrayList.add(new ValueParameterDescriptorImpl(callableDescriptor, null, index, annotations, name, type, hasDefaultValue, zIsCrossinline, zIsNoinline, arrayElementType, source));
        }
        return arrayList;
    }

    public static final AnnotationDefaultValue getDefaultValueFromAnnotation(ValueParameterDescriptor valueParameterDescriptor) {
        d0.e0.p.d.m0.k.v.g<?> gVarFirstArgument;
        w wVar;
        String value;
        Intrinsics3.checkNotNullParameter(valueParameterDescriptor, "<this>");
        Annotations4 annotations = valueParameterDescriptor.getAnnotations();
        FqName fqName = JvmAnnotationNames.r;
        Intrinsics3.checkNotNullExpressionValue(fqName, "DEFAULT_VALUE_FQ_NAME");
        AnnotationDescriptor annotationDescriptorFindAnnotation = annotations.findAnnotation(fqName);
        if (annotationDescriptorFindAnnotation == null || (gVarFirstArgument = DescriptorUtils2.firstArgument(annotationDescriptorFindAnnotation)) == null) {
            wVar = null;
        } else {
            if (!(gVarFirstArgument instanceof w)) {
                gVarFirstArgument = null;
            }
            wVar = (w) gVarFirstArgument;
        }
        if (wVar != null && (value = wVar.getValue()) != null) {
            return new AnnotationDefaultValue3(value);
        }
        Annotations4 annotations2 = valueParameterDescriptor.getAnnotations();
        FqName fqName2 = JvmAnnotationNames.f3306s;
        Intrinsics3.checkNotNullExpressionValue(fqName2, "DEFAULT_NULL_FQ_NAME");
        if (annotations2.hasAnnotation(fqName2)) {
            return AnnotationDefaultValue2.a;
        }
        return null;
    }

    public static final LazyJavaStaticClassScope2 getParentJavaStaticClassScope(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "<this>");
        ClassDescriptor superClassNotAny = DescriptorUtils2.getSuperClassNotAny(classDescriptor);
        if (superClassNotAny == null) {
            return null;
        }
        MemberScope3 staticScope = superClassNotAny.getStaticScope();
        LazyJavaStaticClassScope2 lazyJavaStaticClassScope2 = staticScope instanceof LazyJavaStaticClassScope2 ? (LazyJavaStaticClassScope2) staticScope : null;
        return lazyJavaStaticClassScope2 == null ? getParentJavaStaticClassScope(superClassNotAny) : lazyJavaStaticClassScope2;
    }
}
