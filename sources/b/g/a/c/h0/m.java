package b.g.a.c.h0;

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

/* JADX INFO: compiled from: TypeBindings.java */
/* JADX INFO: loaded from: classes3.dex */
public class m implements Serializable {
    public static final String[] j;
    public static final b.g.a.c.j[] k;
    public static final m l;
    private static final long serialVersionUID = 1;
    private final int _hashCode;
    private final String[] _names;
    private final b.g.a.c.j[] _types;
    private final String[] _unboundVariables;

    static {
        String[] strArr = new String[0];
        j = strArr;
        b.g.a.c.j[] jVarArr = new b.g.a.c.j[0];
        k = jVarArr;
        l = new m(strArr, jVarArr, null);
    }

    public m(String[] strArr, b.g.a.c.j[] jVarArr, String[] strArr2) {
        strArr = strArr == null ? j : strArr;
        this._names = strArr;
        jVarArr = jVarArr == null ? k : jVarArr;
        this._types = jVarArr;
        if (strArr.length != jVarArr.length) {
            StringBuilder sbU = b.d.b.a.a.U("Mismatching names (");
            sbU.append(strArr.length);
            sbU.append("), types (");
            throw new IllegalArgumentException(b.d.b.a.a.B(sbU, jVarArr.length, ")"));
        }
        int length = jVarArr.length;
        int i = 1;
        for (int i2 = 0; i2 < length; i2++) {
            i += this._types[i2]._hash;
        }
        this._unboundVariables = strArr2;
        this._hashCode = i;
    }

    public static m b(Class<?> cls, b.g.a.c.j jVar) {
        TypeVariable[] typeParameters;
        TypeVariable<?>[] typeVariableArr = m$b.a;
        if (cls == Collection.class) {
            typeParameters = m$b.f721b;
        } else if (cls == List.class) {
            typeParameters = m$b.d;
        } else if (cls == ArrayList.class) {
            typeParameters = m$b.e;
        } else if (cls == AbstractList.class) {
            typeParameters = m$b.a;
        } else {
            typeParameters = cls == Iterable.class ? m$b.c : cls.getTypeParameters();
        }
        int length = typeParameters == null ? 0 : typeParameters.length;
        if (length == 1) {
            return new m(new String[]{typeParameters[0].getName()}, new b.g.a.c.j[]{jVar}, null);
        }
        StringBuilder sbU = b.d.b.a.a.U("Cannot create TypeBindings for class ");
        sbU.append(cls.getName());
        sbU.append(" with 1 type parameter: class expects ");
        sbU.append(length);
        throw new IllegalArgumentException(sbU.toString());
    }

    public static m c(Class<?> cls, b.g.a.c.j jVar, b.g.a.c.j jVar2) {
        TypeVariable[] typeParameters;
        TypeVariable<?>[] typeVariableArr = m$b.a;
        if (cls == Map.class) {
            typeParameters = m$b.f;
        } else if (cls == HashMap.class) {
            typeParameters = m$b.g;
        } else {
            typeParameters = cls == LinkedHashMap.class ? m$b.h : cls.getTypeParameters();
        }
        int length = typeParameters == null ? 0 : typeParameters.length;
        if (length == 2) {
            return new m(new String[]{typeParameters[0].getName(), typeParameters[1].getName()}, new b.g.a.c.j[]{jVar, jVar2}, null);
        }
        StringBuilder sbU = b.d.b.a.a.U("Cannot create TypeBindings for class ");
        sbU.append(cls.getName());
        sbU.append(" with 2 type parameters: class expects ");
        sbU.append(length);
        throw new IllegalArgumentException(sbU.toString());
    }

    public static m d(Class<?> cls, b.g.a.c.j[] jVarArr) {
        String[] strArr;
        int length = jVarArr.length;
        if (length == 1) {
            return b(cls, jVarArr[0]);
        }
        if (length == 2) {
            return c(cls, jVarArr[0], jVarArr[1]);
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
        if (strArr.length == jVarArr.length) {
            return new m(strArr, jVarArr, null);
        }
        StringBuilder sbU = b.d.b.a.a.U("Cannot create TypeBindings for class ");
        b.d.b.a.a.k0(cls, sbU, " with ");
        sbU.append(jVarArr.length);
        sbU.append(" type parameter");
        sbU.append(jVarArr.length == 1 ? "" : "s");
        sbU.append(": class expects ");
        sbU.append(strArr.length);
        throw new IllegalArgumentException(sbU.toString());
    }

    public Object a(Class<?> cls) {
        return new m$a(cls, this._types, this._hashCode);
    }

    public b.g.a.c.j e(String str) {
        b.g.a.c.j jVar;
        int length = this._names.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(this._names[i])) {
                b.g.a.c.j jVar2 = this._types[i];
                return (!(jVar2 instanceof j) || (jVar = ((j) jVar2)._referencedType) == null) ? jVar2 : jVar;
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!b.g.a.c.i0.d.o(obj, m.class)) {
            return false;
        }
        int length = this._types.length;
        b.g.a.c.j[] jVarArr = ((m) obj)._types;
        if (length != jVarArr.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!jVarArr[i].equals(this._types[i])) {
                return false;
            }
        }
        return true;
    }

    public b.g.a.c.j f(int i) {
        if (i < 0) {
            return null;
        }
        b.g.a.c.j[] jVarArr = this._types;
        if (i >= jVarArr.length) {
            return null;
        }
        return jVarArr[i];
    }

    public List<b.g.a.c.j> g() {
        b.g.a.c.j[] jVarArr = this._types;
        return jVarArr.length == 0 ? Collections.emptyList() : Arrays.asList(jVarArr);
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

    public b.g.a.c.j[] k() {
        return this._types;
    }

    public m l(String str) {
        String[] strArr = this._unboundVariables;
        int length = strArr == null ? 0 : strArr.length;
        String[] strArr2 = length == 0 ? new String[1] : (String[]) Arrays.copyOf(strArr, length + 1);
        strArr2[length] = str;
        return new m(this._names, this._types, strArr2);
    }

    public Object readResolve() {
        String[] strArr = this._names;
        return (strArr == null || strArr.length == 0) ? l : this;
    }

    public String toString() {
        if (this._types.length == 0) {
            return "<>";
        }
        StringBuilder sbQ = b.d.b.a.a.Q('<');
        int length = this._types.length;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sbQ.append(',');
            }
            b.g.a.c.j jVar = this._types[i];
            StringBuilder sb = new StringBuilder(40);
            jVar.m(sb);
            sbQ.append(sb.toString());
        }
        sbQ.append('>');
        return sbQ.toString();
    }
}
