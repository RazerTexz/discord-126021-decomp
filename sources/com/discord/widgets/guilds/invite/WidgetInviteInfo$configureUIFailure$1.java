package com.discord.widgets.guilds.invite;

import com.discord.i18n.RenderContext;
import com.discord.models.user.MeUser;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetInviteInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetInviteInfo$configureUIFailure$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ MeUser $meUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetInviteInfo$configureUIFailure$1(MeUser meUser) {
        super(1);
        this.$meUser = meUser;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.args.put("quantity", String.valueOf(UserUtils.INSTANCE.isPremiumTier2(this.$meUser) ? 200 : 100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }
}
