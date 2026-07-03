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
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import p007b.p008a.p025i.C0924b4;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ToolbarTitleLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ToolbarTitleLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f19165j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final C0924b4 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolbarTitleLayout(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(C5419R.layout.view_toolbar_title, this);
        int i = C5419R.id.toolbar_icon;
        ImageView imageView = (ImageView) findViewById(C5419R.id.toolbar_icon);
        if (imageView != null) {
            i = C5419R.id.toolbar_presence;
            StatusView statusView = (StatusView) findViewById(C5419R.id.toolbar_presence);
            if (statusView != null) {
                i = C5419R.id.toolbar_title;
                TextView textView = (TextView) findViewById(C5419R.id.toolbar_title);
                if (textView != null) {
                    i = C5419R.id.toolbar_title_subtext;
                    TextView textView2 = (TextView) findViewById(C5419R.id.toolbar_title_subtext);
                    if (textView2 != null) {
                        i = C5419R.id.toolbar_title_trailing_icon;
                        ImageView imageView2 = (ImageView) findViewById(C5419R.id.toolbar_title_trailing_icon);
                        if (imageView2 != null) {
                            C0924b4 c0924b4 = new C0924b4(this, imageView, statusView, textView, textView2, imageView2);
                            C12238m.checkNotNullExpressionValue(c0924b4, "ViewToolbarTitleBinding.…ater.from(context), this)");
                            this.binding = c0924b4;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: a */
    public final void m8564a(CharSequence title, @DrawableRes Integer leftDrawableRes, @DrawableRes Integer trailingDrawableRes) {
        TextView textView = this.binding.f710d;
        C12238m.checkNotNullExpressionValue(textView, "binding.toolbarTitle");
        textView.setText(title);
        if (leftDrawableRes != null) {
            ImageView imageView = this.binding.f708b;
            Resources resources = getResources();
            int iIntValue = leftDrawableRes.intValue();
            Context context = getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, iIntValue, context.getTheme()));
            ImageView imageView2 = this.binding.f708b;
            C12238m.checkNotNullExpressionValue(imageView2, "binding.toolbarIcon");
            imageView2.setVisibility(0);
        } else {
            ImageView imageView3 = this.binding.f708b;
            C12238m.checkNotNullExpressionValue(imageView3, "binding.toolbarIcon");
            imageView3.setVisibility(8);
        }
        if (trailingDrawableRes == null) {
            ImageView imageView4 = this.binding.f712f;
            C12238m.checkNotNullExpressionValue(imageView4, "binding.toolbarTitleTrailingIcon");
            imageView4.setVisibility(8);
            return;
        }
        ImageView imageView5 = this.binding.f712f;
        Resources resources2 = getResources();
        int iIntValue2 = trailingDrawableRes.intValue();
        Context context2 = getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        imageView5.setImageDrawable(ResourcesCompat.getDrawable(resources2, iIntValue2, context2.getTheme()));
        ImageView imageView6 = this.binding.f712f;
        C12238m.checkNotNullExpressionValue(imageView6, "binding.toolbarTitleTrailingIcon");
        imageView6.setVisibility(0);
    }

    public final TextView getTitle() {
        TextView textView = this.binding.f710d;
        C12238m.checkNotNullExpressionValue(textView, "binding.toolbarTitle");
        return textView;
    }

    public final void setSubtitle(CharSequence subtitle) {
        TextView textView = this.binding.f711e;
        C12238m.checkNotNullExpressionValue(textView, "binding.toolbarTitleSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView, subtitle);
    }

    public final void setTitleColor(@ColorInt int color) {
        this.binding.f710d.setTextColor(color);
    }
}
