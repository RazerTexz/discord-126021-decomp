package d0.e0.p.d.m0.l.b;

import b.d.b.a.outline;
import d0.d0._Ranges;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ClassConstructorDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.NotFoundClasses;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.findClassInModule;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptorImpl;
import d0.e0.p.d.m0.f.b;
import d0.e0.p.d.m0.f.z.Flags2;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.v.ConstantValueFactory;
import d0.e0.p.d.m0.k.v.k;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e, reason: use source file name */
/* JADX INFO: compiled from: AnnotationDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationDeserializer {
    public final ModuleDescriptor2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NotFoundClasses f3486b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e$a */
    /* JADX INFO: compiled from: AnnotationDeserializer.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            b.C0393b.c.EnumC0396c.values();
            a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        }
    }

    public AnnotationDeserializer(ModuleDescriptor2 moduleDescriptor2, NotFoundClasses notFoundClasses) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        this.a = moduleDescriptor2;
        this.f3486b = notFoundClasses;
    }

    public final boolean a(d0.e0.p.d.m0.k.v.g<?> gVar, KotlinType kotlinType, b.C0393b.c cVar) {
        b.C0393b.c.EnumC0396c type = cVar.getType();
        int i = type == null ? -1 : a.a[type.ordinal()];
        if (i != 10) {
            if (i != 13) {
                return Intrinsics3.areEqual(gVar.getType(this.a), kotlinType);
            }
            if (!((gVar instanceof d0.e0.p.d.m0.k.v.b) && ((d0.e0.p.d.m0.k.v.b) gVar).getValue().size() == cVar.getArrayElementList().size())) {
                throw new IllegalStateException(Intrinsics3.stringPlus("Deserialized ArrayValue should have the same number of elements as the original array value: ", gVar).toString());
            }
            KotlinType arrayElementType = this.a.getBuiltIns().getArrayElementType(kotlinType);
            Intrinsics3.checkNotNullExpressionValue(arrayElementType, "builtIns.getArrayElementType(expectedType)");
            d0.e0.p.d.m0.k.v.b bVar = (d0.e0.p.d.m0.k.v.b) gVar;
            Iterable indices = Collections2.getIndices(bVar.getValue());
            if ((indices instanceof Collection) && ((Collection) indices).isEmpty()) {
                return true;
            }
            Iterator it = indices.iterator();
            while (it.hasNext()) {
                int iNextInt = ((Iterators4) it).nextInt();
                d0.e0.p.d.m0.k.v.g<?> gVar2 = bVar.getValue().get(iNextInt);
                b.C0393b.c arrayElement = cVar.getArrayElement(iNextInt);
                Intrinsics3.checkNotNullExpressionValue(arrayElement, "value.getArrayElement(i)");
                if (!a(gVar2, arrayElementType, arrayElement)) {
                }
            }
            return true;
        }
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
        if (classDescriptor == null || KotlinBuiltIns.isKClass(classDescriptor)) {
            return true;
        }
        return false;
    }

    public final AnnotationDescriptor deserializeAnnotation(d0.e0.p.d.m0.f.b bVar, NameResolver nameResolver) {
        Intrinsics3.checkNotNullParameter(bVar, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        ClassDescriptor classDescriptorFindNonGenericClassAcrossDependencies = findClassInModule.findNonGenericClassAcrossDependencies(this.a, NameResolverUtil.getClassId(nameResolver, bVar.getId()), this.f3486b);
        Map mapEmptyMap = Maps6.emptyMap();
        if (bVar.getArgumentCount() != 0 && !ErrorUtils.isError(classDescriptorFindNonGenericClassAcrossDependencies) && DescriptorUtils.isAnnotationClass(classDescriptorFindNonGenericClassAcrossDependencies)) {
            Collection<ClassConstructorDescriptor> constructors = classDescriptorFindNonGenericClassAcrossDependencies.getConstructors();
            Intrinsics3.checkNotNullExpressionValue(constructors, "annotationClass.constructors");
            ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) _Collections.singleOrNull(constructors);
            if (classConstructorDescriptor != null) {
                List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                Intrinsics3.checkNotNullExpressionValue(valueParameters, "constructor.valueParameters");
                LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(valueParameters, 10)), 16));
                for (Object obj : valueParameters) {
                    linkedHashMap.put(((ValueParameterDescriptor) obj).getName(), obj);
                }
                List<b.C0393b> argumentList = bVar.getArgumentList();
                ArrayList arrayListA0 = outline.a0(argumentList, "proto.argumentList");
                for (b.C0393b c0393b : argumentList) {
                    Intrinsics3.checkNotNullExpressionValue(c0393b, "it");
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) linkedHashMap.get(NameResolverUtil.getName(nameResolver, c0393b.getNameId()));
                    Object tuples2 = null;
                    if (valueParameterDescriptor != null) {
                        Name name = NameResolverUtil.getName(nameResolver, c0393b.getNameId());
                        KotlinType type = valueParameterDescriptor.getType();
                        Intrinsics3.checkNotNullExpressionValue(type, "parameter.type");
                        b.C0393b.c value = c0393b.getValue();
                        Intrinsics3.checkNotNullExpressionValue(value, "proto.value");
                        d0.e0.p.d.m0.k.v.g<?> gVarResolveValue = resolveValue(type, value, nameResolver);
                        tuples2 = a(gVarResolveValue, type, value) ? gVarResolveValue : null;
                        if (tuples2 == null) {
                            k.a aVar = d0.e0.p.d.m0.k.v.k.f3474b;
                            StringBuilder sbU = outline.U("Unexpected argument value: actual type ");
                            sbU.append(value.getType());
                            sbU.append(" != expected type ");
                            sbU.append(type);
                            tuples2 = aVar.create(sbU.toString());
                        }
                        tuples2 = new Tuples2(name, tuples2);
                    }
                    if (tuples2 != null) {
                        arrayListA0.add(tuples2);
                    }
                }
                mapEmptyMap = Maps6.toMap(arrayListA0);
            }
        }
        return new AnnotationDescriptorImpl(classDescriptorFindNonGenericClassAcrossDependencies.getDefaultType(), mapEmptyMap, SourceElement.a);
    }

    public final d0.e0.p.d.m0.k.v.g<?> resolveValue(KotlinType kotlinType, b.C0393b.c cVar, NameResolver nameResolver) {
        d0.e0.p.d.m0.k.v.g<?> xVar;
        Intrinsics3.checkNotNullParameter(kotlinType, "expectedType");
        Intrinsics3.checkNotNullParameter(cVar, "value");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Boolean bool = Flags2.M.get(cVar.getFlags());
        Intrinsics3.checkNotNullExpressionValue(bool, "IS_UNSIGNED.get(value.flags)");
        boolean zBooleanValue = bool.booleanValue();
        b.C0393b.c.EnumC0396c type = cVar.getType();
        switch (type == null ? -1 : a.a[type.ordinal()]) {
            case 1:
                byte intValue = (byte) cVar.getIntValue();
                xVar = zBooleanValue ? new d0.e0.p.d.m0.k.v.x(intValue) : new d0.e0.p.d.m0.k.v.d(intValue);
                break;
            case 2:
                return new d0.e0.p.d.m0.k.v.e((char) cVar.getIntValue());
            case 3:
                short intValue2 = (short) cVar.getIntValue();
                xVar = zBooleanValue ? new d0.e0.p.d.m0.k.v.a0(intValue2) : new d0.e0.p.d.m0.k.v.v(intValue2);
                break;
            case 4:
                int intValue3 = (int) cVar.getIntValue();
                return zBooleanValue ? new d0.e0.p.d.m0.k.v.y(intValue3) : new d0.e0.p.d.m0.k.v.m(intValue3);
            case 5:
                long intValue4 = cVar.getIntValue();
                return zBooleanValue ? new d0.e0.p.d.m0.k.v.z(intValue4) : new d0.e0.p.d.m0.k.v.s(intValue4);
            case 6:
                return new d0.e0.p.d.m0.k.v.l(cVar.getFloatValue());
            case 7:
                return new d0.e0.p.d.m0.k.v.i(cVar.getDoubleValue());
            case 8:
                return new d0.e0.p.d.m0.k.v.c(cVar.getIntValue() != 0);
            case 9:
                return new d0.e0.p.d.m0.k.v.w(nameResolver.getString(cVar.getStringValue()));
            case 10:
                return new d0.e0.p.d.m0.k.v.r(NameResolverUtil.getClassId(nameResolver, cVar.getClassId()), cVar.getArrayDimensionCount());
            case 11:
                return new d0.e0.p.d.m0.k.v.j(NameResolverUtil.getClassId(nameResolver, cVar.getClassId()), NameResolverUtil.getName(nameResolver, cVar.getEnumValueId()));
            case 12:
                d0.e0.p.d.m0.f.b annotation = cVar.getAnnotation();
                Intrinsics3.checkNotNullExpressionValue(annotation, "value.annotation");
                return new d0.e0.p.d.m0.k.v.a(deserializeAnnotation(annotation, nameResolver));
            case 13:
                ConstantValueFactory constantValueFactory = ConstantValueFactory.a;
                List<b.C0393b.c> arrayElementList = cVar.getArrayElementList();
                Intrinsics3.checkNotNullExpressionValue(arrayElementList, "value.arrayElementList");
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arrayElementList, 10));
                for (b.C0393b.c cVar2 : arrayElementList) {
                    KotlinType4 anyType = this.a.getBuiltIns().getAnyType();
                    Intrinsics3.checkNotNullExpressionValue(anyType, "builtIns.anyType");
                    Intrinsics3.checkNotNullExpressionValue(cVar2, "it");
                    arrayList.add(resolveValue(anyType, cVar2, nameResolver));
                }
                return constantValueFactory.createArrayValue(arrayList, kotlinType);
            default:
                StringBuilder sbU = outline.U("Unsupported annotation argument type: ");
                sbU.append(cVar.getType());
                sbU.append(" (expected ");
                sbU.append(kotlinType);
                sbU.append(')');
                throw new IllegalStateException(sbU.toString().toString());
        }
        return xVar;
    }
}
