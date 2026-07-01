package d0.e0.p.d;

import d0.e0.p.d.l0.a$a;
import d0.e0.p.d.l0.a$b;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KFunctionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$b extends d0.z.d.o implements Function0<d0.e0.p.d.l0.d<? extends Member>> {
    public final /* synthetic */ j this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j$b(j jVar) {
        super(0);
        this.this$0 = jVar;
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ d0.e0.p.d.l0.d<? extends Member> invoke2() {
        return invoke();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x012e  */
    @Override // kotlin.jvm.functions.Function0
    public final d0.e0.p.d.l0.d<? extends Member> invoke() {
        GenericDeclaration genericDeclarationFindDefaultConstructor;
        d0.e0.p.d.l0.d dVarAccess$createStaticMethodCaller;
        a$a a_a = a$a.CALL_BY_NAME;
        d dVarMapSignature = f0.f3198b.mapSignature(this.this$0.getDescriptor());
        if (dVarMapSignature instanceof d$e) {
            i container = this.this$0.getContainer();
            d$e d_e = (d$e) dVarMapSignature;
            String methodName = d_e.getMethodName();
            String methodDesc = d_e.getMethodDesc();
            Member memberMo80getMember = this.this$0.getCaller().mo80getMember();
            d0.z.d.m.checkNotNull(memberMo80getMember);
            genericDeclarationFindDefaultConstructor = container.findDefaultMethod(methodName, methodDesc, !Modifier.isStatic(memberMo80getMember.getModifiers()));
        } else if (dVarMapSignature instanceof d$d) {
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
            genericDeclarationFindDefaultConstructor = this.this$0.getContainer().findDefaultConstructor(((d$d) dVarMapSignature).getConstructorDesc());
        } else {
            if (dVarMapSignature instanceof d$a) {
                List<Method> methods = ((d$a) dVarMapSignature).getMethods();
                Class<?> jClass2 = this.this$0.getContainer().getJClass();
                ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(methods, 10));
                for (Method method : methods) {
                    d0.z.d.m.checkNotNullExpressionValue(method, "it");
                    arrayList2.add(method.getName());
                }
                return new d0.e0.p.d.l0.a(jClass2, arrayList2, a_a, a$b.JAVA, methods);
            }
            genericDeclarationFindDefaultConstructor = null;
        }
        if (genericDeclarationFindDefaultConstructor instanceof Constructor) {
            j jVar = this.this$0;
            dVarAccess$createStaticMethodCaller = j.access$createConstructorCaller(jVar, (Constructor) genericDeclarationFindDefaultConstructor, jVar.getDescriptor());
        } else if (!(genericDeclarationFindDefaultConstructor instanceof Method)) {
            dVarAccess$createStaticMethodCaller = null;
        } else if (this.this$0.getDescriptor().getAnnotations().findAnnotation(j0.getJVM_STATIC()) != null) {
            d0.e0.p.d.m0.c.m containingDeclaration = this.this$0.getDescriptor().getContainingDeclaration();
            Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            if (((d0.e0.p.d.m0.c.e) containingDeclaration).isCompanionObject()) {
                dVarAccess$createStaticMethodCaller = j.access$createStaticMethodCaller(this.this$0, (Method) genericDeclarationFindDefaultConstructor);
            } else {
                dVarAccess$createStaticMethodCaller = j.access$createJvmStaticInObjectCaller(this.this$0, (Method) genericDeclarationFindDefaultConstructor);
            }
        } else {
            dVarAccess$createStaticMethodCaller = j.access$createStaticMethodCaller(this.this$0, (Method) genericDeclarationFindDefaultConstructor);
        }
        if (dVarAccess$createStaticMethodCaller != null) {
            return d0.e0.p.d.l0.h.createInlineClassAwareCallerIfNeeded(dVarAccess$createStaticMethodCaller, this.this$0.getDescriptor(), true);
        }
        return null;
    }
}
