package b.a.a.a;

import b.a.a.a.GuildBoostUncancelViewModel3;
import com.discord.utilities.premium.GuildBoostUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.a.a.l, reason: use source file name */
/* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildBoostUncancelViewModel4 extends Lambda implements Function1<GuildBoostUtils.ModifyGuildBoostSlotResult, Unit> {
    public final /* synthetic */ GuildBoostUncancelViewModel3.c.b $loadedViewState;
    public final /* synthetic */ GuildBoostUncancelViewModel3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostUncancelViewModel4(GuildBoostUncancelViewModel3 guildBoostUncancelViewModel3, GuildBoostUncancelViewModel3.c.b bVar) {
        super(1);
        this.this$0 = guildBoostUncancelViewModel3;
        this.$loadedViewState = bVar;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(GuildBoostUtils.ModifyGuildBoostSlotResult modifyGuildBoostSlotResult) {
        GuildBoostUtils.ModifyGuildBoostSlotResult modifyGuildBoostSlotResult2 = modifyGuildBoostSlotResult;
        Intrinsics3.checkNotNullParameter(modifyGuildBoostSlotResult2, "result");
        int iOrdinal = modifyGuildBoostSlotResult2.ordinal();
        if (iOrdinal == 0) {
            this.this$0.updateViewState(GuildBoostUncancelViewModel3.c.d.a);
        } else if (iOrdinal == 1) {
            this.this$0.updateViewState(GuildBoostUncancelViewModel3.c.b.a(this.$loadedViewState, null, false, true, 3));
        } else if (iOrdinal == 2) {
            this.this$0.updateViewState(GuildBoostUncancelViewModel3.c.d.a);
        }
        return Unit.a;
    }
}
