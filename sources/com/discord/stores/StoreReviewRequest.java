package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences$Editor;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelPayload;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.Clock;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: StoreReviewRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreReviewRequest extends Store {
    public static final StoreReviewRequest$Companion Companion = new StoreReviewRequest$Companion(null);
    private static final int MINIMUM_GUILD_MEMBER_COUNT = 5;
    private static final long MINIMUM_INSTALL_AGE = 864000000;
    private static final int REVIEW_REQUEST_REVISION = 693;
    private final Clock clock;
    private boolean hasUserAcceptedReviewRequest;
    private int requestedReviewRevision;
    private final StoreStream stream;

    public StoreReviewRequest(Clock clock, StoreStream storeStream) {
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeStream, "stream");
        this.clock = clock;
        this.stream = storeStream;
        this.requestedReviewRevision = -1;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0035  */
    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        boolean z2;
        boolean z3;
        m.checkNotNullParameter(payload, "payload");
        List<Guild> guilds = payload.getGuilds();
        if (guilds != null) {
            if (!guilds.isEmpty()) {
                Iterator<T> it = guilds.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z3 = false;
                        break;
                    } else {
                        if (((Guild) it.next()).getMemberCount() >= 5) {
                            z3 = true;
                            break;
                        }
                    }
                }
            } else {
                z3 = false;
                break;
            }
            z2 = z3;
        }
        Boolean verified = payload.getMe().getVerified();
        boolean zBooleanValue = verified != null ? verified.booleanValue() : false;
        if (!z2 || !zBooleanValue || this.hasUserAcceptedReviewRequest || this.requestedReviewRevision >= REVIEW_REQUEST_REVISION) {
            return;
        }
        if (this.clock.currentTimeMillis() <= this.stream.getNotices().getFirstUseTimestamp() + MINIMUM_INSTALL_AGE) {
            return;
        }
        this.stream.getNotices().requestToShow(StoreNotices$Dialog$Type.buildPassiveNotice$default(StoreNotices$Dialog$Type.REQUEST_RATING_MODAL, 0, 31536000000L, 0L, true, 5, null));
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        this.requestedReviewRevision = getPrefsSessionDurable().getInt("CACHE_KEY_VIEWED_REVIEW_REQUEST_REVISION", this.requestedReviewRevision);
        this.hasUserAcceptedReviewRequest = getPrefsSessionDurable().getBoolean("CACHE_KEY_HAS_ACCEPTED_REVIEW_REQUEST", this.hasUserAcceptedReviewRequest);
    }

    public final void onReviewRequestShown() {
        this.requestedReviewRevision = REVIEW_REQUEST_REVISION;
        SharedPreferences$Editor sharedPreferences$EditorEdit = getPrefsSessionDurable().edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putInt("CACHE_KEY_VIEWED_REVIEW_REQUEST_REVISION", REVIEW_REQUEST_REVISION);
        sharedPreferences$EditorEdit.apply();
        this.stream.getNotices().markSeen(StoreNotices$Dialog$Type.REQUEST_RATING_MODAL);
        AnalyticsTracker.INSTANCE.reviewRequestTriggered();
    }

    public final void onUserAcceptedRequest() {
        this.hasUserAcceptedReviewRequest = true;
        SharedPreferences$Editor sharedPreferences$EditorEdit = getPrefsSessionDurable().edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putBoolean("CACHE_KEY_HAS_ACCEPTED_REVIEW_REQUEST", true);
        sharedPreferences$EditorEdit.apply();
        AnalyticsTracker.INSTANCE.reviewRequestAccepted();
    }

    public final void onUserDismissedRequest() {
        AnalyticsTracker.INSTANCE.reviewRequestDismissed();
    }
}
