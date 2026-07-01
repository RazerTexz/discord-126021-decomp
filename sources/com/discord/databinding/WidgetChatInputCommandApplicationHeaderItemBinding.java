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
import com.discord.R$id;
import com.discord.R$layout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatInputCommandApplicationHeaderItemBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2305b;

    @NonNull
    public final TextView c;

    public WidgetChatInputCommandApplicationHeaderItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.a = constraintLayout;
        this.f2305b = imageView;
        this.c = textView;
    }

    @NonNull
    public static WidgetChatInputCommandApplicationHeaderItemBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R$layout.widget_chat_input_command_application_header_item, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = R$id.chat_input_application_avatar;
        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.chat_input_application_avatar);
        if (imageView != null) {
            i = R$id.chat_input_application_name;
            TextView textView = (TextView) viewInflate.findViewById(R$id.chat_input_application_name);
            if (textView != null) {
                return new WidgetChatInputCommandApplicationHeaderItemBinding((ConstraintLayout) viewInflate, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
