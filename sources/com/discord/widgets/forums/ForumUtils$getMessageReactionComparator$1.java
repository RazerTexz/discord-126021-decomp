package com.discord.widgets.forums;

import com.discord.api.message.reaction.MessageReaction;
import com.discord.stores.StoreEmoji;
import d0.z.d.m;
import java.util.Comparator;

/* JADX INFO: compiled from: ForumUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumUtils$getMessageReactionComparator$1<T> implements Comparator<MessageReaction> {
    public final /* synthetic */ StoreEmoji $storeEmoji;

    public ForumUtils$getMessageReactionComparator$1(StoreEmoji storeEmoji) {
        this.$storeEmoji = storeEmoji;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(MessageReaction messageReaction, MessageReaction messageReaction2) {
        return compare2(messageReaction, messageReaction2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(MessageReaction messageReaction, MessageReaction messageReaction2) {
        if (messageReaction != null && messageReaction2 != null) {
            int count = messageReaction.getCount();
            int count2 = messageReaction2.getCount();
            String strAccess$getPlaceholderReactionName = ForumUtils.access$getPlaceholderReactionName(ForumUtils.INSTANCE, this.$storeEmoji);
            String name = messageReaction.getEmoji().getName();
            String name2 = messageReaction2.getEmoji().getName();
            String strC = messageReaction.getEmoji().c();
            String strC2 = messageReaction2.getEmoji().c();
            if (count2 != count) {
                return count2 - count;
            }
            if (m.areEqual(strAccess$getPlaceholderReactionName, name)) {
                return 1;
            }
            if (!m.areEqual(strAccess$getPlaceholderReactionName, name2) && strC2.compareTo(strC) <= 0) {
                return 1;
            }
        } else if (messageReaction == null || messageReaction2 != null) {
            return (messageReaction != null || messageReaction2 == null) ? 0 : 1;
        }
        return -1;
    }
}
