package com.discord.widgets.chat.list;

import a0.a.a.b;
import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.a;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.api.application.Application;
import com.discord.api.message.activity.MessageActivity;
import com.discord.models.user.MeUser;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.widgets.channels.list.items.CollapsedUser;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ViewEmbedGameInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ViewEmbedGameInvite$Model {
    public static final ViewEmbedGameInvite$Model$Companion Companion = new ViewEmbedGameInvite$Model$Companion(null);
    private final Activity activity;
    private final Application application;
    private final boolean canJoin;
    private final long creationTime;
    private final long creatorId;
    private final List<String> gPlayPackageNames;
    private final boolean isInParty;
    private final boolean isPartyMatch;
    private final MeUser meUser;
    private final MessageActivity messageActivity;
    private final List<CollapsedUser> users;

    public ViewEmbedGameInvite$Model(MeUser meUser, long j, long j2, Application application, MessageActivity messageActivity, Activity activity, List<CollapsedUser> list) {
        boolean z2;
        ActivityParty party;
        String id2;
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(application, "application");
        m.checkNotNullParameter(messageActivity, "messageActivity");
        m.checkNotNullParameter(list, "users");
        this.meUser = meUser;
        this.creatorId = j;
        this.creationTime = j2;
        this.application = application;
        this.messageActivity = messageActivity;
        this.activity = activity;
        this.users = list;
        boolean zEquals = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                } else {
                    if (((CollapsedUser) it.next()).getUser().getId() == this.meUser.getId()) {
                        z2 = true;
                        break;
                    }
                }
            }
        } else {
            z2 = false;
            break;
        }
        this.isInParty = z2;
        Activity activity2 = this.activity;
        this.canJoin = activity2 != null && ActivityUtilsKt.hasFlag(activity2, 2) && ActivityUtilsKt.isCurrentPlatform(this.activity);
        this.gPlayPackageNames = this.application.d();
        Activity activity3 = this.activity;
        if (activity3 != null && (party = activity3.getParty()) != null && (id2 = party.getId()) != null) {
            zEquals = id2.equals(getPartyId());
        }
        this.isPartyMatch = zEquals;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewEmbedGameInvite$Model copy$default(ViewEmbedGameInvite$Model viewEmbedGameInvite$Model, MeUser meUser, long j, long j2, Application application, MessageActivity messageActivity, Activity activity, List list, int i, Object obj) {
        return viewEmbedGameInvite$Model.copy((i & 1) != 0 ? viewEmbedGameInvite$Model.meUser : meUser, (i & 2) != 0 ? viewEmbedGameInvite$Model.creatorId : j, (i & 4) != 0 ? viewEmbedGameInvite$Model.creationTime : j2, (i & 8) != 0 ? viewEmbedGameInvite$Model.application : application, (i & 16) != 0 ? viewEmbedGameInvite$Model.messageActivity : messageActivity, (i & 32) != 0 ? viewEmbedGameInvite$Model.activity : activity, (i & 64) != 0 ? viewEmbedGameInvite$Model.users : list);
    }

    private final String getPartyId() {
        return this.messageActivity.getPartyId();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getCreatorId() {
        return this.creatorId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getCreationTime() {
        return this.creationTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MessageActivity getMessageActivity() {
        return this.messageActivity;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    public final List<CollapsedUser> component7() {
        return this.users;
    }

    public final ViewEmbedGameInvite$Model copy(MeUser meUser, long creatorId, long creationTime, Application application, MessageActivity messageActivity, Activity activity, List<CollapsedUser> users) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(application, "application");
        m.checkNotNullParameter(messageActivity, "messageActivity");
        m.checkNotNullParameter(users, "users");
        return new ViewEmbedGameInvite$Model(meUser, creatorId, creationTime, application, messageActivity, activity, users);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewEmbedGameInvite$Model)) {
            return false;
        }
        ViewEmbedGameInvite$Model viewEmbedGameInvite$Model = (ViewEmbedGameInvite$Model) other;
        return m.areEqual(this.meUser, viewEmbedGameInvite$Model.meUser) && this.creatorId == viewEmbedGameInvite$Model.creatorId && this.creationTime == viewEmbedGameInvite$Model.creationTime && m.areEqual(this.application, viewEmbedGameInvite$Model.application) && m.areEqual(this.messageActivity, viewEmbedGameInvite$Model.messageActivity) && m.areEqual(this.activity, viewEmbedGameInvite$Model.activity) && m.areEqual(this.users, viewEmbedGameInvite$Model.users);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final boolean getCanJoin() {
        return this.canJoin;
    }

    public final long getCreationTime() {
        return this.creationTime;
    }

    public final long getCreatorId() {
        return this.creatorId;
    }

    public final List<String> getGPlayPackageNames() {
        return this.gPlayPackageNames;
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final MessageActivity getMessageActivity() {
        return this.messageActivity;
    }

    public final List<CollapsedUser> getUsers() {
        return this.users;
    }

    public int hashCode() {
        MeUser meUser = this.meUser;
        int iA = (b.a(this.creationTime) + ((b.a(this.creatorId) + ((meUser != null ? meUser.hashCode() : 0) * 31)) * 31)) * 31;
        Application application = this.application;
        int iHashCode = (iA + (application != null ? application.hashCode() : 0)) * 31;
        MessageActivity messageActivity = this.messageActivity;
        int iHashCode2 = (iHashCode + (messageActivity != null ? messageActivity.hashCode() : 0)) * 31;
        Activity activity = this.activity;
        int iHashCode3 = (iHashCode2 + (activity != null ? activity.hashCode() : 0)) * 31;
        List<CollapsedUser> list = this.users;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public final boolean isDeadInvite(long now) {
        return !this.isPartyMatch || isExpiredInvite(now);
    }

    public final boolean isExpiredInvite(long now) {
        return now > this.creationTime + 7200000;
    }

    /* JADX INFO: renamed from: isInParty, reason: from getter */
    public final boolean getIsInParty() {
        return this.isInParty;
    }

    /* JADX INFO: renamed from: isPartyMatch, reason: from getter */
    public final boolean getIsPartyMatch() {
        return this.isPartyMatch;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(meUser=");
        sbU.append(this.meUser);
        sbU.append(", creatorId=");
        sbU.append(this.creatorId);
        sbU.append(", creationTime=");
        sbU.append(this.creationTime);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(", messageActivity=");
        sbU.append(this.messageActivity);
        sbU.append(", activity=");
        sbU.append(this.activity);
        sbU.append(", users=");
        return a.L(sbU, this.users, ")");
    }
}
