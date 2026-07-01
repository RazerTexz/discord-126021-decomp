package com.discord.utilities.voice;

import android.content.Context;
import android.os.Build$VERSION;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import b.a.k.b;
import com.discord.rtcconnection.RtcConnection$Quality;
import com.discord.rtcconnection.RtcConnection$State;
import com.discord.rtcconnection.RtcConnection$State$a;
import com.discord.rtcconnection.RtcConnection$State$b;
import com.discord.rtcconnection.RtcConnection$State$c;
import com.discord.rtcconnection.RtcConnection$State$d;
import com.discord.rtcconnection.RtcConnection$State$e;
import com.discord.rtcconnection.RtcConnection$State$f;
import com.discord.rtcconnection.RtcConnection$State$g;
import com.discord.rtcconnection.RtcConnection$State$h;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.streams.StreamContext;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: VoiceViewUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceViewUtils {
    public static final VoiceViewUtils INSTANCE = new VoiceViewUtils();

    private VoiceViewUtils() {
    }

    public static /* synthetic */ CharSequence getConnectedText$default(VoiceViewUtils voiceViewUtils, Context context, RtcConnection$State rtcConnection$State, StreamContext streamContext, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = false;
        }
        return voiceViewUtils.getConnectedText(context, rtcConnection$State, streamContext, z2);
    }

    public final int getCallIndicatorIcon(boolean hasVideo, StreamContext streamContext) {
        if (streamContext == null || !streamContext.isCurrentUserParticipating()) {
            return hasVideo ? 2131232247 : 2131231593;
        }
        return streamContext.isSelfStream() ? 2131231591 : 2131231592;
    }

    public final CharSequence getConnectedText(Context context, RtcConnection$State rtcConnectionState, StreamContext streamContext, boolean hasVideo) {
        int i;
        m.checkNotNullParameter(context, "context");
        RtcConnection$State$f rtcConnection$State$f = RtcConnection$State$f.a;
        if (rtcConnectionState == rtcConnection$State$f && streamContext != null && streamContext.isCurrentUserParticipating()) {
            if (streamContext.isSelfStream()) {
                return b.h(context, 2131887868, new Object[0], null, 4);
            }
            Object[] objArr = new Object[1];
            String userNickname = streamContext.getUserNickname();
            if (userNickname == null) {
                userNickname = streamContext.getUser().getUsername();
            }
            objArr[0] = userNickname;
            return b.h(context, 2131887867, objArr, null, 4);
        }
        if (m.areEqual(rtcConnectionState, RtcConnection$State$c.a)) {
            i = 2131887861;
        } else if (m.areEqual(rtcConnectionState, RtcConnection$State$e.a)) {
            i = 2131887864;
        } else if (m.areEqual(rtcConnectionState, RtcConnection$State$b.a)) {
            i = 2131887860;
        } else if (m.areEqual(rtcConnectionState, RtcConnection$State$a.a)) {
            i = 2131887859;
        } else if (m.areEqual(rtcConnectionState, RtcConnection$State$g.a)) {
            i = 2131887865;
        } else if (m.areEqual(rtcConnectionState, rtcConnection$State$f)) {
            i = hasVideo ? 2131887869 : 2131887870;
        } else {
            if (!(rtcConnectionState instanceof RtcConnection$State$d) && !m.areEqual(rtcConnectionState, RtcConnection$State$h.a) && rtcConnectionState != null) {
                throw new NoWhenBranchMatchedException();
            }
            i = 2131887862;
        }
        String string = context.getString(i);
        m.checkNotNullExpressionValue(string, "context.getString(resId)");
        return string;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        if (r5 != 3) goto L15;
     */
    @ColorInt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getConnectionStatusColor(RtcConnection$State connectionState, RtcConnection$Quality connectionQuality, Context context) {
        m.checkNotNullParameter(context, "context");
        if (!m.areEqual(connectionState, RtcConnection$State$f.a)) {
            if (m.areEqual(connectionState, RtcConnection$State$b.a) || m.areEqual(connectionState, RtcConnection$State$c.a) || m.areEqual(connectionState, RtcConnection$State$a.a) || m.areEqual(connectionState, RtcConnection$State$g.a)) {
                return ColorCompat.getColor(context, 2131100410);
            }
            if (m.areEqual(connectionState, RtcConnection$State$e.a)) {
                return ColorCompat.getColor(context, 2131100382);
            }
            return ((connectionState instanceof RtcConnection$State$d) || m.areEqual(connectionState, RtcConnection$State$h.a)) ? ColorCompat.getColor(context, 2131100382) : ColorCompat.getColor(context, 2131100382);
        }
        if (connectionQuality != null) {
            int iOrdinal = connectionQuality.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    return ColorCompat.getColor(context, 2131100382);
                }
                if (iOrdinal == 2) {
                    return ColorCompat.getColor(context, 2131100410);
                }
            }
            return ColorCompat.getColor(context, 2131100304);
        }
        return ColorCompat.getColor(context, 2131100304);
    }

    public final boolean getIsSoundshareSupported() {
        return Build$VERSION.SDK_INT >= 29;
    }

    @DrawableRes
    public final int getQualityIndicator(RtcConnection$Quality connectionQuality) {
        int iOrdinal;
        if (connectionQuality == null || (iOrdinal = connectionQuality.ordinal()) == 0) {
            return 2131232258;
        }
        if (iOrdinal == 1) {
            return 2131232256;
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? 2131232258 : 2131232257;
        }
        return 2131232255;
    }
}
