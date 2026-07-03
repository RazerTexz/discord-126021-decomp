package com.discord.models.botuikit;

import com.discord.api.botuikit.ComponentType;
import com.discord.api.botuikit.SelectItem;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(componentType, "type");
        C12238m.checkNotNullParameter(actionInteractionComponentState, "stateInteraction");
        C12238m.checkNotNullParameter(str, "customId");
        C12238m.checkNotNullParameter(list, "options");
        C12238m.checkNotNullParameter(list2, "selectedOptions");
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
        C12238m.checkNotNullParameter(type, "type");
        C12238m.checkNotNullParameter(stateInteraction, "stateInteraction");
        C12238m.checkNotNullParameter(customId, "customId");
        C12238m.checkNotNullParameter(options, "options");
        C12238m.checkNotNullParameter(selectedOptions, "selectedOptions");
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
        return C12238m.areEqual(getType(), selectMessageComponent.getType()) && getIndex() == selectMessageComponent.getIndex() && C12238m.areEqual(getStateInteraction(), selectMessageComponent.getStateInteraction()) && C12238m.areEqual(this.customId, selectMessageComponent.customId) && C12238m.areEqual(this.placeholder, selectMessageComponent.placeholder) && this.minValues == selectMessageComponent.minValues && this.maxValues == selectMessageComponent.maxValues && C12238m.areEqual(this.options, selectMessageComponent.options) && C12238m.areEqual(this.selectedOptions, selectMessageComponent.selectedOptions) && this.emojiAnimationsEnabled == selectMessageComponent.emojiAnimationsEnabled;
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
        StringBuilder sbM833U = C1643a.m833U("SelectMessageComponent(type=");
        sbM833U.append(getType());
        sbM833U.append(", index=");
        sbM833U.append(getIndex());
        sbM833U.append(", stateInteraction=");
        sbM833U.append(getStateInteraction());
        sbM833U.append(", customId=");
        sbM833U.append(this.customId);
        sbM833U.append(", placeholder=");
        sbM833U.append(this.placeholder);
        sbM833U.append(", minValues=");
        sbM833U.append(this.minValues);
        sbM833U.append(", maxValues=");
        sbM833U.append(this.maxValues);
        sbM833U.append(", options=");
        sbM833U.append(this.options);
        sbM833U.append(", selectedOptions=");
        sbM833U.append(this.selectedOptions);
        sbM833U.append(", emojiAnimationsEnabled=");
        return C1643a.m827O(sbM833U, this.emojiAnimationsEnabled, ")");
    }
}
