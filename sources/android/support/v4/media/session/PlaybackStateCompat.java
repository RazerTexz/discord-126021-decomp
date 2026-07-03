package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new C0027a();

    /* JADX INFO: renamed from: j */
    public final int f59j;

    /* JADX INFO: renamed from: k */
    public final long f60k;

    /* JADX INFO: renamed from: l */
    public final long f61l;

    /* JADX INFO: renamed from: m */
    public final float f62m;

    /* JADX INFO: renamed from: n */
    public final long f63n;

    /* JADX INFO: renamed from: o */
    public final int f64o;

    /* JADX INFO: renamed from: p */
    public final CharSequence f65p;

    /* JADX INFO: renamed from: q */
    public final long f66q;

    /* JADX INFO: renamed from: r */
    public List<CustomAction> f67r;

    /* JADX INFO: renamed from: s */
    public final long f68s;

    /* JADX INFO: renamed from: t */
    public final Bundle f69t;

    /* JADX INFO: renamed from: android.support.v4.media.session.PlaybackStateCompat$a */
    public class C0027a implements Parcelable.Creator<PlaybackStateCompat> {
        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.session.PlaybackStateCompat$b */
    @RequiresApi(21)
    public static class C0028b {
        @DoNotInline
        /* JADX INFO: renamed from: a */
        public static void m47a(PlaybackState.Builder builder, PlaybackState.CustomAction customAction) {
            builder.addCustomAction(customAction);
        }

        @DoNotInline
        /* JADX INFO: renamed from: b */
        public static PlaybackState.CustomAction m48b(PlaybackState.CustomAction.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        /* JADX INFO: renamed from: c */
        public static PlaybackState m49c(PlaybackState.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        /* JADX INFO: renamed from: d */
        public static PlaybackState.Builder m50d() {
            return new PlaybackState.Builder();
        }

        @DoNotInline
        /* JADX INFO: renamed from: e */
        public static PlaybackState.CustomAction.Builder m51e(String str, CharSequence charSequence, int i) {
            return new PlaybackState.CustomAction.Builder(str, charSequence, i);
        }

        @DoNotInline
        /* JADX INFO: renamed from: f */
        public static String m52f(PlaybackState.CustomAction customAction) {
            return customAction.getAction();
        }

        @DoNotInline
        /* JADX INFO: renamed from: g */
        public static long m53g(PlaybackState playbackState) {
            return playbackState.getActions();
        }

        @DoNotInline
        /* JADX INFO: renamed from: h */
        public static long m54h(PlaybackState playbackState) {
            return playbackState.getActiveQueueItemId();
        }

        @DoNotInline
        /* JADX INFO: renamed from: i */
        public static long m55i(PlaybackState playbackState) {
            return playbackState.getBufferedPosition();
        }

        @DoNotInline
        /* JADX INFO: renamed from: j */
        public static List<PlaybackState.CustomAction> m56j(PlaybackState playbackState) {
            return playbackState.getCustomActions();
        }

        @DoNotInline
        /* JADX INFO: renamed from: k */
        public static CharSequence m57k(PlaybackState playbackState) {
            return playbackState.getErrorMessage();
        }

        @DoNotInline
        /* JADX INFO: renamed from: l */
        public static Bundle m58l(PlaybackState.CustomAction customAction) {
            return customAction.getExtras();
        }

        @DoNotInline
        /* JADX INFO: renamed from: m */
        public static int m59m(PlaybackState.CustomAction customAction) {
            return customAction.getIcon();
        }

        @DoNotInline
        /* JADX INFO: renamed from: n */
        public static long m60n(PlaybackState playbackState) {
            return playbackState.getLastPositionUpdateTime();
        }

        @DoNotInline
        /* JADX INFO: renamed from: o */
        public static CharSequence m61o(PlaybackState.CustomAction customAction) {
            return customAction.getName();
        }

        @DoNotInline
        /* JADX INFO: renamed from: p */
        public static float m62p(PlaybackState playbackState) {
            return playbackState.getPlaybackSpeed();
        }

        @DoNotInline
        /* JADX INFO: renamed from: q */
        public static long m63q(PlaybackState playbackState) {
            return playbackState.getPosition();
        }

        @DoNotInline
        /* JADX INFO: renamed from: r */
        public static int m64r(PlaybackState playbackState) {
            return playbackState.getState();
        }

        @DoNotInline
        /* JADX INFO: renamed from: s */
        public static void m65s(PlaybackState.Builder builder, long j) {
            builder.setActions(j);
        }

        @DoNotInline
        /* JADX INFO: renamed from: t */
        public static void m66t(PlaybackState.Builder builder, long j) {
            builder.setActiveQueueItemId(j);
        }

        @DoNotInline
        /* JADX INFO: renamed from: u */
        public static void m67u(PlaybackState.Builder builder, long j) {
            builder.setBufferedPosition(j);
        }

        @DoNotInline
        /* JADX INFO: renamed from: v */
        public static void m68v(PlaybackState.Builder builder, CharSequence charSequence) {
            builder.setErrorMessage(charSequence);
        }

        @DoNotInline
        /* JADX INFO: renamed from: w */
        public static void m69w(PlaybackState.CustomAction.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }

        @DoNotInline
        /* JADX INFO: renamed from: x */
        public static void m70x(PlaybackState.Builder builder, int i, long j, float f, long j2) {
            builder.setState(i, j, f, j2);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.session.PlaybackStateCompat$c */
    @RequiresApi(22)
    public static class C0029c {
        @DoNotInline
        /* JADX INFO: renamed from: a */
        public static Bundle m71a(PlaybackState playbackState) {
            return playbackState.getExtras();
        }

        @DoNotInline
        /* JADX INFO: renamed from: b */
        public static void m72b(PlaybackState.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }
    }

    public PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f59j = i;
        this.f60k = j;
        this.f61l = j2;
        this.f62m = f;
        this.f63n = j3;
        this.f64o = i2;
        this.f65p = charSequence;
        this.f66q = j4;
        this.f67r = new ArrayList(list);
        this.f68s = j5;
        this.f69t = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {");
        sb.append("state=");
        sb.append(this.f59j);
        sb.append(", position=");
        sb.append(this.f60k);
        sb.append(", buffered position=");
        sb.append(this.f61l);
        sb.append(", speed=");
        sb.append(this.f62m);
        sb.append(", updated=");
        sb.append(this.f66q);
        sb.append(", actions=");
        sb.append(this.f63n);
        sb.append(", error code=");
        sb.append(this.f64o);
        sb.append(", error message=");
        sb.append(this.f65p);
        sb.append(", custom actions=");
        sb.append(this.f67r);
        sb.append(", active item id=");
        return C1643a.m815C(sb, this.f68s, "}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f59j);
        parcel.writeLong(this.f60k);
        parcel.writeFloat(this.f62m);
        parcel.writeLong(this.f66q);
        parcel.writeLong(this.f61l);
        parcel.writeLong(this.f63n);
        TextUtils.writeToParcel(this.f65p, parcel, i);
        parcel.writeTypedList(this.f67r);
        parcel.writeLong(this.f68s);
        parcel.writeBundle(this.f69t);
        parcel.writeInt(this.f64o);
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new C0026a();

        /* JADX INFO: renamed from: j */
        public final String f70j;

        /* JADX INFO: renamed from: k */
        public final CharSequence f71k;

        /* JADX INFO: renamed from: l */
        public final int f72l;

        /* JADX INFO: renamed from: m */
        public final Bundle f73m;

        /* JADX INFO: renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$a */
        public class C0026a implements Parcelable.Creator<CustomAction> {
            @Override // android.os.Parcelable.Creator
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        }

        public CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f70j = str;
            this.f71k = charSequence;
            this.f72l = i;
            this.f73m = bundle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Action:mName='");
            sbM833U.append((Object) this.f71k);
            sbM833U.append(", mIcon=");
            sbM833U.append(this.f72l);
            sbM833U.append(", mExtras=");
            sbM833U.append(this.f73m);
            return sbM833U.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f70j);
            TextUtils.writeToParcel(this.f71k, parcel, i);
            parcel.writeInt(this.f72l);
            parcel.writeBundle(this.f73m);
        }

        public CustomAction(Parcel parcel) {
            this.f70j = parcel.readString();
            this.f71k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f72l = parcel.readInt();
            this.f73m = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f59j = parcel.readInt();
        this.f60k = parcel.readLong();
        this.f62m = parcel.readFloat();
        this.f66q = parcel.readLong();
        this.f61l = parcel.readLong();
        this.f63n = parcel.readLong();
        this.f65p = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f67r = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f68s = parcel.readLong();
        this.f69t = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f64o = parcel.readInt();
    }
}
