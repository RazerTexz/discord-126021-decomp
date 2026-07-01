package b.i.d.q;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Objects;

/* JADX INFO: compiled from: $Gson$Types.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$c implements WildcardType, Serializable {
    private static final long serialVersionUID = 0;
    private final Type lowerBound;
    private final Type upperBound;

    public a$c(Type[] typeArr, Type[] typeArr2) {
        b.i.a.f.e.o.f.w(typeArr2.length <= 1);
        b.i.a.f.e.o.f.w(typeArr.length == 1);
        if (typeArr2.length != 1) {
            Objects.requireNonNull(typeArr[0]);
            a.b(typeArr[0]);
            this.lowerBound = null;
            this.upperBound = a.a(typeArr[0]);
            return;
        }
        Objects.requireNonNull(typeArr2[0]);
        a.b(typeArr2[0]);
        b.i.a.f.e.o.f.w(typeArr[0] == Object.class);
        this.lowerBound = a.a(typeArr2[0]);
        this.upperBound = Object.class;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WildcardType) && a.c(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        Type type = this.lowerBound;
        return type != null ? new Type[]{type} : a.a;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        return new Type[]{this.upperBound};
    }

    public int hashCode() {
        Type type = this.lowerBound;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.upperBound.hashCode() + 31);
    }

    public String toString() {
        if (this.lowerBound != null) {
            StringBuilder sbU = b.d.b.a.a.U("? super ");
            sbU.append(a.i(this.lowerBound));
            return sbU.toString();
        }
        if (this.upperBound == Object.class) {
            return "?";
        }
        StringBuilder sbU2 = b.d.b.a.a.U("? extends ");
        sbU2.append(a.i(this.upperBound));
        return sbU2.toString();
    }
}
