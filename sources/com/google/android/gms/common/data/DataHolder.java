package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.j.a;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@KeepName
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new a();
    public final int j;
    public final String[] k;
    public Bundle l;
    public final CursorWindow[] m;
    public final int n;

    @Nullable
    public final Bundle o;
    public int[] p;
    public boolean q = false;
    public boolean r = true;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static class zaa extends RuntimeException {
    }

    static {
        Objects.requireNonNull(new String[0], "null reference");
        new ArrayList();
        new HashMap();
    }

    public DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, @Nullable Bundle bundle) {
        this.j = i;
        this.k = strArr;
        this.m = cursorWindowArr;
        this.n = i2;
        this.o = bundle;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (!this.q) {
                this.q = true;
                int i = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.m;
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
            if (this.r && this.m.length > 0) {
                synchronized (this) {
                    z2 = this.q;
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
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.u2(parcel, 1, this.k, false);
        AnimatableValueParser.v2(parcel, 2, this.m, i, false);
        int i2 = this.n;
        parcel.writeInt(262147);
        parcel.writeInt(i2);
        AnimatableValueParser.p2(parcel, 4, this.o, false);
        int i3 = this.j;
        parcel.writeInt(263144);
        parcel.writeInt(i3);
        AnimatableValueParser.A2(parcel, iY2);
        if ((i & 1) != 0) {
            close();
        }
    }
}
