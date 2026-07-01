package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;

/* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration$setupRadioManager$$inlined$forEachIndexed$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ CheckedSetting $checkedSetting;
    public final /* synthetic */ int $index;
    public final /* synthetic */ RadioManager $radioManager$inlined;
    public final /* synthetic */ int $stateKey$inlined;
    public final /* synthetic */ WidgetServerSettingsEditIntegration this$0;

    public WidgetServerSettingsEditIntegration$setupRadioManager$$inlined$forEachIndexed$lambda$1(CheckedSetting checkedSetting, int i, WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration, RadioManager radioManager, int i2) {
        this.$checkedSetting = checkedSetting;
        this.$index = i;
        this.this$0 = widgetServerSettingsEditIntegration;
        this.$radioManager$inlined = radioManager;
        this.$stateKey$inlined = i2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$radioManager$inlined.a(this.$checkedSetting);
        WidgetServerSettingsEditIntegration.access$getState$p(this.this$0).put(this.$stateKey$inlined, Integer.valueOf(this.$index));
        WidgetServerSettingsEditIntegration.access$getState$p(this.this$0).configureSaveActionView(WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0).o);
    }
}
