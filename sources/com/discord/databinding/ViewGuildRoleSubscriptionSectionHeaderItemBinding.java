package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGuildRoleSubscriptionSectionHeaderItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15491a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15492b;

    public ViewGuildRoleSubscriptionSectionHeaderItemBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f15491a = linearLayout;
        this.f15492b = textView2;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static ViewGuildRoleSubscriptionSectionHeaderItemBinding m8399a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.view_guild_role_subscription_section_header_item, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = C5419R.id.guild_role_subscription_section_description;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.guild_role_subscription_section_description);
        if (textView != null) {
            i = C5419R.id.guild_role_subscription_section_header;
            TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.guild_role_subscription_section_header);
            if (textView2 != null) {
                return new ViewGuildRoleSubscriptionSectionHeaderItemBinding((LinearLayout) viewInflate, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15491a;
    }
}
