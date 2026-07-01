package com.discord.widgets.chat.list.adapter;

import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.utilities.error.Error;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$UserReactionHandler$requestReactionUpdate$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler6 extends Lambda implements Function1<Error, Unit> {
    public final /* synthetic */ Function1 $optimisticCommitUndo;
    public final /* synthetic */ MessageReactionUpdate $update;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler6(Function1 function1, MessageReactionUpdate messageReactionUpdate) {
        super(1);
        this.$optimisticCommitUndo = function1;
        this.$update = messageReactionUpdate;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        Intrinsics3.checkNotNullParameter(error, "it");
        this.$optimisticCommitUndo.invoke(this.$update);
    }
}
