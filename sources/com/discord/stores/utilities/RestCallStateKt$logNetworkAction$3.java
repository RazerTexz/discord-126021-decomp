package com.discord.stores.utilities;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.utilities.analytics.AnalyticsUtils$Tracker;
import com.discord.utilities.features.GrowthTeamFeatures;
import java.net.UnknownHostException;
import kotlin.jvm.functions.Function1;
import okhttp3.Request;
import retrofit2.HttpException;
import retrofit2.Response;
import rx.functions.Action1;

/* JADX INFO: compiled from: RestCallState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestCallStateKt$logNetworkAction$3<T> implements Action1<Throwable> {
    public final /* synthetic */ Function1 $networkActionProvider;
    public final /* synthetic */ AnalyticsUtils$Tracker $tracker;

    public RestCallStateKt$logNetworkAction$3(Function1 function1, AnalyticsUtils$Tracker analyticsUtils$Tracker) {
        this.$networkActionProvider = function1;
        this.$tracker = analyticsUtils$Tracker;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Throwable th) {
        call2(th);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x006e  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Throwable th) {
        TrackNetworkMetadata trackNetworkMetadata;
        TrackNetworkMetadataReceiver schema$default;
        Request request;
        if (GrowthTeamFeatures.INSTANCE.isNetworkActionLoggingEnabled()) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                Response<?> response = httpException.j;
                if (response == null || (request = RestCallStateKt.getRequest(response)) == null) {
                    trackNetworkMetadata = null;
                } else {
                    String str = request.url.l;
                    String str2 = request.method;
                    Response<?> response2 = httpException.j;
                    Long lValueOf = response2 != null ? Long.valueOf(response2.a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String) : null;
                    Response<?> response3 = httpException.j;
                    Long lValueOf2 = response3 != null ? Long.valueOf(response3.a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String) : null;
                    Response<?> response4 = httpException.j;
                    String str3 = response4 != null ? response4.a.message : null;
                    if (str3 == null) {
                        str3 = "";
                    }
                    trackNetworkMetadata = new TrackNetworkMetadata(str, str2, lValueOf, lValueOf2, str3);
                }
            } else if (th instanceof UnknownHostException) {
                trackNetworkMetadata = new TrackNetworkMetadata(null, null, null, null, ((UnknownHostException) th).getLocalizedMessage(), 15);
            } else {
                trackNetworkMetadata = null;
            }
            if (trackNetworkMetadata == null || (schema$default = RestCallStateKt.getSchema$default(this.$networkActionProvider, trackNetworkMetadata, null, 4, null)) == null) {
                return;
            }
            this.$tracker.track(schema$default);
        }
    }
}
