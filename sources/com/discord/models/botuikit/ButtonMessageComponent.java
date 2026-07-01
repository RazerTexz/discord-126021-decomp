package com.discord.models.botuikit;

import b.d.b.a.a;
import com.discord.api.botuikit.ButtonStyle;
import com.discord.api.botuikit.ComponentEmoji;
import com.discord.api.botuikit.ComponentType;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ButtonMessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ButtonMessageComponent extends ActionMessageComponent {
    private final String customId;
    private final ComponentEmoji emoji;
    private final boolean emojiAnimationsEnabled;
    private final int index;
    private final String label;
    private final ActionInteractionComponentState stateInteraction;
    private final ButtonStyle style;
    private final ComponentType type;
    private final String url;

    public /* synthetic */ ButtonMessageComponent(ComponentType componentType, int i, ActionInteractionComponentState actionInteractionComponentState, String str, String str2, ButtonStyle buttonStyle, ComponentEmoji componentEmoji, String str3, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(componentType, i, (i2 & 4) != 0 ? ActionInteractionComponentState$Enabled.INSTANCE : actionInteractionComponentState, str, str2, buttonStyle, (i2 & 64) != 0 ? null : componentEmoji, (i2 & 128) != 0 ? null : str3, z2);
    }

    public static /* synthetic */ ButtonMessageComponent copy$default(ButtonMessageComponent buttonMessageComponent, ComponentType componentType, int i, ActionInteractionComponentState actionInteractionComponentState, String str, String str2, ButtonStyle buttonStyle, ComponentEmoji componentEmoji, String str3, boolean z2, int i2, Object obj) {
        return buttonMessageComponent.copy((i2 & 1) != 0 ? buttonMessageComponent.getType() : componentType, (i2 & 2) != 0 ? buttonMessageComponent.getIndex() : i, (i2 & 4) != 0 ? buttonMessageComponent.getStateInteraction() : actionInteractionComponentState, (i2 & 8) != 0 ? buttonMessageComponent.customId : str, (i2 & 16) != 0 ? buttonMessageComponent.label : str2, (i2 & 32) != 0 ? buttonMessageComponent.style : buttonStyle, (i2 & 64) != 0 ? buttonMessageComponent.emoji : componentEmoji, (i2 & 128) != 0 ? buttonMessageComponent.url : str3, (i2 & 256) != 0 ? buttonMessageComponent.emojiAnimationsEnabled : z2);
    }

    public final ComponentType component1() {
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
    public final ButtonStyle getStyle() {
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

    public final ButtonMessageComponent copy(ComponentType type, int index, ActionInteractionComponentState stateInteraction, String customId, String label, ButtonStyle style, ComponentEmoji emoji, String url, boolean emojiAnimationsEnabled) {
        m.checkNotNullParameter(type, "type");
        m.checkNotNullParameter(stateInteraction, "stateInteraction");
        m.checkNotNullParameter(style, "style");
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
        return m.areEqual(getType(), buttonMessageComponent.getType()) && getIndex() == buttonMessageComponent.getIndex() && m.areEqual(getStateInteraction(), buttonMessageComponent.getStateInteraction()) && m.areEqual(this.customId, buttonMessageComponent.customId) && m.areEqual(this.label, buttonMessageComponent.label) && m.areEqual(this.style, buttonMessageComponent.style) && m.areEqual(this.emoji, buttonMessageComponent.emoji) && m.areEqual(this.url, buttonMessageComponent.url) && this.emojiAnimationsEnabled == buttonMessageComponent.emojiAnimationsEnabled;
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

    @Override // com.discord.models.botuikit.ActionMessageComponent
    public ActionInteractionComponentState getStateInteraction() {
        return this.stateInteraction;
    }

    public final ButtonStyle getStyle() {
        return this.style;
    }

    @Override // com.discord.models.botuikit.MessageComponent
    public ComponentType getType() {
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
        ComponentType type = getType();
        int index = (getIndex() + ((type != null ? type.hashCode() : 0) * 31)) * 31;
        ActionInteractionComponentState stateInteraction = getStateInteraction();
        int iHashCode = (index + (stateInteraction != null ? stateInteraction.hashCode() : 0)) * 31;
        String str = this.customId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.label;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ButtonStyle buttonStyle = this.style;
        int iHashCode4 = (iHashCode3 + (buttonStyle != null ? buttonStyle.hashCode() : 0)) * 31;
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
        StringBuilder sbU = a.U("ButtonMessageComponent(type=");
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
        return a.O(sbU, this.emojiAnimationsEnabled, ")");
    }

    public ButtonMessageComponent(ComponentType componentType, int i, ActionInteractionComponentState actionInteractionComponentState, String str, String str2, ButtonStyle buttonStyle, ComponentEmoji componentEmoji, String str3, boolean z2) {
        m.checkNotNullParameter(componentType, "type");
        m.checkNotNullParameter(actionInteractionComponentState, "stateInteraction");
        m.checkNotNullParameter(buttonStyle, "style");
        this.type = componentType;
        this.index = i;
        this.stateInteraction = actionInteractionComponentState;
        this.customId = str;
        this.label = str2;
        this.style = buttonStyle;
        this.emoji = componentEmoji;
        this.url = str3;
        this.emojiAnimationsEnabled = z2;
    }
}
