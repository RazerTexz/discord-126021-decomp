package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.R;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGuildRoleSubscriptionSectionHeaderItemBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2198b;

    public ViewGuildRoleSubscriptionSectionHeaderItemBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.f2198b = textView2;
    }

    @NonNull
    public static ViewGuildRoleSubscriptionSectionHeaderItemBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.view_guild_role_subscription_section_header_item, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = R.id.guild_role_subscription_section_description;
        TextView textView = (TextView) viewInflate.findViewById(R.id.guild_role_subscription_section_description);
        if (textView != null) {
            i = R.id.guild_role_subscription_section_header;
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.guild_role_subscription_section_header);
            if (textView2 != null) {
                return new ViewGuildRoleSubscriptionSectionHeaderItemBinding((LinearLayout) viewInflate, textView, textView2);
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
