package b.i.a.b.j;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import b.i.a.b.Priority3;
import b.i.a.b.j.AutoValue_TransportContext;
import com.google.auto.value.AutoValue;

/* JADX INFO: renamed from: b.i.a.b.j.i, reason: use source file name */
/* JADX INFO: compiled from: TransportContext.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class TransportContext {

    /* JADX INFO: renamed from: b.i.a.b.j.i$a */
    /* JADX INFO: compiled from: TransportContext.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract TransportContext a();

        public abstract a b(String str);

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public abstract a c(Priority3 priority3);
    }

    public static a a() {
        AutoValue_TransportContext.b bVar = new AutoValue_TransportContext.b();
        bVar.c(Priority3.DEFAULT);
        return bVar;
    }

    public abstract String b();

    @Nullable
    public abstract byte[] c();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract Priority3 d();

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = b();
        objArr[1] = d();
        objArr[2] = c() == null ? "" : Base64.encodeToString(c(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
