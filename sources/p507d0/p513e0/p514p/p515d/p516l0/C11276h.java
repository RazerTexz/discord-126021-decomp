package p507d0.p513e0.p514p.p515d.p516l0;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.C11247a0;
import p507d0.p513e0.p514p.p515d.C11265j0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11329d1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11448l;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11789g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.l0.h */
/* JADX INFO: compiled from: InlineClassAwareCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11276h {
    /* JADX INFO: renamed from: a */
    public static final AbstractC11913c0 m9354a(InterfaceC11321b interfaceC11321b) {
        InterfaceC11459q0 extensionReceiverParameter = interfaceC11321b.getExtensionReceiverParameter();
        InterfaceC11459q0 dispatchReceiverParameter = interfaceC11321b.getDispatchReceiverParameter();
        if (extensionReceiverParameter != null) {
            return extensionReceiverParameter.getType();
        }
        if (dispatchReceiverParameter == null) {
            return null;
        }
        if (interfaceC11321b instanceof InterfaceC11448l) {
            return dispatchReceiverParameter.getType();
        }
        InterfaceC11450m containingDeclaration = interfaceC11321b.getContainingDeclaration();
        if (!(containingDeclaration instanceof InterfaceC11330e)) {
            containingDeclaration = null;
        }
        InterfaceC11330e interfaceC11330e = (InterfaceC11330e) containingDeclaration;
        if (interfaceC11330e != null) {
            return interfaceC11330e.getDefaultType();
        }
        return null;
    }

    public static final Object coerceToExpectedReceiverType(Object obj, InterfaceC11321b interfaceC11321b) {
        AbstractC11913c0 abstractC11913c0M9354a;
        Class<?> inlineClass;
        Method unboxMethod;
        C12238m.checkNotNullParameter(interfaceC11321b, "descriptor");
        return (((interfaceC11321b instanceof InterfaceC11453n0) && C11789g.isUnderlyingPropertyOfInlineClass((InterfaceC11329d1) interfaceC11321b)) || (abstractC11913c0M9354a = m9354a(interfaceC11321b)) == null || (inlineClass = toInlineClass(abstractC11913c0M9354a)) == null || (unboxMethod = getUnboxMethod(inlineClass, interfaceC11321b)) == null) ? obj : unboxMethod.invoke(obj, new Object[0]);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x006f  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends Member> InterfaceC11272d<M> createInlineClassAwareCallerIfNeeded(InterfaceC11272d<? extends M> interfaceC11272d, InterfaceC11321b interfaceC11321b, boolean z2) {
        boolean z3;
        AbstractC11913c0 returnType;
        C12238m.checkNotNullParameter(interfaceC11272d, "$this$createInlineClassAwareCallerIfNeeded");
        C12238m.checkNotNullParameter(interfaceC11321b, "descriptor");
        boolean z4 = false;
        if (C11789g.isGetterOfUnderlyingPropertyOfInlineClass(interfaceC11321b)) {
            z4 = true;
        } else {
            List<InterfaceC11326c1> valueParameters = interfaceC11321b.getValueParameters();
            C12238m.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            if (!(valueParameters instanceof Collection) || !valueParameters.isEmpty()) {
                Iterator<T> it = valueParameters.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z3 = false;
                        break;
                    }
                    InterfaceC11326c1 interfaceC11326c1 = (InterfaceC11326c1) it.next();
                    C12238m.checkNotNullExpressionValue(interfaceC11326c1, "it");
                    AbstractC11913c0 type = interfaceC11326c1.getType();
                    C12238m.checkNotNullExpressionValue(type, "it.type");
                    if (C11789g.isInlineClassType(type)) {
                        z3 = true;
                        break;
                    }
                }
            } else {
                z3 = false;
                break;
            }
            if (z3 || ((returnType = interfaceC11321b.getReturnType()) != null && C11789g.isInlineClassType(returnType))) {
                z4 = true;
            } else if (!(interfaceC11272d instanceof InterfaceC11271c)) {
                AbstractC11913c0 abstractC11913c0M9354a = m9354a(interfaceC11321b);
                if (abstractC11913c0M9354a != null && C11789g.isInlineClassType(abstractC11913c0M9354a)) {
                    z4 = true;
                }
            }
        }
        return z4 ? new C11275g(interfaceC11321b, interfaceC11272d, z2) : interfaceC11272d;
    }

    public static /* synthetic */ InterfaceC11272d createInlineClassAwareCallerIfNeeded$default(InterfaceC11272d interfaceC11272d, InterfaceC11321b interfaceC11321b, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return createInlineClassAwareCallerIfNeeded(interfaceC11272d, interfaceC11321b, z2);
    }

    public static final Method getBoxMethod(Class<?> cls, InterfaceC11321b interfaceC11321b) {
        C12238m.checkNotNullParameter(cls, "$this$getBoxMethod");
        C12238m.checkNotNullParameter(interfaceC11321b, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", getUnboxMethod(cls, interfaceC11321b).getReturnType());
            C12238m.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(\"box\" …d(descriptor).returnType)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new C11247a0("No box method found in inline class: " + cls + " (calling " + interfaceC11321b + ')');
        }
    }

    public static final Method getUnboxMethod(Class<?> cls, InterfaceC11321b interfaceC11321b) {
        C12238m.checkNotNullParameter(cls, "$this$getUnboxMethod");
        C12238m.checkNotNullParameter(interfaceC11321b, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", new Class[0]);
            C12238m.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(\"unbox…FOR_INLINE_CLASS_MEMBERS)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new C11247a0("No unbox method found in inline class: " + cls + " (calling " + interfaceC11321b + ')');
        }
    }

    public static final Class<?> toInlineClass(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "$this$toInlineClass");
        return toInlineClass(abstractC11913c0.getConstructor().getDeclarationDescriptor());
    }

    public static final Class<?> toInlineClass(InterfaceC11450m interfaceC11450m) {
        if (!(interfaceC11450m instanceof InterfaceC11330e) || !C11789g.isInlineClass(interfaceC11450m)) {
            return null;
        }
        InterfaceC11330e interfaceC11330e = (InterfaceC11330e) interfaceC11450m;
        Class<?> javaClass = C11265j0.toJavaClass(interfaceC11330e);
        if (javaClass != null) {
            return javaClass;
        }
        StringBuilder sbM833U = C1643a.m833U("Class object for the class ");
        sbM833U.append(interfaceC11330e.getName());
        sbM833U.append(" cannot be found (classId=");
        sbM833U.append(C11836a.getClassId((InterfaceC11352h) interfaceC11450m));
        sbM833U.append(')');
        throw new C11247a0(sbM833U.toString());
    }
}
