package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.b.PrimitiveType;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.t._Arrays;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.h, reason: use source file name */
/* JADX INFO: compiled from: ConstantValueFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConstantValueFactory {
    public static final ConstantValueFactory a = new ConstantValueFactory();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.h$a */
    /* JADX INFO: compiled from: ConstantValueFactory.kt */
    public static final class a extends Lambda implements Function1<ModuleDescriptor2, KotlinType> {
        public final /* synthetic */ KotlinType $type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(KotlinType kotlinType) {
            super(1);
            this.$type = kotlinType;
        }

        @Override // kotlin.jvm.functions.Function1
        public final KotlinType invoke(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "it");
            return this.$type;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.h$b */
    /* JADX INFO: compiled from: ConstantValueFactory.kt */
    public static final class b extends Lambda implements Function1<ModuleDescriptor2, KotlinType> {
        public final /* synthetic */ PrimitiveType $componentType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PrimitiveType primitiveType) {
            super(1);
            this.$componentType = primitiveType;
        }

        @Override // kotlin.jvm.functions.Function1
        public final KotlinType invoke(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
            KotlinType4 primitiveArrayKotlinType = moduleDescriptor2.getBuiltIns().getPrimitiveArrayKotlinType(this.$componentType);
            Intrinsics3.checkNotNullExpressionValue(primitiveArrayKotlinType, "module.builtIns.getPrimitiveArrayKotlinType(componentType)");
            return primitiveArrayKotlinType;
        }
    }

    public final d0.e0.p.d.m0.k.v.b a(List<?> list, PrimitiveType primitiveType) {
        List list2 = _Collections.toList(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            g<?> gVarCreateConstantValue = createConstantValue(it.next());
            if (gVarCreateConstantValue != null) {
                arrayList.add(gVarCreateConstantValue);
            }
        }
        return new d0.e0.p.d.m0.k.v.b(arrayList, new b(primitiveType));
    }

    public final d0.e0.p.d.m0.k.v.b createArrayValue(List<? extends g<?>> list, KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(list, "value");
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        return new d0.e0.p.d.m0.k.v.b(list, new a(kotlinType));
    }

    public final g<?> createConstantValue(Object obj) {
        if (obj instanceof Byte) {
            return new d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new v(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new m(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new s(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new e(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new l(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new i(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new c(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new w((String) obj);
        }
        if (obj instanceof byte[]) {
            return a(_Arrays.toList((byte[]) obj), PrimitiveType.BYTE);
        }
        if (obj instanceof short[]) {
            return a(_Arrays.toList((short[]) obj), PrimitiveType.SHORT);
        }
        if (obj instanceof int[]) {
            return a(_Arrays.toList((int[]) obj), PrimitiveType.INT);
        }
        if (obj instanceof long[]) {
            return a(_Arrays.toList((long[]) obj), PrimitiveType.LONG);
        }
        if (obj instanceof char[]) {
            return a(_Arrays.toList((char[]) obj), PrimitiveType.CHAR);
        }
        if (obj instanceof float[]) {
            return a(_Arrays.toList((float[]) obj), PrimitiveType.FLOAT);
        }
        if (obj instanceof double[]) {
            return a(_Arrays.toList((double[]) obj), PrimitiveType.DOUBLE);
        }
        if (obj instanceof boolean[]) {
            return a(_Arrays.toList((boolean[]) obj), PrimitiveType.BOOLEAN);
        }
        if (obj == null) {
            return new t();
        }
        return null;
    }
}
