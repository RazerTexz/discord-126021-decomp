package com.discord.widgets.tos;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.report.ReportReason;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIInterface$DefaultImpls;
import com.discord.restapi.RestAPIParams$Report;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUserProfile;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolationViewModel extends d0<WidgetTosReportViolationViewModel$ViewState> {
    private final long channelId;
    private final long messageId;
    private ReportReason reasonSelected;
    private WidgetTosReportViolationViewModel$StoreState storeState;

    public WidgetTosReportViolationViewModel(long j, long j2) {
        super(WidgetTosReportViolationViewModel$ViewState$Loading.INSTANCE);
        this.channelId = j;
        this.messageId = j2;
        Observable<WidgetTosReportViolationViewModel$StoreState> observableR = observeStoreState().r();
        m.checkNotNullExpressionValue(observableR, "observeStoreState()\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetTosReportViolationViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetTosReportViolationViewModel$1(this), 62, (Object) null);
    }

    public static final /* synthetic */ void access$generateViewState(WidgetTosReportViolationViewModel widgetTosReportViolationViewModel, WidgetTosReportViolationViewModel$StoreState widgetTosReportViolationViewModel$StoreState) {
        widgetTosReportViolationViewModel.generateViewState(widgetTosReportViolationViewModel$StoreState);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetTosReportViolationViewModel widgetTosReportViolationViewModel, WidgetTosReportViolationViewModel$ViewState widgetTosReportViolationViewModel$ViewState) {
        widgetTosReportViolationViewModel.updateViewState(widgetTosReportViolationViewModel$ViewState);
    }

    @MainThread
    private final void generateViewState(WidgetTosReportViolationViewModel$StoreState storeState) {
        this.storeState = storeState;
        if (storeState instanceof WidgetTosReportViolationViewModel$StoreState$ReportReasons) {
            updateViewState(new WidgetTosReportViolationViewModel$ViewState$Loaded(((WidgetTosReportViolationViewModel$StoreState$ReportReasons) storeState).getReasons()));
        }
    }

    private final Observable<WidgetTosReportViolationViewModel$StoreState> observeStoreState() {
        Observable<WidgetTosReportViolationViewModel$StoreState> observableG = ObservableExtensionsKt.restSubscribeOn$default(RestAPIInterface$DefaultImpls.report$default(RestAPI.Companion.getApi(), Long.valueOf(this.channelId), null, Long.valueOf(this.messageId), null, 2, null), false, 1, null).G(WidgetTosReportViolationViewModel$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "RestAPI\n          .api\n …eportReasons)\n          }");
        return observableG;
    }

    public final ReportReason getReasonSelected() {
        return this.reasonSelected;
    }

    @MainThread
    public final void handleDismissError() {
        WidgetTosReportViolationViewModel$StoreState widgetTosReportViolationViewModel$StoreState = this.storeState;
        if (widgetTosReportViolationViewModel$StoreState == null) {
            m.throwUninitializedPropertyAccessException("storeState");
        }
        generateViewState(widgetTosReportViolationViewModel$StoreState);
    }

    @MainThread
    public final void sendReport() {
        ReportReason reportReason = this.reasonSelected;
        if (reportReason != null) {
            updateViewState(new WidgetTosReportViolationViewModel$ViewState$Submitting(reportReason.getReason()));
        }
    }

    @MainThread
    public final void sendReportAPICall(int reason, long channelId, long messageId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Channel channel = storeStream$Companion.getChannels().getChannel(channelId);
        if (channel != null && channel.getType() == 1) {
            User userA = ChannelUtils.a(channel);
            Long lValueOf = userA != null ? Long.valueOf(userA.getId()) : null;
            if (lValueOf != null) {
                StoreUserProfile.fetchProfile$default(storeStream$Companion.getUserProfile(), lValueOf.longValue(), null, false, new WidgetTosReportViolationViewModel$sendReportAPICall$onFetchSuccess$1(this, reason, channelId, messageId), 6, null);
            }
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().report(new RestAPIParams$Report(reason, Long.valueOf(channelId), Long.valueOf(messageId))), false, 1, null)), WidgetTosReportViolationViewModel.class, (Context) null, (Function1) null, new WidgetTosReportViolationViewModel$sendReportAPICall$1(this), (Function0) null, (Function0) null, new WidgetTosReportViolationViewModel$sendReportAPICall$2(this), 54, (Object) null);
    }

    public final void setReasonSelected(ReportReason reportReason) {
        this.reasonSelected = reportReason;
    }
}
