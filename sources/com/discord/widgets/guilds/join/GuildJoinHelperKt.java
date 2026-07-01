package com.discord.widgets.guilds.join;

import android.content.Context;
import com.discord.api.guild.Guild;
import com.discord.restapi.RestAPIParams$InviteCode;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: GuildJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildJoinHelperKt {
    public static final void joinGuild(Context context, long j, boolean z2, String str, Long l, String str2, Class<?> cls, Function1<? super Subscription, Unit> function1, Function1<? super Error, Unit> function2, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, Function1<? super Guild, Unit> function3) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(cls, "errorClass");
        m.checkNotNullParameter(function3, "onNext");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().joinGuild(j, z2, str, l, new RestAPIParams$InviteCode(captchaHelper$CaptchaPayload != null ? captchaHelper$CaptchaPayload.getCaptchaKey() : null, captchaHelper$CaptchaPayload != null ? captchaHelper$CaptchaPayload.getCaptchaRqtoken() : null), str2), false, 1, null)), cls, (Context) null, function1, new GuildJoinHelperKt$joinGuild$1(context, j, z2, str, l, cls, function1, function2, function3), (Function0) null, (Function0) null, function3, 50, (Object) null);
    }

    public static /* synthetic */ void joinGuild$default(Context context, long j, boolean z2, String str, Long l, String str2, Class cls, Function1 function1, Function1 function2, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, Function1 function3, int i, Object obj) {
        joinGuild(context, j, z2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : str2, cls, (i & 128) != 0 ? null : function1, (i & 256) != 0 ? null : function2, (i & 512) != 0 ? null : captchaHelper$CaptchaPayload, function3);
    }
}
