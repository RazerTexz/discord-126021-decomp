package p007b.p008a.p009a.p010a;

import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.premium.GuildBoostUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.p010a.C0796f;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.a.g */
/* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0797g extends AbstractC12240o implements Function1<GuildBoostUtils.ModifyGuildBoostSlotResult, Unit> {
    public final /* synthetic */ ModelSubscription $subscription;
    public final /* synthetic */ C0796f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0797g(C0796f c0796f, ModelSubscription modelSubscription) {
        super(1);
        this.this$0 = c0796f;
        this.$subscription = modelSubscription;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(GuildBoostUtils.ModifyGuildBoostSlotResult modifyGuildBoostSlotResult) {
        GuildBoostUtils.ModifyGuildBoostSlotResult modifyGuildBoostSlotResult2 = modifyGuildBoostSlotResult;
        C12238m.checkNotNullParameter(modifyGuildBoostSlotResult2, "result");
        int iOrdinal = modifyGuildBoostSlotResult2.ordinal();
        if (iOrdinal == 0) {
            this.this$0.updateViewState(new C0796f.c.b(this.$subscription));
        } else if (iOrdinal == 1) {
            this.this$0.updateViewState(new C0796f.c.d(this.$subscription));
        } else if (iOrdinal == 2) {
            this.this$0.updateViewState(new C0796f.c.b(this.$subscription));
        }
        return Unit.f27425a;
    }
}
