package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsHelpItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinkifiedTextView f17674a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinkifiedTextView f17675b;

    public WidgetServerSettingsHelpItemBinding(@NonNull LinkifiedTextView linkifiedTextView, @NonNull LinkifiedTextView linkifiedTextView2) {
        this.f17674a = linkifiedTextView;
        this.f17675b = linkifiedTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17674a;
    }
}
