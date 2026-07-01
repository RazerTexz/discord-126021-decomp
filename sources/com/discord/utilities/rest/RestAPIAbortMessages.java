package com.discord.utilities.rest;

import com.discord.restapi.RestAPIAbortCodes;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Type;
import d0.o;
import d0.t.h0;
import d0.z.d.m;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RestAPIAbortMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPIAbortMessages {
    public static final RestAPIAbortMessages INSTANCE = new RestAPIAbortMessages();
    private static final Map<Integer, Integer> MESSAGES;

    static {
        Integer numValueOf = Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INCOMING_DISABLED);
        MESSAGES = h0.mapOf(o.to(numValueOf, 2131887280), o.to(Integer.valueOf(RestAPIAbortCodes.INVALID_MESSAGE_SEND_USER), 2131887271), o.to(Integer.valueOf(RestAPIAbortCodes.RATE_LIMIT_DM_OPEN), 2131887270), o.to(Integer.valueOf(RestAPIAbortCodes.SEND_MESSAGE_TEMPORARILY_DISABLED), 2131887274), o.to(numValueOf, 2131886332), o.to(Integer.valueOf(RestAPIAbortCodes.TOO_MANY_FRIENDS), 2131886335), o.to(Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INCOMING_BLOCKED), 2131886334), o.to(Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INVALID_SELF), 2131886334), o.to(Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INVALID_USER_BOT), 2131886334), o.to(Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INVALID_DISCORD_TAG), 2131886334), o.to(Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_ALREADY_FRIENDS), 2131886330), o.to(Integer.valueOf(RestAPIAbortCodes.TOO_MANY_THREADS), 2131896457), o.to(Integer.valueOf(RestAPIAbortCodes.TOO_MANY_ANNOUNCEMENT_THREADS), 2131896450), o.to(Integer.valueOf(RestAPIAbortCodes.SLOWMODE_RATE_LIMITED), 2131887611));
    }

    private RestAPIAbortMessages() {
    }

    public static final Integer getAbortCodeMessageResId(int abortCode) {
        return MESSAGES.get(Integer.valueOf(abortCode));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleAbortCodeOrDefault$default(RestAPIAbortMessages restAPIAbortMessages, Error error, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = RestAPIAbortMessages$handleAbortCodeOrDefault$1.INSTANCE;
        }
        restAPIAbortMessages.handleAbortCodeOrDefault(error, function0, function1);
    }

    public final void handleAbortCodeOrDefault(Error errorResponse, Function0<Unit> onHandle, Function0<Boolean> onDefault) {
        m.checkNotNullParameter(errorResponse, "errorResponse");
        m.checkNotNullParameter(onHandle, "onHandle");
        m.checkNotNullParameter(onDefault, "onDefault");
        if (errorResponse.getType() != Error$Type.DISCORD_BAD_REQUEST) {
            errorResponse.setShowErrorToasts(onDefault.invoke().booleanValue());
        } else {
            errorResponse.setShowErrorToasts(false);
            onHandle.invoke();
        }
    }
}
