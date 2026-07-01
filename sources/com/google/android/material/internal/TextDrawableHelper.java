package com.google.android.material.internal;

import android.content.Context;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public class TextDrawableHelper {

    @Nullable
    private TextAppearance textAppearance;
    private float textWidth;
    private final TextPaint textPaint = new TextPaint(1);
    private final TextAppearanceFontCallback fontCallback = new TextDrawableHelper$a(this);
    private boolean textWidthDirty = true;

    @Nullable
    private WeakReference<TextDrawableHelper$TextDrawableDelegate> delegate = new WeakReference<>(null);

    public TextDrawableHelper(@Nullable TextDrawableHelper$TextDrawableDelegate textDrawableHelper$TextDrawableDelegate) {
        setDelegate(textDrawableHelper$TextDrawableDelegate);
    }

    public static /* synthetic */ boolean access$002(TextDrawableHelper textDrawableHelper, boolean z2) {
        textDrawableHelper.textWidthDirty = z2;
        return z2;
    }

    public static /* synthetic */ WeakReference access$100(TextDrawableHelper textDrawableHelper) {
        return textDrawableHelper.delegate;
    }

    private float calculateTextWidth(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.textPaint.measureText(charSequence, 0, charSequence.length());
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        return this.textAppearance;
    }

    @NonNull
    public TextPaint getTextPaint() {
        return this.textPaint;
    }

    public float getTextWidth(String str) {
        if (!this.textWidthDirty) {
            return this.textWidth;
        }
        float fCalculateTextWidth = calculateTextWidth(str);
        this.textWidth = fCalculateTextWidth;
        this.textWidthDirty = false;
        return fCalculateTextWidth;
    }

    public boolean isTextWidthDirty() {
        return this.textWidthDirty;
    }

    public void setDelegate(@Nullable TextDrawableHelper$TextDrawableDelegate textDrawableHelper$TextDrawableDelegate) {
        this.delegate = new WeakReference<>(textDrawableHelper$TextDrawableDelegate);
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance, Context context) {
        if (this.textAppearance != textAppearance) {
            this.textAppearance = textAppearance;
            if (textAppearance != null) {
                textAppearance.updateMeasureState(context, this.textPaint, this.fontCallback);
                TextDrawableHelper$TextDrawableDelegate textDrawableHelper$TextDrawableDelegate = this.delegate.get();
                if (textDrawableHelper$TextDrawableDelegate != null) {
                    this.textPaint.drawableState = textDrawableHelper$TextDrawableDelegate.getState();
                }
                textAppearance.updateDrawState(context, this.textPaint, this.fontCallback);
                this.textWidthDirty = true;
            }
            TextDrawableHelper$TextDrawableDelegate textDrawableHelper$TextDrawableDelegate2 = this.delegate.get();
            if (textDrawableHelper$TextDrawableDelegate2 != null) {
                textDrawableHelper$TextDrawableDelegate2.onTextSizeChange();
                textDrawableHelper$TextDrawableDelegate2.onStateChange(textDrawableHelper$TextDrawableDelegate2.getState());
            }
        }
    }

    public void setTextWidthDirty(boolean z2) {
        this.textWidthDirty = z2;
    }

    public void updateTextPaintDrawState(Context context) {
        this.textAppearance.updateDrawState(context, this.textPaint, this.fontCallback);
    }
}
