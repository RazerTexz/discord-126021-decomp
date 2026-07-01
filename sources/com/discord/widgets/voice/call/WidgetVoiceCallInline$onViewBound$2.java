package com.discord.widgets.voice.call;

import com.discord.stores.StoreStream;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallInline$onViewBound$2 extends o implements Function1<Boolean, Unit> {
    public static final WidgetVoiceCallInline$onViewBound$2 INSTANCE = new WidgetVoiceCallInline$onViewBound$2();

    public WidgetVoiceCallInline$onViewBound$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        StoreStream.Companion.getMediaEngine().setPttActive(z2);
    }
}
