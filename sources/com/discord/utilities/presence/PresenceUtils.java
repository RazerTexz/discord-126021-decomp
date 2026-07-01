package com.discord.utilities.presence;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.ActivityChooserModel;
import b.a.k.b;
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
import com.discord.utilities.textprocessing.node.EmojiNode$Companion;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.t.u;
import d0.u.a;
import d0.z.d.m;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PresenceUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PresenceUtils {
    public static final PresenceUtils INSTANCE = new PresenceUtils();
    private static final Comparator<Activity> ACTIVITY_COMPARATOR = a.compareBy(PresenceUtils$ACTIVITY_COMPARATOR$1.INSTANCE, PresenceUtils$ACTIVITY_COMPARATOR$2.INSTANCE, PresenceUtils$ACTIVITY_COMPARATOR$3.INSTANCE);

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
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        int iOrdinal = activity.getType().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return b.h(context, 2131896726, new Object[]{activity.getName()}, null, 4);
            }
            if (iOrdinal == 2) {
                return b.h(context, 2131896725, new Object[]{activity.getName()}, null, 4);
            }
            if (iOrdinal != 3) {
                return iOrdinal != 5 ? b.h(context, 2131896727, new Object[0], null, 4) : b.h(context, 2131896724, new Object[]{activity.getName()}, null, 4);
            }
            return b.h(context, 2131896731, new Object[]{activity.getName()}, null, 4);
        }
        ActivityPlatform platform = activity.getPlatform();
        if (platform != null) {
            Platform platformFrom = Platform.Companion.from(platform);
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
                return b.h(context, 2131896728, new Object[]{properName}, null, 4);
            }
        }
        properName = str;
        properName = str2;
        return b.h(context, 2131896727, new Object[0], null, 4);
    }

    private final CharSequence getActivityString(Context context, Activity activityModel) {
        ActivityType type = activityModel != null ? activityModel.getType() : null;
        if (type == null) {
            return null;
        }
        int iOrdinal = type.ordinal();
        if (iOrdinal == 0) {
            return b.h(context, 2131893830, new Object[]{activityModel.getName()}, null, 4);
        }
        if (iOrdinal == 1) {
            Object[] objArr = new Object[1];
            String details = activityModel.getDetails();
            if (details == null) {
                details = activityModel.getName();
            }
            objArr[0] = details;
            return b.h(context, 2131896090, objArr, null, 4);
        }
        if (iOrdinal == 2) {
            return b.h(context, 2131892559, new Object[]{activityModel.getName()}, null, 4);
        }
        if (iOrdinal != 3) {
            if (iOrdinal != 5) {
                return null;
            }
            return b.h(context, 2131887815, new Object[]{activityModel.getName()}, null, 4);
        }
        Object[] objArr2 = new Object[1];
        String details2 = activityModel.getDetails();
        if (details2 == null) {
            details2 = activityModel.getName();
        }
        objArr2[0] = details2;
        return b.h(context, 2131897201, objArr2, null, 4);
    }

    private final CharSequence getApplicationStreamingString(Context context, Presence presence) {
        Activity playingActivity;
        return (presence == null || (playingActivity = getPlayingActivity(presence)) == null) ? b.h(context, 2131896091, new Object[0], null, 4) : b.h(context, 2131896090, new Object[]{playingActivity.getName()}, null, 4);
    }

    private final DraweeSpanStringBuilder getStatusDraweeSpanStringBuilder(Context context, Presence presence, boolean isStreamingApplication, boolean hideEmoji, boolean showFallbackStatusText, boolean animateCustomStatusEmoji) {
        Activity customStatusActivity;
        ActivityEmoji emoji;
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        EmojiNode emojiNodeFrom$default = null;
        if (!hideEmoji && presence != null && (customStatusActivity = getCustomStatusActivity(presence)) != null && (emoji = customStatusActivity.getEmoji()) != null) {
            EmojiNode$Companion emojiNode$Companion = EmojiNode.Companion;
            emojiNodeFrom$default = EmojiNode$Companion.from$default(emojiNode$Companion, 0, emojiNode$Companion.generateEmojiIdAndType(emoji), 1, (Object) null);
        }
        if (emojiNodeFrom$default != null) {
            emojiNodeFrom$default.render((SpannableStringBuilder) draweeSpanStringBuilder, new PresenceUtils$getStatusDraweeSpanStringBuilder$1(context, animateCustomStatusEmoji));
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
            return b.h(context, getStatusText(presence), new Object[0], null, 4);
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
        m.checkNotNullParameter(textView, "textView");
        PresenceUtils presenceUtils = INSTANCE;
        Context context = textView.getContext();
        m.checkNotNullExpressionValue(context, "textView.context");
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
        m.checkNotNullParameter(list, "$this$getActivityByType");
        m.checkNotNullParameter(activityType, "type");
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
        m.checkNotNullParameter(activityParty, "$this$currentSize");
        List<Long> listB = activityParty.b();
        if (listB == null || (l = (Long) u.first((List) listB)) == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final Activity getCustomStatusActivity(Presence presence) {
        m.checkNotNullParameter(presence, "$this$customStatusActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getActivityByType(activities, ActivityType.CUSTOM_STATUS);
        }
        return null;
    }

    public final long getMaxSize(ActivityParty activityParty) {
        Long l;
        m.checkNotNullParameter(activityParty, "$this$maxSize");
        List<Long> listB = activityParty.b();
        if (listB == null || (l = (Long) u.last((List) listB)) == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final long getNumOpenSlots(ActivityParty activityParty) {
        m.checkNotNullParameter(activityParty, "$this$numOpenSlots");
        return getMaxSize(activityParty) - getCurrentSize(activityParty);
    }

    public final Activity getPlayingActivity(Presence presence) {
        m.checkNotNullParameter(presence, "$this$playingActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getActivityByType(activities, ActivityType.PLAYING);
        }
        return null;
    }

    public final Activity getPrimaryActivity(Presence presence) {
        m.checkNotNullParameter(presence, "$this$primaryActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getPrimaryActivity(activities);
        }
        return null;
    }

    public final Activity getSpotifyListeningActivity(Presence presence) {
        m.checkNotNullParameter(presence, "$this$spotifyListeningActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getSpotifyListeningActivity(activities);
        }
        return null;
    }

    public final Activity getStageChannelActivity(Presence presence) {
        m.checkNotNullParameter(presence, "$this$stageChannelActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getStageChannelActivity(activities);
        }
        return null;
    }

    @StringRes
    public final int getStatusStringResForPresence(Presence presence) {
        m.checkNotNullParameter(presence, "presence");
        return getStatusText(presence);
    }

    public final Activity getStreamingActivity(Presence presence) {
        m.checkNotNullParameter(presence, "$this$streamingActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getActivityByType(activities, ActivityType.STREAMING);
        }
        return null;
    }

    public final boolean isMobile(ClientStatuses clientStatuses) {
        m.checkNotNullParameter(clientStatuses, "$this$isMobile");
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
                    if (ActivityUtilsKt.isRichPresence((Activity) it.next())) {
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
            if (ActivityUtilsKt.isSpotifyActivity((Activity) next)) {
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
            if (ActivityUtilsKt.isStageChannelActivity((Activity) next)) {
                return (Activity) next;
            }
        }
        next = null;
        return (Activity) next;
    }

    public final Activity getPrimaryActivity(List<Activity> list) {
        Object next;
        m.checkNotNullParameter(list, "$this$primaryActivity");
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
                return 2131895916;
            }
            if (iOrdinal == 1) {
                return 2131895912;
            }
            if (iOrdinal == 2) {
                return 2131895910;
            }
        }
        return 2131895915;
    }
}
