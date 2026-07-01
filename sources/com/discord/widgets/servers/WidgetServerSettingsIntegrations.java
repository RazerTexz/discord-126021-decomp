package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsIntegrationsBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetServerSettingsIntegrations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsIntegrations extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsIntegrations.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsIntegrationsBinding;", 0)};
    public static final WidgetServerSettingsIntegrations$Companion Companion = new WidgetServerSettingsIntegrations$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final int VIEW_INDEX_INTEGRATION_LIST = 0;
    private static final int VIEW_INDEX_NO_INTEGRATIONS = 1;
    private WidgetServerSettingsIntegrations$Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    public WidgetServerSettingsIntegrations() {
        super(R$layout.widget_server_settings_integrations);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsIntegrations$binding$2.INSTANCE, null, 2, null);
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsIntegrations$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsIntegrations widgetServerSettingsIntegrations, WidgetServerSettingsIntegrations$Model widgetServerSettingsIntegrations$Model) {
        widgetServerSettingsIntegrations.configureUI(widgetServerSettingsIntegrations$Model);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void configureUI(WidgetServerSettingsIntegrations$Model model) {
        if (model == null) {
            return;
        }
        setActionBarTitle(2131892094);
        setActionBarSubtitle(model.getGuildName());
        AppViewFlipper appViewFlipper = getBinding().c;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.integrationsViewFlipper");
        appViewFlipper.setDisplayedChild(model.getIntegrations().isEmpty() ? 1 : 0);
        WidgetServerSettingsIntegrations$Adapter widgetServerSettingsIntegrations$Adapter = this.adapter;
        if (widgetServerSettingsIntegrations$Adapter != null) {
            widgetServerSettingsIntegrations$Adapter.configure(model.getIntegrations(), new WidgetServerSettingsIntegrations$configureUI$1(this, model));
        }
    }

    public static final void create(Context context, long j) {
        Companion.create(context, j);
    }

    private final WidgetServerSettingsIntegrationsBinding getBinding() {
        return (WidgetServerSettingsIntegrationsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        StoreStream.Companion.getGuildIntegrations().onIntegrationScreenClosed();
        super.onPause();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        StoreStream.Companion.getGuildIntegrations().onIntegrationScreenOpened(longExtra);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetServerSettingsIntegrations$Model.Companion.get(longExtra), this, null, 2, null), WidgetServerSettingsIntegrations.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsIntegrations$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().f2577b;
        m.checkNotNullExpressionValue(recyclerView, "binding.integrationsRecycler");
        this.adapter = (WidgetServerSettingsIntegrations$Adapter) mGRecyclerAdapter$Companion.configure(new WidgetServerSettingsIntegrations$Adapter(recyclerView));
    }
}
