package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelUserSettings;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAppearance$configureUI$3<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetSettingsAppearance$Model $model;
    public final /* synthetic */ WidgetSettingsAppearance this$0;

    public WidgetSettingsAppearance$configureUI$3(WidgetSettingsAppearance widgetSettingsAppearance, WidgetSettingsAppearance$Model widgetSettingsAppearance$Model) {
        this.this$0 = widgetSettingsAppearance;
        this.$model = widgetSettingsAppearance$Model;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        m.checkNotNullExpressionValue(bool, "isChecked");
        if (bool.booleanValue() && m.areEqual(this.$model.getCurrentTheme(), ModelUserSettings.THEME_DARK)) {
            WidgetSettingsAppearance.access$updateTheme(this.this$0, ModelUserSettings.THEME_PURE_EVIL);
        } else {
            if (bool.booleanValue() || !m.areEqual(this.$model.getCurrentTheme(), ModelUserSettings.THEME_PURE_EVIL)) {
                return;
            }
            WidgetSettingsAppearance.access$updateTheme(this.this$0, ModelUserSettings.THEME_DARK);
        }
    }
}
