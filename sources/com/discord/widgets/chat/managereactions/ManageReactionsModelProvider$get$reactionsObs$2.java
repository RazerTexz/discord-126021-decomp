package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.reaction.MessageReaction;
import d0.t.u;
import j0.k.b;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ManageReactionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsModelProvider$get$reactionsObs$2<T, R> implements b<Map<String, ? extends MessageReaction>, List<? extends MessageReaction>> {
    public static final ManageReactionsModelProvider$get$reactionsObs$2 INSTANCE = new ManageReactionsModelProvider$get$reactionsObs$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends MessageReaction> call(Map<String, ? extends MessageReaction> map) {
        return call2((Map<String, MessageReaction>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<MessageReaction> call2(Map<String, MessageReaction> map) {
        return u.sortedWith(map.values(), new ManageReactionsModelProvider$get$reactionsObs$2$$special$$inlined$sortedByDescending$1());
    }
}
