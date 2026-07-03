package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CodeVerificationView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetHubAuthenticationBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17151a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinkifiedTextView f17152b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CodeVerificationView f17153c;

    public WidgetHubAuthenticationBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView2, @NonNull CodeVerificationView codeVerificationView) {
        this.f17151a = linearLayout;
        this.f17152b = linkifiedTextView;
        this.f17153c = codeVerificationView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17151a;
    }
}
