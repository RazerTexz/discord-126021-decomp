package p000;

import com.discord.views.calls.VideoCallParticipantView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: renamed from: r */
/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class C13004r extends AbstractC12240o implements Function1<Subscription, Unit> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f27628j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Object f27629k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13004r(int i, Object obj) {
        super(1);
        this.f27628j = i;
        this.f27629k = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Subscription subscription) {
        int i = this.f27628j;
        if (i == 0) {
            Subscription subscription2 = subscription;
            C12238m.checkNotNullParameter(subscription2, "it");
            ((VideoCallParticipantView) this.f27629k).frameRenderedSubscription = subscription2;
            return Unit.f27425a;
        }
        if (i != 1) {
            throw null;
        }
        Subscription subscription3 = subscription;
        C12238m.checkNotNullParameter(subscription3, "it");
        ((VideoCallParticipantView) this.f27629k).representativeColorSubscription = subscription3;
        return Unit.f27425a;
    }
}
