package d0.e0.p.d.l0;

import d0.t.k;
import d0.z.d.m;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CallerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e$g extends e<Field> {
    public final boolean f;

    /* JADX WARN: Illegal instructions before constructor call */
    public e$g(Field field, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        Class cls = Void.TYPE;
        m.checkNotNullExpressionValue(cls, "Void.TYPE");
        Class<?> declaringClass = z3 ? field.getDeclaringClass() : null;
        Type genericType = field.getGenericType();
        m.checkNotNullExpressionValue(genericType, "field.genericType");
        super(field, cls, declaringClass, new Type[]{genericType}, null);
        this.f = z2;
    }

    @Override // d0.e0.p.d.l0.d
    public Object call(Object[] objArr) throws IllegalAccessException {
        m.checkNotNullParameter(objArr, "args");
        checkArguments(objArr);
        mo80getMember().set(getInstanceClass() != null ? k.first(objArr) : null, k.last(objArr));
        return Unit.a;
    }

    @Override // d0.e0.p.d.l0.e
    public void checkArguments(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        super.checkArguments(objArr);
        if (this.f && k.last(objArr) == null) {
            throw new IllegalArgumentException("null is not allowed as a value for this property.");
        }
    }
}
