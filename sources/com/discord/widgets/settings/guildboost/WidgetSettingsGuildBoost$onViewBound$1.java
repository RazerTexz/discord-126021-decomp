package com.discord.widgets.settings.guildboost;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.utilities.uri.UriHandler;

/* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoost$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ String $helpdeskArticleUrl;

    public WidgetSettingsGuildBoost$onViewBound$1(String str) {
        this.$helpdeskArticleUrl = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, a.x(view, "it", "it.context"), this.$helpdeskArticleUrl, false, false, null, 28, null);
    }
}
