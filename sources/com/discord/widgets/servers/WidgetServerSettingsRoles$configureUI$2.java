package com.discord.widgets.servers;

import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoles$configureUI$2 extends o implements Function1<Map<String, ? extends Integer>, Unit> {
    public final /* synthetic */ WidgetServerSettingsRoles$Model $data;
    public final /* synthetic */ WidgetServerSettingsRoles this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRoles$configureUI$2(WidgetServerSettingsRoles widgetServerSettingsRoles, WidgetServerSettingsRoles$Model widgetServerSettingsRoles$Model) {
        super(1);
        this.this$0 = widgetServerSettingsRoles;
        this.$data = widgetServerSettingsRoles$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends Integer> map) {
        invoke2((Map<String, Integer>) map);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, Integer> map) {
        m.checkNotNullParameter(map, "newPositions");
        WidgetServerSettingsRoles.access$processRoleDrop(this.this$0, map, this.$data);
    }
}
