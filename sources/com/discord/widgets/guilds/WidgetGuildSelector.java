package com.discord.widgets.guilds;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildSelectorBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.z.d.m;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetGuildSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildSelector extends AppBottomSheet {
    private static final String ARG_FILTER_FUNCTION = "INTENT_EXTRA_FILTER_FUNCTION";
    private static final String ARG_INCLUDE_NO_GUILD = "INTENT_EXTRA_INCLUDE_NO_GUILD";
    private static final String ARG_NO_GUILD_STRING_ID = "INTENT_EXTRA_NO_GUILD_STRING_ID";
    private static final String ARG_REQUEST_KEY = "INTENT_EXTRA_REQUEST_CODE";
    private static final String REQUEST_KEY_DEFAULT = "GUILD_SELECTOR_DEFAULT_REQUEST_KEY";
    private static final String RESULT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String RESULT_EXTRA_GUILD_NAME = "INTENT_EXTRA_GUILD_NAME";
    private WidgetGuildSelector$Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: requestKey$delegate, reason: from kotlin metadata */
    private final Lazy requestKey;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildSelector.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildSelectorBinding;", 0)};
    public static final WidgetGuildSelector$Companion Companion = new WidgetGuildSelector$Companion(null);

    public WidgetGuildSelector() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildSelector$binding$2.INSTANCE, null, 2, null);
        this.requestKey = g.lazy(new WidgetGuildSelector$requestKey$2(this));
    }

    public static final /* synthetic */ WidgetGuildSelector$Adapter access$getAdapter$p(WidgetGuildSelector widgetGuildSelector) {
        WidgetGuildSelector$Adapter widgetGuildSelector$Adapter = widgetGuildSelector.adapter;
        if (widgetGuildSelector$Adapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        return widgetGuildSelector$Adapter;
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetGuildSelector widgetGuildSelector) {
        return widgetGuildSelector.getArgumentsOrDefault();
    }

    public static final /* synthetic */ void access$onGuildSelected(WidgetGuildSelector widgetGuildSelector, Guild guild) {
        widgetGuildSelector.onGuildSelected(guild);
    }

    public static final /* synthetic */ void access$setAdapter$p(WidgetGuildSelector widgetGuildSelector, WidgetGuildSelector$Adapter widgetGuildSelector$Adapter) {
        widgetGuildSelector.adapter = widgetGuildSelector$Adapter;
    }

    private final Observable<List<WidgetGuildSelector$Item>> get(boolean includeNoGuild, WidgetGuildSelector$FilterFunction filterFunction) {
        Observable<R> observableG = StoreStream.Companion.getGuildsSorted().observeOrderedGuilds().G(new WidgetGuildSelector$get$1(filterFunction, includeNoGuild));
        m.checkNotNullExpressionValue(observableG, "StoreStream.getGuildsSor….map { Item(it) }\n      }");
        Observable<List<WidgetGuildSelector$Item>> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream.getGuildsSor…  .distinctUntilChanged()");
        return observableR;
    }

    private final WidgetGuildSelectorBinding getBinding() {
        return (WidgetGuildSelectorBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getRequestKey() {
        return (String) this.requestKey.getValue();
    }

    private final void onGuildSelected(Guild guild) {
        String requestKey = getRequestKey();
        m.checkNotNullExpressionValue(requestKey, "requestKey");
        Bundle bundle = new Bundle();
        bundle.putLong("INTENT_EXTRA_GUILD_ID", guild != null ? guild.getId() : -1L);
        bundle.putString(RESULT_EXTRA_GUILD_NAME, guild != null ? guild.getName() : null);
        FragmentKt.setFragmentResult(this, requestKey, bundle);
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        boolean z2 = getArgumentsOrDefault().getBoolean(ARG_INCLUDE_NO_GUILD, false);
        Serializable serializable = getArgumentsOrDefault().getSerializable(ARG_FILTER_FUNCTION);
        if (!(serializable instanceof WidgetGuildSelector$FilterFunction)) {
            serializable = null;
        }
        WidgetGuildSelector$FilterFunction widgetGuildSelector$BaseFilterFunction = (WidgetGuildSelector$FilterFunction) serializable;
        if (widgetGuildSelector$BaseFilterFunction == null) {
            widgetGuildSelector$BaseFilterFunction = new WidgetGuildSelector$BaseFilterFunction();
        }
        Observable<List<WidgetGuildSelector$Item>> observable = get(z2, widgetGuildSelector$BaseFilterFunction);
        WidgetGuildSelector$Adapter widgetGuildSelector$Adapter = this.adapter;
        if (widgetGuildSelector$Adapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observable, this, widgetGuildSelector$Adapter), WidgetGuildSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildSelector$bindSubscriptions$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_guild_selector;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().f2451b;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildSelectorList");
        this.adapter = (WidgetGuildSelector$Adapter) mGRecyclerAdapter$Companion.configure(new WidgetGuildSelector$Adapter(recyclerView, this, getArgumentsOrDefault().getInt(ARG_NO_GUILD_STRING_ID)));
    }
}
