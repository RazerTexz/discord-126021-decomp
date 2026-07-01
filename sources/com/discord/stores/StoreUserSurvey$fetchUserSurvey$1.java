package com.discord.stores;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserSurveyFetch;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.user.UserSurvey;
import com.discord.api.user.UserSurveyFetchResponse;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserSurvey.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSurvey$fetchUserSurvey$1 extends o implements Function1<UserSurveyFetchResponse, TrackNetworkMetadataReceiver> {
    public static final StoreUserSurvey$fetchUserSurvey$1 INSTANCE = new StoreUserSurvey$fetchUserSurvey$1();

    public StoreUserSurvey$fetchUserSurvey$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(UserSurveyFetchResponse userSurveyFetchResponse) {
        return invoke2(userSurveyFetchResponse);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(UserSurveyFetchResponse userSurveyFetchResponse) {
        UserSurvey survey;
        return new TrackNetworkActionUserSurveyFetch((userSurveyFetchResponse == null || (survey = userSurveyFetchResponse.getSurvey()) == null) ? null : survey.getKey());
    }
}
