package com.discord.views.premium;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import p007b.p008a.p025i.C1011n1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ShinyButton.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShinyButton extends RelativeLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C1011n1 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShinyButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.shiny_button, this);
        int i = C5419R.id.button_container;
        LinearLayout linearLayout = (LinearLayout) findViewById(C5419R.id.button_container);
        if (linearLayout != null) {
            i = C5419R.id.icon;
            ImageView imageView = (ImageView) findViewById(C5419R.id.icon);
            if (imageView != null) {
                i = C5419R.id.text;
                TextView textView = (TextView) findViewById(C5419R.id.text);
                if (textView != null) {
                    C1011n1 c1011n1 = new C1011n1(this, linearLayout, imageView, textView);
                    C12238m.checkNotNullExpressionValue(c1011n1, "ShinyButtonBinding.infla…ater.from(context), this)");
                    this.binding = c1011n1;
                    if (attributeSet != null) {
                        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C5419R.a.ShinyButton, 0, 0);
                        try {
                            String string = typedArrayObtainStyledAttributes.getString(3);
                            if (string != null) {
                                C12238m.checkNotNullExpressionValue(string, "it");
                                setText(string);
                            }
                            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(2);
                            if (drawable != null) {
                                C12238m.checkNotNullExpressionValue(drawable, "it");
                                setDrawable(drawable);
                            }
                            setBackgroundTint(typedArrayObtainStyledAttributes.getColor(0, ColorCompat.getColor(context, C5419R.color.uikit_btn_bg_color_selector_green)));
                            int color = typedArrayObtainStyledAttributes.getColor(1, ColorCompat.getColor(context, C5419R.color.white));
                            setTextColor(color);
                            setDrawableColor(color);
                            return;
                        } finally {
                            typedArrayObtainStyledAttributes.recycle();
                        }
                    }
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        super.onLayout(changed, l, t, r, b2);
        if (changed) {
            LinearLayout linearLayout = this.binding.f1071b;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.buttonContainer");
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.width = getLayoutParams().width;
            layoutParams.height = getLayoutParams().height;
            LinearLayout linearLayout2 = this.binding.f1071b;
            C12238m.checkNotNullExpressionValue(linearLayout2, "binding.buttonContainer");
            linearLayout2.setLayoutParams(layoutParams);
        }
    }

    public final void setBackgroundTint(int color) {
        LinearLayout linearLayout = this.binding.f1071b;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.buttonContainer");
        linearLayout.getBackground().setTint(color);
    }

    public final void setDrawable(Drawable iconStart) {
        C12238m.checkNotNullParameter(iconStart, "iconStart");
        this.binding.f1072c.setImageDrawable(iconStart);
    }

    public final void setDrawableColor(int color) {
        ImageView imageView = this.binding.f1072c;
        C12238m.checkNotNullExpressionValue(imageView, "binding.icon");
        ColorCompatKt.tintWithColor(imageView, color);
    }

    public final void setText(String text) {
        C12238m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        TextView textView = this.binding.f1073d;
        C12238m.checkNotNullExpressionValue(textView, "binding.text");
        textView.setText(text);
    }

    public final void setTextColor(int color) {
        this.binding.f1073d.setTextColor(color);
    }
}
