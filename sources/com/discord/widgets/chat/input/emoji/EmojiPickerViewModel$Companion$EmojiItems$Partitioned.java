package com.discord.widgets.chat.input.emoji;

import b.d.b.a.a;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiPickerViewModel$Companion$EmojiItems$Partitioned extends EmojiPickerViewModel$Companion$EmojiItems {
    public static final EmojiPickerViewModel$Companion$EmojiItems$Partitioned$Companion Companion = new EmojiPickerViewModel$Companion$EmojiItems$Partitioned$Companion(null);
    private static final EmojiPickerViewModel$Companion$EmojiItems$Partitioned Empty = new EmojiPickerViewModel$Companion$EmojiItems$Partitioned(n.emptyList(), n.emptyList());
    private final List<MGRecyclerDataPayload> premiumItems;
    private final List<MGRecyclerDataPayload> regularItems;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmojiPickerViewModel$Companion$EmojiItems$Partitioned(List<? extends MGRecyclerDataPayload> list, List<? extends MGRecyclerDataPayload> list2) {
        super(null);
        m.checkNotNullParameter(list, "regularItems");
        m.checkNotNullParameter(list2, "premiumItems");
        this.regularItems = list;
        this.premiumItems = list2;
    }

    public static final /* synthetic */ EmojiPickerViewModel$Companion$EmojiItems$Partitioned access$getEmpty$cp() {
        return Empty;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmojiPickerViewModel$Companion$EmojiItems$Partitioned copy$default(EmojiPickerViewModel$Companion$EmojiItems$Partitioned emojiPickerViewModel$Companion$EmojiItems$Partitioned, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = emojiPickerViewModel$Companion$EmojiItems$Partitioned.regularItems;
        }
        if ((i & 2) != 0) {
            list2 = emojiPickerViewModel$Companion$EmojiItems$Partitioned.premiumItems;
        }
        return emojiPickerViewModel$Companion$EmojiItems$Partitioned.copy(list, list2);
    }

    public final List<MGRecyclerDataPayload> component1() {
        return this.regularItems;
    }

    public final List<MGRecyclerDataPayload> component2() {
        return this.premiumItems;
    }

    public final EmojiPickerViewModel$Companion$EmojiItems$Partitioned copy(List<? extends MGRecyclerDataPayload> regularItems, List<? extends MGRecyclerDataPayload> premiumItems) {
        m.checkNotNullParameter(regularItems, "regularItems");
        m.checkNotNullParameter(premiumItems, "premiumItems");
        return new EmojiPickerViewModel$Companion$EmojiItems$Partitioned(regularItems, premiumItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiPickerViewModel$Companion$EmojiItems$Partitioned)) {
            return false;
        }
        EmojiPickerViewModel$Companion$EmojiItems$Partitioned emojiPickerViewModel$Companion$EmojiItems$Partitioned = (EmojiPickerViewModel$Companion$EmojiItems$Partitioned) other;
        return m.areEqual(this.regularItems, emojiPickerViewModel$Companion$EmojiItems$Partitioned.regularItems) && m.areEqual(this.premiumItems, emojiPickerViewModel$Companion$EmojiItems$Partitioned.premiumItems);
    }

    public final List<MGRecyclerDataPayload> getPremiumItems() {
        return this.premiumItems;
    }

    public final List<MGRecyclerDataPayload> getRegularItems() {
        return this.regularItems;
    }

    public int hashCode() {
        List<MGRecyclerDataPayload> list = this.regularItems;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<MGRecyclerDataPayload> list2 = this.premiumItems;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Partitioned(regularItems=");
        sbU.append(this.regularItems);
        sbU.append(", premiumItems=");
        return a.L(sbU, this.premiumItems, ")");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiPickerViewModel$Companion$EmojiItems$Partitioned(Pair<? extends List<? extends MGRecyclerDataPayload>, ? extends List<? extends MGRecyclerDataPayload>> pair) {
        this(pair.getFirst(), pair.getSecond());
        m.checkNotNullParameter(pair, "p");
    }
}
