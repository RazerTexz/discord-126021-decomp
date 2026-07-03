package com.discord.widgets.forums;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetForumGuidelinesBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumGuidelinesBottomSheet$requestKey$2 extends AbstractC12240o implements Function0<String> {
    public final /* synthetic */ WidgetForumGuidelinesBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumGuidelinesBottomSheet$requestKey$2(WidgetForumGuidelinesBottomSheet widgetForumGuidelinesBottomSheet) {
        super(0);
        this.this$0 = widgetForumGuidelinesBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.requireArguments().getString("INTENT_EXTRA_REQUEST_KEY", "");
    }
}
