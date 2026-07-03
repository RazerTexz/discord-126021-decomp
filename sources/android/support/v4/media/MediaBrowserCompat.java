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
import p668x.p669a.p672b.p674b.p675a.InterfaceC13183b;

/* JADX INFO: loaded from: classes.dex */
public final class MediaBrowserCompat {

    /* JADX INFO: renamed from: a */
    public static final boolean f5a = Log.isLoggable("MediaBrowserCompat", 3);

    /* JADX INFO: renamed from: b */
    public final InterfaceC0007d f6b;

    public static class CustomActionResultReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        /* JADX INFO: renamed from: a */
        public void mo4a(int i, Bundle bundle) {
        }
    }

    public static class ItemReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        /* JADX INFO: renamed from: a */
        public void mo4a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.m41b(bundle);
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
        /* JADX INFO: renamed from: a */
        public void mo4a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.m41b(bundle);
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

    /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$a */
    @RequiresApi(21)
    public static class C0004a {
        @DoNotInline
        /* JADX INFO: renamed from: a */
        public static MediaDescription m6a(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getDescription();
        }

        @DoNotInline
        /* JADX INFO: renamed from: b */
        public static int m7b(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getFlags();
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$b */
    public static class HandlerC0005b extends Handler {

        /* JADX INFO: renamed from: a */
        public final WeakReference<InterfaceC0011h> f9a;

        /* JADX INFO: renamed from: b */
        public WeakReference<Messenger> f10b;

        public HandlerC0005b(InterfaceC0011h interfaceC0011h) {
            this.f9a = new WeakReference<>(interfaceC0011h);
        }

        /* JADX INFO: renamed from: a */
        public void m8a(Messenger messenger) {
            this.f10b = new WeakReference<>(messenger);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            WeakReference<Messenger> weakReference = this.f10b;
            if (weakReference == null || weakReference.get() == null || this.f9a.get() == null) {
                return;
            }
            Bundle data = message.getData();
            MediaSessionCompat.m40a(data);
            InterfaceC0011h interfaceC0011h = this.f9a.get();
            Messenger messenger = this.f10b.get();
            try {
                int i = message.what;
                if (i == 1) {
                    Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.m40a(bundle);
                    interfaceC0011h.mo9a(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) data.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), bundle);
                } else if (i == 2) {
                    interfaceC0011h.mo11c(messenger);
                } else if (i != 3) {
                    Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                } else {
                    Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                    MediaSessionCompat.m40a(bundle2);
                    Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);
                    MediaSessionCompat.m40a(bundle3);
                    interfaceC0011h.mo10b(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), bundle2, bundle3);
                }
            } catch (BadParcelableException unused) {
                Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                if (message.what == 1) {
                    interfaceC0011h.mo11c(messenger);
                }
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$c */
    public static class C0006c {
        public final MediaBrowser.ConnectionCallback mConnectionCallbackFwk = new a();
        public b mConnectionCallbackInternal;

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$c$a */
        @RequiresApi(21)
        public class a extends MediaBrowser.ConnectionCallback {
            public a() {
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnected() {
                b bVar = C0006c.this.mConnectionCallbackInternal;
                if (bVar != null) {
                    C0008e c0008e = (C0008e) bVar;
                    Objects.requireNonNull(c0008e);
                    try {
                        Bundle extras = c0008e.f13b.getExtras();
                        if (extras != null) {
                            extras.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                            IBinder binder = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                            if (binder != null) {
                                c0008e.f17f = new C0012i(binder, c0008e.f14c);
                                Messenger messenger = new Messenger(c0008e.f15d);
                                c0008e.f18g = messenger;
                                c0008e.f15d.m8a(messenger);
                                try {
                                    C0012i c0012i = c0008e.f17f;
                                    Context context = c0008e.f12a;
                                    Messenger messenger2 = c0008e.f18g;
                                    Objects.requireNonNull(c0012i);
                                    Bundle bundle = new Bundle();
                                    bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
                                    bundle.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Process.myPid());
                                    bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, c0012i.f21b);
                                    c0012i.m12a(6, bundle, messenger2);
                                } catch (RemoteException unused) {
                                    Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                                }
                            }
                            InterfaceC13183b interfaceC13183bM11356c = InterfaceC13183b.a.m11356c(BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
                            if (interfaceC13183bM11356c != null) {
                                c0008e.f19h = MediaSessionCompat.Token.m45a(c0008e.f13b.getSessionToken(), interfaceC13183bM11356c);
                            }
                        }
                    } catch (IllegalStateException e) {
                        Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", e);
                    }
                }
                C0006c.this.onConnected();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionFailed() {
                b bVar = C0006c.this.mConnectionCallbackInternal;
                if (bVar != null) {
                    Objects.requireNonNull((C0008e) bVar);
                }
                C0006c.this.onConnectionFailed();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionSuspended() {
                b bVar = C0006c.this.mConnectionCallbackInternal;
                if (bVar != null) {
                    C0008e c0008e = (C0008e) bVar;
                    c0008e.f17f = null;
                    c0008e.f18g = null;
                    c0008e.f19h = null;
                    c0008e.f15d.m8a(null);
                }
                C0006c.this.onConnectionSuspended();
            }
        }

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$c$b */
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

    /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$d */
    public interface InterfaceC0007d {
    }

    /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$e */
    @RequiresApi(21)
    public static class C0008e implements InterfaceC0007d, InterfaceC0011h, C0006c.b {

        /* JADX INFO: renamed from: a */
        public final Context f12a;

        /* JADX INFO: renamed from: b */
        public final MediaBrowser f13b;

        /* JADX INFO: renamed from: c */
        public final Bundle f14c;

        /* JADX INFO: renamed from: d */
        public final HandlerC0005b f15d = new HandlerC0005b(this);

        /* JADX INFO: renamed from: e */
        public final ArrayMap<String, C0013j> f16e = new ArrayMap<>();

        /* JADX INFO: renamed from: f */
        public C0012i f17f;

        /* JADX INFO: renamed from: g */
        public Messenger f18g;

        /* JADX INFO: renamed from: h */
        public MediaSessionCompat.Token f19h;

        public C0008e(Context context, ComponentName componentName, C0006c c0006c, Bundle bundle) {
            this.f12a = context;
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            this.f14c = bundle2;
            bundle2.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            bundle2.putInt(MediaBrowserProtocol.EXTRA_CALLING_PID, Process.myPid());
            c0006c.setInternalConnectionCallback(this);
            this.f13b = new MediaBrowser(context, componentName, c0006c.mConnectionCallbackFwk, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.InterfaceC0011h
        /* JADX INFO: renamed from: a */
        public void mo9a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.InterfaceC0011h
        /* JADX INFO: renamed from: b */
        public void mo10b(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2) {
            if (this.f18g != messenger) {
                return;
            }
            C0013j c0013j = this.f16e.get(str);
            if (c0013j != null) {
                c0013j.m13a(bundle);
            } else if (MediaBrowserCompat.f5a) {
                Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.InterfaceC0011h
        /* JADX INFO: renamed from: c */
        public void mo11c(Messenger messenger) {
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$f */
    @RequiresApi(23)
    public static class C0009f extends C0008e {
        public C0009f(Context context, ComponentName componentName, C0006c c0006c, Bundle bundle) {
            super(context, componentName, c0006c, bundle);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$g */
    @RequiresApi(26)
    public static class C0010g extends C0009f {
        public C0010g(Context context, ComponentName componentName, C0006c c0006c, Bundle bundle) {
            super(context, componentName, c0006c, bundle);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$h */
    public interface InterfaceC0011h {
        /* JADX INFO: renamed from: a */
        void mo9a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        /* JADX INFO: renamed from: b */
        void mo10b(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2);

        /* JADX INFO: renamed from: c */
        void mo11c(Messenger messenger);
    }

    /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$i */
    public static class C0012i {

        /* JADX INFO: renamed from: a */
        public Messenger f20a;

        /* JADX INFO: renamed from: b */
        public Bundle f21b;

        public C0012i(IBinder iBinder, Bundle bundle) {
            this.f20a = new Messenger(iBinder);
            this.f21b = bundle;
        }

        /* JADX INFO: renamed from: a */
        public final void m12a(int i, Bundle bundle, Messenger messenger) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i;
            messageObtain.arg1 = 1;
            messageObtain.setData(bundle);
            messageObtain.replyTo = messenger;
            this.f20a.send(messageObtain);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$j */
    public static class C0013j {

        /* JADX INFO: renamed from: a */
        public final List<AbstractC0014k> f22a = new ArrayList();

        /* JADX INFO: renamed from: b */
        public final List<Bundle> f23b = new ArrayList();

        /* JADX INFO: renamed from: a */
        public AbstractC0014k m13a(Bundle bundle) {
            for (int i = 0; i < this.f23b.size(); i++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.f23b.get(i), bundle)) {
                    return this.f22a.get(i);
                }
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$k */
    public static abstract class AbstractC0014k {

        /* JADX INFO: renamed from: a */
        public final IBinder f24a = new Binder();

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$k$a */
        @RequiresApi(21)
        public class a extends MediaBrowser.SubscriptionCallback {
            public a() {
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String str, List<MediaBrowser.MediaItem> list) {
                Objects.requireNonNull(AbstractC0014k.this);
                AbstractC0014k abstractC0014k = AbstractC0014k.this;
                MediaItem.m5a(list);
                Objects.requireNonNull(abstractC0014k);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@NonNull String str) {
                Objects.requireNonNull(AbstractC0014k.this);
            }
        }

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$k$b */
        @RequiresApi(26)
        public class b extends a {
            public b() {
                super();
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowser.MediaItem> list, @NonNull Bundle bundle) {
                MediaSessionCompat.m40a(bundle);
                AbstractC0014k abstractC0014k = AbstractC0014k.this;
                MediaItem.m5a(list);
                Objects.requireNonNull(abstractC0014k);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@NonNull String str, @NonNull Bundle bundle) {
                MediaSessionCompat.m40a(bundle);
                Objects.requireNonNull(AbstractC0014k.this);
            }
        }

        public AbstractC0014k() {
            if (Build.VERSION.SDK_INT >= 26) {
                new b();
            } else {
                new a();
            }
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, C0006c c0006c, Bundle bundle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.f6b = new C0010g(context, componentName, c0006c, null);
        } else if (i >= 23) {
            this.f6b = new C0009f(context, componentName, c0006c, null);
        } else {
            this.f6b = new C0008e(context, componentName, c0006c, null);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new C0003a();

        /* JADX INFO: renamed from: j */
        public final int f7j;

        /* JADX INFO: renamed from: k */
        public final MediaDescriptionCompat f8k;

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$a */
        public class C0003a implements Parcelable.Creator<MediaItem> {
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
            if (TextUtils.isEmpty(mediaDescriptionCompat.f27j)) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.f7j = i;
            this.f8k = mediaDescriptionCompat;
        }

        /* JADX INFO: renamed from: a */
        public static List<MediaItem> m5a(List<?> list) {
            MediaItem mediaItem;
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object obj : list) {
                if (obj != null) {
                    MediaBrowser.MediaItem mediaItem2 = (MediaBrowser.MediaItem) obj;
                    mediaItem = new MediaItem(MediaDescriptionCompat.m14a(C0004a.m6a(mediaItem2)), C0004a.m7b(mediaItem2));
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
            return "MediaItem{mFlags=" + this.f7j + ", mDescription=" + this.f8k + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f7j);
            this.f8k.writeToParcel(parcel, i);
        }

        public MediaItem(Parcel parcel) {
            this.f7j = parcel.readInt();
            this.f8k = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
    }
}
