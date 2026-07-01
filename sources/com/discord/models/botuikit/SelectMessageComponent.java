package com.discord.models.botuikit;

import b.d.b.a.outline;
import com.discord.api.botuikit.Component6;
import com.discord.api.botuikit.SelectComponent2;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: SelectMessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class SelectMessageComponent extends MessageComponent2 {
    private final String customId;
    private final boolean emojiAnimationsEnabled;
    private final int index;
    private final int maxValues;
    private final int minValues;
    private final List<SelectComponent2> options;
    private final String placeholder;
    private final List<SelectComponent2> selectedOptions;
    private final ActionInteractionComponentState stateInteraction;
    private final Component6 type;

    public SelectMessageComponent(Component6 component6, int i, ActionInteractionComponentState actionInteractionComponentState, String str, String str2, int i2, int i3, List<SelectComponent2> list, List<SelectComponent2> list2, boolean z2) {
        Intrinsics3.checkNotNullParameter(component6, "type");
        Intrinsics3.checkNotNullParameter(actionInteractionComponentState, "stateInteraction");
        Intrinsics3.checkNotNullParameter(str, "customId");
        Intrinsics3.checkNotNullParameter(list, "options");
        Intrinsics3.checkNotNullParameter(list2, "selectedOptions");
        this.type = component6;
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

    public final Component6 component1() {
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

    public final List<SelectComponent2> component8() {
        return this.options;
    }

    public final List<SelectComponent2> component9() {
        return this.selectedOptions;
    }

    public final SelectMessageComponent copy(Component6 type, int index, ActionInteractionComponentState stateInteraction, String customId, String placeholder, int minValues, int maxValues, List<SelectComponent2> options, List<SelectComponent2> selectedOptions, boolean emojiAnimationsEnabled) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(stateInteraction, "stateInteraction");
        Intrinsics3.checkNotNullParameter(customId, "customId");
        Intrinsics3.checkNotNullParameter(options, "options");
        Intrinsics3.checkNotNullParameter(selectedOptions, "selectedOptions");
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
        return Intrinsics3.areEqual(getType(), selectMessageComponent.getType()) && getIndex() == selectMessageComponent.getIndex() && Intrinsics3.areEqual(getStateInteraction(), selectMessageComponent.getStateInteraction()) && Intrinsics3.areEqual(this.customId, selectMessageComponent.customId) && Intrinsics3.areEqual(this.placeholder, selectMessageComponent.placeholder) && this.minValues == selectMessageComponent.minValues && this.maxValues == selectMessageComponent.maxValues && Intrinsics3.areEqual(this.options, selectMessageComponent.options) && Intrinsics3.areEqual(this.selectedOptions, selectMessageComponent.selectedOptions) && this.emojiAnimationsEnabled == selectMessageComponent.emojiAnimationsEnabled;
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

    public final List<SelectComponent2> getOptions() {
        return this.options;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final List<SelectComponent2> getSelectedOptions() {
        return this.selectedOptions;
    }

    @Override // com.discord.models.botuikit.MessageComponent2
    public ActionInteractionComponentState getStateInteraction() {
        return this.stateInteraction;
    }

    @Override // com.discord.models.botuikit.MessageComponent
    public Component6 getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    public int hashCode() {
        Component6 type = getType();
        int index = (getIndex() + ((type != null ? type.hashCode() : 0) * 31)) * 31;
        ActionInteractionComponentState stateInteraction = getStateInteraction();
        int iHashCode = (index + (stateInteraction != null ? stateInteraction.hashCode() : 0)) * 31;
        String str = this.customId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.placeholder;
        int iHashCode3 = (((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.minValues) * 31) + this.maxValues) * 31;
        List<SelectComponent2> list = this.options;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<SelectComponent2> list2 = this.selectedOptions;
        int iHashCode5 = (iHashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z2 = this.emojiAnimationsEnabled;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return iHashCode5 + r0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("SelectMessageComponent(type=");
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
        return outline.O(sbU, this.emojiAnimationsEnabled, ")");
    }
}
