package b.i.a.b.j;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: TransportContext.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class i {
    public static i$a a() {
        b$b b_b = new b$b();
        b_b.c(b.i.a.b.d.DEFAULT);
        return b_b;
    }

    public abstract String b();

    @Nullable
    public abstract byte[] c();

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public abstract b.i.a.b.d d();

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = b();
        objArr[1] = d();
        objArr[2] = c() == null ? "" : Base64.encodeToString(c(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
