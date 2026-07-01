package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.databinding.WidgetSettingsBinding;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$$inlined$with$lambda$6 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsBinding $this_with;
    public final /* synthetic */ WidgetSettings this$0;

    public WidgetSettings$onViewBound$$inlined$with$lambda$6(WidgetSettingsBinding widgetSettingsBinding, WidgetSettings widgetSettings) {
        this.$this_with = widgetSettingsBinding;
        this.this$0 = widgetSettings;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettings$onViewBound$$inlined$with$lambda$6$1 widgetSettings$onViewBound$$inlined$with$lambda$6$1 = new WidgetSettings$onViewBound$$inlined$with$lambda$6$1(this);
        widgetSettings$onViewBound$$inlined$with$lambda$6$1.invoke(false);
        Observable observableUi$default = ObservableExtensionsKt.ui$default(RestAPI.Companion.uploadSystemLog(), this.this$0, null, 2, null);
        Context context = this.this$0.getContext();
        String name = this.$this_with.getClass().getName();
        m.checkNotNullExpressionValue(name, "javaClass.name");
        ObservableExtensionsKt.appSubscribe$default(observableUi$default, context, name, (Function1) null, new WidgetSettings$onViewBound$$inlined$with$lambda$6$2(this, widgetSettings$onViewBound$$inlined$with$lambda$6$1), new WidgetSettings$onViewBound$$inlined$with$lambda$6$3(widgetSettings$onViewBound$$inlined$with$lambda$6$1), new WidgetSettings$onViewBound$$inlined$with$lambda$6$4(widgetSettings$onViewBound$$inlined$with$lambda$6$1), (Function0) null, 68, (Object) null);
    }
}
