package com.discord.widgets.media;

import com.discord.player.AppMediaPlayer$Event;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia$onViewBoundOrOnResume$$inlined$let$lambda$1 extends o implements Function1<AppMediaPlayer$Event, Unit> {
    public final /* synthetic */ WidgetMedia this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMedia$onViewBoundOrOnResume$$inlined$let$lambda$1(WidgetMedia widgetMedia) {
        super(1);
        this.this$0 = widgetMedia;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AppMediaPlayer$Event appMediaPlayer$Event) {
        invoke2(appMediaPlayer$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppMediaPlayer$Event appMediaPlayer$Event) {
        m.checkNotNullParameter(appMediaPlayer$Event, "event");
        WidgetMedia.access$handlePlayerEvent(this.this$0, appMediaPlayer$Event);
    }
}
