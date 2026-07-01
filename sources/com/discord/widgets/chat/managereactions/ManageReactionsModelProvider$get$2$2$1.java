package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionEmoji;
import d0.t.u;
import d0.z.d.m;
import j0.k.b;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ManageReactionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsModelProvider$get$2$2$1<T, R> implements b<String, MessageReactionEmoji> {
    public final /* synthetic */ List $reactions;

    public ManageReactionsModelProvider$get$2$2$1(List list) {
        this.$reactions = list;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ MessageReactionEmoji call(String str) {
        return call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final MessageReactionEmoji call2(String str) {
        T next;
        MessageReactionEmoji emoji;
        List list = this.$reactions;
        m.checkNotNullExpressionValue(list, "reactions");
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = (T) null;
                break;
            }
            next = it.next();
        } while (!m.areEqual(((MessageReaction) next).getEmoji().c(), str));
        MessageReaction messageReaction = next;
        if (messageReaction != null && (emoji = messageReaction.getEmoji()) != null) {
            return emoji;
        }
        List list2 = this.$reactions;
        m.checkNotNullExpressionValue(list2, "reactions");
        return ((MessageReaction) u.first(list2)).getEmoji();
    }
}
