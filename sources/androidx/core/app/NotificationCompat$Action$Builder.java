package androidx.core.app;

import android.app.Notification$Action;
import android.app.PendingIntent;
import android.os.Build$VERSION;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationCompat$Action$Builder {
    private boolean mAllowGeneratedReplies;
    private final Bundle mExtras;
    private final IconCompat mIcon;
    private final PendingIntent mIntent;
    private boolean mIsContextual;
    private ArrayList<RemoteInput> mRemoteInputs;
    private int mSemanticAction;
    private boolean mShowsUserInterface;
    private final CharSequence mTitle;

    public NotificationCompat$Action$Builder(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
        this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false);
    }

    private void checkContextualActionNullFields() {
        if (this.mIsContextual) {
            Objects.requireNonNull(this.mIntent, "Contextual Actions must contain a valid PendingIntent");
        }
    }

    @NonNull
    @RequiresApi(19)
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public static NotificationCompat$Action$Builder fromAndroidAction(@NonNull Notification$Action notification$Action) {
        NotificationCompat$Action$Builder notificationCompat$Action$Builder = (Build$VERSION.SDK_INT < 23 || notification$Action.getIcon() == null) ? new NotificationCompat$Action$Builder(notification$Action.icon, notification$Action.title, notification$Action.actionIntent) : new NotificationCompat$Action$Builder(IconCompat.createFromIcon(notification$Action.getIcon()), notification$Action.title, notification$Action.actionIntent);
        android.app.RemoteInput[] remoteInputs = notification$Action.getRemoteInputs();
        if (remoteInputs != null && remoteInputs.length != 0) {
            for (android.app.RemoteInput remoteInput : remoteInputs) {
                notificationCompat$Action$Builder.addRemoteInput(RemoteInput.fromPlatform(remoteInput));
            }
        }
        int i = Build$VERSION.SDK_INT;
        if (i >= 24) {
            notificationCompat$Action$Builder.mAllowGeneratedReplies = notification$Action.getAllowGeneratedReplies();
        }
        if (i >= 28) {
            notificationCompat$Action$Builder.setSemanticAction(notification$Action.getSemanticAction());
        }
        if (i >= 29) {
            notificationCompat$Action$Builder.setContextual(notification$Action.isContextual());
        }
        return notificationCompat$Action$Builder;
    }

    @NonNull
    public NotificationCompat$Action$Builder addExtras(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.mExtras.putAll(bundle);
        }
        return this;
    }

    @NonNull
    public NotificationCompat$Action$Builder addRemoteInput(@Nullable RemoteInput remoteInput) {
        if (this.mRemoteInputs == null) {
            this.mRemoteInputs = new ArrayList<>();
        }
        if (remoteInput != null) {
            this.mRemoteInputs.add(remoteInput);
        }
        return this;
    }

    @NonNull
    public NotificationCompat$Action build() {
        checkContextualActionNullFields();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<RemoteInput> arrayList3 = this.mRemoteInputs;
        if (arrayList3 != null) {
            for (RemoteInput remoteInput : arrayList3) {
                if (remoteInput.isDataOnly()) {
                    arrayList.add(remoteInput);
                } else {
                    arrayList2.add(remoteInput);
                }
            }
        }
        RemoteInput[] remoteInputArr = arrayList.isEmpty() ? null : (RemoteInput[]) arrayList.toArray(new RemoteInput[arrayList.size()]);
        return new NotificationCompat$Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, arrayList2.isEmpty() ? null : (RemoteInput[]) arrayList2.toArray(new RemoteInput[arrayList2.size()]), remoteInputArr, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface, this.mIsContextual);
    }

    @NonNull
    public NotificationCompat$Action$Builder extend(@NonNull NotificationCompat$Action$Extender notificationCompat$Action$Extender) {
        notificationCompat$Action$Extender.extend(this);
        return this;
    }

    @NonNull
    public Bundle getExtras() {
        return this.mExtras;
    }

    @NonNull
    public NotificationCompat$Action$Builder setAllowGeneratedReplies(boolean z2) {
        this.mAllowGeneratedReplies = z2;
        return this;
    }

    @NonNull
    public NotificationCompat$Action$Builder setContextual(boolean z2) {
        this.mIsContextual = z2;
        return this;
    }

    @NonNull
    public NotificationCompat$Action$Builder setSemanticAction(int i) {
        this.mSemanticAction = i;
        return this;
    }

    @NonNull
    public NotificationCompat$Action$Builder setShowsUserInterface(boolean z2) {
        this.mShowsUserInterface = z2;
        return this;
    }

    public NotificationCompat$Action$Builder(int i, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
        this(i != 0 ? IconCompat.createWithResource(null, "", i) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false);
    }

    public NotificationCompat$Action$Builder(@NonNull NotificationCompat$Action notificationCompat$Action) {
        this(notificationCompat$Action.getIconCompat(), notificationCompat$Action.title, notificationCompat$Action.actionIntent, new Bundle(notificationCompat$Action.mExtras), notificationCompat$Action.getRemoteInputs(), notificationCompat$Action.getAllowGeneratedReplies(), notificationCompat$Action.getSemanticAction(), notificationCompat$Action.mShowsUserInterface, notificationCompat$Action.isContextual());
    }

    private NotificationCompat$Action$Builder(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent, @NonNull Bundle bundle, @Nullable RemoteInput[] remoteInputArr, boolean z2, int i, boolean z3, boolean z4) {
        this.mAllowGeneratedReplies = true;
        this.mShowsUserInterface = true;
        this.mIcon = iconCompat;
        this.mTitle = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        this.mIntent = pendingIntent;
        this.mExtras = bundle;
        this.mRemoteInputs = remoteInputArr == null ? null : new ArrayList<>(Arrays.asList(remoteInputArr));
        this.mAllowGeneratedReplies = z2;
        this.mSemanticAction = i;
        this.mShowsUserInterface = z3;
        this.mIsContextual = z4;
    }
}
