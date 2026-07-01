package com.discord.utilities.rest;

import b.d.b.a.a;
import com.discord.restapi.RestAPIParams$Message;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SendUtils$SendPayload$ReadyToSend extends SendUtils$SendPayload {
    private final RestAPIParams$Message message;
    private final List<SendUtils$FileUpload> uploads;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendUtils$SendPayload$ReadyToSend(RestAPIParams$Message restAPIParams$Message, List<SendUtils$FileUpload> list) {
        super(null);
        m.checkNotNullParameter(restAPIParams$Message, "message");
        m.checkNotNullParameter(list, "uploads");
        this.message = restAPIParams$Message;
        this.uploads = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SendUtils$SendPayload$ReadyToSend copy$default(SendUtils$SendPayload$ReadyToSend sendUtils$SendPayload$ReadyToSend, RestAPIParams$Message restAPIParams$Message, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            restAPIParams$Message = sendUtils$SendPayload$ReadyToSend.message;
        }
        if ((i & 2) != 0) {
            list = sendUtils$SendPayload$ReadyToSend.uploads;
        }
        return sendUtils$SendPayload$ReadyToSend.copy(restAPIParams$Message, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RestAPIParams$Message getMessage() {
        return this.message;
    }

    public final List<SendUtils$FileUpload> component2() {
        return this.uploads;
    }

    public final SendUtils$SendPayload$ReadyToSend copy(RestAPIParams$Message message, List<SendUtils$FileUpload> uploads) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(uploads, "uploads");
        return new SendUtils$SendPayload$ReadyToSend(message, uploads);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendUtils$SendPayload$ReadyToSend)) {
            return false;
        }
        SendUtils$SendPayload$ReadyToSend sendUtils$SendPayload$ReadyToSend = (SendUtils$SendPayload$ReadyToSend) other;
        return m.areEqual(this.message, sendUtils$SendPayload$ReadyToSend.message) && m.areEqual(this.uploads, sendUtils$SendPayload$ReadyToSend.uploads);
    }

    public final RestAPIParams$Message getMessage() {
        return this.message;
    }

    public final List<SendUtils$FileUpload> getUploads() {
        return this.uploads;
    }

    public int hashCode() {
        RestAPIParams$Message restAPIParams$Message = this.message;
        int iHashCode = (restAPIParams$Message != null ? restAPIParams$Message.hashCode() : 0) * 31;
        List<SendUtils$FileUpload> list = this.uploads;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ReadyToSend(message=");
        sbU.append(this.message);
        sbU.append(", uploads=");
        return a.L(sbU, this.uploads, ")");
    }
}
