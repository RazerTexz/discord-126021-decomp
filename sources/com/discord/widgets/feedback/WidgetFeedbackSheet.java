package com.discord.widgets.feedback;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetFeedbackSheetBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.feedback.FeedbackSheetViewModel;
import com.discord.widgets.guild_delete_feedback.GuildDeleteFeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.discord.widgets.voice.feedback.FeedbackView;
import com.discord.widgets.voice.feedback.WidgetIssueDetailsForm;
import com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
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
import rx.Observable;
import rx.Subscription;
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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetFeedbackSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFeedbackSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetFeedbackSheet newInstance(FeedbackType feedbackType) {
            Intrinsics3.checkNotNullParameter(feedbackType, "feedbackType");
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

    /* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$bindSubscriptions$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<FeedbackSheetViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetFeedbackSheet widgetFeedbackSheet) {
            super(1, widgetFeedbackSheet, WidgetFeedbackSheet.class, "updateView", "updateView(Lcom/discord/widgets/feedback/FeedbackSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FeedbackSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FeedbackSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetFeedbackSheet) this.receiver).updateView(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$bindSubscriptions$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<FeedbackSheetViewModel.Event, Unit> {
        public AnonymousClass2(WidgetFeedbackSheet widgetFeedbackSheet) {
            super(1, widgetFeedbackSheet, WidgetFeedbackSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FeedbackSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FeedbackSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((WidgetFeedbackSheet) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$handleEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            AppToast.i(WidgetFeedbackSheet.this, R.string.call_feedback_confirmation, 0, 4);
            WidgetFeedbackSheet.this.requireDialog().cancel();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$updateView$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
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
            WidgetFeedbackSheet.this.getViewModel().selectRating(FeedbackRating.BAD);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$updateView$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetFeedbackSheet.this.getViewModel().selectRating(FeedbackRating.NEUTRAL);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$updateView$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetFeedbackSheet.this.getViewModel().selectRating(FeedbackRating.GOOD);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$updateView$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<FeedbackIssue, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FeedbackIssue feedbackIssue) {
            invoke2(feedbackIssue);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FeedbackIssue feedbackIssue) {
            Intrinsics3.checkNotNullParameter(feedbackIssue, "issue");
            WidgetFeedbackSheet.this.getViewModel().selectIssue(feedbackIssue, WidgetFeedbackSheet.this.getString(feedbackIssue.getReasonStringRes()));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$updateView$6, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
    public static final class AnonymousClass6 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass6() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetFeedbackSheet.this.isShowingFeedbackIssues = true;
            WidgetFeedbackSheet.this.setBottomSheetState(3);
        }
    }

    public WidgetFeedbackSheet() {
        super(false, 1, null);
        this.onDismissed = WidgetFeedbackSheet3.INSTANCE;
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetFeedbackSheet2.INSTANCE, null, 2, null);
        WidgetFeedbackSheet4 widgetFeedbackSheet4 = new WidgetFeedbackSheet4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModelCallFeedbackSheet = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(CallFeedbackSheetViewModel.class), new WidgetFeedbackSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetFeedbackSheet4));
        WidgetFeedbackSheet6 widgetFeedbackSheet6 = new WidgetFeedbackSheet6(this);
        AppViewModelDelegates3 appViewModelDelegates4 = new AppViewModelDelegates3(this);
        this.viewModelStreamFeedbackSheet = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(StreamFeedbackSheetViewModel.class), new WidgetFeedbackSheet$appViewModels$$inlined$viewModels$2(appViewModelDelegates4), new AppViewModelDelegates5(widgetFeedbackSheet6));
        WidgetFeedbackSheet5 widgetFeedbackSheet5 = new WidgetFeedbackSheet5(this);
        AppViewModelDelegates3 appViewModelDelegates5 = new AppViewModelDelegates3(this);
        this.viewModelGuildDeleteFeedbackSheet = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildDeleteFeedbackSheetViewModel.class), new WidgetFeedbackSheet$appViewModels$$inlined$viewModels$3(appViewModelDelegates5), new AppViewModelDelegates5(widgetFeedbackSheet5));
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
            Observable<Long> observableD0 = Observable.d0(SHEET_DISMISS_DELAY_MS, TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n             …S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), (Class<?>) WidgetFeedbackSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
            return;
        }
        if (event instanceof FeedbackSheetViewModel.Event.NavigateToIssueDetails) {
            WidgetIssueDetailsForm.Companion companion = WidgetIssueDetailsForm.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            FeedbackSheetViewModel.Event.NavigateToIssueDetails navigateToIssueDetails = (FeedbackSheetViewModel.Event.NavigateToIssueDetails) event;
            companion.launch(contextRequireContext, navigateToIssueDetails.getPendingFeedback(), navigateToIssueDetails.getShowCxLinkForIssueDetails());
            requireDialog().cancel();
        }
    }

    private final void updateView(FeedbackSheetViewModel.ViewState viewState) {
        boolean z2 = !this.isShowingFeedbackIssues && (viewState.getFeedbackIssues().isEmpty() ^ true);
        if (z2) {
            if (viewState.getShowFaceRatings()) {
                NestedScrollView nestedScrollView = getBinding().c;
                Intrinsics3.checkNotNullExpressionValue(nestedScrollView, "binding.feedbackSheetContainer");
                updatePeekHeightPx(nestedScrollView.getMeasuredHeight());
            }
            setBottomSheetState(4);
        }
        getBinding().e.setText(viewState.getTitleTextResId());
        FeedbackView feedbackView = getBinding().d;
        Integer promptTextResId = viewState.getPromptTextResId();
        String string = promptTextResId != null ? getString(promptTextResId.intValue()) : null;
        FeedbackRating selectedFeedbackRating = viewState.getSelectedFeedbackRating();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        AnonymousClass4 anonymousClass4 = new AnonymousClass4();
        String string2 = getString(viewState.getIssuesHeaderTextResId());
        Intrinsics3.checkNotNullExpressionValue(string2, "getString(viewState.issuesHeaderTextResId)");
        feedbackView.updateView(string, selectedFeedbackRating, anonymousClass2, anonymousClass3, anonymousClass4, string2, viewState.getFeedbackIssues(), new AnonymousClass5());
        if (z2) {
            Observable<Long> observableD0 = Observable.d0(100L, TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n          .ti…S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), (Class<?>) WidgetFeedbackSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass6());
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetFeedbackSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetFeedbackSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_feedback_sheet;
    }

    public final Function0<Unit> getOnDismissed() {
        return this.onDismissed;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        this.onDismissed.invoke();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().f2385b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.feedback.WidgetFeedbackSheet.onResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetFeedbackSheet.this.getViewModel().submitForm();
            }
        });
    }

    public final void setOnDismissed(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onDismissed = function0;
    }
}
