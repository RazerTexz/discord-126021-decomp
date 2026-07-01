package s.a.c2;

import java.util.Objects;
import kotlin.Unit;

/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$e extends s.a.e {
    public final n<?> j;
    public final /* synthetic */ a k;

    public a$e(a aVar, n<?> nVar) {
        this.k = aVar;
        this.j = nVar;
    }

    @Override // s.a.k
    public void a(Throwable th) {
        if (this.j.n()) {
            Objects.requireNonNull(this.k);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        if (this.j.n()) {
            Objects.requireNonNull(this.k);
        }
        return Unit.a;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("RemoveReceiveOnCancel[");
        sbU.append(this.j);
        sbU.append(']');
        return sbU.toString();
    }
}
