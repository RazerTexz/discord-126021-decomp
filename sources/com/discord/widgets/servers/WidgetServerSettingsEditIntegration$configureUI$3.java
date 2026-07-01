package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.restapi.RestAPIParams$GuildIntegration;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.views.CheckedSetting;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEditIntegration$Model $model;
    public final /* synthetic */ WidgetServerSettingsEditIntegration this$0;

    public WidgetServerSettingsEditIntegration$configureUI$3(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration, WidgetServerSettingsEditIntegration$Model widgetServerSettingsEditIntegration$Model) {
        this.this$0 = widgetServerSettingsEditIntegration;
        this.$model = widgetServerSettingsEditIntegration$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int iB = WidgetServerSettingsEditIntegration.access$getExpiryBehaviorRadioManager$p(this.this$0).b();
        int i = WidgetServerSettingsEditIntegration.access$getGracePeriodDays$cp()[WidgetServerSettingsEditIntegration.access$getGracePeriodRadioManager$p(this.this$0).b()];
        CheckedSetting checkedSetting = WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(checkedSetting, "binding.editIntegrationCustomEmotesToggle");
        Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().updateGuildIntegration(this.$model.getGuild().getId(), this.$model.getIntegration().getId(), new RestAPIParams$GuildIntegration(iB, i, checkedSetting.isChecked())), false, 1, null), this.this$0, null, 2, null);
        Class<?> cls = this.this$0.getClass();
        m.checkNotNullExpressionValue(view, "view");
        ObservableExtensionsKt.appSubscribe$default(observableUi$default, cls, view.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetServerSettingsEditIntegration$configureUI$3$1.INSTANCE, 60, (Object) null);
    }
}
