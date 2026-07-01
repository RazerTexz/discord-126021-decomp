package com.discord.widgets.settings.guildboost;

import b.d.b.a.a;
import com.discord.models.domain.ModelGuildBoostSlot;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem extends WidgetSettingsGuildBoostSubscriptionAdapter$Item {
    private final String boostEndsAt;
    private final ModelGuildBoostSlot boostSlot;
    private final String key;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem(ModelGuildBoostSlot modelGuildBoostSlot, String str) {
        super(null);
        m.checkNotNullParameter(modelGuildBoostSlot, "boostSlot");
        this.boostSlot = modelGuildBoostSlot;
        this.boostEndsAt = str;
        this.type = 1;
        this.key = String.valueOf(modelGuildBoostSlot.getId());
    }

    public static /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem copy$default(WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem, ModelGuildBoostSlot modelGuildBoostSlot, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            modelGuildBoostSlot = widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem.boostSlot;
        }
        if ((i & 2) != 0) {
            str = widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem.boostEndsAt;
        }
        return widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem.copy(modelGuildBoostSlot, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelGuildBoostSlot getBoostSlot() {
        return this.boostSlot;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBoostEndsAt() {
        return this.boostEndsAt;
    }

    public final WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem copy(ModelGuildBoostSlot boostSlot, String boostEndsAt) {
        m.checkNotNullParameter(boostSlot, "boostSlot");
        return new WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem(boostSlot, boostEndsAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem)) {
            return false;
        }
        WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem = (WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem) other;
        return m.areEqual(this.boostSlot, widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem.boostSlot) && m.areEqual(this.boostEndsAt, widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem.boostEndsAt);
    }

    public final String getBoostEndsAt() {
        return this.boostEndsAt;
    }

    public final ModelGuildBoostSlot getBoostSlot() {
        return this.boostSlot;
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
        ModelGuildBoostSlot modelGuildBoostSlot = this.boostSlot;
        int iHashCode = (modelGuildBoostSlot != null ? modelGuildBoostSlot.hashCode() : 0) * 31;
        String str = this.boostEndsAt;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildBoostItem(boostSlot=");
        sbU.append(this.boostSlot);
        sbU.append(", boostEndsAt=");
        return a.J(sbU, this.boostEndsAt, ")");
    }
}
