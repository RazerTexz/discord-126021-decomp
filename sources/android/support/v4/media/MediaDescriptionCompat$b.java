package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription$Builder;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class MediaDescriptionCompat$b {
    @DoNotInline
    public static MediaDescription a(MediaDescription$Builder mediaDescription$Builder) {
        return mediaDescription$Builder.build();
    }

    @DoNotInline
    public static MediaDescription$Builder b() {
        return new MediaDescription$Builder();
    }

    @Nullable
    @DoNotInline
    public static CharSequence c(MediaDescription mediaDescription) {
        return mediaDescription.getDescription();
    }

    @Nullable
    @DoNotInline
    public static Bundle d(MediaDescription mediaDescription) {
        return mediaDescription.getExtras();
    }

    @Nullable
    @DoNotInline
    public static Bitmap e(MediaDescription mediaDescription) {
        return mediaDescription.getIconBitmap();
    }

    @Nullable
    @DoNotInline
    public static Uri f(MediaDescription mediaDescription) {
        return mediaDescription.getIconUri();
    }

    @Nullable
    @DoNotInline
    public static String g(MediaDescription mediaDescription) {
        return mediaDescription.getMediaId();
    }

    @Nullable
    @DoNotInline
    public static CharSequence h(MediaDescription mediaDescription) {
        return mediaDescription.getSubtitle();
    }

    @Nullable
    @DoNotInline
    public static CharSequence i(MediaDescription mediaDescription) {
        return mediaDescription.getTitle();
    }

    @DoNotInline
    public static void j(MediaDescription$Builder mediaDescription$Builder, @Nullable CharSequence charSequence) {
        mediaDescription$Builder.setDescription(charSequence);
    }

    @DoNotInline
    public static void k(MediaDescription$Builder mediaDescription$Builder, @Nullable Bundle bundle) {
        mediaDescription$Builder.setExtras(bundle);
    }

    @DoNotInline
    public static void l(MediaDescription$Builder mediaDescription$Builder, @Nullable Bitmap bitmap) {
        mediaDescription$Builder.setIconBitmap(bitmap);
    }

    @DoNotInline
    public static void m(MediaDescription$Builder mediaDescription$Builder, @Nullable Uri uri) {
        mediaDescription$Builder.setIconUri(uri);
    }

    @DoNotInline
    public static void n(MediaDescription$Builder mediaDescription$Builder, @Nullable String str) {
        mediaDescription$Builder.setMediaId(str);
    }

    @DoNotInline
    public static void o(MediaDescription$Builder mediaDescription$Builder, @Nullable CharSequence charSequence) {
        mediaDescription$Builder.setSubtitle(charSequence);
    }

    @DoNotInline
    public static void p(MediaDescription$Builder mediaDescription$Builder, @Nullable CharSequence charSequence) {
        mediaDescription$Builder.setTitle(charSequence);
    }
}
