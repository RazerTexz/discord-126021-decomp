package com.discord.widgets.settings.connections;

import android.app.Dialog;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAdd$onViewCreated$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetSettingsUserConnectionsAdd this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsUserConnectionsAdd$onViewCreated$1(WidgetSettingsUserConnectionsAdd widgetSettingsUserConnectionsAdd) {
        super(0);
        this.this$0 = widgetSettingsUserConnectionsAdd;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Dialog dialog = this.this$0.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
