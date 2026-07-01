package com.discord.utilities.presence;

import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.outline;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivityEmoji;
import com.discord.api.activity.ActivityParty;
import com.discord.api.activity.ActivityPlatform;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.api.activity.ActivityType;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.stores.Store3;
import com.discord.stores.StoreStream;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.stage.StageRoles;
import d0.Tuples;
import d0.d0._Ranges;
import d0.g0.CharJVM;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;

/* JADX INFO: renamed from: com.discord.utilities.presence.ActivityUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: ActivityUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ActivityUtils {
    private static final long STAGE_PRESENCE_APPLICATION_ID = 834488117758001152L;
    private static final long STAGE_PRESENCE_FLAG_GUILD_IS_PARTNERED = 2;
    private static final long STAGE_PRESENCE_FLAG_GUILD_IS_VERIFIED = 4;
    private static final long STAGE_PRESENCE_FLAG_USER_IS_SPEAKER = 1;
    private static final String STAGE_PRESENCE_PARTY_PREFIX = "stage:";
    private static final long XBOX_APPLICATION_ID = 438122941302046720L;

    public static final Activity createCustomStatusActivity(String str, ActivityEmoji activityEmoji, long j) {
        return new Activity("Custom Status", ActivityType.CUSTOM_STATUS, null, j, null, null, null, str, activityEmoji, null, null, null, null, null, null, null, null, null);
    }

    public static final Activity createPlayingActivity(String str, long j) {
        if (str == null) {
            return null;
        }
        return new Activity(str, ActivityType.PLAYING, null, j, null, null, null, null, null, null, null, null, null, null, null, ActivityPlatform.ANDROID, null, null);
    }

    public static final Activity createSpotifyListeningActivity(long j, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3, String str7) {
        if (str == null) {
            return null;
        }
        ActivityType activityType = ActivityType.LISTENING;
        ActivityAssets activityAssets = new ActivityAssets(str5, str4, null, null);
        return new Activity(str, activityType, null, j, new ActivityTimestamps(String.valueOf(j2), String.valueOf(j3)), null, str2, str6, null, new ActivityParty(str7, null), activityAssets, 48, str3, null, null, null, null, null);
    }

    @Store3
    public static final Activity createStageChannelListeningActivity() {
        Guild guild;
        int size;
        String strValueOf;
        ActivityTimestamps timestamps;
        Collection<StageRoles> collectionValues;
        StoreStream.Companion companion = StoreStream.INSTANCE;
        long selectedVoiceChannelId = companion.getVoiceChannelSelected().getSelectedVoiceChannelId();
        Channel channel = companion.getChannels().getChannel(selectedVoiceChannelId);
        if (channel == null || !ChannelUtils.D(channel)) {
            return null;
        }
        Map<Long, StageRoles> channelRolesInternal = companion.getStageChannels().getChannelRolesInternal(selectedVoiceChannelId);
        StageRoles stageRolesM16getMyRolesInternalvisDeB4 = companion.getStageChannels().m16getMyRolesInternalvisDeB4(selectedVoiceChannelId);
        StageInstance stageInstanceForChannelInternal = companion.getStageInstances().getStageInstanceForChannelInternal(channel.getId());
        if (stageInstanceForChannelInternal != null && (guild = companion.getGuilds().getGuild(channel.getGuildId())) != null) {
            String strM21packStageChannelPartyIdhLOU_GE = m21packStageChannelPartyIdhLOU_GE(channel, guild, stageRolesM16getMyRolesInternalvisDeB4, stageInstanceForChannelInternal);
            if (channelRolesInternal == null || (collectionValues = channelRolesInternal.values()) == null) {
                size = 0;
            } else {
                ArrayList arrayList = new ArrayList();
                for (Object obj : collectionValues) {
                    if (StageRoles.m33isSpeakerimpl(((StageRoles) obj).m35unboximpl())) {
                        arrayList.add(obj);
                    }
                }
                size = arrayList.size();
            }
            int size2 = channelRolesInternal != null ? channelRolesInternal.size() : 0;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            Activity applicationActivity = companion2.getPresences().getApplicationActivity(companion2.getUsers().getMeSnapshot().getId(), STAGE_PRESENCE_APPLICATION_ID);
            ActivityUtils2 activityUtils2UnpackStageChannelParty = unpackStageChannelParty(applicationActivity);
            if (!(activityUtils2UnpackStageChannelParty != null && activityUtils2UnpackStageChannelParty.getGuildId() == guild.getId() && activityUtils2UnpackStageChannelParty.getChannelId() == channel.getId())) {
                applicationActivity = null;
            }
            if (applicationActivity == null || (timestamps = applicationActivity.getTimestamps()) == null || (strValueOf = String.valueOf(timestamps.c())) == null) {
                strValueOf = String.valueOf(ClockFactory.get().currentTimeMillis());
            }
            if (stageInstanceForChannelInternal.getPrivacyLevel() != StageInstancePrivacyLevel.PUBLIC) {
                return null;
            }
            return new Activity(stageInstanceForChannelInternal.getTopic(), ActivityType.LISTENING, null, ClockFactory.get().currentTimeMillis(), new ActivityTimestamps(strValueOf, null), Long.valueOf(STAGE_PRESENCE_APPLICATION_ID), null, null, null, new ActivityParty(strM21packStageChannelPartyIdhLOU_GE, Collections2.listOf((Object[]) new Long[]{Long.valueOf(size), Long.valueOf(size2)})), new ActivityAssets(null, null, guild.getIcon(), guild.getName()), null, null, null, null, null, null, null);
        }
        return null;
    }

    public static final ActivityPlatform getGamePlatform(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, "$this$gamePlatform");
        if (!isGameActivity(activity)) {
            return null;
        }
        if (isXboxActivity(activity)) {
            return ActivityPlatform.XBOX;
        }
        ActivityPlatform platform = activity.getPlatform();
        return platform != null ? platform : ActivityPlatform.DESKTOP;
    }

    public static final ActivityUtils2 getStageChannelRichPresencePartyData(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, "$this$stageChannelRichPresencePartyData");
        return unpackStageChannelParty(activity);
    }

    private static /* synthetic */ void getXBOX_APPLICATION_ID$annotations() {
    }

    public static final boolean hasFlag(Activity activity, int i) {
        Intrinsics3.checkNotNullParameter(activity, "$this$hasFlag");
        Integer flags = activity.getFlags();
        return ((flags != null ? flags.intValue() : 0) & i) == i;
    }

    public static final boolean isCurrentPlatform(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, "$this$isCurrentPlatform");
        ActivityPlatform platform = activity.getPlatform();
        ActivityPlatform activityPlatform = ActivityPlatform.ANDROID;
        if (platform == activityPlatform) {
            return true;
        }
        List<ActivityPlatform> listM = activity.m();
        return listM != null && listM.contains(activityPlatform);
    }

    public static final boolean isCustomStatus(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, "$this$isCustomStatus");
        return activity.getType() == ActivityType.CUSTOM_STATUS;
    }

    public static final boolean isGameActivity(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, "$this$isGameActivity");
        return activity.getType() == ActivityType.PLAYING;
    }

    public static final boolean isGamePlatform(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, "$this$isGamePlatform");
        return isXboxActivity(activity) || activity.getPlatform() == ActivityPlatform.SAMSUNG || activity.getPlatform() == ActivityPlatform.PS4 || activity.getPlatform() == ActivityPlatform.PS5;
    }

    public static final boolean isRichPresence(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, "$this$isRichPresence");
        if (!isCustomStatus(activity)) {
            if (activity.getAssets() != null || activity.getParty() != null) {
                return true;
            }
            String state = activity.getState();
            if (!(state == null || state.length() == 0)) {
                return true;
            }
            String details = activity.getDetails();
            if (!(details == null || details.length() == 0)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isSpotifyActivity(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, "$this$isSpotifyActivity");
        return StringsJVM.equals(activity.getName(), Platform.SPOTIFY.getProperName(), true);
    }

    public static final boolean isStageChannelActivity(Activity activity) {
        Long applicationId;
        Intrinsics3.checkNotNullParameter(activity, "$this$isStageChannelActivity");
        return activity.getType() == ActivityType.LISTENING && (applicationId = activity.getApplicationId()) != null && applicationId.longValue() == STAGE_PRESENCE_APPLICATION_ID;
    }

    public static final boolean isStreaming(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, "$this$isStreaming");
        return activity.getType() == ActivityType.STREAMING;
    }

    public static final boolean isXboxActivity(Activity activity) {
        Long applicationId;
        Intrinsics3.checkNotNullParameter(activity, "$this$isXboxActivity");
        return activity.getPlatform() == ActivityPlatform.XBOX || ((applicationId = activity.getApplicationId()) != null && applicationId.longValue() == XBOX_APPLICATION_ID);
    }

    /* JADX INFO: renamed from: packStageChannelPartyId-hLOU_GE, reason: not valid java name */
    private static final String m21packStageChannelPartyIdhLOU_GE(Channel channel, Guild guild, StageRoles stageRoles, StageInstance stageInstance) {
        long j;
        if (stageRoles != null && StageRoles.m33isSpeakerimpl(stageRoles.m35unboximpl())) {
            j = 1;
        } else if (guild.hasFeature(GuildFeature.PARTNERED)) {
            j = 2;
        } else {
            j = guild.hasFeature(GuildFeature.VERIFIED) ? 4L : 0L;
        }
        String string = Long.toString(j, CharJVM.checkRadix(16));
        Intrinsics3.checkNotNullExpressionValue(string, "java.lang.Long.toString(this, checkRadix(radix))");
        StringBuilder sbU = outline.U(STAGE_PRESENCE_PARTY_PREFIX);
        sbU.append(channel.getGuildId());
        sbU.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        sbU.append(channel.getId());
        sbU.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        sbU.append(string);
        sbU.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        sbU.append(stageInstance.getId());
        return sbU.toString();
    }

    private static final ActivityUtils2 unpackStageChannelParty(Activity activity) {
        ActivityParty party;
        String id2;
        if (activity == null || (party = activity.getParty()) == null || (id2 = party.getId()) == null || !StringsJVM.startsWith$default(id2, STAGE_PRESENCE_PARTY_PREFIX, false, 2, null)) {
            return null;
        }
        try {
            ActivityParty party2 = activity.getParty();
            List<Long> listB = party2 != null ? party2.b() : null;
            Tuples2 tuples2 = (!(listB == null || listB.isEmpty()) && listB.size() == 2) ? Tuples.to(listB.get(0), listB.get(1)) : Tuples.to(0L, 0L);
            long jLongValue = ((Number) tuples2.component1()).longValue();
            long jCoerceAtLeast = _Ranges.coerceAtLeast(0L, ((Number) tuples2.component2()).longValue() - jLongValue);
            List listSplit$default = Strings4.split$default((CharSequence) id2, new char[]{MentionUtils.EMOJIS_AND_STICKERS_CHAR}, false, 0, 6, (Object) null);
            String str = (String) listSplit$default.get(1);
            String str2 = (String) listSplit$default.get(2);
            String str3 = (String) listSplit$default.get(3);
            String str4 = (String) listSplit$default.get(4);
            long j = Long.parseLong(str3, CharJVM.checkRadix(16));
            return new ActivityUtils2(Long.parseLong(str4), Long.parseLong(str2), (1 & j) != 0, Long.parseLong(str), (2 & j) != 0, (4 & j) != 0, jLongValue, jCoerceAtLeast);
        } catch (Exception unused) {
            return null;
        }
    }
}
