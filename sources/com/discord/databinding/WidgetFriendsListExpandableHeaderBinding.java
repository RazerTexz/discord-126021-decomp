package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetFriendsListExpandableHeaderBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2398b;

    @NonNull
    public final TextView c;

    public WidgetFriendsListExpandableHeaderBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = frameLayout;
        this.f2398b = textView;
        this.c = textView2;
    }

    @NonNull
    public static WidgetFriendsListExpandableHeaderBinding a(@NonNull View view) {
        int i = R$id.friends_list_expandable_header_button;
        TextView textView = (TextView) view.findViewById(R$id.friends_list_expandable_header_button);
        if (textView != null) {
            i = R$id.friends_list_pending_item_header_text;
            TextView textView2 = (TextView) view.findViewById(R$id.friends_list_pending_item_header_text);
            if (textView2 != null) {
                return new WidgetFriendsListExpandableHeaderBinding((FrameLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
