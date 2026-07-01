package com.discord.widgets.servers.role_members;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import b.a.a.e;
import b.a.a.e$c;
import b.a.k.b;
import com.discord.dialogs.SimpleConfirmationDialogArgs;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers$configureUI$1 extends o implements Function2<GuildMember, User, Unit> {
    public final /* synthetic */ ServerSettingsRoleMembersViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetServerSettingsRoleMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRoleMembers$configureUI$1(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers, ServerSettingsRoleMembersViewModel$ViewState serverSettingsRoleMembersViewModel$ViewState) {
        super(2);
        this.this$0 = widgetServerSettingsRoleMembers;
        this.$viewState = serverSettingsRoleMembersViewModel$ViewState;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(GuildMember guildMember, User user) {
        invoke2(guildMember, user);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildMember guildMember, User user) {
        m.checkNotNullParameter(guildMember, "guildMember");
        m.checkNotNullParameter(user, "user");
        e$c e_c = e.k;
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        String string = this.this$0.getString(2131895148);
        Context contextRequireContext = this.this$0.requireContext();
        Object[] objArr = new Object[2];
        Object nick = guildMember.getNick();
        if (nick == null) {
            nick = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
        }
        objArr[0] = nick;
        objArr[1] = ((ServerSettingsRoleMembersViewModel$ViewState$Loaded) this.$viewState).getRole().getName();
        e_c.a(childFragmentManager, new SimpleConfirmationDialogArgs(string, b.h(contextRequireContext, 2131895146, objArr, null, 4).toString(), this.this$0.getString(2131894737), this.this$0.getString(2131887437)), new WidgetServerSettingsRoleMembers$configureUI$1$1(this, guildMember));
    }
}
