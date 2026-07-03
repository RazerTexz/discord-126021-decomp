package com.google.android.gms.cloudmessaging;

import android.os.Build;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p298d.C3229d;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zza implements Parcelable {
    public static final Parcelable.Creator<zza> CREATOR = new C3229d();

    /* JADX INFO: renamed from: j */
    public Messenger f20471j;

    /* JADX INFO: renamed from: com.google.android.gms.cloudmessaging.zza$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
    public static final class C10798a extends ClassLoader {
        @Override // java.lang.ClassLoader
        public final Class<?> loadClass(String str, boolean z2) throws ClassNotFoundException {
            if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return super.loadClass(str, z2);
            }
            if (!(Log.isLoggable("CloudMessengerCompat", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("CloudMessengerCompat", 3)))) {
                return zza.class;
            }
            Log.d("CloudMessengerCompat", "Using renamed FirebaseIidMessengerCompat class");
            return zza.class;
        }
    }

    public zza(IBinder iBinder) {
        this.f20471j = new Messenger(iBinder);
    }

    /* JADX INFO: renamed from: a */
    public final IBinder m9017a() {
        Messenger messenger = this.f20471j;
        Objects.requireNonNull(messenger);
        return messenger.getBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return m9017a().equals(((zza) obj).m9017a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return m9017a().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.f20471j;
        Objects.requireNonNull(messenger);
        parcel.writeStrongBinder(messenger.getBinder());
    }
}
