package com.discord.widgets.user;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$tryLoad$3 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetUserMentions$Model$MessageLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMentions$Model$MessageLoader$tryLoad$3(WidgetUserMentions$Model$MessageLoader widgetUserMentions$Model$MessageLoader) {
        super(1);
        this.this$0 = widgetUserMentions$Model$MessageLoader;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        WidgetUserMentions$Model$MessageLoader.access$handleLoadError(this.this$0);
    }
}
