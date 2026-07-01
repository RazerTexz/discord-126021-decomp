package b.c.a.a0;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.os.PowerManager$WakeLock;
import android.os.Process;
import android.os.Trace;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import b.g.a.a.p$a;
import b.i.a.b.i.d$b;
import b.i.a.c.b3.b$b;
import b.i.a.c.f3.t$a;
import b.i.a.c.g3.z.h$a;
import b.i.a.c.g3.z.h$b;
import b.i.a.c.x2.o$a;
import com.adjust.sdk.Constants;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppPermissionsRequests;
import com.discord.i18n.RenderContext;
import com.discord.player.MediaSource;
import com.discord.player.MediaType;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.file.FileUtils$CreateDirectoryException;
import com.facebook.common.file.FileUtils$FileDeleteException;
import com.facebook.common.file.FileUtils$ParentDirNotFoundException;
import com.facebook.common.file.FileUtils$RenameException;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.R$a;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.soloader.SysUtil$LollipopSysdeps;
import com.facebook.soloader.SysUtil$MarshmallowSysdeps;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import java.util.zip.Inflater;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;
import org.objectweb.asm.Opcodes;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: AnimatableValueParser.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ScheduledExecutorService f329b;

    @Nullable
    public static Boolean c;

    @Nullable
    public static Boolean d;

    @Nullable
    public static Boolean e;

    @Nullable
    public static Boolean f;

    @NonNull
    @EnsuresNonNull({"#1"})
    public static <T> T A(@Nullable T t) {
        Objects.requireNonNull(t, "null reference");
        return t;
    }

    public static ScalingUtils$ScaleType A0(TypedArray typedArray, int i) {
        switch (typedArray.getInt(i, -2)) {
            case -1:
                return null;
            case 0:
                ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
                return b.f.g.e.z.l;
            case 1:
                ScalingUtils$ScaleType scalingUtils$ScaleType2 = ScalingUtils$ScaleType.a;
                return b.f.g.e.x.l;
            case 2:
                ScalingUtils$ScaleType scalingUtils$ScaleType3 = ScalingUtils$ScaleType.a;
                return b.f.g.e.v.l;
            case 3:
                ScalingUtils$ScaleType scalingUtils$ScaleType4 = ScalingUtils$ScaleType.a;
                return b.f.g.e.w.l;
            case 4:
                ScalingUtils$ScaleType scalingUtils$ScaleType5 = ScalingUtils$ScaleType.a;
                return b.f.g.e.r.l;
            case 5:
                ScalingUtils$ScaleType scalingUtils$ScaleType6 = ScalingUtils$ScaleType.a;
                return b.f.g.e.t.l;
            case 6:
                ScalingUtils$ScaleType scalingUtils$ScaleType7 = ScalingUtils$ScaleType.a;
                return b.f.g.e.s.l;
            case 7:
                ScalingUtils$ScaleType scalingUtils$ScaleType8 = ScalingUtils$ScaleType.a;
                return b.f.g.e.b0.l;
            case 8:
                ScalingUtils$ScaleType scalingUtils$ScaleType9 = ScalingUtils$ScaleType.a;
                return b.f.g.e.u.l;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }

    public static boolean A1(b.g.a.c.c0.e0 e0Var, b.g.a.c.j jVar, Type type) {
        if (!jVar.B(e0Var.a(type)._class)) {
            return false;
        }
        ParameterizedType parameterizedTypeH1 = h1(type);
        if (parameterizedTypeH1 == null || !Objects.equals(jVar._class, parameterizedTypeH1.getRawType())) {
            return true;
        }
        Type[] actualTypeArguments = parameterizedTypeH1.getActualTypeArguments();
        b.g.a.c.h0.m mVarJ = jVar.j();
        if (mVarJ.j() != actualTypeArguments.length) {
            return false;
        }
        for (int i = 0; i < mVarJ.j(); i++) {
            if (!A1(e0Var, mVarJ.f(i), actualTypeArguments[i])) {
                return false;
            }
        }
        return true;
    }

    public static void A2(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    public static void B(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    @NonNull
    public static String B0(int i) {
        switch (i) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
            case 9:
            case 11:
            case 12:
            default:
                return b.d.b.a.a.g(32, "unknown status code: ", i);
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return "ERROR";
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
            case 19:
                return "REMOTE_EXCEPTION";
            case 20:
                return "CONNECTION_SUSPENDED_DURING_CALL";
            case 21:
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            case 22:
                return "RECONNECTION_TIMED_OUT";
        }
    }

    public static int B1(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    public static <T extends Parcelable> void B2(Parcel parcel, T t, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    public static void C(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static String[] C0() {
        return Build$VERSION.SDK_INT >= 23 ? SysUtil$MarshmallowSysdeps.getSupportedAbis() : SysUtil$LollipopSysdeps.getSupportedAbis();
    }

    public static void C1(FileChannel fileChannel, ByteBuffer byteBuffer, int i, long j) throws IOException {
        int i2;
        byteBuffer.position(0);
        byteBuffer.limit(i);
        while (byteBuffer.remaining() > 0 && (i2 = fileChannel.read(byteBuffer, j)) != -1) {
            j += (long) i2;
        }
        if (byteBuffer.remaining() > 0) {
            throw new b.f.m.h("ELF file truncated");
        }
        byteBuffer.position(0);
    }

    @Pure
    public static void D(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    public static String D0(String str) {
        return b.d.b.a.a.w("TransportRuntime.", str);
    }

    public static int D1(InputStream inputStream) throws IOException {
        byte b2 = (byte) (inputStream.read() & 255);
        return ((((byte) (inputStream.read() & 255)) << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((((byte) (inputStream.read() & 255)) << 8) & 65280) | (b2 & 255);
    }

    @Pure
    public static void E(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static Pair<Integer, Integer> E0(InputStream inputStream) throws IOException {
        inputStream.skip(7L);
        short s2 = (short) (inputStream.read() & 255);
        short s3 = (short) (inputStream.read() & 255);
        short s4 = (short) (inputStream.read() & 255);
        if (s2 == 157 && s3 == 1 && s4 == 42) {
            return new Pair<>(Integer.valueOf(n0(inputStream)), Integer.valueOf(n0(inputStream)));
        }
        return null;
    }

    public static boolean E1(@RecentlyNonNull Parcel parcel, int i) {
        x2(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static void F(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    public static Pair<Integer, Integer> F0(InputStream inputStream) throws IOException {
        w0(inputStream);
        if (((byte) (inputStream.read() & 255)) != 47) {
            return null;
        }
        int i = ((byte) inputStream.read()) & 255;
        int i2 = ((byte) inputStream.read()) & 255;
        return new Pair<>(Integer.valueOf((i | ((i2 & 63) << 8)) + 1), Integer.valueOf(((((((byte) inputStream.read()) & 255) & 15) << 10) | ((((byte) inputStream.read()) & 255) << 2) | ((i2 & Opcodes.CHECKCAST) >> 6)) + 1));
    }

    @RecentlyNonNull
    public static IBinder F1(@RecentlyNonNull Parcel parcel, int i) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iM1);
        return strongBinder;
    }

    public static void G(boolean z2, @RecentlyNonNull Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static long G0(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        C1(fileChannel, byteBuffer, 4, j);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    public static int G1(@RecentlyNonNull Parcel parcel, int i) {
        x2(parcel, i, 4);
        return parcel.readInt();
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T H(@Nullable T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException();
    }

    public static final boolean H0(Long l, long j) {
        return l != null && (l.longValue() & j) == j;
    }

    public static long H1(@RecentlyNonNull Parcel parcel, int i) {
        x2(parcel, i, 8);
        return parcel.readLong();
    }

    public static boolean I(byte[] bArr, String str) {
        if (bArr.length != str.length()) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (str.charAt(i) != bArr[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean I0(byte[] bArr, byte[] bArr2, int i) {
        Objects.requireNonNull(bArr);
        Objects.requireNonNull(bArr2);
        if (bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static int I1(b.i.a.c.f3.x xVar) {
        int i = 0;
        while (xVar.a() != 0) {
            int iT = xVar.t();
            i += iT;
            if (iT != 255) {
                return i;
            }
        }
        return -1;
    }

    public static void J(long j, b.i.a.c.f3.x xVar, b.i.a.c.x2.w[] wVarArr) {
        while (true) {
            if (xVar.a() <= 1) {
                return;
            }
            int iI1 = I1(xVar);
            int iI2 = I1(xVar);
            int i = xVar.f984b + iI2;
            if (iI2 == -1 || iI2 > xVar.a()) {
                Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                i = xVar.c;
            } else if (iI1 == 4 && iI2 >= 8) {
                int iT = xVar.t();
                int iY = xVar.y();
                int iF = iY == 49 ? xVar.f() : 0;
                int iT2 = xVar.t();
                if (iY == 47) {
                    xVar.F(1);
                }
                boolean z2 = iT == 181 && (iY == 49 || iY == 47) && iT2 == 3;
                if (iY == 49) {
                    z2 &= iF == 1195456820;
                }
                if (z2) {
                    K(j, xVar, wVarArr);
                }
            }
            xVar.E(i);
        }
    }

    public static int J0(int i, int i2) {
        return ((i + 31) * 31) + i2;
    }

    public static int J1(InputStream inputStream, int i, boolean z2) throws IOException {
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw new IOException("no more bytes");
            }
            if (z2) {
                i2 = (i5 & 255) << (i4 * 8);
            } else {
                i3 <<= 8;
                i2 = i5 & 255;
            }
            i3 |= i2;
        }
        return i3;
    }

    public static void K(long j, b.i.a.c.f3.x xVar, b.i.a.c.x2.w[] wVarArr) {
        int iT = xVar.t();
        if ((iT & 64) != 0) {
            xVar.F(1);
            int i = (iT & 31) * 3;
            int i2 = xVar.f984b;
            for (b.i.a.c.x2.w wVar : wVarArr) {
                xVar.E(i2);
                wVar.c(xVar, i);
                if (j != -9223372036854775807L) {
                    wVar.d(j, 1, i, 0, null);
                }
            }
        }
    }

    public static int K0(Object obj, Object obj2) {
        return J0(obj == null ? 0 : obj.hashCode(), obj2 != null ? obj2.hashCode() : 0);
    }

    public static long K1(b.i.a.c.f3.x xVar, int i, int i2) {
        xVar.E(i);
        if (xVar.a() < 5) {
            return -9223372036854775807L;
        }
        int iF = xVar.f();
        if ((8388608 & iF) != 0 || ((2096896 & iF) >> 8) != i2) {
            return -9223372036854775807L;
        }
        if (((iF & 32) != 0) && xVar.t() >= 7 && xVar.a() >= 7) {
            if ((xVar.t() & 16) == 16) {
                byte[] bArr = new byte[6];
                System.arraycopy(xVar.a, xVar.f984b, bArr, 0, 6);
                xVar.f984b += 6;
                return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((((long) bArr[4]) & 255) >> 7);
            }
        }
        return -9223372036854775807L;
    }

    public static void L(Drawable drawable, Drawable drawable2) {
        if (drawable == null || drawable == drawable2) {
            return;
        }
        drawable.setBounds(drawable2.getBounds());
        drawable.setChangingConfigurations(drawable2.getChangingConfigurations());
        drawable.setLevel(drawable2.getLevel());
        drawable.setVisible(drawable2.isVisible(), false);
        drawable.setState(drawable2.getState());
    }

    public static void L0(String str, String str2) {
        Log.i(D0(str), str2);
    }

    public static o$a L1(b.i.a.c.f3.x xVar) {
        xVar.F(1);
        int iV = xVar.v();
        long j = ((long) xVar.f984b) + ((long) iV);
        int i = iV / 18;
        long[] jArrCopyOf = new long[i];
        long[] jArrCopyOf2 = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            long jM = xVar.m();
            if (jM == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                break;
            }
            jArrCopyOf[i2] = jM;
            jArrCopyOf2[i2] = xVar.m();
            xVar.F(2);
        }
        xVar.F((int) (j - ((long) xVar.f984b)));
        return new o$a(jArrCopyOf, jArrCopyOf2);
    }

    @RecentlyNonNull
    public static Bundle M(@RecentlyNonNull Parcel parcel, int i) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iM1);
        return bundle;
    }

    public static int M0(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static int M1(@RecentlyNonNull Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }

    @RecentlyNonNull
    public static byte[] N(@RecentlyNonNull Parcel parcel, int i) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iM1);
        return bArrCreateByteArray;
    }

    public static <T> DataSource<T> N0(Throwable th) {
        b.f.e.h hVar = new b.f.e.h();
        Objects.requireNonNull(th);
        hVar.k(th, null);
        return hVar;
    }

    public static b.i.a.c.x2.z N1(b.i.a.c.f3.x xVar, boolean z2, boolean z3) throws ParserException {
        if (z2) {
            n2(3, xVar, false);
        }
        String strQ = xVar.q((int) xVar.j());
        int length = strQ.length() + 11;
        long j = xVar.j();
        String[] strArr = new String[(int) j];
        int length2 = length + 4;
        for (int i = 0; i < j; i++) {
            strArr[i] = xVar.q((int) xVar.j());
            length2 = length2 + 4 + strArr[i].length();
        }
        if (z3 && (xVar.t() & 1) == 0) {
            throw ParserException.a("framing bit expected to be set", null);
        }
        return new b.i.a.c.x2.z(strQ, strArr, length2 + 1);
    }

    @RecentlyNonNull
    public static int[] O(@RecentlyNonNull Parcel parcel, int i) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iM1);
        return iArrCreateIntArray;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:137:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:29:0x0067  */
    public static int O0(Map<String, List<String>> map) {
        byte b2;
        List<String> list = map.get("Content-Type");
        String str = (list == null || list.isEmpty()) ? null : list.get(0);
        if (str != null) {
            ArrayList<t$a> arrayList = b.i.a.c.f3.t.a;
            int iHashCode = str.hashCode();
            if (iHashCode != -1007807498) {
                if (iHashCode != -586683234) {
                    if (iHashCode == 187090231 && str.equals("audio/mp3")) {
                        b2 = 2;
                    } else {
                        b2 = -1;
                    }
                } else if (str.equals("audio/x-wav")) {
                    b2 = 1;
                } else {
                    b2 = -1;
                }
            } else if (str.equals("audio/x-flac")) {
                b2 = 0;
            } else {
                b2 = -1;
            }
            if (b2 == 0) {
                str = "audio/flac";
            } else if (b2 == 1) {
                str = "audio/wav";
            } else if (b2 == 2) {
                str = "audio/mpeg";
            }
            switch (str) {
                case "audio/eac3-joc":
                case "audio/ac3":
                case "audio/eac3":
                    return 0;
                case "video/mp2p":
                    return 10;
                case "video/mp2t":
                    return 11;
                case "video/webm":
                case "audio/x-matroska":
                case "application/webm":
                case "audio/webm":
                case "video/x-matroska":
                    return 6;
                case "audio/amr-wb":
                case "audio/amr":
                case "audio/3gpp":
                    return 3;
                case "image/jpeg":
                    return 14;
                case "application/mp4":
                case "audio/mp4":
                case "video/mp4":
                    return 8;
                case "text/vtt":
                    return 13;
                case "video/x-flv":
                    return 5;
                case "audio/ac4":
                    return 1;
                case "audio/ogg":
                    return 9;
                case "audio/wav":
                    return 12;
                case "audio/flac":
                    return 4;
                case "audio/mpeg":
                    return 7;
            }
        }
        return -1;
    }

    public static void O1(b$b b_b) {
        b_b.k = -3.4028235E38f;
        b_b.j = Integer.MIN_VALUE;
        CharSequence charSequence = b_b.a;
        if (charSequence instanceof Spanned) {
            if (!(charSequence instanceof Spannable)) {
                b_b.a = SpannableString.valueOf(charSequence);
            }
            CharSequence charSequence2 = b_b.a;
            Objects.requireNonNull(charSequence2);
            P1((Spannable) charSequence2, b.i.a.c.d3.h.a);
        }
    }

    public static final MediaSource P(MediaType mediaType, String str, String str2) {
        d0.z.d.m.checkNotNullParameter(mediaType, "mediaType");
        d0.z.d.m.checkNotNullParameter(str, "progressiveMediaUri");
        d0.z.d.m.checkNotNullParameter(str2, "featureTag");
        Uri uri = Uri.parse(str);
        d0.z.d.m.checkNotNullExpressionValue(uri, "Uri.parse(progressiveMediaUri)");
        return new MediaSource(uri, str2, mediaType);
    }

    public static int P0(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        return (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) ? 14 : -1;
    }

    public static void P1(Spannable spannable, b.i.b.a.h<Object> hVar) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (hVar.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    @RecentlyNonNull
    public static <T extends Parcelable> T Q(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable$Creator<T> parcelable$Creator) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        T tCreateFromParcel = parcelable$Creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iM1);
        return tCreateFromParcel;
    }

    public static void Q0(String str) {
        throw new IllegalArgumentException(b.d.b.a.a.w("Unknown library: ", str));
    }

    public static void Q1(File file, File file2) throws FileUtils$RenameException {
        Objects.requireNonNull(file);
        file2.delete();
        if (file.renameTo(file2)) {
            return;
        }
        Throwable fileUtils$FileDeleteException = null;
        if (file2.exists()) {
            fileUtils$FileDeleteException = new FileUtils$FileDeleteException(file2.getAbsolutePath());
        } else if (!file.getParentFile().exists()) {
            fileUtils$FileDeleteException = new FileUtils$ParentDirNotFoundException(file.getAbsolutePath());
        } else if (!file.exists()) {
            fileUtils$FileDeleteException = new FileNotFoundException(file.getAbsolutePath());
        }
        StringBuilder sbU = b.d.b.a.a.U("Unknown error renaming ");
        sbU.append(file.getAbsolutePath());
        sbU.append(" to ");
        sbU.append(file2.getAbsolutePath());
        throw new FileUtils$RenameException(sbU.toString(), fileUtils$FileDeleteException);
    }

    @RecentlyNonNull
    public static String R(@RecentlyNonNull Parcel parcel, int i) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iM1);
        return string;
    }

    public static boolean R0(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return (xmlPullParser.getEventType() == 3) && xmlPullParser.getName().equals(str);
    }

    public static final RenderContext R1(Function1<? super RenderContext, Unit> function1, Object... objArr) {
        d0.z.d.m.checkNotNullParameter(function1, "init");
        d0.z.d.m.checkNotNullParameter(objArr, "orderedArguments");
        RenderContext renderContext = new RenderContext();
        function1.invoke(renderContext);
        if (!(objArr.length == 0)) {
            if (!renderContext.args.isEmpty()) {
                throw new IllegalArgumentException("must provide named arguments OR formatArgs, not both.");
            }
            renderContext.orderedArguments = d0.t.k.toList(objArr);
        }
        return renderContext;
    }

    @RecentlyNonNull
    public static String[] S(@RecentlyNonNull Parcel parcel, int i) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iM1);
        return strArrCreateStringArray;
    }

    public static boolean S0(int i, int i2, b.f.j.d.e eVar) {
        if (eVar == null) {
            return ((float) o0(i)) >= 2048.0f && o0(i2) >= 2048;
        }
        return o0(i) >= eVar.a && o0(i2) >= eVar.f566b;
    }

    public static /* synthetic */ void S1(AppPermissionsRequests appPermissionsRequests, Function0 function0, Function0 function1, int i, Object obj) {
        int i2 = i & 1;
        appPermissionsRequests.requestMicrophone(null, function1);
    }

    @RecentlyNonNull
    public static ArrayList<String> T(@RecentlyNonNull Parcel parcel, int i) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iM1);
        return arrayListCreateStringArrayList;
    }

    public static boolean T0(b.f.j.j.e eVar, b.f.j.d.e eVar2) {
        if (eVar == null) {
            return false;
        }
        eVar.x();
        int i = eVar.m;
        if (i == 90 || i == 270) {
            eVar.x();
            int i2 = eVar.p;
            eVar.x();
            return S0(i2, eVar.o, eVar2);
        }
        eVar.x();
        int i3 = eVar.o;
        eVar.x();
        return S0(i3, eVar.p, eVar2);
    }

    @Nullable
    public static b.i.a.c.b3.t.f T1(@Nullable b.i.a.c.b3.t.f fVar, @Nullable String[] strArr, Map<String, b.i.a.c.b3.t.f> map) {
        int i = 0;
        if (fVar == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                b.i.a.c.b3.t.f fVar2 = new b.i.a.c.b3.t.f();
                int length = strArr.length;
                while (i < length) {
                    fVar2.a(map.get(strArr[i]));
                    i++;
                }
                return fVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                fVar.a(map.get(strArr[0]));
                return fVar;
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i < length2) {
                    fVar.a(map.get(strArr[i]));
                    i++;
                }
            }
        }
        return fVar;
    }

    @RecentlyNonNull
    public static <T> T[] U(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable$Creator<T> parcelable$Creator) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(parcelable$Creator);
        parcel.setDataPosition(iDataPosition + iM1);
        return tArr;
    }

    public static final boolean U0(Context context) {
        d0.z.d.m.checkNotNullParameter(context, "$this$isLtr");
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 0;
    }

    public static float U1(int i, float f2, int i2, int i3) {
        float f3;
        if (f2 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i == 0) {
            f3 = i3;
        } else {
            if (i != 1) {
                if (i != 2) {
                    return -3.4028235E38f;
                }
                return f2;
            }
            f3 = i2;
        }
        return f2 * f3;
    }

    @RecentlyNonNull
    public static <T> ArrayList<T> V(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable$Creator<T> parcelable$Creator) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        ArrayList<T> arrayListCreateTypedArrayList = parcel.createTypedArrayList(parcelable$Creator);
        parcel.setDataPosition(iDataPosition + iM1);
        return arrayListCreateTypedArrayList;
    }

    public static final boolean V0(VoiceState voiceState) {
        d0.z.d.m.checkNotNullParameter(voiceState, "$this$isMutedByAnySource");
        return voiceState.getSelfMute() || voiceState.getMute() || voiceState.getSuppress();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [TResult, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0, types: [TInput, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r7v0, types: [b.i.a.b.i.b, b.i.a.b.i.b<TInput, TResult, TException extends java.lang.Throwable>] */
    public static <TInput, TResult, TException extends Throwable> TResult V1(int i, TInput tinput, b.i.a.b.i.b<TInput, TResult, TException> bVar, b.i.a.b.j.s.a<TInput, TResult> aVar) throws Throwable {
        ?? r0;
        boolean z2;
        if (i < 1) {
            return (TResult) bVar.a(tinput);
        }
        while (true) {
            r0 = (TResult) bVar.a(tinput);
            b.i.a.b.i.d$a d_a = (b.i.a.b.i.d$a) tinput;
            d$b d_b = (d$b) r0;
            URL url = d_b.f746b;
            if (url != null) {
                X("CctTransportBackend", "Following redirect to: %s", url);
                z2 = (TInput) new b.i.a.b.i.d$a(d_b.f746b, d_a.f745b, d_a.c);
            } else {
                tinput = 0;
            }
            if (tinput == 0 || (i = i - 1) < 1) {
                tinput = z2;
                break;
            }
            tinput = z2;
        }
        return r0;
    }

    public static String W(String str) {
        StringBuilder sbS = b.d.b.a.a.S(b.d.b.a.a.b(str, b.d.b.a.a.b(str, 5)), ".", str, ",.", str);
        sbS.append(" *");
        return sbS.toString();
    }

    public static final boolean W0(StageInstance stageInstance) {
        d0.z.d.m.checkNotNullParameter(stageInstance, "$this$isPublic");
        return stageInstance.getPrivacyLevel() == StageInstancePrivacyLevel.PUBLIC;
    }

    public static String W1(CacheKey cacheKey) throws UnsupportedEncodingException {
        byte[] bytes = cacheKey.b().getBytes(Constants.ENCODING);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
            messageDigest.update(bytes, 0, bytes.length);
            return Base64.encodeToString(messageDigest.digest(), 11);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void X(String str, String str2, Object obj) {
        Log.d(D0(str), String.format(str2, obj));
    }

    public static final boolean X0(VoiceState voiceState) {
        d0.z.d.m.checkNotNullParameter(voiceState, "$this$isRemoveSignal");
        return voiceState.getChannelId() == null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void X1(Drawable drawable, Drawable$Callback drawable$Callback, b.f.g.e.e0 e0Var) {
        if (drawable != 0) {
            drawable.setCallback(drawable$Callback);
            if (drawable instanceof b.f.g.e.d0) {
                ((b.f.g.e.d0) drawable).b(e0Var);
            }
        }
    }

    public static void Y(String str, String str2, Object... objArr) {
        Log.d(D0(str), String.format(str2, objArr));
    }

    public static boolean Y0(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return (xmlPullParser.getEventType() == 2) && xmlPullParser.getName().equals(str);
    }

    public static void Y1(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i = 0; i < list.size(); i++) {
            mediaFormat.setByteBuffer(b.d.b.a.a.g(15, "csd-", i), ByteBuffer.wrap(list.get(i)));
        }
    }

    public static boolean Z(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                Z(file2);
            }
        }
        return file.delete();
    }

    @TargetApi(20)
    public static boolean Z0(@RecentlyNonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (c == null) {
            c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return c.booleanValue();
    }

    public static void Z1(Drawable drawable, b.f.g.e.e eVar) {
        if (drawable == null || eVar == null) {
            return;
        }
        int i = eVar.a;
        if (i != -1) {
            drawable.setAlpha(i);
        }
        if (eVar.f506b) {
            drawable.setColorFilter(eVar.c);
        }
        int i2 = eVar.d;
        if (i2 != -1) {
            drawable.setDither(i2 != 0);
        }
        int i3 = eVar.e;
        if (i3 != -1) {
            drawable.setFilterBitmap(i3 != 0);
        }
    }

    public static float a(float f2) {
        return f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((f2 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0086  */
    public static int a0(b.f.j.d.f fVar, b.f.j.d.e eVar, b.f.j.j.e eVar2, int i) {
        float fMax;
        int i2;
        int i3;
        int i4;
        int i5 = 1;
        if (!b.f.j.j.e.s(eVar2)) {
            return 1;
        }
        i(Boolean.valueOf(b.f.j.j.e.s(eVar2)));
        if (eVar == null || eVar.f566b <= 0 || eVar.a <= 0) {
            fMax = 1.0f;
        } else {
            eVar2.x();
            if (eVar2.o != 0) {
                eVar2.x();
                if (eVar2.p == 0) {
                    fMax = 1.0f;
                } else {
                    if (fVar.c()) {
                        eVar2.x();
                        i2 = eVar2.m;
                        i(Boolean.valueOf(i2 == 0 || i2 == 90 || i2 == 180 || i2 == 270));
                    } else {
                        i2 = 0;
                    }
                    boolean z2 = i2 == 90 || i2 == 270;
                    if (z2) {
                        eVar2.x();
                        i3 = eVar2.p;
                    } else {
                        eVar2.x();
                        i3 = eVar2.o;
                    }
                    if (z2) {
                        eVar2.x();
                        i4 = eVar2.o;
                    } else {
                        eVar2.x();
                        i4 = eVar2.p;
                    }
                    fMax = Math.max(eVar.a / i3, eVar.f566b / i4);
                    int i6 = b.f.d.e.a.a;
                }
            } else {
                fMax = 1.0f;
            }
        }
        eVar2.x();
        int i7 = 2;
        if (eVar2.l == b.f.i.b.a) {
            if (fMax <= 0.6666667f) {
                i5 = 2;
                while (true) {
                    int i8 = i5 * 2;
                    double d2 = 1.0d / ((double) i8);
                    if ((d2 * 0.3333333432674408d) + d2 <= fMax) {
                        break;
                    }
                    i5 = i8;
                }
            }
        } else if (fMax <= 0.6666667f) {
            while (true) {
                double d3 = i7;
                if (((1.0d / (Math.pow(d3, 2.0d) - d3)) * 0.3333333432674408d) + (1.0d / d3) <= fMax) {
                    break;
                }
                i7++;
            }
            i5 = i7 - 1;
        }
        eVar2.x();
        int i9 = eVar2.p;
        eVar2.x();
        int iMax = Math.max(i9, eVar2.o);
        float f2 = eVar != null ? eVar.c : i;
        while (iMax / i5 > f2) {
            eVar2.x();
            i5 = eVar2.l == b.f.i.b.a ? i5 * 2 : i5 + 1;
        }
        return i5;
    }

    @TargetApi(26)
    public static boolean a1(@RecentlyNonNull Context context) {
        if (!Z0(context)) {
            return false;
        }
        if (!(Build$VERSION.SDK_INT >= 24)) {
            return true;
        }
        if (d == null) {
            d = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return d.booleanValue() && !b.i.a.f.e.o.f.A0();
    }

    public static <TResult> void a2(Status status, @Nullable TResult tresult, TaskCompletionSource<TResult> taskCompletionSource) {
        if (status.w0()) {
            taskCompletionSource.a.s(tresult);
        } else {
            taskCompletionSource.a.t(new ApiException(status));
        }
    }

    public static float b(float f2) {
        return f2 <= 0.0031308f ? f2 * 12.92f : (float) ((Math.pow(f2, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static void b0(File file) throws IOException {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                b0(file2);
            }
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.canWrite() && !parentFile.setWritable(true)) {
            Log.e("SysUtil", "Enable write permission failed: " + parentFile);
        }
        if (file.delete() || !file.exists()) {
            return;
        }
        throw new IOException("Could not delete file " + file);
    }

    public static final void b1(String str, String str2) {
        d0.z.d.m.checkNotNullParameter(str, "tag");
        d0.z.d.m.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.d$default(LoggingProvider.INSTANCE.get(), str, str2, null, 4, null);
    }

    public static boolean b2(Object obj, Collection<String> collection, Collection<String> collection2) {
        if (collection == null && collection2 == null) {
            return false;
        }
        if (collection2 == null) {
            return collection.contains(obj);
        }
        if (collection == null) {
            return !collection2.contains(obj);
        }
        return !collection2.contains(obj) || collection.contains(obj);
    }

    public static void c(Spannable spannable, Object obj, int i, int i2, int i3) {
        for (Object obj2 : spannable.getSpans(i, i2, obj.getClass())) {
            if (spannable.getSpanStart(obj2) == i && spannable.getSpanEnd(obj2) == i2 && spannable.getSpanFlags(obj2) == i3) {
                spannable.removeSpan(obj2);
            }
        }
        spannable.setSpan(obj, i, i2, i3);
    }

    public static void c0(String str, String str2, Throwable th) {
        Log.e(D0(str), str2, th);
    }

    public static final void c1(String str, String str2, Throwable th) {
        d0.z.d.m.checkNotNullParameter(str, "tag");
        d0.z.d.m.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.e$default(LoggingProvider.INSTANCE.get(), str, str2, th, null, 8, null);
    }

    public static long c2(InputStream inputStream, long j) throws IOException {
        i(Boolean.valueOf(j >= 0));
        long j2 = j;
        while (j2 > 0) {
            long jSkip = inputStream.skip(j2);
            if (jSkip <= 0) {
                if (inputStream.read() == -1) {
                    return j - j2;
                }
                jSkip = 1;
            }
            j2 -= jSkip;
        }
        return j;
    }

    public static int d(int i, int i2, int i3) {
        return Math.min(Math.max(0, i3 - i), i2);
    }

    public static void d0() {
        if (b.i.a.c.f3.e0.a >= 18) {
            Trace.endSection();
        }
    }

    public static final void d1(String str, String str2) {
        d0.z.d.m.checkNotNullParameter(str, "tag");
        d0.z.d.m.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.i$default(LoggingProvider.INSTANCE.get(), str, str2, null, 4, null);
    }

    public static void d2(@RecentlyNonNull Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + M1(parcel, i));
    }

    public static byte[] e(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }

    public static synchronized void e0() {
        if (!a) {
            b.f.m.n.a.c("native-imagetranscoder");
            a = true;
        }
    }

    public static final void e1(String str, String str2) {
        d0.z.d.m.checkNotNullParameter(str, "tag");
        d0.z.d.m.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.v$default(LoggingProvider.INSTANCE.get(), str, str2, null, 4, null);
    }

    public static final <P extends Parcelable> Bundle e2(P p) {
        d0.z.d.m.checkNotNullParameter(p, "$this$toBundle");
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent_args_key", p);
        return bundle;
    }

    public static void f(String str) {
        if (b.i.a.c.f3.e0.a >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void f0(@RecentlyNonNull Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            throw new SafeParcelReader$ParseException(b.d.b.a.a.g(37, "Overread allowed size end=", i), parcel);
        }
    }

    public static final void f1(String str, String str2) {
        d0.z.d.m.checkNotNullParameter(str, "tag");
        d0.z.d.m.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.w$default(LoggingProvider.INSTANCE.get(), str, str2, null, 4, null);
    }

    public static String f2(@ColorInt int i) {
        return b.i.a.c.f3.e0.k("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(((double) Color.alpha(i)) / 255.0d));
    }

    public static List<byte[]> g(byte[] bArr) {
        long j = (((long) (((bArr[11] & 255) << 8) | (bArr[10] & 255))) * 1000000000) / 48000;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(h(j));
        arrayList.add(h(80000000L));
        return arrayList;
    }

    public static boolean g0(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean g1(b.f.j.t.a aVar, CloseableReference<Bitmap> closeableReference) {
        return false;
    }

    public static final <P extends Parcelable> Intent g2(P p) {
        d0.z.d.m.checkNotNullParameter(p, "$this$toIntent");
        Intent intentPutExtra = new Intent().putExtra("intent_args_key", p);
        d0.z.d.m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_ARGS, this)");
        return intentPutExtra;
    }

    public static byte[] h(long j) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array();
    }

    public static boolean h0(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static ParameterizedType h1(Type type) {
        if (type instanceof ParameterizedType) {
            return (ParameterizedType) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return h1(upperBounds[0]);
            }
        }
        return null;
    }

    public static b.f.d.d.i h2(Object obj) {
        return new b.f.d.d.i(obj.getClass().getSimpleName(), null);
    }

    public static void i(Boolean bool) {
        if (bool != null && !bool.booleanValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static int i0(float f2, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f3 = ((i >> 24) & 255) / 255.0f;
        float f4 = ((i2 >> 24) & 255) / 255.0f;
        float fA = a(((i >> 16) & 255) / 255.0f);
        float fA2 = a(((i >> 8) & 255) / 255.0f);
        float fA3 = a((i & 255) / 255.0f);
        float fA4 = a(((i2 >> 16) & 255) / 255.0f);
        float fA5 = a(((i2 >> 8) & 255) / 255.0f);
        float fA6 = a((i2 & 255) / 255.0f);
        float fA7 = b.d.b.a.a.a(f4, f3, f2, f3);
        float fA8 = b.d.b.a.a.a(fA4, fA, f2, fA);
        float fA9 = b.d.b.a.a.a(fA5, fA2, f2, fA2);
        float fA10 = b.d.b.a.a.a(fA6, fA3, f2, fA3);
        float fB = b(fA8) * 255.0f;
        float fB2 = b(fA9) * 255.0f;
        return Math.round(b(fA10) * 255.0f) | (Math.round(fB) << 16) | (Math.round(fA7 * 255.0f) << 24) | (Math.round(fB2) << 8);
    }

    public static TypeVariable<?> i1(Type type) {
        if (type instanceof TypeVariable) {
            return (TypeVariable) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return i1(upperBounds[0]);
            }
        }
        return null;
    }

    public static void i2(Collection<? extends Node> collection, b.a.t.b.c.a aVar) {
        Iterator<? extends Node> it = collection.iterator();
        while (it.hasNext()) {
            j2(it.next(), aVar);
        }
    }

    @Pure
    public static void j(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static String[] j0(FileChannel fileChannel) throws IOException {
        long jG0;
        long jG1;
        long jG2;
        long j;
        long jG3;
        long j2;
        long jG4;
        long j3;
        long jG5;
        long jG6;
        long jG7;
        long jG8;
        long jG9;
        int i = 8;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long jG10 = G0(fileChannel, byteBufferAllocate, 0L);
        if (jG10 != 1179403647) {
            StringBuilder sbU = b.d.b.a.a.U("file is not ELF: 0x");
            sbU.append(Long.toHexString(jG10));
            throw new b.f.m.h(sbU.toString());
        }
        C1(fileChannel, byteBufferAllocate, 1, 4L);
        boolean z2 = ((short) (byteBufferAllocate.get() & 255)) == 1;
        C1(fileChannel, byteBufferAllocate, 1, 5L);
        if (((short) (byteBufferAllocate.get() & 255)) == 2) {
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        }
        if (z2) {
            jG0 = G0(fileChannel, byteBufferAllocate, 28L);
        } else {
            C1(fileChannel, byteBufferAllocate, 8, 32L);
            jG0 = byteBufferAllocate.getLong();
        }
        C1(fileChannel, byteBufferAllocate, 2, z2 ? 44L : 56L);
        long jG11 = byteBufferAllocate.getShort() & 65535;
        C1(fileChannel, byteBufferAllocate, 2, z2 ? 42L : 54L);
        int i2 = 65535 & byteBufferAllocate.getShort();
        if (jG11 == 65535) {
            if (z2) {
                jG9 = G0(fileChannel, byteBufferAllocate, 32L);
            } else {
                C1(fileChannel, byteBufferAllocate, 8, 40L);
                jG9 = byteBufferAllocate.getLong();
            }
            jG11 = z2 ? G0(fileChannel, byteBufferAllocate, jG9 + 28) : G0(fileChannel, byteBufferAllocate, jG9 + 44);
        }
        long j4 = 0;
        long j5 = jG0;
        while (true) {
            if (j4 >= jG11) {
                jG1 = 0;
                break;
            }
            if ((z2 ? G0(fileChannel, byteBufferAllocate, j5 + 0) : G0(fileChannel, byteBufferAllocate, 0 + j5)) == 2) {
                if (!z2) {
                    C1(fileChannel, byteBufferAllocate, 8, j5 + 8);
                    jG1 = byteBufferAllocate.getLong();
                    break;
                }
                jG1 = G0(fileChannel, byteBufferAllocate, j5 + 4);
                break;
            }
            j5 += (long) i2;
            j4++;
        }
        long j6 = 0;
        if (jG1 == 0) {
            throw new b.f.m.h("ELF file does not contain dynamic linking information");
        }
        int i3 = 0;
        long j7 = jG1;
        long j8 = 0;
        while (true) {
            long j9 = j7 + j6;
            if (z2) {
                jG2 = G0(fileChannel, byteBufferAllocate, j9);
            } else {
                C1(fileChannel, byteBufferAllocate, i, j9);
                jG2 = byteBufferAllocate.getLong();
            }
            if (jG2 == 1) {
                j = jG1;
                if (i3 == Integer.MAX_VALUE) {
                    throw new b.f.m.h("malformed DT_NEEDED section");
                }
                i3++;
            } else {
                j = jG1;
                if (jG2 == 5) {
                    if (z2) {
                        jG3 = G0(fileChannel, byteBufferAllocate, j7 + 4);
                    } else {
                        C1(fileChannel, byteBufferAllocate, 8, j7 + 8);
                        jG3 = byteBufferAllocate.getLong();
                    }
                    j8 = jG3;
                }
            }
            long j10 = 16;
            j7 += z2 ? 8L : 16L;
            long j11 = 0;
            if (jG2 != 0) {
                i = 8;
                jG1 = j;
                j6 = 0;
            } else {
                if (j8 == 0) {
                    throw new b.f.m.h("Dynamic section string-table not found");
                }
                int i4 = 0;
                int i5 = i3;
                while (true) {
                    if (i4 >= jG11) {
                        j2 = 0;
                        break;
                    }
                    if ((z2 ? G0(fileChannel, byteBufferAllocate, jG0 + j11) : G0(fileChannel, byteBufferAllocate, jG0 + j11)) == 1) {
                        if (z2) {
                            jG6 = G0(fileChannel, byteBufferAllocate, jG0 + 8);
                        } else {
                            C1(fileChannel, byteBufferAllocate, 8, j10 + jG0);
                            jG6 = byteBufferAllocate.getLong();
                        }
                        if (z2) {
                            jG7 = G0(fileChannel, byteBufferAllocate, 20 + jG0);
                        } else {
                            C1(fileChannel, byteBufferAllocate, 8, 40 + jG0);
                            jG7 = byteBufferAllocate.getLong();
                        }
                        if (jG6 <= j8 && j8 < jG7 + jG6) {
                            if (z2) {
                                jG8 = G0(fileChannel, byteBufferAllocate, jG0 + 4);
                            } else {
                                C1(fileChannel, byteBufferAllocate, 8, jG0 + 8);
                                jG8 = byteBufferAllocate.getLong();
                            }
                            j2 = (j8 - jG6) + jG8;
                            break;
                        }
                    } else {
                        jG11 = jG11;
                    }
                    jG0 += (long) i2;
                    i4++;
                    j10 = 16;
                    j11 = 0;
                    jG11 = jG11;
                }
                if (j2 == 0) {
                    throw new b.f.m.h("did not find file offset of DT_STRTAB table");
                }
                String[] strArr = new String[i5];
                long j12 = 0;
                long j13 = j;
                int i6 = 0;
                while (true) {
                    long j14 = j12 + j13;
                    if (z2) {
                        jG4 = G0(fileChannel, byteBufferAllocate, j14);
                    } else {
                        C1(fileChannel, byteBufferAllocate, 8, j14);
                        jG4 = byteBufferAllocate.getLong();
                    }
                    if (jG4 == 1) {
                        if (z2) {
                            jG5 = G0(fileChannel, byteBufferAllocate, 4 + j13);
                        } else {
                            C1(fileChannel, byteBufferAllocate, 8, j13 + 8);
                            jG5 = byteBufferAllocate.getLong();
                        }
                        long j15 = jG5 + j2;
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            long j16 = j15 + 1;
                            j3 = j2;
                            C1(fileChannel, byteBufferAllocate, 1, j15);
                            short s2 = (short) (byteBufferAllocate.get() & 255);
                            if (s2 == 0) {
                                break;
                            }
                            sb.append((char) s2);
                            j15 = j16;
                            j2 = j3;
                        }
                        strArr[i6] = sb.toString();
                        if (i6 == Integer.MAX_VALUE) {
                            throw new b.f.m.h("malformed DT_NEEDED section");
                        }
                        i6++;
                    } else {
                        j3 = j2;
                    }
                    j13 += z2 ? 8L : 16L;
                    if (jG4 == 0) {
                        if (i6 == i5) {
                            return strArr;
                        }
                        throw new b.f.m.h("malformed DT_NEEDED section");
                    }
                    j12 = 0;
                    j2 = j3;
                }
            }
        }
    }

    public static void j1(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static void j2(Node node, b.a.t.b.c.a aVar) {
        if (node.hasChildren()) {
            Iterator it = node.getChildren().iterator();
            while (it.hasNext()) {
                j2((Node) it.next(), aVar);
            }
        }
        aVar.processNode(node);
    }

    public static void k(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static String k0(String str, Object... objArr) {
        int iIndexOf;
        String strValueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder((objArr.length * 16) + strValueOf.length());
        int i = 0;
        int i2 = 0;
        while (i < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i2)) != -1) {
            sb.append(strValueOf.substring(i2, iIndexOf));
            sb.append(objArr[i]);
            i2 = iIndexOf + 2;
            i++;
        }
        sb.append(strValueOf.substring(i2));
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i3 = i + 1; i3 < objArr.length; i3++) {
                sb.append(", ");
                sb.append(objArr[i3]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static String k1(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void k2(Node node, b.a.t.b.c.a aVar) {
        aVar.processNode(node);
        if (node.hasChildren()) {
            Iterator it = node.getChildren().iterator();
            while (it.hasNext()) {
                k2((Node) it.next(), aVar);
            }
        }
    }

    public static void l(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    @NonNull
    public static ApiException l0(@NonNull Status status) {
        return status.r != null ? new ResolvableApiException(status) : new ApiException(status);
    }

    public static void l1(File file) throws FileUtils$CreateDirectoryException {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (!file.delete()) {
                throw new FileUtils$CreateDirectoryException(file.getAbsolutePath(), new FileUtils$FileDeleteException(file.getAbsolutePath()));
            }
        }
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new FileUtils$CreateDirectoryException(file.getAbsolutePath());
        }
    }

    /* JADX WARN: Code duplicated, block: B:160:0x0266 A[PHI: r1 r2 r3
      0x0266: PHI (r1v20 boolean) = (r1v15 boolean), (r1v22 boolean) binds: [B:159:0x0264, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]
      0x0266: PHI (r2v17 boolean) = (r2v12 boolean), (r2v19 boolean) binds: [B:159:0x0264, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]
      0x0266: PHI (r3v10 boolean) = (r3v6 boolean), (r3v12 boolean) binds: [B:159:0x0264, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:161:0x0268 A[PHI: r1 r2 r3
      0x0268: PHI (r1v17 boolean) = (r1v15 boolean), (r1v15 boolean), (r1v22 boolean), (r1v22 boolean) binds: [B:158:0x0262, B:159:0x0264, B:143:0x0248, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]
      0x0268: PHI (r2v14 boolean) = (r2v12 boolean), (r2v12 boolean), (r2v19 boolean), (r2v19 boolean) binds: [B:158:0x0262, B:159:0x0264, B:143:0x0248, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]
      0x0268: PHI (r3v8 boolean) = (r3v6 boolean), (r3v6 boolean), (r3v12 boolean), (r3v12 boolean) binds: [B:158:0x0262, B:159:0x0264, B:143:0x0248, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]] */
    public static b.f.g.f.a l2(b.f.g.f.a aVar, Context context, AttributeSet attributeSet) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        int integer;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        boolean z9;
        Context context2 = context;
        int i3 = 1;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$a.GenericDraweeHierarchy);
            try {
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                int i4 = 0;
                int dimensionPixelSize = 0;
                integer = 0;
                boolean z10 = true;
                boolean z11 = true;
                boolean z12 = true;
                boolean z13 = true;
                boolean z14 = true;
                boolean z15 = true;
                boolean z16 = true;
                boolean z17 = true;
                while (i4 < indexCount) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i4);
                    if (index == R$a.GenericDraweeHierarchy_actualImageScaleType) {
                        aVar.n = A0(typedArrayObtainStyledAttributes, index);
                    } else if (index == R$a.GenericDraweeHierarchy_placeholderImage) {
                        aVar.f = u0(context2, typedArrayObtainStyledAttributes, index);
                    } else {
                        if (index == R$a.GenericDraweeHierarchy_pressedStateOverlayImage) {
                            Drawable drawableU0 = u0(context2, typedArrayObtainStyledAttributes, index);
                            if (drawableU0 == null) {
                                aVar.q = null;
                            } else {
                                StateListDrawable stateListDrawable = new StateListDrawable();
                                i2 = indexCount;
                                int[] iArr = new int[i3];
                                iArr[0] = 16842919;
                                stateListDrawable.addState(iArr, drawableU0);
                                aVar.q = stateListDrawable;
                            }
                        } else {
                            i2 = indexCount;
                            if (index == R$a.GenericDraweeHierarchy_progressBarImage) {
                                aVar.l = u0(context2, typedArrayObtainStyledAttributes, index);
                            } else if (index == R$a.GenericDraweeHierarchy_fadeDuration) {
                                aVar.d = typedArrayObtainStyledAttributes.getInt(index, 0);
                            } else if (index == R$a.GenericDraweeHierarchy_viewAspectRatio) {
                                aVar.e = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                            } else if (index == R$a.GenericDraweeHierarchy_placeholderImageScaleType) {
                                aVar.g = A0(typedArrayObtainStyledAttributes, index);
                            } else if (index == R$a.GenericDraweeHierarchy_retryImage) {
                                aVar.h = u0(context2, typedArrayObtainStyledAttributes, index);
                            } else if (index == R$a.GenericDraweeHierarchy_retryImageScaleType) {
                                aVar.i = A0(typedArrayObtainStyledAttributes, index);
                            } else if (index == R$a.GenericDraweeHierarchy_failureImage) {
                                aVar.j = u0(context2, typedArrayObtainStyledAttributes, index);
                            } else if (index == R$a.GenericDraweeHierarchy_failureImageScaleType) {
                                aVar.k = A0(typedArrayObtainStyledAttributes, index);
                            } else if (index == R$a.GenericDraweeHierarchy_progressBarImageScaleType) {
                                aVar.m = A0(typedArrayObtainStyledAttributes, index);
                            } else {
                                if (index == R$a.GenericDraweeHierarchy_progressBarAutoRotateInterval) {
                                    integer = typedArrayObtainStyledAttributes.getInteger(index, integer);
                                } else if (index == R$a.GenericDraweeHierarchy_backgroundImage) {
                                    aVar.o = u0(context2, typedArrayObtainStyledAttributes, index);
                                } else if (index == R$a.GenericDraweeHierarchy_overlayImage) {
                                    aVar.b(u0(context2, typedArrayObtainStyledAttributes, index));
                                } else if (index == R$a.GenericDraweeHierarchy_roundAsCircle) {
                                    if (aVar.r == null) {
                                        aVar.r = new b.f.g.f.c();
                                    }
                                    aVar.r.f523b = typedArrayObtainStyledAttributes.getBoolean(index, false);
                                } else if (index == R$a.GenericDraweeHierarchy_roundedCornerRadius) {
                                    dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize);
                                } else if (index == R$a.GenericDraweeHierarchy_roundTopLeft) {
                                    z10 = typedArrayObtainStyledAttributes.getBoolean(index, z10);
                                } else {
                                    if (index == R$a.GenericDraweeHierarchy_roundTopRight) {
                                        z13 = typedArrayObtainStyledAttributes.getBoolean(index, z13);
                                    } else {
                                        if (index == R$a.GenericDraweeHierarchy_roundBottomLeft) {
                                            z8 = typedArrayObtainStyledAttributes.getBoolean(index, z17);
                                        } else {
                                            z8 = z17;
                                            if (index == R$a.GenericDraweeHierarchy_roundBottomRight) {
                                                z14 = typedArrayObtainStyledAttributes.getBoolean(index, z14);
                                            } else if (index == R$a.GenericDraweeHierarchy_roundTopStart) {
                                                z11 = typedArrayObtainStyledAttributes.getBoolean(index, z11);
                                            } else if (index == R$a.GenericDraweeHierarchy_roundTopEnd) {
                                                z12 = typedArrayObtainStyledAttributes.getBoolean(index, z12);
                                            } else {
                                                if (index == R$a.GenericDraweeHierarchy_roundBottomStart) {
                                                    z9 = typedArrayObtainStyledAttributes.getBoolean(index, z16);
                                                } else {
                                                    z9 = z16;
                                                    if (index == R$a.GenericDraweeHierarchy_roundBottomEnd) {
                                                        z15 = typedArrayObtainStyledAttributes.getBoolean(index, z15);
                                                    } else if (index == R$a.GenericDraweeHierarchy_roundWithOverlayColor) {
                                                        if (aVar.r == null) {
                                                            aVar.r = new b.f.g.f.c();
                                                        }
                                                        aVar.r.b(typedArrayObtainStyledAttributes.getColor(index, 0));
                                                    } else if (index == R$a.GenericDraweeHierarchy_roundingBorderWidth) {
                                                        if (aVar.r == null) {
                                                            aVar.r = new b.f.g.f.c();
                                                        }
                                                        b.f.g.f.c cVar = aVar.r;
                                                        float dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                                                        Objects.requireNonNull(cVar);
                                                        k(dimensionPixelSize2 >= 0.0f, "the border width cannot be < 0");
                                                        cVar.e = dimensionPixelSize2;
                                                    } else {
                                                        dimensionPixelSize = dimensionPixelSize;
                                                        if (index == R$a.GenericDraweeHierarchy_roundingBorderColor) {
                                                            if (aVar.r == null) {
                                                                aVar.r = new b.f.g.f.c();
                                                            }
                                                            aVar.r.f = typedArrayObtainStyledAttributes.getColor(index, 0);
                                                        } else if (index == R$a.GenericDraweeHierarchy_roundingBorderPadding) {
                                                            if (aVar.r == null) {
                                                                aVar.r = new b.f.g.f.c();
                                                            }
                                                            b.f.g.f.c cVar2 = aVar.r;
                                                            float dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                                                            Objects.requireNonNull(cVar2);
                                                            k(dimensionPixelSize3 >= 0.0f, "the padding cannot be < 0");
                                                            cVar2.g = dimensionPixelSize3;
                                                        }
                                                    }
                                                }
                                                dimensionPixelSize = dimensionPixelSize;
                                            }
                                        }
                                        dimensionPixelSize = dimensionPixelSize;
                                        z9 = z16;
                                    }
                                    dimensionPixelSize = dimensionPixelSize;
                                    z17 = z8;
                                    i4++;
                                    context2 = context;
                                    z16 = z9;
                                    i3 = 1;
                                    indexCount = i2;
                                }
                                z9 = z16;
                                i4++;
                                context2 = context;
                                z16 = z9;
                                i3 = 1;
                                indexCount = i2;
                            }
                        }
                        z9 = z16;
                        z8 = z17;
                        dimensionPixelSize = dimensionPixelSize;
                        dimensionPixelSize = dimensionPixelSize;
                        z17 = z8;
                        i4++;
                        context2 = context;
                        z16 = z9;
                        i3 = 1;
                        indexCount = i2;
                    }
                    i2 = indexCount;
                    z9 = z16;
                    z8 = z17;
                    dimensionPixelSize = dimensionPixelSize;
                    dimensionPixelSize = dimensionPixelSize;
                    z17 = z8;
                    i4++;
                    context2 = context;
                    z16 = z9;
                    i3 = 1;
                    indexCount = i2;
                }
                boolean z18 = z16;
                boolean z19 = z17;
                int i5 = dimensionPixelSize;
                typedArrayObtainStyledAttributes.recycle();
                if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
                    z6 = z10 && z12;
                    z7 = z13 && z11;
                    z4 = z14 && z18;
                    if (z19 && z15) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                } else {
                    z6 = z10 && z11;
                    z7 = z13 && z12;
                    z4 = z14 && z15;
                    if (z19 && z18) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                }
                i = i5;
                boolean z20 = z7;
                z3 = z6;
                z2 = z20;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                context.getResources().getConfiguration().getLayoutDirection();
                throw th;
            }
        } else {
            z2 = true;
            z3 = true;
            z4 = true;
            z5 = true;
            i = 0;
            integer = 0;
        }
        if (aVar.l != null && integer > 0) {
            aVar.l = new b.f.g.e.c(aVar.l, integer);
        }
        if (i > 0) {
            if (aVar.r == null) {
                aVar.r = new b.f.g.f.c();
            }
            b.f.g.f.c cVar3 = aVar.r;
            float f2 = z3 ? i : 0.0f;
            float f3 = z2 ? i : 0.0f;
            float f4 = z4 ? i : 0.0f;
            float f5 = z5 ? i : 0.0f;
            if (cVar3.c == null) {
                cVar3.c = new float[8];
            }
            float[] fArr = cVar3.c;
            fArr[1] = f2;
            fArr[0] = f2;
            fArr[3] = f3;
            fArr[2] = f3;
            fArr[5] = f4;
            fArr[4] = f4;
            fArr[7] = f5;
            fArr[6] = f5;
        }
        return aVar;
    }

    @Pure
    public static void m(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void m0(File file) throws IOException {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("cannot list directory " + file);
            }
            for (File file2 : fileArrListFiles) {
                m0(file2);
            }
            return;
        }
        if (file.getPath().endsWith("_lock")) {
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static int m1(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & ViewCompat.MEASURED_SIZE_MASK;
        }
        return (i & ViewCompat.MEASURED_SIZE_MASK) | ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24);
    }

    public static int m2(@RecentlyNonNull Parcel parcel) {
        int i = parcel.readInt();
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (((char) i) != 20293) {
            String strValueOf = String.valueOf(Integer.toHexString(i));
            throw new SafeParcelReader$ParseException(strValueOf.length() != 0 ? "Expected object header. Got 0x".concat(strValueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i2 = iM1 + iDataPosition;
        if (i2 < iDataPosition || i2 > parcel.dataSize()) {
            throw new SafeParcelReader$ParseException(b.d.b.a.a.h(54, "Size read is invalid start=", iDataPosition, " end=", i2), parcel);
        }
        return i2;
    }

    public static void n(boolean z2, @RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        if (!z2) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static int n0(InputStream inputStream) throws IOException {
        return ((((byte) inputStream.read()) << 8) & 65280) | (((byte) inputStream.read()) & 255);
    }

    public static final Integer n1(JsonReader jsonReader) throws IOException {
        d0.z.d.m.checkNotNullParameter(jsonReader, "$this$nextIntOrNull");
        if (jsonReader.N() != JsonToken.NULL) {
            return Integer.valueOf(jsonReader.y());
        }
        jsonReader.H();
        return null;
    }

    public static boolean n2(int i, b.i.a.c.f3.x xVar, boolean z2) throws ParserException {
        if (xVar.a() < 7) {
            if (z2) {
                return false;
            }
            throw b.d.b.a.a.w0(29, "too short header: ", xVar.a(), null);
        }
        if (xVar.t() != i) {
            if (z2) {
                return false;
            }
            String strValueOf = String.valueOf(Integer.toHexString(i));
            throw ParserException.a(strValueOf.length() != 0 ? "expected header type ".concat(strValueOf) : new String("expected header type "), null);
        }
        if (xVar.t() == 118 && xVar.t() == 111 && xVar.t() == 114 && xVar.t() == 98 && xVar.t() == 105 && xVar.t() == 115) {
            return true;
        }
        if (z2) {
            return false;
        }
        throw ParserException.a("expected characters 'vorbis'", null);
    }

    public static void o(boolean z2, @RecentlyNonNull Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int o0(int i) {
        return (int) (i * 1.3333334f);
    }

    @Nullable
    public static <T> List<b.c.a.c0.a<T>> o1(b.c.a.a0.i0.c cVar, b.c.a.d dVar, h0<T> h0Var) throws IOException {
        return r.a(cVar, dVar, 1.0f, h0Var);
    }

    public static void o2(File file, b.f.d.c.a aVar) {
        aVar.b(file);
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    o2(file2, aVar);
                } else {
                    aVar.a(file2);
                }
            }
        }
        aVar.c(file);
    }

    public static void p(int i, int i2, int i3, int i4, int i5) {
        i(Boolean.valueOf(i4 >= 0));
        i(Boolean.valueOf(i >= 0));
        i(Boolean.valueOf(i3 >= 0));
        i(Boolean.valueOf(i + i4 <= i5));
        i(Boolean.valueOf(i3 + i4 <= i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b.f.g.e.p p0(Drawable drawable) {
        if (drawable == 0) {
            return null;
        }
        if (drawable instanceof b.f.g.e.p) {
            return (b.f.g.e.p) drawable;
        }
        if (drawable instanceof b.f.g.e.d) {
            return p0(((b.f.g.e.d) drawable).l());
        }
        if (drawable instanceof b.f.g.e.b) {
            b.f.g.e.b bVar = (b.f.g.e.b) drawable;
            int length = bVar.l.length;
            for (int i = 0; i < length; i++) {
                b.f.g.e.p pVarP0 = p0(bVar.a(i));
                if (pVarP0 != null) {
                    return pVarP0;
                }
            }
        }
        return null;
    }

    public static b.c.a.y.k.a p1(b.c.a.a0.i0.c cVar, b.c.a.d dVar) throws IOException {
        return new b.c.a.y.k.a(o1(cVar, dVar, f.a));
    }

    public static void p2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Bundle bundle, boolean z2) {
        if (bundle == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iY2 = y2(parcel, i);
            parcel.writeBundle(bundle);
            A2(parcel, iY2);
        }
    }

    @Pure
    public static void q(boolean z2, @Nullable String str) throws ParserException {
        if (!z2) {
            throw ParserException.a(str, null);
        }
    }

    public static Object q0(Object obj) {
        return new d$a(obj.getClass(), Array.getLength(obj), obj);
    }

    public static b.c.a.y.k.b q1(b.c.a.a0.i0.c cVar, b.c.a.d dVar) throws IOException {
        return r1(cVar, dVar, true);
    }

    public static void q2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull byte[] bArr, boolean z2) {
        if (bArr == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iY2 = y2(parcel, i);
            parcel.writeByteArray(bArr);
            A2(parcel, iY2);
        }
    }

    public static boolean r(b.i.a.c.x2.i iVar) throws IOException {
        b.i.a.c.f3.x xVar = new b.i.a.c.f3.x(8);
        if (b.i.a.c.x2.l0.d.a(iVar, xVar).a != 1380533830) {
            return false;
        }
        iVar.o(xVar.a, 0, 4);
        xVar.E(0);
        int iF = xVar.f();
        if (iF == 1463899717) {
            return true;
        }
        StringBuilder sb = new StringBuilder(34);
        sb.append("Unsupported form type: ");
        sb.append(iF);
        Log.e("WavHeaderReader", sb.toString());
        return false;
    }

    @Nullable
    public static String r0(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (xmlPullParser.getAttributeName(i).equals(str)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    public static b.c.a.y.k.b r1(b.c.a.a0.i0.c cVar, b.c.a.d dVar, boolean z2) throws IOException {
        return new b.c.a.y.k.b(r.a(cVar, dVar, z2 ? b.c.a.b0.g.c() : 1.0f, i.a));
    }

    public static void r2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull IBinder iBinder, boolean z2) {
        if (iBinder == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iY2 = y2(parcel, i);
            parcel.writeStrongBinder(iBinder);
            A2(parcel, iY2);
        }
    }

    public static void s(@RecentlyNonNull Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            String name = looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper";
            String name2 = handler.getLooper().getThread().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name2).length() + 36 + String.valueOf(name).length());
            b.d.b.a.a.s0(sb, "Must be called on ", name2, " thread, but got ", name);
            sb.append(".");
            throw new IllegalStateException(sb.toString());
        }
    }

    public static int s0(int i) {
        if (i == 3) {
            return 180;
        }
        if (i != 6) {
            return i != 8 ? 0 : 270;
        }
        return 90;
    }

    public static b.c.a.y.k.d s1(b.c.a.a0.i0.c cVar, b.c.a.d dVar) throws IOException {
        return new b.c.a.y.k.d(o1(cVar, dVar, o.a));
    }

    public static void s2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable parcelable, int i2, boolean z2) {
        if (parcelable == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iY2 = y2(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            A2(parcel, iY2);
        }
    }

    @Pure
    public static int t(int i, int i2, int i3) {
        if (i < i2 || i >= i3) {
            throw new IndexOutOfBoundsException();
        }
        return i;
    }

    public static Object t0(b.g.a.c.j jVar) {
        Class<?> cls = jVar._class;
        Class<?> clsV = b.g.a.c.i0.d.v(cls);
        if (clsV == null) {
            if (jVar.v() || jVar.b()) {
                return p$a.NON_EMPTY;
            }
            if (cls == String.class) {
                return "";
            }
            if (jVar.B(Date.class)) {
                return new Date(0L);
            }
            if (!jVar.B(Calendar.class)) {
                return null;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(0L);
            return gregorianCalendar;
        }
        if (clsV == Integer.TYPE) {
            return 0;
        }
        if (clsV == Long.TYPE) {
            return 0L;
        }
        if (clsV == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (clsV == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (clsV == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (clsV == Byte.TYPE) {
            return (byte) 0;
        }
        if (clsV == Short.TYPE) {
            return (short) 0;
        }
        if (clsV == Character.TYPE) {
            return (char) 0;
        }
        throw new IllegalArgumentException(b.d.b.a.a.o(clsV, b.d.b.a.a.U("Class "), " is not a primitive type"));
    }

    /* JADX WARN: Code duplicated, block: B:35:0x007f  */
    @Nullable
    public static ArrayList<h$a> t1(b.i.a.c.f3.x xVar) {
        ArrayList<h$a> arrayList;
        int i;
        ArrayList<h$a> arrayList2;
        h$a h_a;
        b.i.a.c.f3.x xVar2 = xVar;
        if (xVar.t() != 0) {
            return null;
        }
        xVar2.F(7);
        int iF = xVar.f();
        if (iF == 1684433976) {
            b.i.a.c.f3.x xVar3 = new b.i.a.c.f3.x();
            Inflater inflater = new Inflater(true);
            try {
                if (!b.i.a.c.f3.e0.x(xVar2, xVar3, inflater)) {
                    inflater.end();
                    return null;
                }
                inflater.end();
                xVar2 = xVar3;
            } catch (Throwable th) {
                inflater.end();
                throw th;
            }
        } else if (iF != 1918990112) {
            return null;
        }
        ArrayList<h$a> arrayList3 = new ArrayList<>();
        int i2 = xVar2.f984b;
        int i3 = xVar2.c;
        while (i2 < i3) {
            int iF2 = xVar2.f() + i2;
            if (iF2 > i2 && iF2 <= i3) {
                if (xVar2.f() == 1835365224) {
                    int iF3 = xVar2.f();
                    if (iF3 > 10000) {
                        arrayList2 = arrayList3;
                        i = i3;
                        h_a = null;
                    } else {
                        float[] fArr = new float[iF3];
                        for (int i4 = 0; i4 < iF3; i4++) {
                            fArr[i4] = Float.intBitsToFloat(xVar2.f());
                        }
                        int iF4 = xVar2.f();
                        if (iF4 > 32000) {
                            arrayList2 = arrayList3;
                        } else {
                            double dLog = Math.log(2.0d);
                            arrayList2 = arrayList3;
                            int iCeil = (int) Math.ceil(Math.log(((double) iF3) * 2.0d) / dLog);
                            b.i.a.c.f3.w wVar = new b.i.a.c.f3.w(xVar2.a);
                            wVar.k(xVar2.f984b * 8);
                            float[] fArr2 = new float[iF4 * 5];
                            int i5 = 5;
                            int[] iArr = new int[5];
                            int i6 = 0;
                            int i7 = 0;
                            while (true) {
                                if (i6 < iF4) {
                                    int i8 = 0;
                                    while (true) {
                                        if (i8 < i5) {
                                            int i9 = iArr[i8];
                                            int iG = wVar.g(iCeil);
                                            int i10 = i9 + ((-(iG & 1)) ^ (iG >> 1));
                                            if (i10 < iF3 && i10 >= 0) {
                                                fArr2[i7] = fArr[i10];
                                                iArr[i8] = i10;
                                                i8++;
                                                i7++;
                                                i5 = 5;
                                            }
                                        } else {
                                            i6++;
                                            i5 = 5;
                                        }
                                    }
                                } else {
                                    wVar.k((wVar.e() + 7) & (-8));
                                    int i11 = 32;
                                    int iG2 = wVar.g(32);
                                    h$b[] h_bArr = new h$b[iG2];
                                    int i12 = 0;
                                    while (true) {
                                        if (i12 < iG2) {
                                            int iG3 = wVar.g(8);
                                            int iG4 = wVar.g(8);
                                            int iG5 = wVar.g(i11);
                                            if (iG5 <= 128000) {
                                                i = i3;
                                                int iCeil2 = (int) Math.ceil(Math.log(((double) iF4) * 2.0d) / dLog);
                                                float[] fArr3 = new float[iG5 * 3];
                                                float[] fArr4 = new float[iG5 * 2];
                                                int i13 = 0;
                                                int i14 = 0;
                                                while (true) {
                                                    if (i13 < iG5) {
                                                        int iG6 = wVar.g(iCeil2);
                                                        int i15 = iG6 >> 1;
                                                        b.i.a.c.f3.w wVar2 = wVar;
                                                        int i16 = iG6 & 1;
                                                        int i17 = iG2;
                                                        float[] fArr5 = fArr4;
                                                        int i18 = i14 + ((-i16) ^ i15);
                                                        if (i18 >= 0 && i18 < iF4) {
                                                            int i19 = i13 * 3;
                                                            int i20 = i18 * 5;
                                                            fArr3[i19] = fArr2[i20];
                                                            fArr3[i19 + 1] = fArr2[i20 + 1];
                                                            fArr3[i19 + 2] = fArr2[i20 + 2];
                                                            int i21 = i13 * 2;
                                                            fArr5[i21] = fArr2[i20 + 3];
                                                            fArr5[i21 + 1] = fArr2[i20 + 4];
                                                            i13++;
                                                            i14 = i18;
                                                            fArr4 = fArr5;
                                                            iG2 = i17;
                                                            wVar = wVar2;
                                                        }
                                                    } else {
                                                        h_bArr[i12] = new h$b(iG3, fArr3, fArr4, iG4);
                                                        i12++;
                                                        i3 = i;
                                                        iG2 = iG2;
                                                        i11 = 32;
                                                    }
                                                }
                                            }
                                            h_a = null;
                                        } else {
                                            i = i3;
                                            h_a = new h$a(h_bArr);
                                        }
                                    }
                                }
                            }
                        }
                        i = i3;
                        h_a = null;
                    }
                    if (h_a != null) {
                        arrayList = arrayList2;
                        arrayList.add(h_a);
                    }
                } else {
                    arrayList = arrayList3;
                    i = i3;
                }
                xVar2.E(iF2);
                arrayList3 = arrayList;
                i2 = iF2;
                i3 = i;
            }
            return null;
        }
        return arrayList3;
    }

    public static void t2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull String str, boolean z2) {
        if (str == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iY2 = y2(parcel, i);
            parcel.writeString(str);
            A2(parcel, iY2);
        }
    }

    public static void u(@RecentlyNonNull String str) {
        if (!(Looper.getMainLooper() == Looper.myLooper())) {
            throw new IllegalStateException(str);
        }
    }

    public static Drawable u0(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getResources().getDrawable(resourceId);
    }

    public static b.c.a.y.k.f u1(b.c.a.a0.i0.c cVar, b.c.a.d dVar) throws IOException {
        return new b.c.a.y.k.f(r.a(cVar, dVar, b.c.a.b0.g.c(), w.a));
    }

    public static void u2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull String[] strArr, boolean z2) {
        if (strArr == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iY2 = y2(parcel, i);
            parcel.writeStringArray(strArr);
            A2(parcel, iY2);
        }
    }

    @RecentlyNonNull
    @EnsuresNonNull({"#1"})
    public static String v(@Nullable String str, @RecentlyNonNull Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    @RecentlyNonNull
    public static String v0(@RecentlyNonNull PowerManager$WakeLock powerManager$WakeLock, @RecentlyNonNull String str) {
        String strValueOf = String.valueOf(String.valueOf(((long) System.identityHashCode(powerManager$WakeLock)) | (((long) Process.myPid()) << 32)));
        String strValueOf2 = String.valueOf(true == TextUtils.isEmpty(null) ? "" : null);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    @Nullable
    public static b.i.a.c.x2.i0.j v1(byte[] bArr) {
        b.i.a.c.f3.x xVar = new b.i.a.c.f3.x(bArr);
        if (xVar.c < 32) {
            return null;
        }
        xVar.E(0);
        if (xVar.f() != xVar.a() + 4 || xVar.f() != 1886614376) {
            return null;
        }
        int iF = (xVar.f() >> 24) & 255;
        if (iF > 1) {
            b.d.b.a.a.g0(37, "Unsupported pssh version: ", iF, "PsshAtomUtil");
            return null;
        }
        UUID uuid = new UUID(xVar.m(), xVar.m());
        if (iF == 1) {
            xVar.F(xVar.w() * 16);
        }
        int iW = xVar.w();
        if (iW != xVar.a()) {
            return null;
        }
        byte[] bArr2 = new byte[iW];
        System.arraycopy(xVar.a, xVar.f984b, bArr2, 0, iW);
        xVar.f984b += iW;
        return new b.i.a.c.x2.i0.j(uuid, iF, bArr2);
    }

    public static <T extends Parcelable> void v2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull T[] tArr, int i2, boolean z2) {
        if (tArr == null) {
            if (z2) {
                parcel.writeInt(i | 0);
                return;
            }
            return;
        }
        int iY2 = y2(parcel, i);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                B2(parcel, t, i2);
            }
        }
        A2(parcel, iY2);
    }

    @RecentlyNonNull
    @EnsuresNonNull({"#1"})
    public static String w(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    public static int w0(InputStream inputStream) throws IOException {
        byte b2 = (byte) inputStream.read();
        byte b3 = (byte) inputStream.read();
        return ((((byte) inputStream.read()) << 24) & ViewCompat.MEASURED_STATE_MASK) | ((((byte) inputStream.read()) << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((b3 << 8) & 65280) | (b2 & 255);
    }

    @Nullable
    public static byte[] w1(byte[] bArr, UUID uuid) {
        b.i.a.c.x2.i0.j jVarV1 = v1(bArr);
        if (jVarV1 == null) {
            return null;
        }
        if (uuid.equals(jVarV1.a)) {
            return jVarV1.c;
        }
        String strValueOf = String.valueOf(uuid);
        String strValueOf2 = String.valueOf(jVarV1.a);
        b.d.b.a.a.r0(b.d.b.a.a.S(strValueOf2.length() + strValueOf.length() + 33, "UUID mismatch. Expected: ", strValueOf, ", got: ", strValueOf2), ".", "PsshAtomUtil");
        return null;
    }

    public static <T extends Parcelable> void w2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull List<T> list, boolean z2) {
        if (list == null) {
            if (z2) {
                parcel.writeInt(i | 0);
                return;
            }
            return;
        }
        int iY2 = y2(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                B2(parcel, t, 0);
            }
        }
        A2(parcel, iY2);
    }

    public static void x(@RecentlyNonNull String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static final Integer x0(Intent intent, String str) {
        d0.z.d.m.checkNotNullParameter(intent, "$this$getIntExtraOrNull");
        d0.z.d.m.checkNotNullParameter(str, "key");
        Integer numValueOf = Integer.valueOf(intent.getIntExtra(str, Integer.MIN_VALUE));
        if (numValueOf.intValue() == Integer.MIN_VALUE) {
            return null;
        }
        return numValueOf;
    }

    public static boolean x1(b.i.a.c.x2.i iVar, byte[] bArr, int i, int i2, boolean z2) throws IOException {
        try {
            return iVar.e(bArr, i, i2, z2);
        } catch (EOFException e2) {
            if (z2) {
                return false;
            }
            throw e2;
        }
    }

    public static void x2(Parcel parcel, int i, int i2) {
        int iM1 = M1(parcel, i);
        if (iM1 == i2) {
            return;
        }
        String hexString = Integer.toHexString(iM1);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(iM1);
        throw new SafeParcelReader$ParseException(b.d.b.a.a.K(sb, " (0x", hexString, ")"), parcel);
    }

    public static <T> T y(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static final StageRequestToSpeakState y0(VoiceState voiceState) {
        if (voiceState == null) {
            return StageRequestToSpeakState.NONE;
        }
        if (voiceState.getSuppress() && voiceState.getRequestToSpeakTimestamp() != null) {
            return StageRequestToSpeakState.REQUESTED_TO_SPEAK;
        }
        if (voiceState.getSuppress() || voiceState.getRequestToSpeakTimestamp() == null) {
            return !voiceState.getSuppress() ? StageRequestToSpeakState.ON_STAGE : StageRequestToSpeakState.NONE;
        }
        return StageRequestToSpeakState.REQUESTED_TO_SPEAK_AND_AWAITING_USER_ACK;
    }

    @Nullable
    public static Metadata y1(b.i.a.c.x2.i iVar, boolean z2) throws IOException {
        b.i.a.c.z2.k.a aVar;
        if (z2) {
            aVar = null;
        } else {
            int i = b.i.a.c.z2.k.b.a;
            aVar = b.i.a.c.z2.k.a.a;
        }
        b.i.a.c.f3.x xVar = new b.i.a.c.f3.x(10);
        Metadata metadataD = null;
        int i2 = 0;
        while (true) {
            try {
                iVar.o(xVar.a, 0, 10);
                xVar.E(0);
                if (xVar.v() != 4801587) {
                    break;
                }
                xVar.F(3);
                int iS = xVar.s();
                int i3 = iS + 10;
                if (metadataD == null) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(xVar.a, 0, bArr, 0, 10);
                    iVar.o(bArr, 10, iS);
                    metadataD = new b.i.a.c.z2.k.b(aVar).d(bArr, i3);
                } else {
                    iVar.g(iS);
                }
                i2 += i3;
            } catch (EOFException unused) {
            }
        }
        iVar.k();
        iVar.g(i2);
        if (metadataD == null || metadataD.j.length == 0) {
            return null;
        }
        return metadataD;
    }

    public static int y2(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    @NonNull
    @EnsuresNonNull({"#1"})
    public static <T> T z(@RecentlyNonNull T t, @RecentlyNonNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static List<String> z0(CacheKey cacheKey) {
        try {
            if (cacheKey instanceof b.f.b.a.c) {
                Objects.requireNonNull((b.f.b.a.c) cacheKey);
                throw null;
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(cacheKey.a() ? cacheKey.b() : W1(cacheKey));
            return arrayList;
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static int z1(b.i.a.c.x2.i iVar, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int i4 = iVar.i(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    public static void z2(Parcel parcel, int i, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        String hexString = Integer.toHexString(i2);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(i2);
        throw new SafeParcelReader$ParseException(b.d.b.a.a.K(sb, " (0x", hexString, ")"), parcel);
    }
}
