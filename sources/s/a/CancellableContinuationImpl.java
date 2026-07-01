package s.a;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: s.a.b1, reason: use source file name */
/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CancellableContinuationImpl extends CancellableContinuationImpl4 {
    public final Function1<Throwable, Unit> j;

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(Function1<? super Throwable, Unit> function1) {
        this.j = function1;
    }

    @Override // s.a.CompletionHandler
    public void a(Throwable th) {
        this.j.invoke(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.j.invoke(th);
        return Unit.a;
    }

    public String toString() {
        StringBuilder sbU = outline.U("InvokeOnCancel[");
        sbU.append(b.i.a.f.e.o.f.e0(this.j));
        sbU.append(MentionUtils.MENTIONS_CHAR);
        sbU.append(b.i.a.f.e.o.f.l0(this));
        sbU.append(']');
        return sbU.toString();
    }
}
