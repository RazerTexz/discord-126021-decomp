package com.discord.models.botuikit;

import b.d.b.a.a;
import com.discord.api.botuikit.ComponentType;
import com.discord.api.botuikit.SelectItem;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: SelectMessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class SelectMessageComponent extends ActionMessageComponent {
    private final String customId;
    private final boolean emojiAnimationsEnabled;
    private final int index;
    private final int maxValues;
    private final int minValues;
    private final List<SelectItem> options;
    private final String placeholder;
    private final List<SelectItem> selectedOptions;
    private final ActionInteractionComponentState stateInteraction;
    private final ComponentType type;

    public SelectMessageComponent(ComponentType componentType, int i, ActionInteractionComponentState actionInteractionComponentState, String str, String str2, int i2, int i3, List<SelectItem> list, List<SelectItem> list2, boolean z2) {
        m.checkNotNullParameter(componentType, "type");
        m.checkNotNullParameter(actionInteractionComponentState, "stateInteraction");
        m.checkNotNullParameter(str, "customId");
        m.checkNotNullParameter(list, "options");
        m.checkNotNullParameter(list2, "selectedOptions");
        this.type = componentType;
        this.index = i;
        this.stateInteraction = actionInteractionComponentState;
        this.customId = str;
        this.placeholder = str2;
        this.minValues = i2;
        this.maxValues = i3;
        this.options = list;
        this.selectedOptions = list2;
        this.emojiAnimationsEnabled = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SelectMessageComponent copy$default(SelectMessageComponent selectMessageComponent, ComponentType componentType, int i, ActionInteractionComponentState actionInteractionComponentState, String str, String str2, int i2, int i3, List list, List list2, boolean z2, int i4, Object obj) {
        return selectMessageComponent.copy((i4 & 1) != 0 ? selectMessageComponent.getType() : componentType, (i4 & 2) != 0 ? selectMessageComponent.getIndex() : i, (i4 & 4) != 0 ? selectMessageComponent.getStateInteraction() : actionInteractionComponentState, (i4 & 8) != 0 ? selectMessageComponent.customId : str, (i4 & 16) != 0 ? selectMessageComponent.placeholder : str2, (i4 & 32) != 0 ? selectMessageComponent.minValues : i2, (i4 & 64) != 0 ? selectMessageComponent.maxValues : i3, (i4 & 128) != 0 ? selectMessageComponent.options : list, (i4 & 256) != 0 ? selectMessageComponent.selectedOptions : list2, (i4 & 512) != 0 ? selectMessageComponent.emojiAnimationsEnabled : z2);
    }

    public final ComponentType component1() {
        return getType();
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getEmojiAnimationsEnabled() {
        return this.emojiAnimationsEnabled;
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
    public final String getPlaceholder() {
        return this.placeholder;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getMinValues() {
        return this.minValues;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getMaxValues() {
        return this.maxValues;
    }

    public final List<SelectItem> component8() {
        return this.options;
    }

    public final List<SelectItem> component9() {
        return this.selectedOptions;
    }

    public final SelectMessageComponent copy(ComponentType type, int index, ActionInteractionComponentState stateInteraction, String customId, String placeholder, int minValues, int maxValues, List<SelectItem> options, List<SelectItem> selectedOptions, boolean emojiAnimationsEnabled) {
        m.checkNotNullParameter(type, "type");
        m.checkNotNullParameter(stateInteraction, "stateInteraction");
        m.checkNotNullParameter(customId, "customId");
        m.checkNotNullParameter(options, "options");
        m.checkNotNullParameter(selectedOptions, "selectedOptions");
        return new SelectMessageComponent(type, index, stateInteraction, customId, placeholder, minValues, maxValues, options, selectedOptions, emojiAnimationsEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectMessageComponent)) {
            return false;
        }
        SelectMessageComponent selectMessageComponent = (SelectMessageComponent) other;
        return m.areEqual(getType(), selectMessageComponent.getType()) && getIndex() == selectMessageComponent.getIndex() && m.areEqual(getStateInteraction(), selectMessageComponent.getStateInteraction()) && m.areEqual(this.customId, selectMessageComponent.customId) && m.areEqual(this.placeholder, selectMessageComponent.placeholder) && this.minValues == selectMessageComponent.minValues && this.maxValues == selectMessageComponent.maxValues && m.areEqual(this.options, selectMessageComponent.options) && m.areEqual(this.selectedOptions, selectMessageComponent.selectedOptions) && this.emojiAnimationsEnabled == selectMessageComponent.emojiAnimationsEnabled;
    }

    public final String getCustomId() {
        return this.customId;
    }

    public final boolean getEmojiAnimationsEnabled() {
        return this.emojiAnimationsEnabled;
    }

    @Override // com.discord.models.botuikit.MessageComponent
    public int getIndex() {
        return this.index;
    }

    public final int getMaxValues() {
        return this.maxValues;
    }

    public final int getMinValues() {
        return this.minValues;
    }

    public final List<SelectItem> getOptions() {
        return this.options;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final List<SelectItem> getSelectedOptions() {
        return this.selectedOptions;
    }

    @Override // com.discord.models.botuikit.ActionMessageComponent
    public ActionInteractionComponentState getStateInteraction() {
        return this.stateInteraction;
    }

    @Override // com.discord.models.botuikit.MessageComponent
    public ComponentType getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    public int hashCode() {
        ComponentType type = getType();
        int index = (getIndex() + ((type != null ? type.hashCode() : 0) * 31)) * 31;
        ActionInteractionComponentState stateInteraction = getStateInteraction();
        int iHashCode = (index + (stateInteraction != null ? stateInteraction.hashCode() : 0)) * 31;
        String str = this.customId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.placeholder;
        int iHashCode3 = (((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.minValues) * 31) + this.maxValues) * 31;
        List<SelectItem> list = this.options;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<SelectItem> list2 = this.selectedOptions;
        int iHashCode5 = (iHashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z2 = this.emojiAnimationsEnabled;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return iHashCode5 + r0;
    }

    public String toString() {
        StringBuilder sbU = a.U("SelectMessageComponent(type=");
        sbU.append(getType());
        sbU.append(", index=");
        sbU.append(getIndex());
        sbU.append(", stateInteraction=");
        sbU.append(getStateInteraction());
        sbU.append(", customId=");
        sbU.append(this.customId);
        sbU.append(", placeholder=");
        sbU.append(this.placeholder);
        sbU.append(", minValues=");
        sbU.append(this.minValues);
        sbU.append(", maxValues=");
        sbU.append(this.maxValues);
        sbU.append(", options=");
        sbU.append(this.options);
        sbU.append(", selectedOptions=");
        sbU.append(this.selectedOptions);
        sbU.append(", emojiAnimationsEnabled=");
        return a.O(sbU, this.emojiAnimationsEnabled, ")");
    }
}
