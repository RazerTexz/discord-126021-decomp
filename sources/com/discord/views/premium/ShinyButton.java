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
import b.a.i.ShinyButtonBinding;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ShinyButton.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShinyButton extends RelativeLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ShinyButtonBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShinyButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.shiny_button, this);
        int i = R.id.button_container;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.button_container);
        if (linearLayout != null) {
            i = R.id.icon;
            ImageView imageView = (ImageView) findViewById(R.id.icon);
            if (imageView != null) {
                i = R.id.text;
                TextView textView = (TextView) findViewById(R.id.text);
                if (textView != null) {
                    ShinyButtonBinding shinyButtonBinding = new ShinyButtonBinding(this, linearLayout, imageView, textView);
                    Intrinsics3.checkNotNullExpressionValue(shinyButtonBinding, "ShinyButtonBinding.infla…ater.from(context), this)");
                    this.binding = shinyButtonBinding;
                    if (attributeSet != null) {
                        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.a.ShinyButton, 0, 0);
                        try {
                            String string = typedArrayObtainStyledAttributes.getString(3);
                            if (string != null) {
                                Intrinsics3.checkNotNullExpressionValue(string, "it");
                                setText(string);
                            }
                            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(2);
                            if (drawable != null) {
                                Intrinsics3.checkNotNullExpressionValue(drawable, "it");
                                setDrawable(drawable);
                            }
                            setBackgroundTint(typedArrayObtainStyledAttributes.getColor(0, ColorCompat.getColor(context, R.color.uikit_btn_bg_color_selector_green)));
                            int color = typedArrayObtainStyledAttributes.getColor(1, ColorCompat.getColor(context, R.color.white));
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
            LinearLayout linearLayout = this.binding.f165b;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.buttonContainer");
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.width = getLayoutParams().width;
            layoutParams.height = getLayoutParams().height;
            LinearLayout linearLayout2 = this.binding.f165b;
            Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.buttonContainer");
            linearLayout2.setLayoutParams(layoutParams);
        }
    }

    public final void setBackgroundTint(int color) {
        LinearLayout linearLayout = this.binding.f165b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.buttonContainer");
        linearLayout.getBackground().setTint(color);
    }

    public final void setDrawable(Drawable iconStart) {
        Intrinsics3.checkNotNullParameter(iconStart, "iconStart");
        this.binding.c.setImageDrawable(iconStart);
    }

    public final void setDrawableColor(int color) {
        ImageView imageView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.icon");
        ColorCompat2.tintWithColor(imageView, color);
    }

    public final void setText(String text) {
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.text");
        textView.setText(text);
    }

    public final void setTextColor(int color) {
        this.binding.d.setTextColor(color);
    }
}
