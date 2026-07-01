package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import b.a.d.AppScreen2;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$Companion$launch$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShare3 extends Lambda implements Function1<Error, Unit> {
    public final /* synthetic */ Intent $arguments;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShare3(String str, Context context, Intent intent) {
        super(1);
        this.$source = str;
        this.$context = context;
        this.$arguments = intent;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        Intrinsics3.checkNotNullParameter(error, "it");
        AnalyticsTracker.openModal$default("Instant Invite Modal", this.$source, null, 4, null);
        AppScreen2.d(this.$context, WidgetGuildInviteShareEmptySuggestions.class, this.$arguments);
    }
}
