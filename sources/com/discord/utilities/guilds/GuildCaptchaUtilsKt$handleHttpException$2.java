package com.discord.utilities.guilds;

import android.content.Context;
import com.discord.app.AppFragment;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.widgets.guilds.join.GuildJoinHelperKt;
import com.discord.widgets.guilds.join.JoinArgs;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: GuildCaptchaUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildCaptchaUtilsKt$handleHttpException$2 extends o implements Function2<AppFragment, CaptchaHelper$CaptchaPayload, Unit> {
    public final /* synthetic */ JoinArgs $args;
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildCaptchaUtilsKt$handleHttpException$2(Context context, JoinArgs joinArgs) {
        super(2);
        this.$context = context;
        this.$args = joinArgs;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        invoke2(appFragment, captchaHelper$CaptchaPayload);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppFragment appFragment, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        m.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
        m.checkNotNullParameter(captchaHelper$CaptchaPayload, "captchaPayload");
        GuildJoinHelperKt.joinGuild$default(this.$context, this.$args.getGuildId(), this.$args.isLurker(), this.$args.getSessionId(), this.$args.getDirectoryChannelId(), null, this.$args.getErrorClass(), this.$args.getSubscriptionHandler(), this.$args.getErrorHandler(), captchaHelper$CaptchaPayload, this.$args.getOnNext(), 32, null);
    }
}
