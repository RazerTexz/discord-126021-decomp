package com.discord.widgets.user;

import com.discord.models.message.Message;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$tryLoad$4 extends o implements Function1<List<? extends Message>, Unit> {
    public final /* synthetic */ WidgetUserMentions$Model$MessageLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMentions$Model$MessageLoader$tryLoad$4(WidgetUserMentions$Model$MessageLoader widgetUserMentions$Model$MessageLoader) {
        super(1);
        this.this$0 = widgetUserMentions$Model$MessageLoader;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Message> list) {
        invoke2((List<Message>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Message> list) {
        WidgetUserMentions$Model$MessageLoader widgetUserMentions$Model$MessageLoader = this.this$0;
        m.checkNotNullExpressionValue(list, "it");
        WidgetUserMentions$Model$MessageLoader.access$handleLoaded(widgetUserMentions$Model$MessageLoader, list);
    }
}
