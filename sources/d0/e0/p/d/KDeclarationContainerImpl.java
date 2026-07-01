package d0.e0.p.d;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import d0.e0.p.d.ReflectProperties;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ConstructorDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.k1.a.ReflectJavaClassFinder2;
import d0.e0.p.d.m0.c.k1.a.RuntimeModuleData;
import d0.e0.p.d.m0.c.k1.b.reflectClassUtil;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.j.DescriptorRenderer2;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.a0.ResolutionScope;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.ClassBasedDeclarationContainer;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: renamed from: d0.e0.p.d.i, reason: use source file name */
/* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {
    public static final a l = new a(null);
    public static final Class<?> j = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
    public static final Regex k = new Regex("<v#(\\d+)>");

    /* JADX INFO: renamed from: d0.e0.p.d.i$a */
    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return KDeclarationContainerImpl.k;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.i$b */
    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    public abstract class b {
        public static final /* synthetic */ KProperty[] a = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ReflectProperties.a f3199b = ReflectProperties.lazySoft(new a());

        /* JADX INFO: renamed from: d0.e0.p.d.i$b$a */
        /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
        public static final class a extends Lambda implements Function0<RuntimeModuleData> {
            public a() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RuntimeModuleData invoke() {
                return moduleByClassLoader.getOrCreateModule(KDeclarationContainerImpl.this.getJClass());
            }
        }

        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final RuntimeModuleData getModuleData() {
            return (RuntimeModuleData) this.f3199b.getValue(this, a[0]);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.i$c */
    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    public enum c {
        DECLARED,
        INHERITED;

        public final boolean accept(CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "member");
            CallableMemberDescriptor.a kind = callableMemberDescriptor.getKind();
            Intrinsics3.checkNotNullExpressionValue(kind, "member.kind");
            return kind.isReal() == (this == DECLARED);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.i$d */
    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    public static final class d extends Lambda implements Function1<FunctionDescriptor, CharSequence> {
        public static final d j = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(FunctionDescriptor functionDescriptor) {
            Intrinsics3.checkNotNullParameter(functionDescriptor, "descriptor");
            return DescriptorRenderer2.c.render(functionDescriptor) + " | " + RuntimeTypeMapper3.f3198b.mapSignature(functionDescriptor).asString();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.i$e */
    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    public static final class e extends Lambda implements Function1<PropertyDescriptor, CharSequence> {
        public static final e j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(PropertyDescriptor propertyDescriptor) {
            Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
            return DescriptorRenderer2.c.render(propertyDescriptor) + " | " + RuntimeTypeMapper3.f3198b.mapPropertySignature(propertyDescriptor).asString();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.i$f */
    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    public static final class f<T> implements Comparator<DescriptorVisibility2> {
        public static final f j = new f();

        @Override // java.util.Comparator
        public final int compare(DescriptorVisibility2 descriptorVisibility2, DescriptorVisibility2 descriptorVisibility3) {
            Integer numCompare = DescriptorVisibilities.compare(descriptorVisibility2, descriptorVisibility3);
            if (numCompare != null) {
                return numCompare.intValue();
            }
            return 0;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.i$g */
    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    public static final class g extends util {
        public g(KDeclarationContainerImpl kDeclarationContainerImpl, KDeclarationContainerImpl kDeclarationContainerImpl2) {
            super(kDeclarationContainerImpl2);
        }

        @Override // d0.e0.p.d.m0.c.i1.DeclarationDescriptorVisitorEmptyBodies, d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
        public KCallableImpl<?> visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, Unit unit) {
            Intrinsics3.checkNotNullParameter(constructorDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(unit, "data");
            throw new IllegalStateException("No constructors should appear here: " + constructorDescriptor);
        }
    }

    public final void a(List<Class<?>> list, String str, boolean z2) {
        List<Class<?>> listD = d(str);
        list.addAll(listD);
        int size = ((((ArrayList) listD).size() + 32) - 1) / 32;
        for (int i = 0; i < size; i++) {
            Class<?> cls = Integer.TYPE;
            Intrinsics3.checkNotNullExpressionValue(cls, "Integer.TYPE");
            list.add(cls);
        }
        Class<?> cls2 = z2 ? j : Object.class;
        Intrinsics3.checkNotNullExpressionValue(cls2, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(cls2);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x004e  */
    public final Collection<KCallableImpl<?>> b(MemberScope3 memberScope3, c cVar) {
        KCallableImpl kCallableImpl;
        Intrinsics3.checkNotNullParameter(memberScope3, "scope");
        Intrinsics3.checkNotNullParameter(cVar, "belonginess");
        g gVar = new g(this, this);
        Collection<DeclarationDescriptor> contributedDescriptors$default = ResolutionScope.a.getContributedDescriptors$default(memberScope3, null, null, 3, null);
        ArrayList arrayList = new ArrayList();
        for (DeclarationDescriptor declarationDescriptor : contributedDescriptors$default) {
            if (declarationDescriptor instanceof CallableMemberDescriptor) {
                CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) declarationDescriptor;
                if ((!Intrinsics3.areEqual(callableMemberDescriptor.getVisibility(), DescriptorVisibilities.h)) && cVar.accept(callableMemberDescriptor)) {
                    kCallableImpl = (KCallableImpl) declarationDescriptor.accept(gVar, Unit.a);
                } else {
                    kCallableImpl = null;
                }
            } else {
                kCallableImpl = null;
            }
            if (kCallableImpl != null) {
                arrayList.add(kCallableImpl);
            }
        }
        return _Collections.toList(arrayList);
    }

    public Class<?> c() {
        Class<?> wrapperByPrimitive = reflectClassUtil.getWrapperByPrimitive(getJClass());
        return wrapperByPrimitive != null ? wrapperByPrimitive : getJClass();
    }

    public final List<Class<?>> d(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (str.charAt(i) != ')') {
            int iIndexOf$default = i;
            while (str.charAt(iIndexOf$default) == '[') {
                iIndexOf$default++;
            }
            char cCharAt = str.charAt(iIndexOf$default);
            if (!Strings4.contains$default((CharSequence) "VZCBSIFJD", cCharAt, false, 2, (Object) null)) {
                if (cCharAt != 'L') {
                    throw new KotlinReflectionInternalError(outline.w("Unknown type prefix in the method signature: ", str));
                }
                iIndexOf$default = Strings4.indexOf$default((CharSequence) str, ';', i, false, 4, (Object) null);
            }
            int i2 = iIndexOf$default + 1;
            arrayList.add(g(str, i, i2));
            i = i2;
        }
        return arrayList;
    }

    public final Class<?> e(String str) {
        return g(str, Strings4.indexOf$default((CharSequence) str, ')', 0, false, 6, (Object) null) + 1, str.length());
    }

    public final Method f(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z2) {
        Method methodF;
        if (z2) {
            clsArr[0] = cls;
        }
        Method methodI = i(cls, str, clsArr, cls2);
        if (methodI != null) {
            return methodI;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && (methodF = f(superclass, str, clsArr, cls2, z2)) != null) {
            return methodF;
        }
        for (Class<?> cls3 : cls.getInterfaces()) {
            Intrinsics3.checkNotNullExpressionValue(cls3, "superInterface");
            Method methodF2 = f(cls3, str, clsArr, cls2, z2);
            if (methodF2 != null) {
                return methodF2;
            }
            if (z2) {
                Class<?> clsTryLoadClass = ReflectJavaClassFinder2.tryLoadClass(reflectClassUtil.getSafeClassLoader(cls3), cls3.getName() + "$DefaultImpls");
                if (clsTryLoadClass != null) {
                    clsArr[0] = cls3;
                    Method methodI2 = i(clsTryLoadClass, str, clsArr, cls2);
                    if (methodI2 != null) {
                        return methodI2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public final Constructor<?> findConstructorBySignature(String str) {
        Intrinsics3.checkNotNullParameter(str, "desc");
        return h(getJClass(), d(str));
    }

    public final Constructor<?> findDefaultConstructor(String str) {
        Intrinsics3.checkNotNullParameter(str, "desc");
        Class<?> jClass = getJClass();
        ArrayList arrayList = new ArrayList();
        a(arrayList, str, true);
        return h(jClass, arrayList);
    }

    public final Method findDefaultMethod(String str, String str2, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "desc");
        if (Intrinsics3.areEqual(str, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z2) {
            arrayList.add(getJClass());
        }
        a(arrayList, str2, false);
        Class<?> clsC = c();
        String strW = outline.w(str, "$default");
        Object[] array = arrayList.toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return f(clsC, strW, (Class[]) array, e(str2), z2);
    }

    public final FunctionDescriptor findFunctionDescriptor(String str, String str2) {
        Collection<FunctionDescriptor> functions;
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "signature");
        if (Intrinsics3.areEqual(str, "<init>")) {
            functions = _Collections.toList(getConstructorDescriptors());
        } else {
            Name nameIdentifier = Name.identifier(str);
            Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "Name.identifier(name)");
            functions = getFunctions(nameIdentifier);
        }
        Collection<FunctionDescriptor> collection = functions;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (Intrinsics3.areEqual(RuntimeTypeMapper3.f3198b.mapSignature((FunctionDescriptor) obj).asString(), str2)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 1) {
            return (FunctionDescriptor) _Collections.single((List) arrayList);
        }
        String strJoinToString$default = _Collections.joinToString$default(collection, "\n", null, null, 0, null, d.j, 30, null);
        StringBuilder sb = new StringBuilder();
        sb.append("Function '");
        sb.append(str);
        sb.append("' (JVM signature: ");
        sb.append(str2);
        sb.append(") not resolved in ");
        sb.append(this);
        sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        sb.append(strJoinToString$default.length() == 0 ? " no members found" : '\n' + strJoinToString$default);
        throw new KotlinReflectionInternalError(sb.toString());
    }

    public final Method findMethodBySignature(String str, String str2) {
        Method methodF;
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "desc");
        if (Intrinsics3.areEqual(str, "<init>")) {
            return null;
        }
        Object[] array = d(str2).toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Class<?>[] clsArr = (Class[]) array;
        Class<?> clsE = e(str2);
        Method methodF2 = f(c(), str, clsArr, clsE, false);
        if (methodF2 != null) {
            return methodF2;
        }
        if (!c().isInterface() || (methodF = f(Object.class, str, clsArr, clsE, false)) == null) {
            return null;
        }
        return methodF;
    }

    public final PropertyDescriptor findPropertyDescriptor(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "signature");
        MatchResult matchResultMatchEntire = k.matchEntire(str2);
        if (matchResultMatchEntire != null) {
            String str3 = matchResultMatchEntire.getDestructured().getMatch().getGroupValues().get(1);
            PropertyDescriptor localProperty = getLocalProperty(Integer.parseInt(str3));
            if (localProperty != null) {
                return localProperty;
            }
            StringBuilder sbY = outline.Y("Local property #", str3, " not found in ");
            sbY.append(getJClass());
            throw new KotlinReflectionInternalError(sbY.toString());
        }
        Name nameIdentifier = Name.identifier(str);
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "Name.identifier(name)");
        Collection<PropertyDescriptor> properties = getProperties(nameIdentifier);
        ArrayList arrayList = new ArrayList();
        for (Object obj : properties) {
            if (Intrinsics3.areEqual(RuntimeTypeMapper3.f3198b.mapPropertySignature((PropertyDescriptor) obj).asString(), str2)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            throw new KotlinReflectionInternalError("Property '" + str + "' (JVM signature: " + str2 + ") not resolved in " + this);
        }
        if (arrayList.size() == 1) {
            return (PropertyDescriptor) _Collections.single((List) arrayList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList) {
            DescriptorVisibility2 visibility = ((PropertyDescriptor) obj2).getVisibility();
            Object arrayList2 = linkedHashMap.get(visibility);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(visibility, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        Collection collectionValues = MapsJVM.toSortedMap(linkedHashMap, f.j).values();
        Intrinsics3.checkNotNullExpressionValue(collectionValues, "properties\n             …                }).values");
        List list = (List) _Collections.last(collectionValues);
        if (list.size() == 1) {
            Intrinsics3.checkNotNullExpressionValue(list, "mostVisibleProperties");
            return (PropertyDescriptor) _Collections.first(list);
        }
        Name nameIdentifier2 = Name.identifier(str);
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier2, "Name.identifier(name)");
        String strJoinToString$default = _Collections.joinToString$default(getProperties(nameIdentifier2), "\n", null, null, 0, null, e.j, 30, null);
        StringBuilder sb = new StringBuilder();
        sb.append("Property '");
        sb.append(str);
        sb.append("' (JVM signature: ");
        sb.append(str2);
        sb.append(") not resolved in ");
        sb.append(this);
        sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        sb.append(strJoinToString$default.length() == 0 ? " no members found" : '\n' + strJoinToString$default);
        throw new KotlinReflectionInternalError(sb.toString());
    }

    public final Class<?> g(String str, int i, int i2) throws ClassNotFoundException {
        char cCharAt = str.charAt(i);
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'L') {
            ClassLoader safeClassLoader = reflectClassUtil.getSafeClassLoader(getJClass());
            String strSubstring = str.substring(i + 1, i2 - 1);
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Class<?> clsLoadClass = safeClassLoader.loadClass(StringsJVM.replace$default(strSubstring, MentionUtils.SLASH_CHAR, '.', false, 4, (Object) null));
            Intrinsics3.checkNotNullExpressionValue(clsLoadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
            return clsLoadClass;
        }
        if (cCharAt == 'S') {
            return Short.TYPE;
        }
        if (cCharAt == 'V') {
            Class<?> cls = Void.TYPE;
            Intrinsics3.checkNotNullExpressionValue(cls, "Void.TYPE");
            return cls;
        }
        if (cCharAt == 'I') {
            return Integer.TYPE;
        }
        if (cCharAt == 'J') {
            return Long.TYPE;
        }
        if (cCharAt == 'Z') {
            return Boolean.TYPE;
        }
        if (cCharAt == '[') {
            return reflectClassUtil.createArrayType(g(str, i + 1, i2));
        }
        switch (cCharAt) {
            case 'B':
                return Byte.TYPE;
            case 'C':
                return Character.TYPE;
            case 'D':
                return Double.TYPE;
            default:
                throw new KotlinReflectionInternalError(outline.w("Unknown type prefix in the method signature: ", str));
        }
    }

    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    public abstract Collection<FunctionDescriptor> getFunctions(Name name);

    public abstract PropertyDescriptor getLocalProperty(int i);

    public abstract Collection<PropertyDescriptor> getProperties(Name name);

    public final Constructor<?> h(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Class[] clsArr = (Class[]) array;
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0055  */
    public final Method i(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) {
        boolean z2;
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            Intrinsics3.checkNotNullExpressionValue(declaredMethod, "result");
            if (Intrinsics3.areEqual(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            Intrinsics3.checkNotNullExpressionValue(declaredMethods, "declaredMethods");
            for (Method method : declaredMethods) {
                Intrinsics3.checkNotNullExpressionValue(method, "method");
                if (Intrinsics3.areEqual(method.getName(), str) && Intrinsics3.areEqual(method.getReturnType(), cls2)) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    Intrinsics3.checkNotNull(parameterTypes);
                    if (Arrays.equals(parameterTypes, clsArr)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                if (z2) {
                    return method;
                }
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
