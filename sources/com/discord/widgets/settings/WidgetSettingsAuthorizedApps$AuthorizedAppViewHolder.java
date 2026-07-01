package com.discord.widgets.settings;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.y.h;
import com.discord.api.application.Application;
import com.discord.api.auth.OAuthScope;
import com.discord.databinding.WidgetSettingsAuthorizedAppsListItemBinding;
import com.discord.models.domain.ModelOAuth2Token;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder;
import com.discord.views.OAuthPermissionViews$a;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;
import d0.g0.t;
import d0.t.n;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder extends SimpleRecyclerAdapter$ViewHolder<ModelOAuth2Token> {
    private final WidgetSettingsAuthorizedAppsListItemBinding binding;
    private final Function1<ModelOAuth2Token, Unit> onDeauthorizeClick;
    private final SimpleRecyclerAdapter<OAuthScope, OAuthPermissionViews$a> permissionsAdapter;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder(WidgetSettingsAuthorizedAppsListItemBinding widgetSettingsAuthorizedAppsListItemBinding, Function1<? super ModelOAuth2Token, Unit> function1) {
        m.checkNotNullParameter(widgetSettingsAuthorizedAppsListItemBinding, "binding");
        m.checkNotNullParameter(function1, "onDeauthorizeClick");
        MaterialCardView materialCardView = widgetSettingsAuthorizedAppsListItemBinding.a;
        m.checkNotNullExpressionValue(materialCardView, "binding.root");
        super(materialCardView);
        this.binding = widgetSettingsAuthorizedAppsListItemBinding;
        this.onDeauthorizeClick = function1;
        SimpleRecyclerAdapter<OAuthScope, OAuthPermissionViews$a> simpleRecyclerAdapter = new SimpleRecyclerAdapter<>(null, h.j, 1, null);
        this.permissionsAdapter = simpleRecyclerAdapter;
        RecyclerView recyclerView = widgetSettingsAuthorizedAppsListItemBinding.i;
        m.checkNotNullExpressionValue(recyclerView, "binding.oauthApplicationPermissionsRv");
        recyclerView.setAdapter(simpleRecyclerAdapter);
        for (TextView textView : n.listOf((Object[]) new TextView[]{widgetSettingsAuthorizedAppsListItemBinding.g, widgetSettingsAuthorizedAppsListItemBinding.c, widgetSettingsAuthorizedAppsListItemBinding.h})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }

    public static final /* synthetic */ Function1 access$getOnDeauthorizeClick$p(WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder widgetSettingsAuthorizedApps$AuthorizedAppViewHolder) {
        return widgetSettingsAuthorizedApps$AuthorizedAppViewHolder.onDeauthorizeClick;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder
    public /* bridge */ /* synthetic */ void bind(ModelOAuth2Token modelOAuth2Token) {
        bind2(modelOAuth2Token);
    }

    /* JADX INFO: renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(ModelOAuth2Token data) {
        m.checkNotNullParameter(data, "data");
        Application application = data.getApplication();
        String icon = application.getIcon();
        String applicationIcon$default = icon != null ? IconUtils.getApplicationIcon$default(application.getId(), icon, 0, 4, (Object) null) : null;
        SimpleDraweeView simpleDraweeView = this.binding.e;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.oauthApplicationIconIv");
        MGImages.setImage$default(simpleDraweeView, applicationIcon$default, 0, 0, false, null, null, 124, null);
        TextView textView = this.binding.g;
        m.checkNotNullExpressionValue(textView, "binding.oauthApplicationNameTv");
        textView.setText(application.getName());
        MaterialCardView materialCardView = this.binding.f;
        m.checkNotNullExpressionValue(materialCardView, "binding.oauthApplicationListItem");
        materialCardView.setContentDescription(application.getName());
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.oauthApplicationDescriptionLabelTv");
        String description = application.getDescription();
        textView2.setVisibility((description == null || t.isBlank(description)) ^ true ? 0 : 8);
        TextView textView3 = this.binding.d;
        m.checkNotNullExpressionValue(textView3, "binding.oauthApplicationDescriptionTv");
        ViewExtensions.setTextAndVisibilityBy(textView3, application.getDescription());
        this.permissionsAdapter.setData(data.getScopes());
        this.binding.f2604b.setOnClickListener(new WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder$bind$2(this, data));
    }
}
