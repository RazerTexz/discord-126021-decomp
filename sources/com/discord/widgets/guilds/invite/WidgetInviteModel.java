package com.discord.widgets.guilds.invite;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetInviteModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetInviteModel {
    public static final WidgetInviteModel$Companion Companion = new WidgetInviteModel$Companion(null);
    private final List<Channel> dms;
    private final List<Channel> invitableChannels;
    private final ModelInvite invite;
    private final boolean isGeneratingInvite;
    private final boolean isInviteFromStore;
    private final boolean isValidInvite;
    private final MeUser me;
    private final ModelInvite$Settings settings;
    private final Channel targetChannel;

    public WidgetInviteModel(Channel channel, ModelInvite$Settings modelInvite$Settings, ModelInvite modelInvite, boolean z2, boolean z3, List<Channel> list, MeUser meUser, List<Channel> list2, boolean z4) {
        m.checkNotNullParameter(list, "invitableChannels");
        m.checkNotNullParameter(meUser, "me");
        m.checkNotNullParameter(list2, "dms");
        this.targetChannel = channel;
        this.settings = modelInvite$Settings;
        this.invite = modelInvite;
        this.isGeneratingInvite = z2;
        this.isValidInvite = z3;
        this.invitableChannels = list;
        this.me = meUser;
        this.dms = list2;
        this.isInviteFromStore = z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetInviteModel copy$default(WidgetInviteModel widgetInviteModel, Channel channel, ModelInvite$Settings modelInvite$Settings, ModelInvite modelInvite, boolean z2, boolean z3, List list, MeUser meUser, List list2, boolean z4, int i, Object obj) {
        return widgetInviteModel.copy((i & 1) != 0 ? widgetInviteModel.targetChannel : channel, (i & 2) != 0 ? widgetInviteModel.settings : modelInvite$Settings, (i & 4) != 0 ? widgetInviteModel.invite : modelInvite, (i & 8) != 0 ? widgetInviteModel.isGeneratingInvite : z2, (i & 16) != 0 ? widgetInviteModel.isValidInvite : z3, (i & 32) != 0 ? widgetInviteModel.invitableChannels : list, (i & 64) != 0 ? widgetInviteModel.me : meUser, (i & 128) != 0 ? widgetInviteModel.dms : list2, (i & 256) != 0 ? widgetInviteModel.isInviteFromStore : z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getTargetChannel() {
        return this.targetChannel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ModelInvite$Settings getSettings() {
        return this.settings;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsGeneratingInvite() {
        return this.isGeneratingInvite;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsValidInvite() {
        return this.isValidInvite;
    }

    public final List<Channel> component6() {
        return this.invitableChannels;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    public final List<Channel> component8() {
        return this.dms;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsInviteFromStore() {
        return this.isInviteFromStore;
    }

    public final WidgetInviteModel copy(Channel targetChannel, ModelInvite$Settings settings, ModelInvite invite, boolean isGeneratingInvite, boolean isValidInvite, List<Channel> invitableChannels, MeUser me2, List<Channel> dms, boolean isInviteFromStore) {
        m.checkNotNullParameter(invitableChannels, "invitableChannels");
        m.checkNotNullParameter(me2, "me");
        m.checkNotNullParameter(dms, "dms");
        return new WidgetInviteModel(targetChannel, settings, invite, isGeneratingInvite, isValidInvite, invitableChannels, me2, dms, isInviteFromStore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetInviteModel)) {
            return false;
        }
        WidgetInviteModel widgetInviteModel = (WidgetInviteModel) other;
        return m.areEqual(this.targetChannel, widgetInviteModel.targetChannel) && m.areEqual(this.settings, widgetInviteModel.settings) && m.areEqual(this.invite, widgetInviteModel.invite) && this.isGeneratingInvite == widgetInviteModel.isGeneratingInvite && this.isValidInvite == widgetInviteModel.isValidInvite && m.areEqual(this.invitableChannels, widgetInviteModel.invitableChannels) && m.areEqual(this.me, widgetInviteModel.me) && m.areEqual(this.dms, widgetInviteModel.dms) && this.isInviteFromStore == widgetInviteModel.isInviteFromStore;
    }

    public final List<Channel> getDms() {
        return this.dms;
    }

    public final List<Channel> getInvitableChannels() {
        return this.invitableChannels;
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final ModelInvite$Settings getSettings() {
        return this.settings;
    }

    public final Channel getTargetChannel() {
        return this.targetChannel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Channel channel = this.targetChannel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        ModelInvite$Settings modelInvite$Settings = this.settings;
        int iHashCode2 = (iHashCode + (modelInvite$Settings != null ? modelInvite$Settings.hashCode() : 0)) * 31;
        ModelInvite modelInvite = this.invite;
        int iHashCode3 = (iHashCode2 + (modelInvite != null ? modelInvite.hashCode() : 0)) * 31;
        boolean z2 = this.isGeneratingInvite;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode3 + r2) * 31;
        boolean z3 = this.isValidInvite;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        List<Channel> list = this.invitableChannels;
        int iHashCode4 = (i2 + (list != null ? list.hashCode() : 0)) * 31;
        MeUser meUser = this.me;
        int iHashCode5 = (iHashCode4 + (meUser != null ? meUser.hashCode() : 0)) * 31;
        List<Channel> list2 = this.dms;
        int iHashCode6 = (iHashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z4 = this.isInviteFromStore;
        return iHashCode6 + (z4 ? 1 : z4);
    }

    public final boolean isGeneratingInvite() {
        return this.isGeneratingInvite;
    }

    public final boolean isInviteFromStore() {
        return this.isInviteFromStore;
    }

    public final boolean isValidInvite() {
        return this.isValidInvite;
    }

    public String toString() {
        StringBuilder sbU = a.U("WidgetInviteModel(targetChannel=");
        sbU.append(this.targetChannel);
        sbU.append(", settings=");
        sbU.append(this.settings);
        sbU.append(", invite=");
        sbU.append(this.invite);
        sbU.append(", isGeneratingInvite=");
        sbU.append(this.isGeneratingInvite);
        sbU.append(", isValidInvite=");
        sbU.append(this.isValidInvite);
        sbU.append(", invitableChannels=");
        sbU.append(this.invitableChannels);
        sbU.append(", me=");
        sbU.append(this.me);
        sbU.append(", dms=");
        sbU.append(this.dms);
        sbU.append(", isInviteFromStore=");
        return a.O(sbU, this.isInviteFromStore, ")");
    }

    public /* synthetic */ WidgetInviteModel(Channel channel, ModelInvite$Settings modelInvite$Settings, ModelInvite modelInvite, boolean z2, boolean z3, List list, MeUser meUser, List list2, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, modelInvite$Settings, modelInvite, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, list, meUser, list2, (i & 256) != 0 ? false : z4);
    }
}
