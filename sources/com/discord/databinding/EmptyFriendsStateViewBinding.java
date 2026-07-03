package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class EmptyFriendsStateViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15060a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f15061b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15062c;

    public EmptyFriendsStateViewBinding(@NonNull View view, @NonNull MaterialButton materialButton, @Nullable ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f15060a = view;
        this.f15061b = materialButton;
        this.f15062c = textView;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static EmptyFriendsStateViewBinding m8383a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(C5419R.layout.empty_friends_state_view, viewGroup);
        int i = C5419R.id.empty_friends_state_add_friend;
        MaterialButton materialButton = (MaterialButton) viewGroup.findViewById(C5419R.id.empty_friends_state_add_friend);
        if (materialButton != null) {
            ImageView imageView = (ImageView) viewGroup.findViewById(C5419R.id.empty_friends_state_image);
            i = C5419R.id.empty_friends_state_title;
            TextView textView = (TextView) viewGroup.findViewById(C5419R.id.empty_friends_state_title);
            if (textView != null) {
                i = C5419R.id.subtitle;
                TextView textView2 = (TextView) viewGroup.findViewById(C5419R.id.subtitle);
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
        return this.f15060a;
    }
}
