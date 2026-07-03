package com.discord.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import p007b.p008a.p025i.C0932c4;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UploadProgressView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UploadProgressView extends ConstraintLayout {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f19167j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final C0932c4 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Drawable drawableComplete;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Drawable drawableInProgress;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.view_upload_progress, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.progress_bar;
        ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(C5419R.id.progress_bar);
        if (progressBar != null) {
            i = C5419R.id.progress_file_image;
            ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.progress_file_image);
            if (imageView != null) {
                i = C5419R.id.progress_subtext;
                TextView textView = (TextView) viewInflate.findViewById(C5419R.id.progress_subtext);
                if (textView != null) {
                    i = C5419R.id.progress_text;
                    TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.progress_text);
                    if (textView2 != null) {
                        C0932c4 c0932c4 = new C0932c4((ConstraintLayout) viewInflate, progressBar, imageView, textView, textView2);
                        C12238m.checkNotNullExpressionValue(c0932c4, "ViewUploadProgressBindin…rom(context), this, true)");
                        this.binding = c0932c4;
                        this.drawableComplete = ContextCompat.getDrawable(getContext(), C5419R.drawable.drawable_progress_green);
                        this.drawableInProgress = ContextCompat.getDrawable(getContext(), DrawableCompat.getThemedDrawableRes$default(this, C5419R.attr.progress_gradient, 0, 2, (Object) null));
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: a */
    public final void m8565a(CharSequence title, int progress, String subtitle) {
        C12238m.checkNotNullParameter(title, "title");
        C0932c4 c0932c4 = this.binding;
        TextView textView = c0932c4.f750e;
        C12238m.checkNotNullExpressionValue(textView, "progressText");
        textView.setText(title);
        if (progress >= 0) {
            ProgressBar progressBar = c0932c4.f747b;
            C12238m.checkNotNullExpressionValue(progressBar, "progressBar");
            progressBar.setIndeterminate(false);
            if (Build.VERSION.SDK_INT >= 24) {
                ProgressBar progressBar2 = c0932c4.f747b;
                C12238m.checkNotNullExpressionValue(progressBar2, "progressBar");
                c0932c4.f747b.setProgress(progress, progress >= progressBar2.getProgress());
            } else {
                ProgressBar progressBar3 = c0932c4.f747b;
                C12238m.checkNotNullExpressionValue(progressBar3, "progressBar");
                progressBar3.setProgress(progress);
            }
            ProgressBar progressBar4 = c0932c4.f747b;
            C12238m.checkNotNullExpressionValue(progressBar4, "progressBar");
            progressBar4.setProgressDrawable(progress == 100 ? this.drawableComplete : this.drawableInProgress);
            ProgressBar progressBar5 = c0932c4.f747b;
            C12238m.checkNotNullExpressionValue(progressBar5, "progressBar");
            progressBar5.setVisibility(0);
        } else if (progress == -1) {
            ProgressBar progressBar6 = c0932c4.f747b;
            C12238m.checkNotNullExpressionValue(progressBar6, "progressBar");
            progressBar6.setVisibility(0);
            ProgressBar progressBar7 = c0932c4.f747b;
            C12238m.checkNotNullExpressionValue(progressBar7, "progressBar");
            progressBar7.setIndeterminate(true);
        } else {
            if (progress != -2) {
                throw new IllegalArgumentException(C1643a.m871q("invalid argument supplied to progress: ", progress));
            }
            ProgressBar progressBar8 = c0932c4.f747b;
            C12238m.checkNotNullExpressionValue(progressBar8, "progressBar");
            progressBar8.setVisibility(4);
        }
        TextView textView2 = c0932c4.f749d;
        C12238m.checkNotNullExpressionValue(textView2, "progressSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView2, subtitle);
    }

    public final void setIcon(@DrawableRes int drawableResId) {
        this.binding.f748c.setImageResource(drawableResId);
    }
}
