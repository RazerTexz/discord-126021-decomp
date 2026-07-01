package com.discord.widgets.settings.premium;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.f;
import b.d.b.a.a;
import com.discord.utilities.uri.UriHandler;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium$configurePriceChangeNotice$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsPremium this$0;

    public WidgetSettingsPremium$configurePriceChangeNotice$2(WidgetSettingsPremium widgetSettingsPremium) {
        this.this$0 = widgetSettingsPremium;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, a.I(WidgetSettingsPremium.access$getBinding$p(this.this$0).k.c, "binding.premiumSettingsPriceChangeNotice.textview", "binding.premiumSettingsP…geNotice.textview.context"), f.a.a(4407269525911L, null), false, false, null, 28, null);
    }
}
