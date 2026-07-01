package androidx.core.app;

import android.app.Notification$DecoratedCustomViewStyle;
import android.os.Build$VERSION;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.R$color;
import androidx.core.R$id;
import androidx.core.R$layout;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NotificationCompat$DecoratedCustomViewStyle extends NotificationCompat$Style {
    private static final int MAX_ACTION_BUTTONS = 3;
    private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";

    private RemoteViews createRemoteViews(RemoteViews remoteViews, boolean z2) {
        int iMin;
        boolean z3 = true;
        RemoteViews remoteViewsApplyStandardTemplate = applyStandardTemplate(true, R$layout.notification_template_custom_big, false);
        remoteViewsApplyStandardTemplate.removeAllViews(R$id.actions);
        List<NotificationCompat$Action> nonContextualActions = getNonContextualActions(this.mBuilder.mActions);
        if (!z2 || nonContextualActions == null || (iMin = Math.min(nonContextualActions.size(), 3)) <= 0) {
            z3 = false;
        } else {
            for (int i = 0; i < iMin; i++) {
                remoteViewsApplyStandardTemplate.addView(R$id.actions, generateActionButton(nonContextualActions.get(i)));
            }
        }
        int i2 = z3 ? 0 : 8;
        remoteViewsApplyStandardTemplate.setViewVisibility(R$id.actions, i2);
        remoteViewsApplyStandardTemplate.setViewVisibility(R$id.action_divider, i2);
        buildIntoRemoteViews(remoteViewsApplyStandardTemplate, remoteViews);
        return remoteViewsApplyStandardTemplate;
    }

    private RemoteViews generateActionButton(NotificationCompat$Action notificationCompat$Action) {
        boolean z2 = notificationCompat$Action.actionIntent == null;
        RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), z2 ? R$layout.notification_action_tombstone : R$layout.notification_action);
        IconCompat iconCompat = notificationCompat$Action.getIconCompat();
        if (iconCompat != null) {
            remoteViews.setImageViewBitmap(R$id.action_image, createColoredBitmap(iconCompat, this.mBuilder.mContext.getResources().getColor(R$color.notification_action_color_filter)));
        }
        remoteViews.setTextViewText(R$id.action_text, notificationCompat$Action.title);
        if (!z2) {
            remoteViews.setOnClickPendingIntent(R$id.action_container, notificationCompat$Action.actionIntent);
        }
        remoteViews.setContentDescription(R$id.action_container, notificationCompat$Action.title);
        return remoteViews;
    }

    private static List<NotificationCompat$Action> getNonContextualActions(List<NotificationCompat$Action> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NotificationCompat$Action notificationCompat$Action : list) {
            if (!notificationCompat$Action.isContextual()) {
                arrayList.add(notificationCompat$Action);
            }
        }
        return arrayList;
    }

    @Override // androidx.core.app.NotificationCompat$Style
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build$VERSION.SDK_INT >= 24) {
            notificationBuilderWithBuilderAccessor.getBuilder().setStyle(new Notification$DecoratedCustomViewStyle());
        }
    }

    @Override // androidx.core.app.NotificationCompat$Style
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public boolean displayCustomViewInline() {
        return true;
    }

    @Override // androidx.core.app.NotificationCompat$Style
    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public String getClassName() {
        return TEMPLATE_CLASS_NAME;
    }

    @Override // androidx.core.app.NotificationCompat$Style
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build$VERSION.SDK_INT >= 24) {
            return null;
        }
        RemoteViews bigContentView = this.mBuilder.getBigContentView();
        if (bigContentView == null) {
            bigContentView = this.mBuilder.getContentView();
        }
        if (bigContentView == null) {
            return null;
        }
        return createRemoteViews(bigContentView, true);
    }

    @Override // androidx.core.app.NotificationCompat$Style
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build$VERSION.SDK_INT < 24 && this.mBuilder.getContentView() != null) {
            return createRemoteViews(this.mBuilder.getContentView(), false);
        }
        return null;
    }

    @Override // androidx.core.app.NotificationCompat$Style
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build$VERSION.SDK_INT >= 24) {
            return null;
        }
        RemoteViews headsUpContentView = this.mBuilder.getHeadsUpContentView();
        RemoteViews contentView = headsUpContentView != null ? headsUpContentView : this.mBuilder.getContentView();
        if (headsUpContentView == null) {
            return null;
        }
        return createRemoteViews(contentView, true);
    }
}
