package com.discord.widgets.feedback;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetFeedbackSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guild_delete_feedback.GuildDeleteFeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.discord.widgets.voice.feedback.FeedbackView;
import com.discord.widgets.voice.feedback.WidgetIssueDetailsForm;
import com.discord.widgets.voice.feedback.WidgetIssueDetailsForm$Companion;
import com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetViewModel;
import d0.z.d.a0;
import d0.z.d.m;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFeedbackSheet extends AppBottomSheet {
    public static final String ARG_CALL_FEEDBACK_CONFIG = "ARG_CONFIG";
    public static final String ARG_FEEDBACK_TYPE = "ARG_FEEDBACK_TYPE";
    public static final String ARG_GUILD_DELETE_FEEDBACK_GUILD_ID = "ARG_GUILD_DELETE_FEEDBACK_GUILD_ID";
    public static final String ARG_STREAM_FEEDBACK_MEDIA_SESSION_ID = "ARG_STREAM_FEEDBACK_MEDIA_SESSION_ID";
    public static final String ARG_STREAM_FEEDBACK_STREAM_KEY = "ARG_STREAM_FEEDBACK_STREAM_KEY ";
    private static final long SHEET_DISMISS_DELAY_MS = 600;
    private static final long SHEET_EXPAND_DELAY_MS = 100;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean isShowingFeedbackIssues;
    private Function0<Unit> onDismissed;

    /* JADX INFO: renamed from: viewModelCallFeedbackSheet$delegate, reason: from kotlin metadata */
    private final Lazy viewModelCallFeedbackSheet;

    /* JADX INFO: renamed from: viewModelGuildDeleteFeedbackSheet$delegate, reason: from kotlin metadata */
    private final Lazy viewModelGuildDeleteFeedbackSheet;

    /* JADX INFO: renamed from: viewModelStreamFeedbackSheet$delegate, reason: from kotlin metadata */
    private final Lazy viewModelStreamFeedbackSheet;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetFeedbackSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFeedbackSheetBinding;", 0)};
    public static final WidgetFeedbackSheet$Companion Companion = new WidgetFeedbackSheet$Companion(null);

    public WidgetFeedbackSheet() {
        super(false, 1, null);
        this.onDismissed = WidgetFeedbackSheet$onDismissed$1.INSTANCE;
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetFeedbackSheet$binding$2.INSTANCE, null, 2, null);
        WidgetFeedbackSheet$viewModelCallFeedbackSheet$2 widgetFeedbackSheet$viewModelCallFeedbackSheet$2 = new WidgetFeedbackSheet$viewModelCallFeedbackSheet$2(this);
        g0 g0Var = new g0(this);
        this.viewModelCallFeedbackSheet = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(CallFeedbackSheetViewModel.class), new WidgetFeedbackSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetFeedbackSheet$viewModelCallFeedbackSheet$2));
        WidgetFeedbackSheet$viewModelStreamFeedbackSheet$2 widgetFeedbackSheet$viewModelStreamFeedbackSheet$2 = new WidgetFeedbackSheet$viewModelStreamFeedbackSheet$2(this);
        g0 g0Var2 = new g0(this);
        this.viewModelStreamFeedbackSheet = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(StreamFeedbackSheetViewModel.class), new WidgetFeedbackSheet$appViewModels$$inlined$viewModels$2(g0Var2), new i0(widgetFeedbackSheet$viewModelStreamFeedbackSheet$2));
        WidgetFeedbackSheet$viewModelGuildDeleteFeedbackSheet$2 widgetFeedbackSheet$viewModelGuildDeleteFeedbackSheet$2 = new WidgetFeedbackSheet$viewModelGuildDeleteFeedbackSheet$2(this);
        g0 g0Var3 = new g0(this);
        this.viewModelGuildDeleteFeedbackSheet = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildDeleteFeedbackSheetViewModel.class), new WidgetFeedbackSheet$appViewModels$$inlined$viewModels$3(g0Var3), new i0(widgetFeedbackSheet$viewModelGuildDeleteFeedbackSheet$2));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetFeedbackSheet widgetFeedbackSheet) {
        return widgetFeedbackSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ FeedbackSheetViewModel access$getViewModel$p(WidgetFeedbackSheet widgetFeedbackSheet) {
        return widgetFeedbackSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetFeedbackSheet widgetFeedbackSheet, FeedbackSheetViewModel$Event feedbackSheetViewModel$Event) {
        widgetFeedbackSheet.handleEvent(feedbackSheetViewModel$Event);
    }

    public static final /* synthetic */ boolean access$isShowingFeedbackIssues$p(WidgetFeedbackSheet widgetFeedbackSheet) {
        return widgetFeedbackSheet.isShowingFeedbackIssues;
    }

    public static final /* synthetic */ void access$setShowingFeedbackIssues$p(WidgetFeedbackSheet widgetFeedbackSheet, boolean z2) {
        widgetFeedbackSheet.isShowingFeedbackIssues = z2;
    }

    public static final /* synthetic */ void access$updateView(WidgetFeedbackSheet widgetFeedbackSheet, FeedbackSheetViewModel$ViewState feedbackSheetViewModel$ViewState) {
        widgetFeedbackSheet.updateView(feedbackSheetViewModel$ViewState);
    }

    private final WidgetFeedbackSheetBinding getBinding() {
        return (WidgetFeedbackSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final FeedbackSheetViewModel getViewModel() {
        Serializable serializable = requireArguments().getSerializable(ARG_FEEDBACK_TYPE);
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.feedback.WidgetFeedbackSheet.FeedbackType");
        int iOrdinal = ((WidgetFeedbackSheet$FeedbackType) serializable).ordinal();
        if (iOrdinal == 0) {
            return getViewModelCallFeedbackSheet();
        }
        if (iOrdinal == 1) {
            return getViewModelStreamFeedbackSheet();
        }
        if (iOrdinal == 2) {
            return getViewModelGuildDeleteFeedbackSheet();
        }
        throw new NoWhenBranchMatchedException();
    }

    private final CallFeedbackSheetViewModel getViewModelCallFeedbackSheet() {
        return (CallFeedbackSheetViewModel) this.viewModelCallFeedbackSheet.getValue();
    }

    private final GuildDeleteFeedbackSheetViewModel getViewModelGuildDeleteFeedbackSheet() {
        return (GuildDeleteFeedbackSheetViewModel) this.viewModelGuildDeleteFeedbackSheet.getValue();
    }

    private final StreamFeedbackSheetViewModel getViewModelStreamFeedbackSheet() {
        return (StreamFeedbackSheetViewModel) this.viewModelStreamFeedbackSheet.getValue();
    }

    private final void handleEvent(FeedbackSheetViewModel$Event event) {
        if (event instanceof FeedbackSheetViewModel$Event$Submitted) {
            if (!((FeedbackSheetViewModel$Event$Submitted) event).getShowConfirmation()) {
                requireDialog().cancel();
                return;
            }
            Observable<Long> observableD0 = Observable.d0(SHEET_DISMISS_DELAY_MS, TimeUnit.MILLISECONDS);
            m.checkNotNullExpressionValue(observableD0, "Observable\n             …S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetFeedbackSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetFeedbackSheet$handleEvent$1(this), 62, (Object) null);
            return;
        }
        if (event instanceof FeedbackSheetViewModel$Event$NavigateToIssueDetails) {
            WidgetIssueDetailsForm$Companion widgetIssueDetailsForm$Companion = WidgetIssueDetailsForm.Companion;
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            FeedbackSheetViewModel$Event$NavigateToIssueDetails feedbackSheetViewModel$Event$NavigateToIssueDetails = (FeedbackSheetViewModel$Event$NavigateToIssueDetails) event;
            widgetIssueDetailsForm$Companion.launch(contextRequireContext, feedbackSheetViewModel$Event$NavigateToIssueDetails.getPendingFeedback(), feedbackSheetViewModel$Event$NavigateToIssueDetails.getShowCxLinkForIssueDetails());
            requireDialog().cancel();
        }
    }

    private final void updateView(FeedbackSheetViewModel$ViewState viewState) {
        boolean z2 = !this.isShowingFeedbackIssues && (viewState.getFeedbackIssues().isEmpty() ^ true);
        if (z2) {
            if (viewState.getShowFaceRatings()) {
                NestedScrollView nestedScrollView = getBinding().c;
                m.checkNotNullExpressionValue(nestedScrollView, "binding.feedbackSheetContainer");
                updatePeekHeightPx(nestedScrollView.getMeasuredHeight());
            }
            setBottomSheetState(4);
        }
        getBinding().e.setText(viewState.getTitleTextResId());
        FeedbackView feedbackView = getBinding().d;
        Integer promptTextResId = viewState.getPromptTextResId();
        String string = promptTextResId != null ? getString(promptTextResId.intValue()) : null;
        FeedbackRating selectedFeedbackRating = viewState.getSelectedFeedbackRating();
        WidgetFeedbackSheet$updateView$2 widgetFeedbackSheet$updateView$2 = new WidgetFeedbackSheet$updateView$2(this);
        WidgetFeedbackSheet$updateView$3 widgetFeedbackSheet$updateView$3 = new WidgetFeedbackSheet$updateView$3(this);
        WidgetFeedbackSheet$updateView$4 widgetFeedbackSheet$updateView$4 = new WidgetFeedbackSheet$updateView$4(this);
        String string2 = getString(viewState.getIssuesHeaderTextResId());
        m.checkNotNullExpressionValue(string2, "getString(viewState.issuesHeaderTextResId)");
        feedbackView.updateView(string, selectedFeedbackRating, widgetFeedbackSheet$updateView$2, widgetFeedbackSheet$updateView$3, widgetFeedbackSheet$updateView$4, string2, viewState.getFeedbackIssues(), new WidgetFeedbackSheet$updateView$5(this));
        if (z2) {
            Observable<Long> observableD0 = Observable.d0(100L, TimeUnit.MILLISECONDS);
            m.checkNotNullExpressionValue(observableD0, "Observable\n          .ti…S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetFeedbackSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetFeedbackSheet$updateView$6(this), 62, (Object) null);
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetFeedbackSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetFeedbackSheet$bindSubscriptions$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetFeedbackSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetFeedbackSheet$bindSubscriptions$2(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_feedback_sheet;
    }

    public final Function0<Unit> getOnDismissed() {
        return this.onDismissed;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnCancelListener
    public void onCancel(DialogInterface dialog) {
        m.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        this.onDismissed.invoke();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().f2385b.setOnClickListener(new WidgetFeedbackSheet$onResume$1(this));
    }

    public final void setOnDismissed(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onDismissed = function0;
    }
}
