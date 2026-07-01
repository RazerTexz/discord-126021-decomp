package d0.e0.p.d.m0.b;

import androidx.exifinterface.media.ExifInterface;
import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.EmptyPackageFragmentDesciptor;
import d0.e0.p.d.m0.c.i1.MutableClassDescriptor;
import d0.e0.p.d.m0.c.i1.TypeParameterDescriptorImpl;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.m.LockBasedStorageManager;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.l, reason: use source file name */
/* JADX INFO: compiled from: suspendFunctionTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class suspendFunctionTypes {
    public static final MutableClassDescriptor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableClassDescriptor f3231b;

    static {
        ModuleDescriptor2 errorModule = ErrorUtils.getErrorModule();
        Intrinsics3.checkNotNullExpressionValue(errorModule, "getErrorModule()");
        EmptyPackageFragmentDesciptor emptyPackageFragmentDesciptor = new EmptyPackageFragmentDesciptor(errorModule, StandardNames.e);
        ClassKind classKind = ClassKind.INTERFACE;
        Name nameShortName = StandardNames.f.shortName();
        SourceElement sourceElement = SourceElement.a;
        StorageManager storageManager = LockBasedStorageManager.f3514b;
        MutableClassDescriptor mutableClassDescriptor = new MutableClassDescriptor(emptyPackageFragmentDesciptor, classKind, false, false, nameShortName, sourceElement, storageManager);
        Modality modality = Modality.ABSTRACT;
        mutableClassDescriptor.setModality(modality);
        DescriptorVisibility2 descriptorVisibility2 = DescriptorVisibilities.e;
        mutableClassDescriptor.setVisibility(descriptorVisibility2);
        Annotations4.a aVar = Annotations4.f;
        Annotations4 empty = aVar.getEMPTY();
        Variance variance = Variance.IN_VARIANCE;
        mutableClassDescriptor.setTypeParameterDescriptors(CollectionsJVM.listOf(TypeParameterDescriptorImpl.createWithDefaultBound(mutableClassDescriptor, empty, false, variance, Name.identifier(ExifInterface.GPS_DIRECTION_TRUE), 0, storageManager)));
        mutableClassDescriptor.createTypeConstructor();
        a = mutableClassDescriptor;
        ModuleDescriptor2 errorModule2 = ErrorUtils.getErrorModule();
        Intrinsics3.checkNotNullExpressionValue(errorModule2, "getErrorModule()");
        MutableClassDescriptor mutableClassDescriptor2 = new MutableClassDescriptor(new EmptyPackageFragmentDesciptor(errorModule2, StandardNames.d), classKind, false, false, StandardNames.g.shortName(), sourceElement, storageManager);
        mutableClassDescriptor2.setModality(modality);
        mutableClassDescriptor2.setVisibility(descriptorVisibility2);
        mutableClassDescriptor2.setTypeParameterDescriptors(CollectionsJVM.listOf(TypeParameterDescriptorImpl.createWithDefaultBound(mutableClassDescriptor2, aVar.getEMPTY(), false, variance, Name.identifier(ExifInterface.GPS_DIRECTION_TRUE), 0, storageManager)));
        mutableClassDescriptor2.createTypeConstructor();
        f3231b = mutableClassDescriptor2;
    }

    public static final boolean isContinuation(FqName fqName, boolean z2) {
        return z2 ? Intrinsics3.areEqual(fqName, StandardNames.g) : Intrinsics3.areEqual(fqName, StandardNames.f);
    }

    public static final KotlinType4 transformSuspendFunctionToRuntimeFunctionType(KotlinType kotlinType, boolean z2) {
        Intrinsics3.checkNotNullParameter(kotlinType, "suspendFunType");
        functionTypes.isSuspendFunctionType(kotlinType);
        KotlinBuiltIns builtIns = TypeUtils2.getBuiltIns(kotlinType);
        Annotations4 annotations = kotlinType.getAnnotations();
        KotlinType receiverTypeFromFunctionType = functionTypes.getReceiverTypeFromFunctionType(kotlinType);
        List<TypeProjection> valueParameterTypesFromFunctionType = functionTypes.getValueParameterTypesFromFunctionType(kotlinType);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(valueParameterTypesFromFunctionType, 10));
        Iterator<T> it = valueParameterTypesFromFunctionType.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeProjection) it.next()).getType());
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        Annotations4 empty = Annotations4.f.getEMPTY();
        TypeConstructor typeConstructor = z2 ? f3231b.getTypeConstructor() : a.getTypeConstructor();
        Intrinsics3.checkNotNullExpressionValue(typeConstructor, "if (isReleaseCoroutines) FAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE.typeConstructor\n                    else FAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL.typeConstructor");
        List listPlus = _Collections.plus((Collection<? extends KotlinType4>) arrayList, KotlinTypeFactory.simpleType$default(empty, typeConstructor, CollectionsJVM.listOf(TypeUtils2.asTypeProjection(functionTypes.getReturnTypeFromFunctionType(kotlinType))), false, null, 16, null));
        KotlinType4 nullableAnyType = TypeUtils2.getBuiltIns(kotlinType).getNullableAnyType();
        Intrinsics3.checkNotNullExpressionValue(nullableAnyType, "suspendFunType.builtIns.nullableAnyType");
        return functionTypes.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, listPlus, null, nullableAnyType, (64 & 64) != 0 ? false : false).makeNullableAsSpecified(kotlinType.isMarkedNullable());
    }
}
