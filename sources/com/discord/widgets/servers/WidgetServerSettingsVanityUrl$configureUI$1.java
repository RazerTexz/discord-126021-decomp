package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsVanityUrl$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsVanityUrl$Model $model;
    public final /* synthetic */ WidgetServerSettingsVanityUrl this$0;

    public WidgetServerSettingsVanityUrl$configureUI$1(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl, WidgetServerSettingsVanityUrl$Model widgetServerSettingsVanityUrl$Model) {
        this.this$0 = widgetServerSettingsVanityUrl;
        this.$model = widgetServerSettingsVanityUrl$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl = this.this$0;
        long guildId = this.$model.getGuildId();
        TextInputLayout textInputLayout = WidgetServerSettingsVanityUrl.access$getBinding$p(this.this$0).f2588b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        int length = textOrEmpty.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = m.compare(textOrEmpty.charAt(!z2 ? i : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                } else {
                    length--;
                }
            } else if (z3) {
                i++;
            } else {
                z2 = true;
            }
        }
        WidgetServerSettingsVanityUrl.access$updateVanityUrl(widgetServerSettingsVanityUrl, guildId, textOrEmpty.subSequence(i, length + 1).toString());
    }
}
