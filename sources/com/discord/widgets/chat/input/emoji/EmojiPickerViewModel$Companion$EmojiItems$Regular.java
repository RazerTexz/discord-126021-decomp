package com.discord.widgets.chat.input.emoji;

import b.d.b.a.a;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.t.n;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiPickerViewModel$Companion$EmojiItems$Regular extends EmojiPickerViewModel$Companion$EmojiItems {
    public static final EmojiPickerViewModel$Companion$EmojiItems$Regular$Companion Companion = new EmojiPickerViewModel$Companion$EmojiItems$Regular$Companion(null);
    private static final EmojiPickerViewModel$Companion$EmojiItems$Regular Empty = new EmojiPickerViewModel$Companion$EmojiItems$Regular(n.emptyList());
    private final List<MGRecyclerDataPayload> items;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmojiPickerViewModel$Companion$EmojiItems$Regular(List<? extends MGRecyclerDataPayload> list) {
        super(null);
        m.checkNotNullParameter(list, "items");
        this.items = list;
    }

    public static final /* synthetic */ EmojiPickerViewModel$Companion$EmojiItems$Regular access$getEmpty$cp() {
        return Empty;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmojiPickerViewModel$Companion$EmojiItems$Regular copy$default(EmojiPickerViewModel$Companion$EmojiItems$Regular emojiPickerViewModel$Companion$EmojiItems$Regular, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = emojiPickerViewModel$Companion$EmojiItems$Regular.items;
        }
        return emojiPickerViewModel$Companion$EmojiItems$Regular.copy(list);
    }

    public final List<MGRecyclerDataPayload> component1() {
        return this.items;
    }

    public final EmojiPickerViewModel$Companion$EmojiItems$Regular copy(List<? extends MGRecyclerDataPayload> items) {
        m.checkNotNullParameter(items, "items");
        return new EmojiPickerViewModel$Companion$EmojiItems$Regular(items);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof EmojiPickerViewModel$Companion$EmojiItems$Regular) && m.areEqual(this.items, ((EmojiPickerViewModel$Companion$EmojiItems$Regular) other).items);
        }
        return true;
    }

    public final List<MGRecyclerDataPayload> getItems() {
        return this.items;
    }

    public int hashCode() {
        List<MGRecyclerDataPayload> list = this.items;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("Regular(items="), this.items, ")");
    }
}
