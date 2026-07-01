package b.g.a.c.b0;

import b.g.a.c.n;
import java.nio.file.Path;

/* JADX INFO: compiled from: Java7HandlersImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f680b = Path.class;

    @Override // b.g.a.c.b0.a
    public n<?> a(Class<?> cls) {
        if (this.f680b.isAssignableFrom(cls)) {
            return new e();
        }
        return null;
    }
}
