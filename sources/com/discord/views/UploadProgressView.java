package com.discord.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
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
import b.a.i.c4;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.m;

/* JADX INFO: compiled from: UploadProgressView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UploadProgressView extends ConstraintLayout {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final c4 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Drawable drawableComplete;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Drawable drawableInProgress;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.view_upload_progress, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.progress_bar;
        ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(R$id.progress_bar);
        if (progressBar != null) {
            i = R$id.progress_file_image;
            ImageView imageView = (ImageView) viewInflate.findViewById(R$id.progress_file_image);
            if (imageView != null) {
                i = R$id.progress_subtext;
                TextView textView = (TextView) viewInflate.findViewById(R$id.progress_subtext);
                if (textView != null) {
                    i = R$id.progress_text;
                    TextView textView2 = (TextView) viewInflate.findViewById(R$id.progress_text);
                    if (textView2 != null) {
                        c4 c4Var = new c4((ConstraintLayout) viewInflate, progressBar, imageView, textView, textView2);
                        m.checkNotNullExpressionValue(c4Var, "ViewUploadProgressBindin…rom(context), this, true)");
                        this.binding = c4Var;
                        this.drawableComplete = ContextCompat.getDrawable(getContext(), 2131231292);
                        this.drawableInProgress = ContextCompat.getDrawable(getContext(), DrawableCompat.getThemedDrawableRes$default(this, 2130970014, 0, 2, (Object) null));
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void a(CharSequence title, int progress, String subtitle) {
        m.checkNotNullParameter(title, "title");
        c4 c4Var = this.binding;
        TextView textView = c4Var.e;
        m.checkNotNullExpressionValue(textView, "progressText");
        textView.setText(title);
        if (progress >= 0) {
            ProgressBar progressBar = c4Var.f93b;
            m.checkNotNullExpressionValue(progressBar, "progressBar");
            progressBar.setIndeterminate(false);
            if (Build$VERSION.SDK_INT >= 24) {
                ProgressBar progressBar2 = c4Var.f93b;
                m.checkNotNullExpressionValue(progressBar2, "progressBar");
                c4Var.f93b.setProgress(progress, progress >= progressBar2.getProgress());
            } else {
                ProgressBar progressBar3 = c4Var.f93b;
                m.checkNotNullExpressionValue(progressBar3, "progressBar");
                progressBar3.setProgress(progress);
            }
            ProgressBar progressBar4 = c4Var.f93b;
            m.checkNotNullExpressionValue(progressBar4, "progressBar");
            progressBar4.setProgressDrawable(progress == 100 ? this.drawableComplete : this.drawableInProgress);
            ProgressBar progressBar5 = c4Var.f93b;
            m.checkNotNullExpressionValue(progressBar5, "progressBar");
            progressBar5.setVisibility(0);
        } else if (progress == -1) {
            ProgressBar progressBar6 = c4Var.f93b;
            m.checkNotNullExpressionValue(progressBar6, "progressBar");
            progressBar6.setVisibility(0);
            ProgressBar progressBar7 = c4Var.f93b;
            m.checkNotNullExpressionValue(progressBar7, "progressBar");
            progressBar7.setIndeterminate(true);
        } else {
            if (progress != -2) {
                throw new IllegalArgumentException(a.q("invalid argument supplied to progress: ", progress));
            }
            ProgressBar progressBar8 = c4Var.f93b;
            m.checkNotNullExpressionValue(progressBar8, "progressBar");
            progressBar8.setVisibility(4);
        }
        TextView textView2 = c4Var.d;
        m.checkNotNullExpressionValue(textView2, "progressSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView2, subtitle);
    }

    public final void setIcon(@DrawableRes int drawableResId) {
        this.binding.c.setImageResource(drawableResId);
    }
}
