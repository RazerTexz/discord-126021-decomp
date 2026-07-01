package com.discord.widgets.tos;

import com.discord.utilities.intent.IntentUtilsKt;
import com.discord.widgets.tos.WidgetTosReportViolation;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTosReportViolation$args$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetTosReportViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolation2 extends Lambda implements Function0<WidgetTosReportViolation.Companion.Arguments> {
    public final /* synthetic */ WidgetTosReportViolation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetTosReportViolation2(WidgetTosReportViolation widgetTosReportViolation) {
        super(0);
        this.this$0 = widgetTosReportViolation;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetTosReportViolation.Companion.Arguments invoke() {
        return new WidgetTosReportViolation.Companion.Arguments(IntentUtilsKt.getStringExtraOrDefault$default(this.this$0.getMostRecentIntent(), "EXTRA_TARGET", null, 2, null), this.this$0.getMostRecentIntent().getLongExtra("EXTRA_CHANNEL_ID", 0L), this.this$0.getMostRecentIntent().getLongExtra("EXTRA_MESSAGE_ID", 0L));
    }
}
