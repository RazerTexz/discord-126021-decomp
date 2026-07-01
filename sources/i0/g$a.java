package i0;

import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
@IgnoreJRERequirement
public final class g$a<R> implements e<R, CompletableFuture<R>> {
    public final Type a;

    public g$a(Type type) {
        this.a = type;
    }

    @Override // i0.e
    public Type a() {
        return this.a;
    }

    @Override // i0.e
    public Object b(d dVar) {
        g$b g_b = new g$b(dVar);
        dVar.C(new g$a$a(this, g_b));
        return g_b;
    }
}
