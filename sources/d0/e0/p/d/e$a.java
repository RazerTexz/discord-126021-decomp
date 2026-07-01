package d0.e0.p.d;

import java.lang.reflect.Field;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a extends e {
    public final Field a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$a(Field field) {
        super(null);
        d0.z.d.m.checkNotNullParameter(field, "field");
        this.a = field;
    }

    @Override // d0.e0.p.d.e
    public String asString() {
        StringBuilder sb = new StringBuilder();
        String name = this.a.getName();
        d0.z.d.m.checkNotNullExpressionValue(name, "field.name");
        sb.append(d0.e0.p.d.m0.e.a.z.getterName(name));
        sb.append("()");
        Class<?> type = this.a.getType();
        d0.z.d.m.checkNotNullExpressionValue(type, "field.type");
        sb.append(d0.e0.p.d.m0.c.k1.b.b.getDesc(type));
        return sb.toString();
    }

    public final Field getField() {
        return this.a;
    }
}
