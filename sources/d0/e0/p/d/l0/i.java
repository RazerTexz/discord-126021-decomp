package d0.e0.p.d.l0;

import d0.z.d.m;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: InternalUnderlyingValOfInlineClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i implements d<Method> {
    public final Type a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f3207b;
    public final List<Type> c;

    public i(Method method, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this.f3207b = method;
        this.c = list;
        Class<?> returnType = method.getReturnType();
        m.checkNotNullExpressionValue(returnType, "unboxMethod.returnType");
        this.a = returnType;
    }

    public void checkArguments(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        d$a.checkArguments(this, objArr);
    }

    @Override // d0.e0.p.d.l0.d
    /* JADX INFO: renamed from: getMember */
    public /* bridge */ /* synthetic */ Member mo80getMember() {
        return mo80getMember();
    }

    @Override // d0.e0.p.d.l0.d
    /* JADX INFO: renamed from: getMember */
    public final Method mo80getMember() {
        return null;
    }

    @Override // d0.e0.p.d.l0.d
    public final List<Type> getParameterTypes() {
        return this.c;
    }

    @Override // d0.e0.p.d.l0.d
    public final Type getReturnType() {
        return this.a;
    }
}
