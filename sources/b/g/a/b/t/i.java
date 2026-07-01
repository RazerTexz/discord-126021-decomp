package b.g.a.b.t;

import java.io.IOException;
import java.io.Serializable;

/* JADX INFO: compiled from: RequestPayload.java */
/* JADX INFO: loaded from: classes3.dex */
public class i implements Serializable {
    private static final long serialVersionUID = 1;
    public String _charset;
    public byte[] _payloadAsBytes;
    public CharSequence _payloadAsText;

    public String toString() {
        if (this._payloadAsBytes == null) {
            return this._payloadAsText.toString();
        }
        try {
            return new String(this._payloadAsBytes, this._charset);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
