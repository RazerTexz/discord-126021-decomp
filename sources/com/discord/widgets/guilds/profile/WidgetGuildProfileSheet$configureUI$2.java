package com.discord.widgets.guilds.profile;

import com.discord.databinding.WidgetGuildProfileActionsBinding;
import d0.z.d.q;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildProfileSheet$configureUI$2 extends q {
    public WidgetGuildProfileSheet$configureUI$2(WidgetGuildProfileSheet widgetGuildProfileSheet) {
        super(widgetGuildProfileSheet, WidgetGuildProfileSheet.class, "guildActionBinding", "getGuildActionBinding()Lcom/discord/databinding/WidgetGuildProfileActionsBinding;", 0);
    }

    @Override // d0.z.d.q, kotlin.reflect.KProperty0
    public Object get() {
        return WidgetGuildProfileSheet.access$getGuildActionBinding$p((WidgetGuildProfileSheet) this.receiver);
    }

    @Override // d0.z.d.q
    public void set(Object obj) {
        WidgetGuildProfileSheet.access$setGuildActionBinding$p((WidgetGuildProfileSheet) this.receiver, (WidgetGuildProfileActionsBinding) obj);
    }
}
