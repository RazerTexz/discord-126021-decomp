package com.discord.widgets.servers;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$configureFabVisibility$setFabVisibility$1 */
/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9199x81f9e4eb extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ WidgetServerSettingsChannels.Model $model;
    public final /* synthetic */ WidgetServerSettingsChannels this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9199x81f9e4eb(WidgetServerSettingsChannels widgetServerSettingsChannels, WidgetServerSettingsChannels.Model model) {
        super(0);
        this.this$0 = widgetServerSettingsChannels;
        this.$model = model;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$model.isSorting()) {
            this.this$0.getBinding().f17567c.hide();
        } else {
            this.this$0.getBinding().f17567c.show();
        }
    }
}
