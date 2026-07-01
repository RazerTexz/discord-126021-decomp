package androidx.core.app;

import android.app.Notification;
import android.app.Notification$Action$Builder;
import android.app.Notification$Builder;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.collection.ArraySet;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
    private RemoteViews mBigContentView;
    private final Notification$Builder mBuilder;
    private final NotificationCompat$Builder mBuilderCompat;
    private RemoteViews mContentView;
    private final Context mContext;
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;
    private final List<Bundle> mActionExtrasList = new ArrayList();
    private final Bundle mExtras = new Bundle();

    public NotificationCompatBuilder(NotificationCompat$Builder notificationCompat$Builder) {
        Icon icon;
        this.mBuilderCompat = notificationCompat$Builder;
        this.mContext = notificationCompat$Builder.mContext;
        if (Build$VERSION.SDK_INT >= 26) {
            this.mBuilder = new Notification$Builder(notificationCompat$Builder.mContext, notificationCompat$Builder.mChannelId);
        } else {
            this.mBuilder = new Notification$Builder(notificationCompat$Builder.mContext);
        }
        Notification notification = notificationCompat$Builder.mNotification;
        this.mBuilder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, notificationCompat$Builder.mTickerView).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(notificationCompat$Builder.mContentTitle).setContentText(notificationCompat$Builder.mContentText).setContentInfo(notificationCompat$Builder.mContentInfo).setContentIntent(notificationCompat$Builder.mContentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(notificationCompat$Builder.mFullScreenIntent, (notification.flags & 128) != 0).setLargeIcon(notificationCompat$Builder.mLargeIcon).setNumber(notificationCompat$Builder.mNumber).setProgress(notificationCompat$Builder.mProgressMax, notificationCompat$Builder.mProgress, notificationCompat$Builder.mProgressIndeterminate);
        this.mBuilder.setSubText(notificationCompat$Builder.mSubText).setUsesChronometer(notificationCompat$Builder.mUseChronometer).setPriority(notificationCompat$Builder.mPriority);
        Iterator<NotificationCompat$Action> it = notificationCompat$Builder.mActions.iterator();
        while (it.hasNext()) {
            addAction(it.next());
        }
        Bundle bundle = notificationCompat$Builder.mExtras;
        if (bundle != null) {
            this.mExtras.putAll(bundle);
        }
        int i = Build$VERSION.SDK_INT;
        this.mContentView = notificationCompat$Builder.mContentView;
        this.mBigContentView = notificationCompat$Builder.mBigContentView;
        this.mBuilder.setShowWhen(notificationCompat$Builder.mShowWhen);
        this.mBuilder.setLocalOnly(notificationCompat$Builder.mLocalOnly).setGroup(notificationCompat$Builder.mGroupKey).setGroupSummary(notificationCompat$Builder.mGroupSummary).setSortKey(notificationCompat$Builder.mSortKey);
        this.mGroupAlertBehavior = notificationCompat$Builder.mGroupAlertBehavior;
        this.mBuilder.setCategory(notificationCompat$Builder.mCategory).setColor(notificationCompat$Builder.mColor).setVisibility(notificationCompat$Builder.mVisibility).setPublicVersion(notificationCompat$Builder.mPublicVersion).setSound(notification.sound, notification.audioAttributes);
        List listCombineLists = i < 28 ? combineLists(getPeople(notificationCompat$Builder.mPersonList), notificationCompat$Builder.mPeople) : notificationCompat$Builder.mPeople;
        if (listCombineLists != null && !listCombineLists.isEmpty()) {
            Iterator it2 = listCombineLists.iterator();
            while (it2.hasNext()) {
                this.mBuilder.addPerson((String) it2.next());
            }
        }
        this.mHeadsUpContentView = notificationCompat$Builder.mHeadsUpContentView;
        if (notificationCompat$Builder.mInvisibleActions.size() > 0) {
            Bundle bundle2 = notificationCompat$Builder.getExtras().getBundle(NotificationCompat$CarExtender.EXTRA_CAR_EXTENDER);
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i2 = 0; i2 < notificationCompat$Builder.mInvisibleActions.size(); i2++) {
                bundle4.putBundle(Integer.toString(i2), NotificationCompatJellybean.getBundleForAction(notificationCompat$Builder.mInvisibleActions.get(i2)));
            }
            bundle2.putBundle(NotificationCompat$CarExtender.EXTRA_INVISIBLE_ACTIONS, bundle4);
            bundle3.putBundle(NotificationCompat$CarExtender.EXTRA_INVISIBLE_ACTIONS, bundle4);
            notificationCompat$Builder.getExtras().putBundle(NotificationCompat$CarExtender.EXTRA_CAR_EXTENDER, bundle2);
            this.mExtras.putBundle(NotificationCompat$CarExtender.EXTRA_CAR_EXTENDER, bundle3);
        }
        int i3 = Build$VERSION.SDK_INT;
        if (i3 >= 23 && (icon = notificationCompat$Builder.mSmallIcon) != null) {
            this.mBuilder.setSmallIcon(icon);
        }
        if (i3 >= 24) {
            this.mBuilder.setExtras(notificationCompat$Builder.mExtras).setRemoteInputHistory(notificationCompat$Builder.mRemoteInputHistory);
            RemoteViews remoteViews = notificationCompat$Builder.mContentView;
            if (remoteViews != null) {
                this.mBuilder.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = notificationCompat$Builder.mBigContentView;
            if (remoteViews2 != null) {
                this.mBuilder.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = notificationCompat$Builder.mHeadsUpContentView;
            if (remoteViews3 != null) {
                this.mBuilder.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i3 >= 26) {
            this.mBuilder.setBadgeIconType(notificationCompat$Builder.mBadgeIcon).setSettingsText(notificationCompat$Builder.mSettingsText).setShortcutId(notificationCompat$Builder.mShortcutId).setTimeoutAfter(notificationCompat$Builder.mTimeout).setGroupAlertBehavior(notificationCompat$Builder.mGroupAlertBehavior);
            if (notificationCompat$Builder.mColorizedSet) {
                this.mBuilder.setColorized(notificationCompat$Builder.mColorized);
            }
            if (!TextUtils.isEmpty(notificationCompat$Builder.mChannelId)) {
                this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i3 >= 28) {
            Iterator<Person> it3 = notificationCompat$Builder.mPersonList.iterator();
            while (it3.hasNext()) {
                this.mBuilder.addPerson(it3.next().toAndroidPerson());
            }
        }
        int i4 = Build$VERSION.SDK_INT;
        if (i4 >= 29) {
            this.mBuilder.setAllowSystemGeneratedContextualActions(notificationCompat$Builder.mAllowSystemGeneratedContextualActions);
            this.mBuilder.setBubbleMetadata(NotificationCompat$BubbleMetadata.toPlatform(notificationCompat$Builder.mBubbleMetadata));
            LocusIdCompat locusIdCompat = notificationCompat$Builder.mLocusId;
            if (locusIdCompat != null) {
                this.mBuilder.setLocusId(locusIdCompat.toLocusId());
            }
        }
        if (notificationCompat$Builder.mSilent) {
            if (this.mBuilderCompat.mGroupSummary) {
                this.mGroupAlertBehavior = 2;
            } else {
                this.mGroupAlertBehavior = 1;
            }
            this.mBuilder.setVibrate(null);
            this.mBuilder.setSound(null);
            int i5 = notification.defaults & (-2);
            notification.defaults = i5;
            int i6 = i5 & (-3);
            notification.defaults = i6;
            this.mBuilder.setDefaults(i6);
            if (i4 >= 26) {
                if (TextUtils.isEmpty(this.mBuilderCompat.mGroupKey)) {
                    this.mBuilder.setGroup(NotificationCompat.GROUP_KEY_SILENT);
                }
                this.mBuilder.setGroupAlertBehavior(this.mGroupAlertBehavior);
            }
        }
    }

    private void addAction(NotificationCompat$Action notificationCompat$Action) {
        int i = Build$VERSION.SDK_INT;
        IconCompat iconCompat = notificationCompat$Action.getIconCompat();
        Notification$Action$Builder notification$Action$Builder = i >= 23 ? new Notification$Action$Builder(iconCompat != null ? iconCompat.toIcon() : null, notificationCompat$Action.getTitle(), notificationCompat$Action.getActionIntent()) : new Notification$Action$Builder(iconCompat != null ? iconCompat.getResId() : 0, notificationCompat$Action.getTitle(), notificationCompat$Action.getActionIntent());
        if (notificationCompat$Action.getRemoteInputs() != null) {
            for (android.app.RemoteInput remoteInput : RemoteInput.fromCompat(notificationCompat$Action.getRemoteInputs())) {
                notification$Action$Builder.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = notificationCompat$Action.getExtras() != null ? new Bundle(notificationCompat$Action.getExtras()) : new Bundle();
        bundle.putBoolean(NotificationCompatJellybean.EXTRA_ALLOW_GENERATED_REPLIES, notificationCompat$Action.getAllowGeneratedReplies());
        int i2 = Build$VERSION.SDK_INT;
        if (i2 >= 24) {
            notification$Action$Builder.setAllowGeneratedReplies(notificationCompat$Action.getAllowGeneratedReplies());
        }
        bundle.putInt(NotificationCompat$Action.EXTRA_SEMANTIC_ACTION, notificationCompat$Action.getSemanticAction());
        if (i2 >= 28) {
            notification$Action$Builder.setSemanticAction(notificationCompat$Action.getSemanticAction());
        }
        if (i2 >= 29) {
            notification$Action$Builder.setContextual(notificationCompat$Action.isContextual());
        }
        bundle.putBoolean(NotificationCompat$Action.EXTRA_SHOWS_USER_INTERFACE, notificationCompat$Action.getShowsUserInterface());
        notification$Action$Builder.addExtras(bundle);
        this.mBuilder.addAction(notification$Action$Builder.build());
    }

    @Nullable
    private static List<String> combineLists(@Nullable List<String> list, @Nullable List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(list2.size() + list.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList(arraySet);
    }

    @Nullable
    private static List<String> getPeople(@Nullable List<Person> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Person> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().resolveToLegacyUri());
        }
        return arrayList;
    }

    private void removeSoundAndVibration(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i = notification.defaults & (-2);
        notification.defaults = i;
        notification.defaults = i & (-3);
    }

    public Notification build() {
        Bundle extras;
        RemoteViews remoteViewsMakeHeadsUpContentView;
        RemoteViews remoteViewsMakeBigContentView;
        NotificationCompat$Style notificationCompat$Style = this.mBuilderCompat.mStyle;
        if (notificationCompat$Style != null) {
            notificationCompat$Style.apply(this);
        }
        RemoteViews remoteViewsMakeContentView = notificationCompat$Style != null ? notificationCompat$Style.makeContentView(this) : null;
        Notification notificationBuildInternal = buildInternal();
        if (remoteViewsMakeContentView != null) {
            notificationBuildInternal.contentView = remoteViewsMakeContentView;
        } else {
            RemoteViews remoteViews = this.mBuilderCompat.mContentView;
            if (remoteViews != null) {
                notificationBuildInternal.contentView = remoteViews;
            }
        }
        if (notificationCompat$Style != null && (remoteViewsMakeBigContentView = notificationCompat$Style.makeBigContentView(this)) != null) {
            notificationBuildInternal.bigContentView = remoteViewsMakeBigContentView;
        }
        if (notificationCompat$Style != null && (remoteViewsMakeHeadsUpContentView = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this)) != null) {
            notificationBuildInternal.headsUpContentView = remoteViewsMakeHeadsUpContentView;
        }
        if (notificationCompat$Style != null && (extras = NotificationCompat.getExtras(notificationBuildInternal)) != null) {
            notificationCompat$Style.addCompatExtras(extras);
        }
        return notificationBuildInternal;
    }

    public Notification buildInternal() {
        int i = Build$VERSION.SDK_INT;
        if (i >= 26) {
            return this.mBuilder.build();
        }
        if (i >= 24) {
            Notification notificationBuild = this.mBuilder.build();
            if (this.mGroupAlertBehavior != 0) {
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) != 0 && this.mGroupAlertBehavior == 2) {
                    removeSoundAndVibration(notificationBuild);
                }
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) == 0 && this.mGroupAlertBehavior == 1) {
                    removeSoundAndVibration(notificationBuild);
                }
            }
            return notificationBuild;
        }
        this.mBuilder.setExtras(this.mExtras);
        Notification notificationBuild2 = this.mBuilder.build();
        RemoteViews remoteViews = this.mContentView;
        if (remoteViews != null) {
            notificationBuild2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.mBigContentView;
        if (remoteViews2 != null) {
            notificationBuild2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.mHeadsUpContentView;
        if (remoteViews3 != null) {
            notificationBuild2.headsUpContentView = remoteViews3;
        }
        if (this.mGroupAlertBehavior != 0) {
            if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) != 0 && this.mGroupAlertBehavior == 2) {
                removeSoundAndVibration(notificationBuild2);
            }
            if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) == 0 && this.mGroupAlertBehavior == 1) {
                removeSoundAndVibration(notificationBuild2);
            }
        }
        return notificationBuild2;
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification$Builder getBuilder() {
        return this.mBuilder;
    }

    public Context getContext() {
        return this.mContext;
    }
}
