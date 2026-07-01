package androidx.versionedparcelable;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/* JADX INFO: loaded from: classes.dex */
public class VersionedParcel$1 extends ObjectInputStream {
    public final /* synthetic */ VersionedParcel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VersionedParcel$1(VersionedParcel versionedParcel, InputStream inputStream) {
        super(inputStream);
        this.this$0 = versionedParcel;
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
        Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
        return cls != null ? cls : super.resolveClass(objectStreamClass);
    }
}
