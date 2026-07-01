package com.discord.widgets.stage.start;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ModeratorStartStageViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ModeratorStartStageViewModel$1 extends k implements Function1<ModeratorStartStageViewModel$StoreState, Unit> {
    public ModeratorStartStageViewModel$1(ModeratorStartStageViewModel moderatorStartStageViewModel) {
        super(1, moderatorStartStageViewModel, ModeratorStartStageViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModeratorStartStageViewModel$StoreState moderatorStartStageViewModel$StoreState) {
        invoke2(moderatorStartStageViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModeratorStartStageViewModel$StoreState moderatorStartStageViewModel$StoreState) {
        m.checkNotNullParameter(moderatorStartStageViewModel$StoreState, "p1");
        ModeratorStartStageViewModel.access$handleStoreState((ModeratorStartStageViewModel) this.receiver, moderatorStartStageViewModel$StoreState);
    }
}
