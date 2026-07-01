package com.discord.widgets.bugreports;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.y.c0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.bugreport.Feature;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetBugReportBinding;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$DistinctChangeDetector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.SearchInputView;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import d0.g;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import java.io.InputStream;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import okhttp3.MediaType;
import okhttp3.MediaType$a;
import okhttp3.RequestBody;
import okhttp3.RequestBody$Companion;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetBugReport extends AppFragment {
    public static final String INTENT_EXTRA_SCREENSHOT_FILENAME = "extra_screenshot_filename";
    public static final String INTENT_EXTRA_SCREENSHOT_URI = "extra_screenshot_uri";
    public static final int VIEW_INDEX_FEATURE_AREA = 2;
    public static final int VIEW_INDEX_REPORT = 0;
    public static final int VIEW_INDEX_STATUS = 1;
    private boolean backHandlerAdded;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BugReportFeatureAdapter featuresAdapter;
    private final MGImages$DistinctChangeDetector imagesChangeDetector;

    /* JADX INFO: renamed from: items$delegate, reason: from kotlin metadata */
    private final Lazy items;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetBugReport.class, "binding", "getBinding()Lcom/discord/databinding/WidgetBugReportBinding;", 0)};
    public static final WidgetBugReport$Companion Companion = new WidgetBugReport$Companion(null);
    private static final List<Priority> priorityLevels = n.listOf((Object[]) new Priority[]{new Priority(2131887318, 2131887317, 801497159479722084L), new Priority(2131887320, 2131887319, 410336837563973632L), new Priority(2131887322, 2131887321, 841420679643529296L), new Priority(2131887324, 2131887323, 827645852352512021L)});

    public WidgetBugReport() {
        super(R$layout.widget_bug_report);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetBugReport$binding$2.INSTANCE, null, 2, null);
        WidgetBugReport$viewModel$2 widgetBugReport$viewModel$2 = new WidgetBugReport$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(BugReportViewModel.class), new WidgetBugReport$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetBugReport$viewModel$2));
        this.featuresAdapter = new BugReportFeatureAdapter(new WidgetBugReport$featuresAdapter$1(this));
        this.imagesChangeDetector = new MGImages$DistinctChangeDetector();
        this.items = g.lazy(new WidgetBugReport$items$2(this));
        this.validationManager = g.lazy(new WidgetBugReport$validationManager$2(this));
    }

    public static final /* synthetic */ boolean access$getBackHandlerAdded$p(WidgetBugReport widgetBugReport) {
        return widgetBugReport.backHandlerAdded;
    }

    public static final /* synthetic */ WidgetBugReportBinding access$getBinding$p(WidgetBugReport widgetBugReport) {
        return widgetBugReport.getBinding();
    }

    public static final /* synthetic */ List access$getPriorityLevels$cp() {
        return priorityLevels;
    }

    public static final /* synthetic */ BugReportViewModel access$getViewModel$p(WidgetBugReport widgetBugReport) {
        return widgetBugReport.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetBugReport widgetBugReport, BugReportViewModel$Event bugReportViewModel$Event) {
        widgetBugReport.handleEvent(bugReportViewModel$Event);
    }

    public static final /* synthetic */ void access$setBackHandlerAdded$p(WidgetBugReport widgetBugReport, boolean z2) {
        widgetBugReport.backHandlerAdded = z2;
    }

    public static final /* synthetic */ void access$submit(WidgetBugReport widgetBugReport) {
        widgetBugReport.submit();
    }

    private final WidgetBugReportBinding getBinding() {
        return (WidgetBugReportBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final BugReportViewModel getViewModel() {
        return (BugReportViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(BugReportViewModel$Event event) {
        AppActivity appActivity;
        if (!m.areEqual(event, BugReportViewModel$Event$CloseReport.INSTANCE) || (appActivity = getAppActivity()) == null) {
            return;
        }
        appActivity.finish();
    }

    private final void submit() {
        InputStream inputStreamOpenInputStream;
        byte[] bytes;
        RequestBody requestBodyD = null;
        MediaType mediaTypeA = null;
        requestBodyD = null;
        requestBodyD = null;
        requestBodyD = null;
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            Uri screenshotUri = getViewModel().getScreenshotUri();
            if (getViewModel().getUseScreenshot() && screenshotUri.getPath() != null && (inputStreamOpenInputStream = requireContext().getContentResolver().openInputStream(screenshotUri)) != null && (bytes = d0.y.a.readBytes(inputStreamOpenInputStream)) != null) {
                RequestBody$Companion requestBody$Companion = RequestBody.Companion;
                String type = requireContext().getContentResolver().getType(screenshotUri);
                if (type != null) {
                    MediaType$a mediaType$a = MediaType.c;
                    mediaTypeA = MediaType$a.a(type);
                }
                requestBodyD = RequestBody$Companion.d(requestBody$Companion, bytes, mediaTypeA, 0, 0, 6);
            }
            getViewModel().sendReport(requestBodyD);
        }
    }

    public final BugReportFeatureAdapter getFeaturesAdapter() {
        return this.featuresAdapter;
    }

    public final List<c0> getItems() {
        return (List) this.items.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewModel().prefetchStickers(requireContext());
    }

    public final void onFeatureClickListener(Feature feature) {
        m.checkNotNullParameter(feature, "feature");
        getViewModel().selectFeatureArea(feature);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarTitle(2131896094);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        Uri uri = Uri.parse(getMostRecentIntent().getStringExtra(INTENT_EXTRA_SCREENSHOT_URI));
        RecyclerView recyclerView = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView, "binding.bugReportFeatureRecycler");
        recyclerView.setAdapter(this.featuresAdapter);
        getBinding().l.setImageURI(uri);
        getBinding().f2241b.setOnClickListener(new WidgetBugReport$onViewBound$1(this));
        TextInputLayout textInputLayout = getBinding().h;
        m.checkNotNullExpressionValue(textInputLayout, "binding.bugReportName");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetBugReport$onViewBound$2(this));
        TextInputLayout textInputLayout2 = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.bugReportDescription");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new WidgetBugReport$onViewBound$3(this));
        getBinding().g.a(this, new WidgetBugReport$onViewBound$4(this));
        getBinding().q.setOnClickListener(new WidgetBugReport$onViewBound$5(this));
        getBinding().t.setOnClickListener(new WidgetBugReport$onViewBound$6(this));
        getBinding().f2242s.setOnClickListener(new WidgetBugReport$onViewBound$7(this));
        getBinding().o.setOnClickListener(new WidgetBugReport$onViewBound$8(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetBugReport.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetBugReport$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetBugReport.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetBugReport$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }

    public final void updateView(BugReportViewModel$ViewState viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        if (!(viewState instanceof BugReportViewModel$ViewState$Report)) {
            if (viewState instanceof BugReportViewModel$ViewState$Sending) {
                AppViewFlipper appViewFlipper = getBinding().p;
                m.checkNotNullExpressionValue(appViewFlipper, "binding.bugReportSwitchFlipper");
                appViewFlipper.setDisplayedChild(1);
                StickerView.e(getBinding().m, getViewModel().getSendingSticker(), null, 2);
                getBinding().n.setText(2131887328);
                return;
            }
            if (viewState instanceof BugReportViewModel$ViewState$Success) {
                AppViewFlipper appViewFlipper2 = getBinding().p;
                m.checkNotNullExpressionValue(appViewFlipper2, "binding.bugReportSwitchFlipper");
                appViewFlipper2.setDisplayedChild(1);
                StickerView.e(getBinding().m, getViewModel().getSuccessSticker(), null, 2);
                getBinding().n.setText(2131887329);
                return;
            }
            if (viewState instanceof BugReportViewModel$ViewState$SelectFeature) {
                setActionBarTitle(2131887326);
                setActionBarSubtitle(2131896094);
                AppViewFlipper appViewFlipper3 = getBinding().p;
                m.checkNotNullExpressionValue(appViewFlipper3, "binding.bugReportSwitchFlipper");
                appViewFlipper3.setDisplayedChild(2);
                ProgressBar progressBar = getBinding().e;
                m.checkNotNullExpressionValue(progressBar, "binding.bugReportFeatureLoader");
                BugReportViewModel$ViewState$SelectFeature bugReportViewModel$ViewState$SelectFeature = (BugReportViewModel$ViewState$SelectFeature) viewState;
                progressBar.setVisibility(bugReportViewModel$ViewState$SelectFeature.getLoadingFeatures() ? 0 : 8);
                RecyclerView recyclerView = getBinding().f;
                m.checkNotNullExpressionValue(recyclerView, "binding.bugReportFeatureRecycler");
                recyclerView.setVisibility(bugReportViewModel$ViewState$SelectFeature.getLoadingFeatures() ^ true ? 0 : 8);
                View editText = getBinding().g.getEditText();
                if (!(editText instanceof TextInputLayout)) {
                    editText = null;
                }
                TextInputLayout textInputLayout = (TextInputLayout) editText;
                if (textInputLayout != null) {
                    EditText editText2 = textInputLayout.getEditText();
                    String strValueOf = String.valueOf(editText2 != null ? editText2.getText() : null);
                    String query = bugReportViewModel$ViewState$SelectFeature.getQuery();
                    if (query == null) {
                        query = "";
                    }
                    if (!m.areEqual(strValueOf, query)) {
                        SearchInputView searchInputView = getBinding().g;
                        String query2 = bugReportViewModel$ViewState$SelectFeature.getQuery();
                        searchInputView.setText(query2 != null ? query2 : "");
                    }
                }
                this.featuresAdapter.setData(bugReportViewModel$ViewState$SelectFeature.getFeatures());
                if (this.backHandlerAdded) {
                    return;
                }
                this.backHandlerAdded = true;
                AppFragment.setOnBackPressed$default(this, new WidgetBugReport$updateView$4(this), 0, 2, null);
                return;
            }
            return;
        }
        setActionBarTitle(2131896094);
        setActionBarSubtitle("");
        AppViewFlipper appViewFlipper4 = getBinding().p;
        m.checkNotNullExpressionValue(appViewFlipper4, "binding.bugReportSwitchFlipper");
        appViewFlipper4.setDisplayedChild(0);
        MaterialTextView materialTextView = getBinding().r;
        m.checkNotNullExpressionValue(materialTextView, "binding.submitReportError");
        BugReportViewModel$ViewState$Report bugReportViewModel$ViewState$Report = (BugReportViewModel$ViewState$Report) viewState;
        materialTextView.setVisibility(bugReportViewModel$ViewState$Report.getError() != null ? 0 : 8);
        if (bugReportViewModel$ViewState$Report.getError() != null) {
            MaterialTextView materialTextView2 = getBinding().r;
            m.checkNotNullExpressionValue(materialTextView2, "binding.submitReportError");
            Error$Response response = bugReportViewModel$ViewState$Report.getError().getResponse();
            m.checkNotNullExpressionValue(response, "viewState.error.response");
            materialTextView2.setText(response.getMessage());
        }
        TextInputLayout textInputLayout2 = getBinding().h;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.bugReportName");
        ViewExtensions.setTextIfDifferent(textInputLayout2, bugReportViewModel$ViewState$Report.getReportName());
        TextInputLayout textInputLayout3 = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.bugReportDescription");
        ViewExtensions.setTextIfDifferent(textInputLayout3, bugReportViewModel$ViewState$Report.getReportDescription());
        AppCompatImageView appCompatImageView = getBinding().l;
        m.checkNotNullExpressionValue(appCompatImageView, "binding.bugReportScreenshot");
        appCompatImageView.setVisibility(bugReportViewModel$ViewState$Report.getUseScreenshot() ^ true ? 4 : 0);
        AppCompatImageView appCompatImageView2 = getBinding().f2241b;
        m.checkNotNullExpressionValue(appCompatImageView2, "binding.bugReportClearScreenshot");
        appCompatImageView2.setVisibility(bugReportViewModel$ViewState$Report.getUseScreenshot() ? 0 : 8);
        MaterialTextView materialTextView3 = getBinding().i;
        m.checkNotNullExpressionValue(materialTextView3, "binding.bugReportNoScreenshotLabel");
        materialTextView3.setVisibility(bugReportViewModel$ViewState$Report.getUseScreenshot() ^ true ? 0 : 8);
        MaterialButton materialButton = getBinding().q;
        m.checkNotNullExpressionValue(materialButton, "binding.bugReportUndoScreenshotRemove");
        materialButton.setVisibility(bugReportViewModel$ViewState$Report.getUseScreenshot() ^ true ? 0 : 8);
        Feature feature = bugReportViewModel$ViewState$Report.getFeature();
        if (feature != null) {
            TextInputLayout textInputLayout4 = getBinding().d;
            m.checkNotNullExpressionValue(textInputLayout4, "binding.bugReportFeatureArea");
            ViewExtensions.setTextIfDifferent(textInputLayout4, feature.getName());
        }
        Integer priority = bugReportViewModel$ViewState$Report.getPriority();
        if (priority != null) {
            int iIntValue = priority.intValue();
            TextInputLayout textInputLayout5 = getBinding().j;
            m.checkNotNullExpressionValue(textInputLayout5, "binding.bugReportPriority");
            ViewExtensions.setText(textInputLayout5, priorityLevels.get(iIntValue).getTitle());
            SimpleDraweeView simpleDraweeView = getBinding().k;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.bugReportPriorityIcon");
            MGImages.setImage$default(simpleDraweeView, getItems().get(iIntValue).d(), 2131165401, 2131165401, true, null, this.imagesChangeDetector, 32, null);
        }
    }
}
