package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEditIntegration$Model $model;
    public final /* synthetic */ WidgetServerSettingsEditIntegration this$0;

    public WidgetServerSettingsEditIntegration$configureUI$1(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration, WidgetServerSettingsEditIntegration$Model widgetServerSettingsEditIntegration$Model) {
        this.this$0 = widgetServerSettingsEditIntegration;
        this.$model = widgetServerSettingsEditIntegration$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().syncIntegration(this.$model.getGuild().getId(), this.$model.getIntegration().getId()), false, 1, null), this.this$0, null, 2, null);
        Class<?> cls = this.this$0.getClass();
        m.checkNotNullExpressionValue(view, "view");
        ObservableExtensionsKt.appSubscribe$default(observableUi$default, cls, view.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsEditIntegration$configureUI$1$1(this), 60, (Object) null);
    }
}
