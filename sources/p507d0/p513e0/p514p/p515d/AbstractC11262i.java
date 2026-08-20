package p507d0.p513e0.p514p.p515d;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11448l;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.C11412e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.C11418k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11423b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;
import p507d0.p592z.p594d.InterfaceC12223e;

/* JADX INFO: renamed from: d0.e0.p.d.i */
/* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11262i implements InterfaceC12223e {

    /* JADX INFO: renamed from: l */
    public static final a f22380l = new a(null);

    /* JADX INFO: renamed from: j */
    public static final Class<?> f22378j = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");

    /* JADX INFO: renamed from: k */
    public static final Regex f22379k = new Regex("<v#(\\d+)>");

    /* JADX INFO: renamed from: d0.e0.p.d.i$a */
    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return AbstractC11262i.f22379k;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.i$b */
    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    public abstract class b {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ KProperty[] f22381a = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(b.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};

        /* JADX INFO: renamed from: b */
        public final C11251c0.a f22382b = C11251c0.lazySoft(new a());

        /* JADX INFO: renamed from: d0.e0.p.d.i$b$a */
        /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
        public static final class a extends AbstractC12240o implements Function0<C11418k> {
            public a() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final C11418k invoke() {
                return C11249b0.getOrCreateModule(AbstractC11262i.this.getJClass());
            }
        }

        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final C11418k getModuleData() {
            return (C11418k) this.f22382b.getValue(this, f22381a[0]);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.i$c */
    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    public enum c {
        DECLARED,
        INHERITED;

        public final boolean accept(InterfaceC11321b interfaceC11321b) {
            C12238m.checkNotNullParameter(interfaceC11321b, "member");
            InterfaceC11321b.a kind = interfaceC11321b.getKind();
            C12238m.checkNotNullExpressionValue(kind, "member.kind");
            return kind.isReal() == (this == DECLARED);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.i$d */
    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    public static final class d extends AbstractC12240o implements Function1<InterfaceC11472x, CharSequence> {

        /* JADX INFO: renamed from: j */
        public static final d f22387j = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(InterfaceC11472x interfaceC11472x) {
            C12238m.checkNotNullParameter(interfaceC11472x, "descriptor");
            return AbstractC11746c.f24227c.render(interfaceC11472x) + " | " + C11257f0.f22358b.mapSignature(interfaceC11472x).asString();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.i$e */
    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    public static final class e extends AbstractC12240o implements Function1<InterfaceC11453n0, CharSequence> {

        /* JADX INFO: renamed from: j */
        public static final e f22388j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(InterfaceC11453n0 interfaceC11453n0) {
            C12238m.checkNotNullParameter(interfaceC11453n0, "descriptor");
            return AbstractC11746c.f24227c.render(interfaceC11453n0) + " | " + C11257f0.f22358b.mapPropertySignature(interfaceC11453n0).asString();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.i$f */
    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    public static final class f<T> implements Comparator<AbstractC11466u> {

        /* JADX INFO: renamed from: j */
        public static final f f22389j = new f();

        @Override // java.util.Comparator
        public final int compare(AbstractC11466u abstractC11466u, AbstractC11466u abstractC11466u2) {
            Integer numCompare = C11464t.compare(abstractC11466u, abstractC11466u2);
            if (numCompare != null) {
                return numCompare.intValue();
            }
            return 0;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.i$g */
    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    public static final class g extends C11246a {
        public g(AbstractC11262i abstractC11262i, AbstractC11262i abstractC11262i2) {
            super(abstractC11262i2);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11385m, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
        public AbstractC11256f<?> visitConstructorDescriptor(InterfaceC11448l interfaceC11448l, Unit unit) {
            C12238m.checkNotNullParameter(interfaceC11448l, "descriptor");
            C12238m.checkNotNullParameter(unit, "data");
            throw new IllegalStateException("No constructors should appear here: " + interfaceC11448l);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m9340a(List<Class<?>> list, String str, boolean z2) {
        List<Class<?>> listM9343d = m9343d(str);
        list.addAll(listM9343d);
        int size = ((((ArrayList) listM9343d).size() + 32) - 1) / 32;
        for (int i = 0; i < size; i++) {
            Class<?> cls = Integer.TYPE;
            C12238m.checkNotNullExpressionValue(cls, "Integer.TYPE");
            list.add(cls);
        }
        Class<?> cls2 = z2 ? f22378j : Object.class;
        C12238m.checkNotNullExpressionValue(cls2, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(cls2);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x004e  */
    /* JADX INFO: renamed from: b */
    public final Collection<AbstractC11256f<?>> m9341b(InterfaceC11770i interfaceC11770i, c cVar) {
        AbstractC11256f abstractC11256f;
        C12238m.checkNotNullParameter(interfaceC11770i, "scope");
        C12238m.checkNotNullParameter(cVar, "belonginess");
        g gVar = new g(this, this);
        Collection<InterfaceC11450m> contributedDescriptors$default = InterfaceC11773l.a.getContributedDescriptors$default(interfaceC11770i, null, null, 3, null);
        ArrayList arrayList = new ArrayList();
        for (InterfaceC11450m interfaceC11450m : contributedDescriptors$default) {
            if (interfaceC11450m instanceof InterfaceC11321b) {
                InterfaceC11321b interfaceC11321b = (InterfaceC11321b) interfaceC11450m;
                if ((!C12238m.areEqual(interfaceC11321b.getVisibility(), C11464t.f23090h)) && cVar.accept(interfaceC11321b)) {
                    abstractC11256f = (AbstractC11256f) interfaceC11450m.accept(gVar, Unit.f27425a);
                } else {
                    abstractC11256f = null;
                }
            } else {
                abstractC11256f = null;
            }
            if (abstractC11256f != null) {
                arrayList.add(abstractC11256f);
            }
        }
        return C12163u.toList(arrayList);
    }

    /* JADX INFO: renamed from: c */
    public Class<?> mo9342c() {
        Class<?> wrapperByPrimitive = C11423b.getWrapperByPrimitive(getJClass());
        return wrapperByPrimitive != null ? wrapperByPrimitive : getJClass();
    }

    /* JADX INFO: renamed from: d */
    public final List<Class<?>> m9343d(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (str.charAt(i) != ')') {
            int iIndexOf$default = i;
            while (str.charAt(iIndexOf$default) == '[') {
                iIndexOf$default++;
            }
            char cCharAt = str.charAt(iIndexOf$default);
            if (!C12106w.contains$default((CharSequence) "VZCBSIFJD", cCharAt, false, 2, (Object) null)) {
                if (cCharAt != 'L') {
                    throw new C11247a0(C1643a.m883w("Unknown type prefix in the method signature: ", str));
                }
                iIndexOf$default = C12106w.indexOf$default((CharSequence) str, ';', i, false, 4, (Object) null);
            }
            int i2 = iIndexOf$default + 1;
            arrayList.add(m9346g(str, i, i2));
            i = i2;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: e */
    public final Class<?> m9344e(String str) {
        return m9346g(str, C12106w.indexOf$default((CharSequence) str, ')', 0, false, 6, (Object) null) + 1, str.length());
    }

    /* JADX INFO: renamed from: f */
    public final Method m9345f(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z2) {
        Method methodM9345f;
        if (z2) {
            clsArr[0] = cls;
        }
        Method methodM9348i = m9348i(cls, str, clsArr, cls2);
        if (methodM9348i != null) {
            return methodM9348i;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && (methodM9345f = m9345f(superclass, str, clsArr, cls2, z2)) != null) {
            return methodM9345f;
        }
        for (Class<?> cls3 : cls.getInterfaces()) {
            C12238m.checkNotNullExpressionValue(cls3, "superInterface");
            Method methodM9345f2 = m9345f(cls3, str, clsArr, cls2, z2);
            if (methodM9345f2 != null) {
                return methodM9345f2;
            }
            if (z2) {
                Class<?> clsTryLoadClass = C11412e.tryLoadClass(C11423b.getSafeClassLoader(cls3), cls3.getName() + "$DefaultImpls");
                if (clsTryLoadClass != null) {
                    clsArr[0] = cls3;
                    Method methodM9348i2 = m9348i(clsTryLoadClass, str, clsArr, cls2);
                    if (methodM9348i2 != null) {
                        return methodM9348i2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public final Constructor<?> findConstructorBySignature(String str) {
        C12238m.checkNotNullParameter(str, "desc");
        return m9347h(getJClass(), m9343d(str));
    }

    public final Constructor<?> findDefaultConstructor(String str) {
        C12238m.checkNotNullParameter(str, "desc");
        Class<?> jClass = getJClass();
        ArrayList arrayList = new ArrayList();
        m9340a(arrayList, str, true);
        return m9347h(jClass, arrayList);
    }

    public final Method findDefaultMethod(String str, String str2, boolean z2) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str2, "desc");
        if (C12238m.areEqual(str, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z2) {
            arrayList.add(getJClass());
        }
        m9340a(arrayList, str2, false);
        Class<?> clsMo9342c = mo9342c();
        String strM883w = C1643a.m883w(str, "$default");
        Object[] array = arrayList.toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return m9345f(clsMo9342c, strM883w, (Class[]) array, m9344e(str2), z2);
    }

    public final InterfaceC11472x findFunctionDescriptor(String str, String str2) {
        Collection<InterfaceC11472x> functions;
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str2, "signature");
        if (C12238m.areEqual(str, "<init>")) {
            functions = C12163u.toList(getConstructorDescriptors());
        } else {
            C11716e c11716eIdentifier = C11716e.identifier(str);
            C12238m.checkNotNullExpressionValue(c11716eIdentifier, "Name.identifier(name)");
            functions = getFunctions(c11716eIdentifier);
        }
        Collection<InterfaceC11472x> collection = functions;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (C12238m.areEqual(C11257f0.f22358b.mapSignature((InterfaceC11472x) obj).asString(), str2)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 1) {
            return (InterfaceC11472x) C12163u.single((List) arrayList);
        }
        String strJoinToString$default = C12163u.joinToString$default(collection, "\n", null, null, 0, null, d.f22387j, 30, null);
        StringBuilder sb = new StringBuilder();
        sb.append("Function '");
        sb.append(str);
        sb.append("' (JVM signature: ");
        sb.append(str2);
        sb.append(") not resolved in ");
        sb.append(this);
        sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        sb.append(strJoinToString$default.length() == 0 ? " no members found" : '\n' + strJoinToString$default);
        throw new C11247a0(sb.toString());
    }

    public final Method findMethodBySignature(String str, String str2) {
        Method methodM9345f;
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str2, "desc");
        if (C12238m.areEqual(str, "<init>")) {
            return null;
        }
        Object[] array = m9343d(str2).toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Class<?>[] clsArr = (Class[]) array;
        Class<?> clsM9344e = m9344e(str2);
        Method methodM9345f2 = m9345f(mo9342c(), str, clsArr, clsM9344e, false);
        if (methodM9345f2 != null) {
            return methodM9345f2;
        }
        if (!mo9342c().isInterface() || (methodM9345f = m9345f(Object.class, str, clsArr, clsM9344e, false)) == null) {
            return null;
        }
        return methodM9345f;
    }

    public final InterfaceC11453n0 findPropertyDescriptor(String str, String str2) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str2, "signature");
        MatchResult matchResultMatchEntire = f22379k.matchEntire(str2);
        if (matchResultMatchEntire != null) {
            String str3 = matchResultMatchEntire.getDestructured().getMatch().getGroupValues().get(1);
            InterfaceC11453n0 localProperty = getLocalProperty(Integer.parseInt(str3));
            if (localProperty != null) {
                return localProperty;
            }
            StringBuilder sbM837Y = C1643a.m837Y("Local property #", str3, " not found in ");
            sbM837Y.append(getJClass());
            throw new C11247a0(sbM837Y.toString());
        }
        C11716e c11716eIdentifier = C11716e.identifier(str);
        C12238m.checkNotNullExpressionValue(c11716eIdentifier, "Name.identifier(name)");
        Collection<InterfaceC11453n0> properties = getProperties(c11716eIdentifier);
        ArrayList arrayList = new ArrayList();
        for (Object obj : properties) {
            if (C12238m.areEqual(C11257f0.f22358b.mapPropertySignature((InterfaceC11453n0) obj).asString(), str2)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            throw new C11247a0("Property '" + str + "' (JVM signature: " + str2 + ") not resolved in " + this);
        }
        if (arrayList.size() == 1) {
            return (InterfaceC11453n0) C12163u.single((List) arrayList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList) {
            AbstractC11466u visibility = ((InterfaceC11453n0) obj2).getVisibility();
            Object arrayList2 = linkedHashMap.get(visibility);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(visibility, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        Collection collectionValues = C12134g0.toSortedMap(linkedHashMap, f.f22389j).values();
        C12238m.checkNotNullExpressionValue(collectionValues, "properties\n             …                }).values");
        List list = (List) C12163u.last(collectionValues);
        if (list.size() == 1) {
            C12238m.checkNotNullExpressionValue(list, "mostVisibleProperties");
            return (InterfaceC11453n0) C12163u.first(list);
        }
        C11716e c11716eIdentifier2 = C11716e.identifier(str);
        C12238m.checkNotNullExpressionValue(c11716eIdentifier2, "Name.identifier(name)");
        String strJoinToString$default = C12163u.joinToString$default(getProperties(c11716eIdentifier2), "\n", null, null, 0, null, e.f22388j, 30, null);
        StringBuilder sb = new StringBuilder();
        sb.append("Property '");
        sb.append(str);
        sb.append("' (JVM signature: ");
        sb.append(str2);
        sb.append(") not resolved in ");
        sb.append(this);
        sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        sb.append(strJoinToString$default.length() == 0 ? " no members found" : '\n' + strJoinToString$default);
        throw new C11247a0(sb.toString());
    }

    /* JADX INFO: renamed from: g */
    public final Class<?> m9346g(String str, int i, int i2) throws ClassNotFoundException {
        char cCharAt = str.charAt(i);
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'L') {
            ClassLoader safeClassLoader = C11423b.getSafeClassLoader(getJClass());
            String strSubstring = str.substring(i + 1, i2 - 1);
            C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Class<?> clsLoadClass = safeClassLoader.loadClass(C12103t.replace$default(strSubstring, MentionUtilsKt.SLASH_CHAR, '.', false, 4, (Object) null));
            C12238m.checkNotNullExpressionValue(clsLoadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
            return clsLoadClass;
        }
        if (cCharAt == 'S') {
            return Short.TYPE;
        }
        if (cCharAt == 'V') {
            Class<?> cls = Void.TYPE;
            C12238m.checkNotNullExpressionValue(cls, "Void.TYPE");
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
            return C11423b.createArrayType(m9346g(str, i + 1, i2));
        }
        switch (cCharAt) {
            case 'B':
                return Byte.TYPE;
            case 'C':
                return Character.TYPE;
            case 'D':
                return Double.TYPE;
            default:
                throw new C11247a0(C1643a.m883w("Unknown type prefix in the method signature: ", str));
        }
    }

    public abstract Collection<InterfaceC11448l> getConstructorDescriptors();

    public abstract Collection<InterfaceC11472x> getFunctions(C11716e c11716e);

    public abstract InterfaceC11453n0 getLocalProperty(int i);

    public abstract Collection<InterfaceC11453n0> getProperties(C11716e c11716e);

    /* JADX INFO: renamed from: h */
    public final Constructor<?> m9347h(Class<?> cls, List<? extends Class<?>> list) {
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
    /* JADX INFO: renamed from: i */
    public final Method m9348i(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) {
        boolean z2;
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            C12238m.checkNotNullExpressionValue(declaredMethod, "result");
            if (C12238m.areEqual(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            C12238m.checkNotNullExpressionValue(declaredMethods, "declaredMethods");
            for (Method method : declaredMethods) {
                C12238m.checkNotNullExpressionValue(method, "method");
                if (C12238m.areEqual(method.getName(), str) && C12238m.areEqual(method.getReturnType(), cls2)) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    C12238m.checkNotNull(parameterTypes);
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
