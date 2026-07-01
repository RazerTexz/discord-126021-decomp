package com.discord.widgets.settings.developer;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.hammerandchisel.libdiscord.Discord;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$setupCrashes$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsDeveloper this$0;

    public WidgetSettingsDeveloper$setupCrashes$3(WidgetSettingsDeveloper widgetSettingsDeveloper) {
        this.this$0 = widgetSettingsDeveloper;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Context context = this.this$0.getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.content.Context");
        new Discord(context).crash();
    }
}
