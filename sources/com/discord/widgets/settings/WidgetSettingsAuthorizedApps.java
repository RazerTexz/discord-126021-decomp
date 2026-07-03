package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.application.Application;
import com.discord.api.auth.OAuthScope;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAuthorizedAppsBinding;
import com.discord.databinding.WidgetSettingsAuthorizedAppsListItemBinding;
import com.discord.models.domain.ModelOAuth2Token;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.OAuthPermissionViews;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p062y.C1333h;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAuthorizedApps extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsAuthorizedApps.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAuthorizedAppsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SimpleRecyclerAdapter<ModelOAuth2Token, AuthorizedAppViewHolder> adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
    public static final class AuthorizedAppViewHolder extends SimpleRecyclerAdapter.ViewHolder<ModelOAuth2Token> {
        private final WidgetSettingsAuthorizedAppsListItemBinding binding;
        private final Function1<ModelOAuth2Token, Unit> onDeauthorizeClick;
        private final SimpleRecyclerAdapter<OAuthScope, OAuthPermissionViews.C7080a> permissionsAdapter;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public AuthorizedAppViewHolder(WidgetSettingsAuthorizedAppsListItemBinding widgetSettingsAuthorizedAppsListItemBinding, Function1<? super ModelOAuth2Token, Unit> function1) {
            C12238m.checkNotNullParameter(widgetSettingsAuthorizedAppsListItemBinding, "binding");
            C12238m.checkNotNullParameter(function1, "onDeauthorizeClick");
            MaterialCardView materialCardView = widgetSettingsAuthorizedAppsListItemBinding.f17863a;
            C12238m.checkNotNullExpressionValue(materialCardView, "binding.root");
            super(materialCardView);
            this.binding = widgetSettingsAuthorizedAppsListItemBinding;
            this.onDeauthorizeClick = function1;
            SimpleRecyclerAdapter<OAuthScope, OAuthPermissionViews.C7080a> simpleRecyclerAdapter = new SimpleRecyclerAdapter<>(null, C1333h.f2026j, 1, null);
            this.permissionsAdapter = simpleRecyclerAdapter;
            RecyclerView recyclerView = widgetSettingsAuthorizedAppsListItemBinding.f17871i;
            C12238m.checkNotNullExpressionValue(recyclerView, "binding.oauthApplicationPermissionsRv");
            recyclerView.setAdapter(simpleRecyclerAdapter);
            for (TextView textView : C12147n.listOf((Object[]) new TextView[]{widgetSettingsAuthorizedAppsListItemBinding.f17869g, widgetSettingsAuthorizedAppsListItemBinding.f17865c, widgetSettingsAuthorizedAppsListItemBinding.f17870h})) {
                AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
                C12238m.checkNotNullExpressionValue(textView, "header");
                accessibilityUtils.setViewIsHeading(textView);
            }
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public void bind(final ModelOAuth2Token data) {
            C12238m.checkNotNullParameter(data, "data");
            Application application = data.getApplication();
            String icon = application.getIcon();
            String applicationIcon$default = icon != null ? IconUtils.getApplicationIcon$default(application.getId(), icon, 0, 4, (Object) null) : null;
            SimpleDraweeView simpleDraweeView = this.binding.f17867e;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.oauthApplicationIconIv");
            MGImages.setImage$default(simpleDraweeView, applicationIcon$default, 0, 0, false, null, null, 124, null);
            TextView textView = this.binding.f17869g;
            C12238m.checkNotNullExpressionValue(textView, "binding.oauthApplicationNameTv");
            textView.setText(application.getName());
            MaterialCardView materialCardView = this.binding.f17868f;
            C12238m.checkNotNullExpressionValue(materialCardView, "binding.oauthApplicationListItem");
            materialCardView.setContentDescription(application.getName());
            TextView textView2 = this.binding.f17865c;
            C12238m.checkNotNullExpressionValue(textView2, "binding.oauthApplicationDescriptionLabelTv");
            String description = application.getDescription();
            textView2.setVisibility((description == null || C12103t.isBlank(description)) ^ true ? 0 : 8);
            TextView textView3 = this.binding.f17866d;
            C12238m.checkNotNullExpressionValue(textView3, "binding.oauthApplicationDescriptionTv");
            ViewExtensions.setTextAndVisibilityBy(textView3, application.getDescription());
            this.permissionsAdapter.setData(data.getScopes());
            this.binding.f17864b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder$bind$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.this$0.onDeauthorizeClick.invoke(data);
                }
            });
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetSettingsAuthorizedApps.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAuthorizedApps$deauthorizeApp$1 */
    /* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
    public static final class C96391 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ long $oauthId;

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAuthorizedApps$deauthorizeApp$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Void, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
                WidgetSettingsAuthorizedApps.this.loadAuthorizedApps();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96391(long j) {
            super(1);
            this.$oauthId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteOAuthToken(this.$oauthId), false, 1, null), (117 & 1) != 0 ? null : WidgetSettingsAuthorizedApps.this.getContext(), "REST: deauthorize app", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass1(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAuthorizedApps$loadAuthorizedApps$1 */
    /* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
    public static final class C96401 extends AbstractC12240o implements Function1<List<? extends ModelOAuth2Token>, Unit> {
        public C96401() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelOAuth2Token> list) {
            invoke2((List<ModelOAuth2Token>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelOAuth2Token> list) {
            C12238m.checkNotNullParameter(list, "authedTokens");
            WidgetSettingsAuthorizedApps.this.adapter.setData(list);
        }
    }

    public WidgetSettingsAuthorizedApps() {
        super(C5419R.layout.widget_settings_authorized_apps);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAuthorizedApps$binding$2.INSTANCE, null, 2, null);
        this.adapter = new SimpleRecyclerAdapter<>(null, new WidgetSettingsAuthorizedApps$adapter$1(this), 1, null);
    }

    private final WidgetSettingsAuthorizedAppsBinding getBinding() {
        return (WidgetSettingsAuthorizedAppsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void loadAuthorizedApps() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getOAuthTokens(), false, 1, null), this, null, 2, null), (Class<?>) WidgetSettingsAuthorizedApps.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C96401());
    }

    @MainThread
    public final void deauthorizeApp(long oauthId) {
        WidgetNoticeDialog.Builder positiveButton = WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(requireContext()).setTitle(C5419R.string.deauthorize_app).setMessage(C5419R.string.delete_app_confirm_msg), C5419R.string.cancel, (Function1) null, 2, (Object) null).setPositiveButton(C5419R.string.deauthorize, new C96391(oauthId));
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        positiveButton.show(parentFragmentManager);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f17862b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.authorizedAppsList");
        recyclerView.setAdapter(this.adapter);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        loadAuthorizedApps();
    }
}
