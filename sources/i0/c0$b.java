package i0;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c0$b implements ParameterizedType {
    public final Type j;
    public final Type k;
    public final Type[] l;

    public c0$b(Type type, Type type2, Type... typeArr) {
        if (type2 instanceof Class) {
            if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                throw new IllegalArgumentException();
            }
        }
        for (Type type3 : typeArr) {
            Objects.requireNonNull(type3, "typeArgument == null");
            c0.b(type3);
        }
        this.j = type;
        this.k = type2;
        this.l = (Type[]) typeArr.clone();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && c0.c(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return (Type[]) this.l.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.j;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.k;
    }

    public int hashCode() {
        int iHashCode = Arrays.hashCode(this.l) ^ this.k.hashCode();
        Type type = this.j;
        return iHashCode ^ (type != null ? type.hashCode() : 0);
    }

    public String toString() {
        Type[] typeArr = this.l;
        if (typeArr.length == 0) {
            return c0.p(this.k);
        }
        StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
        sb.append(c0.p(this.k));
        sb.append("<");
        sb.append(c0.p(this.l[0]));
        for (int i = 1; i < this.l.length; i++) {
            sb.append(", ");
            sb.append(c0.p(this.l[i]));
        }
        sb.append(">");
        return sb.toString();
    }
}
