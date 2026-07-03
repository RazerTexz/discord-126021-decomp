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
import com.discord.C5419R;
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
import com.discord.utilities.experiments.RegisteredExperiment;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.utilities.views.SwipeableItemTouchHelper;
import com.discord.views.CheckedSetting;
import com.discord.widgets.settings.developer.ExperimentOverridesAdapter;
import com.discord.widgets.settings.developer.WidgetSettingsDeveloper;
import com.hammerandchisel.libdiscord.Discord;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12138i0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsDeveloper.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsDeveloperBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetSettingsDeveloper.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
    public static final class NoticeViewHolder extends SimpleRecyclerAdapter.ViewHolder<Pair<? extends String, ? extends Long>> {
        private final IconListItemTextViewBinding binding;
        public String noticeName;

        /* JADX WARN: Illegal instructions before constructor call */
        public NoticeViewHolder(IconListItemTextViewBinding iconListItemTextViewBinding) {
            C12238m.checkNotNullParameter(iconListItemTextViewBinding, "binding");
            TextView textView = iconListItemTextViewBinding.f15165a;
            C12238m.checkNotNullExpressionValue(textView, "binding.root");
            super(textView);
            this.binding = iconListItemTextViewBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public /* bridge */ /* synthetic */ void bind(Pair<? extends String, ? extends Long> pair) {
            bind2((Pair<String, Long>) pair);
        }

        public final String getNoticeName() {
            String str = this.noticeName;
            if (str == null) {
                C12238m.throwUninitializedPropertyAccessException("noticeName");
            }
            return str;
        }

        public final void setNoticeName(String str) {
            C12238m.checkNotNullParameter(str, "<set-?>");
            this.noticeName = str;
        }

        @SuppressLint({"SetTextI18n"})
        /* JADX INFO: renamed from: bind, reason: avoid collision after fix types in other method */
        public void bind2(Pair<String, Long> data) {
            C12238m.checkNotNullParameter(data, "data");
            String strComponent1 = data.component1();
            long jLongValue = data.component2().longValue();
            this.noticeName = strComponent1;
            TextView textView = this.binding.f15165a;
            C12238m.checkNotNullExpressionValue(textView, "binding.root");
            Context context = textView.getContext();
            C12238m.checkNotNullExpressionValue(context, "binding.root.context");
            CharSequence readableTimeString$default = TimeUtils.toReadableTimeString$default(context, jLongValue, null, 4, null);
            TextView textView2 = this.binding.f15165a;
            C12238m.checkNotNullExpressionValue(textView2, "binding.root");
            textView2.setText(strComponent1 + " @ " + readableTimeString$default);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1 */
    /* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
    public static final class C98481<T, R> implements InterfaceC12589b<Map<String, ? extends Integer>, List<? extends 1.1>> {
        public final /* synthetic */ StoreExperiments $experimentStore;

        public C98481(StoreExperiments storeExperiments) {
            this.$experimentStore = storeExperiments;
        }

        @Override // p637j0.p641k.InterfaceC12589b
        public /* bridge */ /* synthetic */ List<? extends 1.1> call(Map<String, ? extends Integer> map) {
            return call2((Map<String, Integer>) map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final List<1.1> call2(final Map<String, Integer> map) {
            Collection<RegisteredExperiment> collectionValues = ExperimentRegistry.INSTANCE.getRegisteredExperiments().values();
            C12238m.checkNotNullExpressionValue(collectionValues, "ExperimentRegistry\n     …nts\n              .values");
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(collectionValues, 10));
            for (final RegisteredExperiment registeredExperiment : collectionValues) {
                arrayList.add(new ExperimentOverridesAdapter.Item(this, map) { // from class: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1
                    public final /* synthetic */ Map $allOverrides$inlined;
                    private final String apiName;
                    private final List<String> bucketDescriptions;
                    private final String name;
                    private final Integer overrideBucket;
                    public final /* synthetic */ WidgetSettingsDeveloper.C98481 this$0;
                    private final Function1<Integer, Unit> onOverrideBucketSelected = new AnonymousClass1();
                    private final Function0<Unit> onOverrideBucketCleared = new AnonymousClass2();

                    /* JADX INFO: renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
                    public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Integer, Unit> {
                        public AnonymousClass1() {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.f27425a;
                        }

                        public final void invoke(int i) {
                            C9849x7b0c2b35 c9849x7b0c2b35 = C9849x7b0c2b35.this;
                            c9849x7b0c2b35.this$0.$experimentStore.setOverride(c9849x7b0c2b35.$registeredExperiment.getName(), i);
                        }
                    }

                    /* JADX INFO: renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
                    public static final class AnonymousClass2 extends AbstractC12240o implements Function0<Unit> {
                        public AnonymousClass2() {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.f27425a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            C9849x7b0c2b35 c9849x7b0c2b35 = C9849x7b0c2b35.this;
                            c9849x7b0c2b35.this$0.$experimentStore.clearOverride(c9849x7b0c2b35.$registeredExperiment.getName());
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

    /* JADX INFO: renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$2 */
    /* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
    public static final class C98502 extends AbstractC12240o implements Function1<List<? extends C98481.1.1>, Unit> {
        public C98502() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends C98481.1.1> list) {
            invoke2((List<C98481.1.1>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<C98481.1.1> list) {
            ExperimentOverridesAdapter experimentOverridesAdapterAccess$getExperimentOverridesAdapter$p = WidgetSettingsDeveloper.access$getExperimentOverridesAdapter$p(WidgetSettingsDeveloper.this);
            C12238m.checkNotNullExpressionValue(list, "data");
            experimentOverridesAdapterAccess$getExperimentOverridesAdapter$p.setData(list);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupNoticesSection$1 */
    /* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
    public static final class C98511 extends AbstractC12240o implements Function0<ItemTouchHelper> {
        public C98511() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ItemTouchHelper invoke() {
            final SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration = new SwipeableItemTouchHelper.SwipeRevealConfiguration(ColorCompat.getColor(WidgetSettingsDeveloper.this, C5419R.color.status_red_500), ContextCompat.getDrawable(WidgetSettingsDeveloper.this.requireContext(), C5419R.drawable.ic_delete_white_24dp), DimenUtils.dpToPixels(8));
            return new ItemTouchHelper(new SwipeableItemTouchHelper(swipeRevealConfiguration, swipeRevealConfiguration) { // from class: com.discord.widgets.settings.developer.WidgetSettingsDeveloper.setupNoticesSection.1.1
                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                    C12238m.checkNotNullParameter(viewHolder, "viewHolder");
                    if (viewHolder instanceof NoticeViewHolder) {
                        StoreStream.INSTANCE.getNotices().clearSeen(((NoticeViewHolder) viewHolder).getNoticeName());
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupNoticesSection$3 */
    /* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
    public static final class C98533 extends AbstractC12240o implements Function1<List<? extends Pair<? extends String, ? extends Long>>, Unit> {
        public final /* synthetic */ SimpleRecyclerAdapter $noticesAdapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C98533(SimpleRecyclerAdapter simpleRecyclerAdapter) {
            super(1);
            this.$noticesAdapter = simpleRecyclerAdapter;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Pair<? extends String, ? extends Long>> list) {
            invoke2((List<Pair<String, Long>>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Pair<String, Long>> list) {
            SimpleRecyclerAdapter simpleRecyclerAdapter = this.$noticesAdapter;
            C12238m.checkNotNullExpressionValue(list, "noticesSeenMap");
            simpleRecyclerAdapter.setData(list);
        }
    }

    public WidgetSettingsDeveloper() {
        super(C5419R.layout.widget_settings_developer);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsDeveloper$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ ExperimentOverridesAdapter access$getExperimentOverridesAdapter$p(WidgetSettingsDeveloper widgetSettingsDeveloper) {
        ExperimentOverridesAdapter experimentOverridesAdapter = widgetSettingsDeveloper.experimentOverridesAdapter;
        if (experimentOverridesAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("experimentOverridesAdapter");
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
        getBinding().f17938d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.developer.WidgetSettingsDeveloper.setupCrashes.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                throw new RuntimeException("This is a developer triggered crash.");
            }
        });
        getBinding().f17937c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.developer.WidgetSettingsDeveloper.setupCrashes.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    throw new RuntimeException("This is a developer triggered crash (caught).");
                } catch (Exception e) {
                    Logger.e$default(AppLog.f14950g, "setupCrashes", e, null, 4, null);
                    C0876m.m172j(WidgetSettingsDeveloper.this, "Done.", 0, 4);
                }
            }
        });
        getBinding().f17936b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.developer.WidgetSettingsDeveloper.setupCrashes.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Context context = WidgetSettingsDeveloper.this.getContext();
                Objects.requireNonNull(context, "null cannot be cast to non-null type android.content.Context");
                new Discord(context).crash();
            }
        });
        getBinding().f17941g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.developer.WidgetSettingsDeveloper.setupCrashes.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreStream.INSTANCE.getGatewaySocket().simulateReconnectForTesting();
                C0876m.m172j(WidgetSettingsDeveloper.this, "Done.", 0, 4);
            }
        });
    }

    private final void setupExperimentSection() {
        this.experimentOverridesAdapter = new ExperimentOverridesAdapter();
        RecyclerView recyclerView = getBinding().f17939e;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.developerSettingsExperiments");
        ExperimentOverridesAdapter experimentOverridesAdapter = this.experimentOverridesAdapter;
        if (experimentOverridesAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("experimentOverridesAdapter");
        }
        recyclerView.setAdapter(experimentOverridesAdapter);
        StoreExperiments experiments = StoreStream.INSTANCE.getExperiments();
        Observable<R> observableM11083G = experiments.observeOverrides().m11083G(new C98481(experiments));
        C12238m.checkNotNullExpressionValue(observableM11083G, "experimentStore\n        …              }\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11083G, this, null, 2, null), (Class<?>) WidgetSettingsDeveloper.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C98502());
    }

    private final void setupNoticesSection() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(null, WidgetSettingsDeveloper$setupNoticesSection$noticesAdapter$1.INSTANCE, 1, null);
        RecyclerView recyclerView = getBinding().f17940f;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.developerSettingsNotices");
        recyclerView.setAdapter(simpleRecyclerAdapter);
        new C98511().invoke().attachToRecyclerView(getBinding().f17940f);
        Observable<R> observableM11083G = StoreStream.INSTANCE.getNotices().observeNoticesSeen().m11083G(new InterfaceC12589b<HashMap<String, Long>, List<? extends Pair<? extends String, ? extends Long>>>() { // from class: com.discord.widgets.settings.developer.WidgetSettingsDeveloper.setupNoticesSection.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final List<Pair<String, Long>> call(HashMap<String, Long> map) {
                C12238m.checkNotNullExpressionValue(map, "noticesSeenMap");
                return C12138i0.toList(C12134g0.toSortedMap(map));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "StoreStream\n        .get…      .toList()\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11083G), this, null, 2, null), (Class<?>) WidgetSettingsDeveloper.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C98533(simpleRecyclerAdapter));
    }

    private final void setupScreenshotDetector() {
        final BugReportManager bugReportManager = BugReportManager.INSTANCE.get();
        CheckedSetting checkedSetting = getBinding().f17942h;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsDeveloperScreenshotBugReporting");
        checkedSetting.setChecked(bugReportManager.getSettingsEnabled());
        getBinding().f17942h.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.developer.WidgetSettingsDeveloper.setupScreenshotDetector.1
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                BugReportManager bugReportManager2 = bugReportManager;
                C12238m.checkNotNullExpressionValue(bool, "isChecked");
                bugReportManager2.setBugReportingSettingEnabled(bool.booleanValue());
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(C5419R.string.developer_options);
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
