package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import com.discord.utilities.mg_recycler.DragAndDropAdapter$Payload;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$Companion;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter$RoleListHelpItem$onConfigure$1$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetServerSettingsRolesAdapter$RoleListHelpItem$onConfigure$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRolesAdapter$RoleListHelpItem$onConfigure$1$1(WidgetServerSettingsRolesAdapter$RoleListHelpItem$onConfigure$1 widgetServerSettingsRolesAdapter$RoleListHelpItem$onConfigure$1) {
        super(1);
        this.this$0 = widgetServerSettingsRolesAdapter$RoleListHelpItem$onConfigure$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "view");
        WidgetServerSettingsMembers$Companion widgetServerSettingsMembers$Companion = WidgetServerSettingsMembers.Companion;
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "view.context");
        DragAndDropAdapter$Payload dragAndDropAdapter$Payload = this.this$0.$data;
        Objects.requireNonNull(dragAndDropAdapter$Payload, "null cannot be cast to non-null type com.discord.widgets.servers.WidgetServerSettingsRolesAdapter.HelpItem");
        widgetServerSettingsMembers$Companion.create(context, ((WidgetServerSettingsRolesAdapter$HelpItem) dragAndDropAdapter$Payload).getGuildId());
    }
}
