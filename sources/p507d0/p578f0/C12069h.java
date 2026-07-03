package p507d0.p578f0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.f0.h */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12069h<T, R, E> implements Sequence<E> {

    /* JADX INFO: renamed from: a */
    public final Sequence<T> f25089a;

    /* JADX INFO: renamed from: b */
    public final Function1<T, R> f25090b;

    /* JADX INFO: renamed from: c */
    public final Function1<R, Iterator<E>> f25091c;

    /* JADX INFO: renamed from: d0.f0.h$a */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<E>, InterfaceC12228a {

        /* JADX INFO: renamed from: j */
        public final Iterator<T> f25092j;

        /* JADX INFO: renamed from: k */
        public Iterator<? extends E> f25093k;

        public a() {
            this.f25092j = C12069h.this.f25089a.iterator();
        }

        /* JADX INFO: renamed from: a */
        public final boolean m10062a() {
            Iterator<? extends E> it = this.f25093k;
            if (it != null && !it.hasNext()) {
                this.f25093k = null;
            }
            while (this.f25093k == null) {
                if (!this.f25092j.hasNext()) {
                    return false;
                }
                Iterator<? extends E> it2 = (Iterator) C12069h.this.f25091c.invoke(C12069h.this.f25090b.invoke(this.f25092j.next()));
                if (it2.hasNext()) {
                    this.f25093k = it2;
                    break;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return m10062a();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!m10062a()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends E> it = this.f25093k;
            C12238m.checkNotNull(it);
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12069h(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1, Function1<? super R, ? extends Iterator<? extends E>> function2) {
        C12238m.checkNotNullParameter(sequence, "sequence");
        C12238m.checkNotNullParameter(function1, "transformer");
        C12238m.checkNotNullParameter(function2, "iterator");
        this.f25089a = sequence;
        this.f25090b = function1;
        this.f25091c = function2;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<E> iterator() {
        return new a();
    }
}
