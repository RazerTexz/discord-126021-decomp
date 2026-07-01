package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class EmptyFriendsStateViewBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2103b;

    @NonNull
    public final TextView c;

    public EmptyFriendsStateViewBinding(@NonNull View view, @NonNull MaterialButton materialButton, @Nullable ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = view;
        this.f2103b = materialButton;
        this.c = textView;
    }

    @NonNull
    public static EmptyFriendsStateViewBinding a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(R.layout.empty_friends_state_view, viewGroup);
        int i = R.id.empty_friends_state_add_friend;
        MaterialButton materialButton = (MaterialButton) viewGroup.findViewById(R.id.empty_friends_state_add_friend);
        if (materialButton != null) {
            ImageView imageView = (ImageView) viewGroup.findViewById(R.id.empty_friends_state_image);
            i = R.id.empty_friends_state_title;
            TextView textView = (TextView) viewGroup.findViewById(R.id.empty_friends_state_title);
            if (textView != null) {
                i = R.id.subtitle;
                TextView textView2 = (TextView) viewGroup.findViewById(R.id.subtitle);
                if (textView2 != null) {
                    return new EmptyFriendsStateViewBinding(viewGroup, materialButton, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewGroup.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
