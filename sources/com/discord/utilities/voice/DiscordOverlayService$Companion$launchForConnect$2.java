package com.discord.utilities.voice;

import android.content.Context;
import d0.z.d.m;
import d0.z.d.o;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DiscordOverlayService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiscordOverlayService$Companion$launchForConnect$2 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WeakReference $weakContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscordOverlayService$Companion$launchForConnect$2(WeakReference weakReference) {
        super(1);
        this.$weakContext = weakReference;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Context context = (Context) this.$weakContext.get();
        if (context != null) {
            DiscordOverlayService$Companion discordOverlayService$Companion = DiscordOverlayService.Companion;
            m.checkNotNullExpressionValue(str, "action");
            DiscordOverlayService$Companion.tryStartOverlayService$default(discordOverlayService$Companion, context, str, false, 4, null);
        }
    }
}
