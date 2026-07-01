package com.discord.widgets.bugreports;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.bugreport.BugReportConfig;
import com.discord.api.bugreport.Feature;
import com.discord.api.sticker.Sticker;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.utilities.Loading;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import d0.c0.c;
import d0.d0.f;
import d0.g0.w;
import d0.t.m;
import d0.t.n;
import d0.t.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.MultipartBody$Part;
import okhttp3.RequestBody;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: BugReportViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportViewModel extends d0<BugReportViewModel$ViewState> {
    public static final BugReportViewModel$Companion Companion = new BugReportViewModel$Companion(null);
    private static final List<Feature> genericFeatureAreas = m.listOf(new Feature(NotificationClient.NOTIF_GENERAL, "Android", null));
    private static final List<Sticker> sendingStickers;
    private static final List<Sticker> successStickers;
    private RestCallState<BugReportConfig> bugReportConfig;
    private final PublishSubject<BugReportViewModel$Event> eventSubject;
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

    static {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        sendingStickers = n.listOfNotNull((Object[]) new Sticker[]{storeStream$Companion.getStickers().getStickers().get(754107634172297306L), storeStream$Companion.getStickers().getStickers().get(751606719611928586L), storeStream$Companion.getStickers().getStickers().get(749049128012742676L), storeStream$Companion.getStickers().getStickers().get(761114619137359892L), storeStream$Companion.getStickers().getStickers().get(783788733987815434L)});
        successStickers = n.listOfNotNull((Object[]) new Sticker[]{storeStream$Companion.getStickers().getStickers().get(754109076933443614L), storeStream$Companion.getStickers().getStickers().get(751606065447305216L), storeStream$Companion.getStickers().getStickers().get(749053689419006003L), storeStream$Companion.getStickers().getStickers().get(761108384010862602L), storeStream$Companion.getStickers().getStickers().get(783794979704537108L)});
    }

    public /* synthetic */ BugReportViewModel(Uri uri, String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, str, (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ void access$dismissAfterDelay(BugReportViewModel bugReportViewModel) {
        bugReportViewModel.dismissAfterDelay();
    }

    public static final /* synthetic */ RestCallState access$getBugReportConfig$p(BugReportViewModel bugReportViewModel) {
        return bugReportViewModel.bugReportConfig;
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(BugReportViewModel bugReportViewModel) {
        return bugReportViewModel.eventSubject;
    }

    public static final /* synthetic */ List access$getGenericFeatureAreas$cp() {
        return genericFeatureAreas;
    }

    public static final /* synthetic */ List access$getSendingStickers$cp() {
        return sendingStickers;
    }

    public static final /* synthetic */ List access$getSuccessStickers$cp() {
        return successStickers;
    }

    public static final /* synthetic */ void access$setBugReportConfig$p(BugReportViewModel bugReportViewModel, RestCallState restCallState) {
        bugReportViewModel.bugReportConfig = restCallState;
    }

    public static final /* synthetic */ void access$updateViewState(BugReportViewModel bugReportViewModel, BugReportViewModel$ViewState bugReportViewModel$ViewState) {
        bugReportViewModel.updateViewState(bugReportViewModel$ViewState);
    }

    private final void dismissAfterDelay() {
        Observable<Long> observableD0 = Observable.d0(1500L, TimeUnit.MILLISECONDS);
        d0.z.d.m.checkNotNullExpressionValue(observableD0, "Observable.timer(1500, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), BugReportViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new BugReportViewModel$dismissAfterDelay$1(this), 62, (Object) null);
    }

    private final List<Feature> filterFeatures(String filter) {
        BugReportConfig bugReportConfigInvoke;
        RestCallState<BugReportConfig> restCallState = this.bugReportConfig;
        List<Feature> listA = (restCallState == null || (bugReportConfigInvoke = restCallState.invoke()) == null) ? null : bugReportConfigInvoke.a();
        if (listA == null) {
            listA = n.emptyList();
        }
        List<Feature> listPlus = u.plus((Collection) listA, (Iterable) genericFeatureAreas);
        if (filter == null) {
            return listPlus;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listPlus) {
            Feature feature = (Feature) obj;
            boolean z2 = true;
            if (!w.contains((CharSequence) feature.getName(), (CharSequence) filter, true) && !w.contains((CharSequence) feature.getSquad(), (CharSequence) filter, true)) {
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
        RestCallStateKt.executeRequest(this.restApi.getBugReportConfig(), new BugReportViewModel$loadFeatures$1(this));
    }

    public final Observable<BugReportViewModel$Event> observeEvents() {
        PublishSubject<BugReportViewModel$Event> publishSubject = this.eventSubject;
        d0.z.d.m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void prefetchStickers(Context context) {
        d0.z.d.m.checkNotNullParameter(context, "context");
        if (this.stickersPrefetched) {
            return;
        }
        StickerUtils stickerUtils = StickerUtils.INSTANCE;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(stickerUtils.fetchSticker(context, this.sendingSticker), false, 1, null), BugReportViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, BugReportViewModel$prefetchStickers$1.INSTANCE, 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(stickerUtils.fetchSticker(context, this.successSticker), false, 1, null), BugReportViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, BugReportViewModel$prefetchStickers$2.INSTANCE, 62, (Object) null);
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
        MultipartBody$Part multipartBody$PartB = screenshotBody != null ? MultipartBody$Part.b("screenshot", this.screenshotName, screenshotBody) : null;
        updateViewState(new BugReportViewModel$ViewState$Sending(this.sendingSticker));
        RestAPI restAPI = this.restApi;
        String str2 = this.reportDescription;
        Feature feature = this.feature;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(restAPI.sendBugReport(str, str2, iIntValue, feature != null ? feature.getAsanaInboxId() : null, multipartBody$PartB), false, 1, null)), BugReportViewModel.class, (Context) null, (Function1) null, new BugReportViewModel$sendReport$2(this), (Function0) null, (Function0) null, new BugReportViewModel$sendReport$1(this), 54, (Object) null);
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
        updateViewState(new BugReportViewModel$ViewState$SelectFeature(str, this.bugReportConfig instanceof Loading, u.sortedWith(filterFeatures(str), new BugReportViewModel$showFeatureAreas$$inlined$sortedBy$1())));
    }

    public final void showReport(Error error) {
        updateViewState(new BugReportViewModel$ViewState$Report(this.screenshotUri, this.reportName, this.reportDescription, this.priority, this.feature, this.useScreenshot, error));
    }

    @MainThread
    public final void updatePriority(int priority) {
        this.priority = Integer.valueOf(priority);
        showReport$default(this, null, 1, null);
    }

    @MainThread
    public final void updateReportDescription(String description) {
        d0.z.d.m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        this.reportDescription = description;
        showReport$default(this, null, 1, null);
    }

    @MainThread
    public final void updateReportName(String name) {
        d0.z.d.m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
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
        d0.z.d.m.checkNotNullParameter(uri, "screenshotUri");
        d0.z.d.m.checkNotNullParameter(restAPI, "restApi");
        this.screenshotUri = uri;
        this.screenshotName = str;
        this.restApi = restAPI;
        List<Sticker> list = sendingStickers;
        int iRandom = f.random(n.getIndices(list), c.k);
        this.stickerCharacterIndex = iRandom;
        this.sendingSticker = list.get(iRandom);
        this.successSticker = successStickers.get(iRandom);
        this.useScreenshot = true;
        this.eventSubject = PublishSubject.k0();
        loadFeatures();
    }

    /* JADX INFO: renamed from: filterFeatures, reason: collision with other method in class */
    public final void m23filterFeatures(String it) {
        d0.z.d.m.checkNotNullParameter(it, "it");
        this.featureSearchQuery = it;
        showFeatureAreas();
    }
}
