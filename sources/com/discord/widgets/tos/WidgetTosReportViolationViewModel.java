package com.discord.widgets.tos;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.report.ReportReason;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIInterface;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolationViewModel extends AppViewModel<ViewState> {
    private final long channelId;
    private final long messageId;
    private ReportReason reasonSelected;
    private StoreState storeState;

    /* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTosReportViolationViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(WidgetTosReportViolationViewModel widgetTosReportViolationViewModel) {
            super(1, widgetTosReportViolationViewModel, WidgetTosReportViolationViewModel.class, "generateViewState", "generateViewState(Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ((WidgetTosReportViolationViewModel) this.receiver).generateViewState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
        public static final /* data */ class ReportReasons extends StoreState {
            private final List<ReportReason> reasons;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReportReasons(List<ReportReason> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "reasons");
                this.reasons = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ReportReasons copy$default(ReportReasons reportReasons, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = reportReasons.reasons;
                }
                return reportReasons.copy(list);
            }

            public final List<ReportReason> component1() {
                return this.reasons;
            }

            public final ReportReasons copy(List<ReportReason> reasons) {
                Intrinsics3.checkNotNullParameter(reasons, "reasons");
                return new ReportReasons(reasons);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ReportReasons) && Intrinsics3.areEqual(this.reasons, ((ReportReasons) other).reasons);
                }
                return true;
            }

            public final List<ReportReason> getReasons() {
                return this.reasons;
            }

            public int hashCode() {
                List<ReportReason> list = this.reasons;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("ReportReasons(reasons="), this.reasons, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<ReportReason> reasons;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<ReportReason> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "reasons");
                this.reasons = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.reasons;
                }
                return loaded.copy(list);
            }

            public final List<ReportReason> component1() {
                return this.reasons;
            }

            public final Loaded copy(List<ReportReason> reasons) {
                Intrinsics3.checkNotNullParameter(reasons, "reasons");
                return new Loaded(reasons);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.reasons, ((Loaded) other).reasons);
                }
                return true;
            }

            public final List<ReportReason> getReasons() {
                return this.reasons;
            }

            public int hashCode() {
                List<ReportReason> list = this.reasons;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(reasons="), this.reasons, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
        public static final class SubmissionError extends ViewState {
            public static final SubmissionError INSTANCE = new SubmissionError();

            private SubmissionError() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
        public static final class Submitted extends ViewState {
            public static final Submitted INSTANCE = new Submitted();

            private Submitted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
        public static final /* data */ class Submitting extends ViewState {
            private final int reason;

            public Submitting(int i) {
                super(null);
                this.reason = i;
            }

            public static /* synthetic */ Submitting copy$default(Submitting submitting, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = submitting.reason;
                }
                return submitting.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getReason() {
                return this.reason;
            }

            public final Submitting copy(int reason) {
                return new Submitting(reason);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Submitting) && this.reason == ((Submitting) other).reason;
                }
                return true;
            }

            public final int getReason() {
                return this.reason;
            }

            public int hashCode() {
                return this.reason;
            }

            public String toString() {
                return outline.B(outline.U("Submitting(reason="), this.reason, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTosReportViolationViewModel$sendReportAPICall$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetTosReportViolationViewModel.this.updateViewState(ViewState.SubmissionError.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTosReportViolationViewModel$sendReportAPICall$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Unit, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            Intrinsics3.checkNotNullParameter(unit, "it");
            WidgetTosReportViolationViewModel.this.updateViewState(ViewState.Submitted.INSTANCE);
        }
    }

    public WidgetTosReportViolationViewModel(long j, long j2) {
        super(ViewState.Loading.INSTANCE);
        this.channelId = j;
        this.messageId = j2;
        Observable<StoreState> observableR = observeStoreState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeStoreState()\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), (Class<?>) WidgetTosReportViolationViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }

    @MainThread
    private final void generateViewState(StoreState storeState) {
        this.storeState = storeState;
        if (storeState instanceof StoreState.ReportReasons) {
            updateViewState(new ViewState.Loaded(((StoreState.ReportReasons) storeState).getReasons()));
        }
    }

    private final Observable<StoreState> observeStoreState() {
        Observable<StoreState> observableG = ObservableExtensionsKt.restSubscribeOn$default(RestAPIInterface.DefaultImpls.report$default(RestAPI.INSTANCE.getApi(), Long.valueOf(this.channelId), null, Long.valueOf(this.messageId), null, 2, null), false, 1, null).G(new Func1<List<? extends ReportReason>, StoreState>() { // from class: com.discord.widgets.tos.WidgetTosReportViolationViewModel.observeStoreState.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ StoreState call(List<? extends ReportReason> list) {
                return call2((List<ReportReason>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final StoreState call2(List<ReportReason> list) {
                Intrinsics3.checkNotNullExpressionValue(list, "reportReasons");
                return new StoreState.ReportReasons(list);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "RestAPI\n          .api\n …eportReasons)\n          }");
        return observableG;
    }

    public final ReportReason getReasonSelected() {
        return this.reasonSelected;
    }

    @MainThread
    public final void handleDismissError() {
        StoreState storeState = this.storeState;
        if (storeState == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("storeState");
        }
        generateViewState(storeState);
    }

    @MainThread
    public final void sendReport() {
        ReportReason reportReason = this.reasonSelected;
        if (reportReason != null) {
            updateViewState(new ViewState.Submitting(reportReason.getReason()));
        }
    }

    @MainThread
    public final void sendReportAPICall(int reason, long channelId, long messageId) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Channel channel = companion.getChannels().getChannel(channelId);
        if (channel != null && channel.getType() == 1) {
            User userA = ChannelUtils.a(channel);
            Long lValueOf = userA != null ? Long.valueOf(userA.getId()) : null;
            if (lValueOf != null) {
                companion.getUserProfile().fetchProfile(lValueOf.longValue(), (12 & 2) != 0 ? null : null, (12 & 4) != 0 ? false : false, (12 & 8) != 0 ? null : new WidgetTosReportViolationViewModel2(this, reason, channelId, messageId));
            }
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().report(new RestAPIParams.Report(reason, Long.valueOf(channelId), Long.valueOf(messageId))), false, 1, null)), (Class<?>) WidgetTosReportViolationViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    public final void setReasonSelected(ReportReason reportReason) {
        this.reasonSelected = reportReason;
    }
}
