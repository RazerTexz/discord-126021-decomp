package b.a.y.q0;

import com.discord.views.sticker.StickerView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: StickerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends o implements Function1<Subscription, Unit> {
    public final /* synthetic */ StickerView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(StickerView stickerView) {
        super(1);
        this.this$0 = stickerView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Subscription subscription) {
        Subscription subscription2 = subscription;
        m.checkNotNullParameter(subscription2, "it");
        this.this$0.com.discord.utilities.analytics.Traits$Payment$Type.SUBSCRIPTION java.lang.String = subscription2;
        return Unit.a;
    }
}
