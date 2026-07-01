package d0.e0.p.d;

import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$b extends d {
    public final Constructor<?> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$b(Constructor<?> constructor) {
        super(null);
        d0.z.d.m.checkNotNullParameter(constructor, "constructor");
        this.a = constructor;
    }

    @Override // d0.e0.p.d.d
    public String asString() {
        Class<?>[] parameterTypes = this.a.getParameterTypes();
        d0.z.d.m.checkNotNullExpressionValue(parameterTypes, "constructor.parameterTypes");
        return d0.t.k.joinToString$default(parameterTypes, "", "<init>(", ")V", 0, (CharSequence) null, d$b$a.j, 24, (Object) null);
    }

    public final Constructor<?> getConstructor() {
        return this.a;
    }
}
