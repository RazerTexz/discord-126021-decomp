package d0.e0.p.d;

import d0.e0.p.d.l0.a$a;
import d0.e0.p.d.l0.a$b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KFunctionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$a extends d0.z.d.o implements Function0<d0.e0.p.d.l0.d<? extends Member>> {
    public final /* synthetic */ j this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j$a(j jVar) {
        super(0);
        this.this$0 = jVar;
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ d0.e0.p.d.l0.d<? extends Member> invoke2() {
        return invoke();
    }

    @Override // kotlin.jvm.functions.Function0
    public final d0.e0.p.d.l0.d<? extends Member> invoke() {
        Object constructor;
        d0.e0.p.d.l0.d dVarAccess$createJvmStaticInObjectCaller;
        a$a a_a = a$a.POSITIONAL_CALL;
        d dVarMapSignature = f0.f3198b.mapSignature(this.this$0.getDescriptor());
        if (dVarMapSignature instanceof d$d) {
            if (this.this$0.b()) {
                Class<?> jClass = this.this$0.getContainer().getJClass();
                List<d0.e0.f> parameters = this.this$0.getParameters();
                ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    String name = ((d0.e0.f) it.next()).getName();
                    d0.z.d.m.checkNotNull(name);
                    arrayList.add(name);
                }
                return new d0.e0.p.d.l0.a(jClass, arrayList, a_a, a$b.KOTLIN, null, 16, null);
            }
            constructor = this.this$0.getContainer().findConstructorBySignature(((d$d) dVarMapSignature).getConstructorDesc());
        } else if (dVarMapSignature instanceof d$e) {
            d$e d_e = (d$e) dVarMapSignature;
            constructor = this.this$0.getContainer().findMethodBySignature(d_e.getMethodName(), d_e.getMethodDesc());
        } else if (dVarMapSignature instanceof d$c) {
            constructor = ((d$c) dVarMapSignature).getMethod();
        } else {
            if (!(dVarMapSignature instanceof d$b)) {
                if (!(dVarMapSignature instanceof d$a)) {
                    throw new NoWhenBranchMatchedException();
                }
                List<Method> methods = ((d$a) dVarMapSignature).getMethods();
                Class<?> jClass2 = this.this$0.getContainer().getJClass();
                ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(methods, 10));
                for (Method method : methods) {
                    d0.z.d.m.checkNotNullExpressionValue(method, "it");
                    arrayList2.add(method.getName());
                }
                return new d0.e0.p.d.l0.a(jClass2, arrayList2, a_a, a$b.JAVA, methods);
            }
            constructor = ((d$b) dVarMapSignature).getConstructor();
        }
        if (constructor instanceof Constructor) {
            j jVar = this.this$0;
            dVarAccess$createJvmStaticInObjectCaller = j.access$createConstructorCaller(jVar, (Constructor) constructor, jVar.getDescriptor());
        } else {
            if (!(constructor instanceof Method)) {
                StringBuilder sbU = b.d.b.a.a.U("Could not compute caller for function: ");
                sbU.append(this.this$0.getDescriptor());
                sbU.append(" (member = ");
                sbU.append(constructor);
                sbU.append(')');
                throw new a0(sbU.toString());
            }
            Method method2 = (Method) constructor;
            dVarAccess$createJvmStaticInObjectCaller = Modifier.isStatic(method2.getModifiers()) ? this.this$0.getDescriptor().getAnnotations().findAnnotation(j0.getJVM_STATIC()) != null ? j.access$createJvmStaticInObjectCaller(this.this$0, method2) : j.access$createStaticMethodCaller(this.this$0, method2) : j.access$createInstanceMethodCaller(this.this$0, method2);
        }
        return d0.e0.p.d.l0.h.createInlineClassAwareCallerIfNeeded$default(dVarAccess$createJvmStaticInObjectCaller, this.this$0.getDescriptor(), false, 2, null);
    }
}
