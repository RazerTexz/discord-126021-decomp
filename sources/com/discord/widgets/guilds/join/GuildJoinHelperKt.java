package com.discord.widgets.guilds.join;

import android.content.Context;
import com.discord.api.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.GuildCaptchaUtilsKt;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: GuildJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildJoinHelperKt {

    /* JADX INFO: renamed from: com.discord.widgets.guilds.join.GuildJoinHelperKt$joinGuild$1 */
    /* JADX INFO: compiled from: GuildJoinHelper.kt */
    public static final class C87161 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ Long $directoryChannelId;
        public final /* synthetic */ Class $errorClass;
        public final /* synthetic */ Function1 $errorHandler;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ boolean $isLurker;
        public final /* synthetic */ Function1 $onNext;
        public final /* synthetic */ String $sessionId;
        public final /* synthetic */ Function1 $subscriptionHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C87161(Context context, long j, boolean z2, String str, Long l, Class cls, Function1 function1, Function1 function2, Function1 function3) {
            super(1);
            this.$context = context;
            this.$guildId = j;
            this.$isLurker = z2;
            this.$sessionId = str;
            this.$directoryChannelId = l;
            this.$errorClass = cls;
            this.$subscriptionHandler = function1;
            this.$errorHandler = function2;
            this.$onNext = function3;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            GuildCaptchaUtilsKt.handleHttpException(error, this.$context, new JoinArgs(this.$guildId, this.$isLurker, this.$sessionId, this.$directoryChannelId, this.$errorClass, this.$subscriptionHandler, this.$errorHandler, this.$onNext));
        }
    }

    public static final void joinGuild(Context context, long j, boolean z2, String str, Long l, String str2, Class<?> cls, Function1<? super Subscription, Unit> function1, Function1<? super Error, Unit> function2, CaptchaHelper.CaptchaPayload captchaPayload, Function1<? super Guild, Unit> function3) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(cls, "errorClass");
        C12238m.checkNotNullParameter(function3, "onNext");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().joinGuild(j, z2, str, l, new RestAPIParams.InviteCode(captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), str2), false, 1, null)), (Class<?>) cls, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : function1), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C87161(context, j, z2, str, l, cls, function1, function2, function3)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), function3);
    }
}
