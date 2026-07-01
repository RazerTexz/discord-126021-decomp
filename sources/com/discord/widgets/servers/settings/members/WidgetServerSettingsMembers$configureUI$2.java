package com.discord.widgets.servers.settings.members;

import android.content.Context;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.api.role.GuildRole;
import com.discord.databinding.WidgetServerSettingsMembersBinding;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.widgets.servers.WidgetServerSettingsEditMember;
import com.discord.widgets.servers.WidgetServerSettingsEditMember$Companion;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembers$configureUI$2 extends o implements Function2<Long, List<? extends Long>, Unit> {
    public final /* synthetic */ WidgetServerSettingsMembersModel $model;
    public final /* synthetic */ WidgetServerSettingsMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsMembers$configureUI$2(WidgetServerSettingsMembers widgetServerSettingsMembers, WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) {
        super(2);
        this.this$0 = widgetServerSettingsMembers;
        this.$model = widgetServerSettingsMembersModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Long> list) {
        invoke(l.longValue(), (List<Long>) list);
        return Unit.a;
    }

    public final void invoke(long j, List<Long> list) {
        m.checkNotNullParameter(list, "userRoles");
        boolean z2 = j == this.$model.getMeUser().getId();
        if (this.$model.getGuild().getOwnerId() == j && !z2) {
            b.a.d.m.i(this.this$0, 2131887450, 0, 4);
            return;
        }
        GuildRole highestRole = RoleUtils.getHighestRole(this.$model.getRoles(), list);
        if (!RoleUtils.rankIsHigher(this.$model.getMyHighestRole(), highestRole) && !this.$model.getGuild().isOwner(this.$model.getMeUser().getId()) && !z2) {
            if (RoleUtils.rankEquals(this.$model.getMyHighestRole(), highestRole)) {
                b.a.d.m.i(this.this$0, 2131887451, 0, 4);
                return;
            } else {
                b.a.d.m.i(this.this$0, 2131887449, 0, 4);
                return;
            }
        }
        WidgetServerSettingsEditMember$Companion widgetServerSettingsEditMember$Companion = WidgetServerSettingsEditMember.Companion;
        long id2 = this.$model.getGuild().getId();
        WidgetServerSettingsMembersBinding widgetServerSettingsMembersBindingAccess$getBinding$p = WidgetServerSettingsMembers.access$getBinding$p(this.this$0);
        m.checkNotNullExpressionValue(widgetServerSettingsMembersBindingAccess$getBinding$p, "binding");
        CoordinatorLayout coordinatorLayout = widgetServerSettingsMembersBindingAccess$getBinding$p.a;
        m.checkNotNullExpressionValue(coordinatorLayout, "binding.root");
        Context context = coordinatorLayout.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        widgetServerSettingsEditMember$Companion.launch(id2, j, context);
    }
}
