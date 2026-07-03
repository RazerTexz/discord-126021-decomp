package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11662w;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11714c;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.EnumC11840d;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12150o0;
import p507d0.p580t.C12160r;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.p */
/* JADX INFO: compiled from: JvmBuiltInsSignatures.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11316p {

    /* JADX INFO: renamed from: a */
    public static final C11316p f22666a;

    /* JADX INFO: renamed from: b */
    public static final Set<String> f22667b;

    /* JADX INFO: renamed from: c */
    public static final Set<String> f22668c;

    /* JADX INFO: renamed from: d */
    public static final Set<String> f22669d;

    /* JADX INFO: renamed from: e */
    public static final Set<String> f22670e;

    /* JADX INFO: renamed from: f */
    public static final Set<String> f22671f;

    /* JADX INFO: renamed from: g */
    public static final Set<String> f22672g;

    static {
        C11316p c11316p = new C11316p();
        f22666a = c11316p;
        C11662w c11662w = C11662w.f23636a;
        f22667b = C12150o0.plus(c11662w.inJavaUtil("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        Objects.requireNonNull(c11316p);
        List<EnumC11840d> listListOf = C12147n.listOf((Object[]) new EnumC11840d[]{EnumC11840d.BOOLEAN, EnumC11840d.CHAR});
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (EnumC11840d enumC11840d : listListOf) {
            String strAsString = enumC11840d.getWrapperFqName().shortName().asString();
            C12238m.checkNotNullExpressionValue(strAsString, "it.wrapperFqName.shortName().asString()");
            C12160r.addAll(linkedHashSet, c11662w.inJavaLang(strAsString, enumC11840d.getJavaKeywordName() + "Value()" + enumC11840d.getDesc()));
        }
        f22668c = C12150o0.plus(C12150o0.plus(C12150o0.plus(C12150o0.plus(C12150o0.plus(C12150o0.plus((Set) linkedHashSet, (Iterable) c11662w.inJavaUtil("List", "sort(Ljava/util/Comparator;)V")), (Iterable) c11662w.inJavaLang("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), (Iterable) c11662w.inJavaLang("Double", "isInfinite()Z", "isNaN()Z")), (Iterable) c11662w.inJavaLang("Float", "isInfinite()Z", "isNaN()Z")), (Iterable) c11662w.inJavaLang("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V")), (Iterable) c11662w.inJavaLang("CharSequence", "isEmpty()Z"));
        C11662w c11662w2 = C11662w.f23636a;
        f22669d = C12150o0.plus(C12150o0.plus(C12150o0.plus(C12150o0.plus(C12150o0.plus(C12150o0.plus((Set) c11662w2.inJavaLang("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), (Iterable) c11662w2.inJavaUtil("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), (Iterable) c11662w2.inJavaLang("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), (Iterable) c11662w2.inJavaLang("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), (Iterable) c11662w2.inJavaUtil("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), (Iterable) c11662w2.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V")), (Iterable) c11662w2.inJavaUtil("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        f22670e = C12150o0.plus(C12150o0.plus((Set) c11662w2.inJavaUtil("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), (Iterable) c11662w2.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), (Iterable) c11662w2.inJavaUtil("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        Objects.requireNonNull(f22666a);
        EnumC11840d enumC11840d2 = EnumC11840d.BYTE;
        List listListOf2 = C12147n.listOf((Object[]) new EnumC11840d[]{EnumC11840d.BOOLEAN, enumC11840d2, EnumC11840d.DOUBLE, EnumC11840d.FLOAT, enumC11840d2, EnumC11840d.INT, EnumC11840d.LONG, EnumC11840d.SHORT});
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        Iterator it = listListOf2.iterator();
        while (it.hasNext()) {
            String strAsString2 = ((EnumC11840d) it.next()).getWrapperFqName().shortName().asString();
            C12238m.checkNotNullExpressionValue(strAsString2, "it.wrapperFqName.shortName().asString()");
            String[] strArrConstructors = c11662w2.constructors("Ljava/lang/String;");
            String[] strArr = new String[strArrConstructors.length];
            System.arraycopy(strArrConstructors, 0, strArr, 0, strArrConstructors.length);
            C12160r.addAll(linkedHashSet2, c11662w2.inJavaLang(strAsString2, strArr));
        }
        String[] strArrConstructors2 = c11662w2.constructors("D");
        String[] strArr2 = new String[strArrConstructors2.length];
        System.arraycopy(strArrConstructors2, 0, strArr2, 0, strArrConstructors2.length);
        Set setPlus = C12150o0.plus((Set) linkedHashSet2, (Iterable) c11662w2.inJavaLang("Float", strArr2));
        String[] strArrConstructors3 = c11662w2.constructors("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        String[] strArr3 = new String[strArrConstructors3.length];
        System.arraycopy(strArrConstructors3, 0, strArr3, 0, strArrConstructors3.length);
        f22671f = C12150o0.plus(setPlus, (Iterable) c11662w2.inJavaLang("String", strArr3));
        C11662w c11662w3 = C11662w.f23636a;
        String[] strArrConstructors4 = c11662w3.constructors("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        String[] strArr4 = new String[strArrConstructors4.length];
        System.arraycopy(strArrConstructors4, 0, strArr4, 0, strArrConstructors4.length);
        f22672g = c11662w3.inJavaLang("Throwable", strArr4);
    }

    public final Set<String> getDROP_LIST_METHOD_SIGNATURES() {
        return f22667b;
    }

    public final Set<String> getHIDDEN_CONSTRUCTOR_SIGNATURES() {
        return f22671f;
    }

    public final Set<String> getHIDDEN_METHOD_SIGNATURES() {
        return f22668c;
    }

    public final Set<String> getMUTABLE_METHOD_SIGNATURES() {
        return f22670e;
    }

    public final Set<String> getVISIBLE_CONSTRUCTOR_SIGNATURES() {
        return f22672g;
    }

    public final Set<String> getVISIBLE_METHOD_SIGNATURES() {
        return f22669d;
    }

    public final boolean isArrayOrPrimitiveArray(C11714c c11714c) {
        C12238m.checkNotNullParameter(c11714c, "fqName");
        if (!C12238m.areEqual(c11714c, C11291k.a.f22544h)) {
            C11291k c11291k = C11291k.f22488a;
            if (!C11291k.isPrimitiveArray(c11714c)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isSerializableInJava(C11714c c11714c) {
        C12238m.checkNotNullParameter(c11714c, "fqName");
        if (isArrayOrPrimitiveArray(c11714c)) {
            return true;
        }
        C11712a c11712aMapKotlinToJava = C11303c.f22614a.mapKotlinToJava(c11714c);
        if (c11712aMapKotlinToJava == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(c11712aMapKotlinToJava.asSingleFqName().asString()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
