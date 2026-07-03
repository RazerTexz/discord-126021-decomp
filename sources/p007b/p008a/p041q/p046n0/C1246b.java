package p007b.p008a.p041q.p046n0;

import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.q.n0.b */
/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1246b extends TimerTask {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1245a f1802j;

    /* JADX INFO: renamed from: b.a.q.n0.b$a */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class a extends AbstractC12240o implements Function0<Unit> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            C1245a c1245a = C1246b.this.f1802j;
            int i = C1245a.f1763j;
            c1245a.m347k();
            return Unit.f27425a;
        }
    }

    public C1246b(C1245a c1245a) {
        this.f1802j = c1245a;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f1802j.m349m(new a());
    }
}
