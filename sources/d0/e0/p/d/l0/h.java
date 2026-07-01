package d0.e0.p.d.l0;

import d0.e0.p.d.a0;
import d0.e0.p.d.j0;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.d1;
import d0.e0.p.d.m0.c.l;
import d0.e0.p.d.m0.c.m;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.n.c0;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: InlineClassAwareCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final c0 a(d0.e0.p.d.m0.c.b bVar) {
        q0 extensionReceiverParameter = bVar.getExtensionReceiverParameter();
        q0 dispatchReceiverParameter = bVar.getDispatchReceiverParameter();
        if (extensionReceiverParameter != null) {
            return extensionReceiverParameter.getType();
        }
        if (dispatchReceiverParameter == null) {
            return null;
        }
        if (bVar instanceof l) {
            return dispatchReceiverParameter.getType();
        }
        m containingDeclaration = bVar.getContainingDeclaration();
        if (!(containingDeclaration instanceof d0.e0.p.d.m0.c.e)) {
            containingDeclaration = null;
        }
        d0.e0.p.d.m0.c.e eVar = (d0.e0.p.d.m0.c.e) containingDeclaration;
        if (eVar != null) {
            return eVar.getDefaultType();
        }
        return null;
    }

    public static final Object coerceToExpectedReceiverType(Object obj, d0.e0.p.d.m0.c.b bVar) {
        c0 c0VarA;
        Class<?> inlineClass;
        Method unboxMethod;
        d0.z.d.m.checkNotNullParameter(bVar, "descriptor");
        return (((bVar instanceof n0) && d0.e0.p.d.m0.k.g.isUnderlyingPropertyOfInlineClass((d1) bVar)) || (c0VarA = a(bVar)) == null || (inlineClass = toInlineClass(c0VarA)) == null || (unboxMethod = getUnboxMethod(inlineClass, bVar)) == null) ? obj : unboxMethod.invoke(obj, new Object[0]);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x006f  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends Member> d<M> createInlineClassAwareCallerIfNeeded(d<? extends M> dVar, d0.e0.p.d.m0.c.b bVar, boolean z2) {
        boolean z3;
        c0 returnType;
        d0.z.d.m.checkNotNullParameter(dVar, "$this$createInlineClassAwareCallerIfNeeded");
        d0.z.d.m.checkNotNullParameter(bVar, "descriptor");
        boolean z4 = false;
        if (d0.e0.p.d.m0.k.g.isGetterOfUnderlyingPropertyOfInlineClass(bVar)) {
            z4 = true;
        } else {
            List<c1> valueParameters = bVar.getValueParameters();
            d0.z.d.m.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            if (!(valueParameters instanceof Collection) || !valueParameters.isEmpty()) {
                Iterator<T> it = valueParameters.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z3 = false;
                        break;
                    }
                    c1 c1Var = (c1) it.next();
                    d0.z.d.m.checkNotNullExpressionValue(c1Var, "it");
                    c0 type = c1Var.getType();
                    d0.z.d.m.checkNotNullExpressionValue(type, "it.type");
                    if (d0.e0.p.d.m0.k.g.isInlineClassType(type)) {
                        z3 = true;
                        break;
                    }
                }
            } else {
                z3 = false;
                break;
            }
            if (z3 || ((returnType = bVar.getReturnType()) != null && d0.e0.p.d.m0.k.g.isInlineClassType(returnType))) {
                z4 = true;
            } else if (!(dVar instanceof c)) {
                c0 c0VarA = a(bVar);
                if (c0VarA != null && d0.e0.p.d.m0.k.g.isInlineClassType(c0VarA)) {
                    z4 = true;
                }
            }
        }
        return z4 ? new g(bVar, dVar, z2) : dVar;
    }

    public static /* synthetic */ d createInlineClassAwareCallerIfNeeded$default(d dVar, d0.e0.p.d.m0.c.b bVar, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return createInlineClassAwareCallerIfNeeded(dVar, bVar, z2);
    }

    public static final Method getBoxMethod(Class<?> cls, d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(cls, "$this$getBoxMethod");
        d0.z.d.m.checkNotNullParameter(bVar, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", getUnboxMethod(cls, bVar).getReturnType());
            d0.z.d.m.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(\"box\" …d(descriptor).returnType)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new a0("No box method found in inline class: " + cls + " (calling " + bVar + ')');
        }
    }

    public static final Method getUnboxMethod(Class<?> cls, d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(cls, "$this$getUnboxMethod");
        d0.z.d.m.checkNotNullParameter(bVar, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", new Class[0]);
            d0.z.d.m.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(\"unbox…FOR_INLINE_CLASS_MEMBERS)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new a0("No unbox method found in inline class: " + cls + " (calling " + bVar + ')');
        }
    }

    public static final Class<?> toInlineClass(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "$this$toInlineClass");
        return toInlineClass(c0Var.getConstructor().getDeclarationDescriptor());
    }

    public static final Class<?> toInlineClass(m mVar) {
        if (!(mVar instanceof d0.e0.p.d.m0.c.e) || !d0.e0.p.d.m0.k.g.isInlineClass(mVar)) {
            return null;
        }
        d0.e0.p.d.m0.c.e eVar = (d0.e0.p.d.m0.c.e) mVar;
        Class<?> javaClass = j0.toJavaClass(eVar);
        if (javaClass != null) {
            return javaClass;
        }
        StringBuilder sbU = b.d.b.a.a.U("Class object for the class ");
        sbU.append(eVar.getName());
        sbU.append(" cannot be found (classId=");
        sbU.append(d0.e0.p.d.m0.k.x.a.getClassId((d0.e0.p.d.m0.c.h) mVar));
        sbU.append(')');
        throw new a0(sbU.toString());
    }
}
