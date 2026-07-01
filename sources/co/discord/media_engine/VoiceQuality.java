package co.discord.media_engine;

import d0.z.d.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: VoiceQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceQuality {
    private Map<String, InboundAudio> _inboundStats = new LinkedHashMap();
    private OutboundAudio _outboundStats = new OutboundAudio(0, 0);
    private Duration _duration = new Duration(0, 0, 0, 0);

    public final void getBufferStats(Map<String, Object> result) {
        PlayoutMetric audioJitterBuffer;
        m.checkNotNullParameter(result, "result");
        Iterator<Map$Entry<String, InboundAudio>> it = this._inboundStats.entrySet().iterator();
        InboundBufferStats bufferStats = null;
        while (it.hasNext()) {
            InboundAudio value = it.next().getValue();
            if (bufferStats == null) {
                bufferStats = value.getBufferStats();
            } else {
                PlayoutMetric audioJitterBuffer2 = bufferStats.getAudioJitterBuffer();
                if (audioJitterBuffer2 != null && (audioJitterBuffer = value.getBufferStats().getAudioJitterBuffer()) != null && audioJitterBuffer.getP75() > audioJitterBuffer2.getP75()) {
                    bufferStats = value.getBufferStats();
                }
            }
        }
        VoiceQualityKt.access$explodePlayoutMetric("audio_jitter_buffer", bufferStats != null ? bufferStats.getAudioJitterBuffer() : null, result);
        VoiceQualityKt.access$explodePlayoutMetric("audio_jitter_target", bufferStats != null ? bufferStats.getAudioJitterTarget() : null, result);
        VoiceQualityKt.access$explodePlayoutMetric("audio_jitter_delay", bufferStats != null ? bufferStats.getAudioJitterDelay() : null, result);
        VoiceQualityKt.access$explodePlayoutMetric("relative_reception_delay", bufferStats != null ? bufferStats.getRelativeReceptionDelay() : null, result);
        VoiceQualityKt.access$explodePlayoutMetric("relative_playout_delay", bufferStats != null ? bufferStats.getRelativePlayoutDelay() : null, result);
    }

    public final void getDurationStats(Map<String, Object> result) {
        m.checkNotNullParameter(result, "result");
        result.put("duration_listening", Integer.valueOf(this._duration.getListening()));
        result.put("duration_speaking", Integer.valueOf(this._duration.getSpeaking()));
        result.put("duration_participation", Integer.valueOf(this._duration.getParticipation()));
        result.put("duration_connected", Integer.valueOf(this._duration.getConnected()));
    }

    public final void getFrameOpStats(Map<String, Object> result) {
        m.checkNotNullParameter(result, "result");
        Iterator<Map$Entry<String, InboundAudio>> it = this._inboundStats.entrySet().iterator();
        Long lValueOf = null;
        Long lValueOf2 = null;
        Long lValueOf3 = null;
        Long lValueOf4 = null;
        Long lValueOf5 = null;
        Long lValueOf6 = null;
        Long lValueOf7 = null;
        while (it.hasNext()) {
            InboundAudio value = it.next().getValue();
            Long silent = value.getFrameOpStats().getSilent();
            if (silent != null) {
                lValueOf = Long.valueOf((lValueOf != null ? lValueOf.longValue() : 0L) + silent.longValue());
            }
            Long normal = value.getFrameOpStats().getNormal();
            if (normal != null) {
                lValueOf2 = Long.valueOf((lValueOf2 != null ? lValueOf2.longValue() : 0L) + normal.longValue());
            }
            Long merged = value.getFrameOpStats().getMerged();
            if (merged != null) {
                lValueOf3 = Long.valueOf((lValueOf3 != null ? lValueOf3.longValue() : 0L) + merged.longValue());
            }
            Long expanded = value.getFrameOpStats().getExpanded();
            if (expanded != null) {
                lValueOf4 = Long.valueOf((lValueOf4 != null ? lValueOf4.longValue() : 0L) + expanded.longValue());
            }
            Long accelerated = value.getFrameOpStats().getAccelerated();
            if (accelerated != null) {
                lValueOf5 = Long.valueOf((lValueOf5 != null ? lValueOf5.longValue() : 0L) + accelerated.longValue());
            }
            Long preemptiveExpanded = value.getFrameOpStats().getPreemptiveExpanded();
            if (preemptiveExpanded != null) {
                lValueOf6 = Long.valueOf((lValueOf6 != null ? lValueOf6.longValue() : 0L) + preemptiveExpanded.longValue());
            }
            Long cng = value.getFrameOpStats().getCng();
            if (cng != null) {
                lValueOf7 = Long.valueOf((lValueOf7 != null ? lValueOf7.longValue() : 0L) + cng.longValue());
            }
        }
        if (lValueOf != null) {
            result.put("frame_op_silent", Long.valueOf(lValueOf.longValue()));
        }
        if (lValueOf2 != null) {
            result.put("frame_op_normal", Long.valueOf(lValueOf2.longValue()));
        }
        if (lValueOf3 != null) {
            result.put("frame_op_merged", Long.valueOf(lValueOf3.longValue()));
        }
        if (lValueOf4 != null) {
            result.put("frame_op_expanded", Long.valueOf(lValueOf4.longValue()));
        }
        if (lValueOf5 != null) {
            result.put("frame_op_accelerated", Long.valueOf(lValueOf5.longValue()));
        }
        if (lValueOf6 != null) {
            result.put("frame_op_preemptive_expanded", Long.valueOf(lValueOf6.longValue()));
        }
        if (lValueOf7 != null) {
            result.put("frame_op_cng", Long.valueOf(lValueOf7.longValue()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void getMosStats(Map<String, Object> result) {
        m.checkNotNullParameter(result, "result");
        Integer[] numArr = new Integer[5];
        Object obj = 0;
        numArr[0] = obj;
        numArr[1] = obj;
        numArr[2] = obj;
        numArr[3] = obj;
        numArr[4] = obj;
        Iterator<Map$Entry<String, InboundAudio>> it = this._inboundStats.entrySet().iterator();
        double mosSum = 0.0d;
        int mosCount = 0;
        while (it.hasNext()) {
            InboundAudio value = it.next().getValue();
            mosSum += value.getMosSum();
            mosCount += value.getMosCount();
            for (int i = 0; i <= 4; i++) {
                numArr[i] = Integer.valueOf(value.getMosBuckets()[i].intValue() + numArr[i].intValue());
            }
        }
        result.put("mos_mean", mosCount > 0 ? Double.valueOf(mosSum / ((double) mosCount)) : 0);
        result.put("mos_1", numArr[1]);
        result.put("mos_2", numArr[2]);
        result.put("mos_3", numArr[3]);
        result.put("mos_4", numArr[4]);
    }

    public final void getPacketStats(Map<String, Object> result) {
        m.checkNotNullParameter(result, "result");
        Iterator<Map$Entry<String, InboundAudio>> it = this._inboundStats.entrySet().iterator();
        long packetsReceived = 0;
        long packetsLost = 0;
        while (it.hasNext()) {
            InboundAudio value = it.next().getValue();
            packetsReceived += value.getPacketsReceived();
            packetsLost += value.getPacketsLost();
        }
        result.put("packets_sent", Long.valueOf(this._outboundStats.getPacketsSent()));
        result.put("packets_sent_lost", Integer.valueOf(this._outboundStats.getPacketsLost()));
        result.put("packets_received", Long.valueOf(packetsReceived));
        result.put("packets_received_lost", Long.valueOf(packetsLost));
    }

    public final void update(Stats stats) {
        boolean z2;
        int i;
        boolean z3;
        long j;
        InboundAudio inboundAudio;
        double d;
        m.checkNotNullParameter(stats, "stats");
        Duration duration = this._duration;
        duration.setConnected(duration.getConnected() + 1);
        long packetsSent = this._outboundStats.getPacketsSent();
        Iterator<Map$Entry<String, InboundAudio>> it = this._inboundStats.entrySet().iterator();
        long j2 = 0;
        long packetsReceived = 0;
        while (it.hasNext()) {
            packetsReceived += it.next().getValue().getPacketsReceived();
        }
        OutboundRtpAudio outboundRtpAudio = stats.getOutboundRtpAudio();
        this._outboundStats = outboundRtpAudio != null ? new OutboundAudio(outboundRtpAudio.getPacketsSent(), outboundRtpAudio.getPacketsLost()) : new OutboundAudio(0L, 0);
        Iterator<Map$Entry<String, InboundRtpAudio>> it2 = stats.getInboundRtpAudio().entrySet().iterator();
        while (it2.hasNext()) {
            Map$Entry<String, InboundRtpAudio> next = it2.next();
            String key = next.getKey();
            InboundRtpAudio value = next.getValue();
            Transport transport = stats.getTransport();
            int ping = transport != null ? transport.getPing() : 0;
            long packetsReceived2 = value.getPacketsReceived();
            long packetsLost = value.getPacketsLost();
            int jitterBuffer = (int) value.getJitterBuffer();
            InboundBufferStats inboundBufferStats = new InboundBufferStats(value.getAudioJitterBuffer(), value.getAudioJitterTarget(), value.getAudioJitterDelay(), value.getRelativeReceptionDelay(), value.getRelativePlayoutDelay());
            InboundFrameOpStats inboundFrameOpStats = new InboundFrameOpStats(value.getOpSilence(), value.getOpNormal(), value.getOpMerge(), value.getOpExpand(), value.getOpAccelerate(), value.getOpPreemptiveExpand(), value.getOpCNG());
            Map<String, InboundAudio> map = this._inboundStats;
            InboundAudio inboundAudio2 = map.get(key);
            if (inboundAudio2 != null) {
                long packetsReceived3 = packetsReceived2 - inboundAudio2.getPacketsReceived();
                long packetsLost2 = packetsLost - inboundAudio2.getPacketsLost();
                Integer[] mosBuckets = inboundAudio2.getMosBuckets();
                j = 0;
                if (packetsReceived3 <= 0 || packetsLost2 < 0) {
                    d = 0.0d;
                } else {
                    double dAccess$_calculateMos = VoiceQualityKt.access$_calculateMos(ping + jitterBuffer, VoiceQualityKt.access$clamp(packetsLost2 / (packetsReceived3 + packetsLost2), 0.0d, 1.0d));
                    int iFloor = (int) Math.floor(dAccess$_calculateMos);
                    mosBuckets[iFloor] = Integer.valueOf(mosBuckets[iFloor].intValue() + 1);
                    d = dAccess$_calculateMos;
                }
                inboundAudio = new InboundAudio(packetsReceived2, packetsLost, d, inboundAudio2.getMosSum() + d, inboundAudio2.getMosCount() + (d > ((double) 0) ? 1 : 0), mosBuckets, inboundBufferStats, inboundFrameOpStats);
            } else {
                it2 = it2;
                j = j2;
                inboundAudio = new InboundAudio(packetsReceived2, packetsLost, 0.0d, 0.0d, 0, new Integer[]{0, 0, 0, 0, 0}, inboundBufferStats, inboundFrameOpStats);
            }
            map.put(key, inboundAudio);
            it2 = it2;
            j2 = j;
        }
        long j3 = j2;
        if (this._outboundStats.getPacketsSent() > packetsSent) {
            Duration duration2 = this._duration;
            duration2.setSpeaking(duration2.getSpeaking() + 1);
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator<Map$Entry<String, InboundAudio>> it3 = this._inboundStats.entrySet().iterator();
        long packetsReceived4 = j3;
        while (it3.hasNext()) {
            packetsReceived4 += it3.next().getValue().getPacketsReceived();
        }
        if (packetsReceived4 > packetsReceived) {
            Duration duration3 = this._duration;
            i = 1;
            duration3.setListening(duration3.getListening() + 1);
            z3 = true;
        } else {
            i = 1;
            z3 = false;
        }
        if (z2 || z3) {
            Duration duration4 = this._duration;
            duration4.setParticipation(duration4.getParticipation() + i);
        }
    }
}
