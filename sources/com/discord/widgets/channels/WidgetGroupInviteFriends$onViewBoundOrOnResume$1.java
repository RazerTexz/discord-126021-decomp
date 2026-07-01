package com.discord.widgets.channels;

import com.discord.models.user.User;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$onViewBoundOrOnResume$1 extends o implements Function1<WidgetGroupInviteFriends$UserDataContract, Unit> {
    public final /* synthetic */ WidgetGroupInviteFriends this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGroupInviteFriends$onViewBoundOrOnResume$1(WidgetGroupInviteFriends widgetGroupInviteFriends) {
        super(1);
        this.this$0 = widgetGroupInviteFriends;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGroupInviteFriends$UserDataContract widgetGroupInviteFriends$UserDataContract) {
        invoke2(widgetGroupInviteFriends$UserDataContract);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGroupInviteFriends$UserDataContract widgetGroupInviteFriends$UserDataContract) {
        User modelUser;
        if (widgetGroupInviteFriends$UserDataContract == null || (modelUser = widgetGroupInviteFriends$UserDataContract.getModelUser()) == null) {
            return;
        }
        WidgetGroupInviteFriends.access$unselectUser(this.this$0, modelUser);
    }
}
