package com.discord.widgets.feedback;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetFeedbackSheetBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.feedback.FeedbackSheetViewModel;
import com.discord.widgets.guild_delete_feedback.GuildDeleteFeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.discord.widgets.voice.feedback.FeedbackView;
import com.discord.widgets.voice.feedback.WidgetIssueDetailsForm;
import com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetViewModel;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subscriptions.CompositeSubscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetFeedbackSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFeedbackSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetFeedbackSheet newInstance(FeedbackType feedbackType) {
            C12238m.checkNotNullParameter(feedbackType, "feedbackType");
            WidgetFeedbackSheet widgetFeedbackSheet = new WidgetFeedbackSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable(WidgetFeedbackSheet.ARG_FEEDBACK_TYPE, feedbackType);
            widgetFeedbackSheet.setArguments(bundle);
            return widgetFeedbackSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public enum FeedbackType {
        CALL,
        STREAM,
        GUILD_DELETE
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FeedbackType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[FeedbackType.CALL.ordinal()] = 1;
            iArr[FeedbackType.STREAM.ordinal()] = 2;
            iArr[FeedbackType.GUILD_DELETE.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$bindSubscriptions$1 */
    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public static final /* synthetic */ class C83121 extends C12236k implements Function1<FeedbackSheetViewModel.ViewState, Unit> {
        public C83121(WidgetFeedbackSheet widgetFeedbackSheet) {
            super(1, widgetFeedbackSheet, WidgetFeedbackSheet.class, "updateView", "updateView(Lcom/discord/widgets/feedback/FeedbackSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FeedbackSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FeedbackSheetViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetFeedbackSheet) this.receiver).updateView(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$bindSubscriptions$2 */
    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public static final /* synthetic */ class C83132 extends C12236k implements Function1<FeedbackSheetViewModel.Event, Unit> {
        public C83132(WidgetFeedbackSheet widgetFeedbackSheet) {
            super(1, widgetFeedbackSheet, WidgetFeedbackSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FeedbackSheetViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FeedbackSheetViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetFeedbackSheet) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$handleEvent$1 */
    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public static final class C83141 extends AbstractC12240o implements Function1<Long, Unit> {
        public C83141() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            C0876m.m171i(WidgetFeedbackSheet.this, C5419R.string.call_feedback_confirmation, 0, 4);
            WidgetFeedbackSheet.this.requireDialog().cancel();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$updateView$2 */
    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public static final class C83162 extends AbstractC12240o implements Function0<Unit> {
        public C83162() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetFeedbackSheet.this.getViewModel().selectRating(FeedbackRating.BAD);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$updateView$3 */
    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public static final class C83173 extends AbstractC12240o implements Function0<Unit> {
        public C83173() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetFeedbackSheet.this.getViewModel().selectRating(FeedbackRating.NEUTRAL);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$updateView$4 */
    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public static final class C83184 extends AbstractC12240o implements Function0<Unit> {
        public C83184() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetFeedbackSheet.this.getViewModel().selectRating(FeedbackRating.GOOD);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$updateView$5 */
    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public static final class C83195 extends AbstractC12240o implements Function1<FeedbackIssue, Unit> {
        public C83195() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FeedbackIssue feedbackIssue) {
            invoke2(feedbackIssue);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FeedbackIssue feedbackIssue) {
            C12238m.checkNotNullParameter(feedbackIssue, "issue");
            WidgetFeedbackSheet.this.getViewModel().selectIssue(feedbackIssue, WidgetFeedbackSheet.this.getString(feedbackIssue.getReasonStringRes()));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$updateView$6 */
    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public static final class C83206 extends AbstractC12240o implements Function1<Long, Unit> {
        public C83206() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetFeedbackSheet.this.isShowingFeedbackIssues = true;
            WidgetFeedbackSheet.this.setBottomSheetState(3);
        }
    }

    public WidgetFeedbackSheet() {
        super(false, 1, null);
        this.onDismissed = WidgetFeedbackSheet$onDismissed$1.INSTANCE;
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetFeedbackSheet$binding$2.INSTANCE, null, 2, null);
        WidgetFeedbackSheet$viewModelCallFeedbackSheet$2 widgetFeedbackSheet$viewModelCallFeedbackSheet$2 = new WidgetFeedbackSheet$viewModelCallFeedbackSheet$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModelCallFeedbackSheet = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(CallFeedbackSheetViewModel.class), new WidgetFeedbackSheet$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetFeedbackSheet$viewModelCallFeedbackSheet$2));
        WidgetFeedbackSheet$viewModelStreamFeedbackSheet$2 widgetFeedbackSheet$viewModelStreamFeedbackSheet$2 = new WidgetFeedbackSheet$viewModelStreamFeedbackSheet$2(this);
        C0865g0 c0865g1 = new C0865g0(this);
        this.viewModelStreamFeedbackSheet = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(StreamFeedbackSheetViewModel.class), new WidgetFeedbackSheet$appViewModels$$inlined$viewModels$2(c0865g1), new C0869i0(widgetFeedbackSheet$viewModelStreamFeedbackSheet$2));
        WidgetFeedbackSheet$viewModelGuildDeleteFeedbackSheet$2 widgetFeedbackSheet$viewModelGuildDeleteFeedbackSheet$2 = new WidgetFeedbackSheet$viewModelGuildDeleteFeedbackSheet$2(this);
        C0865g0 c0865g2 = new C0865g0(this);
        this.viewModelGuildDeleteFeedbackSheet = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildDeleteFeedbackSheetViewModel.class), new WidgetFeedbackSheet$appViewModels$$inlined$viewModels$3(c0865g2), new C0869i0(widgetFeedbackSheet$viewModelGuildDeleteFeedbackSheet$2));
    }

    private final WidgetFeedbackSheetBinding getBinding() {
        return (WidgetFeedbackSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final FeedbackSheetViewModel getViewModel() {
        Serializable serializable = requireArguments().getSerializable(ARG_FEEDBACK_TYPE);
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.feedback.WidgetFeedbackSheet.FeedbackType");
        int iOrdinal = ((FeedbackType) serializable).ordinal();
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

    private final void handleEvent(FeedbackSheetViewModel.Event event) {
        if (event instanceof FeedbackSheetViewModel.Event.Submitted) {
            if (!((FeedbackSheetViewModel.Event.Submitted) event).getShowConfirmation()) {
                requireDialog().cancel();
                return;
            }
            Observable<Long> observableM11068d0 = Observable.m11068d0(SHEET_DISMISS_DELAY_MS, TimeUnit.MILLISECONDS);
            C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable\n             …S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11068d0, this, null, 2, null), (Class<?>) WidgetFeedbackSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C83141());
            return;
        }
        if (event instanceof FeedbackSheetViewModel.Event.NavigateToIssueDetails) {
            WidgetIssueDetailsForm.Companion companion = WidgetIssueDetailsForm.INSTANCE;
            Context contextRequireContext = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            FeedbackSheetViewModel.Event.NavigateToIssueDetails navigateToIssueDetails = (FeedbackSheetViewModel.Event.NavigateToIssueDetails) event;
            companion.launch(contextRequireContext, navigateToIssueDetails.getPendingFeedback(), navigateToIssueDetails.getShowCxLinkForIssueDetails());
            requireDialog().cancel();
        }
    }

    private final void updateView(FeedbackSheetViewModel.ViewState viewState) {
        boolean z2 = !this.isShowingFeedbackIssues && (viewState.getFeedbackIssues().isEmpty() ^ true);
        if (z2) {
            if (viewState.getShowFaceRatings()) {
                NestedScrollView nestedScrollView = getBinding().f16625c;
                C12238m.checkNotNullExpressionValue(nestedScrollView, "binding.feedbackSheetContainer");
                updatePeekHeightPx(nestedScrollView.getMeasuredHeight());
            }
            setBottomSheetState(4);
        }
        getBinding().f16627e.setText(viewState.getTitleTextResId());
        FeedbackView feedbackView = getBinding().f16626d;
        Integer promptTextResId = viewState.getPromptTextResId();
        String string = promptTextResId != null ? getString(promptTextResId.intValue()) : null;
        FeedbackRating selectedFeedbackRating = viewState.getSelectedFeedbackRating();
        C83162 c83162 = new C83162();
        C83173 c83173 = new C83173();
        C83184 c83184 = new C83184();
        String string2 = getString(viewState.getIssuesHeaderTextResId());
        C12238m.checkNotNullExpressionValue(string2, "getString(viewState.issuesHeaderTextResId)");
        feedbackView.updateView(string, selectedFeedbackRating, c83162, c83173, c83184, string2, viewState.getFeedbackIssues(), new C83195());
        if (z2) {
            Observable<Long> observableM11068d0 = Observable.m11068d0(100L, TimeUnit.MILLISECONDS);
            C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable\n          .ti…S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11068d0, this, null, 2, null), (Class<?>) WidgetFeedbackSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C83206());
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        C12238m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetFeedbackSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C83121(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetFeedbackSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C83132(this));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_feedback_sheet;
    }

    public final Function0<Unit> getOnDismissed() {
        return this.onDismissed;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        C12238m.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        this.onDismissed.invoke();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().f16624b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.feedback.WidgetFeedbackSheet.onResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetFeedbackSheet.this.getViewModel().submitForm();
            }
        });
    }

    public final void setOnDismissed(Function0<Unit> function0) {
        C12238m.checkNotNullParameter(function0, "<set-?>");
        this.onDismissed = function0;
    }
}
