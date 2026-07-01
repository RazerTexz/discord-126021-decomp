package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.stores.StoreMessageReactions$EmojiResults;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ManageReactionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsModelProvider$get$2$2$2$1<T, R> implements b<StoreMessageReactions$EmojiResults, ManageReactionsModel> {
    public final /* synthetic */ MessageReactionEmoji $targetedEmoji;
    public final /* synthetic */ ManageReactionsModelProvider$get$2$2$2 this$0;

    public ManageReactionsModelProvider$get$2$2$2$1(ManageReactionsModelProvider$get$2$2$2 manageReactionsModelProvider$get$2$2$2, MessageReactionEmoji messageReactionEmoji) {
        this.this$0 = manageReactionsModelProvider$get$2$2$2;
        this.$targetedEmoji = messageReactionEmoji;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ ManageReactionsModel call(StoreMessageReactions$EmojiResults storeMessageReactions$EmojiResults) {
        return call2(storeMessageReactions$EmojiResults);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ManageReactionsModel call2(StoreMessageReactions$EmojiResults storeMessageReactions$EmojiResults) {
        ManageReactionsModelProvider$get$2$2$2 manageReactionsModelProvider$get$2$2$2 = this.this$0;
        ManageReactionsModelProvider manageReactionsModelProvider = manageReactionsModelProvider$get$2$2$2.this$0.this$0.this$0;
        List list = manageReactionsModelProvider$get$2$2$2.$reactions;
        m.checkNotNullExpressionValue(list, "reactions");
        m.checkNotNullExpressionValue(storeMessageReactions$EmojiResults, "users");
        MessageReactionEmoji messageReactionEmoji = this.$targetedEmoji;
        Boolean bool = this.this$0.$canManageMessages;
        m.checkNotNullExpressionValue(bool, "canManageMessages");
        boolean zBooleanValue = bool.booleanValue();
        long id2 = this.this$0.this$0.$me.getId();
        Map map = this.this$0.$guildMembers;
        m.checkNotNullExpressionValue(map, "guildMembers");
        return ManageReactionsModelProvider.access$createModel(manageReactionsModelProvider, list, storeMessageReactions$EmojiResults, messageReactionEmoji, zBooleanValue, id2, map);
    }
}
