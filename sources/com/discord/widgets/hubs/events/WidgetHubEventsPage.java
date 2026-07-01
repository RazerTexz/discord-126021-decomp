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
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.directory.DirectoryEntryGuild2;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetHubEventsPageBinding;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.hubs.events.WidgetHubEventsPageAdapter2;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
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
import rx.Subscription;

/* JADX INFO: compiled from: WidgetHubEventsPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPage extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetHubEventsPage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubEventsPageBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final WidgetHubEventsPage3 listener;
    private final AppLogger2 loggingConfig;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetHubEventsPage.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId, long directoryChannelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetHubEventsPage widgetHubEventsPage = new WidgetHubEventsPage();
            widgetHubEventsPage.setArguments(AnimatableValueParser.e2(new WidgetHubEventsPage2(guildId, directoryChannelId)));
            widgetHubEventsPage.show(fragmentManager, WidgetHubEventsPage.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPage$configUI$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubEventsPage.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<RestCallState6<? extends List<? extends DirectoryEntryGuild2>>, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends List<? extends DirectoryEntryGuild2>> restCallState6) {
            invoke2((RestCallState6<? extends List<DirectoryEntryGuild2>>) restCallState6);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<? extends List<DirectoryEntryGuild2>> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
            WidgetHubEventsPage.this.getBinding().f2477b.smoothScrollToPosition(0);
            WidgetHubEventsPage.this.getViewModel().reset();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPage$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubEventsPage.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetHubEventsViewModel3, Unit> {
        public AnonymousClass1(WidgetHubEventsPage widgetHubEventsPage) {
            super(1, widgetHubEventsPage, WidgetHubEventsPage.class, "configUI", "configUI(Lcom/discord/widgets/hubs/events/WidgetHubEventsState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubEventsViewModel3 widgetHubEventsViewModel3) {
            invoke2(widgetHubEventsViewModel3);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubEventsViewModel3 widgetHubEventsViewModel3) {
            Intrinsics3.checkNotNullParameter(widgetHubEventsViewModel3, "p1");
            ((WidgetHubEventsPage) this.receiver).configUI(widgetHubEventsViewModel3);
        }
    }

    public WidgetHubEventsPage() {
        super(false, 1, null);
        this.args = LazyJVM.lazy(new WidgetHubEventsPage$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubEventsPage5.INSTANCE, null, 2, null);
        WidgetHubEventsPage9 widgetHubEventsPage9 = new WidgetHubEventsPage9(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubEventsViewModel.class), new WidgetHubEventsPage$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetHubEventsPage9));
        this.listener = new WidgetHubEventsPage6(this);
        this.adapter = LazyJVM.lazy(new WidgetHubEventsPage4(this));
        this.loggingConfig = new AppLogger2(false, null, new WidgetHubEventsPage8(this), 3);
    }

    private final void configUI(WidgetHubEventsViewModel3 state) {
        if (!state.getEventsData().isEmpty() || (state.getEventsAsync() instanceof RestCallState6)) {
            WidgetHubEventsPageAdapter adapter = getAdapter();
            WidgetHubEventsPageAdapter2.Header header = WidgetHubEventsPageAdapter2.Header.INSTANCE;
            if (!state.getShowHeader()) {
                header = null;
            }
            List listListOfNotNull = Collections2.listOfNotNull(header);
            List<WidgetHubEventsViewModel2> eventsData = state.getEventsData();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(eventsData, 10));
            Iterator<T> it = eventsData.iterator();
            while (it.hasNext()) {
                arrayList.add(new WidgetHubEventsPageAdapter2.Event((WidgetHubEventsViewModel2) it.next()));
            }
            adapter.setItems(_Collections.plus((Collection<? extends WidgetHubEventsPageAdapter2.Footer>) _Collections.plus((Collection) listListOfNotNull, (Iterable) arrayList), new WidgetHubEventsPageAdapter2.Footer(state.getEventsAsync())));
            TextView textView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.title");
            Context context = getContext();
            textView.setText(context != null ? StringResourceUtils.getI18nPluralString(context, R.plurals.guild_events_plural_number, state.getEventsData().size(), Integer.valueOf(state.getEventsData().size())) : null);
            RestCallState<List<DirectoryEntryGuild2>> eventsAsync = state.getEventsAsync();
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            RestCallState5.handleResponse$default(eventsAsync, contextRequireContext, null, null, new AnonymousClass3(), 6, null);
        }
    }

    public final WidgetHubEventsPageAdapter getAdapter() {
        return (WidgetHubEventsPageAdapter) this.adapter.getValue();
    }

    public final WidgetHubEventsPage2 getArgs() {
        return (WidgetHubEventsPage2) this.args.getValue();
    }

    public final WidgetHubEventsPageBinding getBinding() {
        return (WidgetHubEventsPageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_hub_events_page;
    }

    public final WidgetHubEventsPage3 getListener() {
        return this.listener;
    }

    @Override // com.discord.app.AppBottomSheet, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final WidgetHubEventsViewModel getViewModel() {
        return (WidgetHubEventsViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetHubEventsPage.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().f2477b;
        recyclerView.setAdapter(getAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }
}
