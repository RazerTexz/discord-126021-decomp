package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsRolesBinding;
import com.discord.restapi.RestAPIParams$Role;
import com.discord.utilities.mg_recycler.DragAndDropHelper;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoles extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsRoles.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsRolesBinding;", 0)};
    public static final WidgetServerSettingsRoles$Companion Companion = new WidgetServerSettingsRoles$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private WidgetServerSettingsRolesAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private ItemTouchHelper itemTouchHelper;
    private final LoggingConfig loggingConfig;

    public WidgetServerSettingsRoles() {
        super(R$layout.widget_server_settings_roles);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsRoles$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetServerSettingsRoles$guildId$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsRoles$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsRoles widgetServerSettingsRoles, WidgetServerSettingsRoles$Model widgetServerSettingsRoles$Model) {
        widgetServerSettingsRoles.configureUI(widgetServerSettingsRoles$Model);
    }

    public static final /* synthetic */ void access$createRole(WidgetServerSettingsRoles widgetServerSettingsRoles, long j, WidgetServerSettingsRoles$Model widgetServerSettingsRoles$Model) {
        widgetServerSettingsRoles.createRole(j, widgetServerSettingsRoles$Model);
    }

    public static final /* synthetic */ void access$processRoleDrop(WidgetServerSettingsRoles widgetServerSettingsRoles, Map map, WidgetServerSettingsRoles$Model widgetServerSettingsRoles$Model) {
        widgetServerSettingsRoles.processRoleDrop(map, widgetServerSettingsRoles$Model);
    }

    private final void configureUI(WidgetServerSettingsRoles$Model data) throws Exception {
        if ((data != null ? data.getRoleItems() : null) == null || data.getRoleItems().isEmpty()) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        setActionBarTitle(2131895161);
        setActionBarSubtitle(data.getGuildName());
        WidgetServerSettingsRolesAdapter widgetServerSettingsRolesAdapter = this.adapter;
        if (widgetServerSettingsRolesAdapter != null) {
            widgetServerSettingsRolesAdapter.configure(data.getRoleItems(), new WidgetServerSettingsRoles$configureUI$1(this, data), new WidgetServerSettingsRoles$configureUI$2(this, data));
        }
        if (data.getCanManageRoles() && data.getElevated()) {
            getBinding().c.setOnClickListener(new WidgetServerSettingsRoles$configureUI$3(this, data));
            getBinding().c.show();
        } else {
            getBinding().c.hide();
            getBinding().c.setOnClickListener(null);
        }
    }

    private final void createRole(long guildId, WidgetServerSettingsRoles$Model dataSnapshot) {
        Observable observableY = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().createRole(guildId), false, 1, null).Y(new WidgetServerSettingsRoles$createRole$1(guildId));
        m.checkNotNullExpressionValue(observableY, "RestAPI\n        .api\n   … rolesMap[id] }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 3, null), this, null, 2, null), WidgetServerSettingsRoles.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsRoles$createRole$2(this, guildId, dataSnapshot), 60, (Object) null);
    }

    private final WidgetServerSettingsRolesBinding getBinding() {
        return (WidgetServerSettingsRolesBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final void processRoleDrop(Map<String, Integer> newPositions, WidgetServerSettingsRoles$Model dataSnapshot) {
        Set<String> setKeySet = newPositions.keySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setKeySet.iterator();
        while (true) {
            RestAPIParams$Role restAPIParams$RoleCreateForPosition = null;
            if (!it.hasNext()) {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().batchUpdateRole(dataSnapshot.getGuildId(), arrayList), false, 1, null), this, null, 2, null), getBinding().f2585b, 0L, 2, null), WidgetServerSettingsRoles.class, getContext(), (Function1) null, new WidgetServerSettingsRoles$processRoleDrop$2(this, dataSnapshot), (Function0) null, (Function0) null, new WidgetServerSettingsRoles$processRoleDrop$1(this), 52, (Object) null);
                return;
            }
            String str = (String) it.next();
            Integer num = newPositions.get(str);
            if (num != null) {
                restAPIParams$RoleCreateForPosition = RestAPIParams$Role.Companion.createForPosition(Long.parseLong(str), num.intValue());
            }
            if (restAPIParams$RoleCreateForPosition != null) {
                arrayList.add(restAPIParams$RoleCreateForPosition);
            }
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().d;
        m.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsRolesRecycler");
        this.adapter = (WidgetServerSettingsRolesAdapter) mGRecyclerAdapter$Companion.configure(new WidgetServerSettingsRolesAdapter(recyclerView));
        ItemTouchHelper itemTouchHelper = this.itemTouchHelper;
        if (itemTouchHelper != null && itemTouchHelper != null) {
            itemTouchHelper.attachToRecyclerView(null);
        }
        WidgetServerSettingsRolesAdapter widgetServerSettingsRolesAdapter = this.adapter;
        m.checkNotNull(widgetServerSettingsRolesAdapter);
        ItemTouchHelper itemTouchHelper2 = new ItemTouchHelper(new DragAndDropHelper(widgetServerSettingsRolesAdapter, 0, 2, null));
        this.itemTouchHelper = itemTouchHelper2;
        if (itemTouchHelper2 != null) {
            itemTouchHelper2.attachToRecyclerView(getBinding().d);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(WidgetServerSettingsRoles$Model.Companion.get(getGuildId())), this, null, 2, null), WidgetServerSettingsRoles.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsRoles$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
