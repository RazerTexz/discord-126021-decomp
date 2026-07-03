package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.MediaDescription;
import android.media.session.MediaSession;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.os.BuildCompat;
import androidx.versionedparcelable.VersionedParcelable;
import p007b.p100d.p104b.p105a.C1643a;
import p668x.p669a.p672b.p674b.p675a.InterfaceC13183b;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionCompat {

    /* JADX INFO: renamed from: a */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int f46a;

    @SuppressLint({"BanParcelableUsage"})
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new C0023a();

        /* JADX INFO: renamed from: j */
        public ResultReceiver f49j;

        /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper$a */
        public class C0023a implements Parcelable.Creator<ResultReceiverWrapper> {
            @Override // android.os.Parcelable.Creator
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        }

        public ResultReceiverWrapper(Parcel parcel) {
            this.f49j = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            this.f49j.writeToParcel(parcel, i);
        }
    }

    static {
        f46a = BuildCompat.isAtLeastS() ? 33554432 : 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* JADX INFO: renamed from: a */
    public static void m40a(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* JADX INFO: renamed from: b */
    public static Bundle m41b(@Nullable Bundle bundle) {
        m40a(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new C0024a();

        /* JADX INFO: renamed from: j */
        public final Object f50j;

        /* JADX INFO: renamed from: k */
        public final Object f51k;

        /* JADX INFO: renamed from: l */
        @GuardedBy("mLock")
        public InterfaceC13183b f52l;

        /* JADX INFO: renamed from: m */
        @GuardedBy("mLock")
        public VersionedParcelable f53m;

        /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$Token$a */
        public class C0024a implements Parcelable.Creator<Token> {
            @Override // android.os.Parcelable.Creator
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable(null));
            }

            @Override // android.os.Parcelable.Creator
            public Token[] newArray(int i) {
                return new Token[i];
            }
        }

        public Token(Object obj) {
            this.f50j = new Object();
            this.f51k = obj;
            this.f52l = null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        /* JADX INFO: renamed from: a */
        public static Token m45a(Object obj, InterfaceC13183b interfaceC13183b) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof MediaSession.Token) {
                return new Token(obj, interfaceC13183b);
            }
            throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        /* JADX INFO: renamed from: b */
        public InterfaceC13183b m46b() {
            InterfaceC13183b interfaceC13183b;
            synchronized (this.f50j) {
                interfaceC13183b = this.f52l;
            }
            return interfaceC13183b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f51k;
            if (obj2 == null) {
                return token.f51k == null;
            }
            Object obj3 = token.f51k;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.f51k;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable((Parcelable) this.f51k, i);
        }

        public Token(Object obj, InterfaceC13183b interfaceC13183b) {
            this.f50j = new Object();
            this.f51k = obj;
            this.f52l = interfaceC13183b;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new C0021a();

        /* JADX INFO: renamed from: j */
        public final MediaDescriptionCompat f47j;

        /* JADX INFO: renamed from: k */
        public final long f48k;

        /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem$a */
        public class C0021a implements Parcelable.Creator<QueueItem> {
            @Override // android.os.Parcelable.Creator
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        }

        /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem$b */
        @RequiresApi(21)
        public static class C0022b {
            @DoNotInline
            /* JADX INFO: renamed from: a */
            public static MediaSession.QueueItem m42a(MediaDescription mediaDescription, long j) {
                return new MediaSession.QueueItem(mediaDescription, j);
            }

            @DoNotInline
            /* JADX INFO: renamed from: b */
            public static MediaDescription m43b(MediaSession.QueueItem queueItem) {
                return queueItem.getDescription();
            }

            @DoNotInline
            /* JADX INFO: renamed from: c */
            public static long m44c(MediaSession.QueueItem queueItem) {
                return queueItem.getQueueId();
            }
        }

        public QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            }
            if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.f47j = mediaDescriptionCompat;
            this.f48k = j;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("MediaSession.QueueItem {Description=");
            sbM833U.append(this.f47j);
            sbM833U.append(", Id=");
            return C1643a.m815C(sbM833U, this.f48k, " }");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            this.f47j.writeToParcel(parcel, i);
            parcel.writeLong(this.f48k);
        }

        public QueueItem(Parcel parcel) {
            this.f47j = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f48k = parcel.readLong();
        }
    }
}
