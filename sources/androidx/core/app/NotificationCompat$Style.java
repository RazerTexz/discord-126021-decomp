package androidx.core.app;

import android.app.Notification;
import android.app.Notification$BigPictureStyle;
import android.app.Notification$BigTextStyle;
import android.app.Notification$DecoratedCustomViewStyle;
import android.app.Notification$InboxStyle;
import android.app.Notification$MessagingStyle;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.R$dimen;
import androidx.core.R$drawable;
import androidx.core.R$id;
import androidx.core.R$integer;
import androidx.core.R$string;
import androidx.core.graphics.drawable.IconCompat;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationCompat$Style {
    public CharSequence mBigContentTitle;

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public NotificationCompat$Builder mBuilder;
    public CharSequence mSummaryText;
    public boolean mSummaryTextSet = false;

    private int calculateTopPadding() {
        Resources resources = this.mBuilder.mContext.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.notification_top_pad);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.notification_top_pad_large_text);
        float fConstrain = (constrain(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
        return Math.round((fConstrain * dimensionPixelSize2) + ((1.0f - fConstrain) * dimensionPixelSize));
    }

    private static float constrain(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        return f > f3 ? f3 : f;
    }

    @Nullable
    public static NotificationCompat$Style constructCompatStyleByName(@Nullable String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle":
                return new NotificationCompat$DecoratedCustomViewStyle();
            case "androidx.core.app.NotificationCompat$BigPictureStyle":
                return new NotificationCompat$BigPictureStyle();
            case "androidx.core.app.NotificationCompat$InboxStyle":
                return new NotificationCompat$InboxStyle();
            case "androidx.core.app.NotificationCompat$BigTextStyle":
                return new NotificationCompat$BigTextStyle();
            case "androidx.core.app.NotificationCompat$MessagingStyle":
                return new NotificationCompat$MessagingStyle();
            default:
                return null;
        }
    }

    @Nullable
    private static NotificationCompat$Style constructCompatStyleByPlatformName(@Nullable String str) {
        if (str == null) {
            return null;
        }
        int i = Build$VERSION.SDK_INT;
        if (str.equals(Notification$BigPictureStyle.class.getName())) {
            return new NotificationCompat$BigPictureStyle();
        }
        if (str.equals(Notification$BigTextStyle.class.getName())) {
            return new NotificationCompat$BigTextStyle();
        }
        if (str.equals(Notification$InboxStyle.class.getName())) {
            return new NotificationCompat$InboxStyle();
        }
        if (i >= 24) {
            if (str.equals(Notification$MessagingStyle.class.getName())) {
                return new NotificationCompat$MessagingStyle();
            }
            if (str.equals(Notification$DecoratedCustomViewStyle.class.getName())) {
                return new NotificationCompat$DecoratedCustomViewStyle();
            }
        }
        return null;
    }

    @Nullable
    public static NotificationCompat$Style constructCompatStyleForBundle(@NonNull Bundle bundle) {
        NotificationCompat$Style notificationCompat$StyleConstructCompatStyleByName = constructCompatStyleByName(bundle.getString(NotificationCompat.EXTRA_COMPAT_TEMPLATE));
        if (notificationCompat$StyleConstructCompatStyleByName != null) {
            return notificationCompat$StyleConstructCompatStyleByName;
        }
        if (bundle.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME) || bundle.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) {
            return new NotificationCompat$MessagingStyle();
        }
        if (bundle.containsKey(NotificationCompat.EXTRA_PICTURE)) {
            return new NotificationCompat$BigPictureStyle();
        }
        if (bundle.containsKey(NotificationCompat.EXTRA_BIG_TEXT)) {
            return new NotificationCompat$BigTextStyle();
        }
        return bundle.containsKey(NotificationCompat.EXTRA_TEXT_LINES) ? new NotificationCompat$InboxStyle() : constructCompatStyleByPlatformName(bundle.getString(NotificationCompat.EXTRA_TEMPLATE));
    }

    @Nullable
    public static NotificationCompat$Style constructStyleForExtras(@NonNull Bundle bundle) {
        NotificationCompat$Style notificationCompat$StyleConstructCompatStyleForBundle = constructCompatStyleForBundle(bundle);
        if (notificationCompat$StyleConstructCompatStyleForBundle == null) {
            return null;
        }
        try {
            notificationCompat$StyleConstructCompatStyleForBundle.restoreFromCompatExtras(bundle);
            return notificationCompat$StyleConstructCompatStyleForBundle;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    private Bitmap createIconWithBackground(int i, int i2, int i3, int i4) {
        int i5 = R$drawable.notification_icon_background;
        if (i4 == 0) {
            i4 = 0;
        }
        Bitmap bitmapCreateColoredBitmap = createColoredBitmap(i5, i4, i2);
        Canvas canvas = new Canvas(bitmapCreateColoredBitmap);
        Drawable drawableMutate = this.mBuilder.mContext.getResources().getDrawable(i).mutate();
        drawableMutate.setFilterBitmap(true);
        int i6 = (i2 - i3) / 2;
        int i7 = i3 + i6;
        drawableMutate.setBounds(i6, i6, i7, i7);
        drawableMutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff$Mode.SRC_ATOP));
        drawableMutate.draw(canvas);
        return bitmapCreateColoredBitmap;
    }

    @Nullable
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public static NotificationCompat$Style extractStyleFromNotification(@NonNull Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        if (extras == null) {
            return null;
        }
        return constructStyleForExtras(extras);
    }

    private void hideNormalContent(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R$id.title, 8);
        remoteViews.setViewVisibility(R$id.text2, 8);
        remoteViews.setViewVisibility(R$id.text, 8);
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void addCompatExtras(@NonNull Bundle bundle) {
        if (this.mSummaryTextSet) {
            bundle.putCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT, this.mSummaryText);
        }
        CharSequence charSequence = this.mBigContentTitle;
        if (charSequence != null) {
            bundle.putCharSequence(NotificationCompat.EXTRA_TITLE_BIG, charSequence);
        }
        String className = getClassName();
        if (className != null) {
            bundle.putString(NotificationCompat.EXTRA_COMPAT_TEMPLATE, className);
        }
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0100  */
    /* JADX WARN: Code duplicated, block: B:36:0x010b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0115  */
    /* JADX WARN: Code duplicated, block: B:38:0x011a  */
    /* JADX WARN: Code duplicated, block: B:40:0x011d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x011f  */
    /* JADX WARN: Code duplicated, block: B:45:0x0141  */
    /* JADX WARN: Code duplicated, block: B:47:0x0147  */
    /* JADX WARN: Code duplicated, block: B:52:0x0176  */
    /* JADX WARN: Code duplicated, block: B:53:0x0188  */
    /* JADX WARN: Code duplicated, block: B:56:0x018d  */
    /* JADX WARN: Code duplicated, block: B:57:0x018f  */
    /* JADX WARN: Code duplicated, block: B:61:0x0199  */
    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews applyStandardTemplate(boolean z2, int i, boolean z3) {
        boolean z4;
        boolean z5;
        CharSequence charSequence;
        boolean z6;
        int i2;
        int i3;
        boolean z7;
        CharSequence charSequence2;
        Resources resources = this.mBuilder.mContext.getResources();
        RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), i);
        this.mBuilder.getPriority();
        int i4 = Build$VERSION.SDK_INT;
        NotificationCompat$Builder notificationCompat$Builder = this.mBuilder;
        if (notificationCompat$Builder.mLargeIcon != null) {
            int i5 = R$id.icon;
            remoteViews.setViewVisibility(i5, 0);
            remoteViews.setImageViewBitmap(i5, this.mBuilder.mLargeIcon);
            if (z2 && this.mBuilder.mNotification.icon != 0) {
                int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.notification_right_icon_size);
                int dimensionPixelSize2 = dimensionPixelSize - (resources.getDimensionPixelSize(R$dimen.notification_small_icon_background_padding) * 2);
                NotificationCompat$Builder notificationCompat$Builder2 = this.mBuilder;
                Bitmap bitmapCreateIconWithBackground = createIconWithBackground(notificationCompat$Builder2.mNotification.icon, dimensionPixelSize, dimensionPixelSize2, notificationCompat$Builder2.getColor());
                int i6 = R$id.right_icon;
                remoteViews.setImageViewBitmap(i6, bitmapCreateIconWithBackground);
                remoteViews.setViewVisibility(i6, 0);
            }
        } else if (z2 && notificationCompat$Builder.mNotification.icon != 0) {
            int i7 = R$id.icon;
            remoteViews.setViewVisibility(i7, 0);
            int dimensionPixelSize3 = resources.getDimensionPixelSize(R$dimen.notification_large_icon_width) - resources.getDimensionPixelSize(R$dimen.notification_big_circle_margin);
            int dimensionPixelSize4 = resources.getDimensionPixelSize(R$dimen.notification_small_icon_size_as_large);
            NotificationCompat$Builder notificationCompat$Builder3 = this.mBuilder;
            remoteViews.setImageViewBitmap(i7, createIconWithBackground(notificationCompat$Builder3.mNotification.icon, dimensionPixelSize3, dimensionPixelSize4, notificationCompat$Builder3.getColor()));
        }
        CharSequence charSequence3 = this.mBuilder.mContentTitle;
        if (charSequence3 != null) {
            remoteViews.setTextViewText(R$id.title, charSequence3);
        }
        CharSequence charSequence4 = this.mBuilder.mContentText;
        boolean z8 = true;
        if (charSequence4 != null) {
            remoteViews.setTextViewText(R$id.text, charSequence4);
            z4 = true;
        } else {
            z4 = false;
        }
        NotificationCompat$Builder notificationCompat$Builder4 = this.mBuilder;
        CharSequence charSequence5 = notificationCompat$Builder4.mContentInfo;
        if (charSequence5 == null) {
            if (notificationCompat$Builder4.mNumber > 0) {
                if (this.mBuilder.mNumber > resources.getInteger(R$integer.status_bar_notification_info_maxnum)) {
                    remoteViews.setTextViewText(R$id.info, resources.getString(R$string.status_bar_notification_info_overflow));
                } else {
                    remoteViews.setTextViewText(R$id.info, NumberFormat.getIntegerInstance().format(this.mBuilder.mNumber));
                }
                remoteViews.setViewVisibility(R$id.info, 0);
            } else {
                remoteViews.setViewVisibility(R$id.info, 8);
                z5 = false;
            }
            charSequence = this.mBuilder.mSubText;
            if (charSequence != null) {
                remoteViews.setTextViewText(R$id.text, charSequence);
                charSequence2 = this.mBuilder.mContentText;
                if (charSequence2 != null) {
                    int i8 = R$id.text2;
                    remoteViews.setTextViewText(i8, charSequence2);
                    remoteViews.setViewVisibility(i8, 0);
                    z6 = true;
                } else {
                    remoteViews.setViewVisibility(R$id.text2, 8);
                    z6 = false;
                }
            } else {
                z6 = false;
            }
            if (z6) {
                if (z3) {
                    remoteViews.setTextViewTextSize(R$id.text, 0, resources.getDimensionPixelSize(R$dimen.notification_subtext_size));
                }
                remoteViews.setViewPadding(R$id.line1, 0, 0, 0, 0);
            }
            if (this.mBuilder.getWhenIfShowing() != 0) {
                z8 = z5;
            } else if (this.mBuilder.mUseChronometer) {
                i3 = R$id.chronometer;
                remoteViews.setViewVisibility(i3, 0);
                remoteViews.setLong(i3, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + this.mBuilder.getWhenIfShowing());
                remoteViews.setBoolean(i3, "setStarted", true);
                z7 = this.mBuilder.mChronometerCountDown;
                if (z7 && i4 >= 24) {
                    remoteViews.setChronometerCountDown(i3, z7);
                }
            } else {
                int i9 = R$id.time;
                remoteViews.setViewVisibility(i9, 0);
                remoteViews.setLong(i9, "setTime", this.mBuilder.getWhenIfShowing());
            }
            int i10 = R$id.right_side;
            if (z8) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            remoteViews.setViewVisibility(i10, i2);
            remoteViews.setViewVisibility(R$id.line3, z4 ? 0 : 8);
            return remoteViews;
        }
        int i11 = R$id.info;
        remoteViews.setTextViewText(i11, charSequence5);
        remoteViews.setViewVisibility(i11, 0);
        z4 = true;
        z5 = true;
        charSequence = this.mBuilder.mSubText;
        if (charSequence != null) {
            remoteViews.setTextViewText(R$id.text, charSequence);
            charSequence2 = this.mBuilder.mContentText;
            if (charSequence2 != null) {
                int i12 = R$id.text2;
                remoteViews.setTextViewText(i12, charSequence2);
                remoteViews.setViewVisibility(i12, 0);
                z6 = true;
            } else {
                remoteViews.setViewVisibility(R$id.text2, 8);
                z6 = false;
            }
        } else {
            z6 = false;
        }
        if (z6) {
            if (z3) {
                remoteViews.setTextViewTextSize(R$id.text, 0, resources.getDimensionPixelSize(R$dimen.notification_subtext_size));
            }
            remoteViews.setViewPadding(R$id.line1, 0, 0, 0, 0);
        }
        if (this.mBuilder.getWhenIfShowing() != 0) {
            z8 = z5;
        } else if (this.mBuilder.mUseChronometer) {
            i3 = R$id.chronometer;
            remoteViews.setViewVisibility(i3, 0);
            remoteViews.setLong(i3, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + this.mBuilder.getWhenIfShowing());
            remoteViews.setBoolean(i3, "setStarted", true);
            z7 = this.mBuilder.mChronometerCountDown;
            if (z7) {
                remoteViews.setChronometerCountDown(i3, z7);
            }
        } else {
            int i13 = R$id.time;
            remoteViews.setViewVisibility(i13, 0);
            remoteViews.setLong(i13, "setTime", this.mBuilder.getWhenIfShowing());
        }
        int i14 = R$id.right_side;
        if (z8) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        remoteViews.setViewVisibility(i14, i2);
        remoteViews.setViewVisibility(R$id.line3, z4 ? 0 : 8);
        return remoteViews;
    }

    @Nullable
    public Notification build() {
        NotificationCompat$Builder notificationCompat$Builder = this.mBuilder;
        if (notificationCompat$Builder != null) {
            return notificationCompat$Builder.build();
        }
        return null;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void buildIntoRemoteViews(RemoteViews remoteViews, RemoteViews remoteViews2) {
        hideNormalContent(remoteViews);
        int i = R$id.notification_main_column;
        remoteViews.removeAllViews(i);
        remoteViews.addView(i, remoteViews2.clone());
        remoteViews.setViewVisibility(i, 0);
        remoteViews.setViewPadding(R$id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void clearCompatExtraKeys(@NonNull Bundle bundle) {
        bundle.remove(NotificationCompat.EXTRA_SUMMARY_TEXT);
        bundle.remove(NotificationCompat.EXTRA_TITLE_BIG);
        bundle.remove(NotificationCompat.EXTRA_COMPAT_TEMPLATE);
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public Bitmap createColoredBitmap(int i, int i2) {
        return createColoredBitmap(i, i2, 0);
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public boolean displayCustomViewInline() {
        return false;
    }

    @Nullable
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public String getClassName() {
        return null;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        return null;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        return null;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        return null;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void restoreFromCompatExtras(@NonNull Bundle bundle) {
        if (bundle.containsKey(NotificationCompat.EXTRA_SUMMARY_TEXT)) {
            this.mSummaryText = bundle.getCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT);
            this.mSummaryTextSet = true;
        }
        this.mBigContentTitle = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
    }

    public void setBuilder(@Nullable NotificationCompat$Builder notificationCompat$Builder) {
        if (this.mBuilder != notificationCompat$Builder) {
            this.mBuilder = notificationCompat$Builder;
            if (notificationCompat$Builder != null) {
                notificationCompat$Builder.setStyle(this);
            }
        }
    }

    public Bitmap createColoredBitmap(@NonNull IconCompat iconCompat, int i) {
        return createColoredBitmap(iconCompat, i, 0);
    }

    private Bitmap createColoredBitmap(int i, int i2, int i3) {
        return createColoredBitmap(IconCompat.createWithResource(this.mBuilder.mContext, i), i2, i3);
    }

    private Bitmap createColoredBitmap(@NonNull IconCompat iconCompat, int i, int i2) {
        Drawable drawableLoadDrawable = iconCompat.loadDrawable(this.mBuilder.mContext);
        int intrinsicWidth = i2 == 0 ? drawableLoadDrawable.getIntrinsicWidth() : i2;
        if (i2 == 0) {
            i2 = drawableLoadDrawable.getIntrinsicHeight();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, i2, Bitmap$Config.ARGB_8888);
        drawableLoadDrawable.setBounds(0, 0, intrinsicWidth, i2);
        if (i != 0) {
            drawableLoadDrawable.mutate().setColorFilter(new PorterDuffColorFilter(i, PorterDuff$Mode.SRC_IN));
        }
        drawableLoadDrawable.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }
}
