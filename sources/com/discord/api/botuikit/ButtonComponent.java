package com.discord.api.botuikit;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ButtonComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ButtonComponent extends ActionComponent {
    private final String customId;
    private final boolean disabled;
    private final ComponentEmoji emoji;
    private final String label;
    private final ButtonStyle style;
    private final ComponentType type;
    private final String url;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getDisabled() {
        return this.disabled;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final ComponentEmoji getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final ButtonStyle getStyle() {
        return this.style;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ButtonComponent)) {
            return false;
        }
        ButtonComponent buttonComponent = (ButtonComponent) other;
        return C12238m.areEqual(this.type, buttonComponent.type) && C12238m.areEqual(this.customId, buttonComponent.customId) && C12238m.areEqual(this.label, buttonComponent.label) && C12238m.areEqual(this.style, buttonComponent.style) && this.disabled == buttonComponent.disabled && C12238m.areEqual(this.emoji, buttonComponent.emoji) && C12238m.areEqual(this.url, buttonComponent.url);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Override // com.discord.api.botuikit.Component
    public ComponentType getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v20 */
    public int hashCode() {
        ComponentType componentType = this.type;
        int iHashCode = (componentType != null ? componentType.hashCode() : 0) * 31;
        String str = this.customId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.label;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ButtonStyle buttonStyle = this.style;
        int iHashCode4 = (iHashCode3 + (buttonStyle != null ? buttonStyle.hashCode() : 0)) * 31;
        boolean z2 = this.disabled;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode4 + r2) * 31;
        ComponentEmoji componentEmoji = this.emoji;
        int iHashCode5 = (i + (componentEmoji != null ? componentEmoji.hashCode() : 0)) * 31;
        String str3 = this.url;
        return iHashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ButtonComponent(type=");
        sbM833U.append(this.type);
        sbM833U.append(", customId=");
        sbM833U.append(this.customId);
        sbM833U.append(", label=");
        sbM833U.append(this.label);
        sbM833U.append(", style=");
        sbM833U.append(this.style);
        sbM833U.append(", disabled=");
        sbM833U.append(this.disabled);
        sbM833U.append(", emoji=");
        sbM833U.append(this.emoji);
        sbM833U.append(", url=");
        return C1643a.m822J(sbM833U, this.url, ")");
    }
}
