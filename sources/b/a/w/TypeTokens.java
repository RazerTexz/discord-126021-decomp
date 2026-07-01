package b.a.w;

import com.google.gson.reflect.TypeToken;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: renamed from: b.a.w.a, reason: use source file name */
/* JADX INFO: compiled from: TypeTokens.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeTokens {
    public static final Type a;

    /* JADX INFO: renamed from: b.a.w.a$a */
    /* JADX INFO: compiled from: TypeTokens.kt */
    public static final class a extends TypeToken<List<? extends String>> {
    }

    static {
        Type type = new a().getType();
        Intrinsics3.checkNotNullExpressionValue(type, "object : TypeToken<List<String>>() {}.type");
        a = type;
    }
}
