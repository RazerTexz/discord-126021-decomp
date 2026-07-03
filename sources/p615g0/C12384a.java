package p615g0;

import okio.ByteString;

/* JADX INFO: renamed from: g0.a */
/* JADX INFO: compiled from: -Base64.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12384a {

    /* JADX INFO: renamed from: a */
    public static final byte[] f26067a;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        f26067a = companion.m11012c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData();
        companion.m11012c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");
    }
}
