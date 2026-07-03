package p507d0.p513e0;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12141k;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.k */
/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11238k implements ParameterizedType, Type {

    /* JADX INFO: renamed from: j */
    public final Type[] f22308j;

    /* JADX INFO: renamed from: k */
    public final Class<?> f22309k;

    /* JADX INFO: renamed from: l */
    public final Type f22310l;

    /* JADX INFO: renamed from: d0.e0.k$a */
    /* JADX INFO: compiled from: TypesJVM.kt */
    public static final /* synthetic */ class a extends C12236k implements Function1<Type, String> {

        /* JADX INFO: renamed from: j */
        public static final a f22311j = new a();

        public a() {
            super(1, C11241n.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(Type type) {
            C12238m.checkNotNullParameter(type, "p1");
            return C11241n.access$typeToString(type);
        }
    }

    public C11238k(Class<?> cls, Type type, List<? extends Type> list) {
        C12238m.checkNotNullParameter(cls, "rawType");
        C12238m.checkNotNullParameter(list, "typeArguments");
        this.f22309k = cls;
        this.f22310l = type;
        Object[] array = list.toArray(new Type[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.f22308j = (Type[]) array;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (C12238m.areEqual(this.f22309k, parameterizedType.getRawType()) && C12238m.areEqual(this.f22310l, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.f22308j;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.f22310l;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f22309k;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() throws IOException {
        StringBuilder sb = new StringBuilder();
        Type type = this.f22310l;
        if (type != null) {
            sb.append(C11241n.access$typeToString(type));
            sb.append("$");
            sb.append(this.f22309k.getSimpleName());
        } else {
            sb.append(C11241n.access$typeToString(this.f22309k));
        }
        Type[] typeArr = this.f22308j;
        if (!(typeArr.length == 0)) {
            C12141k.joinTo(typeArr, sb, (50 & 2) != 0 ? ", " : null, (50 & 4) != 0 ? "" : "<", (50 & 8) == 0 ? ">" : "", (50 & 16) != 0 ? -1 : 0, (50 & 32) != 0 ? "..." : null, (50 & 64) != 0 ? null : a.f22311j);
        }
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public int hashCode() {
        int iHashCode = this.f22309k.hashCode();
        Type type = this.f22310l;
        return (iHashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    public String toString() {
        return getTypeName();
    }
}
