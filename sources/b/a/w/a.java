package b.a.w;

import d0.z.d.m;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: TypeTokens.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final Type a;

    static {
        Type type = new a$a().getType();
        m.checkNotNullExpressionValue(type, "object : TypeToken<List<String>>() {}.type");
        a = type;
    }
}
