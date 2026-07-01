package com.discord.widgets.settings.connections;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.activity.ActivityType;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.connectedaccounts.ConnectedAccountIntegration;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsConnectionsBinding;
import com.discord.databinding.WidgetSettingsItemConnectedAccountBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.StoreUserPresence;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.integrations.SpotifyHelper;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.notices.NoticeBuilders;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnections extends AppFragment {
    public static final String CONNECTION_ID = "connection_id";
    public static final String PLATFORM_NAME = "platform_name";
    public static final String PLATFORM_TITLE = "platform_title";
    private Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsUserConnections.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsConnectionsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
    public static final class Adapter extends MGRecyclerAdapterSimple<UserConnectionItem> {
        private final FragmentManager fragmentManager;
        private final Function1<String, Unit> onJoinIntegration;

        /* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
        public final class ViewHolder extends MGRecyclerViewHolder<Adapter, UserConnectionItem> {
            private final WidgetSettingsItemConnectedAccountBinding binding;
            public final /* synthetic */ Adapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(@LayoutRes Adapter adapter, int i, Adapter adapter2) {
                super(i, adapter2);
                Intrinsics3.checkNotNullParameter(adapter2, "adapter");
                this.this$0 = adapter;
                View view = this.itemView;
                int i2 = R.id.connected_account_disconnect;
                ImageView imageView = (ImageView) view.findViewById(R.id.connected_account_disconnect);
                if (imageView != null) {
                    i2 = R.id.connected_account_divider;
                    View viewFindViewById = view.findViewById(R.id.connected_account_divider);
                    if (viewFindViewById != null) {
                        i2 = R.id.connected_account_img;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.connected_account_img);
                        if (imageView2 != null) {
                            i2 = R.id.connected_account_name;
                            TextView textView = (TextView) view.findViewById(R.id.connected_account_name);
                            if (textView != null) {
                                i2 = R.id.display_activity_switch;
                                SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(R.id.display_activity_switch);
                                if (switchMaterial != null) {
                                    i2 = R.id.display_switch;
                                    SwitchMaterial switchMaterial2 = (SwitchMaterial) view.findViewById(R.id.display_switch);
                                    if (switchMaterial2 != null) {
                                        i2 = R.id.divider;
                                        View viewFindViewById2 = view.findViewById(R.id.divider);
                                        if (viewFindViewById2 != null) {
                                            i2 = R.id.extra_info;
                                            TextView textView2 = (TextView) view.findViewById(R.id.extra_info);
                                            if (textView2 != null) {
                                                i2 = R.id.integrations_root;
                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.integrations_root);
                                                if (linearLayout != null) {
                                                    i2 = R.id.label;
                                                    TextView textView3 = (TextView) view.findViewById(R.id.label);
                                                    if (textView3 != null) {
                                                        i2 = R.id.sync_friends_switch;
                                                        SwitchMaterial switchMaterial3 = (SwitchMaterial) view.findViewById(R.id.sync_friends_switch);
                                                        if (switchMaterial3 != null) {
                                                            WidgetSettingsItemConnectedAccountBinding widgetSettingsItemConnectedAccountBinding = new WidgetSettingsItemConnectedAccountBinding((CardView) view, imageView, viewFindViewById, imageView2, textView, switchMaterial, switchMaterial2, viewFindViewById2, textView2, linearLayout, textView3, switchMaterial3);
                                                            Intrinsics3.checkNotNullExpressionValue(widgetSettingsItemConnectedAccountBinding, "WidgetSettingsItemConnec…untBinding.bind(itemView)");
                                                            this.binding = widgetSettingsItemConnectedAccountBinding;
                                                            return;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
            }

            private final void updateUserConnection(ConnectedAccount connectedAccount) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                StoreUserConnections userConnections = companion.getUserConnections();
                SwitchMaterial switchMaterial = this.binding.i;
                Intrinsics3.checkNotNullExpressionValue(switchMaterial, "binding.syncFriendsSwitch");
                boolean zIsChecked = switchMaterial.isChecked();
                SwitchMaterial switchMaterial2 = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(switchMaterial2, "binding.displayActivitySwitch");
                boolean zIsChecked2 = switchMaterial2.isChecked();
                SwitchMaterial switchMaterial3 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(switchMaterial3, "binding.displaySwitch");
                userConnections.updateUserConnection(connectedAccount, zIsChecked, zIsChecked2, switchMaterial3.isChecked());
                if (Intrinsics3.areEqual(connectedAccount.getType(), Platform.SPOTIFY.getPlatformId())) {
                    SwitchMaterial switchMaterial4 = this.binding.e;
                    Intrinsics3.checkNotNullExpressionValue(switchMaterial4, "binding.displayActivitySwitch");
                    if (switchMaterial4.isChecked()) {
                        return;
                    }
                    StoreUserPresence.updateActivity$default(companion.getPresences(), ActivityType.LISTENING, null, false, 4, null);
                }
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            @SuppressLint({"DefaultLocale"})
            public void onConfigure(int position, final UserConnectionItem data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                final ConnectedAccount connection = data.getConnectedAccount().getConnection();
                final Platform platformFrom = Platform.INSTANCE.from(connection);
                final String id2 = connection.getId();
                this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.connections.WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UriHandler.handle$default(UriHandler.INSTANCE, outline.x(view, "view", "view.context"), platformFrom.getProfileUrl(data.getConnectedAccount().getConnection()), false, false, null, 28, null);
                    }
                });
                ImageView imageView = this.binding.c;
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                Integer themedPlatformImage = platformFrom.getThemedPlatformImage();
                imageView.setImageResource(DrawableCompat.getThemedDrawableRes$default(view, themedPlatformImage != null ? themedPlatformImage.intValue() : 0, 0, 2, (Object) null));
                ImageView imageView2 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.connectedAccountImg");
                imageView2.setContentDescription(platformFrom.name());
                TextView textView = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.connectedAccountName");
                textView.setText(connection.getName());
                this.binding.f2626b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.connections.WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        NoticeBuilders.INSTANCE.showNotice(outline.x(view2, "v", "v.context"), this.this$0.getFragmentManager(), new StoreNotices.Dialog(StoreNotices.Dialog.Type.DELETE_CONNECTION_MODAL, Maps6.mapOf(Tuples.to(WidgetSettingsUserConnections.PLATFORM_NAME, connection.getType()), Tuples.to(WidgetSettingsUserConnections.PLATFORM_TITLE, platformFrom.getProperName()), Tuples.to(WidgetSettingsUserConnections.CONNECTION_ID, id2))));
                    }
                });
                this.binding.f.setOnCheckedChangeListener(null);
                SwitchMaterial switchMaterial = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(switchMaterial, "binding.displaySwitch");
                switchMaterial.setChecked(connection.getVisibility() == 1);
                this.binding.f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.discord.widgets.settings.connections.WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$3
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                        this.updateUserConnection(connection);
                    }
                });
                this.binding.i.setOnCheckedChangeListener(null);
                SwitchMaterial switchMaterial2 = this.binding.i;
                Intrinsics3.checkNotNullExpressionValue(switchMaterial2, "binding.syncFriendsSwitch");
                switchMaterial2.setVisibility(platformFrom.getCanSyncFriends() ? 0 : 8);
                SwitchMaterial switchMaterial3 = this.binding.i;
                Intrinsics3.checkNotNullExpressionValue(switchMaterial3, "binding.syncFriendsSwitch");
                switchMaterial3.setChecked(connection.getFriendSync());
                this.binding.i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.discord.widgets.settings.connections.WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$4
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                        this.updateUserConnection(connection);
                    }
                });
                this.binding.e.setOnCheckedChangeListener(null);
                SwitchMaterial switchMaterial4 = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(switchMaterial4, "binding.displayActivitySwitch");
                switchMaterial4.setVisibility(platformFrom.getCanShowActivity() ? 0 : 8);
                SwitchMaterial switchMaterial5 = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(switchMaterial5, "binding.displayActivitySwitch");
                FormatUtils.m(switchMaterial5, R.string.display_activity, new Object[]{StringsJVM.capitalize(platformFrom.getProperName())}, (4 & 4) != 0 ? FormatUtils.g.j : null);
                SwitchMaterial switchMaterial6 = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(switchMaterial6, "binding.displayActivitySwitch");
                switchMaterial6.setChecked(connection.getShowActivity());
                this.binding.e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.discord.widgets.settings.connections.WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$5
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                        this.updateUserConnection(connection);
                    }
                });
                if (Intrinsics3.areEqual(connection.getType(), Platform.SPOTIFY.getPlatformId())) {
                    TextView textView2 = this.binding.g;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.extraInfo");
                    textView2.setVisibility(0);
                    TextView textView3 = this.binding.g;
                    Intrinsics3.checkNotNullExpressionValue(textView3, "binding.extraInfo");
                    FormatUtils.m(textView3, R.string.spotify_connection_info_android, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
                    this.binding.g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.connections.WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            SpotifyHelper.INSTANCE.openSpotifyApp(this.this$0.this$0.getContext());
                        }
                    });
                } else {
                    TextView textView4 = this.binding.g;
                    Intrinsics3.checkNotNullExpressionValue(textView4, "binding.extraInfo");
                    textView4.setVisibility(8);
                }
                List<ConnectedAccountIntegration> listC = connection.c();
                if (listC == null || listC.isEmpty()) {
                    LinearLayout linearLayout = this.binding.h;
                    Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.integrationsRoot");
                    linearLayout.setVisibility(8);
                    return;
                }
                LinearLayout linearLayout2 = this.binding.h;
                Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.integrationsRoot");
                linearLayout2.setVisibility(0);
                int iIndexOfChild = this.binding.h.indexOfChild(this.binding.h.findViewById(R.id.label));
                if (iIndexOfChild != -1) {
                    LinearLayout linearLayout3 = this.binding.h;
                    int i = iIndexOfChild + 1;
                    Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.integrationsRoot");
                    linearLayout3.removeViewsInLayout(i, linearLayout3.getChildCount() - i);
                }
                List<ConnectedAccountIntegration> listC2 = connection.c();
                if (listC2 != null) {
                    for (final ConnectedAccountIntegration connectedAccountIntegration : listC2) {
                        LinearLayout linearLayout4 = this.binding.h;
                        ConnectionsGuildIntegrationView connectionsGuildIntegrationView = new ConnectionsGuildIntegrationView(this.this$0.getContext(), null);
                        connectionsGuildIntegrationView.setIntegrationData(connectedAccountIntegration, data.getConnectedAccount().getIntegrationGuildJoinStatus().get(connectedAccountIntegration.getId()));
                        connectionsGuildIntegrationView.setJoinClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.connections.WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$7
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                this.this$0.getOnJoinIntegration().invoke(connectedAccountIntegration.getId());
                            }
                        });
                        linearLayout4.addView(connectionsGuildIntegrationView);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Adapter(RecyclerView recyclerView, FragmentManager fragmentManager, Function1<? super String, Unit> function1) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(function1, "onJoinIntegration");
            this.fragmentManager = fragmentManager;
            this.onJoinIntegration = function1;
        }

        public final FragmentManager getFragmentManager() {
            return this.fragmentManager;
        }

        public final Function1<String, Unit> getOnJoinIntegration() {
            return this.onJoinIntegration;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<Adapter, UserConnectionItem> onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return new ViewHolder(this, R.layout.widget_settings_item_connected_account, this);
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsUserConnections.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
    public static final class UserConnectionItem implements MGRecyclerDataPayload {
        private final WidgetSettingsUserConnectionsViewModel.ConnectionState connectedAccount;
        private final String key;
        private final int type;

        public UserConnectionItem(WidgetSettingsUserConnectionsViewModel.ConnectionState connectionState) {
            Intrinsics3.checkNotNullParameter(connectionState, "connectedAccount");
            this.connectedAccount = connectionState;
            this.key = connectionState.getConnection().getId();
        }

        public final WidgetSettingsUserConnectionsViewModel.ConnectionState getConnectedAccount() {
            return this.connectedAccount;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnections$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetSettingsUserConnectionsViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsUserConnectionsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetSettingsUserConnectionsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetSettingsUserConnections.this.handleViewState(viewState);
        }
    }

    public WidgetSettingsUserConnections() {
        super(R.layout.widget_settings_connections);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsUserConnections$binding$2.INSTANCE, null, 2, null);
        WidgetSettingsUserConnections$viewModel$2 widgetSettingsUserConnections$viewModel$2 = WidgetSettingsUserConnections$viewModel$2.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetSettingsUserConnectionsViewModel.class), new WidgetSettingsUserConnections$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetSettingsUserConnections$viewModel$2));
    }

    private final WidgetSettingsConnectionsBinding getBinding() {
        return (WidgetSettingsConnectionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetSettingsUserConnectionsViewModel getViewModel() {
        return (WidgetSettingsUserConnectionsViewModel) this.viewModel.getValue();
    }

    private final void handleViewState(WidgetSettingsUserConnectionsViewModel.ViewState viewState) {
        Adapter adapter = this.adapter;
        int pageSize = adapter != null ? adapter.getPageSize() : 0;
        if (viewState instanceof WidgetSettingsUserConnectionsViewModel.ViewState.Uninitialized) {
            TextView textView = getBinding().f2614b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.connectionsEmpty");
            textView.setVisibility(8);
            RecyclerView recyclerView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.connectionsRecycler");
            recyclerView.setVisibility(8);
            return;
        }
        if (viewState instanceof WidgetSettingsUserConnectionsViewModel.ViewState.Empty) {
            TextView textView2 = getBinding().f2614b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.connectionsEmpty");
            textView2.setVisibility(0);
            RecyclerView recyclerView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.connectionsRecycler");
            recyclerView2.setVisibility(8);
            return;
        }
        if (viewState instanceof WidgetSettingsUserConnectionsViewModel.ViewState.Loaded) {
            TextView textView3 = getBinding().f2614b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.connectionsEmpty");
            textView3.setVisibility(8);
            RecyclerView recyclerView3 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.connectionsRecycler");
            recyclerView3.setVisibility(0);
            List<WidgetSettingsUserConnectionsViewModel.ConnectionState> data = ((WidgetSettingsUserConnectionsViewModel.ViewState.Loaded) viewState).getData();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(data, 10));
            Iterator<T> it = data.iterator();
            while (it.hasNext()) {
                arrayList.add(new UserConnectionItem((WidgetSettingsUserConnectionsViewModel.ConnectionState) it.next()));
            }
            Adapter adapter2 = this.adapter;
            if (adapter2 != null) {
                adapter2.setData(arrayList);
            }
            if (pageSize == 0 || arrayList.size() <= pageSize) {
                return;
            }
            getBinding().c.smoothScrollToPosition(arrayList.size() - 1);
        }
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        FragmentActivity fragmentActivityE = e();
        if (fragmentActivityE != null) {
            MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
            RecyclerView recyclerView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.connectionsRecycler");
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityE, "it");
            FragmentManager supportFragmentManager = fragmentActivityE.getSupportFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "it.supportFragmentManager");
            this.adapter = (Adapter) companion.configure(new Adapter(recyclerView, supportFragmentManager, new WidgetSettingsUserConnections$onViewBound$$inlined$let$lambda$1(this)));
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.connections);
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_connections, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.settings.connections.WidgetSettingsUserConnections.onViewBound.2
            @Override // rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() == R.id.menu_add_connections && WidgetSettingsUserConnections.this.getContext() != null) {
                    WidgetSettingsUserConnectionsAdd.INSTANCE.show(WidgetSettingsUserConnections.this);
                }
            }
        }, null, 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetSettingsUserConnections.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
