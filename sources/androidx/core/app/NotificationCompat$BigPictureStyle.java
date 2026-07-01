package androidx.core.app;

import android.app.Notification$BigPictureStyle;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public class NotificationCompat$BigPictureStyle extends NotificationCompat$Style {
    private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigPictureStyle";
    private IconCompat mBigLargeIcon;
    private boolean mBigLargeIconSet;
    private Bitmap mPicture;

    public NotificationCompat$BigPictureStyle() {
    }

    @Nullable
    private static IconCompat asIconCompat(@Nullable Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        if (Build$VERSION.SDK_INT >= 23 && (parcelable instanceof Icon)) {
            return IconCompat.createFromIcon((Icon) parcelable);
        }
        if (parcelable instanceof Bitmap) {
            return IconCompat.createWithBitmap((Bitmap) parcelable);
        }
        return null;
    }

    @Override // androidx.core.app.NotificationCompat$Style
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        int i = Build$VERSION.SDK_INT;
        Notification$BigPictureStyle notification$BigPictureStyleBigPicture = new Notification$BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigPicture(this.mPicture);
        if (this.mBigLargeIconSet) {
            IconCompat iconCompat = this.mBigLargeIcon;
            if (iconCompat == null) {
                NotificationCompat$BigPictureStyle$Api16Impl.setBigLargeIcon(notification$BigPictureStyleBigPicture, null);
            } else if (i >= 23) {
                NotificationCompat$BigPictureStyle$Api23Impl.setBigLargeIcon(notification$BigPictureStyleBigPicture, this.mBigLargeIcon.toIcon(notificationBuilderWithBuilderAccessor instanceof NotificationCompatBuilder ? ((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).getContext() : null));
            } else if (iconCompat.getType() == 1) {
                NotificationCompat$BigPictureStyle$Api16Impl.setBigLargeIcon(notification$BigPictureStyleBigPicture, this.mBigLargeIcon.getBitmap());
            } else {
                NotificationCompat$BigPictureStyle$Api16Impl.setBigLargeIcon(notification$BigPictureStyleBigPicture, null);
            }
        }
        if (this.mSummaryTextSet) {
            NotificationCompat$BigPictureStyle$Api16Impl.setSummaryText(notification$BigPictureStyleBigPicture, this.mSummaryText);
        }
    }

    @NonNull
    public NotificationCompat$BigPictureStyle bigLargeIcon(@Nullable Bitmap bitmap) {
        this.mBigLargeIcon = bitmap == null ? null : IconCompat.createWithBitmap(bitmap);
        this.mBigLargeIconSet = true;
        return this;
    }

    @NonNull
    public NotificationCompat$BigPictureStyle bigPicture(@Nullable Bitmap bitmap) {
        this.mPicture = bitmap;
        return this;
    }

    @Override // androidx.core.app.NotificationCompat$Style
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void clearCompatExtraKeys(@NonNull Bundle bundle) {
        super.clearCompatExtraKeys(bundle);
        bundle.remove(NotificationCompat.EXTRA_LARGE_ICON_BIG);
        bundle.remove(NotificationCompat.EXTRA_PICTURE);
    }

    @Override // androidx.core.app.NotificationCompat$Style
    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public String getClassName() {
        return TEMPLATE_CLASS_NAME;
    }

    @Override // androidx.core.app.NotificationCompat$Style
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void restoreFromCompatExtras(@NonNull Bundle bundle) {
        super.restoreFromCompatExtras(bundle);
        if (bundle.containsKey(NotificationCompat.EXTRA_LARGE_ICON_BIG)) {
            this.mBigLargeIcon = asIconCompat(bundle.getParcelable(NotificationCompat.EXTRA_LARGE_ICON_BIG));
            this.mBigLargeIconSet = true;
        }
        this.mPicture = (Bitmap) bundle.getParcelable(NotificationCompat.EXTRA_PICTURE);
    }

    @NonNull
    public NotificationCompat$BigPictureStyle setBigContentTitle(@Nullable CharSequence charSequence) {
        this.mBigContentTitle = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    @NonNull
    public NotificationCompat$BigPictureStyle setSummaryText(@Nullable CharSequence charSequence) {
        this.mSummaryText = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        this.mSummaryTextSet = true;
        return this;
    }

    public NotificationCompat$BigPictureStyle(@Nullable NotificationCompat$Builder notificationCompat$Builder) {
        setBuilder(notificationCompat$Builder);
    }
}
