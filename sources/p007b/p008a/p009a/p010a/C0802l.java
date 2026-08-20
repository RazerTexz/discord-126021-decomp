package p007b.p008a.p009a.p010a;

import com.discord.utilities.premium.GuildBoostUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.a.l */
/* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0802l extends AbstractC12240o implements Function1<GuildBoostUtils.ModifyGuildBoostSlotResult, Unit> {
    public final /* synthetic */ C0801k.c.b $loadedViewState;
    public final /* synthetic */ C0801k this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0802l(C0801k c0801k, C0801k.c.b bVar) {
        super(1);
        this.this$0 = c0801k;
        this.$loadedViewState = bVar;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(GuildBoostUtils.ModifyGuildBoostSlotResult modifyGuildBoostSlotResult) {
        GuildBoostUtils.ModifyGuildBoostSlotResult modifyGuildBoostSlotResult2 = modifyGuildBoostSlotResult;
        C12238m.checkNotNullParameter(modifyGuildBoostSlotResult2, "result");
        int iOrdinal = modifyGuildBoostSlotResult2.ordinal();
        if (iOrdinal == 0) {
            this.this$0.updateViewState(C0801k.c.d.f223a);
        } else if (iOrdinal == 1) {
            this.this$0.updateViewState(C0801k.c.b.m102a(this.$loadedViewState, null, false, true, 3));
        } else if (iOrdinal == 2) {
            this.this$0.updateViewState(C0801k.c.d.f223a);
        }
        return Unit.f27425a;
    }
}
