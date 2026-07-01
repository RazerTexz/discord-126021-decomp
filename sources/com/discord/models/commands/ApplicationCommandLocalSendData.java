package com.discord.models.commands;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.commands.ApplicationCommandData2;
import com.discord.api.commands.ApplicationCommandData3;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: compiled from: ApplicationCommandLocalSendData.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApplicationCommandLocalSendData {
    private final Application application;
    private final String applicationCommandId;
    private final String applicationCommandName;
    private final List<ApplicationCommandValue> applicationCommandsValues;
    private final long channelId;
    private final Long commandGuildId;
    private final Long guildId;
    private final Long interactionId;
    private final long nonce;
    private final String nonceString;
    private final String sessionId;
    private final String version;

    public ApplicationCommandLocalSendData(long j, long j2, Long l, Long l2, Application application, String str, String str2, String str3, List<ApplicationCommandValue> list, String str4, Long l3) {
        Intrinsics3.checkNotNullParameter(application, "application");
        Intrinsics3.checkNotNullParameter(str2, "applicationCommandName");
        Intrinsics3.checkNotNullParameter(str3, "applicationCommandId");
        Intrinsics3.checkNotNullParameter(list, "applicationCommandsValues");
        this.nonce = j;
        this.channelId = j2;
        this.guildId = l;
        this.commandGuildId = l2;
        this.application = application;
        this.sessionId = str;
        this.applicationCommandName = str2;
        this.applicationCommandId = str3;
        this.applicationCommandsValues = list;
        this.version = str4;
        this.interactionId = l3;
        this.nonceString = String.valueOf(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getNonce() {
        return this.nonce;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Long getInteractionId() {
        return this.interactionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getCommandGuildId() {
        return this.commandGuildId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getApplicationCommandName() {
        return this.applicationCommandName;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getApplicationCommandId() {
        return this.applicationCommandId;
    }

    public final List<ApplicationCommandValue> component9() {
        return this.applicationCommandsValues;
    }

    public final ApplicationCommandLocalSendData copy(long nonce, long channelId, Long guildId, Long commandGuildId, Application application, String sessionId, String applicationCommandName, String applicationCommandId, List<ApplicationCommandValue> applicationCommandsValues, String version, Long interactionId) {
        Intrinsics3.checkNotNullParameter(application, "application");
        Intrinsics3.checkNotNullParameter(applicationCommandName, "applicationCommandName");
        Intrinsics3.checkNotNullParameter(applicationCommandId, "applicationCommandId");
        Intrinsics3.checkNotNullParameter(applicationCommandsValues, "applicationCommandsValues");
        return new ApplicationCommandLocalSendData(nonce, channelId, guildId, commandGuildId, application, sessionId, applicationCommandName, applicationCommandId, applicationCommandsValues, version, interactionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandLocalSendData)) {
            return false;
        }
        ApplicationCommandLocalSendData applicationCommandLocalSendData = (ApplicationCommandLocalSendData) other;
        return this.nonce == applicationCommandLocalSendData.nonce && this.channelId == applicationCommandLocalSendData.channelId && Intrinsics3.areEqual(this.guildId, applicationCommandLocalSendData.guildId) && Intrinsics3.areEqual(this.commandGuildId, applicationCommandLocalSendData.commandGuildId) && Intrinsics3.areEqual(this.application, applicationCommandLocalSendData.application) && Intrinsics3.areEqual(this.sessionId, applicationCommandLocalSendData.sessionId) && Intrinsics3.areEqual(this.applicationCommandName, applicationCommandLocalSendData.applicationCommandName) && Intrinsics3.areEqual(this.applicationCommandId, applicationCommandLocalSendData.applicationCommandId) && Intrinsics3.areEqual(this.applicationCommandsValues, applicationCommandLocalSendData.applicationCommandsValues) && Intrinsics3.areEqual(this.version, applicationCommandLocalSendData.version) && Intrinsics3.areEqual(this.interactionId, applicationCommandLocalSendData.interactionId);
    }

    public final Application getApplication() {
        return this.application;
    }

    public final String getApplicationCommandId() {
        return this.applicationCommandId;
    }

    public final String getApplicationCommandName() {
        return this.applicationCommandName;
    }

    public final List<ApplicationCommandValue> getApplicationCommandsValues() {
        return this.applicationCommandsValues;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Long getCommandGuildId() {
        return this.commandGuildId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final Long getInteractionId() {
        return this.interactionId;
    }

    public final long getNonce() {
        return this.nonce;
    }

    public final String getNonceString() {
        return this.nonceString;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iA = (b.a(this.channelId) + (b.a(this.nonce) * 31)) * 31;
        Long l = this.guildId;
        int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.commandGuildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Application application = this.application;
        int iHashCode3 = (iHashCode2 + (application != null ? application.hashCode() : 0)) * 31;
        String str = this.sessionId;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.applicationCommandName;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.applicationCommandId;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<ApplicationCommandValue> list = this.applicationCommandsValues;
        int iHashCode7 = (iHashCode6 + (list != null ? list.hashCode() : 0)) * 31;
        String str4 = this.version;
        int iHashCode8 = (iHashCode7 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Long l3 = this.interactionId;
        return iHashCode8 + (l3 != null ? l3.hashCode() : 0);
    }

    public final ApplicationCommandData toRestApiApplicationCommandDataParam() {
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        int i = 0;
        ref$IntRef.element = 0;
        List<ApplicationCommandData3> restParams = ApplicationCommandLocalSendData3.toRestParams(this.applicationCommandsValues, new ApplicationCommandLocalSendData2(ref$IntRef));
        String str = this.version;
        String str2 = this.applicationCommandId;
        Long l = this.commandGuildId;
        String strValueOf = l != null ? String.valueOf(l.longValue()) : null;
        String str3 = this.applicationCommandName;
        List<ApplicationCommandValue> listFlatten = StoreApplicationCommandsKt.flatten(this.applicationCommandsValues);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listFlatten) {
            if (((ApplicationCommandValue) obj).getType() == 11) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        for (Object obj2 : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            arrayList2.add(new ApplicationCommandData2(String.valueOf(((ApplicationCommandValue) obj2).getValue()), String.valueOf(i)));
            i = i2;
        }
        return new ApplicationCommandData(str, strValueOf, str2, str3, restParams, arrayList2);
    }

    public final RestAPIParams.ApplicationCommand toRestApiParam() {
        String strValueOf = String.valueOf(this.channelId);
        String strValueOf2 = String.valueOf(this.application.getId());
        Long l = this.guildId;
        String strValueOf3 = l != null ? String.valueOf(l.longValue()) : null;
        ApplicationCommandData restApiApplicationCommandDataParam = toRestApiApplicationCommandDataParam();
        String str = this.sessionId;
        return new RestAPIParams.ApplicationCommand(2L, strValueOf, strValueOf2, strValueOf3, restApiApplicationCommandDataParam, str != null ? str : null, this.nonceString);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandLocalSendData(nonce=");
        sbU.append(this.nonce);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", commandGuildId=");
        sbU.append(this.commandGuildId);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", applicationCommandName=");
        sbU.append(this.applicationCommandName);
        sbU.append(", applicationCommandId=");
        sbU.append(this.applicationCommandId);
        sbU.append(", applicationCommandsValues=");
        sbU.append(this.applicationCommandsValues);
        sbU.append(", version=");
        sbU.append(this.version);
        sbU.append(", interactionId=");
        return outline.G(sbU, this.interactionId, ")");
    }

    public /* synthetic */ ApplicationCommandLocalSendData(long j, long j2, Long l, Long l2, Application application, String str, String str2, String str3, List list, String str4, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, l, l2, application, str, str2, str3, list, str4, (i & 1024) != 0 ? null : l3);
    }
}
