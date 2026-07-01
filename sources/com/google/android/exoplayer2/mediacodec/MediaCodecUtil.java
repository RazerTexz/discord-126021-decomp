package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.ColorInfo;
import b.i.a.c.y2.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"InlinedApi"})
public final class MediaCodecUtil {
    public static final Pattern a = Pattern.compile("^\\D?(\\d+)$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("MediaCodecUtil.class")
    public static final HashMap<b, List<MediaCodecInfo>> f2947b = new HashMap<>();
    public static int c = -1;

    public static class DecoderQueryException extends Exception {
        public DecoderQueryException(Throwable th, a aVar) {
            super("Failed to query underlying media codecs", th);
        }
    }

    public static final class b {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2948b;
        public final boolean c;

        public b(String str, boolean z2, boolean z3) {
            this.a = str;
            this.f2948b = z2;
            this.c = z3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            return TextUtils.equals(this.a, bVar.a) && this.f2948b == bVar.f2948b && this.c == bVar.c;
        }

        public int hashCode() {
            return ((outline.m(this.a, 31, 31) + (this.f2948b ? 1231 : 1237)) * 31) + (this.c ? 1231 : 1237);
        }
    }

    public interface c {
        android.media.MediaCodecInfo a(int i);

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int d();

        boolean e();
    }

    public static final class d implements c {
        public d(a aVar) {
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public android.media.MediaCodecInfo a(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int d() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean e() {
            return false;
        }
    }

    @RequiresApi(21)
    public static final class e implements c {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public android.media.MediaCodecInfo[] f2949b;

        public e(boolean z2, boolean z3) {
            this.a = (z2 || z3) ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public android.media.MediaCodecInfo a(int i) {
            if (this.f2949b == null) {
                this.f2949b = new MediaCodecList(this.a).getCodecInfos();
            }
            return this.f2949b[i];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int d() {
            if (this.f2949b == null) {
                this.f2949b = new MediaCodecList(this.a).getCodecInfos();
            }
            return this.f2949b.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean e() {
            return true;
        }
    }

    public interface f<T> {
        int a(T t);
    }

    public static void a(String str, List<b.i.a.c.y2.MediaCodecInfo> list) {
        if ("audio/raw".equals(str)) {
            if (Util2.a < 26 && Util2.f968b.equals("R9") && list.size() == 1 && list.get(0).a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(b.i.a.c.y2.MediaCodecInfo.i("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            j(list, new f() { // from class: b.i.a.c.y2.e
                @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
                public final int a(Object obj) {
                    Pattern pattern = MediaCodecUtil.a;
                    String str2 = ((MediaCodecInfo) obj).a;
                    if (str2.startsWith("OMX.google") || str2.startsWith("c2.android")) {
                        return 1;
                    }
                    return (Util2.a >= 26 || !str2.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
                }
            });
        }
        int i = Util2.a;
        if (i < 21 && list.size() > 1) {
            String str2 = list.get(0).a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                j(list, new f() { // from class: b.i.a.c.y2.f
                    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
                    public final int a(Object obj) {
                        Pattern pattern = MediaCodecUtil.a;
                        return ((MediaCodecInfo) obj).a.startsWith("OMX.google") ? 1 : 0;
                    }
                });
            }
        }
        if (i >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(list.get(0).a)) {
            return;
        }
        list.add(list.remove(0));
    }

    @Nullable
    public static String b(android.media.MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:146:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:162:0x0240  */
    /* JADX WARN: Code duplicated, block: B:203:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:310:0x042f A[Catch: NumberFormatException -> 0x043f, TRY_LEAVE, TryCatch #3 {NumberFormatException -> 0x043f, blocks: (B:280:0x03c4, B:282:0x03d8, B:294:0x03f7, B:310:0x042f), top: B:637:0x03c4 }] */
    /* JADX WARN: Code duplicated, block: B:448:0x061e  */
    /* JADX WARN: Code duplicated, block: B:477:0x06dd  */
    /* JADX WARN: Code duplicated, block: B:585:0x08a6  */
    /* JADX WARN: Code duplicated, block: B:586:0x08a8  */
    /* JADX WARN: Code duplicated, block: B:594:0x08b9  */
    /* JADX WARN: Code duplicated, block: B:596:0x08bd  */
    /* JADX WARN: Code duplicated, block: B:597:0x08bf  */
    /* JADX WARN: Code duplicated, block: B:598:0x08c2  */
    /* JADX WARN: Code duplicated, block: B:599:0x08c5  */
    /* JADX WARN: Code duplicated, block: B:600:0x08c8  */
    /* JADX WARN: Code duplicated, block: B:601:0x08cb  */
    /* JADX WARN: Code duplicated, block: B:602:0x08ce  */
    /* JADX WARN: Code duplicated, block: B:603:0x08d1  */
    /* JADX WARN: Code duplicated, block: B:604:0x08d4  */
    /* JADX WARN: Code duplicated, block: B:605:0x08d7  */
    /* JADX WARN: Code duplicated, block: B:606:0x08db  */
    /* JADX WARN: Code duplicated, block: B:607:0x08de  */
    /* JADX WARN: Code duplicated, block: B:608:0x08e1  */
    /* JADX WARN: Code duplicated, block: B:609:0x08e4  */
    /* JADX WARN: Code duplicated, block: B:610:0x08e7  */
    /* JADX WARN: Code duplicated, block: B:611:0x08ea  */
    /* JADX WARN: Code duplicated, block: B:612:0x08ed  */
    /* JADX WARN: Code duplicated, block: B:613:0x08f0  */
    /* JADX WARN: Code duplicated, block: B:614:0x08f3  */
    /* JADX WARN: Code duplicated, block: B:615:0x08f6  */
    /* JADX WARN: Code duplicated, block: B:616:0x08f9  */
    /* JADX WARN: Code duplicated, block: B:617:0x08fc  */
    /* JADX WARN: Code duplicated, block: B:618:0x08ff  */
    /* JADX WARN: Code duplicated, block: B:619:0x0901  */
    /* JADX WARN: Code duplicated, block: B:620:0x0903  */
    /* JADX WARN: Code duplicated, block: B:623:0x0907  */
    /* JADX WARN: Code duplicated, block: B:624:0x090f  */
    /* JADX WARN: Code duplicated, block: B:646:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:80:0x012c  */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0278, code lost:
    
        if (r1.equals("vp09") != true) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x027b, code lost:
    
        r1 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0283, code lost:
    
        if (r1.equals("mp4a") != true) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0286, code lost:
    
        r1 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x028e, code lost:
    
        if (r1.equals("hvc1") != true) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0291, code lost:
    
        r1 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0299, code lost:
    
        if (r1.equals("hev1") != true) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x029c, code lost:
    
        r1 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x02a4, code lost:
    
        if (r1.equals("avc2") != true) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x02a7, code lost:
    
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x02af, code lost:
    
        if (r1.equals("avc1") != true) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x02b2, code lost:
    
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x02ba, code lost:
    
        if (r1.equals("av01") != true) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x02bd, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x02bf, code lost:
    
        r1 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x02c0, code lost:
    
        switch(r1) {
            case 0: goto L567;
            case 1: goto L491;
            case 2: goto L491;
            case 3: goto L318;
            case 4: goto L318;
            case 5: goto L272;
            case 6: goto L207;
            default: goto L205;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x04d0, code lost:
    
        if (r0.equals("L186") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x04d4, code lost:
    
        r6 = 25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x04de, code lost:
    
        if (r0.equals("L183") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x04e2, code lost:
    
        r6 = 24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x04ec, code lost:
    
        if (r0.equals("L180") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x04f0, code lost:
    
        r6 = 23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x04fa, code lost:
    
        if (r0.equals("L156") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x04fe, code lost:
    
        r6 = 22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x0508, code lost:
    
        if (r0.equals("L153") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x050c, code lost:
    
        r6 = 21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x0516, code lost:
    
        if (r0.equals("L150") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x051a, code lost:
    
        r6 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0524, code lost:
    
        if (r0.equals("L123") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x0528, code lost:
    
        r6 = 19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x0532, code lost:
    
        if (r0.equals("L120") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x0536, code lost:
    
        r6 = 18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x0540, code lost:
    
        if (r0.equals("H186") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x0544, code lost:
    
        r6 = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x054e, code lost:
    
        if (r0.equals("H183") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x0552, code lost:
    
        r6 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x055c, code lost:
    
        if (r0.equals("H180") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x0560, code lost:
    
        r6 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x056a, code lost:
    
        if (r0.equals("H156") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x056e, code lost:
    
        r6 = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x0578, code lost:
    
        if (r0.equals("H153") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x057c, code lost:
    
        r6 = 13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x0586, code lost:
    
        if (r0.equals("H150") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x058a, code lost:
    
        r6 = 12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0594, code lost:
    
        if (r0.equals("H123") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0598, code lost:
    
        r6 = 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x05a2, code lost:
    
        if (r0.equals("H120") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x05a6, code lost:
    
        r6 = 10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x05b0, code lost:
    
        if (r0.equals("L93") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x05b4, code lost:
    
        r6 = 9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x05be, code lost:
    
        if (r0.equals("L90") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x05c2, code lost:
    
        r6 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x05cc, code lost:
    
        if (r0.equals("L63") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x05cf, code lost:
    
        r6 = 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x05d7, code lost:
    
        if (r0.equals("L60") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x05da, code lost:
    
        r6 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x05e2, code lost:
    
        if (r0.equals("L30") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x05e5, code lost:
    
        r6 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x05ed, code lost:
    
        if (r0.equals("H93") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:431:0x05f0, code lost:
    
        r6 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x05f8, code lost:
    
        if (r0.equals("H90") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:435:0x05fb, code lost:
    
        r6 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x0603, code lost:
    
        if (r0.equals("H63") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:439:0x0606, code lost:
    
        r6 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:441:0x060e, code lost:
    
        if (r0.equals("H60") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:443:0x0611, code lost:
    
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:445:0x0619, code lost:
    
        if (r0.equals("H30") != true) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:447:0x061c, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x061e, code lost:
    
        r6 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:449:0x061f, code lost:
    
        switch(r6) {
            case 0: goto L476;
            case 1: goto L475;
            case 2: goto L474;
            case 3: goto L473;
            case 4: goto L472;
            case 5: goto L471;
            case 6: goto L470;
            case 7: goto L469;
            case 8: goto L468;
            case 9: goto L467;
            case 10: goto L466;
            case 11: goto L465;
            case 12: goto L464;
            case 13: goto L463;
            case 14: goto L462;
            case 15: goto L461;
            case 16: goto L460;
            case 17: goto L459;
            case 18: goto L458;
            case 19: goto L457;
            case 20: goto L456;
            case 21: goto L455;
            case 22: goto L454;
            case 23: goto L453;
            case 24: goto L452;
            case 25: goto L451;
            default: goto L477;
        };
     */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v108 int, still in use, count: 1, list:
      (r0v108 int) from 0x0155: SWITCH (r0v108 int)
     case 1537: goto B:126:0x01b0
     case 1538: goto B:122:0x01a7
     case 1539: goto B:118:0x019e
     case 1540: goto B:114:0x0195
     case 1541: goto B:110:0x018a
     case 1542: goto B:106:0x017f
     case 1543: goto B:102:0x0174
     case 1544: goto B:98:0x0169
     case 1545: goto B:94:0x015d
     default: goto B:92:0x0158 A[RegionRef:SW:91]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
    	at jadx.core.utils.InsnRemover.removeAllMarked(InsnRemover.java:276)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:354)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v108 int, still in use, count: 1, list:
      (r0v108 int) from 0x0155: SWITCH (r0v108 int)
     case 1537: goto B:126:0x01b0
     case 1538: goto B:122:0x01a7
     case 1539: goto B:118:0x019e
     case 1540: goto B:114:0x0195
     case 1541: goto B:110:0x018a
     case 1542: goto B:106:0x017f
     case 1543: goto B:102:0x0174
     case 1544: goto B:98:0x0169
     case 1545: goto B:94:0x015d
     default: goto B:92:0x0158 A[RegionRef:SW:91]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer> c(Format2 format2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Integer num;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Integer num2;
        Integer num3;
        byte b2;
        String str = format2.t;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        if ("video/dolby-vision".equals(format2.w)) {
            String str2 = format2.t;
            if (strArrSplit.length < 3) {
                String strValueOf = String.valueOf(str2);
                Log.w("MediaCodecUtil", strValueOf.length() != 0 ? "Ignoring malformed Dolby Vision codec string: ".concat(strValueOf) : new String("Ignoring malformed Dolby Vision codec string: "));
            } else {
                Matcher matcher = a.matcher(strArrSplit[1]);
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    if (strGroup != null) {
                        switch (strGroup) {
                            case "00":
                                num2 = 1;
                                break;
                            case "01":
                                num2 = 2;
                                break;
                            case "02":
                                num2 = 4;
                                break;
                            case "03":
                                num2 = 8;
                                break;
                            case "04":
                                num2 = 16;
                                break;
                            case "05":
                                num2 = 32;
                                break;
                            case "06":
                                num2 = 64;
                                break;
                            case "07":
                                num2 = 128;
                                break;
                            case "08":
                                num2 = 256;
                                break;
                            case "09":
                                num2 = 512;
                                break;
                            default:
                                num2 = null;
                                break;
                        }
                    } else {
                        num2 = null;
                    }
                    if (num2 == null) {
                        String strValueOf2 = String.valueOf(strGroup);
                        Log.w("MediaCodecUtil", strValueOf2.length() != 0 ? "Unknown Dolby Vision profile string: ".concat(strValueOf2) : new String("Unknown Dolby Vision profile string: "));
                    } else {
                        String str3 = strArrSplit[2];
                        if (str3 != null) {
                            switch (str3.hashCode()) {
                                case 1537:
                                    if (!str3.equals("01")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 0;
                                    }
                                    break;
                                case 1538:
                                    if (!str3.equals("02")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 1;
                                    }
                                    break;
                                case 1539:
                                    if (!str3.equals("03")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 2;
                                    }
                                    break;
                                case 1540:
                                    if (!str3.equals("04")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 3;
                                    }
                                    break;
                                case 1541:
                                    if (!str3.equals("05")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 4;
                                    }
                                    break;
                                case 1542:
                                    if (!str3.equals("06")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 5;
                                    }
                                    break;
                                case 1543:
                                    if (!str3.equals("07")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 6;
                                    }
                                    break;
                                case 1544:
                                    if (!str3.equals("08")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 7;
                                    }
                                    break;
                                case 1545:
                                    if (!str3.equals("09")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 8;
                                    }
                                    break;
                                default:
                                    switch (str3) {
                                        case "10":
                                            b2 = 9;
                                            break;
                                        case "11":
                                            b2 = 10;
                                            break;
                                        case "12":
                                            b2 = 11;
                                            break;
                                        case "13":
                                            b2 = 12;
                                            break;
                                        default:
                                            b2 = -1;
                                            break;
                                    }
                                    break;
                            }
                            switch (b2) {
                                case 0:
                                    num3 = 1;
                                    break;
                                case 1:
                                    num3 = 2;
                                    break;
                                case 2:
                                    num3 = 4;
                                    break;
                                case 3:
                                    num3 = 8;
                                    break;
                                case 4:
                                    num3 = 16;
                                    break;
                                case 5:
                                    num3 = 32;
                                    break;
                                case 6:
                                    num3 = 64;
                                    break;
                                case 7:
                                    num3 = 128;
                                    break;
                                case 8:
                                    num3 = 256;
                                    break;
                                case 9:
                                    num3 = 512;
                                    break;
                                case 10:
                                    num3 = 1024;
                                    break;
                                case 11:
                                    num3 = 2048;
                                    break;
                                case 12:
                                    num3 = 4096;
                                    break;
                                default:
                                    num3 = null;
                                    break;
                            }
                        } else {
                            num3 = null;
                        }
                        if (num3 != null) {
                            return new Pair<>(num2, num3);
                        }
                        String strValueOf3 = String.valueOf(str3);
                        Log.w("MediaCodecUtil", strValueOf3.length() != 0 ? "Unknown Dolby Vision level string: ".concat(strValueOf3) : new String("Unknown Dolby Vision level string: "));
                    }
                } else {
                    String strValueOf4 = String.valueOf(str2);
                    Log.w("MediaCodecUtil", strValueOf4.length() != 0 ? "Ignoring malformed Dolby Vision codec string: ".concat(strValueOf4) : new String("Ignoring malformed Dolby Vision codec string: "));
                }
            }
            return null;
        }
        String str4 = strArrSplit[0];
        str4.hashCode();
        switch (str4) {
            case "av01":
                String str5 = format2.t;
                ColorInfo colorInfo = format2.I;
                if (strArrSplit.length < 4) {
                    String strValueOf5 = String.valueOf(str5);
                    Log.w("MediaCodecUtil", strValueOf5.length() != 0 ? "Ignoring malformed AV1 codec string: ".concat(strValueOf5) : new String("Ignoring malformed AV1 codec string: "));
                    return null;
                }
                try {
                    int i15 = Integer.parseInt(strArrSplit[1]);
                    int i16 = Integer.parseInt(strArrSplit[2].substring(0, 2));
                    int i17 = Integer.parseInt(strArrSplit[3]);
                    if (i15 != 0) {
                        outline.g0(32, "Unknown AV1 profile: ", i15, "MediaCodecUtil");
                    } else {
                        int i18 = 8;
                        if (i17 == 8) {
                            if (i17 == i18) {
                                i = 1;
                            } else if (colorInfo == null && (colorInfo.n != null || (i2 = colorInfo.m) == 7 || i2 == 6)) {
                                i = 4096;
                            } else {
                                i = 2;
                            }
                            switch (i16) {
                                case 0:
                                    i3 = 1;
                                    break;
                                case 1:
                                    i3 = 2;
                                    break;
                                case 2:
                                    i3 = 4;
                                    break;
                                case 3:
                                    i3 = 8;
                                    break;
                                case 4:
                                    i3 = 16;
                                    break;
                                case 5:
                                    i3 = 32;
                                    break;
                                case 6:
                                    i3 = 64;
                                    break;
                                case 7:
                                    i3 = 128;
                                    break;
                                case 8:
                                    i3 = 256;
                                    break;
                                case 9:
                                    i3 = 512;
                                    break;
                                case 10:
                                    i3 = 1024;
                                    break;
                                case 11:
                                    i3 = 2048;
                                    break;
                                case 12:
                                    i3 = 4096;
                                    break;
                                case 13:
                                    i3 = 8192;
                                    break;
                                case 14:
                                    i3 = 16384;
                                    break;
                                case 15:
                                    i3 = 32768;
                                    break;
                                case 16:
                                    i3 = 65536;
                                    break;
                                case 17:
                                    i3 = 131072;
                                    break;
                                case 18:
                                    i3 = 262144;
                                    break;
                                case 19:
                                    i3 = 524288;
                                    break;
                                case 20:
                                    i3 = 1048576;
                                    break;
                                case 21:
                                    i3 = 2097152;
                                    break;
                                case 22:
                                    i3 = 4194304;
                                    break;
                                case 23:
                                    i3 = 8388608;
                                    break;
                                default:
                                    i3 = -1;
                                    break;
                            }
                            if (i3 == -1) {
                                return new Pair<>(Integer.valueOf(i), Integer.valueOf(i3));
                            }
                            outline.g0(30, "Unknown AV1 level: ", i16, "MediaCodecUtil");
                        } else if (i17 != 10) {
                            outline.g0(34, "Unknown AV1 bit depth: ", i17, "MediaCodecUtil");
                        } else {
                            i18 = 8;
                            if (i17 == i18) {
                                i = 1;
                            } else if (colorInfo == null) {
                                i = 2;
                            } else {
                                i = 2;
                            }
                            switch (i16) {
                                case 0:
                                    i3 = 1;
                                    break;
                                case 1:
                                    i3 = 2;
                                    break;
                                case 2:
                                    i3 = 4;
                                    break;
                                case 3:
                                    i3 = 8;
                                    break;
                                case 4:
                                    i3 = 16;
                                    break;
                                case 5:
                                    i3 = 32;
                                    break;
                                case 6:
                                    i3 = 64;
                                    break;
                                case 7:
                                    i3 = 128;
                                    break;
                                case 8:
                                    i3 = 256;
                                    break;
                                case 9:
                                    i3 = 512;
                                    break;
                                case 10:
                                    i3 = 1024;
                                    break;
                                case 11:
                                    i3 = 2048;
                                    break;
                                case 12:
                                    i3 = 4096;
                                    break;
                                case 13:
                                    i3 = 8192;
                                    break;
                                case 14:
                                    i3 = 16384;
                                    break;
                                case 15:
                                    i3 = 32768;
                                    break;
                                case 16:
                                    i3 = 65536;
                                    break;
                                case 17:
                                    i3 = 131072;
                                    break;
                                case 18:
                                    i3 = 262144;
                                    break;
                                case 19:
                                    i3 = 524288;
                                    break;
                                case 20:
                                    i3 = 1048576;
                                    break;
                                case 21:
                                    i3 = 2097152;
                                    break;
                                case 22:
                                    i3 = 4194304;
                                    break;
                                case 23:
                                    i3 = 8388608;
                                    break;
                                default:
                                    i3 = -1;
                                    break;
                            }
                            if (i3 == -1) {
                                return new Pair<>(Integer.valueOf(i), Integer.valueOf(i3));
                            }
                            outline.g0(30, "Unknown AV1 level: ", i16, "MediaCodecUtil");
                        }
                    }
                } catch (NumberFormatException unused) {
                    String strValueOf6 = String.valueOf(str5);
                    Log.w("MediaCodecUtil", strValueOf6.length() != 0 ? "Ignoring malformed AV1 codec string: ".concat(strValueOf6) : new String("Ignoring malformed AV1 codec string: "));
                }
                return null;
            case "avc1":
            case "avc2":
                int i19 = 2048;
                String str6 = format2.t;
                if (strArrSplit.length < 2) {
                    String strValueOf7 = String.valueOf(str6);
                    Log.w("MediaCodecUtil", strValueOf7.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(strValueOf7) : new String("Ignoring malformed AVC codec string: "));
                    return null;
                }
                try {
                    if (strArrSplit[1].length() == 6) {
                        i4 = Integer.parseInt(strArrSplit[1].substring(0, 2), 16);
                        i5 = Integer.parseInt(strArrSplit[1].substring(4), 16);
                    } else {
                        if (strArrSplit.length < 3) {
                            String strValueOf8 = String.valueOf(str6);
                            Log.w("MediaCodecUtil", strValueOf8.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(strValueOf8) : new String("Ignoring malformed AVC codec string: "));
                            return null;
                        }
                        i4 = Integer.parseInt(strArrSplit[1]);
                        i5 = Integer.parseInt(strArrSplit[2]);
                    }
                    if (i4 == 66) {
                        i6 = 1;
                    } else if (i4 == 77) {
                        i6 = 2;
                    } else if (i4 == 88) {
                        i6 = 4;
                    } else if (i4 == 100) {
                        i6 = 8;
                    } else if (i4 == 110) {
                        i6 = 16;
                    } else if (i4 != 122) {
                        i6 = i4 != 244 ? -1 : 64;
                    } else {
                        i6 = 32;
                    }
                    if (i6 == -1) {
                        outline.g0(32, "Unknown AVC profile: ", i4, "MediaCodecUtil");
                        return null;
                    }
                    switch (i5) {
                        case 10:
                            i7 = -1;
                            i8 = 1;
                            break;
                        case 11:
                            i7 = -1;
                            i8 = 4;
                            break;
                        case 12:
                            i7 = -1;
                            i8 = 8;
                            break;
                        case 13:
                            i7 = -1;
                            i8 = 16;
                            break;
                        default:
                            switch (i5) {
                                case 20:
                                    i7 = -1;
                                    i8 = 32;
                                    break;
                                case 21:
                                    i7 = -1;
                                    i8 = 64;
                                    break;
                                case 22:
                                    i7 = -1;
                                    i8 = 128;
                                    break;
                                default:
                                    switch (i5) {
                                        case 30:
                                            i7 = -1;
                                            i8 = 256;
                                            break;
                                        case 31:
                                            i7 = -1;
                                            i8 = 512;
                                            break;
                                        case 32:
                                            i7 = -1;
                                            i8 = 1024;
                                            break;
                                        default:
                                            switch (i5) {
                                                case 40:
                                                    i8 = i19;
                                                    i7 = -1;
                                                    break;
                                                case 41:
                                                    i7 = -1;
                                                    i8 = 4096;
                                                    break;
                                                case 42:
                                                    i19 = 8192;
                                                    i8 = i19;
                                                    i7 = -1;
                                                    break;
                                                default:
                                                    switch (i5) {
                                                        case 50:
                                                            i19 = 16384;
                                                            i8 = i19;
                                                            i7 = -1;
                                                            break;
                                                        case 51:
                                                            i19 = 32768;
                                                            i8 = i19;
                                                            i7 = -1;
                                                            break;
                                                        case 52:
                                                            i19 = 65536;
                                                            i8 = i19;
                                                            i7 = -1;
                                                            break;
                                                        default:
                                                            i7 = -1;
                                                            i8 = -1;
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    if (i8 != i7) {
                        return new Pair<>(Integer.valueOf(i6), Integer.valueOf(i8));
                    }
                    outline.g0(30, "Unknown AVC level: ", i5, "MediaCodecUtil");
                    return null;
                } catch (NumberFormatException unused2) {
                    String strValueOf9 = String.valueOf(str6);
                    Log.w("MediaCodecUtil", strValueOf9.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(strValueOf9) : new String("Ignoring malformed AVC codec string: "));
                    return null;
                }
            case "hev1":
            case "hvc1":
                String str7 = format2.t;
                if (strArrSplit.length < 4) {
                    String strValueOf10 = String.valueOf(str7);
                    Log.w("MediaCodecUtil", strValueOf10.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(strValueOf10) : new String("Ignoring malformed HEVC codec string: "));
                    return null;
                }
                Matcher matcher2 = a.matcher(strArrSplit[1]);
                if (!matcher2.matches()) {
                    String strValueOf11 = String.valueOf(str7);
                    Log.w("MediaCodecUtil", strValueOf11.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(strValueOf11) : new String("Ignoring malformed HEVC codec string: "));
                    return null;
                }
                String strGroup2 = matcher2.group(1);
                if ("1".equals(strGroup2)) {
                    i9 = 1;
                } else {
                    if (!ExifInterface.GPS_MEASUREMENT_2D.equals(strGroup2)) {
                        String strValueOf12 = String.valueOf(strGroup2);
                        Log.w("MediaCodecUtil", strValueOf12.length() != 0 ? "Unknown HEVC profile string: ".concat(strValueOf12) : new String("Unknown HEVC profile string: "));
                        return null;
                    }
                    i9 = 2;
                }
                String str8 = strArrSplit[3];
                if (str8 != null) {
                    switch (str8) {
                        case "H30":
                            num = 2;
                            break;
                        case "H60":
                            num = 8;
                            break;
                        case "H63":
                            num = 32;
                            break;
                        case "H90":
                            num = 128;
                            break;
                        case "H93":
                            num = 512;
                            break;
                        case "L30":
                            num = 1;
                            break;
                        case "L60":
                            num = 4;
                            break;
                        case "L63":
                            num = 16;
                            break;
                        case "L90":
                            num = 64;
                            break;
                        case "L93":
                            num = 256;
                            break;
                        case "H120":
                            num = 2048;
                            break;
                        case "H123":
                            num = 8192;
                            break;
                        case "H150":
                            num = 32768;
                            break;
                        case "H153":
                            num = 131072;
                            break;
                        case "H156":
                            num = 524288;
                            break;
                        case "H180":
                            num = 2097152;
                            break;
                        case "H183":
                            num = 8388608;
                            break;
                        case "H186":
                            num = 33554432;
                            break;
                        case "L120":
                            num = 1024;
                            break;
                        case "L123":
                            num = 4096;
                            break;
                        case "L150":
                            num = 16384;
                            break;
                        case "L153":
                            num = 65536;
                            break;
                        case "L156":
                            num = 262144;
                            break;
                        case "L180":
                            num = 1048576;
                            break;
                        case "L183":
                            num = 4194304;
                            break;
                        case "L186":
                            num = 16777216;
                            break;
                        default:
                            num = null;
                            break;
                    }
                } else {
                    num = null;
                }
                if (num != null) {
                    return new Pair<>(Integer.valueOf(i9), num);
                }
                String strValueOf13 = String.valueOf(str8);
                Log.w("MediaCodecUtil", strValueOf13.length() != 0 ? "Unknown HEVC level string: ".concat(strValueOf13) : new String("Unknown HEVC level string: "));
                return null;
            case "mp4a":
                String str9 = format2.t;
                if (strArrSplit.length != 3) {
                    String strValueOf14 = String.valueOf(str9);
                    Log.w("MediaCodecUtil", strValueOf14.length() != 0 ? "Ignoring malformed MP4A codec string: ".concat(strValueOf14) : new String("Ignoring malformed MP4A codec string: "));
                    return null;
                }
                try {
                    if (!"audio/mp4a-latm".equals(MimeTypes.d(Integer.parseInt(strArrSplit[1], 16)))) {
                        return null;
                    }
                    int i20 = Integer.parseInt(strArrSplit[2]);
                    if (i20 == 17) {
                        i10 = 17;
                    } else if (i20 == 20) {
                        i10 = 20;
                    } else if (i20 == 23) {
                        i10 = 23;
                    } else if (i20 == 29) {
                        i10 = 29;
                    } else {
                        if (i20 != 39) {
                            if (i20 != 42) {
                                switch (i20) {
                                    case 1:
                                        i11 = -1;
                                        i10 = 1;
                                        break;
                                    case 2:
                                        i11 = -1;
                                        i10 = 2;
                                        break;
                                    case 3:
                                        i11 = -1;
                                        i10 = 3;
                                        break;
                                    case 4:
                                        i11 = -1;
                                        i10 = 4;
                                        break;
                                    case 5:
                                        i11 = -1;
                                        i10 = 5;
                                        break;
                                    case 6:
                                        i11 = -1;
                                        i10 = 6;
                                        break;
                                    default:
                                        i11 = -1;
                                        i10 = -1;
                                        break;
                                }
                            } else {
                                i10 = 42;
                            }
                            if (i10 != i11) {
                                return new Pair<>(Integer.valueOf(i10), 0);
                            }
                            return null;
                        }
                        i10 = 39;
                    }
                    i11 = -1;
                    if (i10 != i11) {
                        return new Pair<>(Integer.valueOf(i10), 0);
                    }
                    return null;
                } catch (NumberFormatException unused3) {
                    String strValueOf15 = String.valueOf(str9);
                    Log.w("MediaCodecUtil", strValueOf15.length() != 0 ? "Ignoring malformed MP4A codec string: ".concat(strValueOf15) : new String("Ignoring malformed MP4A codec string: "));
                    return null;
                }
            case "vp09":
                String str10 = format2.t;
                if (strArrSplit.length < 3) {
                    String strValueOf16 = String.valueOf(str10);
                    Log.w("MediaCodecUtil", strValueOf16.length() != 0 ? "Ignoring malformed VP9 codec string: ".concat(strValueOf16) : new String("Ignoring malformed VP9 codec string: "));
                    return null;
                }
                try {
                    int i21 = Integer.parseInt(strArrSplit[1]);
                    int i22 = Integer.parseInt(strArrSplit[2]);
                    if (i21 == 0) {
                        i12 = 1;
                    } else if (i21 == 1) {
                        i12 = 2;
                    } else if (i21 != 2) {
                        i12 = i21 != 3 ? -1 : 8;
                    } else {
                        i12 = 4;
                    }
                    if (i12 == -1) {
                        outline.g0(32, "Unknown VP9 profile: ", i21, "MediaCodecUtil");
                        return null;
                    }
                    if (i22 == 10) {
                        i13 = -1;
                        i14 = 1;
                    } else if (i22 == 11) {
                        i13 = -1;
                        i14 = 2;
                    } else if (i22 == 20) {
                        i13 = -1;
                        i14 = 4;
                    } else if (i22 == 21) {
                        i13 = -1;
                        i14 = 8;
                    } else if (i22 == 30) {
                        i13 = -1;
                        i14 = 16;
                    } else if (i22 == 31) {
                        i13 = -1;
                        i14 = 32;
                    } else if (i22 == 40) {
                        i13 = -1;
                        i14 = 64;
                    } else if (i22 == 41) {
                        i13 = -1;
                        i14 = 128;
                    } else if (i22 == 50) {
                        i13 = -1;
                        i14 = 256;
                    } else if (i22 != 51) {
                        switch (i22) {
                            case 60:
                                i13 = -1;
                                i14 = 2048;
                                break;
                            case 61:
                                i13 = -1;
                                i14 = 4096;
                                break;
                            case 62:
                                i14 = 8192;
                                i13 = -1;
                                break;
                            default:
                                i13 = -1;
                                i14 = -1;
                                break;
                        }
                    } else {
                        i13 = -1;
                        i14 = 512;
                    }
                    if (i14 != i13) {
                        return new Pair<>(Integer.valueOf(i12), Integer.valueOf(i14));
                    }
                    outline.g0(30, "Unknown VP9 level: ", i22, "MediaCodecUtil");
                    return null;
                } catch (NumberFormatException unused4) {
                    String strValueOf17 = String.valueOf(str10);
                    Log.w("MediaCodecUtil", strValueOf17.length() != 0 ? "Ignoring malformed VP9 codec string: ".concat(strValueOf17) : new String("Ignoring malformed VP9 codec string: "));
                    return null;
                }
            default:
                return null;
        }
    }

    @Nullable
    public static b.i.a.c.y2.MediaCodecInfo d(String str, boolean z2, boolean z3) throws DecoderQueryException {
        List<b.i.a.c.y2.MediaCodecInfo> listE = e(str, z2, z3);
        if (listE.isEmpty()) {
            return null;
        }
        return listE.get(0);
    }

    public static synchronized List<b.i.a.c.y2.MediaCodecInfo> e(String str, boolean z2, boolean z3) throws DecoderQueryException {
        b bVar = new b(str, z2, z3);
        HashMap<b, List<b.i.a.c.y2.MediaCodecInfo>> map = f2947b;
        List<b.i.a.c.y2.MediaCodecInfo> list = map.get(bVar);
        if (list != null) {
            return list;
        }
        int i = Util2.a;
        ArrayList<b.i.a.c.y2.MediaCodecInfo> arrayListF = f(bVar, i >= 21 ? new e(z2, z3) : new d(null));
        if (z2 && arrayListF.isEmpty() && 21 <= i && i <= 23) {
            arrayListF = f(bVar, new d(null));
            if (!arrayListF.isEmpty()) {
                String str2 = arrayListF.get(0).a;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                sb.append("MediaCodecList API didn't list secure decoder for: ");
                sb.append(str);
                sb.append(". Assuming: ");
                sb.append(str2);
                Log.w("MediaCodecUtil", sb.toString());
            }
        }
        a(str, arrayListF);
        List<b.i.a.c.y2.MediaCodecInfo> listUnmodifiableList = Collections.unmodifiableList(arrayListF);
        map.put(bVar, listUnmodifiableList);
        return listUnmodifiableList;
    }

    public static ArrayList<b.i.a.c.y2.MediaCodecInfo> f(b bVar, c cVar) throws DecoderQueryException {
        String strB;
        String str;
        String str2;
        int i;
        boolean z2;
        int i2;
        boolean z3;
        boolean zIsHardwareAccelerated;
        boolean zIsVendor;
        try {
            ArrayList<b.i.a.c.y2.MediaCodecInfo> arrayList = new ArrayList<>();
            String str3 = bVar.a;
            int iD = cVar.d();
            boolean zE = cVar.e();
            int i3 = 0;
            while (i3 < iD) {
                android.media.MediaCodecInfo mediaCodecInfoA = cVar.a(i3);
                int i4 = Util2.a;
                if (!(i4 >= 29 && mediaCodecInfoA.isAlias())) {
                    String name = mediaCodecInfoA.getName();
                    if (g(mediaCodecInfoA, name, zE, str3) && (strB = b(mediaCodecInfoA, name, str3)) != null) {
                        try {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoA.getCapabilitiesForType(strB);
                            boolean zB = cVar.b("tunneled-playback", strB, capabilitiesForType);
                            boolean zC = cVar.c("tunneled-playback", strB, capabilitiesForType);
                            boolean z4 = bVar.c;
                            if ((z4 || !zC) && (!z4 || zB)) {
                                boolean zB2 = cVar.b("secure-playback", strB, capabilitiesForType);
                                boolean zC2 = cVar.c("secure-playback", strB, capabilitiesForType);
                                boolean z5 = bVar.f2948b;
                                if ((z5 || !zC2) && (!z5 || zB2)) {
                                    if (i4 >= 29) {
                                        zIsHardwareAccelerated = mediaCodecInfoA.isHardwareAccelerated();
                                        z3 = true;
                                    } else {
                                        z3 = true;
                                        zIsHardwareAccelerated = !h(mediaCodecInfoA);
                                    }
                                    boolean zH = h(mediaCodecInfoA);
                                    if (i4 >= 29) {
                                        zIsVendor = mediaCodecInfoA.isVendor();
                                    } else {
                                        String strU1 = b.i.a.f.e.o.f.u1(mediaCodecInfoA.getName());
                                        if (strU1.startsWith("omx.google.") || strU1.startsWith("c2.android.") || strU1.startsWith("c2.google.")) {
                                            z3 = false;
                                        }
                                        zIsVendor = z3;
                                    }
                                    if (!(zE && bVar.f2948b == zB2) && (zE || bVar.f2948b)) {
                                        str = strB;
                                        str2 = name;
                                        i = i3;
                                        z2 = zE;
                                        i2 = iD;
                                        if (!z2 && zB2) {
                                            arrayList.add(b.i.a.c.y2.MediaCodecInfo.i(String.valueOf(str2).concat(".secure"), str3, str, capabilitiesForType, zIsHardwareAccelerated, zH, zIsVendor, false, true));
                                            return arrayList;
                                        }
                                    } else {
                                        str = strB;
                                        str2 = name;
                                        i = i3;
                                        z2 = zE;
                                        i2 = iD;
                                        try {
                                            arrayList.add(b.i.a.c.y2.MediaCodecInfo.i(name, str3, strB, capabilitiesForType, zIsHardwareAccelerated, zH, zIsVendor, false, false));
                                        } catch (Exception e2) {
                                            e = e2;
                                            if (Util2.a > 23 || arrayList.isEmpty()) {
                                                String str4 = str2;
                                                StringBuilder sb = new StringBuilder(String.valueOf(str4).length() + 25 + str.length());
                                                sb.append("Failed to query codec ");
                                                sb.append(str4);
                                                sb.append(" (");
                                                sb.append(str);
                                                sb.append(")");
                                                Log.e("MediaCodecUtil", sb.toString());
                                                throw e;
                                            }
                                            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 46);
                                            sb2.append("Skipping codec ");
                                            sb2.append(str2);
                                            sb2.append(" (failed to query capabilities)");
                                            Log.e("MediaCodecUtil", sb2.toString());
                                        }
                                    }
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str = strB;
                            str2 = name;
                            i = i3;
                            z2 = zE;
                            i2 = iD;
                        }
                    }
                    i3 = i + 1;
                    iD = i2;
                    zE = z2;
                }
                i = i3;
                z2 = zE;
                i2 = iD;
                i3 = i + 1;
                iD = i2;
                zE = z2;
            }
            return arrayList;
        } catch (Exception e4) {
            throw new DecoderQueryException(e4, null);
        }
    }

    public static boolean g(android.media.MediaCodecInfo mediaCodecInfo, String str, boolean z2, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z2 && str.endsWith(".secure"))) {
            return false;
        }
        int i = Util2.a;
        if (i < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = Util2.f968b;
            if ("a70".equals(str3) || ("Xiaomi".equals(Util2.c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = Util2.f968b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = Util2.f968b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(Util2.c))) {
            String str6 = Util2.f968b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(Util2.c)) {
            String str7 = Util2.f968b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i <= 19 && Util2.f968b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return ("audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    public static boolean h(android.media.MediaCodecInfo mediaCodecInfo) {
        if (Util2.a >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        String strU1 = b.i.a.f.e.o.f.u1(mediaCodecInfo.getName());
        if (strU1.startsWith("arc.")) {
            return false;
        }
        return strU1.startsWith("omx.google.") || strU1.startsWith("omx.ffmpeg.") || (strU1.startsWith("omx.sec.") && strU1.contains(".sw.")) || strU1.equals("omx.qcom.video.decoder.hevcswvdec") || strU1.startsWith("c2.android.") || strU1.startsWith("c2.google.") || !(strU1.startsWith("omx.") || strU1.startsWith("c2."));
    }

    public static int i() throws DecoderQueryException {
        int i;
        if (c == -1) {
            int iMax = 0;
            b.i.a.c.y2.MediaCodecInfo mediaCodecInfoD = d("video/avc", false, false);
            if (mediaCodecInfoD != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrD = mediaCodecInfoD.d();
                int length = codecProfileLevelArrD.length;
                int iMax2 = 0;
                while (iMax < length) {
                    int i2 = codecProfileLevelArrD[iMax].level;
                    if (i2 != 1 && i2 != 2) {
                        switch (i2) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case 16384:
                                i = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                break;
                            case 131072:
                            case 262144:
                            case 524288:
                                i = 35651584;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    iMax2 = Math.max(i, iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, Util2.a >= 21 ? 345600 : 172800);
            }
            c = iMax;
        }
        return c;
    }

    public static <T> void j(List<T> list, final f<T> fVar) {
        Collections.sort(list, new Comparator() { // from class: b.i.a.c.y2.h
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                MediaCodecUtil.f fVar2 = fVar;
                return fVar2.a(obj2) - fVar2.a(obj);
            }
        });
    }
}
