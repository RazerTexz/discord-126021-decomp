package com.discord.widgets.voice.sheet;

import com.discord.utilities.streams.StreamContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheet$onStreamPreviewClickedListener$1 extends AbstractC12240o implements Function1<StreamContext, Unit> {
    public static final WidgetVoiceBottomSheet$onStreamPreviewClickedListener$1 INSTANCE = new WidgetVoiceBottomSheet$onStreamPreviewClickedListener$1();

    public WidgetVoiceBottomSheet$onStreamPreviewClickedListener$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StreamContext streamContext) {
        invoke2(streamContext);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StreamContext streamContext) {
        C12238m.checkNotNullParameter(streamContext, "it");
    }
}
