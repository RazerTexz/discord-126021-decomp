package com.discord.widgets.hubs.events;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.directory.DirectoryEntryEvent;
import com.discord.app.AppBottomSheet;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetHubEventsPageBinding;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.stores.utilities.Success;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetHubEventsPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPage extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetHubEventsPage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubEventsPageBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final HubEventsEventListener listener;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetHubEventsPage.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId, long directoryChannelId) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetHubEventsPage widgetHubEventsPage = new WidgetHubEventsPage();
            widgetHubEventsPage.setArguments(C1460d.m514e2(new HubEventsArgs(guildId, directoryChannelId)));
            widgetHubEventsPage.show(fragmentManager, WidgetHubEventsPage.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPage$configUI$3 */
    /* JADX INFO: compiled from: WidgetHubEventsPage.kt */
    public static final class C90533 extends AbstractC12240o implements Function1<Success<? extends List<? extends DirectoryEntryEvent>>, Unit> {
        public C90533() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Success<? extends List<? extends DirectoryEntryEvent>> success) {
            invoke2((Success<? extends List<DirectoryEntryEvent>>) success);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Success<? extends List<DirectoryEntryEvent>> success) {
            C12238m.checkNotNullParameter(success, "it");
            WidgetHubEventsPage.this.getBinding().f17186b.smoothScrollToPosition(0);
            WidgetHubEventsPage.this.getViewModel().reset();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPage$onResume$1 */
    /* JADX INFO: compiled from: WidgetHubEventsPage.kt */
    public static final /* synthetic */ class C90541 extends C12236k implements Function1<WidgetHubEventsState, Unit> {
        public C90541(WidgetHubEventsPage widgetHubEventsPage) {
            super(1, widgetHubEventsPage, WidgetHubEventsPage.class, "configUI", "configUI(Lcom/discord/widgets/hubs/events/WidgetHubEventsState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubEventsState widgetHubEventsState) {
            invoke2(widgetHubEventsState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubEventsState widgetHubEventsState) {
            C12238m.checkNotNullParameter(widgetHubEventsState, "p1");
            ((WidgetHubEventsPage) this.receiver).configUI(widgetHubEventsState);
        }
    }

    public WidgetHubEventsPage() {
        super(false, 1, null);
        this.args = C12083g.lazy(new WidgetHubEventsPage$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubEventsPage$binding$2.INSTANCE, null, 2, null);
        WidgetHubEventsPage$viewModel$2 widgetHubEventsPage$viewModel$2 = new WidgetHubEventsPage$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetHubEventsViewModel.class), new WidgetHubEventsPage$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetHubEventsPage$viewModel$2));
        this.listener = new WidgetHubEventsPage$listener$1(this);
        this.adapter = C12083g.lazy(new WidgetHubEventsPage$adapter$2(this));
        this.loggingConfig = new LoggingConfig(false, null, new WidgetHubEventsPage$loggingConfig$1(this), 3);
    }

    private final void configUI(WidgetHubEventsState state) {
        if (!state.getEventsData().isEmpty() || (state.getEventsAsync() instanceof Success)) {
            WidgetHubEventsPageAdapter adapter = getAdapter();
            HubEventsPage.Header header = HubEventsPage.Header.INSTANCE;
            if (!state.getShowHeader()) {
                header = null;
            }
            List listListOfNotNull = C12147n.listOfNotNull(header);
            List<HubGuildScheduledEventData> eventsData = state.getEventsData();
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(eventsData, 10));
            Iterator<T> it = eventsData.iterator();
            while (it.hasNext()) {
                arrayList.add(new HubEventsPage.Event((HubGuildScheduledEventData) it.next()));
            }
            adapter.setItems(C12163u.plus((Collection<? extends HubEventsPage.Footer>) C12163u.plus((Collection) listListOfNotNull, (Iterable) arrayList), new HubEventsPage.Footer(state.getEventsAsync())));
            TextView textView = getBinding().f17187c;
            C12238m.checkNotNullExpressionValue(textView, "binding.title");
            Context context = getContext();
            textView.setText(context != null ? StringResourceUtilsKt.getI18nPluralString(context, C5419R.plurals.guild_events_plural_number, state.getEventsData().size(), Integer.valueOf(state.getEventsData().size())) : null);
            RestCallState<List<DirectoryEntryEvent>> eventsAsync = state.getEventsAsync();
            Context contextRequireContext = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            RestCallStateKt.handleResponse$default(eventsAsync, contextRequireContext, null, null, new C90533(), 6, null);
        }
    }

    public final WidgetHubEventsPageAdapter getAdapter() {
        return (WidgetHubEventsPageAdapter) this.adapter.getValue();
    }

    public final HubEventsArgs getArgs() {
        return (HubEventsArgs) this.args.getValue();
    }

    public final WidgetHubEventsPageBinding getBinding() {
        return (WidgetHubEventsPageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_hub_events_page;
    }

    public final HubEventsEventListener getListener() {
        return this.listener;
    }

    @Override // com.discord.app.AppBottomSheet, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    public final WidgetHubEventsViewModel getViewModel() {
        return (WidgetHubEventsViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetHubEventsPage.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C90541(this));
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().f17186b;
        recyclerView.setAdapter(getAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }
}
