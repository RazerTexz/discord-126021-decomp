package d0.e0.p.d.m0.b;

import d0.t.u;
import java.util.ServiceLoader;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: BuiltInsLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a$a extends d0.z.d.o implements Function0<a> {
    public static final a$a$a j = new a$a$a();

    public a$a$a() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        ServiceLoader serviceLoaderLoad = ServiceLoader.load(a.class, a.class.getClassLoader());
        d0.z.d.m.checkNotNullExpressionValue(serviceLoaderLoad, "implementations");
        a aVar = (a) u.firstOrNull(serviceLoaderLoad);
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
    }
}
