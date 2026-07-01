package com.discord.widgets.channels;

import com.discord.utilities.intent.IntentUtilsKt;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannel$categoryId$2 extends o implements Function0<Long> {
    public final /* synthetic */ WidgetCreateChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreateChannel$categoryId$2(WidgetCreateChannel widgetCreateChannel) {
        super(0);
        this.this$0 = widgetCreateChannel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return IntentUtilsKt.getLongExtraOrNull(this.this$0.getMostRecentIntent(), "INTENT_CATEGORY_ID");
    }
}
