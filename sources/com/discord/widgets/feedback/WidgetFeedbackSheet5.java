package com.discord.widgets.feedback;

import com.discord.widgets.guild_delete_feedback.GuildDeleteFeedbackSheetViewModel;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$viewModelGuildDeleteFeedbackSheet$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFeedbackSheet5 extends Lambda implements Function0<GuildDeleteFeedbackSheetViewModel> {
    public final /* synthetic */ WidgetFeedbackSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFeedbackSheet5(WidgetFeedbackSheet widgetFeedbackSheet) {
        super(0);
        this.this$0 = widgetFeedbackSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildDeleteFeedbackSheetViewModel invoke() {
        return new GuildDeleteFeedbackSheetViewModel(this.this$0.getArgumentsOrDefault().getLong(WidgetFeedbackSheet.ARG_GUILD_DELETE_FEEDBACK_GUILD_ID));
    }
}
