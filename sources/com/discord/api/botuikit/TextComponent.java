package com.discord.api.botuikit;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: TextComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TextComponent extends ActionComponent {
    private final String customId;
    private final String label;
    private final int maxLength;
    private final int minLength;
    private final String placeholder;
    private final Boolean required;
    private final TextStyle style;
    private final ComponentType type;
    private final String value;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getMaxLength() {
        return this.maxLength;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getMinLength() {
        return this.minLength;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getPlaceholder() {
        return this.placeholder;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextComponent)) {
            return false;
        }
        TextComponent textComponent = (TextComponent) other;
        return m.areEqual(this.type, textComponent.type) && m.areEqual(this.style, textComponent.style) && m.areEqual(this.customId, textComponent.customId) && m.areEqual(this.label, textComponent.label) && m.areEqual(this.value, textComponent.value) && m.areEqual(this.placeholder, textComponent.placeholder) && this.minLength == textComponent.minLength && this.maxLength == textComponent.maxLength && m.areEqual(this.required, textComponent.required);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final Boolean getRequired() {
        return this.required;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final TextStyle getStyle() {
        return this.style;
    }

    @Override // com.discord.api.botuikit.Component
    public ComponentType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        ComponentType componentType = this.type;
        int iHashCode = (componentType != null ? componentType.hashCode() : 0) * 31;
        TextStyle textStyle = this.style;
        int iHashCode2 = (iHashCode + (textStyle != null ? textStyle.hashCode() : 0)) * 31;
        String str = this.customId;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.label;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.value;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.placeholder;
        int iHashCode6 = (((((iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.minLength) * 31) + this.maxLength) * 31;
        Boolean bool = this.required;
        return iHashCode6 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TextComponent(type=");
        sbU.append(this.type);
        sbU.append(", style=");
        sbU.append(this.style);
        sbU.append(", customId=");
        sbU.append(this.customId);
        sbU.append(", label=");
        sbU.append(this.label);
        sbU.append(", value=");
        sbU.append(this.value);
        sbU.append(", placeholder=");
        sbU.append(this.placeholder);
        sbU.append(", minLength=");
        sbU.append(this.minLength);
        sbU.append(", maxLength=");
        sbU.append(this.maxLength);
        sbU.append(", required=");
        return a.D(sbU, this.required, ")");
    }
}
