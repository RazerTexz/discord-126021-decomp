package com.discord.widgets.servers;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoles$processRoleDrop$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetServerSettingsRoles$Model $dataSnapshot;
    public final /* synthetic */ WidgetServerSettingsRoles this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRoles$processRoleDrop$2(WidgetServerSettingsRoles widgetServerSettingsRoles, WidgetServerSettingsRoles$Model widgetServerSettingsRoles$Model) {
        super(1);
        this.this$0 = widgetServerSettingsRoles;
        this.$dataSnapshot = widgetServerSettingsRoles$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        WidgetServerSettingsRoles.access$configureUI(this.this$0, this.$dataSnapshot);
    }
}
