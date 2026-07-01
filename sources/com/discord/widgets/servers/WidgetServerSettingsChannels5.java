package com.discord.widgets.servers;

import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$configureFabVisibility$setFabVisibility$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannels5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetServerSettingsChannels.Model $model;
    public final /* synthetic */ WidgetServerSettingsChannels this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsChannels5(WidgetServerSettingsChannels widgetServerSettingsChannels, WidgetServerSettingsChannels.Model model) {
        super(0);
        this.this$0 = widgetServerSettingsChannels;
        this.$model = model;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$model.isSorting()) {
            this.this$0.getBinding().c.hide();
        } else {
            this.this$0.getBinding().c.show();
        }
    }
}
