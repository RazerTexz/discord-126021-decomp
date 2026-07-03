package com.discord.widgets.status;

import android.content.res.ColorStateList;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetForumPostStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatus$defaultReactionMeTextColor$2 extends AbstractC12240o implements Function0<ColorStateList> {
    public final /* synthetic */ WidgetForumPostStatus this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumPostStatus$defaultReactionMeTextColor$2(WidgetForumPostStatus widgetForumPostStatus) {
        super(0);
        this.this$0 = widgetForumPostStatus;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ColorStateList invoke() {
        return ContextCompat.getColorStateList(this.this$0.requireContext(), C5419R.color.status_red_500);
    }
}
