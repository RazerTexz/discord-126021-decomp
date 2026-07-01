package com.discord.utilities.presence;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.ActivityChooserModel;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityEmoji;
import com.discord.api.activity.ActivityParty;
import com.discord.api.activity.ActivityPlatform;
import com.discord.api.activity.ActivityType;
import com.discord.api.presence.ClientStatus;
import com.discord.api.presence.ClientStatuses;
import com.discord.models.presence.Presence;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.t._Collections;
import d0.u.a;
import d0.z.d.Intrinsics3;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PresenceUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PresenceUtils {
    public static final PresenceUtils INSTANCE = new PresenceUtils();
    private static final Comparator<Activity> ACTIVITY_COMPARATOR = a.compareBy(PresenceUtils2.INSTANCE, PresenceUtils3.INSTANCE, PresenceUtils4.INSTANCE);

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            ActivityType.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            ActivityType activityType = ActivityType.STREAMING;
            iArr[activityType.ordinal()] = 1;
            ActivityType activityType2 = ActivityType.LISTENING;
            iArr[activityType2.ordinal()] = 2;
            ActivityType activityType3 = ActivityType.WATCHING;
            iArr[activityType3.ordinal()] = 3;
            ActivityType activityType4 = ActivityType.PLAYING;
            iArr[activityType4.ordinal()] = 4;
            ActivityType activityType5 = ActivityType.COMPETING;
            iArr[activityType5.ordinal()] = 5;
            ActivityType.values();
            int[] iArr2 = new int[7];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[activityType4.ordinal()] = 1;
            iArr2[activityType2.ordinal()] = 2;
            iArr2[activityType.ordinal()] = 3;
            iArr2[activityType3.ordinal()] = 4;
            iArr2[activityType5.ordinal()] = 5;
            ClientStatus.values();
            int[] iArr3 = new int[5];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[ClientStatus.ONLINE.ordinal()] = 1;
            iArr3[ClientStatus.IDLE.ordinal()] = 2;
            iArr3[ClientStatus.DND.ordinal()] = 3;
        }
    }

    private PresenceUtils() {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final CharSequence getActivityHeader(Context context, Activity activity) {
        String str;
        Object properName;
        String str2;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        int iOrdinal = activity.getType().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return FormatUtils.b(context, R.string.user_activity_header_live_on_platform, new Object[]{activity.getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            if (iOrdinal == 2) {
                return FormatUtils.b(context, R.string.user_activity_header_listening, new Object[]{activity.getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            if (iOrdinal != 3) {
                return iOrdinal != 5 ? FormatUtils.b(context, R.string.user_activity_header_playing, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null) : FormatUtils.b(context, R.string.user_activity_header_competing, new Object[]{activity.getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            return FormatUtils.b(context, R.string.user_activity_header_watching, new Object[]{activity.getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        ActivityPlatform platform = activity.getPlatform();
        if (platform != null) {
            Platform platformFrom = Platform.INSTANCE.from(platform);
            if (platform == ActivityPlatform.PS4) {
                str2 = "PS4";
            } else if (platform == ActivityPlatform.PS5) {
                str = "PS5";
            } else if (platformFrom != Platform.NONE) {
                properName = platform;
                properName = platformFrom.getProperName();
            }
            if (properName != null) {
                properName = str;
                properName = str2;
                return FormatUtils.b(context, R.string.user_activity_header_playing_on_platform, new Object[]{properName}, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
        }
        properName = str;
        properName = str2;
        return FormatUtils.b(context, R.string.user_activity_header_playing, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
    }

    private final CharSequence getActivityString(Context context, Activity activityModel) {
        ActivityType type = activityModel != null ? activityModel.getType() : null;
        if (type == null) {
            return null;
        }
        int iOrdinal = type.ordinal();
        if (iOrdinal == 0) {
            return FormatUtils.b(context, R.string.playing_game, new Object[]{activityModel.getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (iOrdinal == 1) {
            Object[] objArr = new Object[1];
            String details = activityModel.getDetails();
            if (details == null) {
                details = activityModel.getName();
            }
            objArr[0] = details;
            return FormatUtils.b(context, R.string.streaming, objArr, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (iOrdinal == 2) {
            return FormatUtils.b(context, R.string.listening_to, new Object[]{activityModel.getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (iOrdinal != 3) {
            if (iOrdinal != 5) {
                return null;
            }
            return FormatUtils.b(context, R.string.competing, new Object[]{activityModel.getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        Object[] objArr2 = new Object[1];
        String details2 = activityModel.getDetails();
        if (details2 == null) {
            details2 = activityModel.getName();
        }
        objArr2[0] = details2;
        return FormatUtils.b(context, R.string.watching, objArr2, (4 & 4) != 0 ? FormatUtils.b.j : null);
    }

    private final CharSequence getApplicationStreamingString(Context context, Presence presence) {
        Activity playingActivity;
        return (presence == null || (playingActivity = getPlayingActivity(presence)) == null) ? FormatUtils.b(context, R.string.streaming_a_game, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null) : FormatUtils.b(context, R.string.streaming, new Object[]{playingActivity.getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null);
    }

    private final DraweeSpanStringBuilder getStatusDraweeSpanStringBuilder(Context context, Presence presence, boolean isStreamingApplication, boolean hideEmoji, boolean showFallbackStatusText, boolean animateCustomStatusEmoji) {
        Activity customStatusActivity;
        ActivityEmoji emoji;
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        EmojiNode emojiNodeFrom$default = null;
        if (!hideEmoji && presence != null && (customStatusActivity = getCustomStatusActivity(presence)) != null && (emoji = customStatusActivity.getEmoji()) != null) {
            EmojiNode.Companion companion = EmojiNode.INSTANCE;
            emojiNodeFrom$default = EmojiNode.Companion.from$default(companion, 0, companion.generateEmojiIdAndType(emoji), 1, (Object) null);
        }
        if (emojiNodeFrom$default != null) {
            emojiNodeFrom$default.render((SpannableStringBuilder) draweeSpanStringBuilder, new EmojiNode.RenderContext(context, animateCustomStatusEmoji) { // from class: com.discord.utilities.presence.PresenceUtils.getStatusDraweeSpanStringBuilder.1
                public final /* synthetic */ boolean $animateCustomStatusEmoji;
                public final /* synthetic */ Context $context;
                private final Context context;
                private final boolean isAnimationEnabled;

                {
                    this.$context = context;
                    this.$animateCustomStatusEmoji = animateCustomStatusEmoji;
                    this.context = context;
                    this.isAnimationEnabled = animateCustomStatusEmoji;
                }

                @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
                public Context getContext() {
                    return this.context;
                }

                @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
                /* JADX INFO: renamed from: isAnimationEnabled, reason: from getter */
                public boolean getIsAnimationEnabled() {
                    return this.isAnimationEnabled;
                }

                @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
                public void onEmojiClicked(EmojiNode.EmojiIdAndType emojiIdAndType) {
                    Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
                    EmojiNode.RenderContext.DefaultImpls.onEmojiClicked(this, emojiIdAndType);
                }
            });
        }
        CharSequence statusText = getStatusText(context, presence, isStreamingApplication, showFallbackStatusText);
        if (statusText != null) {
            if (emojiNodeFrom$default != null) {
                draweeSpanStringBuilder.append((char) 8194);
            }
            draweeSpanStringBuilder.append(statusText);
        }
        return draweeSpanStringBuilder;
    }

    public static /* synthetic */ DraweeSpanStringBuilder getStatusDraweeSpanStringBuilder$default(PresenceUtils presenceUtils, Context context, Presence presence, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
        return presenceUtils.getStatusDraweeSpanStringBuilder(context, presence, z2, z3, (i & 16) != 0 ? false : z4, (i & 32) != 0 ? false : z5);
    }

    private final CharSequence getStatusText(Context context, Presence presence, boolean isStreamingApplication, boolean showFallbackStatusText) {
        Activity customStatusActivity;
        String state = (presence == null || (customStatusActivity = getCustomStatusActivity(presence)) == null) ? null : customStatusActivity.getState();
        if (state != null) {
            return state;
        }
        if (isStreamingApplication) {
            return getApplicationStreamingString(context, presence);
        }
        CharSequence activityString = getActivityString(context, presence != null ? getPrimaryActivity(presence) : null);
        if (activityString != null) {
            return activityString;
        }
        if (showFallbackStatusText) {
            return FormatUtils.b(context, getStatusText(presence), new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        return null;
    }

    public static /* synthetic */ CharSequence getStatusText$default(PresenceUtils presenceUtils, Context context, Presence presence, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 8) != 0) {
            z3 = false;
        }
        return presenceUtils.getStatusText(context, presence, z2, z3);
    }

    public static final void setPresenceText(Presence presence, boolean isStreamingApplication, SimpleDraweeSpanTextView textView, boolean showFallbackStatusText, boolean hideEmoji) {
        Intrinsics3.checkNotNullParameter(textView, "textView");
        PresenceUtils presenceUtils = INSTANCE;
        Context context = textView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "textView.context");
        DraweeSpanStringBuilder statusDraweeSpanStringBuilder$default = getStatusDraweeSpanStringBuilder$default(presenceUtils, context, presence, isStreamingApplication, hideEmoji, showFallbackStatusText, false, 32, null);
        textView.setDraweeSpanStringBuilder(statusDraweeSpanStringBuilder$default);
        textView.setVisibility(statusDraweeSpanStringBuilder$default.length() > 0 ? 0 : 8);
    }

    public static /* synthetic */ void setPresenceText$default(Presence presence, boolean z2, SimpleDraweeSpanTextView simpleDraweeSpanTextView, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 8) != 0) {
            z3 = false;
        }
        if ((i & 16) != 0) {
            z4 = false;
        }
        setPresenceText(presence, z2, simpleDraweeSpanTextView, z3, z4);
    }

    public final Comparator<Activity> getACTIVITY_COMPARATOR$app_productionGoogleRelease() {
        return ACTIVITY_COMPARATOR;
    }

    public final Activity getActivityByType(List<Activity> list, ActivityType activityType) {
        Object next;
        Intrinsics3.checkNotNullParameter(list, "$this$getActivityByType");
        Intrinsics3.checkNotNullParameter(activityType, "type");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((Activity) next).getType() == activityType) {
                return (Activity) next;
            }
        }
        next = null;
        return (Activity) next;
    }

    public final long getCurrentSize(ActivityParty activityParty) {
        Long l;
        Intrinsics3.checkNotNullParameter(activityParty, "$this$currentSize");
        List<Long> listB = activityParty.b();
        if (listB == null || (l = (Long) _Collections.first((List) listB)) == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final Activity getCustomStatusActivity(Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "$this$customStatusActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getActivityByType(activities, ActivityType.CUSTOM_STATUS);
        }
        return null;
    }

    public final long getMaxSize(ActivityParty activityParty) {
        Long l;
        Intrinsics3.checkNotNullParameter(activityParty, "$this$maxSize");
        List<Long> listB = activityParty.b();
        if (listB == null || (l = (Long) _Collections.last((List) listB)) == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final long getNumOpenSlots(ActivityParty activityParty) {
        Intrinsics3.checkNotNullParameter(activityParty, "$this$numOpenSlots");
        return getMaxSize(activityParty) - getCurrentSize(activityParty);
    }

    public final Activity getPlayingActivity(Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "$this$playingActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getActivityByType(activities, ActivityType.PLAYING);
        }
        return null;
    }

    public final Activity getPrimaryActivity(Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "$this$primaryActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getPrimaryActivity(activities);
        }
        return null;
    }

    public final Activity getSpotifyListeningActivity(Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "$this$spotifyListeningActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getSpotifyListeningActivity(activities);
        }
        return null;
    }

    public final Activity getStageChannelActivity(Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "$this$stageChannelActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getStageChannelActivity(activities);
        }
        return null;
    }

    @StringRes
    public final int getStatusStringResForPresence(Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "presence");
        return getStatusText(presence);
    }

    public final Activity getStreamingActivity(Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "$this$streamingActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getActivityByType(activities, ActivityType.STREAMING);
        }
        return null;
    }

    public final boolean isMobile(ClientStatuses clientStatuses) {
        Intrinsics3.checkNotNullParameter(clientStatuses, "$this$isMobile");
        ClientStatus clientStatusB = clientStatuses.b();
        ClientStatus clientStatus = ClientStatus.ONLINE;
        return (clientStatusB != clientStatus || clientStatuses.c() == clientStatus || clientStatuses.a() == clientStatus) ? false : true;
    }

    public final boolean shouldShowRichPresenceIcon(Presence presence) {
        List<Activity> activities;
        boolean z2;
        if (presence != null && (activities = presence.getActivities()) != null) {
            if (activities.isEmpty()) {
                z2 = false;
            } else {
                Iterator<T> it = activities.iterator();
                while (it.hasNext()) {
                    if (ActivityUtils.isRichPresence((Activity) it.next())) {
                        z2 = true;
                    }
                }
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    private final Activity getSpotifyListeningActivity(List<Activity> list) {
        Object next;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (ActivityUtils.isSpotifyActivity((Activity) next)) {
                return (Activity) next;
            }
        }
        next = null;
        return (Activity) next;
    }

    private final Activity getStageChannelActivity(List<Activity> list) {
        Object next;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (ActivityUtils.isStageChannelActivity((Activity) next)) {
                return (Activity) next;
            }
        }
        next = null;
        return (Activity) next;
    }

    public final Activity getPrimaryActivity(List<Activity> list) {
        Object next;
        Intrinsics3.checkNotNullParameter(list, "$this$primaryActivity");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((Activity) next).getType() != ActivityType.CUSTOM_STATUS) {
                return (Activity) next;
            }
        }
        next = null;
        return (Activity) next;
    }

    private final int getStatusText(Presence presence) {
        ClientStatus status = presence != null ? presence.getStatus() : null;
        if (status != null) {
            int iOrdinal = status.ordinal();
            if (iOrdinal == 0) {
                return R.string.status_online;
            }
            if (iOrdinal == 1) {
                return R.string.status_idle;
            }
            if (iOrdinal == 2) {
                return R.string.status_dnd;
            }
        }
        return R.string.status_offline;
    }
}
