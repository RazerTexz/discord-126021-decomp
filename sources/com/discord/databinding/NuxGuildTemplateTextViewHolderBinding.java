package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class NuxGuildTemplateTextViewHolderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final TextView f15200a;

    public NuxGuildTemplateTextViewHolderBinding(@NonNull TextView textView) {
        this.f15200a = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15200a;
    }
}
