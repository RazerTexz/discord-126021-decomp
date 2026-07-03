package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class DialogSimpleSelectorItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final TextView f15039a;

    public DialogSimpleSelectorItemBinding(@NonNull TextView textView) {
        this.f15039a = textView;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static DialogSimpleSelectorItemBinding m8381a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.dialog_simple_selector_item, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        Objects.requireNonNull(viewInflate, "rootView");
        return new DialogSimpleSelectorItemBinding((TextView) viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15039a;
    }
}
