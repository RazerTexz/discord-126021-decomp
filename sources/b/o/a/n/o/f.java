package b.o.a.n.o;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: CompletionCallback.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class f implements b {
    @Override // b.o.a.n.o.b
    public final void a(@NonNull a aVar, int i) {
        if (i == Integer.MAX_VALUE) {
            b(aVar);
        }
    }

    public abstract void b(@NonNull a aVar);
}
