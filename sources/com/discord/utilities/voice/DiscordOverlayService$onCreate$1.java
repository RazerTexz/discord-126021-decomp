package com.discord.utilities.voice;

import android.view.View;
import b.a.y.w;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DiscordOverlayService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiscordOverlayService$onCreate$1 extends o implements Function1<View, Unit> {
    public static final DiscordOverlayService$onCreate$1 INSTANCE = new DiscordOverlayService$onCreate$1();

    public DiscordOverlayService$onCreate$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        if (view instanceof w) {
            StoreStream.Companion.getAnalytics().onOverlayVoiceEvent(true);
        }
    }
}
