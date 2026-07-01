package com.discord.widgets.guilds.profile;

import com.discord.databinding.WidgetGuildHubProfileActionsBinding;
import d0.z.d.q;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildProfileSheet$configureUI$1 extends q {
    public WidgetGuildProfileSheet$configureUI$1(WidgetGuildProfileSheet widgetGuildProfileSheet) {
        super(widgetGuildProfileSheet, WidgetGuildProfileSheet.class, "guildHubActionBinding", "getGuildHubActionBinding()Lcom/discord/databinding/WidgetGuildHubProfileActionsBinding;", 0);
    }

    @Override // d0.z.d.q, kotlin.reflect.KProperty0
    public Object get() {
        return WidgetGuildProfileSheet.access$getGuildHubActionBinding$p((WidgetGuildProfileSheet) this.receiver);
    }

    @Override // d0.z.d.q
    public void set(Object obj) {
        WidgetGuildProfileSheet.access$setGuildHubActionBinding$p((WidgetGuildProfileSheet) this.receiver, (WidgetGuildHubProfileActionsBinding) obj);
    }
}
