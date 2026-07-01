package b.g.a.b.p;

import b.g.a.b.k;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: SerializedString.java */
/* JADX INFO: loaded from: classes3.dex */
public class j implements k, Serializable {
    public static final e j = e.f667b;
    private static final long serialVersionUID = 1;
    public char[] _quotedChars;
    public byte[] _quotedUTF8Ref;
    public byte[] _unquotedUTF8Ref;
    public final String _value;
    public transient String k;

    public j(String str) {
        if (str == null) {
            throw new IllegalStateException("Null String illegal for SerializedString");
        }
        this._value = str;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        this.k = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this._value);
    }

    @Override // b.g.a.b.k
    public final char[] a() {
        char[] cArr = this._quotedChars;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrA = j.a(this._value);
        this._quotedChars = cArrA;
        return cArrA;
    }

    @Override // b.g.a.b.k
    public int b(char[] cArr, int i) {
        String str = this._value;
        int length = str.length();
        if (i + length > cArr.length) {
            return -1;
        }
        str.getChars(0, length, cArr, i);
        return length;
    }

    @Override // b.g.a.b.k
    public int c(char[] cArr, int i) {
        char[] cArrA = this._quotedChars;
        if (cArrA == null) {
            cArrA = j.a(this._value);
            this._quotedChars = cArrA;
        }
        int length = cArrA.length;
        if (i + length > cArr.length) {
            return -1;
        }
        System.arraycopy(cArrA, 0, cArr, i, length);
        return length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != j.class) {
            return false;
        }
        return this._value.equals(((j) obj)._value);
    }

    @Override // b.g.a.b.k
    public final String getValue() {
        return this._value;
    }

    public final int hashCode() {
        return this._value.hashCode();
    }

    public Object readResolve() {
        return new j(this.k);
    }

    public final String toString() {
        return this._value;
    }
}
