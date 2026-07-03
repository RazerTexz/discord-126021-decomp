package com.discord.widgets.status;

import android.content.res.ColorStateList;
import com.discord.C5419R;
import com.discord.utilities.color.ColorCompat;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetForumPostStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatus$reactionMeTextColor$2 extends AbstractC12240o implements Function0<ColorStateList> {
    public final /* synthetic */ WidgetForumPostStatus this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumPostStatus$reactionMeTextColor$2(WidgetForumPostStatus widgetForumPostStatus) {
        super(0);
        this.this$0 = widgetForumPostStatus;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ColorStateList invoke() {
        return ColorStateList.valueOf(ColorCompat.getThemedColor(this.this$0.getContext(), C5419R.attr.colorHeaderPrimary));
    }
}
