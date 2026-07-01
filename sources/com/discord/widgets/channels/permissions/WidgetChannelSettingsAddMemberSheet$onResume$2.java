package com.discord.widgets.channels.permissions;

import android.widget.TextView;
import com.discord.api.permission.PermissionOverwrite$Type;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberSheet$onResume$2 extends o implements Function1<Map<Long, ? extends PermissionOverwrite$Type>, Unit> {
    public final /* synthetic */ WidgetChannelSettingsAddMemberSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsAddMemberSheet$onResume$2(WidgetChannelSettingsAddMemberSheet widgetChannelSettingsAddMemberSheet) {
        super(1);
        this.this$0 = widgetChannelSettingsAddMemberSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends PermissionOverwrite$Type> map) {
        invoke2(map);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<Long, ? extends PermissionOverwrite$Type> map) {
        TextView textView = WidgetChannelSettingsAddMemberSheet.access$getBinding$p(this.this$0).f2272b;
        m.checkNotNullExpressionValue(textView, "binding.addButton");
        m.checkNotNullExpressionValue(map, "selected");
        ViewExtensions.setEnabledAndAlpha$default(textView, !map.isEmpty(), 0.0f, 2, null);
    }
}
