package b.g.a.c.h0;

import b.d.b.a.outline;
import b.g.a.c.JavaType;
import b.g.a.c.i0.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.TypeVariable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: b.g.a.c.h0.m, reason: use source file name */
/* JADX INFO: compiled from: TypeBindings.java */
/* JADX INFO: loaded from: classes3.dex */
public class TypeBindings implements Serializable {
    public static final String[] j;
    public static final JavaType[] k;
    public static final TypeBindings l;
    private static final long serialVersionUID = 1;
    private final int _hashCode;
    private final String[] _names;
    private final JavaType[] _types;
    private final String[] _unboundVariables;

    /* JADX INFO: renamed from: b.g.a.c.h0.m$a */
    /* JADX INFO: compiled from: TypeBindings.java */
    public static final class a {
        public final Class<?> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JavaType[] f720b;
        public final int c;

        public a(Class<?> cls, JavaType[] javaTypeArr, int i) {
            this.a = cls;
            this.f720b = javaTypeArr;
            this.c = i;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            if (this.c == aVar.c && this.a == aVar.a) {
                JavaType[] javaTypeArr = aVar.f720b;
                int length = this.f720b.length;
                if (length == javaTypeArr.length) {
                    for (int i = 0; i < length; i++) {
                        if (!this.f720b[i].equals(javaTypeArr[i])) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.c;
        }

        public String toString() {
            return outline.o(this.a, new StringBuilder(), "<>");
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.h0.m$b */
    /* JADX INFO: compiled from: TypeBindings.java */
    public static class b {
        public static final TypeVariable<?>[] a = AbstractList.class.getTypeParameters();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final TypeVariable<?>[] f721b = Collection.class.getTypeParameters();
        public static final TypeVariable<?>[] c = Iterable.class.getTypeParameters();
        public static final TypeVariable<?>[] d = List.class.getTypeParameters();
        public static final TypeVariable<?>[] e = ArrayList.class.getTypeParameters();
        public static final TypeVariable<?>[] f = Map.class.getTypeParameters();
        public static final TypeVariable<?>[] g = HashMap.class.getTypeParameters();
        public static final TypeVariable<?>[] h = LinkedHashMap.class.getTypeParameters();
    }

    static {
        String[] strArr = new String[0];
        j = strArr;
        JavaType[] javaTypeArr = new JavaType[0];
        k = javaTypeArr;
        l = new TypeBindings(strArr, javaTypeArr, null);
    }

    public TypeBindings(String[] strArr, JavaType[] javaTypeArr, String[] strArr2) {
        strArr = strArr == null ? j : strArr;
        this._names = strArr;
        javaTypeArr = javaTypeArr == null ? k : javaTypeArr;
        this._types = javaTypeArr;
        if (strArr.length != javaTypeArr.length) {
            StringBuilder sbU = outline.U("Mismatching names (");
            sbU.append(strArr.length);
            sbU.append("), types (");
            throw new IllegalArgumentException(outline.B(sbU, javaTypeArr.length, ")"));
        }
        int length = javaTypeArr.length;
        int i = 1;
        for (int i2 = 0; i2 < length; i2++) {
            i += this._types[i2]._hash;
        }
        this._unboundVariables = strArr2;
        this._hashCode = i;
    }

    public static TypeBindings b(Class<?> cls, JavaType javaType) {
        TypeVariable[] typeParameters;
        TypeVariable<?>[] typeVariableArr = b.a;
        if (cls == Collection.class) {
            typeParameters = b.f721b;
        } else if (cls == List.class) {
            typeParameters = b.d;
        } else if (cls == ArrayList.class) {
            typeParameters = b.e;
        } else if (cls == AbstractList.class) {
            typeParameters = b.a;
        } else {
            typeParameters = cls == Iterable.class ? b.c : cls.getTypeParameters();
        }
        int length = typeParameters == null ? 0 : typeParameters.length;
        if (length == 1) {
            return new TypeBindings(new String[]{typeParameters[0].getName()}, new JavaType[]{javaType}, null);
        }
        StringBuilder sbU = outline.U("Cannot create TypeBindings for class ");
        sbU.append(cls.getName());
        sbU.append(" with 1 type parameter: class expects ");
        sbU.append(length);
        throw new IllegalArgumentException(sbU.toString());
    }

    public static TypeBindings c(Class<?> cls, JavaType javaType, JavaType javaType2) {
        TypeVariable[] typeParameters;
        TypeVariable<?>[] typeVariableArr = b.a;
        if (cls == Map.class) {
            typeParameters = b.f;
        } else if (cls == HashMap.class) {
            typeParameters = b.g;
        } else {
            typeParameters = cls == LinkedHashMap.class ? b.h : cls.getTypeParameters();
        }
        int length = typeParameters == null ? 0 : typeParameters.length;
        if (length == 2) {
            return new TypeBindings(new String[]{typeParameters[0].getName(), typeParameters[1].getName()}, new JavaType[]{javaType, javaType2}, null);
        }
        StringBuilder sbU = outline.U("Cannot create TypeBindings for class ");
        sbU.append(cls.getName());
        sbU.append(" with 2 type parameters: class expects ");
        sbU.append(length);
        throw new IllegalArgumentException(sbU.toString());
    }

    public static TypeBindings d(Class<?> cls, JavaType[] javaTypeArr) {
        String[] strArr;
        int length = javaTypeArr.length;
        if (length == 1) {
            return b(cls, javaTypeArr[0]);
        }
        if (length == 2) {
            return c(cls, javaTypeArr[0], javaTypeArr[1]);
        }
        TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null || typeParameters.length == 0) {
            strArr = j;
        } else {
            int length2 = typeParameters.length;
            strArr = new String[length2];
            for (int i = 0; i < length2; i++) {
                strArr[i] = typeParameters[i].getName();
            }
        }
        if (strArr.length == javaTypeArr.length) {
            return new TypeBindings(strArr, javaTypeArr, null);
        }
        StringBuilder sbU = outline.U("Cannot create TypeBindings for class ");
        outline.k0(cls, sbU, " with ");
        sbU.append(javaTypeArr.length);
        sbU.append(" type parameter");
        sbU.append(javaTypeArr.length == 1 ? "" : "s");
        sbU.append(": class expects ");
        sbU.append(strArr.length);
        throw new IllegalArgumentException(sbU.toString());
    }

    public Object a(Class<?> cls) {
        return new a(cls, this._types, this._hashCode);
    }

    public JavaType e(String str) {
        JavaType javaType;
        int length = this._names.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(this._names[i])) {
                JavaType javaType2 = this._types[i];
                return (!(javaType2 instanceof ResolvedRecursiveType) || (javaType = ((ResolvedRecursiveType) javaType2)._referencedType) == null) ? javaType2 : javaType;
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!ClassUtil.o(obj, TypeBindings.class)) {
            return false;
        }
        int length = this._types.length;
        JavaType[] javaTypeArr = ((TypeBindings) obj)._types;
        if (length != javaTypeArr.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!javaTypeArr[i].equals(this._types[i])) {
                return false;
            }
        }
        return true;
    }

    public JavaType f(int i) {
        if (i < 0) {
            return null;
        }
        JavaType[] javaTypeArr = this._types;
        if (i >= javaTypeArr.length) {
            return null;
        }
        return javaTypeArr[i];
    }

    public List<JavaType> g() {
        JavaType[] javaTypeArr = this._types;
        return javaTypeArr.length == 0 ? Collections.emptyList() : Arrays.asList(javaTypeArr);
    }

    public boolean h(String str) {
        String[] strArr = this._unboundVariables;
        if (strArr == null) {
            return false;
        }
        int length = strArr.length;
        do {
            length--;
            if (length < 0) {
                return false;
            }
        } while (!str.equals(this._unboundVariables[length]));
        return true;
    }

    public int hashCode() {
        return this._hashCode;
    }

    public boolean i() {
        return this._types.length == 0;
    }

    public int j() {
        return this._types.length;
    }

    public JavaType[] k() {
        return this._types;
    }

    public TypeBindings l(String str) {
        String[] strArr = this._unboundVariables;
        int length = strArr == null ? 0 : strArr.length;
        String[] strArr2 = length == 0 ? new String[1] : (String[]) Arrays.copyOf(strArr, length + 1);
        strArr2[length] = str;
        return new TypeBindings(this._names, this._types, strArr2);
    }

    public Object readResolve() {
        String[] strArr = this._names;
        return (strArr == null || strArr.length == 0) ? l : this;
    }

    public String toString() {
        if (this._types.length == 0) {
            return "<>";
        }
        StringBuilder sbQ = outline.Q('<');
        int length = this._types.length;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sbQ.append(',');
            }
            JavaType javaType = this._types[i];
            StringBuilder sb = new StringBuilder(40);
            javaType.m(sb);
            sbQ.append(sb.toString());
        }
        sbQ.append('>');
        return sbQ.toString();
    }
}
