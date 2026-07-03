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
import com.discord.C5419R;
import p007b.p008a.p025i.C0912a0;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: IconRow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IconRow extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C0912a0 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.icon_row, this);
        int i = C5419R.id.divider;
        View viewFindViewById = findViewById(C5419R.id.divider);
        if (viewFindViewById != null) {
            i = C5419R.id.image;
            ImageView imageView = (ImageView) findViewById(C5419R.id.image);
            if (imageView != null) {
                i = C5419R.id.text;
                TextView textView = (TextView) findViewById(C5419R.id.text);
                if (textView != null) {
                    C0912a0 c0912a0 = new C0912a0(this, viewFindViewById, imageView, textView);
                    C12238m.checkNotNullExpressionValue(c0912a0, "IconRowBinding.inflate(L…ater.from(context), this)");
                    this.binding = c0912a0;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void setImageRes(@DrawableRes Integer imageRes) {
        if (imageRes != null) {
            this.binding.f659b.setImageResource(imageRes.intValue());
        }
        ImageView imageView = this.binding.f659b;
        C12238m.checkNotNullExpressionValue(imageView, "binding.image");
        imageView.setVisibility(imageRes == null || imageRes.intValue() != 0 ? 0 : 8);
    }

    public final void setText(String text) {
        C12238m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        TextView textView = this.binding.f660c;
        C12238m.checkNotNullExpressionValue(textView, "binding.text");
        C1107b.m209a(textView, text);
    }
}
