package p507d0.p578f0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.f0.g */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12068g<T> implements Sequence<T> {

    /* JADX INFO: renamed from: a */
    public final Sequence<T> f25082a;

    /* JADX INFO: renamed from: b */
    public final boolean f25083b;

    /* JADX INFO: renamed from: c */
    public final Function1<T, Boolean> f25084c;

    /* JADX INFO: renamed from: d0.f0.g$a */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, InterfaceC12228a {

        /* JADX INFO: renamed from: j */
        public final Iterator<T> f25085j;

        /* JADX INFO: renamed from: k */
        public int f25086k = -1;

        /* JADX INFO: renamed from: l */
        public T f25087l;

        public a() {
            this.f25085j = C12068g.this.f25082a.iterator();
        }

        /* JADX INFO: renamed from: a */
        public final void m10061a() {
            while (this.f25085j.hasNext()) {
                T next = this.f25085j.next();
                if (((Boolean) C12068g.this.f25084c.invoke(next)).booleanValue() == C12068g.this.f25083b) {
                    this.f25087l = next;
                    this.f25086k = 1;
                    return;
                }
            }
            this.f25086k = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f25086k == -1) {
                m10061a();
            }
            return this.f25086k == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f25086k == -1) {
                m10061a();
            }
            if (this.f25086k == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f25087l;
            this.f25087l = null;
            this.f25086k = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12068g(Sequence<? extends T> sequence, boolean z2, Function1<? super T, Boolean> function1) {
        C12238m.checkNotNullParameter(sequence, "sequence");
        C12238m.checkNotNullParameter(function1, "predicate");
        this.f25082a = sequence;
        this.f25083b = z2;
        this.f25084c = function1;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a();
    }
}
