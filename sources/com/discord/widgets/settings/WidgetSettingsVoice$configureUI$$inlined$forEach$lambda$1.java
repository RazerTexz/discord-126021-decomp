package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.views.CheckedSetting;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice$configureUI$$inlined$forEach$lambda$1<T> implements Action1<Boolean> {
    public final /* synthetic */ CheckedSetting $button;
    public final /* synthetic */ WidgetSettingsVoice this$0;

    public WidgetSettingsVoice$configureUI$$inlined$forEach$lambda$1(CheckedSetting checkedSetting, WidgetSettingsVoice widgetSettingsVoice) {
        this.$button = checkedSetting;
        this.this$0 = widgetSettingsVoice;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        WidgetSettingsVoice.access$getOpenSLESConfigRadioManager$p(this.this$0).a(this.$button);
        WidgetSettingsVoice.access$onOpenSLESConfigChanged(this.this$0);
    }
}
