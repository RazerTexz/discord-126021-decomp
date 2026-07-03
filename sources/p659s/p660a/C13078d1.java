package p659s.p660a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: s.a.d1 */
/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13078d1 extends AbstractC13113g1<Job> {

    /* JADX INFO: renamed from: n */
    public final Function1<Throwable, Unit> f27780n;

    /* JADX WARN: Multi-variable type inference failed */
    public C13078d1(Job job, Function1<? super Throwable, Unit> function1) {
        super(job);
        this.f27780n = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.f27780n.invoke(th);
        return Unit.f27425a;
    }

    @Override // p659s.p660a.AbstractC13165y
    /* JADX INFO: renamed from: q */
    public void mo11198q(Throwable th) {
        this.f27780n.invoke(th);
    }

    @Override // p659s.p660a.p661a.C13028k
    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("InvokeOnCompletion[");
        sbM833U.append(C13078d1.class.getSimpleName());
        sbM833U.append(MentionUtilsKt.MENTIONS_CHAR);
        sbM833U.append(C3404f.m4312l0(this));
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
