package androidx.media.app;

import android.os.Build$VERSION;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.media.R$color;
import androidx.media.R$id;
import androidx.media.R$layout;

/* JADX INFO: loaded from: classes.dex */
public class NotificationCompat$DecoratedMediaCustomViewStyle extends NotificationCompat$MediaStyle {
    private void setBackgroundColor(RemoteViews remoteViews) {
        remoteViews.setInt(R$id.status_bar_latest_event_content, "setBackgroundColor", this.mBuilder.getColor() != 0 ? this.mBuilder.getColor() : this.mBuilder.mContext.getResources().getColor(R$color.notification_material_background_media_default_color));
    }

    @Override // androidx.media.app.NotificationCompat$MediaStyle, androidx.core.app.NotificationCompat$Style
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build$VERSION.SDK_INT >= 24) {
            NotificationCompat$Api21Impl.setMediaStyle(notificationBuilderWithBuilderAccessor.getBuilder(), NotificationCompat$Api21Impl.fillInMediaStyle(NotificationCompat$Api24Impl.createDecoratedMediaCustomViewStyle(), this.mActionsToShowInCompact, this.mToken));
        } else {
            super.apply(notificationBuilderWithBuilderAccessor);
        }
    }

    @Override // androidx.media.app.NotificationCompat$MediaStyle
    public int getBigContentViewLayoutResource(int i) {
        return i <= 3 ? R$layout.notification_template_big_media_narrow_custom : R$layout.notification_template_big_media_custom;
    }

    @Override // androidx.media.app.NotificationCompat$MediaStyle
    public int getContentViewLayoutResource() {
        return this.mBuilder.getContentView() != null ? R$layout.notification_template_media_custom : super.getContentViewLayoutResource();
    }

    @Override // androidx.media.app.NotificationCompat$MediaStyle, androidx.core.app.NotificationCompat$Style
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build$VERSION.SDK_INT >= 24) {
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

    @Override // androidx.media.app.NotificationCompat$MediaStyle, androidx.core.app.NotificationCompat$Style
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        RemoteViews remoteViewsGenerateContentView = null;
        if (Build$VERSION.SDK_INT >= 24) {
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

    @Override // androidx.core.app.NotificationCompat$Style
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build$VERSION.SDK_INT >= 24) {
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
