package com.discord.utilities.voice;

import android.content.Context;
import com.discord.utilities.voice.DiscordOverlayService;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: DiscordOverlayService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiscordOverlayService$Companion$launchForConnect$2 extends AbstractC12240o implements Function1<String, Unit> {
    public final /* synthetic */ WeakReference $weakContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscordOverlayService$Companion$launchForConnect$2(WeakReference weakReference) {
        super(1);
        this.$weakContext = weakReference;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Context context = (Context) this.$weakContext.get();
        if (context != null) {
            DiscordOverlayService.Companion companion = DiscordOverlayService.INSTANCE;
            C12238m.checkNotNullExpressionValue(str, "action");
            DiscordOverlayService.Companion.tryStartOverlayService$default(companion, context, str, false, 4, null);
        }
    }
}
