package d0.e0.p.d.l0;

import d0.z.d.m;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CallerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e$h extends e<Method> {
    public final boolean f;

    public /* synthetic */ e$h(Method method, boolean z2, Type[] typeArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(method, z2, typeArr);
    }

    public final Object b(Object obj, Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        return this.f ? Unit.a : mo80getMember().invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ e$h(Method method, boolean z2, Type[] typeArr, int i) {
        Type[] genericParameterTypes;
        z2 = (i & 2) != 0 ? !Modifier.isStatic(method.getModifiers()) : z2;
        if ((i & 4) != 0) {
            genericParameterTypes = method.getGenericParameterTypes();
            m.checkNotNullExpressionValue(genericParameterTypes, "method.genericParameterTypes");
        } else {
            genericParameterTypes = null;
        }
        this(method, z2, genericParameterTypes);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public e$h(Method method, boolean z2, Type[] typeArr) {
        Type genericReturnType = method.getGenericReturnType();
        m.checkNotNullExpressionValue(genericReturnType, "method.genericReturnType");
        super(method, genericReturnType, z2 ? method.getDeclaringClass() : null, typeArr, null);
        this.f = m.areEqual(getReturnType(), Void.TYPE);
    }
}
