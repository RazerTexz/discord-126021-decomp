package com.discord.widgets.user.usersheet;

import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$viewModel$2 extends Lambda implements Function0<WidgetUserSheetViewModel> {
    public final /* synthetic */ WidgetUserSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheet$viewModel$2(WidgetUserSheet widgetUserSheet) {
        super(0);
        this.this$0 = widgetUserSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetUserSheetViewModel invoke() {
        long j = this.this$0.getArgumentsOrDefault().getLong("ARG_USER_ID");
        long j2 = this.this$0.getArgumentsOrDefault().getLong("ARG_CHANNEL_ID");
        long j3 = this.this$0.getArgumentsOrDefault().getLong("ARG_GUILD_ID");
        boolean z2 = this.this$0.getArgumentsOrDefault().getBoolean("ARG_IS_VOICE_CONTEXT");
        Serializable serializable = this.this$0.getArgumentsOrDefault().getSerializable("ARG_STREAM_PREVIEW_CLICK_BEHAVIOR");
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.user.usersheet.WidgetUserSheet.StreamPreviewClickBehavior");
        WidgetUserSheet.StreamPreviewClickBehavior streamPreviewClickBehavior = (WidgetUserSheet.StreamPreviewClickBehavior) serializable;
        return new WidgetUserSheetViewModel(j, j2, Long.valueOf(j3), this.this$0.getArgumentsOrDefault().getString("ARG_FRIEND_TOKEN"), z2, null, streamPreviewClickBehavior, null, null, null, null, null, null, null, null, 32672, null);
    }
}
