package p007b.p195g.p196a.p205c.p218h0;

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
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.p219i0.C2342d;

/* JADX INFO: renamed from: b.g.a.c.h0.m */
/* JADX INFO: compiled from: TypeBindings.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2334m implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final String[] f4906j;

    /* JADX INFO: renamed from: k */
    public static final AbstractC2360j[] f4907k;

    /* JADX INFO: renamed from: l */
    public static final C2334m f4908l;
    private static final long serialVersionUID = 1;
    private final int _hashCode;
    private final String[] _names;
    private final AbstractC2360j[] _types;
    private final String[] _unboundVariables;

    /* JADX INFO: renamed from: b.g.a.c.h0.m$a */
    /* JADX INFO: compiled from: TypeBindings.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final Class<?> f4909a;

        /* JADX INFO: renamed from: b */
        public final AbstractC2360j[] f4910b;

        /* JADX INFO: renamed from: c */
        public final int f4911c;

        public a(Class<?> cls, AbstractC2360j[] abstractC2360jArr, int i) {
            this.f4909a = cls;
            this.f4910b = abstractC2360jArr;
            this.f4911c = i;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f4911c == aVar.f4911c && this.f4909a == aVar.f4909a) {
                AbstractC2360j[] abstractC2360jArr = aVar.f4910b;
                int length = this.f4910b.length;
                if (length == abstractC2360jArr.length) {
                    for (int i = 0; i < length; i++) {
                        if (!this.f4910b[i].equals(abstractC2360jArr[i])) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f4911c;
        }

        public String toString() {
            return C1643a.m867o(this.f4909a, new StringBuilder(), "<>");
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.h0.m$b */
    /* JADX INFO: compiled from: TypeBindings.java */
    public static class b {

        /* JADX INFO: renamed from: a */
        public static final TypeVariable<?>[] f4912a = AbstractList.class.getTypeParameters();

        /* JADX INFO: renamed from: b */
        public static final TypeVariable<?>[] f4913b = Collection.class.getTypeParameters();

        /* JADX INFO: renamed from: c */
        public static final TypeVariable<?>[] f4914c = Iterable.class.getTypeParameters();

        /* JADX INFO: renamed from: d */
        public static final TypeVariable<?>[] f4915d = List.class.getTypeParameters();

        /* JADX INFO: renamed from: e */
        public static final TypeVariable<?>[] f4916e = ArrayList.class.getTypeParameters();

        /* JADX INFO: renamed from: f */
        public static final TypeVariable<?>[] f4917f = Map.class.getTypeParameters();

        /* JADX INFO: renamed from: g */
        public static final TypeVariable<?>[] f4918g = HashMap.class.getTypeParameters();

        /* JADX INFO: renamed from: h */
        public static final TypeVariable<?>[] f4919h = LinkedHashMap.class.getTypeParameters();
    }

    static {
        String[] strArr = new String[0];
        f4906j = strArr;
        AbstractC2360j[] abstractC2360jArr = new AbstractC2360j[0];
        f4907k = abstractC2360jArr;
        f4908l = new C2334m(strArr, abstractC2360jArr, null);
    }

    public C2334m(String[] strArr, AbstractC2360j[] abstractC2360jArr, String[] strArr2) {
        strArr = strArr == null ? f4906j : strArr;
        this._names = strArr;
        abstractC2360jArr = abstractC2360jArr == null ? f4907k : abstractC2360jArr;
        this._types = abstractC2360jArr;
        if (strArr.length != abstractC2360jArr.length) {
            StringBuilder sbM833U = C1643a.m833U("Mismatching names (");
            sbM833U.append(strArr.length);
            sbM833U.append("), types (");
            throw new IllegalArgumentException(C1643a.m814B(sbM833U, abstractC2360jArr.length, ")"));
        }
        int length = abstractC2360jArr.length;
        int i = 1;
        for (int i2 = 0; i2 < length; i2++) {
            i += this._types[i2]._hash;
        }
        this._unboundVariables = strArr2;
        this._hashCode = i;
    }

    /* JADX INFO: renamed from: b */
    public static C2334m m2146b(Class<?> cls, AbstractC2360j abstractC2360j) {
        TypeVariable[] typeParameters;
        TypeVariable<?>[] typeVariableArr = b.f4912a;
        if (cls == Collection.class) {
            typeParameters = b.f4913b;
        } else if (cls == List.class) {
            typeParameters = b.f4915d;
        } else if (cls == ArrayList.class) {
            typeParameters = b.f4916e;
        } else if (cls == AbstractList.class) {
            typeParameters = b.f4912a;
        } else {
            typeParameters = cls == Iterable.class ? b.f4914c : cls.getTypeParameters();
        }
        int length = typeParameters == null ? 0 : typeParameters.length;
        if (length == 1) {
            return new C2334m(new String[]{typeParameters[0].getName()}, new AbstractC2360j[]{abstractC2360j}, null);
        }
        StringBuilder sbM833U = C1643a.m833U("Cannot create TypeBindings for class ");
        sbM833U.append(cls.getName());
        sbM833U.append(" with 1 type parameter: class expects ");
        sbM833U.append(length);
        throw new IllegalArgumentException(sbM833U.toString());
    }

    /* JADX INFO: renamed from: c */
    public static C2334m m2147c(Class<?> cls, AbstractC2360j abstractC2360j, AbstractC2360j abstractC2360j2) {
        TypeVariable[] typeParameters;
        TypeVariable<?>[] typeVariableArr = b.f4912a;
        if (cls == Map.class) {
            typeParameters = b.f4917f;
        } else if (cls == HashMap.class) {
            typeParameters = b.f4918g;
        } else {
            typeParameters = cls == LinkedHashMap.class ? b.f4919h : cls.getTypeParameters();
        }
        int length = typeParameters == null ? 0 : typeParameters.length;
        if (length == 2) {
            return new C2334m(new String[]{typeParameters[0].getName(), typeParameters[1].getName()}, new AbstractC2360j[]{abstractC2360j, abstractC2360j2}, null);
        }
        StringBuilder sbM833U = C1643a.m833U("Cannot create TypeBindings for class ");
        sbM833U.append(cls.getName());
        sbM833U.append(" with 2 type parameters: class expects ");
        sbM833U.append(length);
        throw new IllegalArgumentException(sbM833U.toString());
    }

    /* JADX INFO: renamed from: d */
    public static C2334m m2148d(Class<?> cls, AbstractC2360j[] abstractC2360jArr) {
        String[] strArr;
        int length = abstractC2360jArr.length;
        if (length == 1) {
            return m2146b(cls, abstractC2360jArr[0]);
        }
        if (length == 2) {
            return m2147c(cls, abstractC2360jArr[0], abstractC2360jArr[1]);
        }
        TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null || typeParameters.length == 0) {
            strArr = f4906j;
        } else {
            int length2 = typeParameters.length;
            strArr = new String[length2];
            for (int i = 0; i < length2; i++) {
                strArr[i] = typeParameters[i].getName();
            }
        }
        if (strArr.length == abstractC2360jArr.length) {
            return new C2334m(strArr, abstractC2360jArr, null);
        }
        StringBuilder sbM833U = C1643a.m833U("Cannot create TypeBindings for class ");
        C1643a.m860k0(cls, sbM833U, " with ");
        sbM833U.append(abstractC2360jArr.length);
        sbM833U.append(" type parameter");
        sbM833U.append(abstractC2360jArr.length == 1 ? "" : "s");
        sbM833U.append(": class expects ");
        sbM833U.append(strArr.length);
        throw new IllegalArgumentException(sbM833U.toString());
    }

    /* JADX INFO: renamed from: a */
    public Object m2149a(Class<?> cls) {
        return new a(cls, this._types, this._hashCode);
    }

    /* JADX INFO: renamed from: e */
    public AbstractC2360j m2150e(String str) {
        AbstractC2360j abstractC2360j;
        int length = this._names.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(this._names[i])) {
                AbstractC2360j abstractC2360j2 = this._types[i];
                return (!(abstractC2360j2 instanceof C2331j) || (abstractC2360j = ((C2331j) abstractC2360j2)._referencedType) == null) ? abstractC2360j2 : abstractC2360j;
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!C2342d.m2183o(obj, C2334m.class)) {
            return false;
        }
        int length = this._types.length;
        AbstractC2360j[] abstractC2360jArr = ((C2334m) obj)._types;
        if (length != abstractC2360jArr.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!abstractC2360jArr[i].equals(this._types[i])) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: f */
    public AbstractC2360j m2151f(int i) {
        if (i < 0) {
            return null;
        }
        AbstractC2360j[] abstractC2360jArr = this._types;
        if (i >= abstractC2360jArr.length) {
            return null;
        }
        return abstractC2360jArr[i];
    }

    /* JADX INFO: renamed from: g */
    public List<AbstractC2360j> m2152g() {
        AbstractC2360j[] abstractC2360jArr = this._types;
        return abstractC2360jArr.length == 0 ? Collections.emptyList() : Arrays.asList(abstractC2360jArr);
    }

    /* JADX INFO: renamed from: h */
    public boolean m2153h(String str) {
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

    /* JADX INFO: renamed from: i */
    public boolean m2154i() {
        return this._types.length == 0;
    }

    /* JADX INFO: renamed from: j */
    public int m2155j() {
        return this._types.length;
    }

    /* JADX INFO: renamed from: k */
    public AbstractC2360j[] m2156k() {
        return this._types;
    }

    /* JADX INFO: renamed from: l */
    public C2334m m2157l(String str) {
        String[] strArr = this._unboundVariables;
        int length = strArr == null ? 0 : strArr.length;
        String[] strArr2 = length == 0 ? new String[1] : (String[]) Arrays.copyOf(strArr, length + 1);
        strArr2[length] = str;
        return new C2334m(this._names, this._types, strArr2);
    }

    public Object readResolve() {
        String[] strArr = this._names;
        return (strArr == null || strArr.length == 0) ? f4908l : this;
    }

    public String toString() {
        if (this._types.length == 0) {
            return "<>";
        }
        StringBuilder sbM829Q = C1643a.m829Q('<');
        int length = this._types.length;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sbM829Q.append(',');
            }
            AbstractC2360j abstractC2360j = this._types[i];
            StringBuilder sb = new StringBuilder(40);
            abstractC2360j.mo2101m(sb);
            sbM829Q.append(sb.toString());
        }
        sbM829Q.append('>');
        return sbM829Q.toString();
    }
}
