package com.discord.widgets.status;

import android.content.res.ColorStateList;
import androidx.core.content.ContextCompat;
import com.discord.R;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatus$defaultReactionMeTextColor$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetForumPostStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatus3 extends Lambda implements Function0<ColorStateList> {
    public final /* synthetic */ WidgetForumPostStatus this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumPostStatus3(WidgetForumPostStatus widgetForumPostStatus) {
        super(0);
        this.this$0 = widgetForumPostStatus;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ColorStateList invoke() {
        return ContextCompat.getColorStateList(this.this$0.requireContext(), R.color.status_red_500);
    }
}
