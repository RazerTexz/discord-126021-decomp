package defpackage;

import com.discord.views.calls.VideoCallParticipantView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class r extends Lambda implements Function1<Subscription, Unit> {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(int i, Object obj) {
        super(1);
        this.j = i;
        this.k = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Subscription subscription) {
        int i = this.j;
        if (i == 0) {
            Subscription subscription2 = subscription;
            Intrinsics3.checkNotNullParameter(subscription2, "it");
            ((VideoCallParticipantView) this.k).frameRenderedSubscription = subscription2;
            return Unit.a;
        }
        if (i != 1) {
            throw null;
        }
        Subscription subscription3 = subscription;
        Intrinsics3.checkNotNullParameter(subscription3, "it");
        ((VideoCallParticipantView) this.k).representativeColorSubscription = subscription3;
        return Unit.a;
    }
}
