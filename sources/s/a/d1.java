package s.a;

import b.d.b.a.a;
import com.discord.widgets.chat.input.MentionUtilsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d1 extends g1<Job> {
    public final Function1<Throwable, Unit> n;

    /* JADX WARN: Multi-variable type inference failed */
    public d1(Job job, Function1<? super Throwable, Unit> function1) {
        super(job);
        this.n = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.n.invoke(th);
        return Unit.a;
    }

    @Override // s.a.y
    public void q(Throwable th) {
        this.n.invoke(th);
    }

    @Override // s.a.a.k
    public String toString() {
        StringBuilder sbU = a.U("InvokeOnCompletion[");
        sbU.append(d1.class.getSimpleName());
        sbU.append(MentionUtilsKt.MENTIONS_CHAR);
        sbU.append(b.i.a.f.e.o.f.l0(this));
        sbU.append(']');
        return sbU.toString();
    }
}
