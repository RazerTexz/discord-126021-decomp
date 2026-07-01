package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Notification$Action;
import android.app.Notification$Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes$Builder;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.R$dimen;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NotificationCompat$Builder {
    private static final int MAX_CHARSEQUENCE_LENGTH = 5120;

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public ArrayList<NotificationCompat$Action> mActions;
    public boolean mAllowSystemGeneratedContextualActions;
    public int mBadgeIcon;
    public RemoteViews mBigContentView;
    public NotificationCompat$BubbleMetadata mBubbleMetadata;
    public String mCategory;
    public String mChannelId;
    public boolean mChronometerCountDown;
    public int mColor;
    public boolean mColorized;
    public boolean mColorizedSet;
    public CharSequence mContentInfo;
    public PendingIntent mContentIntent;
    public CharSequence mContentText;
    public CharSequence mContentTitle;
    public RemoteViews mContentView;

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public Context mContext;
    public Bundle mExtras;
    public PendingIntent mFullScreenIntent;
    public int mGroupAlertBehavior;
    public String mGroupKey;
    public boolean mGroupSummary;
    public RemoteViews mHeadsUpContentView;
    public ArrayList<NotificationCompat$Action> mInvisibleActions;
    public Bitmap mLargeIcon;
    public boolean mLocalOnly;
    public LocusIdCompat mLocusId;
    public Notification mNotification;
    public int mNumber;

    @Deprecated
    public ArrayList<String> mPeople;

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public ArrayList<Person> mPersonList;
    public int mPriority;
    public int mProgress;
    public boolean mProgressIndeterminate;
    public int mProgressMax;
    public Notification mPublicVersion;
    public CharSequence[] mRemoteInputHistory;
    public CharSequence mSettingsText;
    public String mShortcutId;
    public boolean mShowWhen;
    public boolean mSilent;
    public Icon mSmallIcon;
    public String mSortKey;
    public NotificationCompat$Style mStyle;
    public CharSequence mSubText;
    public RemoteViews mTickerView;
    public long mTimeout;
    public boolean mUseChronometer;
    public int mVisibility;

    @RequiresApi(19)
    public NotificationCompat$Builder(@NonNull Context context, @NonNull Notification notification) {
        ArrayList parcelableArrayList;
        this(context, NotificationCompat.getChannelId(notification));
        Bundle bundle = notification.extras;
        NotificationCompat$Style notificationCompat$StyleExtractStyleFromNotification = NotificationCompat$Style.extractStyleFromNotification(notification);
        setContentTitle(NotificationCompat.getContentTitle(notification)).setContentText(NotificationCompat.getContentText(notification)).setContentInfo(NotificationCompat.getContentInfo(notification)).setSubText(NotificationCompat.getSubText(notification)).setSettingsText(NotificationCompat.getSettingsText(notification)).setStyle(notificationCompat$StyleExtractStyleFromNotification).setContentIntent(notification.contentIntent).setGroup(NotificationCompat.getGroup(notification)).setGroupSummary(NotificationCompat.isGroupSummary(notification)).setLocusId(NotificationCompat.getLocusId(notification)).setWhen(notification.when).setShowWhen(NotificationCompat.getShowWhen(notification)).setUsesChronometer(NotificationCompat.getUsesChronometer(notification)).setAutoCancel(NotificationCompat.getAutoCancel(notification)).setOnlyAlertOnce(NotificationCompat.getOnlyAlertOnce(notification)).setOngoing(NotificationCompat.getOngoing(notification)).setLocalOnly(NotificationCompat.getLocalOnly(notification)).setLargeIcon(notification.largeIcon).setBadgeIconType(NotificationCompat.getBadgeIconType(notification)).setCategory(NotificationCompat.getCategory(notification)).setBubbleMetadata(NotificationCompat.getBubbleMetadata(notification)).setNumber(notification.number).setTicker(notification.tickerText).setContentIntent(notification.contentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(notification.fullScreenIntent, NotificationCompat.getHighPriority(notification)).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setDefaults(notification.defaults).setPriority(notification.priority).setColor(NotificationCompat.getColor(notification)).setVisibility(NotificationCompat.getVisibility(notification)).setPublicVersion(NotificationCompat.getPublicVersion(notification)).setSortKey(NotificationCompat.getSortKey(notification)).setTimeoutAfter(NotificationCompat.getTimeoutAfter(notification)).setShortcutId(NotificationCompat.getShortcutId(notification)).setProgress(bundle.getInt(NotificationCompat.EXTRA_PROGRESS_MAX), bundle.getInt(NotificationCompat.EXTRA_PROGRESS), bundle.getBoolean(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE)).setAllowSystemGeneratedContextualActions(NotificationCompat.getAllowSystemGeneratedContextualActions(notification)).setSmallIcon(notification.icon, notification.iconLevel).addExtras(getExtrasWithoutDuplicateData(notification, notificationCompat$StyleExtractStyleFromNotification));
        if (Build$VERSION.SDK_INT >= 23) {
            this.mSmallIcon = notification.getSmallIcon();
        }
        Notification$Action[] notification$ActionArr = notification.actions;
        if (notification$ActionArr != null && notification$ActionArr.length != 0) {
            for (Notification$Action notification$Action : notification$ActionArr) {
                addAction(NotificationCompat$Action$Builder.fromAndroidAction(notification$Action).build());
            }
        }
        List<NotificationCompat$Action> invisibleActions = NotificationCompat.getInvisibleActions(notification);
        if (!invisibleActions.isEmpty()) {
            Iterator<NotificationCompat$Action> it = invisibleActions.iterator();
            while (it.hasNext()) {
                addInvisibleAction(it.next());
            }
        }
        String[] stringArray = notification.extras.getStringArray(NotificationCompat.EXTRA_PEOPLE);
        if (stringArray != null && stringArray.length != 0) {
            for (String str : stringArray) {
                addPerson(str);
            }
        }
        if (Build$VERSION.SDK_INT >= 28 && (parcelableArrayList = notification.extras.getParcelableArrayList(NotificationCompat.EXTRA_PEOPLE_LIST)) != null && !parcelableArrayList.isEmpty()) {
            Iterator it2 = parcelableArrayList.iterator();
            while (it2.hasNext()) {
                addPerson(Person.fromAndroidPerson((android.app.Person) it2.next()));
            }
        }
        int i = Build$VERSION.SDK_INT;
        if (i >= 24 && bundle.containsKey(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN)) {
            setChronometerCountDown(bundle.getBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN));
        }
        if (i < 26 || !bundle.containsKey(NotificationCompat.EXTRA_COLORIZED)) {
            return;
        }
        setColorized(bundle.getBoolean(NotificationCompat.EXTRA_COLORIZED));
    }

    @Nullable
    @RequiresApi(19)
    private static Bundle getExtrasWithoutDuplicateData(@NonNull Notification notification, @Nullable NotificationCompat$Style notificationCompat$Style) {
        if (notification.extras == null) {
            return null;
        }
        Bundle bundle = new Bundle(notification.extras);
        bundle.remove(NotificationCompat.EXTRA_TITLE);
        bundle.remove(NotificationCompat.EXTRA_TEXT);
        bundle.remove(NotificationCompat.EXTRA_INFO_TEXT);
        bundle.remove(NotificationCompat.EXTRA_SUB_TEXT);
        bundle.remove(NotificationCompat.EXTRA_CHANNEL_ID);
        bundle.remove(NotificationCompat.EXTRA_CHANNEL_GROUP_ID);
        bundle.remove(NotificationCompat.EXTRA_SHOW_WHEN);
        bundle.remove(NotificationCompat.EXTRA_PROGRESS);
        bundle.remove(NotificationCompat.EXTRA_PROGRESS_MAX);
        bundle.remove(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE);
        bundle.remove(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN);
        bundle.remove(NotificationCompat.EXTRA_COLORIZED);
        bundle.remove(NotificationCompat.EXTRA_PEOPLE_LIST);
        bundle.remove(NotificationCompat.EXTRA_PEOPLE);
        bundle.remove(NotificationCompatExtras.EXTRA_SORT_KEY);
        bundle.remove(NotificationCompatExtras.EXTRA_GROUP_KEY);
        bundle.remove(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
        bundle.remove(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
        bundle.remove(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
        Bundle bundle2 = bundle.getBundle(NotificationCompat$CarExtender.EXTRA_CAR_EXTENDER);
        if (bundle2 != null) {
            Bundle bundle3 = new Bundle(bundle2);
            bundle3.remove(NotificationCompat$CarExtender.EXTRA_INVISIBLE_ACTIONS);
            bundle.putBundle(NotificationCompat$CarExtender.EXTRA_CAR_EXTENDER, bundle3);
        }
        if (notificationCompat$Style != null) {
            notificationCompat$Style.clearCompatExtraKeys(bundle);
        }
        return bundle;
    }

    @Nullable
    public static CharSequence limitCharSequenceLength(@Nullable CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > MAX_CHARSEQUENCE_LENGTH) ? charSequence.subSequence(0, MAX_CHARSEQUENCE_LENGTH) : charSequence;
    }

    @Nullable
    private Bitmap reduceLargeIconSize(@Nullable Bitmap bitmap) {
        if (bitmap == null || Build$VERSION.SDK_INT >= 27) {
            return bitmap;
        }
        Resources resources = this.mContext.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_width);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_height);
        if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
            return bitmap;
        }
        double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
        return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
    }

    private void setFlag(int i, boolean z2) {
        if (z2) {
            Notification notification = this.mNotification;
            notification.flags = i | notification.flags;
        } else {
            Notification notification2 = this.mNotification;
            notification2.flags = (~i) & notification2.flags;
        }
    }

    private boolean useExistingRemoteView() {
        NotificationCompat$Style notificationCompat$Style = this.mStyle;
        return notificationCompat$Style == null || !notificationCompat$Style.displayCustomViewInline();
    }

    @NonNull
    public NotificationCompat$Builder addAction(int i, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
        this.mActions.add(new NotificationCompat$Action(i, charSequence, pendingIntent));
        return this;
    }

    @NonNull
    public NotificationCompat$Builder addExtras(@Nullable Bundle bundle) {
        if (bundle != null) {
            Bundle bundle2 = this.mExtras;
            if (bundle2 == null) {
                this.mExtras = new Bundle(bundle);
            } else {
                bundle2.putAll(bundle);
            }
        }
        return this;
    }

    @NonNull
    @RequiresApi(21)
    public NotificationCompat$Builder addInvisibleAction(int i, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
        this.mInvisibleActions.add(new NotificationCompat$Action(i, charSequence, pendingIntent));
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$Builder addPerson(@Nullable String str) {
        if (str != null && !str.isEmpty()) {
            this.mPeople.add(str);
        }
        return this;
    }

    @NonNull
    public Notification build() {
        return new NotificationCompatBuilder(this).build();
    }

    @NonNull
    public NotificationCompat$Builder clearActions() {
        this.mActions.clear();
        return this;
    }

    @NonNull
    public NotificationCompat$Builder clearInvisibleActions() {
        this.mInvisibleActions.clear();
        Bundle bundle = this.mExtras.getBundle(NotificationCompat$CarExtender.EXTRA_CAR_EXTENDER);
        if (bundle != null) {
            Bundle bundle2 = new Bundle(bundle);
            bundle2.remove(NotificationCompat$CarExtender.EXTRA_INVISIBLE_ACTIONS);
            this.mExtras.putBundle(NotificationCompat$CarExtender.EXTRA_CAR_EXTENDER, bundle2);
        }
        return this;
    }

    @NonNull
    public NotificationCompat$Builder clearPeople() {
        this.mPersonList.clear();
        this.mPeople.clear();
        return this;
    }

    @Nullable
    @SuppressLint({"BuilderSetStyle"})
    public RemoteViews createBigContentView() {
        RemoteViews remoteViewsMakeBigContentView;
        int i = Build$VERSION.SDK_INT;
        if (this.mBigContentView != null && useExistingRemoteView()) {
            return this.mBigContentView;
        }
        NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
        NotificationCompat$Style notificationCompat$Style = this.mStyle;
        if (notificationCompat$Style != null && (remoteViewsMakeBigContentView = notificationCompat$Style.makeBigContentView(notificationCompatBuilder)) != null) {
            return remoteViewsMakeBigContentView;
        }
        Notification notificationBuild = notificationCompatBuilder.build();
        return i >= 24 ? Notification$Builder.recoverBuilder(this.mContext, notificationBuild).createBigContentView() : notificationBuild.bigContentView;
    }

    @Nullable
    @SuppressLint({"BuilderSetStyle"})
    public RemoteViews createContentView() {
        RemoteViews remoteViewsMakeContentView;
        if (this.mContentView != null && useExistingRemoteView()) {
            return this.mContentView;
        }
        NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
        NotificationCompat$Style notificationCompat$Style = this.mStyle;
        if (notificationCompat$Style != null && (remoteViewsMakeContentView = notificationCompat$Style.makeContentView(notificationCompatBuilder)) != null) {
            return remoteViewsMakeContentView;
        }
        Notification notificationBuild = notificationCompatBuilder.build();
        return Build$VERSION.SDK_INT >= 24 ? Notification$Builder.recoverBuilder(this.mContext, notificationBuild).createContentView() : notificationBuild.contentView;
    }

    @Nullable
    @SuppressLint({"BuilderSetStyle"})
    public RemoteViews createHeadsUpContentView() {
        RemoteViews remoteViewsMakeHeadsUpContentView;
        int i = Build$VERSION.SDK_INT;
        if (this.mHeadsUpContentView != null && useExistingRemoteView()) {
            return this.mHeadsUpContentView;
        }
        NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
        NotificationCompat$Style notificationCompat$Style = this.mStyle;
        if (notificationCompat$Style != null && (remoteViewsMakeHeadsUpContentView = notificationCompat$Style.makeHeadsUpContentView(notificationCompatBuilder)) != null) {
            return remoteViewsMakeHeadsUpContentView;
        }
        Notification notificationBuild = notificationCompatBuilder.build();
        return i >= 24 ? Notification$Builder.recoverBuilder(this.mContext, notificationBuild).createHeadsUpContentView() : notificationBuild.headsUpContentView;
    }

    @NonNull
    public NotificationCompat$Builder extend(@NonNull NotificationCompat$Extender notificationCompat$Extender) {
        notificationCompat$Extender.extend(this);
        return this;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews getBigContentView() {
        return this.mBigContentView;
    }

    @Nullable
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public NotificationCompat$BubbleMetadata getBubbleMetadata() {
        return this.mBubbleMetadata;
    }

    @ColorInt
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public int getColor() {
        return this.mColor;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews getContentView() {
        return this.mContentView;
    }

    @NonNull
    public Bundle getExtras() {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        return this.mExtras;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews getHeadsUpContentView() {
        return this.mHeadsUpContentView;
    }

    @NonNull
    @Deprecated
    public Notification getNotification() {
        return build();
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public int getPriority() {
        return this.mPriority;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public long getWhenIfShowing() {
        if (this.mShowWhen) {
            return this.mNotification.when;
        }
        return 0L;
    }

    @NonNull
    public NotificationCompat$Builder setAllowSystemGeneratedContextualActions(boolean z2) {
        this.mAllowSystemGeneratedContextualActions = z2;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setAutoCancel(boolean z2) {
        setFlag(16, z2);
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setBadgeIconType(int i) {
        this.mBadgeIcon = i;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setBubbleMetadata(@Nullable NotificationCompat$BubbleMetadata notificationCompat$BubbleMetadata) {
        this.mBubbleMetadata = notificationCompat$BubbleMetadata;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setCategory(@Nullable String str) {
        this.mCategory = str;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setChannelId(@NonNull String str) {
        this.mChannelId = str;
        return this;
    }

    @NonNull
    @RequiresApi(24)
    public NotificationCompat$Builder setChronometerCountDown(boolean z2) {
        this.mChronometerCountDown = z2;
        getExtras().putBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN, z2);
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setColor(@ColorInt int i) {
        this.mColor = i;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setColorized(boolean z2) {
        this.mColorized = z2;
        this.mColorizedSet = true;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setContent(@Nullable RemoteViews remoteViews) {
        this.mNotification.contentView = remoteViews;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setContentInfo(@Nullable CharSequence charSequence) {
        this.mContentInfo = limitCharSequenceLength(charSequence);
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setContentIntent(@Nullable PendingIntent pendingIntent) {
        this.mContentIntent = pendingIntent;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setContentText(@Nullable CharSequence charSequence) {
        this.mContentText = limitCharSequenceLength(charSequence);
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setContentTitle(@Nullable CharSequence charSequence) {
        this.mContentTitle = limitCharSequenceLength(charSequence);
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setCustomBigContentView(@Nullable RemoteViews remoteViews) {
        this.mBigContentView = remoteViews;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setCustomContentView(@Nullable RemoteViews remoteViews) {
        this.mContentView = remoteViews;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setCustomHeadsUpContentView(@Nullable RemoteViews remoteViews) {
        this.mHeadsUpContentView = remoteViews;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setDefaults(int i) {
        Notification notification = this.mNotification;
        notification.defaults = i;
        if ((i & 4) != 0) {
            notification.flags |= 1;
        }
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setDeleteIntent(@Nullable PendingIntent pendingIntent) {
        this.mNotification.deleteIntent = pendingIntent;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setExtras(@Nullable Bundle bundle) {
        this.mExtras = bundle;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setFullScreenIntent(@Nullable PendingIntent pendingIntent, boolean z2) {
        this.mFullScreenIntent = pendingIntent;
        setFlag(128, z2);
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setGroup(@Nullable String str) {
        this.mGroupKey = str;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setGroupAlertBehavior(int i) {
        this.mGroupAlertBehavior = i;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setGroupSummary(boolean z2) {
        this.mGroupSummary = z2;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setLargeIcon(@Nullable Bitmap bitmap) {
        this.mLargeIcon = reduceLargeIconSize(bitmap);
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setLights(@ColorInt int i, int i2, int i3) {
        Notification notification = this.mNotification;
        notification.ledARGB = i;
        notification.ledOnMS = i2;
        notification.ledOffMS = i3;
        notification.flags = ((i2 == 0 || i3 == 0) ? 0 : 1) | (notification.flags & (-2));
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setLocalOnly(boolean z2) {
        this.mLocalOnly = z2;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setLocusId(@Nullable LocusIdCompat locusIdCompat) {
        this.mLocusId = locusIdCompat;
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$Builder setNotificationSilent() {
        this.mSilent = true;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setNumber(int i) {
        this.mNumber = i;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setOngoing(boolean z2) {
        setFlag(2, z2);
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setOnlyAlertOnce(boolean z2) {
        setFlag(8, z2);
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setPriority(int i) {
        this.mPriority = i;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setProgress(int i, int i2, boolean z2) {
        this.mProgressMax = i;
        this.mProgress = i2;
        this.mProgressIndeterminate = z2;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setPublicVersion(@Nullable Notification notification) {
        this.mPublicVersion = notification;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setRemoteInputHistory(@Nullable CharSequence[] charSequenceArr) {
        this.mRemoteInputHistory = charSequenceArr;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setSettingsText(@Nullable CharSequence charSequence) {
        this.mSettingsText = limitCharSequenceLength(charSequence);
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setShortcutId(@Nullable String str) {
        this.mShortcutId = str;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setShortcutInfo(@Nullable ShortcutInfoCompat shortcutInfoCompat) {
        if (shortcutInfoCompat == null) {
            return this;
        }
        this.mShortcutId = shortcutInfoCompat.getId();
        if (this.mLocusId == null) {
            if (shortcutInfoCompat.getLocusId() != null) {
                this.mLocusId = shortcutInfoCompat.getLocusId();
            } else if (shortcutInfoCompat.getId() != null) {
                this.mLocusId = new LocusIdCompat(shortcutInfoCompat.getId());
            }
        }
        if (this.mContentTitle == null) {
            setContentTitle(shortcutInfoCompat.getShortLabel());
        }
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setShowWhen(boolean z2) {
        this.mShowWhen = z2;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setSilent(boolean z2) {
        this.mSilent = z2;
        return this;
    }

    @NonNull
    @RequiresApi(23)
    public NotificationCompat$Builder setSmallIcon(@NonNull IconCompat iconCompat) {
        this.mSmallIcon = iconCompat.toIcon(this.mContext);
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setSortKey(@Nullable String str) {
        this.mSortKey = str;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setSound(@Nullable Uri uri) {
        Notification notification = this.mNotification;
        notification.sound = uri;
        notification.audioStreamType = -1;
        notification.audioAttributes = new AudioAttributes$Builder().setContentType(4).setUsage(5).build();
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setStyle(@Nullable NotificationCompat$Style notificationCompat$Style) {
        if (this.mStyle != notificationCompat$Style) {
            this.mStyle = notificationCompat$Style;
            if (notificationCompat$Style != null) {
                notificationCompat$Style.setBuilder(this);
            }
        }
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setSubText(@Nullable CharSequence charSequence) {
        this.mSubText = limitCharSequenceLength(charSequence);
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setTicker(@Nullable CharSequence charSequence) {
        this.mNotification.tickerText = limitCharSequenceLength(charSequence);
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setTimeoutAfter(long j) {
        this.mTimeout = j;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setUsesChronometer(boolean z2) {
        this.mUseChronometer = z2;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setVibrate(@Nullable long[] jArr) {
        this.mNotification.vibrate = jArr;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setVisibility(int i) {
        this.mVisibility = i;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setWhen(long j) {
        this.mNotification.when = j;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder addAction(@Nullable NotificationCompat$Action notificationCompat$Action) {
        if (notificationCompat$Action != null) {
            this.mActions.add(notificationCompat$Action);
        }
        return this;
    }

    @NonNull
    @RequiresApi(21)
    public NotificationCompat$Builder addInvisibleAction(@Nullable NotificationCompat$Action notificationCompat$Action) {
        if (notificationCompat$Action != null) {
            this.mInvisibleActions.add(notificationCompat$Action);
        }
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setSmallIcon(int i) {
        this.mNotification.icon = i;
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$Builder setTicker(@Nullable CharSequence charSequence, @Nullable RemoteViews remoteViews) {
        this.mNotification.tickerText = limitCharSequenceLength(charSequence);
        this.mTickerView = remoteViews;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder addPerson(@Nullable Person person) {
        if (person != null) {
            this.mPersonList.add(person);
        }
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setSmallIcon(int i, int i2) {
        Notification notification = this.mNotification;
        notification.icon = i;
        notification.iconLevel = i2;
        return this;
    }

    @NonNull
    public NotificationCompat$Builder setSound(@Nullable Uri uri, int i) {
        Notification notification = this.mNotification;
        notification.sound = uri;
        notification.audioStreamType = i;
        notification.audioAttributes = new AudioAttributes$Builder().setContentType(4).setLegacyStreamType(i).build();
        return this;
    }

    public NotificationCompat$Builder(@NonNull Context context, @NonNull String str) {
        this.mActions = new ArrayList<>();
        this.mPersonList = new ArrayList<>();
        this.mInvisibleActions = new ArrayList<>();
        this.mShowWhen = true;
        this.mLocalOnly = false;
        this.mColor = 0;
        this.mVisibility = 0;
        this.mBadgeIcon = 0;
        this.mGroupAlertBehavior = 0;
        Notification notification = new Notification();
        this.mNotification = notification;
        this.mContext = context;
        this.mChannelId = str;
        notification.when = System.currentTimeMillis();
        this.mNotification.audioStreamType = -1;
        this.mPriority = 0;
        this.mPeople = new ArrayList<>();
        this.mAllowSystemGeneratedContextualActions = true;
    }

    @Deprecated
    public NotificationCompat$Builder(@NonNull Context context) {
        this(context, (String) null);
    }
}
