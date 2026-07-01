package com.discord.widgets.chat.managereactions;

import b.d.b.a.a;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ManageReactionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ManageReactionsModel {
    private final List<ManageReactionsEmojisAdapter$ReactionEmojiItem> reactionItems;
    private final List<MGRecyclerDataPayload> userItems;

    /* JADX WARN: Multi-variable type inference failed */
    public ManageReactionsModel(List<ManageReactionsEmojisAdapter$ReactionEmojiItem> list, List<? extends MGRecyclerDataPayload> list2) {
        m.checkNotNullParameter(list, "reactionItems");
        m.checkNotNullParameter(list2, "userItems");
        this.reactionItems = list;
        this.userItems = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ManageReactionsModel copy$default(ManageReactionsModel manageReactionsModel, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = manageReactionsModel.reactionItems;
        }
        if ((i & 2) != 0) {
            list2 = manageReactionsModel.userItems;
        }
        return manageReactionsModel.copy(list, list2);
    }

    public final List<ManageReactionsEmojisAdapter$ReactionEmojiItem> component1() {
        return this.reactionItems;
    }

    public final List<MGRecyclerDataPayload> component2() {
        return this.userItems;
    }

    public final ManageReactionsModel copy(List<ManageReactionsEmojisAdapter$ReactionEmojiItem> reactionItems, List<? extends MGRecyclerDataPayload> userItems) {
        m.checkNotNullParameter(reactionItems, "reactionItems");
        m.checkNotNullParameter(userItems, "userItems");
        return new ManageReactionsModel(reactionItems, userItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ManageReactionsModel)) {
            return false;
        }
        ManageReactionsModel manageReactionsModel = (ManageReactionsModel) other;
        return m.areEqual(this.reactionItems, manageReactionsModel.reactionItems) && m.areEqual(this.userItems, manageReactionsModel.userItems);
    }

    public final List<ManageReactionsEmojisAdapter$ReactionEmojiItem> getReactionItems() {
        return this.reactionItems;
    }

    public final List<MGRecyclerDataPayload> getUserItems() {
        return this.userItems;
    }

    public int hashCode() {
        List<ManageReactionsEmojisAdapter$ReactionEmojiItem> list = this.reactionItems;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<MGRecyclerDataPayload> list2 = this.userItems;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ManageReactionsModel(reactionItems=");
        sbU.append(this.reactionItems);
        sbU.append(", userItems=");
        return a.L(sbU, this.userItems, ")");
    }
}
