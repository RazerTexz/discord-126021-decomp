package com.discord.widgets.channels;

import com.discord.widgets.chat.WidgetUrlActions;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelTopic$getRenderedTopicForTopic$renderContext$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopic3 extends Lambda implements Function1<String, Unit> {
    public static final WidgetChannelTopic3 INSTANCE = new WidgetChannelTopic3();

    public WidgetChannelTopic3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "url");
        WidgetUrlActions.INSTANCE.requestNotice(str);
    }
}
