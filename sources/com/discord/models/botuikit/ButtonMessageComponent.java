package com.discord.models.botuikit;

import b.d.b.a.outline;
import com.discord.api.botuikit.ButtonComponent2;
import com.discord.api.botuikit.Component6;
import com.discord.api.botuikit.ComponentEmoji;
import com.discord.models.botuikit.ActionInteractionComponentState;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ButtonMessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ButtonMessageComponent extends MessageComponent2 {
    private final String customId;
    private final ComponentEmoji emoji;
    private final boolean emojiAnimationsEnabled;
    private final int index;
    private final String label;
    private final ActionInteractionComponentState stateInteraction;
    private final ButtonComponent2 style;
    private final Component6 type;
    private final String url;

    public /* synthetic */ ButtonMessageComponent(Component6 component6, int i, ActionInteractionComponentState actionInteractionComponentState, String str, String str2, ButtonComponent2 buttonComponent2, ComponentEmoji componentEmoji, String str3, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(component6, i, (i2 & 4) != 0 ? ActionInteractionComponentState.Enabled.INSTANCE : actionInteractionComponentState, str, str2, buttonComponent2, (i2 & 64) != 0 ? null : componentEmoji, (i2 & 128) != 0 ? null : str3, z2);
    }

    public final Component6 component1() {
        return getType();
    }

    public final int component2() {
        return getIndex();
    }

    public final ActionInteractionComponentState component3() {
        return getStateInteraction();
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ButtonComponent2 getStyle() {
        return this.style;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final ComponentEmoji getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getEmojiAnimationsEnabled() {
        return this.emojiAnimationsEnabled;
    }

    public final ButtonMessageComponent copy(Component6 type, int index, ActionInteractionComponentState stateInteraction, String customId, String label, ButtonComponent2 style, ComponentEmoji emoji, String url, boolean emojiAnimationsEnabled) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(stateInteraction, "stateInteraction");
        Intrinsics3.checkNotNullParameter(style, "style");
        return new ButtonMessageComponent(type, index, stateInteraction, customId, label, style, emoji, url, emojiAnimationsEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ButtonMessageComponent)) {
            return false;
        }
        ButtonMessageComponent buttonMessageComponent = (ButtonMessageComponent) other;
        return Intrinsics3.areEqual(getType(), buttonMessageComponent.getType()) && getIndex() == buttonMessageComponent.getIndex() && Intrinsics3.areEqual(getStateInteraction(), buttonMessageComponent.getStateInteraction()) && Intrinsics3.areEqual(this.customId, buttonMessageComponent.customId) && Intrinsics3.areEqual(this.label, buttonMessageComponent.label) && Intrinsics3.areEqual(this.style, buttonMessageComponent.style) && Intrinsics3.areEqual(this.emoji, buttonMessageComponent.emoji) && Intrinsics3.areEqual(this.url, buttonMessageComponent.url) && this.emojiAnimationsEnabled == buttonMessageComponent.emojiAnimationsEnabled;
    }

    public final String getCustomId() {
        return this.customId;
    }

    public final ComponentEmoji getEmoji() {
        return this.emoji;
    }

    public final boolean getEmojiAnimationsEnabled() {
        return this.emojiAnimationsEnabled;
    }

    @Override // com.discord.models.botuikit.MessageComponent
    public int getIndex() {
        return this.index;
    }

    public final String getLabel() {
        return this.label;
    }

    @Override // com.discord.models.botuikit.MessageComponent2
    public ActionInteractionComponentState getStateInteraction() {
        return this.stateInteraction;
    }

    public final ButtonComponent2 getStyle() {
        return this.style;
    }

    @Override // com.discord.models.botuikit.MessageComponent
    public Component6 getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    public int hashCode() {
        Component6 type = getType();
        int index = (getIndex() + ((type != null ? type.hashCode() : 0) * 31)) * 31;
        ActionInteractionComponentState stateInteraction = getStateInteraction();
        int iHashCode = (index + (stateInteraction != null ? stateInteraction.hashCode() : 0)) * 31;
        String str = this.customId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.label;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ButtonComponent2 buttonComponent2 = this.style;
        int iHashCode4 = (iHashCode3 + (buttonComponent2 != null ? buttonComponent2.hashCode() : 0)) * 31;
        ComponentEmoji componentEmoji = this.emoji;
        int iHashCode5 = (iHashCode4 + (componentEmoji != null ? componentEmoji.hashCode() : 0)) * 31;
        String str3 = this.url;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z2 = this.emojiAnimationsEnabled;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return iHashCode6 + r0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ButtonMessageComponent(type=");
        sbU.append(getType());
        sbU.append(", index=");
        sbU.append(getIndex());
        sbU.append(", stateInteraction=");
        sbU.append(getStateInteraction());
        sbU.append(", customId=");
        sbU.append(this.customId);
        sbU.append(", label=");
        sbU.append(this.label);
        sbU.append(", style=");
        sbU.append(this.style);
        sbU.append(", emoji=");
        sbU.append(this.emoji);
        sbU.append(", url=");
        sbU.append(this.url);
        sbU.append(", emojiAnimationsEnabled=");
        return outline.O(sbU, this.emojiAnimationsEnabled, ")");
    }

    public ButtonMessageComponent(Component6 component6, int i, ActionInteractionComponentState actionInteractionComponentState, String str, String str2, ButtonComponent2 buttonComponent2, ComponentEmoji componentEmoji, String str3, boolean z2) {
        Intrinsics3.checkNotNullParameter(component6, "type");
        Intrinsics3.checkNotNullParameter(actionInteractionComponentState, "stateInteraction");
        Intrinsics3.checkNotNullParameter(buttonComponent2, "style");
        this.type = component6;
        this.index = i;
        this.stateInteraction = actionInteractionComponentState;
        this.customId = str;
        this.label = str2;
        this.style = buttonComponent2;
        this.emoji = componentEmoji;
        this.url = str3;
        this.emojiAnimationsEnabled = z2;
    }
}
