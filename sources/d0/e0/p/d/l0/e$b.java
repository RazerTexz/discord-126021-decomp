package d0.e0.p.d.l0;

import d0.z.d.c0;
import d0.z.d.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: compiled from: CallerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$b extends e<Constructor<?>> {
    /* JADX WARN: Illegal instructions before constructor call */
    public e$b(Constructor<?> constructor) {
        Object objCopyOfRange;
        m.checkNotNullParameter(constructor, "constructor");
        Class<?> declaringClass = constructor.getDeclaringClass();
        m.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
        Type[] genericParameterTypes = constructor.getGenericParameterTypes();
        m.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
        if (genericParameterTypes.length <= 1) {
            objCopyOfRange = new Type[0];
        } else {
            objCopyOfRange = d0.t.j.copyOfRange(genericParameterTypes, 0, genericParameterTypes.length - 1);
            Objects.requireNonNull(objCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
        }
        super(constructor, declaringClass, null, (Type[]) objCopyOfRange, null);
    }

    @Override // d0.e0.p.d.l0.d
    public Object call(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        checkArguments(objArr);
        Constructor<?> constructorMo80getMember = mo80getMember();
        c0 c0Var = new c0(2);
        c0Var.addSpread(objArr);
        c0Var.add(null);
        return constructorMo80getMember.newInstance(c0Var.toArray(new Object[c0Var.size()]));
    }
}
