package com.discord.widgets.settings.guildboost;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsGuildBoostSubscriptionAdapter$Item$HeaderItem extends WidgetSettingsGuildBoostSubscriptionAdapter$Item {
    private final int headerStringId;
    private final String key;
    private final int type;

    public WidgetSettingsGuildBoostSubscriptionAdapter$Item$HeaderItem(@StringRes int i) {
        super(null);
        this.headerStringId = i;
        this.type = 2;
        this.key = String.valueOf(i);
    }

    public static /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter$Item$HeaderItem copy$default(WidgetSettingsGuildBoostSubscriptionAdapter$Item$HeaderItem widgetSettingsGuildBoostSubscriptionAdapter$Item$HeaderItem, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetSettingsGuildBoostSubscriptionAdapter$Item$HeaderItem.headerStringId;
        }
        return widgetSettingsGuildBoostSubscriptionAdapter$Item$HeaderItem.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getHeaderStringId() {
        return this.headerStringId;
    }

    public final WidgetSettingsGuildBoostSubscriptionAdapter$Item$HeaderItem copy(@StringRes int headerStringId) {
        return new WidgetSettingsGuildBoostSubscriptionAdapter$Item$HeaderItem(headerStringId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetSettingsGuildBoostSubscriptionAdapter$Item$HeaderItem) && this.headerStringId == ((WidgetSettingsGuildBoostSubscriptionAdapter$Item$HeaderItem) other).headerStringId;
        }
        return true;
    }

    public final int getHeaderStringId() {
        return this.headerStringId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.headerStringId;
    }

    public String toString() {
        return a.B(a.U("HeaderItem(headerStringId="), this.headerStringId, ")");
    }
}
