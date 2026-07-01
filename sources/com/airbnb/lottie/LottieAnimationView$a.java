package com.airbnb.lottie;

import android.graphics.PathMeasure;
import b.c.a.b0.c;
import b.c.a.b0.g;
import b.c.a.l;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView$a implements l<Throwable> {
    @Override // b.c.a.l
    public void a(Throwable th) {
        Throwable th2 = th;
        PathMeasure pathMeasure = g.a;
        if (!((th2 instanceof SocketException) || (th2 instanceof ClosedChannelException) || (th2 instanceof InterruptedIOException) || (th2 instanceof ProtocolException) || (th2 instanceof SSLException) || (th2 instanceof UnknownHostException) || (th2 instanceof UnknownServiceException))) {
            throw new IllegalStateException("Unable to parse composition", th2);
        }
        c.c("Unable to load composition.", th2);
    }
}
