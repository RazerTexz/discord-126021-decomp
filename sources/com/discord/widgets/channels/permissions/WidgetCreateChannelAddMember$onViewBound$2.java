package com.discord.widgets.channels.permissions;

import com.discord.R$menu;
import com.discord.api.permission.PermissionOverwrite$Type;
import com.discord.app.AppFragment;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannelAddMember$onViewBound$2 extends o implements Function1<Map<Long, ? extends PermissionOverwrite$Type>, Unit> {
    public final /* synthetic */ WidgetCreateChannelAddMember this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreateChannelAddMember$onViewBound$2(WidgetCreateChannelAddMember widgetCreateChannelAddMember) {
        super(1);
        this.this$0 = widgetCreateChannelAddMember;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends PermissionOverwrite$Type> map) {
        invoke2(map);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<Long, ? extends PermissionOverwrite$Type> map) {
        AppFragment.setActionBarOptionsMenu$default(this.this$0, R$menu.menu_add_member_continue, new WidgetCreateChannelAddMember$onViewBound$2$1(this, map), null, 4, null);
    }
}
