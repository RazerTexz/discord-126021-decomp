package p659s.p660a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: s.a.b1 */
/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13047b1 extends AbstractC13120j {

    /* JADX INFO: renamed from: j */
    public final Function1<Throwable, Unit> f27717j;

    /* JADX WARN: Multi-variable type inference failed */
    public C13047b1(Function1<? super Throwable, Unit> function1) {
        this.f27717j = function1;
    }

    @Override // p659s.p660a.AbstractC13123k
    /* JADX INFO: renamed from: a */
    public void mo11193a(Throwable th) {
        this.f27717j.invoke(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.f27717j.invoke(th);
        return Unit.f27425a;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("InvokeOnCancel[");
        sbM833U.append(C3404f.m4284e0(this.f27717j));
        sbM833U.append(MentionUtilsKt.MENTIONS_CHAR);
        sbM833U.append(C3404f.m4312l0(this));
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
