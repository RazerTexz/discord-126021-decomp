package com.discord.widgets.auth;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.OauthTokenPermissionDetailedListItemBinding;
import com.discord.widgets.auth.WidgetOauth2Authorize;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$adapter$1 extends AbstractC12240o implements Function2<LayoutInflater, ViewGroup, WidgetOauth2Authorize.OAuthPermissionViewHolder> {
    public static final WidgetOauth2Authorize$adapter$1 INSTANCE = new WidgetOauth2Authorize$adapter$1();

    public WidgetOauth2Authorize$adapter$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final WidgetOauth2Authorize.OAuthPermissionViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C12238m.checkNotNullParameter(layoutInflater, "layoutInflater");
        C12238m.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = layoutInflater.inflate(C5419R.layout.oauth_token_permission_detailed_list_item, viewGroup, false);
        int i = C5419R.id.oauth_token_permission_detailed_icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.oauth_token_permission_detailed_icon);
        if (imageView != null) {
            i = C5419R.id.oauth_token_permission_detailed_name;
            TextView textView = (TextView) viewInflate.findViewById(C5419R.id.oauth_token_permission_detailed_name);
            if (textView != null) {
                OauthTokenPermissionDetailedListItemBinding oauthTokenPermissionDetailedListItemBinding = new OauthTokenPermissionDetailedListItemBinding((ConstraintLayout) viewInflate, imageView, textView);
                C12238m.checkNotNullExpressionValue(oauthTokenPermissionDetailedListItemBinding, "OauthTokenPermissionDeta…tInflater, parent, false)");
                return new WidgetOauth2Authorize.OAuthPermissionViewHolder(oauthTokenPermissionDetailedListItemBinding);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
