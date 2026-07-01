package com.discord.widgets.voice.controls;

import android.content.Context;
import android.content.Intent;
import com.discord.utilities.voice.VoiceEngineServiceController;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$Companion;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetScreenShareNfxSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetScreenShareNfxSheet$onActivityResult$1 extends o implements Function1<Intent, Unit> {
    public final /* synthetic */ WidgetScreenShareNfxSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetScreenShareNfxSheet$onActivityResult$1(WidgetScreenShareNfxSheet widgetScreenShareNfxSheet) {
        super(1);
        this.this$0 = widgetScreenShareNfxSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
        invoke2(intent);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Intent intent) {
        m.checkNotNullParameter(intent, "it");
        VoiceEngineServiceController.Companion.getINSTANCE().startStream(intent);
        if (!this.this$0.requireAppActivity().h(a0.getOrCreateKotlinClass(WidgetCallFullscreen.class))) {
            WidgetCallFullscreen$Companion widgetCallFullscreen$Companion = WidgetCallFullscreen.Companion;
            Context contextRequireContext = this.this$0.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetCallFullscreen$Companion.launch$default(widgetCallFullscreen$Companion, contextRequireContext, this.this$0.requireArguments().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID"), false, null, null, 28, null);
        }
        this.this$0.dismiss();
    }
}
