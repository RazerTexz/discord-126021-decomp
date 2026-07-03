package com.discord.widgets.media;

import com.discord.player.AppMediaPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia$onViewBoundOrOnResume$$inlined$let$lambda$1 extends AbstractC12240o implements Function1<AppMediaPlayer.Event, Unit> {
    public final /* synthetic */ WidgetMedia this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMedia$onViewBoundOrOnResume$$inlined$let$lambda$1(WidgetMedia widgetMedia) {
        super(1);
        this.this$0 = widgetMedia;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AppMediaPlayer.Event event) {
        invoke2(event);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppMediaPlayer.Event event) {
        C12238m.checkNotNullParameter(event, "event");
        this.this$0.handlePlayerEvent(event);
    }
}
