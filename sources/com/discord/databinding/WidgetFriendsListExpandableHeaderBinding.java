package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetFriendsListExpandableHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f16683a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16684b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16685c;

    public WidgetFriendsListExpandableHeaderBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f16683a = frameLayout;
        this.f16684b = textView;
        this.f16685c = textView2;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetFriendsListExpandableHeaderBinding m8415a(@NonNull View view) {
        int i = C5419R.id.friends_list_expandable_header_button;
        TextView textView = (TextView) view.findViewById(C5419R.id.friends_list_expandable_header_button);
        if (textView != null) {
            i = C5419R.id.friends_list_pending_item_header_text;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.friends_list_pending_item_header_text);
            if (textView2 != null) {
                return new WidgetFriendsListExpandableHeaderBinding((FrameLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16683a;
    }
}
