package co.discord.media_engine;

import b.d.b.a.outline;
import java.util.Map;

/* JADX INFO: renamed from: co.discord.media_engine.VoiceQualityKt, reason: use source file name */
/* JADX INFO: compiled from: VoiceQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceQuality7 {
    private static final double _calculateMos(double d, double d2) {
        double d_calculateR = _calculateR(d, d2);
        if (d_calculateR < 0) {
            return 1.0d;
        }
        double d3 = 100;
        if (d_calculateR > d3) {
            return 4.5d;
        }
        return ((d3 - d_calculateR) * (d_calculateR - ((double) 60)) * 7.1E-6d * d_calculateR) + (0.035d * d_calculateR) + ((double) 1);
    }

    private static final double _calculateR(double d, double d2) {
        double d3 = (0.024d * d) + (d > 177.3d ? (d - 177.3d) * 0.11d : 0.0d);
        double d4 = 10;
        return (93.4d - d3) - (((((double) 122) * d2) / (d2 + d4)) + d4);
    }

    private static final double clamp(double d, double d2, double d3) {
        if (d < d2) {
            return d2;
        }
        return d3 < d ? d3 : d;
    }

    private static final void explodePlayoutMetric(String str, PlayoutMetric playoutMetric, Map<String, Object> map) {
        Object obj = 0;
        map.put(outline.w(str, "_mean"), playoutMetric != null ? Double.valueOf(playoutMetric.getMean()) : obj);
        map.put(str + "_p75", playoutMetric != null ? Double.valueOf(playoutMetric.getP75()) : obj);
        map.put(str + "_p95", playoutMetric != null ? Double.valueOf(playoutMetric.getP95()) : obj);
        map.put(str + "_p99", playoutMetric != null ? Double.valueOf(playoutMetric.getP99()) : obj);
        map.put(str + "_max", playoutMetric != null ? Double.valueOf(playoutMetric.getMax()) : 0);
    }
}
