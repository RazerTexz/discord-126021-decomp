package s.a.d2.g;

import d0.t.u;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> implements s.a.d2.d {
    public final CoroutineContext a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3837b;
    public final s.a.c2.e c;

    public a(CoroutineContext coroutineContext, int i, s.a.c2.e eVar) {
        this.a = coroutineContext;
        this.f3837b = i;
        this.c = eVar;
    }

    @Override // s.a.d2.d
    public Object a(s.a.d2.e<? super T> eVar, Continuation<? super Unit> continuation) throws Throwable {
        Object objM = b.i.a.f.e.o.f.M(new a$a(this, eVar, null), continuation);
        return objM == d0.w.h.c.getCOROUTINE_SUSPENDED() ? objM : Unit.a;
    }

    public abstract Object b(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation);

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        if (this.a != d0.w.f.j) {
            StringBuilder sbU = b.d.b.a.a.U("context=");
            sbU.append(this.a);
            arrayList.add(sbU.toString());
        }
        if (this.f3837b != -3) {
            StringBuilder sbU2 = b.d.b.a.a.U("capacity=");
            sbU2.append(this.f3837b);
            arrayList.add(sbU2.toString());
        }
        if (this.c != s.a.c2.e.SUSPEND) {
            StringBuilder sbU3 = b.d.b.a.a.U("onBufferOverflow=");
            sbU3.append(this.c);
            arrayList.add(sbU3.toString());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        return b.d.b.a.a.H(sb, u.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null), ']');
    }
}
