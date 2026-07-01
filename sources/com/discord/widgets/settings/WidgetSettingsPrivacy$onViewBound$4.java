package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.utilities.uri.UriHandler;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$onViewBound$4 implements View$OnClickListener {
    public final /* synthetic */ String $dataRequestArticleUrl;

    public WidgetSettingsPrivacy$onViewBound$4(String str) {
        this.$dataRequestArticleUrl = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, a.x(view, "it", "it.context"), this.$dataRequestArticleUrl, false, false, null, 28, null);
    }
}
