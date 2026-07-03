package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p303j.C3342a;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@KeepName
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new C3342a();

    /* JADX INFO: renamed from: j */
    public final int f20512j;

    /* JADX INFO: renamed from: k */
    public final String[] f20513k;

    /* JADX INFO: renamed from: l */
    public Bundle f20514l;

    /* JADX INFO: renamed from: m */
    public final CursorWindow[] f20515m;

    /* JADX INFO: renamed from: n */
    public final int f20516n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public final Bundle f20517o;

    /* JADX INFO: renamed from: p */
    public int[] f20518p;

    /* JADX INFO: renamed from: q */
    public boolean f20519q = false;

    /* JADX INFO: renamed from: r */
    public boolean f20520r = true;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static class zaa extends RuntimeException {
    }

    static {
        Objects.requireNonNull(new String[0], "null reference");
        new ArrayList();
        new HashMap();
    }

    public DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, @Nullable Bundle bundle) {
        this.f20512j = i;
        this.f20513k = strArr;
        this.f20515m = cursorWindowArr;
        this.f20516n = i2;
        this.f20517o = bundle;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (!this.f20519q) {
                this.f20519q = true;
                int i = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.f20515m;
                    if (i >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i].close();
                    i++;
                }
            }
        }
    }

    public final void finalize() throws Throwable {
        boolean z2;
        try {
            if (this.f20520r && this.f20515m.length > 0) {
                synchronized (this) {
                    z2 = this.f20519q;
                }
                if (!z2) {
                    close();
                    String string = toString();
                    StringBuilder sb = new StringBuilder(String.valueOf(string).length() + Opcodes.GETSTATIC);
                    sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                    sb.append(string);
                    sb.append(")");
                    Log.e("DataBuffer", sb.toString());
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m578u2(parcel, 1, this.f20513k, false);
        C1460d.m582v2(parcel, 2, this.f20515m, i, false);
        int i2 = this.f20516n;
        parcel.writeInt(262147);
        parcel.writeInt(i2);
        C1460d.m558p2(parcel, 4, this.f20517o, false);
        int i3 = this.f20512j;
        parcel.writeInt(263144);
        parcel.writeInt(i3);
        C1460d.m418A2(parcel, iM594y2);
        if ((i & 1) != 0) {
            close();
        }
    }
}
