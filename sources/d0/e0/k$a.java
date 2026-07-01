package d0.e0;

import java.lang.reflect.Type;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k$a extends d0.z.d.k implements Function1<Type, String> {
    public static final k$a j = new k$a();

    public k$a() {
        super(1, n.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Type type) {
        return invoke2(type);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(Type type) {
        d0.z.d.m.checkNotNullParameter(type, "p1");
        return n.access$typeToString(type);
    }
}
