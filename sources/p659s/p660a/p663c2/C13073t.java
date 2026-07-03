package p659s.p660a.p663c2;

import com.discord.widgets.chat.input.MentionUtilsKt;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12112k;
import p507d0.C12113l;
import p659s.p660a.C13129m;
import p659s.p660a.p661a.C13028k;
import p659s.p660a.p661a.C13037t;

/* JADX INFO: renamed from: s.a.c2.t */
/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C13073t<E> extends AbstractC13071r {

    /* JADX INFO: renamed from: m */
    public final E f27767m;

    /* JADX INFO: renamed from: n */
    public final CancellableContinuation<Unit> f27768n;

    /* JADX WARN: Multi-variable type inference failed */
    public C13073t(E e, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.f27767m = e;
        this.f27768n = cancellableContinuation;
    }

    @Override // p659s.p660a.p663c2.AbstractC13071r
    /* JADX INFO: renamed from: q */
    public void mo11227q() {
        this.f27768n.mo10907r(C13129m.f27874a);
    }

    @Override // p659s.p660a.p663c2.AbstractC13071r
    /* JADX INFO: renamed from: r */
    public E mo11228r() {
        return this.f27767m;
    }

    @Override // p659s.p660a.p663c2.AbstractC13071r
    /* JADX INFO: renamed from: s */
    public void mo11229s(C13062i<?> c13062i) {
        CancellableContinuation<Unit> cancellableContinuation = this.f27768n;
        Throwable thM11234w = c13062i.m11234w();
        C12112k.a aVar = C12112k.f25169j;
        cancellableContinuation.resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(thM11234w)));
    }

    @Override // p659s.p660a.p663c2.AbstractC13071r
    /* JADX INFO: renamed from: t */
    public C13037t mo11230t(C13028k.b bVar) {
        if (this.f27768n.mo10901c(Unit.f27425a, null) != null) {
            return C13129m.f27874a;
        }
        return null;
    }

    @Override // p659s.p660a.p661a.C13028k
    public String toString() {
        return getClass().getSimpleName() + MentionUtilsKt.MENTIONS_CHAR + C3404f.m4312l0(this) + '(' + this.f27767m + ')';
    }
}
