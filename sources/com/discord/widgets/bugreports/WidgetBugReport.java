package com.discord.widgets.bugreports;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.bugreport.Feature;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetBugReportBinding;
import com.discord.screenshot_detection.ScreenshotDetector;
import com.discord.utilities.error.Error;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
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
import java.io.InputStream;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p062y.C1322b0;
import p007b.p008a.p062y.C1324c0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12147n;
import p507d0.p591y.C12200a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Func0;

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
    private final MGImages.DistinctChangeDetector imagesChangeDetector;

    /* JADX INFO: renamed from: items$delegate, reason: from kotlin metadata */
    private final Lazy items;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetBugReport.class, "binding", "getBinding()Lcom/discord/databinding/WidgetBugReportBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Priority> priorityLevels = C12147n.listOf((Object[]) new Priority[]{new Priority(C5419R.string.bug_report_priority_critical_title, C5419R.string.bug_report_priority_critical_description, 801497159479722084L), new Priority(C5419R.string.bug_report_priority_high_title, C5419R.string.bug_report_priority_high_description, 410336837563973632L), new Priority(C5419R.string.bug_report_priority_low_title, C5419R.string.bug_report_priority_low_description, 841420679643529296L), new Priority(C5419R.string.bug_report_priority_very_low_title, C5419R.string.bug_report_priority_very_low_description, 827645852352512021L)});

    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final class Companion {
        private Companion() {
        }

        public final List<Priority> getPriorityLevels() {
            return WidgetBugReport.priorityLevels;
        }

        public final void launch(Context context, ScreenshotDetector.Screenshot screenshot) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(screenshot, "screenshot");
            Intent intent = new Intent();
            intent.putExtra(WidgetBugReport.INTENT_EXTRA_SCREENSHOT_URI, screenshot.androidx.core.app.NotificationCompat.MessagingStyle.Message.KEY_DATA_URI java.lang.String.toString());
            intent.putExtra(WidgetBugReport.INTENT_EXTRA_SCREENSHOT_FILENAME, screenshot.filename);
            C0870j.m156d(context, WidgetBugReport.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final class C72902 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C72902() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "it");
            WidgetBugReport.this.getViewModel().updateReportName(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final class C72913 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C72913() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "it");
            WidgetBugReport.this.getViewModel().updateReportDescription(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final class C72924 extends AbstractC12240o implements Function1<String, Unit> {
        public C72924() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "it");
            WidgetBugReport.this.getViewModel().m11400filterFeatures(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final class C72971 extends AbstractC12240o implements Function1<BugReportViewModel.ViewState, Unit> {
        public C72971() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BugReportViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BugReportViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetBugReport.this.updateView(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final /* synthetic */ class C72982 extends C12236k implements Function1<BugReportViewModel.Event, Unit> {
        public C72982(WidgetBugReport widgetBugReport) {
            super(1, widgetBugReport, WidgetBugReport.class, "handleEvent", "handleEvent(Lcom/discord/widgets/bugreports/BugReportViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BugReportViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BugReportViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetBugReport) this.receiver).handleEvent(event);
        }
    }

    public WidgetBugReport() {
        super(C5419R.layout.widget_bug_report);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetBugReport$binding$2.INSTANCE, null, 2, null);
        WidgetBugReport$viewModel$2 widgetBugReport$viewModel$2 = new WidgetBugReport$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(BugReportViewModel.class), new WidgetBugReport$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetBugReport$viewModel$2));
        this.featuresAdapter = new BugReportFeatureAdapter(new WidgetBugReport$featuresAdapter$1(this));
        this.imagesChangeDetector = new MGImages.DistinctChangeDetector();
        this.items = C12083g.lazy(new WidgetBugReport$items$2(this));
        this.validationManager = C12083g.lazy(new WidgetBugReport$validationManager$2(this));
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

    private final void handleEvent(BugReportViewModel.Event event) {
        AppActivity appActivity;
        if (!C12238m.areEqual(event, BugReportViewModel.Event.CloseReport.INSTANCE) || (appActivity = getAppActivity()) == null) {
            return;
        }
        appActivity.finish();
    }

    private final void submit() {
        InputStream inputStreamOpenInputStream;
        byte[] bytes;
        RequestBody requestBodyM10986d = null;
        MediaType mediaTypeM10967a = null;
        requestBodyM10986d = null;
        requestBodyM10986d = null;
        requestBodyM10986d = null;
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            Uri screenshotUri = getViewModel().getScreenshotUri();
            if (getViewModel().getUseScreenshot() && screenshotUri.getPath() != null && (inputStreamOpenInputStream = requireContext().getContentResolver().openInputStream(screenshotUri)) != null && (bytes = C12200a.readBytes(inputStreamOpenInputStream)) != null) {
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String type = requireContext().getContentResolver().getType(screenshotUri);
                if (type != null) {
                    MediaType.Companion companion2 = MediaType.INSTANCE;
                    mediaTypeM10967a = MediaType.Companion.m10967a(type);
                }
                requestBodyM10986d = RequestBody.Companion.m10986d(companion, bytes, mediaTypeM10967a, 0, 0, 6);
            }
            getViewModel().sendReport(requestBodyM10986d);
        }
    }

    public final BugReportFeatureAdapter getFeaturesAdapter() {
        return this.featuresAdapter;
    }

    public final List<C1324c0> getItems() {
        return (List) this.items.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewModel().prefetchStickers(requireContext());
    }

    public final void onFeatureClickListener(Feature feature) {
        C12238m.checkNotNullParameter(feature, "feature");
        getViewModel().selectFeatureArea(feature);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarTitle(C5419R.string.submit_bug);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        Uri uri = Uri.parse(getMostRecentIntent().getStringExtra(INTENT_EXTRA_SCREENSHOT_URI));
        RecyclerView recyclerView = getBinding().f15737f;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.bugReportFeatureRecycler");
        recyclerView.setAdapter(this.featuresAdapter);
        getBinding().f15743l.setImageURI(uri);
        getBinding().f15733b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.bugreports.WidgetBugReport.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetBugReport.this.getViewModel().useScreenshot(false);
            }
        });
        TextInputLayout textInputLayout = getBinding().f15739h;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.bugReportName");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C72902());
        TextInputLayout textInputLayout2 = getBinding().f15734c;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.bugReportDescription");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new C72913());
        getBinding().f15738g.m8553a(this, new C72924());
        getBinding().f15748q.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.bugreports.WidgetBugReport.onViewBound.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetBugReport.this.getViewModel().useScreenshot(true);
            }
        });
        getBinding().f15751t.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.bugreports.WidgetBugReport.onViewBound.6

            /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$6$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetBugReport.kt */
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
                    WidgetBugReport.this.getViewModel().updatePriority(i);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AppFragment.hideKeyboard$default(WidgetBugReport.this, null, 1, null);
                C1322b0.Companion companion = C1322b0.INSTANCE;
                FragmentManager childFragmentManager = WidgetBugReport.this.getChildFragmentManager();
                C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                String string = WidgetBugReport.this.getString(C5419R.string.bug_report_priority);
                C12238m.checkNotNullExpressionValue(string, "getString(R.string.bug_report_priority)");
                C1322b0.Companion.m378b(companion, childFragmentManager, string, WidgetBugReport.this.getItems(), false, new AnonymousClass1(), 8);
            }
        });
        getBinding().f15750s.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.bugreports.WidgetBugReport.onViewBound.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetBugReport.this.getViewModel().showFeatureAreas();
            }
        });
        getBinding().f15746o.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.bugreports.WidgetBugReport.onViewBound.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetBugReport.this.submit();
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetBugReport.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72971());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetBugReport.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72982(this));
    }

    public final void updateView(BugReportViewModel.ViewState viewState) {
        C12238m.checkNotNullParameter(viewState, "viewState");
        if (!(viewState instanceof BugReportViewModel.ViewState.Report)) {
            if (viewState instanceof BugReportViewModel.ViewState.Sending) {
                AppViewFlipper appViewFlipper = getBinding().f15747p;
                C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.bugReportSwitchFlipper");
                appViewFlipper.setDisplayedChild(1);
                StickerView.m8613e(getBinding().f15744m, getViewModel().getSendingSticker(), null, 2);
                getBinding().f15745n.setText(C5419R.string.bug_report_status_sending);
                return;
            }
            if (viewState instanceof BugReportViewModel.ViewState.Success) {
                AppViewFlipper appViewFlipper2 = getBinding().f15747p;
                C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.bugReportSwitchFlipper");
                appViewFlipper2.setDisplayedChild(1);
                StickerView.m8613e(getBinding().f15744m, getViewModel().getSuccessSticker(), null, 2);
                getBinding().f15745n.setText(C5419R.string.bug_report_status_sent);
                return;
            }
            if (viewState instanceof BugReportViewModel.ViewState.SelectFeature) {
                setActionBarTitle(C5419R.string.bug_report_select_feature_area);
                setActionBarSubtitle(C5419R.string.submit_bug);
                AppViewFlipper appViewFlipper3 = getBinding().f15747p;
                C12238m.checkNotNullExpressionValue(appViewFlipper3, "binding.bugReportSwitchFlipper");
                appViewFlipper3.setDisplayedChild(2);
                ProgressBar progressBar = getBinding().f15736e;
                C12238m.checkNotNullExpressionValue(progressBar, "binding.bugReportFeatureLoader");
                BugReportViewModel.ViewState.SelectFeature selectFeature = (BugReportViewModel.ViewState.SelectFeature) viewState;
                progressBar.setVisibility(selectFeature.getLoadingFeatures() ? 0 : 8);
                RecyclerView recyclerView = getBinding().f15737f;
                C12238m.checkNotNullExpressionValue(recyclerView, "binding.bugReportFeatureRecycler");
                recyclerView.setVisibility(selectFeature.getLoadingFeatures() ^ true ? 0 : 8);
                View editText = getBinding().f15738g.getEditText();
                if (!(editText instanceof TextInputLayout)) {
                    editText = null;
                }
                TextInputLayout textInputLayout = (TextInputLayout) editText;
                if (textInputLayout != null) {
                    EditText editText2 = textInputLayout.getEditText();
                    String strValueOf = String.valueOf(editText2 != null ? editText2.getText() : null);
                    String query = selectFeature.getQuery();
                    if (query == null) {
                        query = "";
                    }
                    if (!C12238m.areEqual(strValueOf, query)) {
                        SearchInputView searchInputView = getBinding().f15738g;
                        String query2 = selectFeature.getQuery();
                        searchInputView.setText(query2 != null ? query2 : "");
                    }
                }
                this.featuresAdapter.setData(selectFeature.getFeatures());
                if (this.backHandlerAdded) {
                    return;
                }
                this.backHandlerAdded = true;
                AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.bugreports.WidgetBugReport.updateView.4
                    @Override // p658rx.functions.Func0, java.util.concurrent.Callable
                    public final Boolean call() {
                        WidgetBugReport.this.backHandlerAdded = false;
                        BugReportViewModel.showReport$default(WidgetBugReport.this.getViewModel(), null, 1, null);
                        AppFragment.setOnBackPressed$default(WidgetBugReport.this, new Func0<Boolean>() { // from class: com.discord.widgets.bugreports.WidgetBugReport.updateView.4.1
                            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
                            public final Boolean call() {
                                return Boolean.FALSE;
                            }
                        }, 0, 2, null);
                        return Boolean.TRUE;
                    }
                }, 0, 2, null);
                return;
            }
            return;
        }
        setActionBarTitle(C5419R.string.submit_bug);
        setActionBarSubtitle("");
        AppViewFlipper appViewFlipper4 = getBinding().f15747p;
        C12238m.checkNotNullExpressionValue(appViewFlipper4, "binding.bugReportSwitchFlipper");
        appViewFlipper4.setDisplayedChild(0);
        MaterialTextView materialTextView = getBinding().f15749r;
        C12238m.checkNotNullExpressionValue(materialTextView, "binding.submitReportError");
        BugReportViewModel.ViewState.Report report = (BugReportViewModel.ViewState.Report) viewState;
        materialTextView.setVisibility(report.getError() != null ? 0 : 8);
        if (report.getError() != null) {
            MaterialTextView materialTextView2 = getBinding().f15749r;
            C12238m.checkNotNullExpressionValue(materialTextView2, "binding.submitReportError");
            Error.Response response = report.getError().getResponse();
            C12238m.checkNotNullExpressionValue(response, "viewState.error.response");
            materialTextView2.setText(response.getMessage());
        }
        TextInputLayout textInputLayout2 = getBinding().f15739h;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.bugReportName");
        ViewExtensions.setTextIfDifferent(textInputLayout2, report.getReportName());
        TextInputLayout textInputLayout3 = getBinding().f15734c;
        C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.bugReportDescription");
        ViewExtensions.setTextIfDifferent(textInputLayout3, report.getReportDescription());
        AppCompatImageView appCompatImageView = getBinding().f15743l;
        C12238m.checkNotNullExpressionValue(appCompatImageView, "binding.bugReportScreenshot");
        appCompatImageView.setVisibility(report.getUseScreenshot() ^ true ? 4 : 0);
        AppCompatImageView appCompatImageView2 = getBinding().f15733b;
        C12238m.checkNotNullExpressionValue(appCompatImageView2, "binding.bugReportClearScreenshot");
        appCompatImageView2.setVisibility(report.getUseScreenshot() ? 0 : 8);
        MaterialTextView materialTextView3 = getBinding().f15740i;
        C12238m.checkNotNullExpressionValue(materialTextView3, "binding.bugReportNoScreenshotLabel");
        materialTextView3.setVisibility(report.getUseScreenshot() ^ true ? 0 : 8);
        MaterialButton materialButton = getBinding().f15748q;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.bugReportUndoScreenshotRemove");
        materialButton.setVisibility(report.getUseScreenshot() ^ true ? 0 : 8);
        Feature feature = report.getFeature();
        if (feature != null) {
            TextInputLayout textInputLayout4 = getBinding().f15735d;
            C12238m.checkNotNullExpressionValue(textInputLayout4, "binding.bugReportFeatureArea");
            ViewExtensions.setTextIfDifferent(textInputLayout4, feature.getName());
        }
        Integer priority = report.getPriority();
        if (priority != null) {
            int iIntValue = priority.intValue();
            TextInputLayout textInputLayout5 = getBinding().f15741j;
            C12238m.checkNotNullExpressionValue(textInputLayout5, "binding.bugReportPriority");
            ViewExtensions.setText(textInputLayout5, priorityLevels.get(iIntValue).getTitle());
            SimpleDraweeView simpleDraweeView = getBinding().f15742k;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.bugReportPriorityIcon");
            MGImages.setImage$default(simpleDraweeView, getItems().get(iIntValue).m383d(), C5419R.dimen.emoji_size, C5419R.dimen.emoji_size, true, null, this.imagesChangeDetector, 32, null);
        }
    }
}
