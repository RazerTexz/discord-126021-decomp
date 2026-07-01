package d0.e0.p.d.l0;

import d0.t.k;
import d0.z.d.m;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CallerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e$f extends e<Field> {
    /* JADX WARN: Illegal instructions before constructor call */
    public e$f(Field field, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        Type genericType = field.getGenericType();
        m.checkNotNullExpressionValue(genericType, "field.genericType");
        super(field, genericType, z2 ? field.getDeclaringClass() : null, new Type[0], null);
    }

    @Override // d0.e0.p.d.l0.d
    public Object call(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        checkArguments(objArr);
        return mo80getMember().get(getInstanceClass() != null ? k.first(objArr) : null);
    }
}
