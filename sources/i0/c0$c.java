package i0;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Objects;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c0$c implements WildcardType {
    public final Type j;
    public final Type k;

    public c0$c(Type[] typeArr, Type[] typeArr2) {
        if (typeArr2.length > 1) {
            throw new IllegalArgumentException();
        }
        if (typeArr.length != 1) {
            throw new IllegalArgumentException();
        }
        if (typeArr2.length != 1) {
            Objects.requireNonNull(typeArr[0]);
            c0.b(typeArr[0]);
            this.k = null;
            this.j = typeArr[0];
            return;
        }
        Objects.requireNonNull(typeArr2[0]);
        c0.b(typeArr2[0]);
        if (typeArr[0] != Object.class) {
            throw new IllegalArgumentException();
        }
        this.k = typeArr2[0];
        this.j = Object.class;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WildcardType) && c0.c(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        Type type = this.k;
        return type != null ? new Type[]{type} : c0.a;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        return new Type[]{this.j};
    }

    public int hashCode() {
        Type type = this.k;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.j.hashCode() + 31);
    }

    public String toString() {
        if (this.k != null) {
            StringBuilder sbU = b.d.b.a.a.U("? super ");
            sbU.append(c0.p(this.k));
            return sbU.toString();
        }
        if (this.j == Object.class) {
            return "?";
        }
        StringBuilder sbU2 = b.d.b.a.a.U("? extends ");
        sbU2.append(c0.p(this.j));
        return sbU2.toString();
    }
}
