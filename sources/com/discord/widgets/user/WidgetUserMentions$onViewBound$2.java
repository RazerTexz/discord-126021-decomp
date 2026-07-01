package com.discord.widgets.user;

import com.discord.stores.StoreChat$InteractionState;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserMentions$onViewBound$2 extends k implements Function1<StoreChat$InteractionState, Unit> {
    public WidgetUserMentions$onViewBound$2(WidgetUserMentions$Model$MessageLoader widgetUserMentions$Model$MessageLoader) {
        super(1, widgetUserMentions$Model$MessageLoader, WidgetUserMentions$Model$MessageLoader.class, "setInteractionState", "setInteractionState(Lcom/discord/stores/StoreChat$InteractionState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreChat$InteractionState storeChat$InteractionState) {
        invoke2(storeChat$InteractionState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreChat$InteractionState storeChat$InteractionState) {
        m.checkNotNullParameter(storeChat$InteractionState, "p1");
        ((WidgetUserMentions$Model$MessageLoader) this.receiver).setInteractionState(storeChat$InteractionState);
    }
}
