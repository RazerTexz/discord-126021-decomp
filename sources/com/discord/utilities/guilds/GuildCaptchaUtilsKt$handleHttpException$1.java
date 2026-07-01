package com.discord.utilities.guilds;

import com.discord.app.AppFragment;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.widgets.guilds.invite.InviteJoinHelper;
import com.discord.widgets.guilds.join.InviteArgs;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: GuildCaptchaUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildCaptchaUtilsKt$handleHttpException$1 extends o implements Function2<AppFragment, CaptchaHelper$CaptchaPayload, Unit> {
    public final /* synthetic */ InviteArgs $args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildCaptchaUtilsKt$handleHttpException$1(InviteArgs inviteArgs) {
        super(2);
        this.$args = inviteArgs;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        invoke2(appFragment, captchaHelper$CaptchaPayload);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppFragment appFragment, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        m.checkNotNullParameter(appFragment, "newFragment");
        m.checkNotNullParameter(captchaHelper$CaptchaPayload, "captchaPayload");
        InviteJoinHelper.INSTANCE.joinViaInvite(this.$args.getInvite(), this.$args.getJavaClass(), appFragment, this.$args.getLocation(), this.$args.getOnInvitePostError(), this.$args.getOnInvitePostSuccess(), this.$args.getOnInviteFlowFinished(), captchaHelper$CaptchaPayload);
    }
}
