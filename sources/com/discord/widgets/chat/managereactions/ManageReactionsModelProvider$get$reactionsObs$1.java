package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.models.message.Message;
import d0.t.h0;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: ManageReactionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsModelProvider$get$reactionsObs$1<T, R> implements b<Message, Map<String, ? extends MessageReaction>> {
    public static final ManageReactionsModelProvider$get$reactionsObs$1 INSTANCE = new ManageReactionsModelProvider$get$reactionsObs$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Map<String, ? extends MessageReaction> call(Message message) {
        return call2(message);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<String, MessageReaction> call2(Message message) {
        Map<String, MessageReaction> reactionsMap;
        return (message == null || (reactionsMap = message.getReactionsMap()) == null) ? h0.emptyMap() : reactionsMap;
    }
}
