package com.discord.widgets.guild_role_subscriptions.entrypoint;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Valid extends WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState {
    private final Guild guild;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Valid(Guild guild) {
        super(null);
        m.checkNotNullParameter(guild, "guild");
        this.guild = guild;
    }

    public static /* synthetic */ WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Valid copy$default(WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Valid widgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Valid, Guild guild, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Valid.guild;
        }
        return widgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Valid.copy(guild);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Valid copy(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        return new WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Valid(guild);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Valid) && m.areEqual(this.guild, ((WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Valid) other).guild);
        }
        return true;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public int hashCode() {
        Guild guild = this.guild;
        if (guild != null) {
            return guild.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(guild=");
        sbU.append(this.guild);
        sbU.append(")");
        return sbU.toString();
    }
}
