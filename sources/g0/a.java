package g0;

import okio.ByteString;
import okio.ByteString$a;

/* JADX INFO: compiled from: -Base64.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final byte[] a;

    static {
        ByteString$a byteString$a = ByteString.k;
        a = byteString$a.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData();
        byteString$a.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");
    }
}
