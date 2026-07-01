package com.discord.widgets.forums;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.discord.R;
import com.discord.utilities.drawable.DrawableCompat;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.forums.ForumBrowserPostView$cardPressHighlight$2, reason: use source file name */
/* JADX INFO: compiled from: ForumBrowserPostView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumBrowserPostView2 extends Lambda implements Function0<Drawable> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumBrowserPostView2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Drawable invoke() {
        Context context = this.$context;
        return ContextCompat.getDrawable(context, DrawableCompat.getThemedDrawableRes$default(context, R.attr.bg_pressed_highlight, 0, 2, (Object) null));
    }
}
