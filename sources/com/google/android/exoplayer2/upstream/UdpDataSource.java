package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p257e3.AbstractC2705g;
import p007b.p225i.p226a.p242c.p257e3.C2712n;

/* JADX INFO: loaded from: classes3.dex */
public final class UdpDataSource extends AbstractC2705g {

    /* JADX INFO: renamed from: e */
    public final int f20254e;

    /* JADX INFO: renamed from: f */
    public final byte[] f20255f;

    /* JADX INFO: renamed from: g */
    public final DatagramPacket f20256g;

    /* JADX INFO: renamed from: h */
    @Nullable
    public Uri f20257h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public DatagramSocket f20258i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public MulticastSocket f20259j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public InetAddress f20260k;

    /* JADX INFO: renamed from: l */
    public boolean f20261l;

    /* JADX INFO: renamed from: m */
    public int f20262m;

    public static final class UdpDataSourceException extends DataSourceException {
        public UdpDataSourceException(Throwable th, int i) {
            super(th, i);
        }
    }

    public UdpDataSource() {
        super(true);
        this.f20254e = 8000;
        byte[] bArr = new byte[2000];
        this.f20255f = bArr;
        this.f20256g = new DatagramPacket(bArr, 0, 2000);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: a */
    public long mo2586a(C2712n c2712n) throws UdpDataSourceException {
        Uri uri = c2712n.f6542a;
        this.f20257h = uri;
        String host = uri.getHost();
        Objects.requireNonNull(host);
        int port = this.f20257h.getPort();
        m2850r(c2712n);
        try {
            this.f20260k = InetAddress.getByName(host);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f20260k, port);
            if (this.f20260k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f20259j = multicastSocket;
                multicastSocket.joinGroup(this.f20260k);
                this.f20258i = this.f20259j;
            } else {
                this.f20258i = new DatagramSocket(inetSocketAddress);
            }
            this.f20258i.setSoTimeout(this.f20254e);
            this.f20261l = true;
            m2851s(c2712n);
            return -1L;
        } catch (IOException e) {
            throw new UdpDataSourceException(e, 2001);
        } catch (SecurityException e2) {
            throw new UdpDataSourceException(e2, 2006);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    public void close() {
        this.f20257h = null;
        MulticastSocket multicastSocket = this.f20259j;
        if (multicastSocket != null) {
            try {
                InetAddress inetAddress = this.f20260k;
                Objects.requireNonNull(inetAddress);
                multicastSocket.leaveGroup(inetAddress);
            } catch (IOException unused) {
            }
            this.f20259j = null;
        }
        DatagramSocket datagramSocket = this.f20258i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f20258i = null;
        }
        this.f20260k = null;
        this.f20262m = 0;
        if (this.f20261l) {
            this.f20261l = false;
            m2849q();
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    @Nullable
    /* JADX INFO: renamed from: n */
    public Uri mo2589n() {
        return this.f20257h;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2706h
    public int read(byte[] bArr, int i, int i2) throws UdpDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        if (this.f20262m == 0) {
            try {
                DatagramSocket datagramSocket = this.f20258i;
                Objects.requireNonNull(datagramSocket);
                datagramSocket.receive(this.f20256g);
                int length = this.f20256g.getLength();
                this.f20262m = length;
                m2848p(length);
            } catch (SocketTimeoutException e) {
                throw new UdpDataSourceException(e, 2002);
            } catch (IOException e2) {
                throw new UdpDataSourceException(e2, 2001);
            }
        }
        int length2 = this.f20256g.getLength();
        int i3 = this.f20262m;
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.f20255f, length2 - i3, bArr, i, iMin);
        this.f20262m -= iMin;
        return iMin;
    }
}
