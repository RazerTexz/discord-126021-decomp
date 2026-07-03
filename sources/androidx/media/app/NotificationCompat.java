package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.media.C0499R;

/* JADX INFO: loaded from: classes.dex */
public class NotificationCompat {

    @RequiresApi(15)
    public static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        public static void setContentDescription(RemoteViews remoteViews, int i, CharSequence charSequence) {
            remoteViews.setContentDescription(i, charSequence);
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static Notification.MediaStyle createMediaStyle() {
            return new Notification.MediaStyle();
        }

        @DoNotInline
        public static Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle mediaStyle, int[] iArr, MediaSessionCompat.Token token) {
            if (iArr != null) {
                setShowActionsInCompactView(mediaStyle, iArr);
            }
            if (token != null) {
                setMediaSession(mediaStyle, (MediaSession.Token) token.f51k);
            }
            return mediaStyle;
        }

        @DoNotInline
        public static void setMediaSession(Notification.MediaStyle mediaStyle, MediaSession.Token token) {
            mediaStyle.setMediaSession(token);
        }

        @DoNotInline
        public static void setMediaStyle(Notification.Builder builder, Notification.MediaStyle mediaStyle) {
            builder.setStyle(mediaStyle);
        }

        @DoNotInline
        public static void setShowActionsInCompactView(Notification.MediaStyle mediaStyle, int... iArr) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static Notification.DecoratedMediaCustomViewStyle createDecoratedMediaCustomViewStyle() {
            return new Notification.DecoratedMediaCustomViewStyle();
        }
    }

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        private void setBackgroundColor(RemoteViews remoteViews) {
            remoteViews.setInt(C0499R.id.status_bar_latest_event_content, "setBackgroundColor", this.mBuilder.getColor() != 0 ? this.mBuilder.getColor() : this.mBuilder.mContext.getResources().getColor(C0499R.color.notification_material_background_media_default_color));
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                Api21Impl.setMediaStyle(notificationBuilderWithBuilderAccessor.getBuilder(), Api21Impl.fillInMediaStyle(Api24Impl.createDecoratedMediaCustomViewStyle(), this.mActionsToShowInCompact, this.mToken));
            } else {
                super.apply(notificationBuilderWithBuilderAccessor);
            }
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        public int getBigContentViewLayoutResource(int i) {
            return i <= 3 ? C0499R.layout.notification_template_big_media_narrow_custom : C0499R.layout.notification_template_big_media_custom;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        public int getContentViewLayoutResource() {
            return this.mBuilder.getContentView() != null ? C0499R.layout.notification_template_media_custom : super.getContentViewLayoutResource();
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.mBuilder.getBigContentView() != null ? this.mBuilder.getBigContentView() : this.mBuilder.getContentView();
            if (bigContentView == null) {
                return null;
            }
            RemoteViews remoteViewsGenerateBigContentView = generateBigContentView();
            buildIntoRemoteViews(remoteViewsGenerateBigContentView, bigContentView);
            setBackgroundColor(remoteViewsGenerateBigContentView);
            return remoteViewsGenerateBigContentView;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews remoteViewsGenerateContentView = null;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            boolean z2 = true;
            boolean z3 = this.mBuilder.getContentView() != null;
            if (!z3 && this.mBuilder.getBigContentView() == null) {
                z2 = false;
            }
            if (z2) {
                remoteViewsGenerateContentView = generateContentView();
                if (z3) {
                    buildIntoRemoteViews(remoteViewsGenerateContentView, this.mBuilder.getContentView());
                }
                setBackgroundColor(remoteViewsGenerateContentView);
            }
            return remoteViewsGenerateContentView;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews headsUpContentView = this.mBuilder.getHeadsUpContentView() != null ? this.mBuilder.getHeadsUpContentView() : this.mBuilder.getContentView();
            if (headsUpContentView == null) {
                return null;
            }
            RemoteViews remoteViewsGenerateBigContentView = generateBigContentView();
            buildIntoRemoteViews(remoteViewsGenerateBigContentView, headsUpContentView);
            setBackgroundColor(remoteViewsGenerateBigContentView);
            return remoteViewsGenerateBigContentView;
        }
    }

    private NotificationCompat() {
    }

    public static class MediaStyle extends NotificationCompat.Style {
        private static final int MAX_MEDIA_BUTTONS = 5;
        private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        public int[] mActionsToShowInCompact = null;
        public PendingIntent mCancelButtonIntent;
        public boolean mShowCancelButton;
        public MediaSessionCompat.Token mToken;

        public MediaStyle() {
        }

        private RemoteViews generateMediaActionButton(NotificationCompat.Action action) {
            boolean z2 = action.getActionIntent() == null;
            RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), C0499R.layout.notification_media_action);
            int i = C0499R.id.action0;
            remoteViews.setImageViewResource(i, action.getIcon());
            if (!z2) {
                remoteViews.setOnClickPendingIntent(i, action.getActionIntent());
            }
            Api15Impl.setContentDescription(remoteViews, i, action.getTitle());
            return remoteViews;
        }

        public static MediaSessionCompat.Token getMediaSession(Notification notification) {
            Parcelable parcelable;
            Bundle extras = androidx.core.app.NotificationCompat.getExtras(notification);
            if (extras == null || (parcelable = extras.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION)) == null) {
                return null;
            }
            return MediaSessionCompat.Token.m45a(parcelable, null);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Api21Impl.setMediaStyle(notificationBuilderWithBuilderAccessor.getBuilder(), Api21Impl.fillInMediaStyle(Api21Impl.createMediaStyle(), this.mActionsToShowInCompact, this.mToken));
        }

        public RemoteViews generateBigContentView() {
            int iMin = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews remoteViewsApplyStandardTemplate = applyStandardTemplate(false, getBigContentViewLayoutResource(iMin), false);
            remoteViewsApplyStandardTemplate.removeAllViews(C0499R.id.media_actions);
            if (iMin > 0) {
                for (int i = 0; i < iMin; i++) {
                    remoteViewsApplyStandardTemplate.addView(C0499R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(i)));
                }
            }
            if (this.mShowCancelButton) {
                int i2 = C0499R.id.cancel_action;
                remoteViewsApplyStandardTemplate.setViewVisibility(i2, 0);
                remoteViewsApplyStandardTemplate.setInt(i2, "setAlpha", this.mBuilder.mContext.getResources().getInteger(C0499R.integer.cancel_button_image_alpha));
                remoteViewsApplyStandardTemplate.setOnClickPendingIntent(i2, this.mCancelButtonIntent);
            } else {
                remoteViewsApplyStandardTemplate.setViewVisibility(C0499R.id.cancel_action, 8);
            }
            return remoteViewsApplyStandardTemplate;
        }

        public RemoteViews generateContentView() {
            RemoteViews remoteViewsApplyStandardTemplate = applyStandardTemplate(false, getContentViewLayoutResource(), true);
            int size = this.mBuilder.mActions.size();
            int[] iArr = this.mActionsToShowInCompact;
            int iMin = iArr == null ? 0 : Math.min(iArr.length, 3);
            remoteViewsApplyStandardTemplate.removeAllViews(C0499R.id.media_actions);
            if (iMin > 0) {
                for (int i = 0; i < iMin; i++) {
                    if (i >= size) {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i), Integer.valueOf(size - 1)));
                    }
                    remoteViewsApplyStandardTemplate.addView(C0499R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(this.mActionsToShowInCompact[i])));
                }
            }
            if (this.mShowCancelButton) {
                remoteViewsApplyStandardTemplate.setViewVisibility(C0499R.id.end_padder, 8);
                int i2 = C0499R.id.cancel_action;
                remoteViewsApplyStandardTemplate.setViewVisibility(i2, 0);
                remoteViewsApplyStandardTemplate.setOnClickPendingIntent(i2, this.mCancelButtonIntent);
                remoteViewsApplyStandardTemplate.setInt(i2, "setAlpha", this.mBuilder.mContext.getResources().getInteger(C0499R.integer.cancel_button_image_alpha));
            } else {
                remoteViewsApplyStandardTemplate.setViewVisibility(C0499R.id.end_padder, 0);
                remoteViewsApplyStandardTemplate.setViewVisibility(C0499R.id.cancel_action, 8);
            }
            return remoteViewsApplyStandardTemplate;
        }

        public int getBigContentViewLayoutResource(int i) {
            return i <= 3 ? C0499R.layout.notification_template_big_media_narrow : C0499R.layout.notification_template_big_media;
        }

        public int getContentViewLayoutResource() {
            return C0499R.layout.notification_template_media;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.mCancelButtonIntent = pendingIntent;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token token) {
            this.mToken = token;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.mActionsToShowInCompact = iArr;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean z2) {
            return this;
        }

        public MediaStyle(NotificationCompat.Builder builder) {
            setBuilder(builder);
        }
    }
}
