package d0.e0.p.d.m0.c.k1.b;

import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.chat.input.MentionUtils;
import d0.Function3;
import d0.Tuples;
import d0.e0.KClass;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.f0._Sequences2;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t._Arrays;
import d0.z.JvmClassMapping;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.b, reason: use source file name */
/* JADX INFO: compiled from: reflectClassUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class reflectClassUtil {
    public static final List<KClass<? extends Object>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<? extends Object>, Class<? extends Object>> f3291b;
    public static final Map<Class<? extends Object>, Class<? extends Object>> c;
    public static final Map<Class<? extends Function3<?>>, Integer> d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.b$a */
    /* JADX INFO: compiled from: reflectClassUtil.kt */
    public static final class a extends Lambda implements Function1<ParameterizedType, ParameterizedType> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ParameterizedType invoke(ParameterizedType parameterizedType) {
            Intrinsics3.checkNotNullParameter(parameterizedType, "it");
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType instanceof ParameterizedType) {
                return (ParameterizedType) ownerType;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.b$b */
    /* JADX INFO: compiled from: reflectClassUtil.kt */
    public static final class b extends Lambda implements Function1<ParameterizedType, Sequence<? extends Type>> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Sequence<Type> invoke(ParameterizedType parameterizedType) {
            Intrinsics3.checkNotNullParameter(parameterizedType, "it");
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Intrinsics3.checkNotNullExpressionValue(actualTypeArguments, "it.actualTypeArguments");
            return _Arrays.asSequence(actualTypeArguments);
        }
    }

    static {
        int i = 0;
        List<KClass<? extends Object>> listListOf = Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(Boolean.TYPE), Reflection2.getOrCreateKotlinClass(Byte.TYPE), Reflection2.getOrCreateKotlinClass(Character.TYPE), Reflection2.getOrCreateKotlinClass(Double.TYPE), Reflection2.getOrCreateKotlinClass(Float.TYPE), Reflection2.getOrCreateKotlinClass(Integer.TYPE), Reflection2.getOrCreateKotlinClass(Long.TYPE), Reflection2.getOrCreateKotlinClass(Short.TYPE)});
        a = listListOf;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listListOf, 10));
        Iterator<T> it = listListOf.iterator();
        while (it.hasNext()) {
            KClass kClass = (KClass) it.next();
            arrayList.add(Tuples.to(JvmClassMapping.getJavaObjectType(kClass), JvmClassMapping.getJavaPrimitiveType(kClass)));
        }
        f3291b = Maps6.toMap(arrayList);
        List<KClass<? extends Object>> list = a;
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            KClass kClass2 = (KClass) it2.next();
            arrayList2.add(Tuples.to(JvmClassMapping.getJavaPrimitiveType(kClass2), JvmClassMapping.getJavaObjectType(kClass2)));
        }
        c = Maps6.toMap(arrayList2);
        List listListOf2 = Collections2.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, kotlin.jvm.functions.Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, d0.z.c.a.class, d0.z.c.b.class, d0.z.c.c.class, d0.z.c.d.class, Function22.class});
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(listListOf2, 10));
        for (Object obj : listListOf2) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            arrayList3.add(Tuples.to((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        d = Maps6.toMap(arrayList3);
    }

    public static final Class<?> createArrayType(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "<this>");
        return Array.newInstance(cls, 0).getClass();
    }

    public static final ClassId getClassId(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException(Intrinsics3.stringPlus("Can't compute ClassId for primitive type: ", cls));
        }
        if (cls.isArray()) {
            throw new IllegalArgumentException(Intrinsics3.stringPlus("Can't compute ClassId for array type: ", cls));
        }
        if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
            String simpleName = cls.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName, "simpleName");
            if (!(simpleName.length() == 0)) {
                Class<?> declaringClass = cls.getDeclaringClass();
                ClassId classIdCreateNestedClassId = declaringClass == null ? null : getClassId(declaringClass).createNestedClassId(Name.identifier(cls.getSimpleName()));
                if (classIdCreateNestedClassId == null) {
                    classIdCreateNestedClassId = ClassId.topLevel(new FqName(cls.getName()));
                }
                Intrinsics3.checkNotNullExpressionValue(classIdCreateNestedClassId, "declaringClass?.classId?.createNestedClassId(Name.identifier(simpleName)) ?: ClassId.topLevel(FqName(name))");
                return classIdCreateNestedClassId;
            }
        }
        FqName fqName = new FqName(cls.getName());
        return new ClassId(fqName.parent(), FqName.topLevel(fqName.shortName()), true);
    }

    public static final String getDesc(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "<this>");
        if (Intrinsics3.areEqual(cls, Void.TYPE)) {
            return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        }
        String name = createArrayType(cls).getName();
        Intrinsics3.checkNotNullExpressionValue(name, "createArrayType().name");
        String strSubstring = name.substring(1);
        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return StringsJVM.replace$default(strSubstring, '.', MentionUtils.SLASH_CHAR, false, 4, (Object) null);
    }

    public static final List<Type> getParameterizedTypeArguments(Type type) {
        Intrinsics3.checkNotNullParameter(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return Collections2.emptyList();
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return _Sequences2.toList(_Sequences2.flatMap(d0.f0.n.generateSequence(type, a.j), b.j));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Intrinsics3.checkNotNullExpressionValue(actualTypeArguments, "actualTypeArguments");
        return _Arrays.toList(actualTypeArguments);
    }

    public static final Class<?> getPrimitiveByWrapper(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "<this>");
        return f3291b.get(cls);
    }

    public static final ClassLoader getSafeClassLoader(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Intrinsics3.checkNotNullExpressionValue(systemClassLoader, "getSystemClassLoader()");
        return systemClassLoader;
    }

    public static final Class<?> getWrapperByPrimitive(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "<this>");
        return c.get(cls);
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
