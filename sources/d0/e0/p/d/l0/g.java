package d0.e0.p.d.l0;

import d0.e0.p.d.a0;
import d0.e0.p.d.j0;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.l;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.n.c0;
import d0.z.d.m;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: InlineClassAwareCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g<M extends Member> implements d<M> {
    public final g$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d<M> f3205b;
    public final boolean c;

    /* JADX WARN: Code duplicated, block: B:25:0x006c  */
    /* JADX WARN: Multi-variable type inference failed */
    public g(d0.e0.p.d.m0.c.b bVar, d<? extends M> dVar, boolean z2) {
        g$a g_a;
        Class<?> inlineClass;
        m.checkNotNullParameter(bVar, "descriptor");
        m.checkNotNullParameter(dVar, "caller");
        this.f3205b = dVar;
        this.c = z2;
        c0 returnType = bVar.getReturnType();
        m.checkNotNull(returnType);
        m.checkNotNullExpressionValue(returnType, "descriptor.returnType!!");
        Class<?> inlineClass2 = h.toInlineClass(returnType);
        Method boxMethod = inlineClass2 != null ? h.getBoxMethod(inlineClass2, bVar) : null;
        if (d0.e0.p.d.m0.k.g.isGetterOfUnderlyingPropertyOfInlineClass(bVar)) {
            g_a = new g$a(IntRange.o.getEMPTY(), new Method[0], boxMethod);
        } else {
            int i = -1;
            if (!(dVar instanceof e$h$c)) {
                if (bVar instanceof l) {
                    if (!(dVar instanceof c)) {
                        i = 0;
                    }
                } else if (bVar.getDispatchReceiverParameter() == null || (dVar instanceof c)) {
                    i = 0;
                } else {
                    d0.e0.p.d.m0.c.m containingDeclaration = bVar.getContainingDeclaration();
                    m.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
                    if (d0.e0.p.d.m0.k.g.isInlineClass(containingDeclaration)) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                }
            }
            int i2 = (z2 ? 2 : 0) + (((bVar instanceof x) && ((x) bVar).isSuspend()) ? 1 : 0);
            ArrayList arrayList = new ArrayList();
            q0 extensionReceiverParameter = bVar.getExtensionReceiverParameter();
            c0 type = extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null;
            if (type != null) {
                arrayList.add(type);
            } else if (bVar instanceof l) {
                d0.e0.p.d.m0.c.e constructedClass = ((l) bVar).getConstructedClass();
                m.checkNotNullExpressionValue(constructedClass, "descriptor.constructedClass");
                if (constructedClass.isInner()) {
                    d0.e0.p.d.m0.c.m containingDeclaration2 = constructedClass.getContainingDeclaration();
                    Objects.requireNonNull(containingDeclaration2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    arrayList.add(((d0.e0.p.d.m0.c.e) containingDeclaration2).getDefaultType());
                }
            } else {
                d0.e0.p.d.m0.c.m containingDeclaration3 = bVar.getContainingDeclaration();
                m.checkNotNullExpressionValue(containingDeclaration3, "descriptor.containingDeclaration");
                if ((containingDeclaration3 instanceof d0.e0.p.d.m0.c.e) && d0.e0.p.d.m0.k.g.isInlineClass(containingDeclaration3)) {
                    arrayList.add(((d0.e0.p.d.m0.c.e) containingDeclaration3).getDefaultType());
                }
            }
            List<c1> valueParameters = bVar.getValueParameters();
            m.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            Iterator<T> it = valueParameters.iterator();
            while (it.hasNext()) {
                arrayList.add(((c1) it.next()).getType());
            }
            int size = arrayList.size() + i + i2;
            if (f.getArity(this) != size) {
                StringBuilder sbU = b.d.b.a.a.U("Inconsistent number of parameters in the descriptor and Java reflection object: ");
                sbU.append(f.getArity(this));
                sbU.append(" != ");
                sbU.append(size);
                sbU.append('\n');
                sbU.append("Calling: ");
                sbU.append(bVar);
                sbU.append('\n');
                sbU.append("Parameter types: ");
                sbU.append(getParameterTypes());
                sbU.append(")\n");
                sbU.append("Default: ");
                sbU.append(this.c);
                throw new a0(sbU.toString());
            }
            IntRange intRangeUntil = d0.d0.f.until(Math.max(i, 0), arrayList.size() + i);
            Method[] methodArr = new Method[size];
            for (int i3 = 0; i3 < size; i3++) {
                methodArr[i3] = (!intRangeUntil.contains(i3) || (inlineClass = h.toInlineClass((c0) arrayList.get(i3 - i))) == null) ? null : h.getUnboxMethod(inlineClass, bVar);
            }
            g_a = new g$a(intRangeUntil, methodArr, boxMethod);
        }
        this.a = g_a;
    }

    @Override // d0.e0.p.d.l0.d
    public Object call(Object[] objArr) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke;
        m.checkNotNullParameter(objArr, "args");
        g$a g_a = this.a;
        IntRange intRangeComponent1 = g_a.component1();
        Method[] methodArrComponent2 = g_a.component2();
        Method methodComponent3 = g_a.component3();
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        m.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        Objects.requireNonNull(objArrCopyOf, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int first = intRangeComponent1.getFirst();
        int last = intRangeComponent1.getLast();
        if (first <= last) {
            while (true) {
                Method method = methodArrComponent2[first];
                Object objDefaultPrimitiveValue = objArr[first];
                if (method != null) {
                    if (objDefaultPrimitiveValue != null) {
                        objDefaultPrimitiveValue = method.invoke(objDefaultPrimitiveValue, new Object[0]);
                    } else {
                        Class<?> returnType = method.getReturnType();
                        m.checkNotNullExpressionValue(returnType, "method.returnType");
                        objDefaultPrimitiveValue = j0.defaultPrimitiveValue(returnType);
                    }
                }
                objArrCopyOf[first] = objDefaultPrimitiveValue;
                if (first == last) {
                    break;
                }
                first++;
            }
        }
        Object objCall = this.f3205b.call(objArrCopyOf);
        return (methodComponent3 == null || (objInvoke = methodComponent3.invoke(null, objCall)) == null) ? objCall : objInvoke;
    }

    @Override // d0.e0.p.d.l0.d
    /* JADX INFO: renamed from: getMember */
    public M mo80getMember() {
        return (M) this.f3205b.mo80getMember();
    }

    @Override // d0.e0.p.d.l0.d
    public List<Type> getParameterTypes() {
        return this.f3205b.getParameterTypes();
    }

    @Override // d0.e0.p.d.l0.d
    public Type getReturnType() {
        return this.f3205b.getReturnType();
    }
}
