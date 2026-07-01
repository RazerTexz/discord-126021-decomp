package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSettingsPermissionsAdvancedBinding;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.SimpleMembersAdapter;
import com.discord.widgets.channels.SimpleRolesAdapter;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsAdvanced extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelSettingsPermissionsAdvanced.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetChannelSettingsPermissionsAdvancedBinding;", 0)};
    private SimpleMembersAdapter membersAdapter;
    private SimpleRolesAdapter rolesAdapter;

    /* JADX INFO: renamed from: viewBinding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate viewBinding;

    public WidgetChannelSettingsPermissionsAdvanced() {
        super(R$layout.widget_channel_settings_permissions_advanced);
        this.viewBinding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelSettingsPermissionsAdvanced$viewBinding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelSettingsPermissionsAdvanced widgetChannelSettingsPermissionsAdvanced, WidgetChannelSettingsPermissionsAdvanced$Model widgetChannelSettingsPermissionsAdvanced$Model) {
        widgetChannelSettingsPermissionsAdvanced.configureUI(widgetChannelSettingsPermissionsAdvanced$Model);
    }

    private final void configureMembers(WidgetChannelSettingsPermissionsAdvanced$Model model) {
        if (model.getMemberItems().isEmpty()) {
            LinearLayout linearLayout = getViewBinding().d;
            m.checkNotNullExpressionValue(linearLayout, "viewBinding.membersContainer");
            linearLayout.setVisibility(8);
            return;
        }
        SimpleMembersAdapter simpleMembersAdapter = this.membersAdapter;
        if (simpleMembersAdapter == null) {
            m.throwUninitializedPropertyAccessException("membersAdapter");
        }
        simpleMembersAdapter.setData(model.getMemberItems(), new WidgetChannelSettingsPermissionsAdvanced$configureMembers$1(this, model));
        LinearLayout linearLayout2 = getViewBinding().d;
        m.checkNotNullExpressionValue(linearLayout2, "viewBinding.membersContainer");
        linearLayout2.setVisibility(0);
    }

    private final void configureRoles(WidgetChannelSettingsPermissionsAdvanced$Model model) {
        if (model.getRoleItems().isEmpty()) {
            LinearLayout linearLayout = getViewBinding().f;
            m.checkNotNullExpressionValue(linearLayout, "viewBinding.rolesContainer");
            linearLayout.setVisibility(8);
            return;
        }
        SimpleRolesAdapter simpleRolesAdapter = this.rolesAdapter;
        if (simpleRolesAdapter == null) {
            m.throwUninitializedPropertyAccessException("rolesAdapter");
        }
        simpleRolesAdapter.setData(model.getRoleItems(), new WidgetChannelSettingsPermissionsAdvanced$configureRoles$1(this, model));
        LinearLayout linearLayout2 = getViewBinding().f;
        m.checkNotNullExpressionValue(linearLayout2, "viewBinding.rolesContainer");
        linearLayout2.setVisibility(0);
    }

    private final void configureUI(WidgetChannelSettingsPermissionsAdvanced$Model model) {
        if (model == null || !model.getCanManage()) {
            return;
        }
        getViewBinding().c.setOnClickListener(new WidgetChannelSettingsPermissionsAdvanced$configureUI$1(this, model));
        getViewBinding().f2278b.setOnClickListener(new WidgetChannelSettingsPermissionsAdvanced$configureUI$2(this, model));
        configureRoles(model);
        configureMembers(model);
    }

    private final WidgetChannelSettingsPermissionsAdvancedBinding getViewBinding() {
        return (WidgetChannelSettingsPermissionsAdvancedBinding) this.viewBinding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getViewBinding().g;
        m.checkNotNullExpressionValue(recyclerView, "viewBinding.rolesRecycler");
        this.rolesAdapter = (SimpleRolesAdapter) mGRecyclerAdapter$Companion.configure(new SimpleRolesAdapter(recyclerView));
        RecyclerView recyclerView2 = getViewBinding().g;
        m.checkNotNullExpressionValue(recyclerView2, "viewBinding.rolesRecycler");
        recyclerView2.setNestedScrollingEnabled(false);
        getViewBinding().g.setHasFixedSize(false);
        RecyclerView recyclerView3 = getViewBinding().e;
        m.checkNotNullExpressionValue(recyclerView3, "viewBinding.membersRecycler");
        this.membersAdapter = (SimpleMembersAdapter) mGRecyclerAdapter$Companion.configure(new SimpleMembersAdapter(recyclerView3));
        RecyclerView recyclerView4 = getViewBinding().e;
        m.checkNotNullExpressionValue(recyclerView4, "viewBinding.membersRecycler");
        recyclerView4.setNestedScrollingEnabled(false);
        getViewBinding().e.setHasFixedSize(false);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetChannelSettingsPermissionsAdvanced$Model> observableR = WidgetChannelSettingsPermissionsAdvanced$Model.Companion.get(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L)).p(1L, TimeUnit.SECONDS).r();
        m.checkNotNullExpressionValue(observableR, "Model[channelId]\n       …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetChannelSettingsPermissionsAdvanced.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelSettingsPermissionsAdvanced$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
