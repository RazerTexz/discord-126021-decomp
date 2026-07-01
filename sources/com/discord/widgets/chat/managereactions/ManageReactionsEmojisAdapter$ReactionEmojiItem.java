package com.discord.widgets.chat.managereactions;

import b.d.b.a.a;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: ManageReactionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ManageReactionsEmojisAdapter$ReactionEmojiItem implements MGRecyclerDataPayload {
    private final boolean isSelected;
    private final String key;
    private final MessageReaction reaction;
    private final int type;

    public ManageReactionsEmojisAdapter$ReactionEmojiItem(MessageReaction messageReaction, boolean z2) {
        m.checkNotNullParameter(messageReaction, "reaction");
        this.reaction = messageReaction;
        this.isSelected = z2;
        this.key = messageReaction.getEmoji().c();
    }

    public static /* synthetic */ ManageReactionsEmojisAdapter$ReactionEmojiItem copy$default(ManageReactionsEmojisAdapter$ReactionEmojiItem manageReactionsEmojisAdapter$ReactionEmojiItem, MessageReaction messageReaction, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            messageReaction = manageReactionsEmojisAdapter$ReactionEmojiItem.reaction;
        }
        if ((i & 2) != 0) {
            z2 = manageReactionsEmojisAdapter$ReactionEmojiItem.isSelected;
        }
        return manageReactionsEmojisAdapter$ReactionEmojiItem.copy(messageReaction, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MessageReaction getReaction() {
        return this.reaction;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final ManageReactionsEmojisAdapter$ReactionEmojiItem copy(MessageReaction reaction, boolean isSelected) {
        m.checkNotNullParameter(reaction, "reaction");
        return new ManageReactionsEmojisAdapter$ReactionEmojiItem(reaction, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ManageReactionsEmojisAdapter$ReactionEmojiItem)) {
            return false;
        }
        ManageReactionsEmojisAdapter$ReactionEmojiItem manageReactionsEmojisAdapter$ReactionEmojiItem = (ManageReactionsEmojisAdapter$ReactionEmojiItem) other;
        return m.areEqual(this.reaction, manageReactionsEmojisAdapter$ReactionEmojiItem.reaction) && this.isSelected == manageReactionsEmojisAdapter$ReactionEmojiItem.isSelected;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final MessageReaction getReaction() {
        return this.reaction;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        MessageReaction messageReaction = this.reaction;
        int iHashCode = (messageReaction != null ? messageReaction.hashCode() : 0) * 31;
        boolean z2 = this.isSelected;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringBuilder sbU = a.U("ReactionEmojiItem(reaction=");
        sbU.append(this.reaction);
        sbU.append(", isSelected=");
        return a.O(sbU, this.isSelected, ")");
    }
}
