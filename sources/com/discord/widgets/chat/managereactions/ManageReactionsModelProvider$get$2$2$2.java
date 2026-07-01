package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.reaction.MessageReactionEmoji;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: ManageReactionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsModelProvider$get$2$2$2<T, R> implements b<MessageReactionEmoji, Observable<? extends ManageReactionsModel>> {
    public final /* synthetic */ Boolean $canManageMessages;
    public final /* synthetic */ Map $guildMembers;
    public final /* synthetic */ List $reactions;
    public final /* synthetic */ ManageReactionsModelProvider$get$2$2 this$0;

    public ManageReactionsModelProvider$get$2$2$2(ManageReactionsModelProvider$get$2$2 manageReactionsModelProvider$get$2$2, List list, Boolean bool, Map map) {
        this.this$0 = manageReactionsModelProvider$get$2$2;
        this.$reactions = list;
        this.$canManageMessages = bool;
        this.$guildMembers = map;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ManageReactionsModel> call(MessageReactionEmoji messageReactionEmoji) {
        return call2(messageReactionEmoji);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ManageReactionsModel> call2(MessageReactionEmoji messageReactionEmoji) {
        ManageReactionsModelProvider manageReactionsModelProvider = this.this$0.this$0.this$0;
        m.checkNotNullExpressionValue(messageReactionEmoji, "targetedEmoji");
        return ManageReactionsModelProvider.access$getUsersForReaction(manageReactionsModelProvider, messageReactionEmoji).G(new ManageReactionsModelProvider$get$2$2$2$1(this, messageReactionEmoji));
    }
}
