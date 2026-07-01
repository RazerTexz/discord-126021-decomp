package s.a;

import b.d.b.a.a;
import com.discord.widgets.chat.input.MentionUtilsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b1 extends j {
    public final Function1<Throwable, Unit> j;

    /* JADX WARN: Multi-variable type inference failed */
    public b1(Function1<? super Throwable, Unit> function1) {
        this.j = function1;
    }

    @Override // s.a.k
    public void a(Throwable th) {
        this.j.invoke(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.j.invoke(th);
        return Unit.a;
    }

    public String toString() {
        StringBuilder sbU = a.U("InvokeOnCancel[");
        sbU.append(b.i.a.f.e.o.f.e0(this.j));
        sbU.append(MentionUtilsKt.MENTIONS_CHAR);
        sbU.append(b.i.a.f.e.o.f.l0(this));
        sbU.append(']');
        return sbU.toString();
    }
}
