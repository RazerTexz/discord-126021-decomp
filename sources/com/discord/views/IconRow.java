package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import b.a.i.IconRowBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: IconRow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IconRow extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final IconRowBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.icon_row, this);
        int i = R.id.divider;
        View viewFindViewById = findViewById(R.id.divider);
        if (viewFindViewById != null) {
            i = R.id.image;
            ImageView imageView = (ImageView) findViewById(R.id.image);
            if (imageView != null) {
                i = R.id.text;
                TextView textView = (TextView) findViewById(R.id.text);
                if (textView != null) {
                    IconRowBinding iconRowBinding = new IconRowBinding(this, viewFindViewById, imageView, textView);
                    Intrinsics3.checkNotNullExpressionValue(iconRowBinding, "IconRowBinding.inflate(L…ater.from(context), this)");
                    this.binding = iconRowBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void setImageRes(@DrawableRes Integer imageRes) {
        if (imageRes != null) {
            this.binding.f73b.setImageResource(imageRes.intValue());
        }
        ImageView imageView = this.binding.f73b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.image");
        imageView.setVisibility(imageRes == null || imageRes.intValue() != 0 ? 0 : 8);
    }

    public final void setText(String text) {
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.text");
        FormatUtils.a(textView, text);
    }
}
