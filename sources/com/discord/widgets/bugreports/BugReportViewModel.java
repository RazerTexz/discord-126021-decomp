package com.discord.widgets.bugreports;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.MainThread;
import com.discord.api.bugreport.BugReportConfig;
import com.discord.api.bugreport.Feature;
import com.discord.api.sticker.Sticker;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.Loading;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.file.DownloadUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.stickers.StickerUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p510c0.AbstractC11216c;
import p507d0.p512d0.C11226f;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p582u.C12169a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: BugReportViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Feature> genericFeatureAreas = C12145m.listOf(new Feature(NotificationClient.NOTIF_GENERAL, "Android", null));
    private static final List<Sticker> sendingStickers;
    private static final List<Sticker> successStickers;
    private RestCallState<BugReportConfig> bugReportConfig;
    private final PublishSubject<Event> eventSubject;
    private Feature feature;
    private String featureSearchQuery;
    private Integer priority;
    private String reportDescription;
    private String reportName;
    private final RestAPI restApi;
    private final String screenshotName;
    private final Uri screenshotUri;
    private final Sticker sendingSticker;
    private final int stickerCharacterIndex;
    private boolean stickersPrefetched;
    private final Sticker successSticker;
    private boolean useScreenshot;

    /* JADX INFO: compiled from: BugReportViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final List<Feature> getGenericFeatureAreas() {
            return BugReportViewModel.genericFeatureAreas;
        }

        public final List<Sticker> getSendingStickers() {
            return BugReportViewModel.sendingStickers;
        }

        public final List<Sticker> getSuccessStickers() {
            return BugReportViewModel.successStickers;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: BugReportViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: BugReportViewModel.kt */
        public static final class CloseReport extends Event {
            public static final CloseReport INSTANCE = new CloseReport();

            private CloseReport() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: BugReportViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: BugReportViewModel.kt */
        public static final /* data */ class Report extends ViewState {
            private final Error error;
            private final Feature feature;
            private final Integer priority;
            private final String reportDescription;
            private final String reportName;
            private final Uri screenshotUri;
            private final boolean useScreenshot;

            public /* synthetic */ Report(Uri uri, String str, String str2, Integer num, Feature feature, boolean z2, Error error, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(uri, str, str2, num, feature, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? null : error);
            }

            public static /* synthetic */ Report copy$default(Report report, Uri uri, String str, String str2, Integer num, Feature feature, boolean z2, Error error, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = report.screenshotUri;
                }
                if ((i & 2) != 0) {
                    str = report.reportName;
                }
                String str3 = str;
                if ((i & 4) != 0) {
                    str2 = report.reportDescription;
                }
                String str4 = str2;
                if ((i & 8) != 0) {
                    num = report.priority;
                }
                Integer num2 = num;
                if ((i & 16) != 0) {
                    feature = report.feature;
                }
                Feature feature2 = feature;
                if ((i & 32) != 0) {
                    z2 = report.useScreenshot;
                }
                boolean z3 = z2;
                if ((i & 64) != 0) {
                    error = report.error;
                }
                return report.copy(uri, str3, str4, num2, feature2, z3, error);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Uri getScreenshotUri() {
                return this.screenshotUri;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getReportName() {
                return this.reportName;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getReportDescription() {
                return this.reportDescription;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final Integer getPriority() {
                return this.priority;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Feature getFeature() {
                return this.feature;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getUseScreenshot() {
                return this.useScreenshot;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final Error getError() {
                return this.error;
            }

            public final Report copy(Uri screenshotUri, String reportName, String reportDescription, Integer priority, Feature feature, boolean useScreenshot, Error error) {
                C12238m.checkNotNullParameter(screenshotUri, "screenshotUri");
                return new Report(screenshotUri, reportName, reportDescription, priority, feature, useScreenshot, error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Report)) {
                    return false;
                }
                Report report = (Report) other;
                return C12238m.areEqual(this.screenshotUri, report.screenshotUri) && C12238m.areEqual(this.reportName, report.reportName) && C12238m.areEqual(this.reportDescription, report.reportDescription) && C12238m.areEqual(this.priority, report.priority) && C12238m.areEqual(this.feature, report.feature) && this.useScreenshot == report.useScreenshot && C12238m.areEqual(this.error, report.error);
            }

            public final Error getError() {
                return this.error;
            }

            public final Feature getFeature() {
                return this.feature;
            }

            public final Integer getPriority() {
                return this.priority;
            }

            public final String getReportDescription() {
                return this.reportDescription;
            }

            public final String getReportName() {
                return this.reportName;
            }

            public final Uri getScreenshotUri() {
                return this.screenshotUri;
            }

            public final boolean getUseScreenshot() {
                return this.useScreenshot;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v12, types: [int] */
            /* JADX WARN: Type inference failed for: r2v13, types: [int] */
            /* JADX WARN: Type inference failed for: r2v15 */
            /* JADX WARN: Type inference failed for: r2v20 */
            public int hashCode() {
                Uri uri = this.screenshotUri;
                int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
                String str = this.reportName;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.reportDescription;
                int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
                Integer num = this.priority;
                int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
                Feature feature = this.feature;
                int iHashCode5 = (iHashCode4 + (feature != null ? feature.hashCode() : 0)) * 31;
                boolean z2 = this.useScreenshot;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode5 + r2) * 31;
                Error error = this.error;
                return i + (error != null ? error.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Report(screenshotUri=");
                sbM833U.append(this.screenshotUri);
                sbM833U.append(", reportName=");
                sbM833U.append(this.reportName);
                sbM833U.append(", reportDescription=");
                sbM833U.append(this.reportDescription);
                sbM833U.append(", priority=");
                sbM833U.append(this.priority);
                sbM833U.append(", feature=");
                sbM833U.append(this.feature);
                sbM833U.append(", useScreenshot=");
                sbM833U.append(this.useScreenshot);
                sbM833U.append(", error=");
                sbM833U.append(this.error);
                sbM833U.append(")");
                return sbM833U.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Report(Uri uri, String str, String str2, Integer num, Feature feature, boolean z2, Error error) {
                super(null);
                C12238m.checkNotNullParameter(uri, "screenshotUri");
                this.screenshotUri = uri;
                this.reportName = str;
                this.reportDescription = str2;
                this.priority = num;
                this.feature = feature;
                this.useScreenshot = z2;
                this.error = error;
            }
        }

        /* JADX INFO: compiled from: BugReportViewModel.kt */
        public static final /* data */ class SelectFeature extends ViewState {
            private final List<Feature> features;
            private final boolean loadingFeatures;
            private final String query;

            public SelectFeature() {
                this(null, false, null, 7, null);
            }

            public /* synthetic */ SelectFeature(String str, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? C12147n.emptyList() : list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SelectFeature copy$default(SelectFeature selectFeature, String str, boolean z2, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = selectFeature.query;
                }
                if ((i & 2) != 0) {
                    z2 = selectFeature.loadingFeatures;
                }
                if ((i & 4) != 0) {
                    list = selectFeature.features;
                }
                return selectFeature.copy(str, z2, list);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getQuery() {
                return this.query;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getLoadingFeatures() {
                return this.loadingFeatures;
            }

            public final List<Feature> component3() {
                return this.features;
            }

            public final SelectFeature copy(String query, boolean loadingFeatures, List<Feature> features) {
                C12238m.checkNotNullParameter(features, "features");
                return new SelectFeature(query, loadingFeatures, features);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SelectFeature)) {
                    return false;
                }
                SelectFeature selectFeature = (SelectFeature) other;
                return C12238m.areEqual(this.query, selectFeature.query) && this.loadingFeatures == selectFeature.loadingFeatures && C12238m.areEqual(this.features, selectFeature.features);
            }

            public final List<Feature> getFeatures() {
                return this.features;
            }

            public final boolean getLoadingFeatures() {
                return this.loadingFeatures;
            }

            public final String getQuery() {
                return this.query;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3 */
            /* JADX WARN: Type inference failed for: r2v4 */
            public int hashCode() {
                String str = this.query;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                boolean z2 = this.loadingFeatures;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode + r2) * 31;
                List<Feature> list = this.features;
                return i + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("SelectFeature(query=");
                sbM833U.append(this.query);
                sbM833U.append(", loadingFeatures=");
                sbM833U.append(this.loadingFeatures);
                sbM833U.append(", features=");
                return C1643a.m824L(sbM833U, this.features, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SelectFeature(String str, boolean z2, List<Feature> list) {
                super(null);
                C12238m.checkNotNullParameter(list, "features");
                this.query = str;
                this.loadingFeatures = z2;
                this.features = list;
            }
        }

        /* JADX INFO: compiled from: BugReportViewModel.kt */
        public static final /* data */ class Sending extends ViewState {
            private final Sticker sendingSticker;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Sending(Sticker sticker) {
                super(null);
                C12238m.checkNotNullParameter(sticker, "sendingSticker");
                this.sendingSticker = sticker;
            }

            public static /* synthetic */ Sending copy$default(Sending sending, Sticker sticker, int i, Object obj) {
                if ((i & 1) != 0) {
                    sticker = sending.sendingSticker;
                }
                return sending.copy(sticker);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Sticker getSendingSticker() {
                return this.sendingSticker;
            }

            public final Sending copy(Sticker sendingSticker) {
                C12238m.checkNotNullParameter(sendingSticker, "sendingSticker");
                return new Sending(sendingSticker);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Sending) && C12238m.areEqual(this.sendingSticker, ((Sending) other).sendingSticker);
                }
                return true;
            }

            public final Sticker getSendingSticker() {
                return this.sendingSticker;
            }

            public int hashCode() {
                Sticker sticker = this.sendingSticker;
                if (sticker != null) {
                    return sticker.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Sending(sendingSticker=");
                sbM833U.append(this.sendingSticker);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: BugReportViewModel.kt */
        public static final /* data */ class Success extends ViewState {
            private final Sticker successSticker;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(Sticker sticker) {
                super(null);
                C12238m.checkNotNullParameter(sticker, "successSticker");
                this.successSticker = sticker;
            }

            public static /* synthetic */ Success copy$default(Success success, Sticker sticker, int i, Object obj) {
                if ((i & 1) != 0) {
                    sticker = success.successSticker;
                }
                return success.copy(sticker);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Sticker getSuccessSticker() {
                return this.successSticker;
            }

            public final Success copy(Sticker successSticker) {
                C12238m.checkNotNullParameter(successSticker, "successSticker");
                return new Success(successSticker);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Success) && C12238m.areEqual(this.successSticker, ((Success) other).successSticker);
                }
                return true;
            }

            public final Sticker getSuccessSticker() {
                return this.successSticker;
            }

            public int hashCode() {
                Sticker sticker = this.successSticker;
                if (sticker != null) {
                    return sticker.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Success(successSticker=");
                sbM833U.append(this.successSticker);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.BugReportViewModel$dismissAfterDelay$1 */
    /* JADX INFO: compiled from: BugReportViewModel.kt */
    public static final class C72831 extends AbstractC12240o implements Function1<Long, Unit> {
        public C72831() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            BugReportViewModel.this.eventSubject.f27650k.onNext((T) Event.CloseReport.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.BugReportViewModel$loadFeatures$1 */
    /* JADX INFO: compiled from: BugReportViewModel.kt */
    public static final class C72841 extends AbstractC12240o implements Function1<RestCallState<? extends BugReportConfig>, Unit> {
        public C72841() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends BugReportConfig> restCallState) {
            invoke2((RestCallState<BugReportConfig>) restCallState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<BugReportConfig> restCallState) {
            C12238m.checkNotNullParameter(restCallState, "it");
            BugReportViewModel.this.bugReportConfig = restCallState;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.BugReportViewModel$prefetchStickers$1 */
    /* JADX INFO: compiled from: BugReportViewModel.kt */
    public static final class C72851 extends AbstractC12240o implements Function1<DownloadUtils.DownloadState, Unit> {
        public static final C72851 INSTANCE = new C72851();

        public C72851() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DownloadUtils.DownloadState downloadState) {
            invoke2(downloadState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DownloadUtils.DownloadState downloadState) {
            C12238m.checkNotNullParameter(downloadState, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.BugReportViewModel$prefetchStickers$2 */
    /* JADX INFO: compiled from: BugReportViewModel.kt */
    public static final class C72862 extends AbstractC12240o implements Function1<DownloadUtils.DownloadState, Unit> {
        public static final C72862 INSTANCE = new C72862();

        public C72862() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DownloadUtils.DownloadState downloadState) {
            invoke2(downloadState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DownloadUtils.DownloadState downloadState) {
            C12238m.checkNotNullParameter(downloadState, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.BugReportViewModel$sendReport$1 */
    /* JADX INFO: compiled from: BugReportViewModel.kt */
    public static final class C72871 extends AbstractC12240o implements Function1<Unit, Unit> {
        public C72871() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            BugReportViewModel bugReportViewModel = BugReportViewModel.this;
            bugReportViewModel.updateViewState(new ViewState.Success(bugReportViewModel.getSuccessSticker()));
            BugReportViewModel.this.dismissAfterDelay();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.BugReportViewModel$sendReport$2 */
    /* JADX INFO: compiled from: BugReportViewModel.kt */
    public static final class C72882 extends AbstractC12240o implements Function1<Error, Unit> {
        public C72882() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            BugReportViewModel.this.showReport(error);
        }
    }

    static {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        sendingStickers = C12147n.listOfNotNull((Object[]) new Sticker[]{companion.getStickers().getStickers().get(754107634172297306L), companion.getStickers().getStickers().get(751606719611928586L), companion.getStickers().getStickers().get(749049128012742676L), companion.getStickers().getStickers().get(761114619137359892L), companion.getStickers().getStickers().get(783788733987815434L)});
        successStickers = C12147n.listOfNotNull((Object[]) new Sticker[]{companion.getStickers().getStickers().get(754109076933443614L), companion.getStickers().getStickers().get(751606065447305216L), companion.getStickers().getStickers().get(749053689419006003L), companion.getStickers().getStickers().get(761108384010862602L), companion.getStickers().getStickers().get(783794979704537108L)});
    }

    public /* synthetic */ BugReportViewModel(Uri uri, String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, str, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    private final void dismissAfterDelay() {
        Observable<Long> observableM11068d0 = Observable.m11068d0(1500L, TimeUnit.MILLISECONDS);
        C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable.timer(1500, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11068d0, this, null, 2, null), (Class<?>) BugReportViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72831());
    }

    private final List<Feature> filterFeatures(String filter) {
        BugReportConfig bugReportConfigInvoke;
        RestCallState<BugReportConfig> restCallState = this.bugReportConfig;
        List<Feature> listM7625a = (restCallState == null || (bugReportConfigInvoke = restCallState.invoke()) == null) ? null : bugReportConfigInvoke.m7625a();
        if (listM7625a == null) {
            listM7625a = C12147n.emptyList();
        }
        List<Feature> listPlus = C12163u.plus((Collection) listM7625a, (Iterable) genericFeatureAreas);
        if (filter == null) {
            return listPlus;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listPlus) {
            Feature feature = (Feature) obj;
            boolean z2 = true;
            if (!C12106w.contains((CharSequence) feature.getName(), (CharSequence) filter, true) && !C12106w.contains((CharSequence) feature.getSquad(), (CharSequence) filter, true)) {
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void showReport$default(BugReportViewModel bugReportViewModel, Error error, int i, Object obj) {
        if ((i & 1) != 0) {
            error = null;
        }
        bugReportViewModel.showReport(error);
    }

    public final Feature getFeature() {
        return this.feature;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final String getReportDescription() {
        return this.reportDescription;
    }

    public final String getReportName() {
        return this.reportName;
    }

    public final RestAPI getRestApi() {
        return this.restApi;
    }

    public final String getScreenshotName() {
        return this.screenshotName;
    }

    public final Uri getScreenshotUri() {
        return this.screenshotUri;
    }

    public final Sticker getSendingSticker() {
        return this.sendingSticker;
    }

    public final boolean getStickersPrefetched() {
        return this.stickersPrefetched;
    }

    public final Sticker getSuccessSticker() {
        return this.successSticker;
    }

    public final boolean getUseScreenshot() {
        return this.useScreenshot;
    }

    public final void loadFeatures() {
        RestCallStateKt.executeRequest(this.restApi.getBugReportConfig(), new C72841());
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void prefetchStickers(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        if (this.stickersPrefetched) {
            return;
        }
        StickerUtils stickerUtils = StickerUtils.INSTANCE;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(stickerUtils.fetchSticker(context, this.sendingSticker), false, 1, null), (Class<?>) BugReportViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C72851.INSTANCE);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(stickerUtils.fetchSticker(context, this.successSticker), false, 1, null), (Class<?>) BugReportViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C72862.INSTANCE);
        this.stickersPrefetched = true;
    }

    public final void selectFeatureArea(Feature feature) {
        this.feature = feature;
        showReport$default(this, null, 1, null);
    }

    @MainThread
    public final void sendReport(RequestBody screenshotBody) {
        Integer num;
        String str = this.reportName;
        if (str == null || (num = this.priority) == null) {
            return;
        }
        int iIntValue = num.intValue();
        MultipartBody.Part partM10971b = screenshotBody != null ? MultipartBody.Part.m10971b("screenshot", this.screenshotName, screenshotBody) : null;
        updateViewState(new ViewState.Sending(this.sendingSticker));
        RestAPI restAPI = this.restApi;
        String str2 = this.reportDescription;
        Feature feature = this.feature;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.restSubscribeOn$default(restAPI.sendBugReport(str, str2, iIntValue, feature != null ? feature.getAsanaInboxId() : null, partM10971b), false, 1, null)), (Class<?>) BugReportViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C72882()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72871());
    }

    public final void setFeature(Feature feature) {
        this.feature = feature;
    }

    public final void setPriority(Integer num) {
        this.priority = num;
    }

    public final void setReportDescription(String str) {
        this.reportDescription = str;
    }

    public final void setReportName(String str) {
        this.reportName = str;
    }

    public final void setStickersPrefetched(boolean z2) {
        this.stickersPrefetched = z2;
    }

    public final void setUseScreenshot(boolean z2) {
        this.useScreenshot = z2;
    }

    public final void showFeatureAreas() {
        String str = this.featureSearchQuery;
        updateViewState(new ViewState.SelectFeature(str, this.bugReportConfig instanceof Loading, C12163u.sortedWith(filterFeatures(str), new Comparator() { // from class: com.discord.widgets.bugreports.BugReportViewModel$showFeatureAreas$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Feature feature = (Feature) t;
                Feature feature2 = (Feature) t2;
                return C12169a.compareValues(feature.getSquad() + feature.getName(), feature2.getSquad() + feature2.getName());
            }
        })));
    }

    public final void showReport(Error error) {
        updateViewState(new ViewState.Report(this.screenshotUri, this.reportName, this.reportDescription, this.priority, this.feature, this.useScreenshot, error));
    }

    @MainThread
    public final void updatePriority(int priority) {
        this.priority = Integer.valueOf(priority);
        showReport$default(this, null, 1, null);
    }

    @MainThread
    public final void updateReportDescription(String description) {
        C12238m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        this.reportDescription = description;
        showReport$default(this, null, 1, null);
    }

    @MainThread
    public final void updateReportName(String name) {
        C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.reportName = name;
        showReport$default(this, null, 1, null);
    }

    @MainThread
    public final void useScreenshot(boolean useScreenshot) {
        this.useScreenshot = useScreenshot;
        showReport$default(this, null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BugReportViewModel(Uri uri, String str, RestAPI restAPI) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(uri, "screenshotUri");
        C12238m.checkNotNullParameter(restAPI, "restApi");
        this.screenshotUri = uri;
        this.screenshotName = str;
        this.restApi = restAPI;
        List<Sticker> list = sendingStickers;
        int iRandom = C11226f.random(C12147n.getIndices(list), AbstractC11216c.f22272k);
        this.stickerCharacterIndex = iRandom;
        this.sendingSticker = list.get(iRandom);
        this.successSticker = successStickers.get(iRandom);
        this.useScreenshot = true;
        this.eventSubject = PublishSubject.m11133k0();
        loadFeatures();
    }

    /* JADX INFO: renamed from: filterFeatures, reason: collision with other method in class */
    public final void m11400filterFeatures(String it) {
        C12238m.checkNotNullParameter(it, "it");
        this.featureSearchQuery = it;
        showFeatureAreas();
    }
}
