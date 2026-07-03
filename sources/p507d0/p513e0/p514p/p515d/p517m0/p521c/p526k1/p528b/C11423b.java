package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.chat.input.MentionUtilsKt;
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
import kotlin.sequences.Sequence;
import p507d0.C12116o;
import p507d0.InterfaceC11213c;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p578f0.C12075n;
import p507d0.p578f0.C12078q;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.C12209a;
import p507d0.p592z.p593c.InterfaceC12211a;
import p507d0.p592z.p593c.InterfaceC12212b;
import p507d0.p592z.p593c.InterfaceC12213c;
import p507d0.p592z.p593c.InterfaceC12214d;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.b */
/* JADX INFO: compiled from: reflectClassUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11423b {

    /* JADX INFO: renamed from: a */
    public static final List<InterfaceC11230c<? extends Object>> f23032a;

    /* JADX INFO: renamed from: b */
    public static final Map<Class<? extends Object>, Class<? extends Object>> f23033b;

    /* JADX INFO: renamed from: c */
    public static final Map<Class<? extends Object>, Class<? extends Object>> f23034c;

    /* JADX INFO: renamed from: d */
    public static final Map<Class<? extends InterfaceC11213c<?>>, Integer> f23035d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.b$a */
    /* JADX INFO: compiled from: reflectClassUtil.kt */
    public static final class a extends AbstractC12240o implements Function1<ParameterizedType, ParameterizedType> {

        /* JADX INFO: renamed from: j */
        public static final a f23036j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ParameterizedType invoke(ParameterizedType parameterizedType) {
            C12238m.checkNotNullParameter(parameterizedType, "it");
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType instanceof ParameterizedType) {
                return (ParameterizedType) ownerType;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.b$b */
    /* JADX INFO: compiled from: reflectClassUtil.kt */
    public static final class b extends AbstractC12240o implements Function1<ParameterizedType, Sequence<? extends Type>> {

        /* JADX INFO: renamed from: j */
        public static final b f23037j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Sequence<Type> invoke(ParameterizedType parameterizedType) {
            C12238m.checkNotNullParameter(parameterizedType, "it");
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            C12238m.checkNotNullExpressionValue(actualTypeArguments, "it.actualTypeArguments");
            return C12141k.asSequence(actualTypeArguments);
        }
    }

    static {
        int i = 0;
        List<InterfaceC11230c<? extends Object>> listListOf = C12147n.listOf((Object[]) new InterfaceC11230c[]{C12216a0.getOrCreateKotlinClass(Boolean.TYPE), C12216a0.getOrCreateKotlinClass(Byte.TYPE), C12216a0.getOrCreateKotlinClass(Character.TYPE), C12216a0.getOrCreateKotlinClass(Double.TYPE), C12216a0.getOrCreateKotlinClass(Float.TYPE), C12216a0.getOrCreateKotlinClass(Integer.TYPE), C12216a0.getOrCreateKotlinClass(Long.TYPE), C12216a0.getOrCreateKotlinClass(Short.TYPE)});
        f23032a = listListOf;
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listListOf, 10));
        Iterator<T> it = listListOf.iterator();
        while (it.hasNext()) {
            InterfaceC11230c interfaceC11230c = (InterfaceC11230c) it.next();
            arrayList.add(C12116o.m10073to(C12209a.getJavaObjectType(interfaceC11230c), C12209a.getJavaPrimitiveType(interfaceC11230c)));
        }
        f23033b = C12136h0.toMap(arrayList);
        List<InterfaceC11230c<? extends Object>> list = f23032a;
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            InterfaceC11230c interfaceC11230c2 = (InterfaceC11230c) it2.next();
            arrayList2.add(C12116o.m10073to(C12209a.getJavaPrimitiveType(interfaceC11230c2), C12209a.getJavaObjectType(interfaceC11230c2)));
        }
        f23034c = C12136h0.toMap(arrayList2);
        List listListOf2 = C12147n.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, InterfaceC12211a.class, InterfaceC12212b.class, InterfaceC12213c.class, InterfaceC12214d.class, Function22.class});
        ArrayList arrayList3 = new ArrayList(C12149o.collectionSizeOrDefault(listListOf2, 10));
        for (Object obj : listListOf2) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            arrayList3.add(C12116o.m10073to((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        f23035d = C12136h0.toMap(arrayList3);
    }

    public static final Class<?> createArrayType(Class<?> cls) {
        C12238m.checkNotNullParameter(cls, "<this>");
        return Array.newInstance(cls, 0).getClass();
    }

    public static final C11712a getClassId(Class<?> cls) {
        C12238m.checkNotNullParameter(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException(C12238m.stringPlus("Can't compute ClassId for primitive type: ", cls));
        }
        if (cls.isArray()) {
            throw new IllegalArgumentException(C12238m.stringPlus("Can't compute ClassId for array type: ", cls));
        }
        if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
            String simpleName = cls.getSimpleName();
            C12238m.checkNotNullExpressionValue(simpleName, "simpleName");
            if (!(simpleName.length() == 0)) {
                Class<?> declaringClass = cls.getDeclaringClass();
                C11712a c11712aCreateNestedClassId = declaringClass == null ? null : getClassId(declaringClass).createNestedClassId(C11716e.identifier(cls.getSimpleName()));
                if (c11712aCreateNestedClassId == null) {
                    c11712aCreateNestedClassId = C11712a.topLevel(new C11713b(cls.getName()));
                }
                C12238m.checkNotNullExpressionValue(c11712aCreateNestedClassId, "declaringClass?.classId?.createNestedClassId(Name.identifier(simpleName)) ?: ClassId.topLevel(FqName(name))");
                return c11712aCreateNestedClassId;
            }
        }
        C11713b c11713b = new C11713b(cls.getName());
        return new C11712a(c11713b.parent(), C11713b.topLevel(c11713b.shortName()), true);
    }

    public static final String getDesc(Class<?> cls) {
        C12238m.checkNotNullParameter(cls, "<this>");
        if (C12238m.areEqual(cls, Void.TYPE)) {
            return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        }
        String name = createArrayType(cls).getName();
        C12238m.checkNotNullExpressionValue(name, "createArrayType().name");
        String strSubstring = name.substring(1);
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return C12103t.replace$default(strSubstring, '.', MentionUtilsKt.SLASH_CHAR, false, 4, (Object) null);
    }

    public static final List<Type> getParameterizedTypeArguments(Type type) {
        C12238m.checkNotNullParameter(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return C12147n.emptyList();
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return C12078q.toList(C12078q.flatMap(C12075n.generateSequence(type, a.f23036j), b.f23037j));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        C12238m.checkNotNullExpressionValue(actualTypeArguments, "actualTypeArguments");
        return C12141k.toList(actualTypeArguments);
    }

    public static final Class<?> getPrimitiveByWrapper(Class<?> cls) {
        C12238m.checkNotNullParameter(cls, "<this>");
        return f23033b.get(cls);
    }

    public static final ClassLoader getSafeClassLoader(Class<?> cls) {
        C12238m.checkNotNullParameter(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        C12238m.checkNotNullExpressionValue(systemClassLoader, "getSystemClassLoader()");
        return systemClassLoader;
    }

    public static final Class<?> getWrapperByPrimitive(Class<?> cls) {
        C12238m.checkNotNullParameter(cls, "<this>");
        return f23034c.get(cls);
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(Class<?> cls) {
        C12238m.checkNotNullParameter(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
