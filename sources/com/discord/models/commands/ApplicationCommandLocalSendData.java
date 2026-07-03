package com.discord.models.commands;

import com.discord.api.commands.ApplicationCommandAttachment;
import com.discord.api.commands.ApplicationCommandData;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(application, "application");
        C12238m.checkNotNullParameter(str2, "applicationCommandName");
        C12238m.checkNotNullParameter(str3, "applicationCommandId");
        C12238m.checkNotNullParameter(list, "applicationCommandsValues");
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
        C12238m.checkNotNullParameter(application, "application");
        C12238m.checkNotNullParameter(applicationCommandName, "applicationCommandName");
        C12238m.checkNotNullParameter(applicationCommandId, "applicationCommandId");
        C12238m.checkNotNullParameter(applicationCommandsValues, "applicationCommandsValues");
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
        return this.nonce == applicationCommandLocalSendData.nonce && this.channelId == applicationCommandLocalSendData.channelId && C12238m.areEqual(this.guildId, applicationCommandLocalSendData.guildId) && C12238m.areEqual(this.commandGuildId, applicationCommandLocalSendData.commandGuildId) && C12238m.areEqual(this.application, applicationCommandLocalSendData.application) && C12238m.areEqual(this.sessionId, applicationCommandLocalSendData.sessionId) && C12238m.areEqual(this.applicationCommandName, applicationCommandLocalSendData.applicationCommandName) && C12238m.areEqual(this.applicationCommandId, applicationCommandLocalSendData.applicationCommandId) && C12238m.areEqual(this.applicationCommandsValues, applicationCommandLocalSendData.applicationCommandsValues) && C12238m.areEqual(this.version, applicationCommandLocalSendData.version) && C12238m.areEqual(this.interactionId, applicationCommandLocalSendData.interactionId);
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
        int iM3a = (C0002b.m3a(this.channelId) + (C0002b.m3a(this.nonce) * 31)) * 31;
        Long l = this.guildId;
        int iHashCode = (iM3a + (l != null ? l.hashCode() : 0)) * 31;
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
        List<com.discord.api.commands.ApplicationCommandValue> restParams = ApplicationCommandLocalSendDataKt.toRestParams(this.applicationCommandsValues, new C5530xb14bfc1(ref$IntRef));
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
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        for (Object obj2 : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            arrayList2.add(new ApplicationCommandAttachment(String.valueOf(((ApplicationCommandValue) obj2).getValue()), String.valueOf(i)));
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
        StringBuilder sbM833U = C1643a.m833U("ApplicationCommandLocalSendData(nonce=");
        sbM833U.append(this.nonce);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", commandGuildId=");
        sbM833U.append(this.commandGuildId);
        sbM833U.append(", application=");
        sbM833U.append(this.application);
        sbM833U.append(", sessionId=");
        sbM833U.append(this.sessionId);
        sbM833U.append(", applicationCommandName=");
        sbM833U.append(this.applicationCommandName);
        sbM833U.append(", applicationCommandId=");
        sbM833U.append(this.applicationCommandId);
        sbM833U.append(", applicationCommandsValues=");
        sbM833U.append(this.applicationCommandsValues);
        sbM833U.append(", version=");
        sbM833U.append(this.version);
        sbM833U.append(", interactionId=");
        return C1643a.m819G(sbM833U, this.interactionId, ")");
    }

    public /* synthetic */ ApplicationCommandLocalSendData(long j, long j2, Long l, Long l2, Application application, String str, String str2, String str3, List list, String str4, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, l, l2, application, str, str2, str3, list, str4, (i & 1024) != 0 ? null : l3);
    }
}
