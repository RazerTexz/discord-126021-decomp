package i0;

import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
@IgnoreJRERequirement
public final class g$b<T> extends CompletableFuture<T> {
    public final d<?> j;

    public g$b(d<?> dVar) {
        this.j = dVar;
    }

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        if (z2) {
            this.j.cancel();
        }
        return super.cancel(z2);
    }
}
