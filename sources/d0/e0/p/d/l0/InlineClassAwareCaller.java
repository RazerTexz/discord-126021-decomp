package d0.e0.p.d.l0;

import b.d.b.a.outline;
import d0.d0._Ranges;
import d0.e0.p.d.KotlinReflectionInternalError;
import d0.e0.p.d.l0.CallerImpl;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ConstructorDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.k.inlineClassesUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.util2;
import d0.z.d.Intrinsics3;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.ranges.Ranges2;

/* JADX INFO: renamed from: d0.e0.p.d.l0.g, reason: use source file name */
/* JADX INFO: compiled from: InlineClassAwareCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InlineClassAwareCaller<M extends Member> implements Caller2<M> {
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Caller2<M> f3205b;
    public final boolean c;

    /* JADX INFO: renamed from: d0.e0.p.d.l0.g$a */
    /* JADX INFO: compiled from: InlineClassAwareCaller.kt */
    public static final class a {
        public final Ranges2 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method[] f3206b;
        public final Method c;

        public a(Ranges2 ranges2, Method[] methodArr, Method method) {
            Intrinsics3.checkNotNullParameter(ranges2, "argumentRange");
            Intrinsics3.checkNotNullParameter(methodArr, "unbox");
            this.a = ranges2;
            this.f3206b = methodArr;
            this.c = method;
        }

        public final Ranges2 component1() {
            return this.a;
        }

        public final Method[] component2() {
            return this.f3206b;
        }

        public final Method component3() {
            return this.c;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006c  */
    /* JADX WARN: Multi-variable type inference failed */
    public InlineClassAwareCaller(CallableMemberDescriptor callableMemberDescriptor, Caller2<? extends M> caller2, boolean z2) {
        a aVar;
        Class<?> inlineClass;
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        Intrinsics3.checkNotNullParameter(caller2, "caller");
        this.f3205b = caller2;
        this.c = z2;
        KotlinType returnType = callableMemberDescriptor.getReturnType();
        Intrinsics3.checkNotNull(returnType);
        Intrinsics3.checkNotNullExpressionValue(returnType, "descriptor.returnType!!");
        Class<?> inlineClass2 = InlineClassAwareCaller2.toInlineClass(returnType);
        Method boxMethod = inlineClass2 != null ? InlineClassAwareCaller2.getBoxMethod(inlineClass2, callableMemberDescriptor) : null;
        if (inlineClassesUtils.isGetterOfUnderlyingPropertyOfInlineClass(callableMemberDescriptor)) {
            aVar = new a(Ranges2.INSTANCE.getEMPTY(), new Method[0], boxMethod);
        } else {
            int i = -1;
            if (!(caller2 instanceof CallerImpl.h.c)) {
                if (callableMemberDescriptor instanceof ConstructorDescriptor) {
                    if (!(caller2 instanceof Caller)) {
                        i = 0;
                    }
                } else if (callableMemberDescriptor.getDispatchReceiverParameter() == null || (caller2 instanceof Caller)) {
                    i = 0;
                } else {
                    DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
                    Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
                    if (inlineClassesUtils.isInlineClass(containingDeclaration)) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                }
            }
            int i2 = (z2 ? 2 : 0) + (((callableMemberDescriptor instanceof FunctionDescriptor) && ((FunctionDescriptor) callableMemberDescriptor).isSuspend()) ? 1 : 0);
            ArrayList arrayList = new ArrayList();
            ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
            KotlinType type = extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null;
            if (type != null) {
                arrayList.add(type);
            } else if (callableMemberDescriptor instanceof ConstructorDescriptor) {
                ClassDescriptor constructedClass = ((ConstructorDescriptor) callableMemberDescriptor).getConstructedClass();
                Intrinsics3.checkNotNullExpressionValue(constructedClass, "descriptor.constructedClass");
                if (constructedClass.isInner()) {
                    DeclarationDescriptor containingDeclaration2 = constructedClass.getContainingDeclaration();
                    Objects.requireNonNull(containingDeclaration2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    arrayList.add(((ClassDescriptor) containingDeclaration2).getDefaultType());
                }
            } else {
                DeclarationDescriptor containingDeclaration3 = callableMemberDescriptor.getContainingDeclaration();
                Intrinsics3.checkNotNullExpressionValue(containingDeclaration3, "descriptor.containingDeclaration");
                if ((containingDeclaration3 instanceof ClassDescriptor) && inlineClassesUtils.isInlineClass(containingDeclaration3)) {
                    arrayList.add(((ClassDescriptor) containingDeclaration3).getDefaultType());
                }
            }
            List<ValueParameterDescriptor> valueParameters = callableMemberDescriptor.getValueParameters();
            Intrinsics3.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            Iterator<T> it = valueParameters.iterator();
            while (it.hasNext()) {
                arrayList.add(((ValueParameterDescriptor) it.next()).getType());
            }
            int size = arrayList.size() + i + i2;
            if (Caller3.getArity(this) != size) {
                StringBuilder sbU = outline.U("Inconsistent number of parameters in the descriptor and Java reflection object: ");
                sbU.append(Caller3.getArity(this));
                sbU.append(" != ");
                sbU.append(size);
                sbU.append('\n');
                sbU.append("Calling: ");
                sbU.append(callableMemberDescriptor);
                sbU.append('\n');
                sbU.append("Parameter types: ");
                sbU.append(getParameterTypes());
                sbU.append(")\n");
                sbU.append("Default: ");
                sbU.append(this.c);
                throw new KotlinReflectionInternalError(sbU.toString());
            }
            Ranges2 ranges2Until = _Ranges.until(Math.max(i, 0), arrayList.size() + i);
            Method[] methodArr = new Method[size];
            for (int i3 = 0; i3 < size; i3++) {
                methodArr[i3] = (!ranges2Until.contains(i3) || (inlineClass = InlineClassAwareCaller2.toInlineClass((KotlinType) arrayList.get(i3 - i))) == null) ? null : InlineClassAwareCaller2.getUnboxMethod(inlineClass, callableMemberDescriptor);
            }
            aVar = new a(ranges2Until, methodArr, boxMethod);
        }
        this.a = aVar;
    }

    @Override // d0.e0.p.d.l0.Caller2
    public Object call(Object[] objArr) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke;
        Intrinsics3.checkNotNullParameter(objArr, "args");
        a aVar = this.a;
        Ranges2 ranges2Component1 = aVar.component1();
        Method[] methodArrComponent2 = aVar.component2();
        Method methodComponent3 = aVar.component3();
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics3.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        Objects.requireNonNull(objArrCopyOf, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int first = ranges2Component1.getFirst();
        int last = ranges2Component1.getLast();
        if (first <= last) {
            while (true) {
                Method method = methodArrComponent2[first];
                Object objDefaultPrimitiveValue = objArr[first];
                if (method != null) {
                    if (objDefaultPrimitiveValue != null) {
                        objDefaultPrimitiveValue = method.invoke(objDefaultPrimitiveValue, new Object[0]);
                    } else {
                        Class<?> returnType = method.getReturnType();
                        Intrinsics3.checkNotNullExpressionValue(returnType, "method.returnType");
                        objDefaultPrimitiveValue = util2.defaultPrimitiveValue(returnType);
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

    @Override // d0.e0.p.d.l0.Caller2
    /* JADX INFO: renamed from: getMember */
    public M mo80getMember() {
        return (M) this.f3205b.mo80getMember();
    }

    @Override // d0.e0.p.d.l0.Caller2
    public List<Type> getParameterTypes() {
        return this.f3205b.getParameterTypes();
    }

    @Override // d0.e0.p.d.l0.Caller2
    public Type getReturnType() {
        return this.f3205b.getReturnType();
    }
}
