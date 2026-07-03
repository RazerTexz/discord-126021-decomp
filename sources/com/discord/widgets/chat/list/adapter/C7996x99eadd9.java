package com.discord.widgets.chat.list.adapter;

import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.utilities.error.Error;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$UserReactionHandler$requestReactionUpdate$2 */
/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7996x99eadd9 extends AbstractC12240o implements Function1<Error, Unit> {
    public final /* synthetic */ Function1 $optimisticCommitUndo;
    public final /* synthetic */ MessageReactionUpdate $update;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7996x99eadd9(Function1 function1, MessageReactionUpdate messageReactionUpdate) {
        super(1);
        this.$optimisticCommitUndo = function1;
        this.$update = messageReactionUpdate;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        C12238m.checkNotNullParameter(error, "it");
        this.$optimisticCommitUndo.invoke(this.$update);
    }
}
