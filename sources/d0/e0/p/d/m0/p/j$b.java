package d0.e0.p.d.m0.p;

import d0.z.d.m;
import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SmartSet.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$b {
    public j$b(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final <T> j<T> create() {
        return new j<>(null);
    }

    public final <T> j<T> create(Collection<? extends T> collection) {
        m.checkNotNullParameter(collection, "set");
        j<T> jVar = new j<>(null);
        jVar.addAll(collection);
        return jVar;
    }
}
