package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationCompat$Style;
import androidx.media.R$id;
import androidx.media.R$integer;
import androidx.media.R$layout;

/* JADX INFO: loaded from: classes.dex */
public class NotificationCompat$MediaStyle extends NotificationCompat$Style {
    private static final int MAX_MEDIA_BUTTONS = 5;
    private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
    public int[] mActionsToShowInCompact = null;
    public PendingIntent mCancelButtonIntent;
    public boolean mShowCancelButton;
    public MediaSessionCompat$Token mToken;

    public NotificationCompat$MediaStyle() {
    }

    private RemoteViews generateMediaActionButton(NotificationCompat$Action notificationCompat$Action) {
        boolean z2 = notificationCompat$Action.getActionIntent() == null;
        RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), R$layout.notification_media_action);
        int i = R$id.action0;
        remoteViews.setImageViewResource(i, notificationCompat$Action.getIcon());
        if (!z2) {
            remoteViews.setOnClickPendingIntent(i, notificationCompat$Action.getActionIntent());
        }
        NotificationCompat$Api15Impl.setContentDescription(remoteViews, i, notificationCompat$Action.getTitle());
        return remoteViews;
    }

    public static MediaSessionCompat$Token getMediaSession(Notification notification) {
        Parcelable parcelable;
        Bundle extras = androidx.core.app.NotificationCompat.getExtras(notification);
        if (extras == null || (parcelable = extras.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION)) == null) {
            return null;
        }
        return MediaSessionCompat$Token.a(parcelable, null);
    }

    @Override // androidx.core.app.NotificationCompat$Style
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        NotificationCompat$Api21Impl.setMediaStyle(notificationBuilderWithBuilderAccessor.getBuilder(), NotificationCompat$Api21Impl.fillInMediaStyle(NotificationCompat$Api21Impl.createMediaStyle(), this.mActionsToShowInCompact, this.mToken));
    }

    public RemoteViews generateBigContentView() {
        int iMin = Math.min(this.mBuilder.mActions.size(), 5);
        RemoteViews remoteViewsApplyStandardTemplate = applyStandardTemplate(false, getBigContentViewLayoutResource(iMin), false);
        remoteViewsApplyStandardTemplate.removeAllViews(R$id.media_actions);
        if (iMin > 0) {
            for (int i = 0; i < iMin; i++) {
                remoteViewsApplyStandardTemplate.addView(R$id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(i)));
            }
        }
        if (this.mShowCancelButton) {
            int i2 = R$id.cancel_action;
            remoteViewsApplyStandardTemplate.setViewVisibility(i2, 0);
            remoteViewsApplyStandardTemplate.setInt(i2, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R$integer.cancel_button_image_alpha));
            remoteViewsApplyStandardTemplate.setOnClickPendingIntent(i2, this.mCancelButtonIntent);
        } else {
            remoteViewsApplyStandardTemplate.setViewVisibility(R$id.cancel_action, 8);
        }
        return remoteViewsApplyStandardTemplate;
    }

    public RemoteViews generateContentView() {
        RemoteViews remoteViewsApplyStandardTemplate = applyStandardTemplate(false, getContentViewLayoutResource(), true);
        int size = this.mBuilder.mActions.size();
        int[] iArr = this.mActionsToShowInCompact;
        int iMin = iArr == null ? 0 : Math.min(iArr.length, 3);
        remoteViewsApplyStandardTemplate.removeAllViews(R$id.media_actions);
        if (iMin > 0) {
            for (int i = 0; i < iMin; i++) {
                if (i >= size) {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i), Integer.valueOf(size - 1)));
                }
                remoteViewsApplyStandardTemplate.addView(R$id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(this.mActionsToShowInCompact[i])));
            }
        }
        if (this.mShowCancelButton) {
            remoteViewsApplyStandardTemplate.setViewVisibility(R$id.end_padder, 8);
            int i2 = R$id.cancel_action;
            remoteViewsApplyStandardTemplate.setViewVisibility(i2, 0);
            remoteViewsApplyStandardTemplate.setOnClickPendingIntent(i2, this.mCancelButtonIntent);
            remoteViewsApplyStandardTemplate.setInt(i2, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R$integer.cancel_button_image_alpha));
        } else {
            remoteViewsApplyStandardTemplate.setViewVisibility(R$id.end_padder, 0);
            remoteViewsApplyStandardTemplate.setViewVisibility(R$id.cancel_action, 8);
        }
        return remoteViewsApplyStandardTemplate;
    }

    public int getBigContentViewLayoutResource(int i) {
        return i <= 3 ? R$layout.notification_template_big_media_narrow : R$layout.notification_template_big_media;
    }

    public int getContentViewLayoutResource() {
        return R$layout.notification_template_media;
    }

    @Override // androidx.core.app.NotificationCompat$Style
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        return null;
    }

    @Override // androidx.core.app.NotificationCompat$Style
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        return null;
    }

    public NotificationCompat$MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
        this.mCancelButtonIntent = pendingIntent;
        return this;
    }

    public NotificationCompat$MediaStyle setMediaSession(MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.mToken = mediaSessionCompat$Token;
        return this;
    }

    public NotificationCompat$MediaStyle setShowActionsInCompactView(int... iArr) {
        this.mActionsToShowInCompact = iArr;
        return this;
    }

    public NotificationCompat$MediaStyle setShowCancelButton(boolean z2) {
        return this;
    }

    public NotificationCompat$MediaStyle(NotificationCompat$Builder notificationCompat$Builder) {
        setBuilder(notificationCompat$Builder);
    }
}
