package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationCompat$CarExtender implements NotificationCompat$Extender {

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
    private static final String EXTRA_COLOR = "app_color";
    private static final String EXTRA_CONVERSATION = "car_conversation";

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
    private static final String EXTRA_LARGE_ICON = "large_icon";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_MESSAGES = "messages";
    private static final String KEY_ON_READ = "on_read";
    private static final String KEY_ON_REPLY = "on_reply";
    private static final String KEY_PARTICIPANTS = "participants";
    private static final String KEY_REMOTE_INPUT = "remote_input";
    private static final String KEY_TEXT = "text";
    private static final String KEY_TIMESTAMP = "timestamp";
    private int mColor;
    private Bitmap mLargeIcon;
    private NotificationCompat$CarExtender$UnreadConversation mUnreadConversation;

    public NotificationCompat$CarExtender() {
        this.mColor = 0;
    }

    @RequiresApi(21)
    private static Bundle getBundleForUnreadConversation(@NonNull NotificationCompat$CarExtender$UnreadConversation notificationCompat$CarExtender$UnreadConversation) {
        Bundle bundle = new Bundle();
        String str = (notificationCompat$CarExtender$UnreadConversation.getParticipants() == null || notificationCompat$CarExtender$UnreadConversation.getParticipants().length <= 1) ? null : notificationCompat$CarExtender$UnreadConversation.getParticipants()[0];
        int length = notificationCompat$CarExtender$UnreadConversation.getMessages().length;
        Parcelable[] parcelableArr = new Parcelable[length];
        for (int i = 0; i < length; i++) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("text", notificationCompat$CarExtender$UnreadConversation.getMessages()[i]);
            bundle2.putString(KEY_AUTHOR, str);
            parcelableArr[i] = bundle2;
        }
        bundle.putParcelableArray(KEY_MESSAGES, parcelableArr);
        RemoteInput remoteInput = notificationCompat$CarExtender$UnreadConversation.getRemoteInput();
        if (remoteInput != null) {
            bundle.putParcelable(KEY_REMOTE_INPUT, new android.app.RemoteInput$Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build());
        }
        bundle.putParcelable(KEY_ON_REPLY, notificationCompat$CarExtender$UnreadConversation.getReplyPendingIntent());
        bundle.putParcelable(KEY_ON_READ, notificationCompat$CarExtender$UnreadConversation.getReadPendingIntent());
        bundle.putStringArray(KEY_PARTICIPANTS, notificationCompat$CarExtender$UnreadConversation.getParticipants());
        bundle.putLong(KEY_TIMESTAMP, notificationCompat$CarExtender$UnreadConversation.getLatestTimestamp());
        return bundle;
    }

    @RequiresApi(21)
    private static NotificationCompat$CarExtender$UnreadConversation getUnreadConversationFromBundle(@Nullable Bundle bundle) {
        String[] strArr;
        boolean z2;
        RemoteInput remoteInput = null;
        if (bundle == null) {
            return null;
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray(KEY_MESSAGES);
        if (parcelableArray != null) {
            int length = parcelableArray.length;
            String[] strArr2 = new String[length];
            int i = 0;
            while (true) {
                if (i >= length) {
                    z2 = true;
                    break;
                }
                if (parcelableArray[i] instanceof Bundle) {
                    strArr2[i] = ((Bundle) parcelableArray[i]).getString("text");
                    if (strArr2[i] != null) {
                        i++;
                    }
                }
                z2 = false;
                break;
            }
            if (!z2) {
                return null;
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(KEY_ON_READ);
        PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable(KEY_ON_REPLY);
        android.app.RemoteInput remoteInput2 = (android.app.RemoteInput) bundle.getParcelable(KEY_REMOTE_INPUT);
        String[] stringArray = bundle.getStringArray(KEY_PARTICIPANTS);
        if (stringArray == null || stringArray.length != 1) {
            return null;
        }
        if (remoteInput2 != null) {
            remoteInput = new RemoteInput(remoteInput2.getResultKey(), remoteInput2.getLabel(), remoteInput2.getChoices(), remoteInput2.getAllowFreeFormInput(), Build$VERSION.SDK_INT >= 29 ? remoteInput2.getEditChoicesBeforeSending() : 0, remoteInput2.getExtras(), null);
        }
        return new NotificationCompat$CarExtender$UnreadConversation(strArr, remoteInput, pendingIntent2, pendingIntent, stringArray, bundle.getLong(KEY_TIMESTAMP));
    }

    @Override // androidx.core.app.NotificationCompat$Extender
    @NonNull
    public NotificationCompat$Builder extend(@NonNull NotificationCompat$Builder notificationCompat$Builder) {
        Bundle bundle = new Bundle();
        Bitmap bitmap = this.mLargeIcon;
        if (bitmap != null) {
            bundle.putParcelable(EXTRA_LARGE_ICON, bitmap);
        }
        int i = this.mColor;
        if (i != 0) {
            bundle.putInt(EXTRA_COLOR, i);
        }
        NotificationCompat$CarExtender$UnreadConversation notificationCompat$CarExtender$UnreadConversation = this.mUnreadConversation;
        if (notificationCompat$CarExtender$UnreadConversation != null) {
            bundle.putBundle(EXTRA_CONVERSATION, getBundleForUnreadConversation(notificationCompat$CarExtender$UnreadConversation));
        }
        notificationCompat$Builder.getExtras().putBundle(EXTRA_CAR_EXTENDER, bundle);
        return notificationCompat$Builder;
    }

    @ColorInt
    public int getColor() {
        return this.mColor;
    }

    @Nullable
    public Bitmap getLargeIcon() {
        return this.mLargeIcon;
    }

    @Nullable
    @Deprecated
    public NotificationCompat$CarExtender$UnreadConversation getUnreadConversation() {
        return this.mUnreadConversation;
    }

    @NonNull
    public NotificationCompat$CarExtender setColor(@ColorInt int i) {
        this.mColor = i;
        return this;
    }

    @NonNull
    public NotificationCompat$CarExtender setLargeIcon(@Nullable Bitmap bitmap) {
        this.mLargeIcon = bitmap;
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$CarExtender setUnreadConversation(@Nullable NotificationCompat$CarExtender$UnreadConversation notificationCompat$CarExtender$UnreadConversation) {
        this.mUnreadConversation = notificationCompat$CarExtender$UnreadConversation;
        return this;
    }

    public NotificationCompat$CarExtender(@NonNull Notification notification) {
        this.mColor = 0;
        Bundle bundle = NotificationCompat.getExtras(notification) == null ? null : NotificationCompat.getExtras(notification).getBundle(EXTRA_CAR_EXTENDER);
        if (bundle != null) {
            this.mLargeIcon = (Bitmap) bundle.getParcelable(EXTRA_LARGE_ICON);
            this.mColor = bundle.getInt(EXTRA_COLOR, 0);
            this.mUnreadConversation = getUnreadConversationFromBundle(bundle.getBundle(EXTRA_CONVERSATION));
        }
    }
}
