package com.discord.widgets.guilds.join;

import android.content.Context;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.GuildCaptchaUtilsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildJoinHelperKt$joinGuild$1 extends o implements Function1<Error, Unit> {
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
    public GuildJoinHelperKt$joinGuild$1(Context context, long j, boolean z2, String str, Long l, Class cls, Function1 function1, Function1 function2, Function1 function3) {
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
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        GuildCaptchaUtilsKt.handleHttpException(error, this.$context, new JoinArgs(this.$guildId, this.$isLurker, this.$sessionId, this.$directoryChannelId, this.$errorClass, this.$subscriptionHandler, this.$errorHandler, this.$onNext));
    }
}
