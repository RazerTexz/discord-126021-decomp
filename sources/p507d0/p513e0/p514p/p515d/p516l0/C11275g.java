package p507d0.p513e0.p514p.p515d.p516l0;

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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p513e0.p514p.p515d.C11247a0;
import p507d0.p513e0.p514p.p515d.C11265j0;
import p507d0.p513e0.p514p.p515d.p516l0.AbstractC11273e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11448l;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11789g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.l0.g */
/* JADX INFO: compiled from: InlineClassAwareCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11275g<M extends Member> implements InterfaceC11272d<M> {

    /* JADX INFO: renamed from: a */
    public final a f22436a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC11272d<M> f22437b;

    /* JADX INFO: renamed from: c */
    public final boolean f22438c;

    /* JADX INFO: renamed from: d0.e0.p.d.l0.g$a */
    /* JADX INFO: compiled from: InlineClassAwareCaller.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final IntRange f22439a;

        /* JADX INFO: renamed from: b */
        public final Method[] f22440b;

        /* JADX INFO: renamed from: c */
        public final Method f22441c;

        public a(IntRange intRange, Method[] methodArr, Method method) {
            C12238m.checkNotNullParameter(intRange, "argumentRange");
            C12238m.checkNotNullParameter(methodArr, "unbox");
            this.f22439a = intRange;
            this.f22440b = methodArr;
            this.f22441c = method;
        }

        public final IntRange component1() {
            return this.f22439a;
        }

        public final Method[] component2() {
            return this.f22440b;
        }

        public final Method component3() {
            return this.f22441c;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006c  */
    /* JADX WARN: Multi-variable type inference failed */
    public C11275g(InterfaceC11321b interfaceC11321b, InterfaceC11272d<? extends M> interfaceC11272d, boolean z2) {
        a aVar;
        Class<?> inlineClass;
        C12238m.checkNotNullParameter(interfaceC11321b, "descriptor");
        C12238m.checkNotNullParameter(interfaceC11272d, "caller");
        this.f22437b = interfaceC11272d;
        this.f22438c = z2;
        AbstractC11913c0 returnType = interfaceC11321b.getReturnType();
        C12238m.checkNotNull(returnType);
        C12238m.checkNotNullExpressionValue(returnType, "descriptor.returnType!!");
        Class<?> inlineClass2 = C11276h.toInlineClass(returnType);
        Method boxMethod = inlineClass2 != null ? C11276h.getBoxMethod(inlineClass2, interfaceC11321b) : null;
        if (C11789g.isGetterOfUnderlyingPropertyOfInlineClass(interfaceC11321b)) {
            aVar = new a(IntRange.INSTANCE.getEMPTY(), new Method[0], boxMethod);
        } else {
            int i = -1;
            if (!(interfaceC11272d instanceof AbstractC11273e.h.c)) {
                if (interfaceC11321b instanceof InterfaceC11448l) {
                    if (!(interfaceC11272d instanceof InterfaceC11271c)) {
                        i = 0;
                    }
                } else if (interfaceC11321b.getDispatchReceiverParameter() == null || (interfaceC11272d instanceof InterfaceC11271c)) {
                    i = 0;
                } else {
                    InterfaceC11450m containingDeclaration = interfaceC11321b.getContainingDeclaration();
                    C12238m.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
                    if (C11789g.isInlineClass(containingDeclaration)) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                }
            }
            int i2 = (z2 ? 2 : 0) + (((interfaceC11321b instanceof InterfaceC11472x) && ((InterfaceC11472x) interfaceC11321b).isSuspend()) ? 1 : 0);
            ArrayList arrayList = new ArrayList();
            InterfaceC11459q0 extensionReceiverParameter = interfaceC11321b.getExtensionReceiverParameter();
            AbstractC11913c0 type = extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null;
            if (type != null) {
                arrayList.add(type);
            } else if (interfaceC11321b instanceof InterfaceC11448l) {
                InterfaceC11330e constructedClass = ((InterfaceC11448l) interfaceC11321b).getConstructedClass();
                C12238m.checkNotNullExpressionValue(constructedClass, "descriptor.constructedClass");
                if (constructedClass.isInner()) {
                    InterfaceC11450m containingDeclaration2 = constructedClass.getContainingDeclaration();
                    Objects.requireNonNull(containingDeclaration2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    arrayList.add(((InterfaceC11330e) containingDeclaration2).getDefaultType());
                }
            } else {
                InterfaceC11450m containingDeclaration3 = interfaceC11321b.getContainingDeclaration();
                C12238m.checkNotNullExpressionValue(containingDeclaration3, "descriptor.containingDeclaration");
                if ((containingDeclaration3 instanceof InterfaceC11330e) && C11789g.isInlineClass(containingDeclaration3)) {
                    arrayList.add(((InterfaceC11330e) containingDeclaration3).getDefaultType());
                }
            }
            List<InterfaceC11326c1> valueParameters = interfaceC11321b.getValueParameters();
            C12238m.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            Iterator<T> it = valueParameters.iterator();
            while (it.hasNext()) {
                arrayList.add(((InterfaceC11326c1) it.next()).getType());
            }
            int size = arrayList.size() + i + i2;
            if (C11274f.getArity(this) != size) {
                StringBuilder sbM833U = C1643a.m833U("Inconsistent number of parameters in the descriptor and Java reflection object: ");
                sbM833U.append(C11274f.getArity(this));
                sbM833U.append(" != ");
                sbM833U.append(size);
                sbM833U.append('\n');
                sbM833U.append("Calling: ");
                sbM833U.append(interfaceC11321b);
                sbM833U.append('\n');
                sbM833U.append("Parameter types: ");
                sbM833U.append(getParameterTypes());
                sbM833U.append(")\n");
                sbM833U.append("Default: ");
                sbM833U.append(this.f22438c);
                throw new C11247a0(sbM833U.toString());
            }
            IntRange intRangeUntil = C11226f.until(Math.max(i, 0), arrayList.size() + i);
            Method[] methodArr = new Method[size];
            for (int i3 = 0; i3 < size; i3++) {
                methodArr[i3] = (!intRangeUntil.contains(i3) || (inlineClass = C11276h.toInlineClass((AbstractC11913c0) arrayList.get(i3 - i))) == null) ? null : C11276h.getUnboxMethod(inlineClass, interfaceC11321b);
            }
            aVar = new a(intRangeUntil, methodArr, boxMethod);
        }
        this.f22436a = aVar;
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    public Object call(Object[] objArr) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke;
        C12238m.checkNotNullParameter(objArr, "args");
        a aVar = this.f22436a;
        IntRange intRangeComponent1 = aVar.component1();
        Method[] methodArrComponent2 = aVar.component2();
        Method methodComponent3 = aVar.component3();
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        C12238m.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, size)");
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
                        C12238m.checkNotNullExpressionValue(returnType, "method.returnType");
                        objDefaultPrimitiveValue = C11265j0.defaultPrimitiveValue(returnType);
                    }
                }
                objArrCopyOf[first] = objDefaultPrimitiveValue;
                if (first == last) {
                    break;
                }
                first++;
            }
        }
        Object objCall = this.f22437b.call(objArrCopyOf);
        return (methodComponent3 == null || (objInvoke = methodComponent3.invoke(null, objCall)) == null) ? objCall : objInvoke;
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    /* JADX INFO: renamed from: getMember */
    public M mo11457getMember() {
        return (M) this.f22437b.mo11457getMember();
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    public List<Type> getParameterTypes() {
        return this.f22437b.getParameterTypes();
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    public Type getReturnType() {
        return this.f22437b.getReturnType();
    }
}
