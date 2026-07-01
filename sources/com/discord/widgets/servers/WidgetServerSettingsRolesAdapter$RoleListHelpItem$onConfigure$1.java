package com.discord.widgets.servers;

import com.discord.i18n.RenderContext;
import com.discord.utilities.mg_recycler.DragAndDropAdapter$Payload;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter$RoleListHelpItem$onConfigure$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ DragAndDropAdapter$Payload $data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRolesAdapter$RoleListHelpItem$onConfigure$1(DragAndDropAdapter$Payload dragAndDropAdapter$Payload) {
        super(1);
        this.$data = dragAndDropAdapter$Payload;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.b("onMembersClick", new WidgetServerSettingsRolesAdapter$RoleListHelpItem$onConfigure$1$1(this));
    }
}
