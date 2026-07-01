package d0.e0;

import d0.f0.q;
import d0.g0.t;
import d0.t.u;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.KType;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static final Type a(KType kType, boolean z2) {
        d classifier = kType.getClassifier();
        if (classifier instanceof h) {
            return new l((h) classifier);
        }
        if (!(classifier instanceof c)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
        }
        c cVar = (c) classifier;
        Class javaObjectType = z2 ? d0.z.a.getJavaObjectType(cVar) : d0.z.a.getJavaClass(cVar);
        List<i> arguments = kType.getArguments();
        if (arguments.isEmpty()) {
            return javaObjectType;
        }
        if (!javaObjectType.isArray()) {
            return b(javaObjectType, arguments);
        }
        Class<?> componentType = javaObjectType.getComponentType();
        d0.z.d.m.checkNotNullExpressionValue(componentType, "jClass.componentType");
        if (componentType.isPrimitive()) {
            return javaObjectType;
        }
        i iVar = (i) u.singleOrNull((List) arguments);
        if (iVar == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
        }
        j jVarComponent1 = iVar.component1();
        KType kTypeComponent2 = iVar.component2();
        if (jVarComponent1 == null) {
            return javaObjectType;
        }
        int iOrdinal = jVarComponent1.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return javaObjectType;
            }
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
        }
        d0.z.d.m.checkNotNull(kTypeComponent2);
        Type typeA = a(kTypeComponent2, false);
        return typeA instanceof Class ? javaObjectType : new a(typeA);
    }

    public static final /* synthetic */ Type access$computeJavaType(KType kType, boolean z2) {
        return a(kType, z2);
    }

    public static final String access$typeToString(Type type) {
        String name;
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            Sequence sequenceGenerateSequence = d0.f0.n.generateSequence(type, m.j);
            name = ((Class) q.last(sequenceGenerateSequence)).getName() + t.repeat("[]", q.count(sequenceGenerateSequence));
        } else {
            name = cls.getName();
        }
        d0.z.d.m.checkNotNullExpressionValue(name, "if (type.isArray) {\n    …\n        } else type.name");
        return name;
    }

    public static final Type b(Class<?> cls, List<i> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(c((i) it.next()));
            }
            return new k(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(c((i) it2.next()));
            }
            return new k(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type typeB = b(declaringClass, list.subList(length, list.size()));
        List<i> listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(d0.t.o.collectionSizeOrDefault(listSubList, 10));
        Iterator<T> it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(c((i) it3.next()));
        }
        return new k(cls, typeB, arrayList3);
    }

    public static final Type c(i iVar) {
        j variance = iVar.getVariance();
        if (variance == null) {
            return o.k.getSTAR();
        }
        KType type = iVar.getType();
        d0.z.d.m.checkNotNull(type);
        int iOrdinal = variance.ordinal();
        if (iOrdinal == 0) {
            return a(type, true);
        }
        if (iOrdinal == 1) {
            return new o(null, a(type, true));
        }
        if (iOrdinal == 2) {
            return new o(a(type, true), null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Type getJavaType(KType kType) {
        Type javaType;
        d0.z.d.m.checkNotNullParameter(kType, "$this$javaType");
        return (!(kType instanceof d0.z.d.n) || (javaType = ((d0.z.d.n) kType).getJavaType()) == null) ? a(kType, false) : javaType;
    }
}
