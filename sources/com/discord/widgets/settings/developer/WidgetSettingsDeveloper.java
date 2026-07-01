package com.discord.widgets.settings.developer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.IconListItemTextViewBinding;
import com.discord.databinding.WidgetSettingsDeveloperBinding;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import com.discord.utilities.bugreports.BugReportManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.experiments.ExperimentRegistry;
import com.discord.utilities.experiments.ExperimentRegistry2;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.utilities.views.SwipeableItemTouchHelper;
import com.discord.views.CheckedSetting;
import com.discord.widgets.settings.developer.ExperimentOverridesAdapter;
import com.discord.widgets.settings.developer.WidgetSettingsDeveloper;
import com.hammerandchisel.libdiscord.Discord;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t._Maps;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsDeveloper.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsDeveloperBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ExperimentOverridesAdapter experimentOverridesAdapter;

    /* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsDeveloper.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
    public static final class NoticeViewHolder extends SimpleRecyclerAdapter.ViewHolder<Tuples2<? extends String, ? extends Long>> {
        private final IconListItemTextViewBinding binding;
        public String noticeName;

        /* JADX WARN: Illegal instructions before constructor call */
        public NoticeViewHolder(IconListItemTextViewBinding iconListItemTextViewBinding) {
            Intrinsics3.checkNotNullParameter(iconListItemTextViewBinding, "binding");
            TextView textView = iconListItemTextViewBinding.a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            super(textView);
            this.binding = iconListItemTextViewBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public /* bridge */ /* synthetic */ void bind(Tuples2<? extends String, ? extends Long> tuples2) {
            bind2((Tuples2<String, Long>) tuples2);
        }

        public final String getNoticeName() {
            String str = this.noticeName;
            if (str == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("noticeName");
            }
            return str;
        }

        public final void setNoticeName(String str) {
            Intrinsics3.checkNotNullParameter(str, "<set-?>");
            this.noticeName = str;
        }

        @SuppressLint({"SetTextI18n"})
        /* JADX INFO: renamed from: bind, reason: avoid collision after fix types in other method */
        public void bind2(Tuples2<String, Long> data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            String strComponent1 = data.component1();
            long jLongValue = data.component2().longValue();
            this.noticeName = strComponent1;
            TextView textView = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
            CharSequence readableTimeString$default = TimeUtils.toReadableTimeString$default(context, jLongValue, null, 4, null);
            TextView textView2 = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.root");
            textView2.setText(strComponent1 + " @ " + readableTimeString$default);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
    public static final class AnonymousClass1<T, R> implements Func1<Map<String, ? extends Integer>, List<? extends 1.1>> {
        public final /* synthetic */ StoreExperiments $experimentStore;

        public AnonymousClass1(StoreExperiments storeExperiments) {
            this.$experimentStore = storeExperiments;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends 1.1> call(Map<String, ? extends Integer> map) {
            return call2((Map<String, Integer>) map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final List<1.1> call2(final Map<String, Integer> map) {
            Collection<ExperimentRegistry2> collectionValues = ExperimentRegistry.INSTANCE.getRegisteredExperiments().values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues, "ExperimentRegistry\n     …nts\n              .values");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collectionValues, 10));
            for (final ExperimentRegistry2 experimentRegistry2 : collectionValues) {
                arrayList.add(new ExperimentOverridesAdapter.Item(this, map) { // from class: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1
                    public final /* synthetic */ Map $allOverrides$inlined;
                    private final String apiName;
                    private final List<String> bucketDescriptions;
                    private final String name;
                    private final Integer overrideBucket;
                    public final /* synthetic */ WidgetSettingsDeveloper.AnonymousClass1 this$0;
                    private final Function1<Integer, Unit> onOverrideBucketSelected = new AnonymousClass1();
                    private final Function0<Unit> onOverrideBucketCleared = new AnonymousClass2();

                    /* JADX INFO: renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
                    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
                        public AnonymousClass1() {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.a;
                        }

                        public final void invoke(int i) {
                            WidgetSettingsDeveloper3 widgetSettingsDeveloper3 = WidgetSettingsDeveloper3.this;
                            widgetSettingsDeveloper3.this$0.$experimentStore.setOverride(widgetSettingsDeveloper3.$registeredExperiment.getName(), i);
                        }
                    }

                    /* JADX INFO: renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
                    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
                        public AnonymousClass2() {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            WidgetSettingsDeveloper3 widgetSettingsDeveloper3 = WidgetSettingsDeveloper3.this;
                            widgetSettingsDeveloper3.this$0.$experimentStore.clearOverride(widgetSettingsDeveloper3.$registeredExperiment.getName());
                        }
                    }

                    {
                        this.this$0 = this;
                        this.$allOverrides$inlined = map;
                        this.name = this.$registeredExperiment.getReadableName();
                        this.apiName = this.$registeredExperiment.getName();
                        this.overrideBucket = (Integer) map.get(this.$registeredExperiment.getName());
                        this.bucketDescriptions = this.$registeredExperiment.getBuckets();
                    }

                    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
                    public String getApiName() {
                        return this.apiName;
                    }

                    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
                    public List<String> getBucketDescriptions() {
                        return this.bucketDescriptions;
                    }

                    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
                    public String getName() {
                        return this.name;
                    }

                    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
                    public Function0<Unit> getOnOverrideBucketCleared() {
                        return this.onOverrideBucketCleared;
                    }

                    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
                    public Function1<Integer, Unit> getOnOverrideBucketSelected() {
                        return this.onOverrideBucketSelected;
                    }

                    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
                    public Integer getOverrideBucket() {
                        return this.overrideBucket;
                    }
                });
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends AnonymousClass1.1.1>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends AnonymousClass1.1.1> list) {
            invoke2((List<AnonymousClass1.1.1>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<AnonymousClass1.1.1> list) {
            ExperimentOverridesAdapter experimentOverridesAdapterAccess$getExperimentOverridesAdapter$p = WidgetSettingsDeveloper.access$getExperimentOverridesAdapter$p(WidgetSettingsDeveloper.this);
            Intrinsics3.checkNotNullExpressionValue(list, "data");
            experimentOverridesAdapterAccess$getExperimentOverridesAdapter$p.setData(list);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupNoticesSection$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<ItemTouchHelper> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ItemTouchHelper invoke() {
            final SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration = new SwipeableItemTouchHelper.SwipeRevealConfiguration(ColorCompat.getColor(WidgetSettingsDeveloper.this, R.color.status_red_500), ContextCompat.getDrawable(WidgetSettingsDeveloper.this.requireContext(), R.drawable.ic_delete_white_24dp), DimenUtils.dpToPixels(8));
            return new ItemTouchHelper(new SwipeableItemTouchHelper(swipeRevealConfiguration, swipeRevealConfiguration) { // from class: com.discord.widgets.settings.developer.WidgetSettingsDeveloper.setupNoticesSection.1.1
                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                    Intrinsics3.checkNotNullParameter(viewHolder, "viewHolder");
                    if (viewHolder instanceof NoticeViewHolder) {
                        StoreStream.INSTANCE.getNotices().clearSeen(((NoticeViewHolder) viewHolder).getNoticeName());
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupNoticesSection$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<List<? extends Tuples2<? extends String, ? extends Long>>, Unit> {
        public final /* synthetic */ SimpleRecyclerAdapter $noticesAdapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(SimpleRecyclerAdapter simpleRecyclerAdapter) {
            super(1);
            this.$noticesAdapter = simpleRecyclerAdapter;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Tuples2<? extends String, ? extends Long>> list) {
            invoke2((List<Tuples2<String, Long>>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Tuples2<String, Long>> list) {
            SimpleRecyclerAdapter simpleRecyclerAdapter = this.$noticesAdapter;
            Intrinsics3.checkNotNullExpressionValue(list, "noticesSeenMap");
            simpleRecyclerAdapter.setData(list);
        }
    }

    public WidgetSettingsDeveloper() {
        super(R.layout.widget_settings_developer);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsDeveloper2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ ExperimentOverridesAdapter access$getExperimentOverridesAdapter$p(WidgetSettingsDeveloper widgetSettingsDeveloper) {
        ExperimentOverridesAdapter experimentOverridesAdapter = widgetSettingsDeveloper.experimentOverridesAdapter;
        if (experimentOverridesAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("experimentOverridesAdapter");
        }
        return experimentOverridesAdapter;
    }

    private final WidgetSettingsDeveloperBinding getBinding() {
        return (WidgetSettingsDeveloperBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    private final void setupCrashes() {
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.developer.WidgetSettingsDeveloper.setupCrashes.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                throw new RuntimeException("This is a developer triggered crash.");
            }
        });
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.developer.WidgetSettingsDeveloper.setupCrashes.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    throw new RuntimeException("This is a developer triggered crash (caught).");
                } catch (Exception e) {
                    Logger.e$default(AppLog.g, "setupCrashes", e, null, 4, null);
                    AppToast.j(WidgetSettingsDeveloper.this, "Done.", 0, 4);
                }
            }
        });
        getBinding().f2615b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.developer.WidgetSettingsDeveloper.setupCrashes.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Context context = WidgetSettingsDeveloper.this.getContext();
                Objects.requireNonNull(context, "null cannot be cast to non-null type android.content.Context");
                new Discord(context).crash();
            }
        });
        getBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.developer.WidgetSettingsDeveloper.setupCrashes.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreStream.INSTANCE.getGatewaySocket().simulateReconnectForTesting();
                AppToast.j(WidgetSettingsDeveloper.this, "Done.", 0, 4);
            }
        });
    }

    private final void setupExperimentSection() {
        this.experimentOverridesAdapter = new ExperimentOverridesAdapter();
        RecyclerView recyclerView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.developerSettingsExperiments");
        ExperimentOverridesAdapter experimentOverridesAdapter = this.experimentOverridesAdapter;
        if (experimentOverridesAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("experimentOverridesAdapter");
        }
        recyclerView.setAdapter(experimentOverridesAdapter);
        StoreExperiments experiments = StoreStream.INSTANCE.getExperiments();
        Observable<R> observableG = experiments.observeOverrides().G(new AnonymousClass1(experiments));
        Intrinsics3.checkNotNullExpressionValue(observableG, "experimentStore\n        …              }\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableG, this, null, 2, null), (Class<?>) WidgetSettingsDeveloper.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    private final void setupNoticesSection() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(null, WidgetSettingsDeveloper4.INSTANCE, 1, null);
        RecyclerView recyclerView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.developerSettingsNotices");
        recyclerView.setAdapter(simpleRecyclerAdapter);
        new AnonymousClass1().invoke().attachToRecyclerView(getBinding().f);
        Observable<R> observableG = StoreStream.INSTANCE.getNotices().observeNoticesSeen().G(new Func1<HashMap<String, Long>, List<? extends Tuples2<? extends String, ? extends Long>>>() { // from class: com.discord.widgets.settings.developer.WidgetSettingsDeveloper.setupNoticesSection.2
            @Override // j0.k.Func1
            public final List<Tuples2<String, Long>> call(HashMap<String, Long> map) {
                Intrinsics3.checkNotNullExpressionValue(map, "noticesSeenMap");
                return _Maps.toList(MapsJVM.toSortedMap(map));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream\n        .get…      .toList()\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableG), this, null, 2, null), (Class<?>) WidgetSettingsDeveloper.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3(simpleRecyclerAdapter));
    }

    private final void setupScreenshotDetector() {
        final BugReportManager bugReportManager = BugReportManager.INSTANCE.get();
        CheckedSetting checkedSetting = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsDeveloperScreenshotBugReporting");
        checkedSetting.setChecked(bugReportManager.getSettingsEnabled());
        getBinding().h.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.developer.WidgetSettingsDeveloper.setupScreenshotDetector.1
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                BugReportManager bugReportManager2 = bugReportManager;
                Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
                bugReportManager2.setBugReportingSettingEnabled(bool.booleanValue());
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(R.string.developer_options);
        setupCrashes();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        setupScreenshotDetector();
        setupExperimentSection();
        setupNoticesSection();
    }
}
