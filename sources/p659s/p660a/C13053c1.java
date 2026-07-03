package p659s.p660a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: s.a.c1 */
/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13053c1 extends AbstractC13094e1<Job> {

    /* JADX INFO: renamed from: n */
    public static final AtomicIntegerFieldUpdater f27727n = AtomicIntegerFieldUpdater.newUpdater(C13053c1.class, "_invoked");
    public volatile int _invoked;

    /* JADX INFO: renamed from: o */
    public final Function1<Throwable, Unit> f27728o;

    /* JADX WARN: Multi-variable type inference failed */
    public C13053c1(Job job, Function1<? super Throwable, Unit> function1) {
        super(job);
        this.f27728o = function1;
        this._invoked = 0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        mo11198q(th);
        return Unit.f27425a;
    }

    @Override // p659s.p660a.AbstractC13165y
    /* JADX INFO: renamed from: q */
    public void mo11198q(Throwable th) {
        if (f27727n.compareAndSet(this, 0, 1)) {
            this.f27728o.invoke(th);
        }
    }

    @Override // p659s.p660a.p661a.C13028k
    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("InvokeOnCancelling[");
        sbM833U.append(C13053c1.class.getSimpleName());
        sbM833U.append(MentionUtilsKt.MENTIONS_CHAR);
        sbM833U.append(C3404f.m4312l0(this));
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
