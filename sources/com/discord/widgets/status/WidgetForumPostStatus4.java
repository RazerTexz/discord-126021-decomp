package com.discord.widgets.status;

import android.content.res.ColorStateList;
import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatus$reactionMeTextColor$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetForumPostStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatus4 extends Lambda implements Function0<ColorStateList> {
    public final /* synthetic */ WidgetForumPostStatus this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumPostStatus4(WidgetForumPostStatus widgetForumPostStatus) {
        super(0);
        this.this$0 = widgetForumPostStatus;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ColorStateList invoke() {
        return ColorStateList.valueOf(ColorCompat.getThemedColor(this.this$0.getContext(), R.attr.colorHeaderPrimary));
    }
}
