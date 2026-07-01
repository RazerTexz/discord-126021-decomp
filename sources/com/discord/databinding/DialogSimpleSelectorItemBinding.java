package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.R$layout;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class DialogSimpleSelectorItemBinding implements ViewBinding {

    @NonNull
    public final TextView a;

    public DialogSimpleSelectorItemBinding(@NonNull TextView textView) {
        this.a = textView;
    }

    @NonNull
    public static DialogSimpleSelectorItemBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R$layout.dialog_simple_selector_item, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        Objects.requireNonNull(viewInflate, "rootView");
        return new DialogSimpleSelectorItemBinding((TextView) viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
