package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildsListItemDmBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f2459b;

    @NonNull
    public final TextView c;

    public WidgetGuildsListItemDmBinding(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.a = view;
        this.f2459b = simpleDraweeView;
        this.c = textView;
    }

    @NonNull
    public static WidgetGuildsListItemDmBinding a(@NonNull View view) {
        int i = R.id.guilds_item_dm_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.guilds_item_dm_avatar);
        if (simpleDraweeView != null) {
            i = R.id.guilds_item_dm_count;
            TextView textView = (TextView) view.findViewById(R.id.guilds_item_dm_count);
            if (textView != null) {
                return new WidgetGuildsListItemDmBinding(view, simpleDraweeView, textView);
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
