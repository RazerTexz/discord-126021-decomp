package com.discord.widgets.auth;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.OauthTokenPermissionDetailedListItemBinding;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$adapter$1 extends o implements Function2<LayoutInflater, ViewGroup, WidgetOauth2Authorize$OAuthPermissionViewHolder> {
    public static final WidgetOauth2Authorize$adapter$1 INSTANCE = new WidgetOauth2Authorize$adapter$1();

    public WidgetOauth2Authorize$adapter$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetOauth2Authorize$OAuthPermissionViewHolder invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        m.checkNotNullParameter(layoutInflater, "layoutInflater");
        m.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = layoutInflater.inflate(R$layout.oauth_token_permission_detailed_list_item, viewGroup, false);
        int i = R$id.oauth_token_permission_detailed_icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.oauth_token_permission_detailed_icon);
        if (imageView != null) {
            i = R$id.oauth_token_permission_detailed_name;
            TextView textView = (TextView) viewInflate.findViewById(R$id.oauth_token_permission_detailed_name);
            if (textView != null) {
                OauthTokenPermissionDetailedListItemBinding oauthTokenPermissionDetailedListItemBinding = new OauthTokenPermissionDetailedListItemBinding((ConstraintLayout) viewInflate, imageView, textView);
                m.checkNotNullExpressionValue(oauthTokenPermissionDetailedListItemBinding, "OauthTokenPermissionDeta…tInflater, parent, false)");
                return new WidgetOauth2Authorize$OAuthPermissionViewHolder(oauthTokenPermissionDetailedListItemBinding);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetOauth2Authorize$OAuthPermissionViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return invoke2(layoutInflater, viewGroup);
    }
}
