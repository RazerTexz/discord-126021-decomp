package p507d0.p513e0;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.KType;
import kotlin.sequences.Sequence;
import p507d0.p578f0.C12075n;
import p507d0.p578f0.C12078q;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.C12209a;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.InterfaceC12239n;

/* JADX INFO: renamed from: d0.e0.n */
/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11241n {
    /* JADX INFO: renamed from: a */
    public static final Type m9328a(KType kType, boolean z2) {
        InterfaceC11231d classifier = kType.getClassifier();
        if (classifier instanceof InterfaceC11235h) {
            return new C11239l((InterfaceC11235h) classifier);
        }
        if (!(classifier instanceof InterfaceC11230c)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
        }
        InterfaceC11230c interfaceC11230c = (InterfaceC11230c) classifier;
        Class javaObjectType = z2 ? C12209a.getJavaObjectType(interfaceC11230c) : C12209a.getJavaClass(interfaceC11230c);
        List<C11236i> arguments = kType.getArguments();
        if (arguments.isEmpty()) {
            return javaObjectType;
        }
        if (!javaObjectType.isArray()) {
            return m9329b(javaObjectType, arguments);
        }
        Class<?> componentType = javaObjectType.getComponentType();
        C12238m.checkNotNullExpressionValue(componentType, "jClass.componentType");
        if (componentType.isPrimitive()) {
            return javaObjectType;
        }
        C11236i c11236i = (C11236i) C12163u.singleOrNull((List) arguments);
        if (c11236i == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
        }
        EnumC11237j enumC11237jComponent1 = c11236i.component1();
        KType kTypeComponent2 = c11236i.component2();
        if (enumC11237jComponent1 == null) {
            return javaObjectType;
        }
        int iOrdinal = enumC11237jComponent1.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return javaObjectType;
            }
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
        }
        C12238m.checkNotNull(kTypeComponent2);
        Type typeM9328a = m9328a(kTypeComponent2, false);
        return typeM9328a instanceof Class ? javaObjectType : new C11228a(typeM9328a);
    }

    public static final String access$typeToString(Type type) {
        String name;
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            Sequence sequenceGenerateSequence = C12075n.generateSequence(type, C11240m.f22313j);
            name = ((Class) C12078q.last(sequenceGenerateSequence)).getName() + C12103t.repeat("[]", C12078q.count(sequenceGenerateSequence));
        } else {
            name = cls.getName();
        }
        C12238m.checkNotNullExpressionValue(name, "if (type.isArray) {\n    …\n        } else type.name");
        return name;
    }

    /* JADX INFO: renamed from: b */
    public static final Type m9329b(Class<?> cls, List<C11236i> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(m9330c((C11236i) it.next()));
            }
            return new C11238k(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(m9330c((C11236i) it2.next()));
            }
            return new C11238k(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type typeM9329b = m9329b(declaringClass, list.subList(length, list.size()));
        List<C11236i> listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(C12149o.collectionSizeOrDefault(listSubList, 10));
        Iterator<T> it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(m9330c((C11236i) it3.next()));
        }
        return new C11238k(cls, typeM9329b, arrayList3);
    }

    /* JADX INFO: renamed from: c */
    public static final Type m9330c(C11236i c11236i) {
        EnumC11237j variance = c11236i.getVariance();
        if (variance == null) {
            return C11242o.f22315k.getSTAR();
        }
        KType type = c11236i.getType();
        C12238m.checkNotNull(type);
        int iOrdinal = variance.ordinal();
        if (iOrdinal == 0) {
            return m9328a(type, true);
        }
        if (iOrdinal == 1) {
            return new C11242o(null, m9328a(type, true));
        }
        if (iOrdinal == 2) {
            return new C11242o(m9328a(type, true), null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Type getJavaType(KType kType) {
        Type javaType;
        C12238m.checkNotNullParameter(kType, "$this$javaType");
        return (!(kType instanceof InterfaceC12239n) || (javaType = ((InterfaceC12239n) kType).getJavaType()) == null) ? m9328a(kType, false) : javaType;
    }
}
