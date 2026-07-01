package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.restapi.RestAPIParams$UpdateGuild;

/* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsModeration$configureVerificationLevelRadio$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsModeration$Model $model;
    public final /* synthetic */ GuildVerificationLevel $verificationLevel;
    public final /* synthetic */ WidgetServerSettingsModeration this$0;

    public WidgetServerSettingsModeration$configureVerificationLevelRadio$1(WidgetServerSettingsModeration widgetServerSettingsModeration, WidgetServerSettingsModeration$Model widgetServerSettingsModeration$Model, GuildVerificationLevel guildVerificationLevel) {
        this.this$0 = widgetServerSettingsModeration;
        this.$model = widgetServerSettingsModeration$Model;
        this.$verificationLevel = guildVerificationLevel;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsModeration.access$updateGuild(this.this$0, this.$model.getGuild().getId(), RestAPIParams$UpdateGuild.Companion.createForVerificationLevel(this.$verificationLevel));
    }
}
