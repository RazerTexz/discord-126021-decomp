package p007b.p085c.p086a.p087a0;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import android.os.Trace;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
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
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.C10638R;
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
import p007b.p008a.p050t.p052b.p055c.InterfaceC1307a;
import p007b.p085c.p086a.C1505d;
import p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c;
import p007b.p085c.p086a.p089b0.C1499g;
import p007b.p085c.p086a.p090c0.C1501a;
import p007b.p085c.p086a.p095y.p096k.C1572a;
import p007b.p085c.p086a.p095y.p096k.C1573b;
import p007b.p085c.p086a.p095y.p096k.C1575d;
import p007b.p085c.p086a.p095y.p096k.C1577f;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p109f.p111b.p112a.C1653c;
import p007b.p109f.p115d.p118c.InterfaceC1677a;
import p007b.p109f.p115d.p119d.C1686i;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p129e.C1728h;
import p007b.p109f.p132g.p142e.C1762b;
import p007b.p109f.p132g.p142e.C1763b0;
import p007b.p109f.p132g.p142e.C1768e;
import p007b.p109f.p132g.p142e.C1782p;
import p007b.p109f.p132g.p142e.C1784r;
import p007b.p109f.p132g.p142e.C1785s;
import p007b.p109f.p132g.p142e.C1786t;
import p007b.p109f.p132g.p142e.C1787u;
import p007b.p109f.p132g.p142e.C1788v;
import p007b.p109f.p132g.p142e.C1789w;
import p007b.p109f.p132g.p142e.C1790x;
import p007b.p109f.p132g.p142e.C1792z;
import p007b.p109f.p132g.p142e.InterfaceC1766d;
import p007b.p109f.p132g.p142e.InterfaceC1767d0;
import p007b.p109f.p132g.p142e.InterfaceC1769e0;
import p007b.p109f.p132g.p142e.RunnableC1764c;
import p007b.p109f.p132g.p143f.C1793a;
import p007b.p109f.p132g.p143f.C1795c;
import p007b.p109f.p160i.C1831b;
import p007b.p109f.p161j.p169d.C1884e;
import p007b.p109f.p161j.p169d.C1885f;
import p007b.p109f.p161j.p175j.C1919e;
import p007b.p109f.p161j.p185t.InterfaceC2037a;
import p007b.p109f.p190m.C2055h;
import p007b.p109f.p190m.p191n.C2061a;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.p210c0.InterfaceC2182e0;
import p007b.p195g.p196a.p205c.p218h0.C2334m;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p225i.p226a.p228b.p229i.C2415b;
import p007b.p225i.p226a.p228b.p229i.C2417d;
import p007b.p225i.p226a.p228b.p231j.p235s.InterfaceC2465a;
import p007b.p225i.p226a.p242c.p245b3.C2578b;
import p007b.p225i.p226a.p242c.p245b3.p252t.C2616f;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2753t;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p260g3.p261z.C2796h;
import p007b.p225i.p226a.p242c.p267x2.C3114o;
import p007b.p225i.p226a.p242c.p267x2.C3125z;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;
import p007b.p225i.p226a.p242c.p267x2.p274i0.C3051j;
import p007b.p225i.p226a.p242c.p267x2.p277l0.C3110d;
import p007b.p225i.p226a.p242c.p279z2.p283k.C3166a;
import p007b.p225i.p226a.p242c.p279z2.p283k.C3167b;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p356a.InterfaceC4488h;
import p507d0.p580t.C12141k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.c.a.a0.d */
/* JADX INFO: compiled from: AnimatableValueParser.java */
/* JADX INFO: loaded from: classes.dex */
public class C1460d {

    /* JADX INFO: renamed from: a */
    public static boolean f2216a;

    /* JADX INFO: renamed from: b */
    public static ScheduledExecutorService f2217b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public static Boolean f2218c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public static Boolean f2219d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public static Boolean f2220e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public static Boolean f2221f;

    /* JADX INFO: renamed from: b.c.a.a0.d$a */
    /* JADX INFO: compiled from: ArrayBuilders.java */
    /* JADX INFO: loaded from: classes3.dex */
    public static class a {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Class f2222a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ int f2223b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ Object f2224c;

        public a(Class cls, int i, Object obj) {
            this.f2222a = cls;
            this.f2223b = i;
            this.f2224c = obj;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!C2342d.m2183o(obj, this.f2222a) || Array.getLength(obj) != this.f2223b) {
                return false;
            }
            for (int i = 0; i < this.f2223b; i++) {
                Object obj2 = Array.get(this.f2224c, i);
                Object obj3 = Array.get(obj, i);
                if (obj2 != obj3 && obj2 != null && !obj2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        }
    }

    @NonNull
    @EnsuresNonNull({"#1"})
    /* JADX INFO: renamed from: A */
    public static <T> T m415A(@Nullable T t) {
        Objects.requireNonNull(t, "null reference");
        return t;
    }

    /* JADX INFO: renamed from: A0 */
    public static ScalingUtils$ScaleType m416A0(TypedArray typedArray, int i) {
        switch (typedArray.getInt(i, -2)) {
            case -1:
                return null;
            case 0:
                ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.f19495a;
                return C1792z.f3450l;
            case 1:
                ScalingUtils$ScaleType scalingUtils$ScaleType2 = ScalingUtils$ScaleType.f19495a;
                return C1790x.f3448l;
            case 2:
                ScalingUtils$ScaleType scalingUtils$ScaleType3 = ScalingUtils$ScaleType.f19495a;
                return C1788v.f3446l;
            case 3:
                ScalingUtils$ScaleType scalingUtils$ScaleType4 = ScalingUtils$ScaleType.f19495a;
                return C1789w.f3447l;
            case 4:
                ScalingUtils$ScaleType scalingUtils$ScaleType5 = ScalingUtils$ScaleType.f19495a;
                return C1784r.f3442l;
            case 5:
                ScalingUtils$ScaleType scalingUtils$ScaleType6 = ScalingUtils$ScaleType.f19495a;
                return C1786t.f3444l;
            case 6:
                ScalingUtils$ScaleType scalingUtils$ScaleType7 = ScalingUtils$ScaleType.f19495a;
                return C1785s.f3443l;
            case 7:
                ScalingUtils$ScaleType scalingUtils$ScaleType8 = ScalingUtils$ScaleType.f19495a;
                return C1763b0.f3334l;
            case 8:
                ScalingUtils$ScaleType scalingUtils$ScaleType9 = ScalingUtils$ScaleType.f19495a;
                return C1787u.f3445l;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }

    /* JADX INFO: renamed from: A1 */
    public static boolean m417A1(InterfaceC2182e0 interfaceC2182e0, AbstractC2360j abstractC2360j, Type type) {
        if (!abstractC2360j.m2216B(interfaceC2182e0.mo1831a(type)._class)) {
            return false;
        }
        ParameterizedType parameterizedTypeM525h1 = m525h1(type);
        if (parameterizedTypeM525h1 == null || !Objects.equals(abstractC2360j._class, parameterizedTypeM525h1.getRawType())) {
            return true;
        }
        Type[] actualTypeArguments = parameterizedTypeM525h1.getActualTypeArguments();
        C2334m c2334mMo2136j = abstractC2360j.mo2136j();
        if (c2334mMo2136j.m2155j() != actualTypeArguments.length) {
            return false;
        }
        for (int i = 0; i < c2334mMo2136j.m2155j(); i++) {
            if (!m417A1(interfaceC2182e0, c2334mMo2136j.m2151f(i), actualTypeArguments[i])) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: A2 */
    public static void m418A2(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    /* JADX INFO: renamed from: B */
    public static void m419B(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    @NonNull
    /* JADX INFO: renamed from: B0 */
    public static String m420B0(int i) {
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
                return C1643a.m851g(32, "unknown status code: ", i);
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

    /* JADX INFO: renamed from: B1 */
    public static int m421B1(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
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

    /* JADX INFO: renamed from: B2 */
    public static <T extends Parcelable> void m422B2(Parcel parcel, T t, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    /* JADX INFO: renamed from: C */
    public static void m423C(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* JADX INFO: renamed from: C0 */
    public static String[] m424C0() {
        return Build.VERSION.SDK_INT >= 23 ? SysUtil$MarshmallowSysdeps.getSupportedAbis() : SysUtil$LollipopSysdeps.getSupportedAbis();
    }

    /* JADX INFO: renamed from: C1 */
    public static void m425C1(FileChannel fileChannel, ByteBuffer byteBuffer, int i, long j) throws IOException {
        int i2;
        byteBuffer.position(0);
        byteBuffer.limit(i);
        while (byteBuffer.remaining() > 0 && (i2 = fileChannel.read(byteBuffer, j)) != -1) {
            j += (long) i2;
        }
        if (byteBuffer.remaining() > 0) {
            throw new C2055h("ELF file truncated");
        }
        byteBuffer.position(0);
    }

    @Pure
    /* JADX INFO: renamed from: D */
    public static void m426D(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: renamed from: D0 */
    public static String m427D0(String str) {
        return C1643a.m883w("TransportRuntime.", str);
    }

    /* JADX INFO: renamed from: D1 */
    public static int m428D1(InputStream inputStream) throws IOException {
        byte b2 = (byte) (inputStream.read() & 255);
        return ((((byte) (inputStream.read() & 255)) << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((((byte) (inputStream.read() & 255)) << 8) & 65280) | (b2 & 255);
    }

    @Pure
    /* JADX INFO: renamed from: E */
    public static void m429E(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* JADX INFO: renamed from: E0 */
    public static Pair<Integer, Integer> m430E0(InputStream inputStream) throws IOException {
        inputStream.skip(7L);
        short s2 = (short) (inputStream.read() & 255);
        short s3 = (short) (inputStream.read() & 255);
        short s4 = (short) (inputStream.read() & 255);
        if (s2 == 157 && s3 == 1 && s4 == 42) {
            return new Pair<>(Integer.valueOf(m548n0(inputStream)), Integer.valueOf(m548n0(inputStream)));
        }
        return null;
    }

    /* JADX INFO: renamed from: E1 */
    public static boolean m431E1(@RecentlyNonNull Parcel parcel, int i) {
        m590x2(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    /* JADX INFO: renamed from: F */
    public static void m432F(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: renamed from: F0 */
    public static Pair<Integer, Integer> m433F0(InputStream inputStream) throws IOException {
        m584w0(inputStream);
        if (((byte) (inputStream.read() & 255)) != 47) {
            return null;
        }
        int i = ((byte) inputStream.read()) & 255;
        int i2 = ((byte) inputStream.read()) & 255;
        return new Pair<>(Integer.valueOf((i | ((i2 & 63) << 8)) + 1), Integer.valueOf(((((((byte) inputStream.read()) & 255) & 15) << 10) | ((((byte) inputStream.read()) & 255) << 2) | ((i2 & Opcodes.CHECKCAST) >> 6)) + 1));
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: F1 */
    public static IBinder m434F1(@RecentlyNonNull Parcel parcel, int i) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iM455M1);
        return strongBinder;
    }

    /* JADX INFO: renamed from: G */
    public static void m435G(boolean z2, @RecentlyNonNull Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* JADX INFO: renamed from: G0 */
    public static long m436G0(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        m425C1(fileChannel, byteBuffer, 4, j);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    /* JADX INFO: renamed from: G1 */
    public static int m437G1(@RecentlyNonNull Parcel parcel, int i) {
        m590x2(parcel, i, 4);
        return parcel.readInt();
    }

    @EnsuresNonNull({"#1"})
    @Pure
    /* JADX INFO: renamed from: H */
    public static <T> T m438H(@Nullable T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: renamed from: H0 */
    public static final boolean m439H0(Long l, long j) {
        return l != null && (l.longValue() & j) == j;
    }

    /* JADX INFO: renamed from: H1 */
    public static long m440H1(@RecentlyNonNull Parcel parcel, int i) {
        m590x2(parcel, i, 8);
        return parcel.readLong();
    }

    /* JADX INFO: renamed from: I */
    public static boolean m441I(byte[] bArr, String str) {
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

    /* JADX INFO: renamed from: I0 */
    public static boolean m442I0(byte[] bArr, byte[] bArr2, int i) {
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

    /* JADX INFO: renamed from: I1 */
    public static int m443I1(C2757x c2757x) {
        int i = 0;
        while (c2757x.m3081a() != 0) {
            int iM3100t = c2757x.m3100t();
            i += iM3100t;
            if (iM3100t != 255) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: J */
    public static void m444J(long j, C2757x c2757x, InterfaceC3122w[] interfaceC3122wArr) {
        while (true) {
            if (c2757x.m3081a() <= 1) {
                return;
            }
            int iM443I1 = m443I1(c2757x);
            int iM443I2 = m443I1(c2757x);
            int i = c2757x.f6794b + iM443I2;
            if (iM443I2 == -1 || iM443I2 > c2757x.m3081a()) {
                Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                i = c2757x.f6795c;
            } else if (iM443I1 == 4 && iM443I2 >= 8) {
                int iM3100t = c2757x.m3100t();
                int iM3105y = c2757x.m3105y();
                int iM3086f = iM3105y == 49 ? c2757x.m3086f() : 0;
                int iM3100t2 = c2757x.m3100t();
                if (iM3105y == 47) {
                    c2757x.m3080F(1);
                }
                boolean z2 = iM3100t == 181 && (iM3105y == 49 || iM3105y == 47) && iM3100t2 == 3;
                if (iM3105y == 49) {
                    z2 &= iM3086f == 1195456820;
                }
                if (z2) {
                    m447K(j, c2757x, interfaceC3122wArr);
                }
            }
            c2757x.m3079E(i);
        }
    }

    /* JADX INFO: renamed from: J0 */
    public static int m445J0(int i, int i2) {
        return ((i + 31) * 31) + i2;
    }

    /* JADX INFO: renamed from: J1 */
    public static int m446J1(InputStream inputStream, int i, boolean z2) throws IOException {
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

    /* JADX INFO: renamed from: K */
    public static void m447K(long j, C2757x c2757x, InterfaceC3122w[] interfaceC3122wArr) {
        int iM3100t = c2757x.m3100t();
        if ((iM3100t & 64) != 0) {
            c2757x.m3080F(1);
            int i = (iM3100t & 31) * 3;
            int i2 = c2757x.f6794b;
            for (InterfaceC3122w interfaceC3122w : interfaceC3122wArr) {
                c2757x.m3079E(i2);
                interfaceC3122w.mo2524c(c2757x, i);
                if (j != -9223372036854775807L) {
                    interfaceC3122w.mo2525d(j, 1, i, 0, null);
                }
            }
        }
    }

    /* JADX INFO: renamed from: K0 */
    public static int m448K0(Object obj, Object obj2) {
        return m445J0(obj == null ? 0 : obj.hashCode(), obj2 != null ? obj2.hashCode() : 0);
    }

    /* JADX INFO: renamed from: K1 */
    public static long m449K1(C2757x c2757x, int i, int i2) {
        c2757x.m3079E(i);
        if (c2757x.m3081a() < 5) {
            return -9223372036854775807L;
        }
        int iM3086f = c2757x.m3086f();
        if ((8388608 & iM3086f) != 0 || ((2096896 & iM3086f) >> 8) != i2) {
            return -9223372036854775807L;
        }
        if (((iM3086f & 32) != 0) && c2757x.m3100t() >= 7 && c2757x.m3081a() >= 7) {
            if ((c2757x.m3100t() & 16) == 16) {
                byte[] bArr = new byte[6];
                System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, 0, 6);
                c2757x.f6794b += 6;
                return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((((long) bArr[4]) & 255) >> 7);
            }
        }
        return -9223372036854775807L;
    }

    /* JADX INFO: renamed from: L */
    public static void m450L(Drawable drawable, Drawable drawable2) {
        if (drawable == null || drawable == drawable2) {
            return;
        }
        drawable.setBounds(drawable2.getBounds());
        drawable.setChangingConfigurations(drawable2.getChangingConfigurations());
        drawable.setLevel(drawable2.getLevel());
        drawable.setVisible(drawable2.isVisible(), false);
        drawable.setState(drawable2.getState());
    }

    /* JADX INFO: renamed from: L0 */
    public static void m451L0(String str, String str2) {
        Log.i(m427D0(str), str2);
    }

    /* JADX INFO: renamed from: L1 */
    public static C3114o.a m452L1(C2757x c2757x) {
        c2757x.m3080F(1);
        int iM3102v = c2757x.m3102v();
        long j = ((long) c2757x.f6794b) + ((long) iM3102v);
        int i = iM3102v / 18;
        long[] jArrCopyOf = new long[i];
        long[] jArrCopyOf2 = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            long jM3093m = c2757x.m3093m();
            if (jM3093m == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                break;
            }
            jArrCopyOf[i2] = jM3093m;
            jArrCopyOf2[i2] = c2757x.m3093m();
            c2757x.m3080F(2);
        }
        c2757x.m3080F((int) (j - ((long) c2757x.f6794b)));
        return new C3114o.a(jArrCopyOf, jArrCopyOf2);
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: M */
    public static Bundle m453M(@RecentlyNonNull Parcel parcel, int i) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iM455M1);
        return bundle;
    }

    /* JADX INFO: renamed from: M0 */
    public static int m454M0(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    /* JADX INFO: renamed from: M1 */
    public static int m455M1(@RecentlyNonNull Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: N */
    public static byte[] m456N(@RecentlyNonNull Parcel parcel, int i) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iM455M1);
        return bArrCreateByteArray;
    }

    /* JADX INFO: renamed from: N0 */
    public static <T> DataSource<T> m457N0(Throwable th) {
        C1728h c1728h = new C1728h();
        Objects.requireNonNull(th);
        c1728h.m1027k(th, null);
        return c1728h;
    }

    /* JADX INFO: renamed from: N1 */
    public static C3125z m458N1(C2757x c2757x, boolean z2, boolean z3) throws ParserException {
        if (z2) {
            m550n2(3, c2757x, false);
        }
        String strM3097q = c2757x.m3097q((int) c2757x.m3090j());
        int length = strM3097q.length() + 11;
        long jM3090j = c2757x.m3090j();
        String[] strArr = new String[(int) jM3090j];
        int length2 = length + 4;
        for (int i = 0; i < jM3090j; i++) {
            strArr[i] = c2757x.m3097q((int) c2757x.m3090j());
            length2 = length2 + 4 + strArr[i].length();
        }
        if (z3 && (c2757x.m3100t() & 1) == 0) {
            throw ParserException.m8755a("framing bit expected to be set", null);
        }
        return new C3125z(strM3097q, strArr, length2 + 1);
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: O */
    public static int[] m459O(@RecentlyNonNull Parcel parcel, int i) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iM455M1);
        return iArrCreateIntArray;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:137:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:29:0x0067  */
    /* JADX INFO: renamed from: O0 */
    public static int m460O0(Map<String, List<String>> map) {
        byte b2;
        List<String> list = map.get("Content-Type");
        String str = (list == null || list.isEmpty()) ? null : list.get(0);
        if (str != null) {
            ArrayList<C2753t.a> arrayList = C2753t.f6749a;
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

    /* JADX INFO: renamed from: O1 */
    public static void m461O1(C2578b.b bVar) {
        bVar.f5783k = -3.4028235E38f;
        bVar.f5782j = Integer.MIN_VALUE;
        CharSequence charSequence = bVar.f5773a;
        if (charSequence instanceof Spanned) {
            if (!(charSequence instanceof Spannable)) {
                bVar.f5773a = SpannableString.valueOf(charSequence);
            }
            CharSequence charSequence2 = bVar.f5773a;
            Objects.requireNonNull(charSequence2);
            m464P1((Spannable) charSequence2, new InterfaceC4488h() { // from class: b.i.a.c.d3.h
                @Override // p007b.p225i.p355b.p356a.InterfaceC4488h
                public final boolean apply(Object obj) {
                    return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
                }
            });
        }
    }

    /* JADX INFO: renamed from: P */
    public static final MediaSource m462P(MediaType mediaType, String str, String str2) {
        C12238m.checkNotNullParameter(mediaType, "mediaType");
        C12238m.checkNotNullParameter(str, "progressiveMediaUri");
        C12238m.checkNotNullParameter(str2, "featureTag");
        Uri uri = Uri.parse(str);
        C12238m.checkNotNullExpressionValue(uri, "Uri.parse(progressiveMediaUri)");
        return new MediaSource(uri, str2, mediaType);
    }

    /* JADX INFO: renamed from: P0 */
    public static int m463P0(Uri uri) {
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

    /* JADX INFO: renamed from: P1 */
    public static void m464P1(Spannable spannable, InterfaceC4488h<Object> interfaceC4488h) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (interfaceC4488h.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: Q */
    public static <T extends Parcelable> T m465Q(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iM455M1);
        return tCreateFromParcel;
    }

    /* JADX INFO: renamed from: Q0 */
    public static void m466Q0(String str) {
        throw new IllegalArgumentException(C1643a.m883w("Unknown library: ", str));
    }

    /* JADX INFO: renamed from: Q1 */
    public static void m467Q1(File file, File file2) throws IOException {
        Objects.requireNonNull(file);
        file2.delete();
        if (file.renameTo(file2)) {
            return;
        }
        final Throwable fileUtils$FileDeleteException = null;
        if (file2.exists()) {
            fileUtils$FileDeleteException = new FileUtils$FileDeleteException(file2.getAbsolutePath());
        } else if (!file.getParentFile().exists()) {
            final String absolutePath = file.getAbsolutePath();
            fileUtils$FileDeleteException = new FileNotFoundException(absolutePath) { // from class: com.facebook.common.file.FileUtils$ParentDirNotFoundException
            };
        } else if (!file.exists()) {
            fileUtils$FileDeleteException = new FileNotFoundException(file.getAbsolutePath());
        }
        StringBuilder sbM833U = C1643a.m833U("Unknown error renaming ");
        sbM833U.append(file.getAbsolutePath());
        sbM833U.append(" to ");
        sbM833U.append(file2.getAbsolutePath());
        final String string = sbM833U.toString();
        throw new IOException(string, fileUtils$FileDeleteException) { // from class: com.facebook.common.file.FileUtils$RenameException
            {
                initCause(fileUtils$FileDeleteException);
            }
        };
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: R */
    public static String m468R(@RecentlyNonNull Parcel parcel, int i) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iM455M1);
        return string;
    }

    /* JADX INFO: renamed from: R0 */
    public static boolean m469R0(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return (xmlPullParser.getEventType() == 3) && xmlPullParser.getName().equals(str);
    }

    /* JADX INFO: renamed from: R1 */
    public static final RenderContext m470R1(Function1<? super RenderContext, Unit> function1, Object... objArr) {
        C12238m.checkNotNullParameter(function1, "init");
        C12238m.checkNotNullParameter(objArr, "orderedArguments");
        RenderContext renderContext = new RenderContext();
        function1.invoke(renderContext);
        if (!(objArr.length == 0)) {
            if (!renderContext.args.isEmpty()) {
                throw new IllegalArgumentException("must provide named arguments OR formatArgs, not both.");
            }
            renderContext.orderedArguments = C12141k.toList(objArr);
        }
        return renderContext;
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: S */
    public static String[] m471S(@RecentlyNonNull Parcel parcel, int i) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iM455M1);
        return strArrCreateStringArray;
    }

    /* JADX INFO: renamed from: S0 */
    public static boolean m472S0(int i, int i2, C1884e c1884e) {
        if (c1884e == null) {
            return ((float) m552o0(i)) >= 2048.0f && m552o0(i2) >= 2048;
        }
        return m552o0(i) >= c1884e.f3717a && m552o0(i2) >= c1884e.f3718b;
    }

    /* JADX INFO: renamed from: S1 */
    public static /* synthetic */ void m473S1(AppPermissionsRequests appPermissionsRequests, Function0 function0, Function0 function1, int i, Object obj) {
        int i2 = i & 1;
        appPermissionsRequests.requestMicrophone(null, function1);
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: T */
    public static ArrayList<String> m474T(@RecentlyNonNull Parcel parcel, int i) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iM455M1);
        return arrayListCreateStringArrayList;
    }

    /* JADX INFO: renamed from: T0 */
    public static boolean m475T0(C1919e c1919e, C1884e c1884e) {
        if (c1919e == null) {
            return false;
        }
        c1919e.m1347x();
        int i = c1919e.f3894m;
        if (i == 90 || i == 270) {
            c1919e.m1347x();
            int i2 = c1919e.f3897p;
            c1919e.m1347x();
            return m472S0(i2, c1919e.f3896o, c1884e);
        }
        c1919e.m1347x();
        int i3 = c1919e.f3896o;
        c1919e.m1347x();
        return m472S0(i3, c1919e.f3897p, c1884e);
    }

    @Nullable
    /* JADX INFO: renamed from: T1 */
    public static C2616f m476T1(@Nullable C2616f c2616f, @Nullable String[] strArr, Map<String, C2616f> map) {
        int i = 0;
        if (c2616f == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                C2616f c2616f2 = new C2616f();
                int length = strArr.length;
                while (i < length) {
                    c2616f2.m2701a(map.get(strArr[i]));
                    i++;
                }
                return c2616f2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                c2616f.m2701a(map.get(strArr[0]));
                return c2616f;
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i < length2) {
                    c2616f.m2701a(map.get(strArr[i]));
                    i++;
                }
            }
        }
        return c2616f;
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: U */
    public static <T> T[] m477U(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iM455M1);
        return tArr;
    }

    /* JADX INFO: renamed from: U0 */
    public static final boolean m478U0(Context context) {
        C12238m.checkNotNullParameter(context, "$this$isLtr");
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 0;
    }

    /* JADX INFO: renamed from: U1 */
    public static float m479U1(int i, float f, int i2, int i3) {
        float f2;
        if (f == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i == 0) {
            f2 = i3;
        } else {
            if (i != 1) {
                if (i != 2) {
                    return -3.4028235E38f;
                }
                return f;
            }
            f2 = i2;
        }
        return f * f2;
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: V */
    public static <T> ArrayList<T> m480V(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        ArrayList<T> arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iM455M1);
        return arrayListCreateTypedArrayList;
    }

    /* JADX INFO: renamed from: V0 */
    public static final boolean m481V0(VoiceState voiceState) {
        C12238m.checkNotNullParameter(voiceState, "$this$isMutedByAnySource");
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
    /* JADX INFO: renamed from: V1 */
    public static <TInput, TResult, TException extends Throwable> TResult m482V1(int i, TInput tinput, C2415b<TInput, TResult, TException> c2415b, InterfaceC2465a<TInput, TResult> interfaceC2465a) throws Throwable {
        ?? r0;
        boolean z2;
        if (i < 1) {
            return (TResult) c2415b.m2295a(tinput);
        }
        while (true) {
            r0 = (TResult) c2415b.m2295a(tinput);
            C2417d.a aVar = (C2417d.a) tinput;
            C2417d.b bVar = (C2417d.b) r0;
            URL url = bVar.f5143b;
            if (url != null) {
                m486X("CctTransportBackend", "Following redirect to: %s", url);
                z2 = (TInput) new C2417d.a(bVar.f5143b, aVar.f5140b, aVar.f5141c);
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

    /* JADX INFO: renamed from: W */
    public static String m483W(String str) {
        StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(str, C1643a.m841b(str, 5)), ".", str, ",.", str);
        sbM831S.append(" *");
        return sbM831S.toString();
    }

    /* JADX INFO: renamed from: W0 */
    public static final boolean m484W0(StageInstance stageInstance) {
        C12238m.checkNotNullParameter(stageInstance, "$this$isPublic");
        return stageInstance.getPrivacyLevel() == StageInstancePrivacyLevel.PUBLIC;
    }

    /* JADX INFO: renamed from: W1 */
    public static String m485W1(CacheKey cacheKey) throws UnsupportedEncodingException {
        byte[] bytes = cacheKey.mo930b().getBytes(Constants.ENCODING);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
            messageDigest.update(bytes, 0, bytes.length);
            return Base64.encodeToString(messageDigest.digest(), 11);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: X */
    public static void m486X(String str, String str2, Object obj) {
        Log.d(m427D0(str), String.format(str2, obj));
    }

    /* JADX INFO: renamed from: X0 */
    public static final boolean m487X0(VoiceState voiceState) {
        C12238m.checkNotNullParameter(voiceState, "$this$isRemoveSignal");
        return voiceState.getChannelId() == null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: X1 */
    public static void m488X1(Drawable drawable, Drawable.Callback callback, InterfaceC1769e0 interfaceC1769e0) {
        if (drawable != 0) {
            drawable.setCallback(callback);
            if (drawable instanceof InterfaceC1767d0) {
                ((InterfaceC1767d0) drawable).mo1094b(interfaceC1769e0);
            }
        }
    }

    /* JADX INFO: renamed from: Y */
    public static void m489Y(String str, String str2, Object... objArr) {
        Log.d(m427D0(str), String.format(str2, objArr));
    }

    /* JADX INFO: renamed from: Y0 */
    public static boolean m490Y0(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return (xmlPullParser.getEventType() == 2) && xmlPullParser.getName().equals(str);
    }

    /* JADX INFO: renamed from: Y1 */
    public static void m491Y1(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i = 0; i < list.size(); i++) {
            mediaFormat.setByteBuffer(C1643a.m851g(15, "csd-", i), ByteBuffer.wrap(list.get(i)));
        }
    }

    /* JADX INFO: renamed from: Z */
    public static boolean m492Z(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                m492Z(file2);
            }
        }
        return file.delete();
    }

    @TargetApi(20)
    /* JADX INFO: renamed from: Z0 */
    public static boolean m493Z0(@RecentlyNonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f2218c == null) {
            f2218c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f2218c.booleanValue();
    }

    /* JADX INFO: renamed from: Z1 */
    public static void m494Z1(Drawable drawable, C1768e c1768e) {
        if (drawable == null || c1768e == null) {
            return;
        }
        int i = c1768e.f3339a;
        if (i != -1) {
            drawable.setAlpha(i);
        }
        if (c1768e.f3340b) {
            drawable.setColorFilter(c1768e.f3341c);
        }
        int i2 = c1768e.f3342d;
        if (i2 != -1) {
            drawable.setDither(i2 != 0);
        }
        int i3 = c1768e.f3343e;
        if (i3 != -1) {
            drawable.setFilterBitmap(i3 != 0);
        }
    }

    /* JADX INFO: renamed from: a */
    public static float m495a(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0086  */
    /* JADX INFO: renamed from: a0 */
    public static int m496a0(C1885f c1885f, C1884e c1884e, C1919e c1919e, int i) {
        float fMax;
        int i2;
        int i3;
        int i4;
        int i5 = 1;
        if (!C1919e.m1337s(c1919e)) {
            return 1;
        }
        m527i(Boolean.valueOf(C1919e.m1337s(c1919e)));
        if (c1884e == null || c1884e.f3718b <= 0 || c1884e.f3717a <= 0) {
            fMax = 1.0f;
        } else {
            c1919e.m1347x();
            if (c1919e.f3896o != 0) {
                c1919e.m1347x();
                if (c1919e.f3897p == 0) {
                    fMax = 1.0f;
                } else {
                    if (c1885f.m1251c()) {
                        c1919e.m1347x();
                        i2 = c1919e.f3894m;
                        m527i(Boolean.valueOf(i2 == 0 || i2 == 90 || i2 == 180 || i2 == 270));
                    } else {
                        i2 = 0;
                    }
                    boolean z2 = i2 == 90 || i2 == 270;
                    if (z2) {
                        c1919e.m1347x();
                        i3 = c1919e.f3897p;
                    } else {
                        c1919e.m1347x();
                        i3 = c1919e.f3896o;
                    }
                    if (z2) {
                        c1919e.m1347x();
                        i4 = c1919e.f3896o;
                    } else {
                        c1919e.m1347x();
                        i4 = c1919e.f3897p;
                    }
                    fMax = Math.max(c1884e.f3717a / i3, c1884e.f3718b / i4);
                    int i6 = C1691a.f3102a;
                }
            } else {
                fMax = 1.0f;
            }
        }
        c1919e.m1347x();
        int i7 = 2;
        if (c1919e.f3893l == C1831b.f3585a) {
            if (fMax <= 0.6666667f) {
                i5 = 2;
                while (true) {
                    int i8 = i5 * 2;
                    double d = 1.0d / ((double) i8);
                    if ((d * 0.3333333432674408d) + d <= fMax) {
                        break;
                    }
                    i5 = i8;
                }
            }
        } else if (fMax <= 0.6666667f) {
            while (true) {
                double d2 = i7;
                if (((1.0d / (Math.pow(d2, 2.0d) - d2)) * 0.3333333432674408d) + (1.0d / d2) <= fMax) {
                    break;
                }
                i7++;
            }
            i5 = i7 - 1;
        }
        c1919e.m1347x();
        int i9 = c1919e.f3897p;
        c1919e.m1347x();
        int iMax = Math.max(i9, c1919e.f3896o);
        float f = c1884e != null ? c1884e.f3719c : i;
        while (iMax / i5 > f) {
            c1919e.m1347x();
            i5 = c1919e.f3893l == C1831b.f3585a ? i5 * 2 : i5 + 1;
        }
        return i5;
    }

    @TargetApi(26)
    /* JADX INFO: renamed from: a1 */
    public static boolean m497a1(@RecentlyNonNull Context context) {
        if (!m493Z0(context)) {
            return false;
        }
        if (!(Build.VERSION.SDK_INT >= 24)) {
            return true;
        }
        if (f2219d == null) {
            f2219d = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f2219d.booleanValue() && !C3404f.m4190A0();
    }

    /* JADX INFO: renamed from: a2 */
    public static <TResult> void m498a2(Status status, @Nullable TResult tresult, TaskCompletionSource<TResult> taskCompletionSource) {
        if (status.m9030w0()) {
            taskCompletionSource.f20845a.m6024s(tresult);
        } else {
            taskCompletionSource.f20845a.m6025t(new ApiException(status));
        }
    }

    /* JADX INFO: renamed from: b */
    public static float m499b(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    /* JADX INFO: renamed from: b0 */
    public static void m500b0(File file) throws IOException {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                m500b0(file2);
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

    /* JADX INFO: renamed from: b1 */
    public static final void m501b1(String str, String str2) {
        C12238m.checkNotNullParameter(str, "tag");
        C12238m.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.d$default(LoggingProvider.INSTANCE.get(), str, str2, null, 4, null);
    }

    /* JADX INFO: renamed from: b2 */
    public static boolean m502b2(Object obj, Collection<String> collection, Collection<String> collection2) {
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

    /* JADX INFO: renamed from: c */
    public static void m503c(Spannable spannable, Object obj, int i, int i2, int i3) {
        for (Object obj2 : spannable.getSpans(i, i2, obj.getClass())) {
            if (spannable.getSpanStart(obj2) == i && spannable.getSpanEnd(obj2) == i2 && spannable.getSpanFlags(obj2) == i3) {
                spannable.removeSpan(obj2);
            }
        }
        spannable.setSpan(obj, i, i2, i3);
    }

    /* JADX INFO: renamed from: c0 */
    public static void m504c0(String str, String str2, Throwable th) {
        Log.e(m427D0(str), str2, th);
    }

    /* JADX INFO: renamed from: c1 */
    public static final void m505c1(String str, String str2, Throwable th) {
        C12238m.checkNotNullParameter(str, "tag");
        C12238m.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.e$default(LoggingProvider.INSTANCE.get(), str, str2, th, null, 8, null);
    }

    /* JADX INFO: renamed from: c2 */
    public static long m506c2(InputStream inputStream, long j) throws IOException {
        m527i(Boolean.valueOf(j >= 0));
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

    /* JADX INFO: renamed from: d */
    public static int m507d(int i, int i2, int i3) {
        return Math.min(Math.max(0, i3 - i), i2);
    }

    /* JADX INFO: renamed from: d0 */
    public static void m508d0() {
        if (C2738e0.f6708a >= 18) {
            Trace.endSection();
        }
    }

    /* JADX INFO: renamed from: d1 */
    public static final void m509d1(String str, String str2) {
        C12238m.checkNotNullParameter(str, "tag");
        C12238m.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.i$default(LoggingProvider.INSTANCE.get(), str, str2, null, 4, null);
    }

    /* JADX INFO: renamed from: d2 */
    public static void m510d2(@RecentlyNonNull Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + m455M1(parcel, i));
    }

    /* JADX INFO: renamed from: e */
    public static byte[] m511e(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    /* JADX INFO: renamed from: e0 */
    public static synchronized void m512e0() {
        if (!f2216a) {
            C2061a.m1589c("native-imagetranscoder");
            f2216a = true;
        }
    }

    /* JADX INFO: renamed from: e1 */
    public static final void m513e1(String str, String str2) {
        C12238m.checkNotNullParameter(str, "tag");
        C12238m.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.v$default(LoggingProvider.INSTANCE.get(), str, str2, null, 4, null);
    }

    /* JADX INFO: renamed from: e2 */
    public static final <P extends Parcelable> Bundle m514e2(P p) {
        C12238m.checkNotNullParameter(p, "$this$toBundle");
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent_args_key", p);
        return bundle;
    }

    /* JADX INFO: renamed from: f */
    public static void m515f(String str) {
        if (C2738e0.f6708a >= 18) {
            Trace.beginSection(str);
        }
    }

    /* JADX INFO: renamed from: f0 */
    public static void m516f0(@RecentlyNonNull Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            throw new SafeParcelReader$ParseException(C1643a.m851g(37, "Overread allowed size end=", i), parcel);
        }
    }

    /* JADX INFO: renamed from: f1 */
    public static final void m517f1(String str, String str2) {
        C12238m.checkNotNullParameter(str, "tag");
        C12238m.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.w$default(LoggingProvider.INSTANCE.get(), str, str2, null, 4, null);
    }

    /* JADX INFO: renamed from: f2 */
    public static String m518f2(@ColorInt int i) {
        return C2738e0.m3003k("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(((double) Color.alpha(i)) / 255.0d));
    }

    /* JADX INFO: renamed from: g */
    public static List<byte[]> m519g(byte[] bArr) {
        long j = (((long) (((bArr[11] & 255) << 8) | (bArr[10] & 255))) * 1000000000) / 48000;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(m523h(j));
        arrayList.add(m523h(80000000L));
        return arrayList;
    }

    /* JADX INFO: renamed from: g0 */
    public static boolean m520g0(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: renamed from: g1 */
    public static boolean m521g1(InterfaceC2037a interfaceC2037a, CloseableReference<Bitmap> closeableReference) {
        return false;
    }

    /* JADX INFO: renamed from: g2 */
    public static final <P extends Parcelable> Intent m522g2(P p) {
        C12238m.checkNotNullParameter(p, "$this$toIntent");
        Intent intentPutExtra = new Intent().putExtra("intent_args_key", p);
        C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_ARGS, this)");
        return intentPutExtra;
    }

    /* JADX INFO: renamed from: h */
    public static byte[] m523h(long j) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array();
    }

    /* JADX INFO: renamed from: h0 */
    public static boolean m524h0(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: renamed from: h1 */
    public static ParameterizedType m525h1(Type type) {
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
                return m525h1(upperBounds[0]);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: h2 */
    public static C1686i m526h2(Object obj) {
        return new C1686i(obj.getClass().getSimpleName(), null);
    }

    /* JADX INFO: renamed from: i */
    public static void m527i(Boolean bool) {
        if (bool != null && !bool.booleanValue()) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: renamed from: i0 */
    public static int m528i0(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float f3 = ((i2 >> 24) & 255) / 255.0f;
        float fM495a = m495a(((i >> 16) & 255) / 255.0f);
        float fM495a2 = m495a(((i >> 8) & 255) / 255.0f);
        float fM495a3 = m495a((i & 255) / 255.0f);
        float fM495a4 = m495a(((i2 >> 16) & 255) / 255.0f);
        float fM495a5 = m495a(((i2 >> 8) & 255) / 255.0f);
        float fM495a6 = m495a((i2 & 255) / 255.0f);
        float fM839a = C1643a.m839a(f3, f2, f, f2);
        float fM839a2 = C1643a.m839a(fM495a4, fM495a, f, fM495a);
        float fM839a3 = C1643a.m839a(fM495a5, fM495a2, f, fM495a2);
        float fM839a4 = C1643a.m839a(fM495a6, fM495a3, f, fM495a3);
        float fM499b = m499b(fM839a2) * 255.0f;
        float fM499b2 = m499b(fM839a3) * 255.0f;
        return Math.round(m499b(fM839a4) * 255.0f) | (Math.round(fM499b) << 16) | (Math.round(fM839a * 255.0f) << 24) | (Math.round(fM499b2) << 8);
    }

    /* JADX INFO: renamed from: i1 */
    public static TypeVariable<?> m529i1(Type type) {
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
                return m529i1(upperBounds[0]);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: i2 */
    public static void m530i2(Collection<? extends Node> collection, InterfaceC1307a interfaceC1307a) {
        Iterator<? extends Node> it = collection.iterator();
        while (it.hasNext()) {
            m534j2(it.next(), interfaceC1307a);
        }
    }

    @Pure
    /* JADX INFO: renamed from: j */
    public static void m531j(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: renamed from: j0 */
    public static String[] m532j0(FileChannel fileChannel) throws IOException {
        long jM436G0;
        long jM436G1;
        long jM436G2;
        long j;
        long jM436G3;
        long j2;
        long jM436G4;
        long j3;
        long jM436G5;
        long jM436G6;
        long jM436G7;
        long jM436G8;
        long jM436G9;
        int i = 8;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long jM436G10 = m436G0(fileChannel, byteBufferAllocate, 0L);
        if (jM436G10 != 1179403647) {
            StringBuilder sbM833U = C1643a.m833U("file is not ELF: 0x");
            sbM833U.append(Long.toHexString(jM436G10));
            throw new C2055h(sbM833U.toString());
        }
        m425C1(fileChannel, byteBufferAllocate, 1, 4L);
        boolean z2 = ((short) (byteBufferAllocate.get() & 255)) == 1;
        m425C1(fileChannel, byteBufferAllocate, 1, 5L);
        if (((short) (byteBufferAllocate.get() & 255)) == 2) {
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        }
        if (z2) {
            jM436G0 = m436G0(fileChannel, byteBufferAllocate, 28L);
        } else {
            m425C1(fileChannel, byteBufferAllocate, 8, 32L);
            jM436G0 = byteBufferAllocate.getLong();
        }
        m425C1(fileChannel, byteBufferAllocate, 2, z2 ? 44L : 56L);
        long jM436G11 = byteBufferAllocate.getShort() & 65535;
        m425C1(fileChannel, byteBufferAllocate, 2, z2 ? 42L : 54L);
        int i2 = 65535 & byteBufferAllocate.getShort();
        if (jM436G11 == 65535) {
            if (z2) {
                jM436G9 = m436G0(fileChannel, byteBufferAllocate, 32L);
            } else {
                m425C1(fileChannel, byteBufferAllocate, 8, 40L);
                jM436G9 = byteBufferAllocate.getLong();
            }
            jM436G11 = z2 ? m436G0(fileChannel, byteBufferAllocate, jM436G9 + 28) : m436G0(fileChannel, byteBufferAllocate, jM436G9 + 44);
        }
        long j4 = 0;
        long j5 = jM436G0;
        while (true) {
            if (j4 >= jM436G11) {
                jM436G1 = 0;
                break;
            }
            if ((z2 ? m436G0(fileChannel, byteBufferAllocate, j5 + 0) : m436G0(fileChannel, byteBufferAllocate, 0 + j5)) == 2) {
                if (!z2) {
                    m425C1(fileChannel, byteBufferAllocate, 8, j5 + 8);
                    jM436G1 = byteBufferAllocate.getLong();
                    break;
                }
                jM436G1 = m436G0(fileChannel, byteBufferAllocate, j5 + 4);
                break;
            }
            j5 += (long) i2;
            j4++;
        }
        long j6 = 0;
        if (jM436G1 == 0) {
            throw new C2055h("ELF file does not contain dynamic linking information");
        }
        int i3 = 0;
        long j7 = jM436G1;
        long j8 = 0;
        while (true) {
            long j9 = j7 + j6;
            if (z2) {
                jM436G2 = m436G0(fileChannel, byteBufferAllocate, j9);
            } else {
                m425C1(fileChannel, byteBufferAllocate, i, j9);
                jM436G2 = byteBufferAllocate.getLong();
            }
            if (jM436G2 == 1) {
                j = jM436G1;
                if (i3 == Integer.MAX_VALUE) {
                    throw new C2055h("malformed DT_NEEDED section");
                }
                i3++;
            } else {
                j = jM436G1;
                if (jM436G2 == 5) {
                    if (z2) {
                        jM436G3 = m436G0(fileChannel, byteBufferAllocate, j7 + 4);
                    } else {
                        m425C1(fileChannel, byteBufferAllocate, 8, j7 + 8);
                        jM436G3 = byteBufferAllocate.getLong();
                    }
                    j8 = jM436G3;
                }
            }
            long j10 = 16;
            j7 += z2 ? 8L : 16L;
            long j11 = 0;
            if (jM436G2 != 0) {
                i = 8;
                jM436G1 = j;
                j6 = 0;
            } else {
                if (j8 == 0) {
                    throw new C2055h("Dynamic section string-table not found");
                }
                int i4 = 0;
                int i5 = i3;
                while (true) {
                    if (i4 >= jM436G11) {
                        j2 = 0;
                        break;
                    }
                    if ((z2 ? m436G0(fileChannel, byteBufferAllocate, jM436G0 + j11) : m436G0(fileChannel, byteBufferAllocate, jM436G0 + j11)) == 1) {
                        if (z2) {
                            jM436G6 = m436G0(fileChannel, byteBufferAllocate, jM436G0 + 8);
                        } else {
                            m425C1(fileChannel, byteBufferAllocate, 8, j10 + jM436G0);
                            jM436G6 = byteBufferAllocate.getLong();
                        }
                        if (z2) {
                            jM436G7 = m436G0(fileChannel, byteBufferAllocate, 20 + jM436G0);
                        } else {
                            m425C1(fileChannel, byteBufferAllocate, 8, 40 + jM436G0);
                            jM436G7 = byteBufferAllocate.getLong();
                        }
                        if (jM436G6 <= j8 && j8 < jM436G7 + jM436G6) {
                            if (z2) {
                                jM436G8 = m436G0(fileChannel, byteBufferAllocate, jM436G0 + 4);
                            } else {
                                m425C1(fileChannel, byteBufferAllocate, 8, jM436G0 + 8);
                                jM436G8 = byteBufferAllocate.getLong();
                            }
                            j2 = (j8 - jM436G6) + jM436G8;
                            break;
                        }
                    } else {
                        jM436G11 = jM436G11;
                    }
                    jM436G0 += (long) i2;
                    i4++;
                    j10 = 16;
                    j11 = 0;
                    jM436G11 = jM436G11;
                }
                if (j2 == 0) {
                    throw new C2055h("did not find file offset of DT_STRTAB table");
                }
                String[] strArr = new String[i5];
                long j12 = 0;
                long j13 = j;
                int i6 = 0;
                while (true) {
                    long j14 = j12 + j13;
                    if (z2) {
                        jM436G4 = m436G0(fileChannel, byteBufferAllocate, j14);
                    } else {
                        m425C1(fileChannel, byteBufferAllocate, 8, j14);
                        jM436G4 = byteBufferAllocate.getLong();
                    }
                    if (jM436G4 == 1) {
                        if (z2) {
                            jM436G5 = m436G0(fileChannel, byteBufferAllocate, 4 + j13);
                        } else {
                            m425C1(fileChannel, byteBufferAllocate, 8, j13 + 8);
                            jM436G5 = byteBufferAllocate.getLong();
                        }
                        long j15 = jM436G5 + j2;
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            long j16 = j15 + 1;
                            j3 = j2;
                            m425C1(fileChannel, byteBufferAllocate, 1, j15);
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
                            throw new C2055h("malformed DT_NEEDED section");
                        }
                        i6++;
                    } else {
                        j3 = j2;
                    }
                    j13 += z2 ? 8L : 16L;
                    if (jM436G4 == 0) {
                        if (i6 == i5) {
                            return strArr;
                        }
                        throw new C2055h("malformed DT_NEEDED section");
                    }
                    j12 = 0;
                    j2 = j3;
                }
            }
        }
    }

    /* JADX INFO: renamed from: j1 */
    public static void m533j1(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    /* JADX INFO: renamed from: j2 */
    public static void m534j2(Node node, InterfaceC1307a interfaceC1307a) {
        if (node.hasChildren()) {
            Iterator it = node.getChildren().iterator();
            while (it.hasNext()) {
                m534j2((Node) it.next(), interfaceC1307a);
            }
        }
        interfaceC1307a.processNode(node);
    }

    /* JADX INFO: renamed from: k */
    public static void m535k(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* JADX INFO: renamed from: k0 */
    public static String m536k0(String str, Object... objArr) {
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

    /* JADX INFO: renamed from: k1 */
    public static String m537k1(String str, String str2) {
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

    /* JADX INFO: renamed from: k2 */
    public static void m538k2(Node node, InterfaceC1307a interfaceC1307a) {
        interfaceC1307a.processNode(node);
        if (node.hasChildren()) {
            Iterator it = node.getChildren().iterator();
            while (it.hasNext()) {
                m538k2((Node) it.next(), interfaceC1307a);
            }
        }
    }

    /* JADX INFO: renamed from: l */
    public static void m539l(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    @NonNull
    /* JADX INFO: renamed from: l0 */
    public static ApiException m540l0(@NonNull Status status) {
        return status.f20497r != null ? new ResolvableApiException(status) : new ApiException(status);
    }

    /* JADX INFO: renamed from: l1 */
    public static void m541l1(File file) throws FileUtils$CreateDirectoryException {
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
    /* JADX INFO: renamed from: l2 */
    public static C1793a m542l2(C1793a c1793a, Context context, AttributeSet attributeSet) {
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
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, C10638R.a.GenericDraweeHierarchy);
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
                    if (index == C10638R.a.GenericDraweeHierarchy_actualImageScaleType) {
                        c1793a.f3464n = m416A0(typedArrayObtainStyledAttributes, index);
                    } else if (index == C10638R.a.GenericDraweeHierarchy_placeholderImage) {
                        c1793a.f3456f = m576u0(context2, typedArrayObtainStyledAttributes, index);
                    } else {
                        if (index == C10638R.a.GenericDraweeHierarchy_pressedStateOverlayImage) {
                            Drawable drawableM576u0 = m576u0(context2, typedArrayObtainStyledAttributes, index);
                            if (drawableM576u0 == null) {
                                c1793a.f3467q = null;
                            } else {
                                StateListDrawable stateListDrawable = new StateListDrawable();
                                i2 = indexCount;
                                int[] iArr = new int[i3];
                                iArr[0] = 16842919;
                                stateListDrawable.addState(iArr, drawableM576u0);
                                c1793a.f3467q = stateListDrawable;
                            }
                        } else {
                            i2 = indexCount;
                            if (index == C10638R.a.GenericDraweeHierarchy_progressBarImage) {
                                c1793a.f3462l = m576u0(context2, typedArrayObtainStyledAttributes, index);
                            } else if (index == C10638R.a.GenericDraweeHierarchy_fadeDuration) {
                                c1793a.f3454d = typedArrayObtainStyledAttributes.getInt(index, 0);
                            } else if (index == C10638R.a.GenericDraweeHierarchy_viewAspectRatio) {
                                c1793a.f3455e = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                            } else if (index == C10638R.a.GenericDraweeHierarchy_placeholderImageScaleType) {
                                c1793a.f3457g = m416A0(typedArrayObtainStyledAttributes, index);
                            } else if (index == C10638R.a.GenericDraweeHierarchy_retryImage) {
                                c1793a.f3458h = m576u0(context2, typedArrayObtainStyledAttributes, index);
                            } else if (index == C10638R.a.GenericDraweeHierarchy_retryImageScaleType) {
                                c1793a.f3459i = m416A0(typedArrayObtainStyledAttributes, index);
                            } else if (index == C10638R.a.GenericDraweeHierarchy_failureImage) {
                                c1793a.f3460j = m576u0(context2, typedArrayObtainStyledAttributes, index);
                            } else if (index == C10638R.a.GenericDraweeHierarchy_failureImageScaleType) {
                                c1793a.f3461k = m416A0(typedArrayObtainStyledAttributes, index);
                            } else if (index == C10638R.a.GenericDraweeHierarchy_progressBarImageScaleType) {
                                c1793a.f3463m = m416A0(typedArrayObtainStyledAttributes, index);
                            } else {
                                if (index == C10638R.a.GenericDraweeHierarchy_progressBarAutoRotateInterval) {
                                    integer = typedArrayObtainStyledAttributes.getInteger(index, integer);
                                } else if (index == C10638R.a.GenericDraweeHierarchy_backgroundImage) {
                                    c1793a.f3465o = m576u0(context2, typedArrayObtainStyledAttributes, index);
                                } else if (index == C10638R.a.GenericDraweeHierarchy_overlayImage) {
                                    c1793a.m1123b(m576u0(context2, typedArrayObtainStyledAttributes, index));
                                } else if (index == C10638R.a.GenericDraweeHierarchy_roundAsCircle) {
                                    if (c1793a.f3468r == null) {
                                        c1793a.f3468r = new C1795c();
                                    }
                                    c1793a.f3468r.f3472b = typedArrayObtainStyledAttributes.getBoolean(index, false);
                                } else if (index == C10638R.a.GenericDraweeHierarchy_roundedCornerRadius) {
                                    dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize);
                                } else if (index == C10638R.a.GenericDraweeHierarchy_roundTopLeft) {
                                    z10 = typedArrayObtainStyledAttributes.getBoolean(index, z10);
                                } else {
                                    if (index == C10638R.a.GenericDraweeHierarchy_roundTopRight) {
                                        z13 = typedArrayObtainStyledAttributes.getBoolean(index, z13);
                                    } else {
                                        if (index == C10638R.a.GenericDraweeHierarchy_roundBottomLeft) {
                                            z8 = typedArrayObtainStyledAttributes.getBoolean(index, z17);
                                        } else {
                                            z8 = z17;
                                            if (index == C10638R.a.GenericDraweeHierarchy_roundBottomRight) {
                                                z14 = typedArrayObtainStyledAttributes.getBoolean(index, z14);
                                            } else if (index == C10638R.a.GenericDraweeHierarchy_roundTopStart) {
                                                z11 = typedArrayObtainStyledAttributes.getBoolean(index, z11);
                                            } else if (index == C10638R.a.GenericDraweeHierarchy_roundTopEnd) {
                                                z12 = typedArrayObtainStyledAttributes.getBoolean(index, z12);
                                            } else {
                                                if (index == C10638R.a.GenericDraweeHierarchy_roundBottomStart) {
                                                    z9 = typedArrayObtainStyledAttributes.getBoolean(index, z16);
                                                } else {
                                                    z9 = z16;
                                                    if (index == C10638R.a.GenericDraweeHierarchy_roundBottomEnd) {
                                                        z15 = typedArrayObtainStyledAttributes.getBoolean(index, z15);
                                                    } else if (index == C10638R.a.GenericDraweeHierarchy_roundWithOverlayColor) {
                                                        if (c1793a.f3468r == null) {
                                                            c1793a.f3468r = new C1795c();
                                                        }
                                                        c1793a.f3468r.m1125b(typedArrayObtainStyledAttributes.getColor(index, 0));
                                                    } else if (index == C10638R.a.GenericDraweeHierarchy_roundingBorderWidth) {
                                                        if (c1793a.f3468r == null) {
                                                            c1793a.f3468r = new C1795c();
                                                        }
                                                        C1795c c1795c = c1793a.f3468r;
                                                        float dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                                                        Objects.requireNonNull(c1795c);
                                                        m535k(dimensionPixelSize2 >= 0.0f, "the border width cannot be < 0");
                                                        c1795c.f3475e = dimensionPixelSize2;
                                                    } else {
                                                        dimensionPixelSize = dimensionPixelSize;
                                                        if (index == C10638R.a.GenericDraweeHierarchy_roundingBorderColor) {
                                                            if (c1793a.f3468r == null) {
                                                                c1793a.f3468r = new C1795c();
                                                            }
                                                            c1793a.f3468r.f3476f = typedArrayObtainStyledAttributes.getColor(index, 0);
                                                        } else if (index == C10638R.a.GenericDraweeHierarchy_roundingBorderPadding) {
                                                            if (c1793a.f3468r == null) {
                                                                c1793a.f3468r = new C1795c();
                                                            }
                                                            C1795c c1795c2 = c1793a.f3468r;
                                                            float dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                                                            Objects.requireNonNull(c1795c2);
                                                            m535k(dimensionPixelSize3 >= 0.0f, "the padding cannot be < 0");
                                                            c1795c2.f3477g = dimensionPixelSize3;
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
        if (c1793a.f3462l != null && integer > 0) {
            c1793a.f3462l = new RunnableC1764c(c1793a.f3462l, integer);
        }
        if (i > 0) {
            if (c1793a.f3468r == null) {
                c1793a.f3468r = new C1795c();
            }
            C1795c c1795c3 = c1793a.f3468r;
            float f = z3 ? i : 0.0f;
            float f2 = z2 ? i : 0.0f;
            float f3 = z4 ? i : 0.0f;
            float f4 = z5 ? i : 0.0f;
            if (c1795c3.f3473c == null) {
                c1795c3.f3473c = new float[8];
            }
            float[] fArr = c1795c3.f3473c;
            fArr[1] = f;
            fArr[0] = f;
            fArr[3] = f2;
            fArr[2] = f2;
            fArr[5] = f3;
            fArr[4] = f3;
            fArr[7] = f4;
            fArr[6] = f4;
        }
        return c1793a;
    }

    @Pure
    /* JADX INFO: renamed from: m */
    public static void m543m(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* JADX INFO: renamed from: m0 */
    public static void m544m0(File file) throws IOException {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("cannot list directory " + file);
            }
            for (File file2 : fileArrListFiles) {
                m544m0(file2);
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

    /* JADX INFO: renamed from: m1 */
    public static int m545m1(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & ViewCompat.MEASURED_SIZE_MASK;
        }
        return (i & ViewCompat.MEASURED_SIZE_MASK) | ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24);
    }

    /* JADX INFO: renamed from: m2 */
    public static int m546m2(@RecentlyNonNull Parcel parcel) {
        int i = parcel.readInt();
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (((char) i) != 20293) {
            String strValueOf = String.valueOf(Integer.toHexString(i));
            throw new SafeParcelReader$ParseException(strValueOf.length() != 0 ? "Expected object header. Got 0x".concat(strValueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i2 = iM455M1 + iDataPosition;
        if (i2 < iDataPosition || i2 > parcel.dataSize()) {
            throw new SafeParcelReader$ParseException(C1643a.m853h(54, "Size read is invalid start=", iDataPosition, " end=", i2), parcel);
        }
        return i2;
    }

    /* JADX INFO: renamed from: n */
    public static void m547n(boolean z2, @RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        if (!z2) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    /* JADX INFO: renamed from: n0 */
    public static int m548n0(InputStream inputStream) throws IOException {
        return ((((byte) inputStream.read()) << 8) & 65280) | (((byte) inputStream.read()) & 255);
    }

    /* JADX INFO: renamed from: n1 */
    public static final Integer m549n1(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "$this$nextIntOrNull");
        if (jsonReader.mo6878N() != JsonToken.NULL) {
            return Integer.valueOf(jsonReader.mo6891y());
        }
        jsonReader.mo6876H();
        return null;
    }

    /* JADX INFO: renamed from: n2 */
    public static boolean m550n2(int i, C2757x c2757x, boolean z2) throws ParserException {
        if (c2757x.m3081a() < 7) {
            if (z2) {
                return false;
            }
            throw C1643a.m884w0(29, "too short header: ", c2757x.m3081a(), null);
        }
        if (c2757x.m3100t() != i) {
            if (z2) {
                return false;
            }
            String strValueOf = String.valueOf(Integer.toHexString(i));
            throw ParserException.m8755a(strValueOf.length() != 0 ? "expected header type ".concat(strValueOf) : new String("expected header type "), null);
        }
        if (c2757x.m3100t() == 118 && c2757x.m3100t() == 111 && c2757x.m3100t() == 114 && c2757x.m3100t() == 98 && c2757x.m3100t() == 105 && c2757x.m3100t() == 115) {
            return true;
        }
        if (z2) {
            return false;
        }
        throw ParserException.m8755a("expected characters 'vorbis'", null);
    }

    /* JADX INFO: renamed from: o */
    public static void m551o(boolean z2, @RecentlyNonNull Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* JADX INFO: renamed from: o0 */
    public static int m552o0(int i) {
        return (int) (i * 1.3333334f);
    }

    @Nullable
    /* JADX INFO: renamed from: o1 */
    public static <T> List<C1501a<T>> m553o1(AbstractC1473c abstractC1473c, C1505d c1505d, InterfaceC1469h0<T> interfaceC1469h0) throws IOException {
        return C1483r.m632a(abstractC1473c, c1505d, 1.0f, interfaceC1469h0);
    }

    /* JADX INFO: renamed from: o2 */
    public static void m554o2(File file, InterfaceC1677a interfaceC1677a) {
        interfaceC1677a.mo943b(file);
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    m554o2(file2, interfaceC1677a);
                } else {
                    interfaceC1677a.mo942a(file2);
                }
            }
        }
        interfaceC1677a.mo944c(file);
    }

    /* JADX INFO: renamed from: p */
    public static void m555p(int i, int i2, int i3, int i4, int i5) {
        m527i(Boolean.valueOf(i4 >= 0));
        m527i(Boolean.valueOf(i >= 0));
        m527i(Boolean.valueOf(i3 >= 0));
        m527i(Boolean.valueOf(i + i4 <= i5));
        m527i(Boolean.valueOf(i3 + i4 <= i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: p0 */
    public static C1782p m556p0(Drawable drawable) {
        if (drawable == 0) {
            return null;
        }
        if (drawable instanceof C1782p) {
            return (C1782p) drawable;
        }
        if (drawable instanceof InterfaceC1766d) {
            return m556p0(((InterfaceC1766d) drawable).mo1091l());
        }
        if (drawable instanceof C1762b) {
            C1762b c1762b = (C1762b) drawable;
            int length = c1762b.f3328l.length;
            for (int i = 0; i < length; i++) {
                C1782p c1782pM556p0 = m556p0(c1762b.m1093a(i));
                if (c1782pM556p0 != null) {
                    return c1782pM556p0;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: p1 */
    public static C1572a m557p1(AbstractC1473c abstractC1473c, C1505d c1505d) throws IOException {
        return new C1572a(m553o1(abstractC1473c, c1505d, C1464f.f2228a));
    }

    /* JADX INFO: renamed from: p2 */
    public static void m558p2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Bundle bundle, boolean z2) {
        if (bundle == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iM594y2 = m594y2(parcel, i);
            parcel.writeBundle(bundle);
            m418A2(parcel, iM594y2);
        }
    }

    @Pure
    /* JADX INFO: renamed from: q */
    public static void m559q(boolean z2, @Nullable String str) throws ParserException {
        if (!z2) {
            throw ParserException.m8755a(str, null);
        }
    }

    /* JADX INFO: renamed from: q0 */
    public static Object m560q0(Object obj) {
        return new a(obj.getClass(), Array.getLength(obj), obj);
    }

    /* JADX INFO: renamed from: q1 */
    public static C1573b m561q1(AbstractC1473c abstractC1473c, C1505d c1505d) throws IOException {
        return m565r1(abstractC1473c, c1505d, true);
    }

    /* JADX INFO: renamed from: q2 */
    public static void m562q2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull byte[] bArr, boolean z2) {
        if (bArr == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iM594y2 = m594y2(parcel, i);
            parcel.writeByteArray(bArr);
            m418A2(parcel, iM594y2);
        }
    }

    /* JADX INFO: renamed from: r */
    public static boolean m563r(InterfaceC3041i interfaceC3041i) throws IOException {
        C2757x c2757x = new C2757x(8);
        if (C3110d.m3800a(interfaceC3041i, c2757x).f8960a != 1380533830) {
            return false;
        }
        interfaceC3041i.mo3652o(c2757x.f6793a, 0, 4);
        c2757x.m3079E(0);
        int iM3086f = c2757x.m3086f();
        if (iM3086f == 1463899717) {
            return true;
        }
        StringBuilder sb = new StringBuilder(34);
        sb.append("Unsupported form type: ");
        sb.append(iM3086f);
        Log.e("WavHeaderReader", sb.toString());
        return false;
    }

    @Nullable
    /* JADX INFO: renamed from: r0 */
    public static String m564r0(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (xmlPullParser.getAttributeName(i).equals(str)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: r1 */
    public static C1573b m565r1(AbstractC1473c abstractC1473c, C1505d c1505d, boolean z2) throws IOException {
        return new C1573b(C1483r.m632a(abstractC1473c, c1505d, z2 ? C1499g.m659c() : 1.0f, C1470i.f2235a));
    }

    /* JADX INFO: renamed from: r2 */
    public static void m566r2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull IBinder iBinder, boolean z2) {
        if (iBinder == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iM594y2 = m594y2(parcel, i);
            parcel.writeStrongBinder(iBinder);
            m418A2(parcel, iM594y2);
        }
    }

    /* JADX INFO: renamed from: s */
    public static void m567s(@RecentlyNonNull Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            String name = looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper";
            String name2 = handler.getLooper().getThread().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name2).length() + 36 + String.valueOf(name).length());
            C1643a.m876s0(sb, "Must be called on ", name2, " thread, but got ", name);
            sb.append(".");
            throw new IllegalStateException(sb.toString());
        }
    }

    /* JADX INFO: renamed from: s0 */
    public static int m568s0(int i) {
        if (i == 3) {
            return 180;
        }
        if (i != 6) {
            return i != 8 ? 0 : 270;
        }
        return 90;
    }

    /* JADX INFO: renamed from: s1 */
    public static C1575d m569s1(AbstractC1473c abstractC1473c, C1505d c1505d) throws IOException {
        return new C1575d(m553o1(abstractC1473c, c1505d, C1480o.f2274a));
    }

    /* JADX INFO: renamed from: s2 */
    public static void m570s2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable parcelable, int i2, boolean z2) {
        if (parcelable == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iM594y2 = m594y2(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            m418A2(parcel, iM594y2);
        }
    }

    @Pure
    /* JADX INFO: renamed from: t */
    public static int m571t(int i, int i2, int i3) {
        if (i < i2 || i >= i3) {
            throw new IndexOutOfBoundsException();
        }
        return i;
    }

    /* JADX INFO: renamed from: t0 */
    public static Object m572t0(AbstractC2360j abstractC2360j) {
        Class<?> cls = abstractC2360j._class;
        Class<?> clsM2190v = C2342d.m2190v(cls);
        if (clsM2190v == null) {
            if (abstractC2360j.mo2104v() || abstractC2360j.mo1728b()) {
                return InterfaceC2094p.a.NON_EMPTY;
            }
            if (cls == String.class) {
                return "";
            }
            if (abstractC2360j.m2216B(Date.class)) {
                return new Date(0L);
            }
            if (!abstractC2360j.m2216B(Calendar.class)) {
                return null;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(0L);
            return gregorianCalendar;
        }
        if (clsM2190v == Integer.TYPE) {
            return 0;
        }
        if (clsM2190v == Long.TYPE) {
            return 0L;
        }
        if (clsM2190v == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (clsM2190v == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (clsM2190v == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (clsM2190v == Byte.TYPE) {
            return (byte) 0;
        }
        if (clsM2190v == Short.TYPE) {
            return (short) 0;
        }
        if (clsM2190v == Character.TYPE) {
            return (char) 0;
        }
        throw new IllegalArgumentException(C1643a.m867o(clsM2190v, C1643a.m833U("Class "), " is not a primitive type"));
    }

    /* JADX WARN: Code duplicated, block: B:35:0x007f  */
    @Nullable
    /* JADX INFO: renamed from: t1 */
    public static ArrayList<C2796h.a> m573t1(C2757x c2757x) {
        ArrayList<C2796h.a> arrayList;
        int i;
        ArrayList<C2796h.a> arrayList2;
        C2796h.a aVar;
        C2757x c2757x2 = c2757x;
        if (c2757x.m3100t() != 0) {
            return null;
        }
        c2757x2.m3080F(7);
        int iM3086f = c2757x.m3086f();
        if (iM3086f == 1684433976) {
            C2757x c2757x3 = new C2757x();
            Inflater inflater = new Inflater(true);
            try {
                if (!C2738e0.m3016x(c2757x2, c2757x3, inflater)) {
                    inflater.end();
                    return null;
                }
                inflater.end();
                c2757x2 = c2757x3;
            } catch (Throwable th) {
                inflater.end();
                throw th;
            }
        } else if (iM3086f != 1918990112) {
            return null;
        }
        ArrayList<C2796h.a> arrayList3 = new ArrayList<>();
        int i2 = c2757x2.f6794b;
        int i3 = c2757x2.f6795c;
        while (i2 < i3) {
            int iM3086f2 = c2757x2.m3086f() + i2;
            if (iM3086f2 > i2 && iM3086f2 <= i3) {
                if (c2757x2.m3086f() == 1835365224) {
                    int iM3086f3 = c2757x2.m3086f();
                    if (iM3086f3 > 10000) {
                        arrayList2 = arrayList3;
                        i = i3;
                        aVar = null;
                    } else {
                        float[] fArr = new float[iM3086f3];
                        for (int i4 = 0; i4 < iM3086f3; i4++) {
                            fArr[i4] = Float.intBitsToFloat(c2757x2.m3086f());
                        }
                        int iM3086f4 = c2757x2.m3086f();
                        if (iM3086f4 > 32000) {
                            arrayList2 = arrayList3;
                        } else {
                            double dLog = Math.log(2.0d);
                            arrayList2 = arrayList3;
                            int iCeil = (int) Math.ceil(Math.log(((double) iM3086f3) * 2.0d) / dLog);
                            C2756w c2756w = new C2756w(c2757x2.f6793a);
                            c2756w.m3071k(c2757x2.f6794b * 8);
                            float[] fArr2 = new float[iM3086f4 * 5];
                            int i5 = 5;
                            int[] iArr = new int[5];
                            int i6 = 0;
                            int i7 = 0;
                            while (true) {
                                if (i6 < iM3086f4) {
                                    int i8 = 0;
                                    while (true) {
                                        if (i8 < i5) {
                                            int i9 = iArr[i8];
                                            int iM3067g = c2756w.m3067g(iCeil);
                                            int i10 = i9 + ((-(iM3067g & 1)) ^ (iM3067g >> 1));
                                            if (i10 < iM3086f3 && i10 >= 0) {
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
                                    c2756w.m3071k((c2756w.m3065e() + 7) & (-8));
                                    int i11 = 32;
                                    int iM3067g2 = c2756w.m3067g(32);
                                    C2796h.b[] bVarArr = new C2796h.b[iM3067g2];
                                    int i12 = 0;
                                    while (true) {
                                        if (i12 < iM3067g2) {
                                            int iM3067g3 = c2756w.m3067g(8);
                                            int iM3067g4 = c2756w.m3067g(8);
                                            int iM3067g5 = c2756w.m3067g(i11);
                                            if (iM3067g5 <= 128000) {
                                                i = i3;
                                                int iCeil2 = (int) Math.ceil(Math.log(((double) iM3086f4) * 2.0d) / dLog);
                                                float[] fArr3 = new float[iM3067g5 * 3];
                                                float[] fArr4 = new float[iM3067g5 * 2];
                                                int i13 = 0;
                                                int i14 = 0;
                                                while (true) {
                                                    if (i13 < iM3067g5) {
                                                        int iM3067g6 = c2756w.m3067g(iCeil2);
                                                        int i15 = iM3067g6 >> 1;
                                                        C2756w c2756w2 = c2756w;
                                                        int i16 = iM3067g6 & 1;
                                                        int i17 = iM3067g2;
                                                        float[] fArr5 = fArr4;
                                                        int i18 = i14 + ((-i16) ^ i15);
                                                        if (i18 >= 0 && i18 < iM3086f4) {
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
                                                            iM3067g2 = i17;
                                                            c2756w = c2756w2;
                                                        }
                                                    } else {
                                                        bVarArr[i12] = new C2796h.b(iM3067g3, fArr3, fArr4, iM3067g4);
                                                        i12++;
                                                        i3 = i;
                                                        iM3067g2 = iM3067g2;
                                                        i11 = 32;
                                                    }
                                                }
                                            }
                                            aVar = null;
                                        } else {
                                            i = i3;
                                            aVar = new C2796h.a(bVarArr);
                                        }
                                    }
                                }
                            }
                        }
                        i = i3;
                        aVar = null;
                    }
                    if (aVar != null) {
                        arrayList = arrayList2;
                        arrayList.add(aVar);
                    }
                } else {
                    arrayList = arrayList3;
                    i = i3;
                }
                c2757x2.m3079E(iM3086f2);
                arrayList3 = arrayList;
                i2 = iM3086f2;
                i3 = i;
            }
            return null;
        }
        return arrayList3;
    }

    /* JADX INFO: renamed from: t2 */
    public static void m574t2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull String str, boolean z2) {
        if (str == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iM594y2 = m594y2(parcel, i);
            parcel.writeString(str);
            m418A2(parcel, iM594y2);
        }
    }

    /* JADX INFO: renamed from: u */
    public static void m575u(@RecentlyNonNull String str) {
        if (!(Looper.getMainLooper() == Looper.myLooper())) {
            throw new IllegalStateException(str);
        }
    }

    /* JADX INFO: renamed from: u0 */
    public static Drawable m576u0(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getResources().getDrawable(resourceId);
    }

    /* JADX INFO: renamed from: u1 */
    public static C1577f m577u1(AbstractC1473c abstractC1473c, C1505d c1505d) throws IOException {
        return new C1577f(C1483r.m632a(abstractC1473c, c1505d, C1499g.m659c(), C1488w.f2289a));
    }

    /* JADX INFO: renamed from: u2 */
    public static void m578u2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull String[] strArr, boolean z2) {
        if (strArr == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iM594y2 = m594y2(parcel, i);
            parcel.writeStringArray(strArr);
            m418A2(parcel, iM594y2);
        }
    }

    @RecentlyNonNull
    @EnsuresNonNull({"#1"})
    /* JADX INFO: renamed from: v */
    public static String m579v(@Nullable String str, @RecentlyNonNull Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: v0 */
    public static String m580v0(@RecentlyNonNull PowerManager.WakeLock wakeLock, @RecentlyNonNull String str) {
        String strValueOf = String.valueOf(String.valueOf(((long) System.identityHashCode(wakeLock)) | (((long) Process.myPid()) << 32)));
        String strValueOf2 = String.valueOf(true == TextUtils.isEmpty(null) ? "" : null);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    @Nullable
    /* JADX INFO: renamed from: v1 */
    public static C3051j m581v1(byte[] bArr) {
        C2757x c2757x = new C2757x(bArr);
        if (c2757x.f6795c < 32) {
            return null;
        }
        c2757x.m3079E(0);
        if (c2757x.m3086f() != c2757x.m3081a() + 4 || c2757x.m3086f() != 1886614376) {
            return null;
        }
        int iM3086f = (c2757x.m3086f() >> 24) & 255;
        if (iM3086f > 1) {
            C1643a.m852g0(37, "Unsupported pssh version: ", iM3086f, "PsshAtomUtil");
            return null;
        }
        UUID uuid = new UUID(c2757x.m3093m(), c2757x.m3093m());
        if (iM3086f == 1) {
            c2757x.m3080F(c2757x.m3103w() * 16);
        }
        int iM3103w = c2757x.m3103w();
        if (iM3103w != c2757x.m3081a()) {
            return null;
        }
        byte[] bArr2 = new byte[iM3103w];
        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr2, 0, iM3103w);
        c2757x.f6794b += iM3103w;
        return new C3051j(uuid, iM3086f, bArr2);
    }

    /* JADX INFO: renamed from: v2 */
    public static <T extends Parcelable> void m582v2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull T[] tArr, int i2, boolean z2) {
        if (tArr == null) {
            if (z2) {
                parcel.writeInt(i | 0);
                return;
            }
            return;
        }
        int iM594y2 = m594y2(parcel, i);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                m422B2(parcel, t, i2);
            }
        }
        m418A2(parcel, iM594y2);
    }

    @RecentlyNonNull
    @EnsuresNonNull({"#1"})
    /* JADX INFO: renamed from: w */
    public static String m583w(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    /* JADX INFO: renamed from: w0 */
    public static int m584w0(InputStream inputStream) throws IOException {
        byte b2 = (byte) inputStream.read();
        byte b3 = (byte) inputStream.read();
        return ((((byte) inputStream.read()) << 24) & ViewCompat.MEASURED_STATE_MASK) | ((((byte) inputStream.read()) << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((b3 << 8) & 65280) | (b2 & 255);
    }

    @Nullable
    /* JADX INFO: renamed from: w1 */
    public static byte[] m585w1(byte[] bArr, UUID uuid) {
        C3051j c3051jM581v1 = m581v1(bArr);
        if (c3051jM581v1 == null) {
            return null;
        }
        if (uuid.equals(c3051jM581v1.f8449a)) {
            return c3051jM581v1.f8451c;
        }
        String strValueOf = String.valueOf(uuid);
        String strValueOf2 = String.valueOf(c3051jM581v1.f8449a);
        C1643a.m874r0(C1643a.m831S(strValueOf2.length() + strValueOf.length() + 33, "UUID mismatch. Expected: ", strValueOf, ", got: ", strValueOf2), ".", "PsshAtomUtil");
        return null;
    }

    /* JADX INFO: renamed from: w2 */
    public static <T extends Parcelable> void m586w2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull List<T> list, boolean z2) {
        if (list == null) {
            if (z2) {
                parcel.writeInt(i | 0);
                return;
            }
            return;
        }
        int iM594y2 = m594y2(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                m422B2(parcel, t, 0);
            }
        }
        m418A2(parcel, iM594y2);
    }

    /* JADX INFO: renamed from: x */
    public static void m587x(@RecentlyNonNull String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException(str);
        }
    }

    /* JADX INFO: renamed from: x0 */
    public static final Integer m588x0(Intent intent, String str) {
        C12238m.checkNotNullParameter(intent, "$this$getIntExtraOrNull");
        C12238m.checkNotNullParameter(str, "key");
        Integer numValueOf = Integer.valueOf(intent.getIntExtra(str, Integer.MIN_VALUE));
        if (numValueOf.intValue() == Integer.MIN_VALUE) {
            return null;
        }
        return numValueOf;
    }

    /* JADX INFO: renamed from: x1 */
    public static boolean m589x1(InterfaceC3041i interfaceC3041i, byte[] bArr, int i, int i2, boolean z2) throws IOException {
        try {
            return interfaceC3041i.mo3644e(bArr, i, i2, z2);
        } catch (EOFException e) {
            if (z2) {
                return false;
            }
            throw e;
        }
    }

    /* JADX INFO: renamed from: x2 */
    public static void m590x2(Parcel parcel, int i, int i2) {
        int iM455M1 = m455M1(parcel, i);
        if (iM455M1 == i2) {
            return;
        }
        String hexString = Integer.toHexString(iM455M1);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(iM455M1);
        throw new SafeParcelReader$ParseException(C1643a.m823K(sb, " (0x", hexString, ")"), parcel);
    }

    /* JADX INFO: renamed from: y */
    public static <T> T m591y(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* JADX INFO: renamed from: y0 */
    public static final StageRequestToSpeakState m592y0(VoiceState voiceState) {
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
    /* JADX INFO: renamed from: y1 */
    public static Metadata m593y1(InterfaceC3041i interfaceC3041i, boolean z2) throws IOException {
        C3166a c3166a;
        if (z2) {
            c3166a = null;
        } else {
            int i = C3167b.f9154a;
            c3166a = new C3167b.a() { // from class: b.i.a.c.z2.k.a
                @Override // p007b.p225i.p226a.p242c.p279z2.p283k.C3167b.a
                /* JADX INFO: renamed from: a */
                public final boolean mo3688a(int i2, int i3, int i4, int i5, int i6) {
                    int i7 = C3167b.f9154a;
                    return false;
                }
            };
        }
        C2757x c2757x = new C2757x(10);
        Metadata metadataM3922d = null;
        int i2 = 0;
        while (true) {
            try {
                interfaceC3041i.mo3652o(c2757x.f6793a, 0, 10);
                c2757x.m3079E(0);
                if (c2757x.m3102v() != 4801587) {
                    break;
                }
                c2757x.m3080F(3);
                int iM3099s = c2757x.m3099s();
                int i3 = iM3099s + 10;
                if (metadataM3922d == null) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(c2757x.f6793a, 0, bArr, 0, 10);
                    interfaceC3041i.mo3652o(bArr, 10, iM3099s);
                    metadataM3922d = new C3167b(c3166a).m3922d(bArr, i3);
                } else {
                    interfaceC3041i.mo3646g(iM3099s);
                }
                i2 += i3;
            } catch (EOFException unused) {
            }
        }
        interfaceC3041i.mo3649k();
        interfaceC3041i.mo3646g(i2);
        if (metadataM3922d == null || metadataM3922d.f19936j.length == 0) {
            return null;
        }
        return metadataM3922d;
    }

    /* JADX INFO: renamed from: y2 */
    public static int m594y2(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    @NonNull
    @EnsuresNonNull({"#1"})
    /* JADX INFO: renamed from: z */
    public static <T> T m595z(@RecentlyNonNull T t, @RecentlyNonNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* JADX INFO: renamed from: z0 */
    public static List<String> m596z0(CacheKey cacheKey) {
        try {
            if (cacheKey instanceof C1653c) {
                Objects.requireNonNull((C1653c) cacheKey);
                throw null;
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(cacheKey.mo929a() ? cacheKey.mo930b() : m485W1(cacheKey));
            return arrayList;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: z1 */
    public static int m597z1(InterfaceC3041i interfaceC3041i, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int iMo3648i = interfaceC3041i.mo3648i(bArr, i + i3, i2 - i3);
            if (iMo3648i == -1) {
                break;
            }
            i3 += iMo3648i;
        }
        return i3;
    }

    /* JADX INFO: renamed from: z2 */
    public static void m598z2(Parcel parcel, int i, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        String hexString = Integer.toHexString(i2);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(i2);
        throw new SafeParcelReader$ParseException(C1643a.m823K(sb, " (0x", hexString, ")"), parcel);
    }
}
