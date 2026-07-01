package com.discord.widgets.user;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$tryLoad$1 extends o implements Function1<WidgetUserMentions$Model$MessageLoader$LoadingState, WidgetUserMentions$Model$MessageLoader$LoadingState> {
    public static final WidgetUserMentions$Model$MessageLoader$tryLoad$1 INSTANCE = new WidgetUserMentions$Model$MessageLoader$tryLoad$1();

    public WidgetUserMentions$Model$MessageLoader$tryLoad$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserMentions$Model$MessageLoader$LoadingState invoke2(WidgetUserMentions$Model$MessageLoader$LoadingState widgetUserMentions$Model$MessageLoader$LoadingState) {
        m.checkNotNullParameter(widgetUserMentions$Model$MessageLoader$LoadingState, "it");
        return widgetUserMentions$Model$MessageLoader$LoadingState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserMentions$Model$MessageLoader$LoadingState invoke(WidgetUserMentions$Model$MessageLoader$LoadingState widgetUserMentions$Model$MessageLoader$LoadingState) {
        return invoke2(widgetUserMentions$Model$MessageLoader$LoadingState);
    }
}
