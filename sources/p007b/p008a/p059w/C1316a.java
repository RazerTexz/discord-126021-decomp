package p007b.p008a.p059w;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.w.a */
/* JADX INFO: compiled from: TypeTokens.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1316a {

    /* JADX INFO: renamed from: a */
    public static final Type f2003a;

    /* JADX INFO: renamed from: b.a.w.a$a */
    /* JADX INFO: compiled from: TypeTokens.kt */
    public static final class a extends TypeToken<List<? extends String>> {
    }

    static {
        Type type = new a().getType();
        C12238m.checkNotNullExpressionValue(type, "object : TypeToken<List<String>>() {}.type");
        f2003a = type;
    }
}
