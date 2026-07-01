package com.discord.widgets.guildcommunicationdisabled.start;

import android.content.Context;
import b.a.d.m;
import b.a.k.b;
import com.discord.app.AppActivity;
import com.discord.models.user.User;
import com.discord.utilities.user.UserUtils;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableGuildCommunication$configureUI$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetDisableGuildCommunication$configureUI$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDisableGuildCommunication$configureUI$2$1(WidgetDisableGuildCommunication$configureUI$2 widgetDisableGuildCommunication$configureUI$2) {
        super(0);
        this.this$0 = widgetDisableGuildCommunication$configureUI$2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        CharSequence charSequenceH;
        Context context = this.this$0.this$0.getContext();
        Context context2 = this.this$0.this$0.getContext();
        if (context2 != null) {
            Object[] objArr = new Object[2];
            User user = ((DisableGuildCommunicationViewModel$ViewState$Valid) this.this$0.$viewState).getUser();
            objArr[0] = user != null ? UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null) : null;
            objArr[1] = GuildCommunicationDisabledDateUtils.INSTANCE.getFriendlyDurationString(this.this$0.this$0.getContext(), ((DisableGuildCommunicationViewModel$ViewState$Valid) this.this$0.$viewState).getSelectedDurationOption());
            charSequenceH = b.h(context2, 2131888471, objArr, null, 4);
        } else {
            charSequenceH = null;
        }
        m.h(context, charSequenceH, 0, null, 12);
        AppActivity appActivity = this.this$0.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }
}
