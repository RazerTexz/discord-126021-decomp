package com.discord.widgets.forums;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.utilities.drawable.DrawableCompat;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: ForumBrowserPostView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumBrowserPostView$cardPressHighlight$2 extends AbstractC12240o implements Function0<Drawable> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumBrowserPostView$cardPressHighlight$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Drawable invoke() {
        Context context = this.$context;
        return ContextCompat.getDrawable(context, DrawableCompat.getThemedDrawableRes$default(context, C5419R.attr.bg_pressed_highlight, 0, 2, (Object) null));
    }
}
