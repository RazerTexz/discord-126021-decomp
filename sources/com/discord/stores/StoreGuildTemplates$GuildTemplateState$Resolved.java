package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelGuildTemplate;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGuildTemplates$GuildTemplateState$Resolved extends StoreGuildTemplates$GuildTemplateState {
    private final ModelGuildTemplate guildTemplate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildTemplates$GuildTemplateState$Resolved(ModelGuildTemplate modelGuildTemplate) {
        super(null);
        m.checkNotNullParameter(modelGuildTemplate, "guildTemplate");
        this.guildTemplate = modelGuildTemplate;
    }

    public static /* synthetic */ StoreGuildTemplates$GuildTemplateState$Resolved copy$default(StoreGuildTemplates$GuildTemplateState$Resolved storeGuildTemplates$GuildTemplateState$Resolved, ModelGuildTemplate modelGuildTemplate, int i, Object obj) {
        if ((i & 1) != 0) {
            modelGuildTemplate = storeGuildTemplates$GuildTemplateState$Resolved.guildTemplate;
        }
        return storeGuildTemplates$GuildTemplateState$Resolved.copy(modelGuildTemplate);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelGuildTemplate getGuildTemplate() {
        return this.guildTemplate;
    }

    public final StoreGuildTemplates$GuildTemplateState$Resolved copy(ModelGuildTemplate guildTemplate) {
        m.checkNotNullParameter(guildTemplate, "guildTemplate");
        return new StoreGuildTemplates$GuildTemplateState$Resolved(guildTemplate);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreGuildTemplates$GuildTemplateState$Resolved) && m.areEqual(this.guildTemplate, ((StoreGuildTemplates$GuildTemplateState$Resolved) other).guildTemplate);
        }
        return true;
    }

    public final ModelGuildTemplate getGuildTemplate() {
        return this.guildTemplate;
    }

    public int hashCode() {
        ModelGuildTemplate modelGuildTemplate = this.guildTemplate;
        if (modelGuildTemplate != null) {
            return modelGuildTemplate.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Resolved(guildTemplate=");
        sbU.append(this.guildTemplate);
        sbU.append(")");
        return sbU.toString();
    }
}
