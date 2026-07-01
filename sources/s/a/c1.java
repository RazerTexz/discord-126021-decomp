package s.a;

import b.d.b.a.a;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c1 extends e1<Job> {
    public static final AtomicIntegerFieldUpdater n = AtomicIntegerFieldUpdater.newUpdater(c1.class, "_invoked");
    public volatile int _invoked;
    public final Function1<Throwable, Unit> o;

    /* JADX WARN: Multi-variable type inference failed */
    public c1(Job job, Function1<? super Throwable, Unit> function1) {
        super(job);
        this.o = function1;
        this._invoked = 0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        q(th);
        return Unit.a;
    }

    @Override // s.a.y
    public void q(Throwable th) {
        if (n.compareAndSet(this, 0, 1)) {
            this.o.invoke(th);
        }
    }

    @Override // s.a.a.k
    public String toString() {
        StringBuilder sbU = a.U("InvokeOnCancelling[");
        sbU.append(c1.class.getSimpleName());
        sbU.append(MentionUtilsKt.MENTIONS_CHAR);
        sbU.append(b.i.a.f.e.o.f.l0(this));
        sbU.append(']');
        return sbU.toString();
    }
}
