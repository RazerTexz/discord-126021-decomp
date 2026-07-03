package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildsListItemDmBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f17095a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f17096b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f17097c;

    public WidgetGuildsListItemDmBinding(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.f17095a = view;
        this.f17096b = simpleDraweeView;
        this.f17097c = textView;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetGuildsListItemDmBinding m8418a(@NonNull View view) {
        int i = C5419R.id.guilds_item_dm_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.guilds_item_dm_avatar);
        if (simpleDraweeView != null) {
            i = C5419R.id.guilds_item_dm_count;
            TextView textView = (TextView) view.findViewById(C5419R.id.guilds_item_dm_count);
            if (textView != null) {
                return new WidgetGuildsListItemDmBinding(view, simpleDraweeView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17095a;
    }
}
