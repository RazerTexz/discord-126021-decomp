package com.discord.widgets.channels.settings;

import b.a.k.b;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.views.CheckedSetting;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings$configureNotificationRadios$1 extends o implements Function3<WidgetChannelNotificationSettings$Model, CheckedSetting, Integer, Unit> {
    public final /* synthetic */ Ref$IntRef $notificationSetting;
    public final /* synthetic */ WidgetChannelNotificationSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelNotificationSettings$configureNotificationRadios$1(WidgetChannelNotificationSettings widgetChannelNotificationSettings, Ref$IntRef ref$IntRef) {
        super(3);
        this.this$0 = widgetChannelNotificationSettings;
        this.$notificationSetting = ref$IntRef;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelNotificationSettings$Model widgetChannelNotificationSettings$Model, CheckedSetting checkedSetting, Integer num) {
        invoke(widgetChannelNotificationSettings$Model, checkedSetting, num.intValue());
        return Unit.a;
    }

    public final void invoke(WidgetChannelNotificationSettings$Model widgetChannelNotificationSettings$Model, CheckedSetting checkedSetting, int i) {
        m.checkNotNullParameter(widgetChannelNotificationSettings$Model, "$this$configureNotificationRadio");
        m.checkNotNullParameter(checkedSetting, "radio");
        if (widgetChannelNotificationSettings$Model.isGuildMuted() || widgetChannelNotificationSettings$Model.getChannelIsMuted()) {
            checkedSetting.b(2131887562);
        } else {
            checkedSetting.e(new WidgetChannelNotificationSettings$configureNotificationRadios$1$1(widgetChannelNotificationSettings$Model, i));
        }
        if (widgetChannelNotificationSettings$Model.isAboveNotifyAllSize() && i == ModelNotificationSettings.FREQUENCY_ALL) {
            CharSequence charSequenceK = b.k(this.this$0, 2131892512, new Object[0], null, 4);
            int i2 = CheckedSetting.j;
            checkedSetting.h(charSequenceK, false);
        } else {
            int i3 = CheckedSetting.j;
            checkedSetting.h(null, false);
        }
        boolean z2 = this.$notificationSetting.element == i;
        checkedSetting.setButtonAlpha((z2 && widgetChannelNotificationSettings$Model.getNotificationSettingIsInherited()) ? 0.3f : 1.0f);
        if (z2) {
            WidgetChannelNotificationSettings.access$getNotificationSettingsRadioManager$p(this.this$0).a(checkedSetting);
        }
    }
}
