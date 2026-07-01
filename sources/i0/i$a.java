package i0;

import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$a implements e<Object, d<?>> {
    public final /* synthetic */ Type a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Executor f3740b;

    public i$a(i iVar, Type type, Executor executor) {
        this.a = type;
        this.f3740b = executor;
    }

    @Override // i0.e
    public Type a() {
        return this.a;
    }

    @Override // i0.e
    public d<?> b(d<Object> dVar) {
        Executor executor = this.f3740b;
        return executor == null ? dVar : new i$b(executor, dVar);
    }
}
