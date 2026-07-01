package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAuthorizedAppsBinding;
import com.discord.models.domain.ModelOAuth2Token;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.widgets.notice.WidgetNoticeDialog$Builder;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAuthorizedApps extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsAuthorizedApps.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAuthorizedAppsBinding;", 0)};
    public static final WidgetSettingsAuthorizedApps$Companion Companion = new WidgetSettingsAuthorizedApps$Companion(null);
    private final SimpleRecyclerAdapter<ModelOAuth2Token, WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder> adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetSettingsAuthorizedApps() {
        super(R$layout.widget_settings_authorized_apps);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAuthorizedApps$binding$2.INSTANCE, null, 2, null);
        this.adapter = new SimpleRecyclerAdapter<>(null, new WidgetSettingsAuthorizedApps$adapter$1(this), 1, null);
    }

    public static final /* synthetic */ SimpleRecyclerAdapter access$getAdapter$p(WidgetSettingsAuthorizedApps widgetSettingsAuthorizedApps) {
        return widgetSettingsAuthorizedApps.adapter;
    }

    public static final /* synthetic */ void access$loadAuthorizedApps(WidgetSettingsAuthorizedApps widgetSettingsAuthorizedApps) {
        widgetSettingsAuthorizedApps.loadAuthorizedApps();
    }

    private final WidgetSettingsAuthorizedAppsBinding getBinding() {
        return (WidgetSettingsAuthorizedAppsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void loadAuthorizedApps() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getOAuthTokens(), false, 1, null), this, null, 2, null), WidgetSettingsAuthorizedApps.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsAuthorizedApps$loadAuthorizedApps$1(this), 62, (Object) null);
    }

    @MainThread
    public final void deauthorizeApp(long oauthId) {
        WidgetNoticeDialog$Builder positiveButton = WidgetNoticeDialog$Builder.setNegativeButton$default(new WidgetNoticeDialog$Builder(requireContext()).setTitle(2131888358).setMessage(2131888375), 2131887437, (Function1) null, 2, (Object) null).setPositiveButton(2131888357, new WidgetSettingsAuthorizedApps$deauthorizeApp$1(this, oauthId));
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        positiveButton.show(parentFragmentManager);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f2603b;
        m.checkNotNullExpressionValue(recyclerView, "binding.authorizedAppsList");
        recyclerView.setAdapter(this.adapter);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        loadAuthorizedApps();
    }
}
