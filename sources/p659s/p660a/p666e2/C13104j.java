package p659s.p660a.p666e2;

import com.discord.widgets.chat.input.MentionUtilsKt;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: s.a.e2.j */
/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13104j extends AbstractRunnableC13102h {

    /* JADX INFO: renamed from: l */
    public final Runnable f27830l;

    public C13104j(Runnable runnable, long j, InterfaceC13103i interfaceC13103i) {
        super(j, interfaceC13103i);
        this.f27830l = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f27830l.run();
        } finally {
            this.f27829k.mo11268f();
        }
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Task[");
        sbM833U.append(C3404f.m4284e0(this.f27830l));
        sbM833U.append(MentionUtilsKt.MENTIONS_CHAR);
        sbM833U.append(C3404f.m4312l0(this.f27830l));
        sbM833U.append(", ");
        sbM833U.append(this.f27828j);
        sbM833U.append(", ");
        sbM833U.append(this.f27829k);
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
