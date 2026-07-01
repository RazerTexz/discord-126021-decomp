package com.discord.widgets.auth;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.databinding.OauthTokenPermissionDetailedListItemBinding;
import com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder;
import com.discord.views.OAuthPermissionViews;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$OAuthPermissionViewHolder extends SimpleRecyclerAdapter$ViewHolder<WidgetOauth2Authorize$PermissionModel> {
    private final OauthTokenPermissionDetailedListItemBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetOauth2Authorize$OAuthPermissionViewHolder(OauthTokenPermissionDetailedListItemBinding oauthTokenPermissionDetailedListItemBinding) {
        m.checkNotNullParameter(oauthTokenPermissionDetailedListItemBinding, "binding");
        ConstraintLayout constraintLayout = oauthTokenPermissionDetailedListItemBinding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        super(constraintLayout);
        this.binding = oauthTokenPermissionDetailedListItemBinding;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder
    public /* bridge */ /* synthetic */ void bind(WidgetOauth2Authorize$PermissionModel widgetOauth2Authorize$PermissionModel) {
        bind2(widgetOauth2Authorize$PermissionModel);
    }

    /* JADX INFO: renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(WidgetOauth2Authorize$PermissionModel data) {
        m.checkNotNullParameter(data, "data");
        if (data.getScope() != null) {
            this.binding.f2133b.setImageResource(2131231657);
            TextView textView = this.binding.c;
            m.checkNotNullExpressionValue(textView, "binding.oauthTokenPermissionDetailedName");
            OAuthPermissionViews.a(textView, data.getScope());
            return;
        }
        if (data.getFakeText() != null) {
            this.binding.f2133b.setImageResource(2131231679);
            this.binding.c.setText(data.getFakeText().intValue());
        }
    }
}
