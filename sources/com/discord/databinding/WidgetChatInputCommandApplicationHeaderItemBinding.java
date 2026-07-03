package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatInputCommandApplicationHeaderItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16114a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f16115b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16116c;

    public WidgetChatInputCommandApplicationHeaderItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f16114a = constraintLayout;
        this.f16115b = imageView;
        this.f16116c = textView;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetChatInputCommandApplicationHeaderItemBinding m8407a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.widget_chat_input_command_application_header_item, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = C5419R.id.chat_input_application_avatar;
        ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.chat_input_application_avatar);
        if (imageView != null) {
            i = C5419R.id.chat_input_application_name;
            TextView textView = (TextView) viewInflate.findViewById(C5419R.id.chat_input_application_name);
            if (textView != null) {
                return new WidgetChatInputCommandApplicationHeaderItemBinding((ConstraintLayout) viewInflate, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16114a;
    }
}
