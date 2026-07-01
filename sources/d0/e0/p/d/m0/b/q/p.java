package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.b.k$a;
import d0.e0.p.d.m0.e.b.w;
import d0.t.o0;
import d0.t.r;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: JvmBuiltInsSignatures.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p {
    public static final p a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f3242b;
    public static final Set<String> c;
    public static final Set<String> d;
    public static final Set<String> e;
    public static final Set<String> f;
    public static final Set<String> g;

    static {
        p pVar = new p();
        a = pVar;
        w wVar = w.a;
        f3242b = o0.plus(wVar.inJavaUtil("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        Objects.requireNonNull(pVar);
        List<d0.e0.p.d.m0.k.y.d> listListOf = d0.t.n.listOf((Object[]) new d0.e0.p.d.m0.k.y.d[]{d0.e0.p.d.m0.k.y.d.BOOLEAN, d0.e0.p.d.m0.k.y.d.CHAR});
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (d0.e0.p.d.m0.k.y.d dVar : listListOf) {
            String strAsString = dVar.getWrapperFqName().shortName().asString();
            d0.z.d.m.checkNotNullExpressionValue(strAsString, "it.wrapperFqName.shortName().asString()");
            r.addAll(linkedHashSet, wVar.inJavaLang(strAsString, dVar.getJavaKeywordName() + "Value()" + dVar.getDesc()));
        }
        c = o0.plus(o0.plus(o0.plus(o0.plus(o0.plus(o0.plus((Set) linkedHashSet, (Iterable) wVar.inJavaUtil("List", "sort(Ljava/util/Comparator;)V")), (Iterable) wVar.inJavaLang("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), (Iterable) wVar.inJavaLang("Double", "isInfinite()Z", "isNaN()Z")), (Iterable) wVar.inJavaLang("Float", "isInfinite()Z", "isNaN()Z")), (Iterable) wVar.inJavaLang("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V")), (Iterable) wVar.inJavaLang("CharSequence", "isEmpty()Z"));
        w wVar2 = w.a;
        d = o0.plus(o0.plus(o0.plus(o0.plus(o0.plus(o0.plus((Set) wVar2.inJavaLang("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), (Iterable) wVar2.inJavaUtil("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), (Iterable) wVar2.inJavaLang("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), (Iterable) wVar2.inJavaLang("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), (Iterable) wVar2.inJavaUtil("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), (Iterable) wVar2.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V")), (Iterable) wVar2.inJavaUtil("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        e = o0.plus(o0.plus((Set) wVar2.inJavaUtil("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), (Iterable) wVar2.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), (Iterable) wVar2.inJavaUtil("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        Objects.requireNonNull(a);
        d0.e0.p.d.m0.k.y.d dVar2 = d0.e0.p.d.m0.k.y.d.BYTE;
        List listListOf2 = d0.t.n.listOf((Object[]) new d0.e0.p.d.m0.k.y.d[]{d0.e0.p.d.m0.k.y.d.BOOLEAN, dVar2, d0.e0.p.d.m0.k.y.d.DOUBLE, d0.e0.p.d.m0.k.y.d.FLOAT, dVar2, d0.e0.p.d.m0.k.y.d.INT, d0.e0.p.d.m0.k.y.d.LONG, d0.e0.p.d.m0.k.y.d.SHORT});
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        Iterator it = listListOf2.iterator();
        while (it.hasNext()) {
            String strAsString2 = ((d0.e0.p.d.m0.k.y.d) it.next()).getWrapperFqName().shortName().asString();
            d0.z.d.m.checkNotNullExpressionValue(strAsString2, "it.wrapperFqName.shortName().asString()");
            String[] strArrConstructors = wVar2.constructors("Ljava/lang/String;");
            String[] strArr = new String[strArrConstructors.length];
            System.arraycopy(strArrConstructors, 0, strArr, 0, strArrConstructors.length);
            r.addAll(linkedHashSet2, wVar2.inJavaLang(strAsString2, strArr));
        }
        String[] strArrConstructors2 = wVar2.constructors("D");
        String[] strArr2 = new String[strArrConstructors2.length];
        System.arraycopy(strArrConstructors2, 0, strArr2, 0, strArrConstructors2.length);
        Set setPlus = o0.plus((Set) linkedHashSet2, (Iterable) wVar2.inJavaLang("Float", strArr2));
        String[] strArrConstructors3 = wVar2.constructors("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        String[] strArr3 = new String[strArrConstructors3.length];
        System.arraycopy(strArrConstructors3, 0, strArr3, 0, strArrConstructors3.length);
        f = o0.plus(setPlus, (Iterable) wVar2.inJavaLang("String", strArr3));
        w wVar3 = w.a;
        String[] strArrConstructors4 = wVar3.constructors("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        String[] strArr4 = new String[strArrConstructors4.length];
        System.arraycopy(strArrConstructors4, 0, strArr4, 0, strArrConstructors4.length);
        g = wVar3.inJavaLang("Throwable", strArr4);
    }

    public final Set<String> getDROP_LIST_METHOD_SIGNATURES() {
        return f3242b;
    }

    public final Set<String> getHIDDEN_CONSTRUCTOR_SIGNATURES() {
        return f;
    }

    public final Set<String> getHIDDEN_METHOD_SIGNATURES() {
        return c;
    }

    public final Set<String> getMUTABLE_METHOD_SIGNATURES() {
        return e;
    }

    public final Set<String> getVISIBLE_CONSTRUCTOR_SIGNATURES() {
        return g;
    }

    public final Set<String> getVISIBLE_METHOD_SIGNATURES() {
        return d;
    }

    public final boolean isArrayOrPrimitiveArray(d0.e0.p.d.m0.g.c cVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "fqName");
        if (!d0.z.d.m.areEqual(cVar, k$a.h)) {
            d0.e0.p.d.m0.b.k kVar = d0.e0.p.d.m0.b.k.a;
            if (!d0.e0.p.d.m0.b.k.isPrimitiveArray(cVar)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isSerializableInJava(d0.e0.p.d.m0.g.c cVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "fqName");
        if (isArrayOrPrimitiveArray(cVar)) {
            return true;
        }
        d0.e0.p.d.m0.g.a aVarMapKotlinToJava = c.a.mapKotlinToJava(cVar);
        if (aVarMapKotlinToJava == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(aVarMapKotlinToJava.asSingleFqName().asString()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
