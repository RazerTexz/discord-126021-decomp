package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new C0015a();

    /* JADX INFO: renamed from: j */
    public final String f27j;

    /* JADX INFO: renamed from: k */
    public final CharSequence f28k;

    /* JADX INFO: renamed from: l */
    public final CharSequence f29l;

    /* JADX INFO: renamed from: m */
    public final CharSequence f30m;

    /* JADX INFO: renamed from: n */
    public final Bitmap f31n;

    /* JADX INFO: renamed from: o */
    public final Uri f32o;

    /* JADX INFO: renamed from: p */
    public final Bundle f33p;

    /* JADX INFO: renamed from: q */
    public final Uri f34q;

    /* JADX INFO: renamed from: r */
    public MediaDescription f35r;

    /* JADX INFO: renamed from: android.support.v4.media.MediaDescriptionCompat$a */
    public class C0015a implements Parcelable.Creator<MediaDescriptionCompat> {
        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.m14a(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.MediaDescriptionCompat$b */
    @RequiresApi(21)
    public static class C0016b {
        @DoNotInline
        /* JADX INFO: renamed from: a */
        public static MediaDescription m15a(MediaDescription.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        /* JADX INFO: renamed from: b */
        public static MediaDescription.Builder m16b() {
            return new MediaDescription.Builder();
        }

        @Nullable
        @DoNotInline
        /* JADX INFO: renamed from: c */
        public static CharSequence m17c(MediaDescription mediaDescription) {
            return mediaDescription.getDescription();
        }

        @Nullable
        @DoNotInline
        /* JADX INFO: renamed from: d */
        public static Bundle m18d(MediaDescription mediaDescription) {
            return mediaDescription.getExtras();
        }

        @Nullable
        @DoNotInline
        /* JADX INFO: renamed from: e */
        public static Bitmap m19e(MediaDescription mediaDescription) {
            return mediaDescription.getIconBitmap();
        }

        @Nullable
        @DoNotInline
        /* JADX INFO: renamed from: f */
        public static Uri m20f(MediaDescription mediaDescription) {
            return mediaDescription.getIconUri();
        }

        @Nullable
        @DoNotInline
        /* JADX INFO: renamed from: g */
        public static String m21g(MediaDescription mediaDescription) {
            return mediaDescription.getMediaId();
        }

        @Nullable
        @DoNotInline
        /* JADX INFO: renamed from: h */
        public static CharSequence m22h(MediaDescription mediaDescription) {
            return mediaDescription.getSubtitle();
        }

        @Nullable
        @DoNotInline
        /* JADX INFO: renamed from: i */
        public static CharSequence m23i(MediaDescription mediaDescription) {
            return mediaDescription.getTitle();
        }

        @DoNotInline
        /* JADX INFO: renamed from: j */
        public static void m24j(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setDescription(charSequence);
        }

        @DoNotInline
        /* JADX INFO: renamed from: k */
        public static void m25k(MediaDescription.Builder builder, @Nullable Bundle bundle) {
            builder.setExtras(bundle);
        }

        @DoNotInline
        /* JADX INFO: renamed from: l */
        public static void m26l(MediaDescription.Builder builder, @Nullable Bitmap bitmap) {
            builder.setIconBitmap(bitmap);
        }

        @DoNotInline
        /* JADX INFO: renamed from: m */
        public static void m27m(MediaDescription.Builder builder, @Nullable Uri uri) {
            builder.setIconUri(uri);
        }

        @DoNotInline
        /* JADX INFO: renamed from: n */
        public static void m28n(MediaDescription.Builder builder, @Nullable String str) {
            builder.setMediaId(str);
        }

        @DoNotInline
        /* JADX INFO: renamed from: o */
        public static void m29o(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setSubtitle(charSequence);
        }

        @DoNotInline
        /* JADX INFO: renamed from: p */
        public static void m30p(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setTitle(charSequence);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.MediaDescriptionCompat$c */
    @RequiresApi(23)
    public static class C0017c {
        @Nullable
        @DoNotInline
        /* JADX INFO: renamed from: a */
        public static Uri m31a(MediaDescription mediaDescription) {
            return mediaDescription.getMediaUri();
        }

        @DoNotInline
        /* JADX INFO: renamed from: b */
        public static void m32b(MediaDescription.Builder builder, @Nullable Uri uri) {
            builder.setMediaUri(uri);
        }
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f27j = str;
        this.f28k = charSequence;
        this.f29l = charSequence2;
        this.f30m = charSequence3;
        this.f31n = bitmap;
        this.f32o = uri;
        this.f33p = bundle;
        this.f34q = uri2;
    }

    /* JADX INFO: renamed from: a */
    public static MediaDescriptionCompat m14a(Object obj) {
        Bundle bundle;
        if (obj == null) {
            return null;
        }
        int i = Build.VERSION.SDK_INT;
        MediaDescription mediaDescription = (MediaDescription) obj;
        String strM21g = C0016b.m21g(mediaDescription);
        CharSequence charSequenceM23i = C0016b.m23i(mediaDescription);
        CharSequence charSequenceM22h = C0016b.m22h(mediaDescription);
        CharSequence charSequenceM17c = C0016b.m17c(mediaDescription);
        Bitmap bitmapM19e = C0016b.m19e(mediaDescription);
        Uri uriM20f = C0016b.m20f(mediaDescription);
        Bundle bundleM18d = C0016b.m18d(mediaDescription);
        if (bundleM18d != null) {
            bundleM18d = MediaSessionCompat.m41b(bundleM18d);
        }
        Uri uriM31a = bundleM18d != null ? (Uri) bundleM18d.getParcelable("android.support.v4.media.description.MEDIA_URI") : null;
        if (uriM31a == null) {
            bundle = bundleM18d;
        } else if (bundleM18d.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && bundleM18d.size() == 2) {
            bundle = null;
        } else {
            bundleM18d.remove("android.support.v4.media.description.MEDIA_URI");
            bundleM18d.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            bundle = bundleM18d;
        }
        if (uriM31a == null) {
            uriM31a = i >= 23 ? C0017c.m31a(mediaDescription) : null;
        }
        MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(strM21g, charSequenceM23i, charSequenceM22h, charSequenceM17c, bitmapM19e, uriM20f, bundle, uriM31a);
        mediaDescriptionCompat.f35r = mediaDescription;
        return mediaDescriptionCompat;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ((Object) this.f28k) + ", " + ((Object) this.f29l) + ", " + ((Object) this.f30m);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle;
        int i2 = Build.VERSION.SDK_INT;
        MediaDescription mediaDescriptionM15a = this.f35r;
        if (mediaDescriptionM15a == null) {
            MediaDescription.Builder builderM16b = C0016b.m16b();
            C0016b.m28n(builderM16b, this.f27j);
            C0016b.m30p(builderM16b, this.f28k);
            C0016b.m29o(builderM16b, this.f29l);
            C0016b.m24j(builderM16b, this.f30m);
            C0016b.m26l(builderM16b, this.f31n);
            C0016b.m27m(builderM16b, this.f32o);
            if (i2 >= 23 || this.f34q == null) {
                C0016b.m25k(builderM16b, this.f33p);
            } else {
                if (this.f33p == null) {
                    bundle = new Bundle();
                    bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                } else {
                    bundle = new Bundle(this.f33p);
                }
                bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f34q);
                C0016b.m25k(builderM16b, bundle);
            }
            if (i2 >= 23) {
                C0017c.m32b(builderM16b, this.f34q);
            }
            mediaDescriptionM15a = C0016b.m15a(builderM16b);
            this.f35r = mediaDescriptionM15a;
        }
        mediaDescriptionM15a.writeToParcel(parcel, i);
    }
}
