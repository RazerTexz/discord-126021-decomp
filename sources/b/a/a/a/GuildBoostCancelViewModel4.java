package b.a.a.a;

import b.a.a.a.GuildBoostCancelViewModel3;
import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.premium.GuildBoostUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.a.a.g, reason: use source file name */
/* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildBoostCancelViewModel4 extends Lambda implements Function1<GuildBoostUtils.ModifyGuildBoostSlotResult, Unit> {
    public final /* synthetic */ ModelSubscription $subscription;
    public final /* synthetic */ GuildBoostCancelViewModel3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostCancelViewModel4(GuildBoostCancelViewModel3 guildBoostCancelViewModel3, ModelSubscription modelSubscription) {
        super(1);
        this.this$0 = guildBoostCancelViewModel3;
        this.$subscription = modelSubscription;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(GuildBoostUtils.ModifyGuildBoostSlotResult modifyGuildBoostSlotResult) {
        GuildBoostUtils.ModifyGuildBoostSlotResult modifyGuildBoostSlotResult2 = modifyGuildBoostSlotResult;
        Intrinsics3.checkNotNullParameter(modifyGuildBoostSlotResult2, "result");
        int iOrdinal = modifyGuildBoostSlotResult2.ordinal();
        if (iOrdinal == 0) {
            this.this$0.updateViewState(new GuildBoostCancelViewModel3.c.b(this.$subscription));
        } else if (iOrdinal == 1) {
            this.this$0.updateViewState(new GuildBoostCancelViewModel3.c.d(this.$subscription));
        } else if (iOrdinal == 2) {
            this.this$0.updateViewState(new GuildBoostCancelViewModel3.c.b(this.$subscription));
        }
        return Unit.a;
    }
}
