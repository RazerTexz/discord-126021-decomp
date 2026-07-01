package com.discord.widgets.settings.developer;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsDeveloperBinding;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import com.discord.utilities.bugreports.BugReportManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.CheckedSetting;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsDeveloper.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsDeveloperBinding;", 0)};
    public static final WidgetSettingsDeveloper$Companion Companion = new WidgetSettingsDeveloper$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ExperimentOverridesAdapter experimentOverridesAdapter;

    public WidgetSettingsDeveloper() {
        super(R$layout.widget_settings_developer);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsDeveloper$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ ExperimentOverridesAdapter access$getExperimentOverridesAdapter$p(WidgetSettingsDeveloper widgetSettingsDeveloper) {
        ExperimentOverridesAdapter experimentOverridesAdapter = widgetSettingsDeveloper.experimentOverridesAdapter;
        if (experimentOverridesAdapter == null) {
            m.throwUninitializedPropertyAccessException("experimentOverridesAdapter");
        }
        return experimentOverridesAdapter;
    }

    public static final /* synthetic */ void access$setExperimentOverridesAdapter$p(WidgetSettingsDeveloper widgetSettingsDeveloper, ExperimentOverridesAdapter experimentOverridesAdapter) {
        widgetSettingsDeveloper.experimentOverridesAdapter = experimentOverridesAdapter;
    }

    private final WidgetSettingsDeveloperBinding getBinding() {
        return (WidgetSettingsDeveloperBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        Companion.launch(context);
    }

    private final void setupCrashes() {
        getBinding().d.setOnClickListener(WidgetSettingsDeveloper$setupCrashes$1.INSTANCE);
        getBinding().c.setOnClickListener(new WidgetSettingsDeveloper$setupCrashes$2(this));
        getBinding().f2615b.setOnClickListener(new WidgetSettingsDeveloper$setupCrashes$3(this));
        getBinding().g.setOnClickListener(new WidgetSettingsDeveloper$setupCrashes$4(this));
    }

    private final void setupExperimentSection() {
        this.experimentOverridesAdapter = new ExperimentOverridesAdapter();
        RecyclerView recyclerView = getBinding().e;
        m.checkNotNullExpressionValue(recyclerView, "binding.developerSettingsExperiments");
        ExperimentOverridesAdapter experimentOverridesAdapter = this.experimentOverridesAdapter;
        if (experimentOverridesAdapter == null) {
            m.throwUninitializedPropertyAccessException("experimentOverridesAdapter");
        }
        recyclerView.setAdapter(experimentOverridesAdapter);
        StoreExperiments experiments = StoreStream.Companion.getExperiments();
        Observable<R> observableG = experiments.observeOverrides().G(new WidgetSettingsDeveloper$setupExperimentSection$1(experiments));
        m.checkNotNullExpressionValue(observableG, "experimentStore\n        …              }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableG, this, null, 2, null), WidgetSettingsDeveloper.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsDeveloper$setupExperimentSection$2(this), 62, (Object) null);
    }

    private final void setupNoticesSection() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(null, WidgetSettingsDeveloper$setupNoticesSection$noticesAdapter$1.INSTANCE, 1, null);
        RecyclerView recyclerView = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView, "binding.developerSettingsNotices");
        recyclerView.setAdapter(simpleRecyclerAdapter);
        new WidgetSettingsDeveloper$setupNoticesSection$1(this).invoke().attachToRecyclerView(getBinding().f);
        Observable<R> observableG = StoreStream.Companion.getNotices().observeNoticesSeen().G(WidgetSettingsDeveloper$setupNoticesSection$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "StoreStream\n        .get…      .toList()\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableG), this, null, 2, null), WidgetSettingsDeveloper.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsDeveloper$setupNoticesSection$3(simpleRecyclerAdapter), 62, (Object) null);
    }

    private final void setupScreenshotDetector() {
        BugReportManager bugReportManager = BugReportManager.Companion.get();
        CheckedSetting checkedSetting = getBinding().h;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsDeveloperScreenshotBugReporting");
        checkedSetting.setChecked(bugReportManager.getSettingsEnabled());
        getBinding().h.setOnCheckedListener(new WidgetSettingsDeveloper$setupScreenshotDetector$1(bugReportManager));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(2131888436);
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
