package com.discord.widgets.auth;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.OauthTokenPermissionDetailedListItemBinding;
import com.discord.widgets.auth.WidgetOauth2Authorize;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$adapter$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize4 extends Lambda implements Function2<LayoutInflater, ViewGroup, WidgetOauth2Authorize.OAuthPermissionViewHolder> {
    public static final WidgetOauth2Authorize4 INSTANCE = new WidgetOauth2Authorize4();

    public WidgetOauth2Authorize4() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final WidgetOauth2Authorize.OAuthPermissionViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(layoutInflater, "layoutInflater");
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = layoutInflater.inflate(R.layout.oauth_token_permission_detailed_list_item, viewGroup, false);
        int i = R.id.oauth_token_permission_detailed_icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.oauth_token_permission_detailed_icon);
        if (imageView != null) {
            i = R.id.oauth_token_permission_detailed_name;
            TextView textView = (TextView) viewInflate.findViewById(R.id.oauth_token_permission_detailed_name);
            if (textView != null) {
                OauthTokenPermissionDetailedListItemBinding oauthTokenPermissionDetailedListItemBinding = new OauthTokenPermissionDetailedListItemBinding((ConstraintLayout) viewInflate, imageView, textView);
                Intrinsics3.checkNotNullExpressionValue(oauthTokenPermissionDetailedListItemBinding, "OauthTokenPermissionDeta…tInflater, parent, false)");
                return new WidgetOauth2Authorize.OAuthPermissionViewHolder(oauthTokenPermissionDetailedListItemBinding);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
