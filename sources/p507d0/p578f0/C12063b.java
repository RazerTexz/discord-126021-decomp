package p507d0.p578f0;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.AbstractC12123b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.f0.b */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12063b<T, K> extends AbstractC12123b<T> {

    /* JADX INFO: renamed from: l */
    public final HashSet<K> f25072l;

    /* JADX INFO: renamed from: m */
    public final Iterator<T> f25073m;

    /* JADX INFO: renamed from: n */
    public final Function1<T, K> f25074n;

    /* JADX WARN: Multi-variable type inference failed */
    public C12063b(Iterator<? extends T> it, Function1<? super T, ? extends K> function1) {
        C12238m.checkNotNullParameter(it, "source");
        C12238m.checkNotNullParameter(function1, "keySelector");
        this.f25073m = it;
        this.f25074n = function1;
        this.f25072l = new HashSet<>();
    }

    @Override // p507d0.p580t.AbstractC12123b
    /* JADX INFO: renamed from: a */
    public void mo10059a() {
        while (this.f25073m.hasNext()) {
            T next = this.f25073m.next();
            if (this.f25072l.add(this.f25074n.invoke(next))) {
                m10074b(next);
                return;
            }
        }
        this.f25173j = 3;
    }
}
