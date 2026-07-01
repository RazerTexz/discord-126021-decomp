package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.l0.e$e;
import d0.e0.p.d.l0.e$h;
import d0.e0.p.d.l0.e$h$a;
import d0.e0.p.d.l0.e$h$b;
import d0.e0.p.d.l0.e$h$c;
import d0.e0.p.d.l0.e$h$d;
import d0.e0.p.d.l0.e$h$e;
import d0.e0.p.d.l0.e$h$f;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: KFunctionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends f<Object> implements d0.z.d.i<Object>, KFunction<Object>, c {
    public static final /* synthetic */ KProperty[] n = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(j.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(j.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(j.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    public final c0$a o;
    public final c0$b p;
    public final c0$b q;
    public final i r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f3200s;
    public final Object t;

    public j(i iVar, String str, String str2, d0.e0.p.d.m0.c.x xVar, Object obj) {
        this.r = iVar;
        this.f3200s = str2;
        this.t = obj;
        this.o = c0.lazySoft(xVar, new j$c(this, str));
        this.p = c0.lazy(new j$a(this));
        this.q = c0.lazy(new j$b(this));
    }

    public static final d0.e0.p.d.l0.e access$createConstructorCaller(j jVar, Constructor constructor, d0.e0.p.d.m0.c.x xVar) {
        Objects.requireNonNull(jVar);
        if (d0.e0.p.d.m0.k.y.a.shouldHideConstructorDueToInlineClassTypeValueParameters(xVar)) {
            return jVar.isBound() ? new d0.e0.p.d.l0.e$a(constructor, jVar.getBoundReceiver()) : new d0.e0.p.d.l0.e$b(constructor);
        }
        return jVar.isBound() ? new d0.e0.p.d.l0.e$c(constructor, jVar.getBoundReceiver()) : new e$e(constructor);
    }

    public static final e$h access$createInstanceMethodCaller(j jVar, Method method) {
        return jVar.isBound() ? new e$h$a(method, jVar.getBoundReceiver()) : new e$h$d(method);
    }

    public static final e$h access$createJvmStaticInObjectCaller(j jVar, Method method) {
        return jVar.isBound() ? new e$h$b(method) : new e$h$e(method);
    }

    public static final e$h access$createStaticMethodCaller(j jVar, Method method) {
        return jVar.isBound() ? new e$h$c(method, jVar.getBoundReceiver()) : new e$h$f(method);
    }

    public static final /* synthetic */ String access$getSignature$p(j jVar) {
        return jVar.f3200s;
    }

    public boolean equals(Object obj) {
        j jVarAsKFunctionImpl = j0.asKFunctionImpl(obj);
        return jVarAsKFunctionImpl != null && d0.z.d.m.areEqual(getContainer(), jVarAsKFunctionImpl.getContainer()) && d0.z.d.m.areEqual(getName(), jVarAsKFunctionImpl.getName()) && d0.z.d.m.areEqual(this.f3200s, jVarAsKFunctionImpl.f3200s) && d0.z.d.m.areEqual(this.t, jVarAsKFunctionImpl.t);
    }

    @Override // d0.z.d.i
    public int getArity() {
        return d0.e0.p.d.l0.f.getArity(getCaller());
    }

    public final Object getBoundReceiver() {
        return d0.e0.p.d.l0.h.coerceToExpectedReceiverType(this.t, getDescriptor());
    }

    @Override // d0.e0.p.d.f
    public d0.e0.p.d.l0.d<?> getCaller() {
        return (d0.e0.p.d.l0.d) this.p.getValue(this, n[1]);
    }

    @Override // d0.e0.p.d.f
    public i getContainer() {
        return this.r;
    }

    @Override // d0.e0.p.d.f
    public d0.e0.p.d.l0.d<?> getDefaultCaller() {
        return (d0.e0.p.d.l0.d) this.q.getValue(this, n[2]);
    }

    @Override // d0.e0.p.d.f
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b getDescriptor() {
        return getDescriptor();
    }

    @Override // d0.e0.p.d.f
    public d0.e0.p.d.m0.c.x getDescriptor() {
        return (d0.e0.p.d.m0.c.x) this.o.getValue(this, n[0]);
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        String strAsString = getDescriptor().getName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "descriptor.name.asString()");
        return strAsString;
    }

    public int hashCode() {
        return this.f3200s.hashCode() + ((getName().hashCode() + (getContainer().hashCode() * 31)) * 31);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return c$a.invoke(this);
    }

    @Override // d0.e0.p.d.f
    public boolean isBound() {
        return !d0.z.d.m.areEqual(this.t, d0.z.d.d.NO_RECEIVER);
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return getDescriptor().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return getDescriptor().isInfix();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return getDescriptor().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return getDescriptor().isOperator();
    }

    @Override // kotlin.reflect.KCallable, kotlin.reflect.KFunction
    public boolean isSuspend() {
        return getDescriptor().isSuspend();
    }

    public String toString() {
        return e0.f3197b.renderFunction(getDescriptor());
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return c$a.invoke(this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object obj, Object obj2) {
        return c$a.invoke(this, obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function3
    public Object invoke(Object obj, Object obj2, Object obj3) {
        return c$a.invoke(this, obj, obj2, obj3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(i iVar, String str, String str2, Object obj) {
        this(iVar, str, str2, null, obj);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "signature");
    }

    @Override // kotlin.jvm.functions.Function4
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return c$a.invoke(this, obj, obj2, obj3, obj4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public j(i iVar, d0.e0.p.d.m0.c.x xVar) {
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(xVar, "descriptor");
        String strAsString = xVar.getName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "descriptor.name.asString()");
        this(iVar, strAsString, f0.f3198b.mapSignature(xVar).asString(), xVar, d0.z.d.d.NO_RECEIVER);
    }

    @Override // kotlin.jvm.functions.Function5
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return c$a.invoke(this, obj, obj2, obj3, obj4, obj5);
    }

    @Override // kotlin.jvm.functions.Function6
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return c$a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // kotlin.jvm.functions.Function7
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return c$a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // kotlin.jvm.functions.Function8
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return c$a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // kotlin.jvm.functions.Function9
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return c$a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // kotlin.jvm.functions.Function10
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return c$a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // kotlin.jvm.functions.Function11
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
        return c$a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // kotlin.jvm.functions.Function12
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        return c$a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // kotlin.jvm.functions.Function13
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13) {
        return c$a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // kotlin.jvm.functions.Function14
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14) {
        return c$a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // kotlin.jvm.functions.Function15
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15) {
        return c$a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // kotlin.jvm.functions.Function16
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16) {
        return c$a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // kotlin.jvm.functions.Function17
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17) {
        return c$a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // kotlin.jvm.functions.Function22
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21, Object obj22) {
        return c$a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }
}
