package com.discord.views;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import b.a.i.b4;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.m;

/* JADX INFO: compiled from: ToolbarTitleLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ToolbarTitleLayout extends ConstraintLayout {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final b4 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolbarTitleLayout(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R$layout.view_toolbar_title, this);
        int i = R$id.toolbar_icon;
        ImageView imageView = (ImageView) findViewById(R$id.toolbar_icon);
        if (imageView != null) {
            i = R$id.toolbar_presence;
            StatusView statusView = (StatusView) findViewById(R$id.toolbar_presence);
            if (statusView != null) {
                i = R$id.toolbar_title;
                TextView textView = (TextView) findViewById(R$id.toolbar_title);
                if (textView != null) {
                    i = R$id.toolbar_title_subtext;
                    TextView textView2 = (TextView) findViewById(R$id.toolbar_title_subtext);
                    if (textView2 != null) {
                        i = R$id.toolbar_title_trailing_icon;
                        ImageView imageView2 = (ImageView) findViewById(R$id.toolbar_title_trailing_icon);
                        if (imageView2 != null) {
                            b4 b4Var = new b4(this, imageView, statusView, textView, textView2, imageView2);
                            m.checkNotNullExpressionValue(b4Var, "ViewToolbarTitleBinding.…ater.from(context), this)");
                            this.binding = b4Var;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void a(CharSequence title, @DrawableRes Integer leftDrawableRes, @DrawableRes Integer trailingDrawableRes) {
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.toolbarTitle");
        textView.setText(title);
        if (leftDrawableRes != null) {
            ImageView imageView = this.binding.f85b;
            Resources resources = getResources();
            int iIntValue = leftDrawableRes.intValue();
            Context context = getContext();
            m.checkNotNullExpressionValue(context, "context");
            imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, iIntValue, context.getTheme()));
            ImageView imageView2 = this.binding.f85b;
            m.checkNotNullExpressionValue(imageView2, "binding.toolbarIcon");
            imageView2.setVisibility(0);
        } else {
            ImageView imageView3 = this.binding.f85b;
            m.checkNotNullExpressionValue(imageView3, "binding.toolbarIcon");
            imageView3.setVisibility(8);
        }
        if (trailingDrawableRes == null) {
            ImageView imageView4 = this.binding.f;
            m.checkNotNullExpressionValue(imageView4, "binding.toolbarTitleTrailingIcon");
            imageView4.setVisibility(8);
            return;
        }
        ImageView imageView5 = this.binding.f;
        Resources resources2 = getResources();
        int iIntValue2 = trailingDrawableRes.intValue();
        Context context2 = getContext();
        m.checkNotNullExpressionValue(context2, "context");
        imageView5.setImageDrawable(ResourcesCompat.getDrawable(resources2, iIntValue2, context2.getTheme()));
        ImageView imageView6 = this.binding.f;
        m.checkNotNullExpressionValue(imageView6, "binding.toolbarTitleTrailingIcon");
        imageView6.setVisibility(0);
    }

    public final TextView getTitle() {
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.toolbarTitle");
        return textView;
    }

    public final void setSubtitle(CharSequence subtitle) {
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.toolbarTitleSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView, subtitle);
    }

    public final void setTitleColor(@ColorInt int color) {
        this.binding.d.setTextColor(color);
    }
}
