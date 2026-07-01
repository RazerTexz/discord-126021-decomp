package com.discord.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.ColorInt;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.a.i.n2;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;

/* JADX INFO: compiled from: LoadingButton.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LoadingButton extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final n2 binding;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public float disabledAlpha;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public CharSequence buttonText;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Drawable buttonIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code duplicated, block: B:46:0x0132 A[Catch: all -> 0x014f, TryCatch #0 {all -> 0x014f, blocks: (B:9:0x0052, B:11:0x0063, B:12:0x0066, B:15:0x006e, B:16:0x0074, B:18:0x0081, B:19:0x0084, B:21:0x00d2, B:22:0x00d8, B:24:0x00e1, B:25:0x00e7, B:44:0x0125, B:46:0x0132, B:47:0x0135, B:51:0x0148, B:50:0x0146, B:28:0x00f2, B:29:0x00f6, B:31:0x00fa, B:34:0x0105, B:37:0x010f, B:40:0x011a), top: B:59:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0143  */
    /* JADX WARN: Code duplicated, block: B:50:0x0146 A[Catch: all -> 0x014f, TryCatch #0 {all -> 0x014f, blocks: (B:9:0x0052, B:11:0x0063, B:12:0x0066, B:15:0x006e, B:16:0x0074, B:18:0x0081, B:19:0x0084, B:21:0x00d2, B:22:0x00d8, B:24:0x00e1, B:25:0x00e7, B:44:0x0125, B:46:0x0132, B:47:0x0135, B:51:0x0148, B:50:0x0146, B:28:0x00f2, B:29:0x00f6, B:31:0x00fa, B:34:0x0105, B:37:0x010f, B:40:0x011a), top: B:59:0x0052 }] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public LoadingButton(Context context, AttributeSet attributeSet) {
        int color;
        float f;
        super(context, attributeSet, 0);
        int i = 4;
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_loading_button, this);
        int i2 = R$id.loading_button_button;
        MaterialButton materialButton = (MaterialButton) findViewById(R$id.loading_button_button);
        if (materialButton != null) {
            i2 = R$id.loading_button_progress;
            ProgressBar progressBar = (ProgressBar) findViewById(R$id.loading_button_progress);
            if (progressBar != null) {
                n2 n2Var = new n2(this, materialButton, progressBar);
                m.checkNotNullExpressionValue(n2Var, "ViewLoadingButtonBinding…ater.from(context), this)");
                this.binding = n2Var;
                this.disabledAlpha = 0.2f;
                setClickable(true);
                setFocusable(true);
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$a.LoadingButton, 0, 0);
                    m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…able.LoadingButton, 0, 0)");
                    try {
                        String string = typedArrayObtainStyledAttributes.getString(8);
                        setText(string);
                        this.buttonText = string;
                        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(9);
                        if (colorStateList != null) {
                            materialButton.setTextColor(colorStateList);
                        }
                        ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(0);
                        if (colorStateList2 != null) {
                            m.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                            materialButton.setBackgroundTintList(colorStateList2);
                        }
                        float dimension = typedArrayObtainStyledAttributes.getDimension(10, -1.0f);
                        if (dimension > 0) {
                            materialButton.setTextSize(0, dimension);
                        }
                        m.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, materialButton.getPaddingTop());
                        m.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        int paddingLeft = materialButton.getPaddingLeft();
                        m.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        int paddingRight = materialButton.getPaddingRight();
                        m.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        materialButton.setPadding(paddingLeft, dimensionPixelSize, paddingRight, materialButton.getPaddingBottom());
                        m.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, materialButton.getPaddingBottom());
                        m.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        int paddingLeft2 = materialButton.getPaddingLeft();
                        m.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        int paddingTop = materialButton.getPaddingTop();
                        m.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        materialButton.setPadding(paddingLeft2, paddingTop, materialButton.getPaddingRight(), dimensionPixelSize2);
                        if (typedArrayObtainStyledAttributes.getBoolean(1, false)) {
                            m.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                            materialButton.setStateListAnimator(null);
                        }
                        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(3);
                        this.buttonIcon = drawable;
                        if (drawable != null) {
                            m.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                            materialButton.setIcon(drawable);
                        }
                        String string2 = typedArrayObtainStyledAttributes.getString(4);
                        m.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        if (string2 != null) {
                            switch (string2.hashCode()) {
                                case -1417863058:
                                    if (string2.equals("textEnd")) {
                                    }
                                    break;
                                case -1048657099:
                                    if (string2.equals("textStart")) {
                                        i = 2;
                                    }
                                    break;
                                case 100571:
                                    if (string2.equals("end")) {
                                        i = 3;
                                    }
                                    break;
                                case 109757538:
                                    if (string2.equals("start")) {
                                        i = 1;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            materialButton.setIconGravity(i);
                            color = typedArrayObtainStyledAttributes.getColor(7, Integer.MAX_VALUE);
                            if (color != Integer.MAX_VALUE) {
                                setProgressBarColor(color);
                            }
                            this.disabledAlpha = typedArrayObtainStyledAttributes.getFloat(2, this.disabledAlpha);
                            if (isEnabled()) {
                                f = 1.0f;
                            } else {
                                f = this.disabledAlpha;
                            }
                            setAlpha(f);
                            return;
                        }
                        i = 0;
                        materialButton.setIconGravity(i);
                        color = typedArrayObtainStyledAttributes.getColor(7, Integer.MAX_VALUE);
                        if (color != Integer.MAX_VALUE) {
                            setProgressBarColor(color);
                        }
                        this.disabledAlpha = typedArrayObtainStyledAttributes.getFloat(2, this.disabledAlpha);
                        if (isEnabled()) {
                            f = 1.0f;
                        } else {
                            f = this.disabledAlpha;
                        }
                        setAlpha(f);
                        return;
                    } finally {
                        typedArrayObtainStyledAttributes.recycle();
                    }
                }
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }

    private final void setProgressBarColor(@ColorInt int color) {
        ProgressBar progressBar = this.binding.c;
        m.checkNotNullExpressionValue(progressBar, "binding.loadingButtonProgress");
        progressBar.getIndeterminateDrawable().setColorFilter(color, PorterDuff$Mode.SRC_IN);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int colorInt) {
        MaterialButton materialButton = this.binding.f166b;
        m.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
        materialButton.setBackgroundTintList(ColorStateList.valueOf(colorInt));
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        MaterialButton materialButton = this.binding.f166b;
        m.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
        materialButton.setEnabled(enabled);
        setAlpha(isEnabled() ? 1.0f : this.disabledAlpha);
    }

    public final void setIconVisibility(boolean visible) {
        if (visible) {
            MaterialButton materialButton = this.binding.f166b;
            m.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
            materialButton.setIcon(this.buttonIcon);
        } else {
            MaterialButton materialButton2 = this.binding.f166b;
            m.checkNotNullExpressionValue(materialButton2, "binding.loadingButtonButton");
            materialButton2.setIcon(null);
        }
    }

    public final void setIsLoading(boolean isLoading) {
        if (!isLoading) {
            setClickable(true);
            MaterialButton materialButton = this.binding.f166b;
            m.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
            materialButton.setText(this.buttonText);
            MaterialButton materialButton2 = this.binding.f166b;
            m.checkNotNullExpressionValue(materialButton2, "binding.loadingButtonButton");
            materialButton2.setIcon(this.buttonIcon);
            ProgressBar progressBar = this.binding.c;
            m.checkNotNullExpressionValue(progressBar, "binding.loadingButtonProgress");
            progressBar.setVisibility(8);
            return;
        }
        setClickable(false);
        MaterialButton materialButton3 = this.binding.f166b;
        m.checkNotNullExpressionValue(materialButton3, "binding.loadingButtonButton");
        this.buttonText = materialButton3.getText().toString();
        MaterialButton materialButton4 = this.binding.f166b;
        m.checkNotNullExpressionValue(materialButton4, "binding.loadingButtonButton");
        materialButton4.setText((CharSequence) null);
        MaterialButton materialButton5 = this.binding.f166b;
        m.checkNotNullExpressionValue(materialButton5, "binding.loadingButtonButton");
        materialButton5.setIcon(null);
        ProgressBar progressBar2 = this.binding.c;
        m.checkNotNullExpressionValue(progressBar2, "binding.loadingButtonProgress");
        progressBar2.setVisibility(0);
    }

    public final void setText(CharSequence text) {
        this.buttonText = text;
        MaterialButton materialButton = this.binding.f166b;
        m.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
        ProgressBar progressBar = this.binding.c;
        m.checkNotNullExpressionValue(progressBar, "binding.loadingButtonProgress");
        if (progressBar.getVisibility() == 0) {
            text = null;
        }
        materialButton.setText(text);
    }
}
