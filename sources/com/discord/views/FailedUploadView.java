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
import com.discord.C5419R;
import com.discord.utilities.view.extensions.ViewExtensions;
import p007b.p008a.p025i.C0930c2;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: FailedUploadView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FailedUploadView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C0930c2 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FailedUploadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.view_chat_upload, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.display_name;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.display_name);
        if (textView != null) {
            i = C5419R.id.failed_alert_icon;
            ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.failed_alert_icon);
            if (imageView != null) {
                i = C5419R.id.file_image;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(C5419R.id.file_image);
                if (imageView2 != null) {
                    i = C5419R.id.subtitle_text;
                    TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.subtitle_text);
                    if (textView2 != null) {
                        C0930c2 c0930c2 = new C0930c2((ConstraintLayout) viewInflate, textView, imageView, imageView2, textView2);
                        C12238m.checkNotNullExpressionValue(c0930c2, "ViewChatUploadBinding.in…rom(context), this, true)");
                        this.binding = c0930c2;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: a */
    public final void m8544a(CharSequence title, @DrawableRes int iconResId, String subtitle) {
        C12238m.checkNotNullParameter(title, "title");
        TextView textView = this.binding.f739b;
        C12238m.checkNotNullExpressionValue(textView, "binding.displayName");
        textView.setText(title);
        TextView textView2 = this.binding.f741d;
        C12238m.checkNotNullExpressionValue(textView2, "binding.subtitleText");
        ViewExtensions.setTextAndVisibilityBy(textView2, subtitle);
        this.binding.f740c.setImageResource(iconResId);
    }
}
