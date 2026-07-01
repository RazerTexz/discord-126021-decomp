package com.discord.widgets.user;

import b.d.b.a.a;
import com.discord.models.domain.ModelCustomStatusSetting;
import com.discord.models.domain.emoji.EmojiSet;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSetCustomStatusViewModel$StoreState {
    private final ModelCustomStatusSetting customStatusSetting;
    private final EmojiSet emojiSet;

    public WidgetUserSetCustomStatusViewModel$StoreState(ModelCustomStatusSetting modelCustomStatusSetting, EmojiSet emojiSet) {
        m.checkNotNullParameter(modelCustomStatusSetting, "customStatusSetting");
        m.checkNotNullParameter(emojiSet, "emojiSet");
        this.customStatusSetting = modelCustomStatusSetting;
        this.emojiSet = emojiSet;
    }

    public static /* synthetic */ WidgetUserSetCustomStatusViewModel$StoreState copy$default(WidgetUserSetCustomStatusViewModel$StoreState widgetUserSetCustomStatusViewModel$StoreState, ModelCustomStatusSetting modelCustomStatusSetting, EmojiSet emojiSet, int i, Object obj) {
        if ((i & 1) != 0) {
            modelCustomStatusSetting = widgetUserSetCustomStatusViewModel$StoreState.customStatusSetting;
        }
        if ((i & 2) != 0) {
            emojiSet = widgetUserSetCustomStatusViewModel$StoreState.emojiSet;
        }
        return widgetUserSetCustomStatusViewModel$StoreState.copy(modelCustomStatusSetting, emojiSet);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelCustomStatusSetting getCustomStatusSetting() {
        return this.customStatusSetting;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final EmojiSet getEmojiSet() {
        return this.emojiSet;
    }

    public final WidgetUserSetCustomStatusViewModel$StoreState copy(ModelCustomStatusSetting customStatusSetting, EmojiSet emojiSet) {
        m.checkNotNullParameter(customStatusSetting, "customStatusSetting");
        m.checkNotNullParameter(emojiSet, "emojiSet");
        return new WidgetUserSetCustomStatusViewModel$StoreState(customStatusSetting, emojiSet);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetUserSetCustomStatusViewModel$StoreState)) {
            return false;
        }
        WidgetUserSetCustomStatusViewModel$StoreState widgetUserSetCustomStatusViewModel$StoreState = (WidgetUserSetCustomStatusViewModel$StoreState) other;
        return m.areEqual(this.customStatusSetting, widgetUserSetCustomStatusViewModel$StoreState.customStatusSetting) && m.areEqual(this.emojiSet, widgetUserSetCustomStatusViewModel$StoreState.emojiSet);
    }

    public final ModelCustomStatusSetting getCustomStatusSetting() {
        return this.customStatusSetting;
    }

    public final EmojiSet getEmojiSet() {
        return this.emojiSet;
    }

    public int hashCode() {
        ModelCustomStatusSetting modelCustomStatusSetting = this.customStatusSetting;
        int iHashCode = (modelCustomStatusSetting != null ? modelCustomStatusSetting.hashCode() : 0) * 31;
        EmojiSet emojiSet = this.emojiSet;
        return iHashCode + (emojiSet != null ? emojiSet.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(customStatusSetting=");
        sbU.append(this.customStatusSetting);
        sbU.append(", emojiSet=");
        sbU.append(this.emojiSet);
        sbU.append(")");
        return sbU.toString();
    }
}
