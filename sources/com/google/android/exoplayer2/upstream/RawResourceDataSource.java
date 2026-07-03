package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p257e3.AbstractC2705g;
import p007b.p225i.p226a.p242c.p257e3.C2712n;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: loaded from: classes3.dex */
public final class RawResourceDataSource extends AbstractC2705g {

    /* JADX INFO: renamed from: e */
    public final Resources f20247e;

    /* JADX INFO: renamed from: f */
    public final String f20248f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public Uri f20249g;

    /* JADX INFO: renamed from: h */
    @Nullable
    public AssetFileDescriptor f20250h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public InputStream f20251i;

    /* JADX INFO: renamed from: j */
    public long f20252j;

    /* JADX INFO: renamed from: k */
    public boolean f20253k;

    public static class RawResourceDataSourceException extends DataSourceException {
        public RawResourceDataSourceException(@Nullable String str, @Nullable Throwable th, int i) {
            super(str, th, i);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.f20247e = context.getResources();
        this.f20248f = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i) {
        StringBuilder sb = new StringBuilder(26);
        sb.append("rawresource:///");
        sb.append(i);
        return Uri.parse(sb.toString());
    }

    /* JADX WARN: Code duplicated, block: B:86:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: a */
    public long mo2586a(C2712n c2712n) throws RawResourceDataSourceException {
        int identifier;
        Uri uri = c2712n.f6542a;
        this.f20249g = uri;
        if (TextUtils.equals("rawresource", uri.getScheme())) {
            try {
                String lastPathSegment = uri.getLastPathSegment();
                Objects.requireNonNull(lastPathSegment);
                identifier = Integer.parseInt(lastPathSegment);
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.", null, PointerIconCompat.TYPE_WAIT);
            }
        } else {
            if (TextUtils.equals("android.resource", uri.getScheme()) && uri.getPathSegments().size() == 1) {
                String lastPathSegment2 = uri.getLastPathSegment();
                Objects.requireNonNull(lastPathSegment2);
                if (lastPathSegment2.matches("\\d+")) {
                    String lastPathSegment3 = uri.getLastPathSegment();
                    Objects.requireNonNull(lastPathSegment3);
                    identifier = Integer.parseInt(lastPathSegment3);
                }
            }
            if (!TextUtils.equals("android.resource", uri.getScheme())) {
                throw new RawResourceDataSourceException("URI must either use scheme rawresource or android.resource", null, PointerIconCompat.TYPE_WAIT);
            }
            String path = uri.getPath();
            Objects.requireNonNull(path);
            if (path.startsWith(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN)) {
                path = path.substring(1);
            }
            String host = uri.getHost();
            String strValueOf = String.valueOf(TextUtils.isEmpty(host) ? "" : String.valueOf(host).concat(":"));
            String strValueOf2 = String.valueOf(path);
            identifier = this.f20247e.getIdentifier(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf), "raw", this.f20248f);
            if (identifier == 0) {
                throw new RawResourceDataSourceException("Resource not found.", null, 2005);
            }
        }
        m2850r(c2712n);
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = this.f20247e.openRawResourceFd(identifier);
            this.f20250h = assetFileDescriptorOpenRawResourceFd;
            if (assetFileDescriptorOpenRawResourceFd == null) {
                String strValueOf3 = String.valueOf(uri);
                throw new RawResourceDataSourceException(C1643a.m857j(strValueOf3.length() + 24, "Resource is compressed: ", strValueOf3), null, 2000);
            }
            long length = assetFileDescriptorOpenRawResourceFd.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenRawResourceFd.getFileDescriptor());
            this.f20251i = fileInputStream;
            if (length != -1) {
                try {
                    if (c2712n.f6547f > length) {
                        throw new RawResourceDataSourceException(null, null, 2008);
                    }
                } catch (RawResourceDataSourceException e) {
                    throw e;
                } catch (IOException e2) {
                    throw new RawResourceDataSourceException(null, e2, 2000);
                }
            }
            long startOffset = assetFileDescriptorOpenRawResourceFd.getStartOffset();
            long jSkip = fileInputStream.skip(c2712n.f6547f + startOffset) - startOffset;
            if (jSkip != c2712n.f6547f) {
                throw new RawResourceDataSourceException(null, null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                if (channel.size() == 0) {
                    this.f20252j = -1L;
                } else {
                    long size = channel.size() - channel.position();
                    this.f20252j = size;
                    if (size < 0) {
                        throw new RawResourceDataSourceException(null, null, 2008);
                    }
                }
            } else {
                long j = length - jSkip;
                this.f20252j = j;
                if (j < 0) {
                    throw new DataSourceException(2008);
                }
            }
            long jMin = c2712n.f6548g;
            if (jMin != -1) {
                long j2 = this.f20252j;
                if (j2 != -1) {
                    jMin = Math.min(j2, jMin);
                }
                this.f20252j = jMin;
            }
            this.f20253k = true;
            m2851s(c2712n);
            long j3 = c2712n.f6548g;
            return j3 != -1 ? j3 : this.f20252j;
        } catch (Resources.NotFoundException e3) {
            throw new RawResourceDataSourceException(null, e3, 2005);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0037 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0055 */
    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws RawResourceDataSourceException {
        this.f20249g = null;
        try {
            InputStream inputStream = this.f20251i;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f20251i = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor = this.f20250h;
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    this.f20250h = null;
                    if (this.f20253k) {
                        this.f20253k = false;
                        m2849q();
                    }
                } catch (IOException e) {
                    throw new RawResourceDataSourceException(null, e, 2000);
                }
            } catch (Throwable th) {
                this.f20250h = null;
                if (this.f20253k) {
                    this.f20253k = false;
                    m2849q();
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new RawResourceDataSourceException(null, e2, 2000);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    @Nullable
    /* JADX INFO: renamed from: n */
    public Uri mo2589n() {
        return this.f20249g;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2706h
    public int read(byte[] bArr, int i, int i2) throws RawResourceDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f20252j;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new RawResourceDataSourceException(null, e, 2000);
            }
        }
        InputStream inputStream = this.f20251i;
        int i3 = C2738e0.f6708a;
        int i4 = inputStream.read(bArr, i, i2);
        if (i4 == -1) {
            if (this.f20252j == -1) {
                return -1;
            }
            throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j2 = this.f20252j;
        if (j2 != -1) {
            this.f20252j = j2 - ((long) i4);
        }
        m2848p(i4);
        return i4;
    }
}
