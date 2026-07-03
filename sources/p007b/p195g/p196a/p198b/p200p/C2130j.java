package p007b.p195g.p196a.p198b.p200p;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import p007b.p195g.p196a.p198b.InterfaceC2115k;

/* JADX INFO: renamed from: b.g.a.b.p.j */
/* JADX INFO: compiled from: SerializedString.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2130j implements InterfaceC2115k, Serializable {

    /* JADX INFO: renamed from: j */
    public static final C2125e f4558j = C2125e.f4551b;
    private static final long serialVersionUID = 1;
    public char[] _quotedChars;
    public byte[] _quotedUTF8Ref;
    public byte[] _unquotedUTF8Ref;
    public final String _value;

    /* JADX INFO: renamed from: k */
    public transient String f4559k;

    public C2130j(String str) {
        if (str == null) {
            throw new IllegalStateException("Null String illegal for SerializedString");
        }
        this._value = str;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        this.f4559k = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this._value);
    }

    @Override // p007b.p195g.p196a.p198b.InterfaceC2115k
    /* JADX INFO: renamed from: a */
    public final char[] mo1688a() {
        char[] cArr = this._quotedChars;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrM1696a = f4558j.m1696a(this._value);
        this._quotedChars = cArrM1696a;
        return cArrM1696a;
    }

    @Override // p007b.p195g.p196a.p198b.InterfaceC2115k
    /* JADX INFO: renamed from: b */
    public int mo1689b(char[] cArr, int i) {
        String str = this._value;
        int length = str.length();
        if (i + length > cArr.length) {
            return -1;
        }
        str.getChars(0, length, cArr, i);
        return length;
    }

    @Override // p007b.p195g.p196a.p198b.InterfaceC2115k
    /* JADX INFO: renamed from: c */
    public int mo1690c(char[] cArr, int i) {
        char[] cArrM1696a = this._quotedChars;
        if (cArrM1696a == null) {
            cArrM1696a = f4558j.m1696a(this._value);
            this._quotedChars = cArrM1696a;
        }
        int length = cArrM1696a.length;
        if (i + length > cArr.length) {
            return -1;
        }
        System.arraycopy(cArrM1696a, 0, cArr, i, length);
        return length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C2130j.class) {
            return false;
        }
        return this._value.equals(((C2130j) obj)._value);
    }

    @Override // p007b.p195g.p196a.p198b.InterfaceC2115k
    public final String getValue() {
        return this._value;
    }

    public final int hashCode() {
        return this._value.hashCode();
    }

    public Object readResolve() {
        return new C2130j(this.f4559k);
    }

    public final String toString() {
        return this._value;
    }
}
