package d0.e0.p.d.l0;

import d0.z.d.c0;
import d0.z.d.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: CallerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$c extends e<Constructor<?>> implements c {
    public final Object f;

    /* JADX WARN: Illegal instructions before constructor call */
    public e$c(Constructor<?> constructor, Object obj) {
        m.checkNotNullParameter(constructor, "constructor");
        Class<?> declaringClass = constructor.getDeclaringClass();
        m.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
        Type[] genericParameterTypes = constructor.getGenericParameterTypes();
        m.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
        super(constructor, declaringClass, null, genericParameterTypes, null);
        this.f = obj;
    }

    @Override // d0.e0.p.d.l0.d
    public Object call(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        checkArguments(objArr);
        Constructor<?> constructorMo80getMember = mo80getMember();
        c0 c0Var = new c0(2);
        c0Var.add(this.f);
        c0Var.addSpread(objArr);
        return constructorMo80getMember.newInstance(c0Var.toArray(new Object[c0Var.size()]));
    }
}
