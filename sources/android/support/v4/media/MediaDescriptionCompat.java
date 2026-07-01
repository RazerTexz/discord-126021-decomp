package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription$Builder;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.support.v4.media.session.MediaSessionCompat;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable$Creator<MediaDescriptionCompat> CREATOR = new MediaDescriptionCompat$a();
    public final String j;
    public final CharSequence k;
    public final CharSequence l;
    public final CharSequence m;
    public final Bitmap n;
    public final Uri o;
    public final Bundle p;
    public final Uri q;
    public MediaDescription r;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.j = str;
        this.k = charSequence;
        this.l = charSequence2;
        this.m = charSequence3;
        this.n = bitmap;
        this.o = uri;
        this.p = bundle;
        this.q = uri2;
    }

    public static MediaDescriptionCompat a(Object obj) {
        Bundle bundle;
        if (obj == null) {
            return null;
        }
        int i = Build$VERSION.SDK_INT;
        MediaDescription mediaDescription = (MediaDescription) obj;
        String strG = MediaDescriptionCompat$b.g(mediaDescription);
        CharSequence charSequenceI = MediaDescriptionCompat$b.i(mediaDescription);
        CharSequence charSequenceH = MediaDescriptionCompat$b.h(mediaDescription);
        CharSequence charSequenceC = MediaDescriptionCompat$b.c(mediaDescription);
        Bitmap bitmapE = MediaDescriptionCompat$b.e(mediaDescription);
        Uri uriF = MediaDescriptionCompat$b.f(mediaDescription);
        Bundle bundleD = MediaDescriptionCompat$b.d(mediaDescription);
        if (bundleD != null) {
            bundleD = MediaSessionCompat.b(bundleD);
        }
        Uri uriA = bundleD != null ? (Uri) bundleD.getParcelable("android.support.v4.media.description.MEDIA_URI") : null;
        if (uriA == null) {
            bundle = bundleD;
        } else if (bundleD.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && bundleD.size() == 2) {
            bundle = null;
        } else {
            bundleD.remove("android.support.v4.media.description.MEDIA_URI");
            bundleD.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            bundle = bundleD;
        }
        if (uriA == null) {
            uriA = i >= 23 ? MediaDescriptionCompat$c.a(mediaDescription) : null;
        }
        MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(strG, charSequenceI, charSequenceH, charSequenceC, bitmapE, uriF, bundle, uriA);
        mediaDescriptionCompat.r = mediaDescription;
        return mediaDescriptionCompat;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ((Object) this.k) + ", " + ((Object) this.l) + ", " + ((Object) this.m);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle;
        int i2 = Build$VERSION.SDK_INT;
        MediaDescription mediaDescriptionA = this.r;
        if (mediaDescriptionA == null) {
            MediaDescription$Builder mediaDescription$BuilderB = MediaDescriptionCompat$b.b();
            MediaDescriptionCompat$b.n(mediaDescription$BuilderB, this.j);
            MediaDescriptionCompat$b.p(mediaDescription$BuilderB, this.k);
            MediaDescriptionCompat$b.o(mediaDescription$BuilderB, this.l);
            MediaDescriptionCompat$b.j(mediaDescription$BuilderB, this.m);
            MediaDescriptionCompat$b.l(mediaDescription$BuilderB, this.n);
            MediaDescriptionCompat$b.m(mediaDescription$BuilderB, this.o);
            if (i2 >= 23 || this.q == null) {
                MediaDescriptionCompat$b.k(mediaDescription$BuilderB, this.p);
            } else {
                if (this.p == null) {
                    bundle = new Bundle();
                    bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                } else {
                    bundle = new Bundle(this.p);
                }
                bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.q);
                MediaDescriptionCompat$b.k(mediaDescription$BuilderB, bundle);
            }
            if (i2 >= 23) {
                MediaDescriptionCompat$c.b(mediaDescription$BuilderB, this.q);
            }
            mediaDescriptionA = MediaDescriptionCompat$b.a(mediaDescription$BuilderB);
            this.r = mediaDescriptionA;
        }
        mediaDescriptionA.writeToParcel(parcel, i);
    }
}
