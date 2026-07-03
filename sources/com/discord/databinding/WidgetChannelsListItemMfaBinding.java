package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelsListItemMfaBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16052a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinkifiedTextView f16053b;

    public WidgetChannelsListItemMfaBinding(@NonNull LinearLayout linearLayout, @NonNull LinkifiedTextView linkifiedTextView) {
        this.f16052a = linearLayout;
        this.f16053b = linkifiedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16052a;
    }
}
