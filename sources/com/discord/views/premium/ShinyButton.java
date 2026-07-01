package com.discord.views.premium;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup$LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.a.i.n1;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import d0.z.d.m;

/* JADX INFO: compiled from: ShinyButton.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShinyButton extends RelativeLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final n1 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShinyButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R$layout.shiny_button, this);
        int i = R$id.button_container;
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.button_container);
        if (linearLayout != null) {
            i = 2131364017;
            ImageView imageView = (ImageView) findViewById(2131364017);
            if (imageView != null) {
                i = 2131365767;
                TextView textView = (TextView) findViewById(2131365767);
                if (textView != null) {
                    n1 n1Var = new n1(this, linearLayout, imageView, textView);
                    m.checkNotNullExpressionValue(n1Var, "ShinyButtonBinding.infla…ater.from(context), this)");
                    this.binding = n1Var;
                    if (attributeSet != null) {
                        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$a.ShinyButton, 0, 0);
                        try {
                            String string = typedArrayObtainStyledAttributes.getString(3);
                            if (string != null) {
                                m.checkNotNullExpressionValue(string, "it");
                                setText(string);
                            }
                            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(2);
                            if (drawable != null) {
                                m.checkNotNullExpressionValue(drawable, "it");
                                setDrawable(drawable);
                            }
                            setBackgroundTint(typedArrayObtainStyledAttributes.getColor(0, ColorCompat.getColor(context, 2131100471)));
                            int color = typedArrayObtainStyledAttributes.getColor(1, ColorCompat.getColor(context, 2131100487));
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
            m.checkNotNullExpressionValue(linearLayout, "binding.buttonContainer");
            ViewGroup$LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.width = getLayoutParams().width;
            layoutParams.height = getLayoutParams().height;
            LinearLayout linearLayout2 = this.binding.f165b;
            m.checkNotNullExpressionValue(linearLayout2, "binding.buttonContainer");
            linearLayout2.setLayoutParams(layoutParams);
        }
    }

    public final void setBackgroundTint(int color) {
        LinearLayout linearLayout = this.binding.f165b;
        m.checkNotNullExpressionValue(linearLayout, "binding.buttonContainer");
        linearLayout.getBackground().setTint(color);
    }

    public final void setDrawable(Drawable iconStart) {
        m.checkNotNullParameter(iconStart, "iconStart");
        this.binding.c.setImageDrawable(iconStart);
    }

    public final void setDrawableColor(int color) {
        ImageView imageView = this.binding.c;
        m.checkNotNullExpressionValue(imageView, "binding.icon");
        ColorCompatKt.tintWithColor(imageView, color);
    }

    public final void setText(String text) {
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.text");
        textView.setText(text);
    }

    public final void setTextColor(int color) {
        this.binding.d.setTextColor(color);
    }
}
