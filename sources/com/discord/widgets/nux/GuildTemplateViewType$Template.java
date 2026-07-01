package com.discord.widgets.nux;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildTemplatesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildTemplateViewType$Template extends GuildTemplateViewType {
    private final GuildTemplate guildTemplate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTemplateViewType$Template(GuildTemplate guildTemplate) {
        super(GuildTemplateViewType.Companion.getTEMPLATE(), null);
        m.checkNotNullParameter(guildTemplate, "guildTemplate");
        this.guildTemplate = guildTemplate;
    }

    public static /* synthetic */ GuildTemplateViewType$Template copy$default(GuildTemplateViewType$Template guildTemplateViewType$Template, GuildTemplate guildTemplate, int i, Object obj) {
        if ((i & 1) != 0) {
            guildTemplate = guildTemplateViewType$Template.guildTemplate;
        }
        return guildTemplateViewType$Template.copy(guildTemplate);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildTemplate getGuildTemplate() {
        return this.guildTemplate;
    }

    public final GuildTemplateViewType$Template copy(GuildTemplate guildTemplate) {
        m.checkNotNullParameter(guildTemplate, "guildTemplate");
        return new GuildTemplateViewType$Template(guildTemplate);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildTemplateViewType$Template) && m.areEqual(this.guildTemplate, ((GuildTemplateViewType$Template) other).guildTemplate);
        }
        return true;
    }

    public final GuildTemplate getGuildTemplate() {
        return this.guildTemplate;
    }

    public int hashCode() {
        GuildTemplate guildTemplate = this.guildTemplate;
        if (guildTemplate != null) {
            return guildTemplate.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Template(guildTemplate=");
        sbU.append(this.guildTemplate);
        sbU.append(")");
        return sbU.toString();
    }
}
