package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.e.b.SignatureBuildingComponents;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.k.y.JvmPrimitiveType;
import d0.t.Collections2;
import d0.t.MutableCollections;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.p, reason: use source file name */
/* JADX INFO: compiled from: JvmBuiltInsSignatures.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmBuiltInsSignatures {
    public static final JvmBuiltInsSignatures a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f3242b;
    public static final Set<String> c;
    public static final Set<String> d;
    public static final Set<String> e;
    public static final Set<String> f;
    public static final Set<String> g;

    static {
        JvmBuiltInsSignatures jvmBuiltInsSignatures = new JvmBuiltInsSignatures();
        a = jvmBuiltInsSignatures;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.a;
        f3242b = _Sets.plus(signatureBuildingComponents.inJavaUtil("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        Objects.requireNonNull(jvmBuiltInsSignatures);
        List<JvmPrimitiveType> listListOf = Collections2.listOf((Object[]) new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR});
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JvmPrimitiveType jvmPrimitiveType : listListOf) {
            String strAsString = jvmPrimitiveType.getWrapperFqName().shortName().asString();
            Intrinsics3.checkNotNullExpressionValue(strAsString, "it.wrapperFqName.shortName().asString()");
            MutableCollections.addAll(linkedHashSet, signatureBuildingComponents.inJavaLang(strAsString, jvmPrimitiveType.getJavaKeywordName() + "Value()" + jvmPrimitiveType.getDesc()));
        }
        c = _Sets.plus(_Sets.plus(_Sets.plus(_Sets.plus(_Sets.plus(_Sets.plus((Set) linkedHashSet, (Iterable) signatureBuildingComponents.inJavaUtil("List", "sort(Ljava/util/Comparator;)V")), (Iterable) signatureBuildingComponents.inJavaLang("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), (Iterable) signatureBuildingComponents.inJavaLang("Double", "isInfinite()Z", "isNaN()Z")), (Iterable) signatureBuildingComponents.inJavaLang("Float", "isInfinite()Z", "isNaN()Z")), (Iterable) signatureBuildingComponents.inJavaLang("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V")), (Iterable) signatureBuildingComponents.inJavaLang("CharSequence", "isEmpty()Z"));
        SignatureBuildingComponents signatureBuildingComponents2 = SignatureBuildingComponents.a;
        d = _Sets.plus(_Sets.plus(_Sets.plus(_Sets.plus(_Sets.plus(_Sets.plus((Set) signatureBuildingComponents2.inJavaLang("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), (Iterable) signatureBuildingComponents2.inJavaUtil("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), (Iterable) signatureBuildingComponents2.inJavaLang("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), (Iterable) signatureBuildingComponents2.inJavaLang("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), (Iterable) signatureBuildingComponents2.inJavaUtil("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), (Iterable) signatureBuildingComponents2.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V")), (Iterable) signatureBuildingComponents2.inJavaUtil("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        e = _Sets.plus(_Sets.plus((Set) signatureBuildingComponents2.inJavaUtil("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), (Iterable) signatureBuildingComponents2.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), (Iterable) signatureBuildingComponents2.inJavaUtil("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        Objects.requireNonNull(a);
        JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.BYTE;
        List listListOf2 = Collections2.listOf((Object[]) new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, jvmPrimitiveType2, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, jvmPrimitiveType2, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT});
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        Iterator it = listListOf2.iterator();
        while (it.hasNext()) {
            String strAsString2 = ((JvmPrimitiveType) it.next()).getWrapperFqName().shortName().asString();
            Intrinsics3.checkNotNullExpressionValue(strAsString2, "it.wrapperFqName.shortName().asString()");
            String[] strArrConstructors = signatureBuildingComponents2.constructors("Ljava/lang/String;");
            String[] strArr = new String[strArrConstructors.length];
            System.arraycopy(strArrConstructors, 0, strArr, 0, strArrConstructors.length);
            MutableCollections.addAll(linkedHashSet2, signatureBuildingComponents2.inJavaLang(strAsString2, strArr));
        }
        String[] strArrConstructors2 = signatureBuildingComponents2.constructors("D");
        String[] strArr2 = new String[strArrConstructors2.length];
        System.arraycopy(strArrConstructors2, 0, strArr2, 0, strArrConstructors2.length);
        Set setPlus = _Sets.plus((Set) linkedHashSet2, (Iterable) signatureBuildingComponents2.inJavaLang("Float", strArr2));
        String[] strArrConstructors3 = signatureBuildingComponents2.constructors("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        String[] strArr3 = new String[strArrConstructors3.length];
        System.arraycopy(strArrConstructors3, 0, strArr3, 0, strArrConstructors3.length);
        f = _Sets.plus(setPlus, (Iterable) signatureBuildingComponents2.inJavaLang("String", strArr3));
        SignatureBuildingComponents signatureBuildingComponents3 = SignatureBuildingComponents.a;
        String[] strArrConstructors4 = signatureBuildingComponents3.constructors("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        String[] strArr4 = new String[strArrConstructors4.length];
        System.arraycopy(strArrConstructors4, 0, strArr4, 0, strArrConstructors4.length);
        g = signatureBuildingComponents3.inJavaLang("Throwable", strArr4);
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

    public final boolean isArrayOrPrimitiveArray(FqNameUnsafe fqNameUnsafe) {
        Intrinsics3.checkNotNullParameter(fqNameUnsafe, "fqName");
        if (!Intrinsics3.areEqual(fqNameUnsafe, StandardNames.a.h)) {
            StandardNames standardNames = StandardNames.a;
            if (!StandardNames.isPrimitiveArray(fqNameUnsafe)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isSerializableInJava(FqNameUnsafe fqNameUnsafe) {
        Intrinsics3.checkNotNullParameter(fqNameUnsafe, "fqName");
        if (isArrayOrPrimitiveArray(fqNameUnsafe)) {
            return true;
        }
        ClassId classIdMapKotlinToJava = JavaToKotlinClassMap.a.mapKotlinToJava(fqNameUnsafe);
        if (classIdMapKotlinToJava == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(classIdMapKotlinToJava.asSingleFqName().asString()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
