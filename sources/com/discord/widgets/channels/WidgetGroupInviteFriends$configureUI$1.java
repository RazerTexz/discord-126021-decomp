package com.discord.widgets.channels;

import com.discord.models.user.User;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$configureUI$1 extends o implements Function2<User, Boolean, Unit> {
    public final /* synthetic */ WidgetGroupInviteFriends$Model $data;
    public final /* synthetic */ WidgetGroupInviteFriends this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGroupInviteFriends$configureUI$1(WidgetGroupInviteFriends widgetGroupInviteFriends, WidgetGroupInviteFriends$Model widgetGroupInviteFriends$Model) {
        super(2);
        this.this$0 = widgetGroupInviteFriends;
        this.$data = widgetGroupInviteFriends$Model;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(User user, Boolean bool) {
        invoke(user, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(User user, boolean z2) {
        m.checkNotNullParameter(user, "user");
        if (!z2) {
            WidgetGroupInviteFriends.access$unselectUser(this.this$0, user);
        } else if (this.$data.getTotalNumRecipients() >= this.$data.getMaxGroupMemberCount()) {
            b.a.d.m.i(this.this$0, 2131889809, 0, 4);
        } else {
            WidgetGroupInviteFriends.access$selectUser(this.this$0, user);
        }
    }
}
