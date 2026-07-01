package com.discord.widgets.chat.overlay;

import b.d.b.a.a;
import com.lytefast.flexinput.viewmodel.FlexInputState;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatOverlay$StickerAutocompleteState {
    private final boolean autocompleteVisible;
    private final FlexInputState flexInputState;
    private final boolean isForumPostDraftCreation;

    public WidgetChatOverlay$StickerAutocompleteState(boolean z2, FlexInputState flexInputState, boolean z3) {
        m.checkNotNullParameter(flexInputState, "flexInputState");
        this.autocompleteVisible = z2;
        this.flexInputState = flexInputState;
        this.isForumPostDraftCreation = z3;
    }

    public static /* synthetic */ WidgetChatOverlay$StickerAutocompleteState copy$default(WidgetChatOverlay$StickerAutocompleteState widgetChatOverlay$StickerAutocompleteState, boolean z2, FlexInputState flexInputState, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetChatOverlay$StickerAutocompleteState.autocompleteVisible;
        }
        if ((i & 2) != 0) {
            flexInputState = widgetChatOverlay$StickerAutocompleteState.flexInputState;
        }
        if ((i & 4) != 0) {
            z3 = widgetChatOverlay$StickerAutocompleteState.isForumPostDraftCreation;
        }
        return widgetChatOverlay$StickerAutocompleteState.copy(z2, flexInputState, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getAutocompleteVisible() {
        return this.autocompleteVisible;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FlexInputState getFlexInputState() {
        return this.flexInputState;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsForumPostDraftCreation() {
        return this.isForumPostDraftCreation;
    }

    public final WidgetChatOverlay$StickerAutocompleteState copy(boolean autocompleteVisible, FlexInputState flexInputState, boolean isForumPostDraftCreation) {
        m.checkNotNullParameter(flexInputState, "flexInputState");
        return new WidgetChatOverlay$StickerAutocompleteState(autocompleteVisible, flexInputState, isForumPostDraftCreation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatOverlay$StickerAutocompleteState)) {
            return false;
        }
        WidgetChatOverlay$StickerAutocompleteState widgetChatOverlay$StickerAutocompleteState = (WidgetChatOverlay$StickerAutocompleteState) other;
        return this.autocompleteVisible == widgetChatOverlay$StickerAutocompleteState.autocompleteVisible && m.areEqual(this.flexInputState, widgetChatOverlay$StickerAutocompleteState.flexInputState) && this.isForumPostDraftCreation == widgetChatOverlay$StickerAutocompleteState.isForumPostDraftCreation;
    }

    public final boolean getAutocompleteVisible() {
        return this.autocompleteVisible;
    }

    public final FlexInputState getFlexInputState() {
        return this.flexInputState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z2 = this.autocompleteVisible;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        FlexInputState flexInputState = this.flexInputState;
        int iHashCode = (i + (flexInputState != null ? flexInputState.hashCode() : 0)) * 31;
        boolean z3 = this.isForumPostDraftCreation;
        return iHashCode + (z3 ? 1 : z3);
    }

    public final boolean isForumPostDraftCreation() {
        return this.isForumPostDraftCreation;
    }

    public String toString() {
        StringBuilder sbU = a.U("StickerAutocompleteState(autocompleteVisible=");
        sbU.append(this.autocompleteVisible);
        sbU.append(", flexInputState=");
        sbU.append(this.flexInputState);
        sbU.append(", isForumPostDraftCreation=");
        return a.O(sbU, this.isForumPostDraftCreation, ")");
    }
}
