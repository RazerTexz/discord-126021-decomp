package com.discord.widgets.nux;

import android.content.Context;
import b.a.d.j;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildTemplates$Companion {
    private WidgetGuildTemplates$Companion() {
    }

    public final void launch(Context context, CreateGuildTrigger trigger, boolean isNux) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(trigger, "trigger");
        String str = isNux ? GuildTemplateAnalytics.STEP_GUILD_TEMPLATE : GuildTemplateAnalytics.IN_APP_LOCATION_TEMPLATE;
        String string = context.getString(2131891641);
        m.checkNotNullExpressionValue(string, "context.getString(R.stri…_template_selector_title)");
        String string2 = context.getString(2131891639);
        m.checkNotNullExpressionValue(string2, "context.getString(R.stri…ate_selector_description)");
        launch(context, new GuildCreateArgs(isNux, str, trigger, new GuildTemplateArgs(string, string2, null, false, false, 28, null), false, 16, null));
    }

    public /* synthetic */ WidgetGuildTemplates$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void launch(Context context, GuildCreateArgs args) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(args, "args");
        j.d(context, WidgetGuildTemplates.class, args);
    }
}
