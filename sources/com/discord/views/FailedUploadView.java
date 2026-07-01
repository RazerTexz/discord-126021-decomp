package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.ViewChatUploadBinding;
import com.discord.R;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: FailedUploadView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FailedUploadView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ViewChatUploadBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FailedUploadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_chat_upload, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.display_name;
        TextView textView = (TextView) viewInflate.findViewById(R.id.display_name);
        if (textView != null) {
            i = R.id.failed_alert_icon;
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.failed_alert_icon);
            if (imageView != null) {
                i = R.id.file_image;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.file_image);
                if (imageView2 != null) {
                    i = R.id.subtitle_text;
                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.subtitle_text);
                    if (textView2 != null) {
                        ViewChatUploadBinding viewChatUploadBinding = new ViewChatUploadBinding((ConstraintLayout) viewInflate, textView, imageView, imageView2, textView2);
                        Intrinsics3.checkNotNullExpressionValue(viewChatUploadBinding, "ViewChatUploadBinding.in…rom(context), this, true)");
                        this.binding = viewChatUploadBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void a(CharSequence title, @DrawableRes int iconResId, String subtitle) {
        Intrinsics3.checkNotNullParameter(title, "title");
        TextView textView = this.binding.f91b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.displayName");
        textView.setText(title);
        TextView textView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.subtitleText");
        ViewExtensions.setTextAndVisibilityBy(textView2, subtitle);
        this.binding.c.setImageResource(iconResId);
    }
}
