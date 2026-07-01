package com.discord.widgets.guilds.create;

import b.d.b.a.a;
import com.discord.models.user.User;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildCreateViewModel$StoreState {
    private final StoreGuildTemplates$GuildTemplateState guildTemplate;
    private final User meUser;

    public WidgetGuildCreateViewModel$StoreState(User user, StoreGuildTemplates$GuildTemplateState storeGuildTemplates$GuildTemplateState) {
        m.checkNotNullParameter(user, "meUser");
        m.checkNotNullParameter(storeGuildTemplates$GuildTemplateState, "guildTemplate");
        this.meUser = user;
        this.guildTemplate = storeGuildTemplates$GuildTemplateState;
    }

    public static /* synthetic */ WidgetGuildCreateViewModel$StoreState copy$default(WidgetGuildCreateViewModel$StoreState widgetGuildCreateViewModel$StoreState, User user, StoreGuildTemplates$GuildTemplateState storeGuildTemplates$GuildTemplateState, int i, Object obj) {
        if ((i & 1) != 0) {
            user = widgetGuildCreateViewModel$StoreState.meUser;
        }
        if ((i & 2) != 0) {
            storeGuildTemplates$GuildTemplateState = widgetGuildCreateViewModel$StoreState.guildTemplate;
        }
        return widgetGuildCreateViewModel$StoreState.copy(user, storeGuildTemplates$GuildTemplateState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getMeUser() {
        return this.meUser;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreGuildTemplates$GuildTemplateState getGuildTemplate() {
        return this.guildTemplate;
    }

    public final WidgetGuildCreateViewModel$StoreState copy(User meUser, StoreGuildTemplates$GuildTemplateState guildTemplate) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(guildTemplate, "guildTemplate");
        return new WidgetGuildCreateViewModel$StoreState(meUser, guildTemplate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildCreateViewModel$StoreState)) {
            return false;
        }
        WidgetGuildCreateViewModel$StoreState widgetGuildCreateViewModel$StoreState = (WidgetGuildCreateViewModel$StoreState) other;
        return m.areEqual(this.meUser, widgetGuildCreateViewModel$StoreState.meUser) && m.areEqual(this.guildTemplate, widgetGuildCreateViewModel$StoreState.guildTemplate);
    }

    public final StoreGuildTemplates$GuildTemplateState getGuildTemplate() {
        return this.guildTemplate;
    }

    public final User getMeUser() {
        return this.meUser;
    }

    public int hashCode() {
        User user = this.meUser;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        StoreGuildTemplates$GuildTemplateState storeGuildTemplates$GuildTemplateState = this.guildTemplate;
        return iHashCode + (storeGuildTemplates$GuildTemplateState != null ? storeGuildTemplates$GuildTemplateState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(meUser=");
        sbU.append(this.meUser);
        sbU.append(", guildTemplate=");
        sbU.append(this.guildTemplate);
        sbU.append(")");
        return sbU.toString();
    }
}
