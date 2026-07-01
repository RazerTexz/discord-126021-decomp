package android.support.v4.media;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.media.MediaDescription;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import x.a.b.b.a.IMediaSession;

/* JADX INFO: loaded from: classes.dex */
public final class MediaBrowserCompat {
    public static final boolean a = Log.isLoggable("MediaBrowserCompat", 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f14b;

    public static class CustomActionResultReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public void a(int i, Bundle bundle) {
        }
    }

    public static class ItemReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public void a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.b(bundle);
            }
            if (i != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                throw null;
            }
            Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (parcelable != null && !(parcelable instanceof MediaItem)) {
                throw null;
            }
            throw null;
        }
    }

    public static class SearchResultReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public void a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.b(bundle);
            }
            if (i != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
                throw null;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            Objects.requireNonNull(parcelableArray);
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((MediaItem) parcelable);
            }
            throw null;
        }
    }

    @RequiresApi(21)
    public static class a {
        @DoNotInline
        public static MediaDescription a(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getDescription();
        }

        @DoNotInline
        public static int b(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getFlags();
        }
    }

    public static class b extends Handler {
        public final WeakReference<h> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference<Messenger> f15b;

        public b(h hVar) {
            this.a = new WeakReference<>(hVar);
        }

        public void a(Messenger messenger) {
            this.f15b = new WeakReference<>(messenger);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            WeakReference<Messenger> weakReference = this.f15b;
            if (weakReference == null || weakReference.get() == null || this.a.get() == null) {
                return;
            }
            Bundle data = message.getData();
            MediaSessionCompat.a(data);
            h hVar = this.a.get();
            Messenger messenger = this.f15b.get();
            try {
                int i = message.what;
                if (i == 1) {
                    Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.a(bundle);
                    hVar.a(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) data.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), bundle);
                } else if (i == 2) {
                    hVar.c(messenger);
                } else if (i != 3) {
                    Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                } else {
                    Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                    MediaSessionCompat.a(bundle2);
                    Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);
                    MediaSessionCompat.a(bundle3);
                    hVar.b(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), bundle2, bundle3);
                }
            } catch (BadParcelableException unused) {
                Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                if (message.what == 1) {
                    hVar.c(messenger);
                }
            }
        }
    }

    public static class c {
        public final MediaBrowser.ConnectionCallback mConnectionCallbackFwk = new a();
        public b mConnectionCallbackInternal;

        @RequiresApi(21)
        public class a extends MediaBrowser.ConnectionCallback {
            public a() {
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnected() {
                b bVar = c.this.mConnectionCallbackInternal;
                if (bVar != null) {
                    e eVar = (e) bVar;
                    Objects.requireNonNull(eVar);
                    try {
                        Bundle extras = eVar.f16b.getExtras();
                        if (extras != null) {
                            extras.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                            IBinder binder = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                            if (binder != null) {
                                eVar.f = new i(binder, eVar.c);
                                Messenger messenger = new Messenger(eVar.d);
                                eVar.g = messenger;
                                eVar.d.a(messenger);
                                try {
                                    i iVar = eVar.f;
                                    Context context = eVar.a;
                                    Messenger messenger2 = eVar.g;
                                    Objects.requireNonNull(iVar);
                                    Bundle bundle = new Bundle();
                                    bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
                                    bundle.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Process.myPid());
                                    bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, iVar.f17b);
                                    iVar.a(6, bundle, messenger2);
                                } catch (RemoteException unused) {
                                    Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                                }
                            }
                            IMediaSession iMediaSessionC = IMediaSession.a.c(BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
                            if (iMediaSessionC != null) {
                                eVar.h = MediaSessionCompat.Token.a(eVar.f16b.getSessionToken(), iMediaSessionC);
                            }
                        }
                    } catch (IllegalStateException e) {
                        Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", e);
                    }
                }
                c.this.onConnected();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionFailed() {
                b bVar = c.this.mConnectionCallbackInternal;
                if (bVar != null) {
                    Objects.requireNonNull((e) bVar);
                }
                c.this.onConnectionFailed();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionSuspended() {
                b bVar = c.this.mConnectionCallbackInternal;
                if (bVar != null) {
                    e eVar = (e) bVar;
                    eVar.f = null;
                    eVar.g = null;
                    eVar.h = null;
                    eVar.d.a(null);
                }
                c.this.onConnectionSuspended();
            }
        }

        public interface b {
        }

        public void onConnected() {
            throw null;
        }

        public void onConnectionFailed() {
            throw null;
        }

        public void onConnectionSuspended() {
            throw null;
        }

        public void setInternalConnectionCallback(b bVar) {
            this.mConnectionCallbackInternal = bVar;
        }
    }

    public interface d {
    }

    @RequiresApi(21)
    public static class e implements d, h, c.b {
        public final Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaBrowser f16b;
        public final Bundle c;
        public final b d = new b(this);
        public final ArrayMap<String, j> e = new ArrayMap<>();
        public i f;
        public Messenger g;
        public MediaSessionCompat.Token h;

        public e(Context context, ComponentName componentName, c cVar, Bundle bundle) {
            this.a = context;
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            this.c = bundle2;
            bundle2.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            bundle2.putInt(MediaBrowserProtocol.EXTRA_CALLING_PID, Process.myPid());
            cVar.setInternalConnectionCallback(this);
            this.f16b = new MediaBrowser(context, componentName, cVar.mConnectionCallbackFwk, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.h
        public void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.h
        public void b(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2) {
            if (this.g != messenger) {
                return;
            }
            j jVar = this.e.get(str);
            if (jVar != null) {
                jVar.a(bundle);
            } else if (MediaBrowserCompat.a) {
                Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.h
        public void c(Messenger messenger) {
        }
    }

    @RequiresApi(23)
    public static class f extends e {
        public f(Context context, ComponentName componentName, c cVar, Bundle bundle) {
            super(context, componentName, cVar, bundle);
        }
    }

    @RequiresApi(26)
    public static class g extends f {
        public g(Context context, ComponentName componentName, c cVar, Bundle bundle) {
            super(context, componentName, cVar, bundle);
        }
    }

    public interface h {
        void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void b(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2);

        void c(Messenger messenger);
    }

    public static class i {
        public Messenger a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bundle f17b;

        public i(IBinder iBinder, Bundle bundle) {
            this.a = new Messenger(iBinder);
            this.f17b = bundle;
        }

        public final void a(int i, Bundle bundle, Messenger messenger) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i;
            messageObtain.arg1 = 1;
            messageObtain.setData(bundle);
            messageObtain.replyTo = messenger;
            this.a.send(messageObtain);
        }
    }

    public static class j {
        public final List<k> a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Bundle> f18b = new ArrayList();

        public k a(Bundle bundle) {
            for (int i = 0; i < this.f18b.size(); i++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.f18b.get(i), bundle)) {
                    return this.a.get(i);
                }
            }
            return null;
        }
    }

    public static abstract class k {
        public final IBinder a = new Binder();

        @RequiresApi(21)
        public class a extends MediaBrowser.SubscriptionCallback {
            public a() {
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String str, List<MediaBrowser.MediaItem> list) {
                Objects.requireNonNull(k.this);
                k kVar = k.this;
                MediaItem.a(list);
                Objects.requireNonNull(kVar);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@NonNull String str) {
                Objects.requireNonNull(k.this);
            }
        }

        @RequiresApi(26)
        public class b extends a {
            public b() {
                super();
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowser.MediaItem> list, @NonNull Bundle bundle) {
                MediaSessionCompat.a(bundle);
                k kVar = k.this;
                MediaItem.a(list);
                Objects.requireNonNull(kVar);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@NonNull String str, @NonNull Bundle bundle) {
                MediaSessionCompat.a(bundle);
                Objects.requireNonNull(k.this);
            }
        }

        public k() {
            if (Build.VERSION.SDK_INT >= 26) {
                new b();
            } else {
                new a();
            }
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, c cVar, Bundle bundle) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.f14b = new g(context, componentName, cVar, null);
        } else if (i2 >= 23) {
            this.f14b = new f(context, componentName, cVar, null);
        } else {
            this.f14b = new e(context, componentName, cVar, null);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new a();
        public final int j;
        public final MediaDescriptionCompat k;

        public class a implements Parcelable.Creator<MediaItem> {
            @Override // android.os.Parcelable.Creator
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        }

        public MediaItem(@NonNull MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if (TextUtils.isEmpty(mediaDescriptionCompat.j)) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.j = i;
            this.k = mediaDescriptionCompat;
        }

        public static List<MediaItem> a(List<?> list) {
            MediaItem mediaItem;
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object obj : list) {
                if (obj != null) {
                    MediaBrowser.MediaItem mediaItem2 = (MediaBrowser.MediaItem) obj;
                    mediaItem = new MediaItem(MediaDescriptionCompat.a(a.a(mediaItem2)), a.b(mediaItem2));
                } else {
                    mediaItem = null;
                }
                arrayList.add(mediaItem);
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NonNull
        public String toString() {
            return "MediaItem{mFlags=" + this.j + ", mDescription=" + this.k + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.j);
            this.k.writeToParcel(parcel, i);
        }

        public MediaItem(Parcel parcel) {
            this.j = parcel.readInt();
            this.k = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
    }
}
