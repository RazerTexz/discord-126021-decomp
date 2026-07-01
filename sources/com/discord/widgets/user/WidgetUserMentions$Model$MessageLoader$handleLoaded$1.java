package com.discord.widgets.user;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$handleLoaded$1 extends o implements Function0<Unit> {
    public final /* synthetic */ boolean $isAllLoaded;
    public final /* synthetic */ WidgetUserMentions$Model$MessageLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMentions$Model$MessageLoader$handleLoaded$1(WidgetUserMentions$Model$MessageLoader widgetUserMentions$Model$MessageLoader, boolean z2) {
        super(0);
        this.this$0 = widgetUserMentions$Model$MessageLoader;
        this.$isAllLoaded = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.tryLoad(new WidgetUserMentions$Model$MessageLoader$handleLoaded$1$1(this));
    }
}
