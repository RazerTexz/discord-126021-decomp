package com.discord.widgets.settings.connections;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsConnectionsBinding;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.t.o;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnections extends AppFragment {
    public static final String CONNECTION_ID = "connection_id";
    public static final String PLATFORM_NAME = "platform_name";
    public static final String PLATFORM_TITLE = "platform_title";
    private WidgetSettingsUserConnections$Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsUserConnections.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsConnectionsBinding;", 0)};
    public static final WidgetSettingsUserConnections$Companion Companion = new WidgetSettingsUserConnections$Companion(null);

    public WidgetSettingsUserConnections() {
        super(R$layout.widget_settings_connections);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsUserConnections$binding$2.INSTANCE, null, 2, null);
        WidgetSettingsUserConnections$viewModel$2 widgetSettingsUserConnections$viewModel$2 = WidgetSettingsUserConnections$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetSettingsUserConnectionsViewModel.class), new WidgetSettingsUserConnections$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetSettingsUserConnections$viewModel$2));
    }

    public static final /* synthetic */ WidgetSettingsUserConnectionsViewModel access$getViewModel$p(WidgetSettingsUserConnections widgetSettingsUserConnections) {
        return widgetSettingsUserConnections.getViewModel();
    }

    public static final /* synthetic */ void access$handleViewState(WidgetSettingsUserConnections widgetSettingsUserConnections, WidgetSettingsUserConnectionsViewModel$ViewState widgetSettingsUserConnectionsViewModel$ViewState) {
        widgetSettingsUserConnections.handleViewState(widgetSettingsUserConnectionsViewModel$ViewState);
    }

    private final WidgetSettingsConnectionsBinding getBinding() {
        return (WidgetSettingsConnectionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetSettingsUserConnectionsViewModel getViewModel() {
        return (WidgetSettingsUserConnectionsViewModel) this.viewModel.getValue();
    }

    private final void handleViewState(WidgetSettingsUserConnectionsViewModel$ViewState viewState) {
        WidgetSettingsUserConnections$Adapter widgetSettingsUserConnections$Adapter = this.adapter;
        int itemCount = widgetSettingsUserConnections$Adapter != null ? widgetSettingsUserConnections$Adapter.getItemCount() : 0;
        if (viewState instanceof WidgetSettingsUserConnectionsViewModel$ViewState$Uninitialized) {
            TextView textView = getBinding().f2614b;
            m.checkNotNullExpressionValue(textView, "binding.connectionsEmpty");
            textView.setVisibility(8);
            RecyclerView recyclerView = getBinding().c;
            m.checkNotNullExpressionValue(recyclerView, "binding.connectionsRecycler");
            recyclerView.setVisibility(8);
            return;
        }
        if (viewState instanceof WidgetSettingsUserConnectionsViewModel$ViewState$Empty) {
            TextView textView2 = getBinding().f2614b;
            m.checkNotNullExpressionValue(textView2, "binding.connectionsEmpty");
            textView2.setVisibility(0);
            RecyclerView recyclerView2 = getBinding().c;
            m.checkNotNullExpressionValue(recyclerView2, "binding.connectionsRecycler");
            recyclerView2.setVisibility(8);
            return;
        }
        if (viewState instanceof WidgetSettingsUserConnectionsViewModel$ViewState$Loaded) {
            TextView textView3 = getBinding().f2614b;
            m.checkNotNullExpressionValue(textView3, "binding.connectionsEmpty");
            textView3.setVisibility(8);
            RecyclerView recyclerView3 = getBinding().c;
            m.checkNotNullExpressionValue(recyclerView3, "binding.connectionsRecycler");
            recyclerView3.setVisibility(0);
            List<WidgetSettingsUserConnectionsViewModel$ConnectionState> data = ((WidgetSettingsUserConnectionsViewModel$ViewState$Loaded) viewState).getData();
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(data, 10));
            Iterator<T> it = data.iterator();
            while (it.hasNext()) {
                arrayList.add(new WidgetSettingsUserConnections$UserConnectionItem((WidgetSettingsUserConnectionsViewModel$ConnectionState) it.next()));
            }
            WidgetSettingsUserConnections$Adapter widgetSettingsUserConnections$Adapter2 = this.adapter;
            if (widgetSettingsUserConnections$Adapter2 != null) {
                widgetSettingsUserConnections$Adapter2.setData(arrayList);
            }
            if (itemCount == 0 || arrayList.size() <= itemCount) {
                return;
            }
            getBinding().c.smoothScrollToPosition(arrayList.size() - 1);
        }
    }

    public static final void launch(Context context) {
        Companion.launch(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
            RecyclerView recyclerView = getBinding().c;
            m.checkNotNullExpressionValue(recyclerView, "binding.connectionsRecycler");
            m.checkNotNullExpressionValue(activity, "it");
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            m.checkNotNullExpressionValue(supportFragmentManager, "it.supportFragmentManager");
            this.adapter = (WidgetSettingsUserConnections$Adapter) mGRecyclerAdapter$Companion.configure(new WidgetSettingsUserConnections$Adapter(recyclerView, supportFragmentManager, new WidgetSettingsUserConnections$onViewBound$$inlined$let$lambda$1(this)));
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarSubtitle(2131896797);
        setActionBarTitle(2131887872);
        AppFragment.setActionBarOptionsMenu$default(this, R$menu.menu_connections, new WidgetSettingsUserConnections$onViewBound$2(this), null, 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetSettingsUserConnections.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsUserConnections$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
