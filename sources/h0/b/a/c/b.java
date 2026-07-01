package h0.b.a.c;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import org.objenesis.ObjenesisException;

/* JADX INFO: compiled from: ObjectInputStreamInstantiator.java */
/* JADX INFO: loaded from: classes3.dex */
public class b<T> implements h0.b.a.a<T> {
    public ObjectInputStream a;

    public b(Class<T> cls) {
        if (!Serializable.class.isAssignableFrom(cls)) {
            throw new ObjenesisException(new NotSerializableException(cls + " not serializable"));
        }
        try {
            this.a = new ObjectInputStream(new b$a(cls));
        } catch (IOException e) {
            StringBuilder sbU = b.d.b.a.a.U("IOException: ");
            sbU.append(e.getMessage());
            throw new Error(sbU.toString());
        }
    }

    @Override // h0.b.a.a
    public T newInstance() {
        try {
            return (T) this.a.readObject();
        } catch (ClassNotFoundException e) {
            StringBuilder sbU = b.d.b.a.a.U("ClassNotFoundException: ");
            sbU.append(e.getMessage());
            throw new Error(sbU.toString());
        } catch (Exception e2) {
            throw new ObjenesisException(e2);
        }
    }
}
