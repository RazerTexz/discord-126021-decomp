package com.discord.widgets.voice.call;

import android.content.Context;
import com.discord.stores.StoreStream;
import com.discord.widgets.notice.WidgetNoticeNuxOverlay;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallLaunchUtilsKt$callAndLaunch$1$5 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ PrivateCallLaunchUtilsKt$callAndLaunch$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateCallLaunchUtilsKt$callAndLaunch$1$5(PrivateCallLaunchUtilsKt$callAndLaunch$1 privateCallLaunchUtilsKt$callAndLaunch$1) {
        super(1);
        this.this$0 = privateCallLaunchUtilsKt$callAndLaunch$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        Context context;
        if (l.longValue() <= 0 || (context = (Context) this.this$0.$weakContext.get()) == null) {
            return;
        }
        WidgetCallFullscreen$Companion widgetCallFullscreen$Companion = WidgetCallFullscreen.Companion;
        m.checkNotNullExpressionValue(context, "it");
        m.checkNotNullExpressionValue(l, "voiceChannelId");
        WidgetCallFullscreen$Companion.launch$default(widgetCallFullscreen$Companion, context, l.longValue(), false, null, null, 28, null);
        if (StoreStream.Companion.getUserSettings().getIsMobileOverlayEnabled()) {
            return;
        }
        WidgetNoticeNuxOverlay.Companion.enqueue();
    }
}
