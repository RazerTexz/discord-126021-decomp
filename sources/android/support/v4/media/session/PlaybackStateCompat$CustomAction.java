package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.text.TextUtils;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat$CustomAction implements Parcelable {
    public static final Parcelable$Creator<PlaybackStateCompat$CustomAction> CREATOR = new PlaybackStateCompat$CustomAction$a();
    public final String j;
    public final CharSequence k;
    public final int l;
    public final Bundle m;

    public PlaybackStateCompat$CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
        this.j = str;
        this.k = charSequence;
        this.l = i;
        this.m = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Action:mName='");
        sbU.append((Object) this.k);
        sbU.append(", mIcon=");
        sbU.append(this.l);
        sbU.append(", mExtras=");
        sbU.append(this.m);
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j);
        TextUtils.writeToParcel(this.k, parcel, i);
        parcel.writeInt(this.l);
        parcel.writeBundle(this.m);
    }

    public PlaybackStateCompat$CustomAction(Parcel parcel) {
        this.j = parcel.readString();
        this.k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.l = parcel.readInt();
        this.m = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }
}
