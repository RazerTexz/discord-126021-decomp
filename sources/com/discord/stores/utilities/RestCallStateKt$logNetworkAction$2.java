package com.discord.stores.utilities;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.utilities.analytics.AnalyticsUtils$Tracker;
import com.discord.utilities.features.GrowthTeamFeatures;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import okhttp3.Request;
import retrofit2.HttpException;
import retrofit2.Response;
import rx.functions.Action1;

/* JADX INFO: compiled from: RestCallState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestCallStateKt$logNetworkAction$2<T> implements Action1<Response<T>> {
    public final /* synthetic */ Function1 $networkActionProvider;
    public final /* synthetic */ AnalyticsUtils$Tracker $tracker;

    public RestCallStateKt$logNetworkAction$2(Function1 function1, AnalyticsUtils$Tracker analyticsUtils$Tracker) {
        this.$networkActionProvider = function1;
        this.$tracker = analyticsUtils$Tracker;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Response) obj);
    }

    public final void call(Response<T> response) {
        TrackNetworkMetadataReceiver schema;
        m.checkNotNullExpressionValue(response, "response");
        if (!response.a()) {
            throw new HttpException(response);
        }
        Request request = RestCallStateKt.getRequest(response);
        if (!GrowthTeamFeatures.INSTANCE.isNetworkActionLoggingEnabled() || (schema = RestCallStateKt.getSchema(this.$networkActionProvider, new TrackNetworkMetadata(request.url.l, request.method, Long.valueOf(response.a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String), null, null, 24), response.f3824b)) == null) {
            return;
        }
        this.$tracker.track(schema);
    }
}
