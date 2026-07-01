package g0;

import okio.ByteString;

/* JADX INFO: compiled from: -Base64.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final byte[] a;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        a = companion.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData();
        companion.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");
    }
}
