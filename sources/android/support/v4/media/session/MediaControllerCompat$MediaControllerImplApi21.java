package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession$Token;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import x.a.b.b.a.c;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class MediaControllerCompat$MediaControllerImplApi21 {
    public final MediaController a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20b = new Object();

    @GuardedBy("mLock")
    public final List<c> c = new ArrayList();
    public HashMap<c, MediaControllerCompat$MediaControllerImplApi21$a> d = new HashMap<>();
    public final MediaSessionCompat$Token e;

    public MediaControllerCompat$MediaControllerImplApi21(Context context, MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.e = mediaSessionCompat$Token;
        MediaController mediaController = new MediaController(context, (MediaSession$Token) mediaSessionCompat$Token.k);
        this.a = mediaController;
        if (mediaSessionCompat$Token.b() == null) {
            mediaController.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver(this));
        }
    }

    @GuardedBy("mLock")
    public void a() {
        if (this.e.b() == null) {
            return;
        }
        for (c cVar : this.c) {
            MediaControllerCompat$MediaControllerImplApi21$a mediaControllerCompat$MediaControllerImplApi21$a = new MediaControllerCompat$MediaControllerImplApi21$a(cVar);
            this.d.put(cVar, mediaControllerCompat$MediaControllerImplApi21$a);
            cVar.a = mediaControllerCompat$MediaControllerImplApi21$a;
            try {
                this.e.b().k(mediaControllerCompat$MediaControllerImplApi21$a);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
            }
        }
        this.c.clear();
    }
}
