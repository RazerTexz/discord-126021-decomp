package b.a.a.a;

import com.discord.utilities.premium.GuildBoostUtils$ModifyGuildBoostSlotResult;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class l extends o implements Function1<GuildBoostUtils$ModifyGuildBoostSlotResult, Unit> {
    public final /* synthetic */ k$c$b $loadedViewState;
    public final /* synthetic */ k this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(k kVar, k$c$b k_c_b) {
        super(1);
        this.this$0 = kVar;
        this.$loadedViewState = k_c_b;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(GuildBoostUtils$ModifyGuildBoostSlotResult guildBoostUtils$ModifyGuildBoostSlotResult) {
        GuildBoostUtils$ModifyGuildBoostSlotResult guildBoostUtils$ModifyGuildBoostSlotResult2 = guildBoostUtils$ModifyGuildBoostSlotResult;
        m.checkNotNullParameter(guildBoostUtils$ModifyGuildBoostSlotResult2, "result");
        int iOrdinal = guildBoostUtils$ModifyGuildBoostSlotResult2.ordinal();
        if (iOrdinal == 0) {
            this.this$0.updateViewState(k$c$d.a);
        } else if (iOrdinal == 1) {
            this.this$0.updateViewState(k$c$b.a(this.$loadedViewState, null, false, true, 3));
        } else if (iOrdinal == 2) {
            this.this$0.updateViewState(k$c$d.a);
        }
        return Unit.a;
    }
}
