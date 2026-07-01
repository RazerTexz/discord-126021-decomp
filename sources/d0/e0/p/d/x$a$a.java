package d0.e0.p.d;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: KTypeImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x$a$a extends d0.z.d.o implements Function0<Type> {
    public final /* synthetic */ int $i;
    public final /* synthetic */ Lazy $parameterizedTypeArguments$inlined;
    public final /* synthetic */ KProperty $parameterizedTypeArguments$metadata$inlined = null;
    public final /* synthetic */ x$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x$a$a(int i, x$a x_a, Lazy lazy, KProperty kProperty) {
        super(0);
        this.$i = i;
        this.this$0 = x_a;
        this.$parameterizedTypeArguments$inlined = lazy;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Type invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Type invoke2() {
        Type javaType = this.this$0.this$0.getJavaType();
        if (javaType instanceof Class) {
            Class cls = (Class) javaType;
            Class<?> componentType = cls.isArray() ? cls.getComponentType() : Object.class;
            d0.z.d.m.checkNotNullExpressionValue(componentType, "if (javaType.isArray) ja…Type else Any::class.java");
            return componentType;
        }
        if (javaType instanceof GenericArrayType) {
            if (this.$i == 0) {
                Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
                d0.z.d.m.checkNotNullExpressionValue(genericComponentType, "javaType.genericComponentType");
                return genericComponentType;
            }
            StringBuilder sbU = b.d.b.a.a.U("Array type has been queried for a non-0th argument: ");
            sbU.append(this.this$0.this$0);
            throw new a0(sbU.toString());
        }
        if (!(javaType instanceof ParameterizedType)) {
            StringBuilder sbU2 = b.d.b.a.a.U("Non-generic type has been queried for arguments: ");
            sbU2.append(this.this$0.this$0);
            throw new a0(sbU2.toString());
        }
        Type type = (Type) ((List) this.$parameterizedTypeArguments$inlined.getValue()).get(this.$i);
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            d0.z.d.m.checkNotNullExpressionValue(lowerBounds, "argument.lowerBounds");
            Type type2 = (Type) d0.t.k.firstOrNull(lowerBounds);
            if (type2 != null) {
                type = type2;
            } else {
                Type[] upperBounds = wildcardType.getUpperBounds();
                d0.z.d.m.checkNotNullExpressionValue(upperBounds, "argument.upperBounds");
                type = (Type) d0.t.k.first(upperBounds);
            }
        }
        d0.z.d.m.checkNotNullExpressionValue(type, "if (argument !is Wildcar…ument.upperBounds.first()");
        return type;
    }
}
