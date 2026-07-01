package com.discord.widgets.auth;

import b.d.b.a.a;
import com.discord.models.domain.ModelGuildTemplate;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetAuthLandingViewModel$ViewState$GuildTemplate extends WidgetAuthLandingViewModel$ViewState {
    private final String ageGateError;
    private final ModelGuildTemplate guildTemplate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLandingViewModel$ViewState$GuildTemplate(ModelGuildTemplate modelGuildTemplate, String str) {
        super(str, null);
        m.checkNotNullParameter(modelGuildTemplate, "guildTemplate");
        this.guildTemplate = modelGuildTemplate;
        this.ageGateError = str;
    }

    public static /* synthetic */ WidgetAuthLandingViewModel$ViewState$GuildTemplate copy$default(WidgetAuthLandingViewModel$ViewState$GuildTemplate widgetAuthLandingViewModel$ViewState$GuildTemplate, ModelGuildTemplate modelGuildTemplate, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            modelGuildTemplate = widgetAuthLandingViewModel$ViewState$GuildTemplate.guildTemplate;
        }
        if ((i & 2) != 0) {
            str = widgetAuthLandingViewModel$ViewState$GuildTemplate.getAgeGateError();
        }
        return widgetAuthLandingViewModel$ViewState$GuildTemplate.copy(modelGuildTemplate, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelGuildTemplate getGuildTemplate() {
        return this.guildTemplate;
    }

    public final String component2() {
        return getAgeGateError();
    }

    public final WidgetAuthLandingViewModel$ViewState$GuildTemplate copy(ModelGuildTemplate guildTemplate, String ageGateError) {
        m.checkNotNullParameter(guildTemplate, "guildTemplate");
        return new WidgetAuthLandingViewModel$ViewState$GuildTemplate(guildTemplate, ageGateError);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetAuthLandingViewModel$ViewState$GuildTemplate)) {
            return false;
        }
        WidgetAuthLandingViewModel$ViewState$GuildTemplate widgetAuthLandingViewModel$ViewState$GuildTemplate = (WidgetAuthLandingViewModel$ViewState$GuildTemplate) other;
        return m.areEqual(this.guildTemplate, widgetAuthLandingViewModel$ViewState$GuildTemplate.guildTemplate) && m.areEqual(getAgeGateError(), widgetAuthLandingViewModel$ViewState$GuildTemplate.getAgeGateError());
    }

    @Override // com.discord.widgets.auth.WidgetAuthLandingViewModel$ViewState
    public String getAgeGateError() {
        return this.ageGateError;
    }

    public final ModelGuildTemplate getGuildTemplate() {
        return this.guildTemplate;
    }

    public int hashCode() {
        ModelGuildTemplate modelGuildTemplate = this.guildTemplate;
        int iHashCode = (modelGuildTemplate != null ? modelGuildTemplate.hashCode() : 0) * 31;
        String ageGateError = getAgeGateError();
        return iHashCode + (ageGateError != null ? ageGateError.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildTemplate(guildTemplate=");
        sbU.append(this.guildTemplate);
        sbU.append(", ageGateError=");
        sbU.append(getAgeGateError());
        sbU.append(")");
        return sbU.toString();
    }
}
