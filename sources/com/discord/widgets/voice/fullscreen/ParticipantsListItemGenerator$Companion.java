package com.discord.widgets.voice.fullscreen;

import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.EmbeddedActivityUtilsKt;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventsComparator;
import com.discord.utilities.streams.StreamContext;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter$ListItem;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter$ListItem$EmbeddedActivityItem;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter$ListItem$Event;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter$ListItem$Invite;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter$ListItem$VoiceUser;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ParticipantsListItemGenerator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ParticipantsListItemGenerator$Companion {
    private ParticipantsListItemGenerator$Companion() {
    }

    private final void addEmbeddedActivitiesToListItems(ArrayList<CallParticipantsAdapter$ListItem> listItems, List<EmbeddedActivity> embeddedActivities, Map<Long, StoreVoiceParticipants$VoiceUser> voiceParticipants, Map<Long, Application> applications) {
        for (EmbeddedActivity embeddedActivity : embeddedActivities) {
            List<UserGuildMember> activityParticipants = EmbeddedActivityUtilsKt.getActivityParticipants(embeddedActivity, voiceParticipants);
            Application application = applications.get(Long.valueOf(embeddedActivity.getApplicationId()));
            if (application != null) {
                listItems.add(new CallParticipantsAdapter$ListItem$EmbeddedActivityItem(embeddedActivity, activityParticipants, com.discord.models.commands.Application.Companion.fromApiApplication(application)));
            }
        }
    }

    private final Comparator<StoreVoiceParticipants$VoiceUser> createUserItemsComparator(String mySpectatingStreamKey) {
        return new ParticipantsListItemGenerator$Companion$createUserItemsComparator$1(mySpectatingStreamKey);
    }

    public static /* synthetic */ Comparator createUserItemsComparator$default(ParticipantsListItemGenerator$Companion participantsListItemGenerator$Companion, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return participantsListItemGenerator$Companion.createUserItemsComparator(str);
    }

    public final List<CallParticipantsAdapter$ListItem> createConnectedListItems(Map<Long, StoreVoiceParticipants$VoiceUser> voiceParticipants, String mySpectatingStreamKey, Channel channel, CallModel callModel, List<EmbeddedActivity> embeddedActivities, Map<Long, Application> applications) {
        m.checkNotNullParameter(voiceParticipants, "voiceParticipants");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(callModel, "callModel");
        m.checkNotNullParameter(embeddedActivities, "embeddedActivities");
        m.checkNotNullParameter(applications, "applications");
        ArrayList<CallParticipantsAdapter$ListItem> arrayList = new ArrayList<>();
        List<GuildScheduledEvent> guildScheduledEvents = callModel.getGuildScheduledEvents();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = guildScheduledEvents.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            GuildScheduledEventTiming eventTiming = GuildScheduledEventUtilitiesKt.getEventTiming((GuildScheduledEvent) next);
            if (eventTiming.isStartable() || eventTiming == GuildScheduledEventTiming.LIVE) {
                arrayList2.add(next);
            }
        }
        GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) u.minWithOrNull(arrayList2, GuildScheduledEventsComparator.INSTANCE);
        if (guildScheduledEvent != null) {
            arrayList.add(new CallParticipantsAdapter$ListItem$Event(guildScheduledEvent, callModel.canManageEvent(), callModel.isConnected()));
        }
        addEmbeddedActivitiesToListItems(arrayList, embeddedActivities, voiceParticipants, applications);
        ArrayList arrayList3 = new ArrayList();
        for (StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser : voiceParticipants.values()) {
            if (storeVoiceParticipants$VoiceUser.isConnected() || ChannelUtils.B(channel)) {
                arrayList3.add(storeVoiceParticipants$VoiceUser);
            }
        }
        boolean z2 = !arrayList3.isEmpty();
        boolean z3 = mySpectatingStreamKey != null;
        if (z2) {
            List<StoreVoiceParticipants$VoiceUser> listSortedWith = u.sortedWith(arrayList3, createUserItemsComparator(mySpectatingStreamKey));
            ArrayList arrayList4 = new ArrayList(o.collectionSizeOrDefault(listSortedWith, 10));
            for (StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser2 : listSortedWith) {
                arrayList4.add(new CallParticipantsAdapter$ListItem$VoiceUser(storeVoiceParticipants$VoiceUser2, ChannelUtils.B(channel) && !storeVoiceParticipants$VoiceUser2.isConnected(), z3 && m.areEqual(mySpectatingStreamKey, storeVoiceParticipants$VoiceUser2.getWatchingStream())));
            }
            arrayList.addAll(arrayList4);
        }
        if ((!arrayList3.isEmpty()) && callModel.canInvite()) {
            arrayList.add(CallParticipantsAdapter$ListItem$Invite.INSTANCE);
        }
        return arrayList;
    }

    public final boolean refreshStreams(List<? extends CallParticipantsAdapter$ListItem> listItems, Set<String> fetchedPreviews, StoreApplicationStreamPreviews storeApplicationStreamPreviews) {
        ModelApplicationStream stream;
        m.checkNotNullParameter(listItems, "listItems");
        m.checkNotNullParameter(fetchedPreviews, "fetchedPreviews");
        m.checkNotNullParameter(storeApplicationStreamPreviews, "storeApplicationStreamPreviews");
        boolean z2 = false;
        for (CallParticipantsAdapter$ListItem callParticipantsAdapter$ListItem : listItems) {
            if (callParticipantsAdapter$ListItem instanceof CallParticipantsAdapter$ListItem$VoiceUser) {
                z2 = true;
                StreamContext streamContext = ((CallParticipantsAdapter$ListItem$VoiceUser) callParticipantsAdapter$ListItem).getParticipant().getStreamContext();
                String encodedStreamKey = (streamContext == null || (stream = streamContext.getStream()) == null) ? null : stream.getEncodedStreamKey();
                if (encodedStreamKey != null && !fetchedPreviews.contains(encodedStreamKey)) {
                    storeApplicationStreamPreviews.fetchStreamPreviewIfNotFetching(streamContext);
                    fetchedPreviews.add(encodedStreamKey);
                }
            }
        }
        return z2;
    }

    public /* synthetic */ ParticipantsListItemGenerator$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
