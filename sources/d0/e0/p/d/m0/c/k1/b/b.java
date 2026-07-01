package d0.e0.p.d.m0.c.k1.b;

import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.t.h0;
import d0.z.d.a0;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;

/* JADX INFO: compiled from: reflectClassUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final List<d0.e0.c<? extends Object>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<? extends Object>, Class<? extends Object>> f3291b;
    public static final Map<Class<? extends Object>, Class<? extends Object>> c;
    public static final Map<Class<? extends d0.c<?>>, Integer> d;

    static {
        int i = 0;
        List<d0.e0.c<? extends Object>> listListOf = d0.t.n.listOf((Object[]) new d0.e0.c[]{a0.getOrCreateKotlinClass(Boolean.TYPE), a0.getOrCreateKotlinClass(Byte.TYPE), a0.getOrCreateKotlinClass(Character.TYPE), a0.getOrCreateKotlinClass(Double.TYPE), a0.getOrCreateKotlinClass(Float.TYPE), a0.getOrCreateKotlinClass(Integer.TYPE), a0.getOrCreateKotlinClass(Long.TYPE), a0.getOrCreateKotlinClass(Short.TYPE)});
        a = listListOf;
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listListOf, 10));
        Iterator<T> it = listListOf.iterator();
        while (it.hasNext()) {
            d0.e0.c cVar = (d0.e0.c) it.next();
            arrayList.add(d0.o.to(d0.z.a.getJavaObjectType(cVar), d0.z.a.getJavaPrimitiveType(cVar)));
        }
        f3291b = h0.toMap(arrayList);
        List<d0.e0.c<? extends Object>> list = a;
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            d0.e0.c cVar2 = (d0.e0.c) it2.next();
            arrayList2.add(d0.o.to(d0.z.a.getJavaPrimitiveType(cVar2), d0.z.a.getJavaObjectType(cVar2)));
        }
        c = h0.toMap(arrayList2);
        List listListOf2 = d0.t.n.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, d0.z.c.a.class, d0.z.c.b.class, d0.z.c.c.class, d0.z.c.d.class, Function22.class});
        ArrayList arrayList3 = new ArrayList(d0.t.o.collectionSizeOrDefault(listListOf2, 10));
        for (Object obj : listListOf2) {
            int i2 = i + 1;
            if (i < 0) {
                d0.t.n.throwIndexOverflow();
            }
            arrayList3.add(d0.o.to((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        d = h0.toMap(arrayList3);
    }

    public static final Class<?> createArrayType(Class<?> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "<this>");
        return Array.newInstance(cls, 0).getClass();
    }

    public static final d0.e0.p.d.m0.g.a getClassId(Class<?> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException(d0.z.d.m.stringPlus("Can't compute ClassId for primitive type: ", cls));
        }
        if (cls.isArray()) {
            throw new IllegalArgumentException(d0.z.d.m.stringPlus("Can't compute ClassId for array type: ", cls));
        }
        if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
            String simpleName = cls.getSimpleName();
            d0.z.d.m.checkNotNullExpressionValue(simpleName, "simpleName");
            if (!(simpleName.length() == 0)) {
                Class<?> declaringClass = cls.getDeclaringClass();
                d0.e0.p.d.m0.g.a aVarCreateNestedClassId = declaringClass == null ? null : getClassId(declaringClass).createNestedClassId(d0.e0.p.d.m0.g.e.identifier(cls.getSimpleName()));
                if (aVarCreateNestedClassId == null) {
                    aVarCreateNestedClassId = d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b(cls.getName()));
                }
                d0.z.d.m.checkNotNullExpressionValue(aVarCreateNestedClassId, "declaringClass?.classId?.createNestedClassId(Name.identifier(simpleName)) ?: ClassId.topLevel(FqName(name))");
                return aVarCreateNestedClassId;
            }
        }
        d0.e0.p.d.m0.g.b bVar = new d0.e0.p.d.m0.g.b(cls.getName());
        return new d0.e0.p.d.m0.g.a(bVar.parent(), d0.e0.p.d.m0.g.b.topLevel(bVar.shortName()), true);
    }

    public static final String getDesc(Class<?> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "<this>");
        if (d0.z.d.m.areEqual(cls, Void.TYPE)) {
            return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        }
        String name = createArrayType(cls).getName();
        d0.z.d.m.checkNotNullExpressionValue(name, "createArrayType().name");
        String strSubstring = name.substring(1);
        d0.z.d.m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return d0.g0.t.replace$default(strSubstring, '.', MentionUtilsKt.SLASH_CHAR, false, 4, (Object) null);
    }

    public static final List<Type> getParameterizedTypeArguments(Type type) {
        d0.z.d.m.checkNotNullParameter(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return d0.t.n.emptyList();
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return d0.f0.q.toList(d0.f0.q.flatMap(d0.f0.n.generateSequence(type, b$a.j), b$b.j));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        d0.z.d.m.checkNotNullExpressionValue(actualTypeArguments, "actualTypeArguments");
        return d0.t.k.toList(actualTypeArguments);
    }

    public static final Class<?> getPrimitiveByWrapper(Class<?> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "<this>");
        return f3291b.get(cls);
    }

    public static final ClassLoader getSafeClassLoader(Class<?> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        d0.z.d.m.checkNotNullExpressionValue(systemClassLoader, "getSystemClassLoader()");
        return systemClassLoader;
    }

    public static final Class<?> getWrapperByPrimitive(Class<?> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "<this>");
        return c.get(cls);
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(Class<?> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
